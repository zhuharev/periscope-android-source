// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

// Referenced classes of package o:
//            _cls1541, _cls0696, _cls06D5, _cls1D38, 
//            _cls02D0

public final class _cls0715
{
    /* member class not found */
    class if {}


    public static final boolean hI;
    private static final WeakHashMap hJ = new WeakHashMap();
    private static final if hK = new if(6);
    private static final int hL[];
    private static final int hM[];
    private static final int hN[];
    private static final int hO[];
    private static final int hP[];
    private static final int hQ[];
    private static final android.graphics.PorterDuff.Mode _fld026A;
    private final WeakReference hR;
    private SparseArray hS;
    private ColorStateList hT;

    private _cls0715(Context context)
    {
        hR = new WeakReference(context);
    }

    private ColorStateList _mth02BE(Context context)
    {
        if (hT == null)
        {
            int i = _cls0696._mth02BB(context, _cls1541.colorControlNormal);
            int j = _cls0696._mth02BB(context, _cls1541.colorControlActivated);
            int ai[] = _cls0696.hA;
            int k = _cls0696._mth02BD(context, _cls1541.colorControlNormal);
            hT = new ColorStateList(new int[][] {
                ai, _cls0696.FOCUSED_STATE_SET, _cls0696.hB, _cls0696.PRESSED_STATE_SET, _cls0696.hC, _cls0696.SELECTED_STATE_SET, _cls0696.EMPTY_STATE_SET
            }, new int[] {
                k, j, j, j, j, j, i
            });
        }
        return hT;
    }

    private static ColorStateList _mth02BF(Context context)
    {
        int ai[] = _cls0696.hA;
        int i = _cls0696._mth02BD(context, _cls1541.colorControlNormal);
        int ai1[] = _cls0696.hC;
        int j = _cls0696._mth02BB(context, _cls1541.colorControlActivated);
        int ai2[] = _cls0696.EMPTY_STATE_SET;
        int k = _cls0696._mth02BB(context, _cls1541.colorControlNormal);
        return new ColorStateList(new int[][] {
            ai, ai1, ai2
        }, new int[] {
            i, j, k
        });
    }

    private static ColorStateList _mth02C8(Context context)
    {
        int ai[] = _cls0696.hA;
        int i = _cls0696._mth02CA(context, 0x1010030, 0.1F);
        int ai1[] = _cls0696.hC;
        int j = _cls0696._mth02CA(context, _cls1541.colorControlActivated, 0.3F);
        int ai2[] = _cls0696.EMPTY_STATE_SET;
        int k = _cls0696._mth02CA(context, 0x1010030, 0.3F);
        return new ColorStateList(new int[][] {
            ai, ai1, ai2
        }, new int[] {
            i, j, k
        });
    }

    private static ColorStateList _mth02C9(Context context)
    {
        int ai[][] = new int[3][];
        int ai1[] = new int[3];
        ColorStateList colorstatelist = _cls0696._mth02BC(context, _cls1541.colorSwitchThumbNormal);
        if (colorstatelist != null && colorstatelist.isStateful())
        {
            ai[0] = _cls0696.hA;
            ai1[0] = colorstatelist.getColorForState(ai[0], 0);
            ai[1] = _cls0696.hC;
            ai1[1] = _cls0696._mth02BB(context, _cls1541.colorControlActivated);
            ai[2] = _cls0696.EMPTY_STATE_SET;
            ai1[2] = colorstatelist.getDefaultColor();
        } else
        {
            ai[0] = _cls0696.hA;
            ai1[0] = _cls0696._mth02BD(context, _cls1541.colorSwitchThumbNormal);
            ai[1] = _cls0696.hC;
            ai1[1] = _cls0696._mth02BB(context, _cls1541.colorControlActivated);
            ai[2] = _cls0696.EMPTY_STATE_SET;
            ai1[2] = _cls0696._mth02BB(context, _cls1541.colorSwitchThumbNormal);
        }
        return new ColorStateList(ai, ai1);
    }

    public static void _mth02CA(Drawable drawable, _cls06D5 _pcls06d5, int ai[])
    {
        if (_mth037A(drawable) && drawable.mutate() != drawable)
        {
            Log.d("TintManager", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if (_pcls06d5.hH || _pcls06d5.hG)
        {
            ColorStateList colorstatelist;
            if (_pcls06d5.hH)
            {
                colorstatelist = _pcls06d5._fld027E;
            } else
            {
                colorstatelist = null;
            }
            if (_pcls06d5.hG)
            {
                _pcls06d5 = _pcls06d5._fld027F;
            } else
            {
                _pcls06d5 = _fld026A;
            }
            if (colorstatelist == null || _pcls06d5 == null)
            {
                _pcls06d5 = null;
            } else
            {
                _pcls06d5 = _mth02CB(colorstatelist.getColorForState(ai, 0), _pcls06d5);
            }
            drawable.setColorFilter(_pcls06d5);
        } else
        {
            drawable.clearColorFilter();
        }
        if (android.os.Build.VERSION.SDK_INT <= 10)
        {
            drawable.invalidateSelf();
        }
    }

    private static boolean _mth02CA(int ai[], int i)
    {
        int k = ai.length;
        for (int j = 0; j < k; j++)
        {
            if (ai[j] == i)
            {
                return true;
            }
        }

        return false;
    }

    private static PorterDuffColorFilter _mth02CB(int i, android.graphics.PorterDuff.Mode mode)
    {
        PorterDuffColorFilter porterduffcolorfilter1 = (PorterDuffColorFilter)hK._mth02CA(Integer.valueOf((i + 31) * 31 + mode.hashCode()));
        PorterDuffColorFilter porterduffcolorfilter = porterduffcolorfilter1;
        if (porterduffcolorfilter1 == null)
        {
            porterduffcolorfilter = new PorterDuffColorFilter(i, mode);
            hK._mth02CA(Integer.valueOf((i + 31) * 31 + mode.hashCode()), porterduffcolorfilter);
        }
        return porterduffcolorfilter;
    }

    public static Drawable _mth02CB(Context context, int i)
    {
        boolean flag;
        if (_mth02CA(hM, i) || _mth02CA(hL, i) || _mth02CA(hN, i) || _mth02CA(hP, i) || _mth02CA(hO, i) || _mth02CA(hQ, i) || i == FE79.if.abc_cab_background_top_material)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return _mth1FBE(context)._mth02BD(i, false);
        } else
        {
            return _cls1D38._mth02CB(context, i);
        }
    }

    private static ColorStateList _mth02CC(Context context)
    {
        int ai[] = _cls0696.hA;
        int i = _cls0696._mth02BD(context, _cls1541.colorControlNormal);
        int ai1[] = _cls0696.hD;
        int j = _cls0696._mth02BB(context, _cls1541.colorControlNormal);
        int ai2[] = _cls0696.EMPTY_STATE_SET;
        int k = _cls0696._mth02BB(context, _cls1541.colorControlActivated);
        return new ColorStateList(new int[][] {
            ai, ai1, ai2
        }, new int[] {
            i, j, k
        });
    }

    private static ColorStateList _mth02CD(Context context)
    {
        int ai[] = _cls0696.hA;
        int i = _cls0696._mth02BD(context, _cls1541.colorControlNormal);
        int ai1[] = _cls0696.hD;
        int j = _cls0696._mth02BB(context, _cls1541.colorControlNormal);
        int ai2[] = _cls0696.EMPTY_STATE_SET;
        int k = _cls0696._mth02BB(context, _cls1541.colorControlActivated);
        return new ColorStateList(new int[][] {
            ai, ai1, ai2
        }, new int[] {
            i, j, k
        });
    }

    private static ColorStateList _mth02D1(Context context)
    {
        int ai[] = _cls0696.hA;
        int i = _cls0696._mth02BD(context, _cls1541.colorControlActivated);
        int ai1[] = _cls0696.EMPTY_STATE_SET;
        int j = _cls0696._mth02BB(context, _cls1541.colorControlActivated);
        return new ColorStateList(new int[][] {
            ai, ai1
        }, new int[] {
            i, j
        });
    }

    private static ColorStateList _mth037A(Context context, int i)
    {
        i = _cls0696._mth02BB(context, i);
        int l = _cls0696._mth02BB(context, _cls1541.colorControlHighlight);
        int ai[] = _cls0696.hA;
        int j = _cls0696._mth02BD(context, _cls1541.colorButtonNormal);
        context = _cls0696.PRESSED_STATE_SET;
        int k = _cls141D.if._mth02CA(l, i);
        int ai1[] = _cls0696.FOCUSED_STATE_SET;
        l = _cls141D.if._mth02CA(l, i);
        return new ColorStateList(new int[][] {
            ai, context, ai1, _cls0696.EMPTY_STATE_SET
        }, new int[] {
            j, k, l, i
        });
    }

    private static boolean _mth037A(Drawable drawable)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            return true;
        }
        if (drawable instanceof LayerDrawable)
        {
            return android.os.Build.VERSION.SDK_INT >= 16;
        }
        if (drawable instanceof InsetDrawable)
        {
            return android.os.Build.VERSION.SDK_INT >= 14;
        }
        if (drawable instanceof DrawableContainer)
        {
            drawable = drawable.getConstantState();
            if (drawable instanceof android.graphics.drawable.DrawableContainer.DrawableContainerState)
            {
                drawable = ((android.graphics.drawable.DrawableContainer.DrawableContainerState)drawable).getChildren();
                int j = drawable.length;
                for (int i = 0; i < j; i++)
                {
                    if (!_mth037A(drawable[i]))
                    {
                        return false;
                    }
                }

            }
        }
        return true;
    }

    public static _cls0715 _mth1FBE(Context context)
    {
        _cls0715 _lcls0715_1 = (_cls0715)hJ.get(context);
        _cls0715 _lcls0715 = _lcls0715_1;
        if (_lcls0715_1 == null)
        {
            _lcls0715 = new _cls0715(context);
            hJ.put(context, _lcls0715);
        }
        return _lcls0715;
    }

    public final Drawable _mth02BD(int i, boolean flag)
    {
        Context context = (Context)hR.get();
        if (context == null)
        {
            return null;
        }
        Object obj2 = _cls1D38._mth02CB(context, i);
        Object obj1 = obj2;
        if (obj2 != null)
        {
            Object obj = obj2;
            if (android.os.Build.VERSION.SDK_INT >= 8)
            {
                obj = ((Drawable) (obj2)).mutate();
            }
            obj2 = _mth1D57(i);
            if (obj2 != null)
            {
                obj1 = _cls02D0._mth02CF(((Drawable) (obj)));
                _cls02D0._mth02CA(((Drawable) (obj1)), ((ColorStateList) (obj2)));
                obj = null;
                if (i == FE79.if.abc_switch_thumb_material)
                {
                    obj = android.graphics.PorterDuff.Mode.MULTIPLY;
                }
                if (obj != null)
                {
                    _cls02D0._mth02CA(((Drawable) (obj1)), ((android.graphics.PorterDuff.Mode) (obj)));
                }
                return ((Drawable) (obj1));
            }
            if (i == FE79.if.abc_cab_background_top_material)
            {
                return new LayerDrawable(new Drawable[] {
                    _mth02BD(FE79.if.abc_cab_background_internal_bg, false), _mth02BD(FE79.if.abc_cab_background_top_mtrl_alpha, false)
                });
            }
            if (i == FE79.if.FB87)
            {
                Object obj3 = (LayerDrawable)obj;
                Drawable drawable = ((LayerDrawable) (obj3)).findDrawableByLayerId(0x1020000);
                i = _cls0696._mth02BB(context, _cls1541.colorControlNormal);
                obj1 = _fld026A;
                if (obj1 == null)
                {
                    obj1 = _fld026A;
                }
                drawable.setColorFilter(_mth02CB(i, ((android.graphics.PorterDuff.Mode) (obj1))));
                drawable = ((LayerDrawable) (obj3)).findDrawableByLayerId(0x102000f);
                i = _cls0696._mth02BB(context, _cls1541.colorControlNormal);
                obj1 = _fld026A;
                if (obj1 == null)
                {
                    obj1 = _fld026A;
                }
                drawable.setColorFilter(_mth02CB(i, ((android.graphics.PorterDuff.Mode) (obj1))));
                obj3 = ((LayerDrawable) (obj3)).findDrawableByLayerId(0x102000d);
                i = _cls0696._mth02BB(context, _cls1541.colorControlActivated);
                obj1 = _fld026A;
                if (obj1 == null)
                {
                    obj1 = _fld026A;
                }
                ((Drawable) (obj3)).setColorFilter(_mth02CB(i, ((android.graphics.PorterDuff.Mode) (obj1))));
                return ((Drawable) (obj));
            }
            obj1 = obj;
            if (!_mth02CA(i, ((Drawable) (obj))))
            {
                obj1 = obj;
                if (flag)
                {
                    obj1 = null;
                }
            }
        }
        return ((Drawable) (obj1));
    }

    public final boolean _mth02CA(int i, Drawable drawable)
    {
        Context context = (Context)hR.get();
        if (context == null)
        {
            return false;
        }
        android.graphics.PorterDuff.Mode mode1 = _fld026A;
        boolean flag = false;
        int j = 0;
        int k = -1;
        android.graphics.PorterDuff.Mode mode;
        if (_mth02CA(hL, i))
        {
            j = _cls1541.colorControlNormal;
            flag = true;
            mode = mode1;
        } else
        if (_mth02CA(hN, i))
        {
            j = _cls1541.colorControlActivated;
            flag = true;
            mode = mode1;
        } else
        if (_mth02CA(hO, i))
        {
            j = 0x1010031;
            flag = true;
            mode = android.graphics.PorterDuff.Mode.MULTIPLY;
        } else
        {
            mode = mode1;
            if (i == FE79.if.abc_list_divider_mtrl_alpha)
            {
                j = 0x1010030;
                flag = true;
                k = Math.round(40.8F);
                mode = mode1;
            }
        }
        if (flag)
        {
            drawable.setColorFilter(_mth02CB(_cls0696._mth02BB(context, j), mode));
            if (k != -1)
            {
                drawable.setAlpha(k);
            }
            return true;
        } else
        {
            return false;
        }
    }

    public final ColorStateList _mth1D57(int i)
    {
        Context context = (Context)hR.get();
        if (context == null)
        {
            return null;
        }
        ColorStateList colorstatelist;
        if (hS != null)
        {
            colorstatelist = (ColorStateList)hS.get(i);
        } else
        {
            colorstatelist = null;
        }
        ColorStateList colorstatelist1 = colorstatelist;
        if (colorstatelist == null)
        {
            if (i == FE79.if.abc_edit_text_material)
            {
                colorstatelist = _mth02CC(context);
            } else
            if (i == FE79.if.abc_switch_track_mtrl_alpha)
            {
                colorstatelist = _mth02C8(context);
            } else
            if (i == FE79.if.abc_switch_thumb_material)
            {
                colorstatelist = _mth02C9(context);
            } else
            if (i == FE79.if._fld4E3F || i == FE79.if._fld2110)
            {
                colorstatelist = _mth037A(context, _cls1541.colorButtonNormal);
            } else
            if (i == FE79.if._fld3031)
            {
                colorstatelist = _mth037A(context, _cls1541.colorAccent);
            } else
            if (i == FE79.if.abc_spinner_mtrl_am_alpha || i == FE79.if.FB8A)
            {
                colorstatelist = _mth02CD(context);
            } else
            if (_mth02CA(hM, i))
            {
                colorstatelist = _cls0696._mth02BC(context, _cls1541.colorControlNormal);
            } else
            if (_mth02CA(hP, i))
            {
                colorstatelist = _mth02BE(context);
            } else
            if (_mth02CA(hQ, i))
            {
                colorstatelist = _mth02BF(context);
            } else
            if (i == FE79.if.FB69)
            {
                colorstatelist = _mth02D1(context);
            }
            colorstatelist1 = colorstatelist;
            if (colorstatelist != null)
            {
                if (hS == null)
                {
                    hS = new SparseArray();
                }
                hS.append(i, colorstatelist);
                colorstatelist1 = colorstatelist;
            }
        }
        return colorstatelist1;
    }

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT < 21)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hI = flag;
        _fld026A = android.graphics.PorterDuff.Mode.SRC_IN;
        hL = (new int[] {
            FE79.if.abc_textfield_search_default_mtrl_alpha, FE79.if.abc_textfield_default_mtrl_alpha, FE79.if._fld1FD6
        });
        hM = (new int[] {
            FE79.if.abc_ic_ab_back_mtrl_am_alpha, FE79.if.abc_ic_go_search_api_mtrl_alpha, FE79.if.abc_ic_search_api_mtrl_alpha, FE79.if.abc_ic_commit_search_api_mtrl_alpha, FE79.if.abc_ic_clear_mtrl_alpha, FE79.if.abc_ic_menu_share_mtrl_alpha, FE79.if.abc_ic_menu_copy_mtrl_am_alpha, FE79.if.abc_ic_menu_cut_mtrl_alpha, FE79.if.abc_ic_menu_selectall_mtrl_alpha, FE79.if.abc_ic_menu_paste_mtrl_am_alpha, 
            FE79.if.abc_ic_menu_moreoverflow_mtrl_alpha, FE79.if.abc_ic_voice_search_api_mtrl_alpha
        });
        hN = (new int[] {
            FE79.if.abc_textfield_activated_mtrl_alpha, FE79.if.abc_textfield_search_activated_mtrl_alpha, FE79.if.abc_cab_background_top_mtrl_alpha, FE79.if.FB9E
        });
        hO = (new int[] {
            FE79.if.abc_popup_background_mtrl_mult, FE79.if.abc_cab_background_internal_bg, FE79.if.abc_menu_hardkey_panel_mtrl_mult
        });
        hP = (new int[] {
            FE79.if.abc_edit_text_material, FE79.if.abc_tab_indicator_material, FE79.if.abc_textfield_search_material, FE79.if.abc_spinner_mtrl_am_alpha, FE79.if.FB8A, FE79.if.FB31, FE79.if.abc_switch_track_mtrl_alpha, FE79.if.abc_switch_thumb_material, FE79.if._fld4E3F, FE79.if._fld2110
        });
        hQ = (new int[] {
            FE79.if.abc_btn_check_material, FE79.if.abc_btn_radio_material
        });
    }
}
