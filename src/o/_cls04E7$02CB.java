// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls04E7, _cls062A, _cls1681, _cls1EF2

static final class  extends 
{

    private final String key;
    private final String value;

    public final void _mth02CA(_cls1EF2 _pcls1ef2)
    {
        _pcls1ef2._mth02CA(1, _cls1681._mth02CD(key));
        String s;
        if (value == null)
        {
            s = "";
        } else
        {
            s = value;
        }
        _pcls1ef2._mth02CA(2, _cls1681._mth02CD(s));
    }

    public final int FB65()
    {
        int i = _cls1EF2._mth02CB(1, _cls1681._mth02CD(key));
        String s;
        if (value == null)
        {
            s = "";
        } else
        {
            s = value;
        }
        return i + _cls1EF2._mth02CB(2, _cls1681._mth02CD(s));
    }

    public ring(_cls062A _pcls062a)
    {
        super(2, new <init>[0]);
        key = _pcls062a.key;
        value = _pcls062a.value;
    }
}
