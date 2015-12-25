// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            ig, it, kd, iq, 
//            iw

public abstract class auh
{

    public static final ig bFf = new ig();

    public auh()
    {
    }

    public static String _mth02CA(it it1, String s)
    {
        it1 = (iq)it1.GC.get(s);
        if (it1 != null && (it1 instanceof iw))
        {
            return it1._mth04AE();
        } else
        {
            return "";
        }
    }

    public static int _mth02CB(it it1, String s)
    {
        it1 = (iq)it1.GC.get(s);
        if (it1 != null && (it1 instanceof iw))
        {
            return it1._mth05D4();
        } else
        {
            return 0;
        }
    }

}
