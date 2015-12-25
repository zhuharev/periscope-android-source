// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.MediaFormatHolder;
import com.google.android.exoplayer.SampleHolder;
import com.google.android.exoplayer.SampleSource;
import java.util.ArrayList;

// Referenced classes of package o:
//            apg, apa

public class aah
    implements SampleSource, com.google.android.exoplayer.SampleSource.SampleSourceReader
{

    private String aZT;
    protected final String aZU;
    protected final int aZV;
    protected int aZW;
    private MediaFormat aZX;
    private long aZY;
    private final ArrayList aZZ = new ArrayList();
    protected apa aZs;

    public aah(int i, String s, int j, String s1)
    {
        aZY = 0L;
        aZV = i;
        aZT = s;
        aZW = j;
        aZU = s1;
        aZX = MediaFormat.createFormatForMimeType(aZV, aZT, aZW, -1L);
    }

    protected final apg R()
    {
        ArrayList arraylist = aZZ;
        arraylist;
        JVM INSTR monitorenter ;
        apg apg1;
        if (aZZ.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        apg1 = (apg)aZZ.remove(0);
        return apg1;
        arraylist;
        JVM INSTR monitorexit ;
        return null;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean continueBuffering(int i, long l)
    {
        return aZZ.size() > 0;
    }

    public void disable(int i)
    {
    }

    public void enable(int i, long l)
    {
    }

    public long getBufferedPositionUs()
    {
        ArrayList arraylist = aZZ;
        arraylist;
        JVM INSTR monitorenter ;
        long l = aZY;
        arraylist;
        JVM INSTR monitorexit ;
        return l * 1000L;
        Exception exception;
        exception;
        throw exception;
    }

    public MediaFormat getFormat(int i)
    {
        return aZX;
    }

    public int getTrackCount()
    {
        return 1;
    }

    public void maybeThrowError()
    {
    }

    public boolean prepare(long l)
    {
        return true;
    }

    public int readData(int i, long l, MediaFormatHolder mediaformatholder, SampleHolder sampleholder, boolean flag)
    {
        return 0;
    }

    public com.google.android.exoplayer.SampleSource.SampleSourceReader register()
    {
        return this;
    }

    public void release()
    {
        aZs.shutdown();
    }

    public void seekToUs(long l)
    {
    }

    public final void _mth02CA(apa apa1)
    {
        aZs = apa1;
    }

    public final void _mth02CB(apg apg1)
    {
        ArrayList arraylist = aZZ;
        arraylist;
        JVM INSTR monitorenter ;
        aZZ.add(apg1);
        if (apg1.bxk > aZY)
        {
            aZY = apg1.bxk;
        }
        arraylist;
        JVM INSTR monitorexit ;
        return;
        apg1;
        throw apg1;
    }
}
