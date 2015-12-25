// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.InputStream;

// Referenced classes of package o:
//            FEE9, _cls0454, FC60, _cls043E, 
//            _cls06BA, _cls05D4

public final class _cls0E1A
    implements FEE9
{

    private String id;
    private _cls06BA je;
    private final _cls0454 jf;
    private FC60 jg;

    private _cls0E1A(_cls0454 _pcls0454, _cls06BA _pcls06ba, FC60 fc60)
    {
        jf = _pcls0454;
        je = _pcls06ba;
        jg = fc60;
    }

    public _cls0E1A(_cls06BA _pcls06ba, FC60 fc60)
    {
        this(((_cls0454) (_cls0454.oZ)), _pcls06ba, fc60);
    }

    public final String getId()
    {
        if (id == null)
        {
            id = (new StringBuilder("StreamBitmapDecoder.com.bumptech.glide.load.resource.bitmap")).append(jf.getId()).append(jg.name()).toString();
        }
        return id;
    }

    public final _cls05D4 _mth02CB(Object obj, int i, int j)
    {
        obj = (InputStream)obj;
        obj = jf._mth02CA(((InputStream) (obj)), je, i, j, jg);
        _cls06BA _lcls06ba = je;
        if (obj == null)
        {
            return null;
        } else
        {
            return new _cls043E(((android.graphics.Bitmap) (obj)), _lcls06ba);
        }
    }
}
