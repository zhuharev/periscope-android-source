// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

// Referenced classes of package o:
//            _cls09A3, _cls1FD1, _cls0155, FB32

public class _cls012E extends PopupWindow
{

    private static final boolean T;
    private boolean U;

    public _cls012E(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        context = new _cls09A3(context, context.obtainStyledAttributes(attributeset, o._cls1FD1.PopupWindow, i, 0));
        i = _cls1FD1.PopupWindow_overlapAnchor;
        if (((_cls09A3) (context)).hU.hasValue(i))
        {
            i = _cls1FD1.PopupWindow_overlapAnchor;
            _mth0674(((_cls09A3) (context)).hU.getBoolean(i, false));
        }
        setBackgroundDrawable(context.getDrawable(_cls1FD1.PopupWindow_android_popupBackground));
        ((_cls09A3) (context)).hU.recycle();
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            _mth02CA(this);
        }
    }

    private static void _mth02CA(PopupWindow popupwindow)
    {
        try
        {
            Field field = android/widget/PopupWindow.getDeclaredField("mAnchor");
            field.setAccessible(true);
            Field field1 = android/widget/PopupWindow.getDeclaredField("mOnScrollChangedListener");
            field1.setAccessible(true);
            field1.set(popupwindow, new _cls0155(field, popupwindow, (android.view.ViewTreeObserver.OnScrollChangedListener)field1.get(popupwindow)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (PopupWindow popupwindow)
        {
            Log.d("AppCompatPopupWindow", "Exception while installing workaround OnScrollChangedListener", popupwindow);
        }
    }

    public void showAsDropDown(View view, int i, int j)
    {
        int k = j;
        if (T)
        {
            k = j;
            if (U)
            {
                k = j - view.getHeight();
            }
        }
        super.showAsDropDown(view, i, k);
    }

    public void showAsDropDown(View view, int i, int j, int k)
    {
        int l = j;
        if (T)
        {
            l = j;
            if (U)
            {
                l = j - view.getHeight();
            }
        }
        super.showAsDropDown(view, i, l, k);
    }

    public void update(View view, int i, int j, int k, int l)
    {
        int i1 = j;
        if (T)
        {
            i1 = j;
            if (U)
            {
                i1 = j - view.getHeight();
            }
        }
        super.update(view, i, i1, k, l);
    }

    public void _mth0674(boolean flag)
    {
        if (T)
        {
            U = flag;
            return;
        } else
        {
            FB32._mth02CA(this, flag);
            return;
        }
    }

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT < 21)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        T = flag;
    }
}
