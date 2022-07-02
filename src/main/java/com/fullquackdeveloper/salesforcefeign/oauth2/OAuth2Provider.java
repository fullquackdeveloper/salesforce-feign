package com.fullquackdeveloper.salesforcefeign.oauth2;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OAuth2Provider {
    private final OAuth2AuthorizedClientManager authorizedClientManager;

    public static final Authentication principal = new AnonymousAuthenticationToken
            ("key", "anonymous", AuthorityUtils.createAuthorityList("ROLE_ANONYMOUS"));

    public String getAuthenticationToken(final String clientRegistrationId) {
        OAuth2AuthorizeRequest request =
                OAuth2AuthorizeRequest.withClientRegistrationId(clientRegistrationId)
                        .principal(principal)
                        .build();
        OAuth2AuthorizedClient authorizedClient = authorizedClientManager.authorize(request);
        String token = authorizedClient.getAccessToken().getTokenValue();
        return "Bearer " + token;
    }
}
