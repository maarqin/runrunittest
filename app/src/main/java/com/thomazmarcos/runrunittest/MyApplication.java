package com.thomazmarcos.runrunittest;

import android.app.Application;

import butterknife.ButterKnife;
import io.realm.Realm;

/**
 * Created by thomaz on 19/03/2018.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
