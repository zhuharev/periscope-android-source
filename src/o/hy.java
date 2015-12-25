// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            ie, hz, ia, ib, 
//            ic, id

public abstract class hy extends Enum
    implements ie
{

    public static final hz FZ;
    private static ia Ga;
    private static ib Gb;
    public static final ic Gc;
    private static id Gd;
    private static final hy Ge[];

    private hy(String s, int i)
    {
        super(s, i);
    }

    hy(String s, int i, byte byte0)
    {
        this(s, i);
    }

    public static hy valueOf(String s)
    {
        return (hy)Enum.valueOf(o/hy, s);
    }

    public static hy[] values()
    {
        return (hy[])Ge.clone();
    }

    static String _mth02BC(String s, String s1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (Character.isUpperCase(c) && stringbuilder.length() != 0)
            {
                stringbuilder.append(s1);
            }
            stringbuilder.append(c);
        }

        return stringbuilder.toString();
    }

    static String FB1D(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        int i = 0;
        char c;
        for (c = s.charAt(0); i < s.length() - 1 && !Character.isLetter(c); c = s.charAt(i))
        {
            stringbuilder.append(c);
            i++;
        }

        if (i == s.length())
        {
            return stringbuilder.toString();
        }
        if (!Character.isUpperCase(c))
        {
            c = Character.toUpperCase(c);
            i++;
            if (i < s.length())
            {
                s = (new StringBuilder()).append(c).append(s.substring(i)).toString();
            } else
            {
                s = String.valueOf(c);
            }
            return stringbuilder.append(s).toString();
        } else
        {
            return s;
        }
    }

    static 
    {
        FZ = new hz("IDENTITY", 0);
        Ga = new ia("UPPER_CAMEL_CASE", 1);
        Gb = new ib("UPPER_CAMEL_CASE_WITH_SPACES", 2);
        Gc = new ic("LOWER_CASE_WITH_UNDERSCORES", 3);
        Gd = new id("LOWER_CASE_WITH_DASHES", 4);
        Ge = (new hy[] {
            FZ, Ga, Gb, Gc, Gd
        });
    }
}
