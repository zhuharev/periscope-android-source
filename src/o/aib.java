// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import java.util.List;

// Referenced classes of package o:
//            ait, aiq, aiy, aip

public class aib extends RelativeLayout
{

    public aip bmI;
    public aiy bmJ;

    public aib(Context context)
    {
        super(context);
        init();
    }

    public aib(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    public aib(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init();
    }

    private void init()
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            bmI = new ait(getContext());
        } else
        {
            bmI = new aiq(getContext());
        }
        bmJ = new aiy(getContext());
    }

    public void setHeartThemes(List list)
    {
        aiy aiy1 = bmJ;
        aiy1.bow.clear();
        if (list != null)
        {
            aiy1.bow.addAll(list);
        }
    }
}
