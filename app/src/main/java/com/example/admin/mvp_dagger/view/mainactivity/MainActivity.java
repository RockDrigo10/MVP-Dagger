package com.example.admin.mvp_dagger.view.mainactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.mvp_dagger.Injection.mainactivity.DaggerMainActivityComponent;
import com.example.admin.mvp_dagger.R;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    private static final String TAG = "MainActivityTAG";
    @Inject
    MainActivityPresenter presenter;
    Button btnSavePerson,btnGetPreson;
    TextView tvPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerMainActivityComponent.create().inject(this);

        tvPerson = (TextView) findViewById(R.id.tvPerson);
        //presenter = new MainActivityPresenter();
        presenter.attacheView(this);
        presenter.getContext(this);
    }

    public void doMagic(View view) {
        switch (view.getId()) {
            case R.id.btnSavePerson:
                presenter.savePerson("John Snow");
                break;
            case R.id.btnGetPreson:
                tvPerson.setText(presenter.getPerson());
                break;
        }
    }

    @Override
    public void showError(String s) {

    }

    @Override
    public void isPersonSaved(boolean isSaved) {
        Log.d(TAG, "isPersonSaved: " + isSaved);
    }

    @Override
    public void sendPerson(String person) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.removeView();
    }
}
