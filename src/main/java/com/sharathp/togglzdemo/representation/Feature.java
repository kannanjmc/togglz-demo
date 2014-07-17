package com.sharathp.togglzdemo.representation;

/**
 * Model representing a Feature.
 */
public class Feature {
    private String name;
    private String description;
    private boolean active;

    public Feature(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
