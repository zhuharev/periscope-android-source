// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.util;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import o.aoq;

public class Size
    implements Parcelable, Serializable
{

    public static final android.os.Parcelable.Creator CREATOR = new aoq();
    public static final Size bvm = new Size();
    public final int bac;
    public final int _fld0575;

    private Size()
    {
        this(0, 0);
    }

    private Size(int i, int j)
    {
        bac = i;
        _fld0575 = j;
    }

    public Size(Parcel parcel)
    {
        bac = parcel.readInt();
        _fld0575 = parcel.readInt();
    }

    public static Size _mth02BE(float f, float f1)
    {
        int i = (int)f;
        int j = (int)f1;
        if (i != 0 || j != 0)
        {
            return new Size(i, j);
        } else
        {
            return bvm;
        }
    }

    public static Size _mth02CA(android.hardware.Camera.Size size)
    {
        int i = size.width;
        int j = size.height;
        if (i != 0 || j != 0)
        {
            return new Size(i, j);
        } else
        {
            return bvm;
        }
    }

    public static Size _mth05D5(int i, int j)
    {
        if (i != 0 || j != 0)
        {
            return new Size(i, j);
        } else
        {
            return bvm;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || obj != null && super.getClass() == obj.getClass() && _mth02CA((Size)obj);
    }

    public int hashCode()
    {
        return (bac << 16) + _fld0575;
    }

    public String toString()
    {
        return String.format("[w: %d, h: %d]", new Object[] {
            Integer.valueOf(bac), Integer.valueOf(_fld0575)
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(bac);
        parcel.writeInt(_fld0575);
    }

    public final boolean _mth02CA(Size size)
    {
        return this == size || size != null && bac == size.bac && _fld0575 == size._fld0575;
    }

}
