// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.InflateException;
import android.view.MenuItem;
import java.lang.reflect.Method;

// Referenced classes of package o:
//            FE7D

static final class Throwable
    implements android.view..OnMenuItemClickListener
{

    private static final Class _fld01AB[] = {
        android/view/MenuItem
    };
    private Object _fld01A8;
    private Method _fld01B3;

    public final boolean onMenuItemClick(MenuItem menuitem)
    {
        boolean flag;
        if (_fld01B3.getReturnType() != Boolean.TYPE)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        flag = ((Boolean)_fld01B3.invoke(_fld01A8, new Object[] {
            menuitem
        })).booleanValue();
        return flag;
        try
        {
            _fld01B3.invoke(_fld01A8, new Object[] {
                menuitem
            });
        }
        // Misplaced declaration of an exception variable
        catch (MenuItem menuitem)
        {
            throw new RuntimeException(menuitem);
        }
        return true;
    }


    public Throwable(Object obj, String s)
    {
        _fld01A8 = obj;
        Class class1 = obj.getClass();
        try
        {
            _fld01B3 = class1.getMethod(s, _fld01AB);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            s = new InflateException((new StringBuilder("Couldn't resolve menu item onClick handler ")).append(s).append(" in class ").append(class1.getName()).toString());
        }
        s.initCause(((Throwable) (obj)));
        throw s;
    }
}
