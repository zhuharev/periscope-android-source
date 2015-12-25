// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            zw, aji, akp

final class akr
{

    final ApiManager bcW;
    private final aji boY;
    boolean bpa;

    public akr(akp akp, ApiManager apimanager)
    {
        boY = akp;
        bcW = apimanager;
    }

    public final void onEventMainThread(zw zw1)
    {
        static final class _cls1
        {

            static final int bcB[];

            static 
            {
                bcB = new int[zw.values().length];
                try
                {
                    bcB[zw.aYF.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
                try
                {
                    bcB[zw.aYE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    bcB[zw.aYx.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    bcB[zw.aYy.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    bcB[zw.aYz.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    bcB[zw.aYA.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
            }
        }

        switch (_cls1.bcB[zw1.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (bpa)
            {
                boY.cS();
            } else
            {
                boY.cR();
            }
            boY.cI();
            return;

        case 2: // '\002'
            boY.cH();
            return;

        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
            boY.cG();
            return;
        }
    }
}
