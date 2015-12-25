// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;

import android.net.Uri;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;

// Referenced classes of package com.google.android.exoplayer.upstream:
//            UriDataSource, TransferListener, DataSpec

public final class UdpDataSource
    implements UriDataSource
{
    public static final class UdpDataSourceException extends IOException
    {

        public UdpDataSourceException(IOException ioexception)
        {
            super(ioexception);
        }

        public UdpDataSourceException(String s)
        {
            super(s);
        }
    }


    public static final int DEFAULT_MAX_PACKET_SIZE = 2000;
    private InetAddress address;
    private DataSpec dataSpec;
    private final TransferListener listener;
    private MulticastSocket multicastSocket;
    private boolean opened;
    private final DatagramPacket packet;
    private byte packetBuffer[];
    private int packetRemaining;
    private DatagramSocket socket;
    private InetSocketAddress socketAddress;

    public UdpDataSource(TransferListener transferlistener)
    {
        this(transferlistener, 2000);
    }

    public UdpDataSource(TransferListener transferlistener, int i)
    {
        listener = transferlistener;
        packetBuffer = new byte[i];
        packet = new DatagramPacket(packetBuffer, 0, i);
    }

    public final void close()
    {
        if (multicastSocket != null)
        {
            try
            {
                multicastSocket.leaveGroup(address);
            }
            catch (IOException ioexception) { }
            multicastSocket = null;
        }
        if (socket != null)
        {
            socket.close();
            socket = null;
        }
        address = null;
        socketAddress = null;
        packetRemaining = 0;
        if (opened)
        {
            opened = false;
            if (listener != null)
            {
                listener.onTransferEnd();
            }
        }
    }

    public final String getUri()
    {
        if (dataSpec == null)
        {
            return null;
        } else
        {
            return dataSpec.uri.toString();
        }
    }

    public final long open(DataSpec dataspec)
    {
        String s;
        int i;
        dataSpec = dataspec;
        dataspec = dataspec.uri.toString();
        s = dataspec.substring(0, dataspec.indexOf(':'));
        i = Integer.parseInt(dataspec.substring(dataspec.indexOf(':') + 1));
label0:
        {
            address = InetAddress.getByName(s);
            socketAddress = new InetSocketAddress(address, i);
            if (address.isMulticastAddress())
            {
                multicastSocket = new MulticastSocket(socketAddress);
                multicastSocket.joinGroup(address);
                socket = multicastSocket;
                break label0;
            }
            try
            {
                socket = new DatagramSocket(socketAddress);
            }
            // Misplaced declaration of an exception variable
            catch (DataSpec dataspec)
            {
                throw new UdpDataSourceException(dataspec);
            }
        }
        opened = true;
        if (listener != null)
        {
            listener.onTransferStart();
        }
        return -1L;
    }

    public final int read(byte abyte0[], int i, int j)
    {
        if (packetRemaining == 0)
        {
            try
            {
                socket.receive(packet);
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new UdpDataSourceException(abyte0);
            }
            packetRemaining = packet.getLength();
            if (listener != null)
            {
                listener.onBytesTransferred(packetRemaining);
            }
        }
        int k = packet.getLength();
        int l = packetRemaining;
        j = Math.min(packetRemaining, j);
        System.arraycopy(packetBuffer, k - l, abyte0, i, j);
        packetRemaining = packetRemaining - j;
        return j;
    }
}
