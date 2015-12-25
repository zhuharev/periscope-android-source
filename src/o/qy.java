// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Application;
import android.content.Context;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package o:
//            qz

public final class qy
{
    public static final class if
    {

        public final Application Qx;
        public final HashSet Qz = new HashSet();

        public boolean _mth02CB(_cls02CA _pcls02ca)
        {
            if (Qx != null)
            {
                _pcls02ca = new qz(this, _pcls02ca);
                Qx.registerActivityLifecycleCallbacks(_pcls02ca);
                Qz.add(_pcls02ca);
                return true;
            } else
            {
                return false;
            }
        }

        if(Application application)
        {
            Qx = application;
        }
    }

    /* member class not found */
    class _cls02CA {}


    private final Application Qx;
    public if Qy;

    public qy(Context context)
    {
        Qx = (Application)context.getApplicationContext();
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            Qy = new if(Qx);
        }
    }

    public final boolean _mth02CA(_cls02CA _pcls02ca)
    {
        return Qy != null && Qy._mth02CB(_pcls02ca);
    }
}
