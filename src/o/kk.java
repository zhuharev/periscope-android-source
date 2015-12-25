// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// Referenced classes of package o:
//            kl, km, kn, ko

public abstract class kk
{

    public kk()
    {
    }

    public static kk _mth0E43()
    {
        Exception exception;
        Object obj;
        int i;
        try
        {
            obj = Class.forName("sun.misc.Unsafe");
            Object obj1 = ((Class) (obj)).getDeclaredField("theUnsafe");
            ((Field) (obj1)).setAccessible(true);
            obj1 = ((Field) (obj1)).get(null);
            obj = new kl(((Class) (obj)).getMethod("allocateInstance", new Class[] {
                java/lang/Class
            }), obj1);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            try
            {
                obj = java/io/ObjectStreamClass.getDeclaredMethod("getConstructorId", new Class[] {
                    java/lang/Class
                });
                ((Method) (obj)).setAccessible(true);
                i = ((Integer)((Method) (obj)).invoke(null, new Object[] {
                    java/lang/Object
                })).intValue();
                obj = java/io/ObjectStreamClass.getDeclaredMethod("newInstance", new Class[] {
                    java/lang/Class, Integer.TYPE
                });
                ((Method) (obj)).setAccessible(true);
                obj = new km(((Method) (obj)), i);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception)
            {
                try
                {
                    obj = java/io/ObjectInputStream.getDeclaredMethod("newInstance", new Class[] {
                        java/lang/Class, java/lang/Class
                    });
                    ((Method) (obj)).setAccessible(true);
                    obj = new kn(((Method) (obj)));
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception)
                {
                    return new ko();
                }
                return ((kk) (obj));
            }
            return ((kk) (obj));
        }
        return ((kk) (obj));
    }

    public abstract Object _mth02BD(Class class1);
}
