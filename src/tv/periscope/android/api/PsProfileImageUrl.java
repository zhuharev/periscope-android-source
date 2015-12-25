// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.api;

import android.os.Parcel;
import android.os.Parcelable;

public class PsProfileImageUrl
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    public int height;
    public String url;
    public int width;

    public PsProfileImageUrl(Parcel parcel)
    {
        url = parcel.readString();
        width = parcel.readInt();
        height = parcel.readInt();
    }

    public PsProfileImageUrl(String s)
    {
        url = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(url);
        parcel.writeInt(width);
        parcel.writeInt(height);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final PsProfileImageUrl createFromParcel(Parcel parcel)
        {
            return new PsProfileImageUrl(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        public final PsProfileImageUrl[] newArray(int i)
        {
            return new PsProfileImageUrl[i];
        }

        _cls1()
        {
        }
    }

}
