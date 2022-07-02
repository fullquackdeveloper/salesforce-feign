package com.fullquackdeveloper.salesforcefeign.config;

import com.fullquackdeveloper.salesforcefeign.oauth2.OAuth2Provider;
import feign.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class SalesforceClientConfig {
    private final OAuth2Provider oauth2Provider;

    @Bean
    public RequestInterceptor salesforceAuthZInterceptor() {
        return (requestTemplate) -> {
            String token = oauth2Provider.getAuthenticationToken("salesforce");
            requestTemplate.header(HttpHeaders.AUTHORIZATION, token);
        };
    }
}
