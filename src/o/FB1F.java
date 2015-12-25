// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package o:
//            _cls1541, _cls1FD3, FEAC

public class FB1F
    implements _cls1FD3.if
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}


    public static final int A = 0x7f020083;
    public static final int B = 0x7f020084;
    private _cls1541 r;
    public final ArrayList s;
    public final ArrayList t;
    private if u;
    private boolean v;
    private _cls1FD3 z;

    public FB1F()
    {
    }

    private FB1F(if if1, boolean flag)
    {
        r = new _cls1541(30);
        s = new ArrayList();
        t = new ArrayList();
        u = if1;
        v = false;
        z = new _cls1FD3(this);
    }

    public FB1F(FEAC feac)
    {
        this(((if) (feac)), false);
    }

    private int _mth02BE(int i, int j)
    {
        int k = t.size() - 1;
        int l;
        for (l = i; k >= 0; l = i)
        {
label0:
            {
                _cls02CA _lcls02ca = (_cls02CA)t.get(k);
                if (_lcls02ca.FE7A == 3)
                {
                    int i1;
                    if (_lcls02ca.C < _lcls02ca.D)
                    {
                        i = _lcls02ca.C;
                        i1 = _lcls02ca.D;
                    } else
                    {
                        i = _lcls02ca.D;
                        i1 = _lcls02ca.C;
                    }
                    if (l >= i && l <= i1)
                    {
                        if (i == _lcls02ca.C)
                        {
                            if (j == 0)
                            {
                                _lcls02ca.D = _lcls02ca.D + 1;
                            } else
                            if (j == 1)
                            {
                                _lcls02ca.D = _lcls02ca.D - 1;
                            }
                            i = l + 1;
                        } else
                        {
                            if (j == 0)
                            {
                                _lcls02ca.C = _lcls02ca.C + 1;
                            } else
                            if (j == 1)
                            {
                                _lcls02ca.C = _lcls02ca.C - 1;
                            }
                            i = l - 1;
                        }
                        break label0;
                    }
                    if (l < _lcls02ca.C)
                    {
                        if (j == 0)
                        {
                            _lcls02ca.C = _lcls02ca.C + 1;
                            _lcls02ca.D = _lcls02ca.D + 1;
                            i = l;
                            break label0;
                        }
                        if (j == 1)
                        {
                            _lcls02ca.C = _lcls02ca.C - 1;
                            _lcls02ca.D = _lcls02ca.D - 1;
                        }
                    }
                    i = l;
                } else
                if (_lcls02ca.C <= l)
                {
                    if (_lcls02ca.FE7A == 0)
                    {
                        i = l - _lcls02ca.D;
                    } else
                    {
                        i = l;
                        if (_lcls02ca.FE7A == 1)
                        {
                            i = l + _lcls02ca.D;
                        }
                    }
                } else
                if (j == 0)
                {
                    _lcls02ca.C = _lcls02ca.C + 1;
                    i = l;
                } else
                {
                    i = l;
                    if (j == 1)
                    {
                        _lcls02ca.C = _lcls02ca.C - 1;
                        i = l;
                    }
                }
            }
            k--;
        }

        for (i = t.size() - 1; i >= 0; i--)
        {
            _cls02CA _lcls02ca1 = (_cls02CA)t.get(i);
            if (_lcls02ca1.FE7A == 3)
            {
                if (_lcls02ca1.D != _lcls02ca1.C && _lcls02ca1.D >= 0)
                {
                    continue;
                }
                t.remove(i);
                if (!v)
                {
                    r._mth02CA(_lcls02ca1);
                }
                continue;
            }
            if (_lcls02ca1.D > 0)
            {
                continue;
            }
            t.remove(i);
            if (!v)
            {
                r._mth02CA(_lcls02ca1);
            }
        }

        return l;
    }

    private void _mth02CA(_cls02CA _pcls02ca, int i)
    {
        u._mth141D(_pcls02ca);
        switch (_pcls02ca.FE7A)
        {
        case 1: // '\001'
            u._mth02C8(i, _pcls02ca.D);
            return;

        case 2: // '\002'
            u._mth02CC(i, _pcls02ca.D);
            return;
        }
        throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    }

    private void _mth02CB(_cls02CA _pcls02ca)
    {
        if (_pcls02ca.FE7A == 0 || _pcls02ca.FE7A == 3)
        {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int i1 = _mth02BE(_pcls02ca.C, _pcls02ca.FE7A);
        int j1 = 1;
        int j = _pcls02ca.C;
        int k;
        switch (_pcls02ca.FE7A)
        {
        case 2: // '\002'
            k = 1;
            break;

        case 1: // '\001'
            k = 0;
            break;

        default:
            throw new IllegalArgumentException((new StringBuilder("op should be remove or update.")).append(_pcls02ca).toString());
        }
        for (int l = 1; l < _pcls02ca.D;)
        {
            int k1 = _mth02BE(_pcls02ca.C + k * l, _pcls02ca.FE7A);
            boolean flag = false;
            switch (_pcls02ca.FE7A)
            {
            case 2: // '\002'
                if (k1 == i1 + 1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                break;

            case 1: // '\001'
                if (k1 == i1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                break;
            }
            int i;
            if (flag)
            {
                i = j1 + 1;
            } else
            {
                _cls02CA _lcls02ca = _mth02BC(_pcls02ca.FE7A, i1, j1);
                _mth02CA(_lcls02ca, j);
                if (!v)
                {
                    r._mth02CA(_lcls02ca);
                }
                i = j;
                if (_pcls02ca.FE7A == 2)
                {
                    i = j + j1;
                }
                i1 = k1;
                j1 = 1;
                j = i;
                i = j1;
            }
            l++;
            j1 = i;
        }

        if (!v)
        {
            r._mth02CA(_pcls02ca);
        }
        if (j1 > 0)
        {
            _pcls02ca = _mth02BC(_pcls02ca.FE7A, i1, j1);
            _mth02CA(_pcls02ca, j);
            if (!v)
            {
                r._mth02CA(_pcls02ca);
            }
        }
    }

    private void _mth02CE(_cls02CA _pcls02ca)
    {
        t.add(_pcls02ca);
        switch (_pcls02ca.FE7A)
        {
        case 0: // '\0'
            u._mth02CD(_pcls02ca.C, _pcls02ca.D);
            return;

        case 3: // '\003'
            u._mth02D1(_pcls02ca.C, _pcls02ca.D);
            return;

        case 1: // '\001'
            u._mth02C9(_pcls02ca.C, _pcls02ca.D);
            return;

        case 2: // '\002'
            u._mth02CC(_pcls02ca.C, _pcls02ca.D);
            return;
        }
        throw new IllegalArgumentException((new StringBuilder("Unknown update op type for ")).append(_pcls02ca).toString());
    }

    private boolean _mth1429(int i)
    {
        int l = t.size();
label0:
        for (int j = 0; j < l; j++)
        {
            _cls02CA _lcls02ca = (_cls02CA)t.get(j);
            if (_lcls02ca.FE7A == 3)
            {
                if (_mth02BF(_lcls02ca.D, j + 1) == i)
                {
                    return true;
                }
                continue;
            }
            if (_lcls02ca.FE7A != 0)
            {
                continue;
            }
            int i1 = _lcls02ca.C;
            int j1 = _lcls02ca.D;
            int k = _lcls02ca.C;
            do
            {
                if (k >= i1 + j1)
                {
                    continue label0;
                }
                if (_mth02BF(k, j + 1) == i)
                {
                    return true;
                }
                k++;
            } while (true);
        }

        return false;
    }

    public final _cls02CA _mth02BC(int i, int j, int k)
    {
        _cls02CA _lcls02ca = (_cls02CA)r._mth1540();
        if (_lcls02ca == null)
        {
            return new _cls02CA(i, j, k);
        } else
        {
            _lcls02ca.FE7A = i;
            _lcls02ca.C = j;
            _lcls02ca.D = k;
            return _lcls02ca;
        }
    }

    public final int _mth02BF(int i, int j)
    {
        int i1 = t.size();
        int l = j;
        for (j = i; l < i1; j = i)
        {
            _cls02CA _lcls02ca = (_cls02CA)t.get(l);
            if (_lcls02ca.FE7A == 3)
            {
                if (_lcls02ca.C == j)
                {
                    i = _lcls02ca.D;
                } else
                {
                    int k = j;
                    if (_lcls02ca.C < j)
                    {
                        k = j - 1;
                    }
                    i = k;
                    if (_lcls02ca.D <= k)
                    {
                        i = k + 1;
                    }
                }
            } else
            {
                i = j;
                if (_lcls02ca.C <= j)
                {
                    if (_lcls02ca.FE7A == 1)
                    {
                        if (j < _lcls02ca.C + _lcls02ca.D)
                        {
                            return -1;
                        }
                        i = j - _lcls02ca.D;
                    } else
                    {
                        i = j;
                        if (_lcls02ca.FE7A == 0)
                        {
                            i = j + _lcls02ca.D;
                        }
                    }
                }
            }
            l++;
        }

        return j;
    }

    public final void _mth02CB(ArrayList arraylist)
    {
        int j = arraylist.size();
        for (int i = 0; i < j; i++)
        {
            _cls02CA _lcls02ca = (_cls02CA)arraylist.get(i);
            if (!v)
            {
                r._mth02CA(_lcls02ca);
            }
        }

        arraylist.clear();
    }

    public final void _mth02CF(_cls02CA _pcls02ca)
    {
        if (!v)
        {
            r._mth02CA(_pcls02ca);
        }
    }

    public final void _mth05D6()
    {
        _cls1FD3 _lcls1fd3 = z;
        ArrayList arraylist = s;
        do
        {
            int j1;
label0:
            {
                j1 = 0;
                for (int i = arraylist.size() - 1; i >= 0;)
                {
                    boolean flag1;
                    if (((_cls02CA)arraylist.get(i)).FE7A == 3)
                    {
                        flag1 = j1;
                        if (j1 != 0)
                        {
                            j1 = i;
                            break label0;
                        }
                    } else
                    {
                        flag1 = true;
                    }
                    i--;
                    j1 = ((flag1) ? 1 : 0);
                }

                j1 = -1;
            }
            if (j1 == -1)
            {
                break;
            }
            int j4 = j1 + 1;
            _cls02CA _lcls02ca6 = (_cls02CA)arraylist.get(j1);
            _cls02CA _lcls02ca7 = (_cls02CA)arraylist.get(j4);
            switch (_lcls02ca7.FE7A)
            {
            default:
                break;

            case 1: // '\001'
                _cls02CA _lcls02ca = null;
                boolean flag3 = false;
                boolean flag;
                boolean flag2;
                if (_lcls02ca6.C < _lcls02ca6.D)
                {
                    boolean flag4 = false;
                    flag = flag3;
                    flag2 = flag4;
                    if (_lcls02ca7.C == _lcls02ca6.C)
                    {
                        flag = flag3;
                        flag2 = flag4;
                        if (_lcls02ca7.D == _lcls02ca6.D - _lcls02ca6.C)
                        {
                            flag = true;
                            flag2 = flag4;
                        }
                    }
                } else
                {
                    boolean flag5 = true;
                    flag = flag3;
                    flag2 = flag5;
                    if (_lcls02ca7.C == _lcls02ca6.D + 1)
                    {
                        flag = flag3;
                        flag2 = flag5;
                        if (_lcls02ca7.D == _lcls02ca6.C - _lcls02ca6.D)
                        {
                            flag = true;
                            flag2 = flag5;
                        }
                    }
                }
                if (_lcls02ca6.D < _lcls02ca7.C)
                {
                    _lcls02ca7.C = _lcls02ca7.C - 1;
                } else
                if (_lcls02ca6.D < _lcls02ca7.C + _lcls02ca7.D)
                {
                    _lcls02ca7.D = _lcls02ca7.D - 1;
                    _lcls02ca6.FE7A = 1;
                    _lcls02ca6.D = 1;
                    if (_lcls02ca7.D == 0)
                    {
                        arraylist.remove(j4);
                        _lcls1fd3.dq._mth02CF(_lcls02ca7);
                    }
                    continue;
                }
                if (_lcls02ca6.C <= _lcls02ca7.C)
                {
                    _lcls02ca7.C = _lcls02ca7.C + 1;
                } else
                if (_lcls02ca6.C < _lcls02ca7.C + _lcls02ca7.D)
                {
                    int k2 = _lcls02ca7.C;
                    int j3 = _lcls02ca7.D;
                    int l4 = _lcls02ca6.C;
                    _lcls02ca = _lcls1fd3.dq._mth02BC(1, _lcls02ca6.C + 1, (k2 + j3) - l4);
                    _lcls02ca7.D = _lcls02ca6.C - _lcls02ca7.C;
                }
                if (flag)
                {
                    arraylist.set(j1, _lcls02ca7);
                    arraylist.remove(j4);
                    _lcls1fd3.dq._mth02CF(_lcls02ca6);
                } else
                {
                    if (flag2)
                    {
                        if (_lcls02ca != null)
                        {
                            if (_lcls02ca6.C > _lcls02ca.C)
                            {
                                _lcls02ca6.C = _lcls02ca6.C - _lcls02ca.D;
                            }
                            if (_lcls02ca6.D > _lcls02ca.C)
                            {
                                _lcls02ca6.D = _lcls02ca6.D - _lcls02ca.D;
                            }
                        }
                        if (_lcls02ca6.C > _lcls02ca7.C)
                        {
                            _lcls02ca6.C = _lcls02ca6.C - _lcls02ca7.D;
                        }
                        if (_lcls02ca6.D > _lcls02ca7.C)
                        {
                            _lcls02ca6.D = _lcls02ca6.D - _lcls02ca7.D;
                        }
                    } else
                    {
                        if (_lcls02ca != null)
                        {
                            if (_lcls02ca6.C >= _lcls02ca.C)
                            {
                                _lcls02ca6.C = _lcls02ca6.C - _lcls02ca.D;
                            }
                            if (_lcls02ca6.D >= _lcls02ca.C)
                            {
                                _lcls02ca6.D = _lcls02ca6.D - _lcls02ca.D;
                            }
                        }
                        if (_lcls02ca6.C >= _lcls02ca7.C)
                        {
                            _lcls02ca6.C = _lcls02ca6.C - _lcls02ca7.D;
                        }
                        if (_lcls02ca6.D >= _lcls02ca7.C)
                        {
                            _lcls02ca6.D = _lcls02ca6.D - _lcls02ca7.D;
                        }
                    }
                    arraylist.set(j1, _lcls02ca7);
                    if (_lcls02ca6.C != _lcls02ca6.D)
                    {
                        arraylist.set(j4, _lcls02ca6);
                    } else
                    {
                        arraylist.remove(j4);
                    }
                    if (_lcls02ca != null)
                    {
                        arraylist.add(j1, _lcls02ca);
                    }
                }
                break;

            case 0: // '\0'
                int j = 0;
                if (_lcls02ca6.D < _lcls02ca7.C)
                {
                    j = 0 - 1;
                }
                int l1 = j;
                if (_lcls02ca6.C < _lcls02ca7.C)
                {
                    l1 = j + 1;
                }
                if (_lcls02ca7.C <= _lcls02ca6.C)
                {
                    _lcls02ca6.C = _lcls02ca6.C + _lcls02ca7.D;
                }
                if (_lcls02ca7.C <= _lcls02ca6.D)
                {
                    _lcls02ca6.D = _lcls02ca6.D + _lcls02ca7.D;
                }
                _lcls02ca7.C = _lcls02ca7.C + l1;
                arraylist.set(j1, _lcls02ca7);
                arraylist.set(j4, _lcls02ca6);
                break;

            case 2: // '\002'
                _cls02CA _lcls02ca1 = null;
                _cls02CA _lcls02ca3 = null;
                if (_lcls02ca6.D < _lcls02ca7.C)
                {
                    _lcls02ca7.C = _lcls02ca7.C - 1;
                } else
                if (_lcls02ca6.D < _lcls02ca7.C + _lcls02ca7.D)
                {
                    _lcls02ca7.D = _lcls02ca7.D - 1;
                    _lcls02ca1 = _lcls1fd3.dq._mth02BC(2, _lcls02ca6.C, 1);
                }
                if (_lcls02ca6.C <= _lcls02ca7.C)
                {
                    _lcls02ca7.C = _lcls02ca7.C + 1;
                } else
                if (_lcls02ca6.C < _lcls02ca7.C + _lcls02ca7.D)
                {
                    int k = (_lcls02ca7.C + _lcls02ca7.D) - _lcls02ca6.C;
                    _lcls02ca3 = _lcls1fd3.dq._mth02BC(2, _lcls02ca6.C + 1, k);
                    _lcls02ca7.D = _lcls02ca7.D - k;
                }
                arraylist.set(j4, _lcls02ca6);
                if (_lcls02ca7.D > 0)
                {
                    arraylist.set(j1, _lcls02ca7);
                } else
                {
                    arraylist.remove(j1);
                    _lcls1fd3.dq._mth02CF(_lcls02ca7);
                }
                if (_lcls02ca1 != null)
                {
                    arraylist.add(j1, _lcls02ca1);
                }
                if (_lcls02ca3 != null)
                {
                    arraylist.add(j1, _lcls02ca3);
                }
                break;
            }
        } while (true);
        int l5 = s.size();
        for (int i5 = 0; i5 < l5; i5++)
        {
            _cls02CA _lcls02ca2 = (_cls02CA)s.get(i5);
            switch (_lcls02ca2.FE7A)
            {
            default:
                break;

            case 0: // '\0'
                _mth02CE(_lcls02ca2);
                break;

            case 1: // '\001'
                int j5 = _lcls02ca2.C;
                int k3 = 0;
                int l2 = _lcls02ca2.C + _lcls02ca2.D;
                byte byte1 = -1;
                int i2;
                for (int l = _lcls02ca2.C; l < l2; l = i2)
                {
                    byte byte0 = 0;
                    i2 = 0;
                    if (u._mth1540(l) != null || _mth1429(l))
                    {
                        if (byte1 == 0)
                        {
                            _mth02CB(_mth02BC(1, j5, k3));
                            i2 = 1;
                        }
                        byte0 = 1;
                    } else
                    {
                        if (byte1 == 1)
                        {
                            _mth02CE(_mth02BC(1, j5, k3));
                            byte0 = 1;
                        }
                        byte1 = 0;
                        i2 = byte0;
                        byte0 = byte1;
                    }
                    if (i2 != 0)
                    {
                        i2 = l - k3;
                        l2 -= k3;
                        l = 1;
                    } else
                    {
                        k3++;
                        i2 = l;
                        l = k3;
                    }
                    i2++;
                    k3 = l;
                    byte1 = byte0;
                }

                _cls02CA _lcls02ca4 = _lcls02ca2;
                if (k3 != _lcls02ca2.D)
                {
                    if (!v)
                    {
                        r._mth02CA(_lcls02ca2);
                    }
                    _lcls02ca4 = _mth02BC(1, j5, k3);
                }
                if (byte1 == 0)
                {
                    _mth02CB(_lcls02ca4);
                } else
                {
                    _mth02CE(_lcls02ca4);
                }
                break;

            case 2: // '\002'
                int k1 = _lcls02ca2.C;
                int j2 = 0;
                int i6 = _lcls02ca2.C;
                int j6 = _lcls02ca2.D;
                int k5 = -1;
                for (int i1 = _lcls02ca2.C; i1 < i6 + j6;)
                {
                    int i3;
                    int k4;
                    if (u._mth1540(i1) != null || _mth1429(i1))
                    {
                        int l3 = k1;
                        i3 = j2;
                        if (k5 == 0)
                        {
                            _mth02CB(_mth02BC(2, k1, j2));
                            i3 = 0;
                            l3 = i1;
                        }
                        j2 = 1;
                        k1 = l3;
                        k4 = i3;
                        i3 = j2;
                    } else
                    {
                        int i4 = k1;
                        k4 = j2;
                        if (k5 == 1)
                        {
                            _mth02CE(_mth02BC(2, k1, j2));
                            k4 = 0;
                            i4 = i1;
                        }
                        i3 = 0;
                        k1 = i4;
                    }
                    j2 = k4 + 1;
                    i1++;
                    k5 = i3;
                }

                _cls02CA _lcls02ca5 = _lcls02ca2;
                if (j2 != _lcls02ca2.D)
                {
                    if (!v)
                    {
                        r._mth02CA(_lcls02ca2);
                    }
                    _lcls02ca5 = _mth02BC(2, k1, j2);
                }
                if (k5 == 0)
                {
                    _mth02CB(_lcls02ca5);
                } else
                {
                    _mth02CE(_lcls02ca5);
                }
                break;

            case 3: // '\003'
                _mth02CE(_lcls02ca2);
                break;
            }
        }

        s.clear();
    }

    public final void _mth05DF()
    {
        int j = t.size();
        for (int i = 0; i < j; i++)
        {
            u._mth02BB((_cls02CA)t.get(i));
        }

        _mth02CB(t);
    }

    public final void _mth05E0()
    {
        _mth05DF();
        int j = s.size();
        for (int i = 0; i < j; i++)
        {
            _cls02CA _lcls02ca = (_cls02CA)s.get(i);
            switch (_lcls02ca.FE7A)
            {
            case 0: // '\0'
                u._mth02BB(_lcls02ca);
                u._mth02CD(_lcls02ca.C, _lcls02ca.D);
                break;

            case 1: // '\001'
                u._mth02BB(_lcls02ca);
                u._mth02C8(_lcls02ca.C, _lcls02ca.D);
                break;

            case 2: // '\002'
                u._mth02BB(_lcls02ca);
                u._mth02CC(_lcls02ca.C, _lcls02ca.D);
                break;

            case 3: // '\003'
                u._mth02BB(_lcls02ca);
                u._mth02D1(_lcls02ca.C, _lcls02ca.D);
                break;
            }
        }

        _mth02CB(s);
    }

    public final int _mth144A(int i)
    {
        return _mth02BF(i, 0);
    }
}
