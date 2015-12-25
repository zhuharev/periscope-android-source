// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class FEDF
    implements android.view.Window.Callback
{

    final android.view.Window.Callback _fld09AA;

    public FEDF(android.view.Window.Callback callback)
    {
        if (callback == null)
        {
            throw new IllegalArgumentException("Window callback may not be null");
        } else
        {
            _fld09AA = callback;
            return;
        }
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionevent)
    {
        return _fld09AA.dispatchGenericMotionEvent(motionevent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        return _fld09AA.dispatchKeyEvent(keyevent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyevent)
    {
        return _fld09AA.dispatchKeyShortcutEvent(keyevent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        return _fld09AA.dispatchPopulateAccessibilityEvent(accessibilityevent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        return _fld09AA.dispatchTouchEvent(motionevent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionevent)
    {
        return _fld09AA.dispatchTrackballEvent(motionevent);
    }

    public void onActionModeFinished(ActionMode actionmode)
    {
        _fld09AA.onActionModeFinished(actionmode);
    }

    public void onActionModeStarted(ActionMode actionmode)
    {
        _fld09AA.onActionModeStarted(actionmode);
    }

    public void onAttachedToWindow()
    {
        _fld09AA.onAttachedToWindow();
    }

    public void onContentChanged()
    {
        _fld09AA.onContentChanged();
    }

    public boolean onCreatePanelMenu(int i, Menu menu)
    {
        return _fld09AA.onCreatePanelMenu(i, menu);
    }

    public View onCreatePanelView(int i)
    {
        return _fld09AA.onCreatePanelView(i);
    }

    public void onDetachedFromWindow()
    {
        _fld09AA.onDetachedFromWindow();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuitem)
    {
        return _fld09AA.onMenuItemSelected(i, menuitem);
    }

    public boolean onMenuOpened(int i, Menu menu)
    {
        return _fld09AA.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu)
    {
        _fld09AA.onPanelClosed(i, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu)
    {
        return _fld09AA.onPreparePanel(i, view, menu);
    }

    public boolean onSearchRequested()
    {
        return _fld09AA.onSearchRequested();
    }

    public boolean onSearchRequested(SearchEvent searchevent)
    {
        return _fld09AA.onSearchRequested(searchevent);
    }

    public void onWindowAttributesChanged(android.view.WindowManager.LayoutParams layoutparams)
    {
        _fld09AA.onWindowAttributesChanged(layoutparams);
    }

    public void onWindowFocusChanged(boolean flag)
    {
        _fld09AA.onWindowFocusChanged(flag);
    }

    public ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback)
    {
        return _fld09AA.onWindowStartingActionMode(callback);
    }

    public ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback, int i)
    {
        return _fld09AA.onWindowStartingActionMode(callback, i);
    }
}
