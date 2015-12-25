// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;

// Referenced classes of package o:
//            _cls0295

class _cls02B7
    implements android.widget.AdapterView.OnItemClickListener
{

    final _cls0295 ar;
    final _cls0295._cls02CA as;

    _cls02B7(_cls0295._cls02CA _pcls02ca, _cls0295 _pcls0295)
    {
        as = _pcls02ca;
        ar = _pcls0295;
        super();
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        as.am.setSelection(i);
        if (as.am.getOnItemClickListener() != null)
        {
            as.am.performItemClick(view, i, _cls0295._cls02CA._mth02CA(as).getItemId(i));
        }
        as.dismiss();
    }
}
