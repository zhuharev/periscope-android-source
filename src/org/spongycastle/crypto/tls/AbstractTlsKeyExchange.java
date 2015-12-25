// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.util.Vector;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsKeyExchange, TlsContext, TlsUtils, TlsCredentials, 
//            TlsFatalAlert, Certificate

public abstract class AbstractTlsKeyExchange
    implements TlsKeyExchange
{

    protected int azH;
    private Vector azI;
    protected TlsContext azJ;

    protected AbstractTlsKeyExchange(int i, Vector vector)
    {
        azH = i;
        azI = vector;
    }

    public void _mth02CA(Certificate certificate)
    {
    }

    public void _mth02CA(TlsContext tlscontext)
    {
        azJ = tlscontext;
        tlscontext = tlscontext._mth043A();
        if (TlsUtils._mth02CE(tlscontext))
        {
            if (azI == null)
            {
                switch (azH)
                {
                case 3: // '\003'
                case 7: // '\007'
                case 22: // '\026'
                    azI = TlsUtils._mth14B5();
                    return;

                case 16: // '\020'
                case 17: // '\021'
                    azI = TlsUtils._mth14B8();
                    return;

                case 1: // '\001'
                case 5: // '\005'
                case 9: // '\t'
                case 15: // '\017'
                case 18: // '\022'
                case 19: // '\023'
                case 23: // '\027'
                    azI = TlsUtils._mth14B9();
                    return;

                case 13: // '\r'
                case 14: // '\016'
                case 21: // '\025'
                case 24: // '\030'
                    return;
                }
                throw new IllegalStateException("unsupported key exchange algorithm");
            }
        } else
        if (azI != null)
        {
            throw new IllegalStateException((new StringBuilder("supported_signature_algorithms not allowed for ")).append(tlscontext).toString());
        }
    }

    public void _mth02CA(TlsCredentials tlscredentials)
    {
        _mth02CA(tlscredentials._mth067B());
    }

    public void _mth02CB(ByteArrayInputStream bytearrayinputstream)
    {
        if (!_mth04E7())
        {
            throw new TlsFatalAlert((short)10);
        } else
        {
            return;
        }
    }

    public void _mth02CE(ByteArrayInputStream bytearrayinputstream)
    {
        throw new TlsFatalAlert((short)80);
    }

    public boolean _mth04E7()
    {
        return false;
    }

    public byte[] _mth04ED()
    {
        if (_mth04E7())
        {
            throw new TlsFatalAlert((short)80);
        } else
        {
            return null;
        }
    }

    public final void _mth04F1()
    {
        if (_mth04E7())
        {
            throw new TlsFatalAlert((short)10);
        } else
        {
            return;
        }
    }
}
