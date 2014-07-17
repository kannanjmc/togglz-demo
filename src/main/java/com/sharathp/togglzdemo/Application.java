package com.sharathp.togglzdemo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.manager.FeatureManagerBuilder;
import org.togglz.core.repository.FeatureState;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.repository.mem.InMemoryStateRepository;
import org.togglz.core.user.NoOpUserProvider;
import org.togglz.core.user.UserProvider;

import com.sharathp.togglzdemo.feature.DemoFeature;
import com.sharathp.togglzdemo.feature.FeatureManagerWrapper;

/**
 * Entry point.
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan
public class Application {

    /**
     *  Entry point method.
     *
     * @param args - arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FeatureManagerWrapper featureManagerWrapper() throws IOException {
        final FeatureManagerBuilder builder = new FeatureManagerBuilder();
        builder.name("demo-feature-manager")
                .featureEnum(DemoFeature.class)
                .stateRepository(stateRepository())
                .userProvider(userProvider());
        final FeatureManager featureManager = builder.build();
        final FeatureManagerWrapper featureManagerWrapper = FeatureManagerWrapper.getInstance();
        featureManagerWrapper.setFeatureManager(featureManager);
        return featureManagerWrapper;
    }

    @Bean
    public StateRepository stateRepository() throws IOException {
        final InMemoryStateRepository stateRepository = new InMemoryStateRepository();
        stateRepository.setFeatureState(new FeatureState(DemoFeature.FEATURE_TWO, true));
        stateRepository.setFeatureState(new FeatureState(DemoFeature.FEATURE_THREE, false));
        return stateRepository;
    }

    @Bean
    public UserProvider userProvider() {
        return new NoOpUserProvider();
    }
}
