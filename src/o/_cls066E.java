// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls0E30, _cls0646, _cls0645, _cls06BA

public final class _cls066E extends _cls0E30
{

    private final _cls06BA je;

    public _cls066E(_cls0646 _pcls0646, _cls06BA _pcls06ba)
    {
        super(_pcls0646);
        je = _pcls06ba;
    }

    public final int getSize()
    {
        return _cls0645._mth037A(((_cls0646)pz).ph.oW);
    }

    public final void recycle()
    {
        je._mth02BD(((_cls0646)pz).ph.oW);
    }
}
