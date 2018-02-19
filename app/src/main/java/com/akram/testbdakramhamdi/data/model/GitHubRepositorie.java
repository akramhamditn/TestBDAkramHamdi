package com.akram.testbdakramhamdi.data.model;

import android.graphics.Bitmap;

/**
 * Created by akram on 19/02/2018.
 */

public class GitHubRepositorie {

    private Bitmap avatar;
    private String name;
    private String description;
    private String nbStars;

    public Bitmap getAvatar() {
        return avatar;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getNbStars() {
        return nbStars;
    }
}
