package com.example.cardholder.repository;

import com.example.cardholder.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByLast4(String last4);
}
