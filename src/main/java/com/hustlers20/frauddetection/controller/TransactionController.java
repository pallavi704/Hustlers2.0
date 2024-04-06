package com.hustlers20.frauddetection.controller;

import com.hustlers20.frauddetection.dto.FraudDetectionResponseDTO;
import com.hustlers20.frauddetection.dto.TransactionPayloadDTO;
import com.hustlers20.frauddetection.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/bureau"})
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    public TransactionController() {
    }

    @GetMapping({"/transaction/fraud-detection"})
    public ResponseEntity<FraudDetectionResponseDTO> detectFraud(@RequestBody List<TransactionPayloadDTO> transactionList) {
        FraudDetectionResponseDTO response = this.transactionService.detectFraud(transactionList);
        return new ResponseEntity(response, HttpStatus.OK);
    }

//    @PostMapping({"/member"})
//    public String signup(@RequestBody Login login) {
//        return "login Success";
//    }
}

