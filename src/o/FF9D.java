// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.Closeable;

// Referenced classes of package o:
//            _cls0138

public final class FF9D extends _cls0138
{

    public FF9D(Context context, Uri uri)
    {
        super(context, uri);
    }

    protected final void _mth02B3(Object obj)
    {
        ((ParcelFileDescriptor)obj).close();
    }

    protected final Closeable _mth02CA(Uri uri, ContentResolver contentresolver)
    {
        return contentresolver.openAssetFileDescriptor(uri, "r").getParcelFileDescriptor();
    }
}
