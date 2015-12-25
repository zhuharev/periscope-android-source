// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import java.util.List;
import java.util.Map;
import o.vr;
import o.vw;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Hpack, Header

static final class out
{

    private final vr out;

    final void writeByteString(vw vw1)
    {
        writeInt(vw1.data.length, 127, 0);
        vr vr1 = out;
        if (vw1 == null)
        {
            throw new IllegalArgumentException("byteString == null");
        } else
        {
            vw1._mth02CA(vr1);
            return;
        }
    }

    final void writeHeaders(List list)
    {
        int i = 0;
        for (int j = list.size(); i < j; i++)
        {
            vw vw1 = ((Header)list.get(i)).name._mth01AD();
            Integer integer = (Integer)Hpack.access$200().get(vw1);
            if (integer != null)
            {
                writeInt(integer.intValue() + 1, 15, 0);
                writeByteString(((Header)list.get(i)).value);
            } else
            {
                out.FEE7(0);
                writeByteString(vw1);
                writeByteString(((Header)list.get(i)).value);
            }
        }

    }

    final void writeInt(int i, int j, int k)
    {
        if (i < j)
        {
            out.FEE7(k | i);
            return;
        }
        out.FEE7(k | j);
        for (i -= j; i >= 128; i >>>= 7)
        {
            out.FEE7(i & 0x7f | 0x80);
        }

        out.FEE7(i);
    }

    (vr vr1)
    {
        out = vr1;
    }
}
