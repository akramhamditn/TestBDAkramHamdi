package com.akram.testbdakramhamdi.ui.main.model;

/**
 * Created by akram on 19/02/2018.
 */

public class MainResponse {

    private final boolean isNotFound;

    public MainResponse(final boolean isMatch) {
        this.isNotFound = isMatch;
    }

    public boolean isNotFound() {
        return isNotFound;
    }
}
