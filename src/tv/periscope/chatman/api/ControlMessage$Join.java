// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.chatman.api;


// Referenced classes of package tv.periscope.chatman.api:
//            Kind, ControlMessage

public static class room
    implements Kind
{

    public final String room;

    public int kind()
    {
        return 1;
    }

    public String toString()
    {
        return (new StringBuilder("join:")).append(room).toString();
    }

    public (String s)
    {
        room = s;
    }
}
