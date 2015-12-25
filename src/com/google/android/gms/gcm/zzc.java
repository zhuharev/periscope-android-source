// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.gcm;

import android.os.Bundle;

public class zzc
{

    public static final zzc zzaCI = new zzc(0, 30, 3600);
    public static final zzc zzaCJ = new zzc(1, 30, 3600);
    private final int zzaCK;
    private final int zzaCL;
    private final int zzaCM;

    private zzc(int i, int j, int k)
    {
        zzaCK = i;
        zzaCL = j;
        zzaCM = k;
    }

    public int zzvZ()
    {
        return zzaCK;
    }

    public int zzwa()
    {
        return zzaCL;
    }

    public int zzwb()
    {
        return zzaCM;
    }

    public Bundle zzz(Bundle bundle)
    {
        bundle.putInt("retry_policy", zzaCK);
        bundle.putInt("initial_backoff_seconds", zzaCL);
        bundle.putInt("maximum_backoff_seconds", zzaCM);
        return bundle;
    }

}
