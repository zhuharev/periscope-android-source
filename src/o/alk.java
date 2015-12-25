// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterSession;
import java.lang.reflect.Field;
import retrofit.RetrofitError;
import retrofit.client.Response;
import tv.periscope.android.api.ApiManager;
import tv.periscope.android.api.PsUser;
import tv.periscope.android.api.TwitterLoginResponse;

// Referenced classes of package o:
//            ada, alo, all, alm, 
//            abw, zu, zp, xd, 
//            abv, FF6A, ajk, aky, 
//            alt, xf, yo, amy, 
//            ach, alj, akx

public class alk extends ada
    implements android.view.View.OnClickListener
{

    private static int brJ;
    private static akx brK;
    private static all brL = new all();
    private static alm brM = new alm();
    private SharedPreferences brN;
    private ach brO;
    private alt brP;
    private boolean brQ;
    private ProgressDialog brR;
    private zp mUserManager;

    public alk()
    {
    }

    static akx _mth02CA(akx akx1)
    {
        brK = akx1;
        return akx1;
    }

    private void _mth02CA(zu zu1, String s, String s1)
    {
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
            zu1 = (TwitterLoginResponse)zu1.data;
            _mth02CA(((TwitterLoginResponse) (zu1)));
            if (!TextUtils.isEmpty(((TwitterLoginResponse) (zu1)).user.username))
            {
                mUserManager.aQC.edit().putBoolean((String)yp.CON._mth02CA("o.yp").getField("aVP").get(null), true).apply();
                zu1 = xd._mth212A();
                try
                {
                    zu1.aD();
                }
                // Misplaced declaration of an exception variable
                catch (zu zu1)
                {
                    FF6A._mth02CA("LoginActivity", "Failed to register push", zu1);
                }
                startActivity((new Intent(this, o/ajk)).putExtra("e_tab", "main"));
                finish();
                return;
            } else
            {
                startActivityForResult((new Intent(this, o/aky)).putExtra("e_user", ((TwitterLoginResponse) (zu1)).user).putExtra("e_suggested", ((TwitterLoginResponse) (zu1)).suggestedUsername).putExtra("e_session_key", s).putExtra("e_session_secret", s1), 0xf198e);
                return;
            }
        }
        if (zu1.aXl != null && zu1.aXl.getResponse() != null)
        {
            zu1 = zu1.aXl.getResponse().getReason();
        } else
        {
            zu1 = null;
        }
        Toast.makeText(this, zu1, 1).show();
    }

    private void _mth02CA(TwitterLoginResponse twitterloginresponse)
    {
        boolean flag;
        if (twitterloginresponse.user != null)
        {
            flag = twitterloginresponse.user.isEmployee;
        } else
        {
            flag = false;
        }
        brN.edit().putBoolean("last_login_is_employee", flag).putString("last_login_type", twitterloginresponse.sessionType.name()).apply();
    }

    static int FB5C(int i)
    {
        brJ = i;
        return i;
    }

    protected final String aI()
    {
        return "Login";
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        switch (i)
        {
        case 989582: 
            intent = xd._mth212A();
            try
            {
                intent.aD();
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                FF6A._mth02CA("LoginActivity", "Failed to register push", intent);
            }
            startActivity((new Intent(this, o/ajk)).putExtra("e_tab", "global"));
            finish();
            return;
        }
        brP.onActivityResult(i, j, intent);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131558670: 
            brJ = alo.brW;
            xf._mth02CA(xf.if.aRt);
            return;

        case 2131558669: 
            if (yo.i())
            {
                startActivity(new Intent(this, o/amy));
                return;
            }
            break;

        case 2131558671: 
            brJ = alo.brZ;
            xf._mth02CA(xf.if.aRz);
            break;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030055);
        getWindow().setBackgroundDrawable(null);
        brN = getSharedPreferences("app", 0);
        mUserManager = xd._mth1FEA();
        brO = new ach(xd._mth1FEB(), mUserManager, ApiManager.get(this));
        bundle = brN.getString("last_login_type", null);
        if (bundle == null)
        {
            bundle = acj.if.bda;
        } else
        {
            bundle = acj.if.valueOf(bundle);
        }
        brP = (alt)findViewById(0x7f0d010e);
        brP.setCallback(brL);
        brP.setOnClickListener(this);
        brP.setLastLoginType(bundle);
        alj alj1 = (alj)findViewById(0x7f0d010f);
        alj1.setCallback(brM);
        alj1.setOnClickListener(this);
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            alj1.setAuthTheme(0x7f0a007a);
        }
        alj1.setLastLoginType(bundle);
        bundle = (Button)findViewById(0x7f0d010d);
        boolean flag;
        if (yo.i() || brN.getBoolean("last_login_is_employee", false))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            bundle.setVisibility(0);
        } else
        {
            bundle.setVisibility(8);
        }
        bundle.setOnClickListener(this);
        brR = new ProgressDialog(this);
        brR.setMessage(getString(0x7f0600e7));
        brR.setIndeterminate(true);
        brR.setCancelable(false);
    }

    protected void onDestroy()
    {
        static final class _cls1
        {

            static final int $SwitchMap$tv$periscope$android$event$ApiEvent$Type[];
            static final int brS[];

            static 
            {
                $SwitchMap$tv$periscope$android$event$ApiEvent$Type = new int[zu.if.values().length];
                int ai[];
                int j;
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXm.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
                brS = new int[alo.dh().length];
                try
                {
                    ai = brS;
                    int i = alo.bsa;
                }
                catch (NoSuchFieldError nosuchfielderror1)
                {
                    continue; /* Loop/switch isn't completed */
                }
                ai[5] = 1;
_L6:
                ai = brS;
                j = alo.bsb;
                ai[6] = 2;
_L1:
                ai = brS;
                j = alo.brX;
                ai[2] = 3;
_L2:
                ai = brS;
                j = alo.brY;
                ai[3] = 4;
_L3:
                ai = brS;
                j = alo.brW;
                ai[1] = 5;
_L4:
                ai = brS;
                j = alo.brZ;
                ai[4] = 6;
                break MISSING_BLOCK_LABEL_129;
                NoSuchFieldError nosuchfielderror2;
                nosuchfielderror2;
                  goto _L1
                nosuchfielderror2;
                  goto _L2
                nosuchfielderror2;
                  goto _L3
                nosuchfielderror2;
                  goto _L4
                nosuchfielderror2;
                if (true) goto _L6; else goto _L5
_L5:
            }
        }

        if (isFinishing() && !brQ)
        {
            switch (_cls1.brS[brJ - 1])
            {
            case 5: // '\005'
                xf._mth02CA(xf.if.aRu);
                break;

            case 6: // '\006'
                xf._mth02CA(xf.if.aRA);
                break;

            default:
                xf._mth02CA(xf.if.aRv);
                break;
            }
        }
        super.onDestroy();
    }

    public void onEventMainThread(zu zu1)
    {
        switch (_cls1..SwitchMap.tv.periscope.android.event.ApiEvent.Type[zu1.aXk.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            break;
        }
        if (brR.isShowing())
        {
            brR.dismiss();
        }
        int i = brJ;
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
            brQ = true;
        }
        switch (_cls1.brS[i - 1])
        {
        default:
            return;

        case 3: // '\003'
            _mth02CA(zu1, mUserManager.aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVQ").get(null), null), mUserManager.aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVR").get(null), null));
            return;

        case 1: // '\001'
            _mth02CA(zu1, "", "");
            return;
        }
    }

    protected void onResume()
    {
label0:
        {
            Object obj;
label1:
            {
                super.onResume();
                if (brK == null)
                {
                    break label0;
                }
                int i = brJ;
                obj = brK;
                switch (_cls1.brS[i - 1])
                {
                default:
                    break;

                case 1: // '\001'
                    obj = brO._mth02CA(this, ((akx) (obj)).brg, ((akx) (obj)).phoneNumber);
                    break label1;

                case 2: // '\002'
                    xf._mth02CA(xf.if.aRA);
                    break;

                case 3: // '\003'
                    TwitterAuthToken twitterauthtoken = (TwitterAuthToken)((akx) (obj)).brf.getAuthToken();
                    mUserManager._mth1D62(twitterauthtoken.token, twitterauthtoken.secret);
                    obj = brO._mth02CA(this, ((akx) (obj)).brf);
                    break label1;

                case 4: // '\004'
                    xf._mth02CA(xf.if.aRu);
                    break;
                }
                obj = null;
            }
            if (obj != null && !brR.isShowing())
            {
                brR.show();
            }
            brK = null;
        }
    }

    static 
    {
        brJ = alo.brV;
    }
}
