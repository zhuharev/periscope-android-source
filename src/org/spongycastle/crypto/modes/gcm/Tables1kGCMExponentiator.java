// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.modes.gcm;

import java.util.Vector;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.crypto.modes.gcm:
//            GCMExponentiator, GCMUtil

public class Tables1kGCMExponentiator
    implements GCMExponentiator
{

    private Vector awN;

    public Tables1kGCMExponentiator()
    {
    }

    public final void init(byte abyte0[])
    {
        abyte0 = GCMUtil._mth144A(abyte0);
        if (awN != null && Arrays._mth1427(abyte0, (int[])awN.elementAt(0)))
        {
            return;
        } else
        {
            awN = new Vector(8);
            awN.addElement(abyte0);
            return;
        }
    }

    public final void _mth02CB(long l, byte abyte0[])
    {
        int ai1[] = GCMUtil._mth01AB();
        int i = 0;
        for (; l > 0L; l >>>= 1)
        {
            if ((1L & l) != 0L)
            {
                int k = awN.size();
                int j = k;
                if (k <= i)
                {
                    int ai[] = (int[])awN.elementAt(j - 1);
                    int i1;
                    do
                    {
                        ai = Arrays._mth02D1(ai);
                        GCMUtil._mth02CB(ai, ai);
                        awN.addElement(ai);
                        i1 = j + 1;
                        j = i1;
                    } while (i1 <= i);
                }
                GCMUtil._mth02CB(ai1, (int[])awN.elementAt(i));
            }
            i++;
        }

        GCMUtil._mth02CA(ai1, abyte0);
    }
}
