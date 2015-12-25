// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package o:
//            FEE9, _cls05D4

public final class _cls1489
    implements FEE9
{
    /* member class not found */
    class if {}


    private static final if pA = new if();
    private final if pB;
    private FEE9 pp;

    public _cls1489(FEE9 fee9)
    {
        this(fee9, pA);
    }

    private _cls1489(FEE9 fee9, if if1)
    {
        pp = fee9;
        pB = if1;
    }

    private _cls05D4 _mth02CA(File file, int i, int j)
    {
        File file1 = null;
        file = new FileInputStream(file);
        file1 = file;
        _cls05D4 _lcls05d4 = pp._mth02CB(file, i, j);
        try
        {
            file.close();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            return _lcls05d4;
        }
        return _lcls05d4;
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

    public final String getId()
    {
        return "";
    }

    public final _cls05D4 _mth02CB(Object obj, int i, int j)
    {
        return _mth02CA((File)obj, i, j);
    }

}
