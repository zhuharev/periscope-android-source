// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            cu, cv, cr

final class cs extends cu
{

    private cr Ca;

    cs(cr cr1)
    {
        Ca = cr1;
        super();
    }

    protected final cr _mth0129()
    {
        return Ca;
    }

    protected final Object _mth02CA(int i, Object obj)
    {
        cr cr1 = Ca;
        i = (i << 1) + 1;
        Object obj1 = ((cv) (cr1)).FB48[i];
        ((cv) (cr1)).FB48[i] = obj;
        return obj1;
    }

    protected final void _mth02CA(Object obj, Object obj1)
    {
        Ca.put(obj, obj1);
    }

    protected final int _mth02CE(Object obj)
    {
        if (obj == null)
        {
            return Ca._mth1D55();
        } else
        {
            return Ca.indexOf(obj, obj.hashCode());
        }
    }

    protected final Object _mth02CE(int i, int j)
    {
        return Ca.FB48[(i << 1) + j];
    }

    protected final int _mth02CF(Object obj)
    {
        return Ca.indexOfValue(obj);
    }

    protected final int _mth1420()
    {
        return Ca._fld1D61;
    }

    protected final void _mth1429()
    {
        Ca.clear();
    }

    protected final void _mth1FBE(int i)
    {
        Ca.removeAt(i);
    }
}
