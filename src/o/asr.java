// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.concurrent.Callable;

// Referenced classes of package o:
//            asq

final class asr
    implements Callable
{

    private asq bDu;

    asr(asq asq)
    {
        bDu = asq;
        super();
    }

    public final volatile Object call()
    {
        return Boolean.TRUE;
    }
}
