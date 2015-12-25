// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.InputStream;

// Referenced classes of package o:
//            FEE9, _cls1F33, _cls1503, _cls05D4

public final class _cls1529
    implements FEE9
{

    private final FEE9 qx;

    public _cls1529(_cls1503 _pcls1503)
    {
        qx = _pcls1503;
    }

    public final String getId()
    {
        return qx.getId();
    }

    public final _cls05D4 _mth02CB(Object obj, int i, int j)
    {
        obj = (InputStream)obj;
        return qx._mth02CB(new _cls1F33(((InputStream) (obj)), null), i, j);
    }
}
