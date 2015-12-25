// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Future;

// Referenced classes of package o:
//            ri, uj, rz, vh, 
//            uw, vb, uz, ve, 
//            ra, rl, vm, rx, 
//            sd, uv, si, rk, 
//            sj

public final class rm extends ri
{

    private final uj QY = new uj();
    private PackageManager QZ;
    private PackageInfo Ra;
    private String Rb;
    private String Rc;
    private final Future Rd;
    private final Collection Re;
    private String installerPackageName;
    private String packageName;
    private String st;
    private String versionName;

    public rm(Future future, Collection collection)
    {
        Rd = future;
        Re = collection;
    }

    private Boolean doInBackground()
    {
        Object obj1;
        Object obj2;
        boolean flag;
        boolean flag1;
        obj1 = rz._mth141F(getContext());
        flag1 = false;
        obj2 = _mth05D0();
        flag = flag1;
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_278;
        }
        Object obj;
        if (Rd != null)
        {
            obj = (Map)Rd.get();
            break MISSING_BLOCK_LABEL_55;
        }
        obj = new HashMap();
        Map map = _mth02CE(((Map) (obj)), Re);
        obj = ((vh) (obj2)).UT;
        obj2 = map.values();
        boolean flag2 = true;
        if (!"new".equals(((uw) (obj)).Ul))
        {
            break MISSING_BLOCK_LABEL_167;
        }
        obj1 = _mth02CA(vb._mth02BF(getContext(), ((String) (obj1))), ((Collection) (obj2)));
        if ((new uz(this, rz._mth1FBE(getContext(), "com.crashlytics.ApiEndpoint"), ((uw) (obj)).url, QY))._mth02CA(((uv) (obj1))))
        {
            flag = ve.if._mth2148()._mth1F3D();
            break MISSING_BLOCK_LABEL_278;
        }
        ra._mth0454()._mth02CB("Fabric", "Failed to create app with Crashlytics service.", null);
        flag = false;
        break MISSING_BLOCK_LABEL_278;
        if ("configured".equals(((uw) (obj)).Ul))
        {
            flag = ve.if._mth2148()._mth1F3D();
            break MISSING_BLOCK_LABEL_278;
        }
        flag = flag2;
        if (!((uw) (obj)).Un)
        {
            break MISSING_BLOCK_LABEL_278;
        }
        ra._mth0454()._mth02BE("Fabric", "Server says an update is required - forcing a full App update.");
        obj1 = _mth02CA(vb._mth02BF(getContext(), ((String) (obj1))), ((Collection) (obj2)));
        (new vm(this, rz._mth1FBE(getContext(), "com.crashlytics.ApiEndpoint"), ((uw) (obj)).url, QY))._mth02CA(((uv) (obj1)));
        flag = flag2;
        break MISSING_BLOCK_LABEL_278;
        Exception exception;
        exception;
        ra._mth0454()._mth02CB("Fabric", "Error performing auto configuration.", exception);
        flag = flag1;
        return Boolean.valueOf(flag);
    }

    private uv _mth02CA(vb vb1, Collection collection)
    {
        Object obj = getContext();
        String s = (new rx())._mth06E5(((Context) (obj)));
        obj = rz._mth02CF(new String[] {
            rz._mth142A(((Context) (obj)))
        });
        int i = sd._mth15AE(installerPackageName).id;
        return new uv(s, getIdManager().QR, versionName, st, ((String) (obj)), Rb, i, Rc, "0", vb1, collection);
    }

    private static Map _mth02CE(Map map, Collection collection)
    {
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            ri ri1 = (ri)collection.next();
            if (!map.containsKey(ri1.getIdentifier()))
            {
                map.put(ri1.getIdentifier(), new rk(ri1.getIdentifier(), ri1.getVersion(), "binary"));
            }
        } while (true);
        return map;
    }

    private vh _mth05D0()
    {
        vh vh1;
        try
        {
            ve.if._mth2148()._mth02CA(this, idManager, QY, st, versionName, rz._mth1FBE(getContext(), "com.crashlytics.ApiEndpoint"))._mth1F3C();
            vh1 = ve.if._mth2148()._mth1F3B();
        }
        catch (Exception exception)
        {
            ra._mth0454()._mth02CB("Fabric", "Error dealing with settings", exception);
            return null;
        }
        return vh1;
    }

    protected final volatile Object doInBackground()
    {
        return doInBackground();
    }

    public final String getIdentifier()
    {
        return "io.fabric.sdk.android:fabric";
    }

    public final String getVersion()
    {
        return "1.3.6.79";
    }

    protected final boolean onPreExecute()
    {
        si si1 = getIdManager();
        installerPackageName = si1.RV._mth1507(si1.appContext);
        QZ = getContext().getPackageManager();
        packageName = getContext().getPackageName();
        Ra = QZ.getPackageInfo(packageName, 0);
        st = Integer.toString(Ra.versionCode);
        String s;
        if (Ra.versionName == null)
        {
            s = "0.0";
            break MISSING_BLOCK_LABEL_97;
        }
        s = Ra.versionName;
        versionName = s;
        Rb = QZ.getApplicationLabel(getContext().getApplicationInfo()).toString();
        Rc = Integer.toString(getContext().getApplicationInfo().targetSdkVersion);
        return true;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        ra._mth0454()._mth02CB("Fabric", "Failed init", namenotfoundexception);
        return false;
    }
}
