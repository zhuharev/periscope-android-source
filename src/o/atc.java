// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            atp, atx, atn

public final class atc extends atp
{

    private final atx bfl;
    private final atn bfm;

    public atc(atn atn, atx atx)
    {
        if (atn == null)
        {
            throw new NullPointerException("Null broadcast");
        }
        bfm = atn;
        if (atx == null)
        {
            throw new NullPointerException("Null meta");
        } else
        {
            bfl = atx;
            return;
        }
    }

    public final boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj instanceof atp)
        {
            obj = (atp)obj;
            return bfm.equals(((atp) (obj)).fo()) && bfl.equals(((atp) (obj)).fp());
        } else
        {
            return false;
        }
    }

    public final atn fo()
    {
        return bfm;
    }

    public final atx fp()
    {
        return bfl;
    }

    public final int hashCode()
    {
        return (bfm.hashCode() ^ 0xf4243) * 0xf4243 ^ bfl.hashCode();
    }

    public final String toString()
    {
        return (new StringBuilder("BroadcastSummary{broadcast=")).append(bfm).append(", meta=").append(bfl).append("}").toString();
    }
}
