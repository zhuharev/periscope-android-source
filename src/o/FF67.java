// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.InputStream;

class FF67 extends Resources
{

    private final Resources _fld13AB;

    public FF67(Resources resources)
    {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        _fld13AB = resources;
    }

    public XmlResourceParser getAnimation(int i)
    {
        return _fld13AB.getAnimation(i);
    }

    public boolean getBoolean(int i)
    {
        return _fld13AB.getBoolean(i);
    }

    public int getColor(int i)
    {
        return _fld13AB.getColor(i);
    }

    public ColorStateList getColorStateList(int i)
    {
        return _fld13AB.getColorStateList(i);
    }

    public Configuration getConfiguration()
    {
        return _fld13AB.getConfiguration();
    }

    public float getDimension(int i)
    {
        return _fld13AB.getDimension(i);
    }

    public int getDimensionPixelOffset(int i)
    {
        return _fld13AB.getDimensionPixelOffset(i);
    }

    public int getDimensionPixelSize(int i)
    {
        return _fld13AB.getDimensionPixelSize(i);
    }

    public DisplayMetrics getDisplayMetrics()
    {
        return _fld13AB.getDisplayMetrics();
    }

    public Drawable getDrawable(int i)
    {
        return _fld13AB.getDrawable(i);
    }

    public Drawable getDrawable(int i, android.content.res.Resources.Theme theme)
    {
        return _fld13AB.getDrawable(i, theme);
    }

    public Drawable getDrawableForDensity(int i, int j)
    {
        return _fld13AB.getDrawableForDensity(i, j);
    }

    public Drawable getDrawableForDensity(int i, int j, android.content.res.Resources.Theme theme)
    {
        return _fld13AB.getDrawableForDensity(i, j, theme);
    }

    public float getFraction(int i, int j, int k)
    {
        return _fld13AB.getFraction(i, j, k);
    }

    public int getIdentifier(String s, String s1, String s2)
    {
        return _fld13AB.getIdentifier(s, s1, s2);
    }

    public int[] getIntArray(int i)
    {
        return _fld13AB.getIntArray(i);
    }

    public int getInteger(int i)
    {
        return _fld13AB.getInteger(i);
    }

    public XmlResourceParser getLayout(int i)
    {
        return _fld13AB.getLayout(i);
    }

    public Movie getMovie(int i)
    {
        return _fld13AB.getMovie(i);
    }

    public String getQuantityString(int i, int j)
    {
        return _fld13AB.getQuantityString(i, j);
    }

    public transient String getQuantityString(int i, int j, Object aobj[])
    {
        return _fld13AB.getQuantityString(i, j, aobj);
    }

    public CharSequence getQuantityText(int i, int j)
    {
        return _fld13AB.getQuantityText(i, j);
    }

    public String getResourceEntryName(int i)
    {
        return _fld13AB.getResourceEntryName(i);
    }

    public String getResourceName(int i)
    {
        return _fld13AB.getResourceName(i);
    }

    public String getResourcePackageName(int i)
    {
        return _fld13AB.getResourcePackageName(i);
    }

    public String getResourceTypeName(int i)
    {
        return _fld13AB.getResourceTypeName(i);
    }

    public String getString(int i)
    {
        return _fld13AB.getString(i);
    }

    public transient String getString(int i, Object aobj[])
    {
        return _fld13AB.getString(i, aobj);
    }

    public String[] getStringArray(int i)
    {
        return _fld13AB.getStringArray(i);
    }

    public CharSequence getText(int i)
    {
        return _fld13AB.getText(i);
    }

    public CharSequence getText(int i, CharSequence charsequence)
    {
        return _fld13AB.getText(i, charsequence);
    }

    public CharSequence[] getTextArray(int i)
    {
        return _fld13AB.getTextArray(i);
    }

    public void getValue(int i, TypedValue typedvalue, boolean flag)
    {
        _fld13AB.getValue(i, typedvalue, flag);
    }

    public void getValue(String s, TypedValue typedvalue, boolean flag)
    {
        _fld13AB.getValue(s, typedvalue, flag);
    }

    public void getValueForDensity(int i, int j, TypedValue typedvalue, boolean flag)
    {
        _fld13AB.getValueForDensity(i, j, typedvalue, flag);
    }

    public XmlResourceParser getXml(int i)
    {
        return _fld13AB.getXml(i);
    }

    public TypedArray obtainAttributes(AttributeSet attributeset, int ai[])
    {
        return _fld13AB.obtainAttributes(attributeset, ai);
    }

    public TypedArray obtainTypedArray(int i)
    {
        return _fld13AB.obtainTypedArray(i);
    }

    public InputStream openRawResource(int i)
    {
        return _fld13AB.openRawResource(i);
    }

    public InputStream openRawResource(int i, TypedValue typedvalue)
    {
        return _fld13AB.openRawResource(i, typedvalue);
    }

    public AssetFileDescriptor openRawResourceFd(int i)
    {
        return _fld13AB.openRawResourceFd(i);
    }

    public void parseBundleExtra(String s, AttributeSet attributeset, Bundle bundle)
    {
        _fld13AB.parseBundleExtra(s, attributeset, bundle);
    }

    public void parseBundleExtras(XmlResourceParser xmlresourceparser, Bundle bundle)
    {
        _fld13AB.parseBundleExtras(xmlresourceparser, bundle);
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displaymetrics)
    {
        super.updateConfiguration(configuration, displaymetrics);
        if (_fld13AB != null)
        {
            _fld13AB.updateConfiguration(configuration, displaymetrics);
        }
    }
}
