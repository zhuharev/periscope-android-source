// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.chatman.api;

import java.util.List;
import o.auh;
import o.ig;
import o.is;

// Referenced classes of package tv.periscope.chatman.api:
//            Kind

public class ControlMessage
    implements Kind
{
    public static class Join
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

        public Join(String s)
        {
            room = s;
        }
    }

    public static class Leave
        implements Kind
    {

        public final String room;

        public int kind()
        {
            return 2;
        }

        public String toString()
        {
            return (new StringBuilder("leave:")).append(room).toString();
        }

        public Leave(String s)
        {
            room = s;
        }
    }

    public static class Presence
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

        public Presence(String s, int i, int j)
        {
            room = s;
            occupancy = i;
            type = j;
        }
    }

    public static class Roster
        implements Kind
    {

        public final List occupants = null;
        public final String room;

        public int kind()
        {
            return 3;
        }

        public Roster(String s)
        {
            room = s;
        }
    }


    public static final int CONTROL_JOIN = 1;
    public static final int CONTROL_LEAVE = 2;
    public static final int CONTROL_PRESENCE = 4;
    public static final int CONTROL_ROSTER = 3;
    public final String body;
    public final int bodyKind;

    ControlMessage(int i, String s)
    {
        body = s;
        bodyKind = i;
    }

    public static ControlMessage create(Kind kind1)
    {
        int i = kind1.kind();
        ig ig1 = auh.bFf;
        if (kind1 == null)
        {
            kind1 = ig1._mth02CA(is.GB);
        } else
        {
            kind1 = ig1._mth02CA(kind1, kind1.getClass());
        }
        return new ControlMessage(i, kind1);
    }

    public int kind()
    {
        return 2;
    }

    public String toString()
    {
        return (new StringBuilder("ctrl kind=")).append(bodyKind).append(", body=").append(body).toString();
    }
}
