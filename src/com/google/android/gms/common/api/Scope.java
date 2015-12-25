// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import o.0E16;

public final class Scope
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls0E16();
    public final int wB;
    public final String xh;

    public Scope(int i, String s)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException(String.valueOf("scopeUri must not be null or empty"));
        } else
        {
            wB = i;
            xh = s;
            return;
        }
    }

    public Scope(String s)
    {
        this(1, s);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof Scope))
        {
            return false;
        } else
        {
            return xh.equals(((Scope)obj).xh);
        }
    }

    public final int hashCode()
    {
        return xh.hashCode();
    }

    public final String toString()
    {
        return xh;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        _cls0E16._mth02CA(this, parcel);
    }

}
