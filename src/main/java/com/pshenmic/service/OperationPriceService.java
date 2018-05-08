package com.pshenmic.service;

import com.pshenmic.domain.Product;
import com.pshenmic.enums.Currency;
import com.pshenmic.exception.OperationPriceExtractingException;
import com.pshenmic.exception.UnknownCurrencyException;
import com.pshenmic.model.dto.OperationPriceDTO;
import com.pshenmic.util.BitcoinMathContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;

@Service
public class OperationPriceService {

    @Autowired
    private PricesService pricesService;


    public OperationPriceDTO getOperationPriceByProduct(Product product) throws UnknownCurrencyException, OperationPriceExtractingException {
        OperationPriceDTO operationPriceDTO = new OperationPriceDTO();

        BigDecimal fiatPrice = product.getPrice();

        operationPriceDTO.setCurrency(product.getCurrency());

        switch(operationPriceDTO.getCurrency()) {
            case USD:
                operationPriceDTO.setFiatRate(pricesService.getBtcUsdPrice());
                break;
            default:
                throw new UnknownCurrencyException();
        }

        operationPriceDTO.setBtcPrice(fiatPrice.divide(operationPriceDTO.getFiatRate(), BitcoinMathContext.BITCOIN_FRACTION));

        return operationPriceDTO;
    }

}
