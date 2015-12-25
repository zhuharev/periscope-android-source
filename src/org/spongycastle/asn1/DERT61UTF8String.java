// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.OutputStream;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1Primitive, ASN1String, ASN1OutputStream, StreamUtil

public class DERT61UTF8String extends ASN1Primitive
    implements ASN1String
{

    public final String getString()
    {
        return Strings._mth1D53(null);
    }

    public int hashCode()
    {
        return Arrays.hashCode(null);
    }

    public String toString()
    {
        return getString();
    }

    final void _mth02CA(ASN1OutputStream asn1outputstream)
    {
        asn1outputstream.write(20);
        asn1outputstream._mth1449(null.length);
        asn1outputstream.Wb.write(null);
    }

    final boolean _mth02CA(ASN1Primitive asn1primitive)
    {
        if (!(asn1primitive instanceof DERT61UTF8String))
        {
            return false;
        } else
        {
            return Arrays._mth1427(null, null);
        }
    }

    final boolean _mth03BD()
    {
        return false;
    }

    final int _mth03DA()
    {
        return StreamUtil._mth14BE(null.length) + 1 + null.length;
    }
}
