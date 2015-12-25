// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

// Referenced classes of package o:
//            ke, kf

public final class kd extends AbstractMap
    implements Serializable
{
    final class if extends AbstractSet
    {

        final kd Hp;

        public final void clear()
        {
            Hp.clear();
        }

        public final boolean contains(Object obj)
        {
            return (obj instanceof java.util.Map.Entry) && Hp._mth02CA((java.util.Map.Entry)obj) != null;
        }

        public final Iterator iterator()
        {
            return new kf(this);
        }

        public final boolean remove(Object obj)
        {
            if (!(obj instanceof java.util.Map.Entry))
            {
                return false;
            }
            obj = Hp._mth02CA((java.util.Map.Entry)obj);
            if (obj == null)
            {
                return false;
            } else
            {
                Hp._mth02CA(((_cls02CE) (obj)), true);
                return true;
            }
        }

        public final int size()
        {
            return Hp.size;
        }

        if()
        {
            Hp = kd.this;
            super();
        }
    }

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}


    private static boolean $assertionsDisabled;
    private static final ke Hj = new ke();
    private Comparator Hk;
    private _cls02CE Hl;
    final _cls02CE Hm;
    private if Hn;
    private _cls02CA Ho;
    int modCount;
    int size;

    public kd()
    {
        this(((Comparator) (Hj)));
    }

    private kd(Comparator comparator)
    {
        size = 0;
        modCount = 0;
        Hm = new _cls02CE();
        if (comparator == null)
        {
            comparator = Hj;
        }
        Hk = comparator;
    }

    private Object writeReplace()
    {
        return new LinkedHashMap(this);
    }

    private void _mth02CA(_cls02CE _pcls02ce)
    {
        _cls02CE _lcls02ce = _pcls02ce.Hw;
        _cls02CE _lcls02ce1 = _pcls02ce.Hx;
        _cls02CE _lcls02ce2 = _lcls02ce1.Hw;
        _cls02CE _lcls02ce3 = _lcls02ce1.Hx;
        _pcls02ce.Hx = _lcls02ce2;
        if (_lcls02ce2 != null)
        {
            _lcls02ce2.Hv = _pcls02ce;
        }
        _mth02CA(_pcls02ce, _lcls02ce1);
        _lcls02ce1.Hw = _pcls02ce;
        _pcls02ce.Hv = _lcls02ce1;
        int i;
        if (_lcls02ce != null)
        {
            i = _lcls02ce.height;
        } else
        {
            i = 0;
        }
        int j;
        if (_lcls02ce2 != null)
        {
            j = _lcls02ce2.height;
        } else
        {
            j = 0;
        }
        _pcls02ce.height = Math.max(i, j) + 1;
        j = _pcls02ce.height;
        if (_lcls02ce3 != null)
        {
            i = _lcls02ce3.height;
        } else
        {
            i = 0;
        }
        _lcls02ce1.height = Math.max(j, i) + 1;
    }

    private void _mth02CA(_cls02CE _pcls02ce, _cls02CE _pcls02ce1)
    {
        _cls02CE _lcls02ce = _pcls02ce.Hv;
        _pcls02ce.Hv = null;
        if (_pcls02ce1 != null)
        {
            _pcls02ce1.Hv = _lcls02ce;
        }
        if (_lcls02ce != null)
        {
            if (_lcls02ce.Hw == _pcls02ce)
            {
                _lcls02ce.Hw = _pcls02ce1;
                return;
            }
            if (!$assertionsDisabled && _lcls02ce.Hx != _pcls02ce)
            {
                throw new AssertionError();
            } else
            {
                _lcls02ce.Hx = _pcls02ce1;
                return;
            }
        } else
        {
            Hl = _pcls02ce1;
            return;
        }
    }

    private _cls02CE _mth02CB(Object obj, boolean flag)
    {
        Comparator comparator = Hk;
        _cls02CE _lcls02ce1 = Hl;
        int j = 0;
        _cls02CE _lcls02ce = _lcls02ce1;
        if (_lcls02ce1 != null)
        {
            Comparable comparable;
            if (comparator == Hj)
            {
                comparable = (Comparable)obj;
                _lcls02ce = _lcls02ce1;
            } else
            {
                comparable = null;
                _lcls02ce = _lcls02ce1;
            }
            do
            {
                int i;
                if (comparable != null)
                {
                    i = comparable.compareTo(_lcls02ce.nx);
                } else
                {
                    i = comparator.compare(obj, _lcls02ce.nx);
                }
                j = i;
                if (i == 0)
                {
                    return _lcls02ce;
                }
                if (j < 0)
                {
                    _lcls02ce1 = _lcls02ce.Hw;
                } else
                {
                    _lcls02ce1 = _lcls02ce.Hx;
                }
                if (_lcls02ce1 == null)
                {
                    break;
                }
                _lcls02ce = _lcls02ce1;
            } while (true);
        }
        if (!flag)
        {
            return null;
        }
        _lcls02ce1 = Hm;
        if (_lcls02ce == null)
        {
            if (comparator == Hj && !(obj instanceof Comparable))
            {
                throw new ClassCastException((new StringBuilder()).append(obj.getClass().getName()).append(" is not Comparable").toString());
            }
            obj = new _cls02CE(_lcls02ce, obj, _lcls02ce1, _lcls02ce1.Hy);
            Hl = ((_cls02CE) (obj));
        } else
        {
            obj = new _cls02CE(_lcls02ce, obj, _lcls02ce1, _lcls02ce1.Hy);
            if (j < 0)
            {
                _lcls02ce.Hw = ((_cls02CE) (obj));
            } else
            {
                _lcls02ce.Hx = ((_cls02CE) (obj));
            }
            _mth02CB(_lcls02ce, true);
        }
        size = size + 1;
        modCount = modCount + 1;
        return ((_cls02CE) (obj));
    }

    private void _mth02CB(_cls02CE _pcls02ce)
    {
        _cls02CE _lcls02ce = _pcls02ce.Hw;
        _cls02CE _lcls02ce1 = _pcls02ce.Hx;
        _cls02CE _lcls02ce2 = _lcls02ce.Hw;
        _cls02CE _lcls02ce3 = _lcls02ce.Hx;
        _pcls02ce.Hw = _lcls02ce3;
        if (_lcls02ce3 != null)
        {
            _lcls02ce3.Hv = _pcls02ce;
        }
        _mth02CA(_pcls02ce, _lcls02ce);
        _lcls02ce.Hx = _pcls02ce;
        _pcls02ce.Hv = _lcls02ce;
        int i;
        if (_lcls02ce1 != null)
        {
            i = _lcls02ce1.height;
        } else
        {
            i = 0;
        }
        int j;
        if (_lcls02ce3 != null)
        {
            j = _lcls02ce3.height;
        } else
        {
            j = 0;
        }
        _pcls02ce.height = Math.max(i, j) + 1;
        j = _pcls02ce.height;
        if (_lcls02ce2 != null)
        {
            i = _lcls02ce2.height;
        } else
        {
            i = 0;
        }
        _lcls02ce.height = Math.max(j, i) + 1;
    }

    private void _mth02CB(_cls02CE _pcls02ce, boolean flag)
    {
        for (; _pcls02ce != null; _pcls02ce = _pcls02ce.Hv)
        {
            _cls02CE _lcls02ce = _pcls02ce.Hw;
            _cls02CE _lcls02ce1 = _pcls02ce.Hx;
            int i;
            if (_lcls02ce != null)
            {
                i = _lcls02ce.height;
            } else
            {
                i = 0;
            }
            int j;
            if (_lcls02ce1 != null)
            {
                j = _lcls02ce1.height;
            } else
            {
                j = 0;
            }
            int k = i - j;
            if (k == -2)
            {
                _lcls02ce = _lcls02ce1.Hw;
                _cls02CE _lcls02ce3 = _lcls02ce1.Hx;
                if (_lcls02ce3 != null)
                {
                    i = _lcls02ce3.height;
                } else
                {
                    i = 0;
                }
                if (_lcls02ce != null)
                {
                    j = _lcls02ce.height;
                } else
                {
                    j = 0;
                }
                i = j - i;
                if (i == -1 || i == 0 && !flag)
                {
                    _mth02CA(_pcls02ce);
                } else
                {
                    if (!$assertionsDisabled && i != 1)
                    {
                        throw new AssertionError();
                    }
                    _mth02CB(_lcls02ce1);
                    _mth02CA(_pcls02ce);
                }
                if (flag)
                {
                    break;
                }
                continue;
            }
            if (k == 2)
            {
                _cls02CE _lcls02ce2 = _lcls02ce.Hw;
                _cls02CE _lcls02ce4 = _lcls02ce.Hx;
                if (_lcls02ce4 != null)
                {
                    i = _lcls02ce4.height;
                } else
                {
                    i = 0;
                }
                if (_lcls02ce2 != null)
                {
                    j = _lcls02ce2.height;
                } else
                {
                    j = 0;
                }
                i = j - i;
                if (i == 1 || i == 0 && !flag)
                {
                    _mth02CB(_pcls02ce);
                } else
                {
                    if (!$assertionsDisabled && i != -1)
                    {
                        throw new AssertionError();
                    }
                    _mth02CA(_lcls02ce);
                    _mth02CB(_pcls02ce);
                }
                if (flag)
                {
                    break;
                }
                continue;
            }
            if (k == 0)
            {
                _pcls02ce.height = i + 1;
                if (flag)
                {
                    return;
                }
                continue;
            }
            if (!$assertionsDisabled && k != -1 && k != 1)
            {
                throw new AssertionError();
            }
            _pcls02ce.height = Math.max(i, j) + 1;
            if (!flag)
            {
                break;
            }
        }

    }

    public final void clear()
    {
        Hl = null;
        size = 0;
        modCount = modCount + 1;
        _cls02CE _lcls02ce = Hm;
        _lcls02ce.Hy = _lcls02ce;
        _lcls02ce.Hs = _lcls02ce;
    }

    public final boolean containsKey(Object obj)
    {
        return _mth1420(obj) != null;
    }

    public final Set entrySet()
    {
        if if1 = Hn;
        if (if1 != null)
        {
            return if1;
        } else
        {
            if if2 = new if();
            Hn = if2;
            return if2;
        }
    }

    public final Object get(Object obj)
    {
        obj = _mth1420(obj);
        if (obj != null)
        {
            return ((_cls02CE) (obj)).value;
        } else
        {
            return null;
        }
    }

    public final Set keySet()
    {
        _cls02CA _lcls02ca = Ho;
        if (_lcls02ca != null)
        {
            return _lcls02ca;
        } else
        {
            _cls02CA _lcls02ca1 = new _cls02CA();
            Ho = _lcls02ca1;
            return _lcls02ca1;
        }
    }

    public final Object put(Object obj, Object obj1)
    {
        if (obj == null)
        {
            throw new NullPointerException("key == null");
        } else
        {
            obj = _mth02CB(obj, true);
            Object obj2 = ((_cls02CE) (obj)).value;
            obj.value = obj1;
            return obj2;
        }
    }

    public final Object remove(Object obj)
    {
        obj = _mth1420(obj);
        if (obj != null)
        {
            _mth02CA(((_cls02CE) (obj)), true);
        }
        if (obj != null)
        {
            return ((_cls02CE) (obj)).value;
        } else
        {
            return null;
        }
    }

    public final int size()
    {
        return size;
    }

    final _cls02CE _mth02CA(java.util.Map.Entry entry)
    {
        _cls02CE _lcls02ce;
        boolean flag;
label0:
        {
            _lcls02ce = _mth1420(entry.getKey());
            if (_lcls02ce != null)
            {
                Object obj = _lcls02ce.value;
                entry = ((java.util.Map.Entry) (entry.getValue()));
                if (obj == entry || obj != null && obj.equals(entry))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    flag = true;
                    break label0;
                }
            }
            flag = false;
        }
        if (flag)
        {
            return _lcls02ce;
        } else
        {
            return null;
        }
    }

    final void _mth02CA(_cls02CE _pcls02ce, boolean flag)
    {
        if (flag)
        {
            _pcls02ce.Hy.Hs = _pcls02ce.Hs;
            _pcls02ce.Hs.Hy = _pcls02ce.Hy;
        }
        _cls02CE _lcls02ce1 = _pcls02ce.Hw;
        _cls02CE _lcls02ce = _pcls02ce.Hx;
        _cls02CE _lcls02ce2 = _pcls02ce.Hv;
        if (_lcls02ce1 != null && _lcls02ce != null)
        {
            if (_lcls02ce1.height > _lcls02ce.height)
            {
                for (_lcls02ce = _lcls02ce1.Hx; _lcls02ce != null; _lcls02ce = _lcls02ce.Hx)
                {
                    _lcls02ce1 = _lcls02ce;
                }

                _lcls02ce = _lcls02ce1;
            } else
            {
                _lcls02ce1 = _lcls02ce;
                for (_lcls02ce = _lcls02ce.Hw; _lcls02ce != null; _lcls02ce = _lcls02ce.Hw)
                {
                    _lcls02ce1 = _lcls02ce;
                }

                _lcls02ce = _lcls02ce1;
            }
            _mth02CA(_lcls02ce, false);
            int i = 0;
            _lcls02ce1 = _pcls02ce.Hw;
            if (_lcls02ce1 != null)
            {
                i = _lcls02ce1.height;
                _lcls02ce.Hw = _lcls02ce1;
                _lcls02ce1.Hv = _lcls02ce;
                _pcls02ce.Hw = null;
            }
            int j = 0;
            _lcls02ce1 = _pcls02ce.Hx;
            if (_lcls02ce1 != null)
            {
                j = _lcls02ce1.height;
                _lcls02ce.Hx = _lcls02ce1;
                _lcls02ce1.Hv = _lcls02ce;
                _pcls02ce.Hx = null;
            }
            _lcls02ce.height = Math.max(i, j) + 1;
            _mth02CA(_pcls02ce, _lcls02ce);
            return;
        }
        if (_lcls02ce1 != null)
        {
            _mth02CA(_pcls02ce, _lcls02ce1);
            _pcls02ce.Hw = null;
        } else
        if (_lcls02ce != null)
        {
            _mth02CA(_pcls02ce, _lcls02ce);
            _pcls02ce.Hx = null;
        } else
        {
            _mth02CA(_pcls02ce, ((_cls02CE) (null)));
        }
        _mth02CB(_lcls02ce2, false);
        size = size - 1;
        modCount = modCount + 1;
    }

    final _cls02CE _mth1420(Object obj)
    {
        if (obj != null)
        {
            try
            {
                obj = _mth02CB(obj, false);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return null;
            }
            return ((_cls02CE) (obj));
        } else
        {
            return null;
        }
    }

    static 
    {
        boolean flag;
        if (!o/kd.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }
}
