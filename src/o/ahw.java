// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

// Referenced classes of package o:
//            arm, ahx, ahn, ahk

public class ahw extends RelativeLayout
{

    public arm bmk;
    public ahk bml;
    private android.view.View.OnTouchListener bmm;

    public ahw(Context context)
    {
        super(context);
        init(context);
    }

    public ahw(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init(context);
    }

    public ahw(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init(context);
    }

    private void init(Context context)
    {
        bmk = (arm)LayoutInflater.from(context).inflate(0x7f030038, this, true).findViewById(0x7f0d00c8);
        context = new ahx(this, context);
        context._mth1D4E(true);
        bmk.setAllowScroll(false);
        bmk.setItemAnimator(new ahn());
        bmk.setLayoutManager(context);
        bmk.setHasFixedSize(true);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (bmm != null)
        {
            bmm.onTouch(null, motionevent);
        }
        return super.onInterceptTouchEvent(motionevent);
    }

    public void setChatAdapter(ahk ahk)
    {
        bmk.setAdapter(ahk);
        bml = ahk;
    }

    public void setOnInterceptTouchEventListener(android.view.View.OnTouchListener ontouchlistener)
    {
        bmm = ontouchlistener;
    }
}
