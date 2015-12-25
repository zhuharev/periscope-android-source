// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import tv.periscope.android.api.ApiManager;
import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            ada, alz, ama, amd, 
//            ame, amf, amg, xf, 
//            apl, alw, ql, pg, 
//            amn, alx, arx, apk, 
//            acp, qe, apn, aob, 
//            xd, zp, aui, _cls1D3C, 
//            _cls1D5A, _cls1D27, qn, amc, 
//            aol, FF6A, amb, aom

public class aly extends ada
    implements android.view.View.OnClickListener, amn.if, alx.if
{

    private EditText bdv;
    private ImageView beU;
    private apn brA;
    private EditText bri;
    private TextView brl;
    private ImageView bro;
    private int brp;
    private int brq;
    private int brr;
    private int brs;
    private int brt;
    private boolean brw;
    private boolean brx;
    private String bsA;
    private String bsB;
    private final alz bsC = new alz(this);
    private final ama bsD = new ama(this);
    private TextView bsv;
    private ImageView bsw;
    private View bsx;
    private boolean bsy;
    private String bsz;
    private ql mLocalEventBus;

    public aly()
    {
        bsy = true;
        brw = true;
        brx = false;
    }

    private void dm()
    {
        boolean flag;
        if (brw && bsy)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            bsx.setAlpha(1.0F);
            return;
        } else
        {
            bsx.setAlpha(0.3F);
            return;
        }
    }

    private void _mth02CA(TextView textview, EditText edittext)
    {
        if (textview.getVisibility() == 0)
        {
            return;
        } else
        {
            textview.setVisibility(0);
            ValueAnimator valueanimator = ValueAnimator.ofInt(new int[] {
                0, brt
            });
            valueanimator.addUpdateListener(new amd(this, textview));
            valueanimator.addListener(new ame(this, edittext));
            valueanimator.setDuration(180L);
            valueanimator.start();
            return;
        }
    }

    static void _mth02CA(aly aly1)
    {
        if (aly1.bdv.getText().toString().length() > 160)
        {
            aly1.bsy = false;
            aly1.bsv.setText(0x7f060127);
            aly1._mth02CA(aly1.bsv, aly1.bdv);
        } else
        {
            aly1.bsy = true;
            aly1._mth02CB(aly1.bsv, aly1.bdv);
        }
        if (TextUtils.isEmpty(aly1.bdv.getText()))
        {
            aly1.bdv.setTextColor(aly1.getResources().getColor(0x7f0c0056));
            aly1.bsw.setColorFilter(aly1.brr);
        } else
        if (aly1.bsy)
        {
            aly1.bdv.setTextColor(aly1.getResources().getColor(0x7f0c0056));
            aly1.bsw.setColorFilter(aly1.brq);
            aly1._mth02CB(aly1.bsv, aly1.bdv);
        } else
        {
            aly1.bdv.setTextColor(aly1.brs);
            aly1.bsw.setColorFilter(aly1.brs);
        }
        aly1.dm();
    }

    private void _mth02CB(TextView textview, EditText edittext)
    {
        if (textview.getVisibility() != 0)
        {
            return;
        } else
        {
            ValueAnimator valueanimator = ValueAnimator.ofInt(new int[] {
                brt, 0
            });
            valueanimator.addUpdateListener(new amf(this, textview));
            valueanimator.addListener(new amg(this, textview, edittext));
            valueanimator.setDuration(180L);
            valueanimator.start();
            return;
        }
    }

    static void _mth02CB(aly aly1)
    {
        if (TextUtils.isEmpty(aly1.bri.getText()))
        {
            aly1.brw = false;
            aly1._mth02CB(aly1.brl, aly1.bri);
        } else
        if (aly1.bri.getText().toString().length() > 50)
        {
            aly1.brl.setText(0x7f0600c4);
            aly1.brw = false;
            aly1._mth02CA(aly1.brl, aly1.bri);
        } else
        {
            aly1.brw = true;
            aly1._mth02CB(aly1.brl, aly1.bri);
        }
        if (aly1.brw)
        {
            aly1.bri.setTextColor(aly1.brp);
            aly1.bro.setColorFilter(aly1.brq);
        } else
        if (TextUtils.isEmpty(aly1.bri.getText()))
        {
            aly1.bri.setTextColor(aly1.brp);
            aly1.bro.setColorFilter(aly1.brr);
        } else
        {
            aly1.bri.setTextColor(aly1.brs);
            aly1.bro.setColorFilter(aly1.brs);
        }
        aly1.dm();
    }

    static ImageView _mth02CE(aly aly1)
    {
        return aly1.beU;
    }

    private static boolean FE7A(String s, String s1)
    {
        if (s == null && s1 != null)
        {
            return true;
        }
        if (s != null && s1 == null)
        {
            return true;
        }
        return s == null || !s.equals(s1);
    }

    protected final String aI()
    {
        return "Edit Profile";
    }

    public final void df()
    {
        xf._mth02CA(xf.if.aRb);
        brx = true;
        if (bdv.isFocused())
        {
            EditText edittext = bdv;
            if (edittext != null)
            {
                ((InputMethodManager)edittext.getContext().getSystemService("input_method")).hideSoftInputFromWindow(edittext.getWindowToken(), 0);
            }
        } else
        if (bri.isFocused())
        {
            EditText edittext1 = bri;
            if (edittext1 != null)
            {
                ((InputMethodManager)edittext1.getContext().getSystemService("input_method")).hideSoftInputFromWindow(edittext1.getWindowToken(), 0);
            }
        }
        brA.dC();
        startActivityForResult(new Intent(this, o/alw), 29385);
    }

    public final void dg()
    {
        xf._mth02CA(xf.if.aRa);
        brx = true;
        if (bdv.isFocused())
        {
            EditText edittext = bdv;
            if (edittext != null)
            {
                ((InputMethodManager)edittext.getContext().getSystemService("input_method")).hideSoftInputFromWindow(edittext.getWindowToken(), 0);
            }
        } else
        if (bri.isFocused())
        {
            EditText edittext1 = bri;
            if (edittext1 != null)
            {
                ((InputMethodManager)edittext1.getContext().getSystemService("input_method")).hideSoftInputFromWindow(edittext1.getWindowToken(), 0);
            }
        }
        brA.dC();
        startActivityForResult(_cls026B.if._mth1D17(), 29386);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        File file = new File(getCacheDir(), "cropper.jpg");
        switch (i)
        {
        default:
            return;

        case 6709: 
            if (brA.aO())
            {
                brA.dC();
            }
            if (j == -1)
            {
                mLocalEventBus._mth1429(file);
                return;
            }
            break;

        case 29385: 
            if (brA.aO())
            {
                brA.dC();
            }
            switch (j)
            {
            default:
                return;

            case -1: 
                intent = intent.getExtras().getString("e_filename");
                break;
            }
            bsB = intent;
            mLocalEventBus._mth1429(intent);
            return;

        case 29386: 
            if (brA.aO())
            {
                brA.dC();
            }
            switch (j)
            {
            default:
                return;

            case -1: 
                break;
            }
            if (intent != null && intent.getData() != null)
            {
                intent = new pg(intent.getData(), Uri.fromFile(file));
                ((pg) (intent)).NL.putExtra("aspect_x", 1);
                ((pg) (intent)).NL.putExtra("aspect_y", 1);
                intent._mth141D(this);
            }
            break;
        }
    }

    public void onBackPressed()
    {
        if (brA.aO())
        {
            brA.dC();
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

        case 2131558650: 
        case 2131558656: 
            onBackPressed();
            return;

        case 2131558605: 
            view = new amn(this);
            alx alx1 = new alx(this);
            ArrayList arraylist = new ArrayList(2);
            arraylist.add(view);
            arraylist.add(alx1);
            brA._mth02CB(null, arraylist);
            return;

        case 2131558651: 
            break;
        }
        boolean flag;
        if (brw && bsy)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            Toast.makeText(this, 0x7f0600c6, 0).show();
            return;
        }
        if (FE7A(bsz, bri.getText().toString()))
        {
            ApiManager.get(this).updateProfileDisplayName(bri.getText().toString());
        }
        if (FE7A(bsA, bdv.getText().toString()))
        {
            ApiManager.get(this).updateProfileDescription(bdv.getText().toString());
        }
        view = new Intent();
        if (bsB != null)
        {
            brx = false;
            ApiManager.get(this).setProfileImage(new File(bsB), getCacheDir());
            view.putExtra("e_file_path", bsB);
        }
        setResult(-1, view);
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030048);
        getWindow().setBackgroundDrawable(null);
        brp = getResources().getColor(0x7f0c0097);
        brs = getResources().getColor(0x7f0c0081);
        brr = getResources().getColor(0x7f0c0037);
        bdv = (EditText)findViewById(0x7f0d00fd);
        bsw = (ImageView)findViewById(0x7f0d00fc);
        bro = (ImageView)findViewById(0x7f0d00cf);
        bri = (EditText)findViewById(0x7f0d00d0);
        bsv = (TextView)findViewById(0x7f0d00fe);
        bsv.setVisibility(4);
        brl = (TextView)findViewById(0x7f0d00d1);
        brl.setVisibility(4);
        brq = getResources().getColor(0x7f0c00b7);
        brt = getResources().getDimensionPixelOffset(0x7f0900b4);
        findViewById(0x7f0d00fa).setOnClickListener(this);
        findViewById(0x7f0d00cd).setOnClickListener(this);
        bsx = findViewById(0x7f0d00fb);
        bsx.setOnClickListener(this);
        Object obj = (arx)findViewById(0x7f0d00f9);
        apk apk1 = (apk)findViewById(0x7f0d00a9);
        if (super.bdr != null)
        {
            bundle = super.bdr;
        } else
        {
            bundle = new qe();
        }
        brA = new apn(new aob(((arx) (obj)), apk1, bundle), findViewById(0x7f0d00d7));
        obj = xd._mth1FEA().H();
        bsz = ((PsUser) (obj)).displayName;
        bsA = ((PsUser) (obj)).description;
        if (aui._mth02BF(bsz))
        {
            bri.append(bsz);
        }
        bdv.setText(bsA);
        beU = (ImageView)findViewById(0x7f0d0075);
        bundle = _cls1D3C._mth02CA(this);
        obj = ((PsUser) (obj)).getProfileUrlLarge();
        ((_cls1D27)bundle._mth02CA(java/lang/String).FF70(obj))._mth02CA(beU);
        bri.addTextChangedListener(bsD);
        bdv.addTextChangedListener(bsC);
        bundle = ql._mth043E();
        bundle.PM = false;
        mLocalEventBus = new ql(bundle);
        mLocalEventBus._mth02CA(this, false, 0);
    }

    protected void onDestroy()
    {
        mLocalEventBus.unregister(this);
        if (isFinishing() && brx)
        {
            xf._mth02CA(xf.if.aRc);
        }
        super.onDestroy();
    }

    public void onEventBackgroundThread(File file)
    {
        file = _cls026B.if._mth02CE(file);
        runOnUiThread(new amc(this, file));
        file = _cls026B.if._mth02CA(file, "profile", ".jpg", getCacheDir());
        static final class _cls1
        {

            static final int brG[];

            static 
            {
                brG = new int[aom.dD().length];
                int ai[];
                int j;
                try
                {
                    ai = brG;
                    int i = aom.bvf;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    continue; /* Loop/switch isn't completed */
                }
                ai[0] = 1;
_L4:
                ai = brG;
                j = aom.bvh;
                ai[2] = 2;
_L2:
                ai = brG;
                j = aom.bvg;
                ai[1] = 3;
                break MISSING_BLOCK_LABEL_55;
                NoSuchFieldError nosuchfielderror1;
                nosuchfielderror1;
                if (true) goto _L2; else goto _L1
_L1:
                nosuchfielderror1;
                if (true) goto _L4; else goto _L3
_L3:
            }
        }

        _cls1.brG[((aol) (file)).bve - 1];
        JVM INSTR tableswitch 1 3: default 104
    //                   1 68
    //                   2 80
    //                   3 80;
           goto _L1 _L2 _L3 _L3
_L2:
        bsB = ((aol) (file)).file.getPath();
        return;
_L3:
        try
        {
            Toast.makeText(this, 0x7f060077, 0).show();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            FF6A._mth02CA("EditProfileActivity", "Could error processing bitmap.", file);
        }
        return;
_L1:
    }

    public void onEventBackgroundThread(String s)
    {
        runOnUiThread(new amb(this, BitmapFactory.decodeFile(s)));
    }
}
