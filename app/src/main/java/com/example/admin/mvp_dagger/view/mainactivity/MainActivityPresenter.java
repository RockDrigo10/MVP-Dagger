package com.example.admin.mvp_dagger.view.mainactivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by Admin on 8/21/2017.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private static final String TAG = "MainPresenter";
    private static final String MY_PREF_FILE = "mypref_file";
    MainActivityContract.View view;
    Context context;
    public void attacheView(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    @Override
    public void savePerson(String person) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("value1",person);
        boolean isSaved = editor.commit();
        Log.d(TAG, "savePerson: " + person);
        view.isPersonSaved(isSaved);
    }


    @Override
    public String getPerson() {
        String personReal;
        SharedPreferences sharePreferences = context.getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);
        personReal = sharePreferences.getString("value1","default");
        Log.d(TAG, "getPerson: " + personReal );
        return personReal;
    }

    @Override
    public void getContext(Context context) {
        this.context = context;
    }
}
