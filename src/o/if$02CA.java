// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import java.util.List;
import java.util.Map;

// Referenced classes of package o:
//            if, _cls1508

static class _cls02CE extends _cls02CE
{

    private _cls1508 _fld02CE;

    public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectf)
    {
        _cls1508 _lcls1508 = _fld02CE;
        if (view instanceof ImageView)
        {
            ImageView imageview = (ImageView)view;
            Object obj = imageview.getDrawable();
            android.graphics.drawable.Drawable drawable = imageview.getBackground();
            if (obj != null && drawable == null)
            {
                obj = _cls1508._mth02CA(((android.graphics.drawable.Drawable) (obj)));
                if (obj != null)
                {
                    view = new Bundle();
                    view.putParcelable("sharedElement:snapshot:bitmap", ((Parcelable) (obj)));
                    view.putString("sharedElement:snapshot:imageScaleType", imageview.getScaleType().toString());
                    if (imageview.getScaleType() == android.widget.w.ScaleType.MATRIX)
                    {
                        matrix = imageview.getImageMatrix();
                        rectf = new float[9];
                        matrix.getValues(rectf);
                        view.putFloatArray("sharedElement:snapshot:imageMatrix", rectf);
                    }
                    return view;
                }
            }
        }
        int j = Math.round(rectf.width());
        int i = Math.round(rectf.height());
        Object obj1 = null;
        Bitmap bitmap = obj1;
        if (j > 0)
        {
            bitmap = obj1;
            if (i > 0)
            {
                float f = Math.min(1.0F, (float)_cls1508._fld1D4F / (float)(j * i));
                j = (int)((float)j * f);
                i = (int)((float)i * f);
                if (_lcls1508._fld1D37 == null)
                {
                    _lcls1508._fld1D37 = new Matrix();
                }
                _lcls1508._fld1D37.set(matrix);
                _lcls1508._fld1D37.postTranslate(-rectf.left, -rectf.top);
                _lcls1508._fld1D37.postScale(f, f);
                bitmap = Bitmap.createBitmap(j, i, android.graphics.onfig.ARGB_8888);
                matrix = new Canvas(bitmap);
                matrix.concat(_lcls1508._fld1D37);
                view.draw(matrix);
            }
        }
        return bitmap;
    }

    public View onCreateSnapshotView(Context context, Parcelable parcelable)
    {
        return _cls1508._mth02CA(context, parcelable);
    }

    public void onMapSharedElements(List list, Map map)
    {
    }

    public void onRejectSharedElements(List list)
    {
    }

    public void onSharedElementEnd(List list, List list1, List list2)
    {
    }

    public void onSharedElementStart(List list, List list1, List list2)
    {
    }

    public List(_cls1508 _pcls1508)
    {
        _fld02CE = _pcls1508;
    }
}
