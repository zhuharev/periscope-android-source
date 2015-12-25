// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.mceliece;

import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.GoppaCode;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
import org.spongycastle.pqc.math.linearalgebra.PolynomialRingGF2m;

// Referenced classes of package org.spongycastle.pqc.crypto.mceliece:
//            McElieceKeyGenerationParameters, McElieceParameters, McEliecePublicKeyParameters, McEliecePrivateKeyParameters

public class McElieceKeyPairGenerator
    implements AsymmetricCipherKeyPairGenerator
{

    private int aJP;
    private int aLS;
    private McElieceKeyGenerationParameters aMc;
    private int afJ;
    private SecureRandom amC;
    private int axg;
    private boolean initialized;

    public McElieceKeyPairGenerator()
    {
        initialized = false;
    }

    public void _mth02CB(KeyGenerationParameters keygenerationparameters)
    {
        aMc = (McElieceKeyGenerationParameters)keygenerationparameters;
        amC = new SecureRandom();
        afJ = aMc.aMb.afJ;
        axg = aMc.aMb.axg;
        aJP = aMc.aMb.aJP;
        aLS = aMc.aMb.aLS;
        initialized = true;
    }

    public final AsymmetricCipherKeyPair _mth1491()
    {
        if (!initialized)
        {
            _mth02CB(new McElieceKeyGenerationParameters(new SecureRandom(), new McElieceParameters()));
        }
        GF2mField gf2mfield = new GF2mField(afJ, aLS);
        PolynomialGF2mSmallM polynomialgf2msmallm = new PolynomialGF2mSmallM(gf2mfield, aJP, 'I', amC);
        PolynomialGF2mSmallM apolynomialgf2msmallm[] = (new PolynomialRingGF2m(gf2mfield, polynomialgf2msmallm))._mth153D();
        GF2Matrix gf2matrix = GoppaCode._mth02CA(gf2mfield, polynomialgf2msmallm);
        Object obj = GoppaCode._mth02CA(gf2matrix, amC);
        GF2Matrix gf2matrix1 = ((org.spongycastle.pqc.math.linearalgebra.GoppaCode.MaMaPe) (obj)).aLX;
        obj = ((org.spongycastle.pqc.math.linearalgebra.GoppaCode.MaMaPe) (obj)).aLW;
        GF2Matrix gf2matrix2 = (GF2Matrix)gf2matrix1._mth0E21();
        gf2matrix1 = gf2matrix2._mth0E15();
        int i = gf2matrix2.getNumRows();
        GF2Matrix agf2matrix[] = GF2Matrix._mth02CF(i, amC);
        Permutation permutation = new Permutation(axg, amC);
        gf2matrix1 = (GF2Matrix)((GF2Matrix)agf2matrix[0]._mth02CA(gf2matrix1))._mth02CA(permutation);
        return new AsymmetricCipherKeyPair(new McEliecePublicKeyParameters("1.3.6.1.4.1.8301.3.1.3.4.1", axg, aJP, gf2matrix1, aMc.aMb), new McEliecePrivateKeyParameters("1.3.6.1.4.1.8301.3.1.3.4.1", axg, i, gf2mfield, polynomialgf2msmallm, agf2matrix[1], ((Permutation) (obj)), permutation, gf2matrix, apolynomialgf2msmallm, aMc.aMb));
    }
}
