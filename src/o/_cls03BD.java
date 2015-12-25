// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls044C, _cls0645, _cls0437, FF8B

public abstract class _cls03BD extends _cls044C
{

    private final int height;
    private final int width;

    public _cls03BD()
    {
        this(0x80000000, 0x80000000);
    }

    private _cls03BD(int i, int j)
    {
        width = 0x80000000;
        height = 0x80000000;
    }

    public final void _mth02CA(FF8B ff8b)
    {
        if (!_cls0645._mth02E1(width, height))
        {
            throw new IllegalArgumentException((new StringBuilder("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ")).append(width).append(" and height: ").append(height).append(", either provide dimensions in the constructor or call override()").toString());
        } else
        {
            ff8b._mth02C7(width, height);
            return;
        }
    }
}
