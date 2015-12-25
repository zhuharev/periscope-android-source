// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.mceliece;

import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.GoppaCode;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
import org.spongycastle.pqc.math.linearalgebra.PolynomialRingGF2m;

// Referenced classes of package org.spongycastle.pqc.crypto.mceliece:
//            McElieceCCA2KeyGenerationParameters, McElieceParameters, McElieceCCA2Parameters, McElieceCCA2PublicKeyParameters, 
//            McElieceCCA2PrivateKeyParameters

public class McElieceCCA2KeyPairGenerator
    implements AsymmetricCipherKeyPairGenerator
{

    private int aJP;
    private McElieceCCA2KeyGenerationParameters aLR;
    private int aLS;
    private int afJ;
    private SecureRandom amC;
    private int axg;
    private boolean initialized;

    public McElieceCCA2KeyPairGenerator()
    {
        initialized = false;
    }

    public final void _mth02CA(McElieceCCA2KeyGenerationParameters mceliececca2keygenerationparameters)
    {
        aLR = (McElieceCCA2KeyGenerationParameters)mceliececca2keygenerationparameters;
        amC = new SecureRandom();
        afJ = ((McElieceParameters) (aLR.aLQ)).afJ;
        axg = ((McElieceParameters) (aLR.aLQ)).axg;
        aJP = ((McElieceParameters) (aLR.aLQ)).aJP;
        aLS = ((McElieceParameters) (aLR.aLQ)).aLS;
        initialized = true;
    }

    public final AsymmetricCipherKeyPair _mth1491()
    {
        if (!initialized)
        {
            _mth02CA(new McElieceCCA2KeyGenerationParameters(new SecureRandom(), new McElieceCCA2Parameters()));
        }
        GF2mField gf2mfield = new GF2mField(afJ, aLS);
        PolynomialGF2mSmallM polynomialgf2msmallm = new PolynomialGF2mSmallM(gf2mfield, aJP, 'I', amC);
        PolynomialGF2mSmallM apolynomialgf2msmallm[] = (new PolynomialRingGF2m(gf2mfield, polynomialgf2msmallm))._mth153D();
        GF2Matrix gf2matrix = GoppaCode._mth02CA(gf2mfield, polynomialgf2msmallm);
        Object obj = GoppaCode._mth02CA(gf2matrix, amC);
        GF2Matrix gf2matrix1 = ((org.spongycastle.pqc.math.linearalgebra.GoppaCode.MaMaPe) (obj)).aLX;
        obj = ((org.spongycastle.pqc.math.linearalgebra.GoppaCode.MaMaPe) (obj)).aLW;
        gf2matrix1 = (GF2Matrix)gf2matrix1._mth0E21();
        int i = gf2matrix1.getNumRows();
        return new AsymmetricCipherKeyPair(new McElieceCCA2PublicKeyParameters("1.3.6.1.4.1.8301.3.1.3.4.2", axg, aJP, gf2matrix1, aLR.aLQ), new McElieceCCA2PrivateKeyParameters("1.3.6.1.4.1.8301.3.1.3.4.2", axg, i, gf2mfield, polynomialgf2msmallm, ((org.spongycastle.pqc.math.linearalgebra.Permutation) (obj)), gf2matrix, apolynomialgf2msmallm, aLR.aLQ));
    }
}
