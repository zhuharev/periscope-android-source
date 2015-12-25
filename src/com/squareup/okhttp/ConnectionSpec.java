// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

// Referenced classes of package com.squareup.okhttp:
//            CipherSuite, TlsVersion, Route, Address

public final class ConnectionSpec
{
    public static final class Builder
    {

        private String cipherSuites[];
        private boolean supportsTlsExtensions;
        private boolean tls;
        private String tlsVersions[];

        public final ConnectionSpec build()
        {
            return new ConnectionSpec(this, null);
        }

        public final transient Builder cipherSuites(CipherSuite aciphersuite[])
        {
            if (!tls)
            {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String as[] = new String[aciphersuite.length];
            for (int i = 0; i < aciphersuite.length; i++)
            {
                as[i] = aciphersuite[i].javaName;
            }

            cipherSuites = as;
            return this;
        }

        public final transient Builder cipherSuites(String as[])
        {
            if (!tls)
            {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (as == null)
            {
                cipherSuites = null;
                return this;
            } else
            {
                cipherSuites = (String[])as.clone();
                return this;
            }
        }

        public final Builder supportsTlsExtensions(boolean flag)
        {
            if (!tls)
            {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            } else
            {
                supportsTlsExtensions = flag;
                return this;
            }
        }

        public final transient Builder tlsVersions(TlsVersion atlsversion[])
        {
            if (!tls)
            {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String as[] = new String[atlsversion.length];
            for (int i = 0; i < atlsversion.length; i++)
            {
                as[i] = atlsversion[i].javaName;
            }

            tlsVersions = as;
            return this;
        }

        public final transient Builder tlsVersions(String as[])
        {
            if (!tls)
            {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (as == null)
            {
                tlsVersions = null;
                return this;
            } else
            {
                tlsVersions = (String[])as.clone();
                return this;
            }
        }





        public Builder(ConnectionSpec connectionspec)
        {
            tls = connectionspec.tls;
            cipherSuites = connectionspec.cipherSuites;
            tlsVersions = connectionspec.tlsVersions;
            supportsTlsExtensions = connectionspec.supportsTlsExtensions;
        }

        Builder(boolean flag)
        {
            tls = flag;
        }
    }


    public static final ConnectionSpec CLEARTEXT = (new Builder(false)).build();
    public static final ConnectionSpec COMPATIBLE_TLS;
    public static final ConnectionSpec MODERN_TLS;
    private final String cipherSuites[];
    final boolean supportsTlsExtensions;
    final boolean tls;
    private final String tlsVersions[];

    private ConnectionSpec(Builder builder)
    {
        tls = builder.tls;
        cipherSuites = builder.cipherSuites;
        tlsVersions = builder.tlsVersions;
        supportsTlsExtensions = builder.supportsTlsExtensions;
    }

    ConnectionSpec(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    private ConnectionSpec supportedSpec(SSLSocket sslsocket)
    {
        String as[] = null;
        if (cipherSuites != null)
        {
            as = sslsocket.getEnabledCipherSuites();
            as = (String[])Util.intersect(java/lang/String, cipherSuites, as);
        }
        sslsocket = sslsocket.getEnabledProtocols();
        sslsocket = (String[])Util.intersect(java/lang/String, tlsVersions, sslsocket);
        return (new Builder(this)).cipherSuites(as).tlsVersions(sslsocket).build();
    }

    final void apply(SSLSocket sslsocket, Route route)
    {
        ConnectionSpec connectionspec = supportedSpec(sslsocket);
        sslsocket.setEnabledProtocols(connectionspec.tlsVersions);
        String as[] = connectionspec.cipherSuites;
        String as1[] = as;
        if (route.shouldSendTlsFallbackIndicator)
        {
            as1 = as;
            if (Arrays.asList(sslsocket.getSupportedCipherSuites()).contains("TLS_FALLBACK_SCSV"))
            {
                if (as == null)
                {
                    as = sslsocket.getEnabledCipherSuites();
                }
                as1 = new String[as.length + 1];
                System.arraycopy(as, 0, as1, 0, as.length);
                as1[as1.length - 1] = "TLS_FALLBACK_SCSV";
            }
        }
        if (as1 != null)
        {
            sslsocket.setEnabledCipherSuites(as1);
        }
        Platform platform = Platform.get();
        if (connectionspec.supportsTlsExtensions)
        {
            platform.configureTlsExtensions(sslsocket, route.address.uriHost, route.address.protocols);
        }
    }

    public final List cipherSuites()
    {
        if (cipherSuites == null)
        {
            return null;
        }
        CipherSuite aciphersuite[] = new CipherSuite[cipherSuites.length];
        for (int i = 0; i < cipherSuites.length; i++)
        {
            aciphersuite[i] = CipherSuite.forJavaName(cipherSuites[i]);
        }

        return Util.immutableList(aciphersuite);
    }

    public final boolean equals(Object obj)
    {
        if (!(obj instanceof ConnectionSpec))
        {
            return false;
        }
        if (obj == this)
        {
            return true;
        }
        obj = (ConnectionSpec)obj;
        if (tls != ((ConnectionSpec) (obj)).tls)
        {
            return false;
        }
        if (tls)
        {
            if (!Arrays.equals(cipherSuites, ((ConnectionSpec) (obj)).cipherSuites))
            {
                return false;
            }
            if (!Arrays.equals(tlsVersions, ((ConnectionSpec) (obj)).tlsVersions))
            {
                return false;
            }
            if (supportsTlsExtensions != ((ConnectionSpec) (obj)).supportsTlsExtensions)
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        int i = 17;
        if (tls)
        {
            int j = Arrays.hashCode(cipherSuites);
            int k = Arrays.hashCode(tlsVersions);
            if (supportsTlsExtensions)
            {
                i = 0;
            } else
            {
                i = 1;
            }
            i = ((j + 527) * 31 + k) * 31 + i;
        }
        return i;
    }

    public final boolean isTls()
    {
        return tls;
    }

    public final boolean supportsTlsExtensions()
    {
        return supportsTlsExtensions;
    }

    public final List tlsVersions()
    {
        TlsVersion atlsversion[] = new TlsVersion[tlsVersions.length];
        for (int i = 0; i < tlsVersions.length; i++)
        {
            atlsversion[i] = TlsVersion.forJavaName(tlsVersions[i]);
        }

        return Util.immutableList(atlsversion);
    }

    public final String toString()
    {
        if (tls)
        {
            Object obj = cipherSuites();
            if (obj == null)
            {
                obj = "[use default]";
            } else
            {
                obj = obj.toString();
            }
            return (new StringBuilder("ConnectionSpec(cipherSuites=")).append(((String) (obj))).append(", tlsVersions=").append(tlsVersions()).append(", supportsTlsExtensions=").append(supportsTlsExtensions).append(")").toString();
        } else
        {
            return "ConnectionSpec()";
        }
    }

    static 
    {
        MODERN_TLS = (new Builder(true)).cipherSuites(new CipherSuite[] {
            CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_DSS_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, 
            CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA
        }).tlsVersions(new TlsVersion[] {
            TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0
        }).supportsTlsExtensions(true).build();
        COMPATIBLE_TLS = (new Builder(MODERN_TLS)).tlsVersions(new TlsVersion[] {
            TlsVersion.TLS_1_0
        }).supportsTlsExtensions(true).build();
    }


}
