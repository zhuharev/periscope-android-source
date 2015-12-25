// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x500;

import java.util.Vector;
import org.spongycastle.asn1.x500.style.BCStyle;

// Referenced classes of package org.spongycastle.asn1.x500:
//            X500NameStyle

public class X500NameBuilder
{

    private X500NameStyle agj;
    private Vector agk;

    public X500NameBuilder()
    {
        this(((X500NameStyle) (BCStyle.agU)));
    }

    public X500NameBuilder(X500NameStyle x500namestyle)
    {
        agk = new Vector();
        agj = x500namestyle;
    }
}
