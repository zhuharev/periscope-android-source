// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package o:
//            FE70

public final class _cls14AB
{

    private static Method jd;

    public static int combineMeasuredStates(int i, int j)
    {
        return i | j;
    }

    public static void _mth02CA(ViewGroup viewgroup, Rect rect, Rect rect1)
    {
        if (jd != null)
        {
            try
            {
                jd.invoke(viewgroup, new Object[] {
                    rect, rect1
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ViewGroup viewgroup)
            {
                Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", viewgroup);
            }
        }
    }

    public static boolean _mth02CF(ViewGroup viewgroup)
    {
        return FE70._mth02C9(viewgroup) == 1;
    }

    public static void _mth141D(ViewGroup viewgroup)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            try
            {
                Method method = viewgroup.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
                if (!method.isAccessible())
                {
                    method.setAccessible(true);
                }
                method.invoke(viewgroup, new Object[0]);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ViewGroup viewgroup)
            {
                Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ViewGroup viewgroup)
            {
                Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", viewgroup);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ViewGroup viewgroup)
            {
                Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", viewgroup);
            }
        }
    }

    static 
    {
        NoSuchMethodException nosuchmethodexception;
        if (android.os.Build.VERSION.SDK_INT >= 18)
        {
            try
            {
                Method method = android/view/View.getDeclaredMethod("computeFitSystemWindows", new Class[] {
                    android/graphics/Rect, android/graphics/Rect
                });
                jd = method;
                if (!method.isAccessible())
                {
                    jd.setAccessible(true);
                }
                return;
            }
            // Misplaced declaration of an exception variable
            catch (NoSuchMethodException nosuchmethodexception)
            {
                Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
            }
        }
    }
}
