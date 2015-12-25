// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

// Referenced classes of package o:
//            xe

public class aqt extends ImageView
{

    public boolean bAL;
    private Drawable bAM;
    private Drawable bAN;

    public aqt(Context context)
    {
        super(context);
        _mth02CA(context, 0x7f0200d9, 0x7f0c0035, es(), et());
    }

    public aqt(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        _mth02CF(context, attributeset);
    }

    public aqt(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        _mth02CF(context, attributeset);
    }

    private void _mth02CA(Context context, int i, int j, int k, int l)
    {
        bAM = context.getResources().getDrawable(i);
        bAM.mutate().setColorFilter(context.getResources().getColor(j), android.graphics.PorterDuff.Mode.SRC_ATOP);
        if (k > 0)
        {
            bAN = context.getResources().getDrawable(k);
            bAN.mutate().setColorFilter(context.getResources().getColor(l), android.graphics.PorterDuff.Mode.SRC_ATOP);
        } else
        {
            bAN = null;
        }
        if (bAL)
        {
            setImageDrawable(bAM);
            return;
        } else
        {
            setImageDrawable(bAN);
            return;
        }
    }

    private void _mth02CF(Context context, AttributeSet attributeset)
    {
        attributeset = context.obtainStyledAttributes(attributeset, xe.PsCheckButton, 0, 0);
        _mth02CA(context, attributeset.getResourceId(0, 0x7f0200d9), attributeset.getResourceId(2, 0x7f0c0035), attributeset.getResourceId(1, es()), attributeset.getResourceId(3, et()));
        attributeset.recycle();
        return;
        context;
        attributeset.recycle();
        throw context;
    }

    protected int es()
    {
        return 0x7f0200e3;
    }

    protected int et()
    {
        return 0x7f0c001c;
    }

    public void setChecked(boolean flag)
    {
        bAL = flag;
        if (bAL)
        {
            setImageDrawable(bAM);
            return;
        } else
        {
            setImageDrawable(bAN);
            return;
        }
    }
}
