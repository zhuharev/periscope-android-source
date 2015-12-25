// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package o:
//            jf, mp, ka, jj, 
//            jk, ig, jd

public final class jz
    implements jf, Cloneable
{

    public static final jz GX = new jz();
    public double GY;
    public int GZ;
    public boolean Ha;
    public List Hb;
    public List Hc;

    public jz()
    {
        GY = -1D;
        GZ = 136;
        Ha = true;
        Hb = Collections.emptyList();
        Hc = Collections.emptyList();
    }

    public static boolean _mth02CF(Class class1)
    {
        return !java/lang/Enum.isAssignableFrom(class1) && (class1.isAnonymousClass() || class1.isLocalClass());
    }

    private jz _mth09A7()
    {
        CloneNotSupportedException clonenotsupportedexception;
        jz jz1;
        try
        {
            jz1 = (jz)super.clone();
        }
        // Misplaced declaration of an exception variable
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            throw new AssertionError();
        }
        return jz1;
    }

    protected final Object clone()
    {
        return _mth09A7();
    }

    public final jd create(ig ig, mp mp1)
    {
        Class class1 = mp1.Js;
        boolean flag = _mth02CA(class1, true);
        boolean flag1 = _mth02CA(class1, false);
        if (!flag && !flag1)
        {
            return null;
        } else
        {
            return new ka(this, flag1, flag, ig, mp1);
        }
    }

    public final boolean _mth02CA(Class class1, boolean flag)
    {
label0:
        {
            boolean flag1;
label1:
            {
                if (GY == -1D)
                {
                    break label0;
                }
                jj jj1 = (jj)class1.getAnnotation(o/jj);
                jk jk1 = (jk)class1.getAnnotation(o/jk);
                if (jj1 != null && jj1._mth06BA() > GY)
                {
                    flag1 = false;
                } else
                {
                    flag1 = true;
                }
                if (flag1)
                {
                    if (jk1 != null && jk1._mth06BA() <= GY)
                    {
                        flag1 = false;
                    } else
                    {
                        flag1 = true;
                    }
                    if (flag1)
                    {
                        flag1 = true;
                        break label1;
                    }
                }
                flag1 = false;
            }
            if (!flag1)
            {
                return true;
            }
        }
label2:
        {
            boolean flag2;
label3:
            {
                if (Ha)
                {
                    break label2;
                }
                if (class1.isMemberClass())
                {
                    if ((class1.getModifiers() & 8) != 0)
                    {
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                    if (!flag2)
                    {
                        flag2 = true;
                        break label3;
                    }
                }
                flag2 = false;
            }
            if (flag2)
            {
                return true;
            }
        }
        boolean flag3;
        if (!java/lang/Enum.isAssignableFrom(class1) && (class1.isAnonymousClass() || class1.isLocalClass()))
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if (flag3)
        {
            return true;
        }
        if (flag)
        {
            class1 = Hb;
        } else
        {
            class1 = Hc;
        }
        for (class1 = class1.iterator(); class1.hasNext();)
        {
            if (((_cls1427.if)class1.next())._mth1428())
            {
                return true;
            }
        }

        return false;
    }

    public boolean _mth02CA(jj jj1, jk jk1)
    {
        boolean flag;
        if (jj1 != null && jj1._mth06BA() > GY)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (flag)
        {
            boolean flag1;
            if (jk1 != null && jk1._mth06BA() <= GY)
            {
                flag1 = false;
            } else
            {
                flag1 = true;
            }
            if (flag1)
            {
                return true;
            }
        }
        return false;
    }

    public boolean _mth141D(Class class1)
    {
        if (class1.isMemberClass())
        {
            boolean flag;
            if ((class1.getModifiers() & 8) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                return true;
            }
        }
        return false;
    }

}
