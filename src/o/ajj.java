// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            aje, zw, yv, zc

final class ajj extends aje
{

    private final ApiManager bcW;

    public ajj(ApiManager apimanager, yv yv, zc zc, long l)
    {
        super(apimanager, yv, zc, 1000L);
        bcW = apimanager;
    }

    public final void cM()
    {
        bcW.getBroadcastMainGlobal();
    }

    public final void _mth02CA(boolean flag, zw zw1)
    {
        static final class _cls1
        {

            static final int bcB[];

            static 
            {
                bcB = new int[zw.values().length];
                try
                {
                    bcB[zw.aYL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (_cls1.bcB[zw1.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            break;
        }
        if (flag)
        {
            cL();
            return;
        } else
        {
            cK();
            return;
        }
    }
}
