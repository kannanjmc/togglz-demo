package com.sharathp.togglzdemo.feature;


import org.springframework.beans.factory.annotation.Autowired;
import org.togglz.core.Feature;
import org.togglz.core.manager.TogglzConfig;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.repository.mem.InMemoryStateRepository;
import org.togglz.core.user.UserProvider;

/**
 * Togglz main configuration.
 */
// TODO - is this class required?
public class FeatureConfiguration implements TogglzConfig {
    private StateRepository stateRepository;
    private UserProvider userProvider;

    @Override
    public Class<? extends Feature> getFeatureClass() {
        return DemoFeature.class;
    }

    @Override
    public StateRepository getStateRepository() {
        return new InMemoryStateRepository();
    }

    @Override
    public UserProvider getUserProvider() {
        return null;
    }

    @Autowired
    public void setStateRepository(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Autowired
    public void setUserProvider(UserProvider userProvider) {
        this.userProvider = userProvider;
    }
}
