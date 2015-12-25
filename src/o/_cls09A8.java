// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


public final class _cls09A8
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}


    public final String mName;
    private final if wP;
    private final _cls1427.if wQ;
    private final _cls02CB wR;
    private final _cls141D.if wS;

    public _cls09A8(String s, if if1, _cls02CB _pcls02cb)
    {
        if (if1 == null)
        {
            throw new NullPointerException(String.valueOf("Cannot construct an Api with a null ClientBuilder"));
        }
        if (_pcls02cb == null)
        {
            throw new NullPointerException(String.valueOf("Cannot construct an Api with a null ClientKey"));
        } else
        {
            mName = s;
            wP = if1;
            wQ = null;
            wR = _pcls02cb;
            wS = null;
            return;
        }
    }

    public final if _mth027B()
    {
        boolean flag;
        if (wP != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new IllegalStateException(String.valueOf("This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder"));
        } else
        {
            return wP;
        }
    }

    public final _cls02CB _mth028F()
    {
        boolean flag;
        if (wR != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new IllegalStateException(String.valueOf("This API was constructed with a SimpleClientKey. Use getSimpleClientKey"));
        } else
        {
            return wR;
        }
    }
}
