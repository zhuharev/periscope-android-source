// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import java.util.zip.Inflater;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Spdy3, NameValueBlockReader

public class this._cls0 extends Inflater
{

    final NameValueBlockReader this$0;

    public int inflate(byte abyte0[], int i, int j)
    {
        int i1 = super.inflate(abyte0, i, j);
        int k = i1;
        int l = k;
        if (i1 == 0)
        {
            l = k;
            if (needsDictionary())
            {
                setDictionary(Spdy3.DICTIONARY);
                l = super.inflate(abyte0, i, j);
            }
        }
        return l;
    }

    ()
    {
        this$0 = NameValueBlockReader.this;
        super();
    }
}
