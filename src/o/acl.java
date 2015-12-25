// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Set;

public final class acl
{
    public static final class if extends Enum
    {

        public static final if bdm;
        public static final if bdn;
        public static final if bdo;
        private static final if bdp[];

        public static if valueOf(String s)
        {
            return (if)Enum.valueOf(o/acl$if, s);
        }

        public static if[] values()
        {
            return (if[])bdp.clone();
        }

        static 
        {
            bdm = new if("SoundAndVibrate", 0);
            bdn = new if("VibrateOnly", 1);
            bdo = new if("Silent", 2);
            bdp = (new if[] {
                bdm, bdn, bdo
            });
        }

        private if(String s, int i)
        {
            super(s, i);
        }
    }


    public final if bdf;
    public final boolean bdg;
    public final boolean bdh;
    public final boolean bdi;
    public final boolean bdj;
    public final Set bdk;
    public final boolean bdl;

    public acl(if if1, boolean flag, boolean flag1, boolean flag2, boolean flag3, Set set, boolean flag4)
    {
        bdf = if1;
        bdg = flag;
        bdh = flag1;
        bdi = flag2;
        bdj = flag3;
        bdk = set;
        bdl = flag4;
    }
}
