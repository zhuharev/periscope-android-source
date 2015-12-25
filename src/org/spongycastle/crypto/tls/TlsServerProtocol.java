// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import org.spongycastle.asn1.x509.Certificate;
import org.spongycastle.asn1.x509.TBSCertificate;
import org.spongycastle.crypto.util.PublicKeyFactory;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsProtocol, TlsFatalAlert, Certificate, TlsUtils, 
//            ProtocolVersion, TlsKeyExchange, DigitallySigned, SignatureAndHashAlgorithm, 
//            TlsHandshakeHash, TlsSigner, CertificateRequest, TlsCredentials, 
//            AbstractTlsContext

public class TlsServerProtocol extends TlsProtocol
{

    private TlsKeyExchange aAk;
    private CertificateRequest aAn;
    private TlsCredentials aAu;
    private short aAv;
    private TlsHandshakeHash aCu;

    private void _mth02CF(org.spongycastle.crypto.tls.Certificate certificate)
    {
        if (aAn == null)
        {
            throw new IllegalStateException();
        }
        if (aBo != null)
        {
            throw new TlsFatalAlert((short)10);
        }
        aBo = certificate;
        if (!certificate.isEmpty())
        {
            aAv = TlsUtils._mth141D(certificate);
        }
    }

    protected final void _mth02BB(short word0)
    {
        switch (word0)
        {
        case 41: // ')'
            if (TlsUtils._mth02CB(null) && aAn != null)
            {
                _mth02CF(Certificate.azN);
                return;
            }
            break;

        default:
            super._mth02BB(word0);
            break;
        }
    }

    protected final void _mth02CA(short word0, byte abyte0[])
    {
        abyte0 = new ByteArrayInputStream(abyte0);
        word0;
        JVM INSTR tableswitch 1 23: default 116
    //                   1 119
    //                   2 1000
    //                   3 1000
    //                   4 1000
    //                   5 1000
    //                   6 1000
    //                   7 1000
    //                   8 1000
    //                   9 1000
    //                   10 1000
    //                   11 413
    //                   12 1000
    //                   13 1000
    //                   14 1000
    //                   15 651
    //                   16 508
    //                   17 1000
    //                   18 1000
    //                   19 1000
    //                   20 868
    //                   21 1000
    //                   22 1000
    //                   23 365;
           goto _L1 _L2 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L3 _L1 _L1 _L1 _L4 _L5 _L1 _L1 _L1 _L6 _L1 _L1 _L7
_L2:
        switch (aCo)
        {
        case 0: // '\0'
            if (TlsUtils._mth02BF(abyte0).version >> 8 == 254)
            {
                word0 = 1;
            } else
            {
                word0 = 0;
            }
            if (word0 != 0)
            {
                throw new TlsFatalAlert((short)47);
            }
            TlsUtils._mth02CF(32, abyte0);
            if (TlsUtils._mth02BF(abyte0).length > 32)
            {
                throw new TlsFatalAlert((short)47);
            }
            word0 = TlsUtils._mth037A(abyte0);
            if (word0 < 2 || (word0 & 1) != 0)
            {
                throw new TlsFatalAlert((short)50);
            }
            aAc = TlsUtils._mth02CB(word0 / 2, abyte0);
            word0 = TlsUtils._mth02BD(abyte0);
            if (word0 <= 0)
            {
                throw new TlsFatalAlert((short)47);
            }
            aAd = TlsUtils._mth02CA(word0, abyte0);
            aAe = _mth1FBE(abyte0);
            if (Arrays._mth02BD(aAc, 255))
            {
                aAg = true;
            }
            abyte0 = TlsUtils._mth02CA(aAe, aCh);
            if (abyte0 != null)
            {
                aAg = true;
                if (!Arrays._mth1428(abyte0, TlsUtils._mth1D36(TlsUtils.WQ)))
                {
                    throw new TlsFatalAlert((short)40);
                }
            }
            boolean flag = aAg;
            throw new NullPointerException();
        }
        throw new TlsFatalAlert((short)10);
_L7:
        switch (aCo)
        {
        case 8: // '\b'
            _mth02BE(abyte0);
            aCo = 9;
            return;
        }
        throw new TlsFatalAlert((short)10);
_L3:
        switch (aCo)
        {
        case 8: // '\b'
        case 9: // '\t'
            if (aAn == null)
            {
                throw new TlsFatalAlert((short)10);
            }
            org.spongycastle.crypto.tls.Certificate certificate = Certificate._mth02CF(abyte0);
            if (abyte0.available() > 0)
            {
                throw new TlsFatalAlert((short)50);
            } else
            {
                _mth02CF(certificate);
                aCo = 10;
                return;
            }
        }
        throw new TlsFatalAlert((short)10);
_L5:
        aCo;
        JVM INSTR tableswitch 8 10: default 540
    //                   8 543
    //                   9 543
    //                   10 598;
           goto _L8 _L9 _L9 _L10
_L10:
        break; /* Loop/switch isn't completed */
_L9:
        if (aAn != null)
        {
            if (TlsUtils._mth02CF(null))
            {
                throw new TlsFatalAlert((short)10);
            }
            if (TlsUtils._mth02CB(null))
            {
                if (aBo == null)
                {
                    throw new TlsFatalAlert((short)10);
                }
            } else
            {
                _mth02CF(Certificate.azN);
            }
        }
        aAk._mth02CE(abyte0);
        if (abyte0.available() > 0)
        {
            throw new TlsFatalAlert((short)50);
        } else
        {
            _mth02CA(null, aAk);
            throw new NullPointerException();
        }
_L8:
        throw new TlsFatalAlert((short)10);
_L4:
        aCo;
        JVM INSTR lookupswitch 1: default 672
    //                   11: 675;
           goto _L11 _L12
_L12:
        DigitallySigned digitallysigned;
        boolean flag1;
        if (aAv >= 0 && TlsUtils._mth1FBE(aAv))
        {
            word0 = 1;
        } else
        {
            word0 = 0;
        }
        if (word0 == 0)
        {
            throw new TlsFatalAlert((short)10);
        }
        digitallysigned = DigitallySigned._mth02CA(null, abyte0);
        if (abyte0.available() > 0)
        {
            throw new TlsFatalAlert((short)50);
        }
        flag1 = false;
        if (!TlsUtils._mth02CF(null)) goto _L14; else goto _L13
_L13:
        abyte0 = aCu._mth02CE(digitallysigned._mth072B()._mth09AA());
          goto _L15
_L14:
        abyte0 = TlsProtocol._mth02CA(null, aCu, null);
_L15:
        boolean flag2;
        org.spongycastle.crypto.params.AsymmetricKeyParameter asymmetrickeyparameter = PublicKeyFactory._mth02CA(aBo._mth0130(0).air.ajP);
        AbstractTlsSigner abstracttlssigner = TlsUtils._mth02BE(aAv);
        abstracttlssigner._mth02CA(null);
        flag2 = abstracttlssigner._mth02CA(digitallysigned._mth072B(), digitallysigned.getSignature(), asymmetrickeyparameter, abyte0);
        flag1 = flag2;
_L17:
        if (!flag1)
        {
            throw new TlsFatalAlert((short)51);
        } else
        {
            aCo = 12;
            return;
        }
_L11:
        throw new TlsFatalAlert((short)10);
_L6:
        switch (aCo)
        {
        case 11: // '\013'
            if (aAv >= 0 && TlsUtils._mth1FBE(aAv))
            {
                word0 = 1;
            } else
            {
                word0 = 0;
            }
            if (word0 != 0)
            {
                throw new TlsFatalAlert((short)10);
            }
            // fall through

        case 12: // '\f'
            _mth02BD(abyte0);
            aCo = 13;
            if (aAj)
            {
                throw new NullPointerException();
            } else
            {
                aCo = 14;
                _mth0E2B();
                aCo = 15;
                aCo = 16;
                return;
            }

        default:
            throw new TlsFatalAlert((short)10);
        }
_L1:
        throw new TlsFatalAlert((short)10);
        abyte0;
        if (true) goto _L17; else goto _L16
_L16:
    }

    protected final AbstractTlsContext _mth09B9()
    {
        return null;
    }
}
