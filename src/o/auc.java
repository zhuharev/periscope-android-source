// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            aue, auf

public final class auc extends aue
{

    private final auf aVl;

    public auc(auf auf)
    {
        if (auf == null)
        {
            throw new NullPointerException("Null message");
        } else
        {
            aVl = auf;
            return;
        }
    }

    public final boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj instanceof aue)
        {
            obj = (aue)obj;
            return aVl.equals(((aue) (obj)).gm());
        } else
        {
            return false;
        }
    }

    public final auf gm()
    {
        return aVl;
    }

    public final int hashCode()
    {
        return aVl.hashCode() ^ 0xf4243;
    }

    public final String toString()
    {
        return (new StringBuilder("ChatEvent{message=")).append(aVl).append("}").toString();
    }
}
