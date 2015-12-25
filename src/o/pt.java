// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.TypedValue;
import android.view.View;

// Referenced classes of package o:
//            py, pq

final class pt
{
    static final class if extends Enum
    {

        public static final int OE = 1;
        public static final int OF = 2;
        private static int OG = 3;
        private static final int OH[] = {
            1, 2, 3
        };

        public static int[] _mth013D()
        {
            return (int[])OH.clone();
        }

    }

    /* member class not found */
    class _cls02CA {}


    boolean OA;
    float OB;
    float OC;
    boolean OD;
    RectF On;
    Rect Oo;
    Matrix Op;
    RectF Oq;
    final Paint Or;
    final Paint Os;
    final Paint Ot;
    View Ou;
    boolean Ov;
    boolean Ow;
    int Ox;
    int Oy;
    int Oz;
    float outlineWidth;

    public pt(pq pq)
    {
        Or = new Paint();
        Os = new Paint();
        Ot = new Paint();
        Oy = _cls02CA.OI;
        Oz = if.OE;
        Ou = pq;
        pq = pq.getContext();
        TypedValue typedvalue = new TypedValue();
        pq.getTheme().resolveAttribute(android.support.v7.widget.RecyclerView._cls1FBE.eX, typedvalue, true);
        pq = pq.obtainStyledAttributes(typedvalue.resourceId, py.CropImageView);
        Ov = pq.getBoolean(py.CropImageView_showThirds, false);
        Ow = pq.getBoolean(py.CropImageView_showCircle, false);
        Ox = pq.getColor(py.CropImageView_highlightColor, 0xff33b5e5);
        Oz = if._mth013D()[pq.getInt(py.CropImageView_showHandles, 0)];
        pq.recycle();
        return;
        Exception exception;
        exception;
        pq.recycle();
        throw exception;
    }

    Rect _mth0128()
    {
        RectF rectf = new RectF(On.left, On.top, On.right, On.bottom);
        Op.mapRect(rectf);
        return new Rect(Math.round(rectf.left), Math.round(rectf.top), Math.round(rectf.right), Math.round(rectf.bottom));
    }
}
