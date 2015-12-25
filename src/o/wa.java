// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

// Referenced classes of package o:
//            wn, wc, wb, vr, 
//            wk, vv, wo

public final class wa
    implements wn
{

    private int Vn;
    private final Inflater Vo;
    private final CRC32 crc = new CRC32();
    private final wb inflaterSource;
    private final vv source;

    public wa(vv vv1)
    {
        Vn = 0;
        if (vv1 == null)
        {
            throw new IllegalArgumentException("source == null");
        } else
        {
            Vo = new Inflater(true);
            source = wc._mth02CB(vv1);
            inflaterSource = new wb(source, Vo);
            return;
        }
    }

    private static void _mth02CB(String s, int i, int j)
    {
        if (j != i)
        {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[] {
                s, Integer.valueOf(j), Integer.valueOf(i)
            }));
        } else
        {
            return;
        }
    }

    private void _mth02CB(vr vr1, long l, long l1)
    {
        vr1 = vr1.Vh;
        Object obj;
        long l2;
        long l3;
        do
        {
            obj = vr1;
            l2 = l;
            l3 = l1;
            if (l < (long)(((wk) (vr1)).limit - ((wk) (vr1)).pos))
            {
                break;
            }
            l -= ((wk) (vr1)).limit - ((wk) (vr1)).pos;
            vr1 = ((wk) (vr1)).VB;
        } while (true);
        while (l3 > 0L) 
        {
            int i = (int)((long)((wk) (obj)).pos + l2);
            int j = (int)Math.min(((wk) (obj)).limit - i, l3);
            crc.update(((wk) (obj)).data, i, j);
            l3 -= j;
            l2 = 0L;
            obj = ((wk) (obj)).VB;
        }
    }

    public final void close()
    {
        inflaterSource.close();
    }

    public final long read(vr vr1, long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
        }
        if (l == 0L)
        {
            return 0L;
        }
        if (Vn == 0)
        {
            source._mth02BF(10L);
            byte byte0 = source.FE93()._mth02C8(3L);
            boolean flag;
            if ((byte0 >> 1 & 1) == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                _mth02CB(source.FE93(), 0L, 10L);
            }
            _mth02CB("ID1ID2", 8075, source.readShort());
            source._mth02D1(8L);
            if ((byte0 >> 2 & 1) == 1)
            {
                source._mth02BF(2L);
                if (flag)
                {
                    _mth02CB(source.FE93(), 0L, 2L);
                }
                int i = source.FE93().FF56();
                source._mth02BF(i);
                if (flag)
                {
                    _mth02CB(source.FE93(), 0L, i);
                }
                source._mth02D1(i);
            }
            if ((byte0 >> 3 & 1) == 1)
            {
                long l1 = source._mth02CE((byte)0);
                if (l1 == -1L)
                {
                    throw new EOFException();
                }
                if (flag)
                {
                    _mth02CB(source.FE93(), 0L, l1 + 1L);
                }
                source._mth02D1(1L + l1);
            }
            if ((byte0 >> 4 & 1) == 1)
            {
                long l2 = source._mth02CE((byte)0);
                if (l2 == -1L)
                {
                    throw new EOFException();
                }
                if (flag)
                {
                    _mth02CB(source.FE93(), 0L, l2 + 1L);
                }
                source._mth02D1(1L + l2);
            }
            if (flag)
            {
                _mth02CB("FHCRC", source.FF56(), (short)(int)crc.getValue());
                crc.reset();
            }
            Vn = 1;
        }
        if (Vn == 1)
        {
            long l3 = vr1.size;
            l = inflaterSource.read(vr1, l);
            if (l != -1L)
            {
                _mth02CB(vr1, l3, l);
                return l;
            }
            Vn = 2;
        }
        if (Vn == 2)
        {
            _mth02CB("CRC", source.FF6C(), (int)crc.getValue());
            _mth02CB("ISIZE", source.FF6C(), Vo.getTotalOut());
            Vn = 3;
            if (!source.FF46())
            {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    public final wo timeout()
    {
        return source.timeout();
    }
}
