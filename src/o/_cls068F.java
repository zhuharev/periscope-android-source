// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

// Referenced classes of package o:
//            _cls0EC0

class _cls068F extends Drawable
{

    final _cls0EC0 _fld043D;

    public _cls068F(_cls0EC0 _pcls0ec0)
    {
        _fld043D = _pcls0ec0;
    }

    public void draw(Canvas canvas)
    {
        if (_fld043D._fld0506)
        {
            if (_fld043D._fld04F4 != null)
            {
                _fld043D._fld04F4.draw(canvas);
                return;
            }
        } else
        {
            if (_fld043D._fld15BF != null)
            {
                _fld043D._fld15BF.draw(canvas);
            }
            if (_fld043D._fld04DF != null && _fld043D._fld0546)
            {
                _fld043D._fld04DF.draw(canvas);
            }
        }
    }

    public int getOpacity()
    {
        return 0;
    }

    public void setAlpha(int i)
    {
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
    }
}
