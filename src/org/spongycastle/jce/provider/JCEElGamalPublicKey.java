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
import org.spongycastle.asn1.oiw.ElGamalParameter;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.jce.interfaces.ElGamalPublicKey;
import org.spongycastle.jce.spec.ElGamalParameterSpec;

public class JCEElGamalPublicKey
    implements ElGamalPublicKey, DHPublicKey
{

    private ElGamalParameterSpec aDz;
    private BigInteger axe;

    private void readObject(ObjectInputStream objectinputstream)
    {
        axe = (BigInteger)objectinputstream.readObject();
        aDz = new ElGamalParameterSpec((BigInteger)objectinputstream.readObject(), (BigInteger)objectinputstream.readObject());
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        objectoutputstream.writeObject(getY());
        objectoutputstream.writeObject(aDz.amM);
        objectoutputstream.writeObject(aDz.amO);
    }

    public String getAlgorithm()
    {
        return "ElGamal";
    }

    public byte[] getEncoded()
    {
        return KeyUtil._mth02CA(new AlgorithmIdentifier(OIWObjectIdentifiers.aay, new ElGamalParameter(aDz.amM, aDz.amO)), new ASN1Integer(axe));
    }

    public String getFormat()
    {
        return "X.509";
    }

    public DHParameterSpec getParams()
    {
        return new DHParameterSpec(aDz.amM, aDz.amO);
    }

    public BigInteger getY()
    {
        return axe;
    }

    public final ElGamalParameterSpec _mth15AC()
    {
        return aDz;
    }
}
