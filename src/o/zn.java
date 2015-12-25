// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            zm

final class zn extends zm
{

    zn(String s, int i)
    {
        super(s, 0, (byte)0);
    }

    public final int compare(Object obj, Object obj1)
    {
        obj = (PsUser)obj;
        obj1 = (PsUser)obj1;
        if (obj != null && obj1 != null)
        {
            return Integer.compare(((PsUser) (obj)).getNumHearts(), ((PsUser) (obj1)).getNumHearts()) * -1;
        }
        return obj == null ? 1 : -1;
    }
}
