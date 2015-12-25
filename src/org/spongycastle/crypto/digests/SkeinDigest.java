// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.digests;

import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.engines.ThreefishEngine;
import org.spongycastle.util.Memoable;

// Referenced classes of package org.spongycastle.crypto.digests:
//            SkeinEngine

public class SkeinDigest
    implements ExtendedDigest, Memoable
{

    private SkeinEngine aoB;

    public SkeinDigest(int i, int j)
    {
        aoB = new SkeinEngine(i, j);
        aoB._mth02CA(null);
    }

    public SkeinDigest(SkeinDigest skeindigest)
    {
        aoB = new SkeinEngine(skeindigest.aoB);
    }

    public final int doFinal(byte abyte0[], int i)
    {
        return aoB.doFinal(abyte0, i);
    }

    public final void reset()
    {
        Object obj = aoB;
        System.arraycopy(((SkeinEngine) (obj)).aoG, 0, ((SkeinEngine) (obj)).aoF, 0, ((SkeinEngine) (obj)).aoF.length);
        obj = ((SkeinEngine) (obj)).aoJ;
        SkeinEngine.UbiTweak ubitweak = ((SkeinEngine.UBI) (obj)).aoL;
        ubitweak.aoQ[0] = 0L;
        ubitweak.aoQ[1] = 0L;
        ubitweak.aoR = false;
        long al[] = ubitweak.aoQ;
        al[1] = al[1] | 0x4000000000000000L;
        al = ((SkeinEngine.UBI) (obj)).aoL;
        ((SkeinEngine.UbiTweak) (al)).aoQ[1] = ((SkeinEngine.UbiTweak) (al)).aoQ[1] & 0xffffffc000000000L | 0x3000000000000000L;
        obj.aoN = 0;
    }

    public final void update(byte byte0)
    {
        SkeinEngine skeinengine = aoB;
        skeinengine.aoK[0] = byte0;
        byte abyte0[] = skeinengine.aoK;
        skeinengine.aoJ._mth02CA(abyte0, 0, 1, skeinengine.aoF);
    }

    public final void update(byte abyte0[], int i, int j)
    {
        SkeinEngine skeinengine = aoB;
        skeinengine.aoJ._mth02CA(abyte0, i, j, skeinengine.aoF);
    }

    public final void _mth02CA(Memoable memoable)
    {
        memoable = (SkeinDigest)memoable;
        aoB._mth02CA(((SkeinDigest) (memoable)).aoB);
    }

    public final String _mth14AC()
    {
        return (new StringBuilder("Skein-")).append(aoB.aoD.atu << 3).append("-").append(aoB.aoE << 3).toString();
    }

    public final int _mth14AF()
    {
        return aoB.aoE;
    }

    public final int _mth14B2()
    {
        return aoB.aoD.atu;
    }

    public final Memoable _mth14B7()
    {
        return new SkeinDigest(this);
    }
}
