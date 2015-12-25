// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.View;
import java.util.ArrayList;

// Referenced classes of package o:
//            ph, pt, pz, pq

final class <init>
{

    final ph NX;

    static void _mth02CA( )
    {
        if (ph._mth02CF(.NX) != null)
        {
            pt pt1 = new pt(ph._mth02CB(.NX));
            Object obj = ph._mth02CF(.NX);
            int i;
            if (((pz) (obj)).oW == null)
            {
                i = 0;
            } else
            {
                if ((((pz) (obj)).rotation / 90) % 2 != 0)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                if (i != 0)
                {
                    i = ((pz) (obj)).oW.getHeight();
                } else
                {
                    i = ((pz) (obj)).oW.getWidth();
                }
            }
            obj = ph._mth02CF(.NX);
            int j;
            if (((pz) (obj)).oW == null)
            {
                j = 0;
            } else
            {
                if ((((pz) (obj)).rotation / 90) % 2 != 0)
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
                if (j != 0)
                {
                    j = ((pz) (obj)).oW.getWidth();
                } else
                {
                    j = ((pz) (obj)).oW.getHeight();
                }
            }
            obj = new Rect(0, 0, i, j);
            int i1 = (Math.min(i, j) << 2) / 5;
            int j1 = i1;
            int k = j1;
            int l = i1;
            if (ph._mth141D(.NX) != 0)
            {
                k = j1;
                l = i1;
                if (ph._mth02BB(.NX) != 0)
                {
                    if (ph._mth141D(.NX) > ph._mth02BB(.NX))
                    {
                        l = (ph._mth02BB(.NX) * j1) / ph._mth141D(.NX);
                        k = j1;
                    } else
                    {
                        k = (ph._mth141D(.NX) * j1) / ph._mth02BB(.NX);
                        l = i1;
                    }
                }
            }
            i = (i - k) / 2;
            j = (j - l) / 2;
            RectF rectf = new RectF(i, j, i + k, j + l);
            Matrix matrix = ph._mth02CB(.NX).FF7F();
            boolean flag;
            if (ph._mth141D(.NX) != 0 && ph._mth02BB(.NX) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            pt1.Op = new Matrix(matrix);
            pt1.On = rectf;
            pt1.Oq = new RectF(((Rect) (obj)));
            pt1.OA = flag;
            pt1.OB = pt1.On.width() / pt1.On.height();
            pt1.Oo = pt1._mth0128();
            pt1.Or.setARGB(125, 50, 50, 50);
            pt1.Os.setStyle(android.graphics.Style.STROKE);
            pt1.Os.setAntiAlias(true);
            pt1.outlineWidth = pt1.Ou.getResources().getDisplayMetrics().density * 2.0F;
            pt1.Ot.setColor(pt1.Ox);
            pt1.Ot.setStyle(android.graphics.Style.FILL);
            pt1.Ot.setAntiAlias(true);
            pt1.OC = pt1.Ou.getResources().getDisplayMetrics().density * 12F;
            pt1.Oy = A.OI;
             = ph._mth02CB(.NX);
            ((pq) ()).Oc.add(pt1);
            .invalidate();
        }
    }

    private ist(ph ph1)
    {
        NX = ph1;
        super();
    }

    (ph ph1, byte byte0)
    {
        this(ph1);
    }
}
