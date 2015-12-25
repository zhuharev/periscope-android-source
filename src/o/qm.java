// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            ql

final class qm extends ThreadLocal
{

    private ql PS;

    qm(ql ql)
    {
        PS = ql;
        super();
    }

    protected final Object initialValue()
    {
        return new ql.if();
    }
}
