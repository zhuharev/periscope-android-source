// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import tv.periscope.android.util.Size;

public final class aoq
    implements android.os.Parcelable.Creator
{

    public aoq()
    {
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return new Size(parcel);
    }

    public final volatile Object[] newArray(int i)
    {
        return new Size[i];
    }
}
