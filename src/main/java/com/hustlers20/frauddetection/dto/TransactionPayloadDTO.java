package com.hustlers20.frauddetection.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionPayloadDTO {
    private String mti;
    private String processingCode;
    private String transactionAmount;
    private String dateTimeTransaction;
    private String cardholderBillingConversionRate;
    private String stan;
    private String timeLocalTransaction;
    private String dateLocalTransaction;
    private String expiryDate;
    private String conversionDate;
    private String merchantCategoryCode;
    private String posEntryMode;
    private String acquiringInstitutionCode;
    private String forwardingInstitutionCode;
    private String rrn;
    private String cardAcceptorTerminalId;
    private String cardAcceptorId;
    private String cardAcceptorNameLocation;
    private String cardBalance;
    private String additionalData48;
    private String transactionCurrencyCode;
    private String cardholderBillingCurrencyCode;
    private String posDataCode;
    private String originalDataElement;
    private String channel;
    private String encryptedPan;
    private String network;
    private boolean dcc;
    private String kitNo;
    private int factorOfAuthorization;
    private int authenticationScore;
    private boolean contactless;
    private boolean international;
    private boolean preValidated;
    private boolean enhancedLimitWhiteListing;
    private String transactionOrigin;
    private String transactionType;
    private boolean isExternalAuth;
    private String encryptedHexCardNo;
    private boolean isTokenized;
    private String entityId;
    private boolean moneySendTxn;
    private boolean mcRefundTxn;
    private boolean mpqrtxn;
    private boolean authorisationStatus;
    private String latitude;
    private String longitude;
}
