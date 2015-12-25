// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.util.AttributeSet;
import com.digits.sdk.android.DigitsAuthButton;

// Referenced classes of package o:
//            aln

public class alj extends DigitsAuthButton
{

    private int brI;

    public alj(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        aln._mth02CA(context, attributeset, this);
        setLastLoginType(acj.if.bda);
    }

    public alj(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        aln._mth02CA(context, attributeset, this);
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
                    bcX[acj.if.bdc.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        int i;
        switch (_cls1.bcX[if1.ordinal()])
        {
        case 1: // '\001'
            i = 0x7f0600e5;
            break;

        default:
            i = 0x7f060157;
            break;
        }
        if (i != brI)
        {
            brI = i;
            setText(brI);
        }
    }
}
