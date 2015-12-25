// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.dstu;

import java.io.IOException;
import java.security.SignatureException;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.DEROctetString;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.dstu:
//            SignatureSpi

public class SignatureSpiLe extends SignatureSpi
{

    public SignatureSpiLe()
    {
    }

    private static void _mth1D40(byte abyte0[])
    {
        for (int i = 0; i < abyte0.length / 2; i++)
        {
            byte byte0 = abyte0[i];
            abyte0[i] = abyte0[abyte0.length - 1 - i];
            abyte0[abyte0.length - 1 - i] = byte0;
        }

    }

    protected byte[] engineSign()
    {
        byte abyte0[] = ASN1OctetString.FB39(super.engineSign())._mth0501();
        _mth1D40(abyte0);
        try
        {
            abyte0 = (new DEROctetString(abyte0)).getEncoded();
        }
        catch (Exception exception)
        {
            throw new SignatureException(exception.toString());
        }
        return abyte0;
    }

    protected boolean engineVerify(byte abyte0[])
    {
        try
        {
            abyte0 = ((ASN1OctetString)ASN1OctetString._mth0640(abyte0))._mth0501();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new SignatureException("error decoding signature bytes.");
        }
        _mth1D40(abyte0);
        boolean flag;
        try
        {
            flag = super.engineVerify((new DEROctetString(abyte0)).getEncoded());
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw abyte0;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new SignatureException(abyte0.toString());
        }
        return flag;
    }
}
