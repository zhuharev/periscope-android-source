// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.StringReader;

// Referenced classes of package o:
//            ow, iu, iv, io, 
//            nx, or, of, oa

final class ol extends ow
{

    private of ME;
    private String MG;
    private nx MH;

    ol(of of, nx nx1, String s)
    {
        ME = of;
        MH = nx1;
        MG = s;
        super();
    }

    public final void _mth02CA(oa oa, String s)
    {
        String s1;
        Object obj;
        obj = (new iv())._mth02CA(new StringReader(s));
        if (!(obj instanceof io))
        {
            break MISSING_BLOCK_LABEL_74;
        }
        oa = MH;
        s1 = MG;
        if (obj instanceof io)
        {
            obj = (io)obj;
            break MISSING_BLOCK_LABEL_66;
        }
        throw new IllegalStateException("This is not a JSON Array.");
        oa._mth02CA(s1, ((iq) (obj)));
        return;
        try
        {
            oa = or._mth02CA(or.MR, 1, s);
            MH._mth02CA(MG, oa);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (oa oa)
        {
            oa = or._mth02CA(or.MR, 1, s);
        }
        MH._mth02CA(MG, oa);
        return;
    }

    public final void _mth02CB(or or1)
    {
        MH._mth02CA(MG, or1);
    }
}
