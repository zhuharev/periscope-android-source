// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            atq

public final class atd extends atq
{

    private final int numLiveWatched;
    private final int numReplayWatched;
    private final int numWebWatched;

    public atd(int i, int j, int k)
    {
        numWebWatched = i;
        numReplayWatched = j;
        numLiveWatched = k;
    }

    public final boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj instanceof atq)
        {
            obj = (atq)obj;
            return numWebWatched == ((atq) (obj)).fq() && numReplayWatched == ((atq) (obj)).fr() && numLiveWatched == ((atq) (obj)).fs();
        } else
        {
            return false;
        }
    }

    public final int fq()
    {
        return numWebWatched;
    }

    public final int fr()
    {
        return numReplayWatched;
    }

    public final int fs()
    {
        return numLiveWatched;
    }

    public final int hashCode()
    {
        return ((numWebWatched ^ 0xf4243) * 0xf4243 ^ numReplayWatched) * 0xf4243 ^ numLiveWatched;
    }

    public final String toString()
    {
        return (new StringBuilder("BroadcastViewerMeta{numWebWatched=")).append(numWebWatched).append(", numReplayWatched=").append(numReplayWatched).append(", numLiveWatched=").append(numLiveWatched).append("}").toString();
    }
}
