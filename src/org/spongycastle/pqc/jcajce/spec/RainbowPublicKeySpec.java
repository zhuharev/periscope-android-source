// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.jcajce.spec;

import java.security.spec.KeySpec;

public class RainbowPublicKeySpec
    implements KeySpec
{

    public int aNM;
    public short aNO[][];
    public short aNP[][];
    public short aNQ[];

    public RainbowPublicKeySpec(int i, short aword0[][], short aword1[][], short aword2[])
    {
        aNM = i;
        aNO = aword0;
        aNP = aword1;
        aNQ = aword2;
    }
}
