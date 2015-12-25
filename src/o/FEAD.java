// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

// Referenced classes of package o:
//            _cls0715, _cls1D38, _cls09A3

class FEAD
{

    private static final int R[] = {
        0x1010119
    };
    private final _cls0715 E;
    private final ImageView S;

    FEAD(ImageView imageview, _cls0715 _pcls0715)
    {
        S = imageview;
        E = _pcls0715;
    }

    void setImageResource(int i)
    {
        if (i != 0)
        {
            ImageView imageview = S;
            android.graphics.drawable.Drawable drawable;
            if (E != null)
            {
                drawable = E._mth02BD(i, false);
            } else
            {
                drawable = _cls1D38._mth02CB(S.getContext(), i);
            }
            imageview.setImageDrawable(drawable);
            return;
        } else
        {
            S.setImageDrawable(null);
            return;
        }
    }

    void _mth02CA(AttributeSet attributeset, int i)
    {
        Context context = S.getContext();
        attributeset = new _cls09A3(context, context.obtainStyledAttributes(attributeset, R, i, 0));
        if (((_cls09A3) (attributeset)).hU.hasValue(0))
        {
            S.setImageDrawable(attributeset.getDrawable(0));
        }
        ((_cls09A3) (attributeset)).hU.recycle();
        return;
        Exception exception;
        exception;
        ((_cls09A3) (attributeset)).hU.recycle();
        throw exception;
    }

}
