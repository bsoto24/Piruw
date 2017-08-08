package com.codelab.piruw.presenter.cardview;

import android.graphics.PorterDuff;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.codelab.piruw.R;
import com.codelab.piruw.data.entity.PreguntaTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardPagerAdapter extends PagerAdapter implements CardAdapter {

    private List<CardView> mViews;
    private List<PreguntaTO> mData;
    private float mBaseElevation;

    public CardPagerAdapter() {
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
    }

    public void addCardItem(PreguntaTO item) {
        mViews.add(null);
        mData.add(item);
    }

    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.item_pregunta, container, false);
        container.addView(view);
        bind(mData.get(position), view);
        CardView cardView = (CardView) view.findViewById(R.id.cardView);

        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }

        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        mViews.set(position, cardView);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    private void bind(final PreguntaTO item, View view) {

        TextView tv_pregunta = (TextView) view.findViewById(R.id.tv_pregunta);
        ImageView img_pregunta = (ImageView) view.findViewById(R.id.img_pregunta);

        final Button btn_alt1 = (Button) view.findViewById(R.id.btn_alt_1);
        final Button btn_alt2 = (Button) view.findViewById(R.id.btn_alt_2);
        final Button btn_alt3 = (Button) view.findViewById(R.id.btn_alt_3);
        final Button btn_alt4 = (Button) view.findViewById(R.id.btn_alt_4);

        Button[] alternativas = new Button[4];
        alternativas[0] = btn_alt1;
        alternativas[1] = btn_alt2;
        alternativas[2] = btn_alt3;
        alternativas[3] = btn_alt4;

        tv_pregunta.setText(item.getPregunta());
        img_pregunta.setImageResource(item.getImagen());

        if(!item.isMezcla()){
            item.setMezcla(true);
            mezclarAternativas(item);
        }

        if (!item.getRespuesta().equals("")){
            for (int i = 0; i < 4; i++) {
                if (item.getAlternativas()[i].equals(item.getRespuesta())){
                    alternativas[i].getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.colorAccent), PorterDuff.Mode.MULTIPLY);
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            alternativas[i].setText(item.getAlternativas()[i]);
        }

        btn_alt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.setRespuesta(item.getAlternativas()[0]);
                btn_alt1.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.colorAccent), PorterDuff.Mode.MULTIPLY);
                btn_alt2.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.normal), PorterDuff.Mode.MULTIPLY);
                btn_alt3.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.normal), PorterDuff.Mode.MULTIPLY);
                btn_alt4.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.normal), PorterDuff.Mode.MULTIPLY);
            }
        });

        btn_alt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.setRespuesta(item.getAlternativas()[1]);
                btn_alt2.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.colorAccent), PorterDuff.Mode.MULTIPLY);
                btn_alt1.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.normal), PorterDuff.Mode.MULTIPLY);
                btn_alt3.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.normal), PorterDuff.Mode.MULTIPLY);
                btn_alt4.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.normal), PorterDuff.Mode.MULTIPLY);
            }
        });

        btn_alt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.setRespuesta(item.getAlternativas()[2]);
                btn_alt3.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.colorAccent), PorterDuff.Mode.MULTIPLY);
                btn_alt1.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.normal), PorterDuff.Mode.MULTIPLY);
                btn_alt2.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.normal), PorterDuff.Mode.MULTIPLY);
                btn_alt4.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.normal), PorterDuff.Mode.MULTIPLY);
            }
        });

        btn_alt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.setRespuesta(item.getAlternativas()[3]);
                btn_alt4.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.colorAccent), PorterDuff.Mode.MULTIPLY);
                btn_alt1.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.normal), PorterDuff.Mode.MULTIPLY);
                btn_alt2.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.normal), PorterDuff.Mode.MULTIPLY);
                btn_alt3.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.normal), PorterDuff.Mode.MULTIPLY);
            }
        });

    }

    private void mezclarAternativas(PreguntaTO item) {
        int index;
        String temp;
        Random random = new Random();
        for (int i = item.getAlternativas().length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = item.getAlternativas()[index];
            item.getAlternativas()[index] = item.getAlternativas()[i];
            item.getAlternativas()[i] = temp;
        }
    }

}
