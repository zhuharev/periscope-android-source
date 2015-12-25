// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;

// Referenced classes of package o:
//            gq, gi

public final class gj
{

    public final gq Fj;

    public gj(gq gq1)
    {
        if (gq1 == null)
        {
            throw new NullPointerException("null reference");
        } else
        {
            Fj = (gq)gq1;
            return;
        }
    }

    public final boolean equals(Object obj)
    {
        if (!(obj instanceof gj))
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = Fj._mth02BD(((gj)obj).Fj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new android.support.v4.app.Fragment.if(((RemoteException) (obj)));
        }
        return flag;
    }

    public final String getId()
    {
        String s;
        try
        {
            s = Fj.getId();
        }
        catch (RemoteException remoteexception)
        {
            throw new android.support.v4.app.Fragment.if(remoteexception);
        }
        return s;
    }

    public final int hashCode()
    {
        int i;
        try
        {
            i = Fj.FEE9();
        }
        catch (RemoteException remoteexception)
        {
            throw new android.support.v4.app.Fragment.if(remoteexception);
        }
        return i;
    }

    public final void remove()
    {
        try
        {
            Fj.remove();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new android.support.v4.app.Fragment.if(remoteexception);
        }
    }

    public final void _mth02BB(LatLng latlng)
    {
        try
        {
            Fj._mth02BB(latlng);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (LatLng latlng)
        {
            throw new android.support.v4.app.Fragment.if(latlng);
        }
    }

    public final void _mth02CA(gi gi1)
    {
        try
        {
            Fj._mth02C8(gi1.DU);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (gi gi1)
        {
            throw new android.support.v4.app.Fragment.if(gi1);
        }
    }

    public final LatLng FC60()
    {
        LatLng latlng;
        try
        {
            latlng = Fj.FC60();
        }
        catch (RemoteException remoteexception)
        {
            throw new android.support.v4.app.Fragment.if(remoteexception);
        }
        return latlng;
    }
}
