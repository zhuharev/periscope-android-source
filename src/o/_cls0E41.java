// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.support.v7.widget.Toolbar;

public final class _cls0E41
    implements Runnable
{

    private Toolbar iF;

    public _cls0E41(Toolbar toolbar)
    {
        iF = toolbar;
        super();
    }

    public final void run()
    {
        iF.showOverflowMenu();
    }
}
