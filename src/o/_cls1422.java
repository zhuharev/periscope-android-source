// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package o:
//            _cls1551, _cls14BB, _cls150B

public class _cls1422 extends _cls1551
    implements Map
{

    private _cls14BB _fld14BC;

    public _cls1422()
    {
    }

    public Set entrySet()
    {
        if (_fld14BC == null)
        {
            _fld14BC = new _cls14BB(this);
        }
        _cls14BB _lcls14bb = _fld14BC;
        if (((_cls150B) (_lcls14bb))._fld1D43 == null)
        {
            _lcls14bb._fld1D43 = new _cls150B._cls02CA(_lcls14bb);
        }
        return ((_cls150B) (_lcls14bb))._fld1D43;
    }

    public Set keySet()
    {
        if (_fld14BC == null)
        {
            _fld14BC = new _cls14BB(this);
        }
        _cls14BB _lcls14bb = _fld14BC;
        if (((_cls150B) (_lcls14bb))._fld1D45 == null)
        {
            _lcls14bb._fld1D45 = new _cls150B._cls02CB(_lcls14bb);
        }
        return ((_cls150B) (_lcls14bb))._fld1D45;
    }

    public void putAll(Map map)
    {
        int i = _fld1D61 + map.size();
        if (super.FB40.length < i)
        {
            int ai[] = super.FB40;
            Object aobj[] = super.FB48;
            super._mth02C8(i);
            if (super._fld1D61 > 0)
            {
                System.arraycopy(ai, 0, super.FB40, 0, super._fld1D61);
                System.arraycopy(((Object) (aobj)), 0, ((Object) (super.FB48)), 0, super._fld1D61 << 1);
            }
            _cls1551._mth02CA(ai, aobj, super._fld1D61);
        }
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); put(entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

    }

    public Collection values()
    {
        if (_fld14BC == null)
        {
            _fld14BC = new _cls14BB(this);
        }
        _cls14BB _lcls14bb = _fld14BC;
        if (((_cls150B) (_lcls14bb))._fld1D49 == null)
        {
            _lcls14bb._fld1D49 = new _cls150B._cls02CF(_lcls14bb);
        }
        return ((_cls150B) (_lcls14bb))._fld1D49;
    }
}
