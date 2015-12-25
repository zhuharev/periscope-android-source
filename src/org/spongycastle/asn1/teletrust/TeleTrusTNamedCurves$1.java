// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.teletrust;

import java.math.BigInteger;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ECParametersHolder;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.util.encoders.Hex;

// Referenced classes of package org.spongycastle.asn1.teletrust:
//            TeleTrusTNamedCurves

final class  extends X9ECParametersHolder
{

    protected final X9ECParameters _mth098C()
    {
        BigInteger biginteger = new BigInteger("E95E4A5F737059DC60DF5991D45029409E60FC09", 16);
        BigInteger biginteger1 = new BigInteger("01", 16);
        ECCurve eccurve = TeleTrusTNamedCurves._mth02CA(new org.spongycastle.math.ec.rves._cls02CA(new BigInteger("E95E4A5F737059DC60DFC7AD95B3D8139515620F", 16), new BigInteger("340E7BE2A280EB74E2BE61BADA745D97E8F7C300", 16), new BigInteger("1E589A8595423412134FAA2DBDEC95C8D8675E58", 16), biginteger, biginteger1));
        return new X9ECParameters(eccurve, eccurve._mth01C3(Hex._mth1508("04BED5AF16EA3F6A4F62938C4631EB5AF7BDBCDBC31667CB477A1A8EC338F94741669C976316DA6321")), biginteger, biginteger1);
    }

    ()
    {
    }
}
