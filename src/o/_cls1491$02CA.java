// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls1491

public static final class ring extends Enum
{

    public static final ts th;
    public static final ts ti;
    public static final ts tj;
    public static final ts tk;
    public static final ts tl;
    public static final ts tm;
    public static final ts tn;
    public static final ts to;
    public static final ts tp;
    public static final ts tq;
    public static final ts tr;
    public static final ts ts;
    private static final ts tt[];

    public static ring valueOf(String s)
    {
        return (ring)Enum.valueOf(o/1491$02CA, s);
    }

    public static ring[] values()
    {
        return (ring[])tt.clone();
    }

    static 
    {
        th = new <init>("CREATE", 0);
        ti = new <init>("START", 1);
        tj = new <init>("RESUME", 2);
        tk = new <init>("SAVE_INSTANCE_STATE", 3);
        tl = new <init>("PAUSE", 4);
        tm = new <init>("STOP", 5);
        tn = new <init>("DESTROY", 6);
        to = new <init>("ERROR", 7);
        tp = new <init>("CRASH", 8);
        tq = new <init>("INSTALL", 9);
        tr = new <init>("CUSTOM", 10);
        ts = new <init>("PREDEFINED", 11);
        tt = (new tt[] {
            th, ti, tj, tk, tl, tm, tn, to, tp, tq, 
            tr, ts
        });
    }

    private ring(String s, int i)
    {
        super(s, i);
    }
}
