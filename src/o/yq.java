// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            yr, ys, yt

public interface yq
{
    public static abstract class if extends Enum
        implements yq
    {

        private static yr aVZ;
        private static ys aWa;
        private static yt aWb;
        private static final if aWc[];

        public static if valueOf(String s)
        {
            return (if)Enum.valueOf(o/yq$if, s);
        }

        public static if[] values()
        {
            return (if[])aWc.clone();
        }

        static 
        {
            aVZ = new yr("development", 0);
            aWa = new ys("canary", 1);
            aWb = new yt("production", 2);
            aWc = (new if[] {
                aVZ, aWa, aWb
            });
        }

        private if(String s, int i)
        {
            super(s, i);
        }

        if(String s, int i, byte byte0)
        {
            this(s, i);
        }
    }


    public abstract String k();

    public abstract String l();

    public abstract String m();

    public abstract String n();

    public abstract String o();

    public abstract String p();

    public abstract String q();
}
