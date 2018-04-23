package com.pshenmic.model.dto;

import com.pshenmic.enums.Currency;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProductDTO {

    private Long id;

    private String qrCodeBase64;

    @NotNull
    private String name;

    @NotNull
    private BigDecimal price;

    private Currency currency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQrCodeBase64() {
        return qrCodeBase64;
    }

    public void setQrCodeBase64(String qrCodeBase64) {
        this.qrCodeBase64 = qrCodeBase64;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
