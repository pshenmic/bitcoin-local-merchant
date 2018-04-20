package com.pshenmic.service;


import com.pshenmic.exception.OperationPriceExtractingException;
import com.pshenmic.model.BlockchainInfoTicker;
import com.pshenmic.model.OperationPrice;
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

    public OperationPrice getPrice(BigDecimal price) throws OperationPriceExtractingException {

        try {

            String url = "https://blockchain.info/ticker";

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<BlockchainInfoTicker> responseEntity =
                    restTemplate.getForEntity(url, BlockchainInfoTicker.class);
            BlockchainInfoTicker tick = responseEntity.getBody();

            if (tick.getRUB() == null) {
                return null;
            }
            BigDecimal lastBtcRate = tick.getRUB().getFifteenMinutesPrice();
            BigDecimal finalBtcAmount = price.divide(lastBtcRate, 7, RoundingMode.HALF_EVEN);

            OperationPrice operationPrice = new OperationPrice();
            operationPrice.setPrice(price);
            operationPrice.setBtcRate(lastBtcRate);
            operationPrice.setBtcPrice(finalBtcAmount);
            return operationPrice;
        } catch (Exception e) {
            log.error("Error during prices grabbing", e);
            throw new OperationPriceExtractingException(e.getCause());
        }

    }

}
