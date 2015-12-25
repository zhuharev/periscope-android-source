// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.engines.AESEngine;
import org.spongycastle.crypto.engines.CamelliaEngine;
import org.spongycastle.crypto.engines.DESedeEngine;
import org.spongycastle.crypto.engines.RC4Engine;
import org.spongycastle.crypto.engines.SEEDEngine;
import org.spongycastle.crypto.engines.Salsa20Engine;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.CCMBlockCipher;
import org.spongycastle.crypto.modes.GCMBlockCipher;

// Referenced classes of package org.spongycastle.crypto.tls:
//            AbstractTlsCipherFactory, TlsUtils, TlsFatalAlert, TlsBlockCipher, 
//            Chacha20Poly1305, TlsAEADCipher, TlsStreamCipher, TlsNullCipher, 
//            TlsClientContext, TlsCipher

public class DefaultTlsCipherFactory extends AbstractTlsCipherFactory
{

    public DefaultTlsCipherFactory()
    {
    }

    private static Digest _mth0196(int i)
    {
        switch (i)
        {
        case 0: // '\0'
            return null;

        case 1: // '\001'
            return TlsUtils._mth02BD((short)1);

        case 2: // '\002'
            return TlsUtils._mth02BD((short)2);

        case 3: // '\003'
            return TlsUtils._mth02BD((short)4);

        case 4: // '\004'
            return TlsUtils._mth02BD((short)5);

        case 5: // '\005'
            return TlsUtils._mth02BD((short)6);
        }
        throw new TlsFatalAlert((short)80);
    }

    public final TlsCipher _mth02CA(TlsClientContext tlsclientcontext, int i, int j)
    {
        switch (i)
        {
        case 7: // '\007'
            return new TlsBlockCipher(tlsclientcontext, new CBCBlockCipher(new DESedeEngine()), new CBCBlockCipher(new DESedeEngine()), _mth0196(j), _mth0196(j), 24);

        case 102: // 'f'
            return new Chacha20Poly1305(tlsclientcontext);

        case 8: // '\b'
            return new TlsBlockCipher(tlsclientcontext, new CBCBlockCipher(new AESEngine()), new CBCBlockCipher(new AESEngine()), _mth0196(j), _mth0196(j), 16);

        case 15: // '\017'
            return new TlsAEADCipher(tlsclientcontext, new CCMBlockCipher(new AESEngine()), new CCMBlockCipher(new AESEngine()), 16, 16);

        case 16: // '\020'
            return new TlsAEADCipher(tlsclientcontext, new CCMBlockCipher(new AESEngine()), new CCMBlockCipher(new AESEngine()), 16, 8);

        case 17: // '\021'
            return new TlsAEADCipher(tlsclientcontext, new CCMBlockCipher(new AESEngine()), new CCMBlockCipher(new AESEngine()), 32, 16);

        case 18: // '\022'
            return new TlsAEADCipher(tlsclientcontext, new CCMBlockCipher(new AESEngine()), new CCMBlockCipher(new AESEngine()), 32, 8);

        case 10: // '\n'
            return new TlsAEADCipher(tlsclientcontext, new GCMBlockCipher(new AESEngine()), new GCMBlockCipher(new AESEngine()), 16, 16);

        case 9: // '\t'
            return new TlsBlockCipher(tlsclientcontext, new CBCBlockCipher(new AESEngine()), new CBCBlockCipher(new AESEngine()), _mth0196(j), _mth0196(j), 32);

        case 11: // '\013'
            return new TlsAEADCipher(tlsclientcontext, new GCMBlockCipher(new AESEngine()), new GCMBlockCipher(new AESEngine()), 32, 16);

        case 12: // '\f'
            return new TlsBlockCipher(tlsclientcontext, new CBCBlockCipher(new CamelliaEngine()), new CBCBlockCipher(new CamelliaEngine()), _mth0196(j), _mth0196(j), 16);

        case 19: // '\023'
            return new TlsAEADCipher(tlsclientcontext, new GCMBlockCipher(new CamelliaEngine()), new GCMBlockCipher(new CamelliaEngine()), 16, 16);

        case 13: // '\r'
            return new TlsBlockCipher(tlsclientcontext, new CBCBlockCipher(new CamelliaEngine()), new CBCBlockCipher(new CamelliaEngine()), _mth0196(j), _mth0196(j), 32);

        case 20: // '\024'
            return new TlsAEADCipher(tlsclientcontext, new GCMBlockCipher(new CamelliaEngine()), new GCMBlockCipher(new CamelliaEngine()), 32, 16);

        case 100: // 'd'
            return new TlsStreamCipher(tlsclientcontext, new Salsa20Engine(12), new Salsa20Engine(12), _mth0196(j), _mth0196(j), 32, true);

        case 0: // '\0'
            return new TlsNullCipher(tlsclientcontext, _mth0196(j), _mth0196(j));

        case 2: // '\002'
            return new TlsStreamCipher(tlsclientcontext, new RC4Engine(), new RC4Engine(), _mth0196(j), _mth0196(j), 16, false);

        case 101: // 'e'
            return new TlsStreamCipher(tlsclientcontext, new Salsa20Engine(20), new Salsa20Engine(20), _mth0196(j), _mth0196(j), 32, true);

        case 14: // '\016'
            return new TlsBlockCipher(tlsclientcontext, new CBCBlockCipher(new SEEDEngine()), new CBCBlockCipher(new SEEDEngine()), _mth0196(j), _mth0196(j), 16);
        }
        throw new TlsFatalAlert((short)80);
    }
}
