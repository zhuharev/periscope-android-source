// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.HashMap;
import java.util.List;

// Referenced classes of package o:
//            aic, abp, ata, auf, 
//            aug

public final class ahl
{
    public static interface if
    {

        public abstract void br();

        public abstract void bw();

        public abstract void bx();

        public abstract void _mth02BE(List list);

        public abstract void _mth02CA(String s, int i, boolean flag);

        public abstract void _mth02CA(auf auf1, boolean flag);

        public abstract void _mth02CB(auf auf1, boolean flag);

        public abstract void _mth02CE(auf auf1);

        public abstract void _mth02CF(auf auf1);

        public abstract void FB32(int i);
    }


    private if blM;
    private String blN;
    public HashMap blO;
    private boolean blP;
    private final aic blQ = new aic(25, 500, 4);

    public ahl(if if1, String s, boolean flag)
    {
        blO = new HashMap();
        blM = if1;
        blN = s;
        blP = flag;
    }

    public final void onEventMainThread(abp abp1)
    {
        if (abp1.bcz)
        {
            int i = Math.max(abp1.bcy - 1, 0);
            blM.FB32(i);
        }
        blM._mth02BE(abp1.bcx);
    }

    public final void onEventMainThread(ata ata1)
    {
        boolean flag;
        if (ata1.eP() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            int i = Math.max(ata1.eP() - 1, 0);
            blM.FB32(i);
        }
        blM._mth02BE(ata1.eQ());
    }

    public final void onEventMainThread(auf auf1)
    {
        static final class _cls1
        {

            static final int aUJ[];

            static 
            {
                aUJ = new int[aug.values().length];
                try
                {
                    aUJ[aug.bEL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
                try
                {
                    aUJ[aug.bEE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    aUJ[aug.bEB.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    aUJ[aug.bEz.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    aUJ[aug.bEA.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    aUJ[aug.bEO.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    aUJ[aug.bED.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    aUJ[aug.bEG.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    aUJ[aug.bEK.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    aUJ[aug.bEM.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
            }
        }

        switch (_cls1.aUJ[auf1.go().ordinal()])
        {
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            blM._mth02CE(auf1);
            return;

        case 5: // '\005'
            if (!blQ.cr())
            {
                blM._mth02CA(auf1, false);
            }
            if (!blN.equals(auf1.fd()))
            {
                blM._mth02CA(auf1.fd(), auf1.gp().intValue(), false);
            }
            return;

        case 6: // '\006'
            if (!blN.equals(auf1.fd()))
            {
                blM._mth02CB(auf1, false);
            }
            return;

        case 7: // '\007'
            blM.bw();
            return;

        case 8: // '\b'
            blM.bx();
            return;

        case 9: // '\t'
            blM._mth02CE(auf1);
            if (blN.equals(auf1.gz()))
            {
                blM._mth02CF(auf1);
            }
            return;

        case 10: // '\n'
            break;
        }
        if (blP)
        {
            if (blO.containsKey(auf1.gC()))
            {
                blO.put(auf1.gC(), Integer.valueOf(((Integer)blO.get(auf1.gC())).intValue() + 1));
            } else
            {
                blO.put(auf1.gC(), Integer.valueOf(1));
            }
            blM.br();
        }
    }
}
