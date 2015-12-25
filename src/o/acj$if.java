// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            acj

public static final class .String extends Enum
{

    public static final bdc bda;
    public static final bdc bdb;
    public static final bdc bdc;
    private static final bdc bdd[];

    public static .String valueOf(String s)
    {
        return (.String)Enum.valueOf(o/acj$if, s);
    }

    public static .String[] values()
    {
        return (.String[])bdd.clone();
    }

    static 
    {
        bda = new <init>("None", 0);
        bdb = new <init>("Twitter", 1);
        bdc = new <init>("Digits", 2);
        bdd = (new bdd[] {
            bda, bdb, bdc
        });
    }

    private .String(String s, int i)
    {
        super(s, i);
    }
}
