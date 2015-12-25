// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

// Referenced classes of package o:
//            _cls1646, FF8C

public interface _cls0722
{

    public abstract void collapseActionView();

    public abstract void dismissPopupMenus();

    public abstract Context getContext();

    public abstract int getDisplayOptions();

    public abstract Menu getMenu();

    public abstract int getNavigationMode();

    public abstract boolean hasExpandedActionView();

    public abstract boolean hideOverflowMenu();

    public abstract boolean isOverflowMenuShowing();

    public abstract void setCollapsible(boolean flag);

    public abstract void setDisplayOptions(int i);

    public abstract void setIcon(int i);

    public abstract void setIcon(Drawable drawable);

    public abstract void setLogo(int i);

    public abstract void setMenu(Menu menu, _cls0491.if if1);

    public abstract void setMenuPrepared();

    public abstract void setWindowCallback(android.view.Window.Callback callback);

    public abstract void setWindowTitle(CharSequence charsequence);

    public abstract boolean showOverflowMenu();

    public abstract _cls1646 _mth02CA(int i, long l);

    public abstract void _mth02CA(_cls1E5B.if if1, _cls1E5B._cls02CA _pcls02ca);

    public abstract void _mth02CA(FF8C ff8c);

    public abstract boolean FB60();

    public abstract boolean FBE6();

    public abstract Toolbar FE92();

    public abstract void FE9B();

    public abstract void FEA9();
}
