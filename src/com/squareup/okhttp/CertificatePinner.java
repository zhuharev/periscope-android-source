// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLPeerUnverifiedException;
import o.vq;
import o.vw;

public final class CertificatePinner
{
    public static final class Builder
    {

        private final Map hostnameToPins = new LinkedHashMap();

        public final transient Builder add(String s, String as[])
        {
            if (s == null)
            {
                throw new IllegalArgumentException("hostname == null");
            }
            ArrayList arraylist = new ArrayList();
            s = (List)hostnameToPins.put(s, Collections.unmodifiableList(arraylist));
            if (s != null)
            {
                arraylist.addAll(s);
            }
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                s = as[i];
                if (!s.startsWith("sha1/"))
                {
                    throw new IllegalArgumentException((new StringBuilder("pins must start with 'sha1/': ")).append(s).toString());
                }
                vw vw1 = vw._mth02E2(s.substring(5));
                if (vw1 == null)
                {
                    throw new IllegalArgumentException((new StringBuilder("pins must be base64: ")).append(s).toString());
                }
                arraylist.add(vw1);
            }

            return this;
        }

        public final CertificatePinner build()
        {
            return new CertificatePinner(this, null);
        }


        public Builder()
        {
        }
    }


    public static final CertificatePinner DEFAULT = (new Builder()).build();
    private final Map hostnameToPins;

    private CertificatePinner(Builder builder)
    {
        hostnameToPins = Util.immutableMap(builder.hostnameToPins);
    }

    CertificatePinner(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public static String pin(Certificate certificate)
    {
        if (!(certificate instanceof X509Certificate))
        {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        } else
        {
            return (new StringBuilder("sha1/")).append(vq._mth02BF(sha1((X509Certificate)certificate).data)).toString();
        }
    }

    private static vw sha1(X509Certificate x509certificate)
    {
        return Util.sha1(vw._mth02C9(x509certificate.getPublicKey().getEncoded()));
    }

    public final void check(String s, List list)
    {
        List list1 = (List)hostnameToPins.get(s);
        if (list1 == null)
        {
            return;
        }
        int i = 0;
        for (int j = list.size(); i < j; i++)
        {
            if (list1.contains(sha1((X509Certificate)list.get(i))))
            {
                return;
            }
        }

        StringBuilder stringbuilder = (new StringBuilder("Certificate pinning failure!")).append("\n  Peer certificate chain:");
        i = 0;
        for (int k = list.size(); i < k; i++)
        {
            X509Certificate x509certificate = (X509Certificate)list.get(i);
            stringbuilder.append("\n    ").append(pin(x509certificate)).append(": ").append(x509certificate.getSubjectDN().getName());
        }

        stringbuilder.append("\n  Pinned certificates for ").append(s).append(":");
        i = 0;
        for (int l = list1.size(); i < l; i++)
        {
            s = (vw)list1.get(i);
            stringbuilder.append("\n    sha1/").append(vq._mth02BF(((vw) (s)).data));
        }

        throw new SSLPeerUnverifiedException(stringbuilder.toString());
    }

    public final transient void check(String s, Certificate acertificate[])
    {
        check(s, Arrays.asList(acertificate));
    }

}
