// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.Serializable;

// Referenced classes of package o:
//            cq, co, cp

public abstract class cn
{

    private static _cls1427.if BU = null;
    private static int BV = 0;
    protected final String BW;
    protected final Object BX;
    private Object BY;

    protected cn(String s, Serializable serializable)
    {
        BY = null;
        BW = s;
        BX = serializable;
    }

    public static boolean isInitialized()
    {
        return false;
    }

    public static int _mth010B()
    {
        return 0;
    }

    public static cq _mth02BB(String s, String s1)
    {
        return new cq(s, s1);
    }

    public static co _mth02CA(String s, Long long1)
    {
        return new co(s, long1);
    }

    public static cp _mth02CA(String s, Integer integer)
    {
        return new cp(s, integer);
    }

    public final Object get()
    {
        return _mth02EE(BW);
    }

    protected abstract Serializable _mth02EE(String s);

}
