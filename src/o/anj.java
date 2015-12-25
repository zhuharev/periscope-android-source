// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.ActionMode;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            ada, zp, yv, zc, 
//            aig, aco, aii, arm, 
//            ash, xd, aih, zu, 
//            ank

public class anj extends ada
    implements android.view.View.OnClickListener
{
    final class if
        implements aig._cls02CA
    {

        aig.if bmZ;
        int bua;
        ActionMode bub;
        TextView buc;
        private ank bud;
        final anj bue;

        public final boolean cs()
        {
            if (bub != null)
            {
                buc.setText(String.valueOf(bmZ.bnd.size()));
                return true;
            } else
            {
                bub = bue.startActionMode(bud);
                bua = anj._mth02CB(bue);
                anj._mth02CB(bue, bue.getResources().getColor(0x7f0c0038));
                return true;
            }
        }

        public final boolean ct()
        {
            if (bub == null)
            {
                return false;
            }
            if (bmZ.bnd.size() == 0)
            {
                bub.finish();
            } else
            {
                buc.setText(String.valueOf(bmZ.bnd.size()));
            }
            return true;
        }

        public final void _mth02CA(aig.if if1)
        {
            bmZ = if1;
        }

        private if()
        {
            bue = anj.this;
            super();
            bud = new ank(this);
        }

        if(byte byte0)
        {
            this();
        }
    }


    private aig bnf;
    private arm bsX;
    private if btY;
    private aii btZ;
    private yv mBroadcastCacheManager;
    private zp mUserManager;

    public anj()
    {
        btY = new if((byte)0);
    }

    private void dw()
    {
        if (bnf != null)
        {
            return;
        }
        Object obj = mBroadcastCacheManager;
        String s = mUserManager.aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVC").get(null), null);
        obj = (zc)((yv) (obj)).aWh.get(s);
        if (obj != null)
        {
            bnf = new aig(this, ((zc) (obj)));
            bnf.bmX = new aco(this);
            bnf._mth02CA(btY);
            btZ = new aii(bnf);
            obj = bnf.bmU;
            aii aii1 = btZ;
            ((zc) (obj)).aWu.add(aii1);
            bsX.setAdapter(bnf);
        }
    }

    static ApiManager _mth02CA(anj anj1)
    {
        return ApiManager.get(anj1);
    }

    static void _mth02CA(anj anj1, int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            anj1.getWindow().setStatusBarColor(i);
        }
    }

    static int _mth02CB(anj anj1)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            return anj1.getWindow().getStatusBarColor();
        } else
        {
            return anj1.getResources().getColor(0x7f0c005a);
        }
    }

    static void _mth02CB(anj anj1, int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            anj1.getWindow().setStatusBarColor(i);
        }
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        overridePendingTransition(0x7f04000a, 0x7f040010);
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
        setContentView(0x7f030090);
        getWindow().setBackgroundDrawable(null);
        bundle = (ash)findViewById(0x7f0d009c);
        bundle.setTitle(0x7f060170);
        bundle.findViewById(0x7f0d0100).setOnClickListener(this);
        mBroadcastCacheManager = xd._mth216D();
        mUserManager = xd._mth1FEA();
        bsX = (arm)findViewById(0x7f0d0067);
        bsX.setHasFixedSize(true);
        bsX.setLayoutManager(new LinearLayoutManager(this));
        bsX._mth02CA(new aih(getResources().getDimensionPixelOffset(0x7f09005b)));
        dw();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (bnf != null)
        {
            zc zc1 = bnf.bmU;
            aii aii1 = btZ;
            zc1.aWu.remove(aii1);
        }
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
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aYi.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (_cls1..SwitchMap.tv.periscope.android.event.ApiEvent.Type[zu1.aXk.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            dw();
            break;
        }
    }
}
