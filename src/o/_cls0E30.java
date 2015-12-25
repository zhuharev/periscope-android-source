// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.drawable.Drawable;

// Referenced classes of package o:
//            _cls05D4, _cls0EB2

public abstract class _cls0E30
    implements _cls05D4
{

    public final Drawable pz;

    public _cls0E30(_cls0EB2 _pcls0eb2)
    {
        if (_pcls0eb2 == null)
        {
            throw new NullPointerException("Drawable must not be null!");
        } else
        {
            pz = _pcls0eb2;
            return;
        }
    }

    public final Object get()
    {
        return pz.getConstantState().newDrawable();
    }
}
