// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;

// Referenced classes of package o:
//            apm, apj

public final class app extends android.support.v7.widget.RecyclerView._cls02CC
    implements android.view.View.OnClickListener
{

    public final apm byY;
    public apj byZ;

    public app(View view)
    {
        super(view);
        byY = (apm)view;
        byY.setOnClickListener(this);
    }

    public final void onClick(View view)
    {
        if (byY == view)
        {
            byZ.execute();
        }
    }
}
