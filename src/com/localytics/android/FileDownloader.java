// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

// Referenced classes of package com.localytics.android:
//            BaseUploadThread

class FileDownloader
{

    FileDownloader()
    {
    }

    String downloadFile(String s, String s1, boolean flag, Proxy proxy)
    {
        File file;
        file = new File(s1);
        if (file.exists() && !flag)
        {
            Localytics.Log.w(String.format("The file %s does exist and overwrite is turned off.", new Object[] {
                file.getAbsolutePath()
            }));
            return s1;
        }
        File file1 = file.getParentFile();
        if (!file1.mkdirs() && !file1.isDirectory())
        {
            Localytics.Log.w(String.format("Could not create the directory %s for saving file.", new Object[] {
                file1.getAbsolutePath()
            }));
            return null;
        }
        File file2;
        byte abyte0[];
        file2 = new File(String.format("%s_temp", new Object[] {
            s1
        }));
        file2.createNewFile();
        s = new BufferedInputStream(BaseUploadThread.createURLConnection(new URL(s), proxy).getInputStream(), 16384);
        proxy = new FileOutputStream(file2.getPath());
        abyte0 = new byte[8192];
_L1:
        int i = s.read(abyte0);
label0:
        {
            if (i == -1)
            {
                break label0;
            }
            try
            {
                proxy.write(abyte0, 0, i);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Localytics.Log.e("Failed to download In-app campaign", s);
                return null;
            }
        }
          goto _L1
        proxy.close();
        if (file2.renameTo(file))
        {
            break MISSING_BLOCK_LABEL_223;
        }
        Localytics.Log.e("Failed to create permanent file for In-app campaign");
        file2.delete();
        return null;
        return s1;
    }
}
