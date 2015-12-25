// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Hashtable;
import java.util.Vector;

// Referenced classes of package o:
//            pf

abstract class nv extends pf
{

    protected volatile int LQ;
    protected volatile int LR;
    protected volatile int LS;

    nv(Vector vector, int i, int j, int k, int l, int i1, Hashtable hashtable)
    {
        super(vector, i, j, hashtable);
        LQ = 5;
        LR = 5000;
        LS = 0;
        LQ = k;
        LR = l;
        LS = i1;
    }
}
