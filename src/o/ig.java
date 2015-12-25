// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package o:
//            jz, hy, iz, ih, 
//            ii, jm, lj, la, 
//            il, ij, ik, ks, 
//            lg, le, kp, kr, 
//            kz, ku, lc, mq, 
//            mp, jd, iy, mt, 
//            ir, mu, ms, ki, 
//            kv, jf, ie, iq, 
//            is

public final class ig
{
    static final class if extends jd
    {

        jd Gq;

        public final Object read(mq mq1)
        {
            if (Gq == null)
            {
                throw new IllegalStateException();
            } else
            {
                return Gq.read(mq1);
            }
        }

        public final void write(mt mt1, Object obj)
        {
            if (Gq == null)
            {
                throw new IllegalStateException();
            } else
            {
                Gq.write(mt1, obj);
                return;
            }
        }

        if()
        {
        }
    }


    private final ThreadLocal Gf;
    private final Map Gg;
    private final List Gh;
    private final jm Gi;
    private final boolean Gj;
    private final boolean Gk;
    private final boolean Gl;
    private final boolean Gm;
    final ih Gn;
    final ii Go;

    public ig()
    {
        this(jz.GX, ((ie) (hy.FZ)), Collections.emptyMap(), false, false, false, true, false, false, ((iz) (iz.GE)), Collections.emptyList());
    }

    ig(jz jz1, ie ie, Map map, boolean flag, boolean flag1, boolean flag2, boolean flag3, 
            boolean flag4, boolean flag5, iz iz1, List list)
    {
        Gf = new ThreadLocal();
        Gg = Collections.synchronizedMap(new HashMap());
        Gn = new ih(this);
        Go = new ii(this);
        Gi = new jm(map);
        Gj = flag;
        Gl = flag2;
        Gk = flag3;
        Gm = flag4;
        ArrayList arraylist = new ArrayList();
        arraylist.add(lj.Jf);
        arraylist.add(la.HY);
        arraylist.add(jz1);
        arraylist.addAll(list);
        arraylist.add(lj.IM);
        arraylist.add(lj.IB);
        arraylist.add(lj.Iv);
        arraylist.add(lj.Ix);
        arraylist.add(lj.Iz);
        list = Long.TYPE;
        if (iz1 == iz.GE)
        {
            map = lj.IC;
        } else
        {
            map = new il(this);
        }
        arraylist.add(lj._mth02CA(list, java/lang/Long, map));
        iz1 = Double.TYPE;
        if (flag5)
        {
            map = lj.IE;
        } else
        {
            map = new ij(this);
        }
        arraylist.add(lj._mth02CA(iz1, java/lang/Double, map));
        iz1 = Float.TYPE;
        if (flag5)
        {
            map = lj.ID;
        } else
        {
            map = new ik(this);
        }
        arraylist.add(lj._mth02CA(iz1, java/lang/Float, map));
        arraylist.add(lj.IG);
        arraylist.add(lj.II);
        arraylist.add(lj.IO);
        arraylist.add(lj.IQ);
        arraylist.add(lj._mth02CA(java/math/BigDecimal, lj.IK));
        arraylist.add(lj._mth02CA(java/math/BigInteger, lj.IL));
        arraylist.add(lj.IS);
        arraylist.add(lj.IU);
        arraylist.add(lj.IY);
        arraylist.add(lj.Jd);
        arraylist.add(lj.IW);
        arraylist.add(lj.Is);
        arraylist.add(ks.HL);
        arraylist.add(lj.Jb);
        arraylist.add(lg.Im);
        arraylist.add(le.Ik);
        arraylist.add(lj.IZ);
        arraylist.add(kp.HG);
        arraylist.add(lj.Iq);
        arraylist.add(new kr(Gi));
        arraylist.add(new kz(Gi, flag1));
        arraylist.add(new ku(Gi));
        arraylist.add(lj.Jg);
        arraylist.add(new lc(Gi, ie, jz1));
        Gh = Collections.unmodifiableList(arraylist);
    }

    private Object _mth02CA(mq mq1, Type type)
    {
        boolean flag;
        boolean flag1;
        flag = true;
        flag1 = mq1.Ju;
        mq1.Ju = true;
        mq1._mth13A2();
        flag = false;
        type = ((Type) (_mth02CA(new mp(type)).read(mq1)));
        mq1.Ju = flag1;
        return type;
        type;
        if (flag)
        {
            mq1.Ju = flag1;
            return null;
        }
        throw new iy(type);
        type;
        throw new iy(type);
        type;
        throw new iy(type);
        type;
        mq1.Ju = flag1;
        throw type;
    }

    private mt _mth02CA(Writer writer)
    {
        if (Gl)
        {
            writer.write(")]}'\n");
        }
        writer = new mt(writer);
        if (Gm)
        {
            writer.setIndent("  ");
        }
        writer.Gj = Gj;
        return writer;
    }

    private void _mth02CA(Object obj, Type type, StringWriter stringwriter)
    {
        try
        {
            _mth02CA(obj, type, _mth02CA(_cls1D3A._cls02CA._mth02CA(stringwriter)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new ir(((Exception) (obj)));
        }
    }

    private static void _mth02CA(Object obj, mq mq1)
    {
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        if (mq1._mth13A2() != ms.JP)
        {
            throw new ir("JSON document was not fully consumed.");
        }
        return;
        obj;
        throw new iy(((Exception) (obj)));
        obj;
        throw new ir(((Exception) (obj)));
    }

    static void _mth02CA(ig ig1, double d)
    {
        if (Double.isNaN(d) || Double.isInfinite(d))
        {
            throw new IllegalArgumentException((new StringBuilder()).append(d).append(" is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.").toString());
        } else
        {
            return;
        }
    }

    private void _mth02CB(iq iq, mt mt1)
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        flag = mt1.Ju;
        mt1.Ju = true;
        flag1 = mt1.Gk;
        mt1.Gk = Gk;
        flag2 = mt1.Gj;
        mt1.Gj = Gj;
        _cls1D3A._cls02CA._mth02CA(iq, mt1);
        mt1.Ju = flag;
        mt1.Gk = flag1;
        mt1.Gj = flag2;
        return;
        iq;
        throw new ir(iq);
        iq;
        mt1.Ju = flag;
        mt1.Gk = flag1;
        mt1.Gj = flag2;
        throw iq;
    }

    public final String toString()
    {
        return (new StringBuilder("{serializeNulls:")).append(Gj).append("factories:").append(Gh).append(",instanceCreators:").append(Gi).append("}").toString();
    }

    public final Object _mth02CA(Reader reader, Type type)
    {
        reader = new mq(reader);
        type = ((Type) (_mth02CA(((mq) (reader)), type)));
        _mth02CA(type, ((mq) (reader)));
        return type;
    }

    public final Object _mth02CA(String s, Class class1)
    {
        if (s == null)
        {
            s = null;
        } else
        {
            s = ((String) (_mth02CA(((Reader) (new StringReader(s))), ((Type) (class1)))));
        }
        return ki._mth02BC(class1).cast(s);
    }

    public final Object _mth02CA(iq iq, Class class1)
    {
        if (iq == null)
        {
            iq = null;
        } else
        {
            iq = ((iq) (_mth02CA(((mq) (new kv(iq))), ((Type) (class1)))));
        }
        return ki._mth02BC(class1).cast(iq);
    }

    public final String _mth02CA(Object obj, Class class1)
    {
        StringWriter stringwriter = new StringWriter();
        _mth02CA(obj, ((Type) (class1)), stringwriter);
        return stringwriter.toString();
    }

    public final String _mth02CA(is is)
    {
        StringWriter stringwriter = new StringWriter();
        try
        {
            _mth02CB(is, _mth02CA(_cls1D3A._cls02CA._mth02CA(stringwriter)));
        }
        // Misplaced declaration of an exception variable
        catch (is is)
        {
            throw new RuntimeException(is);
        }
        return stringwriter.toString();
    }

    public final jd _mth02CA(jf jf1, mp mp1)
    {
        boolean flag = false;
        if (!Gh.contains(jf1))
        {
            flag = true;
        }
        for (Iterator iterator = Gh.iterator(); iterator.hasNext();)
        {
            Object obj = (jf)iterator.next();
            if (!flag)
            {
                if (obj == jf1)
                {
                    flag = true;
                }
            } else
            {
                obj = ((jf) (obj)).create(this, mp1);
                if (obj != null)
                {
                    return ((jd) (obj));
                }
            }
        }

        throw new IllegalArgumentException((new StringBuilder("GSON cannot serialize ")).append(mp1).toString());
    }

    public final jd _mth02CA(mp mp1)
    {
        Object obj;
        boolean flag;
        obj = (jd)Gg.get(mp1);
        if (obj != null)
        {
            return ((jd) (obj));
        }
        Object obj1 = (Map)Gf.get();
        flag = false;
        obj = obj1;
        if (obj1 == null)
        {
            obj = new HashMap();
            Gf.set(obj);
            flag = true;
        }
        obj1 = (if)((Map) (obj)).get(mp1);
        if (obj1 != null)
        {
            return ((jd) (obj1));
        }
        if if1;
        Iterator iterator;
        if1 = new if();
        ((Map) (obj)).put(mp1, if1);
        iterator = Gh.iterator();
        jd jd1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_198;
            }
            jd1 = ((jf)iterator.next()).create(this, mp1);
        } while (jd1 == null);
        if (if1.Gq != null)
        {
            throw new AssertionError();
        }
        if1.Gq = jd1;
        Gg.put(mp1, jd1);
        ((Map) (obj)).remove(mp1);
        if (flag)
        {
            Gf.remove();
        }
        return jd1;
        throw new IllegalArgumentException((new StringBuilder("GSON cannot handle ")).append(mp1).toString());
        Exception exception;
        exception;
        ((Map) (obj)).remove(mp1);
        if (flag)
        {
            Gf.remove();
        }
        throw exception;
    }

    public final void _mth02CA(Object obj, Type type, mt mt1)
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        type = _mth02CA(new mp(type));
        flag = mt1.Ju;
        mt1.Ju = true;
        flag1 = mt1.Gk;
        mt1.Gk = Gk;
        flag2 = mt1.Gj;
        mt1.Gj = Gj;
        type.write(mt1, obj);
        mt1.Ju = flag;
        mt1.Gk = flag1;
        mt1.Gj = flag2;
        return;
        obj;
        throw new ir(((Exception) (obj)));
        obj;
        mt1.Ju = flag;
        mt1.Gk = flag1;
        mt1.Gj = flag2;
        throw obj;
    }
}
