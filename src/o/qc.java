// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.localytics.android.Localytics;
import java.util.Map;

public class qc
{

    public qc()
    {
    }

    public void tagEvent(String s, Map map)
    {
        Localytics.tagEvent(s, map);
    }

    public void _mth02D0(String s)
    {
        Localytics.tagScreen(s);
    }
}
