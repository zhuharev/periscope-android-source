// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import org.spongycastle.util.Strings;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsUtils, TlsFatalAlert

public final class ProtocolVersion
{

    public static final ProtocolVersion aAF = new ProtocolVersion(768, "SSL 3.0");
    public static final ProtocolVersion aAG = new ProtocolVersion(769, "TLS 1.0");
    public static final ProtocolVersion aAH = new ProtocolVersion(770, "TLS 1.1");
    public static final ProtocolVersion aAI = new ProtocolVersion(771, "TLS 1.2");
    private static ProtocolVersion aAJ = new ProtocolVersion(65279, "DTLS 1.0");
    private static ProtocolVersion aAK = new ProtocolVersion(65277, "DTLS 1.2");
    private String name;
    int version;

    private ProtocolVersion(int i, String s)
    {
        version = 0xffff & i;
        name = s;
    }

    private static ProtocolVersion _mth02CE(int i, int j, String s)
    {
        TlsUtils._mth05D6(i);
        TlsUtils._mth05D6(j);
        i = i << 8 | j;
        String s1 = Strings.FE7C(Integer.toHexString(0x10000 | i).substring(1));
        return new ProtocolVersion(i, (new StringBuilder()).append(s).append(" 0x").append(s1).toString());
    }

    public static ProtocolVersion _mth15EE(int i, int j)
    {
        switch (i)
        {
        case 3: // '\003'
            switch (j)
            {
            case 0: // '\0'
                return aAF;

            case 1: // '\001'
                return aAG;

            case 2: // '\002'
                return aAH;

            case 3: // '\003'
                return aAI;
            }
            return _mth02CE(i, j, "TLS");

        case 254: 
            switch (j)
            {
            case 255: 
                return aAJ;

            case 254: 
                throw new TlsFatalAlert((short)47);

            case 253: 
                return aAK;
            }
            return _mth02CE(i, j, "DTLS");
        }
        throw new TlsFatalAlert((short)47);
    }

    public final boolean equals(Object obj)
    {
label0:
        {
            if (this != obj)
            {
                if (!(obj instanceof ProtocolVersion))
                {
                    break label0;
                }
                obj = (ProtocolVersion)obj;
                boolean flag;
                if (obj != null && version == ((ProtocolVersion) (obj)).version)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    break label0;
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode()
    {
        return version;
    }

    public final String toString()
    {
        return name;
    }

    public final boolean _mth02CB(ProtocolVersion protocolversion)
    {
        if (version >> 8 != protocolversion.version >> 8)
        {
            return false;
        }
        int i = (protocolversion.version & 0xff) - (version & 0xff);
        boolean flag;
        if (version >> 8 == 254)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return i <= 0;
        }
        return i >= 0;
    }

    public final ProtocolVersion _mth0993()
    {
        boolean flag;
        if (version >> 8 == 254)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            return this;
        }
        if (this == aAJ)
        {
            return aAH;
        } else
        {
            return aAI;
        }
    }

}
