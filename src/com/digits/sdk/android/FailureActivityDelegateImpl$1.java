// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.view.View;
import o.rz;

// Referenced classes of package com.digits.sdk.android:
//            FailureActivityDelegateImpl, FailureController

class this._cls0
    implements android.view.ateImpl._cls1
{

    final FailureActivityDelegateImpl this$0;

    public void onClick(View view)
    {
        rz._mth02CB(activity, 200);
        controller.sendFailure(FailureActivityDelegateImpl.access$000(FailureActivityDelegateImpl.this), FailureActivityDelegateImpl.access$100(FailureActivityDelegateImpl.this));
    }

    ()
    {
        this$0 = FailureActivityDelegateImpl.this;
        super();
    }
}
