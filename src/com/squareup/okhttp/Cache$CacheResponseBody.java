// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import o.vv;
import o.vz;
import o.wc;
import o.wn;

// Referenced classes of package com.squareup.okhttp:
//            ResponseBody, Cache, MediaType

static class apshot extends ResponseBody
{

    private final vv bodySource;
    private final String contentLength;
    private final String contentType;
    private final com.squareup.okhttp.internal.e snapshot;

    public long contentLength()
    {
        NumberFormatException numberformatexception;
label0:
        {
            long l;
            try
            {
                if (contentLength == null)
                {
                    break label0;
                }
                l = Long.parseLong(contentLength);
            }
            // Misplaced declaration of an exception variable
            catch (NumberFormatException numberformatexception)
            {
                return -1L;
            }
            return l;
        }
        return -1L;
    }

    public MediaType contentType()
    {
        if (contentType != null)
        {
            return MediaType.parse(contentType);
        } else
        {
            return null;
        }
    }

    public vv source()
    {
        return bodySource;
    }


    public apshot(com.squareup.okhttp.internal. , String s, String s1)
    {
        snapshot = ;
        contentType = s;
        contentLength = s1;
        class _cls1 extends vz
        {

            final Cache.CacheResponseBody this$0;
            final com.squareup.okhttp.internal.DiskLruCache.Snapshot val$snapshot;

            public void close()
            {
                snapshot.close();
                super.close();
            }

            _cls1(com.squareup.okhttp.internal.DiskLruCache.Snapshot snapshot1)
            {
                this$0 = Cache.CacheResponseBody.this;
                snapshot = snapshot1;
                super(final_wn);
            }
        }

        bodySource = wc._mth02CB(new _cls1());
    }
}
