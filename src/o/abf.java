// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

// Referenced classes of package o:
//            abd

final class abf
    implements Runnable
{

    private String bbW;
    private abd bbX;

    abf(abd abd1, String s)
    {
        bbX = abd1;
        bbW = s;
        super();
    }

    public final void run()
    {
        if (abd._mth02CA(bbX))
        {
            return;
        }
        try
        {
            if (abd._mth02CB(bbX) == null)
            {
                abd abd1 = bbX;
                abd abd2 = bbX;
                File file = new File(abd2.bbR.bcb);
                if (!file.exists())
                {
                    file.mkdirs();
                }
                abd._mth02CA(abd1, new BufferedWriter(new FileWriter(abd2.bbS, abd2.bbV)));
            }
            abd._mth02CB(bbX).write(bbW);
            return;
        }
        catch (Exception exception)
        {
            abd._mth02CA(bbX, "Failed to write log entry", exception);
        }
    }
}
