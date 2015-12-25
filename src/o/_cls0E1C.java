// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.common.internal.BinderWrapper;

public final class _cls0E1C
    implements android.os.Parcelable.Creator
{

    public _cls0E1C()
    {
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return new BinderWrapper(parcel, (byte)0);
    }

    public final Object[] newArray(int i)
    {
        return new BinderWrapper[i];
    }
}
