// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.codahale.metrics.Snapshot;
import com.google.android.exoplayer.ExoPlayer;
import com.twitter.sdk.android.core.TwitterSession;
import java.io.File;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import retrofit.RetrofitError;
import retrofit.client.Response;
import tv.periscope.android.api.ApiManager;
import tv.periscope.android.api.BroadcastRankResponse;
import tv.periscope.android.api.BroadcastResponse;
import tv.periscope.android.api.ChatStats;
import tv.periscope.android.api.PsUser;
import tv.periscope.android.api.ThumbnailPlaylistResponse;
import tv.periscope.android.signer.SignerService;

// Referenced classes of package o:
//            ada, aev, agb, aew, 
//            yc, zz, asl, afx, 
//            adf, agq, aha, ahb, 
//            ahc, adx, abm, ahi, 
//            aui, xd, ql, aey, 
//            abj, abk, FF6A, abc, 
//            ahw, ya, yg, yk, 
//            atr, atn, xx, aua, 
//            xw, aug, ahk, arm, 
//            aad, _cls1D3C, _cls1D5A, _cls1D27, 
//            _cls1647, _cls0443, aam, arx, 
//            aoh, agz, aok, aib, 
//            aiy, aip, aic, apb, 
//            auf, acp, qe, xh, 
//            xf, aos, aby, qh, 
//            agl, acy, aqf, ans, 
//            adh, ato, adu, ahf, 
//            agh, afs, agg, are, 
//            apx, xj, afw, ann, 
//            aop, aia, _cls0675, zp, 
//            xy, aoo, yo, aft, 
//            arb, ahd, ahe, anq, 
//            zs, apk, ahl, adl, 
//            adw, adj, ack, ask, 
//            aqc, ev, adk, aaj, 
//            abl, yb, ye, zu, 
//            yv, zw, bb, ba, 
//            ahg, agi, acn, atp, 
//            wr, aix, afk, ahh, 
//            agr, agt, agu, aif, 
//            agv, agw, agx, ags, 
//            agf, agd, age, agc, 
//            atw, agy, zd, zx, 
//            acd, xk

public class agp extends ada
    implements android.view.View.OnClickListener, ahl.if, adx.if, android.view.View.OnFocusChangeListener, aev, agb, aew, aey._cls02CB, ahi._cls02CA, yc, zz, asl, yd.if, afx, adf, aoo.if
{
    final class if
        implements android.view.View.OnSystemUiVisibilityChangeListener
    {

        private agp ble;

        public final void onSystemUiVisibilityChange(int i)
        {
            if ((i & 1) == 0)
            {
                agp._mth06E5(ble);
                if (!arx._mth1424(agp.FE76(ble)) && agp._mth1420(ble) != null && !agp._mth1420(ble).aO())
                {
                    agp._mth02BE(ble).removeCallbacks(agp._mth1423(ble));
                    agp._mth02BE(ble).postDelayed(agp._mth1423(ble), TimeUnit.SECONDS.toMillis(5L));
                }
            }
        }

        private if()
        {
            ble = agp.this;
            super();
        }

        if(byte byte0)
        {
            this();
        }
    }

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}

    /* member class not found */
    class _cls02CF {}


    private static int bke = 0;
    private xx aUX;
    xw aVa;
    PsUser aWS;
    private aqf bdJ;
    private String bei;
    private ans bgK;
    private ahl bgO;
    private int bgQ;
    private aib bgU;
    ahw bgV;
    private abc bgq;
    private boolean bgs;
    private arx bgt;
    final HashSet bhC = new HashSet();
    private adu bha;
    private adj bhc;
    private adw bhd;
    private agi bhf;
    private anq bhi;
    private View bhk;
    private String bhp;
    private adh bhq;
    private int bht;
    private aia biz;
    private ya bkA;
    private ahi.if bkB;
    private boolean bkC;
    private boolean bkD;
    private boolean bkE;
    private long bkF;
    private int bkG;
    private int bkH;
    private Boolean bkI;
    private boolean bkJ;
    private long bkK;
    private boolean bkL;
    private boolean bkM;
    private boolean bkN;
    private boolean bkO;
    private boolean bkP;
    private ahi bkQ;
    private boolean bkR;
    private String bkS;
    private ahe bkT;
    private boolean bkU;
    private apx bkV;
    private boolean bkW;
    private boolean bkX;
    private int bkY;
    private String bkZ;
    private final _cls02CB bkf = new _cls02CB((byte)0);
    private xy bkg;
    private aoo bkh;
    private aic bki;
    private View bkj;
    private ImageView bkk;
    private TextView bkl;
    private are bkm;
    private TextView bkn;
    private atn bko;
    private ImageView bkp;
    private TextureView bkq;
    private TextView bkr;
    private aey bks;
    private adl bkt;
    private agl bku;
    adx bkv;
    atr bkw;
    private afw bkx;
    private boolean bky;
    private boolean bkz;
    private final agq bla = new agq(this);
    private final aha blb = new aha(this);
    private final ahb blc = new ahb(this);
    private final ahc bld = new ahc(this);
    private yv mBroadcastCacheManager;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private zp mUserManager;

    public agp()
    {
        bgs = false;
        bkW = false;
        bkY = 0;
    }

    private void bN()
    {
        bkG = 0;
        bkH = 0;
        bgQ = 0;
        if (bkv != null)
        {
            bkv.bg();
        }
        abm.as();
        bkQ.bN();
    }

    private void bY()
    {
        if (bkO)
        {
            return;
        }
        if (aui.isEmpty(bei))
        {
            return;
        } else
        {
            bkO = true;
            xd.getEventBus()._mth02CA(bkt, false, 0);
            xd.getEventBus()._mth02CA(bgO, false, 0);
            xd.getEventBus()._mth02CA(bkT, false, 0);
            xd.getEventBus()._mth02CA(bhi, false, 0);
            return;
        }
    }

    private void bZ()
    {
        static final class _cls1
        {

            static final int $SwitchMap$tv$periscope$android$event$ApiEvent$Type[];
            static final int aUJ[];
            static final int bcB[];
            static final int bhK[];
            static final int blk[];
            static final int bll[];

            static 
            {
                bll = new int[aua.values().length];
                try
                {
                    bll[aua.bEq.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
                try
                {
                    bll[aua.bEr.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    bll[aua.bEs.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                bhK = new int[yb.values().length];
                try
                {
                    bhK[yb.aUl.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    bhK[yb.aUm.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    bhK[yb.aUn.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                bcB = new int[zw.values().length];
                try
                {
                    bcB[zw.aYJ.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    bcB[zw.aYI.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                $SwitchMap$tv$periscope$android$event$ApiEvent$Type = new int[zu.if.values().length];
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aYg.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXK.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXP.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXT.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXO.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXV.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                aUJ = new int[aug.values().length];
                try
                {
                    aUJ[aug.bEO.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    aUJ[aug.bEB.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                blk = new int[ahi.if.values().length];
                try
                {
                    blk[ahi.if.blu.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    blk[ahi.if.blw.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    blk[ahi.if.blv.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    blk[ahi.if.blx.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
            }
        }

        switch (_cls1.blk[bkB.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            bks.setVisibility(0);
            bks.setChatState$2bba3bc2(aey.if.bij);
            return;

        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            bhk.setVisibility(8);
            break;
        }
        bks.setVisibility(8);
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

    private void ca()
    {
        int i;
        switch (_cls1.blk[bkB.ordinal()])
        {
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            i = getResources().getDimensionPixelOffset(0x7f0900a3);
            break;

        default:
            i = 0;
            break;
        }
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)bgV.getLayoutParams();
        layoutparams.bottomMargin = i;
        bgV.setLayoutParams(layoutparams);
    }

    private void cb()
    {
        if (bkA != null)
        {
            bkA.kill();
        }
        switch (_cls1.blk[bkB.ordinal()])
        {
        case 1: // '\001'
            ql ql1 = xd.getEventBus();
            zp zp1 = mUserManager;
            agp agp1;
            if (bkR)
            {
                agp1 = this;
            } else
            {
                agp1 = null;
            }
            bkA = new yg(ql1, zp1, this, this, agp1);
            bkA.init();
            return;
        }
        ql ql2 = xd.getEventBus();
        zp zp2 = mUserManager;
        xw xw1 = aVa;
        boolean flag;
        if (bkv.bfE == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        agp agp2;
        if (bkR)
        {
            agp2 = this;
        } else
        {
            agp2 = null;
        }
        bkA = new yk(ql2, zp2, xw1, this, flag, agp2);
        bkA.init();
    }

    private boolean cc()
    {
        if (aUX != null && bkw != null)
        {
            xx xx1 = aUX;
            String s = bkw.fx();
            String s1 = bkw.fo().id();
            boolean flag;
            if (Objects.equals(xx1.aUj, s) && Objects.equals(xx1.aUk, s1))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                return true;
            }
        }
        return false;
    }

    private void cd()
    {
        if (bkw == null)
        {
            return;
        }
        switch (_cls1.bll[bkw.bEh.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            bgq.log("Chat State Changed: Connected");
            bks.setChatState$2bba3bc2(aey.if.bik);
            return;

        case 2: // '\002'
            bgq.log("Chat State Changed: Too Full");
            bks.setChatState$2bba3bc2(aey.if.bil);
            return;

        case 3: // '\003'
            bgq.log("Chat State Changed: Friends Only");
            break;
        }
        bks.setChatState$2bba3bc2(aey.if.bim);
    }

    private void ce()
    {
        if (bkJ)
        {
            return;
        }
        if (bkw == null)
        {
            _mth02CA(true, ((String) (null)));
            return;
        }
        bkJ = true;
        if (bkv != null && !bkv.bfL)
        {
            bkv.FE7A(bkK);
            ApiManager.get(this).replayViewed(bkw.fo().id(), bkw.fy());
        }
        bkA.clear();
        if (cc())
        {
            aVa._mth02CA(aUX, bkw.eG(), "0", "");
            if (bkK != 0L)
            {
                bkA.pause();
                bkz = true;
            }
        }
        ahw ahw1 = bgV;
        Object obj = new aud.if();
        obj.bEx = Integer.valueOf(0);
        obj = ((auf.if) (obj))._mth02CB(Integer.valueOf(2))._mth02CB(aug.bEP).gG();
        ahw1.bml._mth141D(((auf) (obj)));
        int i = ahw1.bml.getItemCount();
        ahw1.bmk._mth1507(i - 1);
    }

    private void cg()
    {
        if (bkE)
        {
            return;
        }
        bkE = true;
        mHandler.removeCallbacks(bkf);
        mHandler.removeCallbacks(blb);
        if (bkB == ahi.if.blu && bkv != null && bkv.bfL)
        {
            cp();
            if (bkw != null)
            {
                ApiManager apimanager = ApiManager.get(this);
                String s1 = bei;
                String s2 = bkw.fy();
                String s;
                if (bgs)
                {
                    s = bgq.getName();
                } else
                {
                    s = null;
                }
                apimanager.stopWatching(s1, s2, s, bkG, bkH, bkQ.bO());
            }
            HashMap hashmap = new HashMap();
            Object obj = abm.ar();
            hashmap.put("pubnub_total_sent", Integer.valueOf(abm.an()));
            hashmap.put("pubnub_total_received", Integer.valueOf(abm.ap()));
            hashmap.put("pubnub_total_presence", Integer.valueOf(abm.aq()));
            hashmap.put("pubnub_signer_dropped", Integer.valueOf(abm.am()));
            hashmap.put("pubnub_unreceived", Integer.valueOf(abm.ao()));
            hashmap.put("pubnub_ltnc_mean", Double.valueOf(((Snapshot) (obj)).getMean()));
            hashmap.put("pubnub_ltnc_median", Double.valueOf(((Snapshot) (obj)).getMedian()));
            hashmap.put("pubnub_ltnc_min", Long.valueOf(((Snapshot) (obj)).getMin()));
            hashmap.put("pubnub_ltnc_max", Long.valueOf(((Snapshot) (obj)).getMax()));
            hashmap.put("pubnub_ltnc_stddev", Double.valueOf(((Snapshot) (obj)).getStdDev()));
            hashmap.put("pubnub_ltnc_p95", Double.valueOf(((Snapshot) (obj)).get95thPercentile()));
            hashmap.put("pubnub_ltnc_p99", Double.valueOf(((Snapshot) (obj)).get99thPercentile()));
            hashmap.put("channel_chats_dropped", Integer.valueOf(bkA.FEDB()));
            hashmap.put("channel_hearts_dropped", Integer.valueOf(bkA.FF4B()));
            obj = new HashMap();
            ((HashMap) (obj)).put("n_screenshots", Integer.valueOf(bgQ));
            ChatStats chatstats = aVa.FED0();
            if (chatstats != null)
            {
                chatstats.pubnubFiltered = bkA._mth1D45(1);
                chatstats.chatManFiltered = bkA._mth1D45(2);
            }
            ApiManager.get(this).playbackMeta(bei, bkv.O(), hashmap, ((HashMap) (obj)), chatstats);
            bN();
        }
    }

    private void ch()
    {
        if (!bkJ)
        {
            return;
        }
        bkJ = false;
        bkK = 0L;
        if (bkB == ahi.if.blu || bkB == ahi.if.blx || bkv == null)
        {
            return;
        }
        long l1 = bkF;
        adx adx1 = bkv;
        long l;
        if (adx1.aZr != null)
        {
            l = adx1.aZr.getCurrentPosition();
        } else
        {
            l = 0L;
        }
        bkF = Math.max(l1, l);
        float f = bkF;
        adx1 = bkv;
        if (adx1.aZr != null)
        {
            l = adx1.aZr.aZb.getDuration();
        } else
        {
            l = 0L;
        }
        float f1 = f / (float)l;
        f = f1;
        if (f1 > 0.99F)
        {
            f = 1.0F;
        }
        FF9E(f);
        if (bkw != null)
        {
            ApiManager.get(this).endReplayViewed(bkw.fo().id(), bkw.fy(), bkQ.bO(), f, bkG);
        }
        bN();
    }

    private void ci()
    {
label0:
        {
            if (isFinishing() || bkv == null)
            {
                return;
            }
            boolean flag;
            if (bkB != null && bkB.bly)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && bkv.aVj)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (bkv.bfL && !flag)
            {
                adx adx1 = bkv;
                boolean flag2;
                if (adx1.bfH || adx1.aZr != null && adx1.aZr.getPlaybackState() == 5)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                if (!flag2)
                {
                    break label0;
                }
            }
            if (flag)
            {
                ck();
            } else
            {
                adx adx2 = bkv;
                boolean flag1;
                if (adx2.bfH || adx2.aZr != null && adx2.aZr.getPlaybackState() == 5)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag1 && bko != null)
                {
                    _cls1D5A _lcls1d5a = _cls1D3C._mth02CA(this);
                    String s = bko.ff();
                    ((_cls1D27)_lcls1d5a._mth02CA(java/lang/String).FF70(s))._mth05D5(0x7f0c0037)._mth0197()._mth02CA(new _cls0443[] {
                        new aam(this)
                    })._mth02CA(bkp);
                }
            }
            bkp.setVisibility(0);
            bkp.setAlpha(1.0F);
        }
        if (arx._mth1424(bha))
        {
            return;
        } else
        {
            bgt._mth14A1(bha);
            return;
        }
    }

    private void cj()
    {
        if (bkB != null && bkB.bly && bkv != null && bkv.aVj)
        {
            adx adx1 = bkv;
            adx1.aVj = false;
            if (adx1.aZr != null)
            {
                adx1.aZr.aZb.setPlayWhenReady(true);
            }
            bkA.resume();
        }
    }

    private void ck()
    {
        if (bkv == null)
        {
            return;
        }
        Bitmap bitmap = bkq.getBitmap();
        if (bitmap == null)
        {
            return;
        }
        float f;
        if (bkv.bgg == 1)
        {
            f = 90F;
        } else
        if (bkv.bgg == 3)
        {
            f = 270F;
        } else
        {
            f = 0.0F;
        }
        (new aoh(this, bitmap, f, 25, new agz(this))).start();
    }

    private void cl()
    {
        if (bkv != null)
        {
            bkv.release();
        }
        bkv = new adx(this, aWS, bkq, this);
        if (bkB != null && bkB.blz)
        {
            bkv.FE7A(0L);
        }
    }

    private boolean cm()
    {
label0:
        {
            if (bko == null || !bko.bDX)
            {
                break label0;
            }
            if (bkv.bfL)
            {
                adx adx1 = bkv;
                boolean flag;
                if (adx1.bfH || adx1.aZr != null && adx1.aZr.getPlaybackState() == 5)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    break label0;
                }
            }
            return true;
        }
        return false;
    }

    private void cn()
    {
        if (bkv == null)
        {
            return;
        }
        if (arx._mth1424(bha))
        {
            if (bkB == null)
            {
                return;
            }
            if (bkB.bly)
            {
                if (bkv.aVj)
                {
                    if (arx._mth1424(bha))
                    {
                        bgt._mth14A2(bha);
                        cj();
                    }
                    return;
                }
                if (cm())
                {
                    _mth02C0(true);
                    ce();
                    return;
                }
                if (bko != null && bko.bDX)
                {
                    if (arx._mth1424(bha))
                    {
                        bgt._mth14A2(bha);
                        cj();
                    }
                    return;
                }
            } else
            {
                adx adx1 = bkv;
                boolean flag;
                if (adx1.bfH || adx1.aZr != null && adx1.aZr.getPlaybackState() == 5)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    if (arx._mth1424(bha))
                    {
                        bgt._mth14A2(bha);
                        cj();
                    }
                    return;
                }
            }
        } else
        if (bkB == ahi.if.blu)
        {
            aey aey1 = bks;
            boolean flag1;
            if (aey1.bhU != aey._cls02CA.bio)
            {
                aey1.bhT.clearFocus();
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!flag1 && bkw != null)
            {
                int i = aok._mth02CA(getResources(), bkw.fw());
                bkG = bkG + 1;
                aib aib1 = bgU;
                aix aix1 = aib1.bmJ.FB40(i);
                aib1.bmI._mth02CA(aix1, aib1, true);
                co();
                if (_mth02CA(aug.bEA) && !bki.cr())
                {
                    Object obj = bkw.fx();
                    String s = aWS.id;
                    int j = bkw.fw();
                    adx adx2 = bkv;
                    long l;
                    if (adx2.bfX == 0.0D)
                    {
                        l = apb.ec().getTime();
                    } else
                    {
                        l = (long)((adx2.bfX - 2208988800D) * 1000D);
                    }
                    obj = auf._mth02CA(((String) (obj)), s, Integer.valueOf(j), l, apb.ec().getTime());
                    bgq.log((new StringBuilder("send heart (live) #")).append(bkG).toString());
                    aVa._mth02CA(bkw.fC(), ((auf) (obj)));
                    return;
                }
            }
        } else
        {
            int k = aok._mth02CA(getResources(), -1);
            bkG = bkG + 1;
            aib aib2 = bgU;
            aix aix2 = aib2.bmJ.FB40(k);
            aib2.bmI._mth02CA(aix2, aib2, true);
            co();
        }
    }

    private void co()
    {
        if (bkw == null)
        {
            return;
        }
        Object obj;
        if (super.bdr != null)
        {
            obj = super.bdr;
        } else
        {
            obj = new qe();
        }
        xf._mth02CA((xh)obj);
        _mth02CA(aWS.id, bkw.fw(), true);
    }

    private void cp()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("n_hearts", String.valueOf(bkG));
        hashmap.put("n_chats", String.valueOf(bkH));
        xf._mth02CA(xf.if.aRS, hashmap);
    }

    static ApiManager _mth02B3(agp agp1)
    {
        return ApiManager.get(agp1);
    }

    static boolean _mth02B4(agp agp1)
    {
        return agp1.cc();
    }

    static int _mth02B9(agp agp1)
    {
        int i = agp1.bgQ;
        agp1.bgQ = i + 1;
        return i;
    }

    static ahi.if _mth02BB(agp agp1)
    {
        return agp1.bkB;
    }

    private void _mth02BB(atn atn1)
    {
        _mth02CA(false, ((String) (null)));
        bkj.setVisibility(0);
        if (atn1 != null)
        {
            long l = atn1.bDV;
            atn1 = bkl;
            if (l == 0L)
            {
                l = System.currentTimeMillis();
            }
            atn1.setText(aos._mth02CA(this, l));
            return;
        } else
        {
            bkl.setText(aos._mth02CA(this, System.currentTimeMillis()));
            return;
        }
    }

    static qh _mth02BC(agp agp1)
    {
        if (((acp) (agp1)).bdr != null)
        {
            return ((acp) (agp1)).bdr;
        } else
        {
            return new qe();
        }
    }

    static qh _mth02BD(agp agp1)
    {
        if (((acp) (agp1)).bdr != null)
        {
            return ((acp) (agp1)).bdr;
        } else
        {
            return new qe();
        }
    }

    private boolean _mth02BD(Intent intent)
    {
        (new aby(this))._mth02BC(intent);
        bei = intent.getStringExtra("e_b_id");
        Object obj;
        if (super.bdr != null)
        {
            obj = super.bdr;
        } else
        {
            obj = new qe();
        }
        ((qh) (obj)).setAttribute("Summary.BroadcastID", bei);
        bhp = intent.getStringExtra("e_saved_file");
        bkU = intent.getBooleanExtra("e_saved", false);
        bkK = intent.getLongExtra("e_playtime", 0L);
        if (aui._mth02BF(bei))
        {
            intent = (ahi.if)intent.getSerializableExtra("e_p_mode");
            if (intent == null)
            {
                intent = new ArrayList(1);
                intent.add(bei);
                ApiManager.get(this).refreshLiveBroadcasts(intent);
                return false;
            } else
            {
                _mth02CB(intent);
                return true;
            }
        }
        intent = _mth037A(intent);
        xf._mth1D54("Direct", intent);
        if (aui._mth02BF(intent))
        {
            ApiManager.get(this).getBroadcastIdForShareToken(intent);
        }
        return false;
    }

    static Handler _mth02BE(agp agp1)
    {
        return agp1.mHandler;
    }

    static boolean _mth02BF(agp agp1)
    {
label0:
        {
            boolean flag;
            if (agp1.bku != null && agp1.bku.bjX)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                boolean flag1;
                if (agp1.bkT != null && ((acy) (agp1.bkT)).bdJ.buH)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (!flag1)
                {
                    boolean flag2;
                    if (agp1.bgK != null && agp1.bgK.buH)
                    {
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                    if (!flag2)
                    {
                        boolean flag3;
                        if (agp1.bhq != null && agp1.bhq.aO())
                        {
                            flag3 = true;
                        } else
                        {
                            flag3 = false;
                        }
                        if (!flag3)
                        {
                            boolean flag4;
                            if (agp1.bgt != null && arx._mth1424(agp1.bha))
                            {
                                flag4 = true;
                            } else
                            {
                                flag4 = false;
                            }
                            if (!flag4)
                            {
                                break label0;
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    private void _mth02C0(boolean flag)
    {
        if (bkB == ahi.if.blu)
        {
            boolean flag1;
            if (bko.bDW == ato.bEd)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                bha.setActionButtonVisibility(true);
                bha.bfw.setImageResource(0x7f0200d8);
                bkk.setVisibility(8);
                return;
            }
        }
        if (flag)
        {
            bkk.setImageResource(0x7f0200f7);
            bha.bfw.setImageResource(0x7f0200f7);
        } else
        {
            bkk.setImageResource(0x7f0200f9);
            bha.bfw.setImageResource(0x7f0200f9);
        }
        bkC = flag;
    }

    private void _mth02C1(boolean flag)
    {
        if (bkI == null || bkI.booleanValue() != flag)
        {
            bkI = Boolean.valueOf(flag);
            if (bkB == ahi.if.blu)
            {
                bha.setActionButtonVisibility(true);
                bha.bfw.setImageResource(0x7f0200d8);
                bkk.setVisibility(8);
                return;
            }
            bha.setActionButtonVisibility(flag);
            if (flag)
            {
                bkk.setVisibility(0);
                return;
            }
            bkk.setVisibility(8);
        }
    }

    static xx _mth02C6(agp agp1)
    {
        return agp1.aUX;
    }

    static void _mth02C7(agp agp1)
    {
        agp1.bkp.animate().alpha(0.0F).setDuration(180L).setListener(new ahf(agp1)).start();
    }

    static afw _mth02C8(agp agp1)
    {
        return agp1.bkx;
    }

    static TextureView _mth02C9(agp agp1)
    {
        return agp1.bkq;
    }

    static int _mth02CA(agp agp1, int i)
    {
        i = agp1.bkY | 2;
        agp1.bkY = i;
        return i;
    }

    static String _mth02CA(agp agp1, String s)
    {
        agp1.bkZ = s;
        return s;
    }

    static aia _mth02CA(agp agp1, aia aia1)
    {
        agp1.biz = null;
        return null;
    }

    static void _mth02CA(agp agp1, String s, auf auf1)
    {
        agp1._mth02CB(s, auf1);
    }

    static void _mth02CA(agp agp1, boolean flag, String s)
    {
        agp1._mth02CA(true, s);
    }

    private void _mth02CA(ahi.if if1)
    {
        if (bkQ != null)
        {
            bkQ.kill();
        }
        switch (_cls1.blk[if1.ordinal()])
        {
        case 4: // '\004'
            bkQ = new agh(this, ApiManager.get(this), xd.getEventBus(), bei, mBroadcastCacheManager, bgO);
            break;

        case 2: // '\002'
        case 3: // '\003'
            bkQ = new afs(this, ApiManager.get(this), xd.getEventBus(), bei, mBroadcastCacheManager, bgO);
            break;

        case 1: // '\001'
            bkQ = new agg(this, ApiManager.get(this), xd.getEventBus(), bei, mBroadcastCacheManager, bgO);
            break;
        }
        bkQ.init();
    }

    private void _mth02CA(boolean flag, String s)
    {
        if (flag)
        {
            bkj.setVisibility(8);
            are are1 = bkm;
            are1.setVisibility(0);
            are1.FE7B = false;
            are1.bBk.addUpdateListener(are1.bBj);
            are1.bBk.start();
            bkn.setVisibility(0);
            if (aui._mth02BF(s))
            {
                bkn.setText(s);
                return;
            } else
            {
                bkm.setTag(Integer.valueOf(0x7f0600e3));
                return;
            }
        } else
        {
            bkm.bBl.start();
            bkn.setVisibility(8);
            return;
        }
    }

    static boolean _mth02CA(agp agp1, int i, long l)
    {
        return agp1._mth02CF(i, 30L);
    }

    static boolean _mth02CA(agp agp1, aug aug1)
    {
        return agp1._mth02CA(aug1);
    }

    static boolean _mth02CA(agp agp1, boolean flag)
    {
        agp1.bkM = false;
        return false;
    }

    private void _mth02CB(String s, auf auf1)
    {
        if (bkv != null && bkv.bfL)
        {
            ahw ahw1 = bgV;
            ahw1.bml._mth141D(auf1);
            int i = ahw1.bml.getItemCount();
            ahw1.bmk._mth1507(i - 1);
        }
        bkS = s;
        xf._mth02CA(xf.if.aRI);
        bkH = bkH + 1;
        bgq.log((new StringBuilder("sendChat #")).append(bkH).toString());
        aVa._mth02CA(bkw.fC(), auf1);
    }

    static void _mth02CB(agp agp1)
    {
        agp1.bgt.setSystemUiVisibility(1);
    }

    static void _mth02CB(agp agp1, int i)
    {
        switch (i)
        {
        default:
            return;

        case 0: // '\0'
            break;
        }
        if (agp1.bku != null && agp1.bkP)
        {
            agp1.bkP = false;
            agp1._mth037A(((File) (null)));
        }
    }

    static void _mth02CB(agp agp1, boolean flag)
    {
        agp1._mth02C0(true);
    }

    static aey _mth02CC(agp agp1)
    {
        return agp1.bks;
    }

    static atr _mth02CD(agp agp1)
    {
        return agp1.bkw;
    }

    static void _mth02CE(agp agp1)
    {
        if (agp1.bkv == null || agp1.bkX)
        {
            return;
        }
        int i = agp1.bkv.bgg;
        if (agp1.bkW || !_cls141D.if._mth02CB(agp1) || i != 4 && i != 0)
        {
            long l;
            if (agp1.bkW)
            {
                l = 5000L;
            } else
            {
                l = 100L;
            }
            if (agp1._mth02CF(i, l))
            {
                agp1.bkW = true;
            } else
            {
                if (agp1.bkV != null)
                {
                    int j = agp1.getResources().getColor(0x7f0c0037);
                    agp1.bkV._mth02CA(j, j, j, j, 100L);
                }
                return;
            }
        }
        agp1.mHandler.removeCallbacks(agp1.blb);
        agp1.mHandler.postDelayed(agp1.blb, 5000L);
    }

    static boolean _mth02CE(agp agp1, boolean flag)
    {
        agp1.bkz = flag;
        return flag;
    }

    static adx _mth02CF(agp agp1)
    {
        return agp1.bkv;
    }

    private boolean _mth02CF(int i, long l)
    {
        Bitmap bitmap;
        Bitmap bitmap1;
        Object obj;
        Bitmap bitmap3;
        if (bkX)
        {
            return false;
        }
        bitmap3 = null;
        obj = null;
        bitmap = obj;
        bitmap1 = bitmap3;
        if (bkV != null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        bitmap = obj;
        bitmap1 = bitmap3;
        bkV = (apx)((ViewStub)findViewById(0x7f0d01b5)).inflate();
        bitmap = obj;
        bitmap1 = bitmap3;
        bitmap3 = bkq.getBitmap();
        Bitmap bitmap2 = bitmap3;
        if (bitmap3 != null)
        {
            {
                bitmap = bitmap2;
                bitmap1 = bitmap2;
                try
                {
                    bkV.setBitmapPixels(bitmap2, i, l);
                    break MISSING_BLOCK_LABEL_162;
                }
                // Misplaced declaration of an exception variable
                catch (OutOfMemoryError outofmemoryerror)
                {
                    bitmap = bitmap1;
                }
                finally
                {
                    if (bitmap != null)
                    {
                        bitmap.recycle();
                    }
                    throw exception;
                }
            }
            break MISSING_BLOCK_LABEL_178;
        }
        bitmap = bitmap2;
        bitmap1 = bitmap2;
        if (bkV == null)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        bitmap = bitmap2;
        bitmap1 = bitmap2;
        i = getResources().getColor(0x7f0c0037);
        bitmap = bitmap2;
        bitmap1 = bitmap2;
        bkV._mth02CA(i, i, i, i, 100L);
        if (bitmap2 != null)
        {
            bitmap2.recycle();
        }
        return true;
        bkX = true;
        if (bitmap1 != null)
        {
            bitmap1.recycle();
        }
        break MISSING_BLOCK_LABEL_211;
        OutOfMemoryError outofmemoryerror;
        return false;
    }

    static boolean _mth02CF(agp agp1, boolean flag)
    {
        agp1.bky = flag;
        return flag;
    }

    static ImageView _mth02D1(agp agp1)
    {
        return agp1.bkp;
    }

    static void _mth02E1(agp agp1)
    {
        agp1.cj();
    }

    static void _mth02EE(agp agp1)
    {
        agp1.ce();
    }

    private static String _mth037A(Intent intent)
    {
        intent = intent.getData().getPathSegments();
        if ("w".equals(intent.get(0)) || intent.size() == 2)
        {
            return (String)intent.get(1);
        } else
        {
            return "";
        }
    }

    static String _mth037A(agp agp1)
    {
        return agp1.bei;
    }

    private void _mth037A(File file)
    {
        if (bkw != null)
        {
            atn atn1 = bkw.fo();
            String s1 = atn1.eS();
            String s = s1;
            if (aui.isEmpty(s1))
            {
                s = "";
            }
            if (!TextUtils.isEmpty(atn1.fj()) && !atn1.fd().equals(aWS.id))
            {
                s = getString(0x7f060154, new Object[] {
                    s, atn1.fj()
                });
                if (s.charAt(0) == '@')
                {
                    s = (new StringBuilder(".")).append(s).toString();
                }
            } else
            {
                s = getString(0x7f060153, new Object[] {
                    s
                });
            }
            if (cc())
            {
                xj xj1;
                if (bkB == ahi.if.blu)
                {
                    xj1 = new xj(xf.if.aSQ, xf.if.aSS, xf.if.aSR);
                } else
                {
                    xj1 = new xj(xf.if.aST, xf.if.aSV, xf.if.aSU);
                }
                bku._mth02CA(s, bkw.fG(), file, xj1);
            }
        }
    }

    static qh _mth0559(agp agp1)
    {
        if (((acp) (agp1)).bdr != null)
        {
            return ((acp) (agp1)).bdr;
        } else
        {
            return new qe();
        }
    }

    static agi _mth05D9(agp agp1)
    {
        return agp1.bhf;
    }

    static agl _mth0640(agp agp1)
    {
        return agp1.bku;
    }

    static ahw _mth0674(agp agp1)
    {
        return agp1.bgV;
    }

    static arx _mth06E5(agp agp1)
    {
        return agp1.bgt;
    }

    static atn _mth141D(agp agp1)
    {
        return agp1.bko;
    }

    static adh _mth1420(agp agp1)
    {
        return agp1.bhq;
    }

    static Runnable _mth1423(agp agp1)
    {
        return agp1.bla;
    }

    static PsUser _mth1427(agp agp1)
    {
        return agp1.aWS;
    }

    static int _mth1428(agp agp1)
    {
        return agp1.bkY;
    }

    static Runnable _mth1429(agp agp1)
    {
        return agp1.blc;
    }

    static Runnable _mth144A(agp agp1)
    {
        return agp1.blb;
    }

    static ya _mth1540(agp agp1)
    {
        return agp1.bkA;
    }

    static aib _mth1D35(agp agp1)
    {
        return agp1.bgU;
    }

    static boolean _mth1D4E(agp agp1)
    {
        return agp1.bkE;
    }

    static String _mth1D54(agp agp1)
    {
        if (agp1.bgs)
        {
            return agp1.bgq.getName();
        } else
        {
            return null;
        }
    }

    static ApiManager _mth1D62(agp agp1)
    {
        return ApiManager.get(agp1);
    }

    static ahi _mth1FBE(agp agp1)
    {
        return agp1.bkQ;
    }

    static anq _mth2071(agp agp1)
    {
        return agp1.bhi;
    }

    static abc FE73(agp agp1)
    {
        return agp1.bgq;
    }

    static adu FE76(agp agp1)
    {
        return agp1.bha;
    }

    static ImageView FE7A(agp agp1)
    {
        return agp1.bkk;
    }

    static void FF70(agp agp1)
    {
        agp1.bgt.setSystemUiVisibility(0);
    }

    static xw FF9E(agp agp1)
    {
        return agp1.aVa;
    }

    private void FF9E(float f)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("n_hearts", String.valueOf(bkG));
        xf._mth02CA(xf.if.aRT, hashmap);
        if (f == 1.0F)
        {
            xf._mth02CA(xf.if.aSa);
        }
    }

    public final long J()
    {
        if (bkv != null)
        {
            adx adx1 = bkv;
            if (adx1.aZr != null)
            {
                return adx1.aZr.getCurrentPosition();
            } else
            {
                return 0L;
            }
        } else
        {
            return 0L;
        }
    }

    public final long K()
    {
        if (bkv != null)
        {
            adx adx1 = bkv;
            if (adx1.aZr != null)
            {
                return adx1.aZr.aZb.getDuration();
            } else
            {
                return 0L;
            }
        } else
        {
            return -1L;
        }
    }

    public final long L()
    {
        if (bkv != null)
        {
            return (long)((bkv.bfX - 2208988800D) * 1000D);
        } else
        {
            return 0L;
        }
    }

    protected final String aI()
    {
        return "View Broadcast";
    }

    protected final boolean aJ()
    {
        return true;
    }

    public final void aX()
    {
        bgV.setVisibility(8);
        bgU.setVisibility(8);
        aey aey1 = bks;
        aey1.bA();
        aey1.bhX.setVisibility(4);
    }

    public final void aY()
    {
        bgV.setVisibility(0);
        bgU.setVisibility(0);
        bks.bhX.setVisibility(0);
    }

    public final boolean aZ()
    {
        return bgV.getVisibility() == 0;
    }

    public final void bU()
    {
        bhq.dC();
        bkP = true;
    }

    public final void bV()
    {
        bhq.dC();
        if (bkw != null)
        {
            ((ClipboardManager)getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(bkw.fo().eS(), bkw.fG()));
            Toast.makeText(this, 0x7f060148, 0).show();
            return;
        } else
        {
            Toast.makeText(this, 0x7f060149, 0).show();
            return;
        }
    }

    public final void bn()
    {
        if (isFinishing())
        {
            return;
        }
        bgq.log("onPlaybackStarted");
        bkQ.bn();
        _mth02CA(false, ((String) (null)));
        bkD = true;
        bkp.animate().alpha(0.0F).setDuration(180L).setListener(new ahf(this)).start();
        if (arx._mth1424(bha))
        {
            bgt._mth14A2(bha);
            cj();
        }
        switch (_cls1.blk[bkB.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            Object obj;
            if (super.bdr != null)
            {
                obj = super.bdr;
            } else
            {
                obj = new qe();
            }
            ((qh) (obj))._mth06E6("Summary.TimeWatched");
            return;

        case 2: // '\002'
        case 3: // '\003'
            break;
        }
        Object obj1;
        if (super.bdr != null)
        {
            obj1 = super.bdr;
        } else
        {
            obj1 = new qe();
        }
        ((qh) (obj1))._mth06E6("Summary.ReplayTimeWatched");
    }

    public final void bo()
    {
        if (isFinishing())
        {
            return;
        }
        bgq.log("onPlaybackEnded");
        bkQ.bo();
        if (bkx.FE7B)
        {
            bkx.bT();
        }
        _mth02BB(bko);
        ch();
        ci();
        _mth02C0(false);
    }

    public final void bp()
    {
        if (isFinishing())
        {
            return;
        } else
        {
            bgq.log("onPlaybackRequested");
            bkQ.bp();
            _mth02CA(true, ((String) (null)));
            return;
        }
    }

    public final void bq()
    {
        if (isFinishing())
        {
            return;
        }
        bgq.log("onPlaybackBuffer");
        bkQ.bq();
        if (bkM)
        {
            return;
        }
        if (bkD && bkv != null)
        {
            adx adx1 = bkv;
            boolean flag;
            if (adx1.bfH || adx1.aZr != null && adx1.aZr.getPlaybackState() == 5)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag && !bkv.aVj)
            {
                mHandler.postDelayed(blc, 1000L);
                bkM = true;
                if (!bkN)
                {
                    mHandler.postDelayed(bld, 5000L);
                    bkN = true;
                }
            }
        }
    }

    public final void br()
    {
        ((android.support.v7.widget.RecyclerView.if) (bgV.bml)).ey.notifyChanged();
    }

    public final void bw()
    {
        cg();
        if (bkv != null)
        {
            bkv.bl();
        }
        _mth02BB(bko);
        if (bkB == ahi.if.blu)
        {
            aey aey1 = bks;
            if (aey1.bib.isShowing())
            {
                aey1.bib.dismiss();
            }
            bks.setVisibility(8);
            aey1 = bks;
            if (aey1 != null)
            {
                ((InputMethodManager)aey1.getContext().getSystemService("input_method")).hideSoftInputFromWindow(aey1.getWindowToken(), 0);
            }
        }
        ci();
        _mth02C0(false);
        bgt.setDraggable(false);
    }

    public final void bx()
    {
        bko.bDX = true;
        _mth02CB(ahi.if.blv);
        bgt.setDraggable(true);
    }

    public final void cf()
    {
        bw();
    }

    public final long getCurrentTimeMillis()
    {
        if (bkv != null)
        {
            adx adx1 = bkv;
            if (adx1.bfX == 0.0D)
            {
                return apb.ec().getTime();
            } else
            {
                return (long)((adx1.bfX - 2208988800D) * 1000D);
            }
        } else
        {
            return 0L;
        }
    }

    public void onBackPressed()
    {
        boolean flag;
        if (bku != null && bku.bjX)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            bku.bW();
            return;
        }
        if (bkT != null && ((acy) (bkT)).bdJ.buH)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            ahe ahe1 = bkT;
            if (((acy) (ahe1)).bdJ.buH)
            {
                ((acy) (ahe1)).bdJ._mth02CB(null);
            }
            return;
        }
        if (bgK != null && bgK.buH)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
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
        if (bhq != null && bhq.aO())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            bhq.dC();
            return;
        }
        if (bgt != null && arx._mth1424(bha))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && bkv != null)
        {
            adx adx1 = bkv;
            boolean flag1;
            if (adx1.bfH || adx1.aZr != null && adx1.aZr.getPlaybackState() == 5)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!flag1 && bkv.bfL && !bkv.aVj)
            {
                if (arx._mth1424(bha))
                {
                    bgt._mth14A2(bha);
                    cj();
                }
                return;
            }
        }
        super.onBackPressed();
        overridePendingTransition(0x7f04000a, 0x7f04000f);
    }

    public final void onCancel()
    {
        cn();
    }

    public void onClick(View view)
    {
        if (isFinishing())
        {
            return;
        }
        switch (view.getId())
        {
        default:
            return;

        case 2131558565: 
            xf._mth02CA(xf.if.aRM);
            ci();
            return;

        case 2131558650: 
            onBackPressed();
            return;

        case 2131558839: 
            cn();
            return;

        case 2131558508: 
        case 2131558843: 
            break;
        }
        if (bkB != null)
        {
            if (bkB.bly)
            {
                if (bkv.aVj)
                {
                    if (arx._mth1424(bha))
                    {
                        bgt._mth14A2(bha);
                        cj();
                    }
                    _mth02C0(true);
                    return;
                }
                if (bkv.bfL)
                {
                    if (super.bdr != null)
                    {
                        view = super.bdr;
                    } else
                    {
                        view = new qe();
                    }
                    xf._mth02CE((xh)view);
                    view = bkv;
                    view.aVj = true;
                    if (((adx) (view)).aZr != null)
                    {
                        ((adx) (view)).aZr.aZb.setPlayWhenReady(false);
                    }
                    bkA.pause();
                    ci();
                    _mth02C0(false);
                    return;
                } else
                {
                    ce();
                    _mth02C0(true);
                    return;
                }
            }
            if (bkB == ahi.if.blu && arx._mth1424(bha))
            {
                bgt._mth14A2(bha);
                cj();
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (biz != null)
        {
            configuration = biz;
            if (((aia) (configuration)).biv != null && ((aia) (configuration)).biv.isShowing())
            {
                configuration.bmH = true;
                ((aia) (configuration)).biv.dismiss();
                configuration.biv = null;
                configuration.show();
            }
        }
        if (bkV != null)
        {
            bkV.ek();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bke++;
        _cls0675.setInt("num viewed broadcasts", bke);
        setContentView(0x7f030095);
        getWindow().setBackgroundDrawable(null);
        getWindow().addFlags(128);
        mUserManager = xd._mth1FEA();
        aWS = mUserManager.H();
        bkg = new xy(xd._mth304F());
        bkh = new aoo();
        bkh._mth02CA(this);
        if (yo._mth02CA(mUserManager))
        {
            if (PreferenceManager.getDefaultSharedPreferences(this).getBoolean("pref_show_channel_info", false))
            {
                findViewById(0x7f0d010d).setVisibility(0);
                bkR = true;
            } else
            {
                findViewById(0x7f0d010d).setVisibility(8);
            }
        } else
        {
            findViewById(0x7f0d010d).setVisibility(8);
        }
        bki = new aic(25, 500, 4);
        aVa = new xw(_cls30CE.if._mth02CB(this), _cls30CE.if._mth02CF(this));
        mBroadcastCacheManager = xd._mth216D();
        bundle = (new StringBuilder("ViewerActivity")).append(System.currentTimeMillis()).toString();
        Object obj = getFilesDir();
        bgq = new abc(new abd.if(bundle, "viewer_log", ".txt", (new StringBuilder()).append(((File) (obj)).getAbsolutePath()).append(File.separator).append("viewer_logs").toString()));
        abj.if.al()._mth02CA(bgq);
        bundle = bgq;
        FF6A.ma.set(bundle);
        bgq.log("==================================================");
        bgq.log((new StringBuilder("Android OS Version: ")).append(aos.dF()).toString());
        bgq.log((new StringBuilder("Model Info: ")).append(aos.dG()).toString());
        bgq.log((new StringBuilder("App Version: ")).append(aos._mth02CA(this)).toString());
        if (!bkX)
        {
            try
            {
                bkV = (apx)((ViewStub)findViewById(0x7f0d01b5)).inflate();
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bkX = true;
            }
        }
        bgt = (arx)findViewById(0x7f0d0091);
        bgt.setDraggable(true);
        bgt.setOnViewDragListener(new _cls02CA((byte)0));
        bgt.setOnSystemUiVisibilityChangeListener(new if((byte)0));
        bhk = findViewById(0x7f0d00a5);
        bhk.setOnClickListener(this);
        bkr = (TextView)bhk.findViewById(0x7f0d00b2);
        bks = (aey)findViewById(0x7f0d01ba);
        bks.setSendCommentDelegate(this);
        findViewById(0x7f0d00fa).setOnClickListener(this);
        bkj = findViewById(0x7f0d01bc);
        bkl = (TextView)bkj.findViewById(0x7f0d01be);
        bkm = (are)findViewById(0x7f0d011c);
        bkn = (TextView)findViewById(0x7f0d01b9);
        bkq = (TextureView)findViewById(0x7f0d01b7);
        bdJ = (aqf)findViewById(0x7f0d00a7);
        bgU = (aib)findViewById(0x7f0d00a3);
        bgV = (ahw)findViewById(0x7f0d00a4);
        bha = (adu)findViewById(0x7f0d00a6);
        bha.setOnClickListener(this);
        bkk = (ImageView)findViewById(0x7f0d01bb);
        bkk.setOnClickListener(this);
        bkp = (ImageView)findViewById(0x7f0d007c);
        bkx = new afw((aft)findViewById(0x7f0d01b8));
        bkx.bjt = this;
        bkx.bju = new _cls02CE((byte)0);
        bkq.setHapticFeedbackEnabled(true);
        bkq.setOnClickListener(this);
        obj = new _cls02CF(new arb(this, new ahd(this)), bkx);
        bkq.setOnTouchListener(((android.view.View.OnTouchListener) (obj)));
        bkT = new ahe(this, this, ApiManager.get(this), mUserManager, bdJ);
        bdJ.setDelegate(bkT);
        bgK = (ans)findViewById(0x7f0d00a8);
        bundle = bgK;
        ((ans) (bundle)).buu.setText(0x7f06014e);
        ((ans) (bundle)).buv.setText(0x7f06014b);
        bundle.buE = 0x7f0d0187;
        bundle.buA = 0x7f06014a;
        bundle.buB = 0x7f06014a;
        bhi = new anq(ApiManager.get(this), bgK, zs.aWX);
        arx arx1 = bgt;
        apk apk1 = (apk)findViewById(0x7f0d00a9);
        ahe ahe1 = bkT;
        if (super.bdr != null)
        {
            bundle = super.bdr;
        } else
        {
            bundle = new qe();
        }
        bhq = new adh(arx1, apk1, ahe1, this, bundle);
        bundle = new ahk(this, this, this);
        bgV.setChatAdapter(bundle);
        bgV.setOnTouchListener(((android.view.View.OnTouchListener) (obj)));
        bgV.setOnInterceptTouchEventListener(((android.view.View.OnTouchListener) (obj)));
        bgt._mth14A1(bha);
        bks.bhV.add(this);
        bgO = new ahl(this, aWS.id, yo._mth02CA(this, mUserManager));
        bkt = new adl(this, ApiManager.get(this), bhq, bkT, this, this);
        bhd = new adw(this, mUserManager, mBroadcastCacheManager, bkt);
        bhc = new adj(this, bhd, bkt);
        bundle = xd._mth1FEB();
        if (((ack) (bundle)).bde == null)
        {
            bundle.aG();
        }
        bundle = _cls141D.if._mth02CA(((ack) (bundle)).bde, mUserManager);
        if (bundle != null)
        {
            bundle = bundle.getUserName();
            if (bundle != null)
            {
                ack ack1 = xd._mth1FEB();
                if (ack1.bde == null)
                {
                    ack1.aG();
                }
                bhf = _cls026B._cls02CB._mth02CA(this, ack1.bde, mUserManager);
                bku = new agl(findViewById(0x7f0d0091), this, (ask)findViewById(0x7f0d01bf), bundle);
            }
        }
        if (_mth02BD(getIntent()))
        {
            bY();
        }
    }

    protected void onDestroy()
    {
        bgq.log("onDestroy");
        if (bkQ != null)
        {
            bkQ.kill();
        }
        Object obj = xd.getEventBus();
        if (bkO)
        {
            bkO = false;
            if (bkT != null)
            {
                ((ql) (obj)).unregister(bkT);
            }
            if (bkt != null)
            {
                ((ql) (obj)).unregister(bkt);
            }
            if (bhi != null)
            {
                ((ql) (obj)).unregister(bhi);
            }
            if (bgO != null)
            {
                ((ql) (obj)).unregister(bgO);
            }
        }
        if (bkv != null)
        {
            bkv.release();
            bkv = null;
        }
        if (bkA != null)
        {
            bkA.kill();
        }
        aVa.kill();
        if (bgO != null)
        {
            bgO.blO.clear();
        }
        if (bhc != null)
        {
            obj = bhc.bet.iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                aqc aqc1 = (aqc)((Iterator) (obj)).next();
                if (aqc1.mCreated)
                {
                    aqc1.bzH.onDestroy();
                }
            } while (true);
            bhc.bet.clear();
        }
        if (aui._mth02BF(bhp) && bkt != null && !bkt.ba())
        {
            (new File(bhp)).delete();
        }
        obj = abj.if.al();
        abc abc1 = bgq;
        ((abj) (obj)).bcc.remove(abc1.getName(), abc1);
        obj = bgq;
        FF6A.ma.compareAndSet(obj, null);
        bgq.close();
        super.onDestroy();
    }

    public final void onError(Exception exception)
    {
        if (exception instanceof aaj)
        {
            Toast.makeText(this, "Unsupported DRM exception", 1).show();
        }
        bkQ.onError(exception);
    }

    public void onEventMainThread(abl abl1)
    {
        if (abl1 != null)
        {
            bgq.log(_cls141D.if._mth02CA(abl1.bcf));
            return;
        } else
        {
            bgq.log("Received network activity but info was empty");
            return;
        }
    }

    public void onEventMainThread(yb yb1)
    {
        if (isFinishing())
        {
            return;
        }
        switch (_cls1.bhK[yb1.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (_mth02CA(aug.bEB))
            {
                long l;
                if (bkv != null)
                {
                    yb1 = bkv;
                    if (((adx) (yb1)).bfX == 0.0D)
                    {
                        l = apb.ec().getTime();
                    } else
                    {
                        l = (long)((((adx) (yb1)).bfX - 2208988800D) * 1000D);
                    }
                } else
                {
                    l = 0L;
                }
                yb1 = auf._mth02CA(bkw.fx(), aWS.username, aWS.displayName, aWS.initials, aWS.id, aWS.getProfileUrlMedium(), Integer.valueOf(bkw.fw()), l, apb.ec().getTime());
                aVa._mth02CA(bkw.fC(), yb1);
                aVa._mth02CB(aUX);
                return;
            }
            break;

        case 2: // '\002'
            bks.setChatState$2bba3bc2(aey.if.bij);
            return;

        case 3: // '\003'
            cd();
            break;
        }
    }

    public void onEventMainThread(ye ye1)
    {
        if (!bkL && "0".equals(ye1.prevCursor))
        {
            bkL = true;
        }
    }

    public void onEventMainThread(zu zu1)
    {
        switch (_cls1..SwitchMap.tv.periscope.android.event.ApiEvent.Type[zu1.aXk.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            boolean flag;
            if (zu1.aXl == null && zu1.mU == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && bei != null)
            {
                zu1 = mBroadcastCacheManager;
                String s = bei;
                zu1 = (atn)((yv) (zu1)).aWg.get(s);
                if (zu1 == null)
                {
                    return;
                }
                if (bkB == null)
                {
                    boolean flag1;
                    if (((atn) (zu1)).bDW == ato.bEd)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (flag1)
                    {
                        zu1 = ahi.if.blu;
                    } else
                    {
                        zu1 = ahi.if.blv;
                    }
                    _mth02CB(zu1);
                    bY();
                    return;
                }
                if (bkB == ahi.if.blu && bkv != null && bkv.bm())
                {
                    int i = ((atn) (zu1)).bDW;
                    boolean flag2;
                    if (i == ato.bEf || i == ato.bEe)
                    {
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                    if (flag2)
                    {
                        bgq.log("BroadcastPlayer is buffering but API told us it ended.");
                        bw();
                        mHandler.removeCallbacks(bld);
                        bkN = false;
                    }
                }
                return;
            }
            break;

        case 2: // '\002'
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
                bei = ((BroadcastResponse)zu1.data).broadcastId;
                if (super.bdr != null)
                {
                    zu1 = super.bdr;
                } else
                {
                    zu1 = new qe();
                }
                zu1.setAttribute("Summary.BroadcastID", bei);
                _mth02CB(ahi.if.blu);
                bY();
                return;
            } else
            {
                finish();
                return;
            }

        case 3: // '\003'
            if (bei != null)
            {
                boolean flag4;
                if (zu1.aXl == null && zu1.mU == null)
                {
                    flag4 = true;
                } else
                {
                    flag4 = false;
                }
                if (flag4)
                {
                    zu1 = (ThumbnailPlaylistResponse)zu1.data;
                    if (bei.equals(((ThumbnailPlaylistResponse) (zu1)).broadcastId))
                    {
                        bkx._mth02BF(((ThumbnailPlaylistResponse) (zu1)).chunks);
                    }
                    return;
                }
            }
            bkx._mth02BF(null);
            return;

        case 4: // '\004'
            boolean flag5;
            if (zu1.aXl == null && zu1.mU == null)
            {
                flag5 = true;
            } else
            {
                flag5 = false;
            }
            if (flag5)
            {
                break;
            }
            Toast.makeText(this, 0x7f06014c, 0).show();
            abc abc1 = bgq;
            StringBuilder stringbuilder = new StringBuilder("share w/ followers error: ");
            if (zu1.aXl != null && zu1.aXl.getResponse() != null)
            {
                zu1 = zu1.aXl.getResponse().getReason();
            } else
            {
                zu1 = null;
            }
            abc1.log(stringbuilder.append(zu1).toString());
            return;

        case 5: // '\005'
            bs();
            return;

        case 6: // '\006'
            finish();
            return;

        case 7: // '\007'
            boolean flag6;
            if (zu1.aXl == null && zu1.mU == null)
            {
                flag6 = true;
            } else
            {
                flag6 = false;
            }
            if (flag6)
            {
                View view = View.inflate(this, 0x7f030075, null);
                zu1 = (BroadcastRankResponse)zu1.data;
                DecimalFormat decimalformat = new DecimalFormat("#.###");
                if (((BroadcastRankResponse) (zu1)).rawStickiness != null)
                {
                    ((TextView)view.findViewById(0x7f0d015d)).setText(decimalformat.format(Float.parseFloat(((BroadcastRankResponse) (zu1)).rawStickiness[0])));
                    ((TextView)view.findViewById(0x7f0d015e)).setText(((BroadcastRankResponse) (zu1)).rawStickiness[1]);
                }
                if (((BroadcastRankResponse) (zu1)).stickiness != null)
                {
                    ((TextView)view.findViewById(0x7f0d015f)).setText(decimalformat.format(Float.parseFloat(((BroadcastRankResponse) (zu1)).stickiness[0])));
                    ((TextView)view.findViewById(0x7f0d0160)).setText(decimalformat.format(Float.parseFloat(((BroadcastRankResponse) (zu1)).stickiness[1])));
                }
                if (((BroadcastRankResponse) (zu1)).isVerified != null)
                {
                    ((TextView)view.findViewById(0x7f0d0161)).setText(decimalformat.format(Float.parseFloat(((BroadcastRankResponse) (zu1)).isVerified[0])));
                    ((TextView)view.findViewById(0x7f0d0162)).setText(decimalformat.format(Float.parseFloat(((BroadcastRankResponse) (zu1)).isVerified[1])));
                }
                if (((BroadcastRankResponse) (zu1)).viewersCount != null)
                {
                    ((TextView)view.findViewById(0x7f0d0163)).setText(decimalformat.format(Float.parseFloat(((BroadcastRankResponse) (zu1)).viewersCount[0])));
                    ((TextView)view.findViewById(0x7f0d0164)).setText(decimalformat.format(Float.parseFloat(((BroadcastRankResponse) (zu1)).viewersCount[1])));
                }
                if (((BroadcastRankResponse) (zu1)).hasLocation != null)
                {
                    ((TextView)view.findViewById(0x7f0d0165)).setText(decimalformat.format(Float.parseFloat(((BroadcastRankResponse) (zu1)).hasLocation[0])));
                    ((TextView)view.findViewById(0x7f0d0166)).setText(decimalformat.format(Float.parseFloat(((BroadcastRankResponse) (zu1)).hasLocation[1])));
                }
                if (((BroadcastRankResponse) (zu1)).cortexScore != null)
                {
                    ((TextView)view.findViewById(0x7f0d0167)).setText(decimalformat.format(Float.parseFloat(((BroadcastRankResponse) (zu1)).cortexScore[0])));
                    ((TextView)view.findViewById(0x7f0d0168)).setText(decimalformat.format(Float.parseFloat(((BroadcastRankResponse) (zu1)).cortexScore[1])));
                }
                if (((BroadcastRankResponse) (zu1)).reportRatio != null)
                {
                    ((TextView)view.findViewById(0x7f0d0169)).setText(decimalformat.format(Float.parseFloat(((BroadcastRankResponse) (zu1)).reportRatio[0])));
                    ((TextView)view.findViewById(0x7f0d016a)).setText(decimalformat.format(Float.parseFloat(((BroadcastRankResponse) (zu1)).reportRatio[1])));
                }
                if (((BroadcastRankResponse) (zu1)).ageMinutes != null)
                {
                    ((TextView)view.findViewById(0x7f0d016b)).setText(decimalformat.format(Float.parseFloat(((BroadcastRankResponse) (zu1)).ageMinutes[0])));
                    ((TextView)view.findViewById(0x7f0d016c)).setText(decimalformat.format(Float.parseFloat(((BroadcastRankResponse) (zu1)).ageMinutes[1])));
                }
                if (((BroadcastRankResponse) (zu1)).locales != null)
                {
                    ((TextView)view.findViewById(0x7f0d016d)).setText(TextUtils.join(",", ((BroadcastRankResponse) (zu1)).locales));
                }
                if (((BroadcastRankResponse) (zu1)).country != null)
                {
                    ((TextView)view.findViewById(0x7f0d016e)).setText(((BroadcastRankResponse) (zu1)).country);
                }
                if (((BroadcastRankResponse) (zu1)).language != null)
                {
                    ((TextView)view.findViewById(0x7f0d016f)).setText(((BroadcastRankResponse) (zu1)).language);
                }
                if (((BroadcastRankResponse) (zu1)).score != null)
                {
                    ((TextView)view.findViewById(0x7f0d0170)).setText(decimalformat.format(Float.parseFloat(((BroadcastRankResponse) (zu1)).score)));
                }
                zu1 = new android.app.AlertDialog.Builder(this);
                zu1.setView(view);
                zu1.create().show();
                return;
            }
            Toast.makeText(this, "Failed to get broadcast rank info", 1).show();
            break;
        }
    }

    public void onEventMainThread(zw zw1)
    {
        switch (_cls1.bcB[zw1.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            bhd.A();
            ((android.support.v7.widget.RecyclerView.if) (bhc)).ey.notifyChanged();
            return;

        case 2: // '\002'
            break;
        }
        if (bkB != null)
        {
            zw1 = mBroadcastCacheManager;
            String s = bei;
            zw1 = (atn)((yv) (zw1)).aWg.get(s);
            _mth141D(zw1);
            if (zw1 != null)
            {
                boolean flag;
                if (((atn) (zw1)).bDW == ato.bEd)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag && _cls30CE.if._mth02CE(this))
                {
                    ApiManager.get(this).getBroadcastRank(zw1.id());
                }
            }
        }
    }

    public void onEventMainThread(zx zx)
    {
        bhd._mth02CA(zx);
    }

    public void onFocusChange(View view, boolean flag)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131558586: 
            break;
        }
        if (flag)
        {
            bhk.setVisibility(8);
            return;
        } else
        {
            bhk.setVisibility(0);
            return;
        }
    }

    public void onLowMemory()
    {
        super.onLowMemory();
        bkX = true;
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

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
        _mth02BD(intent);
    }

    protected void onPause()
    {
        bgq.log("onPause");
        cg();
        if (bkv != null && bkv.bfL)
        {
            adx adx1 = bkv;
            adx1.aVj = true;
            if (adx1.aZr != null)
            {
                adx1.aZr.aZb.setPlayWhenReady(false);
            }
            bkA.pause();
            ch();
        }
        if (cc())
        {
            if (bkw != null)
            {
                Object obj;
                if (super.bdr != null)
                {
                    obj = super.bdr;
                } else
                {
                    obj = new qe();
                }
                xf._mth02CA((xh)obj, bkw, bht);
                aVa._mth02CA(aUX);
            }
            aUX = null;
            bkw = null;
            bkS = null;
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
        if (bkB == ahi.if.blw)
        {
            bkB = ahi.if.blv;
        }
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        bgq.log("onResume");
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
        bkh.startWatching();
        if (bkB == ahi.if.blu)
        {
            ((NotificationManager)getSystemService("notification")).cancel(1);
        }
    }

    protected void onStop()
    {
        bgq.log("onStop");
        if (!isFinishing())
        {
            adx adx1 = bkv;
            boolean flag;
            if (bkB != null && bkB.blA && adx1 != null && adx1.bfL)
            {
                if (bko != null)
                {
                    NotificationManager notificationmanager = (NotificationManager)getSystemService("notification");
                    atn atn1 = bko;
                    Object obj = atn1.id();
                    obj = (new Intent(this, o/agp)).putExtra("e_b_id", ((String) (obj)));
                    long l;
                    if (bkv != null)
                    {
                        adx adx2 = bkv;
                        if (adx2.aZr != null)
                        {
                            l = adx2.aZr.getCurrentPosition();
                        } else
                        {
                            l = 0L;
                        }
                    } else
                    {
                        l = 0L;
                    }
                    obj = PendingIntent.getActivity(this, 0, ((Intent) (obj)).putExtra("e_playtime", l).setFlags(0x14000000), 0x8000000);
                    notificationmanager.notify(1, (new _cls06E5._cls02CE(this))._mth141D(0x7f0200ee)._mth02BD(getResources().getColor(0x7f0c006a))._mth02CB(getString(0x7f0600fb, new Object[] {
                        atn1.fh()
                    }))._mth02CE(atn1.eS())._mth02CA((new _cls06E5._cls02CB())._mth02CA(atn1.eS()))._mth02CA(((PendingIntent) (obj)))._mth02CE(true).build());
                }
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                finish();
            }
        }
        if (bkv != null)
        {
            bkv.bl();
        }
        bkh.stopWatching();
        afw afw1 = bkx;
        int i = (int)Math.ceil((double)TimeUnit.MILLISECONDS.toSeconds(afw1.bjA) / 10D);
        HashMap hashmap = new HashMap();
        hashmap.put("n_times", String.valueOf(afw1.bjy));
        hashmap.put("n_duration", String.valueOf(i * 10));
        xf._mth02CA(xf.if.aSc, hashmap);
        afw1.bjy = 0;
        afw1.bjA = 0L;
        super.onStop();
    }

    public final void _mth02B3(long l)
    {
        bkQ._mth02B3(l);
        if (bkz && bkL)
        {
            bkz = false;
            ahw ahw1 = bgV;
            ahw1.bml.clear();
            ((android.support.v7.widget.RecyclerView.if) (ahw1.bml)).ey.notifyChanged();
            bkA.seek(l);
        }
    }

    public final boolean _mth02BC(String s, String s1, String s2)
    {
        boolean flag;
label0:
        {
            if (bkv == null)
            {
                return false;
            }
            adx adx1 = bkv;
            SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(adx1.mContext);
            if (yo._mth02CA(xd._mth1FEA()) && sharedpreferences.getBoolean("pref_force_hls", false) && aui._mth02BF(s1))
            {
                adx1.bfE = 3;
                adx1.bfF = s1;
            } else
            if (aui._mth02BF(s))
            {
                adx1.bfE = 4;
                adx1.bfF = s;
            } else
            if (aui._mth02BF(s1))
            {
                adx1.bfE = 3;
                adx1.bfF = s1;
            } else
            if (aui._mth02BF(s2))
            {
                if (Uri.parse(s2).getLastPathSegment().endsWith(".m3u8"))
                {
                    adx1.bfE = 3;
                } else
                {
                    adx1.bfE = 2;
                }
                adx1.bfF = s2;
            } else
            {
                flag = false;
                break label0;
            }
            adx1.bfI = true;
            if (adx1.bfJ)
            {
                adx1.bf();
                flag = true;
            } else
            {
                flag = false;
            }
        }
        s = bkA;
        boolean flag1;
        if (bkv.bfE == 3)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        s._mth1D5B(flag1);
        return flag;
    }

    public final void _mth02BE(List list)
    {
        if (bkB == ahi.if.blu)
        {
            mUserManager._mth02CA(bko.fd(), bei, list);
        }
    }

    public final void _mth02CA(String s, int i, boolean flag)
    {
        boolean flag1;
        if (bkB == ahi.if.blv || bkB == ahi.if.blw)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1 && !flag)
        {
            return;
        } else
        {
            mUserManager._mth02CA(bei, s, i, flag1);
            return;
        }
    }

    public final void _mth02CA(String s, String s1, String s2, xj xj1)
    {
        bhf._mth02CA(0, 0, s, s1, s2, new ahg(this, xj1));
    }

    public final void _mth02CA(acd acd, Boolean boolean1, ahi.if if1)
    {
        if (aUX == null && bkw != null)
        {
            aUX = new xx(bkw.fx(), bkw.fo().id());
            int j = bkw.fI();
            int i = j;
            if (if1.bly)
            {
                i = j & -2;
            }
            aVa._mth02CA(bkw.fu(), bkw.ft(), bkw.eG(), bkw.eF(), acd, boolean1.booleanValue(), bkw.fH(), i, xd.getEventBus(), (SignerService)xd._mth30A5().getService(), yo.getLogLevel());
            aVa._mth02CA(aUX, bkw.fv(), aWS.id, aWS.username, aWS.displayName, aWS.initials, aWS.getProfileUrlMedium(), bkw.fw());
            bkA._mth02CA(aUX, bkw.fo().fd(), bkw.eG());
            if (bkB == ahi.if.blw && cm())
            {
                _mth02C0(true);
                ce();
            }
        }
    }

    public final void _mth02CA(atp atp1)
    {
        Object obj = atp1.fo();
        _mth02BB(((atn) (obj)));
        obj = new adt._cls02BC(atp1.fp(), ((atn) (obj)));
        atp1 = bhd;
        obj = new adt._cls02BB(((adt._cls02BC) (obj)));
        atp1.bfC = ((adt._cls02BB) (obj));
        if (!((adw) (atp1)).bfz.isEmpty() && (((adw) (atp1)).bfz.get(0) instanceof adt._cls02BB))
        {
            ((adw) (atp1)).bfz.remove(0);
        }
        ((adw) (atp1)).bfz.add(0, obj);
        if (((adw) (atp1)).bfD != null)
        {
            ((adw) (atp1)).bfD.FE76(0, 1);
        }
        ((android.support.v7.widget.RecyclerView.if) (bhc)).ey._mth1D54(0, 1);
    }

    public final void _mth02CA(auf auf1, xk xk)
    {
        switch (_cls1.aUJ[auf1.go().ordinal()])
        {
        case 1: // '\001'
            if (bku != null && bkZ != null)
            {
                _mth037A(new File(bkZ));
            }
            bkZ = null;
            return;
        }
        Object obj;
        if (super.bdr != null)
        {
            obj = super.bdr;
        } else
        {
            obj = new qe();
        }
        xf._mth02CE(((qh) (obj)));
        bhq._mth02CA(bei, auf1, xk, _mth02CA(aug.bEz));
    }

    public final void _mth02CA(auf auf1, boolean flag)
    {
        if (bkv == null || !bkv.bfL)
        {
            return;
        } else
        {
            Object obj = bkB;
            obj = ahi.if.blu;
            obj = bgU;
            int i = aok._mth02CA(getResources(), auf1.gp().intValue());
            auf1 = ((aib) (obj)).bmJ.FB40(i);
            ((aib) (obj)).bmI._mth02CA(auf1, ((android.widget.RelativeLayout) (obj)), false);
            return;
        }
    }

    boolean _mth02CA(aug aug1)
    {
        switch (_cls1.aUJ[aug1.ordinal()])
        {
        case 2: // '\002'
            return cc() && aua.bEq.equals(bkw.bEh);
        }
        return bkv != null && cc() && aua.bEq.equals(bkw.bEh);
    }

    public final void _mth02CB(String s, ArrayList arraylist)
    {
        ApiManager.get(this).shareBroadcast(s, arraylist);
        boolean flag;
        if (arraylist == null || arraylist.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            bgq.log("share with all followers");
        } else
        {
            bgq.log((new StringBuilder("share with ")).append(arraylist.size()).append(" followers").toString());
        }
        if (cc())
        {
            int i;
            if (flag)
            {
                s = getString(0x7f0600df);
                i = 0;
            } else
            {
                s = getResources().getQuantityString(0x7f070000, arraylist.size(), new Object[] {
                    aWS.username, aos._mth02CA(getResources(), arraylist.size(), true)
                });
                i = arraylist.size();
            }
            if (_mth02CA(aug.bEE))
            {
                Object obj = bkw.fx();
                arraylist = aWS.username;
                String s1 = aWS.displayName;
                String s2 = aWS.initials;
                Object obj1 = aWS.id;
                String s3 = aWS.getProfileUrlMedium();
                int j = bkw.fw();
                Object obj2 = bkv;
                long l;
                if (((adx) (obj2)).bfX == 0.0D)
                {
                    l = apb.ec().getTime();
                } else
                {
                    l = (long)((((adx) (obj2)).bfX - 2208988800D) * 1000D);
                }
                long l1 = apb.ec().getTime();
                obj2 = new aud.if();
                obj2.bEx = Integer.valueOf(0);
                obj = ((auf.if) (obj2))._mth02CB(Integer.valueOf(2))._mth02CB(aug.bEE)._mth0407(((String) (obj)))._mth0433(((String) (obj1)))._mth02CE(Integer.valueOf(j));
                obj1 = wr._mth05D9(l);
                s = ((auf.if) (obj))._mth0640(BigInteger.valueOf(((wr) (obj1)).VE >>> 32 & 0xffffffffL).multiply(BigInteger.valueOf(0x100000000L)).add(BigInteger.valueOf(((wr) (obj1)).VE & 0xffffffffL)))._mth0630(UUID.randomUUID().toString())._mth02CB(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())))._mth0719(arraylist)._mth0E07(s1)._mth0E27(s2)._mth1426(s3)._mth1484(s)._mth02CF(Integer.valueOf(i));
                arraylist = wr._mth05D9(l1);
                s = s._mth1427(BigInteger.valueOf(((wr) (arraylist)).VE >>> 32 & 0xffffffffL).multiply(BigInteger.valueOf(0x100000000L)).add(BigInteger.valueOf(((wr) (arraylist)).VE & 0xffffffffL))).gG();
                arraylist = bgV;
                ((ahw) (arraylist)).bml._mth141D(s);
                i = ((ahw) (arraylist)).bml.getItemCount();
                ((ahw) (arraylist)).bmk._mth1507(i - 1);
                if ((bkY & 1) == 1)
                {
                    bgq.log("suppressing invite message, already sent.");
                    return;
                }
                if (flag)
                {
                    bkY = bkY | 1;
                }
                aVa._mth02CA(bkw.fC(), s);
            }
        }
    }

    public final void _mth02CB(ahi.if if1)
    {
        String s = (new StringBuilder("Switching to mode: ")).append(if1).toString();
        bgq.log(s);
        bkB = if1;
        if (bei == null)
        {
            return;
        }
        if (if1 == ahi.if.blu)
        {
            bha.setActionButtonVisibility(true);
            bha.bfw.setImageResource(0x7f0200d8);
        }
        bkt.FE78(bkU);
        bhd.bei = bei;
        _mth02CA(if1);
        bZ();
        ca();
        cl();
        cb();
    }

    public final void _mth02CB(atr atr1)
    {
        bkw = atr1;
        Object obj;
        if (super.bdr != null)
        {
            obj = super.bdr;
        } else
        {
            obj = new qe();
        }
        xf._mth02CA((xh)obj, atr1);
        bgs = bkw.fE();
        bgq._fld1FD2 = bgs;
        atr1 = mBroadcastCacheManager;
        obj = bei;
        _mth141D((atn)((yv) (atr1)).aWg.get(obj));
        if (yo._mth02CA(mUserManager) && PreferenceManager.getDefaultSharedPreferences(this).getBoolean("pref_force_hls", false))
        {
            bkw.bEh = aua.bEr;
        }
        bks.setParticipantInfo(aWS.getProfileUrlMedium(), bkw.fw());
        cd();
        mHandler.removeCallbacks(bkf);
        mHandler.post(bkf);
        mHandler.removeCallbacks(blb);
        mHandler.post(blb);
    }

    public final void _mth02CB(auf auf1, boolean flag)
    {
        if (bkv == null || !bkv.bfL)
        {
            return;
        } else
        {
            aib aib1 = bgU;
            int i = aok._mth02CA(getResources(), auf1.gp().intValue());
            auf1 = new aix(aib1.getContext());
            auf1.setColorAndDrawables(i, 0x7f020119, 0x7f02011a);
            aib1.bmI._mth02CA(auf1, aib1, false);
            return;
        }
    }

    public final void _mth02CE(auf auf1)
    {
        if (bkv == null || !bkv.bfL)
        {
            return;
        } else
        {
            ahw ahw1 = bgV;
            ahw1.bml._mth141D(auf1);
            int i = ahw1.bml.getItemCount();
            ahw1.bmk._mth1507(i - 1);
            return;
        }
    }

    public final boolean _mth02CE(xx xx1)
    {
        if (cc() && aUX.equals(xx1) && bkv != null)
        {
            xx1 = bkv;
            boolean flag;
            if (((adx) (xx1)).aZr != null && ((adx) (xx1)).aZr.getPlaybackState() == 4 && ((adx) (xx1)).aZr.aZb.getPlayWhenReady())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                return true;
            }
        }
        return false;
    }

    public final void _mth02CF(auf auf1)
    {
        if (biz != null)
        {
            aia aia1 = biz;
            if (aia1.biv != null && aia1.biv.isShowing())
            {
                aia1.bmH = false;
                aia1.biv.dismiss();
            }
        }
        Object obj = bks;
        if (obj != null)
        {
            ((InputMethodManager)((View) (obj)).getContext().getSystemService("input_method")).hideSoftInputFromWindow(((View) (obj)).getWindowToken(), 0);
        }
        if (bkv != null && bkv.bfL)
        {
            obj = bkv;
            obj.aVj = true;
            if (((adx) (obj)).aZr != null)
            {
                ((adx) (obj)).aZr.aZb.setPlayWhenReady(false);
            }
            bkA.pause();
        }
        obj = new Intent(this, o/afk);
        ((Intent) (obj)).putExtra("e_message", auf1);
        startActivity(((Intent) (obj)));
        finish();
    }

    public final void _mth0456(String s)
    {
        runOnUiThread(new ahh(this, s));
    }

    public final void _mth0457(String s)
    {
        runOnUiThread(new agr(this, s));
    }

    public final void _mth05E0(String s)
    {
        runOnUiThread(new agt(this, s));
    }

    public final void _mth05E8(String s)
    {
        runOnUiThread(new agu(this, s));
    }

    public final void _mth062F(String s)
    {
        if (isFinishing() || bkw == null)
        {
            return;
        }
        String s1 = bkw.fx();
        Object obj1 = aWS.username;
        String s2 = aWS.displayName;
        String s3 = aWS.initials;
        String s4 = aWS.id;
        String s5 = aWS.getProfileUrlMedium();
        int i = bkw.fw();
        adx adx1 = bkv;
        long l;
        if (adx1.bfX == 0.0D)
        {
            l = apb.ec().getTime();
        } else
        {
            l = (long)((adx1.bfX - 2208988800D) * 1000D);
        }
        obj1 = auf._mth02CA(s1, s, ((String) (obj1)), s2, s3, s4, s5, Integer.valueOf(i), l, apb.ec().getTime());
        if (_mth02CA(aug.bEz))
        {
            if (bkS != null && bkS.trim().equalsIgnoreCase(s.trim()))
            {
                if (bkv != null && bkv.bfL)
                {
                    ahw ahw1 = bgV;
                    ahw1.bml._mth141D(((auf) (obj1)));
                    int j = ahw1.bml.getItemCount();
                    ahw1.bmk._mth1507(j - 1);
                }
                bgq.log((new StringBuilder("ghosted identical message: ")).append(s).toString());
                return;
            }
            if (!bko.fe() && bkg._mth0406(s))
            {
                aey aey1 = bks;
                if (aey1 != null)
                {
                    ((InputMethodManager)aey1.getContext().getSystemService("input_method")).hideSoftInputFromWindow(aey1.getWindowToken(), 0);
                }
                biz = new aif(this, ((auf) (obj1)), new agv(this, s, ((auf) (obj1))), new agw(this), new agx(this));
                xf._mth02CA(xf.if.aRV);
                biz.show();
                return;
            }
            Object obj;
            if (super.bdr != null)
            {
                obj = super.bdr;
            } else
            {
                obj = new qe();
            }
            xf._mth02CA((xh)obj, s);
            _mth02CB(s, ((auf) (obj1)));
            return;
        }
        if (bkv == null || !bkv.bfL)
        {
            return;
        } else
        {
            s = bgV;
            ((ahw) (s)).bml._mth141D(((auf) (obj1)));
            int k = ((ahw) (s)).bml.getItemCount();
            ((ahw) (s)).bmk._mth1507(k - 1);
            return;
        }
    }

    public final void _mth06C1(String s)
    {
        runOnUiThread(new ags(this, s));
    }

    public final void _mth071D(String s)
    {
        if (bkw == null)
        {
            return;
        }
        ArrayList arraylist = new ArrayList(3);
        boolean flag;
        if ((bkB == ahi.if.blw || bkB == ahi.if.blv || cc()) && aui._mth02BF(bkw.fG()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (bku != null && flag)
        {
            arraylist.add(new agf(s, this));
        }
        if (bkB == ahi.if.blu)
        {
            arraylist.add(new agd(s, this));
            arraylist.add(new age(s, this));
        }
        if (bkB == ahi.if.blu || flag)
        {
            arraylist.add(new agc(s, this));
        }
        bhq._mth02CB(null, arraylist);
    }

    public final void _mth0E32(String s)
    {
        bhq.dC();
        _mth02CB(s, ((ArrayList) (null)));
    }

    public final void _mth141D(int i, String s)
    {
        switch (i)
        {
        case 1: // '\001'
            bgq.log((new StringBuilder("Failed to load broadcast ")).append(bei).toString());
            _mth02CA(false, ((String) (null)));
            Toast.makeText(this, s, 1).show();
            break;

        case 2: // '\002'
            Toast.makeText(this, 0x7f060076, 0).show();
            bgq.log("video unplayable, finishing.");
            _cls0675._mth02CB(new IllegalStateException((new StringBuilder("Video unplayable:")).append(bei).toString()));
            break;
        }
        finish();
    }

    public final void _mth141D(atn atn1)
    {
        if (atn1 == null || atn1.equals(bko))
        {
            return;
        }
        if (bkB == null)
        {
            return;
        }
        bko = atn1;
        bgU.setHeartThemes(atn1.fm());
        _cls0675.setString("last viewed broadcast", bko.id());
        _cls0675.setString("last viewed broadcast mode", bkB.name());
        boolean flag;
        if (atn1.bDW == ato.bEd)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        boolean flag1;
        if (!flag && atn1.bDX)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        _mth02C1(flag1);
        Object obj = bgt;
        if (bkB == ahi.if.blu || atn1.bDX)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        ((arx) (obj)).setDraggable(flag1);
        _mth02C0(false);
        obj = _cls1D3C._mth02CA(this);
        String s = atn1.ff();
        ((_cls1D27)((_cls1D5A) (obj))._mth02CA(java/lang/String).FF70(s))._mth05D5(0x7f0c0037)._mth0197()._mth02CA(new _cls0443[] {
            new aam(this)
        })._mth02CA(bkp);
        bhd.A();
        bha.setAdapter(bhc);
        bha.setTitle(atn1.eS(), atn1.eT().toString());
        if (bkB != ahi.if.blu && bkB != ahi.if.blw)
        {
            _mth02BB(atn1);
        }
    }

    public final void _mth1425(String s)
    {
        bhq.dC();
        xf._mth02CA(xf.if.aSE);
        bhi._mth02CA(new agy(this, s));
        bhi.show();
    }

    protected final qh _mth207F(String s)
    {
        qh qh1 = xf._mth30EA();
        qh1._mth02E3(s);
        return qh1;
    }

    public final void FB32(int i)
    {
        bht = i;
        bkr.setText(aos._mth02CA(getResources(), i, true));
    }

    public final void FE7E(boolean flag)
    {
        if (isFinishing())
        {
            return;
        }
        bgq.log("onPlaybackReady");
        bkQ.FE7E(flag);
        long l1 = bkF;
        long l;
        if (bkv != null)
        {
            adx adx1 = bkv;
            if (adx1.aZr != null)
            {
                l = adx1.aZr.getCurrentPosition();
            } else
            {
                l = 0L;
            }
        } else
        {
            l = 0L;
        }
        bkF = Math.max(l1, l);
        _mth02CA(false, ((String) (null)));
        mHandler.removeCallbacks(bld);
        bkN = false;
        if (bky)
        {
            bky = false;
            if (bkx.FE7B)
            {
                bkx.bT();
            }
        }
        if (bkB != null)
        {
            if (bkB == ahi.if.blu)
            {
                bha.setActionButtonVisibility(true);
                bha.bfw.setImageResource(0x7f0200d8);
                return;
            }
            _mth02C1(bkB.bly);
        }
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
