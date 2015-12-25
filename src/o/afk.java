// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Intent;
import android.os.Bundle;

// Referenced classes of package o:
//            ada, auf, ahj, afl, 
//            afm, aia

public class afk extends ada
{

    private aia biz;

    public afk()
    {
    }

    static aia _mth02CA(afk afk1, aia aia1)
    {
        afk1.biz = null;
        return null;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = (auf)getIntent().getExtras().getSerializable("e_message");
        if (bundle != null)
        {
            biz = new ahj(this, bundle, new afl(this), new afm(this));
            biz.show();
        }
    }
}
