// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.concurrent.Semaphore;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;

// Referenced classes of package o:
//            ape

final class apf
    implements HandshakeCompletedListener
{

    private Semaphore bym;
    private ape byn;

    apf(ape ape, Semaphore semaphore)
    {
        byn = ape;
        bym = semaphore;
        super();
    }

    public final void handshakeCompleted(HandshakeCompletedEvent handshakecompletedevent)
    {
        bym.release();
    }
}
