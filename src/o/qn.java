// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class qn
{

    private static final ExecutorService PZ = Executors.newCachedThreadPool();
    public boolean PM;
    boolean PN;
    boolean PO;
    boolean PP;
    boolean PQ;
    boolean PR;
    ExecutorService executorService;

    qn()
    {
        PN = true;
        PO = true;
        PP = true;
        PQ = true;
        PR = true;
        executorService = PZ;
    }

}
