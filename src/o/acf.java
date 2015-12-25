// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import java.util.concurrent.Executor;

// Referenced classes of package o:
//            xd

public class acf extends Service
{
    public final class if extends Binder
    {

        final acf bcS;

        public if()
        {
            bcS = acf.this;
            super();
        }
    }


    Executor bcQ;
    private final if bcR = new if();

    public acf()
    {
    }

    public IBinder onBind(Intent intent)
    {
        return bcR;
    }

    public void onCreate()
    {
        super.onCreate();
        bcQ = xd._mth3063();
    }
}
