// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.google.android.gms.maps.model.LatLng;

// Referenced classes of package o:
//            mx, atn

public final class akv
    implements mx
{

    public final LatLng Ku;
    public final String broadcastId;

    private akv(String s, double d, double d1)
    {
        broadcastId = s;
        Ku = new LatLng(d, d1);
    }

    public static akv _mth037A(atn atn1)
    {
        if (atn1 != null)
        {
            double d = atn1.fb();
            double d1 = atn1.fc();
            boolean flag;
            if (d != 0.0D || d1 != 0.0D)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                return new akv(atn1.id(), atn1.fb(), atn1.fc());
            }
        }
        return null;
    }

    public final LatLng FC60()
    {
        return Ku;
    }
}
