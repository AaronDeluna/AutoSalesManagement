package com.autosalesmanagement.component;

public abstract class Component {
    private boolean isFunctional = true;

    public boolean isFunctional() {
        return isFunctional;
    }

    public void setFunctional(boolean functional) {
        isFunctional = functional;
    }
}
