package com.chtrembl.petstoreapp.security;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;

public class TokenGenerator {
  private TokenGenerator(){}

  public static OAuth2AuthenticationToken generate() {
    Map<String, Object> attributes = new HashMap<>();
    attributes.put("username", "generated-user");
    attributes.put("name", "Generated User");
    attributes.put("emails", List.of("generated-user@gmail.com"));
    List<GrantedAuthority> authorities = Collections.singletonList(
        new OAuth2UserAuthority("ROLE_USER", attributes)
    );
    OAuth2User user = new DefaultOAuth2User(authorities, attributes, "username");
    OAuth2AuthenticationToken token = new OAuth2AuthenticationToken(
        user,
        authorities,
        "custom-client"
    );
    token.setAuthenticated(true);
    return token;
  }
}
