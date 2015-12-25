// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.app.Activity;
import android.content.Context;
import android.os.ResultReceiver;
import o.rz;

// Referenced classes of package com.digits.sdk.android:
//            DigitsControllerImpl

class val.context
    implements Runnable
{

    final DigitsControllerImpl this$0;
    final Context val$context;
    final String val$phoneNumber;

    public void run()
    {
        resultReceiver.send(200, getBundle(val$phoneNumber));
        rz._mth02CB((Activity)val$context, 200);
    }

    ()
    {
        this$0 = final_digitscontrollerimpl;
        val$phoneNumber = s;
        val$context = Context.this;
        super();
    }
}
