// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

// Referenced classes of package o:
//            qn, qm, qp, qk, 
//            qj, qv, qt, qw, 
//            qo, qu, qx, qr, 
//            qs, qq

public final class ql
{
    static final class if
    {

        final ArrayList PU = new ArrayList();
        boolean PV;
        boolean PW;
        qw PX;
        Object PY;
        boolean canceled;

        if()
        {
        }
    }


    private static final qn PC = new qn();
    private static final HashMap PD = new HashMap();
    public static String TAG = "Event";
    private final HashMap PE;
    private final HashMap PF;
    private final ConcurrentHashMap PG;
    private final qm PH;
    private final qp PI;
    private final qk PJ;
    private final qj PK;
    private final qv PL;
    private final boolean PM;
    private final boolean PN;
    private final boolean PO;
    private final boolean PP;
    private final boolean PQ;
    private final boolean PR;
    final ExecutorService executorService;

    public ql()
    {
        this(PC);
    }

    public ql(qn qn1)
    {
        PH = new qm(this);
        PE = new HashMap();
        PF = new HashMap();
        PG = new ConcurrentHashMap();
        PI = new qp(this, Looper.getMainLooper(), 10);
        PJ = new qk(this);
        PK = new qj(this);
        PL = new qv(null);
        PN = qn1.PN;
        PO = qn1.PO;
        PP = qn1.PP;
        PQ = qn1.PQ;
        PM = qn1.PM;
        PR = qn1.PR;
        executorService = qn1.executorService;
    }

    private static void _mth02CA(List list, Class aclass[])
    {
        int j = aclass.length;
        for (int i = 0; i < j; i++)
        {
            Class class1 = aclass[i];
            if (!list.contains(class1))
            {
                list.add(class1);
                _mth02CA(list, class1.getInterfaces());
            }
        }

    }

    private void _mth02CA(qw qw1, Object obj, Throwable throwable)
    {
        if (obj instanceof qt)
        {
            if (PN)
            {
                Log.e(TAG, (new StringBuilder("SubscriberExceptionEvent subscriber ")).append(qw1.Qp.getClass()).append(" threw an exception").toString(), throwable);
                qw1 = (qt)obj;
                Log.e(TAG, (new StringBuilder("Initial event ")).append(((qt) (qw1)).Qi).append(" caused exception in ").append(((qt) (qw1)).Qj).toString(), ((qt) (qw1)).Qh);
                return;
            }
        } else
        {
            if (PM)
            {
                throw new qo("Invoking subscriber failed", throwable);
            }
            if (PN)
            {
                Log.e(TAG, (new StringBuilder("Could not dispatch event: ")).append(obj.getClass()).append(" to subscribing class ").append(qw1.Qp.getClass()).toString(), throwable);
            }
            if (PP)
            {
                _mth1429(new qt(this, throwable, obj, qw1.Qp));
            }
        }
    }

    private void _mth02CA(qw qw1, Object obj, boolean flag)
    {
        static final class _cls1
        {

            static final int PT[];

            static 
            {
                PT = new int[qx.values().length];
                try
                {
                    PT[qx.Qs.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
                try
                {
                    PT[qx.Qt.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    PT[qx.Qu.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    PT[qx.Qv.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
            }
        }

        switch (_cls1.PT[qw1.Qq.Qk.ordinal()])
        {
        case 1: // '\001'
            _mth02CB(qw1, obj);
            return;

        case 2: // '\002'
            if (flag)
            {
                _mth02CB(qw1, obj);
                return;
            } else
            {
                PI._mth02CA(qw1, obj);
                return;
            }

        case 3: // '\003'
            if (flag)
            {
                PJ._mth02CA(qw1, obj);
                return;
            } else
            {
                _mth02CB(qw1, obj);
                return;
            }

        case 4: // '\004'
            qj qj1 = PK;
            qw1 = qr._mth02CE(qw1, obj);
            qj1.Pz._mth02CB(qw1);
            qj1.PA.executorService.execute(qj1);
            return;
        }
        throw new IllegalStateException((new StringBuilder("Unknown thread mode: ")).append(qw1.Qq.Qk).toString());
    }

    private boolean _mth02CA(Object obj, if if1, Class class1)
    {
        this;
        JVM INSTR monitorenter ;
        class1 = (CopyOnWriteArrayList)PE.get(class1);
        this;
        JVM INSTR monitorexit ;
          goto _L1
        obj;
        throw obj;
_L1:
        if (class1 == null || class1.isEmpty())
        {
            break MISSING_BLOCK_LABEL_122;
        }
        class1 = class1.iterator();
_L3:
        qw qw1;
        if (!class1.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        qw1 = (qw)class1.next();
        if1.PY = obj;
        if1.PX = qw1;
        _mth02CA(qw1, obj, if1.PW);
        if1.PY = null;
        if1.PX = null;
        if1.canceled = false;
        if (true) goto _L3; else goto _L2
        obj;
        if1.PY = null;
        if1.PX = null;
        if1.canceled = false;
        throw obj;
_L2:
        return true;
        return false;
    }

    private static List _mth037A(Class class1)
    {
        HashMap hashmap = PD;
        hashmap;
        JVM INSTR monitorenter ;
        Object obj1 = (List)PD.get(class1);
        Object obj;
        obj = obj1;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        obj1 = new ArrayList();
        obj = class1;
_L1:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        ((List) (obj1)).add(obj);
        _mth02CA(((List) (obj1)), ((Class) (obj)).getInterfaces());
        obj = ((Class) (obj)).getSuperclass();
          goto _L1
        PD.put(class1, obj1);
        obj = obj1;
        hashmap;
        JVM INSTR monitorexit ;
        return ((List) (obj));
        class1;
        throw class1;
    }

    public static qn _mth043E()
    {
        return new qn();
    }

    public final void unregister(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj1 = (List)PF.get(obj);
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        obj1 = ((List) (obj1)).iterator();
_L10:
        if (!((Iterator) (obj1)).hasNext()) goto _L4; else goto _L3
_L3:
        Object obj2;
        obj2 = (Class)((Iterator) (obj1)).next();
        obj2 = (List)PE.get(obj2);
        if (obj2 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        int j = ((List) (obj2)).size();
        int i = 0;
_L8:
        if (i >= j)
        {
            continue; /* Loop/switch isn't completed */
        }
        qw qw1 = (qw)((List) (obj2)).get(i);
        int k;
        int l;
        k = j;
        l = i;
        if (qw1.Qp != obj) goto _L6; else goto _L5
_L5:
        qw1.Qr = false;
        ((List) (obj2)).remove(i);
        l = i - 1;
        k = j - 1;
          goto _L6
_L4:
        PF.remove(obj);
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Log.w(TAG, (new StringBuilder("Subscriber to unregister was not registered before: ")).append(obj.getClass()).toString());
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
_L6:
        i = l + 1;
        j = k;
        if (true) goto _L8; else goto _L7
_L7:
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void _mth02CA(Object obj, boolean flag, int i)
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = PL._mth1FBE(obj.getClass()).iterator();
_L1:
        CopyOnWriteArrayList copyonwritearraylist;
        Class class1;
        qw qw1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_273;
        }
        qu qu1 = (qu)iterator.next();
        class1 = qu1.Ql;
        copyonwritearraylist = (CopyOnWriteArrayList)PE.get(class1);
        qw1 = new qw(obj, qu1, 0);
        if (copyonwritearraylist != null)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        Object obj1;
        obj1 = new CopyOnWriteArrayList();
        PE.put(class1, obj1);
        break MISSING_BLOCK_LABEL_162;
        obj1 = copyonwritearraylist;
        if (copyonwritearraylist.contains(qw1))
        {
            throw new qo((new StringBuilder("Subscriber ")).append(obj.getClass()).append(" already registered to event ").append(class1).toString());
        }
        int j = ((CopyOnWriteArrayList) (obj1)).size();
        List list;
        for (i = 0; i > j; i++)
        {
            break MISSING_BLOCK_LABEL_214;
        }

        if (i == j)
        {
            break MISSING_BLOCK_LABEL_203;
        }
        if (qw1.priority <= ((qw)((CopyOnWriteArrayList) (obj1)).get(i)).priority)
        {
            break MISSING_BLOCK_LABEL_281;
        }
        ((CopyOnWriteArrayList) (obj1)).add(i, qw1);
        list = (List)PF.get(obj);
        obj1 = list;
        if (list != null)
        {
            break MISSING_BLOCK_LABEL_260;
        }
        obj1 = new ArrayList();
        PF.put(obj, obj1);
        ((List) (obj1)).add(class1);
          goto _L1
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }

    final void _mth02CB(qw qw1, Object obj)
    {
        try
        {
            qw1.Qq.method.invoke(qw1.Qp, new Object[] {
                obj
            });
            return;
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            _mth02CA(qw1, obj, invocationtargetexception.getCause());
        }
        // Misplaced declaration of an exception variable
        catch (qw qw1)
        {
            throw new IllegalStateException("Unexpected exception", qw1);
        }
    }

    public final void _mth1429(Object obj)
    {
        if if1;
        ArrayList arraylist;
        if1 = (if)PH.get();
        arraylist = if1.PU;
        arraylist.add(obj);
        if (if1.PV)
        {
            break MISSING_BLOCK_LABEL_260;
        }
        boolean flag;
        if (Looper.getMainLooper() == Looper.myLooper())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if1.PW = flag;
        if1.PV = true;
_L6:
        Class class1;
        if (arraylist.isEmpty())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = arraylist.remove(0);
        class1 = obj.getClass();
        boolean flag1 = false;
        if (!PR) goto _L2; else goto _L1
_L1:
        List list;
        int j;
        list = _mth037A(class1);
        j = list.size();
        int i = 0;
_L4:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 |= _mth02CA(obj, if1, (Class)list.get(i));
        i++;
        if (true) goto _L4; else goto _L3
_L2:
        flag1 = _mth02CA(obj, if1, class1);
_L3:
        if (flag1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (PO)
        {
            Log.d(TAG, (new StringBuilder("No subscribers registered for event ")).append(class1).toString());
        }
        if (!PQ || class1 == o/qq || class1 == o/qt)
        {
            continue; /* Loop/switch isn't completed */
        }
        _mth1429(new qq(this, obj));
        if (true) goto _L6; else goto _L5
_L5:
        if1.PV = false;
        if1.PW = false;
        return;
        obj;
        if1.PV = false;
        if1.PW = false;
        throw obj;
    }

}
