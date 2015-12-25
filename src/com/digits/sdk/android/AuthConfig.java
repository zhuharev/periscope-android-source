// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

class AuthConfig
    implements Parcelable, Serializable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private static final long serialVersionUID = 0xca9f1ad1dccde79cL;
    public boolean isVoiceEnabled;
    public boolean tosUpdate;

    public AuthConfig()
    {
    }

    protected AuthConfig(Parcel parcel)
    {
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        tosUpdate = flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isVoiceEnabled = flag;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (AuthConfig)obj;
        return tosUpdate == ((AuthConfig) (obj)).tosUpdate && isVoiceEnabled == ((AuthConfig) (obj)).isVoiceEnabled;
    }

    public int hashCode()
    {
        int i;
        if (tosUpdate)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        int j;
        if (isVoiceEnabled)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        return i * 31 + j;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (tosUpdate)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (isVoiceEnabled)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final AuthConfig createFromParcel(Parcel parcel)
        {
            return new AuthConfig(parcel);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final AuthConfig[] newArray(int i)
        {
            return new AuthConfig[i];
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
