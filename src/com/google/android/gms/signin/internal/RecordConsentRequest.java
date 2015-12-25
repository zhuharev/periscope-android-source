// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import o.hs;

public class RecordConsentRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new hs();
    public final String Co;
    public final Scope FN[];
    public final int wB;
    public final Account xw;

    public RecordConsentRequest(int i, Account account, Scope ascope[], String s)
    {
        wB = i;
        xw = account;
        FN = ascope;
        Co = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        hs._mth02CA(this, parcel, i);
    }

}
