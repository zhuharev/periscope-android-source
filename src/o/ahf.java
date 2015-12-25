// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;
import android.widget.ImageView;

// Referenced classes of package o:
//            aqr, agp

final class ahf extends aqr
{

    private agp ble;

    ahf(agp agp1)
    {
        ble = agp1;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        agp._mth02D1(ble).setVisibility(8);
        if (agp._mth02BB(ble) != null && agp._mth02BB(ble).bly)
        {
            agp._mth02D1(ble).setImageBitmap(null);
        }
    }
}
