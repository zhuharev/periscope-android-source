// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import o.09F0;
import o.0E17;
import o.152C;

public final class Status
    implements _cls09F0, SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls0E17();
    public static final Status xi = new Status(0);
    public static final Status xj = new Status(8);
    public static final Status xk = new Status(15);
    public static final Status xl = new Status(16);
    public final PendingIntent mPendingIntent;
    public final int wB;
    public final int wC;
    public final String wD;

    public Status(int i)
    {
        this(i, null);
    }

    public Status(int i, int j, String s, PendingIntent pendingintent)
    {
        wB = i;
        wC = j;
        wD = s;
        mPendingIntent = pendingintent;
    }

    public Status(int i, String s)
    {
        this(1, i, s, null);
    }

    public Status(int i, String s, PendingIntent pendingintent)
    {
        this(1, 8, s, null);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (!(obj instanceof Status))
        {
            return false;
        }
        obj = (Status)obj;
        if (wB == ((Status) (obj)).wB && wC == ((Status) (obj)).wC)
        {
            String s = wD;
            String s1 = ((Status) (obj)).wD;
            boolean flag;
            if (s == s1 || s != null && s.equals(s1))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                PendingIntent pendingintent = mPendingIntent;
                obj = ((Status) (obj)).mPendingIntent;
                boolean flag1;
                if (pendingintent == obj || pendingintent != null && pendingintent.equals(obj))
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
            Integer.valueOf(wB), Integer.valueOf(wC), wD, mPendingIntent
        });
    }

    public final String toString()
    {
        _cls152C _lcls152c = new _cls152C(this, (byte)0);
        String s;
        if (wD != null)
        {
            s = wD;
        } else
        {
            int i = wC;
            switch (i)
            {
            case -1: 
                s = "SUCCESS_CACHE";
                break;

            case 0: // '\0'
                s = "SUCCESS";
                break;

            case 1: // '\001'
                s = "SERVICE_MISSING";
                break;

            case 2: // '\002'
                s = "SERVICE_VERSION_UPDATE_REQUIRED";
                break;

            case 3: // '\003'
                s = "SERVICE_DISABLED";
                break;

            case 4: // '\004'
                s = "SIGN_IN_REQUIRED";
                break;

            case 5: // '\005'
                s = "INVALID_ACCOUNT";
                break;

            case 6: // '\006'
                s = "RESOLUTION_REQUIRED";
                break;

            case 7: // '\007'
                s = "NETWORK_ERROR";
                break;

            case 8: // '\b'
                s = "INTERNAL_ERROR";
                break;

            case 9: // '\t'
                s = "SERVICE_INVALID";
                break;

            case 10: // '\n'
                s = "DEVELOPER_ERROR";
                break;

            case 11: // '\013'
                s = "LICENSE_CHECK_FAILED";
                break;

            case 13: // '\r'
                s = "ERROR";
                break;

            case 14: // '\016'
                s = "INTERRUPTED";
                break;

            case 15: // '\017'
                s = "TIMEOUT";
                break;

            case 16: // '\020'
                s = "CANCELED";
                break;

            case 17: // '\021'
                s = "API_NOT_CONNECTED";
                break;

            case 3000: 
                s = "AUTH_API_INVALID_CREDENTIALS";
                break;

            case 3001: 
                s = "AUTH_API_ACCESS_FORBIDDEN";
                break;

            case 3002: 
                s = "AUTH_API_CLIENT_ERROR";
                break;

            case 3003: 
                s = "AUTH_API_SERVER_ERROR";
                break;

            case 3004: 
                s = "AUTH_TOKEN_ERROR";
                break;

            case 3005: 
                s = "AUTH_URL_RESOLUTION";
                break;

            default:
                s = (new StringBuilder("unknown status code: ")).append(i).toString();
                break;
            }
        }
        return _lcls152c._mth02CA("statusCode", s)._mth02CA("resolution", mPendingIntent).toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        _cls0E17._mth02CA(this, parcel, i);
    }

    public final Status _mth0390()
    {
        return this;
    }

}
