// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;

import java.util.Enumeration;
import java.util.Hashtable;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.util.Integers;

public class SkeinParameters
    implements CipherParameters
{
    public static class Builder
    {

        public Hashtable axJ;

        public final Builder _mth1D63(byte abyte0[])
        {
            if (abyte0 == null)
            {
                throw new IllegalArgumentException("Parameter value must not be null.");
            } else
            {
                axJ.put(Integers.valueOf(0), abyte0);
                return this;
            }
        }

        public Builder()
        {
            axJ = new Hashtable();
        }

        public Builder(Hashtable hashtable)
        {
            axJ = new Hashtable();
            Integer integer;
            for (Enumeration enumeration = hashtable.keys(); enumeration.hasMoreElements(); axJ.put(integer, hashtable.get(integer)))
            {
                integer = (Integer)enumeration.nextElement();
            }

        }
    }


    public Hashtable axJ;

    public SkeinParameters()
    {
        this(new Hashtable());
    }

    private SkeinParameters(Hashtable hashtable)
    {
        axJ = hashtable;
    }

    public SkeinParameters(Hashtable hashtable, byte byte0)
    {
        this(hashtable);
    }
}
