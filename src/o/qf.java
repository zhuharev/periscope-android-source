// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.util.Log;
import java.util.HashMap;

// Referenced classes of package o:
//            qh

public final class qf extends HashMap
{

    public qf()
    {
    }

    public final Object put(Object obj, Object obj1)
    {
        return _mth02CA((String)obj, (qh)obj1);
    }

    public final qh _mth02CA(String s, qh qh1)
    {
        Log.d("Analytics", (new StringBuilder("Created Summary: ")).append(s).toString());
        return (qh)super.put(s, qh1);
    }
}
