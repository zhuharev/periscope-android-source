// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.util.encoders.Base64;

public class PEMUtil
{

    private final String aEB;
    private final String aEC;
    private final String aED;
    private final String aEE;

    PEMUtil(String s)
    {
        aEB = (new StringBuilder("-----BEGIN ")).append(s).append("-----").toString();
        aEC = (new StringBuilder("-----BEGIN X509 ")).append(s).append("-----").toString();
        aED = (new StringBuilder("-----END ")).append(s).append("-----").toString();
        aEE = (new StringBuilder("-----END X509 ")).append(s).append("-----").toString();
    }

    private static String _mth02CC(InputStream inputstream)
    {
        StringBuffer stringbuffer = new StringBuffer();
        int i;
        do
        {
            do
            {
                i = inputstream.read();
                if (i == 13 || i == 10 || i < 0)
                {
                    break;
                }
                if (i != 13)
                {
                    stringbuffer.append((char)i);
                }
            } while (true);
        } while (i >= 0 && stringbuffer.length() == 0);
        if (i < 0)
        {
            return null;
        } else
        {
            return stringbuffer.toString();
        }
    }

    final ASN1Sequence _mth02CD(InputStream inputstream)
    {
        StringBuffer stringbuffer = new StringBuffer();
        String s;
        do
        {
            s = _mth02CC(inputstream);
        } while (s != null && !s.startsWith(aEB) && !s.startsWith(aEC));
        do
        {
            String s1 = _mth02CC(inputstream);
            if (s1 == null || s1.startsWith(aED) || s1.startsWith(aEE))
            {
                break;
            }
            stringbuffer.append(s1);
        } while (true);
        if (stringbuffer.length() != 0)
        {
            inputstream = (new ASN1InputStream(Base64._mth1508(stringbuffer.toString())))._mth04B7();
            if (!(inputstream instanceof ASN1Sequence))
            {
                throw new IOException("malformed PEM data encountered");
            } else
            {
                return (ASN1Sequence)inputstream;
            }
        } else
        {
            return null;
        }
    }
}
