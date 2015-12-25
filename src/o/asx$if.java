// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.List;

// Referenced classes of package o:
//            asx

public static final class .List extends .List
{

    public Integer bDy;
    private List occupants;

    public final asx eR()
    {
        String s = "";
        if (bDy == null)
        {
            s = (new StringBuilder()).append("").append(" occupancy").toString();
        }
        String s1 = s;
        if (occupants == null)
        {
            s1 = (new StringBuilder()).append(s).append(" occupants").toString();
        }
        if (!s1.isEmpty())
        {
            throw new IllegalStateException((new StringBuilder("Missing required properties:")).append(s1).toString());
        } else
        {
            return new asx(bDy.intValue(), occupants, (byte)0);
        }
    }

    public final .List _mth013C(int i)
    {
        bDy = Integer.valueOf(i);
        return this;
    }

    public final .List _mth02CD(List list)
    {
        occupants = list;
        return this;
    }

    public .List()
    {
    }
}
