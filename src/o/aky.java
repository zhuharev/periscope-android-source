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
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import retrofit.RetrofitError;
import retrofit.client.Response;
import tv.periscope.android.api.ApiManager;
import tv.periscope.android.api.PsUser;
import tv.periscope.android.api.ValidateUsernameError;
import tv.periscope.android.api.ValidateUsernameResponse;

// Referenced classes of package o:
//            ada, alc, ald, alg, 
//            alh, ali, ala, xf, 
//            apl, alw, ql, pg, 
//            amn, alx, ash, arx, 
//            apk, acp, qe, apn, 
//            aob, _cls1D3C, _cls1D5A, _cls1D27, 
//            akz, alb, aos, qn, 
//            ale, aol, alf, zu, 
//            alp, aom

public class aky extends ada
    implements android.view.View.OnClickListener, amn.if, alx.if
{

    private ImageView beU;
    private apn brA;
    private alc brB;
    private ald brC;
    private EditText brh;
    private EditText bri;
    private TextView brj;
    private TextView brk;
    private TextView brl;
    private Button brm;
    private ImageView brn;
    private ImageView bro;
    private int brp;
    private int brq;
    private int brr;
    private int brs;
    private int brt;
    private boolean bru;
    private boolean brv;
    private boolean brw;
    private boolean brx;
    private String bry;
    private String brz;
    private ql mLocalEventBus;

    public aky()
    {
        brB = new alc(this);
        brC = new ald(this);
    }

    private void db()
    {
        dc();
        if (TextUtils.isEmpty(bri.getText()))
        {
            brw = false;
            _mth02CB(brl, bri);
        } else
        if (bri.getText().toString().length() > 50)
        {
            brl.setText(0x7f0600c4);
            brw = false;
            _mth02CA(brl, bri);
        } else
        {
            brw = true;
            _mth02CB(brl, bri);
        }
        if (brw)
        {
            bri.setTextColor(brp);
            bro.setColorFilter(brq);
        } else
        if (TextUtils.isEmpty(bri.getText()))
        {
            bri.setTextColor(brp);
            bro.setColorFilter(brr);
        } else
        {
            bri.setTextColor(brs);
            bro.setColorFilter(brs);
        }
        de();
    }

    private boolean dc()
    {
        if (TextUtils.isEmpty(brh.getText()))
        {
            bru = false;
            _mth02CB(brk, brh);
            dd();
        } else
        if (brh.getText().toString().length() < 3)
        {
            bru = false;
            brk.setText(0x7f060173);
            _mth02CA(brk, brh);
            dd();
        } else
        {
            bru = true;
        }
        de();
        return bru;
    }

    private void dd()
    {
        if (bru && brv)
        {
            brh.setTextColor(brp);
            brn.setColorFilter(brq);
            _mth02CB(brk, brh);
            return;
        }
        if (TextUtils.isEmpty(brh.getText()))
        {
            brh.setTextColor(brp);
            brn.setColorFilter(brr);
            return;
        } else
        {
            brh.setTextColor(brs);
            brn.setColorFilter(brs);
            return;
        }
    }

    private void de()
    {
        boolean flag;
        if (bru && brv && brw)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            brm.setAlpha(0.3F);
        } else
        {
            brm.setAlpha(1.0F);
        }
        brm.setEnabled(flag);
    }

    static ImageView _mth02BB(aky aky1)
    {
        return aky1.beU;
    }

    static TextView _mth02CA(aky aky1)
    {
        return aky1.brj;
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
            valueanimator.addUpdateListener(new alg(this, textview));
            valueanimator.addListener(new alh(this, edittext));
            valueanimator.setDuration(180L);
            valueanimator.start();
            return;
        }
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
            valueanimator.addUpdateListener(new ali(this, textview));
            valueanimator.addListener(new ala(this, textview, edittext));
            valueanimator.setDuration(180L);
            valueanimator.start();
            return;
        }
    }

    static boolean _mth02CB(aky aky1)
    {
        return aky1.dc();
    }

    static void _mth02CE(aky aky1)
    {
        ApiManager.get(aky1).validateUsername(aky1.brh.getText().toString(), aky1.bry, aky1.brz);
    }

    static void _mth02CF(aky aky1)
    {
        aky1.db();
    }

    static void _mth141D(aky aky1)
    {
        aky1.de();
    }

    protected final String aI()
    {
        return "Create Account";
    }

    public final void df()
    {
        xf._mth02CA(xf.if.aRx);
        brx = true;
        if (brh.isFocused())
        {
            EditText edittext = brh;
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
        xf._mth02CA(xf.if.aRw);
        brx = true;
        if (brh.isFocused())
        {
            EditText edittext = brh;
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
                mLocalEventBus._mth1429(new File(getCacheDir(), "cropper.jpg"));
                return;
            }
            break;

        case 29384: 
            switch (j)
            {
            default:
                return;

            case -1: 
                setResult(-1);
                break;
            }
            finish();
            return;

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
                brx = false;
                break;
            }
            intent = intent.getExtras().getString("e_filename");
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
                brx = false;
                intent = new pg(intent.getData(), Uri.fromFile(new File(getCacheDir(), "cropper.jpg")));
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

        case 2131558614: 
            ApiManager.get(this).verifyUsername(brh.getText().toString(), bri.getText().toString(), bry, brz);
            return;

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
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03003b);
        bundle = (ash)findViewById(0x7f0d009c);
        bundle.setTitle(0x7f060081);
        bundle.findViewById(0x7f0d0100).setOnClickListener(this);
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            bundle.setElevation(0.0F);
        }
        brp = getResources().getColor(0x7f0c0097);
        brs = getResources().getColor(0x7f0c0081);
        brr = getResources().getColor(0x7f0c0037);
        brh = (EditText)findViewById(0x7f0d00bd);
        brh.addTextChangedListener(brB);
        brn = (ImageView)findViewById(0x7f0d00d2);
        bro = (ImageView)findViewById(0x7f0d00cf);
        bri = (EditText)findViewById(0x7f0d00d0);
        brj = (TextView)findViewById(0x7f0d00d5);
        brj.setVisibility(0);
        brm = (Button)findViewById(0x7f0d00d6);
        brm.setOnClickListener(this);
        brk = (TextView)findViewById(0x7f0d00d3);
        brk.setVisibility(4);
        brl = (TextView)findViewById(0x7f0d00d1);
        brl.setVisibility(4);
        brq = getResources().getColor(0x7f0c00b7);
        brt = getResources().getDimensionPixelOffset(0x7f0900b4);
        findViewById(0x7f0d00cd).setOnClickListener(this);
        Object obj = (arx)findViewById(0x7f0d00cc);
        Object obj1 = (apk)findViewById(0x7f0d00a9);
        if (super.bdr != null)
        {
            bundle = super.bdr;
        } else
        {
            bundle = new qe();
        }
        brA = new apn(new aob(((arx) (obj)), ((apk) (obj1)), bundle), findViewById(0x7f0d00d7));
        bundle = getIntent();
        if (bundle != null)
        {
            bundle = bundle.getExtras();
            if (bundle != null)
            {
                obj = (PsUser)bundle.getParcelable("e_user");
                obj1 = bundle.getString("e_suggested");
                brh.setText(((CharSequence) (obj1)));
                bri.setText(((PsUser) (obj)).displayName);
                beU = (ImageView)findViewById(0x7f0d0075);
                obj1 = _cls1D3C._mth02CA(this);
                obj = ((PsUser) (obj)).getProfileUrlLarge();
                ((_cls1D27)((_cls1D5A) (obj1))._mth02CA(java/lang/String).FF70(obj))._mth02CA(beU);
                bry = bundle.getString("e_session_key");
                brz = bundle.getString("e_session_secret");
            }
        }
        bri.addTextChangedListener(brC);
        bundle = (TextView)findViewById(0x7f0d00d4);
        obj = new akz(this);
        obj1 = new alb(this);
        aos._mth02CA(bundle, getString(0x7f060162), getResources().getColor(0x7f0c0035), new android.view.View.OnClickListener[] {
            obj, obj1
        });
        brv = true;
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
            xf._mth02CA(xf.if.aRy);
        }
        super.onDestroy();
    }

    public void onEventBackgroundThread(File file)
    {
        file = _cls026B.if._mth02CE(file);
        runOnUiThread(new ale(this, file));
        file = _cls026B.if._mth02CA(file, "profile", ".jpg", getCacheDir());
        static final class _cls1
        {

            static final int $SwitchMap$tv$periscope$android$event$ApiEvent$Type[];
            static final int brG[];

            static 
            {
                $SwitchMap$tv$periscope$android$event$ApiEvent$Type = new int[zu.if.values().length];
                int ai[];
                int j;
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXn.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXo.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                brG = new int[aom.dD().length];
                try
                {
                    ai = brG;
                    int i = aom.bvf;
                }
                catch (NoSuchFieldError nosuchfielderror2)
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
                break MISSING_BLOCK_LABEL_94;
                NoSuchFieldError nosuchfielderror3;
                nosuchfielderror3;
                if (true) goto _L2; else goto _L1
_L1:
                nosuchfielderror3;
                if (true) goto _L4; else goto _L3
_L3:
            }
        }

        _cls1.brG[((aol) (file)).bve - 1];
        JVM INSTR tableswitch 1 3: default 98
    //                   1 68
    //                   2 84
    //                   3 84;
           goto _L1 _L2 _L3 _L3
_L2:
        ApiManager.get(this).setProfileImage(((aol) (file)).file, getCacheDir());
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
            return;
        }
_L1:
    }

    public void onEventBackgroundThread(String s)
    {
        runOnUiThread(new alf(this, BitmapFactory.decodeFile(s)));
        ApiManager.get(this).setProfileImage(new File(s), getCacheDir());
    }

    public void onEventMainThread(zu zu1)
    {
        switch (_cls1..SwitchMap.tv.periscope.android.event.ApiEvent.Type[zu1.aXk.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
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
                zu1 = (ValidateUsernameResponse)zu1.data;
                db();
                boolean flag2;
                if (((ValidateUsernameResponse) (zu1)).errors == null || ((ValidateUsernameResponse) (zu1)).errors.length == 0)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                brv = flag2;
                dd();
                de();
                return;
            }
            if (zu1.data != null)
            {
                zu1 = (ValidateUsernameError)zu1.data;
                if (((ValidateUsernameError) (zu1)).errors != null)
                {
                    zu1 = ((ValidateUsernameError) (zu1)).errors.iterator();
                    do
                    {
                        if (!zu1.hasNext())
                        {
                            break;
                        }
                        tv.periscope.android.api.ValidateUsernameError.UsernameError usernameerror = (tv.periscope.android.api.ValidateUsernameError.UsernameError)zu1.next();
                        if (usernameerror.fields.contains("username"))
                        {
                            brv = false;
                            brk.setText(usernameerror.error);
                            _mth02CA(brk, brh);
                            dd();
                            de();
                        }
                    } while (true);
                }
                return;
            }
            break;

        case 2: // '\002'
            boolean flag1;
            if (zu1.aXl == null && zu1.mU == null)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                startActivityForResult(new Intent(this, o/alp), 29384);
                finish();
                return;
            }
            if (zu1.aXl != null && zu1.aXl.getResponse() != null)
            {
                zu1 = zu1.aXl.getResponse().getReason();
            } else
            {
                zu1 = null;
            }
            Toast.makeText(this, zu1, 1).show();
            break;
        }
    }
}
