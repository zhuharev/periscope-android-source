// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            yw, atn

final class yx extends yw
{

    yx(String s, int i)
    {
        super(s, 0, (byte)0);
    }

    public final int compare(Object obj, Object obj1)
    {
        obj = (atn)obj;
        obj1 = (atn)obj1;
        return Long.compare(((atn) (obj)).eU(), ((atn) (obj1)).eU()) * -1;
    }
}
