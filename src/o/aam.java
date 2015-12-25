// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;

// Referenced classes of package o:
//            _cls0443, FB85, agp, _cls06BA

public final class aam extends _cls0443
{

    private WeakReference hR;

    public aam(agp agp)
    {
        super(agp);
        hR = new WeakReference(agp);
    }

    public final String getId()
    {
        return "Blur";
    }

    protected final Bitmap _mth02CA(_cls06BA _pcls06ba, Bitmap bitmap, int i, int j)
    {
        _pcls06ba = (Context)hR.get();
        if (_pcls06ba == null)
        {
            return null;
        } else
        {
            Object obj = new ByteArrayOutputStream();
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, ((java.io.OutputStream) (obj)));
            bitmap = ((ByteArrayOutputStream) (obj)).toByteArray();
            obj = BitmapFactory.decodeByteArray(bitmap, 0, bitmap.length);
            bitmap = FB85._mth02CA(_pcls06ba, ((Bitmap) (obj)), 25);
            ((Bitmap) (obj)).recycle();
            _pcls06ba = FB85._mth02CA(_pcls06ba, bitmap, 10);
            bitmap.recycle();
            return _pcls06ba;
        }
    }
}
