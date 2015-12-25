// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


public final class ms extends Enum
{

    public static final ms JG;
    public static final ms JH;
    public static final ms JI;
    public static final ms JJ;
    public static final ms JK;
    public static final ms JL;
    public static final ms JM;
    public static final ms JN;
    public static final ms JO;
    public static final ms JP;
    private static final ms JQ[];

    private ms(String s, int i)
    {
        super(s, i);
    }

    public static ms valueOf(String s)
    {
        return (ms)Enum.valueOf(o/ms, s);
    }

    public static ms[] values()
    {
        return (ms[])JQ.clone();
    }

    static 
    {
        JG = new ms("BEGIN_ARRAY", 0);
        JH = new ms("END_ARRAY", 1);
        JI = new ms("BEGIN_OBJECT", 2);
        JJ = new ms("END_OBJECT", 3);
        JK = new ms("NAME", 4);
        JL = new ms("STRING", 5);
        JM = new ms("NUMBER", 6);
        JN = new ms("BOOLEAN", 7);
        JO = new ms("NULL", 8);
        JP = new ms("END_DOCUMENT", 9);
        JQ = (new ms[] {
            JG, JH, JI, JJ, JK, JL, JM, JN, JO, JP
        });
    }
}
