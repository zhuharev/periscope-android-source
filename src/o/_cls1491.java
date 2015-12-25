// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Map;

// Referenced classes of package o:
//            _cls14AC

final class _cls1491
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}


    public final _cls14AC sZ;
    public final _cls02CA ta;
    public final Map tb;
    public final String tc;
    public final Map td;
    public final String te;
    public final Map tf;
    private String tg;
    public final long timestamp;

    private _cls1491(_cls14AC _pcls14ac, long l, _cls02CA _pcls02ca, Map map, String s, Map map1, 
            String s1, Map map2)
    {
        sZ = _pcls14ac;
        timestamp = l;
        ta = _pcls02ca;
        tb = map;
        tc = s;
        td = map1;
        te = s1;
        tf = map2;
    }

    _cls1491(_cls14AC _pcls14ac, long l, _cls02CA _pcls02ca, Map map, String s, Map map1, 
            String s1, Map map2, byte byte0)
    {
        this(_pcls14ac, l, _pcls02ca, map, s, map1, s1, map2);
    }

    public final String toString()
    {
        if (tg == null)
        {
            tg = (new StringBuilder("[")).append(getClass().getSimpleName()).append(": timestamp=").append(timestamp).append(", type=").append(ta).append(", details=").append(tb.toString()).append(", customType=").append(tc).append(", customAttributes=").append(td.toString()).append(", predefinedType=").append(te).append(", predefinedAttributes=").append(tf.toString()).append(", metadata=[").append(sZ).append("]]").toString();
        }
        return tg;
    }
}
