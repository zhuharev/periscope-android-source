// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.digests;


// Referenced classes of package org.spongycastle.crypto.digests:
//            SkeinEngine

static class aoQ
{

    long aoQ[];
    boolean aoR;

    public String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder()).append((int)(aoQ[1] >>> 56 & 63L)).append(" first: ");
        boolean flag;
        if ((aoQ[1] & 0x4000000000000000L) != 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        stringbuilder = stringbuilder.append(flag).append(", final: ");
        if ((aoQ[1] & 0x8000000000000000L) != 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return stringbuilder.append(flag).toString();
    }

    public final void _mth1D64(int i)
    {
        if (aoR)
        {
            long al[] = new long[3];
            al[0] = aoQ[0] & 0xffffffffL;
            al[1] = aoQ[0] >>> 32 & 0xffffffffL;
            al[2] = aoQ[1] & 0xffffffffL;
            long l = i;
            for (i = 0; i < 3; i++)
            {
                l += al[i];
                al[i] = l;
                l >>>= 32;
            }

            aoQ[0] = (al[1] & 0xffffffffL) << 32 | al[0] & 0xffffffffL;
            aoQ[1] = aoQ[1] & 0xffffffff00000000L | al[2] & 0xffffffffL;
            return;
        }
        long l1 = aoQ[0] + (long)i;
        aoQ[0] = l1;
        if (l1 > 0x7fffffff80000000L)
        {
            aoR = true;
        }
    }

    public ()
    {
        aoQ = new long[2];
        aoQ[0] = 0L;
        aoQ[1] = 0L;
        aoR = false;
        long al[] = aoQ;
        al[1] = al[1] | 0x4000000000000000L;
    }
}
