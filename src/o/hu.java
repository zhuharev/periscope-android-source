// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.signin.internal.CheckServerAuthResult;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

// Referenced classes of package o:
//            _cls05E3, hr

final class hu
    implements Runnable
{

    private List FQ;
    private String FR;
    private hr FS;
    private ht.if FT;

    hu(ht.if if1, List list, String s, hr hr1)
    {
        FT = if1;
        FQ = list;
        FR = s;
        FS = hr1;
        super();
    }

    public final void run()
    {
        try
        {
            Object obj = ht.if._mth02CA(FT);
            Collections.unmodifiableSet(new HashSet(FQ));
            obj = ((_cls1427.if) (obj))._mth02C9();
            obj = new CheckServerAuthResult(((_cls05E3) (obj))._mth012E(), ((_cls05E3) (obj))._mth012F());
            FS._mth02CA(((CheckServerAuthResult) (obj)));
            return;
        }
        catch (RemoteException remoteexception)
        {
            Log.e("SignInClientImpl", "RemoteException thrown when processing checkServerAuthorization callback", remoteexception);
        }
    }
}
