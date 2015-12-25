// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.util.io;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class Streams
{

    private static int BUFFER_SIZE = 512;

    public Streams()
    {
    }

    private static void _mth02CA(InputStream inputstream, ByteArrayOutputStream bytearrayoutputstream)
    {
        byte abyte0[] = new byte[BUFFER_SIZE];
        do
        {
            int i = inputstream.read(abyte0, 0, abyte0.length);
            if (i >= 0)
            {
                bytearrayoutputstream.write(abyte0, 0, i);
            } else
            {
                return;
            }
        } while (true);
    }

    public static int _mth02CB(InputStream inputstream, byte abyte0[])
    {
        int j = abyte0.length;
        int i = 0;
        do
        {
            if (i >= j)
            {
                break;
            }
            int k = inputstream.read(abyte0, i + 0, j - i);
            if (k < 0)
            {
                break;
            }
            i += k;
        } while (true);
        return i;
    }

    public static byte[] _mth02D1(InputStream inputstream)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        _mth02CA(inputstream, bytearrayoutputstream);
        return bytearrayoutputstream.toByteArray();
    }

}
