package com.sharathp.togglzdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.annotation.Label;

import com.sharathp.togglzdemo.feature.DemoFeature;
import com.sharathp.togglzdemo.representation.Feature;

/**
 * A controller that returns the features state for the requested user.
 */
@RestController
public class FeatureController {

    @RequestMapping(value = "/features", method = RequestMethod.GET)
    public HttpEntity<List<Feature>> getFeatures() {
        return new HttpEntity<>(doGetFeatures());
    }

    private List<Feature> doGetFeatures() {
        final List<Feature> allFeatures = new ArrayList<>();
        for(final DemoFeature demoFeature : DemoFeature.values()) {
            final Feature feature = new Feature(demoFeature.name());
            feature.setDescription(getFeatureToggleLabel(demoFeature));
            feature.setActive(demoFeature.isActive());
            allFeatures.add(feature);
        }
        return allFeatures;
    }

    private String getFeatureToggleLabel(final DemoFeature demoFeature) {
        try {
            Label label = DemoFeature.class.getField(demoFeature.name()).getAnnotation(Label.class);
            if(label == null) {
                return demoFeature.name();
            }
            return label.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
