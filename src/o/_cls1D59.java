// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.MenuItem;
import android.view.View;

// Referenced classes of package o:
//            FE77, _cls03F3

public interface _cls1D59
    extends MenuItem
{

    public abstract boolean collapseActionView();

    public abstract boolean expandActionView();

    public abstract View getActionView();

    public abstract boolean isActionViewExpanded();

    public abstract MenuItem setActionView(int i);

    public abstract MenuItem setActionView(View view);

    public abstract void setShowAsAction(int i);

    public abstract MenuItem setShowAsActionFlags(int i);

    public abstract FE77 _mth02C7();

    public abstract _cls03F3 _mth02CA(FE77 fe77);

    public abstract _cls1D59 _mth02CA(_cls0441._cls02CB _pcls02cb);
}
