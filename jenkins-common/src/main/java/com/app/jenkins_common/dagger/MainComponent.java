package com.app.jenkins_common.dagger;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MainModule.class})
public interface MainComponent extends MainGraph {
}
