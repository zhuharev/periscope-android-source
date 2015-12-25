// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;

// Referenced classes of package o:
//            aba

public final class aaz extends aba
{

    public aaz(Context context)
    {
        super(context);
    }

    private int ah()
    {
        if (bbJ == 1)
        {
            return (360 - (LN + 90) % 360) % 360;
        } else
        {
            return ((90 - LN) + 360) % 360;
        }
    }

    protected final int _mth30FC(int i)
    {
        int j = i;
        if (LN != -1)
        {
            j = ah();
            switch (bbJ)
            {
            case 0: // '\0'
                return (Math.abs(90 - i) + j) % 360;

            case 1: // '\001'
                return (Math.abs(270 - i) + j) % 360;

            default:
                j = ah();
                break;
            }
        }
        return j;
    }
}
