// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import java.util.ArrayList;

// Referenced classes of package o:
//            amp, atn, ato, yv, 
//            ql, aig, arm, aih

public class amq extends amp
{

    private aig bnf;
    private arm bsX;
    private yv mBroadcastCacheManager;

    public amq()
    {
    }

    private static ArrayList _mth02CA(int i, boolean flag, boolean flag1, String s)
    {
        ArrayList arraylist = new ArrayList(i);
        for (int j = 0; j < i; j++)
        {
            long l = System.currentTimeMillis();
            Object obj = (new StringBuilder()).append(s).append(" ").append(j).toString();
            String s1 = (new StringBuilder("User ")).append(j).toString();
            obj = atn.gl().FEE8(((String) (obj))).FF68(((String) (obj)))._mth02E1(l)._mth03B9(flag1)._mth026A(s1)._mth029F(s1).fn();
            int k;
            if (flag)
            {
                k = ato.bEd;
            } else
            {
                k = ato.bEf;
            }
            obj.bDW = k;
            boolean flag2;
            if (!flag && j % 2 == 0)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            obj.bDX = flag2;
            arraylist.add(obj);
        }

        return arraylist;
    }

    protected final void dr()
    {
        setContentView(0x7f03008e);
        Intent intent = getIntent();
        int i = intent.getIntExtra("featured_count", 0);
        int j = intent.getIntExtra("following_count", 0);
        int k = intent.getIntExtra("live_count", 0);
        intent.getIntExtra("live_large_limit", -1);
        mBroadcastCacheManager = new yv(new ql());
        mBroadcastCacheManager._mth02CA(_mth02CA(i, false, true, "FEATURED BROADCAST"), _mth02CA(j, false, false, "FOLLOWING BROADCAST"), _mth02CA(k, true, false, "LIVE BROADCAST"));
        bnf = new aig(this, mBroadcastCacheManager.aWd);
        bsX = (arm)findViewById(0x7f0d01a8);
        bsX.setHasFixedSize(true);
        bsX.setLayoutManager(new LinearLayoutManager(this));
        bsX._mth02CA(new aih(getResources().getDimensionPixelOffset(0x7f09005b)));
        bsX.setAdapter(bnf);
    }
}
