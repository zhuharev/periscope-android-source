// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

// Referenced classes of package o:
//            _cls0715

public class _cls09A3
{

    public static final int hV = 0x7f060085;
    public static final int hW = 0x7f060086;
    public _cls0715 E;
    public final TypedArray hU;
    public final Context mContext;

    public _cls09A3()
    {
    }

    public _cls09A3(Context context, TypedArray typedarray)
    {
        mContext = context;
        hU = typedarray;
    }

    public final Drawable getDrawable(int i)
    {
        if (hU.hasValue(i))
        {
            int j = hU.getResourceId(i, 0);
            if (j != 0)
            {
                if (E == null)
                {
                    E = _cls0715._mth1FBE(mContext);
                }
                return E._mth02BD(j, false);
            }
        }
        return hU.getDrawable(i);
    }

    public final Drawable FF9F(int i)
    {
        if (hU.hasValue(i))
        {
            i = hU.getResourceId(i, 0);
            if (i != 0)
            {
                if (E == null)
                {
                    E = _cls0715._mth1FBE(mContext);
                }
                return E._mth02BD(i, true);
            }
        }
        return null;
    }
}
