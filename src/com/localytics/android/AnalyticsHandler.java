// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.location.Location;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.net.URLDecoder;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.localytics.android:
//            BaseHandler, BaseProvider, AnalyticsListener, Constants, 
//            LocalyticsDao, DatapointHelper, ReflectionUtils, PushReceiver, 
//            ReferralUploader, LocalyticsManager, AnalyticsProvider, AnalyticsUploadHandler, 
//            BaseUploadThread

class AnalyticsHandler extends BaseHandler
{
    final class AnalyticsListenersSet extends BaseHandler.ListenersSet
        implements AnalyticsListener
    {

        final AnalyticsHandler this$0;

        public final void localyticsDidTagEvent(String s, Map map, long l)
        {
            this;
            JVM INSTR monitorenter ;
            callListeners("localyticsDidTagEvent", new Class[] {
                java/lang/String, java/util/Map, Long.TYPE
            }, new Object[] {
                s, map, Long.valueOf(l)
            });
            this;
            JVM INSTR monitorexit ;
            return;
            s;
            throw s;
        }

        public final void localyticsSessionDidOpen(boolean flag, boolean flag1, boolean flag2)
        {
            this;
            JVM INSTR monitorenter ;
            callListeners("localyticsSessionDidOpen", new Class[] {
                Boolean.TYPE, Boolean.TYPE, Boolean.TYPE
            }, new Object[] {
                Boolean.valueOf(flag), Boolean.valueOf(flag1), Boolean.valueOf(flag2)
            });
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public final void localyticsSessionWillClose()
        {
            this;
            JVM INSTR monitorenter ;
            callListeners("localyticsSessionWillClose", null, null);
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public final void localyticsSessionWillOpen(boolean flag, boolean flag1, boolean flag2)
        {
            this;
            JVM INSTR monitorenter ;
            callListeners("localyticsSessionWillOpen", new Class[] {
                Boolean.TYPE, Boolean.TYPE, Boolean.TYPE
            }, new Object[] {
                Boolean.valueOf(flag), Boolean.valueOf(flag1), Boolean.valueOf(flag2)
            });
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        private AnalyticsListenersSet()
        {
            this$0 = AnalyticsHandler.this;
            super(AnalyticsHandler.this);
        }

        AnalyticsListenersSet(_cls1 _pcls1)
        {
            this();
        }
    }


    private static final int MESSAGE_CLOSE = 102;
    private static final int MESSAGE_DISABLE_PUSH = 112;
    private static final int MESSAGE_HANDLE_PUSH_REGISTRATION = 110;
    private static final int MESSAGE_OPEN = 101;
    private static final int MESSAGE_OPT_OUT = 108;
    private static final int MESSAGE_REGISTER_PUSH = 109;
    private static final int MESSAGE_SET_CUSTOM_DIMENSION = 107;
    private static final int MESSAGE_SET_IDENTIFIER = 105;
    private static final int MESSAGE_SET_LOCATION = 106;
    private static final int MESSAGE_SET_PUSH_REGID = 113;
    private static final int MESSAGE_SET_REFERRERID = 114;
    private static final int MESSAGE_TAG_EVENT = 103;
    private static final int MESSAGE_TAG_SCREEN = 104;
    private static final String PARAM_LOCALYTICS_REFERRER_TEST_MODE = "localytics_test_mode";
    private static final String PROJECTION_SET_CUSTOM_DIMENSION[] = {
        "custom_dimension_value"
    };
    private static final String PROJECTION_SET_IDENTIFIER[] = {
        "key", "value"
    };
    private static final String SELECTION_SET_CUSTOM_DIMENSION = String.format("%s = ?", new Object[] {
        "custom_dimension_key"
    });
    private static final String SELECTION_SET_IDENTIFIER = String.format("%s = ?", new Object[] {
        "key"
    });
    private static Location sLastLocation = null;
    private boolean mAppWasUpgraded;
    boolean mFirstSessionEver;
    boolean mReferrerTestModeEnabled;
    boolean mSentReferrerTestMode;
    private final List screenFlow = new ArrayList();

    AnalyticsHandler(LocalyticsDao localyticsdao, Looper looper)
    {
        super(localyticsdao, looper);
        mAppWasUpgraded = false;
        mFirstSessionEver = false;
        mReferrerTestModeEnabled = false;
        mSentReferrerTestMode = false;
        siloName = "Analytics";
        listeners = new AnalyticsListenersSet(null);
        queueMessage(obtainMessage(1));
    }

    private void _addLocationIDsAndCustomDimensions(JSONObject jsonobject, JSONObject jsonobject1, String s, String s1)
    {
        double d;
        double d1;
        if (sLastLocation == null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        d = sLastLocation.getLatitude();
        d1 = sLastLocation.getLongitude();
        if (d == 0.0D || d1 == 0.0D)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        jsonobject.put("lat", d);
        jsonobject.put("lng", d1);
        jsonobject.put("cid", s);
        jsonobject.put("utp", s1);
        if (jsonobject1.length() > 0)
        {
            jsonobject.put("ids", jsonobject1);
        }
        jsonobject1 = null;
        s = mProvider.query("custom_dimensions", null, null, null, null);
_L2:
        jsonobject1 = s;
        if (!s.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        jsonobject1 = s;
        s1 = s.getString(s.getColumnIndexOrThrow("custom_dimension_key"));
        jsonobject1 = s;
        String s2 = s.getString(s.getColumnIndexOrThrow("custom_dimension_value"));
        jsonobject1 = s;
        jsonobject.put(s1.replace("custom_dimension_", "c"), s2);
        if (true) goto _L2; else goto _L1
_L1:
        if (s != null)
        {
            try
            {
                s.close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                return;
            }
        }
        break MISSING_BLOCK_LABEL_194;
        jsonobject;
        if (jsonobject1 == null)
        {
            break MISSING_BLOCK_LABEL_192;
        }
        jsonobject1.close();
        throw jsonobject;
    }

    private void _close()
    {
        if (!_isSessionOpen())
        {
            Localytics.Log.w("Session was not open, so close is not possible.");
            return;
        } else
        {
            ((AnalyticsListener)listeners).localyticsSessionWillClose();
            _tagEvent("close");
            return;
        }
    }

    private void _dequeQueuedCloseSessionTag(boolean flag)
    {
        Cursor cursor;
        ContentValues contentvalues;
        contentvalues = new ContentValues();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_202;
        }
        cursor = null;
        Object obj = mProvider.query("info", new String[] {
            "queued_close_session_blob", "queued_close_session_blob_upload_format"
        }, null, null, null);
        Cursor cursor1;
        cursor1 = ((Cursor) (obj));
        cursor = cursor1;
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_176;
        }
        cursor = cursor1;
        obj = cursor1.getString(cursor1.getColumnIndexOrThrow("queued_close_session_blob"));
        cursor = cursor1;
        int i = cursor1.getInt(cursor1.getColumnIndexOrThrow("queued_close_session_blob_upload_format"));
        cursor = cursor1;
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            break MISSING_BLOCK_LABEL_176;
        }
        cursor = cursor1;
        screenFlow.clear();
        cursor = cursor1;
        contentvalues.put("blob", ((String) (obj)));
        cursor = cursor1;
        contentvalues.put("upload_format", Integer.valueOf(i));
        cursor = cursor1;
        mProvider.insert("events", contentvalues);
        cursor = cursor1;
        contentvalues.clear();
        cursor = cursor1;
        mAppWasUpgraded = false;
        cursor = cursor1;
        mFirstSessionEver = false;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        break MISSING_BLOCK_LABEL_202;
        Exception exception;
        exception;
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
        contentvalues.putNull("queued_close_session_blob");
        contentvalues.putNull("queued_close_session_blob_upload_format");
        contentvalues.put("last_session_close_time", Integer.valueOf(0));
        mProvider.update("info", contentvalues, null, null);
        return;
    }

    private String _getCustomDimension(int i)
    {
        Cursor cursor;
        Object obj;
        String s;
        if (i < 0 || i > 10)
        {
            return null;
        }
        s = null;
        obj = getCustomDimensionAttributeKey(i);
        cursor = null;
        Cursor cursor1 = mProvider.query("custom_dimensions", PROJECTION_SET_CUSTOM_DIMENSION, SELECTION_SET_CUSTOM_DIMENSION, new String[] {
            obj
        }, null);
        obj = cursor1;
        cursor = ((Cursor) (obj));
        if (!cursor1.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_82;
        }
        cursor = ((Cursor) (obj));
        s = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("custom_dimension_value"));
        Exception exception;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
            return s;
        } else
        {
            return s;
        }
        exception;
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
    }

    private JSONObject _getIdentifiers()
    {
        Cursor cursor1;
        JSONObject jsonobject;
        cursor1 = null;
        Cursor cursor = null;
        jsonobject = new JSONObject();
        Cursor cursor2;
        try
        {
            cursor2 = mProvider.query("identifiers", null, null, null, null);
        }
        // Misplaced declaration of an exception variable
        catch (JSONException jsonexception)
        {
            if (cursor != null)
            {
                cursor.close();
            }
            return jsonobject;
        }
        finally
        {
            if (cursor1 == null) goto _L0; else goto _L0
        }
        cursor = cursor2;
        cursor1 = cursor2;
        if (!cursor2.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        cursor = cursor2;
        cursor1 = cursor2;
        jsonobject.put(cursor2.getString(cursor2.getColumnIndexOrThrow("key")), cursor2.getString(cursor2.getColumnIndexOrThrow("value")));
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_28;
_L1:
        if (cursor2 != null)
        {
            cursor2.close();
        }
        return jsonobject;
        Exception exception;
        JSONException jsonexception;
        cursor1.close();
        return jsonobject;
    }

    private void _handlePushRegistration(Intent intent)
    {
        String s = intent.getStringExtra("registration_id");
        if (_isPushDisabled())
        {
            Localytics.Log.v("GCM registered but push disabled: removing id");
            _setPushID(null);
            return;
        }
        if (intent.getStringExtra("error") != null)
        {
            Localytics.Log.v("GCM registration failed");
            return;
        }
        if (intent.getStringExtra("unregistered") != null)
        {
            Localytics.Log.v("GCM unregistered: removing id");
            _setPushID(null);
            return;
        }
        if (s != null)
        {
            Localytics.Log.v(String.format("GCM registered, new id: %s", new Object[] {
                s
            }));
            _setPushID(s);
        }
    }

    private boolean _isOptedOut()
    {
        Cursor cursor = null;
        Cursor cursor2 = mProvider.query("info", new String[] {
            "opt_out"
        }, null, null, null);
        Cursor cursor1;
        cursor1 = cursor2;
        cursor = cursor1;
        if (!cursor2.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_84;
        }
        cursor = cursor1;
        int i = cursor1.getInt(cursor1.getColumnIndexOrThrow("opt_out"));
        boolean flag;
        if (i != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (cursor1 != null)
        {
            cursor1.close();
        }
        return flag;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        break MISSING_BLOCK_LABEL_110;
        Exception exception;
        exception;
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
        return false;
    }

    private boolean _isPushDisabled()
    {
        Cursor cursor;
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = false;
        cursor = null;
        Cursor cursor1 = mProvider.query("info", new String[] {
            "push_disabled"
        }, null, null, null);
_L2:
        flag1 = flag;
        cursor = cursor1;
        if (!cursor1.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = flag;
        cursor = cursor1;
        int i = cursor1.getInt(cursor1.getColumnIndexOrThrow("push_disabled"));
        if (i == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (true) goto _L2; else goto _L1
_L1:
        if (cursor1 != null)
        {
            cursor1.close();
        }
        return flag;
_L4:
        if (cursor != null)
        {
            cursor.close();
        }
        return flag1;
        Exception exception;
        exception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private boolean _isSessionOpen()
    {
        Cursor cursor;
        long l;
        long l1;
        l = 0L;
        l1 = 0L;
        cursor = null;
        Cursor cursor2 = mProvider.query("info", new String[] {
            "last_session_open_time", "last_session_close_time"
        }, null, null, null);
        Cursor cursor1;
        cursor1 = cursor2;
        cursor = cursor1;
        if (!cursor2.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_88;
        }
        cursor = cursor1;
        l = cursor1.getLong(cursor1.getColumnIndexOrThrow("last_session_open_time"));
        cursor = cursor1;
        l1 = cursor1.getLong(cursor1.getColumnIndexOrThrow("last_session_close_time"));
        if (cursor1 != null)
        {
            cursor1.close();
        }
        break MISSING_BLOCK_LABEL_114;
        Exception exception;
        exception;
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
        return l != 0L && l >= l1;
    }

    private void _open()
    {
        Cursor cursor1;
        if (_isSessionOpen())
        {
            Localytics.Log.w("Session was already open");
            return;
        }
        cursor1 = null;
        Object obj = mProvider.query("info", new String[] {
            "last_session_close_time"
        }, null, null, null);
        Cursor cursor;
        cursor = ((Cursor) (obj));
        cursor1 = cursor;
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_269;
        }
        cursor1 = cursor;
        long l = cursor.getLong(cursor.getColumnIndexOrThrow("last_session_close_time"));
        cursor1 = cursor;
        if (System.currentTimeMillis() >= Constants.SESSION_EXPIRATION + l)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        cursor1 = cursor;
        ((AnalyticsListener)listeners).localyticsSessionWillOpen(false, mAppWasUpgraded, true);
        cursor1 = cursor;
        Localytics.Log.v("Opening old closed session and reconnecting");
        cursor1 = cursor;
        _dequeQueuedCloseSessionTag(false);
        cursor1 = cursor;
        ((AnalyticsListener)listeners).localyticsSessionDidOpen(false, mAppWasUpgraded, true);
        break MISSING_BLOCK_LABEL_269;
        cursor1 = cursor;
        ((AnalyticsListener)listeners).localyticsSessionWillOpen(mFirstSessionEver, mAppWasUpgraded, false);
        cursor1 = cursor;
        Localytics.Log.v("Opening new session");
        cursor1 = cursor;
        _dequeQueuedCloseSessionTag(true);
        cursor1 = cursor;
        obj = DatapointHelper.getAdvertisingInfo(mLocalyticsDao.getAppContext());
        if (obj == null)
        {
            obj = null;
            break MISSING_BLOCK_LABEL_216;
        }
        cursor1 = cursor;
        obj = ((DatapointHelper.AdvertisingInfo) (obj)).id;
        cursor1 = cursor;
        _setFirstAdvertisingId(((String) (obj)));
        cursor1 = cursor;
        _tagEvent("open");
        cursor1 = cursor;
        BaseProvider.deleteOldFiles(mLocalyticsDao.getAppContext());
        cursor1 = cursor;
        ((AnalyticsListener)listeners).localyticsSessionDidOpen(mFirstSessionEver, mAppWasUpgraded, false);
        Exception exception;
        if (cursor != null)
        {
            cursor.close();
            return;
        } else
        {
            return;
        }
        exception;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        throw exception;
    }

    private void _registerPush(String s)
    {
        String s1;
        Cursor cursor1;
        String s3;
        String s4;
        if (_isPushDisabled())
        {
            Localytics.Log.v("Registering for GCM but push disabled");
            return;
        }
        cursor1 = null;
        s4 = null;
        s1 = null;
        s3 = null;
        Cursor cursor2 = mProvider.query("info", new String[] {
            "sender_id", "registration_version", "registration_id"
        }, null, null, null);
        Cursor cursor;
        cursor = cursor2;
        cursor1 = cursor;
        if (!cursor2.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_137;
        }
        cursor1 = cursor;
        s4 = cursor.getString(cursor.getColumnIndexOrThrow("sender_id"));
        cursor1 = cursor;
        s3 = cursor.getString(cursor.getColumnIndexOrThrow("registration_version"));
        cursor1 = cursor;
        s1 = cursor.getString(cursor.getColumnIndexOrThrow("registration_id"));
        if (cursor != null)
        {
            cursor.close();
        }
        break MISSING_BLOCK_LABEL_165;
        s;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        throw s;
        if (!s.equals(s4))
        {
            s1 = null;
            _setPushID(s, null);
        }
        String s2 = DatapointHelper.getAppVersion(mLocalyticsDao.getAppContext());
        if (TextUtils.isEmpty(s1) || !s2.equals(s3))
        {
            Object obj = mLocalyticsDao.getAppContext();
            obj = ReflectionUtils.tryInvokeStatic("com.google.android.gms.gcm.GoogleCloudMessaging", "getInstance", new Class[] {
                android/content/Context
            }, new Object[] {
                obj
            });
            if (obj != null)
            {
                PushReceiver.retrySenderId = s;
                s = (new String[] {
                    s
                });
                ReflectionUtils.tryInvokeInstance(obj, "register", new Class[] {
                    [Ljava/lang/String;
                }, new Object[] {
                    s
                });
            }
        }
        return;
    }

    private void _reuploadFirstSession(String s)
    {
        s = _replaceAttributionInFirstSession(s);
        if (!TextUtils.isEmpty(s))
        {
            (new ReferralUploader(this, s, mLocalyticsDao)).start();
        }
    }

    private void _setCustomDimension(int i, String s)
    {
        String s1 = getCustomDimensionAttributeKey(i);
        if (TextUtils.isEmpty(s))
        {
            mProvider.remove("custom_dimensions", String.format("%s = ?", new Object[] {
                "custom_dimension_key"
            }), new String[] {
                s1
            });
            return;
        }
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("custom_dimension_key", s1);
        contentvalues.put("custom_dimension_value", s);
        if (mProvider.update("custom_dimensions", contentvalues, SELECTION_SET_CUSTOM_DIMENSION, new String[] {
    s1
}) == 0)
        {
            mProvider.insert("custom_dimensions", contentvalues);
        }
    }

    private void _setFirstAdvertisingId(String s)
    {
        Cursor cursor1;
        String s1;
        s1 = null;
        cursor1 = null;
        Cursor cursor2 = mProvider.query("info", new String[] {
            "first_advertising_id"
        }, null, null, null);
        Cursor cursor;
        cursor = cursor2;
        cursor1 = cursor;
        if (!cursor2.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_63;
        }
        cursor1 = cursor;
        s1 = cursor.getString(cursor.getColumnIndexOrThrow("first_advertising_id"));
        if (cursor != null)
        {
            cursor.close();
        }
        break MISSING_BLOCK_LABEL_89;
        s;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        throw s;
        if (!TextUtils.isEmpty(s1))
        {
            Localytics.Log.v("First advertising id has already been set before.");
            return;
        } else
        {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("first_advertising_id", s);
            mProvider.update("info", contentvalues, null, null);
            return;
        }
    }

    private void _setIdentifier(String s, String s1)
    {
        String s2 = s1;
        if (s1 != null)
        {
            s2 = s1.trim();
        }
        if (TextUtils.isEmpty(s2))
        {
            mProvider.remove("identifiers", String.format("%s = ?", new Object[] {
                "key"
            }), new String[] {
                s
            });
        } else
        {
            s1 = new ContentValues();
            s1.put("key", s);
            s1.put("value", s2);
            if (mProvider.update("identifiers", s1, SELECTION_SET_IDENTIFIER, new String[] {
    s
}) == 0)
            {
                mProvider.insert("identifiers", s1);
            }
        }
        if (s.equals("customer_id"))
        {
            s = new ContentValues();
            if (TextUtils.isEmpty(s2))
            {
                s.put("customer_id", mLocalyticsDao.getInstallationId());
                s.put("user_type", "anonymous");
            } else
            {
                s.put("customer_id", s2);
                s.put("user_type", "known");
            }
            mProvider.update("info", s, null, null);
        }
    }

    private void _setOptedOut(boolean flag)
    {
        if (_isOptedOut() == flag)
        {
            return;
        }
        Object obj;
        if (flag)
        {
            obj = "opt_out";
        } else
        {
            obj = "opt_in";
        }
        _tagEvent(((String) (obj)));
        if (_isSessionOpen() && flag)
        {
            _close();
        }
        obj = new ContentValues();
        ((ContentValues) (obj)).put("opt_out", Boolean.valueOf(flag));
        mProvider.update("info", ((ContentValues) (obj)), null, null);
    }

    private void _setPushDisabled(int i)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("push_disabled", Integer.valueOf(i));
        mProvider.update("info", contentvalues, null, null);
    }

    private void _setPushID(String s)
    {
        ContentValues contentvalues = new ContentValues();
        if (s == null)
        {
            s = "";
        }
        contentvalues.put("registration_id", s);
        contentvalues.put("registration_version", DatapointHelper.getAppVersion(mLocalyticsDao.getAppContext()));
        mProvider.update("info", contentvalues, null, null);
    }

    private void _setPushID(String s, String s1)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("sender_id", s);
        if (s1 == null)
        {
            s1 = "";
        }
        contentvalues.put("registration_id", s1);
        mProvider.update("info", contentvalues, null, null);
    }

    private void _setReferrerId(String s)
    {
        Cursor cursor;
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_163;
        }
        cursor = null;
        Object obj = mProvider.query("info", new String[] {
            "play_attribution"
        }, null, null, null);
        Cursor cursor1;
        cursor1 = ((Cursor) (obj));
        cursor = cursor1;
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_139;
        }
        cursor = cursor1;
        if (!TextUtils.isEmpty(cursor1.getString(cursor1.getColumnIndexOrThrow("play_attribution"))))
        {
            break MISSING_BLOCK_LABEL_139;
        }
        cursor = cursor1;
        obj = new ContentValues();
        cursor = cursor1;
        ((ContentValues) (obj)).put("play_attribution", s);
        cursor = cursor1;
        mProvider.update("info", ((ContentValues) (obj)), null, null);
        cursor = cursor1;
        Localytics.Log.i((new StringBuilder("[REFERRAL] _setReferrerId: ")).append(s).toString());
        cursor = cursor1;
        _reuploadFirstSession(s);
        if (cursor1 != null)
        {
            cursor1.close();
            return;
        }
        break MISSING_BLOCK_LABEL_163;
        s;
        if (cursor != null)
        {
            cursor.close();
        }
        throw s;
    }

    private void _tagEvent(String s)
    {
        _tagEvent(s, null, null);
    }

    private void _tagEvent(String s, Map map, Long long1)
    {
        Object obj;
        boolean flag;
        int i = 0;
        int j = 0;
        obj = "";
        String s1 = "";
        String s2 = "";
        Object obj2 = null;
        Object obj1;
        Object obj3;
        JSONObject jsonobject;
        Context context;
        JSONObject jsonobject1;
        Object obj4;
        int k;
        long l;
        long l1;
        long l2;
        try
        {
            jsonobject = new JSONObject();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
        l = 0L;
        jsonobject.put("dt", "h");
        jsonobject.put("u", UUID.randomUUID().toString());
        context = mLocalyticsDao.getAppContext();
        obj4 = (TelephonyManager)context.getSystemService("phone");
        jsonobject1 = new JSONObject();
        obj3 = mProvider.query("info", null, null, null, null);
        obj1 = obj3;
        obj2 = obj1;
        if (!((Cursor) (obj3)).moveToFirst()) goto _L2; else goto _L1
_L1:
        obj2 = obj1;
        jsonobject.put("pa", Math.round(((Cursor) (obj1)).getLong(((Cursor) (obj1)).getColumnIndexOrThrow("created_time")) / 1000L));
        obj2 = obj1;
        k = ((Cursor) (obj1)).getInt(((Cursor) (obj1)).getColumnIndexOrThrow("next_header_number"));
        obj2 = obj1;
        j = ((Cursor) (obj1)).getInt(((Cursor) (obj1)).getColumnIndexOrThrow("next_session_number"));
        obj2 = obj1;
        s1 = ((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndexOrThrow("customer_id"));
        obj2 = obj1;
        s2 = ((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndexOrThrow("user_type"));
        obj2 = obj1;
        obj3 = ((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndexOrThrow("current_session_uuid"));
        obj2 = obj1;
        jsonobject.put("seq", k);
        obj2 = obj1;
        jsonobject1.put("dt", "a");
        obj2 = obj1;
        jsonobject1.put("au", mLocalyticsDao.getApiKey());
        obj2 = obj1;
        obj = DatapointHelper.getAndroidIdHashOrNull(mLocalyticsDao.getAppContext());
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_373;
        }
        obj2 = obj1;
        jsonobject1.put("du", obj);
        obj2 = obj1;
        jsonobject1.put("lv", "androida_3.5.0");
        obj2 = obj1;
        jsonobject1.put("av", DatapointHelper.getAppVersion(mLocalyticsDao.getAppContext()));
        obj2 = obj1;
        jsonobject1.put("dp", "Android");
        obj2 = obj1;
        jsonobject1.put("dll", Locale.getDefault().getLanguage());
        obj2 = obj1;
        jsonobject1.put("dlc", Locale.getDefault().getCountry());
        obj2 = obj1;
        jsonobject1.put("nc", ((TelephonyManager) (obj4)).getNetworkCountryIso());
        obj2 = obj1;
        jsonobject1.put("dc", ((TelephonyManager) (obj4)).getSimCountryIso());
        obj2 = obj1;
        jsonobject1.put("dma", DatapointHelper.getManufacturer());
        obj2 = obj1;
        jsonobject1.put("dmo", Build.MODEL);
        obj2 = obj1;
        jsonobject1.put("dov", android.os.Build.VERSION.RELEASE);
        obj2 = obj1;
        jsonobject1.put("nca", ((TelephonyManager) (obj4)).getNetworkOperatorName());
        obj2 = obj1;
        jsonobject1.put("dac", DatapointHelper.getNetworkType(((TelephonyManager) (obj4)), mLocalyticsDao.getAppContext()));
        obj2 = obj1;
        jsonobject1.put("iu", mLocalyticsDao.getInstallationId());
        obj2 = obj1;
        obj = ((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndexOrThrow("fb_attribution"));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_662;
        }
        obj2 = obj1;
        jsonobject1.put("fbat", obj);
        obj2 = obj1;
        obj = ((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndexOrThrow("registration_id"));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_705;
        }
        obj2 = obj1;
        jsonobject1.put("push", obj);
        obj2 = obj1;
        obj = ((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndexOrThrow("first_android_id"));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_748;
        }
        obj2 = obj1;
        jsonobject1.put("aid", obj);
        obj2 = obj1;
        obj = DatapointHelper.getAndroidIdOrNull(mLocalyticsDao.getAppContext());
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_783;
        }
        obj2 = obj1;
        obj = JSONObject.NULL;
        obj2 = obj1;
        jsonobject1.put("caid", obj);
        obj2 = obj1;
        obj4 = DatapointHelper.getAdvertisingInfo(mLocalyticsDao.getAppContext());
        if (obj4 == null) goto _L4; else goto _L3
_L3:
        obj2 = obj1;
        if (!((DatapointHelper.AdvertisingInfo) (obj4)).limitAdTracking) goto _L4; else goto _L5
_L5:
        flag = true;
_L7:
        obj2 = obj1;
        jsonobject1.put("lad", flag);
        obj2 = obj1;
        obj = ((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndexOrThrow("first_advertising_id"));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_897;
        }
        obj2 = obj1;
        jsonobject1.put("gadid", obj);
        if (obj4 == null)
        {
            break MISSING_BLOCK_LABEL_932;
        }
        obj2 = obj1;
        if (((DatapointHelper.AdvertisingInfo) (obj4)).id == null)
        {
            break MISSING_BLOCK_LABEL_932;
        }
        obj2 = obj1;
        jsonobject1.put("gcadid", ((DatapointHelper.AdvertisingInfo) (obj4)).id);
        obj2 = obj1;
        obj = TimeZone.getDefault();
        obj2 = obj1;
        if (!((TimeZone) (obj)).inDaylightTime(Calendar.getInstance(((TimeZone) (obj))).getTime()))
        {
            break MISSING_BLOCK_LABEL_981;
        }
        obj2 = obj1;
        i = ((TimeZone) (obj)).getRawOffset() + ((TimeZone) (obj)).getDSTSavings();
        break MISSING_BLOCK_LABEL_992;
        obj2 = obj1;
        i = ((TimeZone) (obj)).getRawOffset();
        obj2 = obj1;
        jsonobject1.put("tz", (long)i / 1000L);
        obj2 = obj1;
        obj = ((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndexOrThrow("package_name"));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_1055;
        }
        obj2 = obj1;
        jsonobject1.put("pkg", obj);
        obj2 = obj1;
        obj = DatapointHelper.getSerialNumberHashOrNull();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_1081;
        }
        obj2 = obj1;
        obj = JSONObject.NULL;
        obj2 = obj1;
        jsonobject1.put("dms", obj);
        obj2 = obj1;
        jsonobject1.put("dsdk", Integer.valueOf(Constants.CURRENT_API_LEVEL));
        obj2 = obj1;
        obj = ((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndexOrThrow("play_attribution"));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_1158;
        }
        obj2 = obj1;
        jsonobject1.put("aurl", obj);
        obj2 = obj1;
        l = ((Cursor) (obj1)).getLong(((Cursor) (obj1)).getColumnIndexOrThrow("last_session_open_time"));
        obj2 = obj1;
        _updateHeaderForTestModeAttribution(((String) (obj)), jsonobject1, ((DatapointHelper.AdvertisingInfo) (obj4)), false);
        obj = obj3;
        i = k;
_L2:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_1234;
        }
        ((Cursor) (obj1)).close();
        break MISSING_BLOCK_LABEL_1234;
        s;
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_1232;
        }
        ((Cursor) (obj2)).close();
        throw s;
        jsonobject.put("attrs", jsonobject1);
        jsonobject1 = _getIdentifiers();
        if (jsonobject1.length() > 0)
        {
            jsonobject.put("ids", jsonobject1);
        }
        obj1 = new ContentValues();
        obj2 = new ContentValues();
        ((ContentValues) (obj1)).put("next_header_number", Integer.valueOf(i + 1));
        obj3 = new JSONObject();
        l1 = System.currentTimeMillis();
        obj4 = UUID.randomUUID().toString();
        if (!"open".equals(s))
        {
            break MISSING_BLOCK_LABEL_1563;
        }
        ((JSONObject) (obj3)).put("dt", "s");
        ((JSONObject) (obj3)).put("ct", Math.round(l1 / 1000L));
        ((JSONObject) (obj3)).put("u", obj4);
        l2 = l1 - l;
        if (l != 0L)
        {
            break MISSING_BLOCK_LABEL_1403;
        }
        ((JSONObject) (obj3)).put("sl", 0.0D);
        break MISSING_BLOCK_LABEL_1429;
        if (l2 <= 0L)
        {
            break MISSING_BLOCK_LABEL_1429;
        }
        ((JSONObject) (obj3)).put("sl", Math.round(l2 / 1000L));
        ((JSONObject) (obj3)).put("nth", j);
        _addLocationIDsAndCustomDimensions(((JSONObject) (obj3)), jsonobject1, s1, s2);
        obj = String.format("%s\n%s", new Object[] {
            jsonobject.toString(), ((JSONObject) (obj3)).toString()
        });
        ((ContentValues) (obj2)).put("blob", ((String) (obj)));
        ((ContentValues) (obj2)).put("upload_format", Integer.valueOf(AnalyticsProvider.EventsV3Columns.UploadFormat.V2.getValue()));
        ((ContentValues) (obj1)).put("last_session_open_time", Long.valueOf(l1));
        ((ContentValues) (obj1)).put("next_session_number", Integer.valueOf(j + 1));
        ((ContentValues) (obj1)).put("current_session_uuid", ((String) (obj4)));
        if (mFirstSessionEver)
        {
            ((ContentValues) (obj1)).put("first_open_event_blob", ((String) (obj)));
        }
        break MISSING_BLOCK_LABEL_2102;
        if ("close".equals(s))
        {
            ((JSONObject) (obj3)).put("dt", "c");
            ((JSONObject) (obj3)).put("u", obj4);
            ((JSONObject) (obj3)).put("su", obj);
            ((JSONObject) (obj3)).put("ss", Math.round(l / 1000L));
            ((JSONObject) (obj3)).put("ct", Math.round(l1 / 1000L));
            ((JSONObject) (obj3)).put("ctl", Math.round((l1 - l) / 1000L));
            obj = new JSONArray(screenFlow);
            if (((JSONArray) (obj)).length() > 0)
            {
                ((JSONObject) (obj3)).put("fl", obj);
            }
            _addLocationIDsAndCustomDimensions(((JSONObject) (obj3)), jsonobject1, s1, s2);
            ((ContentValues) (obj1)).put("last_session_close_time", Long.valueOf(l1));
            ((ContentValues) (obj1)).put("queued_close_session_blob", String.format("%s\n%s", new Object[] {
                jsonobject.toString(), ((JSONObject) (obj3)).toString()
            }));
            ((ContentValues) (obj1)).put("queued_close_session_blob_upload_format", Integer.valueOf(AnalyticsProvider.EventsV3Columns.UploadFormat.V2.getValue()));
            break MISSING_BLOCK_LABEL_2102;
        }
        if (!"opt_in".equals(s) && !"opt_out".equals(s))
        {
            break MISSING_BLOCK_LABEL_1886;
        }
        ((JSONObject) (obj3)).put("dt", "o");
        ((JSONObject) (obj3)).put("u", mLocalyticsDao.getApiKey());
        if ("opt_out".equals(s))
        {
            obj = Boolean.TRUE.toString();
            break MISSING_BLOCK_LABEL_1853;
        }
        obj = Boolean.FALSE.toString();
        ((JSONObject) (obj3)).put("out", obj);
        ((JSONObject) (obj3)).put("ct", Math.round(l1 / 1000L));
        break MISSING_BLOCK_LABEL_2053;
        ((JSONObject) (obj3)).put("dt", "e");
        ((JSONObject) (obj3)).put("ct", Math.round(l1 / 1000L));
        ((JSONObject) (obj3)).put("u", obj4);
        if (!_isSessionOpen())
        {
            obj = "";
        }
        ((JSONObject) (obj3)).put("su", obj);
        if (s.startsWith(context.getPackageName()))
        {
            ((JSONObject) (obj3)).put("n", s.substring(context.getPackageName().length() + 1, s.length()));
            break MISSING_BLOCK_LABEL_2001;
        }
        ((JSONObject) (obj3)).put("n", s);
        if (long1.longValue() != 0L)
        {
            ((JSONObject) (obj3)).put("v", long1);
        }
        _addLocationIDsAndCustomDimensions(((JSONObject) (obj3)), jsonobject1, s1, s2);
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_2053;
        }
        ((JSONObject) (obj3)).put("attrs", new JSONObject(map));
        ((ContentValues) (obj2)).put("blob", String.format("%s\n%s", new Object[] {
            jsonobject.toString(), ((JSONObject) (obj3)).toString()
        }));
        ((ContentValues) (obj2)).put("upload_format", Integer.valueOf(AnalyticsProvider.EventsV3Columns.UploadFormat.V2.getValue()));
        mProvider.update("info", ((ContentValues) (obj1)), null, null);
        if (((ContentValues) (obj2)).size() > 0)
        {
            mProvider.insert("events", ((ContentValues) (obj2)));
        }
        if (Arrays.asList(new String[] {
    "open", "close", "opt_in", "opt_out"
}).contains(s))
        {
            break MISSING_BLOCK_LABEL_2212;
        }
        obj = (AnalyticsListener)listeners;
        if (long1 == null)
        {
            l = 0L;
            break MISSING_BLOCK_LABEL_2201;
        }
        l = long1.longValue();
        ((AnalyticsListener) (obj)).localyticsDidTagEvent(s, map, l);
        return;
_L4:
        flag = false;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void _tagScreen(String s)
    {
        if (_isSessionOpen())
        {
            if (screenFlow.size() == 0 || !s.equals(screenFlow.get(screenFlow.size() - 1)))
            {
                screenFlow.add(s);
                return;
            }
        } else
        {
            Localytics.Log.w("Screen not tagged because a session is not open");
        }
    }

    private void _updateHeaderForTestModeAttribution(String s, JSONObject jsonobject, DatapointHelper.AdvertisingInfo advertisinginfo, boolean flag)
    {
        if (mSentReferrerTestMode) goto _L2; else goto _L1
_L1:
        if (!TextUtils.isEmpty(s))
        {
            s = URLDecoder.decode(s).split("[&]");
            int j = s.length;
            for (int i = 0; i < j; i++)
            {
                String as[] = s[i].split("[=]");
                if (as.length <= 1)
                {
                    continue;
                }
                String s1 = as[0].toLowerCase();
                String s2 = as[1].toLowerCase();
                boolean flag1;
                if (s1.equals("localytics_test_mode") && (s2.equals("1") || s2.equals("true")))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                mReferrerTestModeEnabled = flag1;
            }

        }
        if (!flag && !mFirstSessionEver || !mReferrerTestModeEnabled) goto _L2; else goto _L3
_L3:
        Localytics.Log.i("[REFERRAL] using fake id for attribution test mode");
        s = Long.toHexString((new SecureRandom()).nextLong());
        jsonobject.put("aid", s);
        jsonobject.put("du", DatapointHelper.getSha256_buggy(s));
        jsonobject.put("caid", s);
        if (advertisinginfo == null)
        {
            break MISSING_BLOCK_LABEL_231;
        }
        s = UUID.randomUUID().toString();
        jsonobject.put("gadid", s);
        jsonobject.put("gcadid", s);
        mSentReferrerTestMode = true;
        return;
_L5:
        LocalyticsManager.throwOrLogError(org/json/JSONException, "Exception adding values to object");
_L2:
        return;
        s;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private String getCustomDimensionAttributeKey(int i)
    {
        if (i >= 0 && i <= 10)
        {
            return String.format("%s%s", new Object[] {
                "custom_dimension_", String.valueOf(i)
            });
        } else
        {
            return (String)LocalyticsManager.throwOrLogError(java/lang/IndexOutOfBoundsException, (new StringBuilder("Custom dimension index cannot exceed ")).append("10").toString());
        }
    }

    protected void _deleteUploadedData(int i)
    {
        mProvider.remove("events", (new StringBuilder("_id <= ")).append(i).toString(), null);
    }

    protected TreeMap _getDataToUpload()
    {
        Cursor cursor;
        TreeMap treemap;
        treemap = new TreeMap();
        cursor = null;
        Cursor cursor1 = mProvider.query("events", null, null, null, "_id ASC");
_L2:
        cursor = cursor1;
        if (!cursor1.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        cursor = cursor1;
        if (treemap.size() >= 100)
        {
            break; /* Loop/switch isn't completed */
        }
        cursor = cursor1;
        treemap.put(Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("_id"))), cursor1.getString(cursor1.getColumnIndexOrThrow("blob")));
        if (true) goto _L2; else goto _L1
_L1:
        if (cursor1 != null)
        {
            cursor1.close();
        }
        return treemap;
_L4:
        if (cursor != null)
        {
            cursor.close();
        }
        return treemap;
        Exception exception;
        exception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected int _getMaxRowToUpload()
    {
        Cursor cursor;
        int i;
        i = 0;
        cursor = null;
        Cursor cursor2 = mProvider.query("events", new String[] {
            "_id"
        }, null, null, "_id ASC");
        Cursor cursor1;
        cursor1 = cursor2;
        cursor = cursor1;
        if (!cursor2.moveToLast())
        {
            break MISSING_BLOCK_LABEL_63;
        }
        cursor = cursor1;
        i = cursor1.getInt(cursor1.getColumnIndexOrThrow("_id"));
        if (cursor1 != null)
        {
            cursor1.close();
        }
        return i;
_L2:
        if (cursor != null)
        {
            cursor.close();
        }
        return 0;
        Exception exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected void _init()
    {
        if (mProvider == null)
        {
            mProvider = new AnalyticsProvider(siloName.toLowerCase(), mLocalyticsDao);
        }
        _initApiKey();
    }

    protected void _initApiKey()
    {
        Cursor cursor;
        Cursor cursor1;
        cursor1 = null;
        cursor = cursor1;
        String s1 = DatapointHelper.getAppVersion(mLocalyticsDao.getAppContext());
        cursor = cursor1;
        Object obj = mProvider.query("info", new String[] {
            "app_version", "uuid", "next_session_number", "customer_id"
        }, null, null, null);
        cursor1 = ((Cursor) (obj));
        cursor = cursor1;
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_303;
        }
        cursor = cursor1;
        Localytics.Log.v(String.format("Loading details for API key %s", new Object[] {
            mLocalyticsDao.getApiKey()
        }));
        cursor = cursor1;
        obj = new ContentValues();
        cursor = cursor1;
        if (cursor1.getString(cursor1.getColumnIndexOrThrow("app_version")).equals(s1))
        {
            break MISSING_BLOCK_LABEL_155;
        }
        cursor = cursor1;
        ((ContentValues) (obj)).put("app_version", s1);
        cursor = cursor1;
        mAppWasUpgraded = true;
        cursor = cursor1;
        if (((ContentValues) (obj)).size() == 0)
        {
            break MISSING_BLOCK_LABEL_179;
        }
        cursor = cursor1;
        mProvider.update("info", ((ContentValues) (obj)), null, null);
        cursor = cursor1;
        Exception exception;
        String s;
        Exception exception1;
        ContentValues contentvalues;
        boolean flag;
        if (cursor1.getInt(cursor1.getColumnIndexOrThrow("next_session_number")) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        cursor = cursor1;
        mFirstSessionEver = flag;
        cursor = cursor1;
        mLocalyticsDao.setInstallationId(cursor1.getString(cursor1.getColumnIndexOrThrow("uuid")));
        cursor = cursor1;
        s = cursor1.getString(cursor1.getColumnIndexOrThrow("customer_id"));
        cursor = cursor1;
        com/localytics/android/LocalyticsManager;
        JVM INSTR monitorenter ;
        if (mLocalyticsDao.getCustomerIdInMemory(true) == null)
        {
            mLocalyticsDao.setCustomerIdInMemory(s);
        }
        com/localytics/android/LocalyticsManager;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_659;
        exception1;
        cursor = cursor1;
        throw exception1;
        cursor = cursor1;
        Localytics.Log.v(String.format("Performing first-time initialization for new API key %s", new Object[] {
            mLocalyticsDao.getApiKey()
        }));
        cursor = cursor1;
        exception1 = UUID.randomUUID().toString();
        cursor = cursor1;
        mLocalyticsDao.setInstallationId(exception1);
        cursor = cursor1;
        contentvalues = new ContentValues();
        cursor = cursor1;
        contentvalues.put("api_key", mLocalyticsDao.getApiKey());
        cursor = cursor1;
        contentvalues.put("uuid", exception1);
        cursor = cursor1;
        contentvalues.put("created_time", Long.valueOf(System.currentTimeMillis()));
        cursor = cursor1;
        contentvalues.put("opt_out", Boolean.FALSE);
        cursor = cursor1;
        contentvalues.put("push_disabled", Boolean.FALSE);
        cursor = cursor1;
        contentvalues.put("customer_id", exception1);
        cursor = cursor1;
        contentvalues.put("user_type", "anonymous");
        cursor = cursor1;
        contentvalues.put("fb_attribution", DatapointHelper.getFBAttribution(mLocalyticsDao.getAppContext()));
        cursor = cursor1;
        contentvalues.put("first_android_id", DatapointHelper.getAndroidIdOrNull(mLocalyticsDao.getAppContext()));
        cursor = cursor1;
        contentvalues.put("package_name", mLocalyticsDao.getAppContext().getPackageName());
        cursor = cursor1;
        contentvalues.put("app_version", s1);
        cursor = cursor1;
        contentvalues.put("next_session_number", Integer.valueOf(1));
        cursor = cursor1;
        contentvalues.put("next_header_number", Integer.valueOf(1));
        cursor = cursor1;
        contentvalues.put("last_session_open_time", Integer.valueOf(0));
        cursor = cursor1;
        contentvalues.put("last_session_close_time", Integer.valueOf(0));
        cursor = cursor1;
        mProvider.insert("info", contentvalues);
        cursor = cursor1;
        mFirstSessionEver = true;
        cursor = cursor1;
        com/localytics/android/LocalyticsManager;
        JVM INSTR monitorenter ;
        if (mLocalyticsDao.getCustomerIdInMemory(true) == null)
        {
            mLocalyticsDao.setCustomerIdInMemory(exception1);
        }
        com/localytics/android/LocalyticsManager;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_659;
        exception1;
        cursor = cursor1;
        throw exception1;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        mLocalyticsDao.getCustomerIdInitiatedLatch().countDown();
        break MISSING_BLOCK_LABEL_709;
        exception;
        if (cursor != null)
        {
            cursor.close();
        }
        mLocalyticsDao.getCustomerIdInitiatedLatch().countDown();
        throw exception;
        mProvider.vacuumIfNecessary();
        return;
    }

    protected void _onUploadCompleted(String s)
    {
        mProvider.vacuumIfNecessary();
    }

    String _replaceAttributionInFirstSession(String s)
    {
        Cursor cursor = null;
        Object obj = mProvider.query("info", new String[] {
            "first_open_event_blob"
        }, null, null, null);
        Cursor cursor1;
        cursor1 = ((Cursor) (obj));
        cursor = cursor1;
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_197;
        }
        cursor = cursor1;
        obj = cursor1.getString(cursor1.getColumnIndexOrThrow("first_open_event_blob"));
        cursor = cursor1;
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            break MISSING_BLOCK_LABEL_197;
        }
        cursor = cursor1;
        String as[] = ((String) (obj)).split("[\n]");
        cursor = cursor1;
        JSONObject jsonobject = new JSONObject(as[0]);
        cursor = cursor1;
        JSONObject jsonobject1 = (JSONObject)jsonobject.get("attrs");
        cursor = cursor1;
        _updateHeaderForTestModeAttribution(s, jsonobject1, DatapointHelper.getAdvertisingInfo(mLocalyticsDao.getAppContext()), true);
        cursor = cursor1;
        jsonobject1.put("aurl", s);
        cursor = cursor1;
        s = String.format("%s\n%s", new Object[] {
            jsonobject.toString(), as[1]
        });
        if (cursor1 != null)
        {
            cursor1.close();
        }
        return s;
        s;
        cursor = cursor1;
        Localytics.Log.e("JSONException", s);
        if (cursor1 != null)
        {
            cursor1.close();
        }
        break MISSING_BLOCK_LABEL_223;
        s;
        if (cursor != null)
        {
            cursor.close();
        }
        throw s;
        return null;
    }

    void closeSession()
    {
        queueMessage(obtainMessage(102));
    }

    String getCustomDimension(final int dimension)
    {
        return getString(new _cls15());
    }

    String getIdentifier(final String key)
    {
        return getString(new _cls17());
    }

    Map getIdentifiers()
    {
        return getMap(new _cls2());
    }

    String getPushRegistrationID()
    {
        return getString(new _cls16());
    }

    protected BaseUploadThread getUploadThread(TreeMap treemap, String s)
    {
        return new AnalyticsUploadHandler(this, treemap, s, mLocalyticsDao);
    }

    protected void handleMessageExtended(final Message event)
    {
        switch (event.what)
        {
        case 101: // 'e'
            Localytics.Log.d("Analytics handler received MESSAGE_OPEN");
            mProvider.runBatchTransaction(new _cls3());
            return;

        case 102: // 'f'
            Localytics.Log.d("Analytics handler received MESSAGE_CLOSE");
            mProvider.runBatchTransaction(new _cls4());
            return;

        case 103: // 'g'
            Localytics.Log.d("Analytics handler received MESSAGE_TAG_EVENT");
            Object aobj1[] = (Object[])event.obj;
            event = (String)aobj1[0];
            final Map attributes = (Map)aobj1[1];
            final Long clv = (Long)aobj1[2];
            mProvider.runBatchTransaction(new _cls5());
            return;

        case 104: // 'h'
            Localytics.Log.d("Analytics handler received MESSAGE_TAG_SCREEN");
            event = (String)event.obj;
            mProvider.runBatchTransaction(new _cls6());
            return;

        case 107: // 'k'
            Localytics.Log.d("Analytics handler received MESSAGE_SET_CUSTOM_DIMENSION");
            event = ((Message) ((Object[])event.obj));
            final int dimension = ((Integer)event[0]).intValue();
            event = (String)event[1];
            mProvider.runBatchTransaction(new _cls7());
            return;

        case 105: // 'i'
            Localytics.Log.d("Analytics handler received MESSAGE_SET_IDENTIFIER");
            Object aobj[] = (Object[])event.obj;
            event = (String)aobj[0];
            final String value = (String)aobj[1];
            mProvider.runBatchTransaction(new _cls8());
            return;

        case 106: // 'j'
            Localytics.Log.d("Analytics handler received MESSAGE_SET_LOCATION");
            sLastLocation = (Location)event.obj;
            return;

        case 113: // 'q'
            Localytics.Log.d("Analytics handler received MESSAGE_SET_PUSH_REGID");
            event = (String)event.obj;
            mProvider.runBatchTransaction(new _cls9());
            return;

        case 112: // 'p'
            Localytics.Log.d("Analytics handler received MESSAGE_DISABLE_PUSH");
            final int disabled = event.arg1;
            mProvider.runBatchTransaction(new _cls10());
            return;

        case 108: // 'l'
            Localytics.Log.v("Analytics handler received MESSAGE_OPT_OUT");
            final boolean isOptingOut;
            if (event.arg1 != 0)
            {
                isOptingOut = true;
            } else
            {
                isOptingOut = false;
            }
            mProvider.runBatchTransaction(new _cls11());
            return;

        case 109: // 'm'
            Localytics.Log.d("Analytics handler received MESSAGE_REGISTER_PUSH");
            event = (String)event.obj;
            mProvider.runBatchTransaction(new _cls12());
            return;

        case 110: // 'n'
            Localytics.Log.d("Analytics handler received MESSAGE_HANDLE_PUSH_REGISTRATION");
            event = (Intent)event.obj;
            mProvider.runBatchTransaction(new _cls13());
            return;

        case 114: // 'r'
            Localytics.Log.d("Analytics handler received MESSAGE_SET_REFERRERID");
            event = (String)event.obj;
            mProvider.runBatchTransaction(new _cls14());
            return;
        }
        super.handleMessageExtended(event);
    }

    void handleRegistration(Intent intent)
    {
        queueMessage(obtainMessage(110, intent));
    }

    boolean isOptedOut()
    {
        return getBool(new _cls18());
    }

    boolean isPushDisabled()
    {
        return getBool(new _cls1());
    }

    void openSession()
    {
        queueMessage(obtainMessage(101));
    }

    void registerPush(String s, long l)
    {
        queueMessageDelayed(obtainMessage(109, s), l);
    }

    void setCustomDimension(int i, String s)
    {
        if (i < 0 || i >= 10)
        {
            throw new IllegalArgumentException("Only valid dimensions are 0 - 9");
        } else
        {
            queueMessage(obtainMessage(107, ((Object) (new Object[] {
                Integer.valueOf(i), s
            }))));
            return;
        }
    }

    void setIdentifier(String s, String s1)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("key cannot be null or empty");
        } else
        {
            queueMessage(obtainMessage(105, ((Object) (new Object[] {
                s, s1
            }))));
            return;
        }
    }

    void setLocation(Location location)
    {
        queueMessage(obtainMessage(106, new Location(location)));
    }

    void setOptedOut(boolean flag)
    {
        Localytics.Log.v(String.format("Requested opt-out state is %b", new Object[] {
            Boolean.valueOf(flag)
        }));
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        queueMessage(obtainMessage(108, i, 0));
    }

    void setPushDisabled(boolean flag)
    {
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        queueMessage(obtainMessage(112, i, 0));
    }

    void setPushRegistrationId(String s)
    {
        queueMessage(obtainMessage(113, s));
    }

    void setReferrerId(String s)
    {
        queueMessage(obtainMessage(114, s));
    }

    void setScreenFlow(List list)
    {
        screenFlow.addAll(0, list);
    }

    void tagEvent(String s, Map map, long l)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("event cannot be null or empty");
        }
        if (map != null)
        {
            if (map.isEmpty())
            {
                LocalyticsManager.throwOrLogError(java/lang/IllegalArgumentException, "attributes is empty.  Did the caller make an error?");
            }
            if (map.size() > 50)
            {
                LocalyticsManager.throwOrLogError(java/lang/IllegalArgumentException, String.format("attributes size is %d, exceeding the maximum size of %d.  Did the caller make an error?", new Object[] {
                    Integer.valueOf(map.size()), Integer.valueOf(50)
                }));
            }
            Iterator iterator = map.entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (java.util.Map.Entry)iterator.next();
                String s1 = (String)((java.util.Map.Entry) (obj)).getKey();
                obj = (String)((java.util.Map.Entry) (obj)).getValue();
                if (TextUtils.isEmpty(s1))
                {
                    LocalyticsManager.throwOrLogError(java/lang/IllegalArgumentException, "attributes cannot contain null or empty keys");
                }
                if (TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    LocalyticsManager.throwOrLogError(java/lang/IllegalArgumentException, "attributes cannot contain null or empty values");
                }
            } while (true);
        }
        queueMessage(obtainMessage(103, ((Object) (new Object[] {
            s, map, Long.valueOf(l)
        }))));
    }

    void tagScreen(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("event cannot be null or empty");
        } else
        {
            queueMessage(obtainMessage(104, s));
            return;
        }
    }



















    private class _cls15
        implements Callable
    {

        final AnalyticsHandler this$0;
        final int val$dimension;

        public volatile Object call()
        {
            return call();
        }

        public String call()
        {
            return _getCustomDimension(dimension);
        }

        _cls15()
        {
            this$0 = AnalyticsHandler.this;
            dimension = i;
            super();
        }
    }


    private class _cls17
        implements Callable
    {

        final AnalyticsHandler this$0;
        final String val$key;

        public volatile Object call()
        {
            return call();
        }

        public String call()
        {
            Cursor cursor1;
            String s;
            cursor1 = null;
            s = null;
            Cursor cursor2 = mProvider.query("identifiers", AnalyticsHandler.PROJECTION_SET_IDENTIFIER, AnalyticsHandler.SELECTION_SET_IDENTIFIER, new String[] {
                key
            }, null);
            Cursor cursor;
            cursor = cursor2;
            cursor1 = cursor;
            if (!cursor2.moveToFirst())
            {
                break MISSING_BLOCK_LABEL_68;
            }
            cursor1 = cursor;
            s = cursor.getString(cursor.getColumnIndexOrThrow("value"));
            Exception exception;
            if (cursor != null)
            {
                cursor.close();
                return s;
            } else
            {
                return s;
            }
            exception;
            if (cursor1 != null)
            {
                cursor1.close();
            }
            throw exception;
        }

        _cls17()
        {
            this$0 = AnalyticsHandler.this;
            key = s;
            super();
        }
    }


    private class _cls2
        implements Callable
    {

        final AnalyticsHandler this$0;

        public volatile Object call()
        {
            return call();
        }

        public Map call()
        {
            Cursor cursor;
            HashMap hashmap;
            cursor = null;
            hashmap = new HashMap();
            Cursor cursor1 = mProvider.query("identifiers", null, null, null, null);
_L2:
            cursor = cursor1;
            if (!cursor1.moveToNext())
            {
                break; /* Loop/switch isn't completed */
            }
            cursor = cursor1;
            hashmap.put(cursor1.getString(cursor1.getColumnIndexOrThrow("key")), cursor1.getString(cursor1.getColumnIndexOrThrow("value")));
            if (true) goto _L2; else goto _L1
_L1:
            if (cursor1 != null)
            {
                cursor1.close();
            }
            return hashmap;
_L4:
            if (cursor != null)
            {
                cursor.close();
            }
            return hashmap;
            Exception exception;
            exception;
            if (true) goto _L4; else goto _L3
_L3:
        }

        _cls2()
        {
            this$0 = AnalyticsHandler.this;
            super();
        }
    }


    private class _cls16
        implements Callable
    {

        final AnalyticsHandler this$0;

        public volatile Object call()
        {
            return call();
        }

        public String call()
        {
            Cursor cursor1;
            String s;
            cursor1 = null;
            s = null;
            Cursor cursor2 = mProvider.query("info", new String[] {
                "registration_id"
            }, null, null, null);
            Cursor cursor;
            cursor = cursor2;
            cursor1 = cursor;
            if (!cursor2.moveToFirst())
            {
                break MISSING_BLOCK_LABEL_62;
            }
            cursor1 = cursor;
            s = cursor.getString(cursor.getColumnIndexOrThrow("registration_id"));
            if (cursor != null)
            {
                cursor.close();
            }
            return s;
_L2:
            if (cursor1 != null)
            {
                cursor1.close();
            }
            return null;
            Exception exception;
            exception;
            if (true) goto _L2; else goto _L1
_L1:
        }

        _cls16()
        {
            this$0 = AnalyticsHandler.this;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final AnalyticsHandler this$0;

        public void run()
        {
            if (_isOptedOut())
            {
                Localytics.Log.d("Data collection is opted out");
                return;
            } else
            {
                _open();
                return;
            }
        }

        _cls3()
        {
            this$0 = AnalyticsHandler.this;
            super();
        }
    }


    private class _cls4
        implements Runnable
    {

        final AnalyticsHandler this$0;

        public void run()
        {
            if (_isOptedOut())
            {
                Localytics.Log.d("Data collection is opted out");
                return;
            } else
            {
                _close();
                return;
            }
        }

        _cls4()
        {
            this$0 = AnalyticsHandler.this;
            super();
        }
    }


    private class _cls5
        implements Runnable
    {

        final AnalyticsHandler this$0;
        final Map val$attributes;
        final Long val$clv;
        final String val$event;

        public void run()
        {
            if (_isOptedOut())
            {
                Localytics.Log.d("Data collection is opted out");
                return;
            } else
            {
                _tagEvent(event, attributes, clv);
                return;
            }
        }

        _cls5()
        {
            this$0 = AnalyticsHandler.this;
            event = s;
            attributes = map;
            clv = long1;
            super();
        }
    }


    private class _cls6
        implements Runnable
    {

        final AnalyticsHandler this$0;
        final String val$screen;

        public void run()
        {
            if (_isOptedOut())
            {
                Localytics.Log.d("Data collection is opted out");
                return;
            } else
            {
                _tagScreen(screen);
                return;
            }
        }

        _cls6()
        {
            this$0 = AnalyticsHandler.this;
            screen = s;
            super();
        }
    }


    private class _cls7
        implements Runnable
    {

        final AnalyticsHandler this$0;
        final int val$dimension;
        final String val$value;

        public void run()
        {
            _setCustomDimension(dimension, value);
        }

        _cls7()
        {
            this$0 = AnalyticsHandler.this;
            dimension = i;
            value = s;
            super();
        }
    }


    private class _cls8
        implements Runnable
    {

        final AnalyticsHandler this$0;
        final String val$key;
        final String val$value;

        public void run()
        {
            _setIdentifier(key, value);
        }

        _cls8()
        {
            this$0 = AnalyticsHandler.this;
            key = s;
            value = s1;
            super();
        }
    }


    private class _cls9
        implements Runnable
    {

        final AnalyticsHandler this$0;
        final String val$pushRegId;

        public void run()
        {
            if (_isPushDisabled())
            {
                Localytics.Log.v("Registering for GCM but push disabled");
                return;
            } else
            {
                _setPushID(pushRegId);
                return;
            }
        }

        _cls9()
        {
            this$0 = AnalyticsHandler.this;
            pushRegId = s;
            super();
        }
    }


    private class _cls10
        implements Runnable
    {

        final AnalyticsHandler this$0;
        final int val$disabled;

        public void run()
        {
            _setPushDisabled(disabled);
        }

        _cls10()
        {
            this$0 = AnalyticsHandler.this;
            disabled = i;
            super();
        }
    }


    private class _cls11
        implements Runnable
    {

        final AnalyticsHandler this$0;
        final boolean val$isOptingOut;

        public void run()
        {
            _setOptedOut(isOptingOut);
        }

        _cls11()
        {
            this$0 = AnalyticsHandler.this;
            isOptingOut = flag;
            super();
        }
    }


    private class _cls12
        implements Runnable
    {

        final AnalyticsHandler this$0;
        final String val$newSenderId;

        public void run()
        {
            _registerPush(newSenderId);
        }

        _cls12()
        {
            this$0 = AnalyticsHandler.this;
            newSenderId = s;
            super();
        }
    }


    private class _cls13
        implements Runnable
    {

        final AnalyticsHandler this$0;
        final Intent val$intent;

        public void run()
        {
            _handlePushRegistration(intent);
        }

        _cls13()
        {
            this$0 = AnalyticsHandler.this;
            intent = intent1;
            super();
        }
    }


    private class _cls14
        implements Runnable
    {

        final AnalyticsHandler this$0;
        final String val$referrerId;

        public void run()
        {
            _setReferrerId(referrerId);
        }

        _cls14()
        {
            this$0 = AnalyticsHandler.this;
            referrerId = s;
            super();
        }
    }


    private class _cls18
        implements Callable
    {

        final AnalyticsHandler this$0;

        public Boolean call()
        {
            return Boolean.valueOf(_isOptedOut());
        }

        public volatile Object call()
        {
            return call();
        }

        _cls18()
        {
            this$0 = AnalyticsHandler.this;
            super();
        }
    }


    private class _cls1
        implements Callable
    {

        final AnalyticsHandler this$0;

        public Boolean call()
        {
            return Boolean.valueOf(_isPushDisabled());
        }

        public volatile Object call()
        {
            return call();
        }

        _cls1()
        {
            this$0 = AnalyticsHandler.this;
            super();
        }
    }

}
