package com.gfg.microservices;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Exchange_Value")
public class ExchangeValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "currency_from")
    private String fromCurrency;

    @Column(name = "currency_to")
    private String toCurrency;

    @Column(name = "conversion_multiple")
    private BigDecimal conversionMultiple;

    // Le port n'est pas stocké en base : il indique quelle instance a répondu
    @Transient
    private int port;

    public ExchangeValue() {
    }

    public ExchangeValue(Long id, String fromCurrency, String toCurrency, BigDecimal conversionMultiple) {
        this.id = id;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.conversionMultiple = conversionMultiple;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFrom() { return fromCurrency; }
    public void setFrom(String fromCurrency) { this.fromCurrency = fromCurrency; }

    public String getTo() { return toCurrency; }
    public void setTo(String toCurrency) { this.toCurrency = toCurrency; }

    public BigDecimal getConversionMultiple() { return conversionMultiple; }
    public void setConversionMultiple(BigDecimal conversionMultiple) { this.conversionMultiple = conversionMultiple; }

    public int getPort() { return port; }
    public void setPort(int port) { this.port = port; }
}