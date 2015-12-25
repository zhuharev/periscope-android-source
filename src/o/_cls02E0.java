// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package o:
//            _cls1D53, _cls1D64, _cls03F3, _cls0491, 
//            _cls0621, FE77, _cls14BE, _cls02B1

public class _cls02E0
    implements _cls1D53
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}


    private static final int _fld1D2D[] = {
        1, 4, 5, 3, 2, 0
    };
    public final Context mContext;
    private final Resources _fld13AB;
    private boolean _fld1E6C;
    private boolean _fld1E6F;
    public if _fld1E8F;
    private ArrayList _fld1E93;
    boolean _fld1ECD;
    public ArrayList _fld1EF5;
    public ArrayList _fld1F3E;
    public boolean _fld1F3F;
    public int _fld2137;
    CharSequence _fld2161;
    Drawable _fld2171;
    View _fld3005;
    public boolean _fld3043;
    public boolean _fld30A1;
    private boolean _fld30C3;
    private boolean _fld30FE;
    private ArrayList _fld4E40;
    public CopyOnWriteArrayList _fld5B80;
    _cls03F3 FB25;
    public boolean FB46;
    ArrayList FF89;

    public _cls02E0(Context context)
    {
        _fld2137 = 0;
        _fld3043 = false;
        _fld30A1 = false;
        _fld30C3 = false;
        _fld30FE = false;
        _fld4E40 = new ArrayList();
        _fld5B80 = new CopyOnWriteArrayList();
        mContext = context;
        _fld13AB = context.getResources();
        FF89 = new ArrayList();
        _fld1E93 = new ArrayList();
        _fld1ECD = true;
        _fld1EF5 = new ArrayList();
        _fld1F3E = new ArrayList();
        _fld1F3F = true;
        boolean flag;
        if (_fld13AB.getConfiguration().keyboard != 1 && _fld13AB.getBoolean(_cls1D64.abc_config_showMenuShortcutsWhenKeyboardPresent))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        _fld1E6F = flag;
    }

    private static int _mth02CA(ArrayList arraylist, int i)
    {
        for (int j = arraylist.size() - 1; j >= 0; j--)
        {
            if (((_cls03F3)arraylist.get(j))._fld09B9 <= i)
            {
                return j + 1;
            }
        }

        return 0;
    }

    private _cls03F3 _mth02CA(int i, int j, int k, CharSequence charsequence)
    {
        int l = k >> 16;
        if (l < 0 || l >= 6)
        {
            throw new IllegalArgumentException("order does not contain a valid category.");
        } else
        {
            l = _fld1D2D[l] << 16 | 0xffff & k;
            charsequence = new _cls03F3(this, i, j, k, l, charsequence, _fld2137);
            FF89.add(_mth02CA(FF89, l), charsequence);
            FF9E(true);
            return charsequence;
        }
    }

    private void _mth02CA(List list, int i, KeyEvent keyevent)
    {
        boolean flag = _mth14BE();
        int k = keyevent.getMetaState();
        android.view.KeyCharacterMap.KeyData keydata = new android.view.KeyCharacterMap.KeyData();
        if (!keyevent.getKeyData(keydata) && i != 67)
        {
            return;
        }
        int l = FF89.size();
        for (int j = 0; j < l; j++)
        {
            _cls03F3 _lcls03f3 = (_cls03F3)FF89.get(j);
            if (_lcls03f3.hasSubMenu())
            {
                ((_cls02E0)_lcls03f3.getSubMenu())._mth02CA(list, i, keyevent);
            }
            char c;
            if (flag)
            {
                c = _lcls03f3.getAlphabeticShortcut();
            } else
            {
                c = _lcls03f3.getNumericShortcut();
            }
            if ((k & 5) == 0 && c != 0 && (c == keydata.meta[0] || c == keydata.meta[2] || flag && c == '\b' && i == 67) && _lcls03f3.isEnabled())
            {
                list.add(_lcls03f3);
            }
        }

    }

    private boolean _mth02CA(_cls0621 _pcls0621, _cls0491 _pcls0491)
    {
        if (_fld5B80.isEmpty())
        {
            return false;
        }
        boolean flag = false;
        if (_pcls0491 != null)
        {
            flag = _pcls0491._mth02CA(_pcls0621);
        }
        for (_pcls0491 = _fld5B80.iterator(); _pcls0491.hasNext();)
        {
            WeakReference weakreference = (WeakReference)_pcls0491.next();
            _cls0491 _lcls0491 = (_cls0491)weakreference.get();
            if (_lcls0491 == null)
            {
                _fld5B80.remove(weakreference);
            } else
            {
                boolean flag1 = flag;
                if (!flag)
                {
                    flag1 = _lcls0491._mth02CA(_pcls0621);
                }
                flag = flag1;
            }
        }

        return flag;
    }

    private _cls03F3 _mth02CE(int i, KeyEvent keyevent)
    {
        ArrayList arraylist = _fld4E40;
        arraylist.clear();
        _mth02CA(arraylist, i, keyevent);
        if (arraylist.isEmpty())
        {
            return null;
        }
        int k = keyevent.getMetaState();
        android.view.KeyCharacterMap.KeyData keydata = new android.view.KeyCharacterMap.KeyData();
        keyevent.getKeyData(keydata);
        int l = arraylist.size();
        if (l == 1)
        {
            return (_cls03F3)arraylist.get(0);
        }
        boolean flag = _mth14BE();
        for (int j = 0; j < l; j++)
        {
            keyevent = (_cls03F3)arraylist.get(j);
            char c;
            if (flag)
            {
                c = keyevent.getAlphabeticShortcut();
            } else
            {
                c = keyevent.getNumericShortcut();
            }
            if (c == keydata.meta[0] && (k & 2) == 0 || c == keydata.meta[2] && (k & 2) != 0 || flag && c == '\b' && i == 67)
            {
                return keyevent;
            }
        }

        return null;
    }

    private void _mth02CF(int i, boolean flag)
    {
        if (i < 0 || i >= FF89.size())
        {
            return;
        }
        FF89.remove(i);
        if (flag)
        {
            FF9E(true);
        }
    }

    private void _mth1428(boolean flag)
    {
        if (_fld5B80.isEmpty())
        {
            return;
        }
        if (!_fld3043)
        {
            _fld3043 = true;
            _fld30A1 = false;
        }
        for (Iterator iterator = _fld5B80.iterator(); iterator.hasNext();)
        {
            WeakReference weakreference = (WeakReference)iterator.next();
            _cls0491 _lcls0491 = (_cls0491)weakreference.get();
            if (_lcls0491 == null)
            {
                _fld5B80.remove(weakreference);
            } else
            {
                _lcls0491._mth1427(flag);
            }
        }

        _fld3043 = false;
        if (_fld30A1)
        {
            _fld30A1 = false;
            FF9E(true);
        }
    }

    public MenuItem add(int i)
    {
        return _mth02CA(0, 0, 0, _fld13AB.getString(i));
    }

    public MenuItem add(int i, int j, int k, int l)
    {
        return _mth02CA(i, j, k, _fld13AB.getString(l));
    }

    public MenuItem add(int i, int j, int k, CharSequence charsequence)
    {
        return _mth02CA(i, j, k, charsequence);
    }

    public MenuItem add(CharSequence charsequence)
    {
        return _mth02CA(0, 0, 0, charsequence);
    }

    public int addIntentOptions(int i, int j, int k, ComponentName componentname, Intent aintent[], Intent intent, int l, 
            MenuItem amenuitem[])
    {
        PackageManager packagemanager = mContext.getPackageManager();
        List list = packagemanager.queryIntentActivityOptions(componentname, aintent, intent, 0);
        int i1;
        if (list != null)
        {
            i1 = list.size();
        } else
        {
            i1 = 0;
        }
        if ((l & 1) == 0)
        {
            removeGroup(i);
        }
        for (l = 0; l < i1; l++)
        {
            ResolveInfo resolveinfo = (ResolveInfo)list.get(l);
            if (resolveinfo.specificIndex < 0)
            {
                componentname = intent;
            } else
            {
                componentname = aintent[resolveinfo.specificIndex];
            }
            componentname = new Intent(componentname);
            componentname.setComponent(new ComponentName(resolveinfo.activityInfo.applicationInfo.packageName, resolveinfo.activityInfo.name));
            componentname = add(i, j, k, resolveinfo.loadLabel(packagemanager)).setIcon(resolveinfo.loadIcon(packagemanager)).setIntent(componentname);
            if (amenuitem != null && resolveinfo.specificIndex >= 0)
            {
                amenuitem[resolveinfo.specificIndex] = componentname;
            }
        }

        return i1;
    }

    public SubMenu addSubMenu(int i)
    {
        return addSubMenu(0, 0, 0, ((CharSequence) (_fld13AB.getString(i))));
    }

    public SubMenu addSubMenu(int i, int j, int k, int l)
    {
        return addSubMenu(i, j, k, ((CharSequence) (_fld13AB.getString(l))));
    }

    public SubMenu addSubMenu(int i, int j, int k, CharSequence charsequence)
    {
        charsequence = (_cls03F3)_mth02CA(i, j, k, charsequence);
        _cls0621 _lcls0621 = new _cls0621(mContext, this, charsequence);
        charsequence.FB5E = _lcls0621;
        _lcls0621.setHeaderTitle(charsequence.getTitle());
        return _lcls0621;
    }

    public SubMenu addSubMenu(CharSequence charsequence)
    {
        return addSubMenu(0, 0, 0, charsequence);
    }

    public void clear()
    {
        if (FB25 != null)
        {
            _mth02BB(FB25);
        }
        FF89.clear();
        FF9E(true);
    }

    public void clearHeader()
    {
        _fld2171 = null;
        _fld2161 = null;
        _fld3005 = null;
        FF9E(false);
    }

    public void close()
    {
        FE73(true);
    }

    public MenuItem findItem(int i)
    {
        int k = size();
        for (int j = 0; j < k; j++)
        {
            Object obj = (_cls03F3)FF89.get(j);
            if (((_cls03F3) (obj)).getItemId() == i)
            {
                return ((MenuItem) (obj));
            }
            if (!((_cls03F3) (obj)).hasSubMenu())
            {
                continue;
            }
            obj = ((_cls03F3) (obj)).getSubMenu().findItem(i);
            if (obj != null)
            {
                return ((MenuItem) (obj));
            }
        }

        return null;
    }

    public MenuItem getItem(int i)
    {
        return (MenuItem)FF89.get(i);
    }

    public boolean hasVisibleItems()
    {
        if (FB46)
        {
            return true;
        }
        int j = size();
        for (int i = 0; i < j; i++)
        {
            if (((_cls03F3)FF89.get(i)).isVisible())
            {
                return true;
            }
        }

        return false;
    }

    public boolean isShortcutKey(int i, KeyEvent keyevent)
    {
        return _mth02CE(i, keyevent) != null;
    }

    public boolean performIdentifierAction(int i, int j)
    {
        return _mth02CA(findItem(i), ((_cls02B1) (null)), j);
    }

    public boolean performShortcut(int i, KeyEvent keyevent, int j)
    {
        keyevent = _mth02CE(i, keyevent);
        boolean flag = false;
        if (keyevent != null)
        {
            flag = _mth02CA(keyevent, ((_cls02B1) (null)), j);
        }
        if ((j & 2) != 0)
        {
            FE73(true);
        }
        return flag;
    }

    public void removeGroup(int i)
    {
        int l;
label0:
        {
            l = size();
            int j = 0;
            do
            {
                if (j >= l)
                {
                    break;
                }
                if (((_cls03F3)FF89.get(j)).getGroupId() == i)
                {
                    l = j;
                    break label0;
                }
                j++;
            } while (true);
            l = -1;
        }
        if (l >= 0)
        {
            int j1 = FF89.size();
            int k = 0;
            do
            {
                int i1 = k + 1;
                if (k >= j1 - l || ((_cls03F3)FF89.get(l)).getGroupId() != i)
                {
                    break;
                }
                _mth02CF(l, false);
                k = i1;
            } while (true);
            FF9E(true);
        }
    }

    public void removeItem(int i)
    {
        int j;
label0:
        {
            int k = size();
            for (j = 0; j < k; j++)
            {
                if (((_cls03F3)FF89.get(j)).getItemId() == i)
                {
                    break label0;
                }
            }

            j = -1;
        }
        _mth02CF(j, true);
    }

    public void setGroupCheckable(int i, boolean flag, boolean flag1)
    {
        int k = FF89.size();
        for (int j = 0; j < k; j++)
        {
            _cls03F3 _lcls03f3 = (_cls03F3)FF89.get(j);
            if (_lcls03f3.getGroupId() != i)
            {
                continue;
            }
            int l = _lcls03f3._fld0E20;
            byte byte0;
            if (flag1)
            {
                byte0 = 4;
            } else
            {
                byte0 = 0;
            }
            _lcls03f3._fld0E20 = l & -5 | byte0;
            _lcls03f3.setCheckable(flag);
        }

    }

    public void setGroupEnabled(int i, boolean flag)
    {
        int k = FF89.size();
        for (int j = 0; j < k; j++)
        {
            _cls03F3 _lcls03f3 = (_cls03F3)FF89.get(j);
            if (_lcls03f3.getGroupId() == i)
            {
                _lcls03f3.setEnabled(flag);
            }
        }

    }

    public void setGroupVisible(int i, boolean flag)
    {
        int k = FF89.size();
        boolean flag1 = false;
        for (int j = 0; j < k;)
        {
            _cls03F3 _lcls03f3 = (_cls03F3)FF89.get(j);
            boolean flag2 = flag1;
            if (_lcls03f3.getGroupId() == i)
            {
                flag2 = flag1;
                if (_lcls03f3._mth0559(flag))
                {
                    flag2 = true;
                }
            }
            j++;
            flag1 = flag2;
        }

        if (flag1)
        {
            FF9E(true);
        }
    }

    public void setQwertyMode(boolean flag)
    {
        _fld1E6C = flag;
        FF9E(false);
    }

    public int size()
    {
        return FF89.size();
    }

    public boolean _mth02BB(_cls03F3 _pcls03f3)
    {
        if (_fld5B80.isEmpty() || FB25 != _pcls03f3)
        {
            return false;
        }
        boolean flag = false;
        if (!_fld3043)
        {
            _fld3043 = true;
            _fld30A1 = false;
        }
        Iterator iterator = _fld5B80.iterator();
        boolean flag1;
        boolean flag2;
label0:
        do
        {
            _cls0491 _lcls0491;
            do
            {
                flag1 = flag;
                if (!iterator.hasNext())
                {
                    break label0;
                }
                WeakReference weakreference = (WeakReference)iterator.next();
                _lcls0491 = (_cls0491)weakreference.get();
                if (_lcls0491 != null)
                {
                    break;
                }
                _fld5B80.remove(weakreference);
            } while (true);
            flag2 = _lcls0491._mth02CE(_pcls03f3);
            flag = flag2;
            flag1 = flag;
        } while (!flag2);
        _fld3043 = false;
        if (_fld30A1)
        {
            _fld30A1 = false;
            FF9E(true);
        }
        if (flag1)
        {
            FB25 = null;
        }
        return flag1;
    }

    void _mth02CA(int i, CharSequence charsequence, int j, Drawable drawable, View view)
    {
        if (view != null)
        {
            _fld3005 = view;
            _fld2161 = null;
            _fld2171 = null;
        } else
        {
            if (charsequence != null)
            {
                _fld2161 = charsequence;
            }
            if (drawable != null)
            {
                _fld2171 = drawable;
            }
            _fld3005 = null;
        }
        FF9E(false);
    }

    public void _mth02CA(if if1)
    {
        _fld1E8F = if1;
    }

    public final void _mth02CA(_cls0491 _pcls0491)
    {
        Iterator iterator = _fld5B80.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            WeakReference weakreference = (WeakReference)iterator.next();
            _cls0491 _lcls0491 = (_cls0491)weakreference.get();
            if (_lcls0491 == null || _lcls0491 == _pcls0491)
            {
                _fld5B80.remove(weakreference);
            }
        } while (true);
    }

    public final boolean _mth02CA(MenuItem menuitem, _cls02B1 _pcls02b1, int i)
    {
        Object obj = (_cls03F3)menuitem;
        if (obj == null || !((_cls03F3) (obj)).isEnabled())
        {
            return false;
        }
        boolean flag2 = ((_cls03F3) (obj))._mth1D52();
        menuitem = ((_cls03F3) (obj)).FEA7;
        boolean flag;
        if (menuitem != null && menuitem.hasSubMenu())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        boolean flag1;
        if (((_cls03F3) (obj))._mth1D58())
        {
            boolean flag3 = ((_cls03F3) (obj)).expandActionView() | flag2;
            flag2 = flag3;
            flag1 = flag2;
            if (flag3)
            {
                FE73(true);
                return flag2;
            }
        } else
        {
            if (((_cls03F3) (obj)).hasSubMenu() || flag)
            {
                FE73(false);
                if (!((_cls03F3) (obj)).hasSubMenu())
                {
                    _cls0621 _lcls0621 = new _cls0621(mContext, this, ((_cls03F3) (obj)));
                    obj.FB5E = _lcls0621;
                    _lcls0621.setHeaderTitle(((_cls03F3) (obj)).getTitle());
                }
                obj = (_cls0621)((_cls03F3) (obj)).getSubMenu();
                if (flag)
                {
                    menuitem.onPrepareSubMenu(((SubMenu) (obj)));
                }
                flag1 = _mth02CA(((_cls0621) (obj)), ((_cls0491) (_pcls02b1))) | flag2;
                if (!flag1)
                {
                    FE73(true);
                }
                return flag1;
            }
            flag1 = flag2;
            if ((i & 1) == 0)
            {
                FE73(true);
                flag1 = flag2;
            }
        }
        return flag1;
    }

    boolean _mth02CB(_cls02E0 _pcls02e0, MenuItem menuitem)
    {
        return _fld1E8F != null && _fld1E8F._mth02CA(_pcls02e0, menuitem);
    }

    public final void _mth02CE(Bundle bundle)
    {
        SparseArray sparsearray = null;
        int j = size();
        for (int i = 0; i < j;)
        {
            MenuItem menuitem = getItem(i);
            View view = _cls14BE._mth02CA(menuitem);
            SparseArray sparsearray2 = sparsearray;
            if (view != null)
            {
                sparsearray2 = sparsearray;
                if (view.getId() != -1)
                {
                    SparseArray sparsearray1 = sparsearray;
                    if (sparsearray == null)
                    {
                        sparsearray1 = new SparseArray();
                    }
                    view.saveHierarchyState(sparsearray1);
                    sparsearray2 = sparsearray1;
                    if (_cls14BE._mth02CE(menuitem))
                    {
                        bundle.putInt("android:menu:expandedactionview", menuitem.getItemId());
                        sparsearray2 = sparsearray1;
                    }
                }
            }
            if (menuitem.hasSubMenu())
            {
                ((_cls0621)menuitem.getSubMenu())._mth02CE(bundle);
            }
            i++;
            sparsearray = sparsearray2;
        }

        if (sparsearray != null)
        {
            bundle.putSparseParcelableArray(_mth1466(), sparsearray);
        }
    }

    public final void _mth02CF(Bundle bundle)
    {
        if (bundle == null)
        {
            return;
        }
        SparseArray sparsearray = bundle.getSparseParcelableArray(_mth1466());
        int k = size();
        for (int i = 0; i < k; i++)
        {
            MenuItem menuitem = getItem(i);
            View view = _cls14BE._mth02CA(menuitem);
            if (view != null && view.getId() != -1)
            {
                view.restoreHierarchyState(sparsearray);
            }
            if (menuitem.hasSubMenu())
            {
                ((_cls0621)menuitem.getSubMenu())._mth02CF(bundle);
            }
        }

        int j = bundle.getInt("android:menu:expandedactionview");
        if (j > 0)
        {
            bundle = findItem(j);
            if (bundle != null)
            {
                _cls14BE._mth02CB(bundle);
            }
        }
    }

    public boolean _mth141D(_cls03F3 _pcls03f3)
    {
        if (_fld5B80.isEmpty())
        {
            return false;
        }
        boolean flag = false;
        if (!_fld3043)
        {
            _fld3043 = true;
            _fld30A1 = false;
        }
        Iterator iterator = _fld5B80.iterator();
        boolean flag1;
        boolean flag2;
label0:
        do
        {
            _cls0491 _lcls0491;
            do
            {
                flag1 = flag;
                if (!iterator.hasNext())
                {
                    break label0;
                }
                WeakReference weakreference = (WeakReference)iterator.next();
                _lcls0491 = (_cls0491)weakreference.get();
                if (_lcls0491 != null)
                {
                    break;
                }
                _fld5B80.remove(weakreference);
            } while (true);
            flag2 = _lcls0491._mth02CB(_pcls03f3);
            flag = flag2;
            flag1 = flag;
        } while (!flag2);
        _fld3043 = false;
        if (_fld30A1)
        {
            _fld30A1 = false;
            FF9E(true);
        }
        if (flag1)
        {
            FB25 = _pcls03f3;
        }
        return flag1;
    }

    protected String _mth1466()
    {
        return "android:menu:actionviewstates";
    }

    boolean _mth14BE()
    {
        return _fld1E6C;
    }

    public boolean _mth14EA()
    {
        return _fld1E6F;
    }

    final void _mth14EB()
    {
        _fld1F3F = true;
        FF9E(true);
    }

    public final ArrayList _mth153E()
    {
        if (!_fld1ECD)
        {
            return _fld1E93;
        }
        _fld1E93.clear();
        int j = FF89.size();
        for (int i = 0; i < j; i++)
        {
            _cls03F3 _lcls03f3 = (_cls03F3)FF89.get(i);
            if (_lcls03f3.isVisible())
            {
                _fld1E93.add(_lcls03f3);
            }
        }

        _fld1ECD = false;
        _fld1F3F = true;
        return _fld1E93;
    }

    public final void _mth1550()
    {
        ArrayList arraylist = _mth153E();
        if (!_fld1F3F)
        {
            return;
        }
        boolean flag = false;
        for (Iterator iterator = _fld5B80.iterator(); iterator.hasNext();)
        {
            WeakReference weakreference = (WeakReference)iterator.next();
            _cls0491 _lcls0491 = (_cls0491)weakreference.get();
            if (_lcls0491 == null)
            {
                _fld5B80.remove(weakreference);
            } else
            {
                flag |= _lcls0491._mth05F2();
            }
        }

        if (flag)
        {
            _fld1EF5.clear();
            _fld1F3E.clear();
            int j = arraylist.size();
            for (int i = 0; i < j; i++)
            {
                _cls03F3 _lcls03f3 = (_cls03F3)arraylist.get(i);
                boolean flag1;
                if ((_lcls03f3._fld0E20 & 0x20) == 32)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag1)
                {
                    _fld1EF5.add(_lcls03f3);
                } else
                {
                    _fld1F3E.add(_lcls03f3);
                }
            }

        } else
        {
            _fld1EF5.clear();
            _fld1F3E.clear();
            _fld1F3E.addAll(_mth153E());
        }
        _fld1F3F = false;
    }

    public _cls02E0 _mth155D()
    {
        return this;
    }

    public final void FE73(boolean flag)
    {
        if (_fld30FE)
        {
            return;
        }
        _fld30FE = true;
        for (Iterator iterator = _fld5B80.iterator(); iterator.hasNext();)
        {
            WeakReference weakreference = (WeakReference)iterator.next();
            _cls0491 _lcls0491 = (_cls0491)weakreference.get();
            if (_lcls0491 == null)
            {
                _fld5B80.remove(weakreference);
            } else
            {
                _lcls0491._mth02CB(this, flag);
            }
        }

        _fld30FE = false;
    }

    public final void FF9E(boolean flag)
    {
        if (!_fld3043)
        {
            if (flag)
            {
                _fld1ECD = true;
                _fld1F3F = true;
            }
            _mth1428(flag);
            return;
        } else
        {
            _fld30A1 = true;
            return;
        }
    }

}
