// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            apd, _cls028B

public final class apg
{

    public long bxk;
    public apd byA;
    int byw;
    int byx;
    public int byy;
    public Object byz[];

    public apg(int i, int j, int k)
    {
        bxk = 0L;
        byw = j;
        byx = k;
        byy = i;
    }

    public final String toString()
    {
        String s = (new StringBuilder("RTMPMessage ")).append(byy).append(" csid ").append(byw).append(" stream ").append(byx).append(" time ").append(bxk).toString();
        if (byz != null)
        {
            s = (new StringBuilder()).append(s).append(": ").toString();
            Object aobj[] = byz;
            int k = aobj.length;
            for (int i = 0; i < k; i++)
            {
                Object obj = aobj[i];
                s = (new StringBuilder()).append(s).append(obj).append(" / ").toString();
            }

            return s;
        }
        s = (new StringBuilder()).append(s).append(": ").toString();
        int l = Math.min(byA.length, 50);
        for (int j = 0; j < l; j++)
        {
            s = (new StringBuilder()).append(s).append(Integer.toHexString(byA.buffer[j] & 0xff)).append(" ").toString();
        }

        return s;
    }

    public final void _mth02CE(Object aobj[])
    {
        byz = aobj;
        byA = new apd(_cls028B._mth02CB(aobj));
    }
}
