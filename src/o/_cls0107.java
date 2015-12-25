// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.net.Uri;

// Referenced classes of package o:
//            FB87, _cls01F0, _cls0159, _cls2110, 
//            _cls0138, FF69

public final class _cls0107 extends FB87
    implements _cls141F.if
{
    /* member class not found */
    class if {}


    public _cls0107(Context context, _cls2110 _pcls2110)
    {
        super(context, _pcls2110);
    }

    protected final _cls0138 _mth02CA(Context context, Uri uri)
    {
        return new _cls01F0(context, uri);
    }

    protected final FF69 _mth02CF(Context context, String s)
    {
        return new _cls0159(context.getApplicationContext().getAssets(), s);
    }
}
