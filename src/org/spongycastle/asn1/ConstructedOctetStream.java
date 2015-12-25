// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.InputStream;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1StreamParser, ASN1OctetStringParser

class ConstructedOctetStream extends InputStream
{

    private final ASN1StreamParser Wv;
    private boolean Wy;
    private InputStream Wz;

    ConstructedOctetStream(ASN1StreamParser asn1streamparser)
    {
        Wy = true;
        Wv = asn1streamparser;
    }

    public int read()
    {
        if (Wz == null)
        {
            if (!Wy)
            {
                return -1;
            }
            ASN1OctetStringParser asn1octetstringparser = (ASN1OctetStringParser)Wv._mth068B();
            if (asn1octetstringparser == null)
            {
                return -1;
            }
            Wy = false;
            Wz = asn1octetstringparser._mth04CC();
        }
        do
        {
            int i = Wz.read();
            if (i >= 0)
            {
                return i;
            }
            ASN1OctetStringParser asn1octetstringparser1 = (ASN1OctetStringParser)Wv._mth068B();
            if (asn1octetstringparser1 == null)
            {
                Wz = null;
                return -1;
            }
            Wz = asn1octetstringparser1._mth04CC();
        } while (true);
    }

    public int read(byte abyte0[], int i, int j)
    {
        if (Wz == null)
        {
            if (!Wy)
            {
                return -1;
            }
            ASN1OctetStringParser asn1octetstringparser = (ASN1OctetStringParser)Wv._mth068B();
            if (asn1octetstringparser == null)
            {
                return -1;
            }
            Wy = false;
            Wz = asn1octetstringparser._mth04CC();
        }
        int l = 0;
        do
        {
            int k = Wz.read(abyte0, i + l, j - l);
            if (k >= 0)
            {
                int i1 = l + k;
                k = i1;
                l = k;
                if (i1 == j)
                {
                    return k;
                }
            } else
            {
                ASN1OctetStringParser asn1octetstringparser1 = (ASN1OctetStringParser)Wv._mth068B();
                if (asn1octetstringparser1 == null)
                {
                    Wz = null;
                    if (l <= 0)
                    {
                        return -1;
                    } else
                    {
                        return l;
                    }
                }
                Wz = asn1octetstringparser1._mth04CC();
            }
        } while (true);
    }
}
