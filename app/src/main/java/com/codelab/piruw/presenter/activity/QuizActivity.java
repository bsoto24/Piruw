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

public class QuizActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        btnNext = (Button) findViewById(R.id.btn_next);

        mCardAdapter = new CardPagerAdapter();

        mCardAdapter.addCardItem(new PreguntaTO("Mitológicamente fundó el Tahuantinsuyo", "Manco Capac", "Inca Roca", "Atahualpa", "Pachacutec", R.drawable.inca));
        mCardAdapter.addCardItem(new PreguntaTO("Año en el que se declaró la independencia del Perú", "1551", "1892", "1888", "1821", R.drawable.republica));
        mCardAdapter.addCardItem(new PreguntaTO("Ultimo virrey del Perú", "José Fernando de Abascal", "Jose de la Serna", "Joaquin de la Pezuela", "Blasco Nuñez de Vela", R.drawable.colonia));
        mCardAdapter.addCardItem(new PreguntaTO("Mitológicamente fundó el Tahuantinsuyo", "Manco Capac", "Inca Roca", "Atahualpa", "Pachacutec", R.drawable.inca2));
        mCardAdapter.addCardItem(new PreguntaTO("Año en el que se declaró la independencia del Perú", "1551", "1892", "1888", "1821", R.drawable.republica));
        mCardAdapter.addCardItem(new PreguntaTO("Último virrey del Perú", "José Fernando de Abascal", "Jose de la Serna", "Joaquin de la Pezuela", "Blasco Nuñez de Vela", R.drawable.colonia2));

        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mCardShadowTransformer.enableScaling(true);

        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

    }
}
