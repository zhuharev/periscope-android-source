// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


public final class _cls0628
{

    public Class sk;
    public Class sl;

    public _cls0628()
    {
    }

    public _cls0628(Class class1, Class class2)
    {
        sk = class1;
        sl = class2;
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
        obj = (_cls0628)obj;
        if (!sk.equals(((_cls0628) (obj)).sk))
        {
            return false;
        }
        return sl.equals(((_cls0628) (obj)).sl);
    }

    public final int hashCode()
    {
        return sk.hashCode() * 31 + sl.hashCode();
    }

    public final String toString()
    {
        return (new StringBuilder("MultiClassKey{first=")).append(sk).append(", second=").append(sl).append('}').toString();
    }
}
