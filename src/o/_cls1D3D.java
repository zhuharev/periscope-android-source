// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.net.Uri;
import java.io.File;

// Referenced classes of package o:
//            _cls2110, FF83

public class _cls1D3D
    implements _cls2110
{

    private final _cls2110 ov;

    public _cls1D3D(_cls2110 _pcls2110)
    {
        ov = _pcls2110;
    }

    public final FF83 _mth02CE(Object obj, int i, int j)
    {
        obj = (File)obj;
        return ov._mth02CE(Uri.fromFile(((File) (obj))), i, j);
    }
}
