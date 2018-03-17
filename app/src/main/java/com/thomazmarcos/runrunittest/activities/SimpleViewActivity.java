package com.thomazmarcos.runrunittest.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.thomazmarcos.runrunittest.R;


/**
 * Created by thomaz on 16/03/18.
 */
public class SimpleViewActivity extends ActivityToolbared {

    static public final String NAME_STATUS = "NAME_STATUS";
    static public final String BACKABLE = "BACKABLE";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Bundle bundle = getIntent().getExtras();

        boolean b = !bundle.containsKey(BACKABLE) || bundle.getBoolean(BACKABLE);

        super.onCreate(savedInstanceState, R.layout.activity_simple_view, b);
    }

}