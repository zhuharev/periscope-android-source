// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.os.Parcel;
import android.os.Parcelable;

public class ContactsUploadResult
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    public final int successCount;
    public final int totalCount;

    ContactsUploadResult(int i, int j)
    {
        successCount = i;
        totalCount = j;
    }

    ContactsUploadResult(Parcel parcel)
    {
        successCount = parcel.readInt();
        totalCount = parcel.readInt();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(successCount);
        parcel.writeInt(totalCount);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final ContactsUploadResult createFromParcel(Parcel parcel)
        {
            return new ContactsUploadResult(parcel);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final ContactsUploadResult[] newArray(int i)
        {
            return new ContactsUploadResult[i];
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        _cls1()
        {
        }
    }

}
