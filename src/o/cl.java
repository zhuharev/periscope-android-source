// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package o:
//            _cls072B, _cls02C9, _cls1427, _cls1D4E, 
//            _cls09AA, ck

public final class cl extends Fragment
    implements android.content.DialogInterface.OnCancelListener
{
    public final class if
        implements _cls09AA._cls02CB
    {

        public final int BM;
        public final _cls09AA BN;
        public final _cls09AA._cls02CB BO;
        private cl BP;

        public final void _mth02CA(ConnectionResult connectionresult)
        {
            cl._mth02CF(BP).post(new _cls02CA(BP, BM, connectionresult));
        }

        public if(int i, _cls09AA _pcls09aa, _cls09AA._cls02CB _pcls02cb)
        {
            BP = cl.this;
            super();
            BM = i;
            BN = _pcls09aa;
            BO = _pcls02cb;
            _pcls09aa._mth02CA(this);
        }
    }

    /* member class not found */
    class _cls02CA {}


    private static final _cls072B BF = _cls072B._mth026D();
    private boolean BG;
    private int BH;
    private ConnectionResult BI;
    private final Handler BJ = new Handler(Looper.getMainLooper());
    private ck BK;
    private final SparseArray BL = new SparseArray();
    private boolean FE7B;

    public cl()
    {
        BH = -1;
    }

    static int _mth02CA(cl cl1, int i)
    {
        cl1.BH = i;
        return i;
    }

    static ConnectionResult _mth02CA(cl cl1, ConnectionResult connectionresult)
    {
        cl1.BI = connectionresult;
        return connectionresult;
    }

    static ck _mth02CA(cl cl1, ck ck1)
    {
        cl1.BK = ck1;
        return ck1;
    }

    public static cl _mth02CA(_cls02C9 _pcls02c9)
    {
        if (Looper.myLooper() != Looper.getMainLooper())
        {
            throw new IllegalStateException("Must be called from main thread of process");
        }
        _pcls02c9 = _pcls02c9.getSupportFragmentManager();
        try
        {
            _pcls02c9 = (cl)_pcls02c9.findFragmentByTag("GmsSupportLifecycleFragment");
        }
        // Misplaced declaration of an exception variable
        catch (_cls02C9 _pcls02c9)
        {
            throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", _pcls02c9);
        }
        if (_pcls02c9 == null || _pcls02c9.isRemoving())
        {
            return null;
        } else
        {
            return _pcls02c9;
        }
    }

    private void _mth02CA(int i, ConnectionResult connectionresult)
    {
        Log.w("GmsSupportLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
        Object obj = (if)BL.get(i);
        if (obj != null)
        {
            _mth09F2(i);
            obj = ((if) (obj)).BO;
            if (obj != null)
            {
                ((_cls09AA._cls02CB) (obj))._mth02CA(connectionresult);
            }
        }
        FF8C();
    }

    static void _mth02CA(cl cl1, int i, ConnectionResult connectionresult)
    {
        cl1._mth02CA(i, connectionresult);
    }

    static boolean _mth02CA(cl cl1)
    {
        return cl1.FE7B;
    }

    static boolean _mth02CA(cl cl1, boolean flag)
    {
        cl1.BG = true;
        return true;
    }

    public static cl _mth02CB(_cls02C9 _pcls02c9)
    {
        cl cl1 = _mth02CA(_pcls02c9);
        _cls1427 _lcls1427 = _pcls02c9.getSupportFragmentManager();
        _pcls02c9 = cl1;
        if (cl1 == null)
        {
            _pcls02c9 = new cl();
            _lcls1427._mth02BB()._mth02CA(_pcls02c9, "GmsSupportLifecycleFragment").commitAllowingStateLoss();
            _lcls1427.executePendingTransactions();
        }
        return _pcls02c9;
    }

    static boolean _mth02CB(cl cl1)
    {
        return cl1.BG;
    }

    static void _mth02CE(cl cl1)
    {
        cl1.FF8C();
    }

    static Handler _mth02CF(cl cl1)
    {
        return cl1.BJ;
    }

    private void _mth09F2(int i)
    {
        if if1 = (if)BL.get(i);
        BL.remove(i);
        if (if1 != null)
        {
            if1.BN._mth02CB(if1);
            if1.BN.disconnect();
        }
    }

    private void FF8C()
    {
        BG = false;
        BH = -1;
        BI = null;
        if (BK != null)
        {
            BK.unregister();
            BK = null;
        }
        for (int i = 0; i < BL.size(); i++)
        {
            ((if)BL.valueAt(i)).BN.connect();
        }

    }

    static _cls072B FF8D()
    {
        return BF;
    }

    public final void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        super.dump(s, filedescriptor, printwriter, as);
        for (int i = 0; i < BL.size(); i++)
        {
            if if1 = (if)BL.valueAt(i);
            printwriter.append(s).append("GoogleApiClient #").print(if1.BM);
            printwriter.println(":");
            if1.BN.dump((new StringBuilder()).append(s).append("  ").toString(), filedescriptor, printwriter, as);
        }

    }

    public final void onActivityResult(int i, int j, Intent intent)
    {
        boolean flag = false;
        switch (i)
        {
        default:
            i = ((flag) ? 1 : 0);
            break;

        case 2: // '\002'
            i = ((flag) ? 1 : 0);
            if (_cls072B._mth1D4E(getActivity()) == 0)
            {
                i = 1;
            }
            break;

        case 1: // '\001'
            if (j == -1)
            {
                i = 1;
            } else
            {
                i = ((flag) ? 1 : 0);
                if (j == 0)
                {
                    BI = new ConnectionResult(13, null);
                    i = ((flag) ? 1 : 0);
                }
            }
            break;
        }
        if (i != 0)
        {
            FF8C();
            return;
        } else
        {
            _mth02CA(BH, BI);
            return;
        }
    }

    public final void onCancel(DialogInterface dialoginterface)
    {
        _mth02CA(BH, new ConnectionResult(13, null));
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            BG = bundle.getBoolean("resolving_error", false);
            BH = bundle.getInt("failed_client_id", -1);
            if (BH >= 0)
            {
                BI = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent)bundle.getParcelable("failed_resolution"));
            }
        }
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resolving_error", BG);
        if (BH >= 0)
        {
            bundle.putInt("failed_client_id", BH);
            bundle.putInt("failed_status", BI.wC);
            bundle.putParcelable("failed_resolution", BI.mPendingIntent);
        }
    }

    public final void onStart()
    {
        super.onStart();
        FE7B = true;
        if (!BG)
        {
            for (int i = 0; i < BL.size(); i++)
            {
                ((if)BL.valueAt(i)).BN.connect();
            }

        }
    }

    public final void onStop()
    {
        super.onStop();
        FE7B = false;
        for (int i = 0; i < BL.size(); i++)
        {
            ((if)BL.valueAt(i)).BN.disconnect();
        }

    }

    public final void _mth02CA(int i, _cls09AA _pcls09aa, _cls09AA._cls02CB _pcls02cb)
    {
        if (_pcls09aa == null)
        {
            throw new NullPointerException(String.valueOf("GoogleApiClient instance cannot be null"));
        }
        boolean flag;
        if (BL.indexOfKey(i) < 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        String s = (new StringBuilder("Already managing a GoogleApiClient with id ")).append(i).toString();
        if (!flag)
        {
            throw new IllegalStateException(String.valueOf(s));
        }
        _pcls02cb = new if(i, _pcls09aa, _pcls02cb);
        BL.put(i, _pcls02cb);
        if (FE7B && !BG)
        {
            _pcls09aa.connect();
        }
    }

}
