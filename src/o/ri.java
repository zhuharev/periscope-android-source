// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import java.io.File;
import java.util.Collection;

// Referenced classes of package o:
//            rh, sv, sx, tb, 
//            st, ra, rd, si, 
//            rf

public abstract class ri
    implements Comparable
{

    Context context;
    ra fabric;
    si idManager;
    rf initializationCallback;
    rh initializationTask;

    public ri()
    {
        initializationTask = new rh(this);
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((ri)obj);
    }

    public int compareTo(ri ri1)
    {
        if (containsAnnotatedDependency(ri1))
        {
            return 1;
        }
        if (ri1.containsAnnotatedDependency(this))
        {
            return -1;
        }
        if (hasAnnotatedDependency() && !ri1.hasAnnotatedDependency())
        {
            return 1;
        }
        return hasAnnotatedDependency() || !ri1.hasAnnotatedDependency() ? 0 : -1;
    }

    boolean containsAnnotatedDependency(ri ri1)
    {
        sv sv1 = (sv)getClass().getAnnotation(o/sv);
        if (sv1 != null)
        {
            Class aclass[] = sv1._mth14FF();
            int j = aclass.length;
            for (int i = 0; i < j; i++)
            {
                if (aclass[i].equals(ri1.getClass()))
                {
                    return true;
                }
            }

        }
        return false;
    }

    public abstract Object doInBackground();

    public Context getContext()
    {
        return context;
    }

    public Collection getDependencies()
    {
        return ((st)(tb)((sx) (initializationTask)).SS).getDependencies();
    }

    public ra getFabric()
    {
        return fabric;
    }

    public si getIdManager()
    {
        return idManager;
    }

    public abstract String getIdentifier();

    public String getPath()
    {
        return (new StringBuilder(".Fabric")).append(File.separator).append(getIdentifier()).toString();
    }

    public abstract String getVersion();

    boolean hasAnnotatedDependency()
    {
        return (sv)getClass().getAnnotation(o/sv) != null;
    }

    final void initialize()
    {
        initializationTask._mth02CA(fabric.QF, new Void[] {
            null
        });
    }

    void injectParameters(Context context1, ra ra1, rf rf, si si)
    {
        fabric = ra1;
        context = new rd(context1, getIdentifier(), getPath());
        initializationCallback = rf;
        idManager = si;
    }

    protected void onCancelled(Object obj)
    {
    }

    protected void onPostExecute(Object obj)
    {
    }

    public boolean onPreExecute()
    {
        return true;
    }
}
