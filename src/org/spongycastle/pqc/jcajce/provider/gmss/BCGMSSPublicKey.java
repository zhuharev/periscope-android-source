// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.jcajce.provider.gmss;

import java.security.PublicKey;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.util.encoders.Hex;

public class BCGMSSPublicKey
    implements CipherParameters, PublicKey
{

    public String getAlgorithm()
    {
        return "GMSS";
    }

    public byte[] getEncoded()
    {
        org.spongycastle.asn1.ASN1ObjectIdentifier asn1objectidentifier = PQCObjectIdentifiers.aJZ;
        throw new NullPointerException();
    }

    public String getFormat()
    {
        return "X.509";
    }

    public String toString()
    {
        (new StringBuilder("GMSS public key : ")).append(new String(Hex._mth1D65(null))).append("\nHeight of Trees: \n").toString();
        throw new NullPointerException();
    }
}
