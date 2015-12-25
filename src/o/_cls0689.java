// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

// Referenced classes of package o:
//            FB5C, _cls010B, _cls1D38, _cls0285, 
//            _cls1541

final class _cls0689 extends FB5C
    implements android.view.View.OnClickListener
{
    /* member class not found */
    class if {}


    private final SearchableInfo gO;
    private final WeakHashMap gU;
    private final _cls010B hh;
    private final SearchManager hi;
    private final Context hj;
    private final int hk;
    int hl;
    private ColorStateList hm;
    private int hn;
    private int ho;
    private int hp;
    private int hq;
    private int hr;
    private int hs;
    private boolean mClosed;

    public _cls0689(Context context, _cls010B _pcls010b, SearchableInfo searchableinfo, WeakHashMap weakhashmap)
    {
        super(context, _pcls010b.gr, null, true);
        mClosed = false;
        hl = 1;
        hn = -1;
        ho = -1;
        hp = -1;
        hq = -1;
        hr = -1;
        hs = -1;
        hi = (SearchManager)mContext.getSystemService("search");
        hh = _pcls010b;
        gO = searchableinfo;
        hk = _pcls010b.gs;
        hj = context;
        gU = weakhashmap;
    }

    private Drawable getActivityIcon(ComponentName componentname)
    {
        Object obj = mContext.getPackageManager();
        ActivityInfo activityinfo;
        try
        {
            activityinfo = ((PackageManager) (obj)).getActivityInfo(componentname, 128);
        }
        // Misplaced declaration of an exception variable
        catch (ComponentName componentname)
        {
            Log.w("SuggestionsAdapter", componentname.toString());
            return null;
        }
        int i = activityinfo.getIconResource();
        if (i == 0)
        {
            return null;
        }
        obj = ((PackageManager) (obj)).getDrawable(componentname.getPackageName(), i, activityinfo.applicationInfo);
        if (obj == null)
        {
            Log.w("SuggestionsAdapter", (new StringBuilder("Invalid icon resource ")).append(i).append(" for ").append(componentname.flattenToShortString()).toString());
            return null;
        } else
        {
            return ((Drawable) (obj));
        }
    }

    private Drawable _mth02BE(String s)
    {
        if (s == null || s.length() == 0 || "0".equals(s))
        {
            return null;
        }
        Object obj;
        String s1;
        int i;
        try
        {
            i = Integer.parseInt(s);
            s1 = (new StringBuilder("android.resource://")).append(hj.getPackageName()).append("/").append(i).toString();
            obj = (android.graphics.drawable.Drawable.ConstantState)gU.get(s1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            obj = (android.graphics.drawable.Drawable.ConstantState)gU.get(s);
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = ((android.graphics.drawable.Drawable.ConstantState) (obj)).newDrawable();
            }
            if (obj != null)
            {
                return ((Drawable) (obj));
            }
            obj = _mth02CB(Uri.parse(s));
            if (obj != null)
            {
                gU.put(s, ((Drawable) (obj)).getConstantState());
            }
            return ((Drawable) (obj));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            Log.w("SuggestionsAdapter", (new StringBuilder("Icon resource not found: ")).append(s).toString());
            return null;
        }
        if (obj == null)
        {
            obj = null;
            break MISSING_BLOCK_LABEL_87;
        }
        obj = ((android.graphics.drawable.Drawable.ConstantState) (obj)).newDrawable();
        if (obj != null)
        {
            return ((Drawable) (obj));
        }
        obj = _cls1D38._mth02CB(hj, i);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        gU.put(s1, ((Drawable) (obj)).getConstantState());
        Object obj1;
        return ((Drawable) (obj));
    }

    private static String _mth02CA(Cursor cursor, int i)
    {
        if (i == -1)
        {
            return null;
        }
        try
        {
            cursor = cursor.getString(i);
        }
        // Misplaced declaration of an exception variable
        catch (Cursor cursor)
        {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", cursor);
            return null;
        }
        return cursor;
    }

    public static String _mth02CA(Cursor cursor, String s)
    {
        return _mth02CA(cursor, cursor.getColumnIndex(s));
    }

    private static void _mth02CA(ImageView imageview, Drawable drawable, int i)
    {
        imageview.setImageDrawable(drawable);
        if (drawable == null)
        {
            imageview.setVisibility(i);
            return;
        } else
        {
            imageview.setVisibility(0);
            drawable.setVisible(false, false);
            drawable.setVisible(true, false);
            return;
        }
    }

    private Drawable _mth02CB(Uri uri)
    {
        boolean flag = "android.resource".equals(uri.getScheme());
        if (!flag) goto _L2; else goto _L1
_L1:
        Object obj = _mth02CE(uri);
        return ((Drawable) (obj));
_L4:
        throw new FileNotFoundException((new StringBuilder("Resource does not exist: ")).append(uri).toString());
_L2:
        obj = hj.getContentResolver().openInputStream(uri);
        if (obj == null)
        {
            IOException ioexception;
            Drawable drawable;
            Exception exception;
            try
            {
                throw new FileNotFoundException((new StringBuilder("Failed to open ")).append(uri).toString());
            }
            catch (FileNotFoundException filenotfoundexception)
            {
                Log.w("SuggestionsAdapter", (new StringBuilder("Icon not found: ")).append(uri).append(", ").append(filenotfoundexception.getMessage()).toString());
            }
            break MISSING_BLOCK_LABEL_202;
        }
        drawable = Drawable.createFromStream(((InputStream) (obj)), null);
        ((InputStream) (obj)).close();
        return drawable;
        obj;
        Log.e("SuggestionsAdapter", (new StringBuilder("Error closing icon stream for ")).append(uri).toString(), ((Throwable) (obj)));
        return drawable;
        exception;
        ((InputStream) (obj)).close();
        break MISSING_BLOCK_LABEL_163;
        ioexception;
        Log.e("SuggestionsAdapter", (new StringBuilder("Error closing icon stream for ")).append(uri).toString(), ioexception);
        throw exception;
        return null;
        android.content.res.Resources.NotFoundException notfoundexception;
        notfoundexception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private Drawable _mth02CE(Uri uri)
    {
        Object obj;
        String s = uri.getAuthority();
        if (TextUtils.isEmpty(s))
        {
            throw new FileNotFoundException((new StringBuilder("No authority: ")).append(uri).toString());
        }
        Resources resources;
        try
        {
            resources = mContext.getPackageManager().getResourcesForApplication(s);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new FileNotFoundException((new StringBuilder("No package found for authority: ")).append(uri).toString());
        }
        List list = uri.getPathSegments();
        if (list == null)
        {
            throw new FileNotFoundException((new StringBuilder("No path: ")).append(uri).toString());
        }
        int i = list.size();
        if (i == 1)
        {
            try
            {
                i = Integer.parseInt((String)list.get(0));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new FileNotFoundException((new StringBuilder("Single path segment is not a resource ID: ")).append(uri).toString());
            }
        } else
        if (i == 2)
        {
            i = resources.getIdentifier((String)list.get(1), (String)list.get(0), s);
        } else
        {
            throw new FileNotFoundException((new StringBuilder("More than two path segments: ")).append(uri).toString());
        }
        if (i == 0)
        {
            throw new FileNotFoundException((new StringBuilder("No resource found for: ")).append(uri).toString());
        } else
        {
            return resources.getDrawable(i);
        }
    }

    public final void changeCursor(Cursor cursor)
    {
        try
        {
            super.changeCursor(cursor);
        }
        // Misplaced declaration of an exception variable
        catch (Cursor cursor)
        {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", cursor);
            return;
        }
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        hn = cursor.getColumnIndex("suggest_text_1");
        ho = cursor.getColumnIndex("suggest_text_2");
        hp = cursor.getColumnIndex("suggest_text_2_url");
        hq = cursor.getColumnIndex("suggest_icon_1");
        hr = cursor.getColumnIndex("suggest_icon_2");
        hs = cursor.getColumnIndex("suggest_flags");
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        try
        {
            view = super.getView(i, view, viewgroup);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", view);
            viewgroup = newView(mContext, _fld03C2, viewgroup);
            if (viewgroup != null)
            {
                ((if)viewgroup.getTag()).ht.setText(view.toString());
            }
            return viewgroup;
        }
        return view;
    }

    public final boolean hasStableIds()
    {
        return false;
    }

    public final View newView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        context = super.newView(context, cursor, viewgroup);
        context.setTag(new if(context));
        ((ImageView)context.findViewById(_cls0285.edit_query)).setImageResource(hk);
        return context;
    }

    public final void notifyDataSetChanged()
    {
        super.notifyDataSetChanged();
        Object obj = getCursor();
        if (obj != null)
        {
            obj = ((Cursor) (obj)).getExtras();
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            ((Bundle) (obj)).getBoolean("in_progress");
        }
    }

    public final void notifyDataSetInvalidated()
    {
        super.notifyDataSetInvalidated();
        Object obj = getCursor();
        if (obj != null)
        {
            obj = ((Cursor) (obj)).getExtras();
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            ((Bundle) (obj)).getBoolean("in_progress");
        }
    }

    public final void onClick(View view)
    {
        view = ((View) (view.getTag()));
        if (view instanceof CharSequence)
        {
            hh._mth02BE((CharSequence)view);
        }
    }

    public final Cursor runQueryOnBackgroundThread(CharSequence charsequence)
    {
        if (charsequence == null)
        {
            charsequence = "";
        } else
        {
            charsequence = charsequence.toString();
        }
        if (hh.getVisibility() != 0 || hh.getWindowVisibility() != 0)
        {
            return null;
        }
        SearchableInfo searchableinfo = gO;
        if (searchableinfo == null)
        {
            charsequence = null;
            break MISSING_BLOCK_LABEL_192;
        }
        Object obj = searchableinfo.getSuggestAuthority();
        if (obj == null)
        {
            charsequence = null;
            break MISSING_BLOCK_LABEL_192;
        }
        String s;
        obj = (new android.net.Uri.Builder()).scheme("content").authority(((String) (obj))).query("").fragment("");
        s = searchableinfo.getSuggestPath();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        ((android.net.Uri.Builder) (obj)).appendEncodedPath(s);
        ((android.net.Uri.Builder) (obj)).appendPath("search_suggest_query");
        s = searchableinfo.getSuggestSelection();
        String as[];
        as = null;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        as = new String[1];
        as[0] = charsequence;
        charsequence = as;
        break MISSING_BLOCK_LABEL_159;
        ((android.net.Uri.Builder) (obj)).appendPath(charsequence);
        charsequence = as;
        ((android.net.Uri.Builder) (obj)).appendQueryParameter("limit", "50");
        Uri uri = ((android.net.Uri.Builder) (obj)).build();
        charsequence = mContext.getContentResolver().query(uri, null, s, charsequence, null);
        if (charsequence == null)
        {
            break MISSING_BLOCK_LABEL_219;
        }
        charsequence.getCount();
        return charsequence;
        charsequence;
        Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", charsequence);
        return null;
    }

    public final String _mth02CA(Cursor cursor)
    {
        if (cursor == null)
        {
            return null;
        }
        String s = _mth02CA(cursor, cursor.getColumnIndex("suggest_intent_query"));
        if (s != null)
        {
            return s;
        }
        if (gO.shouldRewriteQueryFromData())
        {
            String s1 = _mth02CA(cursor, cursor.getColumnIndex("suggest_intent_data"));
            if (s1 != null)
            {
                return s1;
            }
        }
        if (gO.shouldRewriteQueryFromText())
        {
            cursor = _mth02CA(cursor, cursor.getColumnIndex("suggest_text_1"));
            if (cursor != null)
            {
                return cursor;
            }
        }
        return null;
    }

    public final void _mth02CA(View view, Cursor cursor)
    {
        if if1 = (if)view.getTag();
        int i = 0;
        if (hs != -1)
        {
            i = cursor.getInt(hs);
        }
        if (if1.ht != null)
        {
            view = _mth02CA(cursor, hn);
            TextView textview = if1.ht;
            textview.setText(view);
            if (TextUtils.isEmpty(view))
            {
                textview.setVisibility(8);
            } else
            {
                textview.setVisibility(0);
            }
        }
        if (if1.hu != null)
        {
            Object obj = _mth02CA(cursor, hp);
            if (obj != null)
            {
                if (hm == null)
                {
                    view = new TypedValue();
                    mContext.getTheme().resolveAttribute(_cls1541.textColorSearchUrl, view, true);
                    hm = mContext.getResources().getColorStateList(((TypedValue) (view)).resourceId);
                }
                view = new SpannableString(((CharSequence) (obj)));
                view.setSpan(new TextAppearanceSpan(null, 0, 0, hm, null), 0, ((CharSequence) (obj)).length(), 33);
            } else
            {
                view = _mth02CA(cursor, ho);
            }
            if (TextUtils.isEmpty(view))
            {
                if (if1.ht != null)
                {
                    if1.ht.setSingleLine(false);
                    if1.ht.setMaxLines(2);
                }
            } else
            if (if1.ht != null)
            {
                if1.ht.setSingleLine(true);
                if1.ht.setMaxLines(1);
            }
            obj = if1.hu;
            ((TextView) (obj)).setText(view);
            if (TextUtils.isEmpty(view))
            {
                ((TextView) (obj)).setVisibility(8);
            } else
            {
                ((TextView) (obj)).setVisibility(0);
            }
        }
        if (if1.hv != null)
        {
            ImageView imageview1 = if1.hv;
            if (hq == -1)
            {
                view = null;
            } else
            {
                view = _mth02BE(cursor.getString(hq));
                if (view == null)
                {
                    view = gO.getSearchActivity();
                    String s = view.flattenToShortString();
                    if (gU.containsKey(s))
                    {
                        view = (android.graphics.drawable.Drawable.ConstantState)gU.get(s);
                        if (view == null)
                        {
                            view = null;
                        } else
                        {
                            view = view.newDrawable(hj.getResources());
                        }
                    } else
                    {
                        Drawable drawable = getActivityIcon(view);
                        if (drawable == null)
                        {
                            view = null;
                        } else
                        {
                            view = drawable.getConstantState();
                        }
                        gU.put(s, view);
                        view = drawable;
                    }
                    if (view == null)
                    {
                        view = mContext.getPackageManager().getDefaultActivityIcon();
                    }
                }
            }
            _mth02CA(imageview1, ((Drawable) (view)), 4);
        }
        if (if1.hw != null)
        {
            ImageView imageview = if1.hw;
            if (hr == -1)
            {
                view = null;
            } else
            {
                view = _mth02BE(cursor.getString(hr));
            }
            _mth02CA(imageview, ((Drawable) (view)), 8);
        }
        if (hl == 2 || hl == 1 && (i & 1) != 0)
        {
            if1.hx.setVisibility(0);
            if1.hx.setTag(if1.ht.getText());
            if1.hx.setOnClickListener(this);
            return;
        } else
        {
            if1.hx.setVisibility(8);
            return;
        }
    }
}
