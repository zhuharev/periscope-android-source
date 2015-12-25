// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package o:
//            xe

public class ari extends RelativeLayout
{

    private int bBq;
    private String bBr;
    private TextView bBs;
    private TextView bBt;

    public ari(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        _mth02CF(context, attributeset);
    }

    public ari(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        _mth02CF(context, attributeset);
    }

    private void _mth02CF(Context context, AttributeSet attributeset)
    {
        inflate(context, 0x7f030060, this);
        attributeset = context.obtainStyledAttributes(attributeset, xe.PsMultiSelectPreference, 0, 0);
        bBq = attributeset.getResourceId(0, 0);
        attributeset.recycle();
        break MISSING_BLOCK_LABEL_43;
        context;
        attributeset.recycle();
        throw context;
        bBr = context.getString(0x7f0600e1);
        if (!bBr.contains(" "))
        {
            bBr = (new StringBuilder()).append(bBr).append(" ").toString();
        }
        return;
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        ((TextView)findViewById(0x7f0d0037)).setText(bBq);
        bBs = (TextView)findViewById(0x7f0d0102);
        bBt = (TextView)findViewById(0x7f0d011d);
    }

    public void setItems(Collection collection)
    {
        bBt.setText(String.valueOf(collection.size()));
        StringBuilder stringbuilder = new StringBuilder();
        int i = 0;
        for (collection = collection.iterator(); collection.hasNext();)
        {
            String s = (String)collection.next();
            if (i > 0)
            {
                stringbuilder.append(bBr);
            }
            stringbuilder.append(s);
            i++;
        }

        bBs.setText(stringbuilder.toString());
    }
}
