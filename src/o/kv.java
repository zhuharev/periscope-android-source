// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package o:
//            mq, kw, ms, io, 
//            it, kd, iw, is, 
//            iq

public final class kv extends mq
{

    private static final kw HN = new kw();
    private static final Object HO = new Object();
    public final ArrayList HP = new ArrayList();

    public kv(iq iq)
    {
        super(HN);
        HP.add(iq);
    }

    public final void beginArray()
    {
        _mth02CA(ms.JG);
        io io1 = (io)HP.get(HP.size() - 1);
        HP.add(io1.iterator());
    }

    public final void beginObject()
    {
        _mth02CA(ms.JI);
        it it1 = (it)HP.get(HP.size() - 1);
        HP.add(it1.GC.entrySet().iterator());
    }

    public final void close()
    {
        HP.clear();
        HP.add(HO);
    }

    public final void endArray()
    {
        _mth02CA(ms.JH);
        HP.remove(HP.size() - 1);
        HP.remove(HP.size() - 1);
    }

    public final void endObject()
    {
        _mth02CA(ms.JJ);
        HP.remove(HP.size() - 1);
        HP.remove(HP.size() - 1);
    }

    public final boolean hasNext()
    {
        ms ms1 = _mth13A2();
        return ms1 != ms.JJ && ms1 != ms.JH;
    }

    public final boolean nextBoolean()
    {
        _mth02CA(ms.JN);
        return ((iw)HP.remove(HP.size() - 1))._mth0672();
    }

    public final double nextDouble()
    {
        Object obj = _mth13A2();
        if (obj != ms.JM && obj != ms.JL)
        {
            throw new IllegalStateException((new StringBuilder("Expected ")).append(ms.JM).append(" but was ").append(obj).toString());
        }
        obj = (iw)HP.get(HP.size() - 1);
        double d;
        if (((iw) (obj)).value instanceof Number)
        {
            d = ((iw) (obj))._mth04AD().doubleValue();
        } else
        {
            d = Double.parseDouble(((iw) (obj))._mth04AE());
        }
        if (!super.Ju && (Double.isNaN(d) || Double.isInfinite(d)))
        {
            throw new NumberFormatException((new StringBuilder("JSON forbids NaN and infinities: ")).append(d).toString());
        } else
        {
            HP.remove(HP.size() - 1);
            return d;
        }
    }

    public final int nextInt()
    {
        Object obj = _mth13A2();
        if (obj != ms.JM && obj != ms.JL)
        {
            throw new IllegalStateException((new StringBuilder("Expected ")).append(ms.JM).append(" but was ").append(obj).toString());
        }
        obj = (iw)HP.get(HP.size() - 1);
        int i;
        if (((iw) (obj)).value instanceof Number)
        {
            i = ((iw) (obj))._mth04AD().intValue();
        } else
        {
            i = Integer.parseInt(((iw) (obj))._mth04AE());
        }
        HP.remove(HP.size() - 1);
        return i;
    }

    public final long nextLong()
    {
        Object obj = _mth13A2();
        if (obj != ms.JM && obj != ms.JL)
        {
            throw new IllegalStateException((new StringBuilder("Expected ")).append(ms.JM).append(" but was ").append(obj).toString());
        }
        obj = (iw)HP.get(HP.size() - 1);
        long l;
        if (((iw) (obj)).value instanceof Number)
        {
            l = ((iw) (obj))._mth04AD().longValue();
        } else
        {
            l = Long.parseLong(((iw) (obj))._mth04AE());
        }
        HP.remove(HP.size() - 1);
        return l;
    }

    public final String nextName()
    {
        _mth02CA(ms.JK);
        java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator)HP.get(HP.size() - 1)).next();
        HP.add(entry.getValue());
        return (String)entry.getKey();
    }

    public final void nextNull()
    {
        _mth02CA(ms.JO);
        HP.remove(HP.size() - 1);
    }

    public final String nextString()
    {
        ms ms1 = _mth13A2();
        if (ms1 != ms.JL && ms1 != ms.JM)
        {
            throw new IllegalStateException((new StringBuilder("Expected ")).append(ms.JL).append(" but was ").append(ms1).toString());
        } else
        {
            return ((iw)HP.remove(HP.size() - 1))._mth04AE();
        }
    }

    public final void skipValue()
    {
        if (_mth13A2() == ms.JK)
        {
            nextName();
            return;
        } else
        {
            HP.remove(HP.size() - 1);
            return;
        }
    }

    public final String toString()
    {
        return getClass().getSimpleName();
    }

    public void _mth02CA(ms ms1)
    {
        if (_mth13A2() != ms1)
        {
            throw new IllegalStateException((new StringBuilder("Expected ")).append(ms1).append(" but was ").append(_mth13A2()).toString());
        } else
        {
            return;
        }
    }

    public final ms _mth13A2()
    {
        Object obj;
        do
        {
            if (HP.isEmpty())
            {
                return ms.JP;
            }
            obj = HP.get(HP.size() - 1);
            if (!(obj instanceof Iterator))
            {
                break;
            }
            boolean flag = HP.get(HP.size() - 2) instanceof it;
            obj = (Iterator)obj;
            if (((Iterator) (obj)).hasNext())
            {
                if (flag)
                {
                    return ms.JK;
                }
                HP.add(((Iterator) (obj)).next());
            } else
            if (flag)
            {
                return ms.JJ;
            } else
            {
                return ms.JH;
            }
        } while (true);
        if (obj instanceof it)
        {
            return ms.JI;
        }
        if (obj instanceof io)
        {
            return ms.JG;
        }
        if (obj instanceof iw)
        {
            obj = (iw)obj;
            if (((iw) (obj)).value instanceof String)
            {
                return ms.JL;
            }
            if (((iw) (obj)).value instanceof Boolean)
            {
                return ms.JN;
            }
            if (((iw) (obj)).value instanceof Number)
            {
                return ms.JM;
            } else
            {
                throw new AssertionError();
            }
        }
        if (obj instanceof is)
        {
            return ms.JO;
        }
        if (obj == HO)
        {
            throw new IllegalStateException("JsonReader is closed");
        } else
        {
            throw new AssertionError();
        }
    }

}
