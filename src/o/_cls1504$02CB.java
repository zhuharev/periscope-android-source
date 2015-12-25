// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls1504, _cls152D, _cls1595

public static class ring extends Enum
{

    private static oq oo;
    public static final _cls152D op;
    private static _cls1595 oq;
    private static final oq or[];

    public static ring valueOf(String s)
    {
        return (ring)Enum.valueOf(o/1504$02CB, s);
    }

    public static ring[] values()
    {
        return (ring[])or.clone();
    }

    protected void _mth02CA(Throwable throwable)
    {
    }

    static 
    {
        oo = new <init>("IGNORE", 0);
        op = new _cls152D("LOG", 1);
        oq = new _cls1595("THROW", 2);
        or = (new or[] {
            oo, op, oq
        });
    }

    private ring(String s, int i)
    {
        super(s, i);
    }

    ring(String s, int i, byte byte0)
    {
        this(s, i);
    }
}
