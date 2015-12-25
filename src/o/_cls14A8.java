// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

// Referenced classes of package o:
//            _cls1FD1

public final class _cls14A8 extends View
{
    /* member class not found */
    class if {}


    private int iZ;
    private int ja;
    private WeakReference jb;
    private if jc;
    private LayoutInflater _fld04AE;

    public _cls14A8(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public _cls14A8(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        iZ = 0;
        context = context.obtainStyledAttributes(attributeset, _cls1FD1.ViewStubCompat, i, 0);
        ja = context.getResourceId(_cls1FD1.ViewStubCompat_android_inflatedId, -1);
        iZ = context.getResourceId(_cls1FD1.ViewStubCompat_android_layout, 0);
        setId(context.getResourceId(_cls1FD1.ViewStubCompat_android_id, -1));
        context.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    protected final void dispatchDraw(Canvas canvas)
    {
    }

    public final void draw(Canvas canvas)
    {
    }

    public final View inflate()
    {
        Object obj = getParent();
        if (obj != null && (obj instanceof ViewGroup))
        {
            if (iZ != 0)
            {
                ViewGroup viewgroup = (ViewGroup)obj;
                if (_fld04AE != null)
                {
                    obj = _fld04AE;
                } else
                {
                    obj = LayoutInflater.from(getContext());
                }
                obj = ((LayoutInflater) (obj)).inflate(iZ, viewgroup, false);
                if (ja != -1)
                {
                    ((View) (obj)).setId(ja);
                }
                int i = viewgroup.indexOfChild(this);
                viewgroup.removeViewInLayout(this);
                android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
                if (layoutparams != null)
                {
                    viewgroup.addView(((View) (obj)), i, layoutparams);
                } else
                {
                    viewgroup.addView(((View) (obj)), i);
                }
                jb = new WeakReference(obj);
                if (jc != null)
                {
                    jc._mth02CA(this, ((View) (obj)));
                }
                return ((View) (obj));
            } else
            {
                throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
            }
        } else
        {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        }
    }

    protected final void onMeasure(int i, int j)
    {
        setMeasuredDimension(0, 0);
    }

    public final void setInflatedId(int i)
    {
        ja = i;
    }

    public final void setLayoutInflater(LayoutInflater layoutinflater)
    {
        _fld04AE = layoutinflater;
    }

    public final void setLayoutResource(int i)
    {
        iZ = i;
    }

    public final void setOnInflateListener(if if1)
    {
        jc = if1;
    }

    public final void setVisibility(int i)
    {
        if (jb != null)
        {
            View view = (View)jb.get();
            if (view != null)
            {
                view.setVisibility(i);
                return;
            } else
            {
                throw new IllegalStateException("setVisibility called on un-referenced view");
            }
        }
        super.setVisibility(i);
        if (i == 0 || i == 4)
        {
            inflate();
        }
    }
}
