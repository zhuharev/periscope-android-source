// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.chatman.api;

import o.auh;
import o.ig;
import o.is;

// Referenced classes of package tv.periscope.chatman.api:
//            Kind

public class WireMessage
{

    public static final int WIRE_AUTH = 3;
    public static final int WIRE_CHAT = 1;
    public static final int WIRE_CONTROL = 2;
    public final int kind;
    public final String payload;

    private WireMessage(int i, String s)
    {
        kind = i;
        payload = s;
    }

    public static WireMessage create(Kind kind1)
    {
        int i = kind1.kind();
        ig ig1 = auh.bFf;
        if (kind1 == null)
        {
            kind1 = ig1._mth02CA(is.GB);
        } else
        {
            kind1 = ig1._mth02CA(kind1, kind1.getClass());
        }
        return new WireMessage(i, kind1);
    }
}
