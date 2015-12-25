// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;

// Referenced classes of package o:
//            _cls0140, _cls1541, _cls0715, FE71, 
//            _cls1D38

public class FB65 extends CheckBox
    implements _cls0140
{

    private _cls0715 E;
    private FE71 J;

    public FB65(Context context)
    {
        this(context, null);
    }

    public FB65(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, _cls1541.checkboxStyle);
    }

    public FB65(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        E = _cls0715._mth1FBE(context);
        J = new FE71(this, E);
        J._mth02CA(attributeset, i);
    }

    public int getCompoundPaddingLeft()
    {
        int i = super.getCompoundPaddingLeft();
        if (J != null)
        {
            return J._mth1D63(i);
        } else
        {
            return i;
        }
    }

    public void setButtonDrawable(int i)
    {
        Drawable drawable;
        if (E != null)
        {
            drawable = E._mth02BD(i, false);
        } else
        {
            drawable = _cls1D38._mth02CB(getContext(), i);
        }
        setButtonDrawable(drawable);
    }

    public void setButtonDrawable(Drawable drawable)
    {
        super.setButtonDrawable(drawable);
        if (J != null)
        {
            J._mth062F();
        }
    }

    public void setSupportButtonTintList(ColorStateList colorstatelist)
    {
        if (J != null)
        {
            J.setSupportButtonTintList(colorstatelist);
        }
    }

    public void setSupportButtonTintMode(android.graphics.PorterDuff.Mode mode)
    {
        if (J != null)
        {
            J.setSupportButtonTintMode(mode);
        }
    }
}
