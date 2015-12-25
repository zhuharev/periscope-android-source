// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.api;

import java.io.File;
import java.util.concurrent.ConcurrentMap;
import o.0675;
import o.abj;
import o.abk;
import o.zu;

abstract class ApiRequestWithLogs
{

    private zu mApiEvent;
    private final abj mLogManager;

    public ApiRequestWithLogs()
    {
        this(o.abj.if.al());
    }

    public ApiRequestWithLogs(abj abj1)
    {
        mLogManager = abj1;
    }

    private zu execute(abk abk1)
    {
        abk1._mth02CA(new _cls1());
        return mApiEvent;
    }

    protected abstract zu doExecute(File afile[]);

    public zu execute(String s)
    {
        if (s != null)
        {
            abk abk1 = (abk)mLogManager.bcc.get(s);
            if (abk1 != null)
            {
                return execute(abk1);
            }
            _cls0675._mth02CB(new Exception((new StringBuilder("Failed to find logger with name ")).append(s).toString()));
        }
        return doExecute(null);
    }



/*
    static zu access$002(ApiRequestWithLogs apirequestwithlogs, zu zu)
    {
        apirequestwithlogs.mApiEvent = zu;
        return zu;
    }

*/

    private class _cls1
        implements abi
    {

        final ApiRequestWithLogs this$0;

        public void onError(Exception exception)
        {
            mApiEvent = doExecute(null);
        }

        public boolean onReceive(File afile[])
        {
            mApiEvent = doExecute(afile);
            afile = mApiEvent;
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

        _cls1()
        {
            this$0 = ApiRequestWithLogs.this;
            super();
        }
    }

}
