// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.util.Enumeration;
import java.util.Hashtable;
import org.spongycastle.crypto.Digest;
import org.spongycastle.util.Shorts;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsHandshakeHash, DigestInputBuffer, TlsUtils, TlsContext, 
//            SecurityParameters, CombinedHash

class DeferredHash
    implements TlsHandshakeHash
{

    private DigestInputBuffer aAx;
    private Hashtable aAy;
    private Short aAz;
    private TlsContext azJ;

    DeferredHash()
    {
        aAx = new DigestInputBuffer();
        aAy = new Hashtable();
        aAz = null;
    }

    private DeferredHash(Short short1, Digest digest)
    {
        aAx = null;
        aAy = new Hashtable();
        aAz = short1;
        aAy.put(short1, digest);
    }

    private void _mth0710()
    {
        if (aAx != null && aAy.size() <= 4)
        {
            Digest digest;
            for (Enumeration enumeration = aAy.elements(); enumeration.hasMoreElements(); aAx._mth02CB(digest))
            {
                digest = (Digest)enumeration.nextElement();
            }

            aAx = null;
        }
    }

    public final int doFinal(byte abyte0[], int i)
    {
        throw new IllegalStateException("Use fork() to get a definite Digest");
    }

    public final void reset()
    {
        if (aAx != null)
        {
            aAx.reset();
            return;
        }
        for (Enumeration enumeration = aAy.elements(); enumeration.hasMoreElements(); ((Digest)enumeration.nextElement()).reset()) { }
    }

    public final void update(byte byte0)
    {
        if (aAx != null)
        {
            aAx.write(byte0);
            return;
        }
        for (Enumeration enumeration = aAy.elements(); enumeration.hasMoreElements(); ((Digest)enumeration.nextElement()).update(byte0)) { }
    }

    public final void update(byte abyte0[], int i, int j)
    {
        if (aAx != null)
        {
            aAx.write(abyte0, i, j);
            return;
        }
        for (Enumeration enumeration = aAy.elements(); enumeration.hasMoreElements(); ((Digest)enumeration.nextElement()).update(abyte0, i, j)) { }
    }

    public final void _mth02CB(short word0)
    {
        if (aAx == null)
        {
            throw new IllegalStateException("Too late to track more hash algorithms");
        }
        Short short1 = Shorts.valueOf(word0);
        if (!aAy.containsKey(short1))
        {
            org.spongycastle.crypto.ExtendedDigest extendeddigest = TlsUtils._mth02BD(short1.shortValue());
            aAy.put(short1, extendeddigest);
        }
    }

    public final byte[] _mth02CE(short word0)
    {
        Object obj = (Digest)aAy.get(Shorts.valueOf(word0));
        if (obj == null)
        {
            throw new IllegalStateException((new StringBuilder("HashAlgorithm ")).append(word0).append(" is not being tracked").toString());
        }
        obj = TlsUtils._mth02CA(word0, ((Digest) (obj)));
        if (aAx != null)
        {
            aAx._mth02CB(((Digest) (obj)));
        }
        byte abyte0[] = new byte[((Digest) (obj))._mth14AF()];
        ((Digest) (obj)).doFinal(abyte0, 0);
        return abyte0;
    }

    public final TlsHandshakeHash _mth05E1()
    {
        int i = azJ._mth03DC().aBg;
        if (i == 0)
        {
            CombinedHash combinedhash = new CombinedHash();
            combinedhash._mth02CA(azJ);
            aAx._mth02CB(combinedhash);
            return combinedhash._mth05E1();
        }
        aAz = Shorts.valueOf(TlsUtils._mth05E8(i));
        Short short1 = aAz;
        if (!aAy.containsKey(short1))
        {
            org.spongycastle.crypto.ExtendedDigest extendeddigest = TlsUtils._mth02BD(short1.shortValue());
            aAy.put(short1, extendeddigest);
        }
        return this;
    }

    public final void _mth05E3()
    {
        _mth0710();
    }

    public final TlsHandshakeHash _mth062A()
    {
        Object obj = TlsUtils._mth02CA(aAz.shortValue(), (Digest)aAy.get(aAz));
        if (aAx != null)
        {
            aAx._mth02CB(((Digest) (obj)));
        }
        obj = new DeferredHash(aAz, ((Digest) (obj)));
        obj.azJ = azJ;
        return ((TlsHandshakeHash) (obj));
    }

    public final Digest _mth067A()
    {
        _mth0710();
        if (aAx != null)
        {
            org.spongycastle.crypto.ExtendedDigest extendeddigest = TlsUtils._mth02BD(aAz.shortValue());
            aAx._mth02CB(extendeddigest);
            return extendeddigest;
        } else
        {
            return TlsUtils._mth02CA(aAz.shortValue(), (Digest)aAy.get(aAz));
        }
    }

    public final String _mth14AC()
    {
        throw new IllegalStateException("Use fork() to get a definite Digest");
    }

    public final int _mth14AF()
    {
        throw new IllegalStateException("Use fork() to get a definite Digest");
    }
}
