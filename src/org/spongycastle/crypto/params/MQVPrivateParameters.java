// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;

// Referenced classes of package org.spongycastle.crypto.params:
//            ECPrivateKeyParameters, ECPublicKeyParameters

public class MQVPrivateParameters
    implements CipherParameters
{

    public ECPrivateKeyParameters axv;
    public ECPrivateKeyParameters axw;
    public ECPublicKeyParameters axx;

    public MQVPrivateParameters(ECPrivateKeyParameters ecprivatekeyparameters, ECPrivateKeyParameters ecprivatekeyparameters1, ECPublicKeyParameters ecpublickeyparameters)
    {
        axv = ecprivatekeyparameters;
        axw = ecprivatekeyparameters1;
        axx = ecpublickeyparameters;
    }
}
