// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.File;

// Referenced classes of package o:
//            _cls1D12, FF6B, _cls1EF4, ra, 
//            rl, _cls0109

final class FF9C
    implements Runnable
{

    private FF6B uQ;

    FF9C(FF6B ff6b)
    {
        uQ = ff6b;
        super();
    }

    public final void run()
    {
        FF6B ff6b = uQ;
        File afile1[] = FF6B._mth02CA(uQ, _cls1D12.uc);
        File file = new File(ff6b.uM._mth1E2E(), "invalidClsFiles");
        if (file.exists())
        {
            if (file.isDirectory())
            {
                File afile2[] = file.listFiles();
                int k = afile2.length;
                for (int i = 0; i < k; i++)
                {
                    afile2[i].delete();
                }

            }
            file.delete();
        }
        int i1 = afile1.length;
        for (int j = 0; j < i1; j++)
        {
            Object obj = afile1[j];
            ra._mth0454()._mth02BE("CrashlyticsCore", (new StringBuilder("Found invalid session part file: ")).append(obj).toString());
            obj = FF6B._mth141D(((File) (obj)));
            _cls0109 _lcls0109 = new _cls0109(ff6b, ((String) (obj)));
            ra._mth0454()._mth02BE("CrashlyticsCore", (new StringBuilder("Deleting all part files for invalid session: ")).append(((String) (obj))).toString());
            File afile[] = ff6b.uH.listFiles(_lcls0109);
            if (afile == null)
            {
                afile = new File[0];
            }
            int j1 = afile.length;
            for (int l = 0; l < j1; l++)
            {
                File file1 = afile[l];
                ra._mth0454()._mth02BE("CrashlyticsCore", (new StringBuilder("Deleting session file: ")).append(file1).toString());
                file1.delete();
            }

        }

    }
}
