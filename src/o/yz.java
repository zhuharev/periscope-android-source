// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            yw, atn, ato

final class yz extends yw
{

    yz(String s, int i)
    {
        super(s, 2, (byte)0);
    }

    public final volatile int compare(Object obj, Object obj1)
    {
        obj = (atn)obj;
        obj1 = (atn)obj1;
        boolean flag;
        if (((atn) (obj)).bDW == ato.bEd)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        boolean flag1;
        if (((atn) (obj1)).bDW == ato.bEd)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        return Boolean.compare(flag, flag1) * -1;
    }
}
