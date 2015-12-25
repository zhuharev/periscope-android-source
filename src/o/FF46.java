// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package o:
//            FEE5

public final class FF46
{

    private final Context context;

    public FF46(Context context1)
    {
        context = context1;
    }

    private static FEE5 _mth02C9(String s)
    {
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", s);
        }
        Object obj;
        try
        {
            obj = s.newInstance();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException((new StringBuilder("Unable to instantiate GlideModule implementation for ")).append(s).toString(), ((Throwable) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException((new StringBuilder("Unable to instantiate GlideModule implementation for ")).append(s).toString(), ((Throwable) (obj)));
        }
        if (!(obj instanceof FEE5))
        {
            throw new RuntimeException((new StringBuilder("Expected instanceof GlideModule, but found: ")).append(obj).toString());
        } else
        {
            return (FEE5)obj;
        }
    }

    public final ArrayList _mth013E()
    {
        ArrayList arraylist = new ArrayList();
        ApplicationInfo applicationinfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        if (applicationinfo.metaData != null)
        {
            Iterator iterator = applicationinfo.metaData.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s = (String)iterator.next();
                if ("GlideModule".equals(applicationinfo.metaData.get(s)))
                {
                    arraylist.add(_mth02C9(s));
                }
            } while (true);
        }
        return arraylist;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        throw new RuntimeException("Unable to find metadata to parse GlideModules", namenotfoundexception);
    }
}
