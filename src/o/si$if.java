// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            si

public static final class Sj extends Enum
{

    public static final Si Sc;
    public static final Si Sd;
    public static final Si Se;
    public static final Si Sf;
    public static final Si Sg;
    public static final Si Sh;
    public static final Si Si;
    private static final Si Sk[];
    public final int Sj;

    public static g.String valueOf(String s)
    {
        return (g.String)Enum.valueOf(o/si$if, s);
    }

    public static g.String[] values()
    {
        return ([])Sk.clone();
    }

    static 
    {
        Sc = new <init>("WIFI_MAC_ADDRESS", 0, 1);
        Sd = new <init>("BLUETOOTH_MAC_ADDRESS", 1, 2);
        Se = new <init>("FONT_TOKEN", 2, 53);
        Sf = new <init>("ANDROID_ID", 3, 100);
        Sg = new <init>("ANDROID_DEVICE_ID", 4, 101);
        Sh = new <init>("ANDROID_SERIAL", 5, 102);
        Si = new <init>("ANDROID_ADVERTISING_ID", 6, 103);
        Sk = (new Sk[] {
            Sc, Sd, Se, Sf, Sg, Sh, Si
        });
    }

    private g.String(String s, int i, int j)
    {
        super(s, i);
        Sj = j;
    }
}
