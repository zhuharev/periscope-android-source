// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.res.Resources;
import android.graphics.drawable.shapes.OvalShape;
import android.widget.ImageView;

// Referenced classes of package o:
//            aui, asg

public final class aok
{

    public static final int bva[] = {
        0x7f0c006b, 0x7f0c0070, 0x7f0c0071, 0x7f0c0072, 0x7f0c0073, 0x7f0c0074, 0x7f0c0075, 0x7f0c0076, 0x7f0c0077, 0x7f0c006c, 
        0x7f0c006d, 0x7f0c006e, 0x7f0c006f
    };
    private static aok bvd;
    private int bvb;
    private int bvc;
    private int _fld1D5D[];

    private aok(Resources resources)
    {
        _fld1D5D = new int[13];
        for (int i = 0; i < 13; i++)
        {
            _fld1D5D[i] = resources.getColor(bva[i]);
        }

        bvb = resources.getColor(0x7f0c0037);
        bvc = resources.getColor(0x7f0c0078);
    }

    public static int _mth02CA(Resources resources, int i)
    {
        if (bvd == null)
        {
            bvd = new aok(resources);
        }
        if (i == -1)
        {
            return bvd.bvc;
        }
        if (i == 0)
        {
            return bvd.bvb;
        } else
        {
            i = Math.max(i - 1, 0);
            return bvd._fld1D5D[i % bvd._fld1D5D.length];
        }
    }

    public static void _mth02CA(ImageView imageview, String s, int i)
    {
        if (i == -1)
        {
            i = 0x7f0c0078;
        } else
        if (i == 0)
        {
            i = 0x7f0c0037;
        } else
        {
            i = Math.max(i - 1, 0);
            i = bva[i % 13];
        }
        Resources resources = imageview.getResources();
        int j = resources.getDimensionPixelSize(0x7f090051);
        if (aui._mth02BF(s))
        {
            s = s.substring(0, 1).toUpperCase();
        } else
        {
            s = "";
        }
        imageview.setImageDrawable(new asg(resources, new OvalShape(), j, j, i, 0x7f0c00a4, s));
    }

    public static int _mth02CB(Resources resources, int i)
    {
        return _mth02CA(resources, i) & 0xa0ffffff;
    }

}
