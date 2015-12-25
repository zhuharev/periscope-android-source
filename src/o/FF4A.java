// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

// Referenced classes of package o:
//            FBE6, _cls0715, FB33, FEAD

public class FF4A extends ImageView
    implements FBE6
{

    private FB33 F;
    private FEAD Q;

    public FF4A(Context context)
    {
        this(context, null);
    }

    public FF4A(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public FF4A(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        context = _cls0715._mth1FBE(context);
        F = new FB33(this, context);
        F._mth02CA(attributeset, i);
        Q = new FEAD(this, context);
        Q._mth02CA(attributeset, i);
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        if (F != null)
        {
            F._mth05E8();
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

    public void setImageResource(int i)
    {
        Q.setImageResource(i);
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
}
