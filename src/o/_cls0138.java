// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import java.io.Closeable;
import java.io.IOException;

// Referenced classes of package o:
//            FF83

public abstract class _cls0138
    implements FF83
{

    private final Context context;
    private Object data;
    private final Uri uri;

    public _cls0138(Context context1, Uri uri1)
    {
        context = context1.getApplicationContext();
        uri = uri1;
    }

    public final void cancel()
    {
    }

    public final String getId()
    {
        return uri.toString();
    }

    protected abstract void _mth02B3(Object obj);

    protected abstract Closeable _mth02CA(Uri uri1, ContentResolver contentresolver);

    public final Object _mth1424(int i)
    {
        ContentResolver contentresolver = context.getContentResolver();
        data = _mth02CA(uri, contentresolver);
        return data;
    }

    public final void _mth14F4()
    {
        if (data != null)
        {
            try
            {
                _mth02B3(data);
                return;
            }
            catch (IOException ioexception)
            {
                if (Log.isLoggable("LocalUriFetcher", 2))
                {
                    Log.v("LocalUriFetcher", "failed to close data", ioexception);
                }
            }
        }
    }
}
