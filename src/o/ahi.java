// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.net.URI;
import java.net.URISyntaxException;
import retrofit.RetrofitError;
import retrofit.client.Response;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            ql, zu, atr, atn, 
//            FF6A, ahl, yv, agp

public abstract class ahi
    implements adx.if
{
    public static final class if extends Enum
    {

        private static final if blB[];
        public static final if blu;
        public static final if blv;
        public static final if blw;
        public static final if blx;
        public final boolean blA;
        public final boolean bly;
        public final boolean blz;

        public static if valueOf(String s)
        {
            return (if)Enum.valueOf(o/ahi$if, s);
        }

        public static if[] values()
        {
            return (if[])blB.clone();
        }

        static 
        {
            blu = new if("Subscribe", 0, false, true, true);
            blv = new if("Replay", 1, true, false, false);
            blw = new if("AutoReplay", 2, true, true, false);
            blx = new if("Summary", 3, true, false, true);
            blB = (new if[] {
                blu, blv, blw, blx
            });
        }

        private if(String s, int i, boolean flag, boolean flag1, boolean flag2)
        {
            super(s, i);
            bly = flag;
            blz = flag1;
            blA = flag2;
        }
    }

    /* member class not found */
    class _cls02CA {}


    protected final ApiManager bcW;
    protected final String bei;
    private ahl bgO;
    protected final _cls02CA blq;
    final if blr;
    private boolean bls;
    private atn blt;
    protected final yv mBroadcastCacheManager;
    private ql mEventBus;

    public ahi(_cls02CA _pcls02ca, ApiManager apimanager, ql ql1, String s, yv yv, ahl ahl, if if1)
    {
        blq = _pcls02ca;
        bcW = apimanager;
        mEventBus = ql1;
        bei = s;
        mBroadcastCacheManager = yv;
        bgO = ahl;
        blr = if1;
    }

    abstract void bM();

    abstract void bN();

    abstract float bO();

    public final void init()
    {
        bls = true;
        mEventBus._mth02CA(this, false, 0);
        bM();
    }

    public final void kill()
    {
        if (bls)
        {
            mEventBus.unregister(this);
            bls = false;
        }
    }

    public void onEventMainThread(zu zu1)
    {
        String s;
        atr atr1;
        atn atn1;
        String s1;
        static final class _cls1
        {

            static final int $SwitchMap$tv$periscope$android$event$ApiEvent$Type[];

            static 
            {
                $SwitchMap$tv$periscope$android$event$ApiEvent$Type = new int[zu.if.values().length];
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXz.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (_cls1..SwitchMap.tv.periscope.android.event.ApiEvent.Type[zu1.aXk.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            break;
        }
        boolean flag;
        if (zu1.aXl == null && zu1.mU == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_257;
        }
        atr1 = (atr)zu1.data;
        atn1 = atr1.fo();
        s1 = atn1.id();
        if (!s1.equals(bei))
        {
            break MISSING_BLOCK_LABEL_301;
        }
        s = atr1.fz();
        zu1 = s;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_185;
        }
        int ai[] = atr1.fJ();
        zu1 = s;
        if (ai == null)
        {
            break MISSING_BLOCK_LABEL_185;
        }
        zu1 = s;
        if (ai[0] <= 0)
        {
            break MISSING_BLOCK_LABEL_185;
        }
        URI uri = new URI(s);
        if ("rtmps".equalsIgnoreCase(uri.getScheme()))
        {
            zu1 = "PSPS:";
        } else
        {
            zu1 = "PSP:";
        }
        try
        {
            zu1 = (new StringBuilder()).append(zu1).append(uri.getSchemeSpecificPart()).toString();
        }
        // Misplaced declaration of an exception variable
        catch (zu zu1)
        {
            zu1.printStackTrace();
            zu1 = s;
        }
        if (!blq._mth02BC(zu1, atr1.fB(), atr1.fA()) && atn1.bDX)
        {
            blq._mth141D(2, null);
            return;
        } else
        {
            blq._mth02CB(atr1);
            bcW.getBroadcastViewers(atn1.fd(), s1);
            _mth02CA(atr1);
            return;
        }
        FF6A._mth02CA("VC", (new StringBuilder("Failed to load broadcast ")).append(zu1.aXl).toString());
        blq._mth141D(1, zu1.aXl.getResponse().getReason());
    }

    protected final void _mth02BC(atn atn1)
    {
        blt = atn1;
        blq._mth141D(atn1);
    }

    abstract void _mth02CA(agp agp);

    abstract void _mth02CA(atr atr1);

    protected final void _mth1483(String s)
    {
        bcW.getAccessChannel(s);
    }
}
