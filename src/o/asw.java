// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Collection;
import java.util.List;

// Referenced classes of package o:
//            asz

final class asw extends asz
{
    public static final class if extends asz.if
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

        public final if _mth02CC(List list)
        {
            bDx = list;
            return this;
        }

        public final if FE9B(String s)
        {
            prevCursor = s;
            return this;
        }

        public final if FEA9(String s)
        {
            cursor = s;
            return this;
        }

        public if()
        {
        }
    }


    private final Collection bDx;
    private final String cursor;
    private final String prevCursor;

    private asw(Collection collection, String s, String s1)
    {
        if (collection == null)
        {
            throw new NullPointerException("Null messages");
        }
        bDx = collection;
        if (s == null)
        {
            throw new NullPointerException("Null prevCursor");
        }
        prevCursor = s;
        if (s1 == null)
        {
            throw new NullPointerException("Null cursor");
        } else
        {
            cursor = s1;
            return;
        }
    }

    asw(Collection collection, String s, String s1, byte byte0)
    {
        this(collection, s, s1);
    }

    public final Collection eL()
    {
        return bDx;
    }

    public final String eM()
    {
        return prevCursor;
    }

    public final String eN()
    {
        return cursor;
    }

    public final boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj instanceof asz)
        {
            obj = (asz)obj;
            return bDx.equals(((asz) (obj)).eL()) && prevCursor.equals(((asz) (obj)).eM()) && cursor.equals(((asz) (obj)).eN());
        } else
        {
            return false;
        }
    }

    public final int hashCode()
    {
        return ((bDx.hashCode() ^ 0xf4243) * 0xf4243 ^ prevCursor.hashCode()) * 0xf4243 ^ cursor.hashCode();
    }

    public final String toString()
    {
        return (new StringBuilder("History{messages=")).append(bDx).append(", prevCursor=").append(prevCursor).append(", cursor=").append(cursor).append("}").toString();
    }
}
