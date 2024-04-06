package com.hustlers20.frauddetection.service;

import com.hustlers20.frauddetection.dto.FraudDetectionResponseDTO;
import com.hustlers20.frauddetection.dto.TransactionPayloadDTO;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    public TransactionService() {
    }

    public FraudDetectionResponseDTO detectFraud(List<TransactionPayloadDTO> transactionPayloadDTOList) {
        FraudDetectionResponseDTO fraudDetectionResponseDTO = new FraudDetectionResponseDTO();
        List<String> ruleViolated = new ArrayList();
        if (this.isRule001Violated(transactionPayloadDTOList)) {
            ruleViolated.add("RULE-001");
            fraudDetectionResponseDTO.setStatus("ALERT");
        } else {
            fraudDetectionResponseDTO.setTimestamp("OK");
        }

        fraudDetectionResponseDTO.setRuleViolated(ruleViolated);
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000L);
        fraudDetectionResponseDTO.setTimestamp(timestamp);
        return fraudDetectionResponseDTO;
    }

    private boolean isRule001Violated(List<TransactionPayloadDTO> transactionPayloadDTOList) {
        double cummulativeAmount = 0.0;
        int length = transactionPayloadDTOList.size();
        TransactionPayloadDTO lastTransaction = (TransactionPayloadDTO)transactionPayloadDTOList.get(length - 1);
        double cardBalance = 0.0;
        Iterator var8 = transactionPayloadDTOList.iterator();

        while(var8.hasNext()) {
            TransactionPayloadDTO transactionPayloadDTO = (TransactionPayloadDTO)var8.next();
            if (this.isWithIn12Hrs(transactionPayloadDTO.getDateTimeTransaction())) {
                double transactionAmount = Double.parseDouble(transactionPayloadDTO.getTransactionAmount());
                cummulativeAmount += transactionAmount;
            }
        }

        if (this.isWithIn12Hrs(lastTransaction.getDateTimeTransaction())) {
            cardBalance = Double.parseDouble(lastTransaction.getCardBalance());
            double get70PercentOfBalance = cardBalance * 0.7;
            if (cardBalance <= 300000.0 && cummulativeAmount <= get70PercentOfBalance && cardBalance != 0.0 && cummulativeAmount != 0.0) {
                return false;
            }
        }

        return true;
    }

    private boolean isWithIn12Hrs(String dateTimeTransaction) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss", Locale.ENGLISH);
        LocalDateTime transactionTime = LocalDateTime.parse(dateTimeTransaction + LocalDateTime.now().getYear(), dateTimeFormatter);
        LocalDateTime now = LocalDateTime.now();
        long hoursDifference = Duration.between(transactionTime, now).toHours();
        return hoursDifference <= 12L;
    }
}
