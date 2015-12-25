// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.IOException;
import java.io.Reader;

// Referenced classes of package o:
//            mq, iu, mu, is, 
//            ms, iy, ir, iq

public final class iv
{

    public iv()
    {
    }

    private static iq _mth02CA(mq mq1)
    {
        boolean flag;
        flag = mq1.Ju;
        mq1.Ju = true;
        iq iq = _cls1D3A._cls02CA._mth02CA(mq1);
        mq1.Ju = flag;
        return iq;
        Object obj;
        obj;
        throw new iu((new StringBuilder("Failed parsing JSON source: ")).append(mq1).append(" to Json").toString(), ((Throwable) (obj)));
        obj;
        throw new iu((new StringBuilder("Failed parsing JSON source: ")).append(mq1).append(" to Json").toString(), ((Throwable) (obj)));
        obj;
        mq1.Ju = flag;
        throw obj;
    }

    public final iq _mth02CA(Reader reader)
    {
        iq iq;
        try
        {
            reader = new mq(reader);
            iq = _mth02CA(((mq) (reader)));
            if (!(iq instanceof is) && reader._mth13A2() != ms.JP)
            {
                throw new iy("Did not consume the entire document.");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Reader reader)
        {
            throw new iy(reader);
        }
        // Misplaced declaration of an exception variable
        catch (Reader reader)
        {
            throw new ir(reader);
        }
        // Misplaced declaration of an exception variable
        catch (Reader reader)
        {
            throw new iy(reader);
        }
        return iq;
    }
}
