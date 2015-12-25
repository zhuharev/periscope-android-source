// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric.util;

import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.PBEKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class BCPBEKey
    implements PBEKey
{

    int Yp;
    private String aDc;
    public ASN1ObjectIdentifier aFE;
    private PBEKeySpec aFF;
    public boolean aFG;
    int aFv;
    public int aFw;
    public CipherParameters aso;
    int type;

    public BCPBEKey(String s, ASN1ObjectIdentifier asn1objectidentifier, int i, int j, int k, int l, PBEKeySpec pbekeyspec, 
            CipherParameters cipherparameters)
    {
        aFG = false;
        aDc = s;
        aFE = asn1objectidentifier;
        type = i;
        aFv = j;
        Yp = k;
        aFw = l;
        aFF = pbekeyspec;
        aso = cipherparameters;
    }

    public String getAlgorithm()
    {
        return aDc;
    }

    public byte[] getEncoded()
    {
        if (aso != null)
        {
            KeyParameter keyparameter;
            if (aso instanceof ParametersWithIV)
            {
                keyparameter = (KeyParameter)((ParametersWithIV)aso).axC;
            } else
            {
                keyparameter = (KeyParameter)aso;
            }
            return keyparameter.key;
        }
        if (type == 2)
        {
            return PBEParametersGenerator._mth02CF(aFF.getPassword());
        }
        if (type == 5)
        {
            return PBEParametersGenerator._mth02CE(aFF.getPassword());
        } else
        {
            return PBEParametersGenerator._mth02CB(aFF.getPassword());
        }
    }

    public String getFormat()
    {
        return "RAW";
    }

    public int getIterationCount()
    {
        return aFF.getIterationCount();
    }

    public char[] getPassword()
    {
        return aFF.getPassword();
    }

    public byte[] getSalt()
    {
        return aFF.getSalt();
    }
}
