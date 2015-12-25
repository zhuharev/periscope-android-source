// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Iterator;

// Referenced classes of package o:
//            cu

final class _cls0
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

    (cu cu1, int i)
    {
        Ce = cu1;
        super();
        _fld1D6A = false;
        _fld1D4A = i;
        _fld1D61 = cu1._mth1420();
    }
}
