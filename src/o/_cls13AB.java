// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;

public final class _cls13AB
    implements android.os.Parcelable.Creator
{

    public _cls13AB()
    {
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return new android.support.v7.widget.Toolbar.SavedState(parcel);
    }

    public final volatile Object[] newArray(int i)
    {
        return new android.support.v7.widget.Toolbar.SavedState[i];
    }
}
