// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.signin.internal.AuthAccountResult;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

// Referenced classes of package o:
//            ci, _cls072B, db, cd, 
//            cj, by, _cls1448, _cls09A8, 
//            _cls0E44, _cls067B, _cls14B4, bs, 
//            hn, bz

public final class bx
    implements ci
{
    final class aux extends _cls02BC
    {

        private bx AM;
        private final ArrayList AY;

        public final void _mth216C()
        {
            Set set = AM.Au.Bk;
            Object obj = set;
            if (set.isEmpty())
            {
                obj = AM.FEAC();
            }
            for (Iterator iterator = AY.iterator(); iterator.hasNext(); ((_cls09A8._cls02CA)iterator.next())._mth02CA(AM.AI, ((Set) (obj)))) { }
        }

        public aux(ArrayList arraylist)
        {
            AM = bx.this;
            super((byte)0);
            AY = arraylist;
        }
    }

    public static final class if extends hn
    {

        private final WeakReference AN;

        public final void _mth02CA(ConnectionResult connectionresult, AuthAccountResult authaccountresult)
        {
            bx bx1 = (bx)AN.get();
            if (bx1 == null)
            {
                return;
            } else
            {
                authaccountresult = bx1.Au;
                connectionresult = new bz(this, bx1, bx1, connectionresult);
                connectionresult = ((cd) (authaccountresult)).Bg.obtainMessage(3, connectionresult);
                ((cd) (authaccountresult)).Bg.sendMessage(connectionresult);
                return;
            }
        }

        if(bx bx1)
        {
            AN = new WeakReference(bx1);
        }
    }

    /* member class not found */
    class _cls02BB {}

    /* member class not found */
    class _cls02BC {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}

    /* member class not found */
    class _cls02CF {}

    /* member class not found */
    class _cls141D {}


    private boolean AA;
    private int AB;
    private final Bundle AC = new Bundle();
    private final HashSet AD = new HashSet();
    db AE;
    private int AF;
    boolean AG;
    boolean AH;
    _cls14B4 AI;
    boolean AJ;
    private final Map AK;
    private ArrayList AL;
    final cd Au;
    final Lock Aw;
    private ConnectionResult Ax;
    private int Ay;
    private int Az;
    final Context mContext;
    private final _cls0E44 xO;
    private final _cls072B xa;
    private final _cls09A8.if xb;
    boolean xz;

    public bx(cd cd1, _cls0E44 _pcls0e44, Map map, _cls072B _pcls072b, _cls09A8.if if1, Lock lock, Context context)
    {
        Az = 0;
        AA = false;
        AL = new ArrayList();
        Au = cd1;
        xO = _pcls0e44;
        AK = map;
        xa = _pcls072b;
        xb = if1;
        Aw = lock;
        mContext = context;
    }

    private boolean _mth02CA(int i, int j, ConnectionResult connectionresult)
    {
        if (j == 1)
        {
            if (connectionresult.wC != 0 && connectionresult.mPendingIntent != null)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            if (j != 0)
            {
                j = 1;
            } else
            if (xa._mth02CA(null, connectionresult.wC, null) != null)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            if (j == 0)
            {
                return false;
            }
        }
        return Ax == null || i < Ay;
    }

    private void _mth02E1(boolean flag)
    {
        if (AE != null)
        {
            if (AE.isConnected() && flag)
            {
                AE._mth0283();
            }
            AE.disconnect();
            AI = null;
        }
    }

    private static String _mth03B9(int i)
    {
        switch (i)
        {
        case 0: // '\0'
            return "STEP_GETTING_SERVICE_BINDINGS";

        case 1: // '\001'
            return "STEP_VALIDATING_ACCOUNT";

        case 2: // '\002'
            return "STEP_AUTHENTICATING";

        case 3: // '\003'
            return "STEP_GETTING_REMOTE_SERVICE";
        }
        return "UNKNOWN";
    }

    private void FB68()
    {
        Au.FEE3();
        cj.FF72().execute(new by(this));
        if (AE != null)
        {
            if (xz)
            {
                AE._mth02CA(AI, AJ);
            }
            _mth02E1(false);
        }
        _cls09A8._cls02CB _lcls02cb;
        for (Iterator iterator = Au.Bj.keySet().iterator(); iterator.hasNext(); ((_cls09A8._cls02CA)Au.Bi.get(_lcls02cb)).disconnect())
        {
            _lcls02cb = (_cls09A8._cls02CB)iterator.next();
        }

        if (AA)
        {
            AA = false;
            disconnect();
            return;
        }
        Bundle bundle;
        if (AC.isEmpty())
        {
            bundle = null;
        } else
        {
            bundle = AC;
        }
        Au.Bb._mth02BB(bundle);
    }

    private void FE8C()
    {
        for (Iterator iterator = AL.iterator(); iterator.hasNext(); ((Future)iterator.next()).cancel(true)) { }
        AL.clear();
    }

    public final void begin()
    {
        Au.Bb.yl = true;
        Au.Bj.clear();
        AA = false;
        AG = false;
        Ax = null;
        Az = 0;
        AF = 2;
        AH = false;
        xz = false;
        HashMap hashmap = new HashMap();
        _cls09A8 _lcls09a8;
        _cls09A8._cls02CA _lcls02ca;
        int i;
        for (Iterator iterator = AK.keySet().iterator(); iterator.hasNext(); hashmap.put(_lcls02ca, new _cls02CE(_lcls09a8, i)))
        {
            _lcls09a8 = (_cls09A8)iterator.next();
            _lcls02ca = (_cls09A8._cls02CA)Au.Bi.get(_lcls09a8._mth028F());
            i = ((Integer)AK.get(_lcls09a8)).intValue();
            _lcls09a8._mth027B();
            if (!_lcls02ca._mth0294())
            {
                continue;
            }
            AG = true;
            if (i < AF)
            {
                AF = i;
            }
            if (i != 0)
            {
                AD.add(_lcls09a8._mth028F());
            }
        }

        if (AG)
        {
            xO.xL = Integer.valueOf(System.identityHashCode(Au));
            _cls141D _lcls141d = new _cls141D((byte)0);
            AE = (db)xb._mth02CA(mContext, Au.wZ, xO, xO.xe, _lcls141d, _lcls141d);
        }
        AB = Au.Bi.size();
        AL.add(cj.FF72().submit(new _cls02CF(hashmap)));
    }

    public final void connect()
    {
        AA = false;
    }

    public final void disconnect()
    {
        for (Iterator iterator = Au.Bc.iterator(); iterator.hasNext(); iterator.remove())
        {
            ((cd.aux)iterator.next()).cancel();
        }

        Au.FEAF();
        if (Ax == null && !Au.Bc.isEmpty())
        {
            AA = true;
            return;
        } else
        {
            FE8C();
            _mth02E1(true);
            Au.Bj.clear();
            Au._mth02BD(null);
            _cls1448 _lcls1448 = Au.Bb;
            _lcls1448.yl = false;
            _lcls1448.ym.incrementAndGet();
            return;
        }
    }

    public final String getName()
    {
        return "CONNECTING";
    }

    boolean _mth02BB(ConnectionResult connectionresult)
    {
label0:
        {
            if (AF != 2)
            {
                if (AF != 1)
                {
                    break label0;
                }
                boolean flag;
                if (connectionresult.wC != 0 && connectionresult.mPendingIntent != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    break label0;
                }
            }
            return true;
        }
        return false;
    }

    void _mth02BC(ConnectionResult connectionresult)
    {
        FE8C();
        boolean flag;
        if (connectionresult.wC != 0 && connectionresult.mPendingIntent != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        boolean flag1;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        _mth02E1(flag1);
        Au.Bj.clear();
        Au._mth02BD(connectionresult);
        if (!_cls072B._mth1FBE(mContext, connectionresult.wC))
        {
            Au.FF2A();
        }
        if (!AA && !Au.Bd)
        {
            Au.Bb._mth141D(connectionresult);
        }
        AA = false;
        connectionresult = Au.Bb;
        connectionresult.yl = false;
        ((_cls1448) (connectionresult)).ym.incrementAndGet();
    }

    public final void _mth02C1(int i)
    {
        _mth02BC(new ConnectionResult(8, null));
    }

    public final bs _mth02CA(bs bs)
    {
        Au.Bc.add(bs);
        return bs;
    }

    public final void _mth02CA(ConnectionResult connectionresult, _cls09A8 _pcls09a8, int i)
    {
        if (!_mth02E4(3))
        {
            return;
        }
        _mth02CB(connectionresult, _pcls09a8, i);
        if (_mth2174())
        {
            FB68();
        }
    }

    public final bs _mth02CB(bs bs)
    {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    void _mth02CB(ConnectionResult connectionresult, _cls09A8 _pcls09a8, int i)
    {
        if (i != 2)
        {
            _pcls09a8._mth027B();
            if (_mth02CA(0x7fffffff, i, connectionresult))
            {
                Ax = connectionresult;
                Ay = 0x7fffffff;
            }
        }
        Au.Bj.put(_pcls09a8._mth028F(), connectionresult);
    }

    boolean _mth02E4(int i)
    {
        if (Az != i)
        {
            cd cd1 = Au;
            StringWriter stringwriter = new StringWriter();
            cd1.dump("", null, new PrintWriter(stringwriter), null);
            Log.i("GoogleApiClientConnecting", stringwriter.toString());
            Log.wtf("GoogleApiClientConnecting", (new StringBuilder("GoogleApiClient connecting is in step ")).append(_mth03B9(Az)).append(" but received callback for step ").append(_mth03B9(i)).toString(), new Exception());
            _mth02BC(new ConnectionResult(8, null));
            return false;
        } else
        {
            return true;
        }
    }

    public final void _mth141D(Bundle bundle)
    {
        if (!_mth02E4(3))
        {
            return;
        }
        if (bundle != null)
        {
            AC.putAll(bundle);
        }
        if (_mth2174())
        {
            FB68();
        }
    }

    boolean _mth2174()
    {
        AB = AB - 1;
        if (AB > 0)
        {
            return false;
        }
        if (AB < 0)
        {
            cd cd1 = Au;
            StringWriter stringwriter = new StringWriter();
            cd1.dump("", null, new PrintWriter(stringwriter), null);
            Log.i("GoogleApiClientConnecting", stringwriter.toString());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            _mth02BC(new ConnectionResult(8, null));
            return false;
        }
        if (Ax != null)
        {
            _mth02BC(Ax);
            return false;
        } else
        {
            return true;
        }
    }

    void _mth30A3()
    {
        if (AB != 0)
        {
            return;
        }
        if (AG)
        {
            if (AH)
            {
                ArrayList arraylist = new ArrayList();
                Az = 1;
                AB = Au.Bi.size();
                Iterator iterator = Au.Bi.keySet().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    _cls09A8._cls02CB _lcls02cb = (_cls09A8._cls02CB)iterator.next();
                    if (Au.Bj.containsKey(_lcls02cb))
                    {
                        if (_mth2174())
                        {
                            FB3A();
                        }
                    } else
                    {
                        arraylist.add(Au.Bi.get(_lcls02cb));
                    }
                } while (true);
                if (!arraylist.isEmpty())
                {
                    AL.add(cj.FF72().submit(new _cls02BB(arraylist)));
                }
                return;
            }
        } else
        {
            FB3B();
        }
    }

    void FB3A()
    {
        Az = 2;
        Au.Bk = FEAC();
        AL.add(cj.FF72().submit(new _cls02CB((byte)0)));
    }

    void FB3B()
    {
        ArrayList arraylist = new ArrayList();
        Az = 3;
        AB = Au.Bi.size();
        Iterator iterator = Au.Bi.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            _cls09A8._cls02CB _lcls02cb = (_cls09A8._cls02CB)iterator.next();
            if (Au.Bj.containsKey(_lcls02cb))
            {
                if (_mth2174())
                {
                    FB68();
                }
            } else
            {
                arraylist.add(Au.Bi.get(_lcls02cb));
            }
        } while (true);
        if (!arraylist.isEmpty())
        {
            AL.add(cj.FF72().submit(new aux(arraylist)));
        }
    }

    void FBA2()
    {
        AG = false;
        Au.Bk = Collections.emptySet();
        Iterator iterator = AD.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            _cls09A8._cls02CB _lcls02cb = (_cls09A8._cls02CB)iterator.next();
            if (!Au.Bj.containsKey(_lcls02cb))
            {
                Au.Bj.put(_lcls02cb, new ConnectionResult(17, null));
            }
        } while (true);
    }

    HashSet FEAC()
    {
        HashSet hashset = new HashSet(xO.xG);
        Map map = xO.xI;
        Iterator iterator = map.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            _cls09A8 _lcls09a8 = (_cls09A8)iterator.next();
            if (!Au.Bj.containsKey(_lcls09a8._mth028F()))
            {
                hashset.addAll(((_cls067B)map.get(_lcls09a8)).wr);
            }
        } while (true);
        return hashset;
    }
}
