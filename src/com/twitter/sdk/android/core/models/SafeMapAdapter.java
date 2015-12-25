// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.models;

import o.ig;
import o.jd;
import o.jf;
import o.mp;

public class SafeMapAdapter
    implements jf
{

    public SafeMapAdapter()
    {
    }

    public jd create(ig ig1, mp mp)
    {
        return new _cls1();
    }

    private class _cls1 extends jd
    {

        final SafeMapAdapter this$0;
        final jd val$delegate;
        final mp val$tokenType;

        public Object read(mq mq)
        {
            mq = ((mq) (delegate.read(mq)));
            if (java/util/Map.isAssignableFrom(tokenType.Js))
            {
                if (mq == null)
                {
                    return Collections.EMPTY_MAP;
                } else
                {
                    return Collections.unmodifiableMap((Map)mq);
                }
            } else
            {
                return mq;
            }
        }

        public void write(mt mt, Object obj)
        {
            delegate.write(mt, obj);
        }

        _cls1()
        {
            this$0 = SafeMapAdapter.this;
            delegate = jd1;
            tokenType = mp1;
            super();
        }
    }

}
