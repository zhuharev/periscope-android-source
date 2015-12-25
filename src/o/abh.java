// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

// Referenced classes of package o:
//            abd

final class abh
    implements Runnable
{

    private abd bbX;

    abh(abd abd1)
    {
        bbX = abd1;
        super();
    }

    public final void run()
    {
        if (abd._mth02CA(bbX))
        {
            return;
        }
        Object obj = abd._mth02CB(bbX);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        Exception exception;
        File afile[];
        int i;
        int j;
        try
        {
            ((Closeable) (obj)).close();
        }
        catch (IOException ioexception) { }
        abd._mth02CA(bbX, bbX.bbS);
        obj = new File(bbX.bbR.bcb, "access");
        if (!((File) (obj)).exists())
        {
            ((File) (obj)).mkdirs();
        }
        if (!((File) (obj)).exists() || !((File) (obj)).isDirectory()) goto _L2; else goto _L1
_L1:
        afile = ((File) (obj)).listFiles();
        j = afile.length;
        i = 0;
_L3:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        afile[i].delete();
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        try
        {
            ((File) (obj)).delete();
            abd._mth02CA(bbX, true);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            abd._mth02CA(bbX, "An error occurred attempting to close the logger.", null);
        }
        return;
    }
}
