// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.agreement.kdf;

import java.io.IOException;
import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.util.Pack;

// Referenced classes of package org.spongycastle.crypto.agreement.kdf:
//            DHKDFParameters

public class DHKEKGenerator
    implements DerivationFunction
{

    private int Yp;
    private ASN1ObjectIdentifier amP;
    private byte amQ[];
    private final Digest amS;
    private byte amT[];

    public final int _mth02BF(byte abyte0[], int i, int j)
    {
        if (abyte0.length - j < i)
        {
            throw new DataLengthException("output buffer too small");
        }
        long l1 = j;
        int i1 = amS._mth14AF();
        if (l1 > 0x1ffffffffL)
        {
            throw new IllegalArgumentException("Output length too large");
        }
        int j1 = (int)((((long)i1 + l1) - 1L) / (long)i1);
        byte abyte1[] = new byte[amS._mth14AF()];
        boolean flag = true;
        boolean flag1 = false;
        int k = j;
        int l = i;
        i = ((flag1) ? 1 : 0);
        j = ((flag) ? 1 : 0);
        for (; i < j1; i++)
        {
            amS.update(amQ, 0, amQ.length);
            ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
            Object obj = new ASN1EncodableVector();
            Object obj1 = amP;
            ((ASN1EncodableVector) (obj)).VS.addElement(obj1);
            obj1 = new DEROctetString(Pack._mth1D31(j));
            ((ASN1EncodableVector) (obj)).VS.addElement(obj1);
            obj = new DERSequence(((ASN1EncodableVector) (obj)));
            asn1encodablevector.VS.addElement(obj);
            if (amT != null)
            {
                obj = new DERTaggedObject(true, 0, new DEROctetString(amT));
                asn1encodablevector.VS.addElement(obj);
            }
            obj = new DERTaggedObject(true, 2, new DEROctetString(Pack._mth1D31(Yp)));
            asn1encodablevector.VS.addElement(obj);
            try
            {
                byte abyte2[] = (new DERSequence(asn1encodablevector)).getEncoded("DER");
                amS.update(abyte2, 0, abyte2.length);
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new IllegalArgumentException((new StringBuilder("unable to encode parameter info: ")).append(abyte0.getMessage()).toString());
            }
            amS.doFinal(abyte1, 0);
            if (k > i1)
            {
                System.arraycopy(abyte1, 0, abyte0, l, i1);
                l += i1;
                k -= i1;
            } else
            {
                System.arraycopy(abyte1, 0, abyte0, l, k);
            }
            j++;
        }

        amS.reset();
        return (int)l1;
    }

    public final void _mth02CA(DerivationParameters derivationparameters)
    {
        derivationparameters = (DHKDFParameters)derivationparameters;
        amP = ((DHKDFParameters) (derivationparameters)).amP;
        Yp = ((DHKDFParameters) (derivationparameters)).Yp;
        amQ = ((DHKDFParameters) (derivationparameters)).amQ;
        amT = ((DHKDFParameters) (derivationparameters)).amR;
    }
}
