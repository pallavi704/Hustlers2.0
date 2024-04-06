package com.hustlers20.frauddetection.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FraudDetectionResponseDTO {
    private String status;
    private List<String> ruleViolated;
    private String timestamp;
}
