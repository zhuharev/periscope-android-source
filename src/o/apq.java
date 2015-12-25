// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import java.util.ArrayList;

// Referenced classes of package o:
//            asb, apr, xe, aos, 
//            apt, aps, FE70

public class apq extends RelativeLayout
    implements asb
{

    private int bng;
    private android.support.v7.widget.RecyclerView.aux bza;
    private aps bzb;
    private int bzc;
    private RecyclerView eH;

    public apq(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        bza = new apr(this);
        _mth02CF(context, attributeset);
    }

    public apq(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        bza = new apr(this);
        _mth02CF(context, attributeset);
    }

    static int _mth02CA(apq apq1)
    {
        return apq1.bng;
    }

    static int _mth02CB(apq apq1)
    {
        return apq1.bzc;
    }

    private void _mth02CF(Context context, AttributeSet attributeset)
    {
        LayoutInflater.from(context).inflate(0x7f03001d, this, true);
        attributeset = context.obtainStyledAttributes(attributeset, xe.BottomSheet);
        if (attributeset.hasValue(0))
        {
            TypedValue typedvalue = new TypedValue();
            attributeset.getValue(0, typedvalue);
            switch (typedvalue.type)
            {
            case 5: // '\005'
                bzc = attributeset.getDimensionPixelSize(0, 0);
                break;

            case 6: // '\006'
                float f = attributeset.getFraction(0, 1, 1, 0.0F);
                bzc = (int)((float)aos._mth02B2(context).y * f);
                break;
            }
        }
        if (attributeset.hasValue(1))
        {
            bng = attributeset.getDimensionPixelSize(1, 0);
        }
        attributeset.recycle();
        eH = (RecyclerView)findViewById(0x7f0d0067);
        if (bng > 0)
        {
            eH._mth02CA(bza);
        }
        context = new apt(this, context);
        eH.setLayoutManager(context);
        bzb = new aps(this);
    }

    public final void hide()
    {
        setVisibility(8);
    }

    public final boolean isShowing()
    {
        return getVisibility() == 0;
    }

    public void setAdapter(android.support.v7.widget.RecyclerView.if if1)
    {
        android.support.v7.widget.RecyclerView.if if2 = eH.dF;
        if (if2 != null)
        {
            aps aps2 = bzb;
            if2.ey.unregisterObserver(aps2);
        }
        eH.setAdapter(if1);
        if (if1 != null)
        {
            aps aps1 = bzb;
            if1.ey.registerObserver(aps1);
        }
    }

    public void setItemDecoration(android.support.v7.widget.RecyclerView.aux aux)
    {
        RecyclerView recyclerview = eH;
        android.support.v7.widget.RecyclerView.aux aux1 = bza;
        if (recyclerview.dG != null)
        {
            recyclerview.dG._mth1FBE("Cannot remove item decoration during a scroll  or layout");
        }
        recyclerview.dI.remove(aux1);
        if (recyclerview.dI.isEmpty())
        {
            boolean flag;
            if (FE70._mth02BC(recyclerview) == 2)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            recyclerview.setWillNotDraw(flag);
        }
        recyclerview._mth1D61();
        recyclerview.requestLayout();
        eH._mth02CA(aux);
        bza = aux;
    }
}
