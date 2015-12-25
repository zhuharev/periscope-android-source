// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

// Referenced classes of package o:
//            aug, wr, aud

public abstract class auf
    implements Serializable
{
    public static abstract class if
    {

        public abstract aud gG();

        public abstract aud.if _mth0140(int i);

        public abstract aud.if _mth02CA(Double double1);

        public abstract aud.if _mth02CB(Double double1);

        public abstract aud.if _mth02CB(Integer integer);

        public abstract aud.if _mth02CB(Long long1);

        public abstract aud.if _mth02CB(aug aug1);

        public abstract aud.if _mth02CE(Double double1);

        public abstract aud.if _mth02CE(Integer integer);

        public abstract aud.if _mth02CF(Integer integer);

        public abstract aud.if _mth0407(String s);

        public abstract aud.if _mth0433(String s);

        public abstract aud.if _mth0630(String s);

        public abstract aud.if _mth0640(BigInteger biginteger);

        public abstract aud.if _mth068A(String s);

        public abstract aud.if _mth0719(String s);

        public abstract aud.if _mth0E07(String s);

        public abstract aud.if _mth0E27(String s);

        public abstract aud.if _mth1426(String s);

        public abstract aud.if _mth1427(BigInteger biginteger);

        public abstract aud.if _mth1484(String s);

        public abstract aud.if _mth14BC(String s);

        public abstract aud.if _mth14D1(String s);

        public abstract aud.if _mth1506(String s);

        public abstract aud.if _mth1D16(String s);

        public abstract aud.if _mth1D2C(String s);

        public abstract aud.if _mth1D31(String s);

        public if()
        {
        }
    }


    public auf()
    {
    }

    public static auf _mth02CA(String s, long l, long l1)
    {
        aud.if if1 = new aud.if();
        if1.bEx = Integer.valueOf(0);
        return if1._mth02CB(Integer.valueOf(2))._mth02CB(aug.bED)._mth0407(s)._mth0640(_mth1420(l))._mth0640(_mth1420(l1))._mth0630(UUID.randomUUID().toString())._mth02CB(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()))).gG();
    }

    public static auf _mth02CA(String s, long l, long l1, Double double1, Double double2)
    {
        aud.if if1 = new aud.if();
        if1.bEx = Integer.valueOf(0);
        return if1._mth02CB(Integer.valueOf(2))._mth02CB(aug.bEC)._mth0407(s)._mth0640(_mth1420(l))._mth1427(_mth1420(l1))._mth0630(UUID.randomUUID().toString())._mth02CB(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())))._mth02CB(double1)._mth02CE(double2).gG();
    }

    public static auf _mth02CA(String s, String s1, Integer integer, long l, long l1)
    {
        aud.if if1 = new aud.if();
        if1.bEx = Integer.valueOf(0);
        return if1._mth02CB(Integer.valueOf(2))._mth02CB(aug.bEA)._mth0407(s)._mth0433(s1)._mth02CE(integer)._mth0640(_mth1420(l))._mth0630(UUID.randomUUID().toString())._mth02CB(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())))._mth1427(_mth1420(l1)).gG();
    }

    public static auf _mth02CA(String s, String s1, String s2, String s3, int i, long l, long l1)
    {
        aud.if if1 = new aud.if();
        if1.bEx = Integer.valueOf(0);
        return if1._mth02CB(Integer.valueOf(2))._mth02CB(aug.bEO)._mth0407(s)._mth0640(_mth1420(l))._mth02CB(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())))._mth0433(s3)._mth0719(s1)._mth0E07(s2)._mth0630(UUID.randomUUID().toString())._mth02CE(Integer.valueOf(i))._mth1427(_mth1420(l1)).gG();
    }

    public static auf _mth02CA(String s, String s1, String s2, String s3, String s4, String s5, Integer integer, long l, long l1)
    {
        aud.if if1 = new aud.if();
        if1.bEx = Integer.valueOf(0);
        return if1._mth02CB(Integer.valueOf(2))._mth02CB(aug.bEB)._mth0407(s)._mth0433(s4)._mth02CE(integer)._mth0640(_mth1420(l))._mth0630(UUID.randomUUID().toString())._mth02CB(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())))._mth0719(s1)._mth0E07(s2)._mth0E27(s3)._mth1426(s5)._mth1427(_mth1420(l1)).gG();
    }

    public static auf _mth02CA(String s, String s1, String s2, String s3, String s4, String s5, String s6, Integer integer, 
            long l, long l1)
    {
        aud.if if1 = new aud.if();
        if1.bEx = Integer.valueOf(0);
        s = if1._mth02CB(Integer.valueOf(2))._mth02CB(aug.bEz)._mth0407(s)._mth0433(s5)._mth02CE(integer);
        s5 = wr._mth05D9(l);
        s = s._mth0640(BigInteger.valueOf(((wr) (s5)).VE >>> 32 & 0xffffffffL).multiply(BigInteger.valueOf(0x100000000L)).add(BigInteger.valueOf(((wr) (s5)).VE & 0xffffffffL)))._mth0630(UUID.randomUUID().toString())._mth02CB(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())))._mth0719(s2)._mth0E07(s3)._mth0E27(s4)._mth1426(s6)._mth1484(s1);
        s1 = wr._mth05D9(l1);
        return s._mth1427(BigInteger.valueOf(((wr) (s1)).VE >>> 32 & 0xffffffffL).multiply(BigInteger.valueOf(0x100000000L)).add(BigInteger.valueOf(((wr) (s1)).VE & 0xffffffffL))).gG();
    }

    public static BigInteger _mth1420(long l)
    {
        wr wr1 = wr._mth05D9(l);
        return BigInteger.valueOf(wr1.VE >>> 32 & 0xffffffffL).multiply(BigInteger.valueOf(0x100000000L)).add(BigInteger.valueOf(wr1.VE & 0xffffffffL));
    }

    public abstract String displayName();

    public abstract String eI();

    public abstract String fd();

    public abstract String fi();

    public abstract String fx();

    public abstract String gA();

    public abstract BigInteger gB();

    public abstract String gC();

    public abstract String gD();

    public abstract String gE();

    public abstract int gF();

    public abstract String gj();

    public abstract Integer gn();

    public abstract aug go();

    public abstract Integer gp();

    public abstract BigInteger gq();

    public abstract Long gr();

    public abstract String gs();

    public abstract String gt();

    public abstract Double gu();

    public abstract Double gv();

    public abstract Double gw();

    public abstract Integer gx();

    public abstract String gy();

    public abstract String gz();

    public abstract String _mth1F35();
}
