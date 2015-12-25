// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.prng;


// Referenced classes of package org.spongycastle.crypto.prng:
//            ThreadedSeedGenerator

class 
    implements Runnable
{

    private volatile int Wr;
    private volatile boolean ayk;

    public void run()
    {
        do
        {
            boolean flag = ayk;
            Wr = Wr + 1;
        } while (true);
    }
}
