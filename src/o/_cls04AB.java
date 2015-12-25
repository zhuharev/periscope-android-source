// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.util.List;

// Referenced classes of package o:
//            _cls044C, _cls0437, FF90, FF8B

public abstract class _cls04AB extends _cls044C
{
    /* member class not found */
    class if {}

    /* member class not found */
    class if.if {}


    private static Integer rV = null;
    private final if rW;
    protected final View view;

    public _cls04AB(ImageView imageview)
    {
        if (imageview == null)
        {
            throw new NullPointerException("View must not be null!");
        } else
        {
            view = imageview;
            rW = new if(imageview);
            return;
        }
    }

    public final View getView()
    {
        return view;
    }

    public String toString()
    {
        return (new StringBuilder("Target for: ")).append(view).toString();
    }

    public final void _mth02CA(FF8B ff8b)
    {
        if if1 = rW;
        int i = if1._mth0458();
        int j = if1._mth0445();
        boolean flag;
        if (i > 0 || i == -2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            boolean flag1;
            if (j > 0 || j == -2)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                ff8b._mth02C7(i, j);
                return;
            }
        }
        if (!if1.mQ.contains(ff8b))
        {
            if1.mQ.add(ff8b);
        }
        if (if1.rX == null)
        {
            ff8b = if1.view.getViewTreeObserver();
            if1.rX = new if.if(if1);
            ff8b.addOnPreDrawListener(if1.rX);
        }
    }

    public final void _mth02CF(FF90 ff90)
    {
        view.setTag(ff90);
    }

    public final FF90 _mth0442()
    {
        Object obj = view.getTag();
        if (obj != null)
        {
            if (obj instanceof FF90)
            {
                return (FF90)obj;
            } else
            {
                throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
            }
        } else
        {
            return null;
        }
    }

}
