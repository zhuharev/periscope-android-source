// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x500.style;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.x500.AttributeTypeAndValue;
import org.spongycastle.asn1.x500.RDN;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x500.X500NameStyle;

// Referenced classes of package org.spongycastle.asn1.x500.style:
//            IETFUtils

public abstract class AbstractX500NameStyle
    implements X500NameStyle
{

    public AbstractX500NameStyle()
    {
    }

    public static Hashtable _mth02BC(Hashtable hashtable)
    {
        Hashtable hashtable1 = new Hashtable();
        Object obj;
        for (Enumeration enumeration = hashtable.keys(); enumeration.hasMoreElements(); hashtable1.put(obj, hashtable.get(obj)))
        {
            obj = enumeration.nextElement();
        }

        return hashtable1;
    }

    public final int _mth02CA(X500Name x500name)
    {
        int i = 0;
        RDN ardn[] = new RDN[x500name.agi.length];
        System.arraycopy(x500name.agi, 0, ardn, 0, ardn.length);
        for (int j = 0; j != ardn.length; j++)
        {
            boolean flag;
            if (ardn[j].agd.Wf.size() > 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                x500name = ardn[j]._mth09AC();
                for (int k = 0; k != x500name.length; k++)
                {
                    i = ((AttributeTypeAndValue) (x500name[k])).agb.hashCode() ^ i ^ IETFUtils._mth1509(IETFUtils._mth0559(((AttributeTypeAndValue) (x500name[k])).agc)).hashCode();
                }

            } else
            {
                i = ardn[j]._mth09A2().agb.hashCode() ^ i ^ IETFUtils._mth1509(IETFUtils._mth0559(ardn[j]._mth09A2().agc)).hashCode();
            }
        }

        return i;
    }

    public boolean _mth02CA(X500Name x500name, X500Name x500name1)
    {
        RDN ardn[] = new RDN[x500name.agi.length];
        System.arraycopy(x500name.agi, 0, ardn, 0, ardn.length);
        x500name = new RDN[x500name1.agi.length];
        System.arraycopy(x500name1.agi, 0, x500name, 0, x500name.length);
        if (ardn.length != x500name.length)
        {
            return false;
        }
        boolean flag1 = false;
        boolean flag = flag1;
        if (ardn[0]._mth09A2() != null)
        {
            flag = flag1;
            if (x500name[0]._mth09A2() != null)
            {
                if (!ardn[0]._mth09A2().agb.equals(x500name[0]._mth09A2().agb))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            }
        }
        for (int j = 0; j != ardn.length; j++)
        {
            int i;
label0:
            {
                x500name1 = ardn[j];
                if (flag)
                {
                    i = x500name.length - 1;
                    do
                    {
                        if (i < 0)
                        {
                            break;
                        }
                        if (x500name[i] != null && IETFUtils._mth02CA(x500name1, x500name[i]))
                        {
                            x500name[i] = null;
                            i = 1;
                            break label0;
                        }
                        i--;
                    } while (true);
                } else
                {
                    i = 0;
                    do
                    {
                        if (i == x500name.length)
                        {
                            break;
                        }
                        if (x500name[i] != null && IETFUtils._mth02CA(x500name1, x500name[i]))
                        {
                            x500name[i] = null;
                            i = 1;
                            break label0;
                        }
                        i++;
                    } while (true);
                }
                i = 0;
            }
            if (i == 0)
            {
                return false;
            }
        }

        return true;
    }
}
