// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.util.Log;

// Referenced classes of package com.localytics.android:
//            Localytics, Constants

static final class 
{

    static int d(String s)
    {
        if (Constants.IS_LOGGING_ENABLED)
        {
            return android.util.Log.d("Localytics", s);
        } else
        {
            return -1;
        }
    }

    static int d(String s, Throwable throwable)
    {
        if (Constants.IS_LOGGING_ENABLED)
        {
            return android.util.Log.d("Localytics", s, throwable);
        } else
        {
            return -1;
        }
    }

    static int e(String s)
    {
        if (Constants.IS_LOGGING_ENABLED)
        {
            return android.util.Log.e("Localytics", s);
        } else
        {
            return -1;
        }
    }

    static int e(String s, Throwable throwable)
    {
        if (Constants.IS_LOGGING_ENABLED)
        {
            return android.util.Log.e("Localytics", s, throwable);
        } else
        {
            return -1;
        }
    }

    static int i(String s)
    {
        if (Constants.IS_LOGGING_ENABLED)
        {
            return android.util.Log.i("Localytics", s);
        } else
        {
            return -1;
        }
    }

    static int i(String s, Throwable throwable)
    {
        if (Constants.IS_LOGGING_ENABLED)
        {
            return android.util.Log.i("Localytics", s, throwable);
        } else
        {
            return -1;
        }
    }

    static int v(String s)
    {
        if (Constants.IS_LOGGING_ENABLED)
        {
            return android.util.Log.v("Localytics", s);
        } else
        {
            return -1;
        }
    }

    static int v(String s, Throwable throwable)
    {
        if (Constants.IS_LOGGING_ENABLED)
        {
            return android.util.Log.v("Localytics", s, throwable);
        } else
        {
            return -1;
        }
    }

    static int w(String s)
    {
        if (Constants.IS_LOGGING_ENABLED)
        {
            return android.util.Log.w("Localytics", s);
        } else
        {
            return -1;
        }
    }

    static int w(String s, Throwable throwable)
    {
        if (Constants.IS_LOGGING_ENABLED)
        {
            return android.util.Log.w("Localytics", s, throwable);
        } else
        {
            return -1;
        }
    }

    static int w(Throwable throwable)
    {
        if (Constants.IS_LOGGING_ENABLED)
        {
            return android.util.Log.w("Localytics", throwable);
        } else
        {
            return -1;
        }
    }

    static int wtf(String s)
    {
        if (Constants.IS_LOGGING_ENABLED)
        {
            return android.util.Log.wtf("Localytics", s);
        } else
        {
            return -1;
        }
    }

    static int wtf(String s, Throwable throwable)
    {
        if (Constants.IS_LOGGING_ENABLED)
        {
            return android.util.Log.wtf("Localytics", s, throwable);
        } else
        {
            return -1;
        }
    }

    static int wtf(Throwable throwable)
    {
        if (Constants.IS_LOGGING_ENABLED)
        {
            return android.util.Log.wtf("Localytics", throwable);
        } else
        {
            return -1;
        }
    }

    ()
    {
    }
}
