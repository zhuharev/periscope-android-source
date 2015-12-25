// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;


// Referenced classes of package org.spongycastle.math.ec:
//            ECPoint, ECFieldElement, ECCurve

public static abstract class  extends ECPoint
{

    protected final boolean _mth0232()
    {
        return FF93().FF66();
    }

    protected final boolean FF77()
    {
        ECFieldElement ecfieldelement6 = aII;
        ECFieldElement ecfieldelement = aIJ;
        ECFieldElement ecfieldelement4 = alm.FB46();
        ECFieldElement ecfieldelement3 = alm.FB4C();
        ECFieldElement ecfieldelement5 = ecfieldelement.FF4C();
        ECFieldElement ecfieldelement1;
        ECFieldElement ecfieldelement2;
        switch (FF81())
        {
        case 0: // '\0'
            ecfieldelement2 = ecfieldelement5;
            ecfieldelement = ecfieldelement4;
            ecfieldelement1 = ecfieldelement3;
            break;

        case 1: // '\001'
            ECFieldElement ecfieldelement7 = aIK[0];
            ecfieldelement2 = ecfieldelement5;
            ecfieldelement = ecfieldelement4;
            ecfieldelement1 = ecfieldelement3;
            if (!ecfieldelement7.FF53())
            {
                ecfieldelement = ecfieldelement7.FF4C();
                ecfieldelement1 = ecfieldelement7._mth141D(ecfieldelement);
                ecfieldelement2 = ecfieldelement5._mth141D(ecfieldelement7);
                ecfieldelement = ecfieldelement4._mth141D(ecfieldelement);
                ecfieldelement1 = ecfieldelement3._mth141D(ecfieldelement1);
            }
            break;

        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            ECFieldElement ecfieldelement8 = aIK[0];
            ecfieldelement2 = ecfieldelement5;
            ecfieldelement = ecfieldelement4;
            ecfieldelement1 = ecfieldelement3;
            if (!ecfieldelement8.FF53())
            {
                ecfieldelement1 = ecfieldelement8.FF4C();
                ecfieldelement = ecfieldelement1.FF4C();
                ecfieldelement1 = ecfieldelement1._mth141D(ecfieldelement);
                ecfieldelement = ecfieldelement4._mth141D(ecfieldelement);
                ecfieldelement1 = ecfieldelement3._mth141D(ecfieldelement1);
                ecfieldelement2 = ecfieldelement5;
            }
            break;

        default:
            throw new IllegalStateException("unsupported coordinate system");
        }
        return ecfieldelement2.equals(ecfieldelement6.FF4C()._mth02CE(ecfieldelement)._mth141D(ecfieldelement6)._mth02CE(ecfieldelement1));
    }

    public (ECCurve eccurve, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1)
    {
        super(eccurve, ecfieldelement, ecfieldelement1);
    }

    public (ECCurve eccurve, ECFieldElement ecfieldelement, ECFieldElement ecfieldelement1, ECFieldElement aecfieldelement[])
    {
        super(eccurve, ecfieldelement, ecfieldelement1, aecfieldelement);
    }
}
