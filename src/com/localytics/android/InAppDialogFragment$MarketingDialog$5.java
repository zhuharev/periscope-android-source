// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.widget.RelativeLayout;

// Referenced classes of package com.localytics.android:
//            InAppDialogFragment, MarketingMessage

class this._cls1
    implements Runnable
{

    final this._cls1 this$1;

    public void run()
    {
        String s = (String)InAppDialogFragment.access$200(_fld0).get("location");
        if (s.equals("center"))
        {
            cess._mth700(this._cls1.this).startAnimation(cess._mth600(this._cls1.this));
            return;
        }
        if (s.equals("full"))
        {
            cess._mth700(this._cls1.this).startAnimation(cess._mth800(this._cls1.this));
            return;
        }
        if (s.equals("top"))
        {
            cess._mth700(this._cls1.this).startAnimation(cess._mth900(this._cls1.this));
            return;
        }
        if (s.equals("bottom"))
        {
            cess._mth700(this._cls1.this).startAnimation(cess._mth1000(this._cls1.this));
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
