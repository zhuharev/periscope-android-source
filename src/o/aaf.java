// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.google.android.exoplayer.MediaCodecAudioTrackRenderer;
import com.google.android.exoplayer.TrackRenderer;
import com.google.android.exoplayer.upstream.DefaultBandwidthMeter;
import java.net.URI;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

// Referenced classes of package o:
//            aph, FF6A, apa, aag, 
//            apg, aai, aah, aae, 
//            _cls0675, aad, adx

public final class aaf
    implements aad.aux, apa.if
{
    public static interface if
    {

        public abstract void Q();

        public abstract void _mth02CA(Map map, long l);
    }

    /* member class not found */
    class _cls02CA {}


    private aph aZA;
    private aph aZB;
    private long aZC;
    private long aZD;
    private aph aZE;
    long aZF;
    private long aZG;
    private long aZH;
    private long aZI;
    private long aZJ;
    private long aZK;
    private long aZL;
    private long aZM;
    private long aZN;
    public long aZO;
    private long aZP;
    public aph aZQ;
    public aph aZR;
    private final String aZq;
    private aad aZr;
    apa aZs;
    public aae aZt;
    public aai aZu;
    private if aZv;
    private Timer aZw;
    long aZx;
    private boolean aZy;
    long aZz;

    public aaf(String s, adx adx)
    {
        aZt = null;
        aZu = null;
        aZy = false;
        aZz = 0L;
        aZA = new aph();
        aZB = new aph();
        aZC = 0L;
        aZD = 0L;
        aZE = new aph();
        aZF = 0L;
        aZG = 0L;
        aZH = 0L;
        aZI = 0L;
        aZJ = 0L;
        aZK = 0L;
        aZL = 0L;
        aZM = 0L;
        aZN = 0L;
        aZO = 0L;
        aZP = 0L;
        aZQ = new aph();
        aZR = new aph();
        aZq = s;
        aZv = adx;
    }

    static void _mth02CA(aaf aaf1, long l)
    {
        aaf1;
        JVM INSTR monitorenter ;
        aaf1.aZH = aaf1.aZH + 1L;
        aaf1.aZI = aaf1.aZI + 1L;
        if (aaf1.aZP == 0L)
        {
            aaf1.aZP = System.currentTimeMillis();
            FF6A._mth02CB("RTMP", (new StringBuilder("Start to first packet: ")).append(aaf1.aZN - aaf1.aZM).toString());
            FF6A._mth02CB("RTMP", (new StringBuilder("Start to first frame: ")).append(aaf1.aZP - aaf1.aZM).toString());
        }
        if (aaf1.aZJ != 0L)
        {
            l = System.nanoTime() / 0xf4240L;
            aaf1.aZL = aaf1.aZL + (l - aaf1.aZJ);
            aaf1.aZJ = 0L;
        }
        aaf1;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void _mth1D65(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        aZx = 0L;
        aZz = System.currentTimeMillis();
        if (aZN == 0L)
        {
            aZN = aZz;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        if (aZC > 0L)
        {
            double d = aZz - aZC;
            aZB._mth02CE(d);
        }
        aZC = aZz;
        this;
        JVM INSTR monitorexit ;
        return;
        if (aZD > 0L)
        {
            double d1 = aZz - aZD;
            aZA._mth02CE(d1);
        }
        aZD = aZz;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final HashMap O()
    {
        Object obj = new HashMap();
        this;
        JVM INSTR monitorenter ;
        double d1 = aZL;
        double d = d1;
        long l;
        long l1;
        if (aZJ == 0L)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        l = System.nanoTime() / 0xf4240L;
        l1 = aZJ;
        d = d1 + (double)(l - l1);
        this;
        JVM INSTR monitorexit ;
          goto _L1
        obj;
        throw obj;
_L1:
        d /= 1000D;
        aZE._mth02CA(((HashMap) (obj)), "FrameRate");
        if (aZM > 0L && aZN > 0L)
        {
            ((HashMap) (obj)).put("StartToFirstPacket", Double.valueOf((double)(aZN - aZM) / 1000D));
            if (aZP > 0L)
            {
                ((HashMap) (obj)).put("StartToFirstFrame", Double.valueOf((double)(aZP - aZM) / 1000D));
            }
        }
        aZA._mth02CA(((HashMap) (obj)), "AudioJitter");
        aZB._mth02CA(((HashMap) (obj)), "VideoJitter");
        aZQ._mth02CA(((HashMap) (obj)), "AudioQueue");
        aZR._mth02CA(((HashMap) (obj)), "VideoQueue");
        if (aZs != null)
        {
            ((HashMap) (obj)).put("fmsVer", aZs.bxH);
        }
        ((HashMap) (obj)).put("LostConnection_count", Long.valueOf(aZK));
        ((HashMap) (obj)).put("LostConnection_duration", Double.valueOf(d));
        return ((HashMap) (obj));
    }

    boolean P()
    {
        boolean flag1 = false;
        long l = System.nanoTime() / 0xf4240L;
        this;
        JVM INSTR monitorenter ;
        boolean flag = flag1;
        if (aZG <= 0L)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        double d = (aZH * 1000L) / (l - aZG);
        aZE._mth02CE(d);
        FF6A._mth02CB("RTMP", (new StringBuilder("FPS: ")).append(d).toString());
        flag = flag1;
        if (aZH != 0L)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        if (aZJ != 0L)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        aZJ = l;
        aZK = aZK + 1L;
        flag = flag1;
        break MISSING_BLOCK_LABEL_147;
        flag = flag1;
        if (l - aZJ <= 9000L)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        FF6A._mth02CB("RTMP", "No video timeout");
        flag = true;
        aZG = l;
        aZH = 0L;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public final void cancel()
    {
    }

    public final void onClose()
    {
        FF6A._mth02CB("RTMP", "Unexpected close: reconnect");
        reconnect();
    }

    public final void onShutdown()
    {
        if (aZw != null)
        {
            aZw.cancel();
            aZw.purge();
            aZw = null;
        }
        FF6A._mth02CB("RTMP", (new StringBuilder("Frame rate: ")).append(aZE).toString());
        double d = ((double)aZF * 100D) / (double)(aZF + aZI);
        DecimalFormat decimalformat = new DecimalFormat("0.#");
        FF6A._mth02CB("RTMP", (new StringBuilder("Skipped %: ")).append(decimalformat.format(d)).toString());
        if (aZJ != 0L)
        {
            long l = System.nanoTime() / 0xf4240L;
            aZL = aZL + (l - aZJ);
        }
    }

    void reconnect()
    {
        if (aZs == null || !aZs.bxF)
        {
            break MISSING_BLOCK_LABEL_191;
        }
        String s1;
        Object obj;
        String s2;
        String s3;
        int i;
        obj = new URI(aZq);
        s2 = ((URI) (obj)).getScheme();
        s3 = ((URI) (obj)).getHost();
        i = ((URI) (obj)).getPort();
        s1 = ((URI) (obj)).getQuery();
        String s = s1;
        if (s1.startsWith("t="))
        {
            s = s1.substring(2);
        }
        obj = ((URI) (obj)).getPath();
        s1 = ((String) (obj));
        int j;
        if (((String) (obj)).charAt(0) == '/')
        {
            s1 = ((String) (obj)).substring(1);
        }
        j = s1.indexOf('/');
        if (j <= 0)
        {
            return;
        }
        obj = s1.substring(0, j);
        s1 = s1.substring(j + 1);
        if (i == 80)
        {
            try
            {
                if (s2.equalsIgnoreCase("rtmp"))
                {
                    aZs = new apa();
                    aZs.bxE = 0x2625a0L;
                    aZs._mth02CA("RTMPS", s3, 443, ((String) (obj)), s1, s, this);
                    return;
                }
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
        this;
        JVM INSTR monitorenter ;
        boolean flag = aZy;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        aZy = true;
        this;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception1;
        exception1;
        throw exception1;
_L1:
        aZv.Q();
        return;
    }

    public final void _mth02CA(aad aad1)
    {
        aZr = aad1;
        aZx = System.currentTimeMillis();
        aZM = aZx;
        aZN = 0L;
        aZw = new Timer();
        aZw.schedule(new aag(this), 3000L, 3000L);
        aZs = new apa();
        aZs.bxE = 0x2625a0L;
        aZs._mth02CA(aZq, this);
    }

    public final boolean _mth02CA(apg apg1)
    {
        if (apg1.byy == 18)
        {
            apg1 = ((apg) (apg1.byz));
            if (apg1 == null || apg1.length == 0)
            {
                return false;
            }
            if (((String)apg1[0]).equals("onMetaData") && aZu == null)
            {
                apg1 = (Map)apg1[1];
                Object aobj[] = (Object[])apg1.get("trackinfo");
                for (int i = 0; i < aobj.length; i++)
                {
                    Object obj = (Map)aobj[i];
                    Object obj1 = (String)((Map) (obj)).get("type");
                    if (((String) (obj1)).equals("video"))
                    {
                        obj = (String)((Map) (obj)).get("sprop-parameter-sets");
                        obj1 = (Double)apg1.get("width");
                        Double double2 = (Double)apg1.get("height");
                        aZu = new aai(i, -1, ((String) (obj)), ((Double) (obj1)).intValue(), double2.intValue(), aZv);
                        aZu._mth02CA(aZs);
                        continue;
                    }
                    if (((String) (obj1)).equals("audio"))
                    {
                        obj = (String)((Map) (obj)).get("config");
                        Double double1 = (Double)apg1.get("audiochannels");
                        Double double3 = (Double)apg1.get("audiosamplerate");
                        aZt = new aae(i, -1, ((String) (obj)), double1.intValue(), double3.intValue());
                        aZt._mth02CA(aZs);
                    }
                }

                if (aZu == null)
                {
                    apg1 = null;
                    _cls0675.log((new StringBuilder("Stream with no video encountered: ")).append(aZq).toString());
                } else
                {
                    apg1 = new _cls02CA(aZu, 1, 5000L, aZr.jT, aZr, 50);
                }
                MediaCodecAudioTrackRenderer mediacodecaudiotrackrenderer;
                if (aZt == null)
                {
                    mediacodecaudiotrackrenderer = null;
                    _cls0675._mth02CB(new Exception((new StringBuilder("Stream with no audio encountered: ")).append(aZq).toString()));
                } else
                {
                    mediacodecaudiotrackrenderer = new MediaCodecAudioTrackRenderer(aZt);
                }
                TrackRenderer atrackrenderer[] = new TrackRenderer[4];
                atrackrenderer[0] = apg1;
                atrackrenderer[1] = mediacodecaudiotrackrenderer;
                aZr._mth02CA(atrackrenderer, new DefaultBandwidthMeter());
            }
            break MISSING_BLOCK_LABEL_541;
        }
        if (apg1.byy != 9)
        {
            break MISSING_BLOCK_LABEL_510;
        }
        if (apg1.bxk == 0L)
        {
            break MISSING_BLOCK_LABEL_488;
        }
        this;
        JVM INSTR monitorenter ;
        if (aZO == 0L)
        {
            aZO = apg1.bxk;
        }
        this;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_488;
        apg1;
        throw apg1;
        if (aZu != null)
        {
            _mth1D65(true);
            aZu._mth02CB(apg1);
            return true;
        }
        break MISSING_BLOCK_LABEL_541;
        if (apg1.byy == 8 && aZt != null)
        {
            _mth1D65(false);
            aZt._mth02CB(apg1);
            return true;
        }
        return false;
    }

    public final void _mth309D(int i)
    {
        if (i > 0)
        {
            if (aZs.bxI)
            {
                String s1 = aZs.bxt;
                Object obj = aZs;
                if (((apa) (obj)).bwI == null || ((apa) (obj)).bwI.length() < 3)
                {
                    obj = "";
                } else
                {
                    obj = ((apa) (obj)).bwI.substring(2);
                }
                aZs._mth02BB("fast-play", new Object[] {
                    null, s1, Integer.valueOf(0), obj
                });
                return;
            }
            String s = aZs.bxt;
            aZs._mth02BB("play", new Object[] {
                null, s, Integer.valueOf(0)
            });
        }
    }
}
