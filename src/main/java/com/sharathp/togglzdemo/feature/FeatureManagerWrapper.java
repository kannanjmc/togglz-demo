package com.sharathp.togglzdemo.feature;

import org.togglz.core.manager.FeatureManager;

/**
 * A wrapper to statically access feature-manager. This is slightly hack-ish vs
 * going through the recommended ServiceLoader mechanism -
 * http://www.togglz.org/documentation/advanced-config.html#jee6.
 */
public class FeatureManagerWrapper {
    private FeatureManager featureManager;
    private static final FeatureManagerWrapper instance = new FeatureManagerWrapper();

    private FeatureManagerWrapper() {
        // singleton
    }

    public static FeatureManagerWrapper getInstance() {
        return instance;
    }

    public void setFeatureManager(FeatureManager featureManager) {
        if(this.featureManager == null) {
            this.featureManager = featureManager;
        } else {
            throw new UnsupportedOperationException("featureManager is already set, cannot reset.");
        }
    }

    public FeatureManager getFeatureManager() {
        return featureManager;
    }
}
