// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;

// Referenced classes of package o:
//            _cls1D64, _cls1FD1, _cls1541

public class _cls4E28
{

    public Context mContext;

    public _cls4E28()
    {
    }

    public _cls4E28(Context context)
    {
        mContext = context;
    }

    public final boolean _mth1D5E()
    {
        if (mContext.getApplicationInfo().targetSdkVersion >= 16)
        {
            return mContext.getResources().getBoolean(_cls1D64.abc_action_bar_embed_tabs);
        } else
        {
            return mContext.getResources().getBoolean(_cls1D64.abc_action_bar_embed_tabs_pre_jb);
        }
    }

    public final int _mth1D67()
    {
        TypedArray typedarray = mContext.obtainStyledAttributes(null, _cls1FD1.ActionBar, _cls1541.actionBarStyle, 0);
        int j = typedarray.getLayoutDimension(_cls1FD1.ActionBar_height, 0);
        Resources resources = mContext.getResources();
        int i = j;
        if (!_mth1D5E())
        {
            i = Math.min(j, resources.getDimensionPixelSize(_cls1ECA.if.abc_action_bar_stacked_max_height));
        }
        typedarray.recycle();
        return i;
    }
}
