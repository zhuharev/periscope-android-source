// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.MediaFormatHolder;
import com.google.android.exoplayer.SampleHolder;
import java.nio.ByteBuffer;
import java.util.Collections;

// Referenced classes of package o:
//            aah, apg, apd, apa, 
//            api

public final class aae extends aah
{

    private boolean aZn;
    private int aZo;
    private int aZp;

    public aae(int i, int j, String s, int k, int l)
    {
        super(i, "audio/mp4a-latm", -1, s);
        aZn = false;
        aZo = k;
        aZp = l;
    }

    public final int readData(int i, long l, MediaFormatHolder mediaformatholder, SampleHolder sampleholder, boolean flag)
    {
        if (flag)
        {
            return -2;
        }
        String s = aZU;
        int j = s.length();
        byte abyte1[] = new byte[j / 2];
        for (i = 0; i < j; i += 2)
        {
            abyte1[i / 2] = (byte)((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }

        if (!aZn)
        {
            mediaformatholder.format = MediaFormat.createAudioFormat(aZV, "audio/mp4a-latm", aZW, -1, -1L, aZo, aZp, Collections.singletonList(abyte1), null);
            aZn = true;
            return -4;
        }
        do
        {
            mediaformatholder = R();
            if (mediaformatholder != null)
            {
                if (((apg) (mediaformatholder)).byA == null)
                {
                    mediaformatholder.byA = new apd();
                }
                byte abyte0[] = ((apg) (mediaformatholder)).byA.buffer;
                if (((apg) (mediaformatholder)).byA == null)
                {
                    mediaformatholder.byA = new apd();
                }
                i = ((apg) (mediaformatholder)).byA.length;
                if (abyte0[1] == 1)
                {
                    i -= 2;
                    if (sampleholder.data.capacity() < i)
                    {
                        sampleholder.ensureSpaceForWrite(i);
                    }
                    sampleholder.data.put(abyte0, 2, i);
                    sampleholder.size = i;
                    sampleholder.timeUs = ((apg) (mediaformatholder)).bxk * 1000L;
                    sampleholder.flags = 1;
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
            } else
            {
                return -2;
            }
        } while (true);
    }
}
