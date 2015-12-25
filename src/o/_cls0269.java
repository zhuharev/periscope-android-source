// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;

// Referenced classes of package o:
//            FE7E

class _cls0269
    implements android.os.Parcelable.ClassLoaderCreator
{

    private final FE7E _fld0630;

    public _cls0269(FE7E fe7e)
    {
        _fld0630 = fe7e;
    }

    public Object createFromParcel(Parcel parcel)
    {
        return _fld0630.createFromParcel(parcel, null);
    }

    public Object createFromParcel(Parcel parcel, ClassLoader classloader)
    {
        return _fld0630.createFromParcel(parcel, classloader);
    }

    public Object[] newArray(int i)
    {
        return _fld0630.newArray(i);
    }
}
