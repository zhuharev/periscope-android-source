// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ki
{

    private static final Map Hz;

    public static boolean _mth02BB(Class class1)
    {
        return Hz.containsKey(class1);
    }

    public static Class _mth02BC(Class class1)
    {
        Class class2 = (Class)Hz.get(_cls1D10.aux.checkNotNull(class1));
        if (class2 == null)
        {
            return class1;
        } else
        {
            return class2;
        }
    }

    static 
    {
        HashMap hashmap = new HashMap(16);
        HashMap hashmap1 = new HashMap(16);
        Class class1 = Boolean.TYPE;
        hashmap.put(class1, java/lang/Boolean);
        hashmap1.put(java/lang/Boolean, class1);
        class1 = Byte.TYPE;
        hashmap.put(class1, java/lang/Byte);
        hashmap1.put(java/lang/Byte, class1);
        class1 = Character.TYPE;
        hashmap.put(class1, java/lang/Character);
        hashmap1.put(java/lang/Character, class1);
        class1 = Double.TYPE;
        hashmap.put(class1, java/lang/Double);
        hashmap1.put(java/lang/Double, class1);
        class1 = Float.TYPE;
        hashmap.put(class1, java/lang/Float);
        hashmap1.put(java/lang/Float, class1);
        class1 = Integer.TYPE;
        hashmap.put(class1, java/lang/Integer);
        hashmap1.put(java/lang/Integer, class1);
        class1 = Long.TYPE;
        hashmap.put(class1, java/lang/Long);
        hashmap1.put(java/lang/Long, class1);
        class1 = Short.TYPE;
        hashmap.put(class1, java/lang/Short);
        hashmap1.put(java/lang/Short, class1);
        class1 = Void.TYPE;
        hashmap.put(class1, java/lang/Void);
        hashmap1.put(java/lang/Void, class1);
        Hz = Collections.unmodifiableMap(hashmap);
        Collections.unmodifiableMap(hashmap1);
    }
}
