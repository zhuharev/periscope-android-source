// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

// Referenced classes of package o:
//            rk, rz, ra, rl

final class re
    implements Callable
{

    private String QU;

    re(String s)
    {
        QU = s;
    }

    private static rk _mth02CA(ZipEntry zipentry, ZipFile zipfile)
    {
        ZipFile zipfile1;
        ZipFile zipfile2;
        zipfile2 = null;
        zipfile1 = null;
        zipfile = zipfile.getInputStream(zipentry);
        zipfile1 = zipfile;
        zipfile2 = zipfile;
        Object obj1 = new Properties();
        zipfile1 = zipfile;
        zipfile2 = zipfile;
        ((Properties) (obj1)).load(zipfile);
        zipfile1 = zipfile;
        zipfile2 = zipfile;
        Object obj = ((Properties) (obj1)).getProperty("fabric-identifier");
        zipfile1 = zipfile;
        zipfile2 = zipfile;
        String s = ((Properties) (obj1)).getProperty("fabric-version");
        zipfile1 = zipfile;
        zipfile2 = zipfile;
        obj1 = ((Properties) (obj1)).getProperty("fabric-build-type");
        zipfile1 = zipfile;
        zipfile2 = zipfile;
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            break MISSING_BLOCK_LABEL_96;
        }
        zipfile1 = zipfile;
        zipfile2 = zipfile;
        if (!TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_127;
        }
        zipfile1 = zipfile;
        zipfile2 = zipfile;
        try
        {
            throw new IllegalStateException((new StringBuilder("Invalid format of fabric file,")).append(zipentry.getName()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (ZipFile zipfile)
        {
            zipfile2 = zipfile1;
        }
        finally
        {
            rz.closeQuietly(zipfile2);
        }
        break MISSING_BLOCK_LABEL_156;
        zipfile1 = zipfile;
        zipfile2 = zipfile;
        obj = new rk(((String) (obj)), s, ((String) (obj1)));
        rz.closeQuietly(zipfile);
        return ((rk) (obj));
        ra._mth0454()._mth02CB("Fabric", (new StringBuilder("Error when parsing fabric properties ")).append(zipentry.getName()).toString(), zipfile);
        rz.closeQuietly(zipfile1);
        break MISSING_BLOCK_LABEL_198;
        throw zipentry;
        return null;
    }

    private HashMap _mth0585()
    {
        HashMap hashmap = new HashMap();
        long l = SystemClock.elapsedRealtime();
        int i = 0;
        ZipFile zipfile = new ZipFile(QU);
        Enumeration enumeration = zipfile.entries();
        do
        {
            if (!enumeration.hasMoreElements())
            {
                break;
            }
            i++;
            Object obj = (ZipEntry)enumeration.nextElement();
            if (((ZipEntry) (obj)).getName().startsWith("fabric/") && ((ZipEntry) (obj)).getName().length() > 7)
            {
                obj = _mth02CA(((ZipEntry) (obj)), zipfile);
                if (obj != null)
                {
                    hashmap.put(((rk) (obj)).identifier, obj);
                    ra._mth0454()._mth02BF("Fabric", String.format("Found kit:[%s] version:[%s]", new Object[] {
                        ((rk) (obj)).identifier, ((rk) (obj)).version
                    }));
                }
            }
        } while (true);
        try
        {
            zipfile.close();
        }
        catch (IOException ioexception) { }
        ra._mth0454()._mth02BF("Fabric", (new StringBuilder("finish scanning in ")).append(SystemClock.elapsedRealtime() - l).append(" reading:").append(i).toString());
        return hashmap;
    }

    public final Object call()
    {
        return _mth0585();
    }
}
