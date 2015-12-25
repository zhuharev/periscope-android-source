// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.util.Log;
import com.twitter.sdk.android.core.TwitterCore;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package o:
//            _cls026B, aor, agj, FC62, 
//            ada, acj, zp, agi

public class data
    implements ject
{

    private final Object data;
    private final FC62 mq;
    private _cls026B mr;

    public static agi _mth02CA(ada ada, acj acj, zp zp)
    {
        acj = CA(acj, zp);
        if ("development".equals("production") || acj == null)
        {
            return new aor(ada);
        } else
        {
            return new agj(ada.getResources(), TwitterCore.getInstance().getApiClient(acj));
        }
    }

    public final boolean _mth02CF(File file)
    {
        File file1;
        File file2;
        Object obj;
        Object obj1;
        obj1 = null;
        obj = null;
        file2 = obj;
        file1 = obj1;
        _cls026B._mth02CA(mr);
        file2 = obj;
        file1 = obj1;
        file = new BufferedOutputStream(new FileOutputStream(file));
        file2 = file;
        file1 = file;
        boolean flag = mq._mth02CA(data, file);
        try
        {
            file.close();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            return flag;
        }
        return flag;
        file;
        file1 = file2;
        if (!Log.isLoggable("DecodeJob", 3))
        {
            break MISSING_BLOCK_LABEL_92;
        }
        file1 = file2;
        Log.d("DecodeJob", "Failed to find file to write to disk cache", file);
        if (file2 != null)
        {
            try
            {
                file2.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                return false;
            }
            return false;
        } else
        {
            return false;
        }
        file;
        if (file1 != null)
        {
            try
            {
                file1.close();
            }
            catch (IOException ioexception) { }
        }
        throw file;
    }

    public ject()
    {
    }

    public ject(_cls026B _pcls026b, FC62 fc62, Object obj)
    {
        mr = _pcls026b;
        super();
        mq = fc62;
        data = obj;
    }
}
