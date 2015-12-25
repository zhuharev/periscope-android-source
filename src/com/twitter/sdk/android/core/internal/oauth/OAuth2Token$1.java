// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal.oauth;

import android.os.Parcel;

// Referenced classes of package com.twitter.sdk.android.core.internal.oauth:
//            OAuth2Token

final class 
    implements android.os.ator
{

    public final OAuth2Token createFromParcel(Parcel parcel)
    {
        return new OAuth2Token(parcel, null);
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public final OAuth2Token[] newArray(int i)
    {
        return new OAuth2Token[i];
    }

    public final volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
