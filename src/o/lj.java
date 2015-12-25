// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

// Referenced classes of package o:
//            lk, me, lv, mg, 
//            mj, mf, mk, ml, 
//            mm, mn, mo, ll, 
//            lm, ln, lo, lp, 
//            lq, lr, ls, lt, 
//            lu, lw, mi, lx, 
//            ly, ma, mh, mb, 
//            mc, iq, md, jf, 
//            jd, ji, mq, ms, 
//            mt

public final class lj
{
    static final class if extends jd
    {

        private final HashMap Jq;
        private final HashMap Jr;

        public final Object read(mq mq1)
        {
            if (mq1._mth13A2() == ms.JO)
            {
                mq1.nextNull();
                return null;
            } else
            {
                return (Enum)Jq.get(mq1.nextString());
            }
        }

        public final void write(mt mt1, Object obj)
        {
            obj = (Enum)obj;
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = (String)Jr.get(obj);
            }
            mt1._mth1421(((String) (obj)));
        }

        public if(Class class1)
        {
            Jq = new HashMap();
            Jr = new HashMap();
            String s;
            Enum aenum[];
            Enum enum;
            ji ji1;
            int i;
            int j;
            try
            {
                aenum = (Enum[])class1.getEnumConstants();
                j = aenum.length;
            }
            // Misplaced declaration of an exception variable
            catch (Class class1)
            {
                throw new AssertionError();
            }
            i = 0;
            if (i >= j)
            {
                break; /* Loop/switch isn't completed */
            }
            enum = aenum[i];
            s = enum.name();
            ji1 = (ji)class1.getField(s).getAnnotation(o/ji);
            if (ji1 == null)
            {
                break MISSING_BLOCK_LABEL_88;
            }
            s = ji1.value();
            Jq.put(s, enum);
            Jr.put(enum, s);
            i++;
            if (true) goto _L2; else goto _L1
_L2:
            break MISSING_BLOCK_LABEL_41;
_L1:
        }
    }


    private static mm IA;
    public static final jf IB;
    public static final mn IC = new mn();
    public static final mo ID = new mo();
    public static final ll IE = new ll();
    private static lm IF;
    public static final jf IG;
    private static ln IH;
    public static final jf II;
    private static lo IJ;
    public static final lp IK = new lp();
    public static final lq IL = new lq();
    public static final jf IM;
    private static lr IN;
    public static final jf IO;
    private static ls IP;
    public static final jf IQ;
    private static lt IR;
    public static final jf IS;
    private static lu IT;
    public static final jf IU;
    private static lw IV;
    public static final jf IW;
    private static lx IX;
    public static final jf IY;
    public static final ly IZ = new ly();
    private static lk Ip;
    public static final jf Iq;
    private static lv Ir;
    public static final jf Is;
    private static mg It;
    public static final mj Iu = new mj();
    public static final jf Iv;
    private static mk Iw;
    public static final jf Ix;
    private static ml Iy;
    public static final jf Iz;
    private static ma Ja;
    public static final jf Jb;
    private static mb Jc;
    public static final jf Jd;
    public static final mc Je;
    public static final jf Jf;
    public static final md Jg = new md();

    public static me _mth02CA(Class class1, jd jd)
    {
        return new me(class1, jd);
    }

    public static mf _mth02CA(Class class1, Class class2, jd jd)
    {
        return new mf(class1, class2, jd);
    }

    static 
    {
        Ip = new lk();
        Iq = new me(java/lang/Class, Ip);
        Ir = new lv();
        Is = new me(java/util/BitSet, Ir);
        It = new mg();
        Iv = new mf(Boolean.TYPE, java/lang/Boolean, It);
        Iw = new mk();
        Ix = new mf(Byte.TYPE, java/lang/Byte, Iw);
        Iy = new ml();
        Iz = new mf(Short.TYPE, java/lang/Short, Iy);
        IA = new mm();
        IB = new mf(Integer.TYPE, java/lang/Integer, IA);
        IF = new lm();
        IG = new me(java/lang/Number, IF);
        IH = new ln();
        II = new mf(Character.TYPE, java/lang/Character, IH);
        IJ = new lo();
        IM = new me(java/lang/String, IJ);
        IN = new lr();
        IO = new me(java/lang/StringBuilder, IN);
        IP = new ls();
        IQ = new me(java/lang/StringBuffer, IP);
        IR = new lt();
        IS = new me(java/net/URL, IR);
        IT = new lu();
        IU = new me(java/net/URI, IT);
        IV = new lw();
        IW = new mi(java/net/InetAddress, IV);
        IX = new lx();
        IY = new me(java/util/UUID, IX);
        Ja = new ma();
        Jb = new mh(java/util/Calendar, java/util/GregorianCalendar, Ja);
        Jc = new mb();
        Jd = new me(java/util/Locale, Jc);
        Je = new mc();
        Jf = new mi(o/iq, Je);
    }

    // Unreferenced inner class o/lj$1

/* anonymous class */
    static final class _cls1
    {

        static final int HZ[];

        static 
        {
            HZ = new int[ms.values().length];
            try
            {
                HZ[ms.JM.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror) { }
            try
            {
                HZ[ms.JN.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                HZ[ms.JL.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                HZ[ms.JO.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                HZ[ms.JG.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                HZ[ms.JI.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                HZ[ms.JP.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                HZ[ms.JK.ordinal()] = 8;
            }
            catch (NoSuchFieldError nosuchfielderror7) { }
            try
            {
                HZ[ms.JJ.ordinal()] = 9;
            }
            catch (NoSuchFieldError nosuchfielderror8) { }
            try
            {
                HZ[ms.JH.ordinal()] = 10;
            }
            catch (NoSuchFieldError nosuchfielderror9) { }
        }
    }

}
