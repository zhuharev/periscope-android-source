// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;


// Referenced classes of package org.spongycastle.crypto.engines:
//            ThreefishEngine

static final class it> extends it>
{

    final void _mth02CB(long al[], long al1[])
    {
        long al2[] = aty;
        long al3[] = atx;
        int ai[] = ThreefishEngine._mth5FC4();
        int ai1[] = ThreefishEngine.FB30();
        if (al2.length != 9)
        {
            throw new IllegalArgumentException();
        }
        if (al3.length != 5)
        {
            throw new IllegalArgumentException();
        }
        long l3 = al[0];
        long l2 = al[1];
        long l1 = al[2];
        long l = al[3];
        l3 += al2[0];
        l2 += al2[1] + al3[0];
        l1 += al2[2] + al3[1];
        l += al2[3];
        for (int i = 1; i < 18; i += 2)
        {
            int j = ai[i];
            int k = ai1[i];
            l3 += l2;
            l2 = ThreefishEngine._mth02CA(l2, 14, l3);
            l1 += l;
            l = ThreefishEngine._mth02CA(l, 16, l1);
            l3 += l;
            l = ThreefishEngine._mth02CA(l, 52, l3);
            l1 += l2;
            long l4 = ThreefishEngine._mth02CA(l2, 57, l1);
            l2 = l3 + l4;
            l3 = ThreefishEngine._mth02CA(l4, 23, l2);
            l1 += l;
            l4 = ThreefishEngine._mth02CA(l, 40, l1);
            l = l2 + l4;
            l2 = ThreefishEngine._mth02CA(l4, 5, l);
            l1 += l3;
            l3 = ThreefishEngine._mth02CA(l3, 37, l1);
            long l5 = al2[j];
            long l6 = l3 + (al2[j + 1] + al3[k]);
            l3 = al2[j + 2];
            l4 = al3[k + 1];
            l2 += al2[j + 3] + (long)i;
            l5 = l + l5 + l6;
            l = ThreefishEngine._mth02CA(l6, 25, l5);
            l3 = l1 + (l3 + l4) + l2;
            l1 = ThreefishEngine._mth02CA(l2, 33, l3);
            l2 = l5 + l1;
            l1 = ThreefishEngine._mth02CA(l1, 46, l2);
            l3 += l;
            l = ThreefishEngine._mth02CA(l, 12, l3);
            l2 += l;
            l = ThreefishEngine._mth02CA(l, 58, l2);
            l3 += l1;
            l4 = ThreefishEngine._mth02CA(l1, 22, l3);
            l1 = l2 + l4;
            l4 = ThreefishEngine._mth02CA(l4, 32, l1);
            l5 = l3 + l;
            l = ThreefishEngine._mth02CA(l, 32, l5);
            l3 = l1 + al2[j + 1];
            l2 = l + (al2[j + 2] + al3[k + 1]);
            l1 = l5 + (al2[j + 3] + al3[k + 2]);
            l = l4 + (al2[j + 4] + (long)i + 1L);
        }

        al1[0] = l3;
        al1[1] = l2;
        al1[2] = l1;
        al1[3] = l;
    }

    final void _mth02CE(long al[], long al1[])
    {
        long al2[] = aty;
        long al3[] = atx;
        int ai[] = ThreefishEngine._mth5FC4();
        int ai1[] = ThreefishEngine.FB30();
        if (al2.length != 9)
        {
            throw new IllegalArgumentException();
        }
        if (al3.length != 5)
        {
            throw new IllegalArgumentException();
        }
        long l3 = al[0];
        long l = al[1];
        long l2 = al[2];
        long l1 = al[3];
        for (int i = 17; i > 0; i -= 2)
        {
            int j = ai[i];
            int k = ai1[i];
            long l6 = l3 - al2[j + 1];
            l3 = al2[j + 2];
            long l4 = al3[k + 1];
            l2 -= al2[j + 3] + al3[k + 2];
            l1 = ThreefishEngine._mth02CB(l1 - (al2[j + 4] + (long)i + 1L), 32, l6);
            l6 -= l1;
            l = ThreefishEngine._mth02CB(l - (l3 + l4), 32, l2);
            l2 -= l;
            l = ThreefishEngine._mth02CB(l, 58, l6);
            l3 = l6 - l;
            l4 = ThreefishEngine._mth02CB(l1, 22, l2);
            l1 = l2 - l4;
            l2 = ThreefishEngine._mth02CB(l4, 46, l3);
            l3 -= l2;
            l = ThreefishEngine._mth02CB(l, 12, l1);
            l1 -= l;
            l = ThreefishEngine._mth02CB(l, 25, l3);
            l6 = ThreefishEngine._mth02CB(l2, 33, l1);
            long l8 = l3 - l - al2[j];
            l2 = al2[j + 1];
            l3 = al3[k];
            l4 = l1 - l6 - (al2[j + 2] + al3[k + 1]);
            l1 = ThreefishEngine._mth02CB(l6 - (al2[j + 3] + (long)i), 5, l8);
            l6 = l8 - l1;
            l = ThreefishEngine._mth02CB(l - (l2 + l3), 37, l4);
            l2 = l4 - l;
            l = ThreefishEngine._mth02CB(l, 23, l6);
            l3 = l6 - l;
            l1 = ThreefishEngine._mth02CB(l1, 40, l2);
            l2 -= l1;
            l1 = ThreefishEngine._mth02CB(l1, 52, l3);
            l3 -= l1;
            l = ThreefishEngine._mth02CB(l, 57, l2);
            l2 -= l;
            l = ThreefishEngine._mth02CB(l, 14, l3);
            l3 -= l;
            l1 = ThreefishEngine._mth02CB(l1, 16, l2);
            l2 -= l1;
        }

        long l5 = al2[0];
        long l7 = al2[1];
        long l9 = al3[0];
        long l10 = al2[2];
        long l11 = al3[1];
        long l12 = al2[3];
        al1[0] = l3 - l5;
        al1[1] = l - (l7 + l9);
        al1[2] = l2 - (l10 + l11);
        al1[3] = l1 - l12;
    }

    public (long al[], long al1[])
    {
        super(al, al1);
    }
}
