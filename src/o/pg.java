// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

// Referenced classes of package o:
//            ph, ada

public final class pg
{

    public Intent NL;

    public pg(Uri uri, Uri uri1)
    {
        NL = new Intent();
        NL.setData(uri);
        NL.putExtra("output", uri1);
    }

    public final void _mth141D(ada ada)
    {
        NL.setClass(ada, o/ph);
        ada.startActivityForResult(NL, 6709);
    }
}
