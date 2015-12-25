// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.digests;

import org.spongycastle.crypto.engines.ThreefishEngine;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.crypto.digests:
//            SkeinEngine

public class aoM
{

    final weak aoL = new weak();
    private byte aoM[];
    int aoN;
    private long aoO[];
    private SkeinEngine aoP;

    private void _mth02BC(long al[])
    {
        ThreefishEngine threefishengine = aoP.aoD;
        long al1[] = aoP.aoF;
        long al2[] = aoL.aoQ;
        threefishengine.amy = true;
        if (al1 != null)
        {
            threefishengine._mth1FBE(al1);
        }
        if (al2 != null)
        {
            threefishengine._mth02BE(al2);
        }
        for (int i = 0; i < aoO.length; i++)
        {
            aoO[i] = ThreefishEngine._mth02CC(aoM, i << 3);
        }

        aoP.aoD._mth02CA(aoO, al);
        for (int j = 0; j < al.length; j++)
        {
            al[j] = al[j] ^ aoO[j];
        }

    }

    public final void _mth02BD(long al[])
    {
        for (int i = aoN; i < aoM.length; i++)
        {
            aoM[i] = 0;
        }

        long al1[] = aoL.aoQ;
        al1[1] = al1[1] | 0x8000000000000000L;
        _mth02BC(al);
    }

    public final void _mth02CA(_cls02BC _pcls02bc)
    {
        aoM = Arrays.FE73(_pcls02bc.aoM, aoM);
        aoN = _pcls02bc.aoN;
        aoO = Arrays._mth141D(_pcls02bc.aoO, aoO);
        weak weak = aoL;
        _pcls02bc = _pcls02bc.aoL;
        weak.aoQ = Arrays._mth141D(((weak) (_pcls02bc)).aoQ, weak.aoQ);
        weak.aoR = ((weak) (_pcls02bc)).aoR;
    }

    public final void _mth02CA(byte abyte0[], int i, int j, long al[])
    {
        for (int k = 0; j > k;)
        {
            if (aoN == aoM.length)
            {
                _mth02BC(al);
                long al1[] = aoL.aoQ;
                al1[1] = al1[1] & 0xbfffffffffffffffL;
                aoN = 0;
            }
            int l = Math.min(j - k, aoM.length - aoN);
            System.arraycopy(abyte0, i + k, aoM, aoN, l);
            k += l;
            aoN = aoN + l;
            aoL._mth1D64(l);
        }

    }

    public weak(SkeinEngine skeinengine, int i)
    {
        aoP = skeinengine;
        super();
        aoM = new byte[i];
        aoO = new long[aoM.length / 8];
    }
}
