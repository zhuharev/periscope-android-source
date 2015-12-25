// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            jf, jc, ix, ip, 
//            mp, ig, jd

static final class g.Class
    implements jf
{

    private final ix GH;
    private final ip GI;
    private final mp GL;
    private final boolean GM;
    private final Class GN;

    public final jd create(ig ig, mp mp1)
    {
        boolean flag;
        if (GL != null)
        {
            if (GL.equals(mp1) || GM && GL.Io == mp1.Js)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            flag = GN.isAssignableFrom(mp1.Js);
        }
        if (flag)
        {
            return new jc(GH, GI, ig, mp1, this);
        } else
        {
            return null;
        }
    }

    private g.Class(Object obj, mp mp1, boolean flag, Class class1)
    {
        ix ix1;
        if (obj instanceof ix)
        {
            ix1 = (ix)obj;
        } else
        {
            ix1 = null;
        }
        GH = ix1;
        if (obj instanceof ip)
        {
            obj = (ip)obj;
        } else
        {
            obj = null;
        }
        GI = ((ip) (obj));
        boolean flag1;
        if (GH != null || GI != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        ux.checkArgument(flag1);
        GL = mp1;
        GM = flag;
        GN = class1;
    }

    g.Class(Object obj, mp mp1, boolean flag, Class class1, byte byte0)
    {
        this(obj, mp1, flag, null);
    }
}
