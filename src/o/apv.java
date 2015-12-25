// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package o:
//            xe

public class apv extends LinearLayout
    implements android.support.v4.view.ViewPager._cls02CF
{

    private int bzn;
    private int bzo;
    private android.support.v4.view.ViewPager._cls02CF bzp;

    public apv(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        bzo = -1;
        _mth02CF(context, attributeset);
    }

    public apv(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        bzo = -1;
        _mth02CF(context, attributeset);
    }

    private void _mth012D(int i)
    {
        if (bzo != i)
        {
            bzo = i;
            int j = getChildCount();
            for (i = 0; i < j; i++)
            {
                ImageView imageview = (ImageView)getChildAt(i);
                if (imageview.getId() == bzo)
                {
                    imageview.setImageResource(0x7f0200b2);
                } else
                {
                    imageview.setImageResource(0x7f0200b3);
                }
            }

        }
    }

    private void _mth02CF(Context context, AttributeSet attributeset)
    {
        attributeset = context.getTheme().obtainStyledAttributes(attributeset, xe.DotsPageIndicator, 0, 0);
        int i;
        int j;
        j = attributeset.getInteger(0, 1);
        i = attributeset.getInteger(1, 0);
        if (i <= j)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        throw new IndexOutOfBoundsException("Selected position is out of bounds!");
        bzn = i;
        context = LayoutInflater.from(context);
        i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        context.inflate(0x7f030047, this);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        attributeset.recycle();
        return;
        context;
        attributeset.recycle();
        throw context;
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        int k = getChildCount();
        ArrayList arraylist = new ArrayList(k);
        for (int i = 0; i < k; i++)
        {
            arraylist.add(Integer.valueOf(i));
        }

        boolean flag;
        if (getContext().getResources().getConfiguration().getLayoutDirection() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            Collections.reverse(arraylist);
        }
        for (int j = 0; j < k; j++)
        {
            getChildAt(j).setId(((Integer)arraylist.get(j)).intValue());
        }

        _mth012D(Math.max(bzn, 0));
    }

    public void setOnPageChangeListener(android.support.v4.view.ViewPager._cls02CF _pcls02cf)
    {
        bzp = _pcls02cf;
    }

    public final void _mth02CA(int i, float f, int j)
    {
        if (bzp != null)
        {
            bzp._mth02CA(i, f, j);
        }
    }

    public final void _mth0640(int i)
    {
        _mth012D(i);
        if (bzp != null)
        {
            bzp._mth0640(i);
        }
    }

    public final void _mth1427(int i)
    {
        if (bzp != null)
        {
            bzp._mth1427(i);
        }
    }
}
