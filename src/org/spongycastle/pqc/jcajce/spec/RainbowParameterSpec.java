// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;

public class RainbowParameterSpec
    implements AlgorithmParameterSpec
{

    private static final int aNN[] = {
        6, 12, 17, 22, 33
    };
    public int aNI[];

    public RainbowParameterSpec()
    {
        aNI = aNN;
    }

}
