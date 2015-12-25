// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Bundle;

// Referenced classes of package o:
//            _cls1421

public final class _cls141F extends _cls14BD.if
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}


    private final Bundle mExtras;
    private final String _fld14D2;
    private final CharSequence _fld156A;
    private final CharSequence _fld1646[];
    private final boolean _fld1D0A;

    public final boolean getAllowFreeFormInput()
    {
        return _fld1D0A;
    }

    public final CharSequence[] getChoices()
    {
        return _fld1646;
    }

    public final Bundle getExtras()
    {
        return mExtras;
    }

    public final CharSequence getLabel()
    {
        return _fld156A;
    }

    public final String getResultKey()
    {
        return _fld14D2;
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 20)
        {
            new _cls02CA();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            new _cls02CE();
        } else
        {
            new _cls02CB();
        }
        new _cls1421();
    }
}
