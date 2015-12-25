// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Bitmap;

// Referenced classes of package o:
//            FF43, _cls05D4, _cls148D, _cls043E, 
//            _cls14D7, _cls1D2E, _cls06BA

public final class _cls14D5
    implements FF43
{

    private final _cls06BA je;
    private final FF43 pT;

    public _cls14D5(FF43 ff43, _cls06BA _pcls06ba)
    {
        pT = ff43;
        je = _pcls06ba;
    }

    public final String getId()
    {
        return pT.getId();
    }

    public final _cls05D4 _mth02CA(_cls05D4 _pcls05d4, int i, int j)
    {
        Object obj = (_cls148D)_pcls05d4.get();
        Object obj1 = new _cls043E(((_cls148D)_pcls05d4.get()).pF.pQ, je);
        Object obj2 = pT._mth02CA(((_cls05D4) (obj1)), i, j);
        if (!obj1.equals(obj2))
        {
            ((_cls05D4) (obj1)).recycle();
        }
        obj2 = (Bitmap)((_cls05D4) (obj2)).get();
        obj1 = pT;
        if (obj2 == null)
        {
            throw new NullPointerException("The first frame of the GIF must not be null");
        }
        if (obj1 == null)
        {
            throw new NullPointerException("The frame transformation must not be null");
        }
        ((_cls148D) (obj)).pF.pN = ((FF43) (obj1));
        ((_cls148D) (obj)).pF.pQ = ((Bitmap) (obj2));
        obj = ((_cls148D) (obj)).pH;
        if (obj1 == null)
        {
            throw new NullPointerException("Transformation must not be null");
        } else
        {
            obj.pX = ((_cls14D7) (obj)).pX._mth02CA(new FF43[] {
                obj1
            });
            return _pcls05d4;
        }
    }
}
