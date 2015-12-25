// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;


// Referenced classes of package org.spongycastle.crypto.engines:
//            VMPCEngine

public class VMPCKSA3Engine extends VMPCEngine
{

    public VMPCKSA3Engine()
    {
    }

    protected final void _mth02CE(byte abyte0[], byte abyte1[])
    {
        atK = 0;
        atJ = new byte[256];
        for (int i = 0; i < 256; i++)
        {
            atJ[i] = (byte)i;
        }

        for (int j = 0; j < 768; j++)
        {
            atK = atJ[atK + atJ[j & 0xff] + abyte0[j % abyte0.length] & 0xff];
            byte byte0 = atJ[j & 0xff];
            atJ[j & 0xff] = atJ[atK & 0xff];
            atJ[atK & 0xff] = byte0;
        }

        for (int k = 0; k < 768; k++)
        {
            atK = atJ[atK + atJ[k & 0xff] + abyte1[k % abyte1.length] & 0xff];
            byte byte1 = atJ[k & 0xff];
            atJ[k & 0xff] = atJ[atK & 0xff];
            atJ[atK & 0xff] = byte1;
        }

        for (int l = 0; l < 768; l++)
        {
            atK = atJ[atK + atJ[l & 0xff] + abyte0[l % abyte0.length] & 0xff];
            byte byte2 = atJ[l & 0xff];
            atJ[l & 0xff] = atJ[atK & 0xff];
            atJ[atK & 0xff] = byte2;
        }

        atI = 0;
    }

    public final String _mth14AC()
    {
        return "VMPC-KSA3";
    }
}
