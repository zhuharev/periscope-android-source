// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.gcm;

import android.content.Context;
import android.os.Bundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import o.bj;

public class GcmPubSub
{

    private static GcmPubSub zzaCk;
    private static final Pattern zzaCm = Pattern.compile("/topics/[a-zA-Z0-9-_.~%]{1,900}");
    private bj zzaCl;

    private GcmPubSub(Context context)
    {
        zzaCl = bj.FF70(context);
    }

    public static GcmPubSub getInstance(Context context)
    {
        com/google/android/gms/gcm/GcmPubSub;
        JVM INSTR monitorenter ;
        if (zzaCk == null)
        {
            zzaCk = new GcmPubSub(context);
        }
        context = zzaCk;
        com/google/android/gms/gcm/GcmPubSub;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public void subscribe(String s, String s1, Bundle bundle)
    {
        if (s == null || s.isEmpty())
        {
            throw new IllegalArgumentException((new StringBuilder("Invalid appInstanceToken: ")).append(s).toString());
        }
        if (s1 == null || !zzaCm.matcher(s1).matches())
        {
            throw new IllegalArgumentException((new StringBuilder("Invalid topic name: ")).append(s1).toString());
        }
        Bundle bundle1 = bundle;
        if (bundle == null)
        {
            bundle1 = new Bundle();
        }
        bundle1.putString("gcm.topic", s1);
        zzaCl._mth02CB(s, s1, bundle1);
    }

    public void unsubscribe(String s, String s1)
    {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", s1);
        zzaCl._mth02CA(s, s1, bundle);
    }

}
