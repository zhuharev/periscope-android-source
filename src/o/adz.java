// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.google.android.exoplayer.ExoPlayer;

// Referenced classes of package o:
//            aad, adx

final class adz extends Thread
{

    private adx bgi;
    private aad bgj;

    adz(adx adx, aad aad1)
    {
        bgi = adx;
        bgj = aad1;
        super();
    }

    public final void run()
    {
        aad aad1 = bgj;
        aad1.aZa.cancel();
        aad1.aZe = 1;
        aad1.surface = null;
        aad1.aZb.release();
    }
}
