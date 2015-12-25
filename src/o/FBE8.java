// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.AsyncTask;

// Referenced classes of package o:
//            FE74

public class FBE8
{

    public FBE8()
    {
    }

    public static transient AsyncTask _mth02CA(AsyncTask asynctask, Object aobj[])
    {
        if (asynctask == null)
        {
            throw new IllegalArgumentException("task can not be null");
        }
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            FE74._mth02CB(asynctask, aobj);
            return asynctask;
        } else
        {
            asynctask.execute(aobj);
            return asynctask;
        }
    }
}
