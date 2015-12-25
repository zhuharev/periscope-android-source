// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import java.util.Random;
import java.util.UUID;

// Referenced classes of package o:
//            amp, aev, apb, auf, 
//            ahw, ahk, arm, aib, 
//            ams, aok, aiy, aip, 
//            xk

public class amr extends amp
    implements android.view.View.OnClickListener, aev
{
    static final class if
    {

        final String displayName;
        final String initials;
        final String profileImageUrl;
        final String userId;
        final String username;

        if(String s, String s1, String s2, String s3, String s4)
        {
            profileImageUrl = s;
            username = s1;
            displayName = s2;
            initials = s3;
            userId = s4;
        }
    }


    private boolean aVj;
    private Random bnU;
    private aib bsY;
    private ahw bsZ;
    private if bta[] = {
        new if("https://abs.twimg.com/sticky/default_profile_images/default_profile_0_200x200.png", "username1", "Display Name 1", "AB", "1"), new if("https://abs.twimg.com/sticky/default_profile_images/default_profile_3_200x200.png", "username2", "Display Name 2", "CD", "2")
    };
    final Handler btb = new Handler(Looper.getMainLooper());
    private ams btc;

    public amr()
    {
        aVj = true;
    }

    private void ds()
    {
        int i = bnU.nextInt(bta.length);
        Object obj = bta[i];
        obj = auf._mth02CA("", UUID.randomUUID().toString(), ((if) (obj)).username, ((if) (obj)).displayName, ((if) (obj)).initials, ((if) (obj)).userId, ((if) (obj)).profileImageUrl, Integer.valueOf(bnU.nextInt(100)), 0L, apb.ec().getTime());
        ahw ahw1 = bsZ;
        ahw1.bml._mth141D(((auf) (obj)));
        i = ahw1.bml.getItemCount();
        ahw1.bmk._mth1507(i - 1);
    }

    private void join()
    {
        int i = bnU.nextInt(bta.length);
        Object obj = bta[i];
        obj = auf._mth02CA("", ((if) (obj)).username, ((if) (obj)).displayName, ((if) (obj)).initials, ((if) (obj)).userId, ((if) (obj)).profileImageUrl, Integer.valueOf(bnU.nextInt(100)), 0L, apb.ec().getTime());
        ahw ahw1 = bsZ;
        ahw1.bml._mth141D(((auf) (obj)));
        i = ahw1.bml.getItemCount();
        ahw1.bmk._mth1507(i - 1);
    }

    static Random _mth02CA(amr amr1)
    {
        return amr1.bnU;
    }

    static void _mth02CB(amr amr1)
    {
        amr1.join();
    }

    static void _mth02CE(amr amr1)
    {
        amr1.ds();
    }

    protected final void dr()
    {
        setContentView(0x7f030039);
        findViewById(0x7f0d00c9).setOnClickListener(this);
        findViewById(0x7f0d00ca).setOnClickListener(this);
        findViewById(0x7f0d00cb).setOnClickListener(this);
        findViewById(0x7f0d0091).setOnClickListener(this);
        bsY = (aib)findViewById(0x7f0d00a3);
        bsZ = (ahw)findViewById(0x7f0d00a4);
        ahk ahk1 = new ahk(this, this, null);
        bsZ.setChatAdapter(ahk1);
        bnU = new Random();
        btc = new ams(this);
    }

    public final void onCancel()
    {
        aib aib1 = bsY;
        int i = aok._mth02CA(getResources(), bnU.nextInt(14));
        aix aix = aib1.bmJ.FB40(i);
        aib1.bmI._mth02CA(aix, aib1, true);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131558545: 
            view = bsY;
            int i = aok._mth02CA(getResources(), bnU.nextInt(14));
            aix aix = ((aib) (view)).bmJ.FB40(i);
            ((aib) (view)).bmI._mth02CA(aix, view, true);
            return;

        case 2131558602: 
            ds();
            return;

        case 2131558603: 
            join();
            return;

        case 2131558601: 
            break;
        }
        if (aVj)
        {
            ((TextView)view).setText("Pause");
            btb.postDelayed(btc, bnU.nextInt(1000));
        } else
        {
            ((TextView)view).setText("Auto");
            btb.removeCallbacks(btc);
        }
        boolean flag;
        if (!aVj)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        aVj = flag;
    }

    public final void _mth02CA(auf auf1, xk xk)
    {
    }
}
