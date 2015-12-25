// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Collection;
import java.util.List;

// Referenced classes of package o:
//            asw

public static final class .String extends .String
{

    public Collection bDx;
    private String cursor;
    private String prevCursor;

    public final asw eO()
    {
        String s1 = "";
        if (bDx == null)
        {
            s1 = (new StringBuilder()).append("").append(" messages").toString();
        }
        String s = s1;
        if (prevCursor == null)
        {
            s = (new StringBuilder()).append(s1).append(" prevCursor").toString();
        }
        s1 = s;
        if (cursor == null)
        {
            s1 = (new StringBuilder()).append(s).append(" cursor").toString();
        }
        if (!s1.isEmpty())
        {
            throw new IllegalStateException((new StringBuilder("Missing required properties:")).append(s1).toString());
        } else
        {
            return new asw(bDx, prevCursor, cursor, (byte)0);
        }
    }

    public final .List _mth02CC(List list)
    {
        bDx = list;
        return this;
    }

    public final .String FE9B(String s)
    {
        prevCursor = s;
        return this;
    }

    public final .String FEA9(String s)
    {
        cursor = s;
        return this;
    }

    public .String()
    {
    }
}
