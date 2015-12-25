// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.twitter.sdk.android.core.Session;

// Referenced classes of package o:
//            up, ur

public final class uq
{

    public final up TV;
    public final String key;
    public final ur serializer;

    public uq(up up1, ur ur1, String s)
    {
        TV = up1;
        serializer = ur1;
        key = s;
    }

    public final void _mth02CA(Session session)
    {
        TV._mth02CA(TV.edit().putString(key, serializer.serialize(session)));
    }
}
