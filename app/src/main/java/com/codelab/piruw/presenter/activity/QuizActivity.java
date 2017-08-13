package com.codelab.piruw.presenter.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.codelab.piruw.R;
import com.codelab.piruw.data.database.SQliteManager;
import com.codelab.piruw.data.entity.PreguntaTO;
import com.codelab.piruw.presenter.cardview.CardPagerAdapter;
import com.codelab.piruw.presenter.cardview.ShadowTransformer;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    private Button btnNext;
    private ArrayList<PreguntaTO> preguntas;
    private SQliteManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        btnNext = (Button) findViewById(R.id.btn_next);

        mCardAdapter = new CardPagerAdapter();

        db = new SQliteManager(this);

        preguntas = db.getPreguntas();

        for (PreguntaTO p : preguntas){
            mCardAdapter.addCardItem(p);
        }

        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mCardShadowTransformer.enableScaling(true);

        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResultadoActivity.class);
                intent.putExtra("preguntas", preguntas);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

    }

    @Override
    public void onBackPressed() {

        View view = getLayoutInflater().inflate(R.layout.dialog_back, null);
        Button btnSi = view.findViewById(R.id.btn_si);
        Button btnNo = view.findViewById(R.id.btn_no);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        final AlertDialog alert = builder.create();
        alert.setCancelable(false);
        alert.show();

        btnSi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert.dismiss();
            }
        });

    }
}
