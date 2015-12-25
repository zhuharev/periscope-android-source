// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.List;

// Referenced classes of package o:
//            ata

final class asx extends ata
{
    public static final class if extends ata.if
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

        public final if _mth013C(int i)
        {
            bDy = Integer.valueOf(i);
            return this;
        }

        public final if _mth02CD(List list)
        {
            occupants = list;
            return this;
        }

        public if()
        {
        }
    }


    private final int occupancy;
    private final List occupants;

    private asx(int i, List list)
    {
        occupancy = i;
        if (list == null)
        {
            throw new NullPointerException("Null occupants");
        } else
        {
            occupants = list;
            return;
        }
    }

    asx(int i, List list, byte byte0)
    {
        this(i, list);
    }

    public final int eP()
    {
        return occupancy;
    }

    public final List eQ()
    {
        return occupants;
    }

    public final boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj instanceof ata)
        {
            obj = (ata)obj;
            return occupancy == ((ata) (obj)).eP() && occupants.equals(((ata) (obj)).eQ());
        } else
        {
            return false;
        }
    }

    public final int hashCode()
    {
        return (occupancy ^ 0xf4243) * 0xf4243 ^ occupants.hashCode();
    }

    public final String toString()
    {
        return (new StringBuilder("Presence{occupancy=")).append(occupancy).append(", occupants=").append(occupants).append("}").toString();
    }
}
