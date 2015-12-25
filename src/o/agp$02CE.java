// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Handler;
import android.view.TextureView;
import android.widget.ImageView;
import com.google.android.exoplayer.ExoPlayer;

// Referenced classes of package o:
//            agp, adx, aad, ya, 
//            ahw, ahk, aib, arx, 
//            afw

final class <init>
    implements bject
{

    private agp ble;
    private int blo;

    public final void onStarted()
    {
        agp._mth02CE(ble, agp._mth02CF(ble, false));
        if (agp._mth02CF(ble) != null && agp._mth02CF(ble).bfL)
        {
            agp._mth02BE(ble).removeCallbacks(agp._mth1429(ble));
            agp._mth02CA(ble, false);
            agp._mth02BE(ble).removeCallbacks(agp._mth144A(ble));
            Object obj = agp._mth02CF(ble);
            obj.aVj = true;
            if (((adx) (obj)).aZr != null)
            {
                ((adx) (obj)).aZr.aZb.setPlayWhenReady(false);
            }
            agp._mth1540(ble).pause();
            agp._mth02CA(ble, agp._mth02CF(ble).bgg, 30L);
            agp._mth02C9(ble).setVisibility(8);
            obj = agp._mth0674(ble);
            ((ahw) (obj)).bml.clear();
            ((android.support.v7.widget.iew.if) (((ahw) (obj)).bml)).ey.notifyChanged();
            blo = agp._mth0674(ble).getVisibility();
            agp._mth0674(ble).setVisibility(8);
            agp._mth1D35(ble).setVisibility(8);
            agp.FE7A(ble).setVisibility(8);
            agp._mth06E5(ble).setDraggable(false);
        }
    }

    public final void onStopped()
    {
        agp._mth02CF(ble, false);
        agp._mth02CE(ble);
        agp._mth02C9(ble).setVisibility(0);
        agp._mth1D35(ble).setVisibility(blo);
        agp._mth0674(ble).setVisibility(blo);
        agp.FE7A(ble).setVisibility(0);
        agp._mth06E5(ble).setDraggable(true);
    }

    public final void _mth02B4(long l)
    {
        if (agp._mth02CF(ble) != null && agp._mth02CF(ble).aVj)
        {
            agp._mth02CE(ble, agp._mth02CF(ble, true));
            agp._mth02CA(ble, true, ble.getString(0x7f0600e3));
            adx adx1 = agp._mth02CF(ble);
            adx1.aVj = false;
            if (adx1.aZr != null)
            {
                adx1.aZr.aZb.seekTo(l);
            }
            return;
        } else
        {
            agp._mth02C8(ble).bT();
            return;
        }
    }

    private ew(agp agp1)
    {
        ble = agp1;
        super();
        blo = 0;
    }

    blo(agp agp1, byte byte0)
    {
        this(agp1);
    }
}
