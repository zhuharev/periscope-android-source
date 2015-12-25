// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

// Referenced classes of package o:
//            _cls03C4, _cls0715, _cls06D5

class _cls05DC extends _cls03C4
{

    private static final int aA[] = {
        0x1010392, 0x1010393
    };
    private _cls06D5 aB;
    private _cls06D5 aC;

    _cls05DC(TextView textview)
    {
        super(textview);
    }

    void _mth02CA(AttributeSet attributeset, int i)
    {
        super._mth02CA(attributeset, i);
        Context context = av.getContext();
        _cls0715 _lcls0715 = _cls0715._mth1FBE(context);
        attributeset = context.obtainStyledAttributes(attributeset, aA, i, 0);
        if (attributeset.hasValue(0))
        {
            aB = _mth02CA(context, _lcls0715, attributeset.getResourceId(0, 0));
        }
        if (attributeset.hasValue(1))
        {
            aC = _mth02CA(context, _lcls0715, attributeset.getResourceId(1, 0));
        }
        attributeset.recycle();
    }

    void _mth156A()
    {
        super._mth156A();
        if (aB != null || aC != null)
        {
            android.graphics.drawable.Drawable adrawable[] = av.getCompoundDrawablesRelative();
            _mth02CA(adrawable[0], aB);
            _mth02CA(adrawable[2], aC);
        }
    }

}
