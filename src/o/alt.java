// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

// Referenced classes of package o:
//            aln

public class alt extends TwitterLoginButton
{

    private int brI;

    public alt(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        aln._mth02CA(context, attributeset, this);
        setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        setLastLoginType(acj.if.bda);
    }

    public alt(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        aln._mth02CA(context, attributeset, this);
        setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        setLastLoginType(acj.if.bda);
    }

    public void setLastLoginType(acj.if if1)
    {
        static final class _cls1
        {

            static final int bcX[];

            static 
            {
                bcX = new int[acj.if.values().length];
                try
                {
                    bcX[acj.if.bdb.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        int i;
        switch (_cls1.bcX[if1.ordinal()])
        {
        case 1: // '\001'
            i = 0x7f0600e6;
            break;

        default:
            i = 0x7f060158;
            break;
        }
        if (i != brI)
        {
            brI = i;
            if1 = getContext().getString(brI);
            i = if1.indexOf('*');
            if (i != -1)
            {
                int j = if1.indexOf('*', i + 1);
                if (j != -1)
                {
                    Resources resources = getResources();
                    SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(if1, 0, i);
                    int k = spannablestringbuilder.length();
                    spannablestringbuilder.append(if1, i + 1, j);
                    int l = spannablestringbuilder.length();
                    spannablestringbuilder.append(if1, j + 1, if1.length());
                    spannablestringbuilder.setSpan(new ForegroundColorSpan(resources.getColor(0x7f0c00be)), 0, i, 18);
                    spannablestringbuilder.setSpan(new ForegroundColorSpan(resources.getColor(0x7f0c00a4)), k, l, 18);
                    if1 = spannablestringbuilder;
                }
            }
            setText(if1);
        }
    }
}
