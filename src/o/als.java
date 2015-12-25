// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Collection;
import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            anf, alq, aop, yu

final class als extends anf
{

    private alq bsk;

    als(alq alq1, yu yu)
    {
        bsk = alq1;
        super(yu);
    }

    protected final boolean _mth02CB(PsUser psuser)
    {
        return bsk.bsj.dl().contains(psuser.id);
    }
}
