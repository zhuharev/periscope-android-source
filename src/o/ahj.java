// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package o:
//            aia, aos, afk, auf, 
//            afl, afm

public final class ahj extends aia
{

    public ahj(afk afk, auf auf, afl afl, afm afm)
    {
        super(afk, auf, afl, null, afm);
    }

    protected final View _mth1D40(Context context)
    {
        View view = LayoutInflater.from(context).inflate(0x7f03002d, null);
        ((TextView)view.findViewById(0x7f0d0037)).setText(aos._mth1D37(context.getString(0x7f060064)));
        return view;
    }
}
