// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

// Referenced classes of package o:
//            afo, arc, aec, asj, 
//            afq, arv, aak, anq

public final class afp extends afo
{

    private final arc biL;
    private final boolean biM;

    public afp(Activity activity, TextView textview, TextView textview1, arc arc1, arc arc2, arc arc3, arv arv, 
            boolean flag, aak aak, anq anq)
    {
        super(activity, textview, textview1, arc1, arc2, arv, aak, anq);
        biL = arc3;
        biM = flag;
        biL.setOnClickListener(this);
    }

    static arc _mth02CA(afp afp1)
    {
        return afp1.biL;
    }

    public final aec bH()
    {
        boolean flag1 = bF();
        boolean flag2 = bI();
        boolean flag;
        if (!super.biE.isActivated() && biL.getVisibility() == 0 && biL.isActivated())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return new aec(flag1, flag2, flag);
    }

    protected final void bK()
    {
        super.bK();
        biL.setVisibility(8);
    }

    protected final void bL()
    {
        super.bL();
        biL.setVisibility(0);
    }

    public final void onClick(View view)
    {
        if (view == biL)
        {
            if (biM)
            {
                _mth02CA(biL, false);
                return;
            }
            view = biC;
            boolean flag;
            if (((asj) (view)).bCP.isShowing() && ((asj) (view)).av.isAttachedToWindow())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                view = biC;
                ((asj) (view)).bCO.removeMessages(100);
                ((asj) (view)).bCQ.cancel();
                ((asj) (view)).bCP.dismiss();
            }
            biC._mth02CA(biL, mActivity.getString(0x7f06005f), false);
            return;
        } else
        {
            super.onClick(view);
            return;
        }
    }

    final void _mth02CB(aec aec1)
    {
        super._mth02CB(aec1);
        boolean flag = aec1.bgo;
        aec1 = biL;
        aec1.setActivated(flag);
        float f;
        if (flag)
        {
            f = 1.0F;
        } else
        {
            f = 0.3F;
        }
        aec1.setAlpha(f);
        (new Handler(Looper.getMainLooper())).postDelayed(new afq(this, flag), 150L);
    }
}
