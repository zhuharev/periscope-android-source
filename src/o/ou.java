// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

class ou
{

    ou()
    {
    }

    static Hashtable _mth02BB(Hashtable hashtable)
    {
        if (hashtable == null)
        {
            return null;
        }
        Hashtable hashtable1 = new Hashtable();
        Object obj;
        for (Enumeration enumeration = hashtable.keys(); enumeration.hasMoreElements(); hashtable1.put(obj, hashtable.get(obj)))
        {
            obj = enumeration.nextElement();
        }

        return hashtable1;
    }

    public static String _mth02CA(Hashtable hashtable, String s, String s1)
    {
        o/ou;
        JVM INSTR monitorenter ;
        StringBuffer stringbuffer = new StringBuffer();
        boolean flag = true;
        hashtable = hashtable.keys();
_L3:
        String s2;
        if (!hashtable.hasMoreElements())
        {
            break MISSING_BLOCK_LABEL_85;
        }
        s2 = (String)hashtable.nextElement();
        if (s1 == null) goto _L2; else goto _L1
_L1:
        if (s2.indexOf(s1) != -1) goto _L3; else goto _L2
_L2:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        stringbuffer.append(s2);
        flag = false;
          goto _L3
        stringbuffer.append(s).append(s2);
          goto _L3
        hashtable = stringbuffer.toString();
        o/ou;
        JVM INSTR monitorexit ;
        return hashtable;
        hashtable;
        throw hashtable;
    }

    public static String _mth02CA(String as[], String s)
    {
        if (as == null)
        {
            return "";
        }
        StringBuffer stringbuffer = new StringBuffer();
        for (int i = 0; i < as.length - 1; i++)
        {
            stringbuffer.append(as[i]).append(s);
        }

        stringbuffer.append(as[as.length - 1]);
        return stringbuffer.toString();
    }

    public static String[] _mth037A(String s, String s1)
    {
        int i = 0;
        String s2 = s;
        int j;
        do
        {
            int k = s2.indexOf(s1);
            j = k;
            if (k == -1)
            {
                break;
            }
            s2 = s2.substring(s1.length() + j);
            i++;
        } while (true);
        String as[] = new String[i + 1];
        i = 0;
        int j1;
        do
        {
            int k1 = s.indexOf(s1, j + 1);
            if (k1 != -1)
            {
                int l = i + 1;
                as[i] = s.substring(s1.length() + j, k1);
                s = s.substring(k1);
                i = l;
            } else
            {
                int i1 = i + 1;
                as[i] = s.substring(s1.length() + j);
                s = s.substring(j + 1);
                i = i1;
            }
            j1 = s.indexOf(s1);
            j = j1;
        } while (j1 != -1);
        return as;
    }

    public static String[] _mth141D(Hashtable hashtable)
    {
        o/ou;
        JVM INSTR monitorenter ;
        Vector vector = new Vector();
        int i = 0;
        hashtable = hashtable.keys();
_L1:
        if (!hashtable.hasMoreElements())
        {
            break MISSING_BLOCK_LABEL_47;
        }
        vector.addElement((String)hashtable.nextElement());
        i++;
          goto _L1
        hashtable = new String[i];
        vector.copyInto(hashtable);
        o/ou;
        JVM INSTR monitorexit ;
        return hashtable;
        hashtable;
        throw hashtable;
    }
}
