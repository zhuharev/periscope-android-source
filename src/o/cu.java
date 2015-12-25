// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package o:
//            cr

abstract class cu
{
    final class if
        implements Iterator
    {

        private cu Ce;
        private int mIndex;
        private int _fld1D4A;
        private int _fld1D61;
        private boolean _fld1D6A;

        public final boolean hasNext()
        {
            return mIndex < _fld1D61;
        }

        public final Object next()
        {
            Object obj = Ce._mth02CE(mIndex, _fld1D4A);
            mIndex = mIndex + 1;
            _fld1D6A = true;
            return obj;
        }

        public final void remove()
        {
            if (!_fld1D6A)
            {
                throw new IllegalStateException();
            } else
            {
                mIndex = mIndex - 1;
                _fld1D61 = _fld1D61 - 1;
                _fld1D6A = false;
                Ce._mth1FBE(mIndex);
                return;
            }
        }

        if(int i)
        {
            Ce = cu.this;
            super();
            _fld1D6A = false;
            _fld1D4A = i;
            _fld1D61 = _mth1420();
        }
    }

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}

    /* member class not found */
    class _cls02CF {}


    _cls02CA Cb;
    _cls02CB Cc;
    _cls02CF Cd;

    cu()
    {
    }

    public static boolean _mth02CA(Set set, Object obj)
    {
        if (set == obj)
        {
            return true;
        }
        if (obj instanceof Set)
        {
label0:
            {
                obj = (Set)obj;
                boolean flag;
                try
                {
                    if (set.size() != ((Set) (obj)).size())
                    {
                        break label0;
                    }
                    flag = set.containsAll(((java.util.Collection) (obj)));
                }
                // Misplaced declaration of an exception variable
                catch (Set set)
                {
                    return false;
                }
                // Misplaced declaration of an exception variable
                catch (Set set)
                {
                    return false;
                }
                if (flag)
                {
                    return true;
                }
            }
            return false;
        } else
        {
            return false;
        }
    }

    protected abstract cr _mth0129();

    public final Object[] _mth02BF(int i)
    {
        int k = _mth1420();
        Object aobj[] = new Object[k];
        for (int j = 0; j < k; j++)
        {
            aobj[j] = _mth02CE(j, i);
        }

        return aobj;
    }

    protected abstract Object _mth02CA(int i, Object obj);

    protected abstract void _mth02CA(Object obj, Object obj1);

    public final Object[] _mth02CA(Object aobj[], int i)
    {
        int k = _mth1420();
        Object aobj1[] = aobj;
        if (aobj.length < k)
        {
            aobj1 = (Object[])Array.newInstance(((Object) (aobj)).getClass().getComponentType(), k);
        }
        for (int j = 0; j < k; j++)
        {
            aobj1[j] = _mth02CE(j, i);
        }

        if (aobj1.length > k)
        {
            aobj1[k] = null;
        }
        return aobj1;
    }

    protected abstract int _mth02CE(Object obj);

    protected abstract Object _mth02CE(int i, int j);

    protected abstract int _mth02CF(Object obj);

    protected abstract int _mth1420();

    protected abstract void _mth1429();

    protected abstract void _mth1FBE(int i);
}
