// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Bitmap;

// Referenced classes of package o:
//            _cls0E43, _cls09A7, _cls0645

final class _cls0673
    implements _cls0E43
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}


    private final _cls02CA nq = new _cls02CA();
    private final _cls09A7 nr = new _cls09A7();

    _cls0673()
    {
    }

    static String _mth02CF(int i, int j, android.graphics.Bitmap.Config config)
    {
        return (new StringBuilder("[")).append(i).append("x").append(j).append("], ").append(config).toString();
    }

    public final String toString()
    {
        return (new StringBuilder("AttributeStrategy:\n  ")).append(nr).toString();
    }

    public final String _mth02BB(Bitmap bitmap)
    {
        return _mth02CF(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    public final int _mth02BC(Bitmap bitmap)
    {
        return _cls0645._mth037A(bitmap);
    }

    public final Bitmap _mth02CB(int i, int j, android.graphics.Bitmap.Config config)
    {
        config = nq._mth141D(i, j, config);
        return (Bitmap)nr._mth02CA(config);
    }

    public final String _mth02CE(int i, int j, android.graphics.Bitmap.Config config)
    {
        return _mth02CF(i, j, config);
    }

    public final void _mth141D(Bitmap bitmap)
    {
        if if1 = nq._mth141D(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        nr._mth02CA(if1, bitmap);
    }

    public final Bitmap _mth1D47()
    {
        return (Bitmap)nr.removeLast();
    }
}
