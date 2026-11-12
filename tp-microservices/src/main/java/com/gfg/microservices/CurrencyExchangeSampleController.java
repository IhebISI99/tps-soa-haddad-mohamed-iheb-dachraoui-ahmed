package com.gfg.microservices;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

// @RestController = @Controller + @ResponseBody
@RestController
@RequestMapping("/currency-exchange-sample")
public class CurrencyExchangeSampleController {

    private final Environment environment;
    private final ExchangeService exchangeService;

    public CurrencyExchangeSampleController(Environment environment, ExchangeService exchangeService) {
        this.environment = environment;
        this.exchangeService = exchangeService;
    }

    // Exemple : /currency-exchange-sample/fromCurrency/USD/toCurrency/INR
    @GetMapping("/fromCurrency/{fromCurrency}/toCurrency/{toCurrency}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String fromCurrency,
                                               @PathVariable String toCurrency) {

        ExchangeValue exchangeValue = exchangeService.findExchangeValue(fromCurrency, toCurrency)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Taux introuvable pour " + fromCurrency + " -> " + toCurrency));

        // Renseigne le port de l'instance qui a répondu
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return exchangeValue;
    }

    @PostMapping
    public ResponseEntity<ExchangeValue> createExchangeValue(@RequestBody ExchangeValue exchangeValue) {
        ExchangeValue saved = exchangeService.createExchangeValue(exchangeValue);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}