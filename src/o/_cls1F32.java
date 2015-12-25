// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls2110, FF83

public final class _cls1F32
    implements _cls2110
{
    /* member class not found */
    class if {}


    private final _cls2110 oE;
    private final _cls2110 oF;

    public _cls1F32(_cls2110 _pcls2110, _cls2110 _pcls2110_1)
    {
        if (_pcls2110 == null && _pcls2110_1 == null)
        {
            throw new NullPointerException("At least one of streamLoader and fileDescriptorLoader must be non null");
        } else
        {
            oE = _pcls2110;
            oF = _pcls2110_1;
            return;
        }
    }

    public final FF83 _mth02CE(Object obj, int i, int j)
    {
        FF83 ff83 = null;
        if (oE != null)
        {
            ff83 = oE._mth02CE(obj, i, j);
        }
        FF83 ff83_1 = null;
        if (oF != null)
        {
            ff83_1 = oF._mth02CE(obj, i, j);
        }
        if (ff83 != null || ff83_1 != null)
        {
            return new if(ff83, ff83_1);
        } else
        {
            return null;
        }
    }
}
