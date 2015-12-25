// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package o:
//            ajk, aka, akt, aap

final class ajv
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    private ajk._cls02CA bpR;

    ajv(ajk._cls02CA _pcls02ca)
    {
        bpR = _pcls02ca;
        super();
    }

    public final void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f = valueanimator.getAnimatedFraction();
        valueanimator = ajk._mth02BB(bpR.bpC).iterator();
        do
        {
            if (!valueanimator.hasNext())
            {
                break;
            }
            akt akt1 = ((aka)valueanimator.next()).cv();
            int i = akt1.bpO._mth1428(f);
            if (i != akt1._fld029F)
            {
                akt1._fld029F = i;
                if (akt1._fld0407 != null)
                {
                    akt1._fld0407.setColorFilter(akt1._fld029F, android.graphics.PorterDuff.Mode.SRC_IN);
                    akt1.invalidate();
                }
            }
        } while (true);
    }
}
