// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import o.vr;
import o.vz;
import o.wn;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            NameValueBlockReader

public class this._cls0 extends vz
{

    final NameValueBlockReader this$0;

    public long read(vr vr, long l)
    {
        if (NameValueBlockReader.access$000(NameValueBlockReader.this) == 0)
        {
            return -1L;
        }
        l = super.read(vr, Math.min(l, NameValueBlockReader.access$000(NameValueBlockReader.this)));
        if (l == -1L)
        {
            return -1L;
        } else
        {
            NameValueBlockReader.access$002(NameValueBlockReader.this, (int)((long)NameValueBlockReader.access$000(NameValueBlockReader.this) - l));
            return l;
        }
    }

    (wn wn)
    {
        this$0 = NameValueBlockReader.this;
        super(wn);
    }
}
