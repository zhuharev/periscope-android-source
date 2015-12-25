// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

// Referenced classes of package o:
//            _cls03DC, sl, ra, rl, 
//            _cls04F1, _cls1681, rz

final class _cls04ED
    implements _cls03DC
{

    private final File vD;
    private final int vE;
    private sl vF;

    public _cls04ED(File file, int i)
    {
        vD = file;
        vE = i;
    }

    private void FE71()
    {
        if (vF == null)
        {
            try
            {
                vF = new sl(vD);
                return;
            }
            catch (IOException ioexception)
            {
                ra._mth0454()._mth02CB("CrashlyticsCore", (new StringBuilder("Could not open log file: ")).append(vD).toString(), ioexception);
            }
        }
    }

    public final void _mth02CA(long l, String s)
    {
        FE71();
        String s1 = s;
        if (vF == null)
        {
            break MISSING_BLOCK_LABEL_177;
        }
        s = s1;
        if (s1 == null)
        {
            s = "null";
        }
        int i = vE / 4;
        String s2 = s;
        if (s.length() > i)
        {
            s2 = (new StringBuilder("...")).append(s.substring(s.length() - i)).toString();
        }
        s = s2.replaceAll("\r", " ").replaceAll("\n", " ");
        s = String.format(Locale.US, "%d %s%n", new Object[] {
            Long.valueOf(l), s
        }).getBytes("UTF-8");
        vF._mth02CF(s, 0, s.length);
        for (; !vF.isEmpty() && vF._mth148D() > vE; vF.remove()) { }
        return;
        s;
        ra._mth0454()._mth02CB("CrashlyticsCore", "There was a problem writing to the Crashlytics log.", s);
    }

    public final _cls1681 FB1F()
    {
        if (!vD.exists())
        {
            return null;
        }
        FE71();
        if (vF == null)
        {
            return null;
        }
        int ai[] = new int[1];
        int[] _tmp = ai;
        ai[0] = 0;
        byte abyte0[] = new byte[vF._mth148D()];
        try
        {
            vF._mth02CA(new _cls04F1(this, abyte0, ai));
        }
        catch (IOException ioexception)
        {
            ra._mth0454()._mth02CB("CrashlyticsCore", "A problem occurred while reading the Crashlytics log file.", ioexception);
        }
        return _cls1681._mth02CA(abyte0, 0, ai[0]);
    }

    public final void FB27()
    {
        rz._mth02CA(vF, "There was a problem closing the Crashlytics log file.");
        vF = null;
    }

    public final void FB33()
    {
        rz._mth02CA(vF, "There was a problem closing the Crashlytics log file.");
        vF = null;
        vD.delete();
    }
}
