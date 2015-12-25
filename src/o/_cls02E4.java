// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

class _cls02E4
{

    private static Method _fld0719;
    private static Method _fld0E07;

    _cls02E4()
    {
    }

    public static String _mth02CA(Locale locale)
    {
        locale = _mth02CB(locale);
        if (locale != null)
        {
            return _mth037A(locale);
        } else
        {
            return null;
        }
    }

    private static String _mth02CB(Locale locale)
    {
label0:
        {
            locale = locale.toString();
            String s;
            try
            {
                if (_fld0719 == null)
                {
                    break label0;
                }
                s = (String)_fld0719.invoke(null, new Object[] {
                    locale
                });
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                Log.w("ICUCompatIcs", illegalaccessexception);
                return locale;
            }
            catch (InvocationTargetException invocationtargetexception)
            {
                Log.w("ICUCompatIcs", invocationtargetexception);
                return locale;
            }
            return s;
        }
        return locale;
    }

    private static String _mth037A(String s)
    {
        if (_fld0E07 == null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        s = (String)_fld0E07.invoke(null, new Object[] {
            s
        });
        return s;
        s;
        Log.w("ICUCompatIcs", s);
        break MISSING_BLOCK_LABEL_49;
        s;
        Log.w("ICUCompatIcs", s);
        return null;
    }

    static 
    {
        Class class1;
        try
        {
            class1 = Class.forName("libcore.icu.ICU");
        }
        catch (Exception exception)
        {
            _fld0E07 = null;
            _fld0719 = null;
            Log.w("ICUCompatIcs", exception);
        }
        if (class1 == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        _fld0E07 = class1.getMethod("getScript", new Class[] {
            java/lang/String
        });
        _fld0719 = class1.getMethod("addLikelySubtags", new Class[] {
            java/lang/String
        });
    }
}
