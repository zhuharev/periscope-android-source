// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Collection;
import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            anx, ann, aop

final class anp extends anx
{

    private ann bur;

    anp(ann ann1)
    {
        bur = ann1;
        super();
    }

    protected final boolean _mth02CB(PsUser psuser)
    {
        return ann._mth02CA(bur).dl().contains(psuser.id);
    }
}
