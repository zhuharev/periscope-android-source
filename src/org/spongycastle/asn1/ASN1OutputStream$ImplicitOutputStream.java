// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.OutputStream;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1OutputStream

class St extends ASN1OutputStream
{

    private boolean St;
    private ASN1OutputStream Wc;

    public final void write(int i)
    {
        if (St)
        {
            St = false;
            return;
        } else
        {
            super.write(i);
            return;
        }
    }

    public A(ASN1OutputStream asn1outputstream, OutputStream outputstream)
    {
        Wc = asn1outputstream;
        super(outputstream);
        St = true;
    }
}
