// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.util.SparseArray;
import android.view.animation.Animation;

// Referenced classes of package com.localytics.android:
//            InAppDialogFragment, InAppCallable, Constants

class this._cls1
    implements android.view.animation.this._cls1
{

    final is._cls0 this$1;

    public void onAnimationEnd(Animation animation)
    {
        if (InAppDialogFragment.access$500(_fld0) != null)
        {
            animation = (InAppCallable)InAppDialogFragment.access$500(_fld0).get(16);
            if (!Constants.isTestModeEnabled() && animation != null)
            {
                animation.call(new Object[] {
                    InAppDialogFragment.access$200(_fld0)
                });
            }
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
