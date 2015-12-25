// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Handler;
import android.view.View;

// Referenced classes of package o:
//            aed, aib, ahw, xw

final class aem
    implements arx._cls02CB
{

    private aed bhH;

    aem(aed aed1)
    {
        bhH = aed1;
        super();
    }

    public final void _mth02BF(View view, float f)
    {
        if (view.getId() == 0x7f0d0095)
        {
            aed._mth141D(bhH).setAlpha(1.0F - f);
            aed._mth02BB(bhH).setRotation(180F * f);
            return;
        } else
        {
            aed._mth02BC(bhH).setAlpha(1.0F - f);
            aed._mth02BD(bhH).setAlpha(1.0F - f);
            return;
        }
    }

    public final void _mth037A(View view, int i)
    {
        if (view.getId() == 0x7f0d0095 && i == 1)
        {
            aed._mth02CF(bhH).removeCallbacks(aed._mth02CE(bhH));
        }
    }

    public final void _mth05D5(View view)
    {
        int i = view.getId();
        switch (i)
        {
        default:
            return;

        case 2131558566: 
        case 2131558569: 
            aed._mth037A(bhH);
            break;
        }
        if (i == 0x7f0d00a6 && aed._mth1FBE(bhH))
        {
            aed._mth02BF(bhH)._mth02CB(aed._mth02BE(bhH));
        }
    }

    public final void _mth06E6(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131558549: 
            aed._mth02C8(bhH);
            return;

        case 2131558566: 
        case 2131558569: 
            aed._mth02CB(bhH);
            break;
        }
    }
}
