package com.example.herokudemo.web.services.loadtest;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Component
public class LoadTestClientFactory {

    private final Logger logger = Logger.getLogger(LoadTestClientFactory.class.getName());

    private final LoadTestClient customerOpt;
    private final LoadTestClient productOffer;
    private final LoadTestClient updateEmail;

    public LoadTestClientFactory(LoadTestClient customerOpt, LoadTestClient productOffer, LoadTestClient updateEmail) {
        this.customerOpt = customerOpt;
        this.productOffer = productOffer;
        this.updateEmail = updateEmail;
    }

    public LoadTestClient getInstance(String key){
        LoadTestClient client=null;

        for(LoadTestClientKey clientKey :LoadTestClientKey.values()){
            if(clientKey.toString().equalsIgnoreCase(key)) {
                client = this.createRunnableClientMapping().get(clientKey);
                break;
            }
        }
        return client;
    }

    private Map<LoadTestClientKey, LoadTestClient> createRunnableClientMapping(){
        logger.info("Creating runnable client instance map.");
        Map<LoadTestClientKey, LoadTestClient> runnableClients = new HashMap<LoadTestClientKey, LoadTestClient>(3);
        runnableClients.put(LoadTestClientKey.CUST_OPT, customerOpt);
        runnableClients.put(LoadTestClientKey.PROD_OFFER, productOffer);
        runnableClients.put(LoadTestClientKey.CUST_EMAIL, updateEmail);
        return runnableClients;
    }
}
