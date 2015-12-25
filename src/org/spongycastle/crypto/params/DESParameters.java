// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;


// Referenced classes of package org.spongycastle.crypto.params:
//            KeyParameter

public class DESParameters extends KeyParameter
{

    private static byte axa[] = {
        1, 1, 1, 1, 1, 1, 1, 1, 31, 31, 
        31, 31, 14, 14, 14, 14, -32, -32, -32, -32, 
        -15, -15, -15, -15, -2, -2, -2, -2, -2, -2, 
        -2, -2, 1, -2, 1, -2, 1, -2, 1, -2, 
        31, -32, 31, -32, 14, -15, 14, -15, 1, -32, 
        1, -32, 1, -15, 1, -15, 31, -2, 31, -2, 
        14, -2, 14, -2, 1, 31, 1, 31, 1, 14, 
        1, 14, -32, -2, -32, -2, -15, -2, -15, -2, 
        -2, 1, -2, 1, -2, 1, -2, 1, -32, 31, 
        -32, 31, -15, 14, -15, 14, -32, 1, -32, 1, 
        -15, 1, -15, 1, -2, 31, -2, 31, -2, 14, 
        -2, 14, 31, 1, 31, 1, 14, 1, 14, 1, 
        -2, -32, -2, -32, -2, -15, -2, -15
    };

    public static boolean _mth1428(byte abyte0[], int i)
    {
        if (abyte0.length - i < 8)
        {
            throw new IllegalArgumentException("key material too short.");
        }
        int j = 0;
label0:
        do
        {
label1:
            {
                if (j >= 16)
                {
                    break label0;
                }
                for (int k = 0; k < 8; k++)
                {
                    if (abyte0[k + i] != axa[(j << 3) + k])
                    {
                        break label1;
                    }
                }

                return true;
            }
            j++;
        } while (true);
        return false;
    }

    public static void _mth1D55(byte abyte0[])
    {
        for (int i = 0; i < abyte0.length; i++)
        {
            byte byte0 = abyte0[i];
            abyte0[i] = (byte)(byte0 & 0xfe | (byte0 >> 1 ^ byte0 >> 2 ^ byte0 >> 3 ^ byte0 >> 4 ^ byte0 >> 5 ^ byte0 >> 6 ^ byte0 >> 7 ^ 1) & 1);
        }

    }

}
