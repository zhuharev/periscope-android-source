// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package com.squareup.okhttp:
//            Authenticator, CertificatePinner

public final class Address
{

    final Authenticator authenticator;
    final CertificatePinner certificatePinner;
    final List connectionSpecs;
    final HostnameVerifier hostnameVerifier;
    final List protocols;
    final Proxy proxy;
    final ProxySelector proxySelector;
    final SocketFactory socketFactory;
    final SSLSocketFactory sslSocketFactory;
    final String uriHost;
    final int uriPort;

    public Address(String s, int i, SocketFactory socketfactory, SSLSocketFactory sslsocketfactory, HostnameVerifier hostnameverifier, CertificatePinner certificatepinner, Authenticator authenticator1, 
            Proxy proxy1, List list, List list1, ProxySelector proxyselector)
    {
        if (s == null)
        {
            throw new NullPointerException("uriHost == null");
        }
        if (i <= 0)
        {
            throw new IllegalArgumentException((new StringBuilder("uriPort <= 0: ")).append(i).toString());
        }
        if (authenticator1 == null)
        {
            throw new IllegalArgumentException("authenticator == null");
        }
        if (list == null)
        {
            throw new IllegalArgumentException("protocols == null");
        }
        if (proxyselector == null)
        {
            throw new IllegalArgumentException("proxySelector == null");
        } else
        {
            proxy = proxy1;
            uriHost = s;
            uriPort = i;
            socketFactory = socketfactory;
            sslSocketFactory = sslsocketfactory;
            hostnameVerifier = hostnameverifier;
            certificatePinner = certificatepinner;
            authenticator = authenticator1;
            protocols = Util.immutableList(list);
            connectionSpecs = Util.immutableList(list1);
            proxySelector = proxyselector;
            return;
        }
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof Address)
        {
            obj = (Address)obj;
            return Util.equal(proxy, ((Address) (obj)).proxy) && uriHost.equals(((Address) (obj)).uriHost) && uriPort == ((Address) (obj)).uriPort && Util.equal(sslSocketFactory, ((Address) (obj)).sslSocketFactory) && Util.equal(hostnameVerifier, ((Address) (obj)).hostnameVerifier) && Util.equal(certificatePinner, ((Address) (obj)).certificatePinner) && Util.equal(authenticator, ((Address) (obj)).authenticator) && Util.equal(protocols, ((Address) (obj)).protocols) && Util.equal(connectionSpecs, ((Address) (obj)).connectionSpecs) && Util.equal(proxySelector, ((Address) (obj)).proxySelector);
        } else
        {
            return false;
        }
    }

    public final Authenticator getAuthenticator()
    {
        return authenticator;
    }

    public final List getConnectionSpecs()
    {
        return connectionSpecs;
    }

    public final HostnameVerifier getHostnameVerifier()
    {
        return hostnameVerifier;
    }

    public final List getProtocols()
    {
        return protocols;
    }

    public final Proxy getProxy()
    {
        return proxy;
    }

    public final ProxySelector getProxySelector()
    {
        return proxySelector;
    }

    public final SocketFactory getSocketFactory()
    {
        return socketFactory;
    }

    public final SSLSocketFactory getSslSocketFactory()
    {
        return sslSocketFactory;
    }

    public final String getUriHost()
    {
        return uriHost;
    }

    public final int getUriPort()
    {
        return uriPort;
    }

    public final int hashCode()
    {
        int i;
        if (proxy != null)
        {
            i = proxy.hashCode();
        } else
        {
            i = 0;
        }
        int i1 = uriHost.hashCode();
        int j1 = uriPort;
        int j;
        if (sslSocketFactory != null)
        {
            j = sslSocketFactory.hashCode();
        } else
        {
            j = 0;
        }
        int k;
        if (hostnameVerifier != null)
        {
            k = hostnameVerifier.hashCode();
        } else
        {
            k = 0;
        }
        int l;
        if (certificatePinner != null)
        {
            l = certificatePinner.hashCode();
        } else
        {
            l = 0;
        }
        return (((((((((i + 527) * 31 + i1) * 31 + j1) * 31 + j) * 31 + k) * 31 + l) * 31 + authenticator.hashCode()) * 31 + protocols.hashCode()) * 31 + connectionSpecs.hashCode()) * 31 + proxySelector.hashCode();
    }
}
