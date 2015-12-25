// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

// Referenced classes of package o:
//            _cls1D49

public abstract class _cls1D45 extends BaseAdapter
    implements Filterable, _cls1D49.if
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}


    public Context mContext;
    protected boolean _fld028C;
    private boolean _fld039E;
    public Cursor _fld03C2;
    private int _fld03DB;
    private if _fld0447;
    private _cls02CA _fld0453;
    private _cls1D49 _fld05D1;

    public _cls1D45(Context context, Cursor cursor, boolean flag)
    {
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        if ((i & 1) == 1)
        {
            _fld039E = true;
        } else
        {
            _fld039E = false;
        }
        if (cursor != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        _fld03C2 = cursor;
        _fld028C = flag;
        mContext = context;
        if (flag)
        {
            i = cursor.getColumnIndexOrThrow("_id");
        } else
        {
            i = -1;
        }
        _fld03DB = i;
        _fld0447 = new if();
        _fld0453 = new _cls02CA((byte)0);
        if (flag)
        {
            if (_fld0447 != null)
            {
                cursor.registerContentObserver(_fld0447);
            }
            if (_fld0453 != null)
            {
                cursor.registerDataSetObserver(_fld0453);
            }
        }
    }

    public void changeCursor(Cursor cursor)
    {
        if (cursor == _fld03C2)
        {
            cursor = null;
        } else
        {
            Cursor cursor1 = _fld03C2;
            if (cursor1 != null)
            {
                if (_fld0447 != null)
                {
                    cursor1.unregisterContentObserver(_fld0447);
                }
                if (_fld0453 != null)
                {
                    cursor1.unregisterDataSetObserver(_fld0453);
                }
            }
            _fld03C2 = cursor;
            if (cursor != null)
            {
                if (_fld0447 != null)
                {
                    cursor.registerContentObserver(_fld0447);
                }
                if (_fld0453 != null)
                {
                    cursor.registerDataSetObserver(_fld0453);
                }
                _fld03DB = cursor.getColumnIndexOrThrow("_id");
                _fld028C = true;
                notifyDataSetChanged();
            } else
            {
                _fld03DB = -1;
                _fld028C = false;
                notifyDataSetInvalidated();
            }
            cursor = cursor1;
        }
        if (cursor != null)
        {
            cursor.close();
        }
    }

    public int getCount()
    {
        if (_fld028C && _fld03C2 != null)
        {
            return _fld03C2.getCount();
        } else
        {
            return 0;
        }
    }

    public final Cursor getCursor()
    {
        return _fld03C2;
    }

    public View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        if (_fld028C)
        {
            _fld03C2.moveToPosition(i);
            if (view == null)
            {
                view = newDropDownView(mContext, _fld03C2, viewgroup);
            }
            _mth02CA(view, _fld03C2);
            return view;
        } else
        {
            return null;
        }
    }

    public Filter getFilter()
    {
        if (_fld05D1 == null)
        {
            _fld05D1 = new _cls1D49(this);
        }
        return _fld05D1;
    }

    public Object getItem(int i)
    {
        if (_fld028C && _fld03C2 != null)
        {
            _fld03C2.moveToPosition(i);
            return _fld03C2;
        } else
        {
            return null;
        }
    }

    public long getItemId(int i)
    {
        if (_fld028C && _fld03C2 != null)
        {
            if (_fld03C2.moveToPosition(i))
            {
                return _fld03C2.getLong(_fld03DB);
            } else
            {
                return 0L;
            }
        } else
        {
            return 0L;
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (!_fld028C)
        {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!_fld03C2.moveToPosition(i))
        {
            throw new IllegalStateException((new StringBuilder("couldn't move cursor to position ")).append(i).toString());
        }
        if (view == null)
        {
            view = newView(mContext, _fld03C2, viewgroup);
        }
        _mth02CA(view, _fld03C2);
        return view;
    }

    public boolean hasStableIds()
    {
        return true;
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        return newView(context, cursor, viewgroup);
    }

    public abstract View newView(Context context, Cursor cursor, ViewGroup viewgroup);

    protected final void onContentChanged()
    {
        if (_fld039E && _fld03C2 != null && !_fld03C2.isClosed())
        {
            _fld028C = _fld03C2.requery();
        }
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charsequence)
    {
        return _fld03C2;
    }

    public String _mth02CA(Cursor cursor)
    {
        if (cursor == null)
        {
            return "";
        } else
        {
            return cursor.toString();
        }
    }

    public abstract void _mth02CA(View view, Cursor cursor);
}
