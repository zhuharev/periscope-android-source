// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

// Referenced classes of package o:
//            FBE6, _cls1541, _cls0697, _cls09A3, 
//            _cls0715, FB33, _cls03C4

public class FB27 extends AutoCompleteTextView
    implements FBE6
{

    private static final int _fld15AA[] = {
        0x1010176
    };
    private _cls0715 E;
    private FB33 F;
    private _cls03C4 G;

    public FB27(Context context)
    {
        this(context, null);
    }

    public FB27(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, _cls1541.autoCompleteTextViewStyle);
    }

    public FB27(Context context, AttributeSet attributeset, int i)
    {
        super(_cls0697._mth037A(context), attributeset, i);
        context = getContext();
        context = new _cls09A3(context, context.obtainStyledAttributes(attributeset, _fld15AA, i, 0));
        if (((_cls09A3) (context)).E == null)
        {
            context.E = _cls0715._mth1FBE(((_cls09A3) (context)).mContext);
        }
        E = ((_cls09A3) (context)).E;
        if (((_cls09A3) (context)).hU.hasValue(0))
        {
            setDropDownBackgroundDrawable(context.getDrawable(0));
        }
        ((_cls09A3) (context)).hU.recycle();
        F = new FB33(this, E);
        F._mth02CA(attributeset, i);
        G = _cls03C4._mth02CA(this);
        G._mth02CA(attributeset, i);
        G._mth156A();
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        if (F != null)
        {
            F._mth05E8();
        }
        if (G != null)
        {
            G._mth156A();
        }
    }

    public void setBackgroundDrawable(Drawable drawable)
    {
        super.setBackgroundDrawable(drawable);
        if (F != null)
        {
            F._mth02BC(drawable);
        }
    }

    public void setBackgroundResource(int i)
    {
        super.setBackgroundResource(i);
        if (F != null)
        {
            F._mth1D55(i);
        }
    }

    public void setDropDownBackgroundResource(int i)
    {
        if (E != null)
        {
            setDropDownBackgroundDrawable(E._mth02BD(i, false));
            return;
        } else
        {
            super.setDropDownBackgroundResource(i);
            return;
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorstatelist)
    {
        if (F != null)
        {
            F.setSupportBackgroundTintList(colorstatelist);
        }
    }

    public void setSupportBackgroundTintMode(android.graphics.PorterDuff.Mode mode)
    {
        if (F != null)
        {
            F.setSupportBackgroundTintMode(mode);
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
