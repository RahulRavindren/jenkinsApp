package com.app.jenkinsapp.components;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MainModule.class})
public interface MainComponent extends MainGraph {
}
