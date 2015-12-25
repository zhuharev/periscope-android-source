// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;

public class McElieceCCA2ParameterSpec
    implements AlgorithmParameterSpec
{

    private String aOq;

    public McElieceCCA2ParameterSpec()
    {
        this("SHA256");
    }

    private McElieceCCA2ParameterSpec(String s)
    {
        aOq = s;
    }
}
