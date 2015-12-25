// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package o:
//            ou

public final class ot extends ou
{

    public ot()
    {
    }

    public static String _mth02CB(String s)
    {
        try
        {
            s = URLEncoder.encode(s, "UTF-8").replace("+", "%20");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }
}
