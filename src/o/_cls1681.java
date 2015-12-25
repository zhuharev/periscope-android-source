// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.UnsupportedEncodingException;

final class _cls1681
{

    final byte bytes[];
    private volatile int tW;

    private _cls1681(byte abyte0[])
    {
        tW = 0;
        bytes = abyte0;
    }

    public static _cls1681 _mth02CA(byte abyte0[], int i, int j)
    {
        byte abyte1[] = new byte[j];
        System.arraycopy(abyte0, 0, abyte1, 0, j);
        return new _cls1681(abyte1);
    }

    public static _cls1681 _mth02CD(String s)
    {
        try
        {
            s = new _cls1681(s.getBytes("UTF-8"));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException("UTF-8 not supported.", s);
        }
        return s;
    }

    public final boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof _cls1681))
        {
            return false;
        }
        _cls1681 _lcls1681 = (_cls1681)obj;
        int j = bytes.length;
        if (j != _lcls1681.bytes.length)
        {
            return false;
        }
        obj = bytes;
        byte abyte0[] = _lcls1681.bytes;
        for (int i = 0; i < j; i++)
        {
            if (obj[i] != abyte0[i])
            {
                return false;
            }
        }

        return true;
    }

    public final int hashCode()
    {
        int j = tW;
        int i = j;
        if (j == 0)
        {
            byte abyte0[] = bytes;
            int i1 = bytes.length;
            int k = 0;
            i = i1;
            int l;
            do
            {
                l = i;
                if (k >= i1)
                {
                    break;
                }
                i = l * 31 + abyte0[k];
                k++;
            } while (true);
            i = l;
            if (l == 0)
            {
                i = 1;
            }
            tW = i;
        }
        return i;
    }

    static 
    {
        new _cls1681(new byte[0]);
    }
}
