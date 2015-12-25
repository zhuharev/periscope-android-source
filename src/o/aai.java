// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.util.Base64;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.MediaFormatHolder;
import com.google.android.exoplayer.SampleHolder;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

// Referenced classes of package o:
//            aah, _cls028B, apg, apd, 
//            apa, api

public final class aai extends aah
{

    private static final byte baa[] = {
        0, 0, 0, 1
    };
    public static final UUID bag = UUID.fromString("62100F9A-A411-4E11-9141-482A1368BFD3");
    private MediaFormat bab;
    private int bac;
    private int bad;
    private aaf.if bae;
    public int baf;
    private int _fld0575;

    public aai(int i, int j, String s, int k, int l, aaf.if if1)
    {
        super(i, "video/avc", -1, s);
        bab = null;
        bad = 0;
        baf = 0;
        bac = k;
        _fld0575 = l;
        bae = if1;
    }

    private static long _mth02B3(byte abyte0[], int i, int j)
    {
        long l = 0L;
        for (int k = 0; k < j; k++)
        {
            l = l << 8 | (long)(abyte0[i + k] & 0xff);
        }

        return l;
    }

    private void _mth02CA(byte abyte0[], int i, int j, long l)
    {
        int j1 = 1;
        int k = 0;
        for (; j1 < j && (abyte0[i + j1] & 0xff) == 255; j1++)
        {
            k += 255;
        }

        byte byte1 = abyte0[i + j1];
        j1++;
        int k1 = 0;
        for (; j1 < j && (abyte0[i + j1] & 0xff) == 255; j1++)
        {
            k1 += 255;
        }

        k1 += abyte0[i + j1] & 0xff;
        j1++;
        if (k + (byte1 & 0xff) == 5 && k1 > 16 && k1 <= j - j1)
        {
            ByteBuffer bytebuffer = ByteBuffer.wrap(abyte0, i + j1, 16);
            if ((new UUID(bytebuffer.getLong(), bytebuffer.getLong())).equals(bag))
            {
                j1 += 16;
                k1 -= 16;
                ByteBuffer bytebuffer1 = ByteBuffer.allocate(k1);
                int i1 = 0;
                while (bytebuffer1.position() < k1 && j1 != j) 
                {
                    byte byte0 = abyte0[i + j1];
                    j1++;
                    if (i1 == 2)
                    {
                        if (byte0 != 3)
                        {
                            return;
                        }
                        i1 = 0;
                    } else
                    {
                        if (byte0 == 0)
                        {
                            i1++;
                        } else
                        {
                            i1 = 0;
                        }
                        bytebuffer1.put(byte0);
                    }
                }
                abyte0 = new byte[bytebuffer1.position()];
                bytebuffer1.rewind();
                bytebuffer1.get(abyte0);
                abyte0 = ((byte []) (_cls028B._mth02CB(abyte0)));
                if (abyte0 != null && abyte0.length == 1)
                {
                    abyte0 = (Map)abyte0[0];
                    bae._mth02CA(abyte0, l);
                }
            }
        }
    }

    public final void maybeThrowError()
    {
    }

    public final int readData(int i, long l, MediaFormatHolder mediaformatholder, SampleHolder sampleholder, boolean flag)
    {
        int k1;
        if (flag)
        {
            return -2;
        }
        if (bab == null)
        {
            i = aZU.indexOf(',');
            String s = aZU.substring(0, i);
            sampleholder = aZU.substring(i + 1);
            byte abyte0[] = Base64.decode(s, 0);
            byte abyte2[] = Base64.decode(sampleholder, 0);
            sampleholder = new byte[abyte0.length + 4];
            System.arraycopy(baa, 0, sampleholder, 0, 4);
            System.arraycopy(abyte0, 0, sampleholder, 4, abyte0.length);
            abyte0 = new byte[abyte2.length + 4];
            System.arraycopy(baa, 0, abyte0, 0, 4);
            System.arraycopy(abyte2, 0, abyte0, 4, abyte2.length);
            ArrayList arraylist = new ArrayList();
            arraylist.add(sampleholder);
            arraylist.add(abyte0);
            bab = MediaFormat.createVideoFormat(aZV, "video/avc", aZW, -1, -1L, bac, _fld0575, arraylist);
            mediaformatholder.format = bab;
            return -4;
        }
        byte abyte1[];
        do
        {
            mediaformatholder = R();
            if (mediaformatholder == null)
            {
                return -2;
            }
            if (((apg) (mediaformatholder)).byA == null)
            {
                mediaformatholder.byA = new apd();
            }
            abyte1 = ((apg) (mediaformatholder)).byA.buffer;
            if (abyte1[1] == 1)
            {
                break;
            }
            if (abyte1[1] == 0)
            {
                if (bad == 0)
                {
                    bad = (abyte1[9] & 3) + 1;
                }
                abyte1 = aZs;
                if (((apg) (mediaformatholder)).byA == null)
                {
                    mediaformatholder.byA = new apd();
                }
                if (((apg) (mediaformatholder)).byA != null)
                {
                    if (((apg) (mediaformatholder)).byA == null)
                    {
                        mediaformatholder.byA = new apd();
                    }
                    if (((apg) (mediaformatholder)).byA.ef() != null)
                    {
                        ((apa) (abyte1)).bxm._mth02CE(mediaformatholder);
                    }
                }
            }
        } while (true);
        if (((apg) (mediaformatholder)).byA == null)
        {
            mediaformatholder.byA = new apd();
        }
        k1 = ((apg) (mediaformatholder)).byA.length;
        if (sampleholder.data.capacity() < k1)
        {
            sampleholder.ensureSpaceForWrite(k1);
        }
        int j = 5;
        int i1;
        for (i = 0; j < k1 - 4; i = i1)
        {
            int l1 = (int)_mth02B3(abyte1, j, bad);
            int j1 = bad + j;
            int k = j1;
            i1 = i;
            j = k;
            if (j1 + l1 > k1)
            {
                continue;
            }
            switch (abyte1[k] & 0x1f)
            {
            case 5: // '\005'
                i = 1;
                break;

            case 6: // '\006'
                _mth02CA(abyte1, k, l1, ((apg) (mediaformatholder)).bxk);
                break;
            }
            sampleholder.data.put(baa, 0, 4);
            sampleholder.data.put(abyte1, k, l1);
            j = k + l1;
            i1 = i;
        }

        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_596;
        }
        this;
        JVM INSTR monitorenter ;
        baf = baf + 1;
        this;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_596;
        mediaformatholder;
        throw mediaformatholder;
        if (i != 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        sampleholder.flags = i;
        sampleholder.size = k1;
        sampleholder.timeUs = ((apg) (mediaformatholder)).bxk * 1000L;
        sampleholder = aZs;
        if (((apg) (mediaformatholder)).byA == null)
        {
            mediaformatholder.byA = new apd();
        }
        if (((apg) (mediaformatholder)).byA != null)
        {
            if (((apg) (mediaformatholder)).byA == null)
            {
                mediaformatholder.byA = new apd();
            }
            if (((apg) (mediaformatholder)).byA.ef() != null)
            {
                ((apa) (sampleholder)).bxm._mth02CE(mediaformatholder);
            }
        }
        return -3;
    }

}
