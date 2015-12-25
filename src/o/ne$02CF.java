// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.google.android.gms.maps.model.LatLng;

// Referenced classes of package o:
//            ne, gj

static final class <init>
{

    LatLng FA;
    final gj KY;

    public final boolean equals(Object obj)
    {
        if (obj instanceof Object)
        {
            return KY.equals(((Object)obj).KY);
        } else
        {
            return false;
        }
    }

    public final int hashCode()
    {
        return KY.hashCode();
    }

    private Object(gj gj1)
    {
        KY = gj1;
        FA = gj1.FC60();
    }

    FA(gj gj1, byte byte0)
    {
        this(gj1);
    }
}
