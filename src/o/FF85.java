// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import java.io.Closeable;

// Referenced classes of package o:
//            FF69

public final class FF85 extends FF69
{

    public FF85(AssetManager assetmanager, String s)
    {
        super(assetmanager, s);
    }

    protected final void _mth02B3(Object obj)
    {
        ((ParcelFileDescriptor)obj).close();
    }

    protected final Closeable _mth02CA(AssetManager assetmanager, String s)
    {
        return assetmanager.openFd(s).getParcelFileDescriptor();
    }
}
