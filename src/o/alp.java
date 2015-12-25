// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.Collection;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            ada, asm, alq, aqt, 
//            aop, aqs, aqo, xd, 
//            aqf, acy, ql, zj, 
//            zu, zp, adc, auf

public class alp extends ada
    implements asm, android.view.View.OnClickListener
{

    private aqf bdJ;
    private acy bpx;
    private ProgressDialog brR;
    private aqt bsd;
    private aqs bse;
    private zj bsf;
    private alq bsg;
    private View bsh;
    private View bsi;
    private zp mUserManager;

    public alp()
    {
    }

    private void di()
    {
        alq alq1 = bsg;
        if (alq1.dk())
        {
            bsd.setChecked(true);
        } else
        {
            bsd.setChecked(false);
        }
        int i = alq1.bsj.dl().size();
        if (i == 1)
        {
            bse.setText(getString(0x7f060117));
            return;
        } else
        {
            bse.setText(getString(0x7f060116, new Object[] {
                Integer.valueOf(i)
            }));
            return;
        }
    }

    protected final String aI()
    {
        return "Onboarding";
    }

    public final void aN()
    {
    }

    public final boolean aO()
    {
        return bpx.aO();
    }

    public void onBackPressed()
    {
        if (bpx.aO())
        {
            bpx.aN();
            return;
        } else
        {
            setResult(-1);
            super.onBackPressed();
            return;
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131558790: 
            if (bsd.bAL)
            {
                bsg.bsj.dj();
            } else
            {
                bsg.selectAll();
            }
            ((android.support.v7.widget.RecyclerView.if) (bsg)).ey.notifyChanged();
            di();
            return;

        case 2131558700: 
            onBackPressed();
            return;

        case 2131558701: 
            view = bsg.bsj.dl();
            break;
        }
        if (!view.isEmpty())
        {
            ApiManager.get(this).followAll(view);
            brR = new ProgressDialog(this);
            brR.setMessage(getString(0x7f060118));
            brR.setIndeterminate(true);
            brR.setCancelable(false);
            brR.show();
            return;
        } else
        {
            setResult(-1);
            finish();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mUserManager = xd._mth1FEA();
        setContentView(0x7f030069);
        bsh = findViewById(0x7f0d0129);
        bsi = findViewById(0x7f0d011b);
        bdJ = (aqf)findViewById(0x7f0d00a7);
        bpx = new acy(this, ApiManager.get(this), mUserManager, bdJ);
        xd.getEventBus()._mth02CA(bpx, false, 0);
        bdJ.setDelegate(bpx);
        bundle = (RecyclerView)findViewById(0x7f0d0067);
        bundle.setLayoutManager(new LinearLayoutManager(this));
        bsf = new zj(mUserManager);
        alq alq1 = new alq(this, bsf, this);
        bsg = alq1;
        bundle.setAdapter(alq1);
        bsd = (aqt)findViewById(0x7f0d0186);
        bsd.setOnClickListener(this);
        bse = (aqs)findViewById(0x7f0d012d);
        bse.setOnClickListener(this);
        di();
        findViewById(0x7f0d012c).setOnClickListener(this);
        ApiManager.get(this).getSuggestedPeopleForOnboarding();
        getSharedPreferences("onboarding", 0).edit().putBoolean("shown", true).apply();
    }

    protected void onDestroy()
    {
        xd.getEventBus().unregister(bpx);
        super.onDestroy();
    }

    public void onEventMainThread(zu zu1)
    {
        static final class _cls1
        {

            static final int $SwitchMap$tv$periscope$android$event$ApiEvent$Type[];

            static 
            {
                $SwitchMap$tv$periscope$android$event$ApiEvent$Type = new int[zu.if.values().length];
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXH.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXA.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
            }
        }

        switch (_cls1..SwitchMap.tv.periscope.android.event.ApiEvent.Type[zu1.aXk.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            brR.dismiss();
            mUserManager.D();
            ApiManager.get(this).getSuggestedPeople();
            setResult(-1);
            finish();
            return;

        case 2: // '\002'
            break;
        }
        if (bsf.v() == 0)
        {
            setResult(-1);
            finish();
            return;
        } else
        {
            bsi.setVisibility(8);
            bsh.setVisibility(0);
            bsg.selectAll();
            ((android.support.v7.widget.RecyclerView.if) (bsg)).ey.notifyChanged();
            di();
            return;
        }
    }

    public final void _mth02CA(String s, String s1, String s2, String s3, auf auf)
    {
    }

    public final volatile void _mth1D65(Object obj)
    {
        obj = (adc)obj;
        bpx._mth1D65(obj);
    }

    public final void _mth4E36(String s)
    {
        bsg.bsj._mth1646(s);
        ((android.support.v7.widget.RecyclerView.if) (bsg)).ey.notifyChanged();
        di();
    }

    public final void FB54(String s)
    {
    }

    public final void FB60(String s)
    {
    }

    public final void FBE6(String s)
    {
        bsg.bsj._mth1646(s);
        ((android.support.v7.widget.RecyclerView.if) (bsg)).ey.notifyChanged();
        di();
    }

    public final void FBE9(String s)
    {
    }

    public final void FBFE(String s)
    {
        bpx.FBFE(s);
    }

    public final void FE70(String s)
    {
    }

    public final void FE97(String s)
    {
    }
}
