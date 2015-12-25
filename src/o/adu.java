// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

// Referenced classes of package o:
//            adv, aui, adj

public class adu extends ViewGroup
{

    ImageView bfw;
    private View bfx;
    private RecyclerView eH;
    private TextView _fld05EA;
    private TextView _fld1438;

    public adu(Context context)
    {
        super(context);
        init(context);
    }

    public adu(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init(context);
    }

    public adu(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init(context);
    }

    private void init(Context context)
    {
        LayoutInflater.from(context).inflate(0x7f030020, this, true);
        bfw = (ImageView)findViewById(0x7f0d006c);
        bfx = findViewById(0x7f0d006b);
        _fld1438 = (TextView)findViewById(0x7f0d008f);
        _fld05EA = (TextView)findViewById(0x7f0d0090);
        eH = (RecyclerView)findViewById(0x7f0d0067);
        context = new LinearLayoutManager(context);
        eH.setLayoutManager(context);
        eH.setItemAnimator(null);
        context = eH;
        adv adv1 = new adv(this);
        ((RecyclerView) (context)).dJ.add(adv1);
    }

    public boolean canScrollVertically(int i)
    {
        return eH.canScrollVertically(i);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        k -= i;
        i = eH.getMeasuredHeight();
        j = l - j - i;
        eH.layout(0, j, k, j + i);
        bfx.layout(0, j - bfx.getMeasuredHeight(), k, j);
        j = getResources().getDimensionPixelSize(0x7f09001c);
        l = bfw.getMeasuredWidth();
        int i1 = bfw.getMeasuredHeight();
        int j1 = bfx.getBottom();
        if (getContext().getResources().getConfiguration().getLayoutDirection() == 1)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            i = j;
        } else
        {
            i = k - j - l;
        }
        j = j1 - i1 / 2;
        bfw.layout(i, j, i + l, j + i1);
    }

    protected void onMeasure(int i, int j)
    {
        measureChild(bfw, i, j);
        measureChild(bfx, i, j);
        j = android.view.View.MeasureSpec.makeMeasureSpec((int)((float)android.view.View.MeasureSpec.getSize(j) / 2.0F + 0.5F), 0x80000000);
        measureChild(eH, i, j);
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), i), bfx.getMeasuredHeight() + eH.getMeasuredHeight());
    }

    public void setActionButtonVisibility(boolean flag)
    {
        if (flag)
        {
            bfw.setVisibility(0);
            return;
        } else
        {
            bfw.setVisibility(8);
            return;
        }
    }

    public void setAdapter(adj adj)
    {
        eH.setAdapter(adj);
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        bfw.setOnClickListener(onclicklistener);
    }

    public void setTitle(CharSequence charsequence, CharSequence charsequence1)
    {
        if (aui._mth02BF(charsequence))
        {
            _fld1438.setText(charsequence);
        } else
        {
            _fld1438.setText(0x7f06016f);
        }
        if (aui._mth02BF(charsequence1))
        {
            _fld05EA.setText(charsequence1);
            _fld05EA.setVisibility(0);
            return;
        } else
        {
            _fld05EA.setVisibility(8);
            return;
        }
    }

    public void setTitleAlpha(float f)
    {
        bfx.setAlpha(f);
        bfw.setScaleX(f);
        bfw.setScaleY(f);
    }
}
