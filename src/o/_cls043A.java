// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package o:
//            _cls03DC, rz, ra, rl, 
//            _cls04ED

final class _cls043A
{
    /* member class not found */
    class if {}


    private static final if vc = new if((byte)0);
    private final Context context;
    private final File vd;
    _cls03DC ve;

    public _cls043A(Context context1, File file)
    {
        this(context1, file, null);
    }

    public _cls043A(Context context1, File file, String s)
    {
        context = context1;
        vd = new File(file, "log-files");
        ve = vc;
        _mth1D35(s);
    }

    private File _mth1D4E(String s)
    {
        if (!vd.exists())
        {
            vd.mkdirs();
        }
        s = (new StringBuilder("crashlytics-userlog-")).append(s).append(".temp").toString();
        return new File(vd, s);
    }

    public final void _mth02CA(HashSet hashset)
    {
        File afile[] = vd.listFiles();
        if (afile != null)
        {
            int j = afile.length;
            for (int i = 0; i < j; i++)
            {
                File file = afile[i];
                String s = file.getName();
                int k = s.lastIndexOf(".temp");
                if (k != -1)
                {
                    s = s.substring(20, k);
                }
                if (!hashset.contains(s))
                {
                    file.delete();
                }
            }

        }
    }

    public final void _mth1D35(String s)
    {
        ve.FB27();
        ve = vc;
        if (s == null)
        {
            return;
        }
        if (!rz._mth02CA(context, "com.crashlytics.CollectCustomLogs", true))
        {
            ra._mth0454()._mth02BE("CrashlyticsCore", "Preferences requested no custom logs. Aborting log file creation.");
            return;
        } else
        {
            ve = new _cls04ED(_mth1D4E(s), 0x10000);
            return;
        }
    }

}
