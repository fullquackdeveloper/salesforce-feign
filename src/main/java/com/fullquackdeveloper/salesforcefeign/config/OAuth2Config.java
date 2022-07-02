package com.fullquackdeveloper.salesforcefeign.config;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.*;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ConfigurationProperties(prefix = "salesforce.login")
@Configuration
@Slf4j
public class OAuth2Config {
    private String apiUsername;
    private String apiPassword;
    @Bean
    public OAuth2AuthorizedClientManager authorizedClientManager(
            final ClientRegistrationRepository clientRegistrationRepository,
            final OAuth2AuthorizedClientService authorizedClientService) {

        AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientManager =
                new AuthorizedClientServiceOAuth2AuthorizedClientManager(
                        clientRegistrationRepository, authorizedClientService);

        OAuth2AuthorizedClientProvider authorizedClientProvider = OAuth2AuthorizedClientProviderBuilder.builder()
                .password()
                .build();

        authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);

        Map<String, Object> contextAttributesMap = new HashMap<>();
        contextAttributesMap.put(OAuth2AuthorizationContext.USERNAME_ATTRIBUTE_NAME, getApiUsername());
        contextAttributesMap.put(OAuth2AuthorizationContext.PASSWORD_ATTRIBUTE_NAME, getApiPassword());

        authorizedClientManager.setContextAttributesMapper(oAuth2AuthorizeRequest -> contextAttributesMap);

        return authorizedClientManager;
    }
}
