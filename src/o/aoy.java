// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            api, apg, apd, _cls028B

public final class aoy
{

    private final int bwY;
    int bwZ;
    boolean bxa;
    private byte bxb[];
    int bxc;
    int bxd;
    private int bxe;
    boolean bxf;
    private apg bxg;
    int bxh;
    int bxi;
    int bxj;
    private long bxk;
    long bxl;
    private api bxm;

    public aoy(int i, int j, api api1)
    {
        bxb = new byte[4];
        bxc = 0;
        bxm = api1;
        bwY = i;
        bwZ = j;
        bxa = true;
        bxc = 0;
        bxd = 0;
        bxe = 0;
    }

    public final int dY()
    {
        int j = bxj - bxe;
        int i = j;
        if (j > bwZ)
        {
            i = bwZ;
        }
        return (bxc - bxd) + i;
    }

    public final apg _mth02B4(byte abyte0[], int i, int j)
    {
        if (bxj == 0)
        {
            bxa = true;
            return null;
        }
        int l = i;
        int k = j;
        if (bxd < bxc)
        {
            l = bxc - bxd;
            k = l;
            if (j < l)
            {
                k = j;
            }
            System.arraycopy(abyte0, i, bxb, bxd, k);
            bxd = bxd + k;
            l = i + k;
            k = j - k;
        }
        if (bxc == bxd && k > 0)
        {
            if (bxg == null)
            {
                bxg = bxm._mth0559(bxi, bwY, bxh, bxj);
                apg apg1 = bxg;
                if (apg1.byA == null)
                {
                    apg1.byA = new apd();
                }
                apg1.byA.length = 0;
            }
            Object obj = bxg;
            if (((apg) (obj)).byA == null)
            {
                obj.byA = new apd();
            }
            obj = ((apg) (obj)).byA;
            j = bxj - ((apd) (obj)).length;
            i = j;
            if (k < j)
            {
                i = k;
            }
            ((apd) (obj))._mth02C6(abyte0, l, i);
            bxe = bxe + i;
            if (((apd) (obj)).length == bxj)
            {
                if (bxc == 4)
                {
                    bxl = _cls028B._mth02CB(bxb, 0);
                }
                if (bxf)
                {
                    bxk = bxk + bxl;
                } else
                {
                    bxk = bxl;
                }
                bxg.bxk = bxk;
                abyte0 = bxg;
                if (((apg) (abyte0)).byy == 20 || ((apg) (abyte0)).byy == 18)
                {
                    abyte0.byz = _cls028B._mth02CA(((apg) (abyte0)).byA.buffer, ((apg) (abyte0)).byA.length);
                }
                bxa = true;
                bxc = 0;
                bxd = 0;
                bxe = 0;
                abyte0 = bxg;
                bxg = null;
                return abyte0;
            }
            if (i == bwZ)
            {
                bxd = 0;
                bxa = true;
            }
        }
        return null;
    }
}
