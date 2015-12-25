// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.io.InputStream;
import java.io.OutputStream;
import org.spongycastle.crypto.params.DHKeyParameters;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsDHUtils

public class ServerDHParams
{

    private DHPublicKeyParameters aBn;

    public ServerDHParams(DHPublicKeyParameters dhpublickeyparameters)
    {
        if (dhpublickeyparameters == null)
        {
            throw new IllegalArgumentException("'publicKey' cannot be null");
        } else
        {
            aBn = dhpublickeyparameters;
            return;
        }
    }

    public static ServerDHParams _mth141D(InputStream inputstream)
    {
        java.math.BigInteger biginteger = TlsDHUtils._mth02BC(inputstream);
        java.math.BigInteger biginteger1 = TlsDHUtils._mth02BC(inputstream);
        return new ServerDHParams(new DHPublicKeyParameters(TlsDHUtils._mth02BC(inputstream), new DHParameters(biginteger, biginteger1)));
    }

    public final void encode(OutputStream outputstream)
    {
        DHParameters dhparameters = ((DHKeyParameters) (aBn)).axb;
        java.math.BigInteger biginteger = aBn.axe;
        TlsDHUtils._mth02CA(dhparameters.amM, outputstream);
        TlsDHUtils._mth02CA(dhparameters.amO, outputstream);
        TlsDHUtils._mth02CA(biginteger, outputstream);
    }

    public final DHPublicKeyParameters _mth09A8()
    {
        return aBn;
    }
}
