// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CheckedTextView;

// Referenced classes of package o:
//            _cls03C4, _cls0715, _cls09A3

public class FB86 extends CheckedTextView
{

    private static final int _fld15AA[] = {
        0x1010108
    };
    private _cls0715 E;
    private _cls03C4 G;

    public FB86(Context context)
    {
        this(context, null);
    }

    public FB86(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x10103c8);
    }

    public FB86(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        G = _cls03C4._mth02CA(this);
        G._mth02CA(attributeset, i);
        G._mth156A();
        if (_cls0715.hI)
        {
            context = getContext();
            context = new _cls09A3(context, context.obtainStyledAttributes(attributeset, _fld15AA, i, 0));
            setCheckMarkDrawable(context.getDrawable(0));
            ((_cls09A3) (context)).hU.recycle();
            if (((_cls09A3) (context)).E == null)
            {
                context.E = _cls0715._mth1FBE(((_cls09A3) (context)).mContext);
            }
            E = ((_cls09A3) (context)).E;
        }
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        if (G != null)
        {
            G._mth156A();
        }
    }

    public void setCheckMarkDrawable(int i)
    {
        if (E != null)
        {
            setCheckMarkDrawable(E._mth02BD(i, false));
            return;
        } else
        {
            super.setCheckMarkDrawable(i);
            return;
        }
    }

    public void setTextAppearance(Context context, int i)
    {
        super.setTextAppearance(context, i);
        if (G != null)
        {
            G._mth141D(context, i);
        }
    }

}
