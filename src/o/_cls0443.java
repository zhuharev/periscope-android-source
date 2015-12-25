// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.graphics.Bitmap;

// Referenced classes of package o:
//            FF43, _cls1D3C, _cls0645, _cls05D4, 
//            _cls043E, _cls06BA

public abstract class _cls0443
    implements FF43
{

    private _cls06BA je;

    public _cls0443(Context context)
    {
        this(_cls1D3C._mth0640(context).je);
    }

    public _cls0443(_cls06BA _pcls06ba)
    {
        je = _pcls06ba;
    }

    public abstract Bitmap _mth02CA(_cls06BA _pcls06ba, Bitmap bitmap, int i, int j);

    public final _cls05D4 _mth02CA(_cls05D4 _pcls05d4, int i, int j)
    {
        if (!_cls0645._mth02E1(i, j))
        {
            throw new IllegalArgumentException((new StringBuilder("Cannot apply transformation on width: ")).append(i).append(" or height: ").append(j).append(" less than or equal to zero and not Target.SIZE_ORIGINAL").toString());
        }
        Bitmap bitmap1 = (Bitmap)_pcls05d4.get();
        if (i == 0x80000000)
        {
            i = bitmap1.getWidth();
        }
        if (j == 0x80000000)
        {
            j = bitmap1.getHeight();
        }
        Bitmap bitmap = _mth02CA(je, bitmap1, i, j);
        if (!bitmap1.equals(bitmap))
        {
            _pcls05d4 = je;
            if (bitmap == null)
            {
                _pcls05d4 = null;
            } else
            {
                _pcls05d4 = new _cls043E(bitmap, _pcls05d4);
            }
        }
        return _pcls05d4;
    }
}
