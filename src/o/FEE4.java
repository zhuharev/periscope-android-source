// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.support.v4.app.Fragment;
import java.util.HashSet;

// Referenced classes of package o:
//            _cls1D23, FB88, _cls02C9, _cls1D5A, 
//            _cls1D3C, _cls06BA, _cls14FD

public final class FEE4 extends Fragment
{
    /* member class not found */
    class if {}


    final _cls1D23 qN;
    _cls1D5A qP;
    private final HashSet qQ;
    final if ra;
    private FEE4 rb;

    public FEE4()
    {
        this(new _cls1D23());
    }

    private FEE4(_cls1D23 _pcls1d23)
    {
        ra = new if((byte)0);
        qQ = new HashSet();
        qN = _pcls1d23;
    }

    public final void onAttach(Activity activity)
    {
        super.onAttach(activity);
        rb = FB88.FF89()._mth02CA(getActivity().getSupportFragmentManager());
        if (rb != this)
        {
            rb.qQ.add(this);
        }
    }

    public final void onDestroy()
    {
        super.onDestroy();
        qN.onDestroy();
    }

    public final void onDetach()
    {
        super.onDetach();
        if (rb != null)
        {
            rb.qQ.remove(this);
            rb = null;
        }
    }

    public final void onLowMemory()
    {
        super.onLowMemory();
        if (qP != null)
        {
            _cls1D3C _lcls1d3c = qP.jl;
            _lcls1d3c.je._mth1E59();
            _lcls1d3c.jL._mth1E59();
        }
    }

    public final void onStart()
    {
        super.onStart();
        qN.onStart();
    }

    public final void onStop()
    {
        super.onStop();
        qN.onStop();
    }
}
