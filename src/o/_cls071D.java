// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Comparator;

public final class _cls071D
    implements Comparator
{

    public _cls071D()
    {
    }

    public final volatile int compare(Object obj, Object obj1)
    {
        obj = (android.support.v4.view.ViewPager._cls02CA)obj;
        obj1 = (android.support.v4.view.ViewPager._cls02CA)obj1;
        return ((android.support.v4.view.ViewPager._cls02CA) (obj)).position - ((android.support.v4.view.ViewPager._cls02CA) (obj1)).position;
    }
}
