// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.IOException;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1Primitive, ASN1TaggedObjectParser, ASN1Choice, ASN1Encodable, 
//            DERTaggedObject, DLTaggedObject, ASN1OutputStream

public abstract class ASN1TaggedObject extends ASN1Primitive
    implements ASN1TaggedObjectParser
{

    public int Wk;
    boolean Wl;
    public boolean Wm;
    public ASN1Encodable Wn;

    public ASN1TaggedObject(boolean flag, int i, ASN1Encodable asn1encodable)
    {
        Wl = false;
        Wm = true;
        Wn = null;
        if (asn1encodable instanceof ASN1Choice)
        {
            Wm = true;
        } else
        {
            Wm = flag;
        }
        Wk = i;
        if (Wm)
        {
            Wn = asn1encodable;
            return;
        } else
        {
            asn1encodable._mth0427();
            Wn = asn1encodable;
            return;
        }
    }

    public static ASN1TaggedObject _mth02BC(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        if (asn1taggedobject.Wn != null)
        {
            asn1taggedobject = asn1taggedobject.Wn._mth0427();
        } else
        {
            asn1taggedobject = null;
        }
        return (ASN1TaggedObject)asn1taggedobject;
    }

    public static ASN1TaggedObject _mth142A(Object obj)
    {
        if (obj == null || (obj instanceof ASN1TaggedObject))
        {
            return (ASN1TaggedObject)obj;
        }
        if (obj instanceof byte[])
        {
            try
            {
                obj = _mth142A(_mth0640((byte[])obj));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new IllegalArgumentException((new StringBuilder("failed to construct tagged object from byte[]: ")).append(((IOException) (obj)).getMessage()).toString());
            }
            return ((ASN1TaggedObject) (obj));
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("unknown object in getInstance: ")).append(obj.getClass().getName()).toString());
        }
    }

    public int hashCode()
    {
        int j = Wk;
        int i = j;
        if (Wn != null)
        {
            i = j ^ Wn.hashCode();
        }
        return i;
    }

    public String toString()
    {
        return (new StringBuilder("[")).append(Wk).append("]").append(Wn).toString();
    }

    abstract void _mth02CA(ASN1OutputStream asn1outputstream);

    final boolean _mth02CA(ASN1Primitive asn1primitive)
    {
        if (!(asn1primitive instanceof ASN1TaggedObject))
        {
            return false;
        }
        asn1primitive = (ASN1TaggedObject)asn1primitive;
        if (Wk != ((ASN1TaggedObject) (asn1primitive)).Wk || Wm != ((ASN1TaggedObject) (asn1primitive)).Wm)
        {
            return false;
        }
        if (Wn == null)
        {
            if (((ASN1TaggedObject) (asn1primitive)).Wn != null)
            {
                return false;
            }
        } else
        if (!Wn._mth0427().equals(((ASN1TaggedObject) (asn1primitive)).Wn._mth0427()))
        {
            return false;
        }
        return true;
    }

    public final ASN1Primitive _mth0505()
    {
        return _mth0427();
    }

    final ASN1Primitive _mth0582()
    {
        return new DERTaggedObject(Wm, Wk, Wn);
    }

    final ASN1Primitive _mth05D7()
    {
        return new DLTaggedObject(Wm, Wk, Wn);
    }
}
