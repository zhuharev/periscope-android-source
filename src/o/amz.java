// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            asn, ana, zs

public final class amz
    implements asn
{

    public amz()
    {
    }

    public static void _mth02CA(ana ana1, zp.if if1)
    {
        Resources resources = ana1.fy.getResources();
        static final class _cls1
        {

            static final int btC[];

            static 
            {
                btC = new int[zs.values().length];
                try
                {
                    btC[zs.aWX.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
                try
                {
                    btC[zs.aWY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    btC[zs.aWZ.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    btC[zs.aXa.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    btC[zs.aXb.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    btC[zs.aXc.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    btC[zs.aXd.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    btC[zs.aXe.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
            }
        }

        switch (_cls1.btC[if1.aWT.ordinal()])
        {
        case 1: // '\001'
            ana1.btD.setText(resources.getString(0x7f0600d6));
            return;

        case 2: // '\002'
            ana1.btD.setText(resources.getString(0x7f0600d7));
            return;

        case 3: // '\003'
            ana1.btD.setText(resources.getString(0x7f0600ec));
            return;

        case 4: // '\004'
            ana1.btD.setText(resources.getString(0x7f06004c));
            return;

        case 5: // '\005'
            ana1.btD.setText(resources.getString(0x7f0600cd));
            return;

        case 6: // '\006'
            ana1.btD.setText(resources.getString(0x7f0600cf));
            return;

        case 7: // '\007'
            ana1.btD.setText(resources.getString(0x7f0600cc));
            return;

        case 8: // '\b'
            ana1.btD.setText(resources.getString(0x7f06019a));
            return;
        }
        throw new UnsupportedOperationException("Unsupported user type!");
    }

    public final volatile void _mth02CA(android.support.v7.widget.RecyclerView._cls02CC _pcls02cc, PsUser psuser, int i)
    {
        _mth02CA((ana)_pcls02cc, (zp.if)psuser);
    }
}
