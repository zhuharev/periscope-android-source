// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.ComponentName;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package o:
//            _cls1D48

final class <init> extends AsyncTask
{

    private _cls1D48 FC5F;

    private transient Void _mth02CA(Object aobj[])
    {
        List list;
        Object obj1;
        list = (List)aobj[0];
        obj1 = (String)aobj[1];
        try
        {
            aobj = _cls1D48._mth02CA(FC5F).openFileOutput(((String) (obj1)), 0);
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            Log.e(_cls1D48._mth0279(), (new StringBuilder("Error writing historical recrod file: ")).append(((String) (obj1))).toString(), ((Throwable) (aobj)));
            return null;
        }
        obj1 = Xml.newSerializer();
        int j;
        ((XmlSerializer) (obj1)).setOutput(((java.io.OutputStream) (aobj)), null);
        ((XmlSerializer) (obj1)).startDocument("UTF-8", Boolean.valueOf(true));
        ((XmlSerializer) (obj1)).startTag(null, "historical-records");
        j = list.size();
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        ring ring = (st.size)list.remove(0);
        ((XmlSerializer) (obj1)).startTag(null, "historical-record");
        ((XmlSerializer) (obj1)).attribute(null, "activity", ring.FB90.flattenToString());
        ((XmlSerializer) (obj1)).attribute(null, "time", String.valueOf(ring.time));
        ((XmlSerializer) (obj1)).attribute(null, "weight", String.valueOf(ring.weight));
        ((XmlSerializer) (obj1)).endTag(null, "historical-record");
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        ((XmlSerializer) (obj1)).endTag(null, "historical-records");
        ((XmlSerializer) (obj1)).endDocument();
        _cls1D48._mth02CA(FC5F, true);
        Object obj;
        if (aobj != null)
        {
            try
            {
                ((FileOutputStream) (aobj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[]) { }
        }
        break MISSING_BLOCK_LABEL_425;
        obj;
        Log.e(_cls1D48._mth0279(), (new StringBuilder("Error writing historical recrod file: ")).append(_cls1D48._mth02CB(FC5F)).toString(), ((Throwable) (obj)));
        _cls1D48._mth02CA(FC5F, true);
        if (aobj != null)
        {
            try
            {
                ((FileOutputStream) (aobj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[]) { }
        }
        break MISSING_BLOCK_LABEL_425;
        obj;
        Log.e(_cls1D48._mth0279(), (new StringBuilder("Error writing historical recrod file: ")).append(_cls1D48._mth02CB(FC5F)).toString(), ((Throwable) (obj)));
        _cls1D48._mth02CA(FC5F, true);
        if (aobj != null)
        {
            try
            {
                ((FileOutputStream) (aobj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[]) { }
        }
        break MISSING_BLOCK_LABEL_425;
        obj;
        Log.e(_cls1D48._mth0279(), (new StringBuilder("Error writing historical recrod file: ")).append(_cls1D48._mth02CB(FC5F)).toString(), ((Throwable) (obj)));
        _cls1D48._mth02CA(FC5F, true);
        if (aobj != null)
        {
            try
            {
                ((FileOutputStream) (aobj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[]) { }
        }
        break MISSING_BLOCK_LABEL_425;
        obj;
        _cls1D48._mth02CA(FC5F, true);
        if (aobj != null)
        {
            try
            {
                ((FileOutputStream) (aobj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[]) { }
        }
        throw obj;
        return null;
    }

    public final Object doInBackground(Object aobj[])
    {
        return _mth02CA(aobj);
    }

    private ject(_cls1D48 _pcls1d48)
    {
        FC5F = _pcls1d48;
        super();
    }

    syncTask(_cls1D48 _pcls1d48, byte byte0)
    {
        this(_pcls1d48);
    }
}
