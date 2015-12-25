// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            or

public final class os extends Exception
{

    private String Np;
    or Nq;

    public os(String s)
    {
        Np = "";
        Nq = or.MU;
        Np = s;
    }

    public os(or or1)
    {
        Np = "";
        Nq = or.MU;
        Nq = or1;
    }

    public final String toString()
    {
        String s1 = Nq.toString();
        String s = s1;
        if (Np.length() > 0)
        {
            s = (new StringBuilder()).append(s1).append(" . ").append(Np).toString();
        }
        return s;
    }
}
