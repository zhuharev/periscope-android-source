// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.view.View;
import android.widget.AdapterView;
import java.util.Map;

// Referenced classes of package com.localytics.android:
//            Constants, TestModeListView, InAppCallable

class this._cls1
    implements android.widget.r
{

    final smiss this$1;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (i == 0)
        {
            Constants.setTestModeEnabled(false);
            dismiss();
        } else
        if (i == 1)
        {
            if (TestModeListView.access$200(_fld0) != null)
            {
                adapterview = (InAppCallable)TestModeListView.access$200(_fld0).get(Integer.valueOf(12));
                if (adapterview != null)
                {
                    adapterview.call(null);
                }
            }
        } else
        if (i == 2)
        {
            if (TestModeListView.access$200(_fld0) != null)
            {
                adapterview = (InAppCallable)TestModeListView.access$200(_fld0).get(Integer.valueOf(13));
                if (adapterview != null)
                {
                    adapterview.call(null);
                }
            }
        } else
        if (i == 3 && TestModeListView.access$200(_fld0) != null)
        {
            adapterview = (InAppCallable)TestModeListView.access$200(_fld0).get(Integer.valueOf(14));
            if (adapterview != null)
            {
                adapterview.call(null);
            }
        }
        smiss();
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
