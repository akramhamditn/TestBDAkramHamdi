package com.akram.testbdakramhamdi.ui.main.presenter;

import android.support.annotation.NonNull;

import com.akram.testbdakramhamdi.ui.base.BasePresenter;
import com.akram.testbdakramhamdi.ui.main.view.MainActivityView;



/**
 * Created by akram on 19/02/2018.
 */

public class MainPresenter extends BasePresenter {

    private final MainActivityView mView;
    public MainPresenter(@NonNull final MainActivityView view) {

        mView = view;

    }
}
