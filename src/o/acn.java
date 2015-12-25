// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.concurrent.Executor;
import tv.periscope.android.api.RestClient;
import tv.periscope.android.signer.SignerService;

// Referenced classes of package o:
//            yo, yq, xd

public final class acn extends RestClient
{

    public acn(xd xd, Executor executor)
    {
        String s;
        if (_cls30CE.if.FE73(xd))
        {
            s = "https://signer.periscope.tv";
        } else
        {
            s = yo.aVs.k();
        }
        super(xd, executor, s, tv/periscope/android/signer/SignerService);
    }
}
