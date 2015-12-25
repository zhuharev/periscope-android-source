// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

// Referenced classes of package o:
//            _cls0140

class _cls1D41
{

    private static Field _fld027D;
    private static boolean _fld0283;

    _cls1D41()
    {
    }

    static Drawable _mth02CA(CompoundButton compoundbutton)
    {
        if (!_fld0283)
        {
            try
            {
                Field field = android/widget/CompoundButton.getDeclaredField("mButtonDrawable");
                _fld027D = field;
                field.setAccessible(true);
            }
            catch (NoSuchFieldException nosuchfieldexception)
            {
                Log.i("CompoundButtonCompatDonut", "Failed to retrieve mButtonDrawable field", nosuchfieldexception);
            }
            _fld0283 = true;
        }
        if (_fld027D == null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        compoundbutton = (Drawable)_fld027D.get(compoundbutton);
        return compoundbutton;
        compoundbutton;
        Log.i("CompoundButtonCompatDonut", "Failed to get button drawable via reflection", compoundbutton);
        _fld027D = null;
        return null;
    }

    static void _mth02CA(CompoundButton compoundbutton, ColorStateList colorstatelist)
    {
        if (compoundbutton instanceof _cls0140)
        {
            ((_cls0140)compoundbutton).setSupportButtonTintList(colorstatelist);
        }
    }

    static void _mth02CA(CompoundButton compoundbutton, android.graphics.PorterDuff.Mode mode)
    {
        if (compoundbutton instanceof _cls0140)
        {
            ((_cls0140)compoundbutton).setSupportButtonTintMode(mode);
        }
    }
}
