// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;


// Referenced classes of package org.spongycastle.math.ec:
//            ECPoint, ECCurve, ECFieldElement

public static abstract class  extends ECPoint
{

    protected final boolean FF77()
    {
        Object obj = FF79();
        ECFieldElement ecfieldelement9 = aII;
        ECFieldElement ecfieldelement6 = ((ECCurve) (obj)).FB46();
        ECFieldElement ecfieldelement = ((ECCurve) (obj)).FB4C();
        int i = ((ECCurve) (obj)).FB5E();
        if (i == 6)
        {
            ECFieldElement ecfieldelement4 = aIK[0];
            boolean flag = ecfieldelement4.FF53();
            if (ecfieldelement9.isZero())
            {
                ECFieldElement ecfieldelement1 = aIJ.FF4C();
                obj = ecfieldelement;
                if (!flag)
                {
                    obj = ecfieldelement._mth141D(ecfieldelement4.FF4C());
                }
                return ecfieldelement1.equals(obj);
            }
            obj = aIJ;
            ECFieldElement ecfieldelement2 = ecfieldelement9.FF4C();
            if (flag)
            {
                obj = ((ECFieldElement) (obj)).FF4C()._mth02CE(((ECFieldElement) (obj)))._mth02CE(ecfieldelement6);
                ecfieldelement = ecfieldelement2.FF4C()._mth02CE(ecfieldelement);
            } else
            {
                ecfieldelement9 = ecfieldelement4.FF4C();
                ECFieldElement ecfieldelement7 = ecfieldelement9.FF4C();
                obj = ((ECFieldElement) (obj))._mth02CE(ecfieldelement4)._mth02CB(((ECFieldElement) (obj)), ecfieldelement6, ecfieldelement9);
                ecfieldelement = ecfieldelement2._mth02CA(ecfieldelement, ecfieldelement7);
            }
            return ((ECFieldElement) (obj))._mth141D(ecfieldelement2).equals(ecfieldelement);
        }
        obj = aIJ;
        ECFieldElement ecfieldelement8 = ((ECFieldElement) (obj))._mth02CE(ecfieldelement9)._mth141D(((ECFieldElement) (obj)));
        ECFieldElement ecfieldelement3;
        ECFieldElement ecfieldelement5;
        switch (i)
        {
        case 0: // '\0'
            obj = ecfieldelement6;
            ecfieldelement3 = ecfieldelement;
            ecfieldelement5 = ecfieldelement8;
            break;

        case 1: // '\001'
            ECFieldElement ecfieldelement10 = aIK[0];
            obj = ecfieldelement6;
            ecfieldelement3 = ecfieldelement;
            ecfieldelement5 = ecfieldelement8;
            if (!ecfieldelement10.FF53())
            {
                ecfieldelement3 = ecfieldelement10._mth141D(ecfieldelement10.FF4C());
                ecfieldelement5 = ecfieldelement8._mth141D(ecfieldelement10);
                obj = ecfieldelement6._mth141D(ecfieldelement10);
                ecfieldelement3 = ecfieldelement._mth141D(ecfieldelement3);
            }
            break;

        default:
            throw new IllegalStateException("unsupported coordinate system");
        }
        return ecfieldelement5.equals(ecfieldelement9._mth02CE(((ECFieldElement) (obj)))._mth141D(ecfieldelement9.FF4C())._mth02CE(ecfieldelement3));
    }

    protected (ECCurve eccurve, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1)
    {
        super(eccurve, ecfieldelement, ecfieldelement1);
    }

    protected (ECCurve eccurve, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, ECFieldElement aecfieldelement[])
    {
        super(eccurve, ecfieldelement, ecfieldelement1, aecfieldelement);
    }
}
