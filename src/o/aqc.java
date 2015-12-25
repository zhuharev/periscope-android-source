// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Bundle;

// Referenced classes of package o:
//            ev, _cls0675

public final class aqc
{

    public static boolean bzG = false;
    public final ev bzH;
    public boolean mCreated;

    public aqc(ev ev1)
    {
        bzH = ev1;
    }

    public final boolean _mth02BD(Bundle bundle)
    {
        try
        {
            bzH.onCreate(null);
            mCreated = true;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            _cls0675._mth02CB(new Exception("Failed to initialize map view", bundle));
            bzG = true;
            mCreated = false;
        }
        return mCreated;
    }

}
