package com.fullquackdeveloper.salesforcefeign.client;

import com.fullquackdeveloper.salesforcefeign.config.SalesforceClientConfig;
import com.fullquackdeveloper.salesforcefeign.model.AccountObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "salesforce", url = "${salesforce.baseUrl}", configuration = SalesforceClientConfig.class)
public interface SalesforceClient {
    @GetMapping(path = "services/data/v52.0/sobjects/Account/{accountId}")
    AccountObject getAccountDetail(@PathVariable String accountId);
}
