// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


public class _cls1484
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}

    /* member class not found */
    class _cls02CF {}


    private static final _cls02CB _fld0722;
    private final Object _fld10D0;

    public _cls1484(Object obj)
    {
        _fld10D0 = obj;
    }

    public static _cls1484 _mth02E3()
    {
        return new _cls1484(_fld0722._mth05D5());
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (_cls1484)obj;
        if (_fld10D0 == null)
        {
            if (((_cls1484) (obj))._fld10D0 != null)
            {
                return false;
            }
        } else
        if (!_fld10D0.equals(((_cls1484) (obj))._fld10D0))
        {
            return false;
        }
        return true;
    }

    public int hashCode()
    {
        if (_fld10D0 == null)
        {
            return 0;
        } else
        {
            return _fld10D0.hashCode();
        }
    }

    public void setFromIndex(int i)
    {
        _fld0722._mth02CB(_fld10D0, i);
    }

    public void setItemCount(int i)
    {
        _fld0722._mth02CE(_fld10D0, i);
    }

    public void setMaxScrollX(int i)
    {
        _fld0722._mth02BC(_fld10D0, i);
    }

    public void setMaxScrollY(int i)
    {
        _fld0722._mth02BD(_fld10D0, i);
    }

    public void setScrollX(int i)
    {
        _fld0722._mth02CF(_fld10D0, i);
    }

    public void setScrollY(int i)
    {
        _fld0722._mth141D(_fld10D0, i);
    }

    public void setScrollable(boolean flag)
    {
        _fld0722._mth02CA(_fld10D0, flag);
    }

    public void setToIndex(int i)
    {
        _fld0722._mth02BB(_fld10D0, i);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            _fld0722 = new _cls02CE();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 15)
        {
            _fld0722 = new _cls02CA();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            _fld0722 = new if();
        } else
        {
            _fld0722 = new _cls02CF();
        }
    }
}
