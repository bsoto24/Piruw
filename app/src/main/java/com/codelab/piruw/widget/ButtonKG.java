package com.codelab.piruw.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by Bryam Soto on 06/08/2017.
 */

public class ButtonKG extends Button {

    public ButtonKG(Context context) {
        super(context);
        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/KGMissKindergarten.ttf");
        this.setTypeface(font);

    }

    public ButtonKG(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/KGMissKindergarten.ttf");
        this.setTypeface(font);
    }
}
