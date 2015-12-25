// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;

// Referenced classes of package o:
//            FE7E

public final class _cls1483
    implements FE7E
{

    public _cls1483()
    {
    }

    public final Object createFromParcel(Parcel parcel, ClassLoader classloader)
    {
        return new android.support.v4.view.ViewPager.SavedState(parcel, classloader);
    }

    public final volatile Object[] newArray(int i)
    {
        return new android.support.v4.view.ViewPager.SavedState[i];
    }
}
