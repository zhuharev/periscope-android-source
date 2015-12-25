// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            yu, ana, amz, asn, 
//            asm

public abstract class anm extends android.support.v7.widget.RecyclerView.if
{

    public final asm beo;
    private yu btL;
    private final amz buj;
    public final Context mContext;

    public anm(Context context, yu yu1, asm asm, amz amz1)
    {
        mContext = context;
        btL = yu1;
        beo = asm;
        buj = amz1;
    }

    protected abstract asn dv();

    public Object getItem(int i)
    {
        return btL._mth1D4A(i);
    }

    public int getItemCount()
    {
        return btL.v();
    }

    public int getItemViewType(int i)
    {
        if (getItem(i) instanceof zp.if)
        {
            return i != 0 ? 1 : 3;
        } else
        {
            return 2;
        }
    }

    public abstract android.support.v7.widget.RecyclerView._cls02CC _mth02BC(ViewGroup viewgroup);

    public void _mth02CA(android.support.v7.widget.RecyclerView._cls02CC _pcls02cc, int i)
    {
        PsUser psuser;
        switch (_pcls02cc.getItemViewType())
        {
        default:
            return;

        case 1: // '\001'
        case 3: // '\003'
            zp.if if1 = (zp.if)getItem(i);
            amz._mth02CA((ana)_pcls02cc, if1);
            return;

        case 2: // '\002'
            psuser = (PsUser)getItem(i);
            break;
        }
        dv()._mth02CA(_pcls02cc, psuser, i);
    }

    public android.support.v7.widget.RecyclerView._cls02CC _mth02CB(ViewGroup viewgroup, int i)
    {
        switch (i)
        {
        case 3: // '\003'
            return new ana(LayoutInflater.from(mContext).inflate(0x7f030054, viewgroup, false));

        case 1: // '\001'
            return new ana(LayoutInflater.from(mContext).inflate(0x7f030053, viewgroup, false));
        }
        return _mth02BC(viewgroup);
    }
}
