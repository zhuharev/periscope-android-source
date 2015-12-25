// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.SharedPreferences;

// Referenced classes of package o:
//            ri

public class up
{

    final SharedPreferences TT;
    final String TU;
    final Context context;

    public up(Context context1, String s)
    {
        if (context1 == null)
        {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        } else
        {
            context = context1;
            TU = s;
            TT = context.getSharedPreferences(TU, 0);
            return;
        }
    }

    public up(ri ri1)
    {
        this(ri1.getContext(), ri1.getClass().getName());
    }

    public android.content.SharedPreferences.Editor edit()
    {
        return TT.edit();
    }

    public boolean _mth02CA(android.content.SharedPreferences.Editor editor)
    {
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            editor.apply();
            return true;
        } else
        {
            return editor.commit();
        }
    }

    public SharedPreferences _mth1E97()
    {
        return TT;
    }
}
