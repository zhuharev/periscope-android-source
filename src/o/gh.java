// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

// Referenced classes of package o:
//            _cls0993, _cls091F, bh, fm

public class gh
{

    private static Context EI;
    private static fm EJ;

    public gh()
    {
    }

    public static fm _mth02C7(Context context)
    {
        if (context == null)
        {
            throw new NullPointerException("null reference");
        }
        if (EJ != null)
        {
            return EJ;
        }
        int i = _cls0993._mth1D4E(context);
        switch (i)
        {
        default:
            throw new _cls091F(i);

        case 0: // '\0'
            Log.i(o/gh.getSimpleName(), "Making Creator dynamically");
            break;
        }
        if (EI == null)
        {
            EI = _cls0993._mth1D62(context);
        }
        EJ = fm.if.FF9E((IBinder)_mth02CA(EI.getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
        try
        {
            fm fm1 = EJ;
            if (EI == null)
            {
                EI = _cls0993._mth1D62(context);
            }
            fm1._mth02CA(bh._mth02E1(EI.getResources()), _cls0993.wF);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new android.support.v4.app.Fragment.if(context);
        }
        return EJ;
    }

    private static Object _mth02CA(ClassLoader classloader, String s)
    {
        if (classloader != null)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        throw new NullPointerException("null reference");
        classloader = ((ClassLoader) (_mth02CB(((ClassLoader)classloader).loadClass(s))));
        return classloader;
_L2:
        throw new IllegalStateException((new StringBuilder("Unable to find dynamic class ")).append(s).toString());
        classloader;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static Object _mth02CB(Class class1)
    {
        Object obj1;
        Object obj;
        try
        {
            obj = class1.newInstance();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new IllegalStateException((new StringBuilder("Unable to instantiate the dynamic class ")).append(class1.getName()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new IllegalStateException((new StringBuilder("Unable to call the default constructor of ")).append(class1.getName()).toString());
        }
        return obj;
    }
}
