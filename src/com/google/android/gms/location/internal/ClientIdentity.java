// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import o.dq;

public class ClientIdentity
    implements SafeParcelable
{

    public static final dq CREATOR = new dq();
    public final String packageName;
    public final int uid;
    public final int wB;

    public ClientIdentity(int i, int j, String s)
    {
        wB = i;
        uid = j;
        packageName = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj == null || !(obj instanceof ClientIdentity))
        {
            return false;
        }
        obj = (ClientIdentity)obj;
        if (((ClientIdentity) (obj)).uid == uid)
        {
            obj = ((ClientIdentity) (obj)).packageName;
            String s = packageName;
            boolean flag;
            if (obj == s || obj != null && obj.equals(s))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return uid;
    }

    public String toString()
    {
        return String.format("%d:%s", new Object[] {
            Integer.valueOf(uid), packageName
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        dq._mth02CA(this, parcel);
    }

}
