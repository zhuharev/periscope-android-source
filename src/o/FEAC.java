// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package o:
//            pr, _cls0690, ph

public class FEAC
    implements FB1F.if
{

    private RecyclerView ex;

    FEAC()
    {
    }

    public FEAC(RecyclerView recyclerview)
    {
        ex = recyclerview;
        super();
    }

    private void _mth02BC(FB1F._cls02CA _pcls02ca)
    {
        switch (_pcls02ca.FE7A)
        {
        default:
            return;

        case 0: // '\0'
            RecyclerView._mth02CF(ex);
            return;

        case 1: // '\001'
            RecyclerView._mth02CF(ex);
            return;

        case 2: // '\002'
            RecyclerView._mth02CF(ex);
            return;

        case 3: // '\003'
            RecyclerView._mth02CF(ex);
            break;
        }
    }

    public static File _mth02CA(Context context, ContentResolver contentresolver, Uri uri)
    {
        if (uri == null)
        {
            return null;
        }
        ContentResolver contentresolver2 = null;
        ContentResolver contentresolver1 = null;
        Object obj = null;
        byte abyte0[] = null;
        Context context1 = abyte0;
        Context context2 = obj;
        int i;
        try
        {
            contentresolver = new FileInputStream(contentresolver.openFileDescriptor(uri, "r").getFileDescriptor());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            if (contentresolver2 != null)
            {
                try
                {
                    contentresolver2.close();
                }
                // Misplaced declaration of an exception variable
                catch (Context context) { }
            }
            if (context2 != null)
            {
                try
                {
                    context2.close();
                }
                // Misplaced declaration of an exception variable
                catch (Context context) { }
            }
            break MISSING_BLOCK_LABEL_256;
        }
        finally
        {
            if (contentresolver1 != null)
            {
                try
                {
                    contentresolver1.close();
                }
                // Misplaced declaration of an exception variable
                catch (ContentResolver contentresolver) { }
            }
            if (context1 != null)
            {
                try
                {
                    context1.close();
                }
                // Misplaced declaration of an exception variable
                catch (ContentResolver contentresolver) { }
            }
            throw context;
        }
        contentresolver1 = contentresolver;
        context1 = abyte0;
        contentresolver2 = contentresolver;
        context2 = obj;
        uri = File.createTempFile("image", "tmp", context.getCacheDir()).getAbsolutePath();
        contentresolver1 = contentresolver;
        context1 = abyte0;
        contentresolver2 = contentresolver;
        context2 = obj;
        context = new FileOutputStream(uri);
        contentresolver1 = contentresolver;
        context1 = context;
        contentresolver2 = contentresolver;
        context2 = context;
        abyte0 = new byte[4096];
_L2:
        contentresolver1 = contentresolver;
        context1 = context;
        contentresolver2 = contentresolver;
        context2 = context;
        i = contentresolver.read(abyte0);
        if (i == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        contentresolver1 = contentresolver;
        context1 = context;
        contentresolver2 = contentresolver;
        context2 = context;
        context.write(abyte0, 0, i);
        if (true) goto _L2; else goto _L1
_L1:
        contentresolver1 = contentresolver;
        context1 = context;
        contentresolver2 = contentresolver;
        context2 = context;
        uri = new File(uri);
        if (contentresolver != null)
        {
            try
            {
                contentresolver.close();
            }
            // Misplaced declaration of an exception variable
            catch (ContentResolver contentresolver) { }
        }
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return uri;
            }
        }
        return uri;
        return null;
    }

    public static File _mth02CA(ph ph, ContentResolver contentresolver, Uri uri)
    {
        if (uri == null)
        {
            return null;
        }
        if ("file".equals(uri.getScheme()))
        {
            return new File(uri.getPath());
        }
        if (!"content".equals(uri.getScheme())) goto _L2; else goto _L1
_L1:
        Cursor cursor1;
        Cursor cursor2;
        Cursor cursor3;
        cursor2 = null;
        cursor3 = null;
        cursor1 = null;
        Object obj = contentresolver.query(uri, new String[] {
            "_data", "_display_name"
        }, null, null, null);
        Cursor cursor;
        cursor = ((Cursor) (obj));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_238;
        }
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_238;
        }
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        if (!uri.toString().startsWith("content://com.google.android.gallery3d"))
        {
            break MISSING_BLOCK_LABEL_144;
        }
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        int i;
        i = cursor.getColumnIndex("_display_name");
        break MISSING_BLOCK_LABEL_163;
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        i = cursor.getColumnIndex("_data");
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_238;
        }
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        obj = cursor.getString(i);
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            break MISSING_BLOCK_LABEL_238;
        }
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        obj = new File(((String) (obj)));
        if (cursor != null)
        {
            cursor.close();
        }
        return ((File) (obj));
        if (cursor != null)
        {
            cursor.close();
        }
          goto _L2
_L3:
        cursor1 = cursor2;
        ph = _mth02CA(((Context) (ph)), contentresolver, uri);
        if (cursor2 != null)
        {
            cursor2.close();
        }
        return ph;
_L4:
        if (cursor3 != null)
        {
            cursor3.close();
        }
          goto _L2
        ph;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        throw ph;
_L2:
        return null;
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
          goto _L3
        ph;
          goto _L4
    }

    public static void _mth02CA(ph ph, String s, String s1, Runnable runnable, Handler handler)
    {
        (new Thread(new pr(ph, runnable, ProgressDialog.show(ph, null, s1, true, false), handler))).start();
    }

    public static boolean _mth02CA(File file, File file1)
    {
        if (file == null || file1 == null)
        {
            return false;
        }
        try
        {
            file = new ExifInterface(file.getAbsolutePath());
            file1 = new ExifInterface(file1.getAbsolutePath());
            file1.setAttribute("Orientation", file.getAttribute("Orientation"));
            file1.saveAttributes();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            Log.e("android-crop", "Error copying Exif data", file);
            return false;
        }
        return true;
    }

    public static int _mth02CB(File file)
    {
        if (file == null)
        {
            return 0;
        }
        int i;
        try
        {
            i = (new ExifInterface(file.getAbsolutePath())).getAttributeInt("Orientation", 0);
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            Log.e("android-crop", "Error getting Exif data", file);
            return 0;
        }
        switch (i)
        {
        case 6: // '\006'
            return 90;

        case 3: // '\003'
            return 180;

        case 8: // '\b'
            return 270;
        }
        return 0;
    }

    public final void _mth02BB(FB1F._cls02CA _pcls02ca)
    {
        _mth02BC(_pcls02ca);
    }

    public final void _mth02C8(int i, int j)
    {
        ex._mth02CA(i, j, true);
        ex.em = true;
        android.support.v7.widget.RecyclerView.con con = ex.ek;
        con.fp = con.fp + j;
    }

    public final void _mth02C9(int i, int j)
    {
        ex._mth02CA(i, j, false);
        ex.em = true;
    }

    public final void _mth02CC(int i, int j)
    {
        Object obj = ex;
        int j1 = ((RecyclerView) (obj)).dC.aF.getChildCount();
        for (int k = 0; k < j1; k++)
        {
            View view = ((RecyclerView) (obj)).dC.aF.getChildAt(k);
            android.support.v7.widget.RecyclerView._cls02CC _lcls02cc1 = RecyclerView._mth1508(view);
            if (_lcls02cc1 == null)
            {
                continue;
            }
            boolean flag;
            if ((_lcls02cc1._fld0E20 & 0x80) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag || _lcls02cc1.bX < i || _lcls02cc1.bX >= i + j)
            {
                continue;
            }
            _lcls02cc1._fld0E20 = _lcls02cc1._fld0E20 | 2;
            if (((RecyclerView) (obj)).ea != null && ((RecyclerView) (obj)).ea.eG)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                _lcls02cc1._fld0E20 = _lcls02cc1._fld0E20 | 0x40;
            }
            ((android.support.v7.widget.RecyclerView._cls02BC)view.getLayoutParams()).eL = true;
        }

        obj = ((RecyclerView) (obj)).dz;
        int i1 = ((android.support.v7.widget.RecyclerView._cls1FBE) (obj)).eS.size();
        for (int l = 0; l < i1; l++)
        {
            android.support.v7.widget.RecyclerView._cls02CC _lcls02cc = (android.support.v7.widget.RecyclerView._cls02CC)((android.support.v7.widget.RecyclerView._cls1FBE) (obj)).eS.get(l);
            if (_lcls02cc == null)
            {
                continue;
            }
            int k1 = _lcls02cc.getLayoutPosition();
            if (k1 >= i && k1 < j + i)
            {
                _lcls02cc._fld0E20 = _lcls02cc._fld0E20 | 2;
            }
        }

        ex.en = true;
    }

    public final void _mth02CD(int i, int j)
    {
        RecyclerView recyclerview = ex;
        int j1 = recyclerview.dC.aF.getChildCount();
        for (int k = 0; k < j1; k++)
        {
            android.support.v7.widget.RecyclerView._cls02CC _lcls02cc = RecyclerView._mth1508(recyclerview.dC.aF.getChildAt(k));
            if (_lcls02cc == null)
            {
                continue;
            }
            boolean flag;
            if ((_lcls02cc._fld0E20 & 0x80) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag && _lcls02cc.bX >= i)
            {
                _lcls02cc._mth02BC(j, false);
                recyclerview.ek.fq = true;
            }
        }

        android.support.v7.widget.RecyclerView._cls1FBE _lcls1fbe = recyclerview.dz;
        int i1 = _lcls1fbe.eS.size();
        for (int l = 0; l < i1; l++)
        {
            android.support.v7.widget.RecyclerView._cls02CC _lcls02cc1 = (android.support.v7.widget.RecyclerView._cls02CC)_lcls1fbe.eS.get(l);
            if (_lcls02cc1 != null && _lcls02cc1.getLayoutPosition() >= i)
            {
                _lcls02cc1._mth02BC(j, true);
            }
        }

        recyclerview.requestLayout();
        ex.em = true;
    }

    public final void _mth02D1(int i, int j)
    {
        RecyclerView recyclerview = ex;
        int k1 = recyclerview.dC.aF.getChildCount();
        int k;
        int l;
        byte byte0;
        if (i < j)
        {
            k = i;
            l = j;
            byte0 = -1;
        } else
        {
            k = j;
            l = i;
            byte0 = 1;
        }
        for (int i1 = 0; i1 < k1; i1++)
        {
            android.support.v7.widget.RecyclerView._cls02CC _lcls02cc = RecyclerView._mth1508(recyclerview.dC.aF.getChildAt(i1));
            if (_lcls02cc == null || _lcls02cc.bX < k || _lcls02cc.bX > l)
            {
                continue;
            }
            if (_lcls02cc.bX == i)
            {
                _lcls02cc._mth02BC(j - i, false);
            } else
            {
                _lcls02cc._mth02BC(byte0, false);
            }
            recyclerview.ek.fq = true;
        }

        android.support.v7.widget.RecyclerView._cls1FBE _lcls1fbe = recyclerview.dz;
        if (i < j)
        {
            k = i;
            l = j;
            byte0 = -1;
        } else
        {
            k = j;
            l = i;
            byte0 = 1;
        }
        k1 = _lcls1fbe.eS.size();
        for (int j1 = 0; j1 < k1; j1++)
        {
            android.support.v7.widget.RecyclerView._cls02CC _lcls02cc1 = (android.support.v7.widget.RecyclerView._cls02CC)_lcls1fbe.eS.get(j1);
            if (_lcls02cc1 == null || _lcls02cc1.bX < k || _lcls02cc1.bX > l)
            {
                continue;
            }
            if (_lcls02cc1.bX == i)
            {
                _lcls02cc1._mth02BC(j - i, false);
            } else
            {
                _lcls02cc1._mth02BC(byte0, false);
            }
        }

        recyclerview.requestLayout();
        ex.em = true;
    }

    public final void _mth141D(FB1F._cls02CA _pcls02ca)
    {
        _mth02BC(_pcls02ca);
    }

    public final android.support.v7.widget.RecyclerView._cls02CC _mth1540(int i)
    {
        android.support.v7.widget.RecyclerView._cls02CC _lcls02cc;
label0:
        {
            RecyclerView recyclerview = ex;
            int k = recyclerview.dC.aF.getChildCount();
            for (int j = 0; j < k; j++)
            {
                _lcls02cc = RecyclerView._mth1508(recyclerview.dC.aF.getChildAt(j));
                if (_lcls02cc == null)
                {
                    continue;
                }
                boolean flag;
                if ((_lcls02cc._fld0E20 & 8) != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag && _lcls02cc.bX == i)
                {
                    break label0;
                }
            }

            _lcls02cc = null;
        }
        if (_lcls02cc == null)
        {
            return null;
        }
        _cls0690 _lcls0690 = ex.dC;
        View view = _lcls02cc.fy;
        if (_lcls0690.aH.contains(view))
        {
            return null;
        } else
        {
            return _lcls02cc;
        }
    }
}
