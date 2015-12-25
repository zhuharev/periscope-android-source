// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.maps.GoogleMapOptions;
import java.util.List;

// Referenced classes of package o:
//            bd, bb, _cls0993, be, 
//            ba, bf, ew, ff, 
//            ey, bh

public class ev extends FrameLayout
{
    public static final class if
        implements ba
    {

        private final ViewGroup Ep;
        final ff Eq;
        private View Er;

        public final void onCreate(Bundle bundle)
        {
            try
            {
                Eq.onCreate(bundle);
                Er = (View)bh._mth02CA(Eq._mth1647());
                Ep.removeAllViews();
                Ep.addView(Er);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                throw new android.support.v4.app.Fragment.if(bundle);
            }
        }

        public final void onDestroy()
        {
            try
            {
                Eq.onDestroy();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new android.support.v4.app.Fragment.if(remoteexception);
            }
        }

        public final void onLowMemory()
        {
            try
            {
                Eq.onLowMemory();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new android.support.v4.app.Fragment.if(remoteexception);
            }
        }

        public final void onPause()
        {
            try
            {
                Eq.onPause();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new android.support.v4.app.Fragment.if(remoteexception);
            }
        }

        public final void onResume()
        {
            try
            {
                Eq.onResume();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new android.support.v4.app.Fragment.if(remoteexception);
            }
        }

        public if(ViewGroup viewgroup, ff ff1)
        {
            if (ff1 == null)
            {
                throw new NullPointerException("null reference");
            }
            Eq = (ff)ff1;
            if (viewgroup == null)
            {
                throw new NullPointerException("null reference");
            } else
            {
                Ep = (ViewGroup)viewgroup;
                return;
            }
        }
    }

    /* member class not found */
    class _cls02CA {}


    public final _cls02CA Eo;

    public ev(Context context)
    {
        super(context);
        Eo = new _cls02CA(context, null);
        setClickable(true);
    }

    public ev(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        Eo = new _cls02CA(context, GoogleMapOptions._mth02CB(context, attributeset));
        setClickable(true);
    }

    public ev(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        Eo = new _cls02CA(context, GoogleMapOptions._mth02CB(context, attributeset));
        setClickable(true);
    }

    public final void onCreate(Bundle bundle)
    {
        _cls02CA _lcls02ca = Eo;
        _lcls02ca._mth02CA(bundle, new bd(_lcls02ca, bundle));
        if (((bb) (Eo)).zw == null)
        {
            bundle = getContext();
            int i = _cls0993._mth1D4E(bundle);
            String s1 = _cls141D.if._mth02CA(bundle, i, _cls0993._mth2071(bundle));
            String s = _cls141D.if._mth02CA(bundle, i);
            LinearLayout linearlayout = new LinearLayout(getContext());
            linearlayout.setOrientation(1);
            linearlayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2));
            addView(linearlayout);
            TextView textview = new TextView(getContext());
            textview.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2));
            textview.setText(s1);
            linearlayout.addView(textview);
            if (s != null)
            {
                Button button = new Button(bundle);
                button.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2));
                button.setText(s);
                linearlayout.addView(button);
                button.setOnClickListener(new be(bundle, i));
            }
        }
    }

    public final void onDestroy()
    {
        _cls02CA _lcls02ca = Eo;
        if (((bb) (_lcls02ca)).zw != null)
        {
            ((bb) (_lcls02ca)).zw.onDestroy();
            return;
        } else
        {
            _lcls02ca._mth02E2(1);
            return;
        }
    }

    public final void onPause()
    {
        _cls02CA _lcls02ca = Eo;
        if (((bb) (_lcls02ca)).zw != null)
        {
            ((bb) (_lcls02ca)).zw.onPause();
            return;
        } else
        {
            _lcls02ca._mth02E2(5);
            return;
        }
    }

    public final void onResume()
    {
        _cls02CA _lcls02ca = Eo;
        _lcls02ca._mth02CA(null, new bf(_lcls02ca));
    }

    public final void _mth02CA(ey ey)
    {
        if (Looper.myLooper() != Looper.getMainLooper())
        {
            throw new IllegalStateException("getMapAsync() must be called on the main thread");
        }
        Object obj = Eo;
        if (((bb) (obj)).zw != null)
        {
            obj = (if)((bb) (obj)).zw;
            try
            {
                ((if) (obj)).Eq._mth02CA(new ew(((if) (obj)), ey));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ey ey)
            {
                throw new android.support.v4.app.Fragment.if(ey);
            }
        } else
        {
            ((_cls02CA) (obj)).Ex.add(ey);
            return;
        }
    }
}
