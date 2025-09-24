package com.example.cardholder.controller;

import com.example.cardholder.dto.CardRequest;
import com.example.cardholder.dto.CardResponse;
import com.example.cardholder.model.Card;
import com.example.cardholder.repository.CardRepository;
import com.example.cardholder.util.EncryptionUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardRepository repo;
    private final EncryptionUtil encryptionUtil = new EncryptionUtil(); // instantiate directly

    public CardController(CardRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public CardResponse addCard(@RequestBody CardRequest req) throws Exception {
        String encryptedPan = encryptionUtil.encrypt(req.getPan());
        String last4 = req.getPan().substring(req.getPan().length() - 4);

        Card card = new Card();
        card.setCardholderName(req.getCardholderName());
        card.setEncryptedPan(encryptedPan);
        card.setLast4(last4);

        Card saved = repo.save(card);

        return new CardResponse(saved.getCardholderName(), maskPan(last4), saved.getCreatedTime());
    }

    @GetMapping
    public List<CardResponse> searchCards(@RequestParam String last4) {
        return repo.findByLast4(last4)
                   .stream()
                   .map(c -> new CardResponse(c.getCardholderName(), maskPan(c.getLast4()), c.getCreatedTime()))
                   .collect(Collectors.toList());
    }

    private String maskPan(String last4) {
        return "**** **** **** " + last4;
    }
}
