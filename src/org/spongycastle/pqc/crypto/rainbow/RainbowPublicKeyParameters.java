// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.rainbow;


// Referenced classes of package org.spongycastle.pqc.crypto.rainbow:
//            RainbowKeyParameters

public class RainbowPublicKeyParameters extends RainbowKeyParameters
{

    public short aNO[][];
    public short aNP[][];
    public short aNQ[];

    public RainbowPublicKeyParameters(int i, short aword0[][], short aword1[][], short aword2[])
    {
        super(false, i);
        aNO = aword0;
        aNP = aword1;
        aNQ = aword2;
    }
}
