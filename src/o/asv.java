// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import tv.periscope.chatman.api.Sender;

// Referenced classes of package o:
//            asy

public final class asv extends asy
{

    private final String body;
    private final String payload;
    private final String room;
    private final Sender sender;
    private final long timestamp;

    public asv(String s, String s1, Sender sender1, long l, String s2)
    {
        if (s == null)
        {
            throw new NullPointerException("Null room");
        }
        room = s;
        if (s1 == null)
        {
            throw new NullPointerException("Null body");
        }
        body = s1;
        if (sender1 == null)
        {
            throw new NullPointerException("Null sender");
        }
        sender = sender1;
        timestamp = l;
        if (s2 == null)
        {
            throw new NullPointerException("Null payload");
        } else
        {
            payload = s2;
            return;
        }
    }

    public final String eH()
    {
        return room;
    }

    public final String eI()
    {
        return body;
    }

    public final Sender eJ()
    {
        return sender;
    }

    public final String eK()
    {
        return payload;
    }

    public final boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj instanceof asy)
        {
            obj = (asy)obj;
            return room.equals(((asy) (obj)).eH()) && body.equals(((asy) (obj)).eI()) && sender.equals(((asy) (obj)).eJ()) && timestamp == ((asy) (obj)).timestamp() && payload.equals(((asy) (obj)).eK());
        } else
        {
            return false;
        }
    }

    public final int hashCode()
    {
        return (int)((long)((((room.hashCode() ^ 0xf4243) * 0xf4243 ^ body.hashCode()) * 0xf4243 ^ sender.hashCode()) * 0xf4243) ^ (timestamp >>> 32 ^ timestamp)) * 0xf4243 ^ payload.hashCode();
    }

    public final long timestamp()
    {
        return timestamp;
    }

    public final String toString()
    {
        return (new StringBuilder("Chat{room=")).append(room).append(", body=").append(body).append(", sender=").append(sender).append(", timestamp=").append(timestamp).append(", payload=").append(payload).append("}").toString();
    }
}
