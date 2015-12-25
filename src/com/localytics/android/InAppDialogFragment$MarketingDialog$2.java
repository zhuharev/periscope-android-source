// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.view.View;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.localytics.android:
//            InAppDialogFragment

class this._cls1
    implements android.view.gDialog._cls2
{

    final smissWithAnimation this$1;

    public void onClick(View view)
    {
        if (InAppDialogFragment.access$300(_fld0).getAndSet(false))
        {
            smissWithAnimation();
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
