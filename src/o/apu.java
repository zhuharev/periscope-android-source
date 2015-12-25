// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

// Referenced classes of package o:
//            aos

public class apu extends View
{

    private Paint bze;
    private Paint bzf;
    private Paint bzg;
    private RectF bzh;
    private float bzi;
    public float bzj;
    public float bzk;
    public float bzl;
    private float bzm;

    public apu(Context context)
    {
        super(context);
        init();
    }

    public apu(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    public apu(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init();
    }

    private void init()
    {
        Point point = aos._mth02B2(getContext());
        Resources resources = getContext().getResources();
        int i = resources.getColor(0x7f0c0027);
        bzi = point.y;
        bzj = point.x;
        bzk = (float)point.x / 2.0F;
        bze = new Paint();
        bzh = new RectF(0.0F, 0.0F, bzj, bzi);
        bze.setColor(i);
        bze.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_OVER));
        bzf = new Paint();
        bzf.setColor(resources.getColor(0x7f0c009b));
        bzf.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
        bzl = bzi / 2.0F;
        bzg = new Paint();
        bzm = resources.getDimensionPixelOffset(0x7f09005f);
        bzg.setStrokeWidth(bzm);
        bzg.setStyle(android.graphics.Paint.Style.STROKE);
        bzg.setColor(-1);
    }

    protected void onDraw(Canvas canvas)
    {
        canvas.drawRect(bzh, bze);
        canvas.drawCircle(bzj / 2.0F, bzl, bzk - bzm, bzf);
        canvas.drawCircle(bzj / 2.0F, bzl, bzk - bzm, bzg);
    }
}
