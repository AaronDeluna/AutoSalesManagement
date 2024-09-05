package com.autosalesmanagement.component;

public class Electric {
    private boolean isFunctional;

    public Electric(boolean isFunctional) {
        this.isFunctional = isFunctional;
    }

    public boolean isFunctional() {
        return isFunctional;
    }

    public void setFunctional(boolean functional) {
        isFunctional = functional;
    }
}
