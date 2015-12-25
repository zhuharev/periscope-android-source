// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.location.Location;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.util.SparseArray;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.codahale.metrics.Counter;
import com.codahale.metrics.Snapshot;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationSettingsResult;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import tv.periscope.android.api.ApiManager;
import tv.periscope.android.api.ChatStats;
import tv.periscope.android.api.GetBroadcastShareUrlResponse;
import tv.periscope.android.api.PsUser;
import tv.periscope.android.api.PublishBroadcastResponse;
import tv.periscope.android.api.UploadTestResponse;
import tv.periscope.android.signer.SignerService;

// Referenced classes of package o:
//            ada, xt, zz, aev, 
//            dj, yc, adf, aee, 
//            ael, aek, aov, aou, 
//            abj, abk, FF6A, abc, 
//            xl, aef, aec, ats, 
//            adw, xx, apb, auf, 
//            xw, agp, adk, aeg, 
//            aug, wr, ahw, ahk, 
//            arm, arx, acv, abm, 
//            yg, yi, afn, ans, 
//            ann, aop, adh, xf, 
//            aui, xd, zp, aos, 
//            aoo, aem, aen, aeu, 
//            aeo, xu, xv, art, 
//            aqf, aep, zs, anq, 
//            apk, acp, qe, aib, 
//            adl, aex, aav, ahl, 
//            yo, xm, aeq, adu, 
//            ack, aak, arc, arv, 
//            _cls0675, acj, afp, afo, 
//            ql, aer, yd, adj, 
//            aqc, ev, aet, abl, 
//            yb, zu, atn, acb, 
//            acd, acn, aox, aeh, 
//            aes, agi, zw, atw, 
//            bb, ba, _cls09AA, aai, 
//            apa, apg, api, apd, 
//            aph, aok, aiy, aip, 
//            aix, aej, qh, aei, 
//            zd, yv, zx, xk

public class aed extends ada
    implements xl.if, xt, aov._cls02CA, android.view.View.OnClickListener, ahl.if, zz, aev, afn.if, aak.if, dj, yc, adf, aoo.if
{
    final class if
        implements android.content.DialogInterface.OnClickListener
    {

        private aed bhH;
        private final boolean mCancel;

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            if (mCancel)
            {
                bhH.finish();
                return;
            } else
            {
                aed._mth02CA(bhH, true);
                return;
            }
        }

        if(boolean flag)
        {
            bhH = aed.this;
            super();
            mCancel = flag;
        }
    }

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}


    private static final String bah[] = {
        "android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.RECORD_AUDIO"
    };
    private static final int bgp[] = {
        0, 3, 2, 1
    };
    private SharedPreferences aQC;
    private MediaFormat aTD;
    private aav aTi;
    private xx aUX;
    private xw aVa;
    private PsUser aWS;
    private aqf bdJ;
    private String bei;
    private Location bfB;
    private boolean bgA;
    private boolean bgB;
    private View bgC;
    private View bgD;
    private Button bgE;
    private EditText bgF;
    private ats bgG;
    private int bgH;
    private String bgI;
    private boolean bgJ;
    private ans bgK;
    private afn bgL;
    private aak bgM;
    private aec bgN;
    private ahl bgO;
    private boolean bgP;
    private int bgQ;
    private boolean bgR;
    private boolean bgS;
    private yg bgT;
    private aib bgU;
    private ahw bgV;
    private final _cls02CA bgW = new _cls02CA((byte)0);
    private final Semaphore bgX = new Semaphore(1, true);
    private View bgY;
    private aeq bgZ;
    private abc bgq;
    private aoo bgr;
    private boolean bgs;
    private arx bgt;
    private xl bgu;
    private aov bgv;
    private aou bgw;
    private HashMap bgx;
    private boolean bgy;
    private boolean bgz;
    private double bhA;
    private int bhB;
    private final HashSet bhC = new HashSet();
    private final int bhD = 5000;
    private long bhE;
    Handler bhF;
    private aek bhG;
    private adu bha;
    private atn bhb;
    private adj bhc;
    private adw bhd;
    private TextView bhe;
    private agi bhf;
    private adl bhg;
    private aep bhh;
    private anq bhi;
    private _cls02CB bhj;
    private View bhk;
    private Typeface bhl;
    private Typeface bhm;
    private boolean bhn;
    private MediaFormat bho;
    private String bhp;
    private adh bhq;
    private long bhr;
    private long bhs;
    private int bht;
    private final aee bhu = new aee(this);
    private final ael bhv = new ael(this);
    private aeu bhw;
    private xu bhx;
    private View bhy;
    private aer bhz;
    private yv mBroadcastCacheManager;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private zp mUserManager;

    public aed()
    {
        bgs = false;
        bgx = new HashMap();
        bgy = false;
        bgz = false;
        bhj = new _cls02CB();
        bhr = 0L;
        bhs = 0L;
        bhE = 0L;
        bhF = new Handler();
        bhG = new aek(this);
    }

    private HashMap O()
    {
        HashMap hashmap = new HashMap();
        if (bgv != null)
        {
            hashmap.putAll(bgv.O());
        }
        if (bgw != null)
        {
            hashmap.putAll(bgw.O());
        }
        return hashmap;
    }

    private void bs()
    {
        Object obj = abj.if.al();
        abc abc1 = bgq;
        ((abj) (obj)).bcc.remove(abc1.getName(), abc1);
        obj = bgq;
        FF6A.ma.compareAndSet(obj, null);
        bgq.close();
    }

    private void bt()
    {
        if (bgu == null)
        {
            return;
        }
        boolean flag;
        if (bgu.FB24() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            bgq.log("Flip to rear facing camera");
        } else
        {
            bgq.log("Flip to front facing camera");
        }
        (new aef(this, bhB)).start();
    }

    private boolean bu()
    {
        return bgN != null && bgN.bgm && _cls141D.if._mth02CA(bfB);
    }

    private void bv()
    {
        Object obj;
        ats ats1;
        int i;
        boolean flag;
        boolean flag1;
label0:
        {
            ats1 = bgG;
            if (bgz)
            {
                obj = ats1.fQ();
                i = ats1.fR();
            } else
            {
                obj = ats1.fL();
                i = ats1.fM();
            }
            flag1 = false;
            if (bgv != null)
            {
                flag1 = true;
                bhF.removeCallbacks(bhG);
                aov aov1 = bgv;
                bgv = null;
                aov1.shutdown();
            }
            if (bgG != null)
            {
                int ai[] = bgG.fJ();
                if (ai != null && ai[0] > 0)
                {
                    flag = true;
                    break label0;
                }
            }
            flag = false;
        }
        String s = ((String) (obj));
        if (flag)
        {
            if ("rtmps".equalsIgnoreCase(((String) (obj))))
            {
                s = "PSPS";
            } else
            {
                s = "PSP";
            }
        }
        bgq.log((new StringBuilder("Setting up RTMP with ")).append(s).append(", wasRunning was ").append(flag1).toString());
        obj = new aov(s, ats1.host(), i, ats1.fN(), ats1.fO(), ats1.fP());
        obj.bwr = this;
        ((aov) (obj))._mth02CA(bgx, false, false);
        if (!flag1 || aTD == null || bho == null)
        {
            break MISSING_BLOCK_LABEL_276;
        }
        ((aov) (obj))._mth02CA(aTD, bho);
        bgu.FB38();
        obj;
        JVM INSTR monitorenter ;
        obj.bwA = 0L;
        obj.bwz = 0L;
        obj;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_276;
        Exception exception;
        exception;
        throw exception;
        bgv = ((aov) (obj));
        bhF.postDelayed(bhG, 5000L);
        return;
    }

    private void by()
    {
        if (bu())
        {
            if (bgI == null || aVa == null)
            {
                FF6A._mth02CA("RTMP", "channel not set up yet!");
                return;
            }
            if (bhd != null)
            {
                adw adw1 = bhd;
                Location location = bfB;
                if (adw1.bfB != null && !adw1.bfB.equals(location))
                {
                    adw1.bfB = location;
                }
                bhd.A();
                ((android.support.v7.widget.RecyclerView.if) (bhc)).ey.notifyChanged();
            }
            auf auf1 = auf._mth02CA(aUX.aUj, apb.ec().getTime(), apb.ec().getTime(), Double.valueOf(bfB.getLatitude()), Double.valueOf(bfB.getLongitude()));
            aVa._mth02CA(bgI, auf1);
        }
    }

    static int[] bz()
    {
        return bgp;
    }

    private void _mth0269(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag1 = bgR;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        bgR = true;
        this;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L1:
        if (bgJ)
        {
            if (bgP)
            {
                auf auf1 = auf._mth02CA(aUX.aUj, apb.ec().getTime(), apb.ec().getTime());
                aVa._mth02CA(bgI, auf1);
            }
            ApiManager apimanager = ApiManager.get(this);
            String s1 = bei;
            String s;
            if (bgs)
            {
                s = bgq.getName();
            } else
            {
                s = null;
            }
            apimanager.endBroadcast(s1, s);
        }
        _mth4E41();
        if (bgJ)
        {
            if (flag)
            {
                startActivity((new Intent(this, o/agp)).putExtra("e_b_id", bei).putExtra("e_p_mode", ahi.if.blx).putExtra("e_saved", bhg.ba()).putExtra("e_saved_file", bhp), ActivityOptions.makeCustomAnimation(this, 0x7f04000e, 0x7f04000c).toBundle());
                bgS = true;
            }
            if (bgP)
            {
                aVa._mth02CA(aUX);
                bgP = false;
            }
            aVa.kill();
        }
        finish();
        return;
    }

    static ApiManager _mth02B3(aed aed1)
    {
        return ApiManager.get(aed1);
    }

    static long _mth02B4(aed aed1)
    {
        return aed1.bhr;
    }

    private void _mth02B5(boolean flag)
    {
        if (bgu != null)
        {
            bgx.put("bps", Integer.valueOf(bgu._mth722B()));
        }
        bgx.put("UploadRate", Integer.valueOf(bgw.bvQ << 3));
        bgx.put("live", Boolean.valueOf(bgy));
        if (bhz != null)
        {
            bgx.put("rotation", Double.valueOf(bhA));
        }
        if (bgv != null)
        {
            bgv._mth02CA(bgx, flag, false);
        }
    }

    static double _mth02B9(aed aed1)
    {
        return aed1.bhA;
    }

    static View _mth02BB(aed aed1)
    {
        return aed1.bhy;
    }

    static aib _mth02BC(aed aed1)
    {
        return aed1.bgU;
    }

    static ahw _mth02BD(aed aed1)
    {
        return aed1.bgV;
    }

    static xx _mth02BE(aed aed1)
    {
        return aed1.aUX;
    }

    static xw _mth02BF(aed aed1)
    {
        return aed1.aVa;
    }

    static long _mth02C6(aed aed1)
    {
        return aed1.bhs;
    }

    static long _mth02C7(aed aed1)
    {
        return aed1.bhE;
    }

    static void _mth02C8(aed aed1)
    {
        aed1.mHandler.postDelayed(aed1.bgZ, TimeUnit.SECONDS.toMillis(5L));
    }

    static adu _mth02C9(aed aed1)
    {
        return aed1.bha;
    }

    static int _mth02CA(aed aed1, double d)
    {
        return ((int)(45D + d) / 90) % 4;
    }

    static long _mth02CA(aed aed1, long l)
    {
        aed1.bhr = l;
        return l;
    }

    static Animator _mth02CA(aed aed1, View view)
    {
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(view, "alpha", new float[] {
            0.0F, 1.0F
        });
        android.view.animation.Interpolator interpolator;
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            interpolator = AnimationUtils.loadInterpolator(aed1, 0x10c000e);
        } else
        {
            interpolator = AnimationUtils.loadInterpolator(aed1, 0x10c0003);
        }
        objectanimator.setInterpolator(interpolator);
        objectanimator.addListener(new aeg(aed1, view));
        return objectanimator;
    }

    private void _mth02CA(aec aec1)
    {
        bgN = aec1;
        android.content.SharedPreferences.Editor editor = aQC.edit();
        editor.putBoolean((String)yp.CON._mth02CA("o.yp").getField("aVX").get(null), aec1.bgo);
        editor.putBoolean((String)yp.CON._mth02CA("o.yp").getField("aVV").get(null), aec1.bgm);
        editor.putBoolean((String)yp.CON._mth02CA("o.yp").getField("aVW").get(null), aec1.bgn);
        editor.apply();
    }

    static void _mth02CA(aed aed1, int i)
    {
        aed1.bhB = i;
        aed1._mth30FD(i);
    }

    static void _mth02CA(aed aed1, String s, String s1, String s2)
    {
        Object obj = aed1.aUX.aUj;
        long l = apb.ec().getTime();
        long l1 = apb.ec().getTime();
        Object obj1 = new aud.if();
        obj1.bEx = Integer.valueOf(0);
        obj = ((auf.if) (obj1))._mth02CB(Integer.valueOf(2))._mth02CB(aug.bEK)._mth0407(((String) (obj)));
        obj1 = wr._mth05D9(l);
        s = ((auf.if) (obj))._mth0640(BigInteger.valueOf(((wr) (obj1)).VE >>> 32 & 0xffffffffL).multiply(BigInteger.valueOf(0x100000000L)).add(BigInteger.valueOf(((wr) (obj1)).VE & 0xffffffffL)))._mth0630(UUID.randomUUID().toString())._mth02CB(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())))._mth14BC(s2)._mth14D1(s)._mth1506(s1);
        s1 = wr._mth05D9(l1);
        s = s._mth1427(BigInteger.valueOf(((wr) (s1)).VE >>> 32 & 0xffffffffL).multiply(BigInteger.valueOf(0x100000000L)).add(BigInteger.valueOf(((wr) (s1)).VE & 0xffffffffL))).gG();
        aed1.aVa._mth02CA(aed1.bgI, s);
        aed1 = aed1.bgV;
        ((ahw) (aed1)).bml._mth141D(s);
        int i = ((ahw) (aed1)).bml.getItemCount();
        ((ahw) (aed1)).bmk._mth1507(i - 1);
    }

    static void _mth02CA(aed aed1, boolean flag)
    {
        aed1._mth0269(flag);
    }

    static void _mth02CA(aed aed1, boolean flag, int i, Typeface typeface)
    {
        aed1._mth02CA(true, 0x7f06006e, typeface);
    }

    private void _mth02CA(boolean flag, int i, Typeface typeface)
    {
        bgE.setEnabled(flag);
        bgE.setText(i);
        bgE.setTypeface(typeface);
        bgE.setAllCaps(flag);
    }

    static double _mth02CB(aed aed1, double d)
    {
        aed1.bhA = d;
        return d;
    }

    static long _mth02CB(aed aed1, long l)
    {
        aed1.bhs = 0L;
        return 0L;
    }

    static void _mth02CB(aed aed1)
    {
        aed1.bgt.setSystemUiVisibility(1);
    }

    static void _mth02CB(aed aed1, int i)
    {
        aed1._mth30FD(i);
    }

    static void _mth02CB(aed aed1, boolean flag)
    {
        aed1._mth02B5(flag);
    }

    static arx _mth02CC(aed aed1)
    {
        return aed1.bgt;
    }

    static adh _mth02CD(aed aed1)
    {
        return aed1.bhq;
    }

    static long _mth02CE(aed aed1, long l)
    {
        aed1.bhE = l;
        return l;
    }

    static Runnable _mth02CE(aed aed1)
    {
        return aed1.bgZ;
    }

    private void _mth02CE(boolean flag, int i)
    {
        (new android.app.AlertDialog.Builder(this)).setMessage(getString(i)).setPositiveButton(getString(0x7f0600bd), new if(flag)).setNegativeButton(getString(0x7f0600bb), null).show();
    }

    static boolean _mth02CE(aed aed1, boolean flag)
    {
        aed1.bgB = true;
        return true;
    }

    static Handler _mth02CF(aed aed1)
    {
        return aed1.mHandler;
    }

    static Runnable _mth02D1(aed aed1)
    {
        return aed1.bhu;
    }

    static aou _mth02E1(aed aed1)
    {
        return aed1.bgw;
    }

    static HashMap _mth02EE(aed aed1)
    {
        return aed1.bgx;
    }

    static void _mth037A(aed aed1)
    {
        aed1.bgt.setSystemUiVisibility(0);
    }

    static aov _mth0559(aed aed1)
    {
        return aed1.bgv;
    }

    static int _mth05D9(aed aed1)
    {
        return aed1.bhB;
    }

    static void _mth0640(aed aed1)
    {
        aed1.bt();
    }

    static Semaphore _mth0674(aed aed1)
    {
        return aed1.bgX;
    }

    static View _mth141D(aed aed1)
    {
        return aed1.bgY;
    }

    static String _mth1427(aed aed1)
    {
        return aed1.bei;
    }

    static ApiManager _mth1428(aed aed1)
    {
        return ApiManager.get(aed1);
    }

    static boolean _mth1D35(aed aed1)
    {
        return aed1.bhn;
    }

    static Typeface _mth1D4E(aed aed1)
    {
        return aed1.bhm;
    }

    static int _mth1D54(aed aed1)
    {
        int i = aed1.bgQ;
        aed1.bgQ = i + 1;
        return i;
    }

    static zp _mth1D62(aed aed1)
    {
        return aed1.mUserManager;
    }

    public static Intent _mth1FBE(Activity activity)
    {
        if (!_cls141D.if._mth02CA(activity, bah))
        {
            activity = (new Intent(activity, o/acv)).putExtra("permissions", bah).putExtra("layout", 0x7f03002f).putExtra("start_intent", new Intent(activity, o/aed));
            activity.setFlags(0x10000);
            return activity;
        } else
        {
            return new Intent(activity, o/aed);
        }
    }

    static boolean _mth1FBE(aed aed1)
    {
        return aed1.bgP;
    }

    static int _mth2071(aed aed1)
    {
        return aed1.bgH;
    }

    private void _mth30FD(int i)
    {
        if (bgu != null)
        {
            boolean flag = false;
            switch (i)
            {
            default:
                i = ((flag) ? 1 : 0);
                break;

            case 0: // '\0'
                i = 0;
                break;

            case 1: // '\001'
                i = 90;
                break;

            case 2: // '\002'
                i = 180;
                break;

            case 3: // '\003'
                i = 270;
                break;
            }
            bgu._mth1D32(i);
        }
    }

    private void _mth4E41()
    {
        bgy = false;
        mHandler.removeCallbacks(bgW);
        if (bgu != null)
        {
            _mth02B5(true);
            bhF.removeCallbacks(bhG);
            bgw.dL();
            if (bgv != null)
            {
                bgv.shutdown();
            }
            if (bhp != null && bhg.bb())
            {
                bhg._mth05D6(bei);
            }
            bgu.stopPreview();
            bgu._mth4E41();
            HashMap hashmap = O();
            FF6A._mth02CB("RTMP", (new StringBuilder("Broadcast stats: ")).append(hashmap).toString());
            HashMap hashmap1 = new HashMap();
            Object obj = abm.ar();
            hashmap1.put("pubnub_total_sent", Integer.valueOf(abm.an()));
            hashmap1.put("pubnub_total_received", Integer.valueOf(abm.ap()));
            hashmap1.put("pubnub_total_presence", Integer.valueOf(abm.aq()));
            hashmap1.put("pubnub_signer_dropped", Integer.valueOf(abm.am()));
            hashmap1.put("pubnub_unreceived", Integer.valueOf(abm.ao()));
            hashmap1.put("pubnub_ltnc_mean", Double.valueOf(((Snapshot) (obj)).getMean()));
            hashmap1.put("pubnub_ltnc_median", Double.valueOf(((Snapshot) (obj)).getMedian()));
            hashmap1.put("pubnub_ltnc_min", Long.valueOf(((Snapshot) (obj)).getMin()));
            hashmap1.put("pubnub_ltnc_max", Long.valueOf(((Snapshot) (obj)).getMax()));
            hashmap1.put("pubnub_ltnc_stddev", Double.valueOf(((Snapshot) (obj)).getStdDev()));
            hashmap1.put("pubnub_ltnc_p95", Double.valueOf(((Snapshot) (obj)).get95thPercentile()));
            hashmap1.put("pubnub_ltnc_p99", Double.valueOf(((Snapshot) (obj)).get99thPercentile()));
            hashmap1.put("channel_chats_dropped", Integer.valueOf(bgT.FEDB()));
            hashmap1.put("channel_hearts_dropped", Integer.valueOf(bgT.FF4B()));
            obj = new HashMap();
            ((HashMap) (obj)).put("n_screenshots", Integer.valueOf(bgQ));
            ChatStats chatstats = aVa.FED0();
            if (chatstats != null)
            {
                chatstats.pubnubFiltered = ((Counter)bgT.aUH.aUR.get(1)).getCount();
                chatstats.chatManFiltered = ((Counter)bgT.aUH.aUR.get(2)).getCount();
            }
            ApiManager.get(this).broadcastMeta(bei, hashmap, hashmap1, ((HashMap) (obj)), chatstats);
            abm.as();
        }
    }

    static HashSet FE73(aed aed1)
    {
        return aed1.bhC;
    }

    static String FE76(aed aed1)
    {
        return aed1.bgI;
    }

    static boolean FE7A(aed aed1)
    {
        return aed1.bgR;
    }

    static String FF70(aed aed1)
    {
        if (aed1.bgs)
        {
            return aed1.bgq.getName();
        } else
        {
            return null;
        }
    }

    static xl FF9E(aed aed1)
    {
        return aed1.bgu;
    }

    public final long J()
    {
        return 0L;
    }

    public final long K()
    {
        throw new UnsupportedOperationException("Attempted getTotalDuration on live broadcast");
    }

    public final long L()
    {
        return 0L;
    }

    protected final String aI()
    {
        return "Create Broadcast";
    }

    public final void br()
    {
        ((android.support.v7.widget.RecyclerView.if) (bgV.bml)).ey.notifyChanged();
    }

    public final void bw()
    {
    }

    public final void bx()
    {
    }

    public final long getCurrentTimeMillis()
    {
        return apb.ec().getTime();
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i == 100)
        {
            switch (j)
            {
            case 0: // '\0'
                bgL._mth02B8(true);
                return;

            default:
                bgL._mth02B8(false);
                break;
            }
        }
    }

    public void onBackPressed()
    {
        if (bgK.buH)
        {
            ans ans1 = bgK;
            if (ans1.buD && ans1.buC != 0)
            {
                ans1.dy();
                return;
            }
            ans1.buG.bul.dj();
            ((android.support.v7.widget.RecyclerView.if) (ans1.buG)).ey.notifyChanged();
            ans1.FBE7(ans1.buG.bul.dl().size());
            EditText edittext = ans1.buw;
            if (edittext != null)
            {
                ((InputMethodManager)edittext.getContext().getSystemService("input_method")).hideSoftInputFromWindow(edittext.getWindowToken(), 0);
            }
            if (ans1.buF != null)
            {
                ans1.buF._mth1FBE(ans.biB);
            }
            ans1.aN();
            return;
        }
        if (bhq.aO())
        {
            bhq.dC();
            return;
        }
        if (arx._mth1424(bha))
        {
            bgt._mth14A2(bha);
            return;
        }
        if (bgJ)
        {
            _mth02CE(false, 0x7f0600c2);
            return;
        }
        if (bgF.getText().length() > 0)
        {
            _mth02CE(true, 0x7f0600c1);
            return;
        } else
        {
            super.onBackPressed();
            overridePendingTransition(0x7f04000a, 0x7f04000f);
            return;
        }
    }

    public final void onCancel()
    {
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131558554: 
            bgt._mth02BD(bhw);
            return;

        case 2131558508: 
            bgt._mth02BD(bha);
            return;

        case 2131558557: 
            onBackPressed();
            return;

        case 2131558562: 
            _mth02CA(false, 0x7f0601a7, bhl);
            Object obj = bgL.bH();
            _mth02CA(((aec) (obj)));
            boolean flag1 = bu();
            float f;
            float f1;
            if (flag1)
            {
                f = (float)bfB.getLatitude();
                f1 = (float)bfB.getLongitude();
            } else
            {
                f = 0.0F;
                f1 = 0.0F;
            }
            view = bgF.getText().toString();
            ArrayList arraylist = bgL.bG();
            boolean flag;
            if (!arraylist.isEmpty())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            boolean flag2 = ((aec) (obj)).bgn;
            bgA = ((aec) (obj)).bgo;
            if (bgA)
            {
                xf._mth02CA(xf.if.aSn);
            } else
            {
                xf._mth02CA(xf.if.aSo);
            }
            obj = new HashMap();
            ((HashMap) (obj)).put("has_text", String.valueOf(aui._mth02BF(view)));
            ((HashMap) (obj)).put("is_private", String.valueOf(flag));
            ((HashMap) (obj)).put("is_follower_only_chat", String.valueOf(flag2));
            ((HashMap) (obj)).put("share_twitter_enabled", String.valueOf(bgA));
            xf._mth02CA(xf.if.aSm, ((HashMap) (obj)));
            ApiManager.get(this).publishBroadcast(bei, view, arraylist, flag1, f, f1, flag2);
            if (aQC.getBoolean((String)yp.CON._mth02CA("o.yp").getField("aVY").get(null), true))
            {
                aQC.edit().putBoolean((String)yp.CON._mth02CA("o.yp").getField("aVY").get(null), false).apply();
                return;
            }
            break;

        case 2131558548: 
            if (arx._mth1424(bhw))
            {
                xf._mth02CA(xf.if.aSr);
                bgq.log("Stop Broadcast pressed");
                _mth0269(true);
                return;
            }
            break;

        case 2131558547: 
            if (arx._mth1424(bhw))
            {
                xf._mth02CA(xf.if.aSt);
                bt();
                return;
            }
            break;

        case 2131558565: 
            bgt._mth02BD(bha);
            break;
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        int i = getWindowManager().getDefaultDisplay().getRotation();
        bhB = i;
        _mth30FD(i);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03002c);
        getWindow().setBackgroundDrawable(null);
        bundle = getWindow();
        bundle.addFlags(128);
        Object obj = bundle.getAttributes();
        obj.rotationAnimation = 1;
        bundle.setAttributes(((android.view.WindowManager.LayoutParams) (obj)));
        bhB = getWindowManager().getDefaultDisplay().getRotation();
        aVa = new xw(_cls30CE.if._mth02CB(this), _cls30CE.if._mth02CF(this));
        mBroadcastCacheManager = xd._mth216D();
        mUserManager = xd._mth1FEA();
        aWS = mUserManager.H();
        aQC = PreferenceManager.getDefaultSharedPreferences(this);
        bundle = (new StringBuilder("BroadcasterActivity")).append(System.currentTimeMillis()).toString();
        obj = getFilesDir();
        bgq = new abc(new abd.if(bundle, "broadcaster_log", ".txt", (new StringBuilder()).append(((File) (obj)).getAbsolutePath()).append(File.separator).append("broadcaster_logs").toString()));
        abj.if.al()._mth02CA(bgq);
        bundle = bgq;
        FF6A.ma.set(bundle);
        bgq.log("==================================================");
        bgq.log((new StringBuilder("Android OS Version: ")).append(aos.dF()).toString());
        bgq.log((new StringBuilder("Model Info: ")).append(aos.dG()).toString());
        bgq.log((new StringBuilder("App Version: ")).append(aos._mth02CA(this)).toString());
        bgr = new aoo();
        bgr._mth02CA(this);
        bgt = (arx)findViewById(0x7f0d0091);
        bgt.setDraggable(false);
        bgt.setFriction(0.5F);
        bgt.setOnViewDragListener(new aem(this));
        bgt.setOnSystemUiVisibilityChangeListener(new aen(this));
        bhw = (aeu)findViewById(0x7f0d0095);
        bhw.setGestureListener(new aeo(this));
        bhx = new xu(this);
        bundle = bhw;
        obj = bhx;
        if (((xu) (obj)).aTZ == null)
        {
            obj.aTZ = new xv(((xu) (obj)));
        }
        bundle.setScaleGestureListener(((xu) (obj)).aTZ);
        bgC = findViewById(0x7f0d009b);
        bgF = (EditText)findViewById(0x7f0d00a1);
        bgD = findViewById(0x7f0d0092);
        bgD.findViewById(0x7f0d0094).setOnClickListener(this);
        bgD.findViewById(0x7f0d0093).setOnClickListener(this);
        findViewById(0x7f0d009d).setOnClickListener(this);
        bhl = art._mth02C8(this, "fonts/MuseoSans-500.otf");
        bhm = art._mth02C8(this, "fonts/MuseoSans-700.otf");
        bgE = (Button)findViewById(0x7f0d00a2);
        bgE.setOnClickListener(this);
        _mth02CA(false, 0x7f0600de, bhl);
        obj = xd.getEventBus();
        bgT = new yg(((ql) (obj)), mUserManager, this, this, null);
        bgT.init();
        bdJ = (aqf)findViewById(0x7f0d00a7);
        bhh = new aep(this, this, ApiManager.get(this), mUserManager, bdJ);
        bdJ.setDelegate(bhh);
        bgK = (ans)findViewById(0x7f0d00a8);
        bundle = bgK;
        ((ans) (bundle)).buu.setText(0x7f060124);
        ((ans) (bundle)).buv.setText(0x7f060122);
        bundle.buE = 0x7f0d0187;
        bundle.buA = 0x7f060121;
        bundle.buB = 0x7f060058;
        bundle.buC = 0x7f060123;
        Object obj1 = ((ans) (bundle)).buG;
        obj1.bup = true;
        obj1.buq = bundle;
        ((android.support.v7.widget.RecyclerView.if) (((ans) (bundle)).buG)).ey.notifyChanged();
        bundle.setUserType(zs.aWZ);
        bhi = new anq(ApiManager.get(this), bgK, zs.aWZ);
        obj1 = bgt;
        Object obj2 = (apk)findViewById(0x7f0d00a9);
        Object obj3 = bhh;
        if (super.bdr != null)
        {
            bundle = super.bdr;
        } else
        {
            bundle = new qe();
        }
        bhq = new adh(((arx) (obj1)), ((apk) (obj2)), ((acy) (obj3)), null, bundle);
        bgV = (ahw)findViewById(0x7f0d00a4);
        bgV.setChatAdapter(new ahk(this, this, this));
        bundle = bgV;
        obj1 = bhx;
        if (((xu) (obj1)).aTZ == null)
        {
            obj1.aTZ = new xv(((xu) (obj1)));
        }
        bundle.setOnInterceptTouchEventListener(new _cls02CE(((xu) (obj1)).aTZ));
        bgU = (aib)findViewById(0x7f0d00a3);
        bhg = new adl(this, ApiManager.get(this), bhq, bhh, null, new aex(bgV, bgU));
        aTi = (aav)findViewById(0x7f0d0096);
        bgO = new ahl(this, aWS.id, yo._mth02CA(this, mUserManager));
        ApiManager.get(this).performUploadTest();
        bgu = new xm();
        bgu._mth02CA(this);
        bgw = new aou();
        bgw.bvN = 0x2c600;
        bgu._mth1D3E(bgw.bvW << 3);
        if (!bgu._mth02CA(aTi))
        {
            FF6A._mth02CB("RTMP", "Unable to connect to camera");
            bgu.stopPreview();
            bgu._mth4E41();
            bgu = null;
        }
        _mth30FD(getWindowManager().getDefaultDisplay().getRotation());
        if ("development".equals("production"))
        {
            findViewById(0x7f0d00a0).setVisibility(0);
        }
        bgY = findViewById(0x7f0d0097);
        bgZ = new aeq(this);
        ((TextView)bgY.findViewById(0x7f0d0098)).setText(aos._mth1D37(getString(0x7f060073)), android.widget.TextView.BufferType.SPANNABLE);
        ((TextView)bgY.findViewById(0x7f0d0099)).setText(aos._mth1D37(getString(0x7f060072)), android.widget.TextView.BufferType.SPANNABLE);
        bhy = findViewById(0x7f0d009a);
        bhy.setOnClickListener(this);
        bha = (adu)findViewById(0x7f0d00a6);
        bha.setOnClickListener(this);
        bha.setActionButtonVisibility(true);
        bha.bfw.setImageResource(0x7f0200d8);
        bhk = findViewById(0x7f0d00a5);
        bhk.setOnClickListener(this);
        bhk.setVisibility(8);
        bhe = (TextView)bhk.findViewById(0x7f0d00b2);
        bhe.setVisibility(8);
        bundle = xd._mth1FEB();
        if (((ack) (bundle)).bde == null)
        {
            bundle.aG();
        }
        bundle = ((ack) (bundle)).bde;
        bhf = _cls026B._cls02CB._mth02CA(this, bundle, mUserManager);
        bgM = new aak(this, this, this);
        Object obj4 = findViewById(0x7f0d009b);
        obj2 = bgM;
        obj3 = bhi;
        obj1 = new aec(aQC.getBoolean((String)yp.CON._mth02CA("o.yp").getField("aVV").get(null), false), aQC.getBoolean((String)yp.CON._mth02CA("o.yp").getField("aVW").get(null), false), aQC.getBoolean((String)yp.CON._mth02CA("o.yp").getField("aVX").get(null), false));
        arc arc1 = (arc)((View) (obj4)).findViewById(0x7f0d008b);
        TextView textview = (TextView)((View) (obj4)).findViewById(0x7f0d009f);
        TextView textview1 = (TextView)((View) (obj4)).findViewById(0x7f0d0080);
        arc arc2 = (arc)((View) (obj4)).findViewById(0x7f0d0131);
        arc arc3 = (arc)((View) (obj4)).findViewById(0x7f0d0132);
        obj4 = (arv)((View) (obj4)).findViewById(0x7f0d0130);
        if (bundle == null)
        {
            _cls0675._mth02CB(new IllegalStateException("No valid Periscope session!!!"));
        }
        if (bundle != null && ((acj) (bundle)).bcZ == acj.if.bdb)
        {
            boolean flag;
            if (_cls141D.if._mth02CA(bundle, xd._mth1FEA()) != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                _cls0675._mth02CB(new IllegalStateException("No valid twitter session!!!"));
            }
            bundle = new afp(this, textview, textview1, arc1, arc2, arc3, ((arv) (obj4)), flag, ((aak) (obj2)), ((anq) (obj3)));
        } else
        {
            arc3.setVisibility(8);
            bundle = new afo(this, textview, textview1, arc1, arc2, ((arv) (obj4)), ((aak) (obj2)), ((anq) (obj3)));
        }
        bundle._mth02CB(((aec) (obj1)));
        bundle.biK = this;
        bgL = bundle;
        ((ql) (obj))._mth02CA(bgO, false, 0);
        ((ql) (obj))._mth02CA(bhh, false, 0);
        ((ql) (obj))._mth02CA(bhg, false, 0);
        ((ql) (obj))._mth02CA(bhi, false, 0);
        if (bhz == null)
        {
            bhz = new aer(this, this, 2);
            if (bhz.canDetectOrientation())
            {
                bhz.enable();
                return;
            }
            bhz = null;
        }
    }

    protected void onDestroy()
    {
        if (bhz != null)
        {
            bhz.disable();
            bhz = null;
        }
        if (bgu != null)
        {
            bgu.stopPreview();
            bgu._mth4E41();
            bgu = null;
        }
        bgq.log("onDestroy");
        if (bgP)
        {
            aVa._mth02CA(aUX);
            bgP = false;
        }
        aVa.kill();
        Object obj = bgT;
        Object obj1 = ((yg) (obj)).aUF;
        obj1.aUv = false;
        ((yd) (obj1)).clear();
        ((yg) (obj)).mEventBus.unregister(obj);
        bgO.blO.clear();
        obj = xd.getEventBus();
        ((ql) (obj)).unregister(bgO);
        ((ql) (obj)).unregister(bhh);
        ((ql) (obj)).unregister(bhg);
        ((ql) (obj)).unregister(bhi);
        if (bhc != null)
        {
            obj = bhc.bet.iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                obj1 = (aqc)((Iterator) (obj)).next();
                if (((aqc) (obj1)).mCreated)
                {
                    ((aqc) (obj1)).bzH.onDestroy();
                }
            } while (true);
            bhc.bet.clear();
        }
        if (!bgS && bhp != null && !bhg.ba())
        {
            FF6A._mth02CB("RTMP", "Video was not saved to camera, deleting");
            (new File(bhp)).delete();
        }
        obj = abj.if.al();
        obj1 = bgq;
        ((abj) (obj)).bcc.remove(((abk) (obj1)).getName(), obj1);
        obj = bgq;
        FF6A.ma.compareAndSet(obj, null);
        bgq.close();
        super.onDestroy();
    }

    public void onEventBackgroundThread(int ai[])
    {
        ai = Bitmap.createBitmap(ai, 320, 568, android.graphics.Bitmap.Config.ARGB_8888);
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        ai.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, bytearrayoutputstream);
        bhj.bhM = bytearrayoutputstream.toByteArray();
        ai = bhj;
        if (((_cls02CB) (ai)).uploadUrl == null || ((_cls02CB) (ai)).bhM == null)
        {
            return;
        } else
        {
            xd._mth3063().execute(new aet(ai));
            return;
        }
    }

    public void onEventMainThread(abl abl1)
    {
        if (abl1 != null)
        {
            FF6A._mth02CB("RTMP", _cls141D.if._mth02CA(abl1.bcf));
            return;
        } else
        {
            FF6A._mth02CB("RTMP", "Received network activity but info was empty");
            return;
        }
    }

    public void onEventMainThread(yb yb1)
    {
        static final class _cls1
        {

            static final int $SwitchMap$tv$periscope$android$event$ApiEvent$Type[];
            static final int bcB[];
            static final int bhK[];
            static final int bhL[];

            static 
            {
                bhL = new int[aov.if.dW().length];
                int ai[];
                ai = bhL;
                int i = aov.if.bwQ;
                ai[1] = 1;
_L1:
                bhK = new int[yb.values().length];
                NoSuchFieldError nosuchfielderror;
                try
                {
                    bhK[yb.aUl.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                $SwitchMap$tv$periscope$android$event$ApiEvent$Type = new int[zu.if.values().length];
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXM.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXN.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXF.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aYh.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aYa.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                bcB = new int[zw.values().length];
                try
                {
                    bcB[zw.aYJ.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                break MISSING_BLOCK_LABEL_155;
                nosuchfielderror;
                  goto _L1
            }
        }

        switch (_cls1.bhK[yb1.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            bgP = true;
            break;
        }
        by();
    }

    public void onEventMainThread(zu zu1)
    {
        _cls1..SwitchMap.tv.periscope.android.event.ApiEvent.Type[zu1.aXk.ordinal()];
        JVM INSTR tableswitch 1 5: default 44
    //                   1 45
    //                   2 367
    //                   3 838
    //                   4 954
    //                   5 1286;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        return;
_L2:
        boolean flag;
        if (zu1.aXl == null && zu1.mU == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            zu1 = (ats)zu1.data;
            bei = zu1.fo().id();
            bgG = zu1;
            bv();
            FF6A._mth02CB("RTMP", "Starting encoding");
            bgu._mth30F6();
            bhj.uploadUrl = zu1.fT();
            bgs = zu1.fE();
            bgq._fld1FD2 = bgs;
            aUX = new xx(zu1.fx(), zu1.fo().id());
            bgI = zu1.fC();
            bhb = zu1.fo();
            bgH = zu1.fw();
            try
            {
                Object obj = new acb(zu1.fD());
                aVa._mth02CA(zu1.fu(), zu1.ft(), zu1.eG(), zu1.eF(), new acd(((acb) (obj)), "SHA256withECDSA", "SC"), zu1.fF(), zu1.fH(), zu1.fI(), xd.getEventBus(), (SignerService)xd._mth30A5().getService(), yo.getLogLevel());
                aVa._mth02CA(aUX, zu1.fv(), aWS.id, aWS.username, aWS.displayName, aWS.initials, aWS.getProfileUrlMedium(), zu1.fw());
                obj = bgT;
                Object obj4 = aUX;
                obj4 = zu1.fo().fd();
                zu1.eG();
                obj.aUI = ((String) (obj4));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (zu zu1)
            {
                zu1.printStackTrace();
            }
            return;
        }
        break; /* Loop/switch isn't completed */
_L3:
        boolean flag1;
        if (zu1.aXl == null && zu1.mU == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag1) goto _L8; else goto _L7
_L7:
        Object obj1;
        bgt.setSystemUiVisibility(1);
        obj1 = bgF;
        if (obj1 != null)
        {
            ((InputMethodManager)((View) (obj1)).getContext().getSystemService("input_method")).hideSoftInputFromWindow(((View) (obj1)).getWindowToken(), 0);
        }
        bhy.setVisibility(0);
        bhp = bhg._mth05D2(bei);
        obj1 = bgv;
        Object obj5 = bhp;
        obj1;
        JVM INSTR monitorenter ;
        if (((aov) (obj1)).bwJ == 0L)
        {
            obj1.bwJ = System.currentTimeMillis();
        }
        obj1;
        JVM INSTR monitorexit ;
          goto _L9
        zu1;
        throw zu1;
_L9:
        if (((aov) (obj1)).bwC != null)
        {
            ((aov) (obj1)).bwC._mth02CA(((String) (obj5)), ((aov) (obj1)).aTD, ((aov) (obj1)).bho);
        }
        bgu._mth4E2B();
        bgy = true;
        _mth02B5(true);
        bgt.removeView(bgC);
        bgt.setDraggable(true);
        bgD.setVisibility(0);
        mHandler.postDelayed(new aeh(this), 500L);
        mHandler.postDelayed(bgZ, TimeUnit.SECONDS.toMillis(5L));
        bgJ = true;
        bhe.setVisibility(0);
        bhk.setVisibility(0);
        obj1 = bgV;
        obj5 = new aud.if();
        obj5.bEx = Integer.valueOf(0);
        obj5 = ((auf.if) (obj5))._mth02CB(Integer.valueOf(2))._mth02CB(aug.bEF).gG();
        ((ahw) (obj1)).bml._mth141D(((auf) (obj5)));
        int i = ((ahw) (obj1)).bml.getItemCount();
        ((ahw) (obj1)).bmk._mth1507(i - 1);
        zu1 = (PublishBroadcastResponse)zu1.data;
        bgU.setHeartThemes(((PublishBroadcastResponse) (zu1)).heartThemes);
        if (!bgz && bgA)
        {
            ApiManager.get(this).getBroadcastShareUrl(bei);
        }
        mHandler.removeCallbacks(bgW);
        mHandler.post(bgW);
        return;
_L8:
        if (bgP)
        {
            aVa._mth02CA(aUX);
            bgP = false;
        }
        aVa.kill();
        _mth02CA(false, 0x7f0601a6, bhl);
        ApiManager.get(this).performUploadTest();
        return;
_L4:
        boolean flag2;
        if (zu1.aXl == null && zu1.mU == null)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (!flag2)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj2 = (GetBroadcastShareUrlResponse)zu1.data;
        if (bei.equals(((GetBroadcastShareUrlResponse) (obj2)).id) && !bgB && aui._mth02BF(((GetBroadcastShareUrlResponse) (obj2)).url))
        {
            zu1 = bgF.getText().toString();
            obj2 = ((GetBroadcastShareUrlResponse) (obj2)).url;
            bhf._mth02CA(0x7f06016a, 0x7f06016b, zu1, ((String) (obj2)), null, new aes(this));
        }
        return;
_L5:
        boolean flag3;
        if (zu1.aXl == null && zu1.mU == null)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if (flag3)
        {
            zu1 = (UploadTestResponse)zu1.data;
            float f = ((UploadTestResponse) (zu1)).byteRateSeconds;
            float f1 = (((f * 8F) / 10F - 4000F) * 65F) / 100F;
            boolean flag4;
            if (f1 < 8960F)
            {
                flag4 = true;
            } else
            {
                flag4 = false;
            }
            if (!flag4)
            {
                flag4 = true;
            } else
            {
                flag4 = false;
            }
            FF6A._mth02CB("RTMP", (new StringBuilder("Upload ")).append((int)((8F * f) / 1024F)).append(" Video rate ").append(((int)f1 << 3) / 1024).append(" kbits/s").toString());
            if (flag4)
            {
                FF6A._mth02CB("RTMP", "Video byterate is acceptable.");
                bhn = true;
                if (bgu != null)
                {
                    Object obj3 = bgw;
                    obj3.bvQ = (int)f;
                    obj3.bvS = false;
                    ((aou) (obj3)).dI();
                    bgu._mth1D3E(bgw.bvW << 3);
                    obj3 = bgu;
                    int j;
                    if (bgw.bvW > 46080)
                    {
                        j = 0x10000;
                    } else
                    {
                        j = 32768;
                    }
                    ((xl) (obj3))._mth1D43(j);
                    ApiManager.get(this).createBroadcast(((UploadTestResponse) (zu1)).region);
                    return;
                }
            } else
            {
                _mth02CA(false, 0x7f060047, bhl);
                FF6A._mth02CB("RTMP", "Video byterate is NOT acceptable.");
            }
            return;
        } else
        {
            _mth02CA(false, 0x7f060048, bhl);
            FF6A._mth02CB("RTMP", (new StringBuilder("An error occurred testing video byterates: ")).append(zu1.aXl).toString());
            return;
        }
_L6:
        bs();
    }

    public void onEventMainThread(zw zw1)
    {
        switch (_cls1.bcB[zw1.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            break;
        }
        if (bhc == null)
        {
            bhd = new adw(this, mUserManager, mBroadcastCacheManager, bhg);
            bhd.bei = bei;
            bhc = new adj(this, bhd, bhg);
            bha.setAdapter(bhc);
        }
        if (bu())
        {
            zw1 = bhd;
            Location location = bfB;
            if (((adw) (zw1)).bfB != null && !((adw) (zw1)).bfB.equals(location))
            {
                zw1.bfB = location;
            }
        }
        bhd.A();
        ((android.support.v7.widget.RecyclerView.if) (bhc)).ey.notifyChanged();
        bha.setTitle(bhb.eS(), bhb.eT().toString());
    }

    public void onEventMainThread(zx zx)
    {
        bhd._mth02CA(zx);
    }

    public final void onLocationChanged(Location location)
    {
        FF6A._mth02CB("RTMP", (new StringBuilder("onLocationChanged ")).append(location).toString());
        bfB = location;
        if (bgP)
        {
            by();
        }
    }

    public void onLowMemory()
    {
        super.onLowMemory();
        bgq.log("onLowMemory");
        if (bhc != null)
        {
            Iterator iterator = bhc.bet.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (aqc)iterator.next();
                if (((aqc) (obj)).mCreated)
                {
                    obj = ((aqc) (obj)).bzH.Eo;
                    if (((bb) (obj)).zw != null)
                    {
                        ((bb) (obj)).zw.onLowMemory();
                    }
                }
            } while (true);
        }
    }

    protected void onPause()
    {
        bgq.log("onPause");
        if (bgM.baj.isConnected())
        {
            bgM.T();
        }
        if (bhc != null)
        {
            Iterator iterator = bhc.bet.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                aqc aqc1 = (aqc)iterator.next();
                if (aqc1.mCreated)
                {
                    aqc1.bzH.onPause();
                }
            } while (true);
        }
        super.onPause();
    }

    public void onRequestPermissionsResult(int i, String as[], int ai[])
    {
        switch (i)
        {
        default:
            return;

        case 100: // 'd'
            as = (Activity)bgM.bai.get();
            break;
        }
        boolean flag;
        if (as != null)
        {
            flag = _cls141D.if._mth02CA(as, aak.bah);
        } else
        {
            flag = false;
        }
        if (flag)
        {
            bgM.S();
            return;
        } else
        {
            bgL._mth02B8(true);
            return;
        }
    }

    protected void onResume()
    {
        super.onResume();
        mHandler.removeCallbacks(bhv);
        bgq.log("onResume");
        if (bgL.bF() && bgM.baj.isConnected())
        {
            bgM.S();
        }
        if (bhc != null)
        {
            Iterator iterator = bhc.bet.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                aqc aqc1 = (aqc)iterator.next();
                if (aqc1.mCreated)
                {
                    aqc1.bzH.onResume();
                }
            } while (true);
        }
    }

    protected void onStart()
    {
        super.onStart();
        bgq.log("onStart");
        bgr.startWatching();
        bgM.connect();
    }

    public void onStop()
    {
        super.onStop();
        bgq.log("onStop");
        bgr.stopWatching();
        aak aak1 = bgM;
        if (aak1.baj.isConnected())
        {
            aak1.baj.disconnect();
        }
        if (bgN == null && !aQC.getBoolean((String)yp.CON._mth02CA("o.yp").getField("aVY").get(null), true))
        {
            _mth02CA(bgL.bH());
        }
        if (isFinishing())
        {
            FF6A._mth02CB("RTMP", "onStop and Finishing, ending broadcast");
            _mth0269(false);
            return;
        } else
        {
            FF6A._mth02CB("RTMP", "Unexpected onStop, setting 5000 second timer to end broadcast.");
            mHandler.postDelayed(bhv, 5000L);
            return;
        }
    }

    public final void _mth02B9(int ai[])
    {
        xd.getEventBus()._mth1429(ai);
    }

    public final void _mth02BE(List list)
    {
        mUserManager._mth02CA(aWS.id, bei, list);
    }

    public final void _mth02CA(MediaFormat mediaformat, MediaFormat mediaformat1)
    {
        if (mediaformat != null && mediaformat1 != null)
        {
            aTD = mediaformat;
            bho = mediaformat1;
            if (bgv != null)
            {
                bgv._mth02CA(mediaformat, mediaformat1);
            }
        }
    }

    public final void _mth02CA(String s, int i, boolean flag)
    {
        mUserManager._mth02CA(bei, s, i, false);
    }

    public final void _mth02CA(ByteBuffer bytebuffer, android.media.MediaCodec.BufferInfo bufferinfo)
    {
        this;
        JVM INSTR monitorenter ;
        bhs = System.currentTimeMillis();
        this;
        JVM INSTR monitorexit ;
          goto _L1
        bytebuffer;
        throw bytebuffer;
_L1:
        aov aov1;
        if (bgv == null)
        {
            break MISSING_BLOCK_LABEL_1838;
        }
        aov1 = bgv;
        long l3 = bufferinfo.presentationTimeUs / 1000L;
        aov1;
        JVM INSTR monitorenter ;
        if (aov1.bwA != 0L || l3 <= 0L)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        aov1.bwA = apb.ec().getTime();
        aov1.bwz = l3;
        aov1.bwB = l3;
        aov1;
        JVM INSTR monitorexit ;
          goto _L2
        bytebuffer;
        throw bytebuffer;
_L2:
        int l;
        int i1;
        int i2;
        int j2;
        boolean flag2;
        int l2;
        boolean flag5;
        if (aov1.bwC != null)
        {
            aov1.bwC._mth02CF(bytebuffer, bufferinfo);
        }
        int k2 = 0;
        int i = 0;
        l = 0;
        boolean flag3 = false;
        boolean flag1 = false;
        i1 = 0;
        do
        {
            l2 = l;
            flag5 = flag3;
            j2 = ((flag1) ? 1 : 0);
            i2 = i;
            flag2 = i1;
            if (k2 >= bytebuffer.limit() - 4)
            {
                break;
            }
            l2 = l;
            flag5 = flag3;
            flag2 = flag1;
            j2 = i;
            i2 = i1;
            if (bytebuffer.get(k2) == 0)
            {
                l2 = l;
                flag5 = flag3;
                flag2 = flag1;
                j2 = i;
                i2 = i1;
                if (bytebuffer.get(k2 + 1) == 0)
                {
                    l2 = l;
                    flag5 = flag3;
                    flag2 = flag1;
                    j2 = i;
                    i2 = i1;
                    if (bytebuffer.get(k2 + 2) == 1)
                    {
                        byte byte1 = bytebuffer.get(k2 + 3);
                        i2 = byte1 & 0x1f;
                        if ((byte1 & 0x60) != 0)
                        {
                            flag1 = true;
                        }
                        if (i2 == 5)
                        {
                            flag3 = true;
                            i1 = 1;
                        }
                        if (i2 == 7)
                        {
                            FF6A._mth02CB("RTMP", "SPS found");
                        }
                        if (i2 == 1)
                        {
                            i1 = 1;
                        }
                        if (i == 0)
                        {
                            i = k2 + 3;
                        } else
                        {
                            l = k2 + 3;
                        }
                        l2 = l;
                        flag5 = flag3;
                        j2 = ((flag1) ? 1 : 0);
                        i2 = i;
                        flag2 = i1;
                        if ((byte1 & 0x1f) != 7)
                        {
                            break;
                        }
                        i2 = i1;
                        j2 = i;
                        flag2 = flag1;
                        flag5 = flag3;
                        l2 = l;
                    }
                }
            }
            k2++;
            l = l2;
            flag3 = flag5;
            flag1 = flag2;
            i = j2;
            i1 = i2;
        } while (true);
        if (l2 > 0)
        {
            l = l2 - 3 - i2;
            i1 = bytebuffer.limit() - l2;
        } else
        {
            l = bytebuffer.limit() - i2;
            i1 = 0;
        }
        if (l2 <= 0)
        {
            break MISSING_BLOCK_LABEL_652;
        }
        if ((bytebuffer.get(i2) & 0x1f) != 7 || (bytebuffer.get(l2) & 0x1f) != 8)
        {
            break MISSING_BLOCK_LABEL_643;
        }
        aov1;
        JVM INSTR monitorenter ;
        aov1.bwk = new byte[l];
        bytebuffer.position(i2);
        bytebuffer.get(aov1.bwk, 0, l);
        aov1.bwl = new byte[i1];
        bytebuffer.position(l2);
        bytebuffer.get(aov1.bwl, 0, i1);
        int k1 = 0;
        aov1;
        JVM INSTR monitorenter ;
        int j = k1;
        if (aov1.bwn)
        {
            break MISSING_BLOCK_LABEL_609;
        }
        aov1.bwn = true;
        j = k1;
        boolean flag4;
        if (!aov1.bwm)
        {
            break MISSING_BLOCK_LABEL_609;
        }
        flag4 = aov1.bwo;
        j = k1;
        if (flag4)
        {
            j = 1;
        }
        aov1;
        JVM INSTR monitorexit ;
          goto _L3
        bytebuffer;
        throw bytebuffer;
_L3:
        if (!j)
        {
            break MISSING_BLOCK_LABEL_631;
        }
        aov1.dP();
        aov1;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_652;
        bytebuffer;
        throw bytebuffer;
        FF6A._mth02CB("RTMP", "Unexpected NALU structure");
        if (!flag2)
        {
            break MISSING_BLOCK_LABEL_1748;
        }
        aov1;
        JVM INSTR monitorenter ;
        flag4 = aov1.bwp;
        if (flag4)
        {
            break MISSING_BLOCK_LABEL_678;
        }
        aov1;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_1748;
        aov1;
        JVM INSTR monitorexit ;
          goto _L4
        bytebuffer;
        throw bytebuffer;
_L4:
        if (!aov1.bwq)
        {
            if (!flag5)
            {
                break MISSING_BLOCK_LABEL_1748;
            }
            aov1.bwq = true;
        }
        if (!flag5)
        {
            break MISSING_BLOCK_LABEL_751;
        }
        aov1;
        JVM INSTR monitorenter ;
        if (aov1.bwJ != 0L)
        {
            aov1.bwK = aov1.bwK + 1;
        }
        aov1;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_751;
        bytebuffer;
        throw bytebuffer;
        byte abyte0[];
        k1 = l + 4;
        j = k1;
        if (i1 > 0)
        {
            j = k1 + (i1 + 4);
        }
        abyte0 = null;
        k1 = 0;
        aov1;
        JVM INSTR monitorenter ;
        if (!aov1.bwx && !aov1.bwy)
        {
            break MISSING_BLOCK_LABEL_809;
        }
        k1 = 1;
        aov1.bwx = false;
        aov1;
        JVM INSTR monitorexit ;
          goto _L5
        bytebuffer;
        throw bytebuffer;
_L5:
        int j1;
label0:
        {
            if (!flag5)
            {
                j1 = j;
                if (!k1)
                {
                    break label0;
                }
            }
            j1 = j;
            if (flag5)
            {
                j1 = j + (aov1.bwk.length + aov1.bwl.length + 8);
            }
            abyte0 = aov1._mth02CA(l3, flag5);
            ByteBuffer bytebuffer1 = ByteBuffer.allocate(abyte0.length * 2 + 23 + 1);
            j = abyte0.length + 16;
            bytebuffer1.put((byte)6);
            bytebuffer1.put((byte)5);
            for (; j > 255; j -= 255)
            {
                bytebuffer1.put((byte)-1);
            }

            bytebuffer1.put((byte)j);
            bytebuffer1.putLong(aai.bag.getMostSignificantBits());
            bytebuffer1.putLong(aai.bag.getLeastSignificantBits());
            boolean flag = false;
            for (int l1 = 0; l1 < abyte0.length; l1++)
            {
                byte byte0 = abyte0[l1];
                bytebuffer1.put(byte0);
                if (byte0 == 0)
                {
                    if (flag)
                    {
                        bytebuffer1.put((byte)3);
                    } else
                    {
                        flag = true;
                        continue;
                    }
                }
                flag = false;
            }

            bytebuffer1.put((byte)-128);
            abyte0 = new byte[bytebuffer1.limit()];
            bytebuffer1.rewind();
            bytebuffer1.get(abyte0);
            j1 += abyte0.length + 4;
        }
        Object obj = aov1.aZs;
        flag = aov1.aZs.bxB;
        if (((apa) (obj)).bxm == null)
        {
            obj = new apg(9, 7, flag);
        } else
        {
            obj = ((apa) (obj)).bxm._mth0559(9, 7, flag, j1 + 5);
        }
        if (((apg) (obj)).byA == null)
        {
            obj.byA = new apd();
        }
        apd apd1 = ((apg) (obj)).byA;
        if (flag5)
        {
            apd1.FEAB(apd1.length + 1);
            apd1.buffer[apd1.length] = 23;
            apd1.length = apd1.length + 1;
        } else
        if (j2 != 0)
        {
            apd1.FEAB(apd1.length + 1);
            apd1.buffer[apd1.length] = 39;
            apd1.length = apd1.length + 1;
        } else
        {
            apd1.FEAB(apd1.length + 1);
            apd1.buffer[apd1.length] = 55;
            apd1.length = apd1.length + 1;
        }
        apd1.FEAB(apd1.length + 1);
        apd1.buffer[apd1.length] = 1;
        apd1.length = apd1.length + 1;
        apd1.FEAB(apd1.length + 1);
        apd1.buffer[apd1.length] = 0;
        apd1.length = apd1.length + 1;
        apd1.FEAB(apd1.length + 1);
        apd1.buffer[apd1.length] = 0;
        apd1.length = apd1.length + 1;
        apd1.FEAB(apd1.length + 1);
        apd1.buffer[apd1.length] = 0;
        apd1.length = apd1.length + 1;
        flag = 5;
        if (flag5)
        {
            apa._mth02BB(aov1.bwk.length, apd1.buffer, 5);
            System.arraycopy(aov1.bwk, 0, apd1.buffer, 9, aov1.bwk.length);
            flag = aov1.bwk.length + 4 + 5;
            apa._mth02BB(aov1.bwl.length, apd1.buffer, flag);
            System.arraycopy(aov1.bwl, 0, apd1.buffer, flag + 4, aov1.bwl.length);
            flag += aov1.bwl.length + 4;
        }
        j1 = ((flag) ? 1 : 0);
        if (abyte0 != null)
        {
            apa._mth02BB(abyte0.length, apd1.buffer, flag);
            System.arraycopy(abyte0, 0, apd1.buffer, flag + 4, abyte0.length);
            j1 = flag + (abyte0.length + 4);
        }
        apa._mth02BB(l, apd1.buffer, j1);
        flag = j1 + 4;
        bytebuffer.position(i2);
        bytebuffer.get(apd1.buffer, flag, l);
        apd1.length = flag + l;
        obj.bxk = l3;
        aov1.aZs._mth02CF(((apg) (obj)));
        apa apa1 = aov1.aZs;
        if (((apg) (obj)).byA == null)
        {
            obj.byA = new apd();
        }
        if (((apg) (obj)).byA != null)
        {
            if (((apg) (obj)).byA == null)
            {
                obj.byA = new apd();
            }
            if (((apg) (obj)).byA.ef() != null)
            {
                apa1.bxm._mth02CE(((apg) (obj)));
            }
        }
        aou aou1 = bgw;
        int k = bytebuffer.limit();
        double d = bufferinfo.presentationTimeUs / 1000L;
        aou1.bvG._mth02CA(d / 1000D, k);
        bytebuffer = aou1.bvG;
        k = 0;
        if (((aou._cls02CA) (bytebuffer)).bwf > 0.0D)
        {
            k = (int)((double)((aou._cls02CA) (bytebuffer)).bwg / ((aou._cls02CA) (bytebuffer)).bwf);
        }
        d = (k * 100) / aou1.bvW;
        aou1.bvK._mth02CE(d);
    }

    public final void _mth02CA(auf auf1, xk xk)
    {
        bhq._mth02CA(bei, auf1, xk, true);
    }

    public final void _mth02CA(auf auf1, boolean flag)
    {
        aib aib1 = bgU;
        int i = aok._mth02CA(getResources(), auf1.gp().intValue());
        auf1 = aib1.bmJ.FB40(i);
        aib1.bmI._mth02CA(auf1, aib1, false);
    }

    public final void _mth02CB(ByteBuffer bytebuffer, android.media.MediaCodec.BufferInfo bufferinfo)
    {
        Object obj1;
        if (bgv == null)
        {
            break MISSING_BLOCK_LABEL_511;
        }
        obj1 = bgv;
        long l = bufferinfo.presentationTimeUs / 1000L;
        obj1;
        JVM INSTR monitorenter ;
        if (((aov) (obj1)).bwp)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        obj1.bws = 0L;
        obj1;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_474;
        if (((aov) (obj1)).bwA != 0L || l <= 0L)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        obj1.bwA = apb.ec().getTime();
        obj1.bwz = l;
        obj1;
        JVM INSTR monitorexit ;
          goto _L1
        bytebuffer;
        throw bytebuffer;
_L1:
        if (((aov) (obj1)).bws == 0L)
        {
            obj1.bwt = l;
        } else
        {
            l = ((aov) (obj1)).bwt + Math.round((double)((aov) (obj1)).bws * ((aov) (obj1)).bwu);
        }
        obj1.bws = ((aov) (obj1)).bws + 1024L;
        bufferinfo.presentationTimeUs = 1000L * l;
        if (((aov) (obj1)).bwC != null)
        {
            ((aov) (obj1)).bwC._mth02CE(bytebuffer, bufferinfo);
        }
        Object obj = ((aov) (obj1)).aZs;
        int i = ((aov) (obj1)).aZs.bxB;
        int k = bytebuffer.limit();
        if (((apa) (obj)).bxm == null)
        {
            obj = new apg(8, 6, i);
        } else
        {
            obj = ((apa) (obj)).bxm._mth0559(8, 6, i, k + 2);
        }
        if (((apg) (obj)).byA == null)
        {
            obj.byA = new apd();
        }
        apd apd1 = ((apg) (obj)).byA;
        apd1.FEAB(apd1.length + 1);
        apd1.buffer[apd1.length] = -81;
        apd1.length = apd1.length + 1;
        apd1.FEAB(apd1.length + 1);
        apd1.buffer[apd1.length] = 1;
        apd1.length = apd1.length + 1;
        bytebuffer.get(apd1.buffer, apd1.length, bytebuffer.limit());
        apd1.length = apd1.length + bytebuffer.limit();
        obj.bxk = l;
        ((aov) (obj1)).aZs._mth02CF(((apg) (obj)));
        obj1 = ((aov) (obj1)).aZs;
        if (((apg) (obj)).byA == null)
        {
            obj.byA = new apd();
        }
        if (((apg) (obj)).byA != null)
        {
            if (((apg) (obj)).byA == null)
            {
                obj.byA = new apd();
            }
            if (((apg) (obj)).byA.ef() != null)
            {
                ((apa) (obj1)).bxm._mth02CE(((apg) (obj)));
            }
        }
        aou aou1 = bgw;
        int j = bytebuffer.limit();
        double d = bufferinfo.presentationTimeUs / 1000L;
        aou1.bvH._mth02CA(d / 1000D, j);
    }

    public final void _mth02CB(auf auf1, boolean flag)
    {
        aib aib1 = bgU;
        int i = aok._mth02CA(getResources(), auf1.gp().intValue());
        auf1 = new aix(aib1.getContext());
        auf1.setColorAndDrawables(i, 0x7f020119, 0x7f02011a);
        aib1.bmI._mth02CA(auf1, aib1, false);
    }

    public final void _mth02CE(LocationSettingsResult locationsettingsresult)
    {
        locationsettingsresult = locationsettingsresult.CW;
        boolean flag;
        if (((Status) (locationsettingsresult)).mPendingIntent != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        startIntentSenderForResult(((Status) (locationsettingsresult)).mPendingIntent.getIntentSender(), 100, null, 0, 0, 0);
        return;
        locationsettingsresult;
    }

    public final void _mth02CE(auf auf1)
    {
        ahw ahw1 = bgV;
        ahw1.bml._mth141D(auf1);
        int i = ahw1.bml.getItemCount();
        ahw1.bmk._mth1507(i - 1);
    }

    public final boolean _mth02CE(xx xx1)
    {
        return true;
    }

    public final void _mth02CF(auf auf1)
    {
    }

    public final void _mth037A(ArrayList arraylist)
    {
        boolean flag1 = bgz;
        boolean flag;
        if (arraylist.size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bgz = flag;
        if (bgG != null && flag1 != bgz)
        {
            StringBuilder stringbuilder = new StringBuilder("Switching ");
            if (bgz)
            {
                arraylist = "to";
            } else
            {
                arraylist = "from";
            }
            FF6A._mth02CB("RTMP", stringbuilder.append(arraylist).append(" private").toString());
            _mth02CA(false, 0x7f0600de, bhl);
            bv();
        }
    }

    public final void _mth05E0(String s)
    {
        runOnUiThread(new aej(this));
    }

    public final void _mth05E8(String s)
    {
    }

    public final void _mth141D(String as[])
    {
        _cls141D.if._mth02CA(this, as, 100);
    }

    public final boolean _mth1D54(long l)
    {
        double d = (double)l / 1000000000D;
        aou aou1 = bgw;
        if (aou1.bvX == 0.0D || aou1.bvX >= 24D)
        {
            return true;
        }
        if (aou1.bvY > 0.0D)
        {
            double d1 = 1.0D / aou1.bvX;
            double d2 = d - aou1.bvY;
            if (d1 > 0.0D && d2 > 0.0D && d2 < d1)
            {
                return false;
            }
        }
        aou1.bvY = d;
        return true;
    }

    protected final qh _mth207F(String s)
    {
        qh qh1 = xf._mth30EE();
        qh1._mth02E3(s);
        return qh1;
    }

    public final void _mth4E00(int i)
    {
        switch (_cls1.bhL[i - 1])
        {
        default:
            return;

        case 1: // '\001'
            runOnUiThread(new aei(this));
            break;
        }
    }

    public final void FB32(int i)
    {
        bht = i;
        bhe.setText(aos._mth02CA(getResources(), i, true));
    }

    public final xl FECF()
    {
        return bgu;
    }

    public final boolean FEF3(String s)
    {
        return bhC.contains(s);
    }

    public final boolean FF3F(String s)
    {
        return ((zd)mUserManager.aWI.get(zs.aXa))._mth14EA(s);
    }

    public final int FF86(String s)
    {
        ahl ahl1 = bgO;
        if (ahl1.blO.containsKey(s))
        {
            return ((Integer)ahl1.blO.get(s)).intValue();
        } else
        {
            return 0;
        }
    }

    public final int FF87()
    {
        return bht;
    }

}
