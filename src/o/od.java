// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Hashtable;
import java.util.Vector;

// Referenced classes of package o:
//            pf, ny, os, oa, 
//            aul, ow, or, ob

final class od extends pf
{

    od(Vector vector, int i, int j, Hashtable hashtable)
    {
        super(vector, i, j, hashtable);
    }

    public final void shutdown()
    {
        if (NK != null)
        {
            NK.shutdown();
        }
    }

    final void _mth02CB(oa oa1)
    {
        Object obj;
        try
        {
            aul._mth02BE("PubNub", oa1.getUrl());
            obj = NK._mth02CA(oa1.getUrl(), null);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            aul._mth02BE("PubNub", (new StringBuilder("Pubnub Exception in Fetch : ")).append(((os) (obj)).Nq).toString());
            if (!NI)
            {
                oa1.LY._mth02CB(((os) (obj)).Nq);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            aul._mth02BE("PubNub", (new StringBuilder("Exception in Fetch : ")).append(((Exception) (obj)).toString()).toString());
            if (!NI)
            {
                oa1.LY._mth02CB(or._mth02CA(or.Nb, 2, ((Exception) (obj)).toString()));
            }
            return;
        }
        if (!NI)
        {
            oa1.LY._mth02CA(oa1, ((ob) (obj)).response);
        }
    }
}
