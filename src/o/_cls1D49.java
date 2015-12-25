// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.database.Cursor;
import android.widget.Filter;

// Referenced classes of package o:
//            _cls1D45

final class _cls1D49 extends Filter
{
    /* member class not found */
    class if {}


    private if _fld0647;

    _cls1D49(_cls1D45 _pcls1d45)
    {
        _fld0647 = _pcls1d45;
    }

    public final CharSequence convertResultToString(Object obj)
    {
        return _fld0647._mth02CA((Cursor)obj);
    }

    protected final android.widget.Filter.FilterResults performFiltering(CharSequence charsequence)
    {
        charsequence = _fld0647.runQueryOnBackgroundThread(charsequence);
        android.widget.Filter.FilterResults filterresults = new android.widget.Filter.FilterResults();
        if (charsequence != null)
        {
            filterresults.count = charsequence.getCount();
            filterresults.values = charsequence;
            return filterresults;
        } else
        {
            filterresults.count = 0;
            filterresults.values = null;
            return filterresults;
        }
    }

    protected final void publishResults(CharSequence charsequence, android.widget.Filter.FilterResults filterresults)
    {
        charsequence = _fld0647.getCursor();
        if (filterresults.values != null && filterresults.values != charsequence)
        {
            _fld0647.changeCursor((Cursor)filterresults.values);
        }
    }
}
