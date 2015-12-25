// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.digests;

import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.util.Memoable;

public abstract class GeneralDigest
    implements ExtendedDigest, Memoable
{

    long VD;
    final byte anh[];
    int ani;

    protected GeneralDigest()
    {
        anh = new byte[4];
        ani = 0;
    }

    protected GeneralDigest(GeneralDigest generaldigest)
    {
        anh = new byte[4];
        System.arraycopy(generaldigest.anh, 0, anh, 0, 4);
        ani = generaldigest.ani;
        VD = generaldigest.VD;
    }

    public final void finish()
    {
        long l = VD;
        update((byte)-128);
        while (ani != 0) 
        {
            update((byte)0);
        }
        _mth0674(l << 3);
        _mth14BA();
    }

    public void reset()
    {
        VD = 0L;
        ani = 0;
        for (int i = 0; i < 4; i++)
        {
            anh[i] = 0;
        }

    }

    public final void update(byte byte0)
    {
        byte abyte0[] = anh;
        int i = ani;
        ani = i + 1;
        abyte0[i] = byte0;
        if (ani == 4)
        {
            _mth141D(anh, 0);
            ani = 0;
        }
        VD = VD + 1L;
    }

    public final void update(byte abyte0[], int i, int j)
    {
        int k = j;
        int l = i;
        do
        {
            i = l;
            j = k;
            if (ani == 0)
            {
                break;
            }
            i = l;
            j = k;
            if (k <= 0)
            {
                break;
            }
            update(abyte0[l]);
            l++;
            k--;
        } while (true);
        do
        {
            k = i;
            l = j;
            if (j <= 4)
            {
                break;
            }
            _mth141D(abyte0, i);
            i += 4;
            j -= 4;
            VD = VD + 4L;
        } while (true);
        for (; l > 0; l--)
        {
            update(abyte0[k]);
            k++;
        }

    }

    protected abstract void _mth0674(long l);

    protected abstract void _mth141D(byte abyte0[], int i);

    public final int _mth14B2()
    {
        return 64;
    }

    protected abstract void _mth14BA();
}
