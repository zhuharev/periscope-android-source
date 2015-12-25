// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

// Referenced classes of package o:
//            _cls02D0

public class _cls1FD2 extends ListView
{
    /* member class not found */
    class if {}


    private static final int dg[] = {
        0
    };
    final Rect dh;
    int di;
    int dj;
    int dk;
    int dl;
    protected int dm;
    private Field _flddo;
    private if dp;

    public _cls1FD2(Context context)
    {
        this(context, null);
    }

    public _cls1FD2(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public _cls1FD2(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        dh = new Rect();
        di = 0;
        dj = 0;
        dk = 0;
        dl = 0;
        try
        {
            _flddo = android/widget/AbsListView.getDeclaredField("mIsChildViewEnabled");
            _flddo.setAccessible(true);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }

    protected void dispatchDraw(Canvas canvas)
    {
        _mth02CE(canvas);
        super.dispatchDraw(canvas);
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        _mth1D62(true);
        _mth1484();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        switch (motionevent.getAction())
        {
        case 0: // '\0'
            dm = pointToPosition((int)motionevent.getX(), (int)motionevent.getY());
            break;
        }
        return super.onTouchEvent(motionevent);
    }

    public void setSelector(Drawable drawable)
    {
        Object obj;
        if (drawable != null)
        {
            obj = new if(drawable);
        } else
        {
            obj = null;
        }
        dp = ((if) (obj));
        super.setSelector(dp);
        obj = new Rect();
        if (drawable != null)
        {
            drawable.getPadding(((Rect) (obj)));
        }
        di = ((Rect) (obj)).left;
        dj = ((Rect) (obj)).top;
        dk = ((Rect) (obj)).right;
        dl = ((Rect) (obj)).bottom;
    }

    protected void _mth02CA(int i, View view)
    {
        Drawable drawable = getSelector();
        boolean flag;
        if (drawable != null && i != -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            drawable.setVisible(false, false);
        }
        _mth02CB(i, view);
        if (flag)
        {
            view = dh;
            float f = view.exactCenterX();
            float f1 = view.exactCenterY();
            boolean flag1;
            if (getVisibility() == 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            drawable.setVisible(flag1, false);
            _cls02D0._mth02CA(drawable, f, f1);
        }
    }

    protected void _mth02CA(int i, View view, float f, float f1)
    {
        _mth02CA(i, view);
        view = getSelector();
        if (view != null && i != -1)
        {
            _cls02D0._mth02CA(view, f, f1);
        }
    }

    public int _mth02CB(int i, int j, int k, int l, int i1)
    {
        j = getListPaddingTop();
        int j1 = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        k = getDividerHeight();
        Object obj = getDivider();
        ListAdapter listadapter = getAdapter();
        if (listadapter == null)
        {
            return j + j1;
        }
        j += j1;
        if (k <= 0 || obj == null)
        {
            k = 0;
        }
        int l1 = 0;
        obj = null;
        int j2 = 0;
        int l2 = listadapter.getCount();
        for (int k1 = 0; k1 < l2;)
        {
            int k2 = listadapter.getItemViewType(k1);
            int i2 = j2;
            if (k2 != j2)
            {
                obj = null;
                i2 = k2;
            }
            View view = listadapter.getView(k1, ((View) (obj)), this);
            android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
            obj = layoutparams;
            if (layoutparams == null)
            {
                obj = generateDefaultLayoutParams();
                view.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            }
            if (((android.view.ViewGroup.LayoutParams) (obj)).height > 0)
            {
                j2 = android.view.View.MeasureSpec.makeMeasureSpec(((android.view.ViewGroup.LayoutParams) (obj)).height, 0x40000000);
            } else
            {
                j2 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, j2);
            view.forceLayout();
            j2 = j;
            if (k1 > 0)
            {
                j2 = j + k;
            }
            j2 = view.getMeasuredHeight() + j2;
            j = j2;
            if (j2 >= l)
            {
                if (i1 >= 0 && k1 > i1 && l1 > 0 && j != l)
                {
                    return l1;
                } else
                {
                    return l;
                }
            }
            j2 = l1;
            if (i1 >= 0)
            {
                j2 = l1;
                if (k1 >= i1)
                {
                    j2 = j;
                }
            }
            k1++;
            l1 = j2;
            obj = view;
            j2 = i2;
        }

        return j;
    }

    protected void _mth02CB(int i, View view)
    {
        Rect rect = dh;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left = rect.left - di;
        rect.top = rect.top - dj;
        rect.right = rect.right + dk;
        rect.bottom = rect.bottom + dl;
        boolean flag;
        flag = _flddo.getBoolean(this);
        if (view.isEnabled() == flag)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        view = _flddo;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        try
        {
            view.set(this, Boolean.valueOf(flag));
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
            return;
        }
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        refreshDrawableState();
    }

    protected void _mth02CE(Canvas canvas)
    {
        if (!dh.isEmpty())
        {
            Drawable drawable = getSelector();
            if (drawable != null)
            {
                drawable.setBounds(dh);
                drawable.draw(canvas);
            }
        }
    }

    protected boolean _mth0E07()
    {
        return false;
    }

    protected void _mth1484()
    {
        Drawable drawable = getSelector();
        if (drawable != null && _mth14BC())
        {
            drawable.setState(getDrawableState());
        }
    }

    protected boolean _mth14BC()
    {
        return _mth0E07() && isPressed();
    }

    protected void _mth1D62(boolean flag)
    {
        if (dp != null)
        {
            dp.setEnabled(flag);
        }
    }

}
