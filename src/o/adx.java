// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.view.OrientationEventListener;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.exoplayer.ExoPlayer;
import com.google.android.exoplayer.extractor.mp4.Mp4Extractor;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            aph, aaa, ady, aos, 
//            adz, aad, FF6A, aaf, 
//            aai, aeb, aac, aab, 
//            apb, aah, aea, agp

public final class adx
    implements aad._cls02CF, aad.if, aad._cls02CA, android.view.TextureView.SurfaceTextureListener, aaf.if
{
    public static interface if
    {

        public abstract void bn();

        public abstract void bo();

        public abstract void bp();

        public abstract void bq();

        public abstract void onError(Exception exception);

        public abstract void _mth02B3(long l);

        public abstract void FE7E(boolean flag);
    }

    /* member class not found */
    class _cls02CA {}


    boolean aVj;
    private PsUser aWS;
    aad aZr;
    private Surface baE;
    int bfE;
    String bfF;
    private boolean bfG;
    boolean bfH;
    boolean bfI;
    boolean bfJ;
    private boolean bfK;
    boolean bfL;
    private boolean bfM;
    private long bfN;
    private TextureView bfO;
    private _cls02CA bfP;
    private aad.aux bfQ;
    private int bfR;
    private aph bfS;
    private long bfT;
    private long bfU;
    private long bfV;
    private aph bfW;
    double bfX;
    private boolean bfY;
    private double bfZ;
    private double bga;
    private ady bgb;
    private int bgc;
    private int bgd;
    private aaa bge;
    private int bgf;
    int bgg;
    private Handler bgh;
    Context mContext;

    public adx(agp agp, PsUser psuser, TextureView textureview, agp agp1)
    {
        bfR = 0;
        bfS = new aph();
        bfT = 0L;
        bfU = 0L;
        bfV = 0L;
        bfW = new aph();
        bfY = false;
        bfZ = 0.0D;
        bga = 0.0D;
        bgc = 0;
        bgd = 0;
        bge = new aaa();
        bgh = new Handler();
        mContext = agp.getApplicationContext();
        bfP = new _cls02CA(agp1);
        bfO = textureview;
        textureview.setSurfaceTextureListener(this);
        if (textureview.isAvailable())
        {
            bfJ = true;
            baE = new Surface(textureview.getSurfaceTexture());
        }
        aWS = psuser;
        if (bgb == null)
        {
            bgb = new ady(this, agp, 3);
            if (bgb.canDetectOrientation())
            {
                bgb.enable();
            } else
            {
                bgb = null;
            }
        }
        bgf = (int)((float)aos._mth02B2(mContext).y * 0.15F);
    }

    private void bh()
    {
        if (bfO != null)
        {
            bfO.setRotation(0.0F);
        }
        if (aZr != null)
        {
            (new adz(this, aZr)).start();
            aZr.aZd.remove(this);
            aad aad1 = aZr;
            aaa aaa1 = bge;
            aad1.aZd.remove(aaa1);
            aZr.aZm = null;
            aZr.aZl = null;
            aZr.aZj = null;
            aZr.aZk = null;
            aZr = null;
        }
    }

    private void bi()
    {
        this;
        JVM INSTR monitorenter ;
        if (bfU != 0L)
        {
            bfT = bfT + (System.currentTimeMillis() - bfU);
            bfU = 0L;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void bj()
    {
        this;
        JVM INSTR monitorenter ;
        if (bfV != 0L)
        {
            double d = System.currentTimeMillis() - bfV;
            bfT = (long)((double)bfT - d);
            d /= 1000D;
            bfW._mth02CE(d);
            bfV = 0L;
            FF6A._mth02CB("RTMP", "Stall recovered");
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void bk()
    {
        if (bfO != null && bgc > 0 && bgd > 0)
        {
            double d = bfZ;
            if (!bfY)
            {
                d = 0.0D;
            }
            _mth02CA(bfO, d, bgc, bgd);
        }
    }

    static double _mth02CA(adx adx1, double d)
    {
        adx1.bga = d;
        return d;
    }

    private void _mth02CA(TextureView textureview, double d, int i, int j)
    {
        int l = bfO.getWidth();
        int k = bfO.getHeight();
        int i1 = l;
        int k1 = k;
        float f = (float)j / (float)i;
        int j2 = (int)(45D + d) / 90;
        if ((j2 & 1) == 1)
        {
            f = (float)i / (float)j;
            i1 = k;
            k1 = l;
        }
        boolean flag1 = false;
        if ((float)k / (float)l < 1.0F)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (f < 1.0F)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        boolean flag;
        if (i == j)
        {
            i = k;
            int i2 = l;
            j = i2;
            flag = flag1;
            if (_cls141D.if._mth02CB(mContext))
            {
                i = (int)((float)l * f);
                j = i2;
                flag = flag1;
            }
        } else
        if ((float)k > (float)i1 * f)
        {
            flag = true;
            j = l;
            i = (int)((float)l * f);
        } else
        {
            i = k;
            j = (int)((float)k / f);
            flag = flag1;
        }
        f = (float)j / (float)i1;
        float f1 = (float)i / (float)k1;
        Matrix matrix = new Matrix();
        matrix.setRotate((float)j2 * 90F, l / 2, k / 2);
        if ((j2 & 1) == 1)
        {
            int j1 = (k - l) / 2;
            int l1 = (l - k) / 2;
            matrix.postTranslate(j1, l1);
        }
        matrix.postScale(f, f1);
        j = (l - j) / 2;
        i = (k - i) / 2;
        matrix.postTranslate(j, i);
        if (flag)
        {
            matrix.postTranslate(0.0F, -bgf);
        }
        textureview.setTransform(matrix);
        bgg = j2;
    }

    static void _mth02CA(adx adx1)
    {
        adx1.bk();
    }

    static boolean _mth02CA(adx adx1, boolean flag)
    {
        adx1.bfL = false;
        return false;
    }

    static void _mth02CB(adx adx1)
    {
        adx1.bfP.sendEmptyMessage(5);
    }

    static void _mth02CB(adx adx1, double d)
    {
        adx1.bfY = true;
        adx1.bfZ = d;
        adx1.bk();
    }

    static void _mth02CE(adx adx1)
    {
        adx1.bh();
    }

    static boolean _mth02CF(adx adx1)
    {
        return adx1.bfH;
    }

    static void _mth141D(adx adx1)
    {
        adx1.bf();
    }

    private static String _mth1D38(Context context)
    {
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        String s;
        try
        {
            s = context.getPackageName();
            s = context.getPackageManager().getPackageInfo(s, 0).versionName;
        }
        // Misplaced declaration of an exception variable
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            s = "?";
        }
        return context.getString(0x7f0601a9, new Object[] {
            s, android.os.Build.VERSION.RELEASE, "ExoPlayerLib/1.5.0"
        });
    }

    private void FF70(long l)
    {
        if (bfL)
        {
            return;
        }
        if (aZr == null)
        {
            return;
        } else
        {
            bfL = true;
            bfP.sendEmptyMessage(1);
            bfX = 0.0D;
            aZr.aZb.seekTo(l);
            return;
        }
    }

    public final HashMap O()
    {
        HashMap hashmap = new HashMap();
        if (bfQ != null && (bfQ instanceof aaf))
        {
            aaf aaf1 = (aaf)bfQ;
            hashmap.putAll(aaf1.O());
            bfS._mth02CA(hashmap, "Latency");
            bi();
            bj();
            double d1 = (double)bfT / 1000D;
            hashmap.put("DurationWatched", Double.valueOf(d1));
            hashmap.put("StallCount", Integer.valueOf(bfR));
            bfW._mth02CA(hashmap, "StallDuration");
            if (bfT > 0L)
            {
                double d = bfR;
                if (bfR > 1)
                {
                    d = (double)bfR / (d1 / 60D);
                }
                hashmap.put("StallsPerMinute", Double.valueOf(d));
            }
            int i;
            if (aaf1.aZu instanceof aai)
            {
                i = ((aai)aaf1.aZu).baf;
            } else
            {
                i = 0;
            }
            if (i > 0)
            {
                hashmap.put("KeyframeInterval", Double.valueOf(d1 / (double)i));
            }
            FF6A._mth02CB("RTMP", (new StringBuilder("Playback stats: ")).append(hashmap).toString());
        }
        if (bfE == 3)
        {
            FF6A._mth02CB("RTMP", (new StringBuilder("HLS Stalls: ")).append(bfR).toString());
            hashmap.put("HLSStalls", Integer.valueOf(bfR));
        }
        return hashmap;
    }

    public final void Q()
    {
        if (bfH)
        {
            return;
        } else
        {
            bfP.post(new aeb(this));
            return;
        }
    }

    void bf()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        if (aZr != null)
        {
            break MISSING_BLOCK_LABEL_244;
        }
        bfK = true;
        obj = _mth1D38(mContext);
        bfE;
        JVM INSTR tableswitch 0 4: default 309
    //                   0 71
    //                   1 60
    //                   2 118
    //                   3 82
    //                   4 102;
           goto _L1 _L2 _L3 _L1 _L4 _L5
_L3:
        throw new UnsupportedOperationException("unsupported type ss");
_L2:
        throw new UnsupportedOperationException("unsupported type dash");
_L4:
        obj = new aac(mContext, ((String) (obj)), bfF);
        break; /* Loop/switch isn't completed */
_L5:
        obj = new aaf(bfF, this);
        break; /* Loop/switch isn't completed */
_L1:
        obj = new aab(mContext, ((String) (obj)), Uri.parse(bfF), new Mp4Extractor());
        bfQ = ((aad.aux) (obj));
        aZr = new aad(bfQ);
        aZr.aZd.add(this);
        aZr.aZj = this;
        aZr.aZk = this;
        bge.aYV = SystemClock.elapsedRealtime();
        obj = aZr;
        aaa aaa1 = bge;
        ((aad) (obj)).aZd.add(aaa1);
        aZr.aZm = bge;
        aZr.aZl = bge;
        if (bfK)
        {
            aZr.prepare();
            bfK = false;
        }
        aad aad1 = aZr;
        aad1.surface = baE;
        if (aad1.aZh != null)
        {
            aad1.aZb.sendMessage(aad1.aZh, 1, aad1.surface);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void bg()
    {
        bfU = 0L;
        bfT = 0L;
        aph aph1 = bfW;
        aph1.byB = 0;
        aph1.byC = 0.0D;
        aph1.byD = 0.0D;
        aph1.byE = 0.0D;
        aph1.byF = 0.0D;
        aph1 = bfS;
        aph1.byB = 0;
        aph1.byC = 0.0D;
        aph1.byD = 0.0D;
        aph1.byE = 0.0D;
        aph1.byF = 0.0D;
        bfR = 0;
        bfT = 0L;
    }

    public final void bl()
    {
        bfH = true;
        if (aZr != null)
        {
            aZr.aZb.stop();
        }
        bfP.sendEmptyMessage(2);
    }

    public final boolean bm()
    {
        return aZr != null && (aZr.getPlaybackState() == 3 || aZr.getPlaybackState() == 2);
    }

    public final void onError(Exception exception)
    {
        exception = bfP.obtainMessage(6, exception);
        bfP.sendMessage(exception);
        bfK = true;
    }

    public final void onPlayerSeekComplete()
    {
        aZr.aZb.setPlayWhenReady(true);
        if (bfU == 0L)
        {
            bfU = System.currentTimeMillis();
        }
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfacetexture, int i, int j)
    {
        if (!bfJ)
        {
            bfJ = true;
            baE = new Surface(surfacetexture);
            float f = 1.0F;
            float f1 = 1.0F;
            if (_cls141D.if._mth02CB(mContext))
            {
                f1 = ((float)i * 1.775F) / (float)j;
            } else
            {
                f = ((float)j * 0.5633803F) / (float)i;
            }
            surfacetexture = new Matrix();
            surfacetexture.setScale(f, f1, j / 2, i / 2);
            bfO.setTransform(surfacetexture);
        }
        if (!bfI)
        {
            return;
        } else
        {
            bf();
            return;
        }
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfacetexture)
    {
        return false;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfacetexture, int i, int j)
    {
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfacetexture)
    {
    }

    public final void release()
    {
        bfH = true;
        bh();
        if (bfO != null)
        {
            bfO.setSurfaceTextureListener(null);
            bfO = null;
        }
        if (bgb != null)
        {
            bgb.disable();
            bgb = null;
        }
        bfQ = null;
    }

    public final void _mth02CA(int i, int j, float f)
    {
        bgd = j;
        bgc = i;
    }

    public final void _mth02CA(Map map, long l)
    {
        double d;
        double d2;
        double d3;
        double d4;
        aaf aaf1;
        long l1;
        if (map == null)
        {
            return;
        }
        if (map.get("ntp") == null)
        {
            return;
        }
        d = ((Double)map.get("ntp")).doubleValue();
        if (aZr != null)
        {
            l1 = aZr.getCurrentPosition();
        } else
        {
            l1 = 0L;
        }
        d2 = (double)(l - l1) / 1000D;
        bfX = d - d2;
        d3 = apb.ec().getTime();
        d4 = (d3 / 1000D + 2208988800D) - bfX;
        if (l1 > 0L)
        {
            bfS._mth02CE(d4);
        }
        if (!(bfQ instanceof aaf))
        {
            break MISSING_BLOCK_LABEL_389;
        }
        aaf1 = (aaf)bfQ;
        long l3 = l1;
        aaf1;
        JVM INSTR monitorenter ;
        long l2;
        l2 = l3;
        if (l3 != 0L)
        {
            break MISSING_BLOCK_LABEL_177;
        }
        l2 = l3;
        if (aaf1.aZO != 0L)
        {
            l2 = aaf1.aZO;
        }
        aaf1;
        JVM INSTR monitorexit ;
          goto _L1
        map;
        throw map;
_L1:
        if (aaf1.aZt != null)
        {
            long l4 = aaf1.aZt.getBufferedPositionUs();
            double d5 = l4 / 1000L - l2;
            FF6A._mth02CB("RTMP", (new StringBuilder("Audio queue: ")).append((long)d5).append("ms (").append(l4 / 1000L).append("/").append(l2).append(")").toString());
            aaf1.aZQ._mth02CE(d5 / 1000D);
        }
        if (aaf1.aZu != null)
        {
            long l5 = aaf1.aZu.getBufferedPositionUs();
            double d6 = l5 / 1000L - l2;
            FF6A._mth02CB("RTMP", (new StringBuilder("Video queue: ")).append((long)d6).append("ms (").append(l5 / 1000L).append("/").append(l2).append(")").toString());
            aaf1.aZR._mth02CE(d6 / 1000D);
        }
        Object obj = new DecimalFormat("0.###");
        ((DecimalFormat) (obj)).format(d4);
        ((DecimalFormat) (obj)).format(d2);
        ((DecimalFormat) (obj)).format(d);
        obj = new Date((long)((bfX - 2208988800D) * 1000D));
        (new StringBuilder("Capture: ")).append(obj).append(" now: ").append(new Date((long)d3));
        if (map.get("rotation") != null)
        {
            bfY = true;
            double d1 = ((Double)map.get("rotation")).doubleValue();
            FF6A._mth02CB("RTMP", (new StringBuilder("Broadcast ")).append(d1).append(" degrees").toString());
            l -= l1;
            if (l > 0L)
            {
                bgh.postDelayed(new aea(this, d1), l);
                return;
            }
            bfY = true;
            bfZ = d1;
            bk();
        }
        return;
    }

    public final void _mth02CB(boolean flag, int i)
    {
        if (aZr == null)
        {
            return;
        }
        i;
        JVM INSTR tableswitch 3 5: default 36
    //                   3 109
    //                   4 37
    //                   5 90;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L3:
        bj();
        bfG = true;
        android.os.Message message = bfP.obtainMessage(4, Boolean.valueOf(flag));
        bfP.sendMessage(message);
        if (bfM)
        {
            bfM = false;
            FF70(bfN);
            return;
        } else
        {
            return;
        }
_L4:
        bi();
        bfL = false;
        bfP.sendEmptyMessage(2);
        return;
_L2:
        this;
        JVM INSTR monitorenter ;
        if (bfV == 0L && bfU != 0L)
        {
            bfV = System.currentTimeMillis();
            bfR = bfR + 1;
            FF6A._mth02CB("RTMP", "Stall");
        }
        this;
        JVM INSTR monitorexit ;
          goto _L5
        Exception exception;
        exception;
        throw exception;
_L5:
        bfP.sendEmptyMessage(5);
        return;
    }

    public final void _mth02CF(Map map)
    {
        if (map.get("TIT3") != null)
        {
            double d = Double.parseDouble(new String((byte[])map.get("TIT3")));
            if (bfX != d)
            {
                bfX = d;
                long l = (long)((bfX - 2208988800D) * 1000D);
                android.os.Message message = bfP.obtainMessage(7, Long.valueOf(l));
                bfP.sendMessage(message);
            }
        }
        if (map.get("TKEY") != null)
        {
            double d1 = Double.parseDouble(new String((byte[])map.get("TKEY")));
            bfY = true;
            bfZ = d1;
            bk();
        }
    }

    public final void FE7A(long l)
    {
        if (bfL)
        {
            return;
        }
        if (bfM)
        {
            return;
        }
        bfM = true;
        bfN = l;
        bfP.sendEmptyMessage(3);
        if (bfG)
        {
            FF70(l);
        }
    }
}
