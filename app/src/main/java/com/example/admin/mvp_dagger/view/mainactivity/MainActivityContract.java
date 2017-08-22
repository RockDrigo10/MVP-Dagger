package com.example.admin.mvp_dagger.view.mainactivity;

import android.content.Context;

import com.example.admin.mvp_dagger.BasePresenter;
import com.example.admin.mvp_dagger.BaseView;

/**
 * Created by Admin on 8/21/2017.
 */

public interface MainActivityContract {

    interface View extends BaseView{

        void isPersonSaved(boolean isSaved);
        void sendPerson(String person);
    }
    interface Presenter extends BasePresenter<View>{

        void savePerson(String person);
        String getPerson();
        void getContext(Context context);
    }
}
