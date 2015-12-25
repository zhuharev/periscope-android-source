// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Map;

// Referenced classes of package o:
//            ct, cr

public class cv
{

    private static Object _fld30FD[];
    private static int _fld4E00;
    private static Object FB32[];
    private static int FB36;
    int _fld1D61;
    int FB40[];
    Object FB48[];

    public cv()
    {
        FB40 = ct._fld1506;
        FB48 = ct._fld1D16;
        _fld1D61 = 0;
    }

    static void _mth02CB(int ai[], Object aobj[], int i)
    {
        if (ai.length != 8) goto _L2; else goto _L1
_L1:
        o/cr;
        JVM INSTR monitorenter ;
        if (FB36 < 10)
        {
            aobj[0] = ((Object) (FB32));
            break MISSING_BLOCK_LABEL_24;
        }
          goto _L3
_L8:
        FB32 = aobj;
        FB36++;
_L3:
        o/cr;
        JVM INSTR monitorexit ;
        return;
        ai;
        throw ai;
_L2:
        if (ai.length != 4) goto _L5; else goto _L4
_L4:
        o/cr;
        JVM INSTR monitorenter ;
        if (_fld4E00 >= 10) goto _L7; else goto _L6
_L6:
        aobj[0] = ((Object) (_fld30FD));
        aobj[1] = ai;
        i = (i << 1) - 1;
        break MISSING_BLOCK_LABEL_134;
_L9:
        _fld30FD = aobj;
        _fld4E00++;
_L7:
        o/cr;
        JVM INSTR monitorexit ;
        return;
        ai;
        throw ai;
_L5:
        return;
        aobj[1] = ai;
        i = (i << 1) - 1;
        while (i >= 2) 
        {
            aobj[i] = null;
            i--;
        }
          goto _L8
        while (i >= 2) 
        {
            aobj[i] = null;
            i--;
        }
          goto _L9
    }

    public void clear()
    {
        if (_fld1D61 != 0)
        {
            _mth02CB(FB40, FB48, _fld1D61);
            FB40 = ct._fld1506;
            FB48 = ct._fld1D16;
            _fld1D61 = 0;
        }
    }

    public boolean containsKey(Object obj)
    {
        if (obj == null)
        {
            return _mth1D55() >= 0;
        }
        return indexOf(obj, obj.hashCode()) >= 0;
    }

    public boolean containsValue(Object obj)
    {
        return indexOfValue(obj) >= 0;
    }

    public boolean equals(Object obj)
    {
        int i;
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof Map))
        {
            break MISSING_BLOCK_LABEL_135;
        }
        obj = (Map)obj;
        if (size() != ((Map) (obj)).size())
        {
            return false;
        }
        i = 0;
_L2:
        Object obj1;
        Object obj2;
        Object obj3;
        if (i >= _fld1D61)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = FB48[i << 1];
        obj2 = FB48[(i << 1) + 1];
        obj3 = ((Map) (obj)).get(obj1);
        if (obj2 == null)
        {
            if (obj3 == null)
            {
                boolean flag;
                try
                {
                    flag = ((Map) (obj)).containsKey(obj1);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    return false;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    return false;
                }
                if (flag)
                {
                    break MISSING_BLOCK_LABEL_117;
                }
            }
            return false;
        }
        flag = obj2.equals(obj3);
        if (!flag)
        {
            return false;
        }
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return true;
        return false;
    }

    public Object get(Object obj)
    {
        int i;
        if (obj == null)
        {
            i = _mth1D55();
        } else
        {
            i = indexOf(obj, obj.hashCode());
        }
        if (i >= 0)
        {
            return FB48[(i << 1) + 1];
        } else
        {
            return null;
        }
    }

    public int hashCode()
    {
        int ai[] = FB40;
        Object aobj[] = FB48;
        int k = 0;
        int j = 0;
        int i = 1;
        for (int i1 = _fld1D61; j < i1;)
        {
            Object obj = aobj[i];
            int j1 = ai[j];
            int l;
            if (obj == null)
            {
                l = 0;
            } else
            {
                l = obj.hashCode();
            }
            k += j1 ^ l;
            j++;
            i += 2;
        }

        return k;
    }

    final int indexOf(Object obj, int i)
    {
        int k = _fld1D61;
        if (k == 0)
        {
            return -1;
        }
        int i1 = ct._mth02CA(FB40, k, i);
        if (i1 < 0)
        {
            return i1;
        }
        if (obj.equals(FB48[i1 << 1]))
        {
            return i1;
        }
        int j;
        for (j = i1 + 1; j < k && FB40[j] == i; j++)
        {
            if (obj.equals(FB48[j << 1]))
            {
                return j;
            }
        }

        for (int l = i1 - 1; l >= 0 && FB40[l] == i; l--)
        {
            if (obj.equals(FB48[l << 1]))
            {
                return l;
            }
        }

        return ~j;
    }

    final int indexOfValue(Object obj)
    {
        int k = _fld1D61 << 1;
        Object aobj[] = FB48;
        if (obj == null)
        {
            for (int i = 1; i < k; i += 2)
            {
                if (aobj[i] == null)
                {
                    return i >> 1;
                }
            }

        } else
        {
            for (int j = 1; j < k; j += 2)
            {
                if (obj.equals(aobj[j]))
                {
                    return j >> 1;
                }
            }

        }
        return -1;
    }

    public boolean isEmpty()
    {
        return _fld1D61 <= 0;
    }

    public Object put(Object obj, Object obj1)
    {
        int i;
        int k;
        if (obj == null)
        {
            k = 0;
            i = _mth1D55();
        } else
        {
            k = obj.hashCode();
            i = indexOf(obj, k);
        }
        if (i >= 0)
        {
            i = (i << 1) + 1;
            obj = FB48[i];
            FB48[i] = obj1;
            return obj;
        }
        int l = ~i;
        if (_fld1D61 >= FB40.length)
        {
            int j;
            if (_fld1D61 >= 8)
            {
                j = _fld1D61 + (_fld1D61 >> 1);
            } else
            if (_fld1D61 >= 4)
            {
                j = 8;
            } else
            {
                j = 4;
            }
            int ai[] = FB40;
            Object aobj[] = FB48;
            _mth1422(j);
            if (FB40.length > 0)
            {
                System.arraycopy(ai, 0, FB40, 0, ai.length);
                System.arraycopy(((Object) (aobj)), 0, ((Object) (FB48)), 0, aobj.length);
            }
            _mth02CB(ai, aobj, _fld1D61);
        }
        if (l < _fld1D61)
        {
            int ai1[] = FB40;
            System.arraycopy(ai1, l, ai1, l + 1, _fld1D61 - l);
            System.arraycopy(((Object) (FB48)), l << 1, ((Object) (FB48)), l + 1 << 1, _fld1D61 - l << 1);
        }
        FB40[l] = k;
        FB48[l << 1] = obj;
        FB48[(l << 1) + 1] = obj1;
        _fld1D61 = _fld1D61 + 1;
        return null;
    }

    public Object remove(Object obj)
    {
        int i;
        if (obj == null)
        {
            i = _mth1D55();
        } else
        {
            i = indexOf(obj, obj.hashCode());
        }
        if (i >= 0)
        {
            return removeAt(i);
        } else
        {
            return null;
        }
    }

    public final Object removeAt(int i)
    {
        Object obj = FB48[(i << 1) + 1];
        if (_fld1D61 <= 1)
        {
            _mth02CB(FB40, FB48, _fld1D61);
            FB40 = ct._fld1506;
            FB48 = ct._fld1D16;
            _fld1D61 = 0;
            return obj;
        }
        if (FB40.length > 8 && _fld1D61 < FB40.length / 3)
        {
            int j;
            if (_fld1D61 > 8)
            {
                j = _fld1D61 + (_fld1D61 >> 1);
            } else
            {
                j = 8;
            }
            int ai[] = FB40;
            Object aobj[] = FB48;
            _mth1422(j);
            _fld1D61 = _fld1D61 - 1;
            if (i > 0)
            {
                System.arraycopy(ai, 0, FB40, 0, i);
                System.arraycopy(((Object) (aobj)), 0, ((Object) (FB48)), 0, i << 1);
            }
            if (i < _fld1D61)
            {
                System.arraycopy(ai, i + 1, FB40, i, _fld1D61 - i);
                System.arraycopy(((Object) (aobj)), i + 1 << 1, ((Object) (FB48)), i << 1, _fld1D61 - i << 1);
            }
            return obj;
        }
        _fld1D61 = _fld1D61 - 1;
        if (i < _fld1D61)
        {
            System.arraycopy(FB40, i + 1, FB40, i, _fld1D61 - i);
            System.arraycopy(((Object) (FB48)), i + 1 << 1, ((Object) (FB48)), i << 1, _fld1D61 - i << 1);
        }
        FB48[_fld1D61 << 1] = null;
        FB48[(_fld1D61 << 1) + 1] = null;
        return obj;
    }

    public int size()
    {
        return _fld1D61;
    }

    public String toString()
    {
        if (isEmpty())
        {
            return "{}";
        }
        StringBuilder stringbuilder = new StringBuilder(_fld1D61 * 28);
        stringbuilder.append('{');
        for (int i = 0; i < _fld1D61; i++)
        {
            if (i > 0)
            {
                stringbuilder.append(", ");
            }
            Object obj = FB48[i << 1];
            if (obj != this)
            {
                stringbuilder.append(obj);
            } else
            {
                stringbuilder.append("(this Map)");
            }
            stringbuilder.append('=');
            obj = FB48[(i << 1) + 1];
            if (obj != this)
            {
                stringbuilder.append(obj);
            } else
            {
                stringbuilder.append("(this Map)");
            }
        }

        stringbuilder.append('}');
        return stringbuilder.toString();
    }

    void _mth1422(int i)
    {
        if (i != 8)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        o/cr;
        JVM INSTR monitorenter ;
        Object aobj[];
        if (FB32 == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        aobj = FB32;
        FB48 = aobj;
        FB32 = (Object[])aobj[0];
        FB40 = (int[])aobj[1];
        aobj[1] = null;
        aobj[0] = null;
        FB36--;
        o/cr;
        JVM INSTR monitorexit ;
        return;
        o/cr;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_149;
        Exception exception;
        exception;
        throw exception;
        if (i != 4)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        o/cr;
        JVM INSTR monitorenter ;
        if (_fld30FD == null)
        {
            break MISSING_BLOCK_LABEL_137;
        }
        exception = ((Exception) (_fld30FD));
        FB48 = exception;
        _fld30FD = (Object[])exception[0];
        FB40 = (int[])exception[1];
        exception[1] = null;
        exception[0] = null;
        _fld4E00--;
        o/cr;
        JVM INSTR monitorexit ;
        return;
        o/cr;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_149;
        exception;
        throw exception;
        FB40 = new int[i];
        FB48 = new Object[i << 1];
        return;
    }

    final int _mth1D55()
    {
        int j = _fld1D61;
        if (j == 0)
        {
            return -1;
        }
        int l = ct._mth02CA(FB40, j, 0);
        if (l < 0)
        {
            return l;
        }
        if (FB48[l << 1] == null)
        {
            return l;
        }
        int i;
        for (i = l + 1; i < j && FB40[i] == 0; i++)
        {
            if (FB48[i << 1] == null)
            {
                return i;
            }
        }

        for (int k = l - 1; k >= 0 && FB40[k] == 0; k--)
        {
            if (FB48[k << 1] == null)
            {
                return k;
            }
        }

        return ~i;
    }
}
