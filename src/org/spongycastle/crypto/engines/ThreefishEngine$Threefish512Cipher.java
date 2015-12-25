// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;


// Referenced classes of package org.spongycastle.crypto.engines:
//            ThreefishEngine

static final class it> extends it>
{

    public final void _mth02CB(long al[], long al1[])
    {
        long al2[] = aty;
        long al3[] = atx;
        int ai[] = ThreefishEngine.FB8B();
        int ai1[] = ThreefishEngine.FB30();
        if (al2.length != 17)
        {
            throw new IllegalArgumentException();
        }
        if (al3.length != 5)
        {
            throw new IllegalArgumentException();
        }
        long l7 = al[0];
        long l6 = al[1];
        long l5 = al[2];
        long l4 = al[3];
        long l3 = al[4];
        long l2 = al[5];
        long l1 = al[6];
        long l = al[7];
        l7 += al2[0];
        l6 += al2[1];
        l5 += al2[2];
        l4 += al2[3];
        l3 += al2[4];
        l2 += al2[5] + al3[0];
        l1 += al2[6] + al3[1];
        l += al2[7];
        for (int i = 1; i < 18; i += 2)
        {
            int j = ai[i];
            int k = ai1[i];
            l7 += l6;
            l6 = ThreefishEngine._mth02CA(l6, 46, l7);
            l5 += l4;
            l4 = ThreefishEngine._mth02CA(l4, 36, l5);
            l3 += l2;
            l2 = ThreefishEngine._mth02CA(l2, 19, l3);
            long l8 = l1 + l;
            l1 = ThreefishEngine._mth02CA(l, 37, l8);
            l = l5 + l6;
            l5 = ThreefishEngine._mth02CA(l6, 33, l);
            l3 += l1;
            l1 = ThreefishEngine._mth02CA(l1, 27, l3);
            l6 = l8 + l2;
            l2 = ThreefishEngine._mth02CA(l2, 14, l6);
            l7 += l4;
            long l9 = ThreefishEngine._mth02CA(l4, 42, l7);
            l3 += l5;
            l4 = ThreefishEngine._mth02CA(l5, 17, l3);
            l8 = l6 + l9;
            l5 = ThreefishEngine._mth02CA(l9, 49, l8);
            l9 = l7 + l2;
            l6 = ThreefishEngine._mth02CA(l2, 36, l9);
            l2 = l + l1;
            long l10 = ThreefishEngine._mth02CA(l1, 39, l2);
            l = l8 + l4;
            l7 = ThreefishEngine._mth02CA(l4, 44, l);
            l1 = l9 + l10;
            l4 = ThreefishEngine._mth02CA(l10, 9, l1);
            l2 += l6;
            l6 = ThreefishEngine._mth02CA(l6, 54, l2);
            l3 += l5;
            l5 = ThreefishEngine._mth02CA(l5, 56, l3);
            l9 = al2[j];
            long l12 = l7 + al2[j + 1];
            l10 = al2[j + 2];
            long l11 = l5 + al2[j + 3];
            l7 = al2[j + 4];
            l8 = l6 + (al2[j + 5] + al3[k]);
            l5 = al2[j + 6];
            l6 = al3[k + 1];
            l4 += al2[j + 7] + (long)i;
            l1 = l1 + l9 + l12;
            l9 = ThreefishEngine._mth02CA(l12, 39, l1);
            l10 = l2 + l10 + l11;
            l2 = ThreefishEngine._mth02CA(l11, 30, l10);
            l3 = l3 + l7 + l8;
            l7 = ThreefishEngine._mth02CA(l8, 34, l3);
            l5 = l + (l5 + l6) + l4;
            l8 = ThreefishEngine._mth02CA(l4, 24, l5);
            l = l10 + l9;
            l4 = ThreefishEngine._mth02CA(l9, 13, l);
            l6 = l3 + l8;
            l3 = ThreefishEngine._mth02CA(l8, 50, l6);
            l8 = l5 + l7;
            l5 = ThreefishEngine._mth02CA(l7, 10, l8);
            l7 = l1 + l2;
            l2 = ThreefishEngine._mth02CA(l2, 17, l7);
            l1 = l6 + l4;
            l4 = ThreefishEngine._mth02CA(l4, 25, l1);
            l6 = l8 + l2;
            l2 = ThreefishEngine._mth02CA(l2, 29, l6);
            l7 += l5;
            l5 = ThreefishEngine._mth02CA(l5, 39, l7);
            l9 = l + l3;
            l8 = ThreefishEngine._mth02CA(l3, 43, l9);
            l = l6 + l4;
            l3 = ThreefishEngine._mth02CA(l4, 8, l);
            l4 = l7 + l8;
            l8 = ThreefishEngine._mth02CA(l8, 35, l4);
            l10 = l9 + l5;
            l9 = ThreefishEngine._mth02CA(l5, 56, l10);
            l1 += l2;
            l2 = ThreefishEngine._mth02CA(l2, 22, l1);
            l7 = l4 + al2[j + 1];
            l6 = l3 + al2[j + 2];
            l5 = l10 + al2[j + 3];
            l4 = l2 + al2[j + 4];
            l3 = l1 + al2[j + 5];
            l2 = l9 + (al2[j + 6] + al3[k + 1]);
            l1 = l + (al2[j + 7] + al3[k + 2]);
            l = l8 + (al2[j + 8] + (long)i + 1L);
        }

        al1[0] = l7;
        al1[1] = l6;
        al1[2] = l5;
        al1[3] = l4;
        al1[4] = l3;
        al1[5] = l2;
        al1[6] = l1;
        al1[7] = l;
    }

    public final void _mth02CE(long al[], long al1[])
    {
        long al2[] = aty;
        long al3[] = atx;
        int ai[] = ThreefishEngine.FB8B();
        int ai1[] = ThreefishEngine.FB30();
        if (al2.length != 17)
        {
            throw new IllegalArgumentException();
        }
        if (al3.length != 5)
        {
            throw new IllegalArgumentException();
        }
        long l7 = al[0];
        long l3 = al[1];
        long l6 = al[2];
        long l = al[3];
        long l5 = al[4];
        long l1 = al[5];
        long l4 = al[6];
        long l2 = al[7];
        for (int i = 17; i > 0; i -= 2)
        {
            int j = ai[i];
            int k = ai1[i];
            long l8 = l7 - al2[j + 1];
            long l14 = al2[j + 2];
            l7 = l6 - al2[j + 3];
            l6 = al2[j + 4];
            l5 -= al2[j + 5];
            long l10 = al2[j + 6];
            long l12 = al3[k + 1];
            long l20 = l4 - (al2[j + 7] + al3[k + 2]);
            long l16 = al2[j + 8];
            long l18 = i;
            l4 = ThreefishEngine._mth02CB(l3 - l14, 8, l20);
            l3 = l20 - l4;
            l2 = ThreefishEngine._mth02CB(l2 - (l16 + l18 + 1L), 35, l8);
            l8 -= l2;
            l10 = ThreefishEngine._mth02CB(l1 - (l10 + l12), 56, l7);
            l1 = l7 - l10;
            l = ThreefishEngine._mth02CB(l - l6, 22, l5);
            l5 -= l;
            l7 = ThreefishEngine._mth02CB(l4, 25, l5);
            l4 = l5 - l7;
            l = ThreefishEngine._mth02CB(l, 29, l3);
            l5 = l3 - l;
            l10 = ThreefishEngine._mth02CB(l10, 39, l8);
            l6 = l8 - l10;
            l3 = ThreefishEngine._mth02CB(l2, 43, l1);
            l2 = l1 - l3;
            l1 = ThreefishEngine._mth02CB(l7, 13, l2);
            l2 -= l1;
            l7 = ThreefishEngine._mth02CB(l3, 50, l4);
            l3 = l4 - l7;
            l8 = ThreefishEngine._mth02CB(l10, 10, l5);
            l4 = l5 - l8;
            l = ThreefishEngine._mth02CB(l, 17, l6);
            l6 -= l;
            l5 = ThreefishEngine._mth02CB(l1, 39, l6);
            l = ThreefishEngine._mth02CB(l, 30, l2);
            l1 = ThreefishEngine._mth02CB(l8, 34, l3);
            l7 = ThreefishEngine._mth02CB(l7, 24, l4);
            l8 = l6 - l5 - al2[j];
            l10 = al2[j + 1];
            l6 = l2 - l - al2[j + 2];
            l2 = al2[j + 3];
            l3 = l3 - l1 - al2[j + 4];
            l12 = al2[j + 5];
            l14 = al3[k];
            l4 = l4 - l7 - (al2[j + 6] + al3[k + 1]);
            l16 = al2[j + 7];
            l18 = i;
            l10 = ThreefishEngine._mth02CB(l5 - l10, 44, l4);
            l4 -= l10;
            l5 = ThreefishEngine._mth02CB(l7 - (l16 + l18), 9, l8);
            l7 = l8 - l5;
            l8 = ThreefishEngine._mth02CB(l1 - (l12 + l14), 54, l6);
            l1 = l6 - l8;
            l = ThreefishEngine._mth02CB(l - l2, 56, l3);
            l3 -= l;
            l2 = ThreefishEngine._mth02CB(l10, 17, l3);
            l3 -= l2;
            l = ThreefishEngine._mth02CB(l, 49, l4);
            l4 -= l;
            l8 = ThreefishEngine._mth02CB(l8, 36, l7);
            l6 = l7 - l8;
            l5 = ThreefishEngine._mth02CB(l5, 39, l1);
            l1 -= l5;
            l7 = ThreefishEngine._mth02CB(l2, 33, l1);
            l1 -= l7;
            l2 = ThreefishEngine._mth02CB(l5, 27, l3);
            l5 = l3 - l2;
            l8 = ThreefishEngine._mth02CB(l8, 14, l4);
            l4 -= l8;
            l = ThreefishEngine._mth02CB(l, 42, l6);
            l6 -= l;
            l3 = ThreefishEngine._mth02CB(l7, 46, l6);
            l7 = l6 - l3;
            l = ThreefishEngine._mth02CB(l, 36, l1);
            l6 = l1 - l;
            l1 = ThreefishEngine._mth02CB(l8, 19, l5);
            l5 -= l1;
            l2 = ThreefishEngine._mth02CB(l2, 37, l4);
            l4 -= l2;
        }

        long l9 = al2[0];
        long l11 = al2[1];
        long l13 = al2[2];
        long l15 = al2[3];
        long l17 = al2[4];
        long l19 = al2[5];
        long l21 = al3[0];
        long l22 = al2[6];
        long l23 = al3[1];
        long l24 = al2[7];
        al1[0] = l7 - l9;
        al1[1] = l3 - l11;
        al1[2] = l6 - l13;
        al1[3] = l - l15;
        al1[4] = l5 - l17;
        al1[5] = l1 - (l19 + l21);
        al1[6] = l4 - (l22 + l23);
        al1[7] = l2 - l24;
    }

    protected (long al[], long al1[])
    {
        super(al, al1);
    }
}
