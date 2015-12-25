// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.chatman.api;


// Referenced classes of package tv.periscope.chatman.api:
//            Kind, Sender

public class ChatMessage
    implements Kind
{

    public final String body;
    public final String room;
    public final Sender sender = null;
    public final long timestamp = 0L;

    public ChatMessage(String s, String s1)
    {
        body = s1;
        room = s;
    }

    public int kind()
    {
        return 1;
    }

    public String toString()
    {
        return (new StringBuilder("Chat{body=")).append(body).append(", timestamp=").append(timestamp).append("}").toString();
    }
}
