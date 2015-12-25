// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1Primitive, OIDTokenizer, ASN1Encodable, ASN1TaggedObject, 
//            ASN1OctetString, ASN1OutputStream, StreamUtil

public class ASN1ObjectIdentifier extends ASN1Primitive
{

    private static ASN1ObjectIdentifier VZ[][] = new ASN1ObjectIdentifier[256][];
    private byte VY[];
    public String identifier;

    public ASN1ObjectIdentifier(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("'identifier' cannot be null");
        }
        boolean flag;
        if (s.length() < 3 || s.charAt(1) != '.')
        {
            flag = false;
        } else
        {
            char c = s.charAt(0);
            if (c < '0' || c > '2')
            {
                flag = false;
            } else
            {
                flag = _mth02CB(s, 2);
            }
        }
        if (!flag)
        {
            throw new IllegalArgumentException((new StringBuilder("string ")).append(s).append(" not an OID").toString());
        } else
        {
            identifier = s;
            return;
        }
    }

    public ASN1ObjectIdentifier(ASN1ObjectIdentifier asn1objectidentifier, String s)
    {
        if (!_mth02CB(s, 0))
        {
            throw new IllegalArgumentException((new StringBuilder("string ")).append(s).append(" not a valid OID branch").toString());
        } else
        {
            identifier = (new StringBuilder()).append(asn1objectidentifier.identifier).append(".").append(s).toString();
            return;
        }
    }

    private ASN1ObjectIdentifier(byte abyte0[])
    {
        StringBuffer stringbuffer = new StringBuffer();
        long l1 = 0L;
        BigInteger biginteger = null;
        int i = 1;
        for (int l = 0; l != abyte0.length; l++)
        {
            int j = abyte0[l] & 0xff;
            if (l1 <= 0xffffffffffff80L)
            {
                l1 += j & 0x7f;
                if ((j & 0x80) == 0)
                {
                    long l2 = l1;
                    j = i;
                    if (i != 0)
                    {
                        if (l1 < 40L)
                        {
                            stringbuffer.append('0');
                        } else
                        if (l1 < 80L)
                        {
                            stringbuffer.append('1');
                            l1 -= 40L;
                        } else
                        {
                            stringbuffer.append('2');
                            l1 -= 80L;
                        }
                        j = 0;
                        l2 = l1;
                    }
                    stringbuffer.append('.');
                    stringbuffer.append(l2);
                    l1 = 0L;
                    i = j;
                } else
                {
                    l1 <<= 7;
                }
                continue;
            }
            BigInteger biginteger1 = biginteger;
            if (biginteger == null)
            {
                biginteger1 = BigInteger.valueOf(l1);
            }
            biginteger1 = biginteger1.or(BigInteger.valueOf(j & 0x7f));
            if ((j & 0x80) == 0)
            {
                biginteger = biginteger1;
                int k = i;
                if (i != 0)
                {
                    stringbuffer.append('2');
                    biginteger = biginteger1.subtract(BigInteger.valueOf(80L));
                    k = 0;
                }
                stringbuffer.append('.');
                stringbuffer.append(biginteger);
                biginteger = null;
                l1 = 0L;
                i = k;
            } else
            {
                biginteger = biginteger1.shiftLeft(7);
            }
        }

        identifier = stringbuffer.toString();
        VY = Arrays._mth1D4C(abyte0);
    }

    private void _mth02CA(ByteArrayOutputStream bytearrayoutputstream)
    {
        OIDTokenizer oidtokenizer = new OIDTokenizer(identifier);
        int i = Integer.parseInt(oidtokenizer.nextToken()) * 40;
        String s = oidtokenizer.nextToken();
        if (s.length() <= 18)
        {
            _mth02CA(bytearrayoutputstream, (long)i + Long.parseLong(s));
        } else
        {
            _mth02CA(bytearrayoutputstream, (new BigInteger(s)).add(BigInteger.valueOf(i)));
        }
        do
        {
            boolean flag;
            if (oidtokenizer.index != -1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                String s1 = oidtokenizer.nextToken();
                if (s1.length() <= 18)
                {
                    _mth02CA(bytearrayoutputstream, Long.parseLong(s1));
                } else
                {
                    _mth02CA(bytearrayoutputstream, new BigInteger(s1));
                }
            } else
            {
                return;
            }
        } while (true);
    }

    private static void _mth02CA(ByteArrayOutputStream bytearrayoutputstream, long l)
    {
        byte abyte0[] = new byte[9];
        int i = 8;
        for (abyte0[8] = (byte)((int)l & 0x7f); l >= 128L; abyte0[i] = (byte)((int)l & 0x7f | 0x80))
        {
            l >>= 7;
            i--;
        }

        bytearrayoutputstream.write(abyte0, i, 9 - i);
    }

    private static void _mth02CA(ByteArrayOutputStream bytearrayoutputstream, BigInteger biginteger)
    {
        int k = (biginteger.bitLength() + 6) / 7;
        if (k == 0)
        {
            bytearrayoutputstream.write(0);
            return;
        }
        byte abyte0[] = new byte[k];
        for (int i = k - 1; i >= 0; i--)
        {
            abyte0[i] = (byte)(biginteger.intValue() & 0x7f | 0x80);
            biginteger = biginteger.shiftRight(7);
        }

        int j = k - 1;
        abyte0[j] = (byte)(abyte0[j] & 0x7f);
        bytearrayoutputstream.write(abyte0, 0, k);
    }

    private static boolean _mth02CB(String s, int i)
    {
        boolean flag = false;
        int j = s.length();
        do
        {
            j--;
            if (j >= i)
            {
                char c = s.charAt(j);
                if ('0' <= c && c <= '9')
                {
                    flag = true;
                } else
                if (c == '.')
                {
                    if (!flag)
                    {
                        return false;
                    }
                    flag = false;
                } else
                {
                    return false;
                }
            } else
            {
                return flag;
            }
        } while (true);
    }

    public static ASN1ObjectIdentifier _mth02CE(ASN1Encodable asn1encodable)
    {
        if (asn1encodable == null || (asn1encodable instanceof ASN1ObjectIdentifier))
        {
            return (ASN1ObjectIdentifier)asn1encodable;
        }
        if ((asn1encodable instanceof ASN1Encodable) && (((ASN1Encodable)asn1encodable)._mth0427() instanceof ASN1ObjectIdentifier))
        {
            return (ASN1ObjectIdentifier)((ASN1Encodable)asn1encodable)._mth0427();
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("illegal object in getInstance: ")).append(asn1encodable.getClass().getName()).toString());
        }
    }

    public static ASN1ObjectIdentifier _mth02CE(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        ASN1Primitive asn1primitive;
        if (asn1taggedobject.Wn != null)
        {
            asn1primitive = asn1taggedobject.Wn._mth0427();
        } else
        {
            asn1primitive = null;
        }
        if (asn1primitive instanceof ASN1ObjectIdentifier)
        {
            return _mth02CE(((ASN1Encodable) (asn1primitive)));
        }
        if (asn1taggedobject.Wn != null)
        {
            asn1taggedobject = asn1taggedobject.Wn._mth0427();
        } else
        {
            asn1taggedobject = null;
        }
        return _mth02D1(ASN1OctetString.FB39(asn1taggedobject)._mth0501());
    }

    static ASN1ObjectIdentifier _mth02D1(byte abyte0[])
    {
        int i;
        int j;
        if (abyte0.length < 3)
        {
            return new ASN1ObjectIdentifier(abyte0);
        }
        j = abyte0[abyte0.length - 2] & 0xff;
        i = abyte0[abyte0.length - 1] & 0x7f;
        ASN1ObjectIdentifier aasn1objectidentifier1[][] = VZ;
        aasn1objectidentifier1;
        JVM INSTR monitorenter ;
        Object obj = VZ[j];
        ASN1ObjectIdentifier aasn1objectidentifier[];
        aasn1objectidentifier = ((ASN1ObjectIdentifier []) (obj));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        obj = VZ;
        aasn1objectidentifier = new ASN1ObjectIdentifier[128];
        obj[j] = aasn1objectidentifier;
        obj = aasn1objectidentifier[i];
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        abyte0 = new ASN1ObjectIdentifier(abyte0);
        aasn1objectidentifier[i] = abyte0;
        aasn1objectidentifier1;
        JVM INSTR monitorexit ;
        return abyte0;
        boolean flag = Arrays._mth1427(abyte0, ((ASN1ObjectIdentifier) (obj))._mth04BA());
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        aasn1objectidentifier1;
        JVM INSTR monitorexit ;
        return ((ASN1ObjectIdentifier) (obj));
        j = j + 1 & 0xff;
        obj = VZ[j];
        aasn1objectidentifier = ((ASN1ObjectIdentifier []) (obj));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        obj = VZ;
        aasn1objectidentifier = new ASN1ObjectIdentifier[128];
        obj[j] = aasn1objectidentifier;
        obj = aasn1objectidentifier[i];
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_185;
        }
        abyte0 = new ASN1ObjectIdentifier(abyte0);
        aasn1objectidentifier[i] = abyte0;
        aasn1objectidentifier1;
        JVM INSTR monitorexit ;
        return abyte0;
        flag = Arrays._mth1427(abyte0, ((ASN1ObjectIdentifier) (obj))._mth04BA());
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_204;
        }
        aasn1objectidentifier1;
        JVM INSTR monitorexit ;
        return ((ASN1ObjectIdentifier) (obj));
        i = i + 1 & 0x7f;
        obj = aasn1objectidentifier[i];
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_250;
        }
        abyte0 = new ASN1ObjectIdentifier(abyte0);
        aasn1objectidentifier[i] = abyte0;
        aasn1objectidentifier1;
        JVM INSTR monitorexit ;
        return abyte0;
        abyte0;
        throw abyte0;
        if (Arrays._mth1427(abyte0, ((ASN1ObjectIdentifier) (obj))._mth04BA()))
        {
            return ((ASN1ObjectIdentifier) (obj));
        } else
        {
            return new ASN1ObjectIdentifier(abyte0);
        }
    }

    private byte[] _mth04BA()
    {
        this;
        JVM INSTR monitorenter ;
        byte abyte0[];
        if (VY == null)
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            _mth02CA(bytearrayoutputstream);
            VY = bytearrayoutputstream.toByteArray();
        }
        abyte0 = VY;
        this;
        JVM INSTR monitorexit ;
        return abyte0;
        Exception exception;
        exception;
        throw exception;
    }

    public int hashCode()
    {
        return identifier.hashCode();
    }

    public String toString()
    {
        return identifier;
    }

    final void _mth02CA(ASN1OutputStream asn1outputstream)
    {
        byte abyte0[] = _mth04BA();
        asn1outputstream.write(6);
        asn1outputstream._mth1449(abyte0.length);
        asn1outputstream.Wb.write(abyte0);
    }

    public final boolean _mth02CA(ASN1ObjectIdentifier asn1objectidentifier)
    {
        String s = identifier;
        asn1objectidentifier = asn1objectidentifier.identifier;
        return s.length() > asn1objectidentifier.length() && s.charAt(asn1objectidentifier.length()) == '.' && s.startsWith(asn1objectidentifier);
    }

    final boolean _mth02CA(ASN1Primitive asn1primitive)
    {
        if (!(asn1primitive instanceof ASN1ObjectIdentifier))
        {
            return false;
        } else
        {
            return identifier.equals(((ASN1ObjectIdentifier)asn1primitive).identifier);
        }
    }

    final boolean _mth03BD()
    {
        return false;
    }

    final int _mth03DA()
    {
        int i = _mth04BA().length;
        return StreamUtil._mth14BE(i) + 1 + i;
    }

}
