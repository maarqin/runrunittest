package com.thomazmarcos.runrunittest.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.List;


/**
 * Created by thomaz on 16/03/18.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle b = getIntent().getExtras();

        Class customFragment = (Class) b.getSerializable(CustomFragment.FRAGMENT);
        String title = b.getString(CustomFragment.TITLE_PAGE);

        setNewFragment(customFragment, title, this, false);
    }

    /**
     * @param fragmentClass {@link Class}
     * @param title {@link CharSequence}
     * @param activity {@link FragmentActivity}
     * @param back {@link boolean}
     */
    public static void setNewFragment(Class fragmentClass, CharSequence title,
                                      FragmentActivity activity, boolean back) {
        BaseActivity.setNewFragment(fragmentClass, title, activity, back, null);
    }

    /**
     * @param fragmentClass {@link Class}
     * @param title {@link CharSequence}
     * @param activity {@link FragmentActivity}
     * @param back {@link boolean}
     * @param bundle {@link Bundle}
     */
    public static void setNewFragment(Class fragmentClass, CharSequence title,
                                      FragmentActivity activity, boolean back, Bundle bundle) {
        Fragment fragment = null;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
            if( bundle != null ) fragment.setArguments(bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setNewFragment(fragment, title, activity, back, bundle);
    }

    /**
     * @param fragment {@link Fragment}
     * @param title {@link CharSequence}
     * @param activity {@link android.app.Activity}
     * @param back {@link boolean}
     * @param bundle {@link Bundle}
     */
    public static void setNewFragment(Fragment fragment, CharSequence title,
                                      FragmentActivity activity, boolean back, Bundle bundle) {

        // Set action bar title
        activity.setTitle(title);

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flContent, fragment);
        if( back ) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        List<Fragment> fragmentList = getSupportFragmentManager().getFragments();
        if (fragmentList != null) {
            for(Fragment fragment : fragmentList){
                if(fragment instanceof OnBackPressedListener){
                    ((OnBackPressedListener)fragment).onBackPressed(); return;
                }
            }
        }
        super.onBackPressed();
    }

    public interface OnBackPressedListener {
        void onBackPressed();
    }

}
