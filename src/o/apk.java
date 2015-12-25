// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package o:
//            app, apj, apo, aui, 
//            aos

public class apk extends RelativeLayout
    implements android.view.View.OnClickListener
{

    private TextView byQ;
    private ViewGroup byR;
    private ArrayList byS;

    public apk(Context context)
    {
        super(context);
        byS = new ArrayList();
        init(context);
    }

    public apk(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        byS = new ArrayList();
        init(context);
    }

    public apk(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        byS = new ArrayList();
        init(context);
    }

    private void init(Context context)
    {
        LayoutInflater.from(context).inflate(0x7f030019, this, true);
        byQ = (TextView)findViewById(0x7f0d005d);
        byR = (ViewGroup)findViewById(0x7f0d005f);
        setOnClickListener(this);
    }

    public void onClick(View view)
    {
    }

    public void setActions(List list)
    {
        byS.clear();
        if (list != null)
        {
            byS.addAll(list);
        }
        int l = byR.getChildCount();
        int k = byS.size();
        if (l < k)
        {
            list = byR;
            LayoutInflater layoutinflater = LayoutInflater.from(getContext());
            for (int i = 0; i < k - l; i++)
            {
                View view = layoutinflater.inflate(0x7f03001b, byR, false);
                view.setTag(new app(view));
                list.addView(view);
            }

        }
        l = byR.getChildCount();
        for (int j = 0; j < l; j++)
        {
            Object obj = byR.getChildAt(j);
            if (j < k)
            {
                list = (apj)byS.get(j);
                ((View) (obj)).setVisibility(0);
                obj = (app)((View) (obj)).getTag();
                list.aV()._mth02CA(((app) (obj)), list, j);
            } else
            {
                ((View) (obj)).setVisibility(8);
            }
        }

    }

    public void setSnippet(String s)
    {
        if (aui._mth02BF(s))
        {
            byQ.setText(aos._mth1D37(s));
            byQ.setVisibility(0);
            return;
        } else
        {
            byQ.setVisibility(8);
            return;
        }
    }
}
