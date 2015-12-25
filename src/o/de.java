// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.google.android.gms.location.DetectedActivity;
import java.util.Comparator;

public final class de
    implements Comparator
{

    public de()
    {
    }

    public final int compare(Object obj, Object obj1)
    {
        obj = (DetectedActivity)obj;
        obj1 = (DetectedActivity)obj1;
        int i = Integer.valueOf(((DetectedActivity) (obj1)).Cx).compareTo(Integer.valueOf(((DetectedActivity) (obj)).Cx));
        if (i == 0)
        {
            i = ((DetectedActivity) (obj)).Cw;
            if (i > 15)
            {
                i = 4;
            }
            int j = ((DetectedActivity) (obj1)).Cw;
            if (j > 15)
            {
                j = 4;
            }
            return Integer.valueOf(i).compareTo(Integer.valueOf(j));
        } else
        {
            return i;
        }
    }
}
