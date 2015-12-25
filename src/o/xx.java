// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Objects;

public final class xx
{

    public final String aUj;
    public final String aUk;

    public xx(String s, String s1)
    {
        aUj = s;
        aUk = s1;
    }

    public final boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (xx)obj;
        return Objects.equals(aUj, ((xx) (obj)).aUj) && Objects.equals(aUk, ((xx) (obj)).aUk);
    }

    public final int hashCode()
    {
        return Objects.hash(new Object[] {
            aUj, aUk
        });
    }

    public final String toString()
    {
        return (new StringBuilder("ChannelInfo{pubnubChannel='")).append(aUj).append('\'').append(", roomId='").append(aUk).append('\'').append('}').toString();
    }
}
