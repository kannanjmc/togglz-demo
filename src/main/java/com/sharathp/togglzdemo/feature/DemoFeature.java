package com.sharathp.togglzdemo.feature;

import org.togglz.core.Feature;
import org.togglz.core.annotation.EnabledByDefault;
import org.togglz.core.annotation.Label;

/**
 * Sample features for this demo.
 */
public enum DemoFeature implements Feature {

    @EnabledByDefault
    @Label("First Feature is enabled by default")
    FEATURE_ONE,

    @Label("Second Feature")
    FEATURE_TWO,

    @Label("Third Feature")
    FEATURE_THREE;

    public boolean isActive() {
        return FeatureManagerWrapper.getInstance().getFeatureManager().isActive(this);
    }
}
