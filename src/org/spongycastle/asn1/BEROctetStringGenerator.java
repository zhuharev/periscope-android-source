// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.OutputStream;

// Referenced classes of package org.spongycastle.asn1:
//            BERGenerator, DEROctetString

public class BEROctetStringGenerator extends BERGenerator
{
    class BufferedBEROctetStream extends OutputStream
    {

        private int Wt;
        private BEROctetStringGenerator Wu;

        public void close()
        {
            if (Wt != 0)
            {
                byte abyte0[] = new byte[Wt];
                System.arraycopy(null, 0, abyte0, 0, Wt);
                DEROctetString._mth02CA(null, abyte0);
            }
            BEROctetStringGenerator beroctetstringgenerator = Wu;
            throw new NullPointerException();
        }

        public void write(int i)
        {
            Wt = Wt + 1;
            if (Wt == null.length)
            {
                DEROctetString._mth02CA(null, null);
                Wt = 0;
            }
        }

        public void write(byte abyte0[], int i, int j)
        {
            do
            {
                if (j <= 0)
                {
                    break;
                }
                int k = Math.min(j, null.length - Wt);
                System.arraycopy(abyte0, i, null, Wt, k);
                Wt = Wt + k;
                if (Wt < null.length)
                {
                    break;
                }
                DEROctetString._mth02CA(null, null);
                Wt = 0;
                i += k;
                j -= k;
            } while (true);
        }
    }

}
