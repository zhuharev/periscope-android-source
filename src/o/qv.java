// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package o:
//            qx, qo, qu, ql

final class qv
{

    private static final HashMap Qn = new HashMap();
    private final ConcurrentHashMap Qo = new ConcurrentHashMap();

    qv(List list)
    {
        if (list != null)
        {
            Class class1;
            for (list = list.iterator(); list.hasNext(); Qo.put(class1, class1))
            {
                class1 = (Class)list.next();
            }

        }
    }

    final List _mth1FBE(Class class1)
    {
        String s1 = class1.getName();
        HashMap hashmap = Qn;
        hashmap;
        JVM INSTR monitorenter ;
        Object obj1 = (List)Qn.get(s1);
        hashmap;
        JVM INSTR monitorexit ;
          goto _L1
        class1;
        throw class1;
_L1:
        ArrayList arraylist;
        if (obj1 != null)
        {
            return ((List) (obj1));
        }
        arraylist = new ArrayList();
        obj1 = class1;
        HashSet hashset = new HashSet();
        StringBuilder stringbuilder = new StringBuilder();
        do
        {
            if (obj1 == null)
            {
                break;
            }
            String s = ((Class) (obj1)).getName();
            if (s.startsWith("java.") || s.startsWith("javax.") || s.startsWith("android."))
            {
                break;
            }
            Method amethod[] = ((Class) (obj1)).getDeclaredMethods();
            int j = amethod.length;
            for (int i = 0; i < j; i++)
            {
                Method method = amethod[i];
                String s2 = method.getName();
                if (!s2.startsWith("onEvent"))
                {
                    continue;
                }
                int k = method.getModifiers();
                if ((k & 1) != 0 && (k & 0x1448) == 0)
                {
                    Class aclass[] = method.getParameterTypes();
                    if (aclass.length != 1)
                    {
                        continue;
                    }
                    Object obj = s2.substring(7);
                    if (((String) (obj)).length() == 0)
                    {
                        obj = qx.Qs;
                    } else
                    if (((String) (obj)).equals("MainThread"))
                    {
                        obj = qx.Qt;
                    } else
                    if (((String) (obj)).equals("BackgroundThread"))
                    {
                        obj = qx.Qu;
                    } else
                    if (((String) (obj)).equals("Async"))
                    {
                        obj = qx.Qv;
                    } else
                    {
                        if (!Qo.containsKey(obj1))
                        {
                            throw new qo((new StringBuilder("Illegal onEvent method, check for typos: ")).append(method).toString());
                        }
                        continue;
                    }
                    Class class2 = aclass[0];
                    stringbuilder.setLength(0);
                    stringbuilder.append(s2);
                    stringbuilder.append('>').append(class2.getName());
                    if (hashset.add(stringbuilder.toString()))
                    {
                        arraylist.add(new qu(method, ((qx) (obj)), class2));
                    }
                    continue;
                }
                if (!Qo.containsKey(obj1))
                {
                    Log.d(ql.TAG, (new StringBuilder("Skipping method (not public, static or abstract): ")).append(obj1).append(".").append(s2).toString());
                }
            }

            obj1 = ((Class) (obj1)).getSuperclass();
        } while (true);
        if (arraylist.isEmpty())
        {
            throw new qo((new StringBuilder("Subscriber ")).append(class1).append(" has no public methods called onEvent").toString());
        }
        class1 = Qn;
        class1;
        JVM INSTR monitorenter ;
        Qn.put(s1, arraylist);
        class1;
        JVM INSTR monitorexit ;
        return arraylist;
        Exception exception;
        exception;
        throw exception;
    }

}
