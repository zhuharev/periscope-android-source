// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.pkcs.DHParameter;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;

public class JCEDHPublicKey
    implements DHPublicKey
{

    private DHParameterSpec aCH;
    private BigInteger axe;

    private void readObject(ObjectInputStream objectinputstream)
    {
        axe = (BigInteger)objectinputstream.readObject();
        aCH = new DHParameterSpec((BigInteger)objectinputstream.readObject(), (BigInteger)objectinputstream.readObject(), objectinputstream.readInt());
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        objectoutputstream.writeObject(getY());
        objectoutputstream.writeObject(aCH.getP());
        objectoutputstream.writeObject(aCH.getG());
        objectoutputstream.writeInt(aCH.getL());
    }

    public String getAlgorithm()
    {
        return "DH";
    }

    public byte[] getEncoded()
    {
        return KeyUtil._mth02CA(new AlgorithmIdentifier(PKCSObjectIdentifiers.abl, new DHParameter(aCH.getP(), aCH.getG(), aCH.getL())), new ASN1Integer(axe));
    }

    public String getFormat()
    {
        return "X.509";
    }

    public DHParameterSpec getParams()
    {
        return aCH;
    }

    public BigInteger getY()
    {
        return axe;
    }
}
