package com.example.cardholder.dto;

public class CardRequest {
    private String cardholderName;
    private String pan;

    public String getCardholderName() { return cardholderName; }
    public void setCardholderName(String cardholderName) { this.cardholderName = cardholderName; }
    public String getPan() { return pan; }
    public void setPan(String pan) { this.pan = pan; }
}
