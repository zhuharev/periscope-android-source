// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.net.Uri;

// Referenced classes of package o:
//            _cls2110, _cls1D39, _cls1E3D, _cls0138, 
//            FF83, FF69

public abstract class FB87
    implements _cls2110
{

    private final Context context;
    private final _cls2110 oP;

    public FB87(Context context1, _cls2110 _pcls2110)
    {
        context = context1;
        oP = _pcls2110;
    }

    public abstract _cls0138 _mth02CA(Context context1, Uri uri);

    public final FF83 _mth02CE(Object obj, int i, int j)
    {
label0:
        {
            Uri uri = (Uri)obj;
            String s = uri.getScheme();
            Object obj1 = null;
            boolean flag;
            if ("file".equals(s) || "content".equals(s) || "android.resource".equals(s))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                if (_cls1D39._mth02CF(uri))
                {
                    obj = _cls1D39._mth141D(uri);
                    return _mth02CF(context, ((String) (obj)));
                } else
                {
                    return _mth02CA(context, uri);
                }
            }
            obj = obj1;
            if (oP == null)
            {
                break label0;
            }
            if (!"http".equals(s))
            {
                obj = obj1;
                if (!"https".equals(s))
                {
                    break label0;
                }
            }
            obj = oP._mth02CE(new _cls1E3D(uri.toString()), i, j);
        }
        return ((FF83) (obj));
    }

    public abstract FF69 _mth02CF(Context context1, String s);
}
