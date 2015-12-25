// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.parsers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.crypto.KeyParser;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.math.ec.ECCurve;

public class ECIESPublicKeyParser
    implements KeyParser
{

    private ECDomainParameters axL;

    public ECIESPublicKeyParser(ECDomainParameters ecdomainparameters)
    {
        axL = ecdomainparameters;
    }

    public final AsymmetricKeyParameter _mth02CA(ByteArrayInputStream bytearrayinputstream)
    {
        int i = bytearrayinputstream.read();
        byte abyte0[];
        switch (i)
        {
        case 0: // '\0'
            throw new IOException("Sender's public key invalid.");

        case 2: // '\002'
        case 3: // '\003'
            abyte0 = new byte[(axL.alm.getFieldSize() + 7) / 8 + 1];
            break;

        case 4: // '\004'
        case 6: // '\006'
        case 7: // '\007'
            abyte0 = new byte[((axL.alm.getFieldSize() + 7) / 8) * 2 + 1];
            break;

        case 1: // '\001'
        case 5: // '\005'
        default:
            throw new IOException((new StringBuilder("Sender's public key has invalid point encoding 0x")).append(Integer.toString(i, 16)).toString());
        }
        abyte0[0] = (byte)i;
        bytearrayinputstream.read(abyte0, 1, abyte0.length - 1);
        return new ECPublicKeyParameters(axL.alm._mth01C3(abyte0), axL);
    }
}
