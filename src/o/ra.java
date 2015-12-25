// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package o:
//            rl, rc, ri, td, 
//            rf, si, qy, rb, 
//            sv, rh, tf, rj, 
//            re, rm, xd

public class ra
{
    public static final class if
    {

        ri QO[];
        td QP;
        rl QQ;
        String QR;
        final Context context;
        Handler handler;
        rf initializationCallback;

        public if(Context context1)
        {
            if (context1 == null)
            {
                throw new IllegalArgumentException("Context must not be null.");
            } else
            {
                context = context1.getApplicationContext();
                return;
            }
        }
    }


    private static volatile ra QC;
    private static rl QD = new rl();
    private final Map QE;
    public final td QF;
    private final rf QG;
    public qy QH;
    public WeakReference QI;
    private rl QJ;
    private boolean QK;
    private final Context context;
    private final si idManager;
    private final rf initializationCallback;
    private final Handler jT;
    private AtomicBoolean tQ;

    ra(Context context1, Map map, td td1, Handler handler, rl rl1, boolean flag, rf rf1, 
            si si1)
    {
        context = context1;
        QE = map;
        QF = td1;
        jT = handler;
        QJ = rl1;
        QK = flag;
        initializationCallback = rf1;
        tQ = new AtomicBoolean(false);
        QG = new rc(this, map.size());
        idManager = si1;
    }

    public static String getVersion()
    {
        return "1.3.6.79";
    }

    public static ri _mth02BE(Class class1)
    {
        if (QC == null)
        {
            throw new IllegalStateException("Must Initialize Fabric before using singleton()");
        } else
        {
            return (ri)QC.QE.get(class1);
        }
    }

    static AtomicBoolean _mth02CA(ra ra1)
    {
        return ra1.tQ;
    }

    public static transient ra _mth02CA(xd xd, ri ari[])
    {
        if (QC != null) goto _L2; else goto _L1
_L1:
        o/ra;
        JVM INSTR monitorenter ;
        if (QC != null) goto _L4; else goto _L3
_L3:
        if if1;
        if1 = new if(xd);
        if (if1.QO != null)
        {
            throw new IllegalStateException("Kits already set.");
        }
        if1.QO = ari;
        if (if1.QP == null)
        {
            if1.QP = td._mth1503();
        }
        if (if1.handler == null)
        {
            if1.handler = new Handler(Looper.getMainLooper());
        }
        if (if1.QQ == null)
        {
            if1.QQ = new rl();
        }
        if (if1.QR == null)
        {
            if1.QR = if1.context.getPackageName();
        }
        if (if1.initializationCallback == null)
        {
            if1.initializationCallback = rf.QV;
        }
        if (if1.QO == null)
        {
            xd = new HashMap();
            break MISSING_BLOCK_LABEL_176;
        }
        ari = Arrays.asList(if1.QO);
        xd = new HashMap(ari.size());
        _mth02CB(xd, ari);
        ari = new si(if1.context, if1.QR, null, xd.values());
        ari = new ra(if1.context, xd, if1.QP, if1.handler, if1.QQ, false, if1.initializationCallback, ari);
        QC = ari;
        xd = ((ra) (ari)).context;
        if (!(xd instanceof Activity)) goto _L6; else goto _L5
_L5:
        xd = (Activity)xd;
_L8:
        ari.QI = new WeakReference(xd);
        ari.QH = new qy(((ra) (ari)).context);
        ((ra) (ari)).QH._mth02CA(new rb(ari));
        ari._mth02E1(((ra) (ari)).context);
_L4:
        o/ra;
        JVM INSTR monitorexit ;
          goto _L2
        xd;
        throw xd;
_L2:
        return QC;
_L6:
        xd = null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private static void _mth02CA(Map map, ri ri1)
    {
        sv sv1 = (sv)ri1.getClass().getAnnotation(o/sv);
        if (sv1 != null)
        {
            Class aclass[] = sv1._mth14FF();
            int j = aclass.length;
label0:
            for (int i = 0; i < j; i++)
            {
                Class class1 = aclass[i];
                if (class1.isInterface())
                {
                    Iterator iterator = map.values().iterator();
                    do
                    {
                        ri ri2;
                        do
                        {
                            if (!iterator.hasNext())
                            {
                                continue label0;
                            }
                            ri2 = (ri)iterator.next();
                        } while (!class1.isAssignableFrom(ri2.getClass()));
                        ri1.initializationTask._mth02CB(ri2.initializationTask);
                    } while (true);
                }
                if ((ri)map.get(class1) == null)
                {
                    throw new tf("Referenced Kit was null, does the kit exist?");
                }
                ri1.initializationTask._mth02CB(((ri)map.get(class1)).initializationTask);
            }

        }
    }

    static rf _mth02CB(ra ra1)
    {
        return ra1.initializationCallback;
    }

    private static void _mth02CB(Map map, Collection collection)
    {
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            ri ri1 = (ri)collection.next();
            map.put(ri1.getClass(), ri1);
            if (ri1 instanceof rj)
            {
                _mth02CB(map, ((rj)ri1)._mth0ABD());
            }
        } while (true);
    }

    private void _mth02E1(Context context1)
    {
        Object obj = new re(context1.getPackageCodePath());
        obj = QF.submit(((java.util.concurrent.Callable) (obj)));
        Object obj1 = QE.values();
        obj = new rm(((java.util.concurrent.Future) (obj)), ((Collection) (obj1)));
        obj1 = new ArrayList(((Collection) (obj1)));
        Collections.sort(((List) (obj1)));
        ((rm) (obj)).injectParameters(context1, this, rf.QV, idManager);
        for (Iterator iterator = ((List) (obj1)).iterator(); iterator.hasNext(); ((ri)iterator.next()).injectParameters(context1, this, QG, idManager)) { }
        ((rm) (obj)).initialize();
        if (QC == null)
        {
            context1 = QD;
        } else
        {
            context1 = QC.QJ;
        }
        if (context1.FB35(3))
        {
            context1 = (new StringBuilder("Initializing io.fabric.sdk.android:fabric")).append(" [Version: 1.3.6.79").append("], with the following kits:\n");
        } else
        {
            context1 = null;
        }
        obj1 = ((List) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            ri ri1 = (ri)((Iterator) (obj1)).next();
            ri1.initializationTask._mth02CB(((rm) (obj)).initializationTask);
            _mth02CA(QE, ri1);
            ri1.initialize();
            if (context1 != null)
            {
                context1.append(ri1.getIdentifier()).append(" [Version: ").append(ri1.getVersion()).append("]\n");
            }
        } while (true);
        if (context1 != null)
        {
            rl rl1;
            if (QC == null)
            {
                rl1 = QD;
            } else
            {
                rl1 = QC.QJ;
            }
            rl1._mth02BE("Fabric", context1.toString());
        }
    }

    public static rl _mth0454()
    {
        if (QC == null)
        {
            return QD;
        } else
        {
            return QC.QJ;
        }
    }

    public static boolean _mth04F5()
    {
        if (QC == null)
        {
            return false;
        } else
        {
            return QC.QK;
        }
    }

}
