package com.app.session;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
@Component
public abstract class CurrentUserImpl implements CurrentUser {
    private Integer id;
    private String name;
    private Integer langId;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getLangId() {
        return langId;
    }

    @Override
    public void setLangId(Integer langId) {
        this.langId = langId;
    }
}