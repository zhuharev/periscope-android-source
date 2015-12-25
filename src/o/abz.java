// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package o:
//            aby

public class abz extends BroadcastReceiver
{

    public abz()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        String s = intent.getAction();
        byte byte0 = -1;
        switch (s.hashCode())
        {
        case 1671672458: 
            if (s.equals("dismiss"))
            {
                byte0 = 0;
            }
            break;
        }
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            (new aby(context))._mth02BC(intent);
            break;
        }
    }
}
