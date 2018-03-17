package com.thomazmarcos.runrunittest.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;

import com.dgreenhalgh.android.simpleitemdecoration.linear.DividerItemDecoration;
import com.thomazmarcos.runrunittest.R;

import java.io.Serializable;


/**
 * Created by thomaz on 16/03/18.
 */
public class CustomFragment extends Fragment implements Serializable {

    static public final String FRAGMENT = "FRAGMENT";
    static public final String TITLE_PAGE = "TITLE_PAGE";
    static public final String OBJECT = "OBJECT";
    static public final String OBJECT_EXTRA = "OBJECT_EXTRA";

    protected Bundle bundle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bundle = getActivity().getIntent().getExtras();
    }

    protected void setDecorationLine(RecyclerView rv) {
        Drawable dividerDrawable = ContextCompat.getDrawable(getActivity(), R.drawable.divider_line);
        rv.addItemDecoration(new DividerItemDecoration(dividerDrawable));
    }

}
