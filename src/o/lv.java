// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.BitSet;

// Referenced classes of package o:
//            jd, mq, ms, iy, 
//            mt

final class lv extends jd
{

    lv()
    {
    }

    private static BitSet _mth02BD(mq mq1)
    {
        if (mq1._mth13A2() == ms.JO)
        {
            mq1.nextNull();
            return null;
        }
        BitSet bitset = new BitSet();
        mq1.beginArray();
        int i = 0;
        for (Object obj = mq1._mth13A2(); obj != ms.JH; obj = mq1._mth13A2())
        {
            boolean flag;
            switch (lj._cls1.HZ[((ms) (obj)).ordinal()])
            {
            case 1: // '\001'
                if (mq1.nextInt() != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                break;

            case 2: // '\002'
                flag = mq1.nextBoolean();
                break;

            case 3: // '\003'
                obj = mq1.nextString();
                int j;
                try
                {
                    j = Integer.parseInt(((String) (obj)));
                }
                // Misplaced declaration of an exception variable
                catch (mq mq1)
                {
                    throw new iy((new StringBuilder("Error: Expecting: bitset number value (1, 0), Found: ")).append(((String) (obj))).toString());
                }
                if (j != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                break;

            default:
                throw new iy((new StringBuilder("Invalid bitset value type: ")).append(obj).toString());
            }
            if (flag)
            {
                bitset.set(i);
            }
            i++;
        }

        mq1.endArray();
        return bitset;
    }

    public final Object read(mq mq1)
    {
        return _mth02BD(mq1);
    }

    public final void write(mt mt1, Object obj)
    {
        obj = (BitSet)obj;
        if (obj == null)
        {
            mt1._mth14F7();
            return;
        }
        mt1._mth13D0();
        for (int i = 0; i < ((BitSet) (obj)).length(); i++)
        {
            int j;
            if (((BitSet) (obj)).get(i))
            {
                j = 1;
            } else
            {
                j = 0;
            }
            mt1._mth02BE(j);
        }

        mt1._mth141C();
    }
}
