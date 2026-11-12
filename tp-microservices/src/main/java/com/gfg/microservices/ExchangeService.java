package com.gfg.microservices;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ExchangeService {

    private final ExchangeRepository exchangeRepository;

    public ExchangeService(ExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }

    // CREATE
    public ExchangeValue createExchangeValue(ExchangeValue ex) {
        return exchangeRepository.save(ex);
    }

    // READ
    public Optional<ExchangeValue> findExchangeValue(String from, String to) {
        return exchangeRepository.findByFromCurrencyIgnoreCaseAndToCurrencyIgnoreCase(from, to);
    }
}
