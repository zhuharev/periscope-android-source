// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;

// Referenced classes of package o:
//            _cls03DF, _cls0493, _cls0672, _cls14FD, 
//            apa, _cls0582, _cls0645, _cls0481, 
//            FF83, FF54, _cls04AD, FF9A, 
//            _cls03A5, _cls04AE, _cls026B, FEAE, 
//            FF7A, FF43, _cls1D08, _cls0287, 
//            FF8B, _cls05D4

public class _cls028B
    implements _cls03DF, _cls14FD.if, _cls04AD.if
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}


    private final _cls0493 mA;
    private final _cls14FD mB;
    private final if mC;
    private final Map mD;
    private final _cls0672 mE;
    private final _cls026B.if mF;
    private ReferenceQueue mG;
    private final Map mz;

    public _cls028B()
    {
    }

    public _cls028B(_cls14FD _pcls14fd, _cls13D0.if if1, ExecutorService executorservice, ExecutorService executorservice1)
    {
        this(_pcls14fd, if1, executorservice, executorservice1, null, null, null, null, null);
    }

    private _cls028B(_cls14FD _pcls14fd, _cls13D0.if if1, ExecutorService executorservice, ExecutorService executorservice1, Map map, _cls0493 _pcls0493, Map map1, 
            if if2, _cls0672 _pcls0672)
    {
        mB = _pcls14fd;
        mF = new _cls026B.if(if1);
        mD = new HashMap();
        mA = new _cls0493();
        mz = new HashMap();
        mC = new if(executorservice, executorservice1, this);
        mE = new _cls0672();
        _pcls14fd._mth02CA(this);
    }

    public static int _mth02CA(byte abyte0[], int i, ArrayList arraylist)
    {
        if (i == abyte0.length)
        {
            return i;
        }
        int k = i + 1;
        int j = k;
        switch (abyte0[i])
        {
        default:
            return k;

        case 4: // '\004'
        case 7: // '\007'
            break;

        case 9: // '\t'
            return k;

        case 5: // '\005'
            arraylist.add(null);
            return k;

        case 6: // '\006'
            arraylist.add(null);
            return k;

        case 1: // '\001'
            j = k;
            if (k < abyte0.length)
            {
                boolean flag;
                if (abyte0[k] != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                arraylist.add(Boolean.valueOf(flag));
                return k + 1;
            }
            break;

        case 2: // '\002'
            j = k;
            if (k >= abyte0.length - 2)
            {
                break;
            }
            int i1 = ((abyte0[k] & 0xff) << 8) + (abyte0[k + 1] & 0xff);
            j = k + 2;
            i = j;
            if (j < abyte0.length - i1)
            {
                arraylist.add(new String(abyte0, j, i1, StandardCharsets.UTF_8));
                i = j + i1;
            }
            return i;

        case 0: // '\0'
            j = k;
            if (k <= abyte0.length - 8)
            {
                long l1 = _mth02CB(abyte0, k + 4);
                arraylist.add(Double.valueOf(Double.longBitsToDouble(_mth02CB(abyte0, k) << 32 | l1)));
                return k + 8;
            }
            break;

        case 3: // '\003'
            return _mth02CB(abyte0, k, arraylist);

        case 8: // '\b'
            return _mth02CB(abyte0, k + 4, arraylist);

        case 10: // '\n'
            j = k;
            if (k >= abyte0.length - 4)
            {
                break;
            }
            j = (int)_mth02CB(abyte0, k);
            i = k + 4;
            ArrayList arraylist1 = new ArrayList();
            do
            {
                int l = j;
                j = l - 1;
                if (l <= 0)
                {
                    break;
                }
                i = _mth02CA(abyte0, i, arraylist1);
            } while (true);
            arraylist.add(((Object) (arraylist1.toArray())));
            j = i;
            break;
        }
        return j;
    }

    public static void _mth02CA(Object obj, ByteArrayOutputStream bytearrayoutputstream)
    {
        if (obj == null)
        {
            bytearrayoutputstream.write(5);
            return;
        }
        if (obj instanceof Boolean)
        {
            obj = (Boolean)obj;
            bytearrayoutputstream.write(1);
            int i;
            if (((Boolean) (obj)).booleanValue())
            {
                i = 1;
            } else
            {
                i = 0;
            }
            bytearrayoutputstream.write(i);
            return;
        }
        if ((obj instanceof Double) || (obj instanceof Integer))
        {
            if (obj instanceof Integer)
            {
                obj = Double.valueOf(((Integer)obj).doubleValue());
            } else
            {
                obj = (Double)obj;
            }
            long l = Double.doubleToLongBits(((Double) (obj)).doubleValue());
            obj = new byte[9];
            obj[0] = 0;
            apa._mth02BB(l >> 32, ((byte []) (obj)), 1);
            apa._mth02BB(l, ((byte []) (obj)), 5);
            bytearrayoutputstream.write(((byte []) (obj)), 0, 9);
            return;
        }
        if (obj instanceof String)
        {
            obj = (String)obj;
            bytearrayoutputstream.write(2);
            _mth02CA(((String) (obj)), bytearrayoutputstream);
            return;
        }
        if (obj instanceof Map)
        {
            bytearrayoutputstream.write(3);
            obj = (Map)obj;
            Object obj1;
            for (Iterator iterator = ((Map) (obj)).keySet().iterator(); iterator.hasNext(); _mth02CA(obj1, bytearrayoutputstream))
            {
                String s = (String)iterator.next();
                obj1 = ((Map) (obj)).get(s);
                _mth02CA(s, bytearrayoutputstream);
            }

            bytearrayoutputstream.write(new byte[] {
                0, 0, 9
            }, 0, 3);
            return;
        }
        if (obj instanceof Object[])
        {
            byte abyte0[] = new byte[5];
            abyte0[0] = 10;
            obj = ((Object) ((Object[])obj));
            apa._mth02BB(obj.length, abyte0, 1);
            bytearrayoutputstream.write(abyte0, 0, 5);
            int k = obj.length;
            for (int j = 0; j < k; j++)
            {
                _mth02CA(obj[j], bytearrayoutputstream);
            }

        }
    }

    private static void _mth02CA(String s, long l, _cls0481 _pcls0481)
    {
        Log.v("Engine", (new StringBuilder()).append(s).append(" in ").append(_cls0582._mth02BB(l)).append("ms, key: ").append(_pcls0481).toString());
    }

    public static void _mth02CA(String s, ByteArrayOutputStream bytearrayoutputstream)
    {
        s = s.getBytes(StandardCharsets.UTF_8);
        bytearrayoutputstream.write((s.length >> 8) % 256);
        bytearrayoutputstream.write(s.length % 256);
        bytearrayoutputstream.write(s, 0, s.length);
    }

    public static Object[] _mth02CA(byte abyte0[], int i)
    {
        ArrayList arraylist = new ArrayList();
        for (int j = 0; j < i && abyte0[j] != 9; j = _mth02CA(abyte0, j, arraylist)) { }
        return arraylist.toArray();
    }

    public static int _mth02CB(byte abyte0[], int i, ArrayList arraylist)
    {
        HashMap hashmap = new HashMap();
        int j = i;
        do
        {
            i = j;
            if (j >= abyte0.length - 2)
            {
                break;
            }
            i = abyte0[j];
            int k = (abyte0[j + 1] & 0xff) + ((i & 0xff) << 8);
            j += 2;
            i = j;
            if (j >= abyte0.length - k)
            {
                break;
            }
            String s = new String(abyte0, j, k, StandardCharsets.UTF_8);
            ArrayList arraylist1 = new ArrayList();
            j = _mth02CA(abyte0, j + k, arraylist1);
            i = j;
            if (s.length() <= 0)
            {
                break;
            }
            i = j;
            if (arraylist1.size() != 1)
            {
                break;
            }
            hashmap.put(s, arraylist1.get(0));
        } while (true);
        arraylist.add(hashmap);
        return i;
    }

    public static long _mth02CB(byte abyte0[], int i)
    {
        long l = abyte0[i] & 0xff;
        byte byte0 = abyte0[i + 1];
        byte byte1 = abyte0[i + 2];
        i = abyte0[i + 3];
        return (l << 24 & 0xffffffffff000000L) + (long)((byte0 & 0xff) << 16) + (long)((byte1 & 0xff) << 8) + (long)(i & 0xff);
    }

    public static byte[] _mth02CB(Object aobj[])
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        int j = aobj.length;
        for (int i = 0; i < j; i++)
        {
            _mth02CA(aobj[i], bytearrayoutputstream);
        }

        return bytearrayoutputstream.toByteArray();
    }

    public static Object[] _mth02CB(byte abyte0[])
    {
        return _mth02CA(abyte0, abyte0.length);
    }

    private ReferenceQueue _mth1D34()
    {
        if (mG == null)
        {
            mG = new ReferenceQueue();
            Looper.myQueue().addIdleHandler(new _cls02CB(mD, mG));
        }
        return mG;
    }

    public final _cls02CA _mth02CA(FEAE feae, int i, int j, FF83 ff83, FF7A ff7a, FF43 ff43, _cls1D08 _pcls1d08, 
            int k, boolean flag, _cls0287 _pcls0287, FF8B ff8b)
    {
        _cls0645._mth0631();
        long l = _cls0582._mth0621();
        _cls0481 _lcls0481 = new _cls0481(ff83.getId(), feae, i, j, ff7a._mth4E28(), ff7a._mth6C35(), ff43, ff7a.FB59(), _pcls1d08, ff7a._mth706C());
        if (!flag)
        {
            feae = null;
        } else
        {
            feae = mB._mth02BC(_lcls0481);
            if (feae == null)
            {
                feae = null;
            } else
            if (feae instanceof _cls04AD)
            {
                feae = (_cls04AD)feae;
            } else
            {
                feae = new _cls04AD(feae, true);
            }
            if (feae != null)
            {
                feae.acquire();
                mD.put(_lcls0481, new _cls02CE(_lcls0481, feae, _mth1D34()));
            }
        }
        if (feae != null)
        {
            ff8b._mth141D(feae);
            if (Log.isLoggable("Engine", 2))
            {
                _mth02CA("Loaded resource from cache", l, _lcls0481);
            }
            return null;
        }
        if (!flag)
        {
            feae = null;
        } else
        {
            feae = null;
            WeakReference weakreference = (WeakReference)mD.get(_lcls0481);
            if (weakreference != null)
            {
                feae = (_cls04AD)weakreference.get();
                if (feae != null)
                {
                    feae.acquire();
                } else
                {
                    mD.remove(_lcls0481);
                }
            }
        }
        if (feae != null)
        {
            ff8b._mth141D(feae);
            if (Log.isLoggable("Engine", 2))
            {
                _mth02CA("Loaded resource from active resources", l, _lcls0481);
            }
            return null;
        }
        feae = (_cls03A5)mz.get(_lcls0481);
        if (feae != null)
        {
            feae._mth02CA(ff8b);
            if (Log.isLoggable("Engine", 2))
            {
                _mth02CA("Added to existing load", l, _lcls0481);
            }
            return new _cls02CA(ff8b, feae);
        }
        feae = mC;
        feae = new _cls03A5(_lcls0481, ((if) (feae)).mH, ((if) (feae)).mI, flag, ((if) (feae)).mJ);
        ff83 = new _cls04AE(feae, new _cls026B(_lcls0481, i, j, ff83, ff7a, ff43, _pcls1d08, mF, _pcls0287, k), k);
        mz.put(_lcls0481, feae);
        feae._mth02CA(ff8b);
        feae.mX = ff83;
        feae.mZ = ((_cls03A5) (feae)).mH.submit(ff83);
        if (Log.isLoggable("Engine", 2))
        {
            _mth02CA("Started new load", l, _lcls0481);
        }
        return new _cls02CA(ff8b, feae);
    }

    public final void _mth02CA(_cls03A5 _pcls03a5, FEAE feae)
    {
        _cls0645._mth0631();
        if (_pcls03a5.equals((_cls03A5)mz.get(feae)))
        {
            mz.remove(feae);
        }
    }

    public final void _mth02CA(FEAE feae, _cls04AD _pcls04ad)
    {
        _cls0645._mth0631();
        if (_pcls04ad != null)
        {
            _pcls04ad.mN = feae;
            _pcls04ad.ng = this;
            if (_pcls04ad.jy)
            {
                mD.put(feae, new _cls02CE(feae, _pcls04ad, _mth1D34()));
            }
        }
        mz.remove(feae);
    }

    public final void _mth02CB(FEAE feae, _cls04AD _pcls04ad)
    {
        _cls0645._mth0631();
        mD.remove(feae);
        if (_pcls04ad.jy)
        {
            mB._mth02CE(feae, _pcls04ad);
            return;
        } else
        {
            mE._mth02BB(_pcls04ad);
            return;
        }
    }

    public final void _mth02CF(_cls05D4 _pcls05d4)
    {
        _cls0645._mth0631();
        mE._mth02BB(_pcls05d4);
    }
}
