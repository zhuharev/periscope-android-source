// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import java.net.InetSocketAddress;
import java.net.Proxy;

// Referenced classes of package com.squareup.okhttp:
//            Address, ConnectionSpec

public final class Route
{

    final Address address;
    final ConnectionSpec connectionSpec;
    final InetSocketAddress inetSocketAddress;
    final Proxy proxy;
    final boolean shouldSendTlsFallbackIndicator;

    public Route(Address address1, Proxy proxy1, InetSocketAddress inetsocketaddress, ConnectionSpec connectionspec)
    {
        this(address1, proxy1, inetsocketaddress, connectionspec, false);
    }

    public Route(Address address1, Proxy proxy1, InetSocketAddress inetsocketaddress, ConnectionSpec connectionspec, boolean flag)
    {
        if (address1 == null)
        {
            throw new NullPointerException("address == null");
        }
        if (proxy1 == null)
        {
            throw new NullPointerException("proxy == null");
        }
        if (inetsocketaddress == null)
        {
            throw new NullPointerException("inetSocketAddress == null");
        }
        if (connectionspec == null)
        {
            throw new NullPointerException("connectionConfiguration == null");
        } else
        {
            address = address1;
            proxy = proxy1;
            inetSocketAddress = inetsocketaddress;
            connectionSpec = connectionspec;
            shouldSendTlsFallbackIndicator = flag;
            return;
        }
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof Route)
        {
            obj = (Route)obj;
            return address.equals(((Route) (obj)).address) && proxy.equals(((Route) (obj)).proxy) && inetSocketAddress.equals(((Route) (obj)).inetSocketAddress) && connectionSpec.equals(((Route) (obj)).connectionSpec) && shouldSendTlsFallbackIndicator == ((Route) (obj)).shouldSendTlsFallbackIndicator;
        } else
        {
            return false;
        }
    }

    public final Address getAddress()
    {
        return address;
    }

    public final ConnectionSpec getConnectionSpec()
    {
        return connectionSpec;
    }

    public final Proxy getProxy()
    {
        return proxy;
    }

    public final boolean getShouldSendTlsFallbackIndicator()
    {
        return shouldSendTlsFallbackIndicator;
    }

    public final InetSocketAddress getSocketAddress()
    {
        return inetSocketAddress;
    }

    public final int hashCode()
    {
        int j = address.hashCode();
        int k = proxy.hashCode();
        int l = inetSocketAddress.hashCode();
        int i1 = connectionSpec.hashCode();
        int i;
        if (shouldSendTlsFallbackIndicator)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        return ((((j + 527) * 31 + k) * 31 + l) * 31 + i1) * 31 + i;
    }

    public final boolean requiresTunnel()
    {
        return address.sslSocketFactory != null && proxy.type() == java.net.Proxy.Type.HTTP;
    }
}
