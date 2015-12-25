// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

// Referenced classes of package o:
//            _cls1541, _cls05DC, _cls0715, _cls06D5, 
//            _cls2054, _cls1FD1

class _cls03C4
{

    private static final int R[] = {
        0x1010034, 0x101016f, 0x101016d, 0x1010170, 0x101016e
    };
    private static final int au[];
    final TextView av;
    private _cls06D5 aw;
    private _cls06D5 ax;
    private _cls06D5 ay;
    private _cls06D5 az;

    _cls03C4(TextView textview)
    {
        av = textview;
    }

    static _cls03C4 _mth02CA(TextView textview)
    {
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            return new _cls05DC(textview);
        } else
        {
            return new _cls03C4(textview);
        }
    }

    protected static _cls06D5 _mth02CA(Context context, _cls0715 _pcls0715, int i)
    {
        context = _pcls0715._mth1D57(i);
        if (context != null)
        {
            _pcls0715 = new _cls06D5();
            _pcls0715.hH = true;
            _pcls0715._fld027E = context;
        }
        return null;
    }

    void setAllCaps(boolean flag)
    {
        TextView textview = av;
        _cls2054 _lcls2054;
        if (flag)
        {
            _lcls2054 = new _cls2054(av.getContext());
        } else
        {
            _lcls2054 = null;
        }
        textview.setTransformationMethod(_lcls2054);
    }

    final void _mth02CA(Drawable drawable, _cls06D5 _pcls06d5)
    {
        if (drawable != null && _pcls06d5 != null)
        {
            _cls0715._mth02CA(drawable, _pcls06d5, av.getDrawableState());
        }
    }

    void _mth02CA(AttributeSet attributeset, int i)
    {
        Context context = av.getContext();
        _cls0715 _lcls0715 = _cls0715._mth1FBE(context);
        TypedArray typedarray1 = context.obtainStyledAttributes(attributeset, R, i, 0);
        int j = typedarray1.getResourceId(0, -1);
        if (typedarray1.hasValue(1))
        {
            aw = _mth02CA(context, _lcls0715, typedarray1.getResourceId(1, 0));
        }
        if (typedarray1.hasValue(2))
        {
            ax = _mth02CA(context, _lcls0715, typedarray1.getResourceId(2, 0));
        }
        if (typedarray1.hasValue(3))
        {
            ay = _mth02CA(context, _lcls0715, typedarray1.getResourceId(3, 0));
        }
        if (typedarray1.hasValue(4))
        {
            az = _mth02CA(context, _lcls0715, typedarray1.getResourceId(4, 0));
        }
        typedarray1.recycle();
        if (j != -1)
        {
            TypedArray typedarray = context.obtainStyledAttributes(j, _cls1FD1.TextAppearance);
            if (typedarray.hasValue(_cls1FD1.TextAppearance_textAllCaps))
            {
                setAllCaps(typedarray.getBoolean(_cls1FD1.TextAppearance_textAllCaps, false));
            }
            typedarray.recycle();
        }
        attributeset = context.obtainStyledAttributes(attributeset, au, i, 0);
        if (attributeset.getBoolean(0, false))
        {
            setAllCaps(true);
        }
        attributeset.recycle();
    }

    void _mth141D(Context context, int i)
    {
        context = context.obtainStyledAttributes(i, au);
        if (context.hasValue(0))
        {
            setAllCaps(context.getBoolean(0, false));
        }
        context.recycle();
    }

    void _mth156A()
    {
        if (aw != null || ax != null || ay != null || az != null)
        {
            Drawable adrawable[] = av.getCompoundDrawables();
            _mth02CA(adrawable[0], aw);
            _mth02CA(adrawable[1], ax);
            _mth02CA(adrawable[2], ay);
            _mth02CA(adrawable[3], az);
        }
    }

    static 
    {
        au = (new int[] {
            _cls1541.textAllCaps
        });
    }
}
