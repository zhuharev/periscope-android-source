// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralSubtree;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

// Referenced classes of package org.spongycastle.jce.provider:
//            PKIXNameConstraintValidatorException

public class PKIXNameConstraintValidator
{

    private Set aHA;
    private Set aHB;
    private Set aHC;
    Set aHD;
    Set aHE;
    Set aHF;
    Set aHG;
    Set aHH;
    private Set aHy;
    private Set aHz;

    public PKIXNameConstraintValidator()
    {
        aHy = new HashSet();
        aHz = new HashSet();
        aHA = new HashSet();
        aHB = new HashSet();
        aHC = new HashSet();
    }

    private static boolean equals(Object obj, Object obj1)
    {
        if (obj == obj1)
        {
            return true;
        }
        if (obj == null || obj1 == null)
        {
            return false;
        }
        if ((obj instanceof byte[]) && (obj1 instanceof byte[]))
        {
            return Arrays._mth1427((byte[])obj, (byte[])obj1);
        } else
        {
            return obj.equals(obj1);
        }
    }

    private static String _mth0131(byte abyte0[])
    {
        String s = "";
        for (int i = 0; i < abyte0.length / 2; i++)
        {
            s = (new StringBuilder()).append(s).append(Integer.toString(abyte0[i] & 0xff)).append(".").toString();
        }

        s = s.substring(0, s.length() - 1);
        s = (new StringBuilder()).append(s).append("/").toString();
        for (int j = abyte0.length / 2; j < abyte0.length; j++)
        {
            s = (new StringBuilder()).append(s).append(Integer.toString(abyte0[j] & 0xff)).append(".").toString();
        }

        return s.substring(0, s.length() - 1);
    }

    private boolean _mth02B9(String s, String s1)
    {
        s = FE77(s);
        if (!s1.startsWith("."))
        {
            if (s.equalsIgnoreCase(s1))
            {
                return true;
            }
        } else
        if (FF9E(s, s1))
        {
            return true;
        }
        return false;
    }

    private String _mth02BB(Set set)
    {
        Object obj = (new StringBuilder()).append("").append("[").toString();
        Iterator iterator = set.iterator();
        for (set = ((Set) (obj)); iterator.hasNext(); set = (new StringBuilder()).append(set).append(_mth0131((byte[])iterator.next())).append(",").toString()) { }
        obj = set;
        if (set.length() > 1)
        {
            obj = set.substring(0, set.length() - 1);
        }
        return (new StringBuilder()).append(((String) (obj))).append("]").toString();
    }

    private boolean _mth02BB(Set set, Set set1)
    {
label0:
        {
            if (set == set1)
            {
                return true;
            }
            if (set == null || set1 == null)
            {
                return false;
            }
            if (set.size() != set1.size())
            {
                return false;
            }
            set = set.iterator();
            boolean flag;
label1:
            do
            {
                if (!set.hasNext())
                {
                    break label0;
                }
                Object obj = set.next();
                Iterator iterator = set1.iterator();
                boolean flag1 = false;
                do
                {
                    flag = flag1;
                    if (!iterator.hasNext())
                    {
                        continue label1;
                    }
                } while (!equals(obj, iterator.next()));
                flag = true;
            } while (flag);
            return false;
        }
        return true;
    }

    private static byte[] _mth02BE(byte abyte0[], byte abyte1[])
    {
        for (int i = 0; i < abyte0.length; i++)
        {
            if ((abyte0[i] & 0xffff) > (abyte1[i] & 0xffff))
            {
                return abyte0;
            }
        }

        return abyte1;
    }

    private static byte[] _mth02BF(byte abyte0[], byte abyte1[])
    {
        for (int i = 0; i < abyte0.length; i++)
        {
            if ((abyte0[i] & 0xffff) < (abyte1[i] & 0xffff))
            {
                return abyte0;
            }
        }

        return abyte1;
    }

    private static byte[] _mth02C8(byte abyte0[], byte abyte1[])
    {
        byte abyte2[] = new byte[abyte0.length];
        for (int i = 0; i < abyte0.length; i++)
        {
            abyte2[i] = (byte)(abyte0[i] | abyte1[i]);
        }

        return abyte2;
    }

    static HashSet _mth02CA(Set set, Set set1)
    {
        HashSet hashset = new HashSet();
        for (set1 = set1.iterator(); set1.hasNext();)
        {
            ASN1Sequence asn1sequence = ASN1Sequence._mth141F(((GeneralSubtree)set1.next()).ajd.Wn._mth0427());
            if (set == null)
            {
                if (asn1sequence != null)
                {
                    hashset.add(asn1sequence);
                }
            } else
            {
                Iterator iterator = set.iterator();
                while (iterator.hasNext()) 
                {
                    ASN1Sequence asn1sequence1 = (ASN1Sequence)iterator.next();
                    if (_mth02CA(asn1sequence, asn1sequence1))
                    {
                        hashset.add(asn1sequence);
                    } else
                    if (_mth02CA(asn1sequence1, asn1sequence))
                    {
                        hashset.add(asn1sequence1);
                    }
                }
            }
        }

        return hashset;
    }

    private Set _mth02CA(Set set, String s)
    {
        if (set.isEmpty())
        {
            if (s == null)
            {
                return set;
            } else
            {
                set.add(s);
                return set;
            }
        }
        HashSet hashset = new HashSet();
        for (set = set.iterator(); set.hasNext();)
        {
            String s1 = (String)set.next();
            if (FF9E(s1, s))
            {
                hashset.add(s);
            } else
            if (FF9E(s, s1))
            {
                hashset.add(s1);
            } else
            {
                hashset.add(s1);
                hashset.add(s);
            }
        }

        return hashset;
    }

    private static Set _mth02CA(Set set, ASN1Sequence asn1sequence)
    {
        if (set.isEmpty())
        {
            if (asn1sequence == null)
            {
                return set;
            } else
            {
                set.add(asn1sequence);
                return set;
            }
        }
        HashSet hashset = new HashSet();
        for (set = set.iterator(); set.hasNext();)
        {
            ASN1Sequence asn1sequence1 = (ASN1Sequence)set.next();
            if (_mth02CA(asn1sequence, asn1sequence1))
            {
                hashset.add(asn1sequence1);
            } else
            if (_mth02CA(asn1sequence1, asn1sequence))
            {
                hashset.add(asn1sequence);
            } else
            {
                hashset.add(asn1sequence1);
                hashset.add(asn1sequence);
            }
        }

        return hashset;
    }

    private Set _mth02CA(Set set, byte abyte0[])
    {
        if (set.isEmpty())
        {
            if (abyte0 == null)
            {
                return set;
            } else
            {
                set.add(abyte0);
                return set;
            }
        }
        HashSet hashset = new HashSet();
        HashSet hashset1;
        for (set = set.iterator(); set.hasNext(); hashset.addAll(hashset1))
        {
            byte abyte1[] = (byte[])set.next();
            hashset1 = new HashSet();
            if (Arrays._mth1427(abyte1, abyte0))
            {
                hashset1.add(abyte1);
            } else
            {
                hashset1.add(abyte1);
                hashset1.add(abyte0);
            }
        }

        return hashset;
    }

    private void _mth02CA(String s, String s1, HashSet hashset)
    {
        if (s.indexOf('@') != -1)
        {
            String s2 = s.substring(s.indexOf('@') + 1);
            if (s1.indexOf('@') != -1)
            {
                if (s.equalsIgnoreCase(s1))
                {
                    hashset.add(s);
                    return;
                } else
                {
                    hashset.add(s);
                    hashset.add(s1);
                    return;
                }
            }
            if (s1.startsWith("."))
            {
                if (FF9E(s2, s1))
                {
                    hashset.add(s1);
                    return;
                } else
                {
                    hashset.add(s);
                    hashset.add(s1);
                    return;
                }
            }
            if (s2.equalsIgnoreCase(s1))
            {
                hashset.add(s1);
                return;
            } else
            {
                hashset.add(s);
                hashset.add(s1);
                return;
            }
        }
        if (s.startsWith("."))
        {
            if (s1.indexOf('@') != -1)
            {
                if (FF9E(s1.substring(s.indexOf('@') + 1), s))
                {
                    hashset.add(s);
                    return;
                } else
                {
                    hashset.add(s);
                    hashset.add(s1);
                    return;
                }
            }
            if (s1.startsWith("."))
            {
                if (FF9E(s, s1) || s.equalsIgnoreCase(s1))
                {
                    hashset.add(s1);
                    return;
                }
                if (FF9E(s1, s))
                {
                    hashset.add(s);
                    return;
                } else
                {
                    hashset.add(s);
                    hashset.add(s1);
                    return;
                }
            }
            if (FF9E(s1, s))
            {
                hashset.add(s);
                return;
            } else
            {
                hashset.add(s);
                hashset.add(s1);
                return;
            }
        }
        if (s1.indexOf('@') != -1)
        {
            if (s1.substring(s.indexOf('@') + 1).equalsIgnoreCase(s))
            {
                hashset.add(s);
                return;
            } else
            {
                hashset.add(s);
                hashset.add(s1);
                return;
            }
        }
        if (s1.startsWith("."))
        {
            if (FF9E(s, s1))
            {
                hashset.add(s1);
                return;
            } else
            {
                hashset.add(s);
                hashset.add(s1);
                return;
            }
        }
        if (s.equalsIgnoreCase(s1))
        {
            hashset.add(s);
            return;
        } else
        {
            hashset.add(s);
            hashset.add(s1);
            return;
        }
    }

    private static boolean _mth02CA(ASN1Sequence asn1sequence, ASN1Sequence asn1sequence1)
    {
        if (asn1sequence1.size() <= 0)
        {
            return false;
        }
        if (asn1sequence1.size() > asn1sequence.size())
        {
            return false;
        }
        for (int i = asn1sequence1.size() - 1; i >= 0; i--)
        {
            if (!asn1sequence1._mth144B(i).equals(asn1sequence._mth144B(i)))
            {
                return false;
            }
        }

        return true;
    }

    private Set _mth02CB(Set set, String s)
    {
        if (set.isEmpty())
        {
            if (s == null)
            {
                return set;
            } else
            {
                set.add(s);
                return set;
            }
        }
        HashSet hashset = new HashSet();
        for (set = set.iterator(); set.hasNext(); _mth02CA((String)set.next(), s, hashset)) { }
        return hashset;
    }

    private static byte[][] _mth02CB(byte abyte0[], byte abyte1[], byte abyte2[], byte abyte3[])
    {
        int j = abyte0.length;
        byte abyte4[] = new byte[j];
        byte abyte5[] = new byte[j];
        byte abyte6[] = new byte[j];
        byte abyte7[] = new byte[j];
        for (int i = 0; i < j; i++)
        {
            abyte4[i] = (byte)(abyte0[i] & abyte1[i]);
            abyte5[i] = (byte)(abyte0[i] & abyte1[i] | ~abyte1[i]);
            abyte6[i] = (byte)(abyte2[i] & abyte3[i]);
            abyte7[i] = (byte)(abyte2[i] & abyte3[i] | ~abyte3[i]);
        }

        return (new byte[][] {
            abyte4, abyte5, abyte6, abyte7
        });
    }

    private static int _mth141D(Set set)
    {
        if (set == null)
        {
            return 0;
        }
        int i = 0;
        for (set = set.iterator(); set.hasNext();)
        {
            Object obj = set.next();
            if (obj instanceof byte[])
            {
                i += Arrays.hashCode((byte[])obj);
            } else
            {
                i += obj.hashCode();
            }
        }

        return i;
    }

    private static boolean _mth1FBE(byte abyte0[], byte abyte1[])
    {
        int j = abyte0.length;
        if (j != abyte1.length / 2)
        {
            return false;
        }
        byte abyte2[] = new byte[j];
        System.arraycopy(abyte1, j, abyte2, 0, j);
        byte abyte3[] = new byte[j];
        byte abyte4[] = new byte[j];
        for (int i = 0; i < j; i++)
        {
            abyte3[i] = (byte)(abyte1[i] & abyte2[i]);
            abyte4[i] = (byte)(abyte0[i] & abyte2[i]);
        }

        return Arrays._mth1427(abyte3, abyte4);
    }

    private boolean FE73(String s, String s1)
    {
        String s2 = s.substring(s.indexOf('@') + 1);
        if (s1.indexOf('@') != -1)
        {
            if (s.equalsIgnoreCase(s1))
            {
                return true;
            }
        } else
        if (s1.charAt(0) != '.')
        {
            if (s2.equalsIgnoreCase(s1))
            {
                return true;
            }
        } else
        if (FF9E(s2, s1))
        {
            return true;
        }
        return false;
    }

    private static String FE77(String s)
    {
        String s1 = s.substring(s.indexOf(':') + 1);
        s = s1;
        if (s1.indexOf("//") != -1)
        {
            s = s1.substring(s1.indexOf("//") + 2);
        }
        s1 = s;
        if (s.lastIndexOf(':') != -1)
        {
            s1 = s.substring(0, s.lastIndexOf(':'));
        }
        s = s1.substring(s1.indexOf(':') + 1);
        s1 = s.substring(s.indexOf('@') + 1);
        s = s1;
        if (s1.indexOf('/') != -1)
        {
            s = s1.substring(0, s1.indexOf('/'));
        }
        return s;
    }

    private static boolean FF9E(String s, String s1)
    {
        String s2 = s1;
        if (s1.startsWith("."))
        {
            s2 = s1.substring(1);
        }
        s1 = Strings._mth02CA(s2, '.');
        s = Strings._mth02CA(s, '.');
        if (s.length <= s1.length)
        {
            return false;
        }
        int j = s.length - s1.length;
        for (int i = -1; i < s1.length; i++)
        {
            if (i == -1)
            {
                if (s[i + j].equals(""))
                {
                    return false;
                }
                continue;
            }
            if (!s1[i].equalsIgnoreCase(s[i + j]))
            {
                return false;
            }
        }

        return true;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof PKIXNameConstraintValidator))
        {
            return false;
        }
        obj = (PKIXNameConstraintValidator)obj;
        return _mth02BB(((PKIXNameConstraintValidator) (obj)).aHy, aHy) && _mth02BB(((PKIXNameConstraintValidator) (obj)).aHz, aHz) && _mth02BB(((PKIXNameConstraintValidator) (obj)).aHA, aHA) && _mth02BB(((PKIXNameConstraintValidator) (obj)).aHC, aHC) && _mth02BB(((PKIXNameConstraintValidator) (obj)).aHB, aHB) && _mth02BB(((PKIXNameConstraintValidator) (obj)).aHD, aHD) && _mth02BB(((PKIXNameConstraintValidator) (obj)).aHE, aHE) && _mth02BB(((PKIXNameConstraintValidator) (obj)).aHF, aHF) && _mth02BB(((PKIXNameConstraintValidator) (obj)).aHH, aHH) && _mth02BB(((PKIXNameConstraintValidator) (obj)).aHG, aHG);
    }

    public int hashCode()
    {
        return _mth141D(aHy) + _mth141D(aHz) + _mth141D(aHA) + _mth141D(aHC) + _mth141D(aHB) + _mth141D(aHD) + _mth141D(aHE) + _mth141D(aHF) + _mth141D(aHH) + _mth141D(aHG);
    }

    public String toString()
    {
        String s1 = (new StringBuilder()).append("").append("permitted:\n").toString();
        String s = s1;
        if (aHD != null)
        {
            s = (new StringBuilder()).append(s1).append("DN:\n").toString();
            s = (new StringBuilder()).append(s).append(aHD.toString()).append("\n").toString();
        }
        s1 = s;
        if (aHE != null)
        {
            s = (new StringBuilder()).append(s).append("DNS:\n").toString();
            s1 = (new StringBuilder()).append(s).append(aHE.toString()).append("\n").toString();
        }
        s = s1;
        if (aHF != null)
        {
            s = (new StringBuilder()).append(s1).append("Email:\n").toString();
            s = (new StringBuilder()).append(s).append(aHF.toString()).append("\n").toString();
        }
        s1 = s;
        if (aHG != null)
        {
            s = (new StringBuilder()).append(s).append("URI:\n").toString();
            s1 = (new StringBuilder()).append(s).append(aHG.toString()).append("\n").toString();
        }
        s = s1;
        if (aHH != null)
        {
            s = (new StringBuilder()).append(s1).append("IP:\n").toString();
            s = (new StringBuilder()).append(s).append(_mth02BB(aHH)).append("\n").toString();
        }
        s1 = (new StringBuilder()).append(s).append("excluded:\n").toString();
        s = s1;
        if (!aHy.isEmpty())
        {
            s = (new StringBuilder()).append(s1).append("DN:\n").toString();
            s = (new StringBuilder()).append(s).append(aHy.toString()).append("\n").toString();
        }
        s1 = s;
        if (!aHz.isEmpty())
        {
            s = (new StringBuilder()).append(s).append("DNS:\n").toString();
            s1 = (new StringBuilder()).append(s).append(aHz.toString()).append("\n").toString();
        }
        s = s1;
        if (!aHA.isEmpty())
        {
            s = (new StringBuilder()).append(s1).append("Email:\n").toString();
            s = (new StringBuilder()).append(s).append(aHA.toString()).append("\n").toString();
        }
        s1 = s;
        if (!aHB.isEmpty())
        {
            s = (new StringBuilder()).append(s).append("URI:\n").toString();
            s1 = (new StringBuilder()).append(s).append(aHB.toString()).append("\n").toString();
        }
        s = s1;
        if (!aHC.isEmpty())
        {
            s = (new StringBuilder()).append(s1).append("IP:\n").toString();
            s = (new StringBuilder()).append(s).append(_mth02BB(aHC)).append("\n").toString();
        }
        return s;
    }

    public final void _mth02CA(GeneralName generalname)
    {
        switch (generalname.tag)
        {
        default:
            return;

        case 3: // '\003'
        case 5: // '\005'
            break;

        case 1: // '\001'
label0:
            {
                Set set = aHF;
                generalname = DERIA5String._mth02BB(generalname.Wn).getString();
                if (set == null)
                {
                    break label0;
                }
                for (Iterator iterator = set.iterator(); iterator.hasNext();)
                {
                    if (FE73(generalname, (String)iterator.next()))
                    {
                        break label0;
                    }
                }

                if (generalname.length() != 0 || set.size() != 0)
                {
                    throw new PKIXNameConstraintValidatorException("Subject email address is not from a permitted subtree.");
                }
            }
            return;

        case 2: // '\002'
            Set set1 = aHE;
            generalname = DERIA5String._mth02BB(generalname.Wn).getString();
            if (set1 != null)
            {
                for (Iterator iterator1 = set1.iterator(); iterator1.hasNext();)
                {
                    String s = (String)iterator1.next();
                    if (FF9E(generalname, s) || generalname.equalsIgnoreCase(s))
                    {
                        return;
                    }
                }

                if (generalname.length() != 0 || set1.size() != 0)
                {
                    throw new PKIXNameConstraintValidatorException("DNS is not from a permitted subtree.");
                }
            }
            return;

        case 4: // '\004'
            _mth037A(ASN1Sequence._mth141F(generalname.Wn._mth0427()));
            return;

        case 6: // '\006'
label1:
            {
                Set set2 = aHG;
                generalname = DERIA5String._mth02BB(generalname.Wn).getString();
                if (set2 == null)
                {
                    break label1;
                }
                for (Iterator iterator2 = set2.iterator(); iterator2.hasNext();)
                {
                    if (_mth02B9(generalname, (String)iterator2.next()))
                    {
                        break label1;
                    }
                }

                if (generalname.length() != 0 || set2.size() != 0)
                {
                    throw new PKIXNameConstraintValidatorException("URI is not from a permitted subtree.");
                }
            }
            return;

        case 7: // '\007'
            generalname = ASN1OctetString.FB39(generalname.Wn)._mth0501();
            Set set3 = aHH;
            if (set3 == null)
            {
                break MISSING_BLOCK_LABEL_411;
            }
            for (Iterator iterator3 = set3.iterator(); iterator3.hasNext();)
            {
                if (_mth1FBE(generalname, (byte[])iterator3.next()))
                {
                    break MISSING_BLOCK_LABEL_411;
                }
            }

            if (generalname.length != 0 || set3.size() != 0)
            {
                throw new PKIXNameConstraintValidatorException("IP is not from a permitted subtree.");
            }
            break;
        }
    }

    public final void _mth02CA(GeneralSubtree generalsubtree)
    {
        Object obj = generalsubtree.ajd;
        switch (((GeneralName) (obj)).tag)
        {
        default:
            return;

        case 1: // '\001'
            generalsubtree = aHA;
            String s = DERIA5String._mth02BB(((GeneralName) (obj)).Wn).getString();
            if (generalsubtree.isEmpty())
            {
                if (s != null)
                {
                    generalsubtree.add(s);
                }
            } else
            {
                obj = new HashSet();
                for (generalsubtree = generalsubtree.iterator(); generalsubtree.hasNext();)
                {
                    String s1 = (String)generalsubtree.next();
                    if (s1.indexOf('@') != -1)
                    {
                        String s2 = s1.substring(s1.indexOf('@') + 1);
                        if (s.indexOf('@') != -1)
                        {
                            if (s1.equalsIgnoreCase(s))
                            {
                                ((Set) (obj)).add(s1);
                            } else
                            {
                                ((Set) (obj)).add(s1);
                                ((Set) (obj)).add(s);
                            }
                        } else
                        if (s.startsWith("."))
                        {
                            if (FF9E(s2, s))
                            {
                                ((Set) (obj)).add(s);
                            } else
                            {
                                ((Set) (obj)).add(s1);
                                ((Set) (obj)).add(s);
                            }
                        } else
                        if (s2.equalsIgnoreCase(s))
                        {
                            ((Set) (obj)).add(s);
                        } else
                        {
                            ((Set) (obj)).add(s1);
                            ((Set) (obj)).add(s);
                        }
                    } else
                    if (s1.startsWith("."))
                    {
                        if (s.indexOf('@') != -1)
                        {
                            if (FF9E(s.substring(s1.indexOf('@') + 1), s1))
                            {
                                ((Set) (obj)).add(s1);
                            } else
                            {
                                ((Set) (obj)).add(s1);
                                ((Set) (obj)).add(s);
                            }
                        } else
                        if (s.startsWith("."))
                        {
                            if (FF9E(s1, s) || s1.equalsIgnoreCase(s))
                            {
                                ((Set) (obj)).add(s);
                            } else
                            if (FF9E(s, s1))
                            {
                                ((Set) (obj)).add(s1);
                            } else
                            {
                                ((Set) (obj)).add(s1);
                                ((Set) (obj)).add(s);
                            }
                        } else
                        if (FF9E(s, s1))
                        {
                            ((Set) (obj)).add(s1);
                        } else
                        {
                            ((Set) (obj)).add(s1);
                            ((Set) (obj)).add(s);
                        }
                    } else
                    if (s.indexOf('@') != -1)
                    {
                        if (s.substring(s1.indexOf('@') + 1).equalsIgnoreCase(s1))
                        {
                            ((Set) (obj)).add(s1);
                        } else
                        {
                            ((Set) (obj)).add(s1);
                            ((Set) (obj)).add(s);
                        }
                    } else
                    if (s.startsWith("."))
                    {
                        if (FF9E(s1, s))
                        {
                            ((Set) (obj)).add(s);
                        } else
                        {
                            ((Set) (obj)).add(s1);
                            ((Set) (obj)).add(s);
                        }
                    } else
                    if (s1.equalsIgnoreCase(s))
                    {
                        ((Set) (obj)).add(s1);
                    } else
                    {
                        ((Set) (obj)).add(s1);
                        ((Set) (obj)).add(s);
                    }
                }

                generalsubtree = ((GeneralSubtree) (obj));
            }
            aHA = generalsubtree;
            return;

        case 2: // '\002'
            aHz = _mth02CA(aHz, DERIA5String._mth02BB(((GeneralName) (obj)).Wn).getString());
            return;

        case 4: // '\004'
            aHy = _mth02CA(aHy, (ASN1Sequence)((GeneralName) (obj)).Wn._mth0427());
            return;

        case 6: // '\006'
            aHB = _mth02CB(aHB, DERIA5String._mth02BB(((GeneralName) (obj)).Wn).getString());
            return;

        case 7: // '\007'
            aHC = _mth02CA(aHC, ASN1OctetString.FB39(((GeneralName) (obj)).Wn)._mth0501());
            // fall through

        case 3: // '\003'
        case 5: // '\005'
            return;
        }
    }

    HashSet _mth02CB(Set set, Set set1)
    {
        HashSet hashset = new HashSet();
        for (set1 = set1.iterator(); set1.hasNext();)
        {
            String s = DERIA5String._mth02BB(((GeneralSubtree)set1.next()).ajd.Wn).getString();
            if (set == null)
            {
                if (s != null)
                {
                    hashset.add(s);
                }
            } else
            {
                Iterator iterator = set.iterator();
                while (iterator.hasNext()) 
                {
                    String s1 = (String)iterator.next();
                    if (s.indexOf('@') != -1)
                    {
                        String s2 = s.substring(s.indexOf('@') + 1);
                        if (s1.indexOf('@') != -1)
                        {
                            if (s.equalsIgnoreCase(s1))
                            {
                                hashset.add(s);
                            }
                        } else
                        if (s1.startsWith("."))
                        {
                            if (FF9E(s2, s1))
                            {
                                hashset.add(s);
                            }
                        } else
                        if (s2.equalsIgnoreCase(s1))
                        {
                            hashset.add(s);
                        }
                    } else
                    if (s.startsWith("."))
                    {
                        if (s1.indexOf('@') != -1)
                        {
                            if (FF9E(s1.substring(s.indexOf('@') + 1), s))
                            {
                                hashset.add(s1);
                            }
                        } else
                        if (s1.startsWith("."))
                        {
                            if (FF9E(s, s1) || s.equalsIgnoreCase(s1))
                            {
                                hashset.add(s);
                            } else
                            if (FF9E(s1, s))
                            {
                                hashset.add(s1);
                            }
                        } else
                        if (FF9E(s1, s))
                        {
                            hashset.add(s1);
                        }
                    } else
                    if (s1.indexOf('@') != -1)
                    {
                        if (s1.substring(s1.indexOf('@') + 1).equalsIgnoreCase(s))
                        {
                            hashset.add(s1);
                        }
                    } else
                    if (s1.startsWith("."))
                    {
                        if (FF9E(s, s1))
                        {
                            hashset.add(s);
                        }
                    } else
                    if (s.equalsIgnoreCase(s1))
                    {
                        hashset.add(s);
                    }
                }
            }
        }

        return hashset;
    }

    public final void _mth02CB(GeneralName generalname)
    {
        generalname.tag;
        JVM INSTR tableswitch 1 7: default 48
    //                   1 49
    //                   2 122
    //                   3 365
    //                   4 204
    //                   5 365
    //                   6 221
    //                   7 294;
           goto _L1 _L2 _L3 _L4 _L5 _L4 _L6 _L7
_L4:
        break MISSING_BLOCK_LABEL_365;
_L1:
        return;
_L2:
        Object obj;
        obj = aHA;
        generalname = DERIA5String._mth02BB(generalname.Wn).getString();
        if (((Set) (obj)).isEmpty()) goto _L9; else goto _L8
_L8:
        obj = ((Set) (obj)).iterator();
_L12:
        if (!((Iterator) (obj)).hasNext()) goto _L9; else goto _L10
_L10:
        if (!FE73(generalname, (String)((Iterator) (obj)).next())) goto _L12; else goto _L11
_L11:
        throw new PKIXNameConstraintValidatorException("Email address is from an excluded subtree.");
_L9:
        return;
_L3:
        obj = aHz;
        generalname = DERIA5String._mth02BB(generalname.Wn).getString();
        if (((Set) (obj)).isEmpty()) goto _L14; else goto _L13
_L13:
        obj = ((Set) (obj)).iterator();
_L17:
        if (!((Iterator) (obj)).hasNext()) goto _L14; else goto _L15
_L15:
        String s = (String)((Iterator) (obj)).next();
        if (!FF9E(generalname, s) && !generalname.equalsIgnoreCase(s)) goto _L17; else goto _L16
_L16:
        throw new PKIXNameConstraintValidatorException("DNS is from an excluded subtree.");
_L14:
        return;
_L5:
        _mth1FBE(ASN1Sequence._mth141F(generalname.Wn._mth0427()));
        return;
_L6:
        obj = aHB;
        generalname = DERIA5String._mth02BB(generalname.Wn).getString();
        if (((Set) (obj)).isEmpty()) goto _L19; else goto _L18
_L18:
        obj = ((Set) (obj)).iterator();
_L22:
        if (!((Iterator) (obj)).hasNext()) goto _L19; else goto _L20
_L20:
        if (!_mth02B9(generalname, (String)((Iterator) (obj)).next())) goto _L22; else goto _L21
_L21:
        throw new PKIXNameConstraintValidatorException("URI is from an excluded subtree.");
_L19:
        return;
_L7:
        generalname = ASN1OctetString.FB39(generalname.Wn)._mth0501();
        Object obj1 = aHC;
        if (((Set) (obj1)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_365;
        }
        obj1 = ((Set) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break MISSING_BLOCK_LABEL_365;
            }
        } while (!_mth1FBE(generalname, (byte[])((Iterator) (obj1)).next()));
        throw new PKIXNameConstraintValidatorException("IP is from an excluded subtree.");
    }

    HashSet _mth02CE(Set set, Set set1)
    {
        HashSet hashset = new HashSet();
        Iterator iterator = set1.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            byte abyte0[] = ASN1OctetString.FB39(((GeneralSubtree)iterator.next()).ajd.Wn)._mth0501();
            if (set == null)
            {
                if (abyte0 != null)
                {
                    hashset.add(abyte0);
                }
            } else
            {
                Iterator iterator1 = set.iterator();
                while (iterator1.hasNext()) 
                {
                    Object obj = (byte[])iterator1.next();
                    if (obj.length != abyte0.length)
                    {
                        set1 = Collections.EMPTY_SET;
                    } else
                    {
                        int i = obj.length / 2;
                        set1 = new byte[i];
                        Object obj1 = new byte[i];
                        System.arraycopy(obj, 0, set1, 0, i);
                        System.arraycopy(obj, i, obj1, 0, i);
                        byte abyte3[] = new byte[i];
                        byte abyte4[] = new byte[i];
                        System.arraycopy(abyte0, 0, abyte3, 0, i);
                        System.arraycopy(abyte0, i, abyte4, 0, i);
                        obj = new byte[4][];
                        obj[0] = set1;
                        obj[1] = ((byte []) (obj1));
                        obj[2] = abyte3;
                        obj[3] = abyte4;
                        obj1 = obj[0];
                        set1 = obj[1];
                        abyte3 = obj[2];
                        byte abyte1[] = obj[3];
                        obj1 = _mth02CB(((byte []) (obj1)), set1, abyte3, abyte1);
                        abyte3 = _mth02BF(obj1[1], obj1[3]);
                        abyte4 = _mth02BE(obj1[0], obj1[2]);
                        if (Arrays._mth1427(abyte4, abyte3))
                        {
                            i = 0;
                        } else
                        if (Arrays._mth1427(_mth02BE(abyte4, abyte3), abyte4))
                        {
                            i = 1;
                        } else
                        {
                            i = -1;
                        }
                        if (i == 1)
                        {
                            set1 = Collections.EMPTY_SET;
                        } else
                        {
                            byte abyte2[] = _mth02C8(obj1[0], obj1[2]);
                            set1 = _mth02C8(set1, abyte1);
                            int j = abyte2.length;
                            abyte1 = new byte[j << 1];
                            System.arraycopy(abyte2, 0, abyte1, 0, j);
                            System.arraycopy(set1, 0, abyte1, j, j);
                            set1 = Collections.singleton(abyte1);
                        }
                    }
                    hashset.addAll(set1);
                }
            }
        } while (true);
        return hashset;
    }

    HashSet _mth02CF(Set set, Set set1)
    {
        HashSet hashset = new HashSet();
        for (set1 = set1.iterator(); set1.hasNext();)
        {
            String s = DERIA5String._mth02BB(((GeneralSubtree)set1.next()).ajd.Wn).getString();
            if (set == null)
            {
                if (s != null)
                {
                    hashset.add(s);
                }
            } else
            {
                Iterator iterator = set.iterator();
                while (iterator.hasNext()) 
                {
                    String s1 = (String)iterator.next();
                    if (FF9E(s1, s))
                    {
                        hashset.add(s1);
                    } else
                    if (FF9E(s, s1))
                    {
                        hashset.add(s);
                    }
                }
            }
        }

        return hashset;
    }

    public final void _mth037A(ASN1Sequence asn1sequence)
    {
label0:
        {
            Object obj = aHD;
            if (obj == null || ((Set) (obj)).isEmpty() && asn1sequence.size() == 0)
            {
                break label0;
            }
            for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
            {
                if (_mth02CA(asn1sequence, (ASN1Sequence)((Iterator) (obj)).next()))
                {
                    break label0;
                }
            }

            throw new PKIXNameConstraintValidatorException("Subject distinguished name is not from a permitted subtree");
        }
    }

    HashSet _mth141D(Set set, Set set1)
    {
        HashSet hashset = new HashSet();
        for (set1 = set1.iterator(); set1.hasNext();)
        {
            String s = DERIA5String._mth02BB(((GeneralSubtree)set1.next()).ajd.Wn).getString();
            if (set == null)
            {
                if (s != null)
                {
                    hashset.add(s);
                }
            } else
            {
                Iterator iterator = set.iterator();
                while (iterator.hasNext()) 
                {
                    String s1 = (String)iterator.next();
                    if (s1.indexOf('@') != -1)
                    {
                        String s2 = s1.substring(s1.indexOf('@') + 1);
                        if (s.indexOf('@') != -1)
                        {
                            if (s1.equalsIgnoreCase(s))
                            {
                                hashset.add(s1);
                            }
                        } else
                        if (s.startsWith("."))
                        {
                            if (FF9E(s2, s))
                            {
                                hashset.add(s1);
                            }
                        } else
                        if (s2.equalsIgnoreCase(s))
                        {
                            hashset.add(s1);
                        }
                    } else
                    if (s1.startsWith("."))
                    {
                        if (s.indexOf('@') != -1)
                        {
                            if (FF9E(s.substring(s1.indexOf('@') + 1), s1))
                            {
                                hashset.add(s);
                            }
                        } else
                        if (s.startsWith("."))
                        {
                            if (FF9E(s1, s) || s1.equalsIgnoreCase(s))
                            {
                                hashset.add(s1);
                            } else
                            if (FF9E(s, s1))
                            {
                                hashset.add(s);
                            }
                        } else
                        if (FF9E(s, s1))
                        {
                            hashset.add(s);
                        }
                    } else
                    if (s.indexOf('@') != -1)
                    {
                        if (s.substring(s.indexOf('@') + 1).equalsIgnoreCase(s1))
                        {
                            hashset.add(s);
                        }
                    } else
                    if (s.startsWith("."))
                    {
                        if (FF9E(s1, s))
                        {
                            hashset.add(s1);
                        }
                    } else
                    if (s1.equalsIgnoreCase(s))
                    {
                        hashset.add(s1);
                    }
                }
            }
        }

        return hashset;
    }

    public final void _mth1FBE(ASN1Sequence asn1sequence)
    {
label0:
        {
            Object obj = aHy;
            if (((Set) (obj)).isEmpty())
            {
                break label0;
            }
            obj = ((Set) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
            } while (!_mth02CA(asn1sequence, (ASN1Sequence)((Iterator) (obj)).next()));
            throw new PKIXNameConstraintValidatorException("Subject distinguished name is from an excluded subtree");
        }
    }
}
