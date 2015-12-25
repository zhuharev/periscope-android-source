// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls04E7, _cls1EF2

static final class vz extends vz
{

    private final _cls02CB vz[];

    public final int getSize()
    {
        int j = 0;
        vz avz[] = vz;
        int k = avz.length;
        for (int i = 0; i < k; i++)
        {
            j += avz[i].getSize();
        }

        return j;
    }

    public final void _mth02CB(_cls1EF2 _pcls1ef2)
    {
        getSize agetsize[] = vz;
        int j = agetsize.length;
        for (int i = 0; i < j; i++)
        {
            agetsize[i]._mth02CB(_pcls1ef2);
        }

    }

    public transient ( a[])
    {
        super(0, new <init>[0]);
        vz = a;
    }
}
