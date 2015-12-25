// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.res.AssetManager;
import android.util.Log;
import java.io.Closeable;
import java.io.IOException;

// Referenced classes of package o:
//            FF83

public abstract class FF69
    implements FF83
{

    private final AssetManager assetManager;
    private Object data;
    private final String lZ;

    public FF69(AssetManager assetmanager, String s)
    {
        assetManager = assetmanager;
        lZ = s;
    }

    public final void cancel()
    {
    }

    public final String getId()
    {
        return lZ;
    }

    protected abstract void _mth02B3(Object obj);

    protected abstract Closeable _mth02CA(AssetManager assetmanager, String s);

    public final Object _mth1424(int i)
    {
        data = _mth02CA(assetManager, lZ);
        return data;
    }

    public final void _mth14F4()
    {
        if (data == null)
        {
            return;
        }
        try
        {
            _mth02B3(data);
            return;
        }
        catch (IOException ioexception)
        {
            if (Log.isLoggable("AssetUriFetcher", 2))
            {
                Log.v("AssetUriFetcher", "Failed to close data", ioexception);
            }
        }
    }
}
