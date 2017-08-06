package com.codelab.piruw.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Bryam Soto on 05/08/2017.
 */

public class TextViewKG extends TextView {

    public TextViewKG(Context context) {
        super(context);

        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/KGMissKindergarten.ttf");
        this.setTypeface(font);
    }

    public TextViewKG(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/KGMissKindergarten.ttf");
        this.setTypeface(font);
    }
}
