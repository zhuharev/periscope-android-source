// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1Primitive, ASN1String, ASN1OutputStream, StreamUtil

public class DERUniversalString extends ASN1Primitive
    implements ASN1String
{

    private static final char WD[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'A', 'B', 'C', 'D', 'E', 'F'
    };
    private byte Wa[];

    public DERUniversalString(byte abyte0[])
    {
        Wa = abyte0;
    }

    public final String getString()
    {
        IOException ioexception;
        StringBuffer stringbuffer = new StringBuffer("#");
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        ASN1OutputStream asn1outputstream = new ASN1OutputStream(bytearrayoutputstream);
        try
        {
            asn1outputstream._mth02CF(this);
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            throw new RuntimeException("internal error encoding BitString");
        }
        byte abyte0[] = bytearrayoutputstream.toByteArray();
        for (int i = 0; i != abyte0.length; i++)
        {
            stringbuffer.append(WD[abyte0[i] >>> 4 & 0xf]);
            stringbuffer.append(WD[abyte0[i] & 0xf]);
        }

        return stringbuffer.toString();
    }

    public int hashCode()
    {
        return Arrays.hashCode(Wa);
    }

    public String toString()
    {
        return getString();
    }

    final void _mth02CA(ASN1OutputStream asn1outputstream)
    {
        byte abyte0[] = Wa;
        asn1outputstream.write(28);
        asn1outputstream._mth1449(abyte0.length);
        asn1outputstream.Wb.write(abyte0);
    }

    final boolean _mth02CA(ASN1Primitive asn1primitive)
    {
        if (!(asn1primitive instanceof DERUniversalString))
        {
            return false;
        } else
        {
            return Arrays._mth1427(Wa, ((DERUniversalString)asn1primitive).Wa);
        }
    }

    final boolean _mth03BD()
    {
        return false;
    }

    final int _mth03DA()
    {
        return StreamUtil._mth14BE(Wa.length) + 1 + Wa.length;
    }

}
