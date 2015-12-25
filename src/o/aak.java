// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

// Referenced classes of package o:
//            dl, _cls09A8, cd, cl, 
//            _cls09AF, _cls09AA, dn, aal, 
//            _cls09B0, dg, FF6A, dj, 
//            aed

public final class aak
    implements _cls09AA._cls02CA, _cls09AA._cls02CB
{
    public static interface if
    {

        public abstract void _mth02CE(LocationSettingsResult locationsettingsresult);

        public abstract void _mth141D(String as[]);
    }


    public static final String bah[] = {
        "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"
    };
    public WeakReference bai;
    public _cls09AA baj;
    private LocationRequest bak;
    private LocationSettingsRequest bal;
    public if bam;
    private dj ban;
    private boolean bao;

    public aak(aed aed, aed aed1, aed aed2)
    {
        bai = new WeakReference(aed);
        bam = aed1;
        ban = aed2;
        aed1 = new _cls09AA.if(aed);
        if (this == null)
        {
            throw new NullPointerException(String.valueOf("Listener must not be null"));
        }
        ((_cls09AA.if) (aed1)).xc.add(this);
        if (this == null)
        {
            throw new NullPointerException(String.valueOf("Listener must not be null"));
        }
        ((_cls09AA.if) (aed1)).xd.add(this);
        aed = dl.Ck;
        if (aed == null)
        {
            throw new NullPointerException(String.valueOf("Api must not be null"));
        }
        ((_cls09AA.if) (aed1)).wX.put(aed, null);
        aed2 = ((_cls09AA.if) (aed1)).wT;
        aed._mth027B();
        aed2.addAll(Collections.emptyList());
        boolean flag;
        if (!((_cls09AA.if) (aed1)).wX.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new IllegalArgumentException(String.valueOf("must call addApi() to add at least one API"));
        }
        if (((_cls09AA.if) (aed1)).wY >= 0)
        {
            aed = new cd(((_cls09AA.if) (aed1)).mContext.getApplicationContext(), ((_cls09AA.if) (aed1)).wZ, aed1._mth0296(), ((_cls09AA.if) (aed1)).xa, ((_cls09AA.if) (aed1)).xb, ((_cls09AA.if) (aed1)).wX, ((_cls09AA.if) (aed1)).xc, ((_cls09AA.if) (aed1)).xd, ((_cls09AA.if) (aed1)).wY);
            aed2 = cl._mth02CA(null);
            if (aed2 == null)
            {
                (new Handler(((_cls09AA.if) (aed1)).mContext.getMainLooper())).post(new _cls09AF(aed1, aed));
            } else
            {
                aed2._mth02CA(((_cls09AA.if) (aed1)).wY, aed, null);
            }
        } else
        {
            aed = new cd(((_cls09AA.if) (aed1)).mContext, ((_cls09AA.if) (aed1)).wZ, aed1._mth0296(), ((_cls09AA.if) (aed1)).xa, ((_cls09AA.if) (aed1)).xb, ((_cls09AA.if) (aed1)).wX, ((_cls09AA.if) (aed1)).xc, ((_cls09AA.if) (aed1)).xd, -1);
        }
        baj = aed;
        aed = new LocationRequest();
        LocationRequest._mth1FBE(10000L);
        aed.CF = 10000L;
        if (!((LocationRequest) (aed)).CH)
        {
            aed.CG = (long)((double)((LocationRequest) (aed)).CF / 6D);
        }
        LocationRequest._mth1FBE(10000L);
        aed.CH = true;
        aed.CG = 10000L;
        aed.CK = 3F;
label0:
        do
        {
            switch (100)
            {
            case 101: // 'e'
            case 103: // 'g'
            default:
                break;

            case 100: // 'd'
            case 102: // 'f'
            case 104: // 'h'
            case 105: // 'i'
                aed.mPriority = 100;
                break label0;
            }
        } while (true);
        bak = aed;
        aed = new com.google.android.gms.location.LocationSettingsRequest.if();
        aed1 = bak;
        ((com.google.android.gms.location.LocationSettingsRequest.if) (aed)).CV.add(aed1);
        bal = new LocationSettingsRequest(((com.google.android.gms.location.LocationSettingsRequest.if) (aed)).CV, false, false, false);
    }

    static if _mth02CA(aak aak1)
    {
        return aak1.bam;
    }

    public final void S()
    {
        if (!baj.isConnected())
        {
            bao = true;
            return;
        }
        dl.CQ._mth02CA(baj, bal)._mth02CA(new aal(this));
        Activity activity = (Activity)bai.get();
        boolean flag;
        if (activity != null)
        {
            flag = _cls141D.if._mth02CA(activity, bah);
        } else
        {
            flag = false;
        }
        if (flag)
        {
            dl.CP._mth02CA(baj, bak, ban);
        }
    }

    public final void T()
    {
        if (!baj.isConnected())
        {
            bao = false;
            return;
        }
        Activity activity = (Activity)bai.get();
        boolean flag;
        if (activity != null)
        {
            flag = _cls141D.if._mth02CA(activity, bah);
        } else
        {
            flag = false;
        }
        if (flag)
        {
            dl.CP._mth02CA(baj, ban);
        }
    }

    public final void connect()
    {
        if (!baj.isConnected() && !baj.isConnecting())
        {
            Activity activity = (Activity)bai.get();
            boolean flag;
            if (activity != null)
            {
                flag = _cls141D.if._mth02CA(activity, bah);
            } else
            {
                flag = false;
            }
            if (flag)
            {
                baj.connect();
            }
        }
    }

    public final void _mth02C1(int i)
    {
        connect();
    }

    public final void _mth02CA(ConnectionResult connectionresult)
    {
        FF6A._mth02CA("LocationManager", (new StringBuilder("onConnectionFailed ")).append(connectionresult).toString());
    }

    public final void _mth141D(Bundle bundle)
    {
        if (bao)
        {
            S();
        }
    }

}
