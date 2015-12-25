// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.view.View;

// Referenced classes of package o:
//            _cls0993

public final class be
    implements android.view.View.OnClickListener
{

    private Context zC;
    private int zD;

    public be(Context context, int i)
    {
        zC = context;
        zD = i;
        super();
    }

    public final void onClick(View view)
    {
        zC.startActivity(_cls0993._mth02B8(zD));
    }
}
