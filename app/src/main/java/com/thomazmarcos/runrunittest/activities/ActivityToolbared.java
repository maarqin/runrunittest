package com.thomazmarcos.runrunittest.activities;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.thomazmarcos.runrunittest.R;


/**
 * Created by thomaz on 16/03/18.
 */
public abstract class ActivityToolbared extends BaseActivity {

    protected Toolbar toolbar;

    protected void onCreate(@Nullable Bundle savedInstanceState, @LayoutRes int res, boolean backable) {
        setContentView(res);
        super.onCreate(savedInstanceState);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if( backable ) {
            showBackButton();
        }
    }

    private void showBackButton() {
        if( getSupportActionBar() != null ) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
