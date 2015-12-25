// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

// Referenced classes of package org.spongycastle.asn1:
//            LimitedInputStream, ASN1InputStream

class StreamUtil
{

    private static final long Xb = Runtime.getRuntime().maxMemory();

    StreamUtil()
    {
    }

    static int _mth02CF(InputStream inputstream)
    {
        if (inputstream instanceof LimitedInputStream)
        {
            return ((LimitedInputStream)inputstream).getRemaining();
        }
        if (inputstream instanceof ASN1InputStream)
        {
            return ((ASN1InputStream)inputstream).limit;
        }
        if (inputstream instanceof ByteArrayInputStream)
        {
            return ((ByteArrayInputStream)inputstream).available();
        }
        if (!(inputstream instanceof FileInputStream))
        {
            break MISSING_BLOCK_LABEL_87;
        }
        inputstream = ((FileInputStream)inputstream).getChannel();
label0:
        {
            if (inputstream != null)
            {
                long l;
                try
                {
                    l = inputstream.size();
                    break label0;
                }
                // Misplaced declaration of an exception variable
                catch (InputStream inputstream) { }
                break MISSING_BLOCK_LABEL_87;
            }
            l = 0x7fffffffL;
        }
        if (l < 0x7fffffffL)
        {
            return (int)l;
        }
        if (Xb > 0x7fffffffL)
        {
            return 0x7fffffff;
        } else
        {
            return (int)Xb;
        }
    }

    static int _mth14BE(int i)
    {
        int k = 1;
        boolean flag = true;
        if (i > 127)
        {
            k = 1;
            int j = i;
            i = k;
            do
            {
                k = j >>> 8;
                j = k;
                if (k == 0)
                {
                    break;
                }
                i++;
            } while (true);
            j = i - 1 << 3;
            i = ((flag) ? 1 : 0);
            do
            {
                k = i;
                if (j < 0)
                {
                    break;
                }
                i++;
                j -= 8;
            } while (true);
        }
        return k;
    }

    static int _mth14EA(int i)
    {
        int j = 1;
        if (i >= 31)
        {
            if (i < 128)
            {
                return 1 + 1;
            }
            j = 5 - 1;
            int k;
            int l;
            do
            {
                k = i >> 7;
                l = j - 1;
                j = l;
                i = k;
            } while (k > 127);
            j = (5 - l) + 1;
        }
        return j;
    }

}
