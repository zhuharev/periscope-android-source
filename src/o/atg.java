// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            att

public final class atg extends att
{

    private final String broadcastId;

    public atg(String s)
    {
        if (s == null)
        {
            throw new NullPointerException("Null broadcastId");
        } else
        {
            broadcastId = s;
            return;
        }
    }

    public final boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj instanceof att)
        {
            obj = (att)obj;
            return broadcastId.equals(((att) (obj)).fW());
        } else
        {
            return false;
        }
    }

    public final String fW()
    {
        return broadcastId;
    }

    public final int hashCode()
    {
        return broadcastId.hashCode() ^ 0xf4243;
    }

    public final String toString()
    {
        return (new StringBuilder("DeletedBroadcast{broadcastId=")).append(broadcastId).append("}").toString();
    }
}
