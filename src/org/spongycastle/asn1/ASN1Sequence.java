// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1Primitive, ASN1EncodableVector, ASN1Encodable, ASN1TaggedObject, 
//            BERTaggedObject, BERSequence, DLSequence, ASN1SequenceParser, 
//            DERSequence, ASN1OutputStream

public abstract class ASN1Sequence extends ASN1Primitive
{

    protected Vector Wd;

    protected ASN1Sequence()
    {
        Wd = new Vector();
    }

    protected ASN1Sequence(ASN1Encodable asn1encodable)
    {
        Wd = new Vector();
        Wd.addElement(asn1encodable);
    }

    protected ASN1Sequence(ASN1EncodableVector asn1encodablevector)
    {
        Wd = new Vector();
        for (int i = 0; i != asn1encodablevector.VS.size(); i++)
        {
            Wd.addElement((ASN1Encodable)asn1encodablevector.VS.elementAt(i));
        }

    }

    protected ASN1Sequence(ASN1Encodable aasn1encodable[])
    {
        Wd = new Vector();
        for (int i = 0; i != aasn1encodable.length; i++)
        {
            Wd.addElement(aasn1encodable[i]);
        }

    }

    public static ASN1Sequence _mth141D(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        if (flag)
        {
            if (!asn1taggedobject.Wm)
            {
                throw new IllegalArgumentException("object implicit - explicit expected.");
            }
            if (asn1taggedobject.Wn != null)
            {
                asn1taggedobject = asn1taggedobject.Wn._mth0427();
            } else
            {
                asn1taggedobject = null;
            }
            return _mth141F(asn1taggedobject._mth0427());
        }
        if (asn1taggedobject.Wm)
        {
            if (asn1taggedobject instanceof BERTaggedObject)
            {
                if (asn1taggedobject.Wn != null)
                {
                    asn1taggedobject = asn1taggedobject.Wn._mth0427();
                } else
                {
                    asn1taggedobject = null;
                }
                return new BERSequence(asn1taggedobject);
            }
            if (asn1taggedobject.Wn != null)
            {
                asn1taggedobject = asn1taggedobject.Wn._mth0427();
            } else
            {
                asn1taggedobject = null;
            }
            return new DLSequence(asn1taggedobject);
        }
        ASN1Primitive asn1primitive;
        if (asn1taggedobject.Wn != null)
        {
            asn1primitive = asn1taggedobject.Wn._mth0427();
        } else
        {
            asn1primitive = null;
        }
        if (asn1primitive instanceof ASN1Sequence)
        {
            if (asn1taggedobject.Wn != null)
            {
                asn1taggedobject = asn1taggedobject.Wn._mth0427();
            } else
            {
                asn1taggedobject = null;
            }
            return (ASN1Sequence)asn1taggedobject;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("unknown object in getInstance: ")).append(asn1taggedobject.getClass().getName()).toString());
        }
    }

    public static ASN1Sequence _mth141F(Object obj)
    {
        do
        {
            if (obj == null || (obj instanceof ASN1Sequence))
            {
                return (ASN1Sequence)obj;
            }
            if (!(obj instanceof ASN1SequenceParser))
            {
                break;
            }
            obj = ((ASN1SequenceParser)obj)._mth0427();
        } while (true);
        if (obj instanceof byte[])
        {
            try
            {
                obj = _mth141F(_mth0640((byte[])obj));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new IllegalArgumentException((new StringBuilder("failed to construct sequence from byte[]: ")).append(((IOException) (obj)).getMessage()).toString());
            }
            return ((ASN1Sequence) (obj));
        }
        if (obj instanceof ASN1Encodable)
        {
            ASN1Primitive asn1primitive = ((ASN1Encodable)obj)._mth0427();
            if (asn1primitive instanceof ASN1Sequence)
            {
                return (ASN1Sequence)asn1primitive;
            }
        }
        throw new IllegalArgumentException((new StringBuilder("unknown object in getInstance: ")).append(obj.getClass().getName()).toString());
    }

    public int hashCode()
    {
        Enumeration enumeration = _mth0675();
        int i;
        for (i = size(); enumeration.hasMoreElements(); i = i * 17 ^ ((ASN1Encodable)enumeration.nextElement()).hashCode()) { }
        return i;
    }

    public int size()
    {
        return Wd.size();
    }

    public String toString()
    {
        return Wd.toString();
    }

    abstract void _mth02CA(ASN1OutputStream asn1outputstream);

    final boolean _mth02CA(ASN1Primitive asn1primitive)
    {
        if (!(asn1primitive instanceof ASN1Sequence))
        {
            return false;
        }
        Object obj = (ASN1Sequence)asn1primitive;
        if (size() != ((ASN1Sequence) (obj)).size())
        {
            return false;
        }
        asn1primitive = _mth0675();
        obj = ((ASN1Sequence) (obj))._mth0675();
        while (asn1primitive.hasMoreElements()) 
        {
            Object obj2 = (ASN1Encodable)asn1primitive.nextElement();
            Object obj1 = (ASN1Encodable)((Enumeration) (obj)).nextElement();
            obj2 = ((ASN1Encodable) (obj2))._mth0427();
            obj1 = ((ASN1Encodable) (obj1))._mth0427();
            if (obj2 != obj1 && !((ASN1Primitive) (obj2)).equals(obj1))
            {
                return false;
            }
        }
        return true;
    }

    final boolean _mth03BD()
    {
        return true;
    }

    ASN1Primitive _mth0582()
    {
        DERSequence dersequence = new DERSequence();
        dersequence.Wd = Wd;
        return dersequence;
    }

    ASN1Primitive _mth05D7()
    {
        DLSequence dlsequence = new DLSequence();
        dlsequence.Wd = Wd;
        return dlsequence;
    }

    public final ASN1Encodable[] _mth0645()
    {
        ASN1Encodable aasn1encodable[] = new ASN1Encodable[size()];
        for (int i = 0; i != size(); i++)
        {
            aasn1encodable[i] = _mth144B(i);
        }

        return aasn1encodable;
    }

    public Enumeration _mth0675()
    {
        return Wd.elements();
    }

    public ASN1Encodable _mth144B(int i)
    {
        return (ASN1Encodable)Wd.elementAt(i);
    }
}
