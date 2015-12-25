// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;

// Referenced classes of package o:
//            FEE9, _cls0E22, _cls043E, _cls06BA, 
//            FC60, _cls05D4

public final class _cls05E2
    implements FEE9
{

    private final _cls06BA je;
    private FC60 jg;
    private final _cls0E22 pd;

    public _cls05E2(_cls06BA _pcls06ba, FC60 fc60)
    {
        this(new _cls0E22(), _pcls06ba, fc60);
    }

    private _cls05E2(_cls0E22 _pcls0e22, _cls06BA _pcls06ba, FC60 fc60)
    {
        pd = _pcls0e22;
        je = _pcls06ba;
        jg = fc60;
    }

    public final String getId()
    {
        return "FileDescriptorBitmapDecoder.com.bumptech.glide.load.data.bitmap";
    }

    public final _cls05D4 _mth02CB(Object obj, int i, int j)
    {
        Object obj1 = (ParcelFileDescriptor)obj;
        obj = pd;
        MediaMetadataRetriever mediametadataretriever = new MediaMetadataRetriever();
        mediametadataretriever.setDataSource(((ParcelFileDescriptor) (obj1)).getFileDescriptor());
        if (((_cls0E22) (obj)).py >= 0)
        {
            obj = mediametadataretriever.getFrameAtTime(((_cls0E22) (obj)).py);
        } else
        {
            obj = mediametadataretriever.getFrameAtTime();
        }
        mediametadataretriever.release();
        ((ParcelFileDescriptor) (obj1)).close();
        obj1 = je;
        if (obj == null)
        {
            return null;
        } else
        {
            return new _cls043E(((android.graphics.Bitmap) (obj)), ((_cls06BA) (obj1)));
        }
    }
}
