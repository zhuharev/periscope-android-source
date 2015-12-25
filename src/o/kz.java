// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package o:
//            jf, mp, jl, lj, 
//            ig, jm, jd, li, 
//            mq, ms, kh, iy, 
//            kb, mt, io, it, 
//            iq, iw, is

public final class kz
    implements jf
{
    final class if extends jd
    {

        private final kh HK;
        private final li HV;
        private final li HW;
        private kz HX;

        public final Object read(mq mq1)
        {
            ms ms1 = mq1._mth13A2();
            if (ms1 == ms.JO)
            {
                mq1.nextNull();
                return null;
            }
            Map map = (Map)HK._mth0725();
            if (ms1 == ms.JG)
            {
                mq1.beginArray();
                for (; mq1.hasNext(); mq1.endArray())
                {
                    mq1.beginArray();
                    Object obj = HV.read(mq1);
                    if (map.put(obj, HW.read(mq1)) != null)
                    {
                        throw new iy((new StringBuilder("duplicate key: ")).append(obj).toString());
                    }
                }

                mq1.endArray();
                return map;
            }
            mq1.beginObject();
            while (mq1.hasNext()) 
            {
                kb.Hi._mth02CB(mq1);
                Object obj1 = HV.read(mq1);
                if (map.put(obj1, HW.read(mq1)) != null)
                {
                    throw new iy((new StringBuilder("duplicate key: ")).append(obj1).toString());
                }
            }
            mq1.endObject();
            return map;
        }

        public final void write(mt mt1, Object obj)
        {
            obj = (Map)obj;
            if (obj == null)
            {
                mt1._mth14F7();
                return;
            }
            if (!kz._mth02CA(HX))
            {
                mt1._mth14A9();
                java.util.Map.Entry entry;
                for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); HW.write(mt1, entry.getValue()))
                {
                    entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                    mt1._mth141F(String.valueOf(entry.getKey()));
                }

                mt1._mth14F6();
                return;
            }
            boolean flag = false;
            ArrayList arraylist = new ArrayList(((Map) (obj)).size());
            ArrayList arraylist1 = new ArrayList(((Map) (obj)).size());
            for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext();)
            {
                java.util.Map.Entry entry1 = (java.util.Map.Entry)((Iterator) (obj)).next();
                iq iq1 = HV.toJsonTree(entry1.getKey());
                arraylist.add(iq1);
                arraylist1.add(entry1.getValue());
                boolean flag1;
                if ((iq1 instanceof io) || (iq1 instanceof it))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                flag |= flag1;
            }

            if (flag)
            {
                mt1._mth13D0();
                for (int i = 0; i < arraylist.size(); i++)
                {
                    mt1._mth13D0();
                    _cls1D3A._cls02CA._mth02CA((iq)arraylist.get(i), mt1);
                    HW.write(mt1, arraylist1.get(i));
                    mt1._mth141C();
                }

                mt1._mth141C();
                return;
            }
            mt1._mth14A9();
            for (int j = 0; j < arraylist.size(); j++)
            {
                obj = (iq)arraylist.get(j);
                if (obj instanceof iw)
                {
                    if (obj instanceof iw)
                    {
                        obj = (iw)obj;
                    } else
                    {
                        throw new IllegalStateException("This is not a JSON Primitive.");
                    }
                    if (((iw) (obj)).value instanceof Number)
                    {
                        obj = String.valueOf(((iw) (obj))._mth04AD());
                    } else
                    if (((iw) (obj)).value instanceof Boolean)
                    {
                        obj = Boolean.toString(((iw) (obj))._mth0672());
                    } else
                    if (((iw) (obj)).value instanceof String)
                    {
                        obj = ((iw) (obj))._mth04AE();
                    } else
                    {
                        throw new AssertionError();
                    }
                } else
                if (obj instanceof is)
                {
                    obj = "null";
                } else
                {
                    throw new AssertionError();
                }
                mt1._mth141F(((String) (obj)));
                HW.write(mt1, arraylist1.get(j));
            }

            mt1._mth14F6();
        }

        public if(ig ig1, Type type, jd jd1, Type type1, jd jd2, kh kh1)
        {
            HX = kz.this;
            super();
            HV = new li(ig1, jd1, type);
            HW = new li(ig1, jd2, type1);
            HK = kh1;
        }
    }


    private final jm Gi;
    private final boolean HU;

    public kz(jm jm1, boolean flag)
    {
        Gi = jm1;
        HU = flag;
    }

    static boolean _mth02CA(kz kz1)
    {
        return kz1.HU;
    }

    public final jd create(ig ig1, mp mp1)
    {
        Object obj = mp1.Io;
        if (!java/util/Map.isAssignableFrom(mp1.Js))
        {
            return null;
        }
        Type atype[] = jl._mth02CB(((Type) (obj)), jl.getRawType(((Type) (obj))));
        obj = atype[0];
        if (obj == Boolean.TYPE || obj == java/lang/Boolean)
        {
            obj = lj.Iu;
        } else
        {
            obj = ig1._mth02CA(new mp(((Type) (obj))));
        }
        jd jd = ig1._mth02CA(new mp(atype[1]));
        mp1 = Gi._mth02CB(mp1);
        return new if(ig1, atype[0], ((jd) (obj)), atype[1], jd, mp1);
    }
}
