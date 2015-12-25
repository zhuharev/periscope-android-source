// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.FileObserver;
import java.io.File;

// Referenced classes of package o:
//            aoo

static final class bvk extends FileObserver
{

    private final String bvk;
    tring bvl;

    public final void onEvent(int i, String s)
    {
        switch (i)
        {
        default:
            return;

        case 256: 
            if (bvl != null)
            {
                bvl.E0((new StringBuilder()).append(bvk).append(File.separator).append(s).toString());
                return;
            }
            break;

        case 8: // '\b'
            if (bvl != null)
            {
                bvl.E8((new StringBuilder()).append(bvk).append(File.separator).append(s).toString());
            }
            break;
        }
    }

    public tring(String s, int i)
    {
        super(s, 264);
        bvk = s;
    }
}
