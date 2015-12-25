// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.util.encoders;

import java.io.ByteArrayOutputStream;

// Referenced classes of package org.spongycastle.util.encoders:
//            HexEncoder, Encoder, DecoderException, EncoderException

public class Hex
{

    private static final HexEncoder aPz = new HexEncoder();

    public Hex()
    {
    }

    public static byte[] _mth1508(String s)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        try
        {
            aPz._mth02CB(s, bytearrayoutputstream);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new DecoderException((new StringBuilder("exception decoding Hex string: ")).append(s.getMessage()).toString(), s);
        }
        return bytearrayoutputstream.toByteArray();
    }

    public static byte[] _mth1D65(byte abyte0[])
    {
        return FF70(abyte0, 0, abyte0.length);
    }

    public static byte[] FF70(byte abyte0[], int i, int j)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        try
        {
            aPz._mth02CA(abyte0, i, j, bytearrayoutputstream);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new EncoderException((new StringBuilder("exception encoding Hex string: ")).append(abyte0.getMessage()).toString(), abyte0);
        }
        return bytearrayoutputstream.toByteArray();
    }

}
