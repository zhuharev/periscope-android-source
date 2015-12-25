// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

// Referenced classes of package o:
//            _cls153E

public class arm extends RecyclerView
{

    private boolean bBJ;

    public arm(Context context)
    {
        super(context);
        bBJ = true;
        setOverScrollMode(2);
    }

    public arm(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        bBJ = true;
        setOverScrollMode(2);
    }

    public arm(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        bBJ = true;
        setOverScrollMode(2);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (!bBJ)
        {
            switch (_cls153E._mth02CA(motionevent))
            {
            case 2: // '\002'
                return true;
            }
        }
        return bBJ && super.onTouchEvent(motionevent);
    }

    public void setAllowScroll(boolean flag)
    {
        bBJ = flag;
    }
}
