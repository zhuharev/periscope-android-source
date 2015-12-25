// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Outline;
import android.graphics.drawable.Drawable;

// Referenced classes of package o:
//            _cls068F, _cls0EC0

class _cls0ABD extends _cls068F
{

    public _cls0ABD(_cls0EC0 _pcls0ec0)
    {
        super(_pcls0ec0);
    }

    public void getOutline(Outline outline)
    {
        if (_fld043D._fld0506)
        {
            if (_fld043D._fld04F4 != null)
            {
                _fld043D._fld04F4.getOutline(outline);
                return;
            }
        } else
        if (_fld043D._fld15BF != null)
        {
            _fld043D._fld15BF.getOutline(outline);
        }
    }
}
