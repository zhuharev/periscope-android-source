// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            aod, ann

final class ano extends aod
{

    private ann bur;

    ano(ann ann1)
    {
        bur = ann1;
        super();
    }

    protected final int getItemCount()
    {
        return bur.getItemCount();
    }

    protected final boolean FB61(int i)
    {
        return bur.getItemViewType(i) == 2;
    }

    protected final String FB64(int i)
    {
        Object obj = bur.getItem(i);
        if (obj instanceof PsUser)
        {
            return ((PsUser)obj).id;
        } else
        {
            return "";
        }
    }
}
