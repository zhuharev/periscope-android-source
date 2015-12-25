// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.MarkerOptions;

// Referenced classes of package o:
//            fc, gj, eq, es, 
//            fa, ez

public final class er
{
    public static interface if
    {

        public abstract void _mth02CA(CameraPosition cameraposition);
    }

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}


    public final fc DV;
    private fa DW;

    protected er(fc fc1)
    {
        if (fc1 == null)
        {
            throw new NullPointerException("null reference");
        } else
        {
            DV = (fc)fc1;
            return;
        }
    }

    public final gj _mth02CA(MarkerOptions markeroptions)
    {
        try
        {
            markeroptions = DV._mth02CB(markeroptions);
        }
        // Misplaced declaration of an exception variable
        catch (MarkerOptions markeroptions)
        {
            throw new android.support.v4.app.Fragment.if(markeroptions);
        }
        if (markeroptions == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        markeroptions = new gj(markeroptions);
        return markeroptions;
        return null;
    }

    public final void _mth02CA(eq eq1, int i, _cls1427.if if1)
    {
        try
        {
            DV._mth02CA(eq1.DU, 300, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (eq eq1)
        {
            throw new android.support.v4.app.Fragment.if(eq1);
        }
    }

    public final void _mth02CA(_cls02CB _pcls02cb)
    {
        if (_pcls02cb == null)
        {
            try
            {
                DV._mth02CA(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (_cls02CB _pcls02cb)
            {
                throw new android.support.v4.app.Fragment.if(_pcls02cb);
            }
        }
        DV._mth02CA(new es(this, _pcls02cb));
        return;
    }

    public final CameraPosition _mth0447()
    {
        CameraPosition cameraposition;
        try
        {
            cameraposition = DV._mth0447();
        }
        catch (RemoteException remoteexception)
        {
            throw new android.support.v4.app.Fragment.if(remoteexception);
        }
        return cameraposition;
    }

    public final float _mth0453()
    {
        float f;
        try
        {
            f = DV._mth0453();
        }
        catch (RemoteException remoteexception)
        {
            throw new android.support.v4.app.Fragment.if(remoteexception);
        }
        return f;
    }

    public final fa _mth05D1()
    {
        fa fa1;
        try
        {
            if (DW == null)
            {
                DW = new fa(DV._mth13B1());
            }
            fa1 = DW;
        }
        catch (RemoteException remoteexception)
        {
            throw new android.support.v4.app.Fragment.if(remoteexception);
        }
        return fa1;
    }

    public final ez _mth05F0()
    {
        ez ez1;
        try
        {
            ez1 = new ez(DV._mth13D3());
        }
        catch (RemoteException remoteexception)
        {
            throw new android.support.v4.app.Fragment.if(remoteexception);
        }
        return ez1;
    }
}
