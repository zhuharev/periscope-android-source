// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Bitmap;
import android.os.Handler;

// Referenced classes of package o:
//            _cls03BD, _cls14D7, _cls0192

public static final class qa extends _cls03BD
{

    private final Handler handler;
    final int index;
    private final long qa;
    Bitmap qb;

    public final void _mth02CA(Object obj, _cls0192 _pcls0192)
    {
        qb = (Bitmap)obj;
        obj = handler.obtainMessage(1, this);
        handler.sendMessageAtTime(((android.os.Message) (obj)), qa);
    }

    public .Handler(Handler handler1, int i, long l)
    {
        handler = handler1;
        index = i;
        qa = l;
    }
}
