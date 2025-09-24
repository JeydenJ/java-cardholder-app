package com.example.cardholder.dto;

import java.time.LocalDateTime;

public class CardResponse {
    private String cardholderName;
    private String maskedPan;
    private LocalDateTime createdTime;

    public CardResponse(String cardholderName, String maskedPan, LocalDateTime createdTime) {
        this.cardholderName = cardholderName;
        this.maskedPan = maskedPan;
        this.createdTime = createdTime;
    }

    public String getCardholderName() { return cardholderName; }
    public String getMaskedPan() { return maskedPan; }
    public LocalDateTime getCreatedTime() { return createdTime; }
}
