// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls05D4, _cls14FF

public final class _cls1502
    implements _cls05D4
{

    private final _cls14FF qo;

    public _cls1502(_cls14FF _pcls14ff)
    {
        if (_pcls14ff == null)
        {
            throw new NullPointerException("Data must not be null");
        } else
        {
            qo = _pcls14ff;
            return;
        }
    }

    public final volatile Object get()
    {
        return qo;
    }

    public final int getSize()
    {
        _cls14FF _lcls14ff = qo;
        if (_lcls14ff.qn != null)
        {
            return _lcls14ff.qn.getSize();
        } else
        {
            return _lcls14ff.qm.getSize();
        }
    }

    public final void recycle()
    {
        _cls05D4 _lcls05d4 = qo.qn;
        if (_lcls05d4 != null)
        {
            _lcls05d4.recycle();
        }
        _lcls05d4 = qo.qm;
        if (_lcls05d4 != null)
        {
            _lcls05d4.recycle();
        }
    }
}
