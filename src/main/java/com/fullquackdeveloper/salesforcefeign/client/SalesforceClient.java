package com.fullquackdeveloper.salesforcefeign.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "salesforce", url = "${client.salesforce.baseUrl}")
public interface SalesforceClient {
}
