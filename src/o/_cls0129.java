// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import java.lang.reflect.Method;

// Referenced classes of package o:
//            _cls010B

final class _cls0129
    implements Runnable
{

    private _cls010B hb;

    _cls0129(_cls010B _pcls010b)
    {
        hb = _pcls010b;
        super();
    }

    public final void run()
    {
        InputMethodManager inputmethodmanager = (InputMethodManager)hb.getContext().getSystemService("input_method");
        if (inputmethodmanager != null)
        {
            _cls010B.if if1 = _cls010B.gQ;
            _cls010B _lcls010b = hb;
            if (if1.hf != null)
            {
                try
                {
                    if1.hf.invoke(inputmethodmanager, new Object[] {
                        Integer.valueOf(0), null
                    });
                    return;
                }
                catch (Exception exception) { }
            }
            inputmethodmanager.showSoftInput(_lcls010b, 0);
        }
    }
}
