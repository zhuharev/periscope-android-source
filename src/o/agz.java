// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Bitmap;
import android.widget.ImageView;

// Referenced classes of package o:
//            aoj, agp

public final class agz
    implements aoj
{

    private agp ble;

    agz(agp agp1)
    {
        ble = agp1;
        super();
    }

    public final void _mth02C8(Bitmap bitmap)
    {
        agp._mth02D1(ble).setVisibility(0);
        agp._mth02D1(ble).setAlpha(1.0F);
        agp._mth02D1(ble).setImageBitmap(bitmap);
    }
}
