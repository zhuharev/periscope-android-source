// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Color;
import android.text.TextUtils;

// Referenced classes of package o:
//            adt

public static final class tring
{

    public final String category;
    public final int color;
    public final String summary;

    public static int parseColor(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return 0;
        }
        String s1 = s;
        int i;
        try
        {
            if (s.charAt(0) != '#')
            {
                s1 = (new StringBuilder("#")).append(s).toString();
            }
            i = Color.parseColor(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return 0;
        }
        return i;
    }

    public tring(String s, String s1, String s2)
    {
        summary = s;
        if (TextUtils.isEmpty(s1))
        {
            s1 = null;
        }
        category = s1;
        color = parseColor(s2);
    }
}
