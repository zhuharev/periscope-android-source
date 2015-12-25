// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            qu

final class qw
{

    final Object Qp;
    final qu Qq;
    volatile boolean Qr;
    final int priority;

    qw(Object obj, qu qu1, int i)
    {
        Qp = obj;
        Qq = qu1;
        priority = i;
        Qr = true;
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof qw)
        {
            obj = (qw)obj;
            return Qp == ((qw) (obj)).Qp && Qq.equals(((qw) (obj)).Qq);
        } else
        {
            return false;
        }
    }

    public final int hashCode()
    {
        return Qp.hashCode() + Qq.Qm.hashCode();
    }
}
