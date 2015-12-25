// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x500.style;

import org.spongycastle.asn1.x500.RDN;
import org.spongycastle.asn1.x500.X500Name;

// Referenced classes of package org.spongycastle.asn1.x500.style:
//            BCStyle, IETFUtils

public class BCStrictStyle extends BCStyle
{

    public BCStrictStyle()
    {
    }

    public final boolean _mth02CA(X500Name x500name, X500Name x500name1)
    {
        RDN ardn[] = new RDN[x500name.agi.length];
        System.arraycopy(x500name.agi, 0, ardn, 0, ardn.length);
        x500name = new RDN[x500name1.agi.length];
        System.arraycopy(x500name1.agi, 0, x500name, 0, x500name.length);
        if (ardn.length != x500name.length)
        {
            return false;
        }
        for (int i = 0; i != ardn.length; i++)
        {
            if (!IETFUtils._mth02CA(ardn[i], x500name[i]))
            {
                return false;
            }
        }

        return true;
    }

    static 
    {
        new BCStrictStyle();
    }
}
