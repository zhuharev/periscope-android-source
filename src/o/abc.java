// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutorService;

// Referenced classes of package o:
//            abd, aui, abf, abi

public final class abc extends abd
{
    static class if
    {

        public Date getDate()
        {
            return new Date();
        }

        if()
        {
        }
    }

    /* member class not found */
    class _cls02CA {}


    private final if bbO;
    public volatile boolean _fld1FD2;

    public abc(abd.if if1)
    {
        this(if1, _cls02CA.ai(), new if());
    }

    private abc(abd.if if1, ExecutorService executorservice, if if2)
    {
        super(if1, executorservice);
        _fld1FD2 = true;
        bbO = if2;
    }

    public final void close()
    {
        _fld1FD2 = false;
        super.close();
    }

    public final volatile String getName()
    {
        return super.getName();
    }

    public final void log(String s)
    {
        if (!_fld1FD2)
        {
            return;
        }
        if (aui.isEmpty(s))
        {
            return;
        } else
        {
            s = String.format(Locale.US, "%s: %s\n", new Object[] {
                bbO.getDate(), s
            });
            super.bbT.execute(new abf(this, s));
            return;
        }
    }

    public final volatile void _mth02CA(abi abi)
    {
        super._mth02CA(abi);
    }
}
