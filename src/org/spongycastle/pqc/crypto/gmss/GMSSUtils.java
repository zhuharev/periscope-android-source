// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.gmss;

import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.pqc.crypto.gmss:
//            Treehash

class GMSSUtils
{

    GMSSUtils()
    {
    }

    static Vector[] _mth02CA(Vector avector[])
    {
        if (avector == null)
        {
            return null;
        }
        Vector avector1[] = new Vector[avector.length];
        for (int i = 0; i != avector.length; i++)
        {
            avector1[i] = new Vector();
            for (Enumeration enumeration = avector[i].elements(); enumeration.hasMoreElements(); avector1[i].addElement(enumeration.nextElement())) { }
        }

        return avector1;
    }

    static Treehash[] _mth02CA(Treehash atreehash[])
    {
        if (atreehash == null)
        {
            return null;
        } else
        {
            Treehash atreehash1[] = new Treehash[atreehash.length];
            System.arraycopy(atreehash, 0, atreehash1, 0, atreehash.length);
            return atreehash1;
        }
    }

    static byte[][] _mth02CA(byte abyte0[][])
    {
        if (abyte0 == null)
        {
            return null;
        }
        byte abyte1[][] = new byte[abyte0.length][];
        for (int i = 0; i != abyte0.length; i++)
        {
            abyte1[i] = Arrays._mth1D4C(abyte0[i]);
        }

        return abyte1;
    }
}
