package com.example.cardholder.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardholderName;

    private String encryptedPan; // store encrypted card number

    private String last4;        // store last 4 digits for search

    private LocalDateTime createdTime = LocalDateTime.now();

    // getters and setters
    public Long getId() { return id; }
    public String getCardholderName() { return cardholderName; }
    public void setCardholderName(String name) { this.cardholderName = name; }
    public String getEncryptedPan() { return encryptedPan; }
    public void setEncryptedPan(String pan) { this.encryptedPan = pan; }
    public String getLast4() { return last4; }
    public void setLast4(String last4) { this.last4 = last4; }
    public LocalDateTime getCreatedTime() { return createdTime; }
    public void setCreatedTime(LocalDateTime createdTime) { this.createdTime = createdTime; }
}
