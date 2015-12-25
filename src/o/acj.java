// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


public final class acj
{
    public static final class if extends Enum
    {

        public static final if bda;
        public static final if bdb;
        public static final if bdc;
        private static final if bdd[];

        public static if valueOf(String s)
        {
            return (if)Enum.valueOf(o/acj$if, s);
        }

        public static if[] values()
        {
            return (if[])bdd.clone();
        }

        static 
        {
            bda = new if("None", 0);
            bdb = new if("Twitter", 1);
            bdc = new if("Digits", 2);
            bdd = (new if[] {
                bda, bdb, bdc
            });
        }

        private if(String s, int i)
        {
            super(s, i);
        }
    }


    public final String bcY;
    public final if bcZ;

    public acj(String s, if if1)
    {
        bcY = s;
        bcZ = if1;
    }
}
