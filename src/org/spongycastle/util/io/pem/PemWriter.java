// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.util.io.pem;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;
import org.spongycastle.util.encoders.Base64;

// Referenced classes of package org.spongycastle.util.io.pem:
//            PemObjectGenerator, PemObject, PemHeader

public class PemWriter extends BufferedWriter
{

    private final int aPF;
    private char buf[];

    public PemWriter(OutputStreamWriter outputstreamwriter)
    {
        super(outputstreamwriter);
        buf = new char[64];
        outputstreamwriter = System.getProperty("line.separator");
        if (outputstreamwriter != null)
        {
            aPF = outputstreamwriter.length();
            return;
        } else
        {
            aPF = 2;
            return;
        }
    }

    private void FBE8(byte abyte0[])
    {
        abyte0 = Base64._mth1D65(abyte0);
        for (int i = 0; i < abyte0.length; i += buf.length)
        {
            int j;
            for (j = 0; j != buf.length && i + j < abyte0.length; j++)
            {
                buf[j] = (char)abyte0[i + j];
            }

            write(buf, 0, j);
            newLine();
        }

    }

    public final void _mth02CA(PemObject pemobject)
    {
        pemobject = pemobject._mth1E3C();
        String s = pemobject.type;
        write((new StringBuilder("-----BEGIN ")).append(s).append("-----").toString());
        newLine();
        if (!pemobject.headers.isEmpty())
        {
            for (Iterator iterator = pemobject.headers.iterator(); iterator.hasNext(); newLine())
            {
                PemHeader pemheader = (PemHeader)iterator.next();
                write(null);
                write(": ");
                write(null);
            }

            newLine();
        }
        FBE8(pemobject.aPE);
        pemobject = pemobject.type;
        write((new StringBuilder("-----END ")).append(pemobject).append("-----").toString());
        newLine();
    }
}
