// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.Closeable;
import java.io.InputStream;

// Referenced classes of package o:
//            _cls0138

public final class _cls01F0 extends _cls0138
{

    public _cls01F0(Context context, Uri uri)
    {
        super(context, uri);
    }

    protected final void _mth02B3(Object obj)
    {
        ((InputStream)obj).close();
    }

    protected final Closeable _mth02CA(Uri uri, ContentResolver contentresolver)
    {
        return contentresolver.openInputStream(uri);
    }
}
