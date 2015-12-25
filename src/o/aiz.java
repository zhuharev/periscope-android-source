// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Bitmap;
import java.util.Map;

// Referenced classes of package o:
//            _cls03BD, aiy, _cls0192

final class aiz extends _cls03BD
{

    private String boD;
    private aiy boE;

    aiz(aiy aiy1, String s)
    {
        boE = aiy1;
        boD = s;
        super();
    }

    public final void _mth02CA(Object obj, _cls0192 _pcls0192)
    {
        obj = (Bitmap)obj;
        boE.box.put(boD, obj);
    }
}
