package com.codelab.piruw.presenter.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.codelab.piruw.R;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        btnNext = (Button) findViewById(R.id.btn_next);

        mCardAdapter = new CardPagerAdapter();

        preguntas = new ArrayList<>();

        preguntas.add(new PreguntaTO("Mitológicamente fundó el Tahuantinsuyo", "Manco Capac", "Inca Roca", "Atahualpa", "Pachacutec", R.drawable.inca));
        preguntas.add(new PreguntaTO("Año en el que se declaró la independencia del Perú", "1551", "1892", "1888", "1821", R.drawable.republica));
        preguntas.add(new PreguntaTO("Ultimo virrey del Perú", "José Fernando de Abascal", "Jose de la Serna", "Joaquin de la Pezuela", "Blasco Nuñez de Vela", R.drawable.colonia));
        preguntas.add(new PreguntaTO("Mitológicamente fundó el Tahuantinsuyo", "Manco Capac", "Inca Roca", "Atahualpa", "Pachacutec", R.drawable.inca2));
        preguntas.add(new PreguntaTO("Año en el que se declaró la independencia del Perú", "1551", "1892", "1888", "1821", R.drawable.republica));
        preguntas.add(new PreguntaTO("Último virrey del Perú", "José Fernando de Abascal", "Jose de la Serna", "Joaquin de la Pezuela", "Blasco Nuñez de Vela", R.drawable.colonia2));


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
}
