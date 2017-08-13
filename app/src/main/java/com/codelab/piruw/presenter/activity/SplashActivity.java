package com.codelab.piruw.presenter.activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.codelab.piruw.R;
import com.codelab.piruw.data.database.LocalData;
import com.codelab.piruw.data.database.SQliteManager;
import com.codelab.piruw.data.session.SessionManager;

public class SplashActivity extends AppCompatActivity {

    private SessionManager sessionMananger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        sessionMananger = SessionManager.getInstance(SplashActivity.this);

        if (!sessionMananger.getAppCreated()) {
            Snackbar.make(this.findViewById(R.id.container), "Cargando datos ...", Snackbar.LENGTH_INDEFINITE).show();
            sessionMananger.setAppCreated(true);
            LocalData.load(this);
        }

        new CountDownTimer(1500, 500){

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        }.start();

    }
}
