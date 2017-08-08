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

    private void bind(PreguntaTO item, View view) {

        TextView tv_pregunta = (TextView) view.findViewById(R.id.tv_pregunta);
        ImageView img_pregunta = (ImageView) view.findViewById(R.id.img_pregunta);

        final Button btn_alt1 = (Button) view.findViewById(R.id.btn_alt_1);
        final Button btn_alt2 = (Button) view.findViewById(R.id.btn_alt_2);
        final Button btn_alt3 = (Button) view.findViewById(R.id.btn_alt_3);
        final Button btn_alt4 = (Button) view.findViewById(R.id.btn_alt_4);

        tv_pregunta.setText(item.getPregunta());
        img_pregunta.setImageResource(item.getImagen());

        btn_alt1.setText(item.getAlt1());
        btn_alt2.setText(item.getAlt2());
        btn_alt3.setText(item.getAlt3());
        btn_alt4.setText(item.getAlt4());


        btn_alt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_alt1.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.colorAccent), PorterDuff.Mode.MULTIPLY);
                btn_alt2.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.normal), PorterDuff.Mode.MULTIPLY);
                btn_alt3.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.normal), PorterDuff.Mode.MULTIPLY);
                btn_alt4.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.normal), PorterDuff.Mode.MULTIPLY);
            }
        });

        btn_alt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_alt2.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.colorAccent), PorterDuff.Mode.MULTIPLY);
                btn_alt1.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.normal), PorterDuff.Mode.MULTIPLY);
                btn_alt3.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.normal), PorterDuff.Mode.MULTIPLY);
                btn_alt4.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.normal), PorterDuff.Mode.MULTIPLY);
            }
        });

        btn_alt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_alt3.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.colorAccent), PorterDuff.Mode.MULTIPLY);
                btn_alt1.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.normal), PorterDuff.Mode.MULTIPLY);
                btn_alt2.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.normal), PorterDuff.Mode.MULTIPLY);
                btn_alt4.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.normal), PorterDuff.Mode.MULTIPLY);
            }
        });

        btn_alt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_alt4.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.colorAccent), PorterDuff.Mode.MULTIPLY);
                btn_alt1.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.normal), PorterDuff.Mode.MULTIPLY);
                btn_alt2.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.normal), PorterDuff.Mode.MULTIPLY);
                btn_alt3.getBackground().setColorFilter(view.getContext().getResources().getColor(R.color.normal), PorterDuff.Mode.MULTIPLY);
            }
        });

    }

}
