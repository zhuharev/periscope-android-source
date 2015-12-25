// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;

// Referenced classes of package org.spongycastle.pqc.crypto.mceliece:
//            McElieceCCA2Parameters

public class McElieceCCA2KeyParameters extends AsymmetricKeyParameter
{

    public McElieceCCA2Parameters aLQ;

    public McElieceCCA2KeyParameters(boolean flag, McElieceCCA2Parameters mceliececca2parameters)
    {
        super(flag);
        aLQ = mceliececca2parameters;
    }
}
