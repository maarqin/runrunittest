package com.thomazmarcos.runrunittest.network;

import java.util.ArrayList;

/**
 * Created by thomaz on 17/03/2018.
 */
public class BaseUserApi {

    public abstract static class All extends SuccessCallback<ArrayList<Object>> {

        public All() {
            super();

            rest.allUsers().enqueue(this);
        }
    }
}
