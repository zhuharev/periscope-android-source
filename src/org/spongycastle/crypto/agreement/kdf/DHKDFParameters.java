// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.agreement.kdf;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.crypto.DerivationParameters;

public class DHKDFParameters
    implements DerivationParameters
{

    int Yp;
    ASN1ObjectIdentifier amP;
    byte amQ[];
    byte amR[];

    public DHKDFParameters(ASN1ObjectIdentifier asn1objectidentifier, int i, byte abyte0[])
    {
        this(asn1objectidentifier, i, abyte0, null);
    }

    private DHKDFParameters(ASN1ObjectIdentifier asn1objectidentifier, int i, byte abyte0[], byte abyte1[])
    {
        amP = asn1objectidentifier;
        Yp = i;
        amQ = abyte0;
        amR = null;
    }
}
