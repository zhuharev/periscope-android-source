// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.renderscript.RenderScript;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.view.Display;
import android.view.WindowManager;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package o:
//            aui, aot

public final class aos
{
    static final class if extends Handler
    {

        HashMap bvv;

        public final void handleMessage(Message message)
        {
            int i = message.what;
            if (!hasMessages(i))
            {
                removeMessages(i);
                ((Runnable)message.obj).run();
            }
        }

        public if()
        {
            bvv = new HashMap();
        }
    }


    private static final String RT = Pattern.quote("/");
    private static if bvn;
    private static RenderScript bvo;
    private static final Random bvp = new Random();
    private static final DecimalFormat bvq = new DecimalFormat();
    private static final DecimalFormatSymbols bvr = new DecimalFormatSymbols();
    private static Pattern bvs = Pattern.compile("(\\*(\\d+)\\$(.+?)\\*)");

    public aos()
    {
    }

    public static Random dE()
    {
        return bvp;
    }

    public static String dF()
    {
        return String.format(Locale.US, "%s/%d/%s", new Object[] {
            android.os.Build.VERSION.RELEASE.replaceAll(RT, ""), Integer.valueOf(android.os.Build.VERSION.SDK_INT), Build.DISPLAY.replaceAll(RT, "")
        });
    }

    public static String dG()
    {
        return String.format(Locale.US, "%s/%s", new Object[] {
            Build.MANUFACTURER.replaceAll(RT, ""), Build.MODEL.replaceAll(RT, "")
        });
    }

    public static String dH()
    {
        return aui._mth0157(6);
    }

    public static int _mth0131(Context context)
    {
        int i;
        try
        {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new RuntimeException((new StringBuilder("Could not get package name: ")).append(context).toString());
        }
        return i;
    }

    public static RenderScript _mth01C3(Context context)
    {
        if (bvo == null)
        {
            bvo = RenderScript.create(context);
        }
        return bvo;
    }

    public static Point _mth02B2(Context context)
    {
        context = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        context.getSize(point);
        return point;
    }

    private static transient SpannableStringBuilder _mth02CA(String s, int i, android.view.View.OnClickListener aonclicklistener[])
    {
        StringBuilder stringbuilder = new StringBuilder(s);
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(stringbuilder);
        int k = aonclicklistener.length;
        for (int j = 0; j < k; j++)
        {
            Object obj = bvs.matcher(stringbuilder);
            if (!((Matcher) (obj)).find())
            {
                continue;
            }
            if (((Matcher) (obj)).groupCount() != 3)
            {
                throw new IllegalArgumentException((new StringBuilder("String not properly formatted: ")).append(s).toString());
            }
            int l = ((Matcher) (obj)).start(1);
            int i1 = ((Matcher) (obj)).end(1);
            int j1 = Integer.parseInt(((Matcher) (obj)).group(2));
            obj = ((Matcher) (obj)).group(3);
            stringbuilder.replace(l, i1, ((String) (obj)));
            spannablestringbuilder.replace(l, i1, ((CharSequence) (obj)));
            spannablestringbuilder.setSpan(new aot(i, aonclicklistener, j1 - 1), l, ((String) (obj)).length() + l, 33);
        }

        return spannablestringbuilder;
    }

    public static String _mth02CA(Context context, long l)
    {
        l = System.currentTimeMillis() - l;
        context = context.getResources();
        NumberFormat numberformat = NumberFormat.getInstance();
        if (l <= 5000L)
        {
            return context.getString(0x7f06010c);
        }
        if (l < 60000L)
        {
            return context.getString(0x7f060141, new Object[] {
                numberformat.format((int)Math.floor(l / 1000L))
            });
        }
        if (l < 0x36ee80L)
        {
            return context.getString(0x7f0600e9, new Object[] {
                numberformat.format((int)Math.floor(l / 60000L))
            });
        }
        if (l < 0x5265c00L)
        {
            return context.getString(0x7f0600dd, new Object[] {
                numberformat.format((int)Math.floor(l / 0x36ee80L))
            });
        }
        if (l < 0x240c8400L)
        {
            return context.getString(0x7f060087, new Object[] {
                numberformat.format((int)Math.floor(l / 0x5265c00L))
            });
        }
        if (l < 0x9ca41900L)
        {
            return context.getString(0x7f060179, new Object[] {
                numberformat.format((int)Math.floor(l / 0x240c8400L))
            });
        }
        if (l < 0x757b12c00L)
        {
            return context.getString(0x7f0600ea, new Object[] {
                numberformat.format((int)Math.floor(l / 0x9ca41900L))
            });
        } else
        {
            return context.getString(0x7f06017a, new Object[] {
                numberformat.format((int)Math.floor(l / 0x757b12c00L))
            });
        }
    }

    public static String _mth02CA(ContextWrapper contextwrapper)
    {
        PackageManager packagemanager = contextwrapper.getPackageManager();
        try
        {
            contextwrapper = packagemanager.getPackageInfo(contextwrapper.getPackageName(), 0);
            contextwrapper = (new StringBuilder()).append(((PackageInfo) (contextwrapper)).versionName).append("/").append(((PackageInfo) (contextwrapper)).versionCode).toString();
        }
        // Misplaced declaration of an exception variable
        catch (ContextWrapper contextwrapper)
        {
            return "unknown";
        }
        return contextwrapper;
    }

    public static String _mth02CA(Resources resources, long l, boolean flag)
    {
        boolean flag1;
        if (Integer.parseInt(resources.getString(0x7f060113)) == 4)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        boolean flag2;
        if (Integer.parseInt(resources.getString(0x7f060110)) == 8)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        bvq.setDecimalFormatSymbols(bvr);
        if (!flag)
        {
            return bvq.format(l);
        }
        double d1 = (double)l / 1000000D;
        double d = d1;
        if (d1 >= 1.0D)
        {
            d1 = d;
            if (flag2)
            {
                d1 = d / 100D;
            }
            return resources.getString(0x7f060111, new Object[] {
                bvq.format(Math.floor(10D * d1) / 10D)
            });
        }
        d1 = (double)l / 1000D;
        d = d1;
        if (d1 >= 1.0D)
        {
            double d2 = d;
            if (flag1)
            {
                d2 = d / 10D;
            }
            return resources.getString(0x7f060114, new Object[] {
                bvq.format(Math.floor(10D * d2) / 10D)
            });
        } else
        {
            return bvq.format(l);
        }
    }

    public static transient void _mth02CA(TextView textview, String s, int i, android.view.View.OnClickListener aonclicklistener[])
    {
        textview.setMovementMethod(new LinkMovementMethod());
        textview.setText(_mth02CA(s, i, aonclicklistener));
    }

    public static void _mth02CA(String s, Runnable runnable, long l)
    {
        if (bvn == null)
        {
            bvn = new if();
        }
        if if1 = bvn;
        s = Message.obtain(bvn, s.hashCode(), runnable);
        if1.bvv.put(Integer.valueOf(((Message) (s)).what), Long.valueOf(l));
        if1.sendMessageDelayed(s, l);
    }

    public static void _mth1D0A(String s)
    {
        if (bvn != null && bvn.hasMessages(s.hashCode()))
        {
            bvn.removeMessages(s.hashCode());
        }
    }

    public static CharSequence _mth1D37(String s)
    {
        int k = s.indexOf('*');
        if (k == -1)
        {
            return s;
        }
        int i = s.indexOf('*', k + 1);
        if (i == -1)
        {
            return s;
        } else
        {
            SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(s, 0, k);
            int j = spannablestringbuilder.length();
            spannablestringbuilder.append(s, k + 1, i);
            k = spannablestringbuilder.length();
            spannablestringbuilder.append(s, i + 1, s.length());
            spannablestringbuilder.setSpan(new StyleSpan(1), j, k, 18);
            return spannablestringbuilder;
        }
    }

    public static String _mth1D4B(Context context)
    {
        return (new StringBuilder()).append(android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id")).append("-").append(context.getPackageName()).toString();
    }

    public static String _mth1D57(Context context)
    {
        return android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static String FF9F(Context context)
    {
        return context.getPackageName();
    }

}
