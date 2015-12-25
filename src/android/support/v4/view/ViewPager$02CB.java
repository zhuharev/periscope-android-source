// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

// Referenced classes of package android.support.v4.view:
//            ViewPager

public static final class er extends android.view.tParams
{

    public int gravity;
    int position;
    float FB65;
    public boolean FE71;
    boolean FE80;
    int FEAA;

    public ()
    {
        super(-1, -1);
        FB65 = 0.0F;
    }

    public FB65(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        FB65 = 0.0F;
        context = context.obtainStyledAttributes(attributeset, ViewPager._mth1D57());
        gravity = context.getInteger(0, 48);
        context.recycle();
    }
}
