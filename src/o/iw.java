// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.math.BigInteger;

// Referenced classes of package o:
//            iq, kc

public final class iw extends iq
{

    private static final Class GD[];
    public Object value;

    public iw(Boolean boolean1)
    {
        setValue(boolean1);
    }

    public iw(Number number)
    {
        setValue(number);
    }

    iw(Object obj)
    {
        setValue(obj);
    }

    public iw(String s)
    {
        setValue(s);
    }

    private void setValue(Object obj)
    {
        if (obj instanceof Character)
        {
            value = String.valueOf(((Character)obj).charValue());
            return;
        }
        boolean flag;
        if ((obj instanceof Number) || _mth06E5(obj))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        _cls1D10.aux.checkArgument(flag);
        value = obj;
    }

    private static boolean _mth02CA(iw iw1)
    {
        if (iw1.value instanceof Number)
        {
            iw1 = (Number)iw1.value;
            return (iw1 instanceof BigInteger) || (iw1 instanceof Long) || (iw1 instanceof Integer) || (iw1 instanceof Short) || (iw1 instanceof Byte);
        } else
        {
            return false;
        }
    }

    private static boolean _mth06E5(Object obj)
    {
        if (obj instanceof String)
        {
            return true;
        }
        obj = obj.getClass();
        Class aclass[] = GD;
        for (int i = 0; i < 16; i++)
        {
            if (aclass[i].isAssignableFrom(((Class) (obj))))
            {
                return true;
            }
        }

        return false;
    }

    public final boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (iw)obj;
        if (value == null)
        {
            return ((iw) (obj)).value == null;
        }
        if (_mth02CA(this) && _mth02CA(((iw) (obj))))
        {
            return _mth04AD().longValue() == ((iw) (obj))._mth04AD().longValue();
        }
        if ((value instanceof Number) && (((iw) (obj)).value instanceof Number))
        {
            double d = _mth04AD().doubleValue();
            double d1 = ((iw) (obj))._mth04AD().doubleValue();
            return d == d1 || Double.isNaN(d) && Double.isNaN(d1);
        } else
        {
            return value.equals(((iw) (obj)).value);
        }
    }

    public final int hashCode()
    {
        if (value == null)
        {
            return 31;
        }
        if (_mth02CA(this))
        {
            long l = _mth04AD().longValue();
            return (int)(l ^ l >>> 32);
        }
        if (value instanceof Number)
        {
            long l1 = Double.doubleToLongBits(_mth04AD().doubleValue());
            return (int)(l1 ^ l1 >>> 32);
        } else
        {
            return value.hashCode();
        }
    }

    public final Number _mth04AD()
    {
        if (value instanceof String)
        {
            return new kc((String)value);
        } else
        {
            return (Number)value;
        }
    }

    public final String _mth04AE()
    {
        if (value instanceof Number)
        {
            return _mth04AD().toString();
        }
        if (value instanceof Boolean)
        {
            return ((Boolean)value).toString();
        } else
        {
            return (String)value;
        }
    }

    public final long _mth0507()
    {
        if (value instanceof Number)
        {
            return _mth04AD().longValue();
        } else
        {
            return Long.parseLong(_mth04AE());
        }
    }

    public final int _mth05D4()
    {
        if (value instanceof Number)
        {
            return _mth04AD().intValue();
        } else
        {
            return Integer.parseInt(_mth04AE());
        }
    }

    public final boolean _mth0672()
    {
        if (value instanceof Boolean)
        {
            return ((Boolean)value).booleanValue();
        } else
        {
            return Boolean.parseBoolean(_mth04AE());
        }
    }

    static 
    {
        GD = (new Class[] {
            Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, java/lang/Integer, java/lang/Long, 
            java/lang/Short, java/lang/Float, java/lang/Double, java/lang/Byte, java/lang/Boolean, java/lang/Character
        });
    }
}
