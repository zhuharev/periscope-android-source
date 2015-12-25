// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.FilterInputStream;

// Referenced classes of package o:
//            _cls0505

public final class _cls05E6 extends FilterInputStream
{

    private int sj;

    public _cls05E6(_cls0505 _pcls0505)
    {
        super(_pcls0505);
        sj = 0x80000000;
    }

    private long _mth02BC(long l)
    {
        if (sj == 0)
        {
            return -1L;
        }
        if (sj != 0x80000000 && l > (long)sj)
        {
            return (long)sj;
        } else
        {
            return l;
        }
    }

    public final int available()
    {
        if (sj == 0x80000000)
        {
            return super.available();
        } else
        {
            return Math.min(sj, super.available());
        }
    }

    public final void mark(int i)
    {
        super.mark(i);
        sj = i;
    }

    public final int read()
    {
        if (_mth02BC(1L) == -1L)
        {
            return -1;
        }
        int i = super.read();
        if (sj != 0x80000000 && 1L != -1L)
        {
            sj = (int)((long)sj - 1L);
        }
        return i;
    }

    public final int read(byte abyte0[], int i, int j)
    {
        j = (int)_mth02BC(j);
        if (j == -1)
        {
            return -1;
        }
        i = super.read(abyte0, i, j);
        long l = i;
        if (sj != 0x80000000 && l != -1L)
        {
            sj = (int)((long)sj - l);
        }
        return i;
    }

    public final void reset()
    {
        super.reset();
        sj = 0x80000000;
    }

    public final long skip(long l)
    {
        l = _mth02BC(l);
        if (l == -1L)
        {
            return -1L;
        }
        l = super.skip(l);
        if (sj != 0x80000000 && l != -1L)
        {
            sj = (int)((long)sj - l);
        }
        return l;
    }
}
