// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Notification;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package o:
//            _cls02EE, _cls1507

class FB1D
{
    /* member class not found */
    class if {}


    private static final Object _fld06C1 = new Object();
    private static Field _fld071D;
    private static boolean _fld0E32;
    private static final Object _fld1425 = new Object();

    FB1D()
    {
    }

    public static void _mth02CA(_cls02EE _pcls02ee, CharSequence charsequence, boolean flag, CharSequence charsequence1, Bitmap bitmap, Bitmap bitmap1, boolean flag1)
    {
        _pcls02ee = (new android.app.Notification.BigPictureStyle(_pcls02ee._mth2071())).setBigContentTitle(charsequence).bigPicture(bitmap);
        if (flag1)
        {
            _pcls02ee.bigLargeIcon(bitmap1);
        }
        if (flag)
        {
            _pcls02ee.setSummaryText(charsequence1);
        }
    }

    public static void _mth02CA(_cls02EE _pcls02ee, CharSequence charsequence, boolean flag, CharSequence charsequence1, CharSequence charsequence2)
    {
        _pcls02ee = (new android.app.Notification.BigTextStyle(_pcls02ee._mth2071())).setBigContentTitle(charsequence).bigText(charsequence2);
        if (flag)
        {
            _pcls02ee.setSummaryText(charsequence1);
        }
    }

    public static void _mth02CA(_cls02EE _pcls02ee, CharSequence charsequence, boolean flag, CharSequence charsequence1, ArrayList arraylist)
    {
        _pcls02ee = (new android.app.Notification.InboxStyle(_pcls02ee._mth2071())).setBigContentTitle(charsequence);
        if (flag)
        {
            _pcls02ee.setSummaryText(charsequence1);
        }
        for (charsequence = arraylist.iterator(); charsequence.hasNext(); _pcls02ee.addLine((CharSequence)charsequence.next())) { }
    }

    public static Bundle _mth02CB(android.app.Notification.Builder builder, _cls144A.if if1)
    {
        builder.addAction(if1.getIcon(), if1.getTitle(), if1.FE7A());
        builder = new Bundle(if1.getExtras());
        if (if1._mth02B3() != null)
        {
            builder.putParcelableArray("android.support.remoteInputs", _cls1507._mth02CB(if1._mth02B3()));
        }
        return builder;
    }

    public static Bundle _mth02CB(Notification notification)
    {
        Object obj1 = _fld06C1;
        obj1;
        JVM INSTR monitorenter ;
        boolean flag = _fld0E32;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        obj1;
        JVM INSTR monitorexit ;
        return null;
        Object obj;
        if (_fld071D != null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        obj = android/app/Notification.getDeclaredField("extras");
        if (android/os/Bundle.isAssignableFrom(((Field) (obj)).getType()))
        {
            break MISSING_BLOCK_LABEL_62;
        }
        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
        _fld0E32 = true;
        obj1;
        JVM INSTR monitorexit ;
        return null;
        ((Field) (obj)).setAccessible(true);
        _fld071D = ((Field) (obj));
        Bundle bundle = (Bundle)_fld071D.get(notification);
        obj = bundle;
        if (bundle != null)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        obj = new Bundle();
        _fld071D.set(notification, obj);
        obj1;
        JVM INSTR monitorexit ;
        return ((Bundle) (obj));
        notification;
        Log.e("NotificationCompat", "Unable to access notification extras", notification);
        break MISSING_BLOCK_LABEL_131;
        notification;
        Log.e("NotificationCompat", "Unable to access notification extras", notification);
        _fld0E32 = true;
        obj1;
        JVM INSTR monitorexit ;
        return null;
        notification;
        throw notification;
    }

    public static SparseArray _mth02CB(List list)
    {
        SparseArray sparsearray = null;
        int i = 0;
        for (int j = list.size(); i < j;)
        {
            Bundle bundle = (Bundle)list.get(i);
            SparseArray sparsearray1 = sparsearray;
            if (bundle != null)
            {
                sparsearray1 = sparsearray;
                if (sparsearray == null)
                {
                    sparsearray1 = new SparseArray();
                }
                sparsearray1.put(i, bundle);
            }
            i++;
            sparsearray = sparsearray1;
        }

        return sparsearray;
    }

}
