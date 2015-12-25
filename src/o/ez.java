// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

// Referenced classes of package o:
//            fg, bh

public final class ez
{

    private final fg Ez;

    ez(fg fg1)
    {
        Ez = fg1;
    }

    public final Point _mth02CE(LatLng latlng)
    {
        try
        {
            latlng = (Point)bh._mth02CA(Ez._mth141D(latlng));
        }
        // Misplaced declaration of an exception variable
        catch (LatLng latlng)
        {
            throw new android.support.v4.app.Fragment.if(latlng);
        }
        return latlng;
    }

    public final VisibleRegion _mth0689()
    {
        VisibleRegion visibleregion;
        try
        {
            visibleregion = Ez._mth0689();
        }
        catch (RemoteException remoteexception)
        {
            throw new android.support.v4.app.Fragment.if(remoteexception);
        }
        return visibleregion;
    }
}
