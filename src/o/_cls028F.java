// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;

// Referenced classes of package o:
//            _cls1541, _cls0715, _cls0294

public class _cls028F extends SeekBar
{

    private _cls0715 E;
    private _cls0294 ab;

    public _cls028F(Context context)
    {
        this(context, null);
    }

    public _cls028F(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, _cls1541.seekBarStyle);
    }

    public _cls028F(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        E = _cls0715._mth1FBE(context);
        ab = new _cls0294(this, E);
        ab._mth02CA(attributeset, i);
    }
}
