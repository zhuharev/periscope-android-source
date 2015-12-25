// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.util.encoders;

import java.io.ByteArrayOutputStream;

// Referenced classes of package org.spongycastle.util.encoders:
//            Base64Encoder, Encoder, DecoderException, EncoderException

public class Base64
{

    private static final Base64Encoder aPv = new Base64Encoder();

    public Base64()
    {
    }

    public static byte[] _mth1508(String s)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream((s.length() / 4) * 3);
        try
        {
            aPv._mth02CB(s, bytearrayoutputstream);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new DecoderException((new StringBuilder("unable to decode base64 string: ")).append(s.getMessage()).toString(), s);
        }
        return bytearrayoutputstream.toByteArray();
    }

    public static byte[] _mth1D65(byte abyte0[])
    {
        return FF70(abyte0, 0, abyte0.length);
    }

    private static byte[] FF70(byte abyte0[], int i, int j)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream((j + 2) / 3 << 2);
        try
        {
            aPv._mth02CA(abyte0, 0, j, bytearrayoutputstream);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new EncoderException((new StringBuilder("exception encoding base64 string: ")).append(abyte0.getMessage()).toString(), abyte0);
        }
        return bytearrayoutputstream.toByteArray();
    }

}
