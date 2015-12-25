// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package o:
//            _cls02B4, _cls0E2F

public final class _cls1D36
    implements Iterable
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}


    public final ArrayList _fld217C = new ArrayList();
    public final Context FB58;

    private _cls1D36(Context context)
    {
        FB58 = context;
    }

    public static _cls1D36 _mth02CA(_cls0E2F _pcls0e2f)
    {
        return new _cls1D36(_pcls0e2f);
    }

    public final Iterator iterator()
    {
        return _fld217C.iterator();
    }

    public final _cls1D36 _mth02CA(ComponentName componentname)
    {
        int i = _fld217C.size();
        try
        {
            componentname = _cls02B4._mth02CA(FB58, componentname);
        }
        // Misplaced declaration of an exception variable
        catch (ComponentName componentname)
        {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(componentname);
        }
        if (componentname == null)
        {
            break; /* Loop/switch isn't completed */
        }
        _fld217C.add(i, componentname);
        componentname = _cls02B4._mth02CA(FB58, componentname.getComponent());
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_17;
_L1:
        return this;
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            new _cls02CB();
        } else
        {
            new _cls02CA();
        }
    }
}
