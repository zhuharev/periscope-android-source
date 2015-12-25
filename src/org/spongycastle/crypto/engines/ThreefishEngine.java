// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.TweakableBlockCipherParameters;

public class ThreefishEngine
    implements BlockCipher
{
    static final class Threefish1024Cipher extends ThreefishCipher
    {

        final void _mth02CB(long al[], long al1[])
        {
            long al2[] = aty;
            long al3[] = atx;
            int ai[] = ThreefishEngine.FE8F();
            int ai1[] = ThreefishEngine.FB30();
            if (al2.length != 33)
            {
                throw new IllegalArgumentException();
            }
            if (al3.length != 5)
            {
                throw new IllegalArgumentException();
            }
            long l15 = al[0];
            long l14 = al[1];
            long l13 = al[2];
            long l12 = al[3];
            long l11 = al[4];
            long l10 = al[5];
            long l9 = al[6];
            long l8 = al[7];
            long l7 = al[8];
            long l6 = al[9];
            long l5 = al[10];
            long l4 = al[11];
            long l3 = al[12];
            long l2 = al[13];
            long l1 = al[14];
            long l = al[15];
            l15 += al2[0];
            l14 += al2[1];
            l13 += al2[2];
            l12 += al2[3];
            l11 += al2[4];
            l10 += al2[5];
            l9 += al2[6];
            l8 += al2[7];
            l7 += al2[8];
            l6 += al2[9];
            l5 += al2[10];
            l4 += al2[11];
            l3 += al2[12];
            l2 += al2[13] + al3[0];
            l1 += al2[14] + al3[1];
            l += al2[15];
            for (int i = 1; i < 20; i += 2)
            {
                int j = ai[i];
                int k = ai1[i];
                l15 += l14;
                l14 = ThreefishEngine._mth02CA(l14, 24, l15);
                l13 += l12;
                l12 = ThreefishEngine._mth02CA(l12, 13, l13);
                l11 += l10;
                l10 = ThreefishEngine._mth02CA(l10, 8, l11);
                l9 += l8;
                l8 = ThreefishEngine._mth02CA(l8, 47, l9);
                l7 += l6;
                long l19 = ThreefishEngine._mth02CA(l6, 8, l7);
                long l16 = l5 + l4;
                l5 = ThreefishEngine._mth02CA(l4, 17, l16);
                long l17 = l3 + l2;
                l2 = ThreefishEngine._mth02CA(l2, 22, l17);
                long l18 = l1 + l;
                l3 = ThreefishEngine._mth02CA(l, 37, l18);
                l6 = l15 + l19;
                l = ThreefishEngine._mth02CA(l19, 38, l6);
                l13 += l2;
                l1 = ThreefishEngine._mth02CA(l2, 19, l13);
                l4 = l9 + l5;
                l2 = ThreefishEngine._mth02CA(l5, 10, l4);
                l15 = l11 + l3;
                l5 = ThreefishEngine._mth02CA(l3, 55, l15);
                l3 = l16 + l8;
                l9 = ThreefishEngine._mth02CA(l8, 49, l3);
                l16 = l17 + l12;
                l8 = ThreefishEngine._mth02CA(l12, 18, l16);
                l17 = l18 + l10;
                l19 = ThreefishEngine._mth02CA(l10, 23, l17);
                l18 = l7 + l14;
                l12 = ThreefishEngine._mth02CA(l14, 52, l18);
                l10 = l6 + l9;
                l9 = ThreefishEngine._mth02CA(l9, 33, l10);
                l11 = l13 + l19;
                l7 = ThreefishEngine._mth02CA(l19, 4, l11);
                l6 = l15 + l8;
                l8 = ThreefishEngine._mth02CA(l8, 51, l6);
                l14 = l4 + l12;
                l13 = ThreefishEngine._mth02CA(l12, 13, l14);
                l12 = l16 + l5;
                l4 = ThreefishEngine._mth02CA(l5, 34, l12);
                l15 = l17 + l1;
                l5 = ThreefishEngine._mth02CA(l1, 41, l15);
                l16 = l18 + l2;
                l2 = ThreefishEngine._mth02CA(l2, 59, l16);
                l17 = l3 + l;
                l = ThreefishEngine._mth02CA(l, 17, l17);
                l1 = l10 + l4;
                l4 = ThreefishEngine._mth02CA(l4, 5, l1);
                l3 = l11 + l2;
                l10 = ThreefishEngine._mth02CA(l2, 20, l3);
                l2 = l14 + l5;
                l11 = ThreefishEngine._mth02CA(l5, 48, l2);
                l5 = l6 + l;
                l14 = ThreefishEngine._mth02CA(l, 41, l5);
                l = l15 + l13;
                l15 = ThreefishEngine._mth02CA(l13, 47, l);
                l6 = l16 + l7;
                l13 = ThreefishEngine._mth02CA(l7, 28, l6);
                l7 = l17 + l8;
                l16 = ThreefishEngine._mth02CA(l8, 16, l7);
                l8 = l12 + l9;
                l9 = ThreefishEngine._mth02CA(l9, 25, l8);
                long l25 = al2[j];
                long l26 = l15 + al2[j + 1];
                l17 = al2[j + 2];
                long l24 = l16 + al2[j + 3];
                long l22 = al2[j + 4];
                long l23 = l13 + al2[j + 5];
                l18 = al2[j + 6];
                long l21 = l9 + al2[j + 7];
                l19 = al2[j + 8];
                long l20 = l14 + al2[j + 9];
                l15 = al2[j + 10];
                l16 = l10 + al2[j + 11];
                l12 = al2[j + 12];
                l13 = l11 + (al2[j + 13] + al3[k]);
                l9 = al2[j + 14];
                l10 = al3[k + 1];
                l11 = l4 + (al2[j + 15] + (long)i);
                l14 = l1 + l25 + l26;
                l1 = ThreefishEngine._mth02CA(l26, 41, l14);
                l17 = l3 + l17 + l24;
                l3 = ThreefishEngine._mth02CA(l24, 9, l17);
                l5 = l5 + l22 + l23;
                l4 = ThreefishEngine._mth02CA(l23, 37, l5);
                l22 = l2 + l18 + l21;
                l18 = ThreefishEngine._mth02CA(l21, 31, l22);
                l2 = l6 + l19 + l20;
                l6 = ThreefishEngine._mth02CA(l20, 12, l2);
                l15 = l7 + l15 + l16;
                l7 = ThreefishEngine._mth02CA(l16, 47, l15);
                l12 = l8 + l12 + l13;
                l8 = ThreefishEngine._mth02CA(l13, 44, l12);
                l13 = l + (l9 + l10) + l11;
                l9 = ThreefishEngine._mth02CA(l11, 30, l13);
                l10 = l14 + l6;
                l = ThreefishEngine._mth02CA(l6, 16, l10);
                l11 = l17 + l8;
                l6 = ThreefishEngine._mth02CA(l8, 34, l11);
                l8 = l22 + l7;
                l7 = ThreefishEngine._mth02CA(l7, 56, l8);
                l14 = l5 + l9;
                l9 = ThreefishEngine._mth02CA(l9, 51, l14);
                l5 = l15 + l18;
                l17 = ThreefishEngine._mth02CA(l18, 4, l5);
                l15 = l12 + l3;
                l3 = ThreefishEngine._mth02CA(l3, 53, l15);
                l13 += l4;
                l19 = ThreefishEngine._mth02CA(l4, 42, l13);
                l16 = l2 + l1;
                l18 = ThreefishEngine._mth02CA(l1, 41, l16);
                l4 = l10 + l17;
                l1 = ThreefishEngine._mth02CA(l17, 31, l4);
                l12 = l11 + l19;
                l2 = ThreefishEngine._mth02CA(l19, 44, l12);
                l10 = l14 + l3;
                l3 = ThreefishEngine._mth02CA(l3, 47, l10);
                l14 = l8 + l18;
                l11 = ThreefishEngine._mth02CA(l18, 46, l14);
                l8 = l15 + l9;
                l9 = ThreefishEngine._mth02CA(l9, 19, l8);
                l13 += l6;
                l6 = ThreefishEngine._mth02CA(l6, 42, l13);
                l15 = l16 + l7;
                l16 = ThreefishEngine._mth02CA(l7, 44, l15);
                l18 = l5 + l;
                l17 = ThreefishEngine._mth02CA(l, 25, l18);
                l7 = l4 + l9;
                l = ThreefishEngine._mth02CA(l9, 9, l7);
                l9 = l12 + l16;
                l4 = ThreefishEngine._mth02CA(l16, 48, l9);
                l5 = l14 + l6;
                l16 = ThreefishEngine._mth02CA(l6, 35, l5);
                l10 += l17;
                l6 = ThreefishEngine._mth02CA(l17, 52, l10);
                l17 = l13 + l11;
                l11 = ThreefishEngine._mth02CA(l11, 23, l17);
                l19 = l15 + l2;
                l20 = ThreefishEngine._mth02CA(l2, 31, l19);
                l2 = l18 + l3;
                l12 = ThreefishEngine._mth02CA(l3, 37, l2);
                l3 = l8 + l1;
                l1 = ThreefishEngine._mth02CA(l1, 20, l3);
                l15 = l7 + al2[j + 1];
                l14 = l11 + al2[j + 2];
                l13 = l9 + al2[j + 3];
                l12 += al2[j + 4];
                l11 = l10 + al2[j + 5];
                l10 = l20 + al2[j + 6];
                l9 = l5 + al2[j + 7];
                l8 = l1 + al2[j + 8];
                l7 = l19 + al2[j + 9];
                l6 += al2[j + 10];
                l5 = l2 + al2[j + 11];
                l4 += al2[j + 12];
                l3 += al2[j + 13];
                l2 = l16 + (al2[j + 14] + al3[k + 1]);
                l1 = l17 + (al2[j + 15] + al3[k + 2]);
                l += al2[j + 16] + (long)i + 1L;
            }

            al1[0] = l15;
            al1[1] = l14;
            al1[2] = l13;
            al1[3] = l12;
            al1[4] = l11;
            al1[5] = l10;
            al1[6] = l9;
            al1[7] = l8;
            al1[8] = l7;
            al1[9] = l6;
            al1[10] = l5;
            al1[11] = l4;
            al1[12] = l3;
            al1[13] = l2;
            al1[14] = l1;
            al1[15] = l;
        }

        final void _mth02CE(long al[], long al1[])
        {
            long al2[] = aty;
            long al3[] = atx;
            int ai[] = ThreefishEngine.FE8F();
            int ai1[] = ThreefishEngine.FB30();
            if (al2.length != 33)
            {
                throw new IllegalArgumentException();
            }
            if (al3.length != 5)
            {
                throw new IllegalArgumentException();
            }
            long l15 = al[0];
            long l3 = al[1];
            long l14 = al[2];
            long l1 = al[3];
            long l13 = al[4];
            long l2 = al[5];
            long l12 = al[6];
            long l = al[7];
            long l11 = al[8];
            long l4 = al[9];
            long l10 = al[10];
            long l6 = al[11];
            long l9 = al[12];
            long l5 = al[13];
            long l8 = al[14];
            long l7 = al[15];
            for (int i = 19; i > 0; i -= 2)
            {
                int j = ai[i];
                int k = ai1[i];
                long l26 = l15 - al2[j + 1];
                l15 = al2[j + 2];
                long l16 = l14 - al2[j + 3];
                l14 = al2[j + 4];
                long l20 = l13 - al2[j + 5];
                l13 = al2[j + 6];
                long l18 = l12 - al2[j + 7];
                l12 = al2[j + 8];
                l11 -= al2[j + 9];
                long l22 = al2[j + 10];
                l10 -= al2[j + 11];
                long l32 = al2[j + 12];
                l9 -= al2[j + 13];
                long l28 = al2[j + 14];
                long l30 = al3[k + 1];
                long l24 = l8 - (al2[j + 15] + al3[k + 2]);
                l7 = ThreefishEngine._mth02CB(l7 - (al2[j + 16] + (long)i + 1L), 9, l26);
                l8 = l26 - l7;
                l6 = ThreefishEngine._mth02CB(l6 - l32, 48, l16);
                l16 -= l6;
                l5 = ThreefishEngine._mth02CB(l5 - (l28 + l30), 35, l18);
                l18 -= l5;
                l4 = ThreefishEngine._mth02CB(l4 - l22, 52, l20);
                l20 -= l4;
                l3 = ThreefishEngine._mth02CB(l3 - l15, 23, l24);
                l15 = l24 - l3;
                l2 = ThreefishEngine._mth02CB(l2 - l13, 31, l11);
                l11 -= l2;
                l14 = ThreefishEngine._mth02CB(l1 - l14, 37, l10);
                l10 -= l14;
                l = ThreefishEngine._mth02CB(l - l12, 20, l9);
                l13 = l9 - l;
                l1 = ThreefishEngine._mth02CB(l, 31, l8);
                l8 -= l1;
                l = ThreefishEngine._mth02CB(l2, 44, l16);
                l12 = l16 - l;
                l2 = ThreefishEngine._mth02CB(l14, 47, l20);
                l9 = l20 - l2;
                l3 = ThreefishEngine._mth02CB(l3, 46, l18);
                l18 -= l3;
                l20 = ThreefishEngine._mth02CB(l7, 19, l13);
                l13 -= l20;
                l5 = ThreefishEngine._mth02CB(l5, 42, l15);
                l14 = l15 - l5;
                l16 = ThreefishEngine._mth02CB(l6, 44, l11);
                l15 = l11 - l16;
                l6 = ThreefishEngine._mth02CB(l4, 25, l10);
                l4 = l10 - l6;
                l6 = ThreefishEngine._mth02CB(l6, 16, l8);
                l7 = l8 - l6;
                l11 = ThreefishEngine._mth02CB(l5, 34, l12);
                l8 = l12 - l11;
                l16 = ThreefishEngine._mth02CB(l16, 56, l18);
                l5 = l18 - l16;
                l20 = ThreefishEngine._mth02CB(l20, 51, l9);
                l12 = l9 - l20;
                l1 = ThreefishEngine._mth02CB(l1, 4, l4);
                l9 = l4 - l1;
                l4 = ThreefishEngine._mth02CB(l2, 53, l13);
                l10 = l13 - l4;
                l18 = ThreefishEngine._mth02CB(l, 42, l14);
                l2 = l14 - l18;
                l = ThreefishEngine._mth02CB(l3, 41, l15);
                l13 = l15 - l;
                l3 = ThreefishEngine._mth02CB(l, 41, l7);
                l = ThreefishEngine._mth02CB(l4, 9, l8);
                l4 = ThreefishEngine._mth02CB(l18, 37, l12);
                l1 = ThreefishEngine._mth02CB(l1, 31, l5);
                l6 = ThreefishEngine._mth02CB(l6, 12, l13);
                l16 = ThreefishEngine._mth02CB(l16, 47, l9);
                l18 = ThreefishEngine._mth02CB(l11, 44, l10);
                l14 = ThreefishEngine._mth02CB(l20, 30, l2);
                l30 = l7 - l3 - al2[j];
                l11 = al2[j + 1];
                l22 = l8 - l - al2[j + 2];
                l7 = al2[j + 3];
                l20 = l12 - l4 - al2[j + 4];
                l12 = al2[j + 5];
                l24 = l5 - l1 - al2[j + 6];
                l8 = al2[j + 7];
                l15 = l13 - l6 - al2[j + 8];
                l26 = al2[j + 9];
                l13 = l9 - l16 - al2[j + 10];
                long l34 = al2[j + 11];
                l10 = l10 - l18 - al2[j + 12];
                l9 = al2[j + 13];
                l32 = al3[k];
                l28 = l2 - l14 - (al2[j + 14] + al3[k + 1]);
                l5 = ThreefishEngine._mth02CB(l14 - (al2[j + 15] + (long)i), 5, l30);
                l14 = l30 - l5;
                l2 = ThreefishEngine._mth02CB(l16 - l34, 20, l22);
                l16 = l22 - l2;
                l9 = ThreefishEngine._mth02CB(l18 - (l9 + l32), 48, l24);
                l18 = l24 - l9;
                l6 = ThreefishEngine._mth02CB(l6 - l26, 41, l20);
                l20 -= l6;
                l3 = ThreefishEngine._mth02CB(l3 - l11, 47, l28);
                l11 = l28 - l3;
                l12 = ThreefishEngine._mth02CB(l4 - l12, 28, l15);
                l4 = l15 - l12;
                l15 = ThreefishEngine._mth02CB(l - l7, 16, l13);
                l7 = l13 - l15;
                l = ThreefishEngine._mth02CB(l1 - l8, 25, l10);
                l22 = l10 - l;
                l1 = ThreefishEngine._mth02CB(l, 33, l14);
                l13 = l14 - l1;
                l = ThreefishEngine._mth02CB(l12, 4, l16);
                l14 = l16 - l;
                l8 = ThreefishEngine._mth02CB(l15, 51, l20);
                l10 = l20 - l8;
                l3 = ThreefishEngine._mth02CB(l3, 13, l18);
                l15 = l18 - l3;
                l16 = ThreefishEngine._mth02CB(l5, 34, l22);
                l12 = l22 - l16;
                l5 = ThreefishEngine._mth02CB(l9, 41, l11);
                l9 = l11 - l5;
                l11 = ThreefishEngine._mth02CB(l2, 59, l4);
                l2 = l4 - l11;
                l4 = ThreefishEngine._mth02CB(l6, 17, l7);
                l22 = l7 - l4;
                l4 = ThreefishEngine._mth02CB(l4, 38, l13);
                l13 -= l4;
                l5 = ThreefishEngine._mth02CB(l5, 19, l14);
                l14 -= l5;
                l6 = ThreefishEngine._mth02CB(l11, 10, l15);
                l11 = l15 - l6;
                l7 = ThreefishEngine._mth02CB(l16, 55, l10);
                l18 = l10 - l7;
                l20 = ThreefishEngine._mth02CB(l1, 49, l22);
                l10 = l22 - l20;
                l1 = ThreefishEngine._mth02CB(l8, 18, l12);
                l8 = l12 - l1;
                l = ThreefishEngine._mth02CB(l, 23, l9);
                l16 = l9 - l;
                l3 = ThreefishEngine._mth02CB(l3, 52, l2);
                l9 = l2 - l3;
                l3 = ThreefishEngine._mth02CB(l3, 24, l13);
                l15 = l13 - l3;
                l1 = ThreefishEngine._mth02CB(l1, 13, l14);
                l14 -= l1;
                l2 = ThreefishEngine._mth02CB(l, 8, l18);
                l13 = l18 - l2;
                l = ThreefishEngine._mth02CB(l20, 47, l11);
                l12 = l11 - l;
                l4 = ThreefishEngine._mth02CB(l4, 8, l9);
                l11 = l9 - l4;
                l6 = ThreefishEngine._mth02CB(l6, 17, l10);
                l10 -= l6;
                l5 = ThreefishEngine._mth02CB(l5, 22, l8);
                l9 = l8 - l5;
                l7 = ThreefishEngine._mth02CB(l7, 37, l16);
                l8 = l16 - l7;
            }

            long l17 = al2[0];
            long l19 = al2[1];
            long l21 = al2[2];
            long l23 = al2[3];
            long l25 = al2[4];
            long l27 = al2[5];
            long l29 = al2[6];
            long l31 = al2[7];
            long l33 = al2[8];
            long l35 = al2[9];
            long l36 = al2[10];
            long l37 = al2[11];
            long l38 = al2[12];
            long l39 = al2[13];
            long l40 = al3[0];
            long l41 = al2[14];
            long l42 = al3[1];
            long l43 = al2[15];
            al1[0] = l15 - l17;
            al1[1] = l3 - l19;
            al1[2] = l14 - l21;
            al1[3] = l1 - l23;
            al1[4] = l13 - l25;
            al1[5] = l2 - l27;
            al1[6] = l12 - l29;
            al1[7] = l - l31;
            al1[8] = l11 - l33;
            al1[9] = l4 - l35;
            al1[10] = l10 - l36;
            al1[11] = l6 - l37;
            al1[12] = l9 - l38;
            al1[13] = l5 - (l39 + l40);
            al1[14] = l8 - (l41 + l42);
            al1[15] = l7 - l43;
        }

        public Threefish1024Cipher(long al[], long al1[])
        {
            super(al, al1);
        }
    }

    static final class Threefish256Cipher extends ThreefishCipher
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

        public Threefish256Cipher(long al[], long al1[])
        {
            super(al, al1);
        }
    }

    static final class Threefish512Cipher extends ThreefishCipher
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

        protected Threefish512Cipher(long al[], long al1[])
        {
            super(al, al1);
        }
    }

    static abstract class ThreefishCipher
    {

        protected final long atx[];
        protected final long aty[];

        abstract void _mth02CB(long al[], long al1[]);

        abstract void _mth02CE(long al[], long al1[]);

        protected ThreefishCipher(long al[], long al1[])
        {
            aty = al;
            atx = al1;
        }
    }


    private static int atq[];
    private static int atr[];
    private static int ats[];
    private static int att[];
    public boolean amy;
    public int atu;
    private int atv;
    private long atw[];
    private long atx[];
    private long aty[];
    private ThreefishCipher atz;

    public ThreefishEngine(int i)
    {
        atx = new long[5];
        atu = i / 8;
        atv = atu / 8;
        atw = new long[atv];
        aty = new long[atv * 2 + 1];
        switch (i)
        {
        case 256: 
            atz = new Threefish256Cipher(aty, atx);
            return;

        case 512: 
            atz = new Threefish512Cipher(aty, atx);
            return;

        case 1024: 
            atz = new Threefish1024Cipher(aty, atx);
            return;
        }
        throw new IllegalArgumentException("Invalid blocksize - Threefish is defined with block size of 256, 512, or 1024 bits");
    }

    static long _mth02CA(long l, int i, long l1)
    {
        return (l << i | l >>> -i) ^ l1;
    }

    static long _mth02CB(long l, int i, long l1)
    {
        l ^= l1;
        return l >>> i | l << -i;
    }

    public static void _mth02CB(long l, byte abyte0[], int i)
    {
        if (i + 8 > abyte0.length)
        {
            throw new IllegalArgumentException();
        } else
        {
            int j = i + 1;
            abyte0[i] = (byte)(int)l;
            i = j + 1;
            abyte0[j] = (byte)(int)(l >> 8);
            j = i + 1;
            abyte0[i] = (byte)(int)(l >> 16);
            i = j + 1;
            abyte0[j] = (byte)(int)(l >> 24);
            j = i + 1;
            abyte0[i] = (byte)(int)(l >> 32);
            i = j + 1;
            abyte0[j] = (byte)(int)(l >> 40);
            abyte0[i] = (byte)(int)(l >> 48);
            abyte0[i + 1] = (byte)(int)(l >> 56);
            return;
        }
    }

    public static long _mth02CC(byte abyte0[], int i)
    {
        if (i + 8 > abyte0.length)
        {
            throw new IllegalArgumentException();
        } else
        {
            int j = i + 1;
            long l = abyte0[i];
            i = j + 1;
            long l1 = abyte0[j];
            j = i + 1;
            long l2 = abyte0[i];
            i = j + 1;
            long l3 = abyte0[j];
            j = i + 1;
            long l4 = abyte0[i];
            i = j + 1;
            return l & 255L | (l1 & 255L) << 8 | (l2 & 255L) << 16 | (l3 & 255L) << 24 | (l4 & 255L) << 32 | ((long)abyte0[j] & 255L) << 40 | ((long)abyte0[i] & 255L) << 48 | ((long)abyte0[i + 1] & 255L) << 56;
        }
    }

    static int[] _mth5FC4()
    {
        return ats;
    }

    static int[] FB30()
    {
        return att;
    }

    static int[] FB8B()
    {
        return atq;
    }

    static int[] FE8F()
    {
        return atr;
    }

    public final int getBlockSize()
    {
        return atu;
    }

    public final void reset()
    {
    }

    public void _mth02BE(long al[])
    {
        if (al.length != 2)
        {
            throw new IllegalArgumentException("Tweak must be 2 words.");
        } else
        {
            atx[0] = al[0];
            atx[1] = al[1];
            atx[2] = atx[0] ^ atx[1];
            atx[3] = atx[0];
            atx[4] = atx[1];
            return;
        }
    }

    public final int _mth02CA(byte abyte0[], int i, byte abyte1[], int j)
    {
        if (atu + j > abyte1.length)
        {
            throw new DataLengthException("Output buffer too short");
        }
        if (atu + i > abyte0.length)
        {
            throw new DataLengthException("Input buffer too short");
        }
        for (int k = 0; k < atu; k += 8)
        {
            atw[k >> 3] = _mth02CC(abyte0, i + k);
        }

        _mth02CA(atw, atw);
        for (i = 0; i < atu; i += 8)
        {
            _mth02CB(atw[i >> 3], abyte1, j + i);
        }

        return atu;
    }

    public final int _mth02CA(long al[], long al1[])
    {
        if (aty[atv] == 0L)
        {
            throw new IllegalStateException("Threefish engine not initialised");
        }
        if (al.length != atv)
        {
            throw new DataLengthException("Input buffer too short");
        }
        if (al1.length != atv)
        {
            throw new DataLengthException("Output buffer too short");
        }
        if (amy)
        {
            atz._mth02CB(al, al1);
        } else
        {
            atz._mth02CE(al, al1);
        }
        return atv;
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        long al1[];
        if (cipherparameters instanceof TweakableBlockCipherParameters)
        {
            cipherparameters = (TweakableBlockCipherParameters)cipherparameters;
            al1 = ((TweakableBlockCipherParameters) (cipherparameters)).avZ.key;
            cipherparameters = ((TweakableBlockCipherParameters) (cipherparameters)).axK;
        } else
        if (cipherparameters instanceof KeyParameter)
        {
            al1 = ((KeyParameter)cipherparameters).key;
            cipherparameters = null;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Invalid parameter passed to Threefish init - ")).append(cipherparameters.getClass().getName()).toString());
        }
        long al[] = null;
        Object obj = null;
        if (al1 != null)
        {
            if (al1.length != atu)
            {
                throw new IllegalArgumentException((new StringBuilder("Threefish key must be same size as block (")).append(atu).append(" bytes)").toString());
            }
            long al2[] = new long[atv];
            int i = 0;
            do
            {
                al = al2;
                if (i >= al2.length)
                {
                    break;
                }
                al2[i] = _mth02CC(al1, i << 3);
                i++;
            } while (true);
        }
        al1 = obj;
        if (cipherparameters != null)
        {
            if (cipherparameters.length != 16)
            {
                throw new IllegalArgumentException("Threefish tweak must be 16 bytes");
            }
            al1 = new long[2];
            al1[0] = _mth02CC(cipherparameters, 0);
            al1[1] = _mth02CC(cipherparameters, 8);
        }
        _mth02CA(flag, al, al1);
    }

    public final void _mth02CA(boolean flag, long al[], long al1[])
    {
        amy = flag;
        if (al != null)
        {
            _mth1FBE(al);
        }
        if (al1 != null)
        {
            _mth02BE(al1);
        }
    }

    public final String _mth14AC()
    {
        return (new StringBuilder("Threefish-")).append(atu << 3).toString();
    }

    public void _mth1FBE(long al[])
    {
        if (al.length != atv)
        {
            throw new IllegalArgumentException((new StringBuilder("Threefish key must be same size as block (")).append(atv).append(" words)").toString());
        }
        long l = 0x1bd11bdaa9fc1a22L;
        for (int i = 0; i < atv; i++)
        {
            aty[i] = al[i];
            l ^= aty[i];
        }

        aty[atv] = l;
        System.arraycopy(aty, 0, aty, atv + 1, atv);
    }

    static 
    {
        int ai[] = new int[80];
        atq = ai;
        atr = new int[ai.length];
        ats = new int[atq.length];
        att = new int[atq.length];
        for (int i = 0; i < atq.length; i++)
        {
            atr[i] = i % 17;
            atq[i] = i % 9;
            ats[i] = i % 5;
            att[i] = i % 3;
        }

    }
}
