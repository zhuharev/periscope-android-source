// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;

// Referenced classes of package o:
//            _cls1435

public static final class yf extends yf
{

    private _cls1435 ye;
    private final int yf;

    public final void _mth02CA(int i, Bundle bundle)
    {
        if (ye == null)
        {
            throw new NullPointerException(String.valueOf("onAccountValidationComplete can be called only once per call to validateAccount"));
        } else
        {
            _cls1435 _lcls1435 = ye;
            int j = yf;
            _lcls1435.xQ.sendMessage(_lcls1435.xQ.obtainMessage(5, j, -1, new <init>(_lcls1435, i, bundle)));
            ye = null;
            return;
        }
    }

    public final void _mth02CA(int i, IBinder ibinder, Bundle bundle)
    {
        if (ye == null)
        {
            throw new NullPointerException(String.valueOf("onPostInitComplete can be called only once per call to getRemoteService"));
        } else
        {
            _cls1435 _lcls1435 = ye;
            int j = yf;
            _lcls1435.xQ.sendMessage(_lcls1435.xQ.obtainMessage(1, j, -1, new <init>(_lcls1435, i, ibinder, bundle)));
            ye = null;
            return;
        }
    }

    public undle(_cls1435 _pcls1435, int i)
    {
        ye = _pcls1435;
        yf = i;
    }
}
