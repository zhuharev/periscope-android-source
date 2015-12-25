// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.io.ByteArrayOutputStream;
import org.spongycastle.crypto.Digest;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.rsa:
//            PSSSignatureSpi

class aEj
    implements Digest
{

    private Digest aEj;
    private boolean aEk;
    private PSSSignatureSpi aEl;
    private ByteArrayOutputStream anR;

    public final int doFinal(byte abyte0[], int i)
    {
        byte abyte1[] = anR.toByteArray();
        if (aEk)
        {
            System.arraycopy(abyte1, 0, abyte0, i, abyte1.length);
        } else
        {
            aEj.update(abyte1, 0, abyte1.length);
            aEj.doFinal(abyte0, i);
        }
        anR.reset();
        aEj.reset();
        boolean flag;
        if (!aEk)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        aEk = flag;
        return abyte1.length;
    }

    public final void reset()
    {
        anR.reset();
        aEj.reset();
    }

    public final void update(byte byte0)
    {
        anR.write(byte0);
    }

    public final void update(byte abyte0[], int i, int j)
    {
        anR.write(abyte0, i, j);
    }

    public final String _mth14AC()
    {
        return "NULL";
    }

    public final int _mth14AF()
    {
        return aEj._mth14AF();
    }

    public (PSSSignatureSpi psssignaturespi, Digest digest)
    {
        aEl = psssignaturespi;
        super();
        anR = new ByteArrayOutputStream();
        aEk = true;
        aEj = digest;
    }
}
