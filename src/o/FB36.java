// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

class FB36
{

    private static Field _fld0403;

    FB36()
    {
    }

    static void _mth02CA(PopupWindow popupwindow, boolean flag)
    {
        if (_fld0403 != null)
        {
            try
            {
                _fld0403.set(popupwindow, Boolean.valueOf(flag));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (PopupWindow popupwindow)
            {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", popupwindow);
            }
        }
    }

    static 
    {
        try
        {
            Field field = android/widget/PopupWindow.getDeclaredField("mOverlapAnchor");
            _fld0403 = field;
            field.setAccessible(true);
        }
        catch (NoSuchFieldException nosuchfieldexception)
        {
            Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", nosuchfieldexception);
        }
    }
}
