// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.SeekBar;

// Referenced classes of package o:
//            _cls0213, _cls09A3, _cls0715

class _cls0294 extends _cls0213
{

    private static final int _fld15AA[] = {
        0x1010142
    };
    private final SeekBar ac;

    _cls0294(SeekBar seekbar, _cls0715 _pcls0715)
    {
        super(seekbar, _pcls0715);
        ac = seekbar;
    }

    void _mth02CA(AttributeSet attributeset, int i)
    {
        super._mth02CA(attributeset, i);
        Object obj = ac.getContext();
        attributeset = new _cls09A3(((Context) (obj)), ((Context) (obj)).obtainStyledAttributes(attributeset, _fld15AA, i, 0));
        obj = attributeset.FF9F(0);
        if (obj != null)
        {
            ac.setThumb(((android.graphics.drawable.Drawable) (obj)));
        }
        ((_cls09A3) (attributeset)).hU.recycle();
    }

}
