// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


public abstract class atv
{
    public static final class if extends Enum
    {

        public static final if bEi;
        public static final if bEj;
        public static final if bEk;
        public static final if bEl;
        public static final if bEm;
        private static final if bEn[];

        public static if valueOf(String s)
        {
            return (if)Enum.valueOf(o/atv$if, s);
        }

        public static if[] values()
        {
            return (if[])bEn.clone();
        }

        static 
        {
            bEi = new if("Hero", 0);
            bEj = new if("Broadcast", 1);
            bEk = new if("NothingLive", 2);
            bEl = new if("RecentFirst", 3);
            bEm = new if("Recent", 4);
            bEn = (new if[] {
                bEi, bEj, bEk, bEl, bEm
            });
        }

        private if(String s, int i)
        {
            super(s, i);
        }
    }


    atv()
    {
    }

    public abstract if fZ();

    public abstract String ga();
}
