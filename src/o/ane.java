// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

// Referenced classes of package o:
//            anm, amz, anf, ang, 
//            yu, asm, asn

public class ane extends anm
{

    public anf btK;

    public ane(Context context, yu yu, asm asm)
    {
        super(context, yu, asm, new amz());
        btK = new anf(yu);
    }

    protected final volatile asn dv()
    {
        return btK;
    }

    public final volatile int getItemCount()
    {
        return super.getItemCount();
    }

    public final volatile int getItemViewType(int i)
    {
        return super.getItemViewType(i);
    }

    public ang _mth02BB(ViewGroup viewgroup)
    {
        return new ang(LayoutInflater.from(mContext).inflate(0x7f030082, viewgroup, false), beo);
    }

    public android.support.v7.widget.RecyclerView._cls02CC _mth02BC(ViewGroup viewgroup)
    {
        return _mth02BB(viewgroup);
    }

    public final volatile void _mth02CA(android.support.v7.widget.RecyclerView._cls02CC _pcls02cc, int i)
    {
        super._mth02CA(_pcls02cc, i);
    }

    public final volatile android.support.v7.widget.RecyclerView._cls02CC _mth02CB(ViewGroup viewgroup, int i)
    {
        return super._mth02CB(viewgroup, i);
    }
}
