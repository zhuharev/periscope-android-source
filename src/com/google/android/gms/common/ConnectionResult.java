// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import o.152C;
import o.1605;

public final class ConnectionResult
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1605();
    public static final ConnectionResult wA = new ConnectionResult(0);
    public final PendingIntent mPendingIntent;
    public final int wB;
    public final int wC;
    public final String wD;

    private ConnectionResult(int i)
    {
        this(0, null, null);
    }

    public ConnectionResult(int i, int j, PendingIntent pendingintent, String s)
    {
        wB = i;
        wC = j;
        mPendingIntent = pendingintent;
        wD = s;
    }

    public ConnectionResult(int i, PendingIntent pendingintent)
    {
        this(i, pendingintent, null);
    }

    private ConnectionResult(int i, PendingIntent pendingintent, String s)
    {
        this(1, i, pendingintent, null);
    }

    public static String FE7E(int i)
    {
        switch (i)
        {
        case 0: // '\0'
            return "SUCCESS";

        case 1: // '\001'
            return "SERVICE_MISSING";

        case 2: // '\002'
            return "SERVICE_VERSION_UPDATE_REQUIRED";

        case 3: // '\003'
            return "SERVICE_DISABLED";

        case 4: // '\004'
            return "SIGN_IN_REQUIRED";

        case 5: // '\005'
            return "INVALID_ACCOUNT";

        case 6: // '\006'
            return "RESOLUTION_REQUIRED";

        case 7: // '\007'
            return "NETWORK_ERROR";

        case 8: // '\b'
            return "INTERNAL_ERROR";

        case 9: // '\t'
            return "SERVICE_INVALID";

        case 10: // '\n'
            return "DEVELOPER_ERROR";

        case 11: // '\013'
            return "LICENSE_CHECK_FAILED";

        case 13: // '\r'
            return "CANCELED";

        case 14: // '\016'
            return "TIMEOUT";

        case 15: // '\017'
            return "INTERRUPTED";

        case 16: // '\020'
            return "API_UNAVAILABLE";

        case 17: // '\021'
            return "SIGN_IN_FAILED";

        case 18: // '\022'
            return "SERVICE_UPDATING";

        case 19: // '\023'
            return "SERVICE_MISSING_PERMISSION";
        }
        return (new StringBuilder("UNKNOWN_ERROR_CODE(")).append(i).append(")").toString();
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof ConnectionResult))
        {
            return false;
        }
        obj = (ConnectionResult)obj;
        if (wC == ((ConnectionResult) (obj)).wC)
        {
            PendingIntent pendingintent = mPendingIntent;
            PendingIntent pendingintent1 = ((ConnectionResult) (obj)).mPendingIntent;
            boolean flag;
            if (pendingintent == pendingintent1 || pendingintent != null && pendingintent.equals(pendingintent1))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                String s = wD;
                obj = ((ConnectionResult) (obj)).wD;
                boolean flag1;
                if (s == obj || s != null && s.equals(obj))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag1)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            Integer.valueOf(wC), mPendingIntent, wD
        });
    }

    public final String toString()
    {
        return (new _cls152C(this, (byte)0))._mth02CA("statusCode", FE7E(wC))._mth02CA("resolution", mPendingIntent)._mth02CA("message", wD).toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        _cls1605._mth02CA(this, parcel, i);
    }

}
