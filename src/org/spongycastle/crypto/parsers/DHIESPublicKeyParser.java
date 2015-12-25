// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.parsers;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import org.spongycastle.crypto.KeyParser;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;

public class DHIESPublicKeyParser
    implements KeyParser
{

    private DHParameters amJ;

    public DHIESPublicKeyParser(DHParameters dhparameters)
    {
        amJ = dhparameters;
    }

    public final AsymmetricKeyParameter _mth02CA(ByteArrayInputStream bytearrayinputstream)
    {
        byte abyte0[] = new byte[(amJ.amM.bitLength() + 7) / 8];
        bytearrayinputstream.read(abyte0, 0, abyte0.length);
        return new DHPublicKeyParameters(new BigInteger(1, abyte0), amJ);
    }
}
