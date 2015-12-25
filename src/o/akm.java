// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.util.AttributeSet;

// Referenced classes of package o:
//            FE79, akn

public class akm extends FE79
    implements akn
{

    private boolean bqI;

    public akm(Context context)
    {
        super(context);
        bqI = true;
    }

    public akm(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        bqI = true;
    }

    public void setRefreshable(boolean flag)
    {
        bqI = flag;
    }

    public final boolean _mth1D59()
    {
        return !bqI || super._mth1D59();
    }
}
