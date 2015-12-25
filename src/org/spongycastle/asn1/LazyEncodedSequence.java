// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Vector;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1Sequence, LazyConstructionEnumeration, ASN1OutputStream, ASN1Primitive, 
//            StreamUtil, ASN1Encodable

class LazyEncodedSequence extends ASN1Sequence
{

    private byte WZ[];

    LazyEncodedSequence(byte abyte0[])
    {
        WZ = abyte0;
    }

    private void _mth072A()
    {
        for (LazyConstructionEnumeration lazyconstructionenumeration = new LazyConstructionEnumeration(WZ); lazyconstructionenumeration.hasMoreElements(); Wd.addElement(lazyconstructionenumeration.nextElement())) { }
        WZ = null;
    }

    public final int size()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        if (WZ != null)
        {
            _mth072A();
        }
        i = super.size();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    final void _mth02CA(ASN1OutputStream asn1outputstream)
    {
        if (WZ != null)
        {
            byte abyte0[] = WZ;
            asn1outputstream.write(48);
            asn1outputstream._mth1449(abyte0.length);
            asn1outputstream.Wb.write(abyte0);
            return;
        } else
        {
            super._mth05D7()._mth02CA(asn1outputstream);
            return;
        }
    }

    final int _mth03DA()
    {
        if (WZ != null)
        {
            return StreamUtil._mth14BE(WZ.length) + 1 + WZ.length;
        } else
        {
            return super._mth05D7()._mth03DA();
        }
    }

    final ASN1Primitive _mth0582()
    {
        if (WZ != null)
        {
            _mth072A();
        }
        return super._mth0582();
    }

    final ASN1Primitive _mth05D7()
    {
        if (WZ != null)
        {
            _mth072A();
        }
        return super._mth05D7();
    }

    public final Enumeration _mth0675()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        if (WZ != null)
        {
            break MISSING_BLOCK_LABEL_18;
        }
        obj = super._mth0675();
        this;
        JVM INSTR monitorexit ;
        return ((Enumeration) (obj));
        obj = new LazyConstructionEnumeration(WZ);
        this;
        JVM INSTR monitorexit ;
        return ((Enumeration) (obj));
        Exception exception;
        exception;
        throw exception;
    }

    public final ASN1Encodable _mth144B(int i)
    {
        this;
        JVM INSTR monitorenter ;
        ASN1Encodable asn1encodable;
        if (WZ != null)
        {
            _mth072A();
        }
        asn1encodable = super._mth144B(i);
        this;
        JVM INSTR monitorexit ;
        return asn1encodable;
        Exception exception;
        exception;
        throw exception;
    }
}
