// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls1505

public class _cls157D
    implements Cloneable
{

    private static final Object FB55 = new Object();
    private int _fld1D61;
    private boolean FB5C;
    private int FB61[];
    private Object FB64[];

    public _cls157D()
    {
        this(10);
    }

    public _cls157D(int i)
    {
        FB5C = false;
        if (i == 0)
        {
            FB61 = _cls1505._fld1506;
            FB64 = _cls1505._fld1D16;
        } else
        {
            i = _cls1505._mth02BE(i);
            FB61 = new int[i];
            FB64 = new Object[i];
        }
        _fld1D61 = 0;
    }

    private void gc()
    {
        int l = _fld1D61;
        int j = 0;
        int ai[] = FB61;
        Object aobj[] = FB64;
        for (int i = 0; i < l;)
        {
            Object obj = aobj[i];
            int k = j;
            if (obj != FB55)
            {
                if (i != j)
                {
                    ai[j] = ai[i];
                    aobj[j] = obj;
                    aobj[i] = null;
                }
                k = j + 1;
            }
            i++;
            j = k;
        }

        FB5C = false;
        _fld1D61 = j;
    }

    public void clear()
    {
        int j = _fld1D61;
        Object aobj[] = FB64;
        for (int i = 0; i < j; i++)
        {
            aobj[i] = null;
        }

        _fld1D61 = 0;
        FB5C = false;
    }

    public Object clone()
    {
        return _mth1D63();
    }

    public int keyAt(int i)
    {
        if (FB5C)
        {
            gc();
        }
        return FB61[i];
    }

    public int size()
    {
        if (FB5C)
        {
            gc();
        }
        return _fld1D61;
    }

    public String toString()
    {
        if (size() <= 0)
        {
            return "{}";
        }
        StringBuilder stringbuilder = new StringBuilder(_fld1D61 * 28);
        stringbuilder.append('{');
        for (int i = 0; i < _fld1D61; i++)
        {
            if (i > 0)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append(keyAt(i));
            stringbuilder.append('=');
            Object obj = valueAt(i);
            if (obj != this)
            {
                stringbuilder.append(obj);
            } else
            {
                stringbuilder.append("(this Map)");
            }
        }

        stringbuilder.append('}');
        return stringbuilder.toString();
    }

    public Object valueAt(int i)
    {
        if (FB5C)
        {
            gc();
        }
        return FB64[i];
    }

    public _cls157D _mth1D63()
    {
        _cls157D _lcls157d = null;
        _cls157D _lcls157d1;
        _cls157D _lcls157d2;
        try
        {
            _lcls157d2 = (_cls157D)super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            return _lcls157d;
        }
        _lcls157d1 = _lcls157d2;
        _lcls157d = _lcls157d1;
        _lcls157d2.FB61 = (int[])FB61.clone();
        _lcls157d = _lcls157d1;
        _lcls157d1.FB64 = (Object[])((Object []) (FB64)).clone();
        return _lcls157d1;
    }

}
