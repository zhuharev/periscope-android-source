// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.media.MediaFormat;
import android.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

// Referenced classes of package o:
//            aox, aow, apa, FF6A, 
//            apg, _cls028B

public final class aov
    implements apa.if
{
    public static final class if extends Enum
    {

        public static final int bwP = 1;
        public static final int bwQ = 2;
        public static final int bwR = 3;
        public static final int bwS = 4;
        private static final int bwT[] = {
            1, 2, 3, 4
        };

        public static int[] dW()
        {
            return (int[])bwT.clone();
        }

    }

    /* member class not found */
    class _cls02CA {}


    private static int bwN[] = {
        0x17700, 0x15888, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 
        11025, 8000, 7350
    };
    public MediaFormat aTD;
    public apa aZs;
    private Timer aZw;
    private long aZx;
    public MediaFormat bho;
    public long bwA;
    public long bwB;
    public aox bwC;
    private String bwD;
    private String bwE;
    private int bwF;
    private String bwG;
    private String bwH;
    private String bwI;
    public long bwJ;
    public int bwK;
    private double bwL;
    private int bwM;
    public byte bwk[];
    public byte bwl[];
    public boolean bwm;
    public boolean bwn;
    public boolean bwo;
    public boolean bwp;
    public boolean bwq;
    public _cls02CA bwr;
    public long bws;
    public long bwt;
    public double bwu;
    private HashMap bwv;
    private HashMap bww;
    public boolean bwx;
    public boolean bwy;
    public long bwz;
    private long _fld0710;

    public aov(String s, String s1, int i, String s2, String s3, String s4)
    {
        bwk = null;
        bwl = null;
        bwm = false;
        bwn = false;
        bwo = false;
        bwp = false;
        bwq = false;
        bwv = null;
        bww = new HashMap();
        bwx = false;
        bwy = false;
        bwA = 0L;
        bwB = 0L;
        bwC = new aox();
        aZx = 0L;
        bwJ = 0L;
        _fld0710 = 0L;
        bwK = 0;
        bwL = 0.0D;
        bwM = if.bwP;
        bwD = s;
        bwE = s1;
        bwF = i;
        bwG = s2;
        bwH = s3;
        bwI = s4;
        aZw = new Timer();
        aZw.schedule(new aow(this), 3000L, 3000L);
        dN();
    }

    private void dN()
    {
        aZx = System.currentTimeMillis();
        aZs = new apa();
        aZs.bxE = 0x2625a0L;
        aZs._mth02CA(bwD, bwE, bwF, bwG, bwH, bwI, this);
    }

    private HashMap dQ()
    {
        HashMap hashmap = new HashMap();
        String s1 = (new StringBuilder()).append(Integer.toHexString(bwk[1] & 0xff & 0xff | 0x100).substring(1)).append(Integer.toHexString(bwk[2] & 0xff & 0xff | 0x100).substring(1)).append(Integer.toHexString(bwk[3] & 0xff & 0xff | 0x100).substring(1)).toString();
        hashmap.put("profile-level-id", s1);
        Object obj = "Baseline";
        if (bwk[1] == 77)
        {
            obj = "Main";
        } else
        if (bwk[1] == 100)
        {
            obj = "High";
        }
        String s = "";
        if ((bwk[2] & 0x80) != 0)
        {
            s = "Constrained ";
        }
        FF6A._mth02CB("RTMP", (new StringBuilder("Profile-level-id: ")).append(s).append(((String) (obj))).append(" profile: ").append(s1).toString());
        hashmap.put("sprop-parameter-sets", (new StringBuilder()).append(Base64.encodeToString(bwk, 2)).append(",").append(Base64.encodeToString(bwl, 2)).toString());
        int i = bho.getInteger("width");
        int j = bho.getInteger("height");
        hashmap.put("description", (new StringBuilder("{H264CodecConfigInfo: codec:H264, profile:Main, level:2.1, frameSize:")).append(i).append("x").append(j).append(", displaySize:").append(i).append("x").append(j).append(", crop: l:0 r:0 t:0 b:0}").toString());
        hashmap.put("language", "eng");
        hashmap.put("timescale", Integer.valueOf(0x15f90));
        hashmap.put("type", "video");
        obj = new HashMap();
        ((HashMap) (obj)).put("sampletype", "H264");
        hashmap.put("sampledescription", ((Object) (new Object[] {
            obj
        })));
        FF6A._mth02CB("RTMP", (new StringBuilder("Video props: ")).append(hashmap).toString());
        return hashmap;
    }

    private HashMap dR()
    {
        HashMap hashmap = new HashMap();
        int i = aTD.getInteger("channel-count");
        int j = aTD.getInteger("sample-rate");
        hashmap.put("description", (new StringBuilder("{AACFrame: codec:AAC, channels:")).append(i).append(", frequency:").append(j).append(", samplesPerFrame:1024, objectType:LC}").toString());
        hashmap.put("language", "eng");
        hashmap.put("timescale", Integer.valueOf(0x15f90));
        hashmap.put("type", "audio");
        HashMap hashmap1 = new HashMap();
        hashmap1.put("sampletype", "mpeg4-generic");
        hashmap.put("sampledescription", ((Object) (new Object[] {
            hashmap1
        })));
        byte abyte0[] = _mth06E6(j, i);
        hashmap.put("config", (new StringBuilder()).append(Integer.toHexString(abyte0[0] & 0xff | 0x100).substring(1)).append(Integer.toHexString(abyte0[1] & 0xff | 0x100).substring(1)).toString());
        FF6A._mth02CB("RTMP", (new StringBuilder("Audio props: ")).append(hashmap).toString());
        return hashmap;
    }

    private void dS()
    {
        byte abyte0[] = dU();
        byte abyte1[] = new byte[abyte0.length + 5];
        abyte1[0] = 23;
        System.arraycopy(abyte0, 0, abyte1, 5, abyte0.length);
        aZs._mth02CA(abyte1, 0L);
    }

    private void dT()
    {
        int i = aTD.getInteger("channel-count");
        byte abyte0[] = _mth06E6(aTD.getInteger("sample-rate"), i);
        byte abyte1[] = new byte[4];
        abyte1[0] = -81;
        abyte1[2] = abyte0[0];
        abyte1[3] = abyte0[1];
        aZs._mth02CB(abyte1, 0L);
    }

    private byte[] dU()
    {
        byte abyte0[] = new byte[bwk.length + 11 + bwl.length];
        abyte0[0] = 1;
        System.arraycopy(bwk, 1, abyte0, 1, 3);
        abyte0[4] = -1;
        abyte0[5] = -31;
        abyte0[6] = (byte)(bwk.length >> 8);
        abyte0[7] = (byte)bwk.length;
        System.arraycopy(bwk, 0, abyte0, 8, bwk.length);
        int j = bwk.length + 8;
        int i = j + 1;
        abyte0[j] = 1;
        j = i + 1;
        abyte0[i] = (byte)(bwl.length >> 8);
        abyte0[j] = (byte)bwl.length;
        System.arraycopy(bwl, 0, abyte0, j + 1, bwl.length);
        return abyte0;
    }

    static void _mth02CA(aov aov1)
    {
        boolean flag1 = false;
        long l = System.currentTimeMillis();
        aov1;
        JVM INSTR monitorenter ;
        boolean flag = flag1;
        if (aov1.aZx <= 0L)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        flag = flag1;
        if (l - aov1.aZx <= 15000L)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        FF6A._mth02CB("RTMP", "Restart on Connect timeout");
        flag = true;
        aov1.aZx = 0L;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        aov1.dV();
        aov1;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private static byte[] _mth06E6(int i, int j)
    {
        int k = j;
        if (j == 8)
        {
            k = 7;
        }
        boolean flag = false;
        j = 0;
        int l;
        do
        {
            l = ((flag) ? 1 : 0);
            if (j >= 13)
            {
                break;
            }
            if (bwN[j] == i)
            {
                l = j;
                break;
            }
            j++;
        } while (true);
        return (new byte[] {
            (byte)(l >> 1 & 7 | 0x10), (byte)((l & 1) << 7 | k << 3)
        });
    }

    private void FBFF(int i)
    {
        this;
        JVM INSTR monitorenter ;
        int j = bwM;
        if (i != j)
        {
            break MISSING_BLOCK_LABEL_15;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        bwM = i;
        this;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L1:
        if (bwr != null)
        {
            bwr._mth4E00(i);
        }
        return;
    }

    public final HashMap O()
    {
        HashMap hashmap;
        hashmap = new HashMap();
        if (aZs != null)
        {
            hashmap.put("fmsVer", aZs.bxH);
        }
        this;
        JVM INSTR monitorenter ;
        long l1;
        if (bwK <= 0)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        l1 = _fld0710;
        long l = l1;
        if (bwJ != 0L)
        {
            l = l1 + (System.currentTimeMillis() - bwJ);
        }
        double d = (double)l / (double)bwK / 1000D;
        FF6A._mth02CB("RTMP", (new StringBuilder("Keyframe interval (secs): ")).append(d).toString());
        hashmap.put("KeyframeInterval", Double.valueOf(d));
        this;
        JVM INSTR monitorexit ;
        return hashmap;
        Exception exception;
        exception;
        throw exception;
    }

    public final double dO()
    {
        this;
        JVM INSTR monitorenter ;
        double d = bwL;
        this;
        JVM INSTR monitorexit ;
        return d;
        Exception exception;
        exception;
        throw exception;
    }

    public void dP()
    {
        if (aZs.bxI)
        {
            String s1 = aZs.bxt;
            Object obj = aZs;
            if (((apa) (obj)).bwI == null || ((apa) (obj)).bwI.length() < 3)
            {
                obj = "";
            } else
            {
                obj = ((apa) (obj)).bwI.substring(2);
            }
            aZs._mth02BB("fast-publish", new Object[] {
                null, s1, "live", obj
            });
        } else
        {
            String s = aZs.bxt;
            aZs._mth02BB("publish", new Object[] {
                null, s, "live"
            });
        }
        Object obj1 = new HashMap();
        ((HashMap) (obj1)).put("connectiondata", "In IP4 0.0.0.0");
        ((HashMap) (obj1)).put("name", "Live stream from Periscope");
        ((HashMap) (obj1)).put("protocolversion", Integer.valueOf(0));
        ((HashMap) (obj1)).put("timing", "0 0");
        HashMap hashmap = new HashMap();
        hashmap.put("rtpsessioninfo", obj1);
        hashmap.put("trackinfo", ((Object) (new Object[] {
            dQ(), dR()
        })));
        int i = bho.getInteger("width");
        int j = bho.getInteger("height");
        hashmap.put("videocodecid", "avc1");
        hashmap.put("width", Integer.valueOf(i));
        hashmap.put("displayWidth", Integer.valueOf(i));
        hashmap.put("frameWidth", Integer.valueOf(i));
        hashmap.put("height", Integer.valueOf(j));
        hashmap.put("displayHeight", Integer.valueOf(j));
        hashmap.put("frameHeight", Integer.valueOf(j));
        hashmap.put("audiocodecid", "mp4a");
        hashmap.put("audiochannels", Integer.valueOf(aTD.getInteger("channel-count")));
        hashmap.put("audiosamplerate", Integer.valueOf(aTD.getInteger("sample-rate")));
        obj1 = new apg(18, 5, aZs.bxB);
        ((apg) (obj1))._mth02CE(new Object[] {
            "onMetaData", hashmap
        });
        aZs._mth02CF(((apg) (obj1)));
        FF6A._mth02CB("RTMP", (new StringBuilder("Metadata: ")).append(obj1).toString());
        aZs.FE79(512);
        dS();
        dT();
    }

    public final void dV()
    {
        FF6A._mth02CB("RTMP", "Restarting publish connection");
        FBFF(if.bwR);
        this;
        JVM INSTR monitorenter ;
        bwm = false;
        bwp = false;
        this;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L1:
        aZs.shutdown();
        aZs = null;
        dN();
        return;
    }

    public final void onClose()
    {
        if (bwM != if.bwS)
        {
            if (aZs.bxF && bwF == 80 && bwD.equalsIgnoreCase("rtmp"))
            {
                bwF = 443;
                bwD = "RTMPS";
                FF6A._mth02CB("RTMP", "Attempt restart with SSL:443");
            } else
            {
                FF6A._mth02CB("RTMP", "Restart on socket close");
            }
            dV();
        }
    }

    public final void onShutdown()
    {
        FBFF(if.bwS);
    }

    public final void shutdown()
    {
        if (aZw != null)
        {
            aZw.cancel();
            aZw = null;
        }
        FBFF(if.bwS);
        if (bwC != null)
        {
            bwC.dX();
        }
        this;
        JVM INSTR monitorenter ;
        if (bwJ != 0L)
        {
            _fld0710 = _fld0710 + (System.currentTimeMillis() - bwJ);
            bwJ = 0L;
        }
        this;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L1:
        bwp = false;
        if (aZs != null)
        {
            aZs.shutdown();
        }
        return;
    }

    public final void _mth02CA(MediaFormat mediaformat, MediaFormat mediaformat1)
    {
        bho = mediaformat1;
        aTD = mediaformat;
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        boolean flag = flag1;
        if (bwo)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        bwo = true;
        flag = flag1;
        boolean flag2;
        if (!bwm)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        flag2 = bwn;
        flag = flag1;
        if (flag2)
        {
            flag = true;
        }
        this;
        JVM INSTR monitorexit ;
          goto _L1
        mediaformat;
        throw mediaformat;
_L1:
        if (flag)
        {
            dP();
        }
        bwu = ((double)aTD.getInteger("channel-count") * 1000D) / (double)aTD.getInteger("sample-rate");
        return;
    }

    public final void _mth02CA(HashMap hashmap, boolean flag, boolean flag1)
    {
        this;
        JVM INSTR monitorenter ;
        bwv = hashmap;
        bwx = flag;
        bwy = false;
        this;
        JVM INSTR monitorexit ;
        return;
        hashmap;
        throw hashmap;
    }

    public final boolean _mth02CA(apg apg1)
    {
        if (apg1.byy != 20)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        apg1 = ((apg) (apg1.byz));
        if (!((String)apg1[0]).equals("onStatus") || apg1.length <= 3 || !(apg1[3] instanceof Map) || !"NetStream.Publish.Start".equals((String)((Map)apg1[3]).get("code")))
        {
            break MISSING_BLOCK_LABEL_104;
        }
        this;
        JVM INSTR monitorenter ;
        bwq = false;
        bwp = true;
        aZx = 0L;
        this;
        JVM INSTR monitorexit ;
          goto _L1
        apg1;
        throw apg1;
_L1:
        FBFF(if.bwQ);
        return false;
    }

    public byte[] _mth02CA(long l, boolean flag)
    {
        double d = 0.0D;
        this;
        JVM INSTR monitorenter ;
        if (bwA != 0L)
        {
            d = (double)(bwA + (l - bwz)) / 1000D + 2208988800D;
        }
        if (bwv.containsKey("rotation"))
        {
            bwL = ((Double)bwv.get("rotation")).doubleValue();
        }
        this;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L1:
        Object obj;
        bww.put("ntp", Double.valueOf(d));
        obj = new HashMap();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        this;
        JVM INSTR monitorenter ;
        if (bwv != null)
        {
            ((HashMap) (obj)).putAll(bwv);
        }
        this;
        JVM INSTR monitorexit ;
          goto _L2
        obj;
        throw obj;
_L2:
        ((HashMap) (obj)).putAll(bww);
        break MISSING_BLOCK_LABEL_219;
        ((HashMap) (obj)).put("ntp", Double.valueOf(d));
        this;
        JVM INSTR monitorenter ;
        if (bwv != null && bwv.containsKey("rotation"))
        {
            ((HashMap) (obj)).put("rotation", bwv.get("rotation"));
        }
        this;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_219;
        obj;
        throw obj;
        byte abyte0[] = _cls028B._mth02CB(new Object[] {
            obj
        });
        if (flag)
        {
            ((HashMap) (obj)).put("Base64", Base64.encodeToString(abyte0, 2));
        }
        apa apa1 = aZs;
        apg apg1 = new apg(18, 5, apa1.bxB);
        apg1._mth02CE(new Object[] {
            "Periscope", obj
        });
        apg1.bxk = l;
        apa1._mth02CF(apg1);
        return abyte0;
    }

    public final void _mth309D(int i)
    {
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        this;
        JVM INSTR monitorenter ;
        if (!bwm)
        {
            bwm = true;
            if (bwn && bwo)
            {
                dP();
            }
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

}
