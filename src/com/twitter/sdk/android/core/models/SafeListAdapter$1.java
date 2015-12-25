// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.models;

import java.util.Collections;
import java.util.List;
import o.jd;
import o.mp;
import o.mq;
import o.mt;

// Referenced classes of package com.twitter.sdk.android.core.models:
//            SafeListAdapter

class val.tokenType extends jd
{

    final SafeListAdapter this$0;
    final jd val$delegate;
    final mp val$tokenType;

    public Object read(mq mq)
    {
        mq = ((mq) (val$delegate.read(mq)));
        if (java/util/List.isAssignableFrom(val$tokenType.Js))
        {
            if (mq == null)
            {
                return Collections.EMPTY_LIST;
            } else
            {
                return Collections.unmodifiableList((List)mq);
            }
        } else
        {
            return mq;
        }
    }

    public void write(mt mt, Object obj)
    {
        val$delegate.write(mt, obj);
    }

    ()
    {
        this$0 = final_safelistadapter;
        val$delegate = jd1;
        val$tokenType = mp.this;
        super();
    }
}
