// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// Referenced classes of package o:
//            mw

public final class nc
    implements mw
{

    private final LatLng KB;
    public final ArrayList KC = new ArrayList();

    public nc(LatLng latlng)
    {
        KB = latlng;
    }

    public final int getSize()
    {
        return KC.size();
    }

    public final String toString()
    {
        return (new StringBuilder("StaticCluster{mCenter=")).append(KB).append(", mItems.size=").append(KC.size()).append('}').toString();
    }

    public final Collection _mth1595()
    {
        return KC;
    }

    public final LatLng FC60()
    {
        return KB;
    }
}
