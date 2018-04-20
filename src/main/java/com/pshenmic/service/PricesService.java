package com.pshenmic.service;


import com.pshenmic.domain.OperationPrice;
import com.pshenmic.exception.OperationPriceExtractingException;
import com.pshenmic.model.BlockchainInfoTicker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class PricesService {

    private final Logger log = LoggerFactory.getLogger(PricesService.class);

    private final static String BLOCKCHAIN_INFO_API_URL = "https://blockchain.info/ticker";

    public BigDecimal getBtcUsdPrice() throws OperationPriceExtractingException {
        BlockchainInfoTicker blockchainInfoTicker = getTicks();
        if (blockchainInfoTicker == null || blockchainInfoTicker.getUSD() == null || blockchainInfoTicker.getUSD().getFifteenMinutesPrice() == null) {
            throw new OperationPriceExtractingException("JSON is not valid, some of required fields is null");
        }
        return blockchainInfoTicker.getUSD().getFifteenMinutesPrice();
    }

    private BlockchainInfoTicker getTicks() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<BlockchainInfoTicker> responseEntity =
                restTemplate.getForEntity(BLOCKCHAIN_INFO_API_URL, BlockchainInfoTicker.class);
        return responseEntity.getBody();
    }

}
