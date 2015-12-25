// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.security.MessageDigest;

// Referenced classes of package o:
//            FEAE

public final class _cls04BA
    implements FEAE
{

    private final String signature;

    public _cls04BA(String s)
    {
        if (s == null)
        {
            throw new NullPointerException("Signature cannot be null!");
        } else
        {
            signature = s;
            return;
        }
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
        } else
        {
            obj = (_cls04BA)obj;
            return signature.equals(((_cls04BA) (obj)).signature);
        }
    }

    public final int hashCode()
    {
        return signature.hashCode();
    }

    public final String toString()
    {
        return (new StringBuilder("StringSignature{signature='")).append(signature).append('\'').append('}').toString();
    }

    public final void _mth02CA(MessageDigest messagedigest)
    {
        messagedigest.update(signature.getBytes("UTF-8"));
    }
}
