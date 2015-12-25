// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package o:
//            _cls1681, _cls1EF2, rx

final class _cls05D8
{

    private static final _cls1681 vR = _cls1681._mth02CD("0");
    private final Context context;
    android.app.ActivityManager.RunningAppProcessInfo vS;
    Thread vT[];
    List vU;
    StackTraceElement vV[];
    private final _cls1681 vW;
    private final _cls1681 vX;
    private final int vY = 8;

    public _cls05D8(Context context1, String s, String s1)
    {
        context = context1;
        vW = _cls1681._mth02CD(s1);
        if (s == null)
        {
            context1 = null;
        } else
        {
            context1 = _cls1681._mth02CD(s.replace("-", ""));
        }
        vX = context1;
    }

    private int _mth012C()
    {
        int j = _cls1EF2._mth02CE(1, 0L) + 0 + _cls1EF2._mth02CE(2, 0L) + _cls1EF2._mth02CB(3, vW);
        int i = j;
        if (vX != null)
        {
            i = j + _cls1EF2._mth02CB(4, vX);
        }
        return i;
    }

    static int _mth02CA(float f, int i, boolean flag, int j, long l, long l1)
    {
        return _cls1EF2.FE74(8) + 4 + 0 + _cls1EF2._mth1429(2, i) + (_cls1EF2.FE74(24) + 1) + (_cls1EF2.FE74(32) + _cls1EF2.FE74(j)) + _cls1EF2._mth02CE(5, l) + _cls1EF2._mth02CE(6, l1);
    }

    private static int _mth02CA(StackTraceElement stacktraceelement, boolean flag)
    {
        int i;
        if (stacktraceelement.isNativeMethod())
        {
            i = _cls1EF2._mth02CE(1, Math.max(stacktraceelement.getLineNumber(), 0)) + 0;
        } else
        {
            i = _cls1EF2._mth02CE(1, 0L) + 0;
        }
        int j = i + _cls1EF2._mth02CB(2, _cls1681._mth02CD((new StringBuilder()).append(stacktraceelement.getClassName()).append(".").append(stacktraceelement.getMethodName()).toString()));
        i = j;
        if (stacktraceelement.getFileName() != null)
        {
            i = j + _cls1EF2._mth02CB(3, _cls1681._mth02CD(stacktraceelement.getFileName()));
        }
        j = i;
        if (!stacktraceelement.isNativeMethod())
        {
            j = i;
            if (stacktraceelement.getLineNumber() > 0)
            {
                j = i + _cls1EF2._mth02CE(4, stacktraceelement.getLineNumber());
            }
        }
        if (flag)
        {
            i = 2;
        } else
        {
            i = 0;
        }
        return j + (_cls1EF2.FE74(40) + _cls1EF2.FE74(i));
    }

    private int _mth02CA(Thread thread, Throwable throwable)
    {
        int i = _mth02CA(thread, vV, 4, true);
        i = _cls1EF2.FE74(8) + _cls1EF2.FE74(i) + i + 0;
        int l = vT.length;
        for (int j = 0; j < l; j++)
        {
            int i1 = _mth02CA(vT[j], (StackTraceElement[])vU.get(j), 0, false);
            i += _cls1EF2.FE74(8) + _cls1EF2.FE74(i1) + i1;
        }

        int k = _mth02CA(throwable, 1);
        l = _cls1EF2.FE74(16);
        int j1 = _cls1EF2.FE74(k);
        int k1 = _cls1EF2._mth02CB(1, vR) + 0 + _cls1EF2._mth02CB(2, vR) + _cls1EF2._mth02CE(3, 0L);
        int l1 = _cls1EF2.FE74(24);
        int i2 = _cls1EF2.FE74(k1);
        int j2 = _mth012C();
        return i + (l + j1 + k) + (l1 + i2 + k1) + (_cls1EF2.FE74(24) + _cls1EF2.FE74(j2) + j2);
    }

    private int _mth02CA(Thread thread, StackTraceElement astacktraceelement[], int i, boolean flag)
    {
        int j = _cls1EF2._mth02CB(1, _cls1681._mth02CD(thread.getName())) + (_cls1EF2.FE74(16) + _cls1EF2.FE74(i));
        int k = astacktraceelement.length;
        for (i = 0; i < k; i++)
        {
            int l = _mth02CA(astacktraceelement[i], flag);
            j += _cls1EF2.FE74(24) + _cls1EF2.FE74(l) + l;
        }

        return j;
    }

    private int _mth02CA(Throwable throwable, int i)
    {
        int k = _cls1EF2._mth02CB(1, _cls1681._mth02CD(throwable.getClass().getName())) + 0;
        String s = throwable.getLocalizedMessage();
        int j = k;
        if (s != null)
        {
            j = k + _cls1EF2._mth02CB(3, _cls1681._mth02CD(s));
        }
        StackTraceElement astacktraceelement[] = throwable.getStackTrace();
        int l = astacktraceelement.length;
        for (k = 0; k < l; k++)
        {
            int i1 = _mth02CA(astacktraceelement[k], true);
            j += _cls1EF2.FE74(32) + _cls1EF2.FE74(i1) + i1;
        }

        throwable = throwable.getCause();
        k = j;
        if (throwable != null)
        {
            if (i < 8)
            {
                i = _mth02CA(throwable, i + 1);
                return j + (_cls1EF2.FE74(48) + _cls1EF2.FE74(i) + i);
            }
            for (i = 0; throwable != null; i++)
            {
                throwable = throwable.getCause();
            }

            k = j + (_cls1EF2.FE74(56) + _cls1EF2.FE74(i));
        }
        return k;
    }

    static int _mth02CA(_cls1681 _pcls1681)
    {
        return _cls1EF2._mth02CB(1, _pcls1681);
    }

    private int _mth02CA(_cls1681 _pcls1681, _cls1681 _pcls1681_1, _cls1681 _pcls1681_2, _cls1681 _pcls1681_3, int i)
    {
        int j = _cls1EF2._mth02CB(1, _pcls1681);
        int k = _cls1EF2._mth02CB(2, _pcls1681_1);
        int l = _cls1EF2._mth02CB(3, _pcls1681_2);
        int i1 = _cls1EF2._mth02CB(1, _cls1681._mth02CD((new rx())._mth06E5(context))) + 0;
        return j + 0 + k + l + (_cls1EF2.FE74(40) + _cls1EF2.FE74(i1) + i1) + _cls1EF2._mth02CB(6, _pcls1681_3) + _cls1EF2._mth1423(10, i);
    }

    private static int _mth02CA(_cls1681 _pcls1681, _cls1681 _pcls1681_1, boolean flag)
    {
        return _cls1EF2._mth1423(1, 3) + 0 + _cls1EF2._mth02CB(2, _pcls1681) + _cls1EF2._mth02CB(3, _pcls1681_1) + (_cls1EF2.FE74(32) + 1);
    }

    private void _mth02CA(_cls1EF2 _pcls1ef2, int i, StackTraceElement stacktraceelement, boolean flag)
    {
        _pcls1ef2.FBE8(i << 3 | 2);
        _pcls1ef2.FBE8(_mth02CA(stacktraceelement, flag));
        if (stacktraceelement.isNativeMethod())
        {
            _pcls1ef2._mth02CB(1, Math.max(stacktraceelement.getLineNumber(), 0));
        } else
        {
            _pcls1ef2._mth02CB(1, 0L);
        }
        _pcls1ef2._mth02CA(2, _cls1681._mth02CD((new StringBuilder()).append(stacktraceelement.getClassName()).append(".").append(stacktraceelement.getMethodName()).toString()));
        if (stacktraceelement.getFileName() != null)
        {
            _pcls1ef2._mth02CA(3, _cls1681._mth02CD(stacktraceelement.getFileName()));
        }
        if (!stacktraceelement.isNativeMethod() && stacktraceelement.getLineNumber() > 0)
        {
            _pcls1ef2._mth02CB(4, stacktraceelement.getLineNumber());
        }
        if (flag)
        {
            i = 4;
        } else
        {
            i = 0;
        }
        _pcls1ef2._mth02EE(5, i);
    }

    public static void _mth02CA(_cls1EF2 _pcls1ef2, String s, String s1, long l)
    {
        _pcls1ef2._mth02CA(1, _cls1681._mth02CD(s1));
        _pcls1ef2._mth02CA(2, _cls1681._mth02CD(s));
        _pcls1ef2._mth02CB(3, l);
    }

    private void _mth02CA(_cls1EF2 _pcls1ef2, Thread thread, StackTraceElement astacktraceelement[], int i, boolean flag)
    {
        _pcls1ef2.FBE8(10);
        _pcls1ef2.FBE8(_mth02CA(thread, astacktraceelement, i, flag));
        _pcls1ef2._mth02CA(1, _cls1681._mth02CD(thread.getName()));
        _pcls1ef2._mth02EE(2, i);
        int j = astacktraceelement.length;
        for (i = 0; i < j; i++)
        {
            _mth02CA(_pcls1ef2, 3, astacktraceelement[i], flag);
        }

    }

    private void _mth02CA(_cls1EF2 _pcls1ef2, Throwable throwable, int i, int j)
    {
        _pcls1ef2.FBE8(j << 3 | 2);
        _pcls1ef2.FBE8(_mth02CA(throwable, 1));
        _pcls1ef2._mth02CA(1, _cls1681._mth02CD(throwable.getClass().getName()));
        String s = throwable.getLocalizedMessage();
        if (s != null)
        {
            _pcls1ef2._mth02CA(3, _cls1681._mth02CD(s));
        }
        StackTraceElement astacktraceelement[] = throwable.getStackTrace();
        int k = astacktraceelement.length;
        for (j = 0; j < k; j++)
        {
            _mth02CA(_pcls1ef2, 4, astacktraceelement[j], true);
        }

        throwable = throwable.getCause();
        if (throwable != null)
        {
            if (i < 8)
            {
                _mth02CA(_pcls1ef2, throwable, i + 1, 6);
                return;
            }
            for (i = 0; throwable != null; i++)
            {
                throwable = throwable.getCause();
            }

            _pcls1ef2._mth02EE(7, i);
        }
    }

    int _mth02CA(Thread thread, Throwable throwable, int i, Map map)
    {
        int j = _mth02CA(thread, throwable);
        j = _cls1EF2.FE74(8) + _cls1EF2.FE74(j) + j + 0;
        int k = j;
        if (map != null)
        {
            throwable = map.entrySet().iterator();
            do
            {
                k = j;
                if (!throwable.hasNext())
                {
                    break;
                }
                thread = (java.util.Map.Entry)throwable.next();
                map = (String)thread.getKey();
                thread = (String)thread.getValue();
                k = _cls1EF2._mth02CB(1, _cls1681._mth02CD(map));
                if (thread == null)
                {
                    thread = "";
                }
                k += _cls1EF2._mth02CB(2, _cls1681._mth02CD(thread));
                j += _cls1EF2.FE74(16) + _cls1EF2.FE74(k) + k;
            } while (true);
        }
        j = k;
        if (vS != null)
        {
            if (vS.importance == 100);
            j = k + (_cls1EF2.FE74(24) + 1);
        }
        return j + (_cls1EF2.FE74(32) + _cls1EF2.FE74(i));
    }

    public final void _mth02CA(_cls1EF2 _pcls1ef2, String s, int i, String s1, int j, long l, 
            long l1, boolean flag, Map map, int k, String s2, String s3)
    {
        _cls1681 _lcls1681 = _cls1681._mth02CD(s);
        if (s1 == null)
        {
            s1 = null;
        } else
        {
            s1 = _cls1681._mth02CD(s1);
        }
        if (s3 == null)
        {
            s = null;
        } else
        {
            s = _cls1681._mth02CD(s3);
        }
        if (s2 == null)
        {
            s2 = null;
        } else
        {
            s2 = _cls1681._mth02CD(s2);
        }
        _pcls1ef2.FBE8(74);
        int j1 = _cls1EF2._mth02CB(1, _lcls1681);
        int k1 = _cls1EF2._mth1423(3, i);
        int i1;
        if (s1 == null)
        {
            i1 = 0;
        } else
        {
            i1 = _cls1EF2._mth02CB(4, s1);
        }
        i1 = j1 + 0 + k1 + i1 + (_cls1EF2.FE74(40) + _cls1EF2.FE74(j)) + _cls1EF2._mth02CE(6, l) + _cls1EF2._mth02CE(7, l1) + (_cls1EF2.FE74(80) + 1);
        j1 = i1;
        if (map != null)
        {
            s3 = map.entrySet().iterator();
            do
            {
                j1 = i1;
                if (!s3.hasNext())
                {
                    break;
                }
                Object obj = (java.util.Map.Entry)s3.next();
                si.if if1 = (si.if)((java.util.Map.Entry) (obj)).getKey();
                obj = (String)((java.util.Map.Entry) (obj)).getValue();
                j1 = _cls1EF2._mth1423(1, if1.Sj) + _cls1EF2._mth02CB(2, _cls1681._mth02CD(((String) (obj))));
                i1 += _cls1EF2.FE74(88) + _cls1EF2.FE74(j1) + j1;
            } while (true);
        }
        int i2 = _cls1EF2.FE74(96);
        int j2 = _cls1EF2.FE74(k);
        if (s2 == null)
        {
            i1 = 0;
        } else
        {
            i1 = _cls1EF2._mth02CB(13, s2);
        }
        if (s == null)
        {
            k1 = 0;
        } else
        {
            k1 = _cls1EF2._mth02CB(14, s);
        }
        _pcls1ef2.FBE8(j1 + (i2 + j2) + i1 + k1);
        _pcls1ef2._mth02CA(1, _lcls1681);
        _pcls1ef2._mth06E5(3, i);
        _pcls1ef2._mth02CA(4, s1);
        _pcls1ef2._mth02EE(5, j);
        _pcls1ef2._mth02CB(6, l);
        _pcls1ef2._mth02CB(7, l1);
        _pcls1ef2._mth037A(10, flag);
        for (s1 = map.entrySet().iterator(); s1.hasNext(); _pcls1ef2._mth02CA(2, _cls1681._mth02CD((String)map.getValue())))
        {
            map = (java.util.Map.Entry)s1.next();
            _pcls1ef2.FBE8(90);
            s3 = (si.if)map.getKey();
            String s4 = (String)map.getValue();
            _pcls1ef2.FBE8(_cls1EF2._mth1423(1, ((si.if) (s3)).Sj) + _cls1EF2._mth02CB(2, _cls1681._mth02CD(s4)));
            _pcls1ef2._mth06E5(1, ((si.if)map.getKey()).Sj);
        }

        _pcls1ef2._mth02EE(12, k);
        if (s2 != null)
        {
            _pcls1ef2._mth02CA(13, s2);
        }
        if (s != null)
        {
            _pcls1ef2._mth02CA(14, s);
        }
    }

    public final void _mth02CA(_cls1EF2 _pcls1ef2, String s, String s1, String s2)
    {
        if (s == null)
        {
            s = "";
        }
        _cls1681 _lcls1681_1 = _cls1681._mth02CD(s);
        if (s1 == null)
        {
            s = null;
        } else
        {
            s = _cls1681._mth02CD(s1);
        }
        _cls1681 _lcls1681;
        if (s2 == null)
        {
            _lcls1681 = null;
        } else
        {
            _lcls1681 = _cls1681._mth02CD(s2);
        }
        int j = _cls1EF2._mth02CB(1, _lcls1681_1) + 0;
        int i = j;
        if (s1 != null)
        {
            i = j + _cls1EF2._mth02CB(2, s);
        }
        j = i;
        if (s2 != null)
        {
            j = i + _cls1EF2._mth02CB(3, _lcls1681);
        }
        _pcls1ef2.FBE8(50);
        _pcls1ef2.FBE8(j);
        _pcls1ef2._mth02CA(1, _lcls1681_1);
        if (s1 != null)
        {
            _pcls1ef2._mth02CA(2, s);
        }
        if (s2 != null)
        {
            _pcls1ef2._mth02CA(3, _lcls1681);
        }
    }

    public final void _mth02CA(_cls1EF2 _pcls1ef2, String s, String s1, String s2, String s3, int i)
    {
        s = _cls1681._mth02CD(s);
        s1 = _cls1681._mth02CD(s1);
        s2 = _cls1681._mth02CD(s2);
        s3 = _cls1681._mth02CD(s3);
        _pcls1ef2.FBE8(58);
        _pcls1ef2.FBE8(_mth02CA(((_cls1681) (s)), ((_cls1681) (s1)), ((_cls1681) (s2)), ((_cls1681) (s3)), i));
        _pcls1ef2._mth02CA(1, s);
        _pcls1ef2._mth02CA(2, s1);
        _pcls1ef2._mth02CA(3, s2);
        _pcls1ef2.FBE8(42);
        _pcls1ef2.FBE8(_cls1EF2._mth02CB(1, _cls1681._mth02CD((new rx())._mth06E5(context))) + 0);
        _pcls1ef2._mth02CA(1, (new rx())._mth06E5(context));
        _pcls1ef2._mth02CA(6, s3);
        _pcls1ef2._mth06E5(10, i);
    }

    void _mth02CA(_cls1EF2 _pcls1ef2, Thread thread, Throwable throwable)
    {
        _pcls1ef2.FBE8(10);
        _pcls1ef2.FBE8(_mth02CA(thread, throwable));
        _mth02CA(_pcls1ef2, thread, vV, 4, true);
        int j = vT.length;
        for (int i = 0; i < j; i++)
        {
            _mth02CA(_pcls1ef2, vT[i], (StackTraceElement[])vU.get(i), 0, false);
        }

        _mth02CA(_pcls1ef2, throwable, 1, 2);
        _pcls1ef2.FBE8(26);
        _pcls1ef2.FBE8(_cls1EF2._mth02CB(1, vR) + 0 + _cls1EF2._mth02CB(2, vR) + _cls1EF2._mth02CE(3, 0L));
        _pcls1ef2._mth02CA(1, vR);
        _pcls1ef2._mth02CA(2, vR);
        _pcls1ef2._mth02CB(3, 0L);
        _pcls1ef2.FBE8(34);
        _pcls1ef2.FBE8(_mth012C());
        _pcls1ef2._mth02CB(1, 0L);
        _pcls1ef2._mth02CB(2, 0L);
        _pcls1ef2._mth02CA(3, vW);
        if (vX != null)
        {
            _pcls1ef2._mth02CA(4, vX);
        }
    }

    void _mth02CA(_cls1EF2 _pcls1ef2, Map map)
    {
        for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); _pcls1ef2._mth02CA(2, _cls1681._mth02CD(map)))
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            _pcls1ef2.FBE8(18);
            String s = (String)entry.getKey();
            map = (String)entry.getValue();
            int i = _cls1EF2._mth02CB(1, _cls1681._mth02CD(s));
            if (map == null)
            {
                map = "";
            }
            _pcls1ef2.FBE8(i + _cls1EF2._mth02CB(2, _cls1681._mth02CD(map)));
            _pcls1ef2._mth02CA(1, _cls1681._mth02CD((String)entry.getKey()));
            map = (String)entry.getValue();
            if (map == null)
            {
                map = "";
            }
        }

    }

    public final void _mth02CA(_cls1EF2 _pcls1ef2, boolean flag)
    {
        _cls1681 _lcls1681 = _cls1681._mth02CD(android.os.Build.VERSION.RELEASE);
        _cls1681 _lcls1681_1 = _cls1681._mth02CD(android.os.Build.VERSION.CODENAME);
        _pcls1ef2.FBE8(66);
        _pcls1ef2.FBE8(_mth02CA(_lcls1681, _lcls1681_1, flag));
        _pcls1ef2._mth06E5(1, 3);
        _pcls1ef2._mth02CA(2, _lcls1681);
        _pcls1ef2._mth02CA(3, _lcls1681_1);
        _pcls1ef2._mth037A(4, flag);
    }

}
