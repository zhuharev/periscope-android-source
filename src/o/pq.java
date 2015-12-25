// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package o:
//            pu, pt, pz, ph

public class pq extends pu
{

    ArrayList Oc;
    private pt Od;
    ph Oe;
    private float Of;
    private float Og;
    private int Oh;

    public pq(Context context)
    {
        super(context);
        Oc = new ArrayList();
    }

    public pq(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        Oc = new ArrayList();
    }

    public pq(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        Oc = new ArrayList();
    }

    private void _mth02CA(pt pt1)
    {
        pt1 = pt1.Oo;
        int i = Math.max(0, getLeft() - ((Rect) (pt1)).left);
        int l = Math.min(0, getRight() - ((Rect) (pt1)).right);
        int j = Math.max(0, getTop() - ((Rect) (pt1)).top);
        int k = Math.min(0, getBottom() - ((Rect) (pt1)).bottom);
        if (i == 0)
        {
            i = l;
        }
        if (j == 0)
        {
            j = k;
        }
        if (i != 0 || j != 0)
        {
            _mth1FBE(i, j);
        }
    }

    private void _mth02CB(pt pt1)
    {
        Rect rect = pt1.Oo;
        float f = rect.width();
        float f1 = rect.height();
        float f2 = getWidth();
        float f3 = getHeight();
        f = Math.max(1.0F, Math.min((f2 / f) * 0.6F, (f3 / f1) * 0.6F) * getScale());
        if ((double)(Math.abs(f - getScale()) / f) > 0.10000000000000001D)
        {
            float af[] = new float[2];
            af[0] = pt1.On.centerX();
            af[1] = pt1.On.centerY();
            super.FF7F().mapPoints(af);
            _mth02CF(f, af[0], af[1], 300F);
        }
        _mth02CA(pt1);
    }

    public final volatile void clear()
    {
        super.clear();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        Iterator iterator = Oc.iterator();
label0:
        do
        {
            pt pt1;
            Path path;
            Rect rect;
            boolean flag;
label1:
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                pt1 = (pt)iterator.next();
                canvas.save();
                path = new Path();
                pt1.Os.setStrokeWidth(pt1.outlineWidth);
                if (!pt1.OD)
                {
                    pt1.Os.setColor(0xff000000);
                    canvas.drawRect(pt1.Oo, pt1.Os);
                    continue;
                }
                rect = new Rect();
                pt1.Ou.getDrawingRect(rect);
                path.addRect(new RectF(pt1.Oo), android.graphics.Path.Direction.CW);
                pt1.Os.setColor(pt1.Ox);
                if (android.os.Build.VERSION.SDK_INT != 17)
                {
                    if (android.os.Build.VERSION.SDK_INT < 14 || android.os.Build.VERSION.SDK_INT > 15)
                    {
                        flag = true;
                        break label1;
                    }
                    if (!canvas.isHardwareAccelerated())
                    {
                        flag = true;
                        break label1;
                    }
                }
                flag = false;
            }
            if (flag)
            {
                canvas.clipPath(path, android.graphics.Region.Op.DIFFERENCE);
                canvas.drawRect(rect, pt1.Or);
            } else
            {
                canvas.drawRect(0.0F, 0.0F, canvas.getWidth(), pt1.Oo.top, pt1.Or);
                canvas.drawRect(0.0F, pt1.Oo.bottom, canvas.getWidth(), canvas.getHeight(), pt1.Or);
                canvas.drawRect(0.0F, pt1.Oo.top, pt1.Oo.left, pt1.Oo.bottom, pt1.Or);
                canvas.drawRect(pt1.Oo.right, pt1.Oo.top, canvas.getWidth(), pt1.Oo.bottom, pt1.Or);
            }
            canvas.restore();
            canvas.drawPath(path, pt1.Os);
            if (pt1.Ov)
            {
                pt1.Os.setStrokeWidth(1.0F);
                float f = (pt1.Oo.right - pt1.Oo.left) / 3;
                float f1 = (pt1.Oo.bottom - pt1.Oo.top) / 3;
                canvas.drawLine((float)pt1.Oo.left + f, pt1.Oo.top, (float)pt1.Oo.left + f, pt1.Oo.bottom, pt1.Os);
                canvas.drawLine((float)pt1.Oo.left + 2.0F * f, pt1.Oo.top, (float)pt1.Oo.left + 2.0F * f, pt1.Oo.bottom, pt1.Os);
                canvas.drawLine(pt1.Oo.left, (float)pt1.Oo.top + f1, pt1.Oo.right, (float)pt1.Oo.top + f1, pt1.Os);
                canvas.drawLine(pt1.Oo.left, (float)pt1.Oo.top + 2.0F * f1, pt1.Oo.right, (float)pt1.Oo.top + 2.0F * f1, pt1.Os);
            }
            if (pt1.Ow)
            {
                pt1.Os.setStrokeWidth(1.0F);
                canvas.drawOval(new RectF(pt1.Oo), pt1.Os);
            }
            if (pt1.Oz == pt.if.OF || pt1.Oz == pt.if.OE && pt1.Oy == pt._cls02CA.OK)
            {
                int i = pt1.Oo.left + (pt1.Oo.right - pt1.Oo.left) / 2;
                int j = pt1.Oo.top + (pt1.Oo.bottom - pt1.Oo.top) / 2;
                canvas.drawCircle(pt1.Oo.left, j, pt1.OC, pt1.Ot);
                canvas.drawCircle(i, pt1.Oo.top, pt1.OC, pt1.Ot);
                canvas.drawCircle(pt1.Oo.right, j, pt1.OC, pt1.Ot);
                canvas.drawCircle(i, pt1.Oo.bottom, pt1.OC, pt1.Ot);
            }
        } while (true);
    }

    public volatile boolean onKeyDown(int i, KeyEvent keyevent)
    {
        return super.onKeyDown(i, keyevent);
    }

    public volatile boolean onKeyUp(int i, KeyEvent keyevent)
    {
        return super.onKeyUp(i, keyevent);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        if (OR.oW != null)
        {
            Iterator iterator = Oc.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                pt pt1 = (pt)iterator.next();
                pt1.Op.set(super.FF7F());
                pt1.Oo = pt1._mth0128();
                if (pt1.OD)
                {
                    _mth02CB(pt1);
                }
            } while (true);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (((ph)Oe).NT)
        {
            return false;
        }
label0:
        switch (motionevent.getAction())
        {
        default:
            break;

        case 0: // '\0'
            Object obj = Oc.iterator();
            pt pt3;
            int i;
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
                pt3 = (pt)((Iterator) (obj)).next();
                float f = motionevent.getX();
                float f2 = motionevent.getY();
                Rect rect = pt3._mth0128();
                int l = 1;
                boolean flag1;
                if (f2 >= (float)rect.top - 20F && f2 < (float)rect.bottom + 20F)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                boolean flag;
                if (f >= (float)rect.left - 20F && f < (float)rect.right + 20F)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                i = l;
                if (Math.abs((float)rect.left - f) < 20F)
                {
                    i = l;
                    if (flag1)
                    {
                        i = 3;
                    }
                }
                l = i;
                if (Math.abs((float)rect.right - f) < 20F)
                {
                    l = i;
                    if (flag1)
                    {
                        l = i | 4;
                    }
                }
                i = l;
                if (Math.abs((float)rect.top - f2) < 20F)
                {
                    i = l;
                    if (flag)
                    {
                        i = l | 8;
                    }
                }
                l = i;
                if (Math.abs((float)rect.bottom - f2) < 20F)
                {
                    l = i;
                    if (flag)
                    {
                        l = i | 0x10;
                    }
                }
                i = l;
                if (l == 1)
                {
                    i = l;
                    if (rect.contains((int)f, (int)f2))
                    {
                        i = 32;
                    }
                }
            } while (i == 1);
            Oh = i;
            Od = pt3;
            Of = motionevent.getX();
            Og = motionevent.getY();
            obj = Od;
            if (i == 32)
            {
                i = pt._cls02CA.OJ;
            } else
            {
                i = pt._cls02CA.OK;
            }
            if (i != ((pt) (obj)).Oy)
            {
                obj.Oy = i;
                ((pt) (obj)).Ou.invalidate();
            }
            break;

        case 1: // '\001'
            if (Od != null)
            {
                _mth02CB(Od);
                pt pt1 = Od;
                int j = pt._cls02CA.OI;
                if (j != pt1.Oy)
                {
                    pt1.Oy = j;
                    pt1.Ou.invalidate();
                }
            }
            Od = null;
            break;

        case 2: // '\002'
            if (Od != null)
            {
                pt pt2 = Od;
                int i1 = Oh;
                float f1 = motionevent.getX() - Of;
                float f3 = motionevent.getY() - Og;
                Object obj1 = pt2._mth0128();
                if (i1 == 32)
                {
                    float f4 = pt2.On.width() / (float)((Rect) (obj1)).width();
                    float f6 = pt2.On.height() / (float)((Rect) (obj1)).height();
                    obj1 = new Rect(pt2.Oo);
                    pt2.On.offset(f4 * f1, f3 * f6);
                    pt2.On.offset(Math.max(0.0F, pt2.Oq.left - pt2.On.left), Math.max(0.0F, pt2.Oq.top - pt2.On.top));
                    pt2.On.offset(Math.min(0.0F, pt2.Oq.right - pt2.On.right), Math.min(0.0F, pt2.Oq.bottom - pt2.On.bottom));
                    pt2.Oo = pt2._mth0128();
                    ((Rect) (obj1)).union(pt2.Oo);
                    ((Rect) (obj1)).inset(-(int)pt2.OC, -(int)pt2.OC);
                    pt2.Ou.invalidate(((Rect) (obj1)));
                } else
                {
                    if ((i1 & 6) == 0)
                    {
                        f1 = 0.0F;
                    }
                    if ((i1 & 0x18) == 0)
                    {
                        f3 = 0.0F;
                    }
                    float f7 = pt2.On.width() / (float)((Rect) (obj1)).width();
                    float f5 = pt2.On.height() / (float)((Rect) (obj1)).height();
                    int k;
                    if ((i1 & 2) != 0)
                    {
                        k = -1;
                    } else
                    {
                        k = 1;
                    }
                    f7 = (float)k * (f1 * f7);
                    if ((i1 & 8) != 0)
                    {
                        k = -1;
                    } else
                    {
                        k = 1;
                    }
                    f3 = (float)k * (f3 * f5);
                    f5 = f7;
                    f1 = f3;
                    if (pt2.OA)
                    {
                        if (f7 != 0.0F)
                        {
                            f1 = f7 / pt2.OB;
                            f5 = f7;
                        } else
                        {
                            f5 = f7;
                            f1 = f3;
                            if (f3 != 0.0F)
                            {
                                f5 = f3 * pt2.OB;
                                f1 = f3;
                            }
                        }
                    }
                    obj1 = new RectF(pt2.On);
                    f3 = f5;
                    f7 = f1;
                    if (f5 > 0.0F)
                    {
                        f3 = f5;
                        f7 = f1;
                        if (((RectF) (obj1)).width() + 2.0F * f5 > pt2.Oq.width())
                        {
                            f5 = (pt2.Oq.width() - ((RectF) (obj1)).width()) / 2.0F;
                            f3 = f5;
                            f7 = f1;
                            if (pt2.OA)
                            {
                                f7 = f5 / pt2.OB;
                                f3 = f5;
                            }
                        }
                    }
                    f5 = f3;
                    f1 = f7;
                    if (f7 > 0.0F)
                    {
                        f5 = f3;
                        f1 = f7;
                        if (((RectF) (obj1)).height() + 2.0F * f7 > pt2.Oq.height())
                        {
                            float f8 = (pt2.Oq.height() - ((RectF) (obj1)).height()) / 2.0F;
                            f5 = f3;
                            f1 = f8;
                            if (pt2.OA)
                            {
                                f5 = f8 * pt2.OB;
                                f1 = f8;
                            }
                        }
                    }
                    ((RectF) (obj1)).inset(-f5, -f1);
                    if (((RectF) (obj1)).width() < 25F)
                    {
                        ((RectF) (obj1)).inset(-(25F - ((RectF) (obj1)).width()) / 2.0F, 0.0F);
                    }
                    if (pt2.OA)
                    {
                        f1 = 25F / pt2.OB;
                    } else
                    {
                        f1 = 25F;
                    }
                    if (((RectF) (obj1)).height() < f1)
                    {
                        ((RectF) (obj1)).inset(0.0F, -(f1 - ((RectF) (obj1)).height()) / 2.0F);
                    }
                    if (((RectF) (obj1)).left < pt2.Oq.left)
                    {
                        ((RectF) (obj1)).offset(pt2.Oq.left - ((RectF) (obj1)).left, 0.0F);
                    } else
                    if (((RectF) (obj1)).right > pt2.Oq.right)
                    {
                        ((RectF) (obj1)).offset(-(((RectF) (obj1)).right - pt2.Oq.right), 0.0F);
                    }
                    if (((RectF) (obj1)).top < pt2.Oq.top)
                    {
                        ((RectF) (obj1)).offset(0.0F, pt2.Oq.top - ((RectF) (obj1)).top);
                    } else
                    if (((RectF) (obj1)).bottom > pt2.Oq.bottom)
                    {
                        ((RectF) (obj1)).offset(0.0F, -(((RectF) (obj1)).bottom - pt2.Oq.bottom));
                    }
                    pt2.On.set(((RectF) (obj1)));
                    pt2.Oo = pt2._mth0128();
                    pt2.Ou.invalidate();
                }
                Of = motionevent.getX();
                Og = motionevent.getY();
                _mth02CA(Od);
            }
            break;
        }
        switch (motionevent.getAction())
        {
        default:
            break;

        case 1: // '\001'
            _mth02BB(true, true);
            break;

        case 2: // '\002'
            if (getScale() == 1.0F)
            {
                _mth02BB(true, true);
            }
            break;
        }
        return true;
    }

    public volatile void setImageBitmap(Bitmap bitmap)
    {
        super.setImageBitmap(bitmap);
    }

    public volatile void setImageBitmapResetBase(Bitmap bitmap, boolean flag)
    {
        super.setImageBitmapResetBase(bitmap, flag);
    }

    public volatile void setImageRotateBitmapResetBase(pz pz1, boolean flag)
    {
        super.setImageRotateBitmapResetBase(pz1, flag);
    }

    public volatile void setRecycler(pu.if if1)
    {
        super.setRecycler(if1);
    }

    protected final void _mth02CE(float f, float f1, float f2)
    {
        super._mth02CE(f, f1, f2);
        for (Iterator iterator = Oc.iterator(); iterator.hasNext();)
        {
            pt pt1 = (pt)iterator.next();
            pt1.Op.set(super.FF7F());
            pt1.Oo = pt1._mth0128();
        }

    }

    protected final void _mth037A(float f, float f1)
    {
        super._mth037A(f, f1);
        for (Iterator iterator = Oc.iterator(); iterator.hasNext();)
        {
            pt pt1 = (pt)iterator.next();
            pt1.Op.postTranslate(f, f1);
            pt1.Oo = pt1._mth0128();
        }

    }

    public final volatile Matrix FF7F()
    {
        return super.FF7F();
    }
}
