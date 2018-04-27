package com.pshenmic.model.electrum;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pshenmic.configuration.UnixTimestampDeserializer;

import java.math.BigDecimal;
import java.time.Instant;

public class SendRequest {

    @JsonProperty("status")
    private String status;

    @JsonProperty("amount (BTC)")
    private BigDecimal btcAmount;

    @JsonProperty("index_url")
    private String indexUrl;

    @JsonProperty("memo")
    private String memo;

    @JsonProperty("time")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private Instant time;

    @JsonProperty("URI")
    private String URI;

    @JsonProperty("websocket_port")
    private int websocketPort;

    @JsonProperty("websocket_server")
    private String websocketServer;

    @JsonProperty("amount")
    private Long amount;

    @JsonProperty("address")
    private String address;

    @JsonProperty("request_url")
    private String requestUrl;

    @JsonProperty("id")
    private String id;

    @JsonProperty("exp")
    private int expiration;

    @JsonProperty("confirmations")
    private int confirmations;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getBtcAmount() {
        return btcAmount;
    }

    public void setBtcAmount(BigDecimal btcAmount) {
        this.btcAmount = btcAmount;
    }

    public String getIndexUrl() {
        return indexUrl;
    }

    public void setIndexUrl(String indexUrl) {
        this.indexUrl = indexUrl;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public String getURI() {
        return URI;
    }

    public void setURI(String URI) {
        this.URI = URI;
    }

    public int getWebsocketPort() {
        return websocketPort;
    }

    public void setWebsocketPort(int websocketPort) {
        this.websocketPort = websocketPort;
    }

    public String getWebsocketServer() {
        return websocketServer;
    }

    public void setWebsocketServer(String websocketServer) {
        this.websocketServer = websocketServer;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }

    public int getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(int confirmations) {
        this.confirmations = confirmations;
    }
}
