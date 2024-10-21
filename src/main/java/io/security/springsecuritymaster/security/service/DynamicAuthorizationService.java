package io.security.springsecuritymaster.security.service;

import io.security.springsecuritymaster.security.mapper.UrlRoleMapper;

import java.util.Map;

public class DynamicAuthorizationService {
    private final UrlRoleMapper delegate;

    public DynamicAuthorizationService(UrlRoleMapper urlRoleMapper) {
        this.delegate = urlRoleMapper;
    }

    public Map<String, String> getUrlRoleMappings() {
        return delegate.getUrlRoleMappings();
    }
}
