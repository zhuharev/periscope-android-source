// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            aba, aav, xm, aaq, 
//            aaz, aax

final class xn
    implements aar._cls02CB
{

    private aav aTH;
    private xm aTI;

    xn(xm xm1, aav aav1)
    {
        aTI = xm1;
        aTH = aav1;
        super();
    }

    public final void FB8C()
    {
        xm._mth02CA(aTI, new aba(aTH.getContext()));
        xm._mth02CA(aTI).bbN.baz = "Encoder";
        xm._mth02CA(aTI, new aaz(aTH.getContext()));
        xm._mth02CB(aTI).bbN.baz = "Preview";
        xm._mth02CA(aTI, new aax());
    }

    public final void FB90()
    {
        throw new RuntimeException("Unable to acquire video context");
    }
}
