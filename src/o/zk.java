// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.List;
import java.util.Map;
import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            yu, zp

public final class zk extends yu
{

    public zk(zp zp1)
    {
        super(zp1);
    }

    public final String id()
    {
        return null;
    }

    public final int v()
    {
        return mUserManager.aWQ.size();
    }

    public final Object _mth1D4A(int i)
    {
        Object obj = mUserManager.aWQ.get(i);
        if (obj instanceof zp.if)
        {
            return obj;
        } else
        {
            zp zp1 = mUserManager;
            obj = (String)obj;
            return (PsUser)zp1.aWM.get(obj);
        }
    }
}
