// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.gmss;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;

// Referenced classes of package org.spongycastle.pqc.crypto.gmss:
//            GMSSParameters

public class GMSSKeyParameters extends AsymmetricKeyParameter
{

    GMSSParameters aKr;

    public GMSSKeyParameters(boolean flag, GMSSParameters gmssparameters)
    {
        super(flag);
        aKr = gmssparameters;
    }
}
