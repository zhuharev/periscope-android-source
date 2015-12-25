// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

// Referenced classes of package o:
//            _cls2110, FF83

public class _cls4E3F
    implements _cls2110
{

    private final _cls2110 ov;
    private final Resources resources;

    public _cls4E3F(Context context, _cls2110 _pcls2110)
    {
        this(context.getResources(), _pcls2110);
    }

    private _cls4E3F(Resources resources1, _cls2110 _pcls2110)
    {
        resources = resources1;
        ov = _pcls2110;
    }

    private FF83 _mth02CA(Integer integer, int i, int j)
    {
        Object obj = null;
        Uri uri;
        try
        {
            uri = Uri.parse((new StringBuilder("android.resource://")).append(resources.getResourcePackageName(integer.intValue())).append('/').append(resources.getResourceTypeName(integer.intValue())).append('/').append(resources.getResourceEntryName(integer.intValue())).toString());
        }
        catch (android.content.res.Resources.NotFoundException notfoundexception)
        {
            uri = obj;
            if (Log.isLoggable("ResourceLoader", 5))
            {
                Log.w("ResourceLoader", (new StringBuilder("Received invalid resource id: ")).append(integer).toString(), notfoundexception);
                uri = obj;
            }
        }
        if (uri != null)
        {
            return ov._mth02CE(uri, i, j);
        } else
        {
            return null;
        }
    }

    public final FF83 _mth02CE(Object obj, int i, int j)
    {
        return _mth02CA((Integer)obj, i, j);
    }
}
