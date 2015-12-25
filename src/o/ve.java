// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package o:
//            ri, si, rx, sj, 
//            sc, vj, uy, rz, 
//            _cls03BB, vg, vk, sd, 
//            vh, ra, rl, vf, 
//            rm, uj

public final class ve
{
    public static final class if
    {

        private static final ve UK = new ve((byte)0);

        public static ve _mth2148()
        {
            return UK;
        }


        if()
        {
        }
    }

    /* member class not found */
    class _cls02CA {}


    public final AtomicReference UH;
    private final CountDownLatch UI;
    private vg UJ;
    private boolean initialized;

    private ve()
    {
        UH = new AtomicReference();
        UI = new CountDownLatch(1);
        initialized = false;
    }

    ve(byte byte0)
    {
        this();
    }

    public final ve _mth02CA(rm rm, si si1, uj uj, String s, String s1, String s2)
    {
        this;
        JVM INSTR monitorenter ;
        if (!initialized)
        {
            break MISSING_BLOCK_LABEL_13;
        }
        this;
        JVM INSTR monitorexit ;
        return this;
        if (UJ == null)
        {
            android.content.Context context = rm.getContext();
            String s3 = si1.QR;
            String s4 = (new rx())._mth06E5(context);
            String s5 = si1.RV._mth1507(si1.appContext);
            sc sc1 = new sc();
            vj vj1 = new vj();
            uy uy1 = new uy(rm);
            String s6 = rz._mth141F(context);
            uj = new _cls03BB(rm, s2, String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", new Object[] {
                s3
            }), uj);
            UJ = new vg(rm, new vk(s4, si1._mth02C9(s4, s3), rz._mth02CF(new String[] {
                rz._mth142A(context)
            }), s1, s, sd._mth15AE(s5).id, s6), sc1, vj1, uy1, uj);
        }
        initialized = true;
        this;
        JVM INSTR monitorexit ;
        return this;
        rm;
        throw rm;
    }

    public final vh _mth1F3B()
    {
        InterruptedException interruptedexception;
        vh vh1;
        try
        {
            UI.await();
            vh1 = (vh)UH.get();
        }
        // Misplaced declaration of an exception variable
        catch (InterruptedException interruptedexception)
        {
            ra._mth0454()._mth02CA("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
        return vh1;
    }

    public final boolean _mth1F3C()
    {
        this;
        JVM INSTR monitorenter ;
        vh vh1;
        vh1 = UJ._mth5196();
        UH.set(vh1);
        UI.countDown();
        if (vh1 != null)
        {
            return true;
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean _mth1F3D()
    {
        this;
        JVM INSTR monitorenter ;
        vh vh1;
        vh1 = UJ._mth02CA(vf.UM);
        UH.set(vh1);
        UI.countDown();
        if (vh1 != null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        ra._mth0454()._mth02CB("Fabric", "Failed to force reload of settings from Crashlytics.", null);
        if (vh1 != null)
        {
            return true;
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        Exception exception;
        exception;
        throw exception;
    }
}
