// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.util.Vector;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsProtocol, TlsUtils, ProtocolVersion, TlsFatalAlert, 
//            Certificate, TlsKeyExchange, CertificateStatus, CertificateRequest, 
//            NewSessionTicket, TlsAuthentication, AbstractTlsContext

public class TlsClientProtocol extends TlsProtocol
{

    private byte aAf[];
    private TlsKeyExchange aAk;
    private TlsAuthentication aAl;
    private CertificateStatus aAm;
    private CertificateRequest aAn;

    private void _mth02BC(ByteArrayInputStream bytearrayinputstream)
    {
        boolean flag;
        if (TlsUtils._mth02BF(bytearrayinputstream).version >> 8 == 254)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            throw new TlsFatalAlert((short)47);
        } else
        {
            throw new NullPointerException();
        }
    }

    private void _mth02CB(Vector vector)
    {
        throw new NullPointerException();
    }

    protected final void _mth02CA(short word0, byte abyte0[])
    {
        abyte0 = new ByteArrayInputStream(abyte0);
        if (aCp)
        {
            if (word0 != 20 || aCo != 2)
            {
                throw new TlsFatalAlert((short)10);
            } else
            {
                _mth02BD(abyte0);
                aCo = 15;
                _mth0E2B();
                aCo = 13;
                aCo = 16;
                return;
            }
        }
        switch (word0)
        {
        case 11: // '\013'
            switch (aCo)
            {
            case 2: // '\002'
                _mth02CB(null);
                // fall through

            case 3: // '\003'
                aBo = Certificate._mth02CF(abyte0);
                if (abyte0.available() > 0)
                {
                    throw new TlsFatalAlert((short)50);
                }
                if (aBo == null || aBo.isEmpty())
                {
                    aAi = false;
                }
                aAk._mth02CA(aBo);
                throw new NullPointerException();

            default:
                throw new TlsFatalAlert((short)10);
            }

        case 22: // '\026'
            switch (aCo)
            {
            case 4: // '\004'
                if (!aAi)
                {
                    throw new TlsFatalAlert((short)10);
                }
                aAm = CertificateStatus._mth141D(abyte0);
                if (abyte0.available() > 0)
                {
                    throw new TlsFatalAlert((short)50);
                } else
                {
                    aCo = 5;
                    return;
                }
            }
            throw new TlsFatalAlert((short)10);

        case 20: // '\024'
            switch (aCo)
            {
            case 13: // '\r'
                if (aAj)
                {
                    throw new TlsFatalAlert((short)10);
                }
                // fall through

            case 14: // '\016'
                _mth02BD(abyte0);
                aCo = 15;
                aCo = 16;
                return;

            default:
                throw new TlsFatalAlert((short)10);
            }

        case 2: // '\002'
            switch (aCo)
            {
            case 1: // '\001'
                _mth02BC(abyte0);
                aCo = 2;
                throw new NullPointerException();
            }
            throw new TlsFatalAlert((short)10);

        case 23: // '\027'
            switch (aCo)
            {
            case 2: // '\002'
                _mth02CB(_mth02BE(abyte0));
                return;
            }
            throw new TlsFatalAlert((short)10);

        case 14: // '\016'
            switch (aCo)
            {
            case 2: // '\002'
                _mth02CB(null);
                // fall through

            case 3: // '\003'
                aAk._mth09F0();
                aAl = null;
                // fall through

            case 4: // '\004'
            case 5: // '\005'
                aAk._mth04F1();
                // fall through

            case 6: // '\006'
            case 7: // '\007'
                if (abyte0.available() > 0)
                {
                    throw new TlsFatalAlert((short)50);
                } else
                {
                    aCo = 8;
                    throw new NullPointerException();
                }

            default:
                throw new TlsFatalAlert((short)40);
            }

        case 12: // '\f'
            switch (aCo)
            {
            case 2: // '\002'
                _mth02CB(null);
                // fall through

            case 3: // '\003'
                aAk._mth09F0();
                aAl = null;
                // fall through

            case 4: // '\004'
            case 5: // '\005'
                aAk._mth02CB(abyte0);
                if (abyte0.available() > 0)
                {
                    throw new TlsFatalAlert((short)50);
                } else
                {
                    aCo = 6;
                    return;
                }

            default:
                throw new TlsFatalAlert((short)10);
            }

        case 13: // '\r'
            switch (aCo)
            {
            case 4: // '\004'
            case 5: // '\005'
                aAk._mth04F1();
                // fall through

            case 6: // '\006'
                if (aAl == null)
                {
                    throw new TlsFatalAlert((short)40);
                }
                aAn = CertificateRequest._mth02CA(null, abyte0);
                if (abyte0.available() > 0)
                {
                    throw new TlsFatalAlert((short)50);
                } else
                {
                    aAk._mth02CA(aAn);
                    throw new NullPointerException();
                }

            default:
                throw new TlsFatalAlert((short)10);
            }

        case 4: // '\004'
            switch (aCo)
            {
            case 13: // '\r'
                if (!aAj)
                {
                    throw new TlsFatalAlert((short)10);
                }
                _mth0E20();
                NewSessionTicket._mth02BB(abyte0);
                if (abyte0.available() > 0)
                {
                    throw new TlsFatalAlert((short)50);
                }
                aCo = 14;
                break;

            default:
                throw new TlsFatalAlert((short)10);
            }
            // fall through

        case 0: // '\0'
            if (abyte0.available() > 0)
            {
                throw new TlsFatalAlert((short)50);
            }
            if (aCo == 16)
            {
                if (TlsUtils._mth02CB(null))
                {
                    throw new TlsFatalAlert((short)40);
                } else
                {
                    _mth02CA((short)100, "Renegotiation not supported");
                    return;
                }
            } else
            {
                return;
            }

        case 1: // '\001'
        case 3: // '\003'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 15: // '\017'
        case 16: // '\020'
        case 17: // '\021'
        case 18: // '\022'
        case 19: // '\023'
        case 21: // '\025'
        default:
            throw new TlsFatalAlert((short)10);
        }
    }

    protected final AbstractTlsContext _mth09B9()
    {
        return null;
    }
}
