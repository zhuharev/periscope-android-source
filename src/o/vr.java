// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Referenced classes of package o:
//            vv, vu, wq, wk, 
//            wl, wo, vw, wn, 
//            vs, vt

public final class vr
    implements vv, vu, Cloneable
{

    private static final byte Vg[] = {
        48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 
        97, 98, 99, 100, 101, 102
    };
    wk Vh;
    public long size;

    public vr()
    {
    }

    private String _mth02CA(long l, Charset charset)
    {
        wq.checkOffsetAndCount(size, 0L, l);
        if (charset == null)
        {
            throw new IllegalArgumentException("charset == null");
        }
        if (l > 0x7fffffffL)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount > Integer.MAX_VALUE: ")).append(l).toString());
        }
        if (l == 0L)
        {
            return "";
        }
        wk wk1 = Vh;
        if ((long)wk1.pos + l > (long)wk1.limit)
        {
            return new String(_mth02CD(l), charset);
        }
        charset = new String(wk1.data, wk1.pos, (int)l, charset);
        wk1.pos = (int)((long)wk1.pos + l);
        size = size - l;
        if (wk1.pos == wk1.limit)
        {
            Vh = wk1._mth0288();
            wl._mth02CA(wk1);
        }
        return charset;
    }

    private vr FF9A()
    {
        vr vr1 = new vr();
        if (size == 0L)
        {
            return vr1;
        }
        vr1.Vh = new wk(Vh);
        wk wk1 = vr1.Vh;
        wk wk3 = vr1.Vh;
        wk wk5 = vr1.Vh;
        wk3.VC = wk5;
        wk1.VB = wk5;
        for (wk wk2 = Vh.VB; wk2 != Vh; wk2 = wk2.VB)
        {
            wk wk4 = vr1.Vh.VC;
            wk wk6 = new wk(wk2);
            wk6.VC = wk4;
            wk6.VB = wk4.VB;
            wk4.VB.VC = wk6;
            wk4.VB = wk6;
        }

        vr1.size = size;
        return vr1;
    }

    public final void clear()
    {
        try
        {
            _mth02D1(size);
            return;
        }
        catch (EOFException eofexception)
        {
            throw new AssertionError(eofexception);
        }
    }

    public final Object clone()
    {
        return FF9A();
    }

    public final void close()
    {
    }

    public final boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof vr))
        {
            return false;
        }
        obj = (vr)obj;
        if (size != ((vr) (obj)).size)
        {
            return false;
        }
        if (size == 0L)
        {
            return true;
        }
        wk wk1 = Vh;
        obj = ((vr) (obj)).Vh;
        int i = wk1.pos;
        int j = ((wk) (obj)).pos;
        for (long l1 = 0L; l1 < size;)
        {
            long l2 = Math.min(wk1.limit - i, ((wk) (obj)).limit - j);
            int l = 0;
            int k;
            do
            {
                k = j;
                j = i;
                if ((long)l >= l2)
                {
                    break;
                }
                byte abyte0[] = wk1.data;
                i = j + 1;
                byte byte0 = abyte0[j];
                abyte0 = ((wk) (obj)).data;
                j = k + 1;
                if (byte0 != abyte0[k])
                {
                    return false;
                }
                l++;
            } while (true);
            wk wk2 = wk1;
            i = j;
            if (j == wk1.limit)
            {
                wk2 = wk1.VB;
                i = wk2.pos;
            }
            j = k;
            Object obj1 = obj;
            if (k == ((wk) (obj)).limit)
            {
                obj1 = ((wk) (obj)).VB;
                j = ((wk) (obj1)).pos;
            }
            l1 += l2;
            wk1 = wk2;
            obj = obj1;
        }

        return true;
    }

    public final void flush()
    {
    }

    public final int hashCode()
    {
        wk wk1 = Vh;
        if (wk1 == null)
        {
            return 0;
        }
        int i = 1;
        wk wk2;
        int j;
        do
        {
            int k = wk1.pos;
            int l = wk1.limit;
            j = i;
            for (; k < l; k++)
            {
                j = j * 31 + wk1.data[k];
            }

            wk2 = wk1.VB;
            wk1 = wk2;
            i = j;
        } while (wk2 != Vh);
        return j;
    }

    public final int read(byte abyte0[], int i, int j)
    {
        wq.checkOffsetAndCount(abyte0.length, i, j);
        wk wk1 = Vh;
        if (wk1 == null)
        {
            return -1;
        }
        j = Math.min(j, wk1.limit - wk1.pos);
        System.arraycopy(wk1.data, wk1.pos, abyte0, i, j);
        wk1.pos = wk1.pos + j;
        size = size - (long)j;
        if (wk1.pos == wk1.limit)
        {
            Vh = wk1._mth0288();
            wl._mth02CA(wk1);
        }
        return j;
    }

    public final long read(vr vr1, long l)
    {
        if (vr1 == null)
        {
            throw new IllegalArgumentException("sink == null");
        }
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
        }
        if (size == 0L)
        {
            return -1L;
        }
        long l1 = l;
        if (l > size)
        {
            l1 = size;
        }
        vr1.write(this, l1);
        return l1;
    }

    public final byte readByte()
    {
        if (size == 0L)
        {
            throw new IllegalStateException("size == 0");
        }
        wk wk1 = Vh;
        int i = wk1.pos;
        int j = wk1.limit;
        byte abyte0[] = wk1.data;
        int k = i + 1;
        byte byte0 = abyte0[i];
        size = size - 1L;
        if (k == j)
        {
            Vh = wk1._mth0288();
            wl._mth02CA(wk1);
            return byte0;
        } else
        {
            wk1.pos = k;
            return byte0;
        }
    }

    public final void readFully(byte abyte0[])
    {
        int j;
        for (int i = 0; i < abyte0.length; i += j)
        {
            j = read(abyte0, i, abyte0.length - i);
            if (j == -1)
            {
                throw new EOFException();
            }
        }

    }

    public final int readInt()
    {
        if (size < 4L)
        {
            throw new IllegalStateException((new StringBuilder("size < 4: ")).append(size).toString());
        }
        wk wk1 = Vh;
        int j = wk1.pos;
        int i = wk1.limit;
        if (i - j < 4)
        {
            return (readByte() & 0xff) << 24 | (readByte() & 0xff) << 16 | (readByte() & 0xff) << 8 | readByte() & 0xff;
        }
        byte abyte0[] = wk1.data;
        int k = j + 1;
        j = abyte0[j];
        int i1 = k + 1;
        k = abyte0[k];
        int l = i1 + 1;
        byte byte0 = abyte0[i1];
        i1 = l + 1;
        j = (j & 0xff) << 24 | (k & 0xff) << 16 | (byte0 & 0xff) << 8 | abyte0[l] & 0xff;
        size = size - 4L;
        if (i1 == i)
        {
            Vh = wk1._mth0288();
            wl._mth02CA(wk1);
            return j;
        } else
        {
            wk1.pos = i1;
            return j;
        }
    }

    public final long readLong()
    {
        if (size < 8L)
        {
            throw new IllegalStateException((new StringBuilder("size < 8: ")).append(size).toString());
        }
        wk wk1 = Vh;
        int k = wk1.pos;
        int i = wk1.limit;
        if (i - k < 8)
        {
            return ((long)readInt() & 0xffffffffL) << 32 | (long)readInt() & 0xffffffffL;
        }
        byte abyte0[] = wk1.data;
        int j = k + 1;
        long l = abyte0[k];
        k = j + 1;
        long l1 = abyte0[j];
        j = k + 1;
        long l2 = abyte0[k];
        k = j + 1;
        long l3 = abyte0[j];
        j = k + 1;
        long l4 = abyte0[k];
        k = j + 1;
        long l5 = abyte0[j];
        j = k + 1;
        long l6 = abyte0[k];
        k = j + 1;
        l = (l & 255L) << 56 | (l1 & 255L) << 48 | (l2 & 255L) << 40 | (l3 & 255L) << 32 | (l4 & 255L) << 24 | (l5 & 255L) << 16 | (l6 & 255L) << 8 | (long)abyte0[j] & 255L;
        size = size - 8L;
        if (k == i)
        {
            Vh = wk1._mth0288();
            wl._mth02CA(wk1);
            return l;
        } else
        {
            wk1.pos = k;
            return l;
        }
    }

    public final short readShort()
    {
        if (size < 2L)
        {
            throw new IllegalStateException((new StringBuilder("size < 2: ")).append(size).toString());
        }
        wk wk1 = Vh;
        int k = wk1.pos;
        int i = wk1.limit;
        if (i - k < 2)
        {
            return (short)((readByte() & 0xff) << 8 | readByte() & 0xff);
        }
        byte abyte0[] = wk1.data;
        int j = k + 1;
        k = abyte0[k];
        int l = j + 1;
        j = abyte0[j];
        size = size - 2L;
        if (l == i)
        {
            Vh = wk1._mth0288();
            wl._mth02CA(wk1);
        } else
        {
            wk1.pos = l;
        }
        return (short)((k & 0xff) << 8 | j & 0xff);
    }

    public final wo timeout()
    {
        return wo.NONE;
    }

    public final String toString()
    {
        if (size == 0L)
        {
            return "Buffer[size=0]";
        }
        if (size <= 16L)
        {
            vw vw1 = new vw(FF9A().FF98());
            return String.format("Buffer[size=%s data=%s]", new Object[] {
                Long.valueOf(size), vw1._mth0192()
            });
        }
        String s;
        MessageDigest messagedigest;
        try
        {
            messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(Vh.data, Vh.pos, Vh.limit - Vh.pos);
            for (wk wk1 = Vh.VB; wk1 != Vh; wk1 = wk1.VB)
            {
                messagedigest.update(wk1.data, wk1.pos, wk1.limit - wk1.pos);
            }

        }
        // Misplaced declaration of an exception variable
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            throw new AssertionError();
        }
        s = String.format("Buffer[size=%s md5=%s]", new Object[] {
            Long.valueOf(size), vw._mth02C9(messagedigest.digest())._mth0192()
        });
        NoSuchAlgorithmException nosuchalgorithmexception;
        return s;
    }

    public final void write(vr vr1, long l)
    {
        if (vr1 == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        if (vr1 == this)
        {
            throw new IllegalArgumentException("source == this");
        }
        wq.checkOffsetAndCount(vr1.size, 0L, l);
        long l2;
        for (; l > 0L; l -= l2)
        {
            if (l < (long)(vr1.Vh.limit - vr1.Vh.pos))
            {
                wk wk1;
                if (Vh != null)
                {
                    wk1 = Vh.VC;
                } else
                {
                    wk1 = null;
                }
                if (wk1 != null && wk1.VA)
                {
                    long l1 = wk1.limit;
                    int i;
                    if (wk1.Vz)
                    {
                        i = 0;
                    } else
                    {
                        i = wk1.pos;
                    }
                    if ((l1 + l) - (long)i <= 2048L)
                    {
                        vr1.Vh._mth02CA(wk1, (int)l);
                        vr1.size = vr1.size - l;
                        size = size + l;
                        return;
                    }
                }
                wk wk3 = vr1.Vh;
                int j = (int)l;
                if (j <= 0 || j > wk3.limit - wk3.pos)
                {
                    throw new IllegalArgumentException();
                }
                wk1 = new wk(wk3);
                wk1.limit = wk1.pos + j;
                wk3.pos = wk3.pos + j;
                wk3 = wk3.VC;
                wk1.VC = wk3;
                wk1.VB = wk3.VB;
                wk3.VB.VC = wk1;
                wk3.VB = wk1;
                vr1.Vh = wk1;
            }
            wk wk2 = vr1.Vh;
            l2 = wk2.limit - wk2.pos;
            vr1.Vh = wk2._mth0288();
            if (Vh == null)
            {
                Vh = wk2;
                wk2 = Vh;
                wk wk4 = Vh;
                wk wk6 = Vh;
                wk4.VC = wk6;
                wk2.VB = wk6;
            } else
            {
                wk wk5 = Vh.VC;
                wk2.VC = wk5;
                wk2.VB = wk5.VB;
                wk5.VB.VC = wk2;
                wk5.VB = wk2;
                if (wk2.VC == wk2)
                {
                    throw new IllegalStateException();
                }
                if (wk2.VC.VA)
                {
                    int i1 = wk2.limit - wk2.pos;
                    int j1 = wk2.VC.limit;
                    int k;
                    if (wk2.VC.Vz)
                    {
                        k = 0;
                    } else
                    {
                        k = wk2.VC.pos;
                    }
                    if (i1 <= (2048 - j1) + k)
                    {
                        wk2._mth02CA(wk2.VC, i1);
                        wk2._mth0288();
                        wl._mth02CA(wk2);
                    }
                }
            }
            vr1.size = vr1.size - l2;
            size = size + l2;
        }

    }

    public final volatile vu _mth0165()
    {
        return this;
    }

    public final vr _mth02B5(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("string == null");
        }
        int i = 0;
        for (int l = s.length(); i < l;)
        {
            char c = s.charAt(i);
            if (c < '\200')
            {
                wk wk1 = _mth0406(1);
                byte abyte0[] = wk1.data;
                int i1 = wk1.limit - i;
                int j1 = Math.min(l, 2048 - i1);
                int j = i + 1;
                abyte0[i + i1] = (byte)c;
                i = j;
                do
                {
                    if (i >= j1)
                    {
                        break;
                    }
                    c = s.charAt(i);
                    if (c >= '\200')
                    {
                        break;
                    }
                    j = i + 1;
                    abyte0[i + i1] = (byte)c;
                    i = j;
                } while (true);
                j = (i + i1) - wk1.limit;
                wk1.limit = wk1.limit + j;
                size = size + (long)j;
            } else
            if (c < '\u0800')
            {
                FEE7(c >> 6 | 0xc0);
                FEE7(c & 0x3f | 0x80);
                i++;
            } else
            if (c < '\uD800' || c > '\uDFFF')
            {
                FEE7(c >> 12 | 0xe0);
                FEE7(c >> 6 & 0x3f | 0x80);
                FEE7(c & 0x3f | 0x80);
                i++;
            } else
            {
                int k;
                if (i + 1 < l)
                {
                    k = s.charAt(i + 1);
                } else
                {
                    k = 0;
                }
                if (c > '\uDBFF' || k < '\uDC00' || k > '\uDFFF')
                {
                    FEE7(63);
                    i++;
                } else
                {
                    k = 0x10000 + ((0xffff27ff & c) << 10 | 0xffff23ff & k);
                    FEE7(k >> 18 | 0xf0);
                    FEE7(k >> 12 & 0x3f | 0x80);
                    FEE7(k >> 6 & 0x3f | 0x80);
                    FEE7(k & 0x3f | 0x80);
                    i += 2;
                }
            }
        }

        return this;
    }

    public final vu _mth02B8(String s)
    {
        return _mth02B5(s);
    }

    public final vu _mth02B9(long l)
    {
        return _mth0640(l);
    }

    public final vr _mth02BA(int i)
    {
        wk wk1 = _mth0406(2);
        byte abyte0[] = wk1.data;
        int j = wk1.limit;
        int k = j + 1;
        abyte0[j] = (byte)(i >>> 8);
        abyte0[k] = (byte)i;
        wk1.limit = k + 1;
        size = size + 2L;
        return this;
    }

    public final vr _mth02BC(byte abyte0[], int i, int j)
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        wq.checkOffsetAndCount(abyte0.length, i, j);
        for (int k = i + j; i < k;)
        {
            wk wk1 = _mth0406(1);
            int l = Math.min(k - i, 2048 - wk1.limit);
            System.arraycopy(abyte0, i, wk1.data, wk1.limit, l);
            i += l;
            wk1.limit = wk1.limit + l;
        }

        size = size + (long)j;
        return this;
    }

    public final vu _mth02BD(byte abyte0[], int i, int j)
    {
        return _mth02BC(abyte0, i, j);
    }

    public final void _mth02BF(long l)
    {
        if (size < l)
        {
            throw new EOFException();
        } else
        {
            return;
        }
    }

    public final byte _mth02C8(long l)
    {
        wq.checkOffsetAndCount(size, l, 1L);
        wk wk1 = Vh;
        do
        {
            int i = wk1.limit - wk1.pos;
            if (l < (long)i)
            {
                return wk1.data[wk1.pos + (int)l];
            }
            l -= i;
            wk1 = wk1.VB;
        } while (true);
    }

    public final vu _mth02C8(byte abyte0[])
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("source == null");
        } else
        {
            return _mth02BC(abyte0, 0, abyte0.length);
        }
    }

    public final vw _mth02C9(long l)
    {
        return new vw(_mth02CD(l));
    }

    public final long _mth02CA(byte byte0, long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        wk wk1 = Vh;
        if (wk1 == null)
        {
            return -1L;
        }
        long l1 = 0L;
        wk wk2;
        do
        {
            int i = wk1.limit - wk1.pos;
            if (l >= (long)i)
            {
                l -= i;
            } else
            {
                byte abyte0[] = wk1.data;
                l = (long)wk1.pos + l;
                for (long l2 = wk1.limit; l < l2; l++)
                {
                    if (abyte0[(int)l] == byte0)
                    {
                        return (l1 + l) - (long)wk1.pos;
                    }
                }

                l = 0L;
            }
            l1 += i;
            wk2 = wk1.VB;
            wk1 = wk2;
        } while (wk2 != Vh);
        return -1L;
    }

    public final long _mth02CA(wn wn1)
    {
        if (wn1 == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        long l = 0L;
        do
        {
            long l1 = wn1.read(this, 2048L);
            if (l1 != -1L)
            {
                l += l1;
            } else
            {
                return l;
            }
        } while (true);
    }

    public final vr _mth02CA(vr vr1, long l, long l1)
    {
        if (vr1 == null)
        {
            throw new IllegalArgumentException("out == null");
        }
        wq.checkOffsetAndCount(size, l, l1);
        if (l1 == 0L)
        {
            return this;
        }
        vr1.size = vr1.size + l1;
        wk wk1 = Vh;
        wk wk3;
        long l2;
        long l3;
        do
        {
            wk3 = wk1;
            l2 = l;
            l3 = l1;
            if (l < (long)(wk1.limit - wk1.pos))
            {
                break;
            }
            l -= wk1.limit - wk1.pos;
            wk1 = wk1.VB;
        } while (true);
        while (l3 > 0L) 
        {
            wk wk2 = new wk(wk3);
            wk2.pos = (int)((long)wk2.pos + l2);
            wk2.limit = Math.min(wk2.pos + (int)l3, wk2.limit);
            if (vr1.Vh == null)
            {
                wk2.VC = wk2;
                wk2.VB = wk2;
                vr1.Vh = wk2;
            } else
            {
                wk wk4 = vr1.Vh.VC;
                wk2.VC = wk4;
                wk2.VB = wk4.VB;
                wk4.VB.VC = wk2;
                wk4.VB = wk2;
            }
            l3 -= wk2.limit - wk2.pos;
            l2 = 0L;
            wk3 = wk3.VB;
        }
        return this;
    }

    public final vu _mth02CA(vw vw1)
    {
        if (vw1 == null)
        {
            throw new IllegalArgumentException("byteString == null");
        } else
        {
            vw1._mth02CA(this);
            return this;
        }
    }

    public final void _mth02CA(vr vr1, long l)
    {
        if (size < l)
        {
            vr1.write(this, size);
            throw new EOFException();
        } else
        {
            vr1.write(this, l);
            return;
        }
    }

    final String _mth02CC(long l)
    {
        if (l > 0L && _mth02C8(l - 1L) == 13)
        {
            String s = _mth02CA(l - 1L, wq.UTF_8);
            _mth02D1(2L);
            return s;
        } else
        {
            String s1 = _mth02CA(l, wq.UTF_8);
            _mth02D1(1L);
            return s1;
        }
    }

    public final byte[] _mth02CD(long l)
    {
        wq.checkOffsetAndCount(size, 0L, l);
        if (l > 0x7fffffffL)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount > Integer.MAX_VALUE: ")).append(l).toString());
        } else
        {
            byte abyte0[] = new byte[(int)l];
            readFully(abyte0);
            return abyte0;
        }
    }

    public final long _mth02CE(byte byte0)
    {
        return _mth02CA(byte0, 0L);
    }

    public final void _mth02D1(long l)
    {
        do
        {
            if (l <= 0L)
            {
                break;
            }
            if (Vh == null)
            {
                throw new EOFException();
            }
            int i = (int)Math.min(l, Vh.limit - Vh.pos);
            size = size - (long)i;
            l -= i;
            wk wk1 = Vh;
            wk1.pos = wk1.pos + i;
            if (Vh.pos == Vh.limit)
            {
                wk wk2 = Vh;
                Vh = wk2._mth0288();
                wl._mth02CA(wk2);
            }
        } while (true);
    }

    public final vr _mth0399(int i)
    {
        wk wk1 = _mth0406(4);
        byte abyte0[] = wk1.data;
        int k = wk1.limit;
        int j = k + 1;
        abyte0[k] = (byte)(i >>> 24);
        k = j + 1;
        abyte0[j] = (byte)(i >>> 16);
        j = k + 1;
        abyte0[k] = (byte)(i >>> 8);
        abyte0[j] = (byte)i;
        wk1.limit = j + 1;
        size = size + 4L;
        return this;
    }

    final wk _mth0406(int i)
    {
        wk wk2;
label0:
        {
            if (i <= 0 || i > 2048)
            {
                throw new IllegalArgumentException();
            }
            if (Vh == null)
            {
                Vh = wl._mth02A1();
                wk wk1 = Vh;
                wk wk3 = Vh;
                wk wk5 = Vh;
                wk3.VC = wk5;
                wk1.VB = wk5;
                return wk5;
            }
            wk wk4 = Vh.VC;
            if (wk4.limit + i <= 2048)
            {
                wk2 = wk4;
                if (wk4.VA)
                {
                    break label0;
                }
            }
            wk2 = wl._mth02A1();
            wk2.VC = wk4;
            wk2.VB = wk4.VB;
            wk4.VB.VC = wk2;
            wk4.VB = wk2;
        }
        return wk2;
    }

    public final vu _mth0456(int i)
    {
        return _mth0399(i);
    }

    public final vu _mth0457(int i)
    {
        return _mth02BA(i);
    }

    public final vu _mth04C0(int i)
    {
        return FEE7(i);
    }

    public final vr _mth0640(long l)
    {
        wk wk1 = _mth0406(8);
        byte abyte0[] = wk1.data;
        int j = wk1.limit;
        int i = j + 1;
        abyte0[j] = (byte)(int)(l >>> 56 & 255L);
        j = i + 1;
        abyte0[i] = (byte)(int)(l >>> 48 & 255L);
        i = j + 1;
        abyte0[j] = (byte)(int)(l >>> 40 & 255L);
        j = i + 1;
        abyte0[i] = (byte)(int)(l >>> 32 & 255L);
        i = j + 1;
        abyte0[j] = (byte)(int)(l >>> 24 & 255L);
        j = i + 1;
        abyte0[i] = (byte)(int)(l >>> 16 & 255L);
        i = j + 1;
        abyte0[j] = (byte)(int)(l >>> 8 & 255L);
        abyte0[i] = (byte)(int)(255L & l);
        wk1.limit = i + 1;
        size = size + 8L;
        return this;
    }

    public final vr _mth1427(long l)
    {
        if (l == 0L)
        {
            return FEE7(48);
        }
        boolean flag = false;
        long l1 = l;
        if (l < 0L)
        {
            l = -l;
            l1 = l;
            if (l < 0L)
            {
                return _mth02B5("-9223372036854775808");
            }
            flag = true;
        }
        int i;
        if (l1 < 0x5f5e100L)
        {
            if (l1 < 10000L)
            {
                if (l1 < 100L)
                {
                    if (l1 < 10L)
                    {
                        i = 1;
                    } else
                    {
                        i = 2;
                    }
                } else
                if (l1 < 1000L)
                {
                    i = 3;
                } else
                {
                    i = 4;
                }
            } else
            if (l1 < 0xf4240L)
            {
                if (l1 < 0x186a0L)
                {
                    i = 5;
                } else
                {
                    i = 6;
                }
            } else
            if (l1 < 0x989680L)
            {
                i = 7;
            } else
            {
                i = 8;
            }
        } else
        if (l1 < 0xe8d4a51000L)
        {
            if (l1 < 0x2540be400L)
            {
                if (l1 < 0x3b9aca00L)
                {
                    i = 9;
                } else
                {
                    i = 10;
                }
            } else
            if (l1 < 0x174876e800L)
            {
                i = 11;
            } else
            {
                i = 12;
            }
        } else
        if (l1 < 0x38d7ea4c68000L)
        {
            if (l1 < 0x9184e72a000L)
            {
                i = 13;
            } else
            if (l1 < 0x5af3107a4000L)
            {
                i = 14;
            } else
            {
                i = 15;
            }
        } else
        if (l1 < 0x16345785d8a0000L)
        {
            if (l1 < 0x2386f26fc10000L)
            {
                i = 16;
            } else
            {
                i = 17;
            }
        } else
        if (l1 < 0xde0b6b3a7640000L)
        {
            i = 18;
        } else
        {
            i = 19;
        }
        int j = i;
        if (flag)
        {
            j = i + 1;
        }
        wk wk1 = _mth0406(j);
        byte abyte0[] = wk1.data;
        i = wk1.limit + j;
        for (; l1 != 0L; l1 /= 10L)
        {
            int k = (int)(l1 % 10L);
            i--;
            abyte0[i] = Vg[k];
        }

        if (flag)
        {
            abyte0[i - 1] = 45;
        }
        wk1.limit = wk1.limit + j;
        size = size + (long)j;
        return this;
    }

    public final vr _mth1428(long l)
    {
        if (l == 0L)
        {
            return FEE7(48);
        }
        int j = Long.numberOfTrailingZeros(Long.highestOneBit(l)) / 4 + 1;
        wk wk1 = _mth0406(j);
        byte abyte0[] = wk1.data;
        int i = (wk1.limit + j) - 1;
        for (int k = wk1.limit; i >= k; i--)
        {
            abyte0[i] = Vg[(int)(15L & l)];
            l >>>= 4;
        }

        wk1.limit = wk1.limit + j;
        size = size + (long)j;
        return this;
    }

    public final vu FE73(long l)
    {
        return _mth1428(l);
    }

    public final vr FE93()
    {
        return this;
    }

    public final OutputStream FEE4()
    {
        return new vs(this);
    }

    public final vu FEE5()
    {
        return this;
    }

    public final vr FEE7(int i)
    {
        wk wk1 = _mth0406(1);
        byte abyte0[] = wk1.data;
        int j = wk1.limit;
        wk1.limit = j + 1;
        abyte0[j] = (byte)i;
        size = size + 1L;
        return this;
    }

    public final boolean FF46()
    {
        return size == 0L;
    }

    public final InputStream FF49()
    {
        return new vt(this);
    }

    public final long FF54()
    {
        long l1 = size;
        long l = l1;
        if (l1 == 0L)
        {
            return 0L;
        }
        wk wk1 = Vh.VC;
        l1 = l;
        if (wk1.limit < 2048)
        {
            l1 = l;
            if (wk1.VA)
            {
                l1 = l - (long)(wk1.limit - wk1.pos);
            }
        }
        return l1;
    }

    public final short FF56()
    {
        return wq._mth02CA(readShort());
    }

    public final int FF6C()
    {
        return wq._mth05F2(readInt());
    }

    public final long FF74()
    {
        if (size == 0L)
        {
            throw new IllegalStateException("size == 0");
        }
        long l3 = 0L;
        int k = 0;
        byte byte0 = 0;
        boolean flag = false;
        long l2 = -7L;
        int i;
        boolean flag1;
        long l1;
        do
        {
            Object obj = Vh;
            byte abyte0[] = ((wk) (obj)).data;
            int j = ((wk) (obj)).pos;
            int l = ((wk) (obj)).limit;
            flag1 = byte0;
            i = k;
            l1 = l3;
            boolean flag2;
            do
            {
                flag2 = flag;
                if (j >= l)
                {
                    break;
                }
                byte0 = abyte0[j];
                if (byte0 >= 48 && byte0 <= 57)
                {
                    k = 48 - byte0;
                    if (l1 < 0xf333333333333334L || l1 == 0xf333333333333334L && (long)k < l2)
                    {
                        obj = (new vr())._mth1427(l1).FEE7(byte0);
                        if (!flag1)
                        {
                            ((vr) (obj)).readByte();
                        }
                        throw new NumberFormatException((new StringBuilder("Number too large: ")).append(((vr) (obj)).FF8B()).toString());
                    }
                    l1 = 10L * l1 + (long)k;
                } else
                if (byte0 == 45 && i == 0)
                {
                    flag1 = true;
                    l2--;
                } else
                {
                    if (i == 0)
                    {
                        throw new NumberFormatException((new StringBuilder("Expected leading [0-9] or '-' character but was 0x")).append(Integer.toHexString(byte0)).toString());
                    }
                    flag2 = true;
                    break;
                }
                j++;
                i++;
            } while (true);
            if (j == l)
            {
                Vh = ((wk) (obj))._mth0288();
                wl._mth02CA(((wk) (obj)));
            } else
            {
                obj.pos = j;
            }
            if (flag2)
            {
                break;
            }
            l3 = l1;
            k = i;
            byte0 = flag1;
            flag = flag2;
        } while (Vh != null);
        size = size - (long)i;
        if (flag1)
        {
            return l1;
        } else
        {
            return -l1;
        }
    }

    public final long FF7A()
    {
        if (size == 0L)
        {
            throw new IllegalStateException("size == 0");
        }
        long l1 = 0L;
        int i = 0;
        byte byte0 = 0;
        int j;
        long l2;
        do
        {
            Object obj = Vh;
            byte abyte0[] = ((wk) (obj)).data;
            int k = ((wk) (obj)).pos;
            int l = ((wk) (obj)).limit;
            j = i;
            l2 = l1;
            byte byte1;
            do
            {
                byte1 = byte0;
                if (k >= l)
                {
                    break;
                }
                byte1 = abyte0[k];
                if (byte1 >= 48 && byte1 <= 57)
                {
                    i = byte1 - 48;
                } else
                if (byte1 >= 97 && byte1 <= 102)
                {
                    i = (byte1 - 97) + 10;
                } else
                if (byte1 >= 65 && byte1 <= 70)
                {
                    i = (byte1 - 65) + 10;
                } else
                {
                    if (j == 0)
                    {
                        throw new NumberFormatException((new StringBuilder("Expected leading [0-9a-fA-F] character but was 0x")).append(Integer.toHexString(byte1)).toString());
                    }
                    byte1 = 1;
                    break;
                }
                if ((0xf000000000000000L & l2) != 0L)
                {
                    obj = (new vr())._mth1428(l2).FEE7(byte1);
                    throw new NumberFormatException((new StringBuilder("Number too large: ")).append(((vr) (obj)).FF8B()).toString());
                }
                l2 = l2 << 4 | (long)i;
                k++;
                j++;
            } while (true);
            if (k == l)
            {
                Vh = ((wk) (obj))._mth0288();
                wl._mth02CA(((wk) (obj)));
            } else
            {
                obj.pos = k;
            }
            if (byte1 != 0)
            {
                break;
            }
            l1 = l2;
            i = j;
            byte0 = byte1;
        } while (Vh != null);
        size = size - (long)j;
        return l2;
    }

    public final String FF8B()
    {
        String s;
        try
        {
            s = _mth02CA(size, wq.UTF_8);
        }
        catch (EOFException eofexception)
        {
            throw new AssertionError(eofexception);
        }
        return s;
    }

    public final String FF90()
    {
        long l = _mth02CA((byte)10, 0L);
        if (l == -1L)
        {
            vr vr1 = new vr();
            _mth02CA(vr1, 0L, Math.min(32L, size));
            throw new EOFException((new StringBuilder("\\n not found: size=")).append(size).append(" content=").append((new vw(vr1.FF98()))._mth0192()).append("...").toString());
        } else
        {
            return _mth02CC(l);
        }
    }

    public final byte[] FF98()
    {
        byte abyte0[];
        try
        {
            abyte0 = _mth02CD(size);
        }
        catch (EOFException eofexception)
        {
            throw new AssertionError(eofexception);
        }
        return abyte0;
    }

    public final vu FF9E(long l)
    {
        return _mth1427(l);
    }

}
