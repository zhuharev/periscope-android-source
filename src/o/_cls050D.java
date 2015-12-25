// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls0454

final class _cls050D extends _cls0454
{

    _cls050D()
    {
    }

    public final String getId()
    {
        return "AT_MOST.com.bumptech.glide.load.data.bitmap";
    }

    protected final int _mth02BB(int i, int j, int k, int l)
    {
        i = (int)Math.ceil(Math.max((float)j / (float)l, (float)i / (float)k));
        j = Math.max(1, Integer.highestOneBit(i));
        if (j < i)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        return j << i;
    }
}
