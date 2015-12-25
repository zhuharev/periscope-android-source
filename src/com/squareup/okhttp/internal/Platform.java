// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import com.squareup.okhttp.Protocol;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import o.vr;

// Referenced classes of package com.squareup.okhttp.internal:
//            OptionalMethod, Util, Internal

public class Platform
{
    static class Android extends Platform
    {

        private final OptionalMethod getAlpnSelectedProtocol;
        private final OptionalMethod setAlpnProtocols;
        private final OptionalMethod setHostname;
        private final OptionalMethod setUseSessionTickets;
        private final Method trafficStatsTagSocket;
        private final Method trafficStatsUntagSocket;

        public void configureTlsExtensions(SSLSocket sslsocket, String s, List list)
        {
            if (s != null)
            {
                setUseSessionTickets.invokeOptionalWithoutCheckedException(sslsocket, new Object[] {
                    Boolean.valueOf(true)
                });
                setHostname.invokeOptionalWithoutCheckedException(sslsocket, new Object[] {
                    s
                });
            }
            if (setAlpnProtocols != null && setAlpnProtocols.isSupported(sslsocket))
            {
                s = concatLengthPrefixed(list);
                setAlpnProtocols.invokeWithoutCheckedException(sslsocket, new Object[] {
                    s
                });
            }
        }

        public void connectSocket(Socket socket, InetSocketAddress inetsocketaddress, int i)
        {
            try
            {
                socket.connect(inetsocketaddress, i);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Socket socket)
            {
                inetsocketaddress = new IOException("Exception in connect");
            }
            inetsocketaddress.initCause(socket);
            throw inetsocketaddress;
        }

        public String getSelectedProtocol(SSLSocket sslsocket)
        {
            if (getAlpnSelectedProtocol == null)
            {
                return null;
            }
            if (!getAlpnSelectedProtocol.isSupported(sslsocket))
            {
                return null;
            }
            sslsocket = (byte[])getAlpnSelectedProtocol.invokeWithoutCheckedException(sslsocket, new Object[0]);
            if (sslsocket != null)
            {
                return new String(sslsocket, Util.UTF_8);
            } else
            {
                return null;
            }
        }

        public void tagSocket(Socket socket)
        {
            if (trafficStatsTagSocket == null)
            {
                return;
            }
            try
            {
                trafficStatsTagSocket.invoke(null, new Object[] {
                    socket
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Socket socket)
            {
                throw new RuntimeException(socket);
            }
            // Misplaced declaration of an exception variable
            catch (Socket socket)
            {
                throw new RuntimeException(socket.getCause());
            }
        }

        public void untagSocket(Socket socket)
        {
            if (trafficStatsUntagSocket == null)
            {
                return;
            }
            try
            {
                trafficStatsUntagSocket.invoke(null, new Object[] {
    