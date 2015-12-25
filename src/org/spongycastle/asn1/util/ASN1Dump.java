// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.util;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.ASN1UTCTime;
import org.spongycastle.asn1.BERApplicationSpecific;
import org.spongycastle.asn1.BEROctetString;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.BERSet;
import org.spongycastle.asn1.BERTaggedObject;
import org.spongycastle.asn1.DERApplicationSpecific;
import org.spongycastle.asn1.DERBMPString;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERExternal;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DERPrintableString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERT61String;
import org.spongycastle.asn1.DERUTF8String;
import org.spongycastle.asn1.DERVisibleString;
import org.spongycastle.util.encoders.Hex;

public class ASN1Dump
{

    public ASN1Dump()
    {
    }

    private static String _mth02CA(String s, String s1, boolean flag, ASN1Primitive asn1primitive, String s2)
    {
        DERApplicationSpecific derapplicationspecific = (DERApplicationSpecific)asn1primitive;
        asn1primitive = new StringBuffer();
        if (derapplicationspecific.WA)
        {
            try
            {
                ASN1Sequence asn1sequence = ASN1Sequence._mth141F(derapplicationspecific._mth1466(16));
                asn1primitive.append((new StringBuilder()).append(s1).append(s).append(" ApplicationSpecific[").append(derapplicationspecific.tag).append("]").append(s2).toString());
                for (s = asn1sequence._mth0675(); s.hasMoreElements(); _mth02CA((new StringBuilder()).append(s1).append("    ").toString(), flag, (ASN1Primitive)s.nextElement(), ((StringBuffer) (asn1primitive)))) { }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                asn1primitive.append(s);
            }
            return asn1primitive.toString();
        } else
        {
            return (new StringBuilder()).append(s1).append(s).append(" ApplicationSpecific[").append(derapplicationspecific.tag).append("] (").append(new String(Hex._mth1D65(derapplicationspecific.WB))).append(")").append(s2).toString();
        }
    }

    private static String _mth02CA(String s, byte abyte0[])
    {
        String s1 = System.getProperty("line.separator");
        StringBuffer stringbuffer = new StringBuffer();
        s = (new StringBuilder()).append(s).append("    ").toString();
        stringbuffer.append(s1);
        for (int i = 0; i < abyte0.length; i += 32)
        {
            if (abyte0.length - i > 32)
            {
                stringbuffer.append(s);
                stringbuffer.append(new String(Hex.FF70(abyte0, i, 32)));
                stringbuffer.append("    ");
                stringbuffer.append(_mth037A(abyte0, i, 32));
                stringbuffer.append(s1);
                continue;
            }
            stringbuffer.append(s);
            stringbuffer.append(new String(Hex.FF70(abyte0, i, abyte0.length - i)));
            for (int j = abyte0.length - i; j != 32; j++)
            {
                stringbuffer.append("  ");
            }

            stringbuffer.append("    ");
            stringbuffer.append(_mth037A(abyte0, i, abyte0.length - i));
            stringbuffer.append(s1);
        }

        return stringbuffer.toString();
    }

    private static void _mth02CA(String s, boolean flag, ASN1Primitive asn1primitive, StringBuffer stringbuffer)
    {
        String s1 = System.getProperty("line.separator");
        if (asn1primitive instanceof ASN1Sequence)
        {
            Enumeration enumeration = ((ASN1Sequence)asn1primitive)._mth0675();
            String s3 = (new StringBuilder()).append(s).append("    ").toString();
            stringbuffer.append(s);
            if (asn1primitive instanceof BERSequence)
            {
                stringbuffer.append("BER Sequence");
            } else
            if (asn1primitive instanceof DERSequence)
            {
                stringbuffer.append("DER Sequence");
            } else
            {
                stringbuffer.append("Sequence");
            }
            stringbuffer.append(s1);
            while (enumeration.hasMoreElements()) 
            {
                s = ((String) (enumeration.nextElement()));
                if (s == null || s.equals(DERNull.WL))
                {
                    stringbuffer.append(s3);
                    stringbuffer.append("NULL");
                    stringbuffer.append(s1);
                } else
                if (s instanceof ASN1Primitive)
                {
                    _mth02CA(s3, flag, (ASN1Primitive)s, stringbuffer);
                } else
                {
                    _mth02CA(s3, flag, ((ASN1Encodable)s)._mth0427(), stringbuffer);
                }
            }
            return;
        }
        if (asn1primitive instanceof ASN1TaggedObject)
        {
            String s2 = (new StringBuilder()).append(s).append("    ").toString();
            stringbuffer.append(s);
            if (asn1primitive instanceof BERTaggedObject)
            {
                stringbuffer.append("BER Tagged [");
            } else
            {
                stringbuffer.append("Tagged [");
            }
            s = (ASN1TaggedObject)asn1primitive;
            stringbuffer.append(Integer.toString(((ASN1TaggedObject) (s)).Wk));
            stringbuffer.append(']');
            if (!((ASN1TaggedObject) (s)).Wm)
            {
                stringbuffer.append(" IMPLICIT ");
            }
            stringbuffer.append(s1);
            if (((ASN1TaggedObject) (s)).Wn != null)
            {
                s = ((ASN1TaggedObject) (s)).Wn._mth0427();
            } else
            {
                s = null;
            }
            _mth02CA(s2, flag, ((ASN1Primitive) (s)), stringbuffer);
            return;
        }
        if (asn1primitive instanceof ASN1Set)
        {
            Enumeration enumeration1 = ((ASN1Set)asn1primitive).Wf.elements();
            String s4 = (new StringBuilder()).append(s).append("    ").toString();
            stringbuffer.append(s);
            if (asn1primitive instanceof BERSet)
            {
                stringbuffer.append("BER Set");
            } else
            {
                stringbuffer.append("DER Set");
            }
            stringbuffer.append(s1);
            while (enumeration1.hasMoreElements()) 
            {
                s = ((String) (enumeration1.nextElement()));
                if (s == null)
                {
                    stringbuffer.append(s4);
                    stringbuffer.append("NULL");
                    stringbuffer.append(s1);
                } else
                if (s instanceof ASN1Primitive)
                {
                    _mth02CA(s4, flag, (ASN1Primitive)s, stringbuffer);
                } else
                {
                    _mth02CA(s4, flag, ((ASN1Encodable)s)._mth0427(), stringbuffer);
                }
            }
            return;
        }
        if (asn1primitive instanceof ASN1OctetString)
        {
            ASN1OctetString asn1octetstring = (ASN1OctetString)asn1primitive;
            if (asn1primitive instanceof BEROctetString)
            {
                stringbuffer.append((new StringBuilder()).append(s).append("BER Constructed Octet String[").append(asn1octetstring._mth0501().length).append("] ").toString());
            } else
            {
                stringbuffer.append((new StringBuilder()).append(s).append("DER Octet String[").append(asn1octetstring._mth0501().length).append("] ").toString());
            }
            if (flag)
            {
                stringbuffer.append(_mth02CA(s, asn1octetstring._mth0501()));
                return;
            } else
            {
                stringbuffer.append(s1);
                return;
            }
        }
        if (asn1primitive instanceof ASN1ObjectIdentifier)
        {
            stringbuffer.append((new StringBuilder()).append(s).append("ObjectIdentifier(").append(((ASN1ObjectIdentifier)asn1primitive).identifier).append(")").append(s1).toString());
            return;
        }
        if (asn1primitive instanceof ASN1Boolean)
        {
            s = (new StringBuilder()).append(s).append("Boolean(");
            if (((ASN1Boolean)asn1primitive).VP[0] != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            stringbuffer.append(s.append(flag).append(")").append(s1).toString());
            return;
        }
        if (asn1primitive instanceof ASN1Integer)
        {
            stringbuffer.append((new StringBuilder()).append(s).append("Integer(").append(new BigInteger(((ASN1Integer)asn1primitive).bytes)).append(")").append(s1).toString());
            return;
        }
        if (asn1primitive instanceof DERBitString)
        {
            asn1primitive = (DERBitString)asn1primitive;
            stringbuffer.append((new StringBuilder()).append(s).append("DER Bit String[").append(asn1primitive.getBytes().length).append(", ").append(asn1primitive._mth06B9()).append("] ").toString());
            if (flag)
            {
                stringbuffer.append(_mth02CA(s, asn1primitive.getBytes()));
                return;
            } else
            {
                stringbuffer.append(s1);
                return;
            }
        }
        if (asn1primitive instanceof DERIA5String)
        {
            stringbuffer.append((new StringBuilder()).append(s).append("IA5String(").append(((DERIA5String)asn1primitive).getString()).append(") ").append(s1).toString());
            return;
        }
        if (asn1primitive instanceof DERUTF8String)
        {
            stringbuffer.append((new StringBuilder()).append(s).append("UTF8String(").append(((DERUTF8String)asn1primitive).getString()).append(") ").append(s1).toString());
            return;
        }
        if (asn1primitive instanceof DERPrintableString)
        {
            stringbuffer.append((new StringBuilder()).append(s).append("PrintableString(").append(((DERPrintableString)asn1primitive).getString()).append(") ").append(s1).toString());
            return;
        }
        if (asn1primitive instanceof DERVisibleString)
        {
            stringbuffer.append((new StringBuilder()).append(s).append("VisibleString(").append(((DERVisibleString)asn1primitive).getString()).append(") ").append(s1).toString());
            return;
        }
        if (asn1primitive instanceof DERBMPString)
        {
            stringbuffer.append((new StringBuilder()).append(s).append("BMPString(").append(((DERBMPString)asn1primitive).getString()).append(") ").append(s1).toString());
            return;
        }
        if (asn1primitive instanceof DERT61String)
        {
            stringbuffer.append((new StringBuilder()).append(s).append("T61String(").append(((DERT61String)asn1primitive).getString()).append(") ").append(s1).toString());
            return;
        }
        if (asn1primitive instanceof ASN1UTCTime)
        {
            stringbuffer.append((new StringBuilder()).append(s).append("UTCTime(").append(((ASN1UTCTime)asn1primitive)._mth0437()).append(") ").append(s1).toString());
            return;
        }
        if (asn1primitive instanceof ASN1GeneralizedTime)
        {
            stringbuffer.append((new StringBuilder()).append(s).append("GeneralizedTime(").append(((ASN1GeneralizedTime)asn1primitive)._mth0437()).append(") ").append(s1).toString());
            return;
        }
        if (asn1primitive instanceof BERApplicationSpecific)
        {
            stringbuffer.append(_mth02CA("BER", s, flag, asn1primitive, s1));
            return;
        }
        if (asn1primitive instanceof DERApplicationSpecific)
        {
            stringbuffer.append(_mth02CA("DER", s, flag, asn1primitive, s1));
            return;
        }
        if (asn1primitive instanceof ASN1Enumerated)
        {
            asn1primitive = (ASN1Enumerated)asn1primitive;
            stringbuffer.append((new StringBuilder()).append(s).append("DER Enumerated(").append(new BigInteger(((ASN1Enumerated) (asn1primitive)).bytes)).append(")").append(s1).toString());
            return;
        }
        if (asn1primitive instanceof DERExternal)
        {
            asn1primitive = (DERExternal)asn1primitive;
            stringbuffer.append((new StringBuilder()).append(s).append("External ").append(s1).toString());
            s = (new StringBuilder()).append(s).append("    ").toString();
            if (((DERExternal) (asn1primitive)).WF != null)
            {
                stringbuffer.append((new StringBuilder()).append(s).append("Direct Reference: ").append(((DERExternal) (asn1primitive)).WF.identifier).append(s1).toString());
            }
            if (((DERExternal) (asn1primitive)).WG != null)
            {
                stringbuffer.append((new StringBuilder()).append(s).append("Indirect Reference: ").append(((DERExternal) (asn1primitive)).WG.toString()).append(s1).toString());
            }
            if (((DERExternal) (asn1primitive)).WH != null)
            {
                _mth02CA(s, flag, ((DERExternal) (asn1primitive)).WH, stringbuffer);
            }
            stringbuffer.append((new StringBuilder()).append(s).append("Encoding: ").append(((DERExternal) (asn1primitive)).encoding).append(s1).toString());
            _mth02CA(s, flag, ((DERExternal) (asn1primitive)).WI, stringbuffer);
            return;
        } else
        {
            stringbuffer.append((new StringBuilder()).append(s).append(asn1primitive.toString()).append(s1).toString());
            return;
        }
    }

    private static String _mth037A(byte abyte0[], int i, int j)
    {
        StringBuffer stringbuffer = new StringBuffer();
        for (int k = i; k != i + j; k++)
        {
            if (abyte0[k] >= 32 && abyte0[k] <= 126)
            {
                stringbuffer.append((char)abyte0[k]);
            }
        }

        return stringbuffer.toString();
    }

    public static String FF9E(ASN1Encodable asn1encodable)
    {
        StringBuffer stringbuffer = new StringBuffer();
        if (asn1encodable instanceof ASN1Primitive)
        {
            _mth02CA("", false, (ASN1Primitive)asn1encodable, stringbuffer);
        } else
        if (asn1encodable instanceof ASN1Encodable)
        {
            _mth02CA("", false, ((ASN1Encodable)asn1encodable)._mth0427(), stringbuffer);
        } else
        {
            return (new StringBuilder("unknown object type ")).append(asn1encodable.toString()).toString();
        }
        return stringbuffer.toString();
    }
}
