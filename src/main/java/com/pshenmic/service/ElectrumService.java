package com.pshenmic.service;


import com.pshenmic.exception.ElectrumRequestFailedException;
import com.pshenmic.model.ElectrumSendRequest;
import com.pshenmic.model.electrum.SendRequest;
import com.pshenmic.model.electrum.SendRequestParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Arrays;

@Service
public class ElectrumService {

    private final String electrumUrl = "http://127.0.0.1:7778";

    //in seconds
    private final int paymentTimeout = 900;

    private final Logger log = LoggerFactory.getLogger(ElectrumService.class);

    private RestTemplate restTemplate;

    @Autowired
    private ElectrumAPIService electrumAPIService;

    public ElectrumService() {
        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        MediaType jsonRpcMediaType = new MediaType("application");
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, jsonRpcMediaType));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        this.restTemplate = restTemplate;

    }


    public SendRequest sendRequest(BigDecimal amount) throws ElectrumRequestFailedException {
        try {

            ElectrumSendRequest request = new ElectrumSendRequest();
            SendRequestParams sendRequestParams = new SendRequestParams();
            sendRequestParams.setAmount(amount);
            sendRequestParams.setMemo(null);
            sendRequestParams.setForce(true);
            sendRequestParams.setExpiration(paymentTimeout);

            request.setId("bitcoin-local-merchant");
            request.setMethod("addrequest");
            request.setParams(sendRequestParams);


            SendRequest sendRequest = electrumAPIService.addRequest(sendRequestParams);

            return sendRequest;
        } catch (Exception e) {
            log.error("Failed to make electrum request", e);
            throw new ElectrumRequestFailedException(e);
        }

    }


    public SendRequest getRequest(String address) {
        return electrumAPIService.getRequest(address);
    }


}
