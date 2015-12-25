// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;

// Referenced classes of package o:
//            _cls2110, FF83

public class FB69
    implements _cls2110
{

    private final _cls2110 ov;

    public FB69(_cls2110 _pcls2110)
    {
        ov = _pcls2110;
    }

    public final FF83 _mth02CE(Object obj, int i, int j)
    {
        String s = (String)obj;
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        if (s.startsWith("/"))
        {
            obj = Uri.fromFile(new File(s));
        } else
        {
            Uri uri = Uri.parse(s);
            obj = uri;
            if (uri.getScheme() == null)
            {
                obj = Uri.fromFile(new File(s));
            }
        }
        return ov._mth02CE(obj, i, j);
    }
}
