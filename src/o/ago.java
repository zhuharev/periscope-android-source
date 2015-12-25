// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.view.View;

// Referenced classes of package o:
//            agl

final class ago
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener
{

    private agl bkd;

    ago(agl agl1)
    {
        bkd = agl1;
        super();
    }

    public final void onGlobalLayout()
    {
        Rect rect = new Rect();
        bkd.bjR.getWindowVisibleDisplayFrame(rect);
        int i = bkd.bjR.getRootView().getHeight() - (rect.bottom - rect.top);
        if (i > bkd.bjV)
        {
            if (!bkd.bjW)
            {
                bkd.bjW = true;
                float f = bkd.bjU;
                float f2 = i;
                float f3 = bkd.bjS.getTranslationY();
                f2 = -((f - f2) / 4F);
                f = f2;
                if ((float)bkd.bjS.getTop() + f2 < 0.0F)
                {
                    f = -bkd.bjS.getTop();
                }
                ObjectAnimator objectanimator = ObjectAnimator.ofFloat(bkd.bjS, View.TRANSLATION_Y, new float[] {
                    f3, f
                });
                objectanimator.setDuration(100L);
                objectanimator.start();
                return;
            }
        } else
        if (i < bkd.bjV && bkd.bjW)
        {
            bkd.bjW = false;
            float f1 = bkd.bjS.getTranslationY();
            ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(bkd.bjS, View.TRANSLATION_Y, new float[] {
                f1, 0.0F
            });
            objectanimator1.setDuration(100L);
            objectanimator1.start();
        }
    }
}
