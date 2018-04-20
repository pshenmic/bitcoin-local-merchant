package com.pshenmic.configuration;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;
import com.pshenmic.api.service.ElectrumAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class JSONRPCConfiguration {

    private static final String endpoint = "http://localhost:7778";

    private final static String electrumUsername = "user";
    //private final static String electrumPassword = "mOGETJiR7kH5_gyGHhWZzg==";
    private final static String electrumPassword = "XfIR9n8HQ11Igrzi14Vh6A==";

    @Bean
    public JsonRpcHttpClient jsonRpcHttpClient() {
        URL url = null;
        //You can add authentication headers etc to this map
        Map<String, String> map = new HashMap<>();
        try {
            map.put("Authorization", "Basic " + Base64.getEncoder().encodeToString((electrumUsername + ":" + electrumPassword).getBytes()));
            url = new URL(endpoint);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JsonRpcHttpClient jsonRpcHttpClient = new JsonRpcHttpClient(url, map);
        return jsonRpcHttpClient;
    }

    @Bean
    public ElectrumAPI electrumClientAPI(JsonRpcHttpClient jsonRpcHttpClient) {
        return ProxyUtil.createClientProxy(getClass().getClassLoader(), ElectrumAPI.class, jsonRpcHttpClient);
    }

}
