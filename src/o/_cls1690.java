// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.res.Resources;
import android.graphics.Bitmap;

// Referenced classes of package o:
//            _cls1D08, _cls066E, _cls0646, _cls05D4, 
//            _cls06BA

public final class _cls1690
    implements _cls1D08
{

    private final _cls06BA je;
    private final Resources resources;

    public _cls1690(Resources resources1, _cls06BA _pcls06ba)
    {
        resources = resources1;
        je = _pcls06ba;
    }

    public final String getId()
    {
        return "GlideBitmapDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }

    public final _cls05D4 _mth02BC(_cls05D4 _pcls05d4)
    {
        return new _cls066E(new _cls0646(resources, (Bitmap)_pcls05d4.get()), je);
    }
}
