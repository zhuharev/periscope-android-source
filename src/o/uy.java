// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONObject;

// Referenced classes of package o:
//            ra, rl, uo, rz, 
//            ri

public class uy
{

    final ri kit;

    public uy(ri ri)
    {
        kit = ri;
    }

    public void _mth02CA(long l, JSONObject jsonobject)
    {
        FileWriter filewriter;
        FileWriter filewriter1;
        FileWriter filewriter2;
        FileWriter filewriter3;
        ra._mth0454()._mth02BE("Fabric", "Writing settings to cache file...");
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        filewriter3 = null;
        filewriter2 = null;
        filewriter1 = filewriter2;
        filewriter = filewriter3;
        jsonobject.put("expires_at", l);
        filewriter1 = filewriter2;
        filewriter = filewriter3;
        filewriter3 = new FileWriter(new File(uo._mth02BC((new uo(kit)).context.getFilesDir()), "com.crashlytics.settings.json"));
        filewriter2 = filewriter3;
        filewriter1 = filewriter2;
        filewriter = filewriter2;
        filewriter3.write(jsonobject.toString());
        filewriter1 = filewriter2;
        filewriter = filewriter2;
        filewriter2.flush();
        rz._mth02CA(filewriter2, "Failed to close settings writer.");
        return;
        jsonobject;
        filewriter = filewriter1;
        ra._mth0454()._mth02CB("Fabric", "Failed to cache settings", jsonobject);
        rz._mth02CA(filewriter1, "Failed to close settings writer.");
        return;
        jsonobject;
        rz._mth02CA(filewriter, "Failed to close settings writer.");
        throw jsonobject;
    }

    public JSONObject _mth1F3A()
    {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        ra._mth0454()._mth02BE("Fabric", "Reading cached settings...");
        obj5 = null;
        obj6 = null;
        obj = null;
        obj4 = null;
        obj3 = obj5;
        obj2 = obj6;
        File file = new File(uo._mth02BC((new uo(kit)).context.getFilesDir()), "com.crashlytics.settings.json");
        obj3 = obj5;
        obj2 = obj6;
        if (!file.exists())
        {
            break MISSING_BLOCK_LABEL_116;
        }
        obj3 = obj5;
        obj2 = obj6;
        obj4 = new FileInputStream(file);
        obj = obj4;
        obj3 = obj;
        obj2 = obj;
        obj4 = new JSONObject(rz._mth02CA(((FileInputStream) (obj4))));
        obj2 = obj4;
        break MISSING_BLOCK_LABEL_135;
        obj3 = obj5;
        obj2 = obj6;
        ra._mth0454()._mth02BE("Fabric", "No cached settings found.");
        obj2 = obj4;
        rz._mth02CA(((java.io.Closeable) (obj)), "Error while closing settings cache file.");
        return ((JSONObject) (obj2));
        Object obj1;
        obj1;
        obj2 = obj3;
        ra._mth0454()._mth02CB("Fabric", "Failed to fetch cached settings", ((Exception) (obj1)));
        rz._mth02CA(((java.io.Closeable) (obj3)), "Error while closing settings cache file.");
        return null;
        obj1;
        rz._mth02CA(((java.io.Closeable) (obj2)), "Error while closing settings cache file.");
        throw obj1;
    }
}
