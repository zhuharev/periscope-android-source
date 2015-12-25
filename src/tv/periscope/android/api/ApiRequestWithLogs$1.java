// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.api;

import java.io.File;
import o.abi;
import o.zu;

// Referenced classes of package tv.periscope.android.api:
//            ApiRequestWithLogs

class this._cls0
    implements abi
{

    final ApiRequestWithLogs this$0;

    public void onError(Exception exception)
    {
        ApiRequestWithLogs.access$002(ApiRequestWithLogs.this, doExecute(null));
    }

    public boolean onReceive(File afile[])
    {
        ApiRequestWithLogs.access$002(ApiRequestWithLogs.this, doExecute(afile));
        afile = ApiRequestWithLogs.access$000(ApiRequestWithLogs.this);
        boolean flag;
        if (((zu) (afile)).aXl == null && ((zu) (afile)).mU == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    ()
    {
        this$0 = ApiRequestWithLogs.this;
        super();
    }
}
