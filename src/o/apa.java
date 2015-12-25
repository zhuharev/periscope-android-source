// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.net.URI;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

// Referenced classes of package o:
//            apc, ape, FF6A, api, 
//            apg, apd, _cls028B, aoy, 
//            aaf

public final class apa
    implements ape.if
{
    public static interface if
    {

        public abstract void onClose();

        public abstract void onShutdown();

        public abstract boolean _mth02CA(apg apg1);

        public abstract void _mth309D(int i);
    }

    /* member class not found */
    class _cls02CA {}


    private String bwE;
    private int bwF;
    private String bwG;
    public String bwI;
    private int bxA;
    public int bxB;
    private long bxC;
    private long bxD;
    public long bxE;
    public boolean bxF;
    private apc bxG;
    public String bxH;
    public boolean bxI;
    private int bxJ;
    public api bxm;
    private if bxq;
    public ape bxr;
    private String bxs;
    public String bxt;
    private byte bxu[];
    private long bxv;
    private LinkedList bxw;
    private int bxx;
    private int bxy;
    private int bxz;

    public apa()
    {
        bxx = 0;
        bxy = 0;
        bxz = 0;
        bxC = 0L;
        bxD = 0L;
        bxE = 0L;
        bxF = false;
        bxG = new apc();
        bxH = "";
        bxI = false;
    }

    private void dN()
    {
        boolean flag1 = false;
        bxI = false;
        boolean flag;
        if ("rtmps".equalsIgnoreCase(bxs))
        {
            flag = true;
        } else
        if ("psps".equalsIgnoreCase(bxs))
        {
            bxI = true;
            flag = true;
        } else
        {
            flag = flag1;
            if ("psp".equalsIgnoreCase(bxs))
            {
                bxI = true;
                flag = flag1;
            }
        }
        bxr = new ape();
        bxr._mth02CA(bwE, bwF, flag, this);
    }

    public static void _mth02BB(long l, byte abyte0[], int i)
    {
        abyte0[i] = (byte)(int)((l >> 24) % 256L);
        abyte0[i + 1] = (byte)(int)((l >> 16) % 256L);
        abyte0[i + 2] = (byte)(int)((l >> 8) % 256L);
        abyte0[i + 3] = (byte)(int)(l % 256L);
    }

    public final void dZ()
    {
        bxw = new LinkedList();
        if (bxI)
        {
            FF6A._mth02CB("RTMP", "Using PSP");
            bxr.send(new byte[] {
                4, 1, 0, 0
            }, 0, 4);
            bxm = new api(bxr);
            bxA = 2;
            bxz = 1;
            bxB = 1;
            bxJ = _cls02CA.bxQ;
            bxq._mth309D(bxB);
            return;
        } else
        {
            bxr.send(new byte[] {
                3
            }, 0, 1);
            bxu = new byte[1536];
            (new Random()).nextBytes(bxu);
            Arrays.fill(bxu, 0, 8, (byte)0);
            bxv = System.currentTimeMillis();
            bxJ = _cls02CA.bxM;
            bxz = 1;
            bxr.send(bxu, 0, bxu.length);
            return;
        }
    }

    public final void ea()
    {
        FF6A._mth02CB("RTMP", "Close stream");
        if (bxJ != _cls02CA.bxR)
        {
            bxq.onClose();
        }
    }

    public final void shutdown()
    {
        this;
        JVM INSTR monitorenter ;
        if (bxJ == _cls02CA.bxQ)
        {
            bxJ = _cls02CA.bxR;
            _mth02BB("deleteStream", new Object[] {
                null, Integer.valueOf(bxB)
            });
        }
        bxr.shutdown();
        bxq.onShutdown();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void _mth02BB(String s, Object aobj[])
    {
        apg apg1 = new apg(20, 3, bxB);
        Object aobj1[] = new Object[aobj.length + 2];
        aobj1[0] = s;
        int i = bxA + 1;
        bxA = i;
        aobj1[1] = Integer.valueOf(i);
        System.arraycopy(((Object) (aobj)), 0, ((Object) (aobj1)), 2, aobj.length);
        apg1.byz = aobj1;
        apg1.byA = new apd(_cls028B._mth02CB(aobj1));
        _mth02CF(apg1);
    }

    public final void _mth02CA(String s, String s1, int i, String s2, String s3, String s4, if if1)
    {
        bxq = if1;
        bxs = s;
        bwE = s1;
        bwF = i;
        bwG = s2;
        bxt = s3;
        bwI = (new StringBuilder("t=")).append(s4).toString();
        dN();
    }

    public final void _mth02CA(String s, aaf aaf)
    {
        bxq = aaf;
        s = new URI(s);
        bxs = s.getScheme();
        bwE = s.getHost();
        bwF = s.getPort();
        bwI = s.getQuery();
        aaf = s.getPath();
        s = aaf;
        int i;
        if (aaf.charAt(0) == '/')
        {
            s = aaf.substring(1);
        }
        i = s.indexOf('/');
        if (i <= 0)
        {
            return;
        }
        try
        {
            bwG = s.substring(0, i);
            bxt = s.substring(i + 1);
            dN();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        return;
    }

    public final void _mth02CA(apd apd1)
    {
        bxw.add(apd1);
        bxx = bxx + apd1.length;
        if (bxD > 0L && (long)bxx - bxC > bxD)
        {
            bxC = bxx;
            apd1 = new byte[4];
            _mth02BB(bxC, apd1, 0);
            apg apg1 = new apg(3, 2, 0);
            apg1.byA = new apd(apd1);
            _mth02CF(apg1);
        }
label0:
        do
        {
            Object obj;
label1:
            {
                int i = bxz;
                if (i > bxx)
                {
                    apd1 = null;
                } else
                {
                    apd1 = bxG.FE98(i);
                    do
                    {
                        if (apd1 == null || i <= 0)
                        {
                            break;
                        }
                        apd apd2 = (apd)bxw.get(0);
                        int k1 = apd2.length - bxy;
                        int i1 = k1;
                        if (k1 > i)
                        {
                            i1 = i;
                        }
                        apd1._mth02C6(apd2.buffer, bxy, i1);
                        bxy = bxy + i1;
                        bxx = bxx - i1;
                        i -= i1;
                        if (bxy >= apd2.length)
                        {
                            bxw.remove(0);
                            bxr.bxG._mth02CB(apd2);
                            bxy = 0;
                        }
                    } while (true);
                }
                if (apd1 == null)
                {
                    break label0;
                }
                static final class _cls1
                {

                    static final int bxK[];

                    static 
                    {
                        bxK = new int[_cls02CA.eb().length];
                        int ai[];
                        int l2;
                        try
                        {
                            ai = bxK;
                            int k2 = _cls02CA.bxM;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            continue; /* Loop/switch isn't completed */
                        }
                        ai[1] = 1;
_L4:
                        ai = bxK;
                        l2 = _cls02CA.bxN;
                        ai[2] = 2;
_L2:
                        ai = bxK;
                        l2 = _cls02CA.bxO;
                        ai[3] = 3;
                        break MISSING_BLOCK_LABEL_55;
                        NoSuchFieldError nosuchfielderror1;
                        nosuchfielderror1;
                        if (true) goto _L2; else goto _L1
_L1:
                        nosuchfielderror1;
                        if (true) goto _L4; else goto _L3
_L3:
                    }
                }

                switch (_cls1.bxK[bxJ - 1])
                {
                case 1: // '\001'
                    if (apd1.buffer[0] != 3)
                    {
                        FF6A._mth02CB("RTMP", (new StringBuilder("Invalid version ")).append(apd1.buffer[0]).toString());
                        if (apd1.buffer[0] == 72 && bwF == 80)
                        {
                            FF6A._mth02CB("RTMP", "Proxy error? try SSL");
                            bxF = true;
                            bxq.onClose();
                            bxJ = _cls02CA.bxR;
                            bxr.shutdown();
                            return;
                        }
                    }
                    bxJ = _cls02CA.bxN;
                    bxz = 1536;
                    if (apd1.ef() == bxG)
                    {
                        bxG._mth02CB(apd1);
                    }
                    continue;

                case 2: // '\002'
                    byte abyte0[] = Arrays.copyOfRange(apd1.buffer, 0, apd1.length);
                    if (apd1.ef() == bxG)
                    {
                        bxG._mth02CB(apd1);
                    }
                    _mth02BB((new Date()).getTime() - bxv, abyte0, 4);
                    bxr.send(abyte0, 0, abyte0.length);
                    bxJ = _cls02CA.bxO;
                    bxz = 1536;
                    continue;

                case 3: // '\003'
                    byte abyte1[] = Arrays.copyOfRange(apd1.buffer, 8, apd1.length);
                    byte abyte2[] = Arrays.copyOfRange(bxu, 8, apd1.length);
                    if (apd1.ef() == bxG)
                    {
                        bxG._mth02CB(apd1);
                    }
                    if (Arrays.equals(abyte1, abyte2))
                    {
                        FF6A._mth02CB("RTMP", "C2 ok");
                    } else
                    {
                        FF6A._mth02CB("RTMP", "C2 mismatch");
                    }
                    bxm = new api(bxr);
                    bxA = 0;
                    apd1 = (new StringBuilder()).append(bwG).append("?").append(bwI).toString();
                    String s = (new StringBuilder()).append(bxs).append("://").append(bwE).append(":").append(bwF).append("/").append(apd1).append("/").toString();
                    bxz = 1;
                    bxJ = _cls02CA.bxL;
                    bxB = 0;
                    HashMap hashmap = new HashMap();
                    hashmap.put("app", apd1);
                    hashmap.put("tcUrl", s);
                    hashmap.put("fpad", Boolean.valueOf(false));
                    hashmap.put("audioCodecs", Integer.valueOf(1024));
                    hashmap.put("videoCodecs", Integer.valueOf(128));
                    _mth02BB("connect", new Object[] {
                        hashmap
                    });
                    continue;
                }
                api api1 = bxm;
                obj = apd1.buffer;
                i = apd1.length;
                if (i == api1.dY())
                {
                    if (api1.byK != null)
                    {
                        obj = api1.byK._mth02B4(((byte []) (obj)), 0, i);
                        if (api1.byK.bxa)
                        {
                            api1.byK = null;
                            api1.byO = 0;
                        }
                        break label1;
                    }
                    if (api1.byO == 0)
                    {
                        api1.byM[0] = obj[0];
                        api1.byN = 1;
                        api1.byO = 1;
                        if ((api1.byM[0] & 0x3f) == 0)
                        {
                            api1.byO = api1.byO + 1;
                        } else
                        if ((api1.byM[0] & 0x3f) == 1)
                        {
                            api1.byO = api1.byO + 2;
                        }
                        switch (api1.byM[0] >> 6 & 3)
                        {
                        case 0: // '\0'
                            api1.byO = api1.byO + 11;
                            break;

                        case 1: // '\001'
                            api1.byO = api1.byO + 7;
                            break;

                        case 2: // '\002'
                            api1.byO = api1.byO + 3;
                            break;
                        }
                    } else
                    if (api1.byN < api1.byO)
                    {
                        int j = api1.byO - api1.byN;
                        System.arraycopy(obj, 0, api1.byM, api1.byN, j);
                        api1.byN = api1.byN + j;
                    }
                    if (api1.byN == api1.byO)
                    {
                        int j2 = api1.byM[0] >> 6 & 3;
                        obj = api1.byM;
                        int i2 = 0 + 1;
                        int k = obj[0] & 0x3f;
                        int l1 = k;
                        int j1;
                        if (k == 0)
                        {
                            obj = api1.byM;
                            k = i2 + 1;
                            j1 = obj[1] + 64;
                        } else
                        {
                            j1 = l1;
                            k = i2;
                            if (l1 == 1)
                            {
                                j1 = api1.byM[1];
                                obj = api1.byM;
                                k = i2 + 1 + 1;
                                j1 = (j1 << 8) + obj[2];
                            }
                        }
                        aoy aoy1 = (aoy)api1.byJ.get(Integer.valueOf(j1));
                        obj = aoy1;
                        if (aoy1 == null)
                        {
                            obj = new aoy(j1, api1.byH, api1);
                            api1.byJ.put(Integer.valueOf(j1), obj);
                        }
                        api1.byK = ((aoy) (obj));
                        obj = api1.byK;
                        byte abyte3[] = api1.byM;
                        j1 = k;
                        k = j1;
                        if (j2 < 3)
                        {
                            obj.bxl = (abyte3[j1] & 0xff) << 16 | ((abyte3[j1 + 1] & 0xff) << 8) + (abyte3[j1 + 2] & 0xff);
                            k = j1 + 3;
                        }
                        j1 = k;
                        if (j2 < 2)
                        {
                            obj.bxj = (abyte3[k] & 0xff) << 16 | ((abyte3[k + 1] & 0xff) << 8) + (abyte3[k + 2] & 0xff);
                            obj.bxi = abyte3[k + 3];
                            j1 = k + 4;
                        }
                        if (j2 == 0)
                        {
                            obj.bxh = (abyte3[j1 + 3] & 0xff) << 24 | (abyte3[j1 + 2] & 0xff) << 16 | ((abyte3[j1 + 1] & 0xff) << 8) + (abyte3[j1] & 0xff);
                            obj.bxf = false;
                        } else
                        {
                            obj.bxf = true;
                        }
                        if (((aoy) (obj)).bxl == 0xffffffL)
                        {
                            FF6A._mth02CB("RTMP", "Extended time");
                            obj.bxc = 4;
                            obj.bxd = 0;
                        }
                        obj.bxa = false;
                    }
                }
                obj = null;
            }
            if (apd1.ef() == bxG)
            {
                bxG._mth02CB(apd1);
            }
            if (obj != null)
            {
                boolean flag1 = false;
                if (((apg) (obj)).byy != 8 && ((apg) (obj)).byy != 9 && (bxJ != _cls02CA.bxQ || ((apg) (obj)).byy != 18))
                {
                    FF6A._mth02CB("RTMP", (new StringBuilder("Receive:")).append(obj).toString());
                }
                boolean flag;
                if (((apg) (obj)).byw == 2)
                {
                    if (((apg) (obj)).byy == 5)
                    {
                        if (((apg) (obj)).byA == null)
                        {
                            obj.byA = new apd();
                        }
                        bxD = _cls028B._mth02CB(((apg) (obj)).byA.buffer, 0);
                        flag = flag1;
                        if (bxE > 0L)
                        {
                            apd1 = new byte[4];
                            _mth02BB(bxE, apd1, 0);
                            apg apg2 = new apg(5, 2, 0);
                            apg2.byA = new apd(apd1);
                            _mth02CF(apg2);
                            byte abyte4[] = new byte[5];
                            _mth02BB(bxE, apd1, 0);
                            abyte4[4] = 2;
                            apd1 = new apg(6, 2, 0);
                            apd1.byA = new apd(abyte4);
                            _mth02CF(apd1);
                            flag = flag1;
                        }
                    } else
                    if (((apg) (obj)).byy == 1)
                    {
                        if (((apg) (obj)).byA == null)
                        {
                            obj.byA = new apd();
                        }
                        int l = (int)_cls028B._mth02CB(((apg) (obj)).byA.buffer, 0);
                        bxm.FEF4(l);
                        flag = flag1;
                    } else
                    {
                        flag = flag1;
                        if (((apg) (obj)).byy == 4)
                        {
                            if (((apg) (obj)).byA == null)
                            {
                                obj.byA = new apd();
                            }
                            apd1 = ((apg) (obj)).byA.buffer;
                            if (((apg) (obj)).byA == null)
                            {
                                obj.byA = new apd();
                            }
                            apd1 = Arrays.copyOfRange(apd1, 0, ((apg) (obj)).byA.length);
                            if (((apd1[0] & 0xff) << 8 | apd1[1] & 0xff) == 6)
                            {
                                apd1[1] = 7;
                                apg apg3 = new apg(4, 2, 0);
                                apg3.byA = new apd(apd1);
                                _mth02CF(apg3);
                            }
                            flag = flag1;
                        }
                    }
                } else
                if (bxJ == _cls02CA.bxQ)
                {
                    flag = bxq._mth02CA(((apg) (obj)));
                } else
                {
                    flag = flag1;
                    if (((apg) (obj)).byy == 20)
                    {
                        apd1 = ((apd) (((apg) (obj)).byz));
                        flag = flag1;
                        if (apd1[1] instanceof Double)
                        {
                            flag = flag1;
                            if (Math.round(((Double)apd1[1]).doubleValue()) == (long)bxA)
                            {
                                if (bxJ == _cls02CA.bxL)
                                {
                                    if (apd1.length > 2 && (apd1[2] instanceof Map))
                                    {
                                        bxH = (String)((Map)apd1[2]).get("fmsVer");
                                    }
                                    apd1 = new byte[10];
                                    apd1[0] = 0;
                                    apd1[1] = 3;
                                    _mth02BB(0L, apd1, 2);
                                    _mth02BB(300L, apd1, 6);
                                    apg apg4 = new apg(4, 2, 0);
                                    apg4.byA = new apd(apd1);
                                    _mth02CF(apg4);
                                    bxB = 0;
                                    _mth02BB("createStream", new Object[] {
                                        null
                                    });
                                    bxJ = _cls02CA.bxP;
                                    flag = flag1;
                                } else
                                {
                                    flag = flag1;
                                    if (bxJ == _cls02CA.bxP)
                                    {
                                        flag = flag1;
                                        if (apd1.length == 4)
                                        {
                                            flag = flag1;
                                            if (apd1[3] instanceof Double)
                                            {
                                                bxB = (int)Math.round(((Double)apd1[3]).doubleValue());
                                                FF6A._mth02CB("RTMP", (new StringBuilder("Media Stream: ")).append(bxB).toString());
                                                bxJ = _cls02CA.bxQ;
                                                bxq._mth309D(bxB);
                                                flag = flag1;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (!flag)
                {
                    _mth02CE(((apg) (obj)));
                }
            }
            bxz = bxm.dY();
        } while (true);
    }

    public final void _mth02CA(byte abyte0[], long l)
    {
        apg apg1 = new apg(9, 7, bxB);
        apg1.bxk = 0L;
        apg1.byA = new apd(abyte0);
        _mth02CF(apg1);
    }

    public final void _mth02CB(byte abyte0[], long l)
    {
        apg apg1 = new apg(8, 6, bxB);
        apg1.bxk = 0L;
        apg1.byA = new apd(abyte0);
        _mth02CF(apg1);
    }

    public final void _mth02CE(apg apg1)
    {
        if (apg1.byA == null)
        {
            apg1.byA = new apd();
        }
        if (apg1.byA != null)
        {
            if (apg1.byA == null)
            {
                apg1.byA = new apd();
            }
            if (apg1.byA.ef() != null)
            {
                bxm._mth02CE(apg1);
            }
        }
    }

    public final void _mth02CF(apg apg1)
    {
        if (apg1.byy != 8 && apg1.byy != 9 && apg1.byy != 18)
        {
            FF6A._mth02CB("RTMP", (new StringBuilder("Send:")).append(apg1).toString());
        }
        bxm._mth141D(apg1);
    }

    public final void FE79(int i)
    {
        apg apg1 = new apg(1, 2, 0);
        byte abyte0[] = new byte[4];
        _mth02BB(512L, abyte0, 0);
        apg1.byA = new apd(abyte0);
        _mth02CF(apg1);
        bxm._mth012B(512);
    }
}
