// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            zm

final class zo extends zm
{

    zo(String s, int i)
    {
        super(s, 1, (byte)0);
    }

    public final int compare(Object obj, Object obj1)
    {
        obj = (PsUser)obj;
        obj1 = (PsUser)obj1;
        if (obj != null && obj1 != null)
        {
            return ((PsUser) (obj)).username.compareToIgnoreCase(((PsUser) (obj1)).username);
        }
        return obj == null ? 1 : -1;
    }
}
