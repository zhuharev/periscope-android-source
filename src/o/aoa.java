// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import java.util.Map;
import tv.periscope.android.api.ApiManager;
import tv.periscope.android.api.GetUserResponse;
import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            ada, acy, aqf, xd, 
//            ql, anh, zr, ash, 
//            zs, zp, adc, zu, 
//            zw

public class aoa extends ada
    implements android.view.View.OnClickListener
{

    private aqf bdJ;
    private anh buL;
    private acy buM;
    private String buN;
    private zp mUserManager;

    public aoa()
    {
    }

    public void onBackPressed()
    {
        if (buM.bdJ.buH)
        {
            acy acy1 = buM;
            if (acy1.bdJ.buH)
            {
                acy1.bdJ._mth02CB(null);
            }
            return;
        } else
        {
            super.onBackPressed();
            overridePendingTransition(0x7f04000a, 0x7f040010);
            return;
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131558656: 
            onBackPressed();
            break;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030094);
        getWindow().setBackgroundDrawable(null);
        mUserManager = xd._mth1FEA();
        bdJ = (aqf)findViewById(0x7f0d00a7);
        buM = new acy(this, ApiManager.get(this), mUserManager, bdJ);
        xd.getEventBus()._mth02CA(buM, false, 0);
        bdJ.setDelegate(buM);
        bundle = (RecyclerView)findViewById(0x7f0d0067);
        bundle.setLayoutManager(new LinearLayoutManager(this));
        Object obj = new anh(new zr(mUserManager), buM);
        bundle.setAdapter(((android.support.v7.widget.RecyclerView.if) (obj)));
        buL = ((anh) (obj));
        ash ash1 = (ash)findViewById(0x7f0d009c);
        ash1.findViewById(0x7f0d0100).setOnClickListener(this);
        Object obj1 = null;
        Object obj2 = null;
        Intent intent = getIntent();
        obj = obj1;
        bundle = obj2;
        if (intent != null)
        {
            Bundle bundle1 = intent.getExtras();
            obj = obj1;
            bundle = obj2;
            if (bundle1 != null)
            {
                obj1 = (zs)bundle1.getSerializable("e_user_type");
                String s = bundle1.getString("e_user_id");
                obj = s;
                bundle = ((Bundle) (obj1));
                if (!TextUtils.isEmpty(s))
                {
                    buL.btU._mth1550(s);
                    bundle = ((Bundle) (obj1));
                    obj = s;
                }
            }
        }
        obj1 = bundle;
        if (bundle == null)
        {
            obj1 = zs.aWX;
        }
        buL.btU._mth02CA(((zs) (obj1)));
        static final class _cls1
        {

            static final int $SwitchMap$tv$periscope$android$event$ApiEvent$Type[];
            static final int bcB[];
            static final int btC[];

            static 
            {
                $SwitchMap$tv$periscope$android$event$ApiEvent$Type = new int[zu.if.values().length];
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXu.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXx.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXq.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                bcB = new int[zw.values().length];
                try
                {
                    bcB[zw.aYE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    bcB[zw.aYx.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    bcB[zw.aYy.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    bcB[zw.aYz.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    bcB[zw.aYA.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    bcB[zw.aYD.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    bcB[zw.aYC.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    bcB[zw.aYN.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    bcB[zw.aYO.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    bcB[zw.aYP.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                btC = new int[zs.values().length];
                try
                {
                    btC[zs.aXc.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    btC[zs.aXd.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    btC[zs.aXb.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    btC[zs.aWX.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    btC[zs.aWY.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    btC[zs.aXa.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
            }
        }

        switch (_cls1.btC[((zs) (obj1)).ordinal()])
        {
        default:
            break;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            ash1.setTitle(0x7f06011c);
            break;

        case 4: // '\004'
            ash1.setTitle(0x7f0600d6);
            if (TextUtils.isEmpty(((CharSequence) (obj))))
            {
                ApiManager.get(this).getFollowers();
            } else
            {
                ApiManager.get(this).getFollowersById(((String) (obj)));
            }
            break;

        case 5: // '\005'
            ash1.setTitle(0x7f0600d7);
            if (TextUtils.isEmpty(((CharSequence) (obj))))
            {
                ApiManager.get(this).getFollowing();
            } else
            {
                ApiManager.get(this).getFollowingById(((String) (obj)));
            }
            break;

        case 6: // '\006'
            ash1.setTitle(0x7f06004c);
            ApiManager.get(this).getBlocked();
            break;
        }
        bundle = intent.getStringExtra("e_sheet_user_id");
        if (bundle != null)
        {
            PsUser psuser = (PsUser)mUserManager.aWM.get(bundle);
            if (psuser == null)
            {
                ApiManager.get(this).getUserById(bundle);
                buN = bundle;
                return;
            }
            buM._mth02CA(new adc(psuser.id, null));
            buN = null;
        }
    }

    protected void onDestroy()
    {
        xd.getEventBus().unregister(buM);
        super.onDestroy();
    }

    public void onEventMainThread(zu zu1)
    {
        switch (_cls1..SwitchMap.tv.periscope.android.event.ApiEvent.Type[zu1.aXk.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
            boolean flag;
            if (zu1.aXl == null && zu1.mU == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                ApiManager.get(this).getUser();
                return;
            }
            break;

        case 3: // '\003'
            zu1 = ((GetUserResponse)zu1.data).user;
            if (buN != null && buN.equals(((PsUser) (zu1)).id))
            {
                buM._mth02CA(new adc(((PsUser) (zu1)).id, null));
                buN = null;
            }
            break;
        }
    }

    public void onEventMainThread(zw zw1)
    {
        switch (_cls1.bcB[zw1.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
            buL.btU.A();
            break;
        }
        ((android.support.v7.widget.RecyclerView.if) (buL)).ey.notifyChanged();
    }
}
