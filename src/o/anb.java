// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            ada, aqo, xd, aqf, 
//            acy, ql, ane, zh, 
//            anc, and, zw

public class anb extends ada
    implements android.view.View.OnClickListener, asc.if
{

    private static long btE = 100L;
    private static String btF = "UserSearch";
    private aqf bdJ;
    private ane bqL;
    private and btG;
    private acy btH;
    private EditText btI;

    public anb()
    {
    }

    static long da()
    {
        return btE;
    }

    static Runnable _mth02CA(anb anb1)
    {
        return anb1.btG;
    }

    static EditText _mth02CB(anb anb1)
    {
        return anb1.btI;
    }

    static ApiManager _mth02CE(anb anb1)
    {
        return ApiManager.get(anb1);
    }

    static String _mth02EE()
    {
        return btF;
    }

    public final void du()
    {
        EditText edittext = btI;
        if (edittext != null)
        {
            ((InputMethodManager)edittext.getContext().getSystemService("input_method")).hideSoftInputFromWindow(edittext.getWindowToken(), 0);
        }
    }

    public void onBackPressed()
    {
        if (btH.aO())
        {
            btH.aN();
            return;
        } else
        {
            super.onBackPressed();
            overridePendingTransition(0x7f04000a, 0x7f04000f);
            return;
        }
    }

    public void onClick(View view)
    {
        view.getId();
        onBackPressed();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030078);
        getWindow().setBackgroundDrawable(null);
        bundle = (RecyclerView)findViewById(0x7f0d0067);
        bundle.setLayoutManager(new LinearLayoutManager(this));
        Object obj = xd._mth1FEA();
        bdJ = (aqf)findViewById(0x7f0d00a7);
        btH = new acy(this, ApiManager.get(this), ((zp) (obj)), bdJ, this);
        bdJ.setDelegate(btH);
        xd.getEventBus()._mth02CA(btH, false, 0);
        obj = new ane(this, new zh(((zp) (obj))), btH);
        bundle.setAdapter(((android.support.v7.widget.RecyclerView.if) (obj)));
        bqL = ((ane) (obj));
        bundle = (RelativeLayout)findViewById(0x7f0d004e);
        bundle.findViewById(0x7f0d00fa).setOnClickListener(this);
        obj = new anc(this);
        btI = (EditText)bundle.findViewById(0x7f0d0184);
        btI.addTextChangedListener(((android.text.TextWatcher) (obj)));
        btG = new and(this);
    }

    protected void onDestroy()
    {
        xd.getEventBus().unregister(btH);
        super.onDestroy();
    }

    public void onEventMainThread(zw zw1)
    {
        static final class _cls1
        {

            static final int bcB[];

            static 
            {
                bcB = new int[zw.values().length];
                try
                {
                    bcB[zw.aYE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
                try
                {
                    bcB[zw.aYx.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    bcB[zw.aYy.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    bcB[zw.aYz.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    bcB[zw.aYA.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    bcB[zw.aYN.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    bcB[zw.aYO.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    bcB[zw.aYG.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
            }
        }

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
            ((android.support.v7.widget.RecyclerView.if) (bqL)).ey.notifyChanged();
            break;
        }
    }

}
