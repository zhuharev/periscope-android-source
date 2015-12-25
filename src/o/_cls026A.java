// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Rect;

public class _cls026A
{
    /* member class not found */
    class aux {}

    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02BB {}

    /* member class not found */
    class _cls02BC {}

    /* member class not found */
    class _cls02BD {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}

    /* member class not found */
    class _cls02CF {}

    /* member class not found */
    class _cls037A {}

    /* member class not found */
    class _cls141D {}


    private static final _cls02CE _fld0393;
    private final Object _fld03C4;

    public _cls026A(Object obj)
    {
        _fld03C4 = obj;
    }

    static _cls02CE _mth02B2()
    {
        return _fld0393;
    }

    private static String _mth1428(int i)
    {
        switch (i)
        {
        case 1: // '\001'
            return "ACTION_FOCUS";

        case 2: // '\002'
            return "ACTION_CLEAR_FOCUS";

        case 4: // '\004'
            return "ACTION_SELECT";

        case 8: // '\b'
            return "ACTION_CLEAR_SELECTION";

        case 16: // '\020'
            return "ACTION_CLICK";

        case 32: // ' '
            return "ACTION_LONG_CLICK";

        case 64: // '@'
            return "ACTION_ACCESSIBILITY_FOCUS";

        case 128: 
            return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";

        case 256: 
            return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";

        case 512: 
            return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";

        case 1024: 
            return "ACTION_NEXT_HTML_ELEMENT";

        case 2048: 
            return "ACTION_PREVIOUS_HTML_ELEMENT";

        case 4096: 
            return "ACTION_SCROLL_FORWARD";

        case 8192: 
            return "ACTION_SCROLL_BACKWARD";

        case 65536: 
            return "ACTION_CUT";

        case 16384: 
            return "ACTION_COPY";

        case 32768: 
            return "ACTION_PASTE";

        case 131072: 
            return "ACTION_SET_SELECTION";
        }
        return "ACTION_UNKNOWN";
    }

    public void addAction(int i)
    {
        _fld0393._mth02CA(_fld03C4, i);
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
        obj = (_cls026A)obj;
        if (_fld03C4 == null)
        {
            if (((_cls026A) (obj))._fld03C4 != null)
            {
                return false;
            }
        } else
        if (!_fld03C4.equals(((_cls026A) (obj))._fld03C4))
        {
            return false;
        }
        return true;
    }

    public int getActions()
    {
        return _fld0393._mth02BD(_fld03C4);
    }

    public void getBoundsInParent(Rect rect)
    {
        _fld0393._mth02CA(_fld03C4, rect);
    }

    public void getBoundsInScreen(Rect rect)
    {
        _fld0393._mth02CB(_fld03C4, rect);
    }

    public CharSequence getClassName()
    {
        return _fld0393._mth037A(_fld03C4);
    }

    public CharSequence getContentDescription()
    {
        return _fld0393._mth1FBE(_fld03C4);
    }

    public CharSequence getPackageName()
    {
        return _fld0393._mth02BE(_fld03C4);
    }

    public CharSequence getText()
    {
        return _fld0393._mth02BF(_fld03C4);
    }

    public String getViewIdResourceName()
    {
        return _fld0393._mth02B9(_fld03C4);
    }

    public int hashCode()
    {
        if (_fld03C4 == null)
        {
            return 0;
        } else
        {
            return _fld03C4.hashCode();
        }
    }

    public boolean isCheckable()
    {
        return _fld0393._mth02C8(_fld03C4);
    }

    public boolean isChecked()
    {
        return _fld0393._mth02C9(_fld03C4);
    }

    public boolean isClickable()
    {
        return _fld0393._mth02CC(_fld03C4);
    }

    public boolean isEnabled()
    {
        return _fld0393._mth02CD(_fld03C4);
    }

    public boolean isFocusable()
    {
        return _fld0393._mth02D1(_fld03C4);
    }

    public boolean isFocused()
    {
        return _fld0393._mth0640(_fld03C4);
    }

    public boolean isLongClickable()
    {
        return _fld0393._mth1427(_fld03C4);
    }

    public boolean isPassword()
    {
        return _fld0393._mth1428(_fld03C4);
    }

    public boolean isScrollable()
    {
        return _fld0393.FE73(_fld03C4);
    }

    public boolean isSelected()
    {
        return _fld0393.FF9E(_fld03C4);
    }

    public void setClassName(CharSequence charsequence)
    {
        _fld0393._mth02CA(_fld03C4, charsequence);
    }

    public void setScrollable(boolean flag)
    {
        _fld0393._mth02CA(_fld03C4, flag);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(super.toString());
        Rect rect = new Rect();
        getBoundsInParent(rect);
        stringbuilder.append((new StringBuilder("; boundsInParent: ")).append(rect).toString());
        getBoundsInScreen(rect);
        stringbuilder.append((new StringBuilder("; boundsInScreen: ")).append(rect).toString());
        stringbuilder.append("; packageName: ").append(getPackageName());
        stringbuilder.append("; className: ").append(getClassName());
        stringbuilder.append("; text: ").append(getText());
        stringbuilder.append("; contentDescription: ").append(getContentDescription());
        stringbuilder.append("; viewId: ").append(getViewIdResourceName());
        stringbuilder.append("; checkable: ").append(isCheckable());
        stringbuilder.append("; checked: ").append(isChecked());
        stringbuilder.append("; focusable: ").append(isFocusable());
        stringbuilder.append("; focused: ").append(isFocused());
        stringbuilder.append("; selected: ").append(isSelected());
        stringbuilder.append("; clickable: ").append(isClickable());
        stringbuilder.append("; longClickable: ").append(isLongClickable());
        stringbuilder.append("; enabled: ").append(isEnabled());
        stringbuilder.append("; password: ").append(isPassword());
        stringbuilder.append((new StringBuilder("; scrollable: ")).append(isScrollable()).toString());
        stringbuilder.append("; [");
        int i = getActions();
        do
        {
            if (i == 0)
            {
                break;
            }
            int j = 1 << Integer.numberOfTrailingZeros(i);
            i &= ~j;
            stringbuilder.append(_mth1428(j));
            if (i != 0)
            {
                stringbuilder.append(", ");
            }
        } while (true);
        stringbuilder.append("]");
        return stringbuilder.toString();
    }

    public Object _mth01C3()
    {
        return _fld03C4;
    }

    public void _mth02BB(Object obj)
    {
        _fld0393._mth02CB(_fld03C4, ((_cls02BD)obj)._fld03C4);
    }

    public void _mth02BC(Object obj)
    {
        _fld0393._mth02CE(_fld03C4, _cls037A._mth02CA((_cls037A)obj));
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 22)
        {
            _fld0393 = new _cls02CA();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            _fld0393 = new if();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            _fld0393 = new _cls02BB();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 18)
        {
            _fld0393 = new _cls141D();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            _fld0393 = new aux();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            _fld0393 = new _cls02CF();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            _fld0393 = new _cls02CB();
        } else
        {
            _fld0393 = new _cls02BC();
        }
    }
}
