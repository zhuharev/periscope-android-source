// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.app.Fragment;
import java.util.HashSet;

// Referenced classes of package o:
//            _cls1D23, FB88, _cls1D5A, _cls1D3C, 
//            _cls06BA, _cls14FD

public final class FB4D extends Fragment
{
    /* member class not found */
    class if {}


    final _cls1D23 qN;
    final if qO;
    _cls1D5A qP;
    private final HashSet qQ;
    private FB4D qR;

    public FB4D()
    {
        this(new _cls1D23());
    }

    private FB4D(_cls1D23 _pcls1d23)
    {
        qO = new if((byte)0);
        qQ = new HashSet();
        qN = _pcls1d23;
    }

    public final void onAttach(Activity activity)
    {
        super.onAttach(activity);
        qR = FB88.FF89()._mth02CA(getActivity().getFragmentManager());
        if (qR != this)
        {
            qR.qQ.add(this);
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
        if (qR != null)
        {
            qR.qQ.remove(this);
            qR = null;
        }
    }

    public final void onLowMemory()
    {
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

    public final void onTrimMemory(int i)
    {
        if (qP != null)
        {
            _cls1D3C _lcls1d3c = qP.jl;
            _lcls1d3c.je._mth14A1(i);
            _lcls1d3c.jL._mth14A1(i);
        }
    }
}
