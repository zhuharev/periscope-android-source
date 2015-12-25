// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            jd, mp, ig, is, 
//            ip, mt, ix, jf, 
//            hw, mq

final class jc extends jd
{
    static final class if
        implements jf
    {

        private final ix GH;
        private final ip GI;
        private final mp GL;
        private final boolean GM;
        private final Class GN;

        public final jd create(ig ig1, mp mp1)
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
                return new jc(GH, GI, ig1, mp1, this);
            } else
            {
                return null;
            }
        }

        private if(Object obj, mp mp1, boolean flag, Class class1)
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
            _cls1D10.aux.checkArgument(flag1);
            GL = mp1;
            GM = flag;
            GN = class1;
        }

        if(Object obj, mp mp1, boolean flag, Class class1, byte byte0)
        {
            this(obj, mp1, flag, null);
        }
    }


    private final ix GH;
    private final ip GI;
    private final mp GJ;
    private final jf GK;
    private jd Gq;
    private final ig gson;

    jc(ix ix1, ip ip1, ig ig1, mp mp1, if if1)
    {
        this(ix1, ip1, ig1, mp1, ((jf) (if1)));
    }

    private jc(ix ix1, ip ip1, ig ig1, mp mp1, jf jf)
    {
        GH = ix1;
        GI = ip1;
        gson = ig1;
        GJ = mp1;
        GK = jf;
    }

    public static if _mth02CA(mp mp1, Object obj)
    {
        boolean flag;
        if (mp1.Io == mp1.Js)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return new if(obj, mp1, flag, null, (byte)0);
    }

    public static if _mth02CA(mp mp1, hw hw)
    {
        return new if(hw, mp1, false, null, (byte)0);
    }

    private jd _mth0698()
    {
        jd jd1 = Gq;
        if (jd1 != null)
        {
            return jd1;
        } else
        {
            jd jd2 = gson._mth02CA(GK, GJ);
            Gq = jd2;
            return jd2;
        }
    }

    public final Object read(mq mq)
    {
        if (GI == null)
        {
            return _mth0698().read(mq);
        }
        mq = _cls1D3A._cls02CA._mth02CA(mq);
        if (mq instanceof is)
        {
            return null;
        } else
        {
            return GI.deserialize$140ae884(mq, GJ.Io, gson.Gn);
        }
    }

    public final void write(mt mt1, Object obj)
    {
        if (GH == null)
        {
            _mth0698().write(mt1, obj);
            return;
        }
        if (obj == null)
        {
            mt1._mth14F7();
            return;
        } else
        {
            _cls1D3A._cls02CA._mth02CA(GH.serialize$117eb95b(obj, GJ.Io, gson.Go), mt1);
            return;
        }
    }
}
