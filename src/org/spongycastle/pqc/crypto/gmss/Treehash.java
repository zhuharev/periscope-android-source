// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.gmss;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Vector;
import org.spongycastle.crypto.Digest;
import org.spongycastle.util.encoders.Hex;

public class Treehash
{

    byte aLI[];
    private byte aLJ[];
    byte aLK[];
    private int aLL;
    int aLM;
    boolean aLN;
    private Vector aLq;
    private Vector aLr;
    Digest aLs;
    boolean aLt;
    boolean aLu;
    int maxHeight;

    public Treehash(Vector vector, int i, Digest digest)
    {
        aLq = vector;
        maxHeight = i;
        aLI = null;
        aLt = false;
        aLu = false;
        aLN = false;
        aLs = digest;
        aLK = new byte[aLs._mth14AF()];
        aLJ = new byte[aLs._mth14AF()];
    }

    private byte[][] _mth067D()
    {
        int i = aLs._mth14AF();
        byte abyte0[][] = (byte[][])Array.newInstance(Byte.TYPE, new int[] {
            3, i
        });
        abyte0[0] = aLI;
        abyte0[1] = aLJ;
        abyte0[2] = aLK;
        return abyte0;
    }

    public final void initialize()
    {
        if (!aLN)
        {
            System.err.println((new StringBuilder("Seed ")).append(maxHeight).append(" not initialized").toString());
            return;
        } else
        {
            aLr = new Vector();
            aLL = 0;
            aLI = null;
            aLM = -1;
            aLt = true;
            System.arraycopy(aLK, 0, aLJ, 0, aLs._mth14AF());
            return;
        }
    }

    public String toString()
    {
        Object obj = "Treehash    : ";
        for (int i = 0; i < 6; i++)
        {
            obj = (new StringBuilder()).append(((String) (obj)));
            int ai[] = new int[6];
            ai[0] = maxHeight;
            ai[1] = 0;
            ai[2] = aLM;
            if (aLu)
            {
                ai[3] = 1;
            } else
            {
                ai[3] = 0;
            }
            if (aLt)
            {
                ai[4] = 1;
            } else
            {
                ai[4] = 0;
            }
            if (aLN)
            {
                ai[5] = 1;
            } else
            {
                ai[5] = 0;
            }
            obj = ((StringBuilder) (obj)).append(ai[i]).append(" ").toString();
        }

        for (int j = 0; j < 3; j++)
        {
            if (_mth067D()[j] != null)
            {
                obj = (new StringBuilder()).append(((String) (obj))).append(new String(Hex._mth1D65(_mth067D()[j]))).append(" ").toString();
            } else
            {
                obj = (new StringBuilder()).append(((String) (obj))).append("null ").toString();
            }
        }

        return (new StringBuilder()).append(((String) (obj))).append("  ").append(aLs._mth14AF()).toString();
    }
}
