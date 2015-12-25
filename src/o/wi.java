// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.EOFException;
import java.io.InputStream;

// Referenced classes of package o:
//            vv, vr, wn, wq, 
//            wj, vw, wo

final class wi
    implements vv
{

    public final vr Vu;
    public final wn Vx;
    boolean closed;

    public wi(wn wn1)
    {
        this(wn1, new vr());
    }

    private wi(wn wn1, vr vr1)
    {
        if (wn1 == null)
        {
            throw new IllegalArgumentException("source == null");
        } else
        {
            Vu = vr1;
            Vx = wn1;
            return;
        }
    }

    private long _mth02CA(byte byte0, long l)
    {
        if (closed)
        {
            throw new IllegalStateException("closed");
        }
        do
        {
            long l1 = l;
            if (0L >= Vu.size)
            {
                if (Vx.read(Vu, 2048L) == -1L)
                {
                    return -1L;
                }
            } else
            {
                do
                {
                    l = Vu._mth02CA(byte0, l1);
                    if (l == -1L)
                    {
                        l1 = Vu.size;
                        if (Vx.read(Vu, 2048L) == -1L)
                        {
                            return -1L;
                        }
                    } else
                    {
                        return l;
                    }
                } while (true);
            }
        } while (true);
    }

    private boolean _mth0559(long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
        }
        if (closed)
        {
            throw new IllegalStateException("closed");
        }
        while (Vu.size < l) 
        {
            if (Vx.read(Vu, 2048L) == -1L)
            {
                return false;
            }
        }
        return true;
    }

    public final void close()
    {
        if (closed)
        {
            return;
        }
        closed = true;
        Vx.close();
        vr vr1 = Vu;
        try
        {
            vr1._mth02D1(vr1.size);
            return;
        }
        catch (EOFException eofexception)
        {
            throw new AssertionError(eofexception);
        }
    }

    public final int read(byte abyte0[], int i, int j)
    {
        wq.checkOffsetAndCount(abyte0.length, i, j);
        if (Vu.size == 0L && Vx.read(Vu, 2048L) == -1L)
        {
            return -1;
        } else
        {
            j = (int)Math.min(j, Vu.size);
            return Vu.read(abyte0, i, j);
        }
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
        if (closed)
        {
            throw new IllegalStateException("closed");
        }
        if (Vu.size == 0L && Vx.read(Vu, 2048L) == -1L)
        {
            return -1L;
        } else
        {
            l = Math.min(l, Vu.size);
            return Vu.read(vr1, l);
        }
    }

    public final byte readByte()
    {
        if (!_mth0559(1L))
        {
            throw new EOFException();
        } else
        {
            return Vu.readByte();
        }
    }

    public final void readFully(byte abyte0[])
    {
        try
        {
            if (!_mth0559(abyte0.length))
            {
                throw new EOFException();
            }
        }
        catch (EOFException eofexception)
        {
            int j;
            for (int i = 0; Vu.size > 0L; i += j)
            {
                j = Vu.read(abyte0, i, (int)Vu.size - i);
                if (j == -1)
                {
                    throw new AssertionError();
                }
            }

            throw eofexception;
        }
        Vu.readFully(abyte0);
    }

    public final int readInt()
    {
        if (!_mth0559(4L))
        {
            throw new EOFException();
        } else
        {
            return Vu.readInt();
        }
    }

    public final long readLong()
    {
        if (!_mth0559(8L))
        {
            throw new EOFException();
        } else
        {
            return Vu.readLong();
        }
    }

    public final short readShort()
    {
        if (!_mth0559(2L))
        {
            throw new EOFException();
        } else
        {
            return Vu.readShort();
        }
    }

    public final wo timeout()
    {
        return Vx.timeout();
    }

    public final String toString()
    {
        return (new StringBuilder("buffer(")).append(Vx).append(")").toString();
    }

    public final void _mth02BF(long l)
    {
        if (!_mth0559(l))
        {
            throw new EOFException();
        } else
        {
            return;
        }
    }

    public final vw _mth02C9(long l)
    {
        if (!_mth0559(l))
        {
            throw new EOFException();
        } else
        {
            return Vu._mth02C9(l);
        }
    }

    public final void _mth02CA(vr vr1, long l)
    {
        try
        {
            if (!_mth0559(l))
            {
                throw new EOFException();
            }
        }
        catch (EOFException eofexception)
        {
            vr1._mth02CA(Vu);
            throw eofexception;
        }
        Vu._mth02CA(vr1, l);
    }

    public final byte[] _mth02CD(long l)
    {
        if (!_mth0559(l))
        {
            throw new EOFException();
        } else
        {
            return Vu._mth02CD(l);
        }
    }

    public final long _mth02CE(byte byte0)
    {
        return _mth02CA(byte0, 0L);
    }

    public final void _mth02D1(long l)
    {
        if (closed)
        {
            throw new IllegalStateException("closed");
        }
        long l1;
        for (; l > 0L; l -= l1)
        {
            if (Vu.size == 0L && Vx.read(Vu, 2048L) == -1L)
            {
                throw new EOFException();
            }
            l1 = Math.min(l, Vu.size);
            Vu._mth02D1(l1);
        }

    }

    public final vr FE93()
    {
        return Vu;
    }

    public final boolean FF46()
    {
        if (closed)
        {
            throw new IllegalStateException("closed");
        }
        boolean flag;
        if (Vu.size == 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag && Vx.read(Vu, 2048L) == -1L;
    }

    public final InputStream FF49()
    {
        return new wj(this);
    }

    public final short FF56()
    {
        if (!_mth0559(2L))
        {
            throw new EOFException();
        } else
        {
            return Vu.FF56();
        }
    }

    public final int FF6C()
    {
        if (!_mth0559(4L))
        {
            throw new EOFException();
        } else
        {
            return Vu.FF6C();
        }
    }

    public final long FF74()
    {
        int i = 0;
        do
        {
            if (!_mth0559(i + 1))
            {
                break;
            }
            byte byte0 = Vu._mth02C8(i);
            if ((byte0 < 48 || byte0 > 57) && (i != 0 || byte0 != 45))
            {
                break;
            }
            i++;
        } while (true);
        if (i == 0)
        {
            throw new NumberFormatException((new StringBuilder("Expected leading [0-9] or '-' character but was 0x")).append(Integer.toHexString(Vu._mth02C8(0L))).toString());
        } else
        {
            return Vu.FF74();
        }
    }

    public final long FF7A()
    {
        int i = 0;
        do
        {
            if (!_mth0559(i + 1))
            {
                break;
            }
            byte byte0 = Vu._mth02C8(i);
            if ((byte0 < 48 || byte0 > 57) && (byte0 < 97 || byte0 > 102) && (byte0 < 65 || byte0 > 70))
            {
                break;
            }
            i++;
        } while (true);
        if (i == 0)
        {
            throw new NumberFormatException((new StringBuilder("Expected leading [0-9a-fA-F] character but was 0x")).append(Integer.toHexString(Vu._mth02C8(0L))).toString());
        } else
        {
            return Vu.FF7A();
        }
    }

    public final String FF8B()
    {
        Vu._mth02CA(Vx);
        return Vu.FF8B();
    }

    public final String FF90()
    {
        long l = _mth02CA((byte)10, 0L);
        if (l == -1L)
        {
            vr vr1 = new vr();
            Vu._mth02CA(vr1, 0L, Math.min(32L, Vu.size));
            throw new EOFException((new StringBuilder("\\n not found: size=")).append(Vu.size).append(" content=").append((new vw(vr1.FF98()))._mth0192()).append("...").toString());
        } else
        {
            return Vu._mth02CC(l);
        }
    }

    public final byte[] FF98()
    {
        Vu._mth02CA(Vx);
        return Vu.FF98();
    }
}
