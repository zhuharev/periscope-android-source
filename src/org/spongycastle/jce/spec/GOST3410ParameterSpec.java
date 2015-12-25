// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.cryptopro.GOST3410NamedParameters;
import org.spongycastle.asn1.cryptopro.GOST3410ParamSetParameters;
import org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.spongycastle.jce.interfaces.GOST3410Params;

// Referenced classes of package org.spongycastle.jce.spec:
//            GOST3410PublicKeyParameterSetSpec

public class GOST3410ParameterSpec
    implements AlgorithmParameterSpec, GOST3410Params
{

    public GOST3410PublicKeyParameterSetSpec aIk;
    public String aIl;
    public String aIm;
    public String aIn;

    public GOST3410ParameterSpec(String s)
    {
        this(s, CryptoProObjectIdentifiers.XZ.identifier, null);
    }

    private GOST3410ParameterSpec(String s, String s1)
    {
        this(s, s1, null);
    }

    public GOST3410ParameterSpec(String s, String s1, String s2)
    {
        GOST3410ParamSetParameters gost3410paramsetparameters;
        gost3410paramsetparameters = null;
        GOST3410ParamSetParameters gost3410paramsetparameters1 = GOST3410NamedParameters._mth02CF(new ASN1ObjectIdentifier(s));
        gost3410paramsetparameters = gost3410paramsetparameters1;
          goto _L1
_L3:
        ASN1ObjectIdentifier asn1objectidentifier = GOST3410NamedParameters._mth1422(s);
        if (asn1objectidentifier != null)
        {
            s = asn1objectidentifier.identifier;
            gost3410paramsetparameters = GOST3410NamedParameters._mth02CF(asn1objectidentifier);
        }
_L1:
        if (gost3410paramsetparameters == null)
        {
            throw new IllegalArgumentException("no key parameter set for passed in name/OID.");
        } else
        {
            aIk = new GOST3410PublicKeyParameterSetSpec(new BigInteger(1, gost3410paramsetparameters.Yq.bytes), new BigInteger(1, gost3410paramsetparameters.Yr.bytes), new BigInteger(1, gost3410paramsetparameters.Ys.bytes));
            aIl = s;
            aIm = s1;
            aIn = s2;
            return;
        }
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public GOST3410ParameterSpec(GOST3410PublicKeyParameterSetSpec gost3410publickeyparametersetspec)
    {
        aIk = gost3410publickeyparametersetspec;
        aIm = CryptoProObjectIdentifiers.XZ.identifier;
        aIn = null;
    }

    public static GOST3410ParameterSpec _mth02CA(GOST3410PublicKeyAlgParameters gost3410publickeyalgparameters)
    {
        if (gost3410publickeyalgparameters.Yv != null)
        {
            return new GOST3410ParameterSpec(gost3410publickeyalgparameters.Yt.identifier, gost3410publickeyalgparameters.Yu.identifier, gost3410publickeyalgparameters.Yv.identifier);
        } else
        {
            return new GOST3410ParameterSpec(gost3410publickeyalgparameters.Yt.identifier, gost3410publickeyalgparameters.Yu.identifier);
        }
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof GOST3410ParameterSpec)
        {
            obj = (GOST3410ParameterSpec)obj;
            return aIk.equals(((GOST3410ParameterSpec) (obj)).aIk) && aIm.equals(((GOST3410ParameterSpec) (obj)).aIm) && (aIn == ((GOST3410ParameterSpec) (obj)).aIn || aIn != null && aIn.equals(((GOST3410ParameterSpec) (obj)).aIn));
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        int j = aIk.hashCode();
        int k = aIm.hashCode();
        int i;
        if (aIn != null)
        {
            i = aIn.hashCode();
        } else
        {
            i = 0;
        }
        return j ^ k ^ i;
    }

    public final String _mth1D1D()
    {
        return aIl;
    }

    public final String _mth1D26()
    {
        return aIm;
    }

    public final String _mth1D29()
    {
        return aIn;
    }

    public final GOST3410PublicKeyParameterSetSpec _mth1D2D()
    {
        return aIk;
    }
}
