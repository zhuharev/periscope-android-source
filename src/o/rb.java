// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.os.Bundle;
import java.lang.ref.WeakReference;

// Referenced classes of package o:
//            ra

final class rb extends qy._cls02CA
{

    private ra QL;

    rb(ra ra1)
    {
        QL = ra1;
        super();
    }

    public final void onActivityCreated(Activity activity, Bundle bundle)
    {
        QL.QI = new WeakReference(activity);
    }

    public final void onActivityResumed(Activity activity)
    {
        QL.QI = new WeakReference(activity);
    }

    public final void onActivityStarted(Activity activity)
    {
        QL.QI = new WeakReference(activity);
    }
}
