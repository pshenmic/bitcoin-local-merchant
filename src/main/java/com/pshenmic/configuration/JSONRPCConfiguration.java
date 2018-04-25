package com.pshenmic.configuration;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;
import com.pshenmic.api.service.ElectrumAPI;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class JSONRPCConfiguration {

    @Value("${blm.electrum.hostname}")
    private String electrumHostname;

    @Value("${blm.electrum.rpcuser}")
    private String rpcUser;

    @Value("${blm.electrum.rpcpassword}")
    private String rpcPassword;

    @Bean
    public JsonRpcHttpClient jsonRpcHttpClient() {
        URL url = null;
        //You can add authentication headers etc to this map
        Map<String, String> map = new HashMap<>();
        try {
            map.put("Authorization", "Basic " + Base64.getEncoder().encodeToString((rpcUser + ":" + rpcPassword).getBytes()));
            url = new URL(electrumHostname);

            JsonRpcHttpClient jsonRpcHttpClient = new JsonRpcHttpClient(url, map);
            return jsonRpcHttpClient;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new FatalBeanException("Could not construct jsonRpcHttpClient");
        }
    }

    @Bean
    public ElectrumAPI electrumClientAPI(JsonRpcHttpClient jsonRpcHttpClient) {
        return ProxyUtil.createClientProxy(getClass().getClassLoader(), ElectrumAPI.class, jsonRpcHttpClient);
    }

}
