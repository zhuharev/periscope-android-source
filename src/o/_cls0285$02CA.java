// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

// Referenced classes of package o:
//            _cls0285, _cls1E37

static final class ject extends Handler
{

    private WeakReference _fld1F3D;

    public final void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case -3: 
        case -2: 
        case -1: 
            ((android.content.rface.OnClickListener)message.obj).onClick((DialogInterface)_fld1F3D.get(), message.what);
            return;

        case 1: // '\001'
            ((DialogInterface)message.obj).dismiss();
            // fall through

        case 0: // '\0'
            return;
        }
    }

    public ject(_cls1E37 _pcls1e37)
    {
        _fld1F3D = new WeakReference(_pcls1e37);
    }
}
