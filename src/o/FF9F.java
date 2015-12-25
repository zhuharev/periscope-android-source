// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.ComponentName;
import android.content.Intent;

public class FF9F
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}


    private static final if FE92;

    public static Intent makeMainActivity(ComponentName componentname)
    {
        return FE92.makeMainActivity(componentname);
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 15)
        {
            FE92 = new _cls02CE();
        } else
        if (i >= 11)
        {
            FE92 = new _cls02CB();
        } else
        {
            FE92 = new _cls02CA();
        }
    }
}
