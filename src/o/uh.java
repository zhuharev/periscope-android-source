// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package o:
//            ug

final class uh extends ug._cls02CA
{

    private InputStream TB;
    private OutputStream TC;
    private ug TD;

    uh(ug ug1, InputStream inputstream, boolean flag, InputStream inputstream1, OutputStream outputstream)
    {
        TD = ug1;
        TB = inputstream1;
        TC = outputstream;
        super(inputstream, flag);
    }

    public final ug _mth1E6B()
    {
        byte abyte0[] = new byte[ug._mth02CB(TD)];
        do
        {
            int i = TB.read(abyte0);
            if (i != -1)
            {
                TC.write(abyte0, 0, i);
            } else
            {
                return TD;
            }
        } while (true);
    }
}
