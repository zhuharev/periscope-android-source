// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package o:
//            br, bp

public final class bj
{

    private static HashMap zE = new HashMap();
    public static br zF;
    private static bp zG;
    private static String zK;
    private Context mContext;
    public KeyPair zH;
    public String zI;
    public long zJ;

    private bj(Context context, String s)
    {
        zI = "";
        mContext = context.getApplicationContext();
        zI = s;
    }

    static String _mth02BB(byte abyte0[])
    {
        return Base64.encodeToString(abyte0, 11);
    }

    static String _mth02CA(KeyPair keypair)
    {
        keypair = keypair.getPublic().getEncoded();
        try
        {
            keypair = MessageDigest.getInstance("SHA1").digest(keypair);
        }
        // Misplaced declaration of an exception variable
        catch (KeyPair keypair)
        {
            Log.w("InstanceID", "Unexpected error, device missing required alghorithms");
            return null;
        }
        keypair[0] = (byte)((keypair[0] & 0xf) + 112);
        keypair = Base64.encodeToString(keypair, 0, 8, 11);
        return keypair;
    }

    public static bj _mth02CA(Context context, Bundle bundle)
    {
        o/bj;
        JVM INSTR monitorenter ;
        if (bundle != null) goto _L2; else goto _L1
_L1:
        bundle = "";
          goto _L3
_L2:
        bundle = bundle.getString("subtype");
          goto _L3
_L5:
        Object obj;
        Context context1;
        context1 = context.getApplicationContext();
        if (zF == null)
        {
            zF = new br(context1);
            zG = new bp(context1);
        }
        zK = Integer.toString(FE7A(context1));
        bundle = (bj)zE.get(obj);
        context = bundle;
        if (bundle != null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        context = new bj(context1, ((String) (obj)));
        zE.put(obj, context);
        o/bj;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
_L3:
        obj = bundle;
        if (bundle == null)
        {
            obj = "";
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    private KeyPair _mth1D20()
    {
        if (zH == null)
        {
            zH = zF._mth02E1(zI);
        }
        if (zH == null)
        {
            zJ = System.currentTimeMillis();
            zH = zF._mth02CE(zI, zJ);
        }
        return zH;
    }

    static br _mth1D3B()
    {
        return zF;
    }

    static bp _mth1D60()
    {
        return zG;
    }

    private static boolean _mth1D69()
    {
        String s = zF.get("appVersion");
        if (s == null || !s.equals(zK))
        {
            return true;
        }
        s = zF.get("lastToken");
        if (s == null)
        {
            return true;
        }
        long l = Long.parseLong(s);
        return System.currentTimeMillis() / 1000L - Long.valueOf(l).longValue() > 0x93a80L;
    }

    static int FE7A(Context context)
    {
        int i;
        try
        {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.w("InstanceID", (new StringBuilder("Never happens: can't find own package ")).append(context).toString());
            return 0;
        }
        return i;
    }

    public static bj FF70(Context context)
    {
        return _mth02CA(context, null);
    }

    public final void _mth02CA(String s, String s1, Bundle bundle)
    {
        if (Looper.getMainLooper() == Looper.myLooper())
        {
            throw new IOException("MAIN_THREAD");
        }
        zF._mth02CE(zI, s, s1);
        Bundle bundle1 = bundle;
        if (bundle == null)
        {
            bundle1 = new Bundle();
        }
        bundle1.putString("sender", s);
        if (s1 != null)
        {
            bundle1.putString("scope", s1);
        }
        bundle1.putString("subscription", s);
        bundle1.putString("delete", "1");
        bundle1.putString("X-delete", "1");
        if ("".equals(zI))
        {
            s1 = s;
        } else
        {
            s1 = zI;
        }
        bundle1.putString("subtype", s1);
        if (!"".equals(zI))
        {
            s = zI;
        }
        bundle1.putString("X-subtype", s);
        bundle = zG;
        KeyPair keypair = _mth1D20();
        s1 = bundle._mth02CA(bundle1, keypair);
        s = s1;
        if (s1 != null)
        {
            s = s1;
            if (s1.hasExtra("google.messenger"))
            {
                s = bundle._mth02CA(bundle1, keypair);
            }
        }
        bp._mth02CF(s);
    }

    public final String _mth02CB(String s, String s1, Bundle bundle)
    {
        if (Looper.getMainLooper() == Looper.myLooper())
        {
            throw new IOException("MAIN_THREAD");
        }
        boolean flag = true;
        Object obj;
        if (_mth1D69())
        {
            obj = null;
        } else
        {
            obj = zF._mth02CB(zI, s, s1);
        }
        if (obj != null)
        {
            return ((String) (obj));
        }
        obj = bundle;
        if (bundle == null)
        {
            obj = new Bundle();
        }
        if (((Bundle) (obj)).getString("ttl") != null)
        {
            flag = false;
        }
        if ("jwt".equals(((Bundle) (obj)).getString("type")))
        {
            flag = false;
        }
        bundle = _mth02CE(s, s1, ((Bundle) (obj)));
        Log.w("InstanceID", (new StringBuilder("token: ")).append(bundle).toString());
        if (bundle != null && flag)
        {
            zF._mth02CA(zI, s, s1, bundle, zK);
        }
        return bundle;
    }

    public final String _mth02CE(String s, String s1, Bundle bundle)
    {
        if (s1 != null)
        {
            bundle.putString("scope", s1);
        }
        bundle.putString("sender", s);
        if ("".equals(zI))
        {
            s1 = s;
        } else
        {
            s1 = zI;
        }
        if (!bundle.containsKey("legacy.register"))
        {
            bundle.putString("subscription", s);
            bundle.putString("subtype", s1);
            bundle.putString("X-subscription", s);
            bundle.putString("X-subtype", s1);
        }
        bp bp1 = zG;
        KeyPair keypair = _mth1D20();
        s1 = bp1._mth02CA(bundle, keypair);
        s = s1;
        if (s1 != null)
        {
            s = s1;
            if (s1.hasExtra("google.messenger"))
            {
                s = bp1._mth02CA(bundle, keypair);
            }
        }
        return bp._mth02CF(s);
    }

    public final void _mth1D30()
    {
        zJ = 0L;
        br br1 = zF;
        String s = zI;
        br1._mth02C7((new StringBuilder()).append(s).append("|").toString());
        zH = null;
    }

}
