// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls04E7, _cls05E3, _cls1681, _cls1EF2

static final class tance extends tance
{

    private final int importance;
    private final String name;

    public final void _mth02CA(_cls1EF2 _pcls1ef2)
    {
        boolean flag;
        if (name != null && name.length() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            _pcls1ef2._mth02CA(1, _cls1681._mth02CD(name));
        }
        _pcls1ef2._mth02EE(2, importance);
    }

    public final int FB65()
    {
        boolean flag;
        if (name != null && name.length() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        int i;
        if (flag)
        {
            i = _cls1EF2._mth02CB(1, _cls1681._mth02CD(name));
        } else
        {
            i = 0;
        }
        int j = importance;
        return _cls1EF2.FE74(16) + _cls1EF2.FE74(j) + i;
    }

    public ring(_cls05E3 _pcls05e3, ring ring)
    {
        super(1, new <init>[] {
            ring
        });
        name = _pcls05e3.name;
        importance = _pcls05e3.importance;
    }
}
