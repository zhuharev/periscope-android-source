// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.util.Log;
import android.view.LayoutInflater;
import java.lang.reflect.Field;

// Referenced classes of package o:
//            _cls1449

class _cls04C0
{
    /* member class not found */
    class if {}


    private static Field _fld1D3F;
    private static boolean _fld1D47;

    _cls04C0()
    {
    }

    static void _mth02CA(LayoutInflater layoutinflater, android.view.LayoutInflater.Factory2 factory2)
    {
        if (!_fld1D47)
        {
            try
            {
                Field field = android/view/LayoutInflater.getDeclaredField("mFactory2");
                _fld1D3F = field;
                field.setAccessible(true);
            }
            catch (NoSuchFieldException nosuchfieldexception)
            {
                Log.e("LayoutInflaterCompatHC", (new StringBuilder("forceSetFactory2 Could not find field 'mFactory2' on class ")).append(android/view/LayoutInflater.getName()).append("; inflation may have unexpected results.").toString(), nosuchfieldexception);
            }
            _fld1D47 = true;
        }
        if (_fld1D3F != null)
        {
            try
            {
                _fld1D3F.set(layoutinflater, factory2);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (android.view.LayoutInflater.Factory2 factory2)
            {
                Log.e("LayoutInflaterCompatHC", (new StringBuilder("forceSetFactory2 could not set the Factory2 on LayoutInflater ")).append(layoutinflater).append("; inflation may have unexpected results.").toString(), factory2);
            }
        }
    }

    static void _mth02CA(LayoutInflater layoutinflater, _cls1449 _pcls1449)
    {
        if (_pcls1449 != null)
        {
            _pcls1449 = new if(_pcls1449);
        } else
        {
            _pcls1449 = null;
        }
        layoutinflater.setFactory2(_pcls1449);
        android.view.LayoutInflater.Factory factory = layoutinflater.getFactory();
        if (factory instanceof android.view.LayoutInflater.Factory2)
        {
            _mth02CA(layoutinflater, (android.view.LayoutInflater.Factory2)factory);
            return;
        } else
        {
            _mth02CA(layoutinflater, ((android.view.LayoutInflater.Factory2) (_pcls1449)));
            return;
        }
    }
}
