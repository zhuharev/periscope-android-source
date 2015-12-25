// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import java.util.ArrayList;
import java.util.Collection;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            ans, ann, aop, anr, 
//            zu, zs

public class anq
{

    final zs aWV;
    final ApiManager bcW;
    final ans bgK;

    public anq(ApiManager apimanager, ans ans1, zs zs1)
    {
        bcW = apimanager;
        bgK = ans1;
        aWV = zs1;
    }

    public void clear()
    {
        Object obj = bgK;
        ((ans) (obj)).buG.bul.dj();
        ((android.support.v7.widget.RecyclerView.if) (((ans) (obj)).buG)).ey.notifyChanged();
        ((ans) (obj)).FBE7(((ans) (obj)).buG.bul.dl().size());
        obj = ((ans) (obj)).buw;
        if (obj != null)
        {
            ((InputMethodManager)((View) (obj)).getContext().getSystemService("input_method")).hideSoftInputFromWindow(((View) (obj)).getWindowToken(), 0);
        }
    }

    public void onEventMainThread(zu zu1)
    {
        switch (anr.$SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu1.aXk.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
            break;
        }
        boolean flag;
        if (zu1.aXl == null && zu1.mU == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            ((android.support.v7.widget.RecyclerView.if) (bgK.buG)).ey.notifyChanged();
        }
    }

    public void show()
    {
        switch (anr.btC[aWV.ordinal()])
        {
        case 1: // '\001'
            bcW.getFollowers();
            break;

        case 2: // '\002'
            bcW.getMutualFollows();
            break;
        }
        ans ans1 = bgK;
        if (!ans1._fld1EC8)
        {
            ObjectAnimator objectanimator = ObjectAnimator.ofFloat(ans1, "translationY", new float[] {
                (float)ans1._fld0575, 0.0F
            });
            Object obj = ans1.getContext();
            if (android.os.Build.VERSION.SDK_INT >= 21)
            {
                obj = AnimationUtils.loadInterpolator(((Context) (obj)), 0x10c000e);
            } else
            {
                obj = AnimationUtils.loadInterpolator(((Context) (obj)), 0x10c0003);
            }
            objectanimator.setInterpolator(((android.animation.TimeInterpolator) (obj)));
            objectanimator.addListener(ans1.buI);
            obj = new AnimatorSet();
            ((AnimatorSet) (obj)).play(objectanimator);
            ((AnimatorSet) (obj)).start();
            int i = ans1.dA().size();
            boolean flag;
            if (i > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ans1.buD = flag;
            ans1.FBE7(i);
        }
    }

    public void _mth02CA(ans.if if1)
    {
        bgK.buF = if1;
    }
}
