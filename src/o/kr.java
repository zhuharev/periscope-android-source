// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package o:
//            jf, mp, jl, ig, 
//            jm, jd, li, mq, 
//            ms, kh, mt

public final class kr
    implements jf
{
    static final class if extends jd
    {

        private final li HJ;
        private final kh HK;

        public final Object read(mq mq1)
        {
            if (mq1._mth13A2() == ms.JO)
            {
                mq1.nextNull();
                return null;
            }
            Collection collection = (Collection)HK._mth0725();
            mq1.beginArray();
            for (; mq1.hasNext(); collection.add(HJ.read(mq1))) { }
            mq1.endArray();
            return collection;
        }

        public final void write(mt mt1, Object obj)
        {
            obj = (Collection)obj;
            if (obj == null)
            {
                mt1._mth14F7();
                return;
            }
            mt1._mth13D0();
            Object obj1;
            for (obj = ((Collection) (obj)).iterator(); ((Iterator) (obj)).hasNext(); HJ.write(mt1, obj1))
            {
                obj1 = ((Iterator) (obj)).next();
            }

            mt1._mth141C();
        }

        public if(ig ig1, Type type, jd jd1, kh kh1)
        {
            HJ = new li(ig1, jd1, type);
            HK = kh1;
        }
    }


    private final jm Gi;

    public kr(jm jm1)
    {
        Gi = jm1;
    }

    public final jd create(ig ig1, mp mp1)
    {
        Type type = mp1.Io;
        Class class1 = mp1.Js;
        if (!java/util/Collection.isAssignableFrom(class1))
        {
            return null;
        } else
        {
            type = jl._mth02CA(type, class1);
            return new if(ig1, type, ig1._mth02CA(new mp(type)), Gi._mth02CB(mp1));
        }
    }
}
