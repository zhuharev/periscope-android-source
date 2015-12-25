// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.digits.sdk.android.Digits;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import java.lang.reflect.Field;
import java.security.Security;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import tv.periscope.android.api.ApiClient;

// Referenced classes of package o:
//            auj, ada, FF6A, abj, 
//            qa, ql, qn, zp, 
//            ack, xf, yo, yq, 
//            _cls1EF4, _cls068B, _cls14B6, _cls0675, 
//            ri, ra, acn, yv, 
//            abv, zf, zt, aul

public class xd extends Application
{
    static final class if extends aul
    {

        protected final void _mth02BB(String s, String s1, Throwable throwable)
        {
            FF6A._mth02CA(s, s1, throwable);
        }

        protected final void _mth02BC(String s, String s1, Throwable throwable)
        {
            FF6A._mth02CA(s, s1, throwable);
            _cls0675._mth02CB(throwable);
        }

        protected final void _mth05D9(String s, String s1)
        {
        }

        protected final void _mth0674(String s, String s1)
        {
        }

        protected final void _mth141D(String s, String s1, Throwable throwable)
        {
        }

        protected final void _mth1D35(String s, String s1)
        {
            FF6A._mth02CA(s, s1);
        }

        protected final void _mth1D4E(String s, String s1)
        {
            FF6A._mth02CE(s, s1);
        }

        if()
        {
        }
    }


    private static ql aQE;
    private static zp aQF;
    private static ack aQG;
    private static abv aQH;
    private static yv aQI;
    private static zf aQJ;
    private static zt aQK;
    private static ExecutorService aQL;
    private static ApiClient aQM;
    private static acn aQN;

    public xd()
    {
    }

    public static ql getEventBus()
    {
        return aQE;
    }

    public static boolean _mth1FE9()
    {
        return ada.isVisible();
    }

    public static zp _mth1FEA()
    {
        return aQF;
    }

    public static ack _mth1FEB()
    {
        return aQG;
    }

    public static abv _mth212A()
    {
        return aQH;
    }

    public static yv _mth216D()
    {
        return aQI;
    }

    public static zf _mth2183()
    {
        return aQJ;
    }

    public static zt _mth304F()
    {
        return aQK;
    }

    public static Executor _mth3063()
    {
        return aQL;
    }

    public static ApiClient _mth3078()
    {
        return aQM;
    }

    public static acn _mth30A5()
    {
        return aQN;
    }

    protected void attachBaseContext(Context context)
    {
        super.attachBaseContext(context);
    }

    public void onCreate()
    {
        FF6A.mb = false;
        abj.if.al().bcd = false;
        super.onCreate();
        Object obj = qa.Ph;
        obj = ql._mth043E();
        obj.PM = false;
        aQE = new ql(((qn) (obj)));
        aQF = new zp(this, aQE);
        aQG = new ack(this);
        xf._mth02CA(this, aQG, aQF);
        obj = yo.aVs.o();
        if (_cls30CE.if.FE73(this))
        {
            obj = (String)yp.CON._mth02CA("o.yp").getField("aVA").get(null);
        } else
        if (_cls30CE.if._mth1428(this))
        {
            obj = (String)yp.CON._mth02CA("o.yp").getField("aVy").get(null);
        }
        Object obj1 = yo.aVs.p();
        if (_cls30CE.if.FE73(this))
        {
            obj1 = (String)yp.CON._mth02CA("o.yp").getField("aVz").get(null);
        } else
        if (_cls30CE.if._mth1428(this))
        {
            obj1 = (String)yp.CON._mth02CA("o.yp").getField("aVx").get(null);
        }
        obj = new TwitterAuthConfig(((String) (obj)), ((String) (obj1)));
        obj1 = new _cls0675.if();
        boolean flag = yo.i();
        ((_cls0675.if) (obj1))._mth0EC0().ul = flag;
        if (((_cls0675.if) (obj1)).ss != null)
        {
            if (((_cls0675.if) (obj1)).sq != null)
            {
                throw new IllegalStateException("Must not use Deprecated methods delay(), disabled(), listener(), pinningInfoProvider() with core()");
            }
            _cls1EF4.if if1 = ((_cls0675.if) (obj1)).ss;
            if (if1.uk < 0.0F)
            {
                if1.uk = 1.0F;
            }
            obj1.sq = new _cls1EF4(if1.uk, null, null, if1.ul);
        }
        if (((_cls0675.if) (obj1)).so == null)
        {
            obj1.so = new _cls068B();
        }
        if (((_cls0675.if) (obj1)).sp == null)
        {
            obj1.sp = new _cls14B6();
        }
        if (((_cls0675.if) (obj1)).sq == null)
        {
            obj1.sq = new _cls1EF4();
        }
        obj1 = new _cls0675(((_cls0675.if) (obj1)).so, ((_cls0675.if) (obj1)).sp, ((_cls0675.if) (obj1)).sq);
        ra._mth02CA(this, new ri[] {
            new TwitterCore(((TwitterAuthConfig) (obj))), new Digits(), obj1
        });
        aQL = Executors.newCachedThreadPool();
        aQM = new ApiClient(this, aQL);
        aQN = new acn(this, aQL);
        aQI = new yv(aQE);
        aQH = new abv(this, aQE, aQG);
        aQJ = new zf(this, aQE);
        aQK = new zt();
    }

    static 
    {
        auj.bFh = new if();
        auj.tC = Build.MODEL;
        auj.bFi = android.os.Build.VERSION.RELEASE;
        Security.insertProviderAt(new BouncyCastleProvider(), 1);
    }
}
