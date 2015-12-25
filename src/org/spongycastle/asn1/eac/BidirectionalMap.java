// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.eac;

import java.util.Hashtable;

public class BidirectionalMap extends Hashtable
{

    private Hashtable YD;

    public BidirectionalMap()
    {
        YD = new Hashtable();
    }

    public Object put(Object obj, Object obj1)
    {
        YD.put(obj1, obj);
        return super.put(obj, obj1);
    }
}
