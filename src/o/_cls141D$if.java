// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.location.Location;
import android.net.NetworkInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;
import java.io.File;
import java.io.FilenameFilter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.security.auth.x500.X500Principal;

// Referenced classes of package o:
//            _cls141D, _cls06BA, acj, zp, 
//            aui, sf, ul, um, 
//            uk, eq, fb, gi, 
//            gm, _cls0442, _cls0441, rz, 
//            ra, rl, sh, if, 
//            _cls1D38, ada, _cls1D59, _cls1D12

public static final class .Parcel
{

    public static fb _fld02EE;
    public static gm _fld06E5;
    public int _fld02B3;
    public int _fld02B4;
    public int _fld02C6;
    public int _fld02C7;
    public ArrayList _fld02E1;
    public ArrayList _fld2071;
    ArrayList FE76;
    public int FE7A;
    public Fragment FF70;

    public static int _mth02CA(int i, int j)
    {
        int j1 = Color.alpha(j);
        int k1 = Color.alpha(i);
        int i1 = 255 - ((255 - j1) * (255 - k1)) / 255;
        int k = Color.red(i);
        int l = Color.red(j);
        if (i1 == 0)
        {
            k = 0;
        } else
        {
            k = (k * 255 * k1 + l * j1 * (255 - k1)) / (i1 * 255);
        }
        l = Color.green(i);
        int l1 = Color.green(j);
        if (i1 == 0)
        {
            l = 0;
        } else
        {
            l = (l * 255 * k1 + l1 * j1 * (255 - k1)) / (i1 * 255);
        }
        i = Color.blue(i);
        j = Color.blue(j);
        if (i1 == 0)
        {
            i = 0;
        } else
        {
            i = (i * 255 * k1 + j * j1 * (255 - k1)) / (i1 * 255);
        }
        return Color.argb(i1, k, l, i);
    }

    public static int _mth02CA(Parcel parcel)
    {
        int j = parcel.readInt();
        int i;
        if ((0xffff0000 & j) != 0xffff0000)
        {
            i = j >> 16 & 0xffff;
        } else
        {
            i = parcel.readInt();
        }
        int k = parcel.dataPosition();
        if ((0xffff & j) != 20293)
        {
            throw new android.support.v4.app..if((new StringBuilder("Expected object header. Got 0x")).append(Integer.toHexString(j)).toString(), parcel);
        }
        i = k + i;
        if (i < k || i > parcel.dataSize())
        {
            throw new android.support.v4.app..if((new StringBuilder("Size read is invalid start=")).append(k).append(" end=").append(i).toString(), parcel);
        } else
        {
            return i;
        }
    }

    public static long _mth02CA(BigInteger biginteger)
    {
        if (biginteger == null)
        {
            return 0L;
        }
        long l1 = biginteger.longValue();
        long l = l1 >>> 32 & 0xffffffffL;
        l1 = Math.round(((double)(l1 & 0xffffffffL) * 1000D) / 4294967296D);
        if ((0x80000000L & l) == 0L)
        {
            return 1000L * l + 0x1e5ae01dc00L + l1;
        } else
        {
            return (1000L * l - 0x20251fe2400L) + l1;
        }
    }

    public static Bitmap _mth02CA(Bitmap bitmap, Bitmap bitmap1, int i, int j)
    {
        if (bitmap1 == null)
        {
            return null;
        }
        if (bitmap1.getWidth() == i && bitmap1.getHeight() == j)
        {
            return bitmap1;
        }
        float f1 = 0.0F;
        float f2 = 0.0F;
        Matrix matrix = new Matrix();
        float f;
        if (bitmap1.getWidth() * j > bitmap1.getHeight() * i)
        {
            f = (float)j / (float)bitmap1.getHeight();
            f1 = ((float)i - (float)bitmap1.getWidth() * f) * 0.5F;
        } else
        {
            f = (float)i / (float)bitmap1.getWidth();
            f2 = ((float)j - (float)bitmap1.getHeight() * f) * 0.5F;
        }
        matrix.setScale(f, f);
        matrix.postTranslate((int)(0.5F + f1), (int)(0.5F + f2));
        if (bitmap == null)
        {
            if (bitmap1.getConfig() != null)
            {
                bitmap = bitmap1.getConfig();
            } else
            {
                bitmap = android.graphics.onfig.ARGB_8888;
            }
            bitmap = Bitmap.createBitmap(i, j, bitmap);
        }
        if (android.os.RSION.SDK_INT >= 12 && bitmap != null)
        {
            bitmap.setHasAlpha(bitmap1.hasAlpha());
        }
        (new Canvas(bitmap)).drawBitmap(bitmap1, matrix, new Paint(6));
        return bitmap;
    }

    public static Bitmap _mth02CA(Bitmap bitmap, _cls06BA _pcls06ba, int i)
    {
        Matrix matrix = new Matrix();
        switch (i)
        {
        case 2: // '\002'
            matrix.setScale(-1F, 1.0F);
            break;

        case 3: // '\003'
            matrix.setRotate(180F);
            break;

        case 4: // '\004'
            matrix.setRotate(180F);
            matrix.postScale(-1F, 1.0F);
            break;

        case 5: // '\005'
            matrix.setRotate(90F);
            matrix.postScale(-1F, 1.0F);
            break;

        case 6: // '\006'
            matrix.setRotate(90F);
            break;

        case 7: // '\007'
            matrix.setRotate(-90F);
            matrix.postScale(-1F, 1.0F);
            break;

        case 8: // '\b'
            matrix.setRotate(-90F);
            break;
        }
        if (matrix.isIdentity())
        {
            return bitmap;
        }
        RectF rectf = new RectF(0.0F, 0.0F, bitmap.getWidth(), bitmap.getHeight());
        matrix.mapRect(rectf);
        i = Math.round(rectf.width());
        int j = Math.round(rectf.height());
        android.graphics.onfig onfig;
        if (bitmap.getConfig() != null)
        {
            onfig = bitmap.getConfig();
        } else
        {
            onfig = android.graphics.onfig.ARGB_8888;
        }
        Bitmap bitmap1 = _pcls06ba._mth02CB(i, j, onfig);
        _pcls06ba = bitmap1;
        if (bitmap1 == null)
        {
            _pcls06ba = Bitmap.createBitmap(i, j, onfig);
        }
        matrix.postTranslate(-rectf.left, -rectf.top);
        (new Canvas(_pcls06ba)).drawBitmap(bitmap, matrix, new Paint(6));
        return _pcls06ba;
    }

    public static Bitmap _mth02CA(Bitmap bitmap, _cls06BA _pcls06ba, int i, int j)
    {
        if (bitmap.getWidth() == i && bitmap.getHeight() == j)
        {
            if (Log.isLoggable("TransformationUtils", 2))
            {
                Log.v("TransformationUtils", "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float f = Math.min((float)i / (float)bitmap.getWidth(), (float)j / (float)bitmap.getHeight());
        int k = (int)(f * (float)bitmap.getWidth());
        int l = (int)((float)bitmap.getHeight() * f);
        if (bitmap.getWidth() == k && bitmap.getHeight() == l)
        {
            if (Log.isLoggable("TransformationUtils", 2))
            {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Object obj;
        if (bitmap.getConfig() != null)
        {
            obj = bitmap.getConfig();
        } else
        {
            obj = android.graphics.onfig.ARGB_8888;
        }
        Object obj1 = _pcls06ba._mth02CB(k, l, ((android.graphics.onfig) (obj)));
        _pcls06ba = ((_cls06BA) (obj1));
        if (obj1 == null)
        {
            _pcls06ba = Bitmap.createBitmap(k, l, ((android.graphics.onfig) (obj)));
        }
        if (android.os.RSION.SDK_INT >= 12 && _pcls06ba != null)
        {
            _pcls06ba.setHasAlpha(bitmap.hasAlpha());
        }
        if (Log.isLoggable("TransformationUtils", 2))
        {
            Log.v("TransformationUtils", (new StringBuilder("request: ")).append(i).append("x").append(j).toString());
            Log.v("TransformationUtils", (new StringBuilder("toFit:   ")).append(bitmap.getWidth()).append("x").append(bitmap.getHeight()).toString());
            Log.v("TransformationUtils", (new StringBuilder("toReuse: ")).append(_pcls06ba.getWidth()).append("x").append(_pcls06ba.getHeight()).toString());
            Log.v("TransformationUtils", (new StringBuilder("minPct:   ")).append(f).toString());
        }
        obj = new Canvas(_pcls06ba);
        obj1 = new Matrix();
        ((Matrix) (obj1)).setScale(f, f);
        ((Canvas) (obj)).drawBitmap(bitmap, ((Matrix) (obj1)), new Paint(6));
        return _pcls06ba;
    }

    public static Parcelable _mth02CA(Parcel parcel, int i, android.os.le.Creator creator)
    {
        if ((0xffff0000 & i) != 0xffff0000)
        {
            i = i >> 16 & 0xffff;
        } else
        {
            i = parcel.readInt();
        }
        int j = parcel.dataPosition();
        if (i == 0)
        {
            return null;
        } else
        {
            creator = (Parcelable)creator.createFromParcel(parcel);
            parcel.setDataPosition(j + i);
            return creator;
        }
    }

    public static TwitterSession _mth02CA(acj acj1, zp zp1)
    {
        if (acj1 != null && acj1.bcZ == db)
        {
            TwitterSession twittersession = (TwitterSession)TwitterCore.getInstance().getSessionManager().getActiveSession();
            acj1 = twittersession;
            if (twittersession == null)
            {
                String s = zp1.aQC.getString((String)_mth2CA("o.yp").getField("aVQ").get(null), null);
                zp1 = zp1.aQC.getString((String)_mth2CA("o.yp").getField("aVR").get(null), null);
                acj1 = twittersession;
                if (aui._mth02BF(s))
                {
                    acj1 = twittersession;
                    if (aui._mth02BF(zp1))
                    {
                        acj1 = new TwitterSession(new TwitterAuthToken(s, zp1), -1L, "");
                    }
                }
            }
            return acj1;
        } else
        {
            return null;
        }
    }

    public static Boolean _mth02CA(byte byte0)
    {
        switch (byte0)
        {
        case 1: // '\001'
            return Boolean.TRUE;

        case 0: // '\0'
            return Boolean.FALSE;
        }
        return null;
    }

    public static String _mth02CA(long l)
    {
        long l1 = TimeUnit.SECONDS.toHours(l);
        long l2 = l - TimeUnit.HOURS.toSeconds(1L) * l1;
        l = TimeUnit.SECONDS.toMinutes(l2);
        l2 -= TimeUnit.MINUTES.toSeconds(1L) * l;
        if (l1 > 0L)
        {
            return String.format("%d:%02d:%02d", new Object[] {
                Long.valueOf(l1), Long.valueOf(l), Long.valueOf(l2)
            });
        } else
        {
            return String.format("%d:%02d", new Object[] {
                Long.valueOf(l), Long.valueOf(l2)
            });
        }
    }

    public static String _mth02CA(Activity activity, int i)
    {
        activity = activity.getResources();
        switch (i)
        {
        case 4: // '\004'
        case 6: // '\006'
            return null;

        case 1: // '\001'
            return activity.getString(A.common_google_play_services_install_title);

        case 3: // '\003'
            return activity.getString(A.common_google_play_services_enable_title);

        case 18: // '\022'
            return activity.getString(A.common_google_play_services_updating_title);

        case 2: // '\002'
            return activity.getString(A.common_google_play_services_update_title);

        case 42: // '*'
            return activity.getString(A.common_android_wear_update_title);

        case 9: // '\t'
            Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
            return activity.getString(A.common_google_play_services_unsupported_title);

        case 7: // '\007'
            Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
            return activity.getString(A.common_google_play_services_network_error_title);

        case 8: // '\b'
            Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
            return null;

        case 10: // '\n'
            Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
            return null;

        case 5: // '\005'
            Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
            return activity.getString(A.common_google_play_services_invalid_account_title);

        case 11: // '\013'
            Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
            return null;

        case 16: // '\020'
            Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
            return null;

        case 17: // '\021'
            Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
            return activity.getString(A.common_google_play_services_sign_in_failed_title);
        }
        Log.e("GoogleApiAvailability", (new StringBuilder("Unexpected error code ")).append(i).toString());
        return null;
    }

    public static String _mth02CA(Context context)
    {
label0:
        {
            int i = Binder.getCallingPid();
            context = ((ActivityManager)context.getSystemService("activity")).getRunningAppProcesses();
            if (context == null)
            {
                break label0;
            }
            context = context.iterator();
            android.app.Manager.RunningAppProcessInfo runningappprocessinfo;
            do
            {
                if (!context.hasNext())
                {
                    break label0;
                }
                runningappprocessinfo = (android.app.Manager.RunningAppProcessInfo)context.next();
            } while (runningappprocessinfo.pid != i);
            return runningappprocessinfo.processName;
        }
        return null;
    }

    public static String _mth02CA(Context context, int i)
    {
        context = context.getResources();
        switch (i)
        {
        case 1: // '\001'
            return context.getString(A.common_google_play_services_install_button);

        case 3: // '\003'
            return context.getString(A.common_google_play_services_enable_button);

        case 2: // '\002'
        case 42: // '*'
            return context.getString(A.common_google_play_services_update_button);
        }
        return context.getString(0x104000a);
    }

    public static String _mth02CA(Context context, int i, String s)
    {
        context = context.getResources();
        i;
        JVM INSTR lookupswitch 10: default 96
    //                   1: 99
    //                   2: 286
    //                   3: 254
    //                   5: 342
    //                   7: 334
    //                   9: 318
    //                   16: 350
    //                   17: 366
    //                   18: 270
    //                   42: 302;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L2:
        if (context == null) goto _L13; else goto _L12
_L12:
        boolean flag;
        if ((context.getConfiguration().screenLayout & 0xf) > 3)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (android.os.RSION.SDK_INT >= 11)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && i != 0) goto _L15; else goto _L14
_L14:
        Configuration configuration = context.getConfiguration();
        if (android.os.RSION.SDK_INT >= 13)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            if ((configuration.screenLayout & 0xf) <= 3 && configuration.smallestScreenWidthDp >= 600)
            {
                i = 1;
            } else
            {
                i = 0;
            }
        } else
        {
            i = 0;
        }
        if (i == 0) goto _L13; else goto _L15
_L15:
        i = 1;
          goto _L16
_L13:
        i = 0;
_L16:
        if (i != 0)
        {
            return context.getString(A.common_google_play_services_install_text_tablet, new Object[] {
                s
            });
        } else
        {
            return context.getString(A.common_google_play_services_install_text_phone, new Object[] {
                s
            });
        }
_L4:
        return context.getString(A.common_google_play_services_enable_text, new Object[] {
            s
        });
_L10:
        return context.getString(A.common_google_play_services_updating_text, new Object[] {
            s
        });
_L3:
        return context.getString(A.common_google_play_services_update_text, new Object[] {
            s
        });
_L11:
        return context.getString(A.common_android_wear_update_text, new Object[] {
            s
        });
_L7:
        return context.getString(A.common_google_play_services_unsupported_text, new Object[] {
            s
        });
_L6:
        return context.getString(A.common_google_play_services_network_error_text);
_L5:
        return context.getString(A.common_google_play_services_invalid_account_text);
_L8:
        return context.getString(A.common_google_play_services_api_unavailable_text, new Object[] {
            s
        });
_L9:
        return context.getString(A.common_google_play_services_sign_in_failed_text);
_L1:
        return context.getString(A.common_google_play_services_unknown_issue);
    }

    public static String _mth02CA(Bundle bundle)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("---Network Change: ");
        if (bundle.containsKey("networkInfo"))
        {
            NetworkInfo networkinfo = (NetworkInfo)bundle.get("networkInfo");
            if (networkinfo != null)
            {
                stringbuilder.append("type: ").append(networkinfo.getType()).append(" ").append(networkinfo.getTypeName()).append(" ");
                stringbuilder.append("state: ").append(networkinfo.getState()).append(" ").append(networkinfo.getDetailedState()).append(" ");
                stringbuilder.append("reason: ").append(networkinfo.getReason()).append(" ");
            }
        }
        if (bundle.containsKey("inetCondition"))
        {
            stringbuilder.append("inetCondition: ").append(bundle.get("inetCondition")).append(" ");
        }
        return stringbuilder.toString();
    }

    public static String _mth02CA(ada ada, String s)
    {
        if (aui.isEmpty(s))
        {
            return "";
        }
        if (s.equals("other"))
        {
            return ada.getString(0x7f06011a);
        } else
        {
            ada = new Locale(s);
            ada = ada.getDisplayLanguage(ada);
            return (new StringBuilder()).append(ada.substring(0, 1).toUpperCase()).append(ada.substring(1)).toString();
        }
    }

    public static KeyPair _mth02CA()
    {
        Object obj;
        try
        {
            obj = KeyPairGenerator.getInstance("RSA");
            ((KeyPairGenerator) (obj)).initialize(2048);
            obj = ((KeyPairGenerator) (obj)).generateKeyPair();
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            throw new AssertionError(nosuchalgorithmexception);
        }
        return ((KeyPair) (obj));
    }

    public static TreeMap _mth02CA(String s, boolean flag)
    {
        TreeMap treemap = new TreeMap();
        if (s == null)
        {
            return treemap;
        }
        s = s.split("&");
        int j = s.length;
        for (int i = 0; i < j; i++)
        {
            String as[] = s[i].split("=");
            if (as.length == 2)
            {
                if (flag)
                {
                    treemap.put(_mth02CE(as[0]), _mth02CE(as[1]));
                } else
                {
                    treemap.put(as[0], as[1]);
                }
                continue;
            }
            if (TextUtils.isEmpty(as[0]))
            {
                continue;
            }
            if (flag)
            {
                treemap.put(_mth02CE(as[0]), "");
            } else
            {
                treemap.put(as[0], "");
            }
        }

        return treemap;
    }

    public static ScheduledExecutorService _mth02CA(String s)
    {
        ScheduledExecutorService scheduledexecutorservice = Executors.newSingleThreadScheduledExecutor(new sf(s, new AtomicLong(1L)));
        _mth02CA(s, ((ExecutorService) (scheduledexecutorservice)), 2L, TimeUnit.SECONDS);
        return scheduledexecutorservice;
    }

    public static SSLSocketFactory _mth02CA(uk uk1)
    {
        SSLContext sslcontext = SSLContext.getInstance("TLS");
        sslcontext.init(null, new TrustManager[] {
            new ul(new um(uk1.getKeyStoreStream(), uk1.getKeyStorePassword()), uk1)
        }, null);
        return sslcontext.getSocketFactory();
    }

    public static eq _mth02CA(float f)
    {
        Object obj;
        try
        {
            obj = _fld02EE;
        }
        catch (RemoteException remoteexception)
        {
            throw new android.support.v4.app..if(remoteexception);
        }
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        throw new NullPointerException(String.valueOf("CameraUpdateFactory is not initialized"));
        obj = new eq(((fb)obj)._mth02C8(f));
        return ((eq) (obj));
    }

    public static eq _mth02CA(LatLng latlng)
    {
        fb fb1;
        try
        {
            fb1 = _fld02EE;
        }
        // Misplaced declaration of an exception variable
        catch (LatLng latlng)
        {
            throw new android.support.v4.app..if(latlng);
        }
        if (fb1 != null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        throw new NullPointerException(String.valueOf("CameraUpdateFactory is not initialized"));
        latlng = new eq(((fb)fb1)._mth02CF(latlng));
        return latlng;
    }

    public static gi _mth02CA(Bitmap bitmap)
    {
        gm gm1;
        try
        {
            gm1 = _fld06E5;
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            throw new android.support.v4.app..if(bitmap);
        }
        if (gm1 != null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        throw new NullPointerException(String.valueOf("IBitmapDescriptorFactory is not initialized"));
        bitmap = new gi(((gm)gm1)._mth02BE(bitmap));
        return bitmap;
    }

    public static _cls0441 _mth02CA(Context context, _cls1D59 _pcls1d59)
    {
        if (android.os.RSION.SDK_INT >= 16)
        {
            return new _cls0442(context, _pcls1d59);
        }
        if (android.os.RSION.SDK_INT >= 14)
        {
            return new _cls0441(context, _pcls1d59);
        } else
        {
            throw new UnsupportedOperationException();
        }
    }

    public static void _mth02CA(Parcel parcel, int i)
    {
        if ((0xffff0000 & i) != 0xffff0000)
        {
            i = i >> 16 & 0xffff;
        } else
        {
            i = parcel.readInt();
        }
        parcel.setDataPosition(parcel.dataPosition() + i);
    }

    public static void _mth02CA(Parcel parcel, int i, int j)
    {
        if ((0xffff0000 & i) != 0xffff0000)
        {
            i = i >> 16 & 0xffff;
        } else
        {
            i = parcel.readInt();
        }
        if (i != j)
        {
            throw new android.support.v4.app..if((new StringBuilder("Expected size ")).append(j).append(" got ").append(i).append(" (0x").append(Integer.toHexString(i)).append(")").toString(), parcel);
        } else
        {
            return;
        }
    }

    public static void _mth02CA(Parcel parcel, int i, Bundle bundle, boolean flag)
    {
        if (bundle == null)
        {
            return;
        } else
        {
            parcel.writeInt(0xffff0000 | i);
            parcel.writeInt(0);
            i = parcel.dataPosition();
            parcel.writeBundle(bundle);
            int j = parcel.dataPosition();
            parcel.setDataPosition(i - 4);
            parcel.writeInt(j - i);
            parcel.setDataPosition(j);
            return;
        }
    }

    public static void _mth02CA(Parcel parcel, int i, IBinder ibinder, boolean flag)
    {
        if (ibinder == null)
        {
            return;
        } else
        {
            parcel.writeInt(0xffff0000 | i);
            parcel.writeInt(0);
            i = parcel.dataPosition();
            parcel.writeStrongBinder(ibinder);
            int j = parcel.dataPosition();
            parcel.setDataPosition(i - 4);
            parcel.writeInt(j - i);
            parcel.setDataPosition(j);
            return;
        }
    }

    public static void _mth02CA(Parcel parcel, int i, Parcelable parcelable, int j, boolean flag)
    {
        if (parcelable == null)
        {
            return;
        } else
        {
            parcel.writeInt(0xffff0000 | i);
            parcel.writeInt(0);
            i = parcel.dataPosition();
            parcelable.writeToParcel(parcel, j);
            j = parcel.dataPosition();
            parcel.setDataPosition(i - 4);
            parcel.writeInt(j - i);
            parcel.setDataPosition(j);
            return;
        }
    }

    public static void _mth02CA(Parcel parcel, int i, String s, boolean flag)
    {
        if (s == null)
        {
            return;
        } else
        {
            parcel.writeInt(0xffff0000 | i);
            parcel.writeInt(0);
            i = parcel.dataPosition();
            parcel.writeString(s);
            int j = parcel.dataPosition();
            parcel.setDataPosition(i - 4);
            parcel.writeInt(j - i);
            parcel.setDataPosition(j);
            return;
        }
    }

    public static void _mth02CA(Parcel parcel, int i, ArrayList arraylist, ClassLoader classloader)
    {
        if ((0xffff0000 & i) != 0xffff0000)
        {
            i = i >> 16 & 0xffff;
        } else
        {
            i = parcel.readInt();
        }
        int j = parcel.dataPosition();
        if (i == 0)
        {
            return;
        } else
        {
            parcel.readList(arraylist, classloader);
            parcel.setDataPosition(j + i);
            return;
        }
    }

    public static void _mth02CA(Parcel parcel, int i, List list, boolean flag)
    {
        if (list == null)
        {
            return;
        }
        parcel.writeInt(0xffff0000 | i);
        parcel.writeInt(0);
        int j = parcel.dataPosition();
        int k = list.size();
        parcel.writeInt(k);
        for (i = 0; i < k; i++)
        {
            Parcelable parcelable = (Parcelable)list.get(i);
            if (parcelable == null)
            {
                parcel.writeInt(0);
            } else
            {
                _mth02CA(parcel, parcelable, 0);
            }
        }

        i = parcel.dataPosition();
        parcel.setDataPosition(j - 4);
        parcel.writeInt(i - j);
        parcel.setDataPosition(i);
    }

    public static void _mth02CA(Parcel parcel, int i, SafeParcelable asafeparcelable[], int j, boolean flag)
    {
        if (asafeparcelable == null)
        {
            return;
        }
        parcel.writeInt(0xffff0000 | i);
        parcel.writeInt(0);
        int k = parcel.dataPosition();
        int l = asafeparcelable.length;
        parcel.writeInt(l);
        for (i = 0; i < l; i++)
        {
            SafeParcelable safeparcelable = asafeparcelable[i];
            if (safeparcelable == null)
            {
                parcel.writeInt(0);
            } else
            {
                _mth02CA(parcel, ((Parcelable) (safeparcelable)), j);
            }
        }

        i = parcel.dataPosition();
        parcel.setDataPosition(k - 4);
        parcel.writeInt(i - k);
        parcel.setDataPosition(i);
    }

    public static void _mth02CA(Parcel parcel, Parcelable parcelable, int i)
    {
        int j = parcel.dataPosition();
        parcel.writeInt(1);
        int k = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i);
        i = parcel.dataPosition();
        parcel.setDataPosition(j);
        parcel.writeInt(i - k);
        parcel.setDataPosition(i);
    }

    public static void _mth02CA(File file, FilenameFilter filenamefilter, int i, Comparator comparator)
    {
        file = file.listFiles(filenamefilter);
        if (file != null && file.length > i)
        {
            Arrays.sort(file, comparator);
            int k = file.length;
            int l = file.length;
            for (int j = 0; j < l; j++)
            {
                filenamefilter = file[j];
                if (k <= i)
                {
                    return;
                }
                filenamefilter.delete();
                k--;
            }

        }
    }

    public static void _mth02CA(Exception exception, _cls1D12 _pcls1d12)
    {
        _cls1D12 _lcls1d12;
        _cls1D12 _lcls1d12_1;
        if (_pcls1d12 == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        _lcls1d12_1 = null;
        _lcls1d12 = null;
        _pcls1d12 = new PrintWriter(_pcls1d12);
        _lcls1d12 = _pcls1d12;
        _lcls1d12_1 = _pcls1d12;
        _mth02CA(((Throwable) (exception)), ((PrintWriter) (_pcls1d12)));
        rz._mth02CA(_pcls1d12, "Failed to close stack trace writer.");
        return;
        exception;
        _lcls1d12_1 = _lcls1d12;
        ra._mth0454()._mth02CB("CrashlyticsCore", "Failed to create PrintWriter", exception);
        rz._mth02CA(_lcls1d12, "Failed to close stack trace writer.");
        return;
        exception;
        rz._mth02CA(_lcls1d12_1, "Failed to close stack trace writer.");
        throw exception;
    }

    public static void _mth02CA(String s, ExecutorService executorservice, long l, TimeUnit timeunit)
    {
        Runtime.getRuntime().addShutdownHook(new Thread(new sh(s, executorservice, 2L, timeunit), (new StringBuilder("Crashlytics Shutdown Hook for ")).append(s).toString()));
    }

    public static void _mth02CA(Throwable throwable, PrintWriter printwriter)
    {
        Throwable throwable1;
        int i;
        i = 1;
        throwable1 = throwable;
_L5:
        if (throwable1 == null) goto _L2; else goto _L1
_L1:
        String s;
        boolean flag;
        int j;
        try
        {
            throwable = throwable1.getLocalizedMessage();
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            ra._mth0454()._mth02CB("CrashlyticsCore", "Could not write stack trace", throwable);
            return;
        }
        if (throwable == null)
        {
            throwable = null;
            break MISSING_BLOCK_LABEL_175;
        }
        throwable = throwable.replaceAll("(\r\n|\n|\f)", " ");
        break MISSING_BLOCK_LABEL_175;
_L6:
        printwriter.write((new StringBuilder()).append(s).append(throwable1.getClass().getName()).append(": ").append(throwable).append("\n").toString());
        flag = false;
        throwable = throwable1.getStackTrace();
        j = throwable.length;
        i = 0;
_L4:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        s = throwable[i];
        printwriter.write((new StringBuilder("\tat ")).append(s.toString()).append("\n").toString());
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        throwable1 = throwable1.getCause();
        i = ((flag) ? 1 : 0);
          goto _L5
_L2:
        return;
        if (throwable == null)
        {
            throwable = "";
        }
        if (i != 0)
        {
            s = "";
        } else
        {
            s = "Caused by: ";
        }
          goto _L6
    }

    public static void _mth02CA(ada ada, String as[], int i)
    {
        o.if._mth02CA(ada, as, 100);
        ada = PreferenceManager.getDefaultSharedPreferences(ada).edit();
        int j = as.length;
        for (i = 0; i < j; i++)
        {
            String s = as[i];
            ada.putBoolean((new StringBuilder("perm_prompted_")).append(s).toString(), true);
        }

        ada.apply();
    }

    public static boolean _mth02CA(Activity activity, String as[])
    {
        if (android.os.RSION.SDK_INT >= 23)
        {
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                if (_cls1D38._mth02CB(activity, as[i]) != 0)
                {
                    return false;
                }
            }

        }
        return true;
    }

    public static boolean _mth02CA(Context context, String s)
    {
        context = context.getPackageManager();
        int i;
        try
        {
            i = context.getApplicationInfo(s, 0).flags;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return (i & 0x200000) != 0;
    }

    public static boolean _mth02CA(Location location)
    {
        if (location != null)
        {
            double d = location.getLatitude();
            double d1 = location.getLongitude();
            boolean flag;
            if (d != 0.0D || d1 != 0.0D)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                return true;
            }
        }
        return false;
    }

    public static boolean _mth02CA(X509Certificate x509certificate, X509Certificate x509certificate1)
    {
        if (!x509certificate.getSubjectX500Principal().equals(x509certificate1.getIssuerX500Principal()))
        {
            return false;
        }
        try
        {
            x509certificate1.verify(x509certificate.getPublicKey());
        }
        // Misplaced declaration of an exception variable
        catch (X509Certificate x509certificate)
        {
            return false;
        }
        return true;
    }

    public static X509Certificate[] _mth02CA(X509Certificate ax509certificate[], um um1)
    {
        LinkedList linkedlist = new LinkedList();
        boolean flag = false;
        if (um1._mth02CB(ax509certificate[0]))
        {
            flag = true;
        }
        linkedlist.add(ax509certificate[0]);
        int i = 1;
        boolean flag1;
        do
        {
            flag1 = flag;
            if (i >= ax509certificate.length)
            {
                break;
            }
            if (um1._mth02CB(ax509certificate[i]))
            {
                flag = true;
            }
            flag1 = flag;
            if (!_mth02CA(ax509certificate[i], ax509certificate[i - 1]))
            {
                break;
            }
            linkedlist.add(ax509certificate[i]);
            i++;
        } while (true);
        ax509certificate = um1._mth02CE(ax509certificate[i - 1]);
        if (ax509certificate != null)
        {
            linkedlist.add(ax509certificate);
            flag1 = true;
        }
        if (flag1)
        {
            return (X509Certificate[])linkedlist.toArray(new X509Certificate[linkedlist.size()]);
        } else
        {
            throw new CertificateException("Didn't find a trust anchor in chain cleanup!");
        }
    }

    public static int _mth02CB(int i)
    {
        switch (i)
        {
        case 5: // '\005'
        case 6: // '\006'
            return 90;

        case 3: // '\003'
        case 4: // '\004'
            return 180;

        case 7: // '\007'
        case 8: // '\b'
            return 270;
        }
        return 0;
    }

    public static String _mth02CB(int i, int j)
    {
        StackTraceElement astacktraceelement[] = Thread.currentThread().getStackTrace();
        StringBuffer stringbuffer = new StringBuffer();
        for (i = 3; i < j + 3; i++)
        {
            Object obj;
            if (i + 4 >= astacktraceelement.length)
            {
                obj = "<bottom of call stack>";
            } else
            {
                obj = astacktraceelement[i + 4];
                obj = (new StringBuilder()).append(((StackTraceElement) (obj)).getClassName()).append(".").append(((StackTraceElement) (obj)).getMethodName()).append(":").append(((StackTraceElement) (obj)).getLineNumber()).toString();
            }
            stringbuffer.append(((String) (obj))).append(" ");
        }

        return stringbuffer.toString();
    }

    public static String _mth02CB(Parcel parcel, int i)
    {
        if ((0xffff0000 & i) != 0xffff0000)
        {
            i = i >> 16 & 0xffff;
        } else
        {
            i = parcel.readInt();
        }
        int j = parcel.dataPosition();
        if (i == 0)
        {
            return null;
        } else
        {
            String s = parcel.readString();
            parcel.setDataPosition(j + i);
            return s;
        }
    }

    public static String _mth02CB(String s)
    {
        if (s == null)
        {
            return "";
        }
        try
        {
            s = URLEncoder.encode(s, "UTF8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s.getMessage(), s);
        }
        return s;
    }

    public static void _mth02CB(Parcel parcel, int i, int j)
    {
        if (j >= 65535)
        {
            parcel.writeInt(0xffff0000 | i);
            parcel.writeInt(j);
            return;
        } else
        {
            parcel.writeInt(j << 16 | i);
            return;
        }
    }

    public static boolean _mth02CB(Activity activity, String as[])
    {
        int j = as.length;
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(activity);
        for (int i = 0; i < j; i++)
        {
            boolean flag2 = o.if._mth02CA(activity, as[i]);
            boolean flag = flag2;
            boolean flag1 = flag;
            if (!flag2)
            {
                String s = as[i];
                flag1 = flag;
                if (!sharedpreferences.getBoolean((new StringBuilder("perm_prompted_")).append(s).toString(), false))
                {
                    flag1 = true;
                }
            }
            if (!flag1)
            {
                return false;
            }
        }

        return true;
    }

    public static boolean _mth02CB(Context context)
    {
        context = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        context.getSize(point);
        byte byte0;
        if (point.x <= point.y)
        {
            byte0 = 1;
        } else
        {
            byte0 = 2;
        }
        return byte0 == 1;
    }

    public static Object[] _mth02CB(Parcel parcel, int i, android.os.le.Creator creator)
    {
        if ((0xffff0000 & i) != 0xffff0000)
        {
            i = i >> 16 & 0xffff;
        } else
        {
            i = parcel.readInt();
        }
        int j = parcel.dataPosition();
        if (i == 0)
        {
            return null;
        } else
        {
            creator = ((android.os.le.Creator) (parcel.createTypedArray(creator)));
            parcel.setDataPosition(j + i);
            return creator;
        }
    }

    public static IBinder _mth02CE(Parcel parcel, int i)
    {
        if ((0xffff0000 & i) != 0xffff0000)
        {
            i = i >> 16 & 0xffff;
        } else
        {
            i = parcel.readInt();
        }
        int j = parcel.dataPosition();
        if (i == 0)
        {
            return null;
        } else
        {
            IBinder ibinder = parcel.readStrongBinder();
            parcel.setDataPosition(j + i);
            return ibinder;
        }
    }

    public static String _mth02CE(String s)
    {
        if (s == null)
        {
            return "";
        }
        try
        {
            s = URLDecoder.decode(s, "UTF8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s.getMessage(), s);
        }
        return s;
    }

    public static ArrayList _mth02CE(Parcel parcel, int i, android.os.le.Creator creator)
    {
        if ((0xffff0000 & i) != 0xffff0000)
        {
            i = i >> 16 & 0xffff;
        } else
        {
            i = parcel.readInt();
        }
        int j = parcel.dataPosition();
        if (i == 0)
        {
            return null;
        } else
        {
            creator = parcel.createTypedArrayList(creator);
            parcel.setDataPosition(j + i);
            return creator;
        }
    }

    public static gi _mth02CE(int i)
    {
        Object obj;
        try
        {
            obj = _fld06E5;
        }
        catch (RemoteException remoteexception)
        {
            throw new android.support.v4.app..if(remoteexception);
        }
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        throw new NullPointerException(String.valueOf("IBitmapDescriptorFactory is not initialized"));
        obj = new gi(((gm)obj)._mth1505(i));
        return ((gi) (obj));
    }

    public static Bundle _mth02CF(Parcel parcel, int i)
    {
        if ((0xffff0000 & i) != 0xffff0000)
        {
            i = i >> 16 & 0xffff;
        } else
        {
            i = parcel.readInt();
        }
        int j = parcel.dataPosition();
        if (i == 0)
        {
            return null;
        } else
        {
            Bundle bundle = parcel.readBundle();
            parcel.setDataPosition(j + i);
            return bundle;
        }
    }

    public static String _mth02CF(String s)
    {
        if (s == null)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        s = _mth02CB(s);
        int j = s.length();
        for (int i = 0; i < j; i++)
        {
            char c = s.charAt(i);
            if (c == '*')
            {
                stringbuilder.append("%2A");
                continue;
            }
            if (c == '+')
            {
                stringbuilder.append("%20");
                continue;
            }
            if (c == '%' && i + 2 < j && s.charAt(i + 1) == '7' && s.charAt(i + 2) == 'E')
            {
                stringbuilder.append('~');
                i += 2;
            } else
            {
                stringbuilder.append(c);
            }
        }

        return stringbuilder.toString();
    }

    public static void _mth141D(Parcel parcel, int i)
    {
        int j = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(j - i);
        parcel.setDataPosition(j);
    }

    public .Parcel()
    {
    }
}
