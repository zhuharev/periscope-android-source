// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1Primitive, ASN1EncodableVector, ASN1Encodable, ASN1TaggedObject, 
//            BERTaggedObject, BERSet, DLSet, ASN1Sequence, 
//            ASN1OutputStream, ASN1SetParser, DERNull, DERSet

public abstract class ASN1Set extends ASN1Primitive
{

    public Vector Wf;
    private boolean Wg;

    protected ASN1Set()
    {
        Wf = new Vector();
        Wg = false;
    }

    protected ASN1Set(ASN1Encodable asn1encodable)
    {
        Wf = new Vector();
        Wg = false;
        Wf.addElement(asn1encodable);
    }

    protected ASN1Set(ASN1EncodableVector asn1encodablevector, boolean flag)
    {
        Wf = new Vector();
        Wg = false;
        for (int i = 0; i != asn1encodablevector.VS.size(); i++)
        {
            Wf.addElement((ASN1Encodable)asn1encodablevector.VS.elementAt(i));
        }

        if (flag)
        {
            sort();
        }
    }

    protected ASN1Set(ASN1Encodable aasn1encodable[], boolean flag)
    {
        Wf = new Vector();
        Wg = false;
        for (int i = 0; i != aasn1encodable.length; i++)
        {
            Wf.addElement(aasn1encodable[i]);
        }

        if (flag)
        {
            sort();
        }
    }

    private void sort()
    {
        if (!Wg)
        {
            Wg = true;
            if (Wf.size() > 1)
            {
                boolean flag = true;
                int l = Wf.size() - 1;
                do
                {
                    if (!flag)
                    {
                        break;
                    }
                    int j = 0;
                    int k = 0;
                    byte abyte0[] = _mth141D((ASN1Encodable)Wf.elementAt(0));
                    flag = false;
                    for (; j != l; j++)
                    {
                        byte abyte1[];
                        int i;
label0:
                        {
                            abyte1 = _mth141D((ASN1Encodable)Wf.elementAt(j + 1));
                            int i1 = Math.min(abyte0.length, abyte1.length);
                            i = 0;
                            do
                            {
                                if (i == i1)
                                {
                                    break;
                                }
                                if (abyte0[i] != abyte1[i])
                                {
                                    if ((abyte0[i] & 0xff) < (abyte1[i] & 0xff))
                                    {
                                        i = 1;
                                    } else
                                    {
                                        i = 0;
                                    }
                                    break label0;
                                }
                                i++;
                            } while (true);
                            if (i1 == abyte0.length)
                            {
                                i = 1;
                            } else
                            {
                                i = 0;
                            }
                        }
                        if (i != 0)
                        {
                            abyte0 = abyte1;
                        } else
                        {
                            Object obj = Wf.elementAt(j);
                            Wf.setElementAt(Wf.elementAt(j + 1), j);
                            Wf.setElementAt(obj, j + 1);
                            flag = true;
                            k = j;
                        }
                    }

                    l = k;
                } while (true);
            }
        }
    }

    public static ASN1Set _mth02BB(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
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
                return new BERSet(asn1taggedobject);
            }
            if (asn1taggedobject.Wn != null)
            {
                asn1taggedobject = asn1taggedobject.Wn._mth0427();
            } else
            {
                asn1taggedobject = null;
            }
            return new DLSet(asn1taggedobject);
        }
        ASN1Primitive asn1primitive;
        if (asn1taggedobject.Wn != null)
        {
            asn1primitive = asn1taggedobject.Wn._mth0427();
        } else
        {
            asn1primitive = null;
        }
        if (asn1primitive instanceof ASN1Set)
        {
            if (asn1taggedobject.Wn != null)
            {
                asn1taggedobject = asn1taggedobject.Wn._mth0427();
            } else
            {
                asn1taggedobject = null;
            }
            return (ASN1Set)asn1taggedobject;
        }
        if (asn1taggedobject.Wn != null)
        {
            asn1primitive = asn1taggedobject.Wn._mth0427();
        } else
        {
            asn1primitive = null;
        }
        if (asn1primitive instanceof ASN1Sequence)
        {
            Object obj;
            if (asn1taggedobject.Wn != null)
            {
                obj = asn1taggedobject.Wn._mth0427();
            } else
            {
                obj = null;
            }
            obj = (ASN1Sequence)obj;
            if (asn1taggedobject instanceof BERTaggedObject)
            {
                return new BERSet(((ASN1Sequence) (obj))._mth0645());
            } else
            {
                return new DLSet(((ASN1Sequence) (obj))._mth0645());
            }
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("unknown object in getInstance: ")).append(asn1taggedobject.getClass().getName()).toString());
        }
    }

    private static byte[] _mth141D(ASN1Encodable asn1encodable)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        ASN1OutputStream asn1outputstream = new ASN1OutputStream(bytearrayoutputstream);
        try
        {
            asn1outputstream._mth02CF(asn1encodable);
        }
        // Misplaced declaration of an exception variable
        catch (ASN1Encodable asn1encodable)
        {
            throw new IllegalArgumentException("cannot encode object added to SET");
        }
        return bytearrayoutputstream.toByteArray();
    }

    public static ASN1Set _mth1421(Object obj)
    {
        do
        {
            if (obj == null || (obj instanceof ASN1Set))
            {
                return (ASN1Set)obj;
            }
            if (!(obj instanceof ASN1SetParser))
            {
                break;
            }
            obj = ((ASN1SetParser)obj)._mth0427();
        } while (true);
        if (obj instanceof byte[])
        {
            try
            {
                obj = _mth1421(ASN1Primitive._mth0640((byte[])obj));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new IllegalArgumentException((new StringBuilder("failed to construct set from byte[]: ")).append(((IOException) (obj)).getMessage()).toString());
            }
            return ((ASN1Set) (obj));
        }
        if (obj instanceof ASN1Encodable)
        {
            ASN1Primitive asn1primitive = ((ASN1Encodable)obj)._mth0427();
            if (asn1primitive instanceof ASN1Set)
            {
                return (ASN1Set)asn1primitive;
            }
        }
        throw new IllegalArgumentException((new StringBuilder("unknown object in getInstance: ")).append(obj.getClass().getName()).toString());
    }

    public int hashCode()
    {
        Enumeration enumeration = Wf.elements();
        Object obj;
        int i;
        for (i = Wf.size(); enumeration.hasMoreElements(); i = i * 17 ^ obj.hashCode())
        {
            obj = (ASN1Encodable)enumeration.nextElement();
            if (obj == null)
            {
                obj = DERNull.WL;
            }
        }

        return i;
    }

    public String toString()
    {
        return Wf.toString();
    }

    abstract void _mth02CA(ASN1OutputStream asn1outputstream);

    final boolean _mth02CA(ASN1Primitive asn1primitive)
    {
        if (!(asn1primitive instanceof ASN1Set))
        {
            return false;
        }
        asn1primitive = (ASN1Set)asn1primitive;
        if (Wf.size() != ((ASN1Set) (asn1primitive)).Wf.size())
        {
            return false;
        }
        Enumeration enumeration = Wf.elements();
        Enumeration enumeration1 = ((ASN1Set) (asn1primitive)).Wf.elements();
        while (enumeration.hasMoreElements()) 
        {
            asn1primitive = (ASN1Encodable)enumeration.nextElement();
            if (asn1primitive == null)
            {
                asn1primitive = DERNull.WL;
            }
            Object obj = (ASN1Encodable)enumeration1.nextElement();
            if (obj == null)
            {
                obj = DERNull.WL;
            }
            asn1primitive = asn1primitive._mth0427();
            obj = ((ASN1Encodable) (obj))._mth0427();
            if (asn1primitive != obj && !asn1primitive.equals(obj))
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

    final ASN1Primitive _mth0582()
    {
        if (Wg)
        {
            DERSet derset = new DERSet();
            derset.Wf = Wf;
            return derset;
        }
        Vector vector = new Vector();
        for (int i = 0; i != Wf.size(); i++)
        {
            vector.addElement(Wf.elementAt(i));
        }

        DERSet derset1 = new DERSet();
        derset1.Wf = vector;
        derset1.sort();
        return derset1;
    }

    final ASN1Primitive _mth05D7()
    {
        DLSet dlset = new DLSet();
        dlset.Wf = Wf;
        return dlset;
    }
}
