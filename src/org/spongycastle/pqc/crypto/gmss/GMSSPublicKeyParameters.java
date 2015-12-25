// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.gmss;


// Referenced classes of package org.spongycastle.pqc.crypto.gmss:
//            GMSSKeyParameters, GMSSParameters

public class GMSSPublicKeyParameters extends GMSSKeyParameters
{

    byte aLj[];

    public GMSSPublicKeyParameters(byte abyte0[], GMSSParameters gmssparameters)
    {
        super(false, gmssparameters);
        aLj = abyte0;
    }
}
