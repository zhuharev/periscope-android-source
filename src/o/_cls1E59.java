// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.Map;

// Referenced classes of package o:
//            _cls1422, _cls1FD1, FB59, FE70, 
//            _cls05E5, FF4A, FB5D, FE80, 
//            _cls0295, FEAA, FB65, _cls026D, 
//            FB86, FB27, FF6D, _cls027B, 
//            _cls028F

class _cls1E59
{
    /* member class not found */
    class if {}


    private static final Class _fld072C[] = {
        android/content/Context, android/util/AttributeSet
    };
    private static final int _fld0930[] = {
        0x101026f
    };
    private static final Map _fld098C = new _cls1422();
    private final Object _fld0997[] = new Object[2];

    _cls1E59()
    {
    }

    private static Context _mth02CA(Context context, AttributeSet attributeset, boolean flag, boolean flag1)
    {
label0:
        {
            attributeset = context.obtainStyledAttributes(attributeset, o._cls1FD1.View, 0, 0);
            int i = 0;
            if (flag)
            {
                i = attributeset.getResourceId(_cls1FD1.View_android_theme, 0);
            }
            int k = i;
            if (flag1)
            {
                k = i;
                if (i == 0)
                {
                    int l = attributeset.getResourceId(_cls1FD1.View_theme, 0);
                    int j = l;
                    k = j;
                    if (l != 0)
                    {
                        Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
                        k = j;
                    }
                }
            }
            attributeset.recycle();
            attributeset = context;
            if (k == 0)
            {
                break label0;
            }
            if (context instanceof FB59)
            {
                attributeset = context;
                if (((FB59)context).FF55 == k)
                {
                    break label0;
                }
            }
            attributeset = new FB59(context, k);
        }
        return attributeset;
    }

    private View _mth02CA(Context context, String s, AttributeSet attributeset)
    {
        String s1;
        s1 = s;
        if (s.equals("view"))
        {
            s1 = attributeset.getAttributeValue(null, "class");
        }
        _fld0997[0] = context;
        _fld0997[1] = attributeset;
        if (-1 != s1.indexOf('.'))
        {
            break MISSING_BLOCK_LABEL_74;
        }
        context = _mth02CA(context, s1, "android.widget.");
        _fld0997[0] = null;
        _fld0997[1] = null;
        return context;
        try
        {
            context = _mth02CA(context, s1, ((String) (null)));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            _fld0997[0] = null;
            _fld0997[1] = null;
            return null;
        }
        finally
        {
            _fld0997[0] = null;
        }
        _fld0997[0] = null;
        _fld0997[1] = null;
        return context;
        _fld0997[1] = null;
        throw context;
    }

    private View _mth02CA(Context context, String s, String s1)
    {
        Object obj;
        Constructor constructor;
        constructor = (Constructor)_fld098C.get(s);
        obj = constructor;
        if (constructor != null) goto _L2; else goto _L1
_L1:
        try
        {
            obj = context.getClassLoader();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        if (s1 == null) goto _L4; else goto _L3
_L3:
        context = (new StringBuilder()).append(s1).append(s).toString();
_L6:
        obj = ((ClassLoader) (obj)).loadClass(context).asSubclass(android/view/View).getConstructor(_fld072C);
        _fld098C.put(s, obj);
_L2:
        ((Constructor) (obj)).setAccessible(true);
        context = (View)((Constructor) (obj)).newInstance(_fld0997);
        return context;
_L4:
        context = s;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void _mth02CA(View view, AttributeSet attributeset)
    {
        Object obj = view.getContext();
        if (!FE70._mth1D62(view) || !(obj instanceof ContextWrapper))
        {
            return;
        }
        attributeset = ((Context) (obj)).obtainStyledAttributes(attributeset, _fld0930);
        obj = attributeset.getString(0);
        if (obj != null)
        {
            view.setOnClickListener(new if(view, ((String) (obj))));
        }
        attributeset.recycle();
    }

    public final View _mth02CA(View view, String s, Context context, AttributeSet attributeset, boolean flag, boolean flag1, boolean flag2)
    {
        Object obj;
label0:
        {
            obj = context;
            if (flag)
            {
                obj = context;
                if (view != null)
                {
                    obj = view.getContext();
                }
            }
            view = ((View) (obj));
            if (!flag1)
            {
                obj = view;
                if (!flag2)
                {
                    break label0;
                }
            }
            obj = _mth02CA(((Context) (view)), attributeset, flag1, flag2);
        }
        view = null;
        byte byte0 = -1;
        switch (s.hashCode())
        {
        case -938935918: 
            if (s.equals("TextView"))
            {
                byte0 = 0;
            }
            break;

        case 1125864064: 
            if (s.equals("ImageView"))
            {
                byte0 = 1;
            }
            break;

        case 2001146706: 
            if (s.equals("Button"))
            {
                byte0 = 2;
            }
            break;

        case 1666676343: 
            if (s.equals("EditText"))
            {
                byte0 = 3;
            }
            break;

        case -339785223: 
            if (s.equals("Spinner"))
            {
                byte0 = 4;
            }
            break;

        case -937446323: 
            if (s.equals("ImageButton"))
            {
                byte0 = 5;
            }
            break;

        case 1601505219: 
            if (s.equals("CheckBox"))
            {
                byte0 = 6;
            }
            break;

        case 776382189: 
            if (s.equals("RadioButton"))
            {
                byte0 = 7;
            }
            break;

        case -1455429095: 
            if (s.equals("CheckedTextView"))
            {
                byte0 = 8;
            }
            break;

        case 1413872058: 
            if (s.equals("AutoCompleteTextView"))
            {
                byte0 = 9;
            }
            break;

        case -1346021293: 
            if (s.equals("MultiAutoCompleteTextView"))
            {
                byte0 = 10;
            }
            break;

        case -1946472170: 
            if (s.equals("RatingBar"))
            {
                byte0 = 11;
            }
            break;

        case -658531749: 
            if (s.equals("SeekBar"))
            {
                byte0 = 12;
            }
            break;
        }
        switch (byte0)
        {
        case 0: // '\0'
            view = new _cls05E5(((Context) (obj)), attributeset);
            break;

        case 1: // '\001'
            view = new FF4A(((Context) (obj)), attributeset);
            break;

        case 2: // '\002'
            view = new FB5D(((Context) (obj)), attributeset);
            break;

        case 3: // '\003'
            view = new FE80(((Context) (obj)), attributeset);
            break;

        case 4: // '\004'
            view = new _cls0295(((Context) (obj)), attributeset);
            break;

        case 5: // '\005'
            view = new FEAA(((Context) (obj)), attributeset);
            break;

        case 6: // '\006'
            view = new FB65(((Context) (obj)), attributeset);
            break;

        case 7: // '\007'
            view = new _cls026D(((Context) (obj)), attributeset);
            break;

        case 8: // '\b'
            view = new FB86(((Context) (obj)), attributeset);
            break;

        case 9: // '\t'
            view = new FB27(((Context) (obj)), attributeset);
            break;

        case 10: // '\n'
            view = new FF6D(((Context) (obj)), attributeset);
            break;

        case 11: // '\013'
            view = new _cls027B(((Context) (obj)), attributeset);
            break;

        case 12: // '\f'
            view = new _cls028F(((Context) (obj)), attributeset);
            break;
        }
        View view1 = view;
        if (view == null)
        {
            view1 = view;
            if (context != obj)
            {
                view1 = _mth02CA(((Context) (obj)), s, attributeset);
            }
        }
        if (view1 != null)
        {
            _mth02CA(view1, attributeset);
        }
        return view1;
    }

}
