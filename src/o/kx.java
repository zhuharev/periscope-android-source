// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package o:
//            mt, ky, iw, is, 
//            iq, it, kd, io

public final class kx extends mt
{

    private static final ky HQ = new ky();
    private static final iw HR = new iw("closed");
    private final ArrayList HP = new ArrayList();
    private String HS;
    private iq HT;

    public kx()
    {
        super(HQ);
        HT = is.GB;
    }

    private void _mth02CB(iq iq1)
    {
        if (HS != null)
        {
            if (!(iq1 instanceof is) || super.Gj)
            {
                it it1 = (it)(iq)HP.get(HP.size() - 1);
                String s = HS;
                Object obj = iq1;
                if (iq1 == null)
                {
                    obj = is.GB;
                }
                it1.GC.put(s, obj);
            }
            HS = null;
            return;
        }
        if (HP.isEmpty())
        {
            HT = iq1;
            return;
        }
        Object obj1 = (iq)HP.get(HP.size() - 1);
        if (obj1 instanceof io)
        {
            io io1 = (io)obj1;
            obj1 = iq1;
            if (iq1 == null)
            {
                obj1 = is.GB;
            }
            io1.GA.add(obj1);
            return;
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final void close()
    {
        if (!HP.isEmpty())
        {
            throw new IOException("Incomplete document");
        } else
        {
            HP.add(HR);
            return;
        }
    }

    public final void flush()
    {
    }

    public final mt _mth02BE(long l)
    {
        _mth02CB(new iw(Long.valueOf(l)));
        return this;
    }

    public final mt _mth02CA(Number number)
    {
        if (number == null)
        {
            _mth02CB(is.GB);
            return this;
        }
        if (!super.Ju)
        {
            double d = number.doubleValue();
            if (Double.isNaN(d) || Double.isInfinite(d))
            {
                throw new IllegalArgumentException((new StringBuilder("JSON forbids NaN and infinities: ")).append(number).toString());
            }
        }
        _mth02CB(new iw(number));
        return this;
    }

    public final iq _mth13A8()
    {
        if (!HP.isEmpty())
        {
            throw new IllegalStateException((new StringBuilder("Expected one JSON element but was ")).append(HP).toString());
        } else
        {
            return HT;
        }
    }

    public final mt _mth13D0()
    {
        io io1 = new io();
        _mth02CB(io1);
        HP.add(io1);
        return this;
    }

    public final mt _mth141C()
    {
        if (HP.isEmpty() || HS != null)
        {
            throw new IllegalStateException();
        }
        if ((iq)HP.get(HP.size() - 1) instanceof io)
        {
            HP.remove(HP.size() - 1);
            return this;
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final mt _mth141F(String s)
    {
        if (HP.isEmpty() || HS != null)
        {
            throw new IllegalStateException();
        }
        if ((iq)HP.get(HP.size() - 1) instanceof it)
        {
            HS = s;
            return this;
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final mt _mth1421(String s)
    {
        if (s == null)
        {
            _mth02CB(is.GB);
            return this;
        } else
        {
            _mth02CB(new iw(s));
            return this;
        }
    }

    public final mt _mth14A9()
    {
        it it1 = new it();
        _mth02CB(it1);
        HP.add(it1);
        return this;
    }

    public final mt _mth14F6()
    {
        if (HP.isEmpty() || HS != null)
        {
            throw new IllegalStateException();
        }
        if ((iq)HP.get(HP.size() - 1) instanceof it)
        {
            HP.remove(HP.size() - 1);
            return this;
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final mt _mth14F7()
    {
        _mth02CB(is.GB);
        return this;
    }

    public final mt FF9F(boolean flag)
    {
        _mth02CB(new iw(Boolean.valueOf(flag)));
        return this;
    }

}
