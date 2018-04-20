package com.pshenmic.service;


import com.pshenmic.model.*;
import com.pshenmic.model.electrum.GetBalanceResult;
import com.pshenmic.model.electrum.GetRequestParams;
import com.pshenmic.model.electrum.SendRequest;
import com.pshenmic.model.electrum.SendRequestParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;

@Service
public class ElectrumService {

    private final String electrumUrl = "http://127.0.0.1:7778";

    //in seconds
    private final int paymentTimeout = 900;

    private final Logger log = LoggerFactory.getLogger(ElectrumService.class);

    private RestTemplate restTemplate;

    private final static String electrumUsername = "user";
    //private final static String electrumPassword = "mOGETJiR7kH5_gyGHhWZzg==";
    private final static String electrumPassword = "XfIR9n8HQ11Igrzi14Vh6A==";

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

    public GetBalanceResult getBalance() {
        try {

            ElectrumGetBalanceRequest request = new ElectrumGetBalanceRequest();
            request.setId("bitcoin-local-merchant");
            request.setMethod("getbalance");
            request.setParams(new ArrayList<>());

            HttpEntity<ElectrumGetBalanceRequest> httpEntity = new HttpEntity<>(request);

            ResponseEntity<ElectrumGetBalanceResponse> response =
                    restTemplate.exchange(electrumUrl, HttpMethod.POST, httpEntity, ElectrumGetBalanceResponse.class);
            ElectrumGetBalanceResponse responseBody = response.getBody();
            return responseBody.getResult();
        } catch (Exception e) {
            return null;
        }
    }


    public SendRequest sendRequest(BigDecimal amount, String memo) {
        try {

            ElectrumSendRequest request = new ElectrumSendRequest();
            SendRequestParams sendRequestParams = new SendRequestParams();
            sendRequestParams.setAmount(amount);
            sendRequestParams.setMemo(memo);
            sendRequestParams.setForce(true);
            sendRequestParams.setExpiration(paymentTimeout);

            request.setId("bitcoin-local-merchant");
            request.setMethod("addrequest");
            request.setParams(sendRequestParams);


            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", "Basic " + Base64.getEncoder().encodeToString((electrumUsername + ":" + electrumPassword).getBytes()));

            HttpEntity<ElectrumSendRequest> httpEntity = new HttpEntity<>(request, httpHeaders);

            SendRequest sendRequest = electrumAPIService.test(sendRequestParams);


/*
            ResponseEntity<ElectrumSendRequestResponse> response =
                    restTemplate.exchange(electrumUrl, HttpMethod.POST, httpEntity, ElectrumSendRequestResponse.class);

            ElectrumSendRequestResponse responseBody = response.getBody();
            if(responseBody.getError() != null) {
                throw new Exception(responseBody.getError().getMessage());
            }*/

            return sendRequest;
        } catch (Exception e) {
            log.error("Failed to make electrum request", e);
            return null;
        }

    }

    public SendRequest getRequest(String address) {
        try {

            GetRequestParams getRequestParams = new GetRequestParams();
            getRequestParams.setKey(address);

            ElectrumGetRequest electrumGetRequest = new ElectrumGetRequest();
            electrumGetRequest.setParams(getRequestParams);

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", "Basic " + Base64.getEncoder().encodeToString((electrumUsername + ":" + electrumPassword).getBytes()));

            electrumGetRequest.setId("bitcoin-local-merchant");
            electrumGetRequest.setMethod("getrequest");
            electrumGetRequest.setParams(getRequestParams);

            HttpEntity<ElectrumGetRequest> httpEntity = new HttpEntity<>(electrumGetRequest, httpHeaders);
            ResponseEntity<ElectrumGetRequestResponse> response =
                    restTemplate.exchange(electrumUrl, HttpMethod.POST, httpEntity, ElectrumGetRequestResponse.class);
            ElectrumGetRequestResponse responseBody = response.getBody();
            return responseBody.getResult();
        } catch (Exception e) {
            return null;
        }

    }


}
