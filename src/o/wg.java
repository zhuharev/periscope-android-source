// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.OutputStream;

// Referenced classes of package o:
//            vu, vr, wm, wq, 
//            wn, vw, wh, wo

final class wg
    implements vu
{

    public final vr Vu;
    private wm Vv;
    boolean closed;

    public wg(wm wm1)
    {
        this(wm1, new vr());
    }

    private wg(wm wm1, vr vr1)
    {
        if (wm1 == null)
        {
            throw new IllegalArgumentException("sink == null");
        } else
        {
            Vu = vr1;
            Vv = wm1;
            return;
        }
    }

    public final void close()
    {
        Throwable throwable;
        if (closed)
        {
            return;
        }
        throwable = null;
        try
        {
            if (Vu.size > 0L)
            {
                Vv.write(Vu, Vu.size);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable) { }
        Vv.close();
        Throwable throwable1;
        throwable1 = throwable;
        break MISSING_BLOCK_LABEL_69;
        Throwable throwable2;
        throwable2;
        throwable1 = throwable;
        if (throwable == null)
        {
            throwable1 = throwable2;
        }
        closed = true;
        if (throwable1 != null)
        {
            wq._mth141D(throwable1);
        }
        return;
    }

    public final void flush()
    {
        if (closed)
        {
            throw new IllegalStateException("closed");
        }
        if (Vu.size > 0L)
        {
            Vv.write(Vu, Vu.size);
        }
        Vv.flush();
    }

    public final wo timeout()
    {
        return Vv.timeout();
    }

    public final String toString()
    {
        return (new StringBuilder("buffer(")).append(Vv).append(")").toString();
    }

    public final void write(vr vr1, long l)
    {
        if (closed)
        {
            throw new IllegalStateException("closed");
        } else
        {
            Vu.write(vr1, l);
            _mth0165();
            return;
        }
    }

    public final vu _mth0165()
    {
        if (closed)
        {
            throw new IllegalStateException("closed");
        }
        long l = Vu.FF54();
        if (l > 0L)
        {
            Vv.write(Vu, l);
        }
        return this;
    }

    public final vu _mth02B8(String s)
    {
        if (closed)
        {
            throw new IllegalStateException("closed");
        } else
        {
            Vu._mth02B5(s);
            return _mth0165();
        }
    }

    public final vu _mth02B9(long l)
    {
        if (closed)
        {
            throw new IllegalStateException("closed");
        } else
        {
            Vu._mth0640(l);
            return _mth0165();
        }
    }

    public final vu _mth02BD(byte abyte0[], int i, int j)
    {
        if (closed)
        {
            throw new IllegalStateException("closed");
        } else
        {
            Vu._mth02BC(abyte0, i, j);
            return _mth0165();
        }
    }

    public final vu _mth02C8(byte abyte0[])
    {
        if (closed)
        {
            throw new IllegalStateException("closed");
        }
        vr vr1 = Vu;
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("source == null");
        } else
        {
            vr1._mth02BC(abyte0, 0, abyte0.length);
            return _mth0165();
        }
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
            long l1 = wn1.read(Vu, 2048L);
            if (l1 != -1L)
            {
                l += l1;
                _mth0165();
            } else
            {
                return l;
            }
        } while (true);
    }

    public final vu _mth02CA(vw vw1)
    {
        if (closed)
        {
            throw new IllegalStateException("closed");
        }
        vr vr1 = Vu;
        if (vw1 == null)
        {
            throw new IllegalArgumentException("byteString == null");
        } else
        {
            vw1._mth02CA(vr1);
            return _mth0165();
        }
    }

    public final vu _mth0456(int i)
    {
        if (closed)
        {
            throw new IllegalStateException("closed");
        } else
        {
            Vu._mth0399(i);
            return _mth0165();
        }
    }

    public final vu _mth0457(int i)
    {
        if (closed)
        {
            throw new IllegalStateException("closed");
        } else
        {
            Vu._mth02BA(i);
            return _mth0165();
        }
    }

    public final vu _mth04C0(int i)
    {
        if (closed)
        {
            throw new IllegalStateException("closed");
        } else
        {
            Vu.FEE7(i);
            return _mth0165();
        }
    }

    public final vu FE73(long l)
    {
        if (closed)
        {
            throw new IllegalStateException("closed");
        } else
        {
            Vu._mth1428(l);
            return _mth0165();
        }
    }

    public final vr FE93()
    {
        return Vu;
    }

    public final OutputStream FEE4()
    {
        return new wh(this);
    }

    public final vu FEE5()
    {
        if (closed)
        {
            throw new IllegalStateException("closed");
        }
        long l = Vu.size;
        if (l > 0L)
        {
            Vv.write(Vu, l);
        }
        return this;
    }

    public final vu FF9E(long l)
    {
        if (closed)
        {
            throw new IllegalStateException("closed");
        } else
        {
            Vu._mth1427(l);
            return _mth0165();
        }
    }
}
