// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.widget.PopupWindow;
import java.lang.reflect.Method;

class FB48
{

    private static Method _fld0481;
    private static boolean _fld0490;

    FB48()
    {
    }

    static void _mth02CA(PopupWindow popupwindow, int i)
    {
        if (!_fld0490)
        {
            try
            {
                Method method = android/widget/PopupWindow.getDeclaredMethod("setWindowLayoutType", new Class[] {
                    Integer.TYPE
                });
                _fld0481 = method;
                method.setAccessible(true);
            }
            catch (Exception exception) { }
            _fld0490 = true;
        }
        if (_fld0481 != null)
        {
            try
            {
                _fld0481.invoke(popupwindow, new Object[] {
                    Integer.valueOf(i)
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (PopupWindow popupwindow)
            {
                return;
            }
        } else
        {
            return;
        }
    }
}
