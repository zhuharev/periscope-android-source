// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.twitter.sdk.android.core.AuthTokenAdapter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package o:
//            jz, iz, hy, hw, 
//            mp, jc, in, ig

public final class im
{

    private jz Gr;
    private iz Gs;
    public hy Gt;
    private final HashMap Gu = new HashMap();
    public final ArrayList Gv = new ArrayList();
    private final ArrayList Gw = new ArrayList();
    private int Gx;
    private int Gy;
    private boolean Gz;

    public im()
    {
        Gr = jz.GX;
        Gs = iz.GE;
        Gt = hy.FZ;
        Gx = 2;
        Gy = 2;
        Gz = true;
    }

    private static void _mth02CA(String s, int i, int j, ArrayList arraylist)
    {
        if (s != null && !"".equals(s.trim()))
        {
            s = new hw(s);
        } else
        if (i != 2 && j != 2)
        {
            s = new hw(i, j);
        } else
        {
            return;
        }
        arraylist.add(jc._mth02CA(new mp(java/util/Date), s));
        arraylist.add(jc._mth02CA(new mp(java/sql/Timestamp), s));
        arraylist.add(jc._mth02CA(new mp(java/sql/Date), s));
    }

    public final im _mth02CA(Class class1, AuthTokenAdapter authtokenadapter)
    {
        _cls1D10.aux.checkArgument(true);
        if (authtokenadapter instanceof in)
        {
            Gu.put(class1, (in)authtokenadapter);
        }
        class1 = new mp(class1);
        Gv.add(jc._mth02CA(class1, authtokenadapter));
        return this;
    }

    public final ig _mth0490()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(Gv);
        Collections.reverse(arraylist);
        arraylist.addAll(Gw);
        _mth02CA(null, Gx, Gy, arraylist);
        return new ig(Gr, Gt, Gu, false, false, false, Gz, false, false, Gs, arraylist);
    }
}
