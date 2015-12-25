// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.jcajce.spec;

import java.security.spec.KeySpec;
import org.spongycastle.pqc.crypto.rainbow.Layer;

public class RainbowPrivateKeySpec
    implements KeySpec
{

    public Layer aKk[];
    public short aND[][];
    public short aNE[];
    public short aNG[][];
    public short aNH[];
    public int aNI[];

    public RainbowPrivateKeySpec(short aword0[][], short aword1[], short aword2[][], short aword3[], int ai[], Layer alayer[])
    {
        aND = aword0;
        aNE = aword1;
        aNG = aword2;
        aNH = aword3;
        aNI = ai;
        aKk = alayer;
    }
}
