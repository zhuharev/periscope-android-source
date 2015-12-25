// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;


// Referenced classes of package org.spongycastle.crypto.engines:
//            ThreefishEngine

static abstract class atx
{

    protected final long atx[];
    protected final long aty[];

    abstract void _mth02CB(long al[], long al1[]);

    abstract void _mth02CE(long al[], long al1[]);

    protected (long al[], long al1[])
    {
        aty = al;
        atx = al1;
    }
}
