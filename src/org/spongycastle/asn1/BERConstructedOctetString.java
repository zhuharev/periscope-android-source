// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.util.Enumeration;
import java.util.Vector;

// Referenced classes of package org.spongycastle.asn1:
//            BEROctetString, DEROctetString

public class BERConstructedOctetString extends BEROctetString
{

    public final byte[] _mth0501()
    {
        return Wa;
    }

    public final Enumeration _mth0675()
    {
        Vector vector = new Vector();
        for (int i = 0; i < Wa.length; i += 1000)
        {
            int j;
            if (i + 1000 > Wa.length)
            {
                j = Wa.length;
            } else
            {
                j = i + 1000;
            }
            byte abyte0[] = new byte[j - i];
            System.arraycopy(Wa, i, abyte0, 0, abyte0.length);
            vector.addElement(new DEROctetString(abyte0));
        }

        return vector.elements();
    }
}
