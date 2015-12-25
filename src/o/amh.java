// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.util.Linkify;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            ada, ami, _cls1D3C, zp, 
//            _cls1D5A, _cls1D27, _cls1647, aui, 
//            aos, zf, zv, aoa, 
//            ql, xf, zs, adb, 
//            add, acs, acu, anj, 
//            amy, aly, xd, yo, 
//            qn, amj, zu, zw

public class amh extends ada
    implements android.view.View.OnClickListener
{

    private static long bsF = 0L;
    private View beI;
    private ImageView beU;
    private ImageView bsG;
    private TextView bsH;
    private TextView bsI;
    private TextView bsJ;
    private TextView bsK;
    private TextView bsL;
    private TextView bsM;
    private TextView bsN;
    private TextView bsO;
    private boolean bsP;
    private final ami bsQ = new ami(this);
    private ql mLocalEventBus;
    private zf mProfileManager;
    private zp mUserManager;

    public amh()
    {
    }

    private void dn()
    {
        Object obj = mUserManager;
        _cls1D5A _lcls1d5a = _cls1D3C._mth02CA(this);
        String s = ((zp) (obj)).E();
        ((_cls1D27)_lcls1d5a._mth02CA(java/lang/String).FF70(s))._mth02CA(beU);
        _lcls1d5a = _cls1D3C._mth02CA(this);
        s = ((zp) (obj)).E();
        ((_cls1D27)_lcls1d5a._mth02CA(java/lang/String).FF70(s))._mth05D5(0x7f0c00a4)._mth02CA(bsG);
        bsH.setText(((zp) (obj)).aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVD").get(null), null));
        bsI.setText(getString(0x7f060171, new Object[] {
            ((zp) (obj)).aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVB").get(null), null)
        }));
        if (mUserManager.aQC.getBoolean((String)yp.CON._mth02CA("o.yp").getField("aVO").get(null), false))
        {
            beI.setVisibility(0);
        } else
        {
            beI.setVisibility(8);
        }
        obj = ((zp) (obj)).aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVF").get(null), null);
        if (aui._mth02BF(((CharSequence) (obj))))
        {
            bsJ.setVisibility(0);
            bsJ.setText(((CharSequence) (obj)));
            bsJ.setLinkTextColor(getResources().getColor(0x7f0c005a));
            Linkify.addLinks(bsJ, 7);
        } else
        {
            bsJ.setVisibility(8);
        }
        _mthdo();
    }

    private void _mthdo()
    {
        Resources resources = getResources();
        bsK.setText(aos._mth02CA(resources, mUserManager.aQC.getInt((String)yp.CON._mth02CA("o.yp").getField("aVH").get(null), 0), true));
        bsL.setText(aos._mth02CA(resources, mUserManager.aQC.getInt((String)yp.CON._mth02CA("o.yp").getField("aVG").get(null), 0), true));
        bsO.setText(aos._mth02CA(resources, mUserManager.aQC.getInt((String)yp.CON._mth02CA("o.yp").getField("aVK").get(null), 1), false));
        bsM.setText(aos._mth02CA(getResources(), mUserManager.aQC.getInt((String)yp.CON._mth02CA("o.yp").getField("aVI").get(null), 0), true));
        bsN.setText(aos._mth02CA(getResources(), mProfileManager.aQC.getInt((String)yp.CON._mth02CA("o.yp").getField("aVJ").get(null), 0), false));
    }

    private void dp()
    {
        bsN.setText(aos._mth02CA(getResources(), mProfileManager.aQC.getInt((String)yp.CON._mth02CA("o.yp").getField("aVJ").get(null), 0), false));
    }

    private void dq()
    {
        bsM.setText(aos._mth02CA(getResources(), mUserManager.aQC.getInt((String)yp.CON._mth02CA("o.yp").getField("aVI").get(null), 0), true));
    }

    static void _mth02CA(amh amh1)
    {
        bsF = 0L;
        amh1._mth02CA(zv.aYp);
    }

    static ImageView _mth02CB(amh amh1)
    {
        return amh1.beU;
    }

    private void _mth02CB(zs zs1)
    {
        startActivity((new Intent(this, o/aoa)).putExtra("e_user_type", zs1), ActivityOptions.makeCustomAnimation(this, 0x7f04000e, 0x7f04000c).toBundle());
    }

    static ImageView _mth02CE(amh amh1)
    {
        return amh1.bsG;
    }

    protected final String aI()
    {
        return "Profile";
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        switch (i)
        {
        case 19328: 
            if (j == -1)
            {
                bsH.setText(mUserManager.aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVD").get(null), null));
                bsJ.setText(mUserManager.aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVF").get(null), null));
                if (intent != null && intent.hasExtra("e_file_path"))
                {
                    mLocalEventBus._mth1429(intent.getStringExtra("e_file_path"));
                    return;
                }
            }
            break;

        default:
            super.onActivityResult(i, j, intent);
            break;
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
            return;

        case 2131558715: 
            xf._mth02CA(xf.if.aQR);
            _mth02CB(zs.aWX);
            return;

        case 2131558713: 
            xf._mth02CA(xf.if.aQS);
            _mth02CB(zs.aWY);
            return;

        case 2131558717: 
            xf._mth02CA(xf.if.aQT);
            _mth02CB(zs.aXa);
            return;

        case 2131558721: 
            startActivity(new Intent(this, o/adb), ActivityOptions.makeCustomAnimation(this, 0x7f04000e, 0x7f04000c).toBundle());
            return;

        case 2131558723: 
            xf._mth02CA(xf.if.aQX);
            view = new Intent(this, o/add);
            view.putExtra("e_title", getString(0x7f0600db));
            view.putExtra("e_url", getString(0x7f0600dc));
            startActivity(view, ActivityOptions.makeCustomAnimation(this, 0x7f04000e, 0x7f04000c).toBundle());
            return;

        case 2131558724: 
            xf._mth02CA(xf.if.aQY);
            startActivity(new Intent(this, o/acs), ActivityOptions.makeCustomAnimation(this, 0x7f04000e, 0x7f04000c).toBundle());
            return;

        case 2131558727: 
            xf._mth02CA(xf.if.aQZ);
            (new android.app.AlertDialog.Builder(this)).setMessage(getString(0x7f0600c3)).setNegativeButton(0x7f0600bc, null).setPositiveButton(0x7f0600be, bsQ).show();
            return;

        case 2131558726: 
            startActivity(new Intent(this, o/acu), ActivityOptions.makeCustomAnimation(this, 0x7f04000e, 0x7f04000c).toBundle());
            return;

        case 2131558719: 
            startActivity(new Intent(this, o/anj), ActivityOptions.makeCustomAnimation(this, 0x7f04000e, 0x7f04000c).toBundle());
            return;

        case 2131558725: 
            startActivity(new Intent(this, o/amy), ActivityOptions.makeCustomAnimation(this, 0x7f04000e, 0x7f04000c).toBundle());
            return;

        case 2131558712: 
            startActivityForResult(new Intent(this, o/aly), 19328);
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03006e);
        getWindow().setBackgroundDrawable(null);
        beU = (ImageView)findViewById(0x7f0d0075);
        bsG = (ImageView)findViewById(0x7f0d0134);
        bsH = (TextView)findViewById(0x7f0d0136);
        bsI = (TextView)findViewById(0x7f0d00bd);
        beI = findViewById(0x7f0d00b0);
        bsJ = (TextView)findViewById(0x7f0d00fd);
        bsK = (TextView)findViewById(0x7f0d013a);
        bsL = (TextView)findViewById(0x7f0d013c);
        bsM = (TextView)findViewById(0x7f0d013e);
        bsN = (TextView)findViewById(0x7f0d0140);
        bsO = (TextView)findViewById(0x7f0d0137);
        mUserManager = xd._mth1FEA();
        mProfileManager = xd._mth2183();
        findViewById(0x7f0d0139).setOnClickListener(this);
        findViewById(0x7f0d013b).setOnClickListener(this);
        findViewById(0x7f0d013d).setOnClickListener(this);
        findViewById(0x7f0d013f).setOnClickListener(this);
        findViewById(0x7f0d0141).setOnClickListener(this);
        findViewById(0x7f0d0143).setOnClickListener(this);
        findViewById(0x7f0d0144).setOnClickListener(this);
        findViewById(0x7f0d0146).setOnClickListener(this);
        findViewById(0x7f0d0147).setOnClickListener(this);
        findViewById(0x7f0d0100).setOnClickListener(this);
        findViewById(0x7f0d0138).setOnClickListener(this);
        ((TextView)findViewById(0x7f0d0148)).setVisibility(8);
        bundle = (TextView)findViewById(0x7f0d0145);
        if (yo._mth02CA(mUserManager))
        {
            bundle.setVisibility(0);
            bundle.setOnClickListener(this);
        } else
        {
            bundle.setVisibility(8);
        }
        ((ImageView)findViewById(0x7f0d0142)).setColorFilter(getResources().getColor(0x7f0c0056));
        bundle = ql._mth043E();
        bundle.PM = false;
        mLocalEventBus = new ql(bundle);
        mLocalEventBus._mth02CA(this, false, 0);
        dn();
    }

    protected void onDestroy()
    {
        mLocalEventBus.unregister(this);
        super.onDestroy();
    }

    public void onEventBackgroundThread(String s)
    {
        runOnUiThread(new amj(this, BitmapFactory.decodeFile(s)));
    }

    public void onEventMainThread(zu zu1)
    {
        static final class _cls1
        {

            static final int $SwitchMap$tv$periscope$android$event$ApiEvent$Type[];
            static final int bcB[];

            static 
            {
                $SwitchMap$tv$periscope$android$event$ApiEvent$Type = new int[zu.if.values().length];
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aYj.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
                bcB = new int[zw.values().length];
                try
                {
                    bcB[zw.aYB.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    bcB[zw.aYP.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    bcB[zw.aYQ.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
            }
        }

        switch (_cls1..SwitchMap.tv.periscope.android.event.ApiEvent.Type[zu1.aXk.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            mProfileManager.aWD.set(true);
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
            dn();
            return;

        case 2: // '\002'
            dq();
            return;

        case 3: // '\003'
            dp();
            break;
        }
    }

    protected void onResume()
    {
label0:
        {
            super.onResume();
            if (!bsP)
            {
                boolean flag;
                if (SystemClock.elapsedRealtime() - bsF > 0x493e0L || mProfileManager.aWD.getAndSet(false))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    ApiManager apimanager = ApiManager.get(this);
                    apimanager.getUser();
                    apimanager.getBlocked();
                    apimanager.getMyUserBroadcasts();
                    bsF = SystemClock.elapsedRealtime();
                    break label0;
                }
            }
            _mthdo();
        }
        bsP = false;
    }

    public void startActivityForResult(Intent intent, int i)
    {
        bsP = true;
        super.startActivityForResult(intent, i);
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle)
    {
        bsP = true;
        super.startActivityForResult(intent, i, bundle);
    }

}
