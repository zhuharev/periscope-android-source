// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            ada, ajl, asb, adc, 
//            aqo, aui, aka, akt, 
//            arx, aqf, acy, xd, 
//            apq, aig, yv, aij, 
//            ajm, aje, _cls0993, akk, 
//            aos, aki, ake, ajn, 
//            ajj, akp, arz, aqe, 
//            ary, akc, apb, FF6A, 
//            zu, abb, ql, afg, 
//            aco, ajo, atn, afh

public class ajk extends ada
    implements android.view.View.OnClickListener, aig._cls02CF, android.view.View.OnLongClickListener, aig._cls02CE
{
    static interface if
    {

        public abstract void cU();

        public abstract void cV();

        public abstract void cW();
    }

    /* member class not found */
    class _cls02CA {}


    private afg bpA;
    private final ajl bpB = new ajl(this);
    private final SparseIntArray bpn = new SparseIntArray();
    private ViewPager bpo;
    private List bpp;
    private View bpq;
    private View bpr;
    private ImageView bps;
    private _cls02CA bpt;
    private ImageView bpu;
    private ArrayList bpv;
    private arx bpw;
    private acy bpx;
    private apq bpy;
    private akc bpz;

    public ajk()
    {
        bpv = new ArrayList();
    }

    private boolean cT()
    {
        for (Iterator iterator = bpv.iterator(); iterator.hasNext();)
        {
            asb asb1 = (asb)iterator.next();
            if (asb1.isShowing())
            {
                asb1.hide();
                return true;
            }
        }

        return false;
    }

    static List _mth02BB(ajk ajk1)
    {
        return ajk1.bpp;
    }

    static View _mth02BC(ajk ajk1)
    {
        return ajk1.bpr;
    }

    static ImageView _mth02BD(ajk ajk1)
    {
        return ajk1.bpu;
    }

    static afg _mth02CA(ajk ajk1, afg afg1)
    {
        ajk1.bpA = null;
        return null;
    }

    static void _mth02CA(ajk ajk1, int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            ajk1.getWindow().setStatusBarColor(i);
        }
    }

    static void _mth02CB(ajk ajk1, int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            ajk1.getWindow().setStatusBarColor(i);
        }
    }

    static ViewPager _mth02CE(ajk ajk1)
    {
        return ajk1.bpo;
    }

    static _cls02CA _mth02CF(ajk ajk1)
    {
        return ajk1.bpt;
    }

    static View _mth037A(ajk ajk1)
    {
        return ajk1.bpq;
    }

    static boolean _mth141D(ajk ajk1)
    {
        return ajk1.cT();
    }

    static ImageView _mth1FBE(ajk ajk1)
    {
        return ajk1.bps;
    }

    private void _mth1FBE(Intent intent)
    {
        Bundle bundle = intent.getExtras();
        if (bundle != null && bundle.containsKey("e_show_user"))
        {
            intent = bundle.getString("e_show_user");
            bpx._mth1D65(new adc(null, intent));
            return;
        }
        intent = intent.getData();
        if (intent != null)
        {
            intent = intent.getPathSegments();
            if (intent != null && intent.size() > 0)
            {
                String s = (String)intent.get(0);
                if (aui._mth02BF(s))
                {
                    intent = s;
                    if (s.startsWith("@"))
                    {
                        intent = s.substring(1, s.length());
                    }
                    bpx._mth1D65(new adc(null, intent));
                }
            }
        }
    }

    protected final String aI()
    {
        if (bpo != null)
        {
            int i = bpo._fld025F;
            return (new StringBuilder("Main Activity: Tab ")).append(i).toString();
        } else
        {
            return "Main Activity";
        }
    }

    public final void cu()
    {
        _cls02CA _lcls02ca = bpt;
        int i = bpn.get(0x7f0d0113);
        _lcls02ca.bpG.set(i);
        _lcls02ca.bpC.bpo.setCurrentItem(i);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        switch (i)
        {
        default:
            return;

        case 7854: 
            switch (j)
            {
            default:
                return;

            case -1: 
                break;
            }
            break;
        }
        if (intent != null && "action_logout".equals(intent.getAction()))
        {
            finish();
        }
    }

    public void onBackPressed()
    {
        if (cT())
        {
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131558673 2131558679: default 48
    //                   2131558673 49
    //                   2131558674 49
    //                   2131558675 49
    //                   2131558676 49
    //                   2131558677 187
    //                   2131558678 260
    //                   2131558679 138;
           goto _L1 _L2 _L2 _L2 _L2 _L3 _L4 _L5
_L4:
        break; /* Loop/switch isn't completed */
_L1:
        return;
_L2:
        int i;
        int k;
        k = view.getId();
        i = 0;
_L10:
        if (i >= bpp.size()) goto _L7; else goto _L6
_L6:
        if (((aka)bpp.get(i)).cv().getId() != k) goto _L9; else goto _L8
_L9:
        i++;
          goto _L10
_L7:
        i = -1;
_L8:
        if (i != -1)
        {
            view = bpt;
            ((_cls02CA) (view)).bpG.set(i);
            ((_cls02CA) (view)).bpC.bpo.setCurrentItem(i);
            return;
        }
        break; /* Loop/switch isn't completed */
_L5:
        view = ((aka)bpp.get(bpo._fld025F))._mth02CA(this);
        if (view != null)
        {
            startActivity(view, ActivityOptions.makeCustomAnimation(this, 0x7f04000d, 0x7f04000c).toBundle());
            return;
        }
        break; /* Loop/switch isn't completed */
_L3:
        cT();
        int j = bpo._fld025F;
        view = (aka)bpp.get(j);
        Intent intent = view._mth02CB(this);
        if (intent != null)
        {
            startActivityForResult(intent, 7854, ActivityOptions.makeCustomAnimation(this, 0x7f04000e, 0x7f04000c).toBundle());
        }
        bpu.setImageResource(view.cD());
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030056);
        getWindow().setBackgroundDrawable(null);
        bundle = ApiManager.get(this);
        bundle.getBlocked();
        bpw = (arx)findViewById(0x7f0d0091);
        bpq = findViewById(0x7f0d009c);
        Object obj = (aqf)findViewById(0x7f0d00a7);
        bpx = new acy(this, bundle, xd._mth1FEA(), ((aqf) (obj)));
        ((aqf) (obj)).setDelegate(bpx);
        bpv.add(obj);
        bpy = (apq)findViewById(0x7f0d0119);
        bpv.add(bpy);
        Object obj1 = xd._mth216D();
        ApiManager apimanager = ApiManager.get(this);
        zp zp = xd._mth1FEA();
        aig aig1 = new aig(this, ((yv) (obj1)).aWd, new aij(((yv) (obj1)), false, true));
        aig1.bmY = this;
        aig1.bmW = this;
        obj = new ArrayList();
        ((List) (obj)).add(new ajm(this, this, xd.getEventBus(), apimanager, aig1, new aje(apimanager, ((yv) (obj1)), ((yv) (obj1)).aWd, 0L), "watch list", bpx, (akt)findViewById(0x7f0d0111), 0x7f0c005c, 0x7f0c005d, 0x7f0c005a, 0x7f0c005b, 0x7f0c00a4, 0x7f020068, 0x7f0200d4, 0, 0, 0));
        boolean flag;
        if (_cls0993._mth1D4E(this) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            aig1 = new aig(this, ((yv) (obj1)).aWf, new aij(((yv) (obj1)), true, false));
            aig1.bmY = this;
            aig1.bmW = this;
            akk akk1 = new akk(bpw, bpy, aig1, ((yv) (obj1)));
            ql ql1 = xd.getEventBus();
            yv._cls02CE _lcls02ce = ((yv) (obj1)).aWf;
            Point point = aos._mth02B2(this);
            int i = getResources().getDimensionPixelOffset(0x7f09008e);
            int l = getResources().getDimensionPixelOffset(0x7f0900aa);
            float f = point.y;
            float f1 = point.y;
            ((List) (obj)).add(new aki(this, ql1, apimanager, aig1, new ake(this, apimanager, ((yv) (obj1)), _lcls02ce, 1000L, akk1, new RectF(i, i * 2 + l, point.x - i, f - f1 * 0.4F - (float)i), bpB), "map", bpx, (akt)findViewById(0x7f0d0112), 0x7f0c004b, 0x7f0c004c, 0x7f0c0049, 0x7f0c004a, 0x7f0c00a4, 0x7f020068, 0x7f0200d4, 0, 0, 0));
        } else
        {
            ((ViewGroup)findViewById(0x7f0d0110)).removeView(findViewById(0x7f0d0112));
        }
        aig1 = new aig(this, ((yv) (obj1)).aWe);
        aig1.bmY = this;
        ((List) (obj)).add(new ajn(this, this, xd.getEventBus(), apimanager, aig1, new ajj(apimanager, ((yv) (obj1)), ((yv) (obj1)).aWe, 1000L), "global list", bpx, (akt)findViewById(0x7f0d0113), 0x7f0c004b, 0x7f0c004c, 0x7f0c0049, 0x7f0c004a, 0x7f0c00a4, 0x7f020068, 0x7f0200d4, 0, 0, 0));
        ((List) (obj)).add(new akp(this, xd.getEventBus(), apimanager, zp, "people", bpx, (akt)findViewById(0x7f0d0114), 0x7f0c005c, 0x7f0c005d, 0x7f0c005a, 0x7f0c005b, 0x7f0c0013, 0x7f02006b, 0x7f020020, 0, 0x7f0200fb, 0x7f06006d));
        aka aka1;
        for (obj1 = ((List) (obj)).iterator(); ((Iterator) (obj1)).hasNext(); aka1.cv().setOnLongClickListener(this))
        {
            aka1 = (aka)((Iterator) (obj1)).next();
            aka1.cv().setOnClickListener(this);
            aka1.cv().setLongClickable(true);
        }

        bpp = ((List) (obj));
        if (getResources().getConfiguration().getLayoutDirection() == 1)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i)
        {
            Collections.reverse(bpp);
        }
        int i1 = bpp.size();
        for (int j = 0; j < i1; j++)
        {
            bpn.put(((aka)bpp.get(j)).cv().getId(), j);
        }

        obj1 = (arz)findViewById(0x7f0d0110);
        obj = new aqe();
        obj1 = new ary(((arz) (obj1)));
        ((aqe) (obj)).bzU.add(obj1);
        obj1 = new _cls02CA((byte)0);
        ((aqe) (obj)).bzU.add(obj1);
        bpt = ((_cls02CA) (obj1));
        bpo = (ViewPager)findViewById(0x7f0d0116);
        bpo.setOverScrollMode(2);
        bpo.setOffscreenPageLimit(bpp.size());
        bpz = new akc(bpp, ((aqe) (obj)));
        bpo.setAdapter(bpz);
        bpo.setOnPageChangeListener(((android.support.v4.view.ViewPager._cls02CF) (obj)));
        bpr = findViewById(0x7f0d0117);
        bpr.setOnClickListener(this);
        bps = (ImageView)findViewById(0x7f0d0118);
        bpu = (ImageView)findViewById(0x7f0d0115);
        bpu.setOnClickListener(this);
        bpu.setOnLongClickListener(this);
        FF6A._mth02CB("RTMP", (new StringBuilder("Initial time: ")).append(apb.ec().getTime()).toString());
        obj = getIntent().getStringExtra("e_tab");
        int k;
        if (obj != null)
        {
            k = -1;
            switch (((String) (obj)).hashCode())
            {
            case -1243020381: 
                if (((String) (obj)).equals("global"))
                {
                    k = 0;
                }
                break;

            case 3343801: 
                if (((String) (obj)).equals("main"))
                {
                    k = 2;
                }
                break;
            }
            switch (k)
            {
            case 0: // '\0'
                k = bpn.get(0x7f0d0112);
                break;

            default:
                k = bpn.get(0x7f0d0111);
                break;
            }
        } else
        {
            k = bpn.get(0x7f0d0111);
        }
        obj = (aka)bpp.get(k);
        ((_cls02CA) (obj1))._mth02BB(((aka) (obj)));
        ((_cls02CA) (obj1))._mth141D(((aka) (obj)));
        obj1.bpP = ((aka) (obj)).cA();
        obj1.bpQ = ((aka) (obj)).cD();
        ((_cls02CA) (obj1)).bpG.set(k);
        ((_cls02CA) (obj1)).bpC.bpo.setCurrentItem(k);
        if (k == 0)
        {
            ((_cls02CA) (obj1))._mth0640(k);
        }
        _mth1FBE(getIntent());
        bundle.supportedLanguages();
    }

    protected void onDestroy()
    {
        for (Iterator iterator = bpz.bpp.iterator(); iterator.hasNext(); ((aka)iterator.next()).cP().destroy()) { }
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
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXY.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (_cls1..SwitchMap.tv.periscope.android.event.ApiEvent.Type[zu1.aXk.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            break;
        }
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
            zu1 = (String[])zu1.data;
            if (zu1 != null)
            {
                (new abb(this))._mth02BB(zu1);
            }
        }
    }

    public boolean onLongClick(View view)
    {
        switch (view.getId())
        {
        case 2131558673: 
            int ai[] = new int[2];
            view.getLocationOnScreen(ai);
            ai[1] = ai[1] + view.getHeight() / 2;
            view = Toast.makeText(this, 0x7f060070, 0);
            view.setGravity(51, ai[0], ai[1]);
            view.show();
            return true;

        case 2131558674: 
            int ai1[] = new int[2];
            view.getLocationOnScreen(ai1);
            ai1[1] = ai1[1] + view.getHeight() / 2;
            view = Toast.makeText(this, 0x7f060071, 0);
            view.setGravity(51, ai1[0], ai1[1]);
            view.show();
            return true;

        case 2131558675: 
            int ai2[] = new int[2];
            view.getLocationOnScreen(ai2);
            ai2[1] = ai2[1] + view.getHeight() / 2;
            view = Toast.makeText(this, 0x7f06006a, 0);
            view.setGravity(51, ai2[0], ai2[1]);
            view.show();
            return true;

        case 2131558676: 
            int ai3[] = new int[2];
            view.getLocationOnScreen(ai3);
            ai3[1] = ai3[1] + view.getHeight() / 2;
            view = Toast.makeText(this, 0x7f06006c, 0);
            view.setGravity(51, ai3[0], ai3[1]);
            view.show();
            return true;

        case 2131558677: 
            int i = bpo._fld025F;
            i = ((aka)bpp.get(i)).cE();
            if (i != 0)
            {
                int ai4[] = new int[2];
                view.getLocationOnScreen(ai4);
                ai4[1] = ai4[1] + view.getHeight() / 2;
                view = Toast.makeText(this, i, 0);
                view.setGravity(0x800035, 0, ai4[1]);
                view.show();
            }
            return true;
        }
        return false;
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        _mth1FBE(intent);
    }

    protected void onPause()
    {
        for (Iterator iterator = bpz.bpp.iterator(); iterator.hasNext(); ((aka)iterator.next()).cP().pause()) { }
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        for (Iterator iterator = bpz.bpp.iterator(); iterator.hasNext(); ((aka)iterator.next()).cP().resume()) { }
    }

    protected void onStart()
    {
        super.onStart();
        xd.getEventBus()._mth02CA(bpx, false, 0);
    }

    protected void onStop()
    {
        xd.getEventBus().unregister(bpx);
        super.onStop();
    }

    public final void _mth02BD(atn atn1)
    {
        bpA = new afg(this, atn1, new aco(this), new ajo(this));
        afg afg1 = bpA;
        if (afg1.biv == null)
        {
            Context context = afg1.mContext;
            atn atn2 = afg1.bis;
            View view = LayoutInflater.from(context).inflate(0x7f030049, null);
            atn1 = (TextView)view.findViewById(0x7f0d007e);
            TextView textview = (TextView)view.findViewById(0x7f0d0037);
            TextView textview1 = (TextView)view.findViewById(0x7f0d00fd);
            Button button = (Button)view.findViewById(0x7f0d00ab);
            atn1.setText(atn2.fh());
            String s = atn2.eS();
            atn1 = s;
            if (TextUtils.isEmpty(s))
            {
                atn1 = context.getResources().getString(0x7f06016f);
            }
            textview.setText(atn1);
            textview1.setText(atn2.eY());
            button.setOnClickListener(new afh(afg1, atn2));
            atn1 = (new android.app.AlertDialog.Builder(context)).setView(view).setCancelable(true).setOnDismissListener(afg1.biu).create();
            atn1.getWindow().getAttributes().windowAnimations = 0x7f0a00ca;
            afg1.biv = atn1;
        }
        if (!afg1.biv.isShowing())
        {
            afg1.biv.show();
        }
    }
}
