// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            ast

public final class asu extends ast
{

    private final String accessToken;
    private final String endpoint;

    public asu(String s, String s1)
    {
        if (s == null)
        {
            throw new NullPointerException("Null endpoint");
        }
        endpoint = s;
        if (s1 == null)
        {
            throw new NullPointerException("Null accessToken");
        } else
        {
            accessToken = s1;
            return;
        }
    }

    public final String eF()
    {
        return endpoint;
    }

    public final String eG()
    {
        return accessToken;
    }

    public final boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj instanceof ast)
        {
            obj = (ast)obj;
            return endpoint.equals(((ast) (obj)).eF()) && accessToken.equals(((ast) (obj)).eG());
        } else
        {
            return false;
        }
    }

    public final int hashCode()
    {
        return (endpoint.hashCode() ^ 0xf4243) * 0xf4243 ^ accessToken.hashCode();
    }

    public final String toString()
    {
        return (new StringBuilder("AccessPoint{endpoint=")).append(endpoint).append(", accessToken=").append(accessToken).append("}").toString();
    }
}
