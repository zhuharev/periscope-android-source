// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.res.ColorStateList;
import android.view.View;
import java.lang.reflect.Field;

// Referenced classes of package o:
//            FBE6

class FE97
{

    private static Field _fld2054;
    private static boolean _fld4E28;
    private static Field _fld6C35;
    private static boolean _fld706C;

    FE97()
    {
    }

    static void _mth02CA(View view, ColorStateList colorstatelist)
    {
        if (view instanceof FBE6)
        {
            ((FBE6)view).setSupportBackgroundTintList(colorstatelist);
        }
    }

    static void _mth02CA(View view, android.graphics.PorterDuff.Mode mode)
    {
        if (view instanceof FBE6)
        {
            ((FBE6)view).setSupportBackgroundTintMode(mode);
        }
    }

    static int _mth0640(View view)
    {
        if (!_fld4E28)
        {
            int i;
            try
            {
                Field field = android/view/View.getDeclaredField("mMinWidth");
                _fld2054 = field;
                field.setAccessible(true);
            }
            catch (NoSuchFieldException nosuchfieldexception) { }
            _fld4E28 = true;
        }
        if (_fld2054 == null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        i = ((Integer)_fld2054.get(view)).intValue();
        return i;
_L2:
        return 0;
        view;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static int _mth1427(View view)
    {
        if (!_fld706C)
        {
            int i;
            try
            {
                Field field = android/view/View.getDeclaredField("mMinHeight");
                _fld6C35 = field;
                field.setAccessible(true);
            }
            catch (NoSuchFieldException nosuchfieldexception) { }
            _fld706C = true;
        }
        if (_fld6C35 == null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        i = ((Integer)_fld6C35.get(view)).intValue();
        return i;
_L2:
        return 0;
        view;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static boolean _mth1D4E(View view)
    {
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    static boolean _mth1D54(View view)
    {
        return view.getWindowToken() != null;
    }
}
