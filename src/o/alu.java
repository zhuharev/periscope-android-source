// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

// Referenced classes of package o:
//            acp, xf, alk, apv, 
//            alv

public class alu extends acp
    implements android.view.View.OnClickListener, android.support.v4.view.ViewPager._cls02CF
{

    private static final int bsl[] = {
        0x7f020045, 0x7f020046, 0x7f020047, 0x7f020048
    };
    private static final int bsm[] = {
        0x7f060174, 0x7f060175, 0x7f060176, 0x7f060177
    };
    private apv bsn;
    private View bso;
    private int bsp;

    public alu()
    {
    }

    protected final String aI()
    {
        return "Walkthrough";
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131558700: 
            xf._mth02CA(xf.if.aRp);
            startActivity(new Intent(this, o/alk));
            finish();
            return;

        case 2131558851: 
            xf._mth02CA(xf.if.aRq);
            break;
        }
        startActivity(new Intent(this, o/alk));
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030097);
        findViewById(0x7f0d012c).setOnClickListener(this);
        bsn = (apv)findViewById(0x7f0d01c2);
        bsn.setOnPageChangeListener(this);
        bso = findViewById(0x7f0d01c3);
        bso.setOnClickListener(this);
        boolean flag;
        if (getResources().getConfiguration().getLayoutDirection() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        int ai[];
        byte byte0;
        if (flag)
        {
            bundle = new int[4];
            ai = bsl;
            int k = ai.length - 1;
            for (int i = 0; k >= 0; i++)
            {
                bundle[i] = ai[k];
                k--;
            }

            ai = new int[4];
            int ai1[] = bsm;
            k = ai1.length - 1;
            for (int j = 0; k >= 0; j++)
            {
                ai[j] = ai1[k];
                k--;
            }

            byte0 = 3;
            bsp = 0;
        } else
        {
            bundle = bsl;
            ai = bsm;
            byte0 = 0;
            bsp = 3;
        }
        bundle = new alv(this, bundle, ai);
        ViewPager viewpager = (ViewPager)findViewById(0x7f0d0116);
        viewpager.setAdapter(bundle);
        viewpager.setOnPageChangeListener(bsn);
        viewpager.setCurrentItem(byte0);
    }

    public final void _mth02CA(int i, float f, int j)
    {
    }

    public final void _mth0640(int i)
    {
        if (i == bsp)
        {
            bso.setVisibility(0);
            bsn.setVisibility(8);
            return;
        } else
        {
            bso.setVisibility(8);
            bsn.setVisibility(0);
            return;
        }
    }

    public final void _mth1427(int i)
    {
    }

}
