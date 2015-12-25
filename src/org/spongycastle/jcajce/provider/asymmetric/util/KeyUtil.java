// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.util;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;

public class KeyUtil
{

    public KeyUtil()
    {
    }

    public static byte[] _mth02CA(AlgorithmIdentifier algorithmidentifier, ASN1Object asn1object)
    {
        try
        {
            algorithmidentifier = _mth02CF(new SubjectPublicKeyInfo(algorithmidentifier, asn1object));
        }
        // Misplaced declaration of an exception variable
        catch (AlgorithmIdentifier algorithmidentifier)
        {
            return null;
        }
        return algorithmidentifier;
    }

    public static byte[] _mth02CB(AlgorithmIdentifier algorithmidentifier, ASN1Object asn1object)
    {
        try
        {
            algorithmidentifier = _mth02CE(new PrivateKeyInfo(algorithmidentifier, asn1object._mth0427()));
        }
        // Misplaced declaration of an exception variable
        catch (AlgorithmIdentifier algorithmidentifier)
        {
            return null;
        }
        return algorithmidentifier;
    }

    private static byte[] _mth02CE(PrivateKeyInfo privatekeyinfo)
    {
        try
        {
            privatekeyinfo = privatekeyinfo.getEncoded("DER");
        }
        // Misplaced declaration of an exception variable
        catch (PrivateKeyInfo privatekeyinfo)
        {
            return null;
        }
        return privatekeyinfo;
    }

    public static byte[] _mth02CF(SubjectPublicKeyInfo subjectpublickeyinfo)
    {
        try
        {
            subjectpublickeyinfo = subjectpublickeyinfo.getEncoded("DER");
        }
        // Misplaced declaration of an exception variable
        catch (SubjectPublicKeyInfo subjectpublickeyinfo)
        {
            return null;
        }
        return subjectpublickeyinfo;
    }
}
