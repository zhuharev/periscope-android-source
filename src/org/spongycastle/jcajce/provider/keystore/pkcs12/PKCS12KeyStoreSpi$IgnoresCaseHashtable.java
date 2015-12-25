// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.keystore.pkcs12;

import java.util.Hashtable;
import org.spongycastle.util.Strings;

// Referenced classes of package org.spongycastle.jcajce.provider.keystore.pkcs12:
//            PKCS12KeyStoreSpi

static class <init>
{

    Hashtable aFp;
    private Hashtable aFq;

    public final Object get(String s)
    {
        Hashtable hashtable = aFq;
        if (s == null)
        {
            s = null;
        } else
        {
            s = Strings.FE91(s);
        }
        s = (String)hashtable.get(s);
        if (s == null)
        {
            return null;
        } else
        {
            return aFp.get(s);
        }
    }

    public final void put(String s, Object obj)
    {
        String s1;
        if (s == null)
        {
            s1 = null;
        } else
        {
            s1 = Strings.FE91(s);
        }
        String s2 = (String)aFq.get(s1);
        if (s2 != null)
        {
            aFp.remove(s2);
        }
        aFq.put(s1, s);
        aFp.put(s, obj);
    }

    public final Object remove(String s)
    {
        Hashtable hashtable = aFq;
        if (s == null)
        {
            s = null;
        } else
        {
            s = Strings.FE91(s);
        }
        s = (String)hashtable.remove(s);
        if (s == null)
        {
            return null;
        } else
        {
            return aFp.remove(s);
        }
    }

    private ()
    {
        aFp = new Hashtable();
        aFq = new Hashtable();
    }

    aFq(byte byte0)
    {
        this();
    }
}
