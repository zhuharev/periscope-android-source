// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

// Referenced classes of package o:
//            np, _cls1E3B, nr, _cls1FD3

public final class nq
{

    private nr LI;
    public TextView LJ;
    private float LK;
    private float LL;
    private np LM;
    private ViewGroup mContainer;
    public final Context mContext;
    private View _fld14D8;

    public nq(Context context)
    {
        LK = 0.5F;
        LL = 1.0F;
        mContext = context;
        LM = new np(mContext.getResources());
        mContainer = (ViewGroup)LayoutInflater.from(mContext).inflate(_cls1E3B.cQ, null);
        LI = (nr)mContainer.getChildAt(0);
        context = (TextView)LI.findViewById(_cls10D0._cls02CA.text);
        LJ = context;
        _fld14D8 = context;
label0:
        do
        {
            switch (1)
            {
            default:
                LM._fld0196 = -1;
                break label0;

            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
            case 6: // '\006'
            case 7: // '\007'
                break;
            }
        } while (true);
        setBackground(LM);
        context = mContext;
        int i;
label1:
        do
        {
            switch (1)
            {
            default:
                i = _cls1FD3.dr;
                break label1;

            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
            case 6: // '\006'
            case 7: // '\007'
                break;
            }
        } while (true);
        if (LJ != null)
        {
            LJ.setTextAppearance(context, i);
        }
    }

    public final void setBackground(Drawable drawable)
    {
        mContainer.setBackgroundDrawable(drawable);
        if (drawable != null)
        {
            Rect rect = new Rect();
            drawable.getPadding(rect);
            mContainer.setPadding(rect.left, rect.top, rect.right, rect.bottom);
            return;
        } else
        {
            mContainer.setPadding(0, 0, 0, 0);
            return;
        }
    }

    public final void setContentView(View view)
    {
        LI.removeAllViews();
        LI.addView(view);
        _fld14D8 = view;
        view = LI.findViewById(_cls10D0._cls02CA.text);
        if (view instanceof TextView)
        {
            view = (TextView)view;
        } else
        {
            view = null;
        }
        LJ = view;
    }

    public final Bitmap _mth1F32()
    {
        int i = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        mContainer.measure(i, i);
        i = mContainer.getMeasuredWidth();
        int j = mContainer.getMeasuredHeight();
        mContainer.layout(0, 0, i, j);
        Bitmap bitmap = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
        bitmap.eraseColor(0);
        Canvas canvas = new Canvas(bitmap);
        mContainer.draw(canvas);
        return bitmap;
    }
}
