// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.chatman.api;


// Referenced classes of package tv.periscope.chatman.api:
//            Kind, ControlMessage

public static class type
    implements Kind
{

    public static final int TYPE_JOIN = 1;
    public static final int TYPE_LEAVE = 2;
    public final int occupancy;
    public final String room;
    public final int type;

    public int kind()
    {
        return 4;
    }

    public String toString()
    {
        return (new StringBuilder("presence: room=")).append(room).append(", occupancy=").append(occupancy).append(", type=").append(type).toString();
    }

    public (String s, int i, int j)
    {
        room = s;
        occupancy = i;
        type = j;
    }
}
