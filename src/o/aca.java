// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.IntentService;
import android.content.Intent;
import java.io.IOException;
import retrofit.RetrofitError;
import tv.periscope.android.api.ApiClient;
import tv.periscope.android.push.api.PushClient;

// Referenced classes of package o:
//            xd, abv, bj, abt, 
//            ql, FF6A, abu, aos, 
//            _cls0993

public class aca extends IntentService
{

    private final PushClient bcM = new PushClient(xd._mth3078().getAdapter());
    private final ql mEventBus;

    public aca()
    {
        super("RegistrationIntentService");
        mEventBus = xd._mth212A().mEventBus;
    }

    private String aE()
    {
        String s = null;
        String s1;
        try
        {
            s1 = bj.FF70(this)._mth02CB(getString(0x7f06019c), "GCM", null);
        }
        catch (IOException ioexception)
        {
            FF6A._mth02CA("RegistrationIntentService", "Device register with gcm failed", ioexception);
            return s;
        }
        s = s1;
        mEventBus._mth1429(new abt(s1));
        return s1;
    }

    private void aF()
    {
        try
        {
            bj.FF70(this)._mth02CA(getString(0x7f06019c), "GCM", null);
            mEventBus._mth1429(new abu());
            return;
        }
        catch (IOException ioexception)
        {
            FF6A._mth02CA("RegistrationIntentService", "Device unregister failed", ioexception);
        }
    }

    private void _mth2071(String s, String s1)
    {
        try
        {
            bcM.registerToken(s, aos.FF9F(this), aos._mth1D57(this), s1, aos._mth1D4B(this), aos._mth02CA(this), "", aos.dG());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            FF6A._mth02CA("RegistrationIntentService", "Failed to register device and user for push, will try on next app launch");
        }
    }

    protected void onHandleIntent(Intent intent)
    {
        if (intent == null)
        {
            return;
        }
        String s = intent.getAction();
        byte byte0 = -1;
        switch (s.hashCode())
        {
        case -690213213: 
            if (s.equals("register"))
            {
                byte0 = 0;
            }
            break;

        case -137591459: 
            if (s.equals("register_token"))
            {
                byte0 = 1;
            }
            break;

        case 836015164: 
            if (s.equals("unregister"))
            {
                byte0 = 2;
            }
            break;
        }
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            _mth2071(intent.getStringExtra("cookie"), aE());
            return;

        case 1: // '\001'
            _mth2071(intent.getStringExtra("cookie"), intent.getStringExtra("registration_id"));
            return;

        case 2: // '\002'
            intent = intent.getStringExtra("cookie");
            break;
        }
        try
        {
            bcM.unregisterToken(intent, aos._mth1D4B(this));
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            FF6A._mth02CA("RegistrationIntentService", "Failed to unregister token", intent);
        }
        if (_cls0993._mth1D4E(this) == 0)
        {
            aF();
        }
    }
}
