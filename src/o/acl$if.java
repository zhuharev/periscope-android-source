// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            acl

public static final class .String extends Enum
{

    public static final bdo bdm;
    public static final bdo bdn;
    public static final bdo bdo;
    private static final bdo bdp[];

    public static .String valueOf(String s)
    {
        return (.String)Enum.valueOf(o/acl$if, s);
    }

    public static .String[] values()
    {
        return (.String[])bdp.clone();
    }

    static 
    {
        bdm = new <init>("SoundAndVibrate", 0);
        bdn = new <init>("VibrateOnly", 1);
        bdo = new <init>("Silent", 2);
        bdp = (new bdp[] {
            bdm, bdn, bdo
        });
    }

    private .String(String s, int i)
    {
        super(s, i);
    }
}
