// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Enumeration;
import java.util.Hashtable;

// Referenced classes of package o:
//            ot, ow, pf

final class oa
{

    volatile ow LY;
    private String LZ[];
    private Hashtable Ma;
    boolean Mb;
    boolean Mc;
    pf Md;
    private String url;

    public oa(String as[], Hashtable hashtable, ow ow)
    {
        LZ = as;
        Ma = hashtable;
        LY = ow;
    }

    public final String getUrl()
    {
        if (url != null)
        {
            return url;
        }
        Object obj1 = ot._mth02CA(LZ, "/");
        Object obj = obj1;
        if (Ma != null)
        {
            obj = obj1;
            if (Ma.size() > 0)
            {
                obj = new StringBuffer();
                ((StringBuffer) (obj)).append(((String) (obj1))).append("?");
                obj1 = Ma.keys();
                boolean flag = true;
                String s;
                for (; ((Enumeration) (obj1)).hasMoreElements(); ((StringBuffer) (obj)).append(ot._mth02CB(s)).append("=").append(ot._mth02CB((String)Ma.get(s))))
                {
                    if (!flag)
                    {
                        ((StringBuffer) (obj)).append("&");
                    } else
                    {
                        flag = false;
                    }
                    s = (String)((Enumeration) (obj1)).nextElement();
                }

                obj = ((StringBuffer) (obj)).toString();
            }
        }
        url = ((String) (obj));
        return url;
    }
}
