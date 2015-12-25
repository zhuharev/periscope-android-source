// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.DialogInterface;
import android.view.ActionMode;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            ank, anj

final class anl
    implements android.content.DialogInterface.OnClickListener
{

    private ActionMode buh;
    private ank bui;

    anl(ank ank1, ActionMode actionmode)
    {
        bui = ank1;
        buh = actionmode;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        String s;
        for (dialoginterface = Collections.unmodifiableCollection(bui.bug.bmZ.bnd).iterator(); dialoginterface.hasNext(); anj._mth02CA(bui.bug.bue).deleteBroadcast(s))
        {
            s = (String)dialoginterface.next();
        }

        bui.bug.bmZ.bnd.clear();
        buh.finish();
    }
}
