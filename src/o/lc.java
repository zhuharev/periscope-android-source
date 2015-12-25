// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package o:
//            jf, mp, jl, ji, 
//            ie, ld, ki, jh, 
//            ku, ig, jz, jj, 
//            jk, hx, jm, jd, 
//            mq, ms, kh, iy, 
//            mt

public final class lc
    implements jf
{
    public static final class if extends jd
    {

        private final kh HK;
        private final Map Ih;

        public final Object read(mq mq1)
        {
            Object obj;
            if (mq1._mth13A2() == ms.JO)
            {
                mq1.nextNull();
                return null;
            }
            obj = HK._mth0725();
            mq1.beginObject();
_L1:
            Object obj1;
            if (!mq1.hasNext())
            {
                break MISSING_BLOCK_LABEL_106;
            }
            obj1 = mq1.nextName();
            obj1 = (_cls02CA)Ih.get(obj1);
            if (obj1 == null)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            if (((_cls02CA) (obj1)).Ij)
            {
                break MISSING_BLOCK_LABEL_74;
            }
            mq1.skipValue();
              goto _L1
            try
            {
                ((_cls02CA) (obj1))._mth02CA(mq1, obj);
            }
            // Misplaced declaration of an exception variable
            catch (mq mq1)
            {
                throw new iy(mq1);
            }
            // Misplaced declaration of an exception variable
            catch (mq mq1)
            {
                throw new AssertionError(mq1);
            }
              goto _L1
            mq1.endObject();
            return obj;
        }

        public final void write(mt mt1, Object obj)
        {
            if (obj == null)
            {
                mt1._mth14F7();
                return;
            }
            mt1._mth14A9();
            try
            {
                Iterator iterator = Ih.values().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    _cls02CA _lcls02ca = (_cls02CA)iterator.next();
                    if (_lcls02ca._mth1423(obj))
                    {
                        mt1._mth141F(_lcls02ca.name);
                        _lcls02ca.write(mt1, obj);
                    }
                } while (true);
            }
            // Misplaced declaration of an exception variable
            catch (mt mt1)
            {
                throw new AssertionError();
            }
            mt1._mth14F6();
        }

        private if(kh kh1, Map map)
        {
            HK = kh1;
            Ih = map;
        }

        if(kh kh1, Map map, byte byte0)
        {
            this(kh1, map);
        }
    }

    /* member class not found */
    class _cls02CA {}


    private final jm Gi;
    private final jz Gr;
    private final ie Ia;

    public lc(jm jm1, ie ie1, jz jz1)
    {
        Gi = jm1;
        Ia = ie1;
        Gr = jz1;
    }

    private LinkedHashMap _mth02CA(ig ig1, mp mp1, Class class1)
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        if (class1.isInterface())
        {
            return linkedhashmap;
        }
        java.lang.reflect.Type type = mp1.Io;
        for (; class1 != java/lang/Object; class1 = ((mp) (class1)).Js)
        {
            Field afield[] = class1.getDeclaredFields();
            int j = afield.length;
            for (int i = 0; i < j; i++)
            {
                Field field = afield[i];
                boolean flag = _mth02CA(field, true);
                boolean flag1 = _mth02CA(field, false);
                if (!flag && !flag1)
                {
                    continue;
                }
                field.setAccessible(true);
                Object obj1 = jl.resolve(mp1.Io, class1, field.getGenericType());
                Object obj = Ia;
                ji ji1 = (ji)field.getAnnotation(o/ji);
                if (ji1 == null)
                {
                    obj = ((ie) (obj))._mth02CA(field);
                } else
                {
                    obj = ji1.value();
                }
                obj1 = new mp(((java.lang.reflect.Type) (obj1)));
                obj = new ld(this, ((String) (obj)), flag, flag1, ig1, field, ((mp) (obj1)), ki._mth02BB(((mp) (obj1)).Js));
                obj = (_cls02CA)linkedhashmap.put(((_cls02CA) (obj)).name, obj);
                if (obj != null)
                {
                    throw new IllegalArgumentException((new StringBuilder()).append(type).append(" declares multiple JSON fields named ").append(((_cls02CA) (obj)).name).toString());
                }
            }

            class1 = new mp(jl.resolve(mp1.Io, class1, class1.getGenericSuperclass()));
            mp1 = class1;
        }

        return linkedhashmap;
    }

    static jd _mth02CA(lc lc1, ig ig1, Field field, mp mp1)
    {
        field = (jh)field.getAnnotation(o/jh);
        if (field != null)
        {
            lc1 = ku._mth02CA(lc1.Gi, ig1, mp1, field);
            if (lc1 != null)
            {
                return lc1;
            }
        }
        return ig1._mth02CA(mp1);
    }

    private boolean _mth02CA(Field field, boolean flag)
    {
label0:
        {
            boolean flag1;
label1:
            {
label2:
                {
                    Object obj = Gr;
                    if (((jz) (obj))._mth02CA(field.getType(), flag))
                    {
                        break label0;
                    }
                    if ((((jz) (obj)).GZ & field.getModifiers()) != 0)
                    {
                        flag1 = true;
                        break label1;
                    }
                    if (((jz) (obj)).GY != -1D && !((jz) (obj))._mth02CA((jj)field.getAnnotation(o/jj), (jk)field.getAnnotation(o/jk)))
                    {
                        flag1 = true;
                        break label1;
                    }
                    if (field.isSynthetic())
                    {
                        flag1 = true;
                        break label1;
                    }
                    if (!((jz) (obj)).Ha && ((jz) (obj))._mth141D(field.getType()))
                    {
                        flag1 = true;
                        break label1;
                    }
                    if (jz._mth02CF(field.getType()))
                    {
                        flag1 = true;
                        break label1;
                    }
                    if (flag)
                    {
                        obj = ((jz) (obj)).Hb;
                    } else
                    {
                        obj = ((jz) (obj)).Hc;
                    }
                    if (((List) (obj)).isEmpty())
                    {
                        break label2;
                    }
                    new hx(field);
                    field = ((List) (obj)).iterator();
                    do
                    {
                        if (!field.hasNext())
                        {
                            break label2;
                        }
                    } while (!((_cls1427.if)field.next())._mth1427());
                    flag1 = true;
                    break label1;
                }
                flag1 = false;
            }
            if (!flag1)
            {
                return true;
            }
        }
        return false;
    }

    public final jd create(ig ig1, mp mp1)
    {
        Class class1 = mp1.Js;
        if (!java/lang/Object.isAssignableFrom(class1))
        {
            return null;
        } else
        {
            return new if(Gi._mth02CB(mp1), _mth02CA(ig1, mp1, class1), (byte)0);
        }
    }
}
