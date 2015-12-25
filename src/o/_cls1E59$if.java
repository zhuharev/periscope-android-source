// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package o:
//            _cls1E59

static class _cls09AC
    implements android.view.lickListener
{

    private final View _fld09A2;
    private final String _fld09AC;
    private Method _fld09B6;
    private Context _fld09BD;

    private void _mth02CE(Context context, String s)
    {
_L2:
        if (context == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (context.isRestricted())
        {
            break MISSING_BLOCK_LABEL_47;
        }
        s = context.getClass().getMethod(_fld09AC, new Class[] {
            android/view/View
        });
        if (s != null)
        {
            try
            {
                _fld09B6 = s;
                _fld09BD = context;
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        if (context instanceof ContextWrapper)
        {
            context = ((ContextWrapper)context).getBaseContext();
        } else
        {
            context = null;
        }
        if (true) goto _L2; else goto _L1
_L1:
        int i = _fld09A2.getId();
        if (i == -1)
        {
            context = "";
        } else
        {
            context = (new StringBuilder(" with id '")).append(_fld09A2.getContext().getResources().getResourceEntryName(i)).append("'").toString();
        }
        throw new IllegalStateException((new StringBuilder("Could not find method ")).append(_fld09AC).append("(View) in a parent or ancestor Context for android:onClick attribute defined on view ").append(_fld09A2.getClass()).append(context).toString());
    }

    public void onClick(View view)
    {
        if (_fld09B6 == null)
        {
            _mth02CE(_fld09A2.getContext(), _fld09AC);
        }
        try
        {
            _fld09B6.invoke(_fld09BD, new Object[] {
                view
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", view);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            throw new IllegalStateException("Could not execute method for android:onClick", view);
        }
    }

    public String(View view, String s)
    {
        _fld09A2 = view;
        _fld09AC = s;
    }
}
