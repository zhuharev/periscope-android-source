// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class _cls1D48 extends DataSetObservable
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}


    private static final String LOG_TAG = o/1D48.getSimpleName();
    private final Context mContext;
    final Object FB41;
    final List FB43;
    final List FB56;
    final String FB74;
    private boolean FB78;
    boolean FB89;
    boolean FB8C;

    private void _mth0196()
    {
        FileInputStream fileinputstream;
        XmlPullParser xmlpullparser;
        List list;
        int i;
        try
        {
            fileinputstream = mContext.openFileInput(FB74);
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            return;
        }
        xmlpullparser = Xml.newPullParser();
        xmlpullparser.setInput(fileinputstream, "UTF-8");
        i = 0;
_L1:
        if (i == 1 || i == 2)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        i = xmlpullparser.next();
          goto _L1
        if (!"historical-records".equals(xmlpullparser.getName()))
        {
            throw new XmlPullParserException("Share records file does not start with historical-records tag.");
        }
        list = FB56;
        list.clear();
_L3:
        i = xmlpullparser.next();
        if (i == 1)
        {
            break MISSING_BLOCK_LABEL_189;
        }
        if (i == 3 || i == 4) goto _L3; else goto _L2
_L2:
        if (!"historical-record".equals(xmlpullparser.getName()))
        {
            throw new XmlPullParserException("Share records file not well-formed.");
        }
        list.add(new _cls02CA(xmlpullparser.getAttributeValue(null, "activity"), Long.parseLong(xmlpullparser.getAttributeValue(null, "time")), Float.parseFloat(xmlpullparser.getAttributeValue(null, "weight"))));
          goto _L3
        Object obj;
        if (fileinputstream != null)
        {
            try
            {
                fileinputstream.close();
                return;
            }
            catch (IOException ioexception)
            {
                return;
            }
        }
        break MISSING_BLOCK_LABEL_283;
        obj;
        Log.e(LOG_TAG, (new StringBuilder("Error reading historical recrod file: ")).append(FB74).toString(), ((Throwable) (obj)));
        if (fileinputstream != null)
        {
            try
            {
                fileinputstream.close();
                return;
            }
            catch (IOException ioexception1)
            {
                return;
            }
        }
        break MISSING_BLOCK_LABEL_283;
        obj;
        Log.e(LOG_TAG, (new StringBuilder("Error reading historical recrod file: ")).append(FB74).toString(), ((Throwable) (obj)));
        if (fileinputstream != null)
        {
            try
            {
                fileinputstream.close();
                return;
            }
            catch (IOException ioexception2)
            {
                return;
            }
        }
        break MISSING_BLOCK_LABEL_283;
        obj;
        if (fileinputstream != null)
        {
            try
            {
                fileinputstream.close();
            }
            catch (IOException ioexception3) { }
        }
        throw obj;
    }

    static String _mth0279()
    {
        return LOG_TAG;
    }

    static Context _mth02CA(_cls1D48 _pcls1d48)
    {
        return _pcls1d48.mContext;
    }

    static boolean _mth02CA(_cls1D48 _pcls1d48, boolean flag)
    {
        _pcls1d48.FB78 = true;
        return true;
    }

    static String _mth02CB(_cls1D48 _pcls1d48)
    {
        return _pcls1d48.FB74;
    }

    public final int getHistorySize()
    {
        Object obj = FB41;
        obj;
        JVM INSTR monitorenter ;
        boolean flag;
        flag = FF86();
        _mth0130();
        if (!(flag | false))
        {
            break MISSING_BLOCK_LABEL_28;
        }
        notifyChanged();
        int i = FB56.size();
        obj;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    void _mth0130()
    {
        int j = FB56.size();
        if (j <= 0)
        {
            return;
        }
        FB8C = true;
        for (int i = 0; i < j; i++)
        {
            FB56.remove(0);
        }

    }

    public final int _mth02CA(ResolveInfo resolveinfo)
    {
        Object obj = FB41;
        obj;
        JVM INSTR monitorenter ;
        boolean flag;
        flag = FF86();
        _mth0130();
        if (!(flag | false))
        {
            break MISSING_BLOCK_LABEL_28;
        }
        notifyChanged();
        List list;
        int j;
        list = FB43;
        j = list.size();
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        ResolveInfo resolveinfo1 = ((if)list.get(i)).resolveInfo;
        if (resolveinfo1 != resolveinfo)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        obj;
        JVM INSTR monitorexit ;
        return i;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return -1;
        resolveinfo;
        throw resolveinfo;
    }

    public final ResolveInfo _mth1420(int i)
    {
        Object obj = FB41;
        obj;
        JVM INSTR monitorenter ;
        boolean flag;
        flag = FF86();
        _mth0130();
        if (!(flag | false))
        {
            break MISSING_BLOCK_LABEL_28;
        }
        notifyChanged();
        ResolveInfo resolveinfo = ((if)FB43.get(i)).resolveInfo;
        obj;
        JVM INSTR monitorexit ;
        return resolveinfo;
        Exception exception;
        exception;
        throw exception;
    }

    public final int FEF3()
    {
        Object obj = FB41;
        obj;
        JVM INSTR monitorenter ;
        boolean flag;
        flag = FF86();
        _mth0130();
        if (!(flag | false))
        {
            break MISSING_BLOCK_LABEL_28;
        }
        notifyChanged();
        int i = FB43.size();
        obj;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final ResolveInfo FF3F()
    {
        Object obj = FB41;
        obj;
        JVM INSTR monitorenter ;
        boolean flag;
        flag = FF86();
        _mth0130();
        if (!(flag | false))
        {
            break MISSING_BLOCK_LABEL_26;
        }
        notifyChanged();
        ResolveInfo resolveinfo;
        if (FB43.isEmpty())
        {
            break MISSING_BLOCK_LABEL_59;
        }
        resolveinfo = ((if)FB43.get(0)).resolveInfo;
        return resolveinfo;
        obj;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L1:
        return null;
    }

    boolean FF86()
    {
        if (FB78 && FB8C && !TextUtils.isEmpty(FB74))
        {
            FB78 = false;
            FB89 = true;
            _mth0196();
            return true;
        } else
        {
            return false;
        }
    }

    static 
    {
        new HashMap();
    }
}
