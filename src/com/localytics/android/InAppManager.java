// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import o.1427;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.localytics.android:
//            BaseMarketingManager, BaseProvider, MarketingMessage, LocalyticsManager, 
//            MarketingCondition, LocalyticsDao, JsonHelper, MarketingDownloader, 
//            FileDownloader, Constants, TestModeButton, TestModeListView, 
//            InAppMessagesAdapter, InAppDialogFragment, MarketingHandler

class InAppManager extends BaseMarketingManager
{
    static final class FrequencyCappingFilter extends Enum
    {

        private static final FrequencyCappingFilter $VALUES[];
        public static final FrequencyCappingFilter BLACKOUT;
        public static final FrequencyCappingFilter FREQUENCY;
        public static final FrequencyCappingFilter MAX_COUNT;

        public static FrequencyCappingFilter valueOf(String s)
        {
            return (FrequencyCappingFilter)Enum.valueOf(com/localytics/android/InAppManager$FrequencyCappingFilter, s);
        }

        public static FrequencyCappingFilter[] values()
        {
            return (FrequencyCappingFilter[])$VALUES.clone();
        }

        static 
        {
            FREQUENCY = new FrequencyCappingFilter("FREQUENCY", 0);
            MAX_COUNT = new FrequencyCappingFilter("MAX_COUNT", 1);
            BLACKOUT = new FrequencyCappingFilter("BLACKOUT", 2);
            $VALUES = (new FrequencyCappingFilter[] {
                FREQUENCY, MAX_COUNT, BLACKOUT
            });
        }

        private FrequencyCappingFilter(String s, int i)
        {
            super(s, i);
        }
    }


    private static final List AUGMENTED_BLACKOUT_TIMES_RULE;
    private static final List AUGMENTED_BLACKOUT_WEEKDAYS_RULE = Arrays.asList(new Integer[] {
        Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6)
    });
    private static final SimpleDateFormat DATE_SDF;
    private static final Map DEFAULT_FREQUENCY_CAPPING_RULE;
    private static final int GLOBAL_FREQUENCY_CAPPING_RULE_CAMPAIGN_ID = -1;
    private static final String GLOBAL_FREQUENCY_CAPPING_RULE_REQUIRED_KEYS[] = {
        "display_frequencies"
    };
    private static final String INDIVIDUAL_FREQUENCY_CAPPING_RULE_REQUIRED_KEYS[] = {
        "max_display_count", "ignore_global"
    };
    private static final List JS_STRINGS_THAT_MEAN_NULL = Arrays.asList(new String[] {
        "undefined", "null", "nil", "\"\"", "''"
    });
    private static final String PROJECTION_IN_APP_RULE_RECORD[] = {
        "_id", "version"
    };
    private static final SimpleDateFormat TIME_SDF;
    private boolean mCampaignDisplaying;
    protected FileDownloader mFileDownloader;
    private _cls1427 mFragmentManager;
    private MarketingHandler mMarketingHandler;
    private boolean mSessionStartInAppMessageShown;
    private InAppMessagesAdapter mTestCampaignsListAdapter;

    InAppManager(LocalyticsDao localyticsdao, MarketingHandler marketinghandler, FileDownloader filedownloader)
    {
        super(localyticsdao);
        mSessionStartInAppMessageShown = true;
        mCampaignDisplaying = false;
        mTestCampaignsListAdapter = null;
        mMarketingHandler = marketinghandler;
        mFileDownloader = filedownloader;
    }

    private void _bindRuleToEvents(long l, List list)
    {
        mProvider.remove("marketing_ruleevent", String.format("%s = ?", new Object[] {
            "rule_id_ref"
        }), new String[] {
            Long.toString(l)
        });
        ContentValues contentvalues;
        for (list = list.iterator(); list.hasNext(); mProvider.insert("marketing_ruleevent", contentvalues))
        {
            String s = (String)list.next();
            contentvalues = new ContentValues();
            contentvalues.put("event_name", s);
            contentvalues.put("rule_id_ref", Long.valueOf(l));
        }

    }

    private boolean _decompressZipFile(String s, String s1, String s2)
    {
        String s3;
        String s4;
        s4 = null;
        s3 = null;
        s = new ZipInputStream(new FileInputStream((new StringBuilder()).append(s).append(File.separator).append(s2).toString()));
        s3 = s;
        s4 = s;
        s2 = new byte[8192];
_L4:
        s3 = s;
        s4 = s;
        ZipEntry zipentry = s.getNextEntry();
        if (zipentry == null)
        {
            break; /* Loop/switch isn't completed */
        }
        s3 = s;
        s4 = s;
        String s5 = (new StringBuilder()).append(s1).append(File.separator).append(zipentry.getName()).toString();
        s3 = s;
        s4 = s;
        if (!zipentry.isDirectory())
        {
            break MISSING_BLOCK_LABEL_173;
        }
        s3 = s;
        s4 = s;
        if ((new File(s5)).mkdir())
        {
            continue; /* Loop/switch isn't completed */
        }
        s3 = s;
        s4 = s;
        FileOutputStream fileoutputstream;
        int i;
        try
        {
            Localytics.Log.w(String.format("Could not create directory %s", new Object[] {
                s5
            }));
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s4 = s3;
        }
        finally
        {
            if (s4 == null) goto _L0; else goto _L0
        }
        break MISSING_BLOCK_LABEL_277;
        s3 = s;
        s4 = s;
        fileoutputstream = new FileOutputStream(s5);
_L2:
        s3 = s;
        s4 = s;
        i = s.read(s2, 0, 8192);
        if (i <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        s3 = s;
        s4 = s;
        fileoutputstream.write(s2, 0, i);
        if (true) goto _L2; else goto _L1
_L1:
        s3 = s;
        s4 = s;
        fileoutputstream.close();
        s3 = s;
        s4 = s;
        s.closeEntry();
        if (true) goto _L4; else goto _L3
_L3:
        try
        {
            s.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Localytics.Log.w("Caught IOException", s);
            return false;
        }
        break MISSING_BLOCK_LABEL_338;
        Localytics.Log.w("Caught IOException", s);
        if (s3 != null)
        {
            try
            {
                s3.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Localytics.Log.w("Caught IOException", s);
                return false;
            }
        }
        return false;
        try
        {
            s4.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Localytics.Log.w("Caught IOException", s);
            return false;
        }
        throw s;
        return true;
    }

    private void _destroyLocalInAppMessage(MarketingMessage marketingmessage)
    {
        long al[];
        File file;
        String as[];
        int i;
        int j;
        int k;
        long l;
        try
        {
            j = _getRuleIdFromCampaignId(((Integer)marketingmessage.get("campaign_id")).intValue());
            al = _getConditionIdFromRuleId(j);
            k = al.length;
        }
        // Misplaced declaration of an exception variable
        catch (MarketingMessage marketingmessage)
        {
            LocalyticsManager.throwOrLogError(java/lang/RuntimeException, "Localytics library threw an uncaught exception", marketingmessage);
            return;
        }
        i = 0;
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        l = al[i];
        mProvider.remove("marketing_condition_values", String.format("%s = ?", new Object[] {
            "condition_id_ref"
        }), new String[] {
            Long.toString(l)
        });
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_34;
_L1:
        mProvider.remove("marketing_conditions", String.format("%s = ?", new Object[] {
            "rule_id_ref"
        }), new String[] {
            Integer.toString(j)
        });
        mProvider.remove("marketing_ruleevent", String.format("%s = ?", new Object[] {
            "rule_id_ref"
        }), new String[] {
            Integer.toString(j)
        });
        mProvider.remove("marketing_rules", String.format("%s = ?", new Object[] {
            "_id"
        }), new String[] {
            Integer.toString(j)
        });
        marketingmessage = (String)marketingmessage.get("base_path");
        if (marketingmessage == null)
        {
            break MISSING_BLOCK_LABEL_374;
        }
        file = new File(marketingmessage);
        if (!file.isDirectory()) goto _L4; else goto _L3
_L3:
        as = file.list();
        j = as.length;
        i = 0;
_L5:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        (new File(file, as[i])).delete();
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        if (!file.delete())
        {
            Localytics.Log.w(String.format("Delete %s failed.", new Object[] {
                marketingmessage
            }));
        }
        if (!(new File((new StringBuilder()).append(marketingmessage).append(".zip").toString())).delete())
        {
            Localytics.Log.w(String.format("Delete %s failed.", new Object[] {
                (new StringBuilder()).append(marketingmessage).append(".zip").toString()
            }));
        }
    }

    private boolean _doesCreativeExist(int i, boolean flag)
    {
        File file;
        if (flag)
        {
            file = new File((new StringBuilder()).append(_getZipFileDirPath()).append(File.separator).append(String.format("amp_rule_%d.zip", new Object[] {
                Integer.valueOf(i)
            })).toString());
        } else
        {
            file = new File((new StringBuilder()).append(_getUnzipFileDirPath(i)).append(File.separator).append("index.html").toString());
        }
        return file.exists();
    }

    private Set _getCampaignIdsFromFrequencyCappingQuery(String s)
    {
        return _getCampaignIdsFromFrequencyCappingQuery(s, null);
    }

    private Set _getCampaignIdsFromFrequencyCappingQuery(String s, String as[])
    {
        String s1;
        HashSet hashset;
        hashset = new HashSet();
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_99;
        }
        s1 = null;
        s = mProvider.mDb.rawQuery(s, as);
_L2:
        s1 = s;
        if (!s.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = s;
        hashset.add(Integer.valueOf(s.getInt(s.getColumnIndexOrThrow("campaign_id"))));
        if (true) goto _L2; else goto _L1
_L1:
        if (s != null)
        {
            s.close();
            return hashset;
        }
        break MISSING_BLOCK_LABEL_99;
        s;
        if (s1 != null)
        {
            s1.close();
        }
        throw s;
        return hashset;
    }

    private long[] _getConditionIdFromRuleId(long l)
    {
        Cursor cursor;
        Cursor cursor1;
        cursor1 = null;
        cursor = cursor1;
        Object obj = mProvider;
        cursor = cursor1;
        String s = String.format("%s = ?", new Object[] {
            "rule_id_ref"
        });
        cursor = cursor1;
        String s1 = Long.toString(l);
        cursor = cursor1;
        obj = ((BaseProvider) (obj)).query("marketing_conditions", new String[] {
            "_id"
        }, s, new String[] {
            s1
        }, null);
        cursor1 = ((Cursor) (obj));
        cursor = cursor1;
        long al[] = new long[((Cursor) (obj)).getCount()];
        int i = 0;
_L2:
        cursor = cursor1;
        if (!cursor1.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        int j;
        j = i + 1;
        cursor = cursor1;
        al[i] = cursor1.getInt(cursor1.getColumnIndexOrThrow("_id"));
        i = j;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        if (cursor1 != null)
        {
            cursor1.close();
            return al;
        } else
        {
            return al;
        }
        exception;
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
    }

    private Vector _getInAppConditionValues(int i)
    {
        Cursor cursor;
        Object obj;
        Object obj1;
        obj = null;
        obj1 = null;
        cursor = ((Cursor) (obj1));
        Object obj2 = mProvider;
        cursor = ((Cursor) (obj1));
        String s = String.format("%s = ?", new Object[] {
            "condition_id_ref"
        });
        cursor = ((Cursor) (obj1));
        String s1 = Integer.toString(i);
        cursor = ((Cursor) (obj1));
        obj2 = ((BaseProvider) (obj2)).query("marketing_condition_values", new String[] {
            "value"
        }, s, new String[] {
            s1
        }, null);
_L2:
        cursor = ((Cursor) (obj2));
        if (!((Cursor) (obj2)).moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        cursor = ((Cursor) (obj2));
        s = ((Cursor) (obj2)).getString(((Cursor) (obj2)).getColumnIndexOrThrow("value"));
        obj1 = obj;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        cursor = ((Cursor) (obj2));
        obj1 = new Vector();
        cursor = ((Cursor) (obj2));
        ((Vector) (obj1)).add(s);
        obj = obj1;
        if (true) goto _L2; else goto _L1
_L1:
        if (obj2 != null)
        {
            ((Cursor) (obj2)).close();
            return ((Vector) (obj));
        } else
        {
            return ((Vector) (obj));
        }
        obj;
        if (cursor != null)
        {
            cursor.close();
        }
        throw obj;
    }

    private Vector _getInAppConditions(int i)
    {
        Cursor cursor;
        Object obj1;
        obj1 = null;
        cursor = null;
        Cursor cursor1 = mProvider.query("marketing_conditions", null, String.format("%s = ?", new Object[] {
            "rule_id_ref"
        }), new String[] {
            Integer.toString(i)
        }, null);
_L2:
        cursor = cursor1;
        if (!cursor1.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        cursor = cursor1;
        i = cursor1.getInt(cursor1.getColumnIndexOrThrow("_id"));
        cursor = cursor1;
        String s = cursor1.getString(cursor1.getColumnIndexOrThrow("attribute_name"));
        cursor = cursor1;
        String s1 = cursor1.getString(cursor1.getColumnIndexOrThrow("operator"));
        cursor = cursor1;
        Vector vector = _getInAppConditionValues(i);
        Object obj;
        obj = obj1;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        cursor = cursor1;
        obj = new Vector();
        cursor = cursor1;
        obj1 = new MarketingCondition(s, s1, vector);
        cursor = cursor1;
        ((MarketingCondition) (obj1)).setPackageName(mLocalyticsDao.getAppContext().getPackageName());
        cursor = cursor1;
        ((Vector) (obj)).add(obj1);
        obj1 = obj;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        if (cursor1 != null)
        {
            cursor1.close();
            return ((Vector) (obj1));
        } else
        {
            return ((Vector) (obj1));
        }
        exception;
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
    }

    private List _getInAppMessageMaps(String s)
    {
        String s1;
        MarketingMessage marketingmessage;
        LinkedList linkedlist;
        linkedlist = new LinkedList();
        marketingmessage = null;
        s1 = marketingmessage;
        String s2 = Long.toString(mLocalyticsDao.getCurrentTimeMillis() / 1000L);
        s1 = marketingmessage;
        String s3 = String.format("SELECT * FROM %s AS r LEFT OUTER JOIN %s AS re ON r.%s=re.%s WHERE %s > ? AND %s = ? GROUP BY r.%s;", new Object[] {
            "marketing_rules", "marketing_ruleevent", "_id", "rule_id_ref", "expiration", "event_name", "_id"
        });
        s1 = marketingmessage;
        s = mProvider.mDb.rawQuery(s3, new String[] {
            s2, s
        });
        int i = 0;
_L2:
        s1 = s;
        if (i >= s.getCount())
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = s;
        s.moveToPosition(i);
        s1 = s;
        marketingmessage = new MarketingMessage();
        s1 = s;
        marketingmessage.put("_id", Integer.valueOf(s.getInt(s.getColumnIndexOrThrow("_id"))));
        s1 = s;
        marketingmessage.put("campaign_id", Integer.valueOf(s.getInt(s.getColumnIndexOrThrow("campaign_id"))));
        s1 = s;
        marketingmessage.put("expiration", Integer.valueOf(s.getInt(s.getColumnIndexOrThrow("expiration"))));
        s1 = s;
        marketingmessage.put("display_seconds", Integer.valueOf(s.getInt(s.getColumnIndexOrThrow("display_seconds"))));
        s1 = s;
        marketingmessage.put("display_session", Integer.valueOf(s.getInt(s.getColumnIndexOrThrow("display_session"))));
        s1 = s;
        marketingmessage.put("version", s.getString(s.getColumnIndexOrThrow("version")));
        s1 = s;
        marketingmessage.put("phone_location", s.getString(s.getColumnIndexOrThrow("phone_location")));
        s1 = s;
        marketingmessage.put("phone_size_width", Integer.valueOf(s.getInt(s.getColumnIndexOrThrow("phone_size_width"))));
        s1 = s;
        marketingmessage.put("phone_size_height", Integer.valueOf(s.getInt(s.getColumnIndexOrThrow("phone_size_height"))));
        s1 = s;
        marketingmessage.put("tablet_location", s.getString(s.getColumnIndexOrThrow("tablet_location")));
        s1 = s;
        marketingmessage.put("tablet_size_width", Integer.valueOf(s.getInt(s.getColumnIndexOrThrow("tablet_size_width"))));
        s1 = s;
        marketingmessage.put("tablet_size_height", Integer.valueOf(s.getInt(s.getColumnIndexOrThrow("tablet_size_height"))));
        s1 = s;
        marketingmessage.put("time_to_display", Integer.valueOf(s.getInt(s.getColumnIndexOrThrow("time_to_display"))));
        s1 = s;
        marketingmessage.put("internet_required", Integer.valueOf(s.getInt(s.getColumnIndexOrThrow("internet_required"))));
        s1 = s;
        marketingmessage.put("ab_test", s.getString(s.getColumnIndexOrThrow("ab_test")));
        s1 = s;
        marketingmessage.put("rule_name_non_unique", s.getString(s.getColumnIndexOrThrow("rule_name_non_unique")));
        s1 = s;
        marketingmessage.put("location", s.getString(s.getColumnIndexOrThrow("location")));
        s1 = s;
        marketingmessage.put("devices", s.getString(s.getColumnIndexOrThrow("devices")));
        s1 = s;
        marketingmessage.put("control_group", Integer.valueOf(s.getInt(s.getColumnIndexOrThrow("control_group"))));
        s1 = s;
        marketingmessage.put("schema_version", Integer.valueOf(s.getInt(s.getColumnIndexOrThrow("schema_version"))));
        s1 = s;
        linkedlist.add(marketingmessage);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (s != null)
        {
            s.close();
            return linkedlist;
        } else
        {
            return linkedlist;
        }
        s;
        if (s1 != null)
        {
            s1.close();
        }
        throw s;
    }

    private SparseArray _getJavaScriptClientCallbacks(final Map attributes)
    {
        JSONException jsonexception;
        SparseArray sparsearray = new SparseArray();
        sparsearray.put(3, new _cls7());
        sparsearray.put(5, new _cls8());
        final JSONObject jsonCustomDimensions = new JSONObject();
        for (int i = 0; i < 10; i++)
        {
            try
            {
                jsonCustomDimensions.put((new StringBuilder("c")).append(i).toString(), mLocalyticsDao.getCustomDimension(i));
            }
            // Misplaced declaration of an exception variable
            catch (JSONException jsonexception)
            {
                Localytics.Log.w("[JavaScriptClient]: Failed to get custom dimension");
            }
        }

        sparsearray.put(6, new _cls9());
        sparsearray.put(7, new _cls10());
        sparsearray.put(8, new _cls11());
        return sparsearray;
    }

    private String _getRemoteFileURL(MarketingMessage marketingmessage)
    {
        String s = (String)marketingmessage.get("devices");
        if (s.compareTo("tablet") == 0)
        {
            return (String)marketingmessage.get("tablet_location");
        } else
        {
            s.compareTo("both");
            return (String)marketingmessage.get("phone_location");
        }
    }

    private int _getRuleIdFromCampaignId(int i)
    {
        Cursor cursor;
        Cursor cursor1;
        boolean flag;
        flag = false;
        cursor1 = null;
        cursor = cursor1;
        Object obj = mProvider;
        cursor = cursor1;
        String s = String.format("%s = ?", new Object[] {
            "campaign_id"
        });
        cursor = cursor1;
        String s1 = Integer.toString(i);
        cursor = cursor1;
        obj = ((BaseProvider) (obj)).query("marketing_rules", new String[] {
            "_id"
        }, s, new String[] {
            s1
        }, null);
        cursor1 = ((Cursor) (obj));
        i = ((flag) ? 1 : 0);
        cursor = cursor1;
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_108;
        }
        cursor = cursor1;
        i = cursor1.getInt(cursor1.getColumnIndexOrThrow("_id"));
        Exception exception;
        if (cursor1 != null)
        {
            cursor1.close();
            return i;
        } else
        {
            return i;
        }
        exception;
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
    }

    private String _getUnzipFileDirPath(int i)
    {
        Object obj = new StringBuilder();
        ((StringBuilder) (obj)).append(mLocalyticsDao.getAppContext().getFilesDir().getAbsolutePath());
        ((StringBuilder) (obj)).append(File.separator);
        ((StringBuilder) (obj)).append(".localytics");
        ((StringBuilder) (obj)).append(File.separator);
        ((StringBuilder) (obj)).append(mLocalyticsDao.getApiKey());
        ((StringBuilder) (obj)).append(File.separator);
        ((StringBuilder) (obj)).append(String.format("marketing_rule_%d", new Object[] {
            Integer.valueOf(i)
        }));
        obj = ((StringBuilder) (obj)).toString();
        File file = new File(((String) (obj)));
        if ((!file.exists() || !file.isDirectory()) && !file.mkdirs())
        {
            Localytics.Log.w(String.format("Could not create the directory %s for saving the decompressed file.", new Object[] {
                file.getAbsolutePath()
            }));
            return null;
        } else
        {
            return ((String) (obj));
        }
    }

    private String _getZipFileDirPath()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(mLocalyticsDao.getAppContext().getFilesDir().getAbsolutePath());
        stringbuilder.append(File.separator);
        stringbuilder.append(".localytics");
        stringbuilder.append(File.separator);
        stringbuilder.append(mLocalyticsDao.getApiKey());
        return stringbuilder.toString();
    }

    private boolean _isConnectingToInternet()
    {
        ConnectivityManager connectivitymanager = (ConnectivityManager)mLocalyticsDao.getAppContext().getSystemService("connectivity");
        if (connectivitymanager != null)
        {
            NetworkInfo anetworkinfo[] = connectivitymanager.getAllNetworkInfo();
            if (anetworkinfo != null)
            {
                int j = anetworkinfo.length;
                for (int i = 0; i < j; i++)
                {
                    if (anetworkinfo[i].getState() == android.net.NetworkInfo.State.CONNECTED)
                    {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    private boolean _isInAppMessageSatisfiedConditions(MarketingMessage marketingmessage, Map map)
    {
label0:
        {
            marketingmessage = _getInAppConditions(_getRuleIdFromCampaignId(((Integer)marketingmessage.get("campaign_id")).intValue()));
            if (marketingmessage == null)
            {
                break label0;
            }
            marketingmessage = marketingmessage.iterator();
            do
            {
                if (!marketingmessage.hasNext())
                {
                    break label0;
                }
            } while (((MarketingCondition)marketingmessage.next()).isSatisfiedByAttributes(map));
            return false;
        }
        return true;
    }

    private ContentValues _parseInAppMessage(MarketingMessage marketingmessage, Map map)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("campaign_id", Integer.valueOf(JsonHelper.getSafeIntegerFromMap(marketingmessage, "campaign_id")));
        contentvalues.put("expiration", Integer.valueOf(JsonHelper.getSafeIntegerFromMap(marketingmessage, "expiration")));
        contentvalues.put("display_seconds", Integer.valueOf(JsonHelper.getSafeIntegerFromMap(marketingmessage, "display_seconds")));
        contentvalues.put("display_session", Integer.valueOf(JsonHelper.getSafeIntegerFromMap(marketingmessage, "display_session")));
        contentvalues.put("version", Integer.valueOf(JsonHelper.getSafeIntegerFromMap(marketingmessage, "version")));
        contentvalues.put("phone_location", JsonHelper.getSafeStringFromMap(marketingmessage, "phone_location"));
        Map map1 = JsonHelper.getSafeMapFromMap(marketingmessage, "phone_size");
        contentvalues.put("phone_size_width", Integer.valueOf(JsonHelper.getSafeIntegerFromMap(map1, "width")));
        contentvalues.put("phone_size_height", Integer.valueOf(JsonHelper.getSafeIntegerFromMap(map1, "height")));
        map1 = JsonHelper.getSafeMapFromMap(marketingmessage, "tablet_size");
        contentvalues.put("tablet_location", JsonHelper.getSafeStringFromMap(marketingmessage, "tablet_location"));
        contentvalues.put("tablet_size_width", Integer.valueOf(JsonHelper.getSafeIntegerFromMap(map1, "width")));
        contentvalues.put("tablet_size_height", Integer.valueOf(JsonHelper.getSafeIntegerFromMap(map1, "height")));
        contentvalues.put("time_to_display", Integer.valueOf(1));
        int i;
        if (JsonHelper.getSafeBooleanFromMap(marketingmessage, "internet_required"))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        contentvalues.put("internet_required", Integer.valueOf(i));
        contentvalues.put("ab_test", JsonHelper.getSafeStringFromMap(marketingmessage, "ab"));
        contentvalues.put("rule_name_non_unique", JsonHelper.getSafeStringFromMap(marketingmessage, "rule_name"));
        contentvalues.put("rule_name", UUID.randomUUID().toString());
        contentvalues.put("location", JsonHelper.getSafeStringFromMap(marketingmessage, "location"));
        contentvalues.put("devices", JsonHelper.getSafeStringFromMap(marketingmessage, "devices"));
        contentvalues.put("control_group", Integer.valueOf(JsonHelper.getSafeIntegerFromMap(marketingmessage, "control_group")));
        if (map != null)
        {
            int j = JsonHelper.getSafeIntegerFromMap(map, "schema_version");
            if (j > 0)
            {
                contentvalues.put("schema_version", Integer.valueOf(j));
            }
        }
        return contentvalues;
    }

    private MarketingMessage _retrieveDisplayingCandidate(List list, Map map)
    {
        Object obj = null;
        Iterator iterator = list.iterator();
        list = obj;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            MarketingMessage marketingmessage = (MarketingMessage)iterator.next();
            boolean flag;
            if (((Integer)marketingmessage.get("internet_required")).intValue() == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if ((!flag || _isConnectingToInternet()) && _isInAppMessageSatisfiedConditions(marketingmessage, map))
            {
                list = marketingmessage;
            }
        } while (true);
        if (list == null || !_updateDisplayingCandidate(list))
        {
            return null;
        } else
        {
            return list;
        }
    }

    private void _saveInAppConditions(long l, List list)
    {
        if (list == null)
        {
            return;
        }
        long al[] = _getConditionIdFromRuleId(l);
        int k = al.length;
        for (int i = 0; i < k; i++)
        {
            long l1 = al[i];
            mProvider.remove("marketing_condition_values", String.format("%s = ?", new Object[] {
                "condition_id_ref"
            }), new String[] {
                Long.toString(l1)
            });
        }

        mProvider.remove("marketing_conditions", String.format("%s = ?", new Object[] {
            "rule_id_ref"
        }), new String[] {
            Long.toString(l)
        });
        for (list = list.iterator(); list.hasNext();)
        {
            List list1 = (List)list.next();
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("attribute_name", (String)list1.get(0));
            contentvalues.put("operator", (String)list1.get(1));
            contentvalues.put("rule_id_ref", Long.valueOf(l));
            long l2 = mProvider.insert("marketing_conditions", contentvalues);
            int j = 2;
            while (j < list1.size()) 
            {
                ContentValues contentvalues1 = new ContentValues();
                contentvalues1.put("value", JsonHelper.getSafeStringFromValue(list1.get(j)));
                contentvalues1.put("condition_id_ref", Long.valueOf(l2));
                mProvider.insert("marketing_condition_values", contentvalues1);
                j++;
            }
        }

    }

    private void _tagAmpActionEventForControlGroup(MarketingMessage marketingmessage)
    {
        TreeMap treemap = new TreeMap();
        String s = marketingmessage.get("campaign_id").toString();
        String s1 = marketingmessage.get("rule_name_non_unique").toString();
        String s2 = marketingmessage.get("schema_version").toString();
        marketingmessage = (String)marketingmessage.get("ab_test");
        if (!TextUtils.isEmpty(marketingmessage))
        {
            treemap.put("ampAB", marketingmessage);
        }
        treemap.put("ampAction", "control");
        treemap.put("type", "Control");
        treemap.put("ampCampaignId", s);
        treemap.put("ampCampaign", s1);
        treemap.put("Schema Version - Client", "3");
        treemap.put("Schema Version - Server", s2);
        mLocalyticsDao.tagEvent("ampView", treemap);
    }

    private int _timeStringToSeconds(String s)
    {
        int i;
        int j;
        try
        {
            s = s.split(":");
            i = Integer.valueOf(s[0]).intValue();
            j = Integer.valueOf(s[1]).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return -1;
        }
        return i * 3600 + j * 60;
    }

    private boolean _updateDisplayingCandidate(MarketingMessage marketingmessage)
    {
        String s = null;
        int i = ((Integer)marketingmessage.get("_id")).intValue();
        String s2 = _getZipFileDirPath();
        String s1 = _getUnzipFileDirPath(i);
        boolean flag3 = _getRemoteFileURL(marketingmessage).endsWith(".zip");
        boolean flag2 = _doesCreativeExist(i, flag3);
        boolean flag1 = flag2;
        boolean flag = flag1;
        if (!flag2)
        {
            String s3 = MarketingDownloader.getRemoteFileURL(marketingmessage);
            String s4 = MarketingDownloader.getLocalFileURL(i, flag3, mLocalyticsDao.getAppContext(), mLocalyticsDao.getApiKey());
            flag = flag1;
            if (!TextUtils.isEmpty(s3))
            {
                flag = flag1;
                if (!TextUtils.isEmpty(s4))
                {
                    if (!TextUtils.isEmpty(mFileDownloader.downloadFile(s3, s4, true, mLocalyticsDao.getProxy())))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                }
            }
        }
        if (!flag)
        {
            return false;
        }
        if (flag3)
        {
            if (_decompressZipFile(s2, s1, String.format("amp_rule_%d.zip", new Object[] {
    Integer.valueOf(i)
})))
            {
                s = (new StringBuilder("file://")).append(s1).append(File.separator).append("index.html").toString();
            }
        } else
        {
            s = (new StringBuilder("file://")).append(s1).append(File.separator).append("index.html").toString();
        }
        if (TextUtils.isEmpty(s))
        {
            return false;
        }
        s2 = (String)marketingmessage.get("devices");
        int j;
        if (s2.equals("tablet"))
        {
            i = ((Integer)marketingmessage.get("tablet_size_width")).intValue();
            j = ((Integer)marketingmessage.get("tablet_size_height")).intValue();
        } else
        {
            s2.equals("both");
            i = ((Integer)marketingmessage.get("phone_size_width")).intValue();
            j = ((Integer)marketingmessage.get("phone_size_height")).intValue();
        }
        marketingmessage.put("html_url", s);
        marketingmessage.put("base_path", s1);
        marketingmessage.put("display_width", Float.valueOf(i));
        marketingmessage.put("display_height", Float.valueOf(j));
        return true;
    }

    boolean _additionalFCDatesAndTimesRulesValidation(List list, SimpleDateFormat simpledateformat)
    {
        if (list == null) goto _L2; else goto _L1
_L1:
        list = list.iterator();
_L5:
        if (!list.hasNext()) goto _L2; else goto _L3
_L3:
        Map map = (Map)list.next();
        if (!simpledateformat.parse((String)map.get("start")).after(simpledateformat.parse((String)map.get("end")))) goto _L5; else goto _L4
_L4:
        throw new Exception();
_L7:
        return false;
_L2:
        return true;
        list;
        if (true) goto _L7; else goto _L6
_L6:
    }

    boolean _additionalFCDisplayFrequencyRulesValidation(List list)
    {
label0:
        {
            if (list == null)
            {
                break label0;
            }
            list = list.iterator();
            Map map;
            do
            {
                if (!list.hasNext())
                {
                    break label0;
                }
                map = (Map)list.next();
            } while (((Integer)map.get("days")).intValue() > 0 && ((Integer)map.get("count")).intValue() > 0);
            return false;
        }
        return true;
    }

    boolean _additionalFCWeekdaysRulesValidation(List list)
    {
label0:
        {
            if (list == null)
            {
                break label0;
            }
            if (list.size() > 7)
            {
                return false;
            }
            list = list.iterator();
            Integer integer;
            do
            {
                if (!list.hasNext())
                {
                    break label0;
                }
                integer = (Integer)list.next();
            } while (integer.intValue() >= 0 && integer.intValue() <= 6);
            return false;
        }
        return true;
    }

    Map _augmentBlackoutRule(Map map)
    {
        HashMap hashmap = new HashMap(map);
        boolean flag = map.containsKey("dates");
        boolean flag1 = map.containsKey("weekdays");
        boolean flag2 = map.containsKey("times");
        if ((flag || flag1) && !flag2)
        {
            hashmap.put("times", new ArrayList(AUGMENTED_BLACKOUT_TIMES_RULE));
            return hashmap;
        }
        if (flag2 && !flag && !flag1)
        {
            hashmap.put("weekdays", new ArrayList(AUGMENTED_BLACKOUT_WEEKDAYS_RULE));
        }
        return hashmap;
    }

    boolean _checkFrequencyCappingRuleArray(List list, String as[])
    {
        if (list != null)
        {
            if (list.size() <= 0)
            {
                return false;
            }
            if (as.length > 0)
            {
                int j = as.length;
                int i = 0;
                do
                {
                    if (i >= j)
                    {
                        break;
                    }
                    String s = as[i];
                    for (Iterator iterator = list.iterator(); iterator.hasNext();)
                    {
                        if (!((Map)iterator.next()).containsKey(s))
                        {
                            return false;
                        }
                    }

                    i++;
                } while (true);
            }
        }
        return true;
    }

    boolean _deleteFrequencyCappingRule(Integer integer)
    {
        try
        {
            mProvider.remove("frequency_capping_rules", String.format("%s = ?", new Object[] {
                "campaign_id"
            }), new String[] {
                String.valueOf(integer)
            });
        }
        // Misplaced declaration of an exception variable
        catch (Integer integer)
        {
            return false;
        }
        return true;
    }

    List _filterInAppMessagesDisqualifiedByFrequencyCappingRules(List list)
    {
        HashSet hashset = new HashSet();
        for (Iterator iterator = list.iterator(); iterator.hasNext(); hashset.add((Integer)((MarketingMessage)iterator.next()).get("campaign_id"))) { }
        if (hashset.size() > 0)
        {
            hashset.removeAll(_getDisqualifiedCampaigns(FrequencyCappingFilter.MAX_COUNT, hashset));
        }
        if (hashset.size() > 0)
        {
            hashset.removeAll(_getDisqualifiedCampaigns(FrequencyCappingFilter.FREQUENCY, hashset));
        }
        if (hashset.size() > 0)
        {
            hashset.removeAll(_getDisqualifiedCampaigns(FrequencyCappingFilter.BLACKOUT, hashset));
        }
        if (hashset.size() > 0)
        {
            hashset.removeAll(_getGloballyDisqualifiedCampaigns(FrequencyCappingFilter.FREQUENCY, hashset));
        }
        if (hashset.size() > 0)
        {
            hashset.removeAll(_getGloballyDisqualifiedCampaigns(FrequencyCappingFilter.BLACKOUT, hashset));
        }
        LinkedList linkedlist = new LinkedList();
        if (hashset.size() > 0)
        {
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                MarketingMessage marketingmessage = (MarketingMessage)list.next();
                if (hashset.contains(Integer.valueOf(((Integer)marketingmessage.get("campaign_id")).intValue())))
                {
                    linkedlist.add(marketingmessage);
                }
            } while (true);
        }
        return linkedlist;
    }

    Set _getDisqualifiedCampaigns(FrequencyCappingFilter frequencycappingfilter, Set set)
    {
        static class _cls19
        {

            static final int $SwitchMap$com$localytics$android$InAppManager$FrequencyCappingFilter[];

            static 
            {
                $SwitchMap$com$localytics$android$InAppManager$FrequencyCappingFilter = new int[FrequencyCappingFilter.values().length];
                try
                {
                    $SwitchMap$com$localytics$android$InAppManager$FrequencyCappingFilter[FrequencyCappingFilter.MAX_COUNT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
                try
                {
                    $SwitchMap$com$localytics$android$InAppManager$FrequencyCappingFilter[FrequencyCappingFilter.FREQUENCY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$localytics$android$InAppManager$FrequencyCappingFilter[FrequencyCappingFilter.BLACKOUT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
            }
        }

        switch (_cls19..SwitchMap.com.localytics.android.InAppManager.FrequencyCappingFilter[frequencycappingfilter.ordinal()])
        {
        case 1: // '\001'
            return _getCampaignIdsFromFrequencyCappingQuery(String.format("SELECT fc.%s FROM %s AS fc JOIN %s AS cd ON fc.%s=cd.%s WHERE cd.%s in (%s) GROUP BY fc.%s HAVING count(*) >= fc.%s;", new Object[] {
                "campaign_id", "frequency_capping_rules", "campaigns_displayed", "campaign_id", "campaign_id", "campaign_id", TextUtils.join(",", set), "campaign_id", "max_display_count"
            }));

        case 2: // '\002'
            return _getCampaignIdsFromFrequencyCappingQuery(String.format("SELECT DISTINCT fc.%s FROM %s AS fc JOIN %s AS df ON fc.%s=df.%s JOIN %s AS cd ON fc.%s=cd.%s WHERE (cd.%s BETWEEN datetime('%s','-'||df.%s||' days') AND datetime('%s')) AND fc.%s in (%s) GROUP BY df.%s HAVING count(cd.%s) >= df.%s;", new Object[] {
                "campaign_id", "frequency_capping_rules", "frequency_capping_display_frequencies", "_id", "frequency_id", "campaigns_displayed", "campaign_id", "campaign_id", "date", mLocalyticsDao.getTimeStringForSQLite(), 
                "days", mLocalyticsDao.getTimeStringForSQLite(), "campaign_id", TextUtils.join(",", set), "_id", "date", "count"
            }));

        case 3: // '\003'
            frequencycappingfilter = mLocalyticsDao.getCalendar();
            int i = frequencycappingfilter.get(7);
            int j = (frequencycappingfilter.get(11) * 60 + frequencycappingfilter.get(12)) * 60 + frequencycappingfilter.get(13);
            frequencycappingfilter = _getCampaignIdsFromFrequencyCappingQuery(String.format("SELECT fc.%s FROM %s AS fc, %s AS d, %s AS t WHERE ((fc.%s=t.%s) AND (fc.%s=d.%s)) AND (d.%s=t.%s) AND (datetime('%s','localtime') BETWEEN d.%s and d.%s) AND (? BETWEEN t.%s AND t.%s) AND fc.%s IN (%s);", new Object[] {
                "campaign_id", "frequency_capping_rules", "frequency_capping_blackout_dates", "frequency_capping_blackout_times", "_id", "frequency_id", "_id", "frequency_id", "rule_group_id", "rule_group_id", 
                mLocalyticsDao.getTimeStringForSQLite(), "start", "end", "start", "end", "campaign_id", TextUtils.join(",", set)
            }), new String[] {
                String.valueOf(j)
            });
            frequencycappingfilter.addAll(_getCampaignIdsFromFrequencyCappingQuery(String.format("SELECT fc.%s FROM %s AS fc, %s AS w, %s AS t WHERE ((fc.%s=t.%s) AND (fc.%s=w.%s)) AND (w.%s=t.%s) AND (w.%s=?)  AND (? BETWEEN t.%s AND t.%s) AND fc.%s IN (%s);", new Object[] {
                "campaign_id", "frequency_capping_rules", "frequency_capping_blackout_weekdays", "frequency_capping_blackout_times", "_id", "frequency_id", "_id", "frequency_id", "rule_group_id", "rule_group_id", 
                "day", "start", "end", "campaign_id", TextUtils.join(",", set)
            }), new String[] {
                String.valueOf(i - 1), String.valueOf(j)
            }));
            return frequencycappingfilter;
        }
        return new HashSet();
    }

    Set _getGloballyDisqualifiedCampaigns(FrequencyCappingFilter frequencycappingfilter, Set set)
    {
        Object obj;
        int i;
        i = -1;
        obj = null;
        Cursor cursor = mProvider.query("frequency_capping_rules", null, "campaign_id = ?", new String[] {
            "-1"
        }, null);
        Object obj1;
        obj1 = cursor;
        obj = obj1;
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_70;
        }
        obj = obj1;
        i = ((Cursor) (obj1)).getInt(((Cursor) (obj1)).getColumnIndexOrThrow("_id"));
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        break MISSING_BLOCK_LABEL_98;
        frequencycappingfilter;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw frequencycappingfilter;
        if (i == -1) goto _L2; else goto _L1
_L1:
        obj = obj1;
        _cls19..SwitchMap.com.localytics.android.InAppManager.FrequencyCappingFilter[frequencycappingfilter.ordinal()];
        JVM INSTR lookupswitch 2: default 717
    //                   2: 140
    //                   3: 322;
           goto _L3 _L4 _L5
_L3:
        break MISSING_BLOCK_LABEL_681;
_L4:
        obj = obj1;
        cursor = mProvider.mDb.rawQuery(String.format("SELECT df.%s FROM %s AS fc JOIN %s AS df ON fc.%s = df.%s JOIN %s AS cd WHERE cd.%s = 0 AND fc.%s = ? AND (cd.%s BETWEEN datetime('%s','-'||df.%s||' days') AND datetime('%s')) GROUP BY df.%s HAVING count(cd.%s) >= df.%s;", new Object[] {
            "_id", "frequency_capping_rules", "frequency_capping_display_frequencies", "_id", "frequency_id", "campaigns_displayed", "ignore_global", "campaign_id", "date", mLocalyticsDao.getTimeStringForSQLite(), 
            "days", mLocalyticsDao.getTimeStringForSQLite(), "_id", "date", "count"
        }), new String[] {
            "-1"
        });
        frequencycappingfilter = cursor;
        obj1 = frequencycappingfilter;
        obj = frequencycappingfilter;
        if (cursor.getCount() <= 0)
        {
            break MISSING_BLOCK_LABEL_681;
        }
        obj = frequencycappingfilter;
        set = _getIgnoresGlobalCampaigns(false, set);
        if (frequencycappingfilter != null)
        {
            frequencycappingfilter.close();
        }
        return set;
_L5:
        obj = obj1;
        frequencycappingfilter = mLocalyticsDao.getCalendar();
        obj = obj1;
        int j = frequencycappingfilter.get(7);
        obj = obj1;
        int k = (frequencycappingfilter.get(11) * 60 + frequencycappingfilter.get(12)) * 60 + frequencycappingfilter.get(13);
        obj = obj1;
        obj1 = mProvider.mDb.rawQuery(String.format("SELECT * FROM %s AS d, %s AS t WHERE ((d.%s=?) AND (t.%s=?)) AND (d.%s=t.%s) AND (datetime('%s','localtime') BETWEEN d.%s and d.%s) AND (? BETWEEN t.%s AND t.%s);", new Object[] {
            "frequency_capping_blackout_dates", "frequency_capping_blackout_times", "frequency_id", "frequency_id", "rule_group_id", "rule_group_id", mLocalyticsDao.getTimeStringForSQLite(), "start", "end", "start", 
            "end"
        }), new String[] {
            String.valueOf(i), String.valueOf(i), String.valueOf(k)
        });
        frequencycappingfilter = ((FrequencyCappingFilter) (obj1));
        obj = frequencycappingfilter;
        int l = ((Cursor) (obj1)).getCount();
        obj = frequencycappingfilter;
        frequencycappingfilter.close();
        obj = frequencycappingfilter;
        frequencycappingfilter = mProvider.mDb.rawQuery(String.format("SELECT * FROM %s AS w, %s AS t WHERE ((w.%s=?) AND (t.%s=?)) AND (w.%s=t.%s) AND (w.%s=?) AND (? BETWEEN t.%s AND t.%s);", new Object[] {
            "frequency_capping_blackout_weekdays", "frequency_capping_blackout_times", "frequency_id", "frequency_id", "rule_group_id", "rule_group_id", "day", "start", "end"
        }), new String[] {
            String.valueOf(i), String.valueOf(i), String.valueOf(j - 1), String.valueOf(k)
        });
        obj1 = frequencycappingfilter;
        obj = frequencycappingfilter;
        if (frequencycappingfilter.getCount() + l <= 0)
        {
            break MISSING_BLOCK_LABEL_681;
        }
        obj = frequencycappingfilter;
        set = _getIgnoresGlobalCampaigns(false, set);
        if (frequencycappingfilter != null)
        {
            frequencycappingfilter.close();
        }
        return set;
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
          goto _L2
        frequencycappingfilter;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw frequencycappingfilter;
_L2:
        return new HashSet();
    }

    Set _getIgnoresGlobalCampaigns(boolean flag, Set set)
    {
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        return _getCampaignIdsFromFrequencyCappingQuery(String.format("SELECT %s FROM %s WHERE %s = %s AND %s in (%s);", new Object[] {
            "campaign_id", "frequency_capping_rules", "ignore_global", Integer.valueOf(i), "campaign_id", TextUtils.join(",", set)
        }));
    }

    MarketingMessage _getQualifiedInAppMessageForTrigger(String s, Map map)
    {
        if (Constants.isTestModeEnabled())
        {
            return null;
        }
        String s1 = s;
        if (s.equals("open"))
        {
            if (!mSessionStartInAppMessageShown && !Constants.isTestModeEnabled())
            {
                s1 = "AMP Loaded";
                mSessionStartInAppMessageShown = true;
            } else
            {
                return null;
            }
        }
        List list = _getInAppMessageMaps(s1);
        s = list;
        if (list.size() == 0)
        {
            Context context = mLocalyticsDao.getAppContext();
            s = list;
            if (s1.startsWith(context.getPackageName()))
            {
                s = _getInAppMessageMaps(s1.substring(context.getPackageName().length() + 1, s1.length()));
            }
        }
        return _retrieveDisplayingCandidate(_filterInAppMessagesDisqualifiedByFrequencyCappingRules(s), map);
    }

    boolean _handleTestCampaigns()
    {
        if (mTestCampaignsListAdapter != null)
        {
            (new _cls1()).start();
            mTestCampaignsListAdapter = null;
            return true;
        } else
        {
            return false;
        }
    }

    void _inAppMessageTrigger(String s, Map map)
    {
        s = _getQualifiedInAppMessageForTrigger(s, map);
        if (s != null)
        {
            Integer integer = (Integer)s.get("campaign_id");
            Integer integer1 = (Integer)s.get("control_group");
            if (integer1 != null && integer1.intValue() == 1)
            {
                if (_setInAppMessageAsDisplayed(integer.intValue()))
                {
                    _tagAmpActionEventForControlGroup(s);
                }
                return;
            }
            _tryDisplayingInAppCampaign(s, map);
        }
    }

    void _processMarketingObject(Map map, Map map1)
    {
        Object obj = new ArrayList();
        Object obj1 = map.get("amp");
        if (obj1 != null)
        {
            for (obj1 = JsonHelper.toList((JSONArray)JsonHelper.toJSON(obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((List) (obj)).add(new MarketingMessage((Map)((Iterator) (obj1)).next()))) { }
        }
        _removeDeactivatedInAppMessages(((List) (obj)));
        _validateAndStoreFrequencyCappingRule(map, Integer.valueOf(-1));
        for (map = ((List) (obj)).iterator(); map.hasNext(); _validateAndStoreFrequencyCappingRule(((Map) (obj)), (Integer)((MarketingMessage) (obj)).get("campaign_id")))
        {
            obj = (MarketingMessage)map.next();
            _saveInAppMessage(((MarketingMessage) (obj)), map1);
        }

    }

    void _removeDeactivatedInAppMessages(List list)
    {
        ArrayList arraylist;
        Vector vector;
        arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add(Integer.valueOf(JsonHelper.getSafeIntegerFromMap((MarketingMessage)list.next(), "campaign_id")))) { }
        _deleteFrequencyCappingRule(Integer.valueOf(-1));
        vector = new Vector();
        list = null;
        Cursor cursor = mProvider.query("marketing_rules", null, null, null, null);
        int i = 0;
_L2:
        list = cursor;
        if (i >= cursor.getCount())
        {
            break; /* Loop/switch isn't completed */
        }
        list = cursor;
        cursor.moveToPosition(i);
        list = cursor;
        if (arraylist.contains(Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("campaign_id")))))
        {
            break MISSING_BLOCK_LABEL_655;
        }
        list = cursor;
        MarketingMessage marketingmessage1 = new MarketingMessage();
        list = cursor;
        marketingmessage1.put("_id", Integer.valueOf(cursor.getColumnIndexOrThrow("_id")));
        list = cursor;
        marketingmessage1.put("campaign_id", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("campaign_id"))));
        list = cursor;
        marketingmessage1.put("expiration", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("expiration"))));
        list = cursor;
        marketingmessage1.put("display_seconds", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("display_seconds"))));
        list = cursor;
        marketingmessage1.put("display_session", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("display_session"))));
        list = cursor;
        marketingmessage1.put("version", cursor.getString(cursor.getColumnIndexOrThrow("version")));
        list = cursor;
        marketingmessage1.put("phone_location", cursor.getString(cursor.getColumnIndexOrThrow("phone_location")));
        list = cursor;
        marketingmessage1.put("phone_size_width", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("phone_size_width"))));
        list = cursor;
        marketingmessage1.put("phone_size_height", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("phone_size_height"))));
        list = cursor;
        marketingmessage1.put("tablet_location", cursor.getString(cursor.getColumnIndexOrThrow("tablet_location")));
        list = cursor;
        marketingmessage1.put("tablet_size_width", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("tablet_size_width"))));
        list = cursor;
        marketingmessage1.put("tablet_size_height", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("tablet_size_height"))));
        list = cursor;
        marketingmessage1.put("time_to_display", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("time_to_display"))));
        list = cursor;
        marketingmessage1.put("internet_required", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("internet_required"))));
        list = cursor;
        marketingmessage1.put("ab_test", cursor.getString(cursor.getColumnIndexOrThrow("ab_test")));
        list = cursor;
        marketingmessage1.put("rule_name_non_unique", cursor.getString(cursor.getColumnIndexOrThrow("rule_name_non_unique")));
        list = cursor;
        marketingmessage1.put("location", cursor.getString(cursor.getColumnIndexOrThrow("location")));
        list = cursor;
        marketingmessage1.put("devices", cursor.getString(cursor.getColumnIndexOrThrow("devices")));
        list = cursor;
        vector.add(marketingmessage1);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (cursor != null)
        {
            cursor.close();
        }
        break MISSING_BLOCK_LABEL_690;
        Exception exception;
        exception;
        if (list != null)
        {
            list.close();
        }
        throw exception;
        MarketingMessage marketingmessage;
        for (list = vector.iterator(); list.hasNext(); _deleteFrequencyCappingRule((Integer)marketingmessage.get("campaign_id")))
        {
            marketingmessage = (MarketingMessage)list.next();
            _destroyLocalInAppMessage(marketingmessage);
        }

        mProvider.vacuumIfNecessary();
        return;
    }

    boolean _saveFrequencyCappingRule(Map map, Integer integer)
    {
        mProvider.mDb.beginTransaction();
        int i = (int)_saveFrequencyCappingRuleBase(map, integer);
        integer = (List)map.get("display_frequencies");
        boolean flag;
        if (i > 0 && _saveFrequencyCappingRuleDisplayFrequency(integer, Integer.valueOf(i)))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        map = (List)map.get("blackout_rules");
        boolean flag1;
        if (flag && _saveFrequencyCappingRuleBlackout(map, Integer.valueOf(i)))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            mProvider.mDb.setTransactionSuccessful();
        }
        mProvider.mDb.endTransaction();
        return flag1;
    }

    long _saveFrequencyCappingRuleBase(Map map, Integer integer)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("campaign_id", integer);
        if (integer.intValue() != -1)
        {
            contentvalues.put("max_display_count", (Integer)map.get("max_display_count"));
            contentvalues.put("ignore_global", (Integer)map.get("ignore_global"));
        } else
        {
            contentvalues.putNull("max_display_count");
            contentvalues.putNull("ignore_global");
        }
        return mProvider.mDb.replace("frequency_capping_rules", null, contentvalues);
    }

    boolean _saveFrequencyCappingRuleBlackout(List list, Integer integer)
    {
        if (list != null)
        {
            int i = 0;
            for (list = list.iterator(); list.hasNext();)
            {
                Map map = _augmentBlackoutRule((Map)list.next());
                if (!_saveFrequencyCappingRuleBlackoutDates((List)map.get("dates"), integer, Integer.valueOf(i)))
                {
                    return false;
                }
                if (!_saveFrequencyCappingRuleBlackoutWeekdays((List)map.get("weekdays"), integer, Integer.valueOf(i)))
                {
                    return false;
                }
                if (!_saveFrequencyCappingRuleBlackoutTimes((List)map.get("times"), integer, Integer.valueOf(i)))
                {
                    return false;
                }
                i++;
            }

        }
        return true;
    }

    boolean _saveFrequencyCappingRuleBlackoutDates(List list, Integer integer, Integer integer1)
    {
        if (list != null)
        {
            for (list = list.iterator(); list.hasNext();)
            {
                Map map = (Map)list.next();
                try
                {
                    mProvider.mDb.execSQL(String.format("INSERT INTO %s VALUES (?, ?, datetime(?,'start of day'), datetime(?,'start of day','1 day','-1 second'));", new Object[] {
                        "frequency_capping_blackout_dates"
                    }), new Object[] {
                        integer, integer1, map.get("start"), map.get("end")
                    });
                }
                // Misplaced declaration of an exception variable
                catch (List list)
                {
                    return false;
                }
            }

        }
        return true;
    }

    boolean _saveFrequencyCappingRuleBlackoutTimes(List list, Integer integer, Integer integer1)
    {
label0:
        {
            if (list == null)
            {
                break label0;
            }
            list = list.iterator();
            ContentValues contentvalues;
            do
            {
                if (!list.hasNext())
                {
                    break label0;
                }
                Object obj = (Map)list.next();
                Integer integer2 = Integer.valueOf(_timeStringToSeconds((String)((Map) (obj)).get("start")));
                obj = Integer.valueOf(_timeStringToSeconds((String)((Map) (obj)).get("end")));
                if (integer2.intValue() == -1 || ((Integer) (obj)).intValue() == -1)
                {
                    return false;
                }
                contentvalues = new ContentValues();
                contentvalues.put("frequency_id", integer);
                contentvalues.put("rule_group_id", integer1);
                contentvalues.put("start", integer2);
                contentvalues.put("end", Integer.valueOf(((Integer) (obj)).intValue() + 59));
            } while (mProvider.insert("frequency_capping_blackout_times", contentvalues) > 0L);
            return false;
        }
        return true;
    }

    boolean _saveFrequencyCappingRuleBlackoutWeekdays(List list, Integer integer, Integer integer1)
    {
label0:
        {
            if (list == null)
            {
                break label0;
            }
            list = list.iterator();
            ContentValues contentvalues;
            do
            {
                if (!list.hasNext())
                {
                    break label0;
                }
                Integer integer2 = (Integer)list.next();
                contentvalues = new ContentValues();
                contentvalues.put("frequency_id", integer);
                contentvalues.put("rule_group_id", integer1);
                contentvalues.put("day", integer2);
            } while (mProvider.insert("frequency_capping_blackout_weekdays", contentvalues) > 0L);
            return false;
        }
        return true;
    }

    boolean _saveFrequencyCappingRuleDisplayFrequency(List list, Integer integer)
    {
label0:
        {
            if (list == null)
            {
                break label0;
            }
            list = list.iterator();
            ContentValues contentvalues;
            do
            {
                if (!list.hasNext())
                {
                    break label0;
                }
                Map map = (Map)list.next();
                contentvalues = new ContentValues();
                contentvalues.put("frequency_id", integer);
                contentvalues.put("count", (Integer)map.get("count"));
                contentvalues.put("days", (Integer)map.get("days"));
            } while (mProvider.insert("frequency_capping_display_frequencies", contentvalues) > 0L);
            return false;
        }
        return true;
    }

    int _saveInAppMessage(MarketingMessage marketingmessage, Map map)
    {
        Object obj;
        int i;
        int j;
        int k;
        if (!_validateInAppMessage(marketingmessage))
        {
            return 0;
        }
        k = JsonHelper.getSafeIntegerFromMap(marketingmessage, "campaign_id");
        i = 0;
        j = 0;
        obj = null;
        Cursor cursor1 = mProvider.query("marketing_rules", PROJECTION_IN_APP_RULE_RECORD, String.format("%s = ?", new Object[] {
            "campaign_id"
        }), new String[] {
            Integer.toString(k)
        }, null);
        Cursor cursor;
        cursor = cursor1;
        obj = cursor;
        if (!cursor1.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_129;
        }
        obj = cursor;
        i = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
        obj = cursor;
        j = cursor.getInt(cursor.getColumnIndexOrThrow("version"));
        if (cursor != null)
        {
            cursor.close();
        }
        break MISSING_BLOCK_LABEL_157;
        marketingmessage;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw marketingmessage;
        if (i > 0)
        {
            Localytics.Log.w(String.format("Existing in-app rule already exists for this campaign\n\t campaignID = %d\n\t ruleID = %d", new Object[] {
                Integer.valueOf(k), Integer.valueOf(i)
            }));
            if (j >= JsonHelper.getSafeIntegerFromMap(marketingmessage, "version"))
            {
                Localytics.Log.w(String.format("No update needed. Campaign version has not been updated\n\t version: %d", new Object[] {
                    Integer.valueOf(j)
                }));
                return 0;
            }
            _destroyLocalInAppMessage(marketingmessage);
        } else
        {
            Localytics.Log.w("In-app campaign not found. Creating a new one.");
        }
        map = _parseInAppMessage(marketingmessage, map);
        i = (int)mProvider.insert("marketing_rules", map);
        if (i <= 0) goto _L2; else goto _L1
_L1:
        _saveInAppConditions(i, JsonHelper.getSafeListFromMap(marketingmessage, "conditions"));
        map = null;
        obj = JsonHelper.toList((JSONArray)JsonHelper.toJSON(marketingmessage.get("display_events")));
        map = ((Map) (obj));
_L4:
        if (map != null)
        {
            _bindRuleToEvents(i, map);
        }
_L2:
        if (i > 0 && !Constants.isTestModeEnabled())
        {
            map = MarketingDownloader.getRemoteFileURL(marketingmessage);
            if (!TextUtils.isEmpty(map))
            {
                marketingmessage = MarketingDownloader.getLocalFileURL(i, map.endsWith(".zip"), mLocalyticsDao.getAppContext(), mLocalyticsDao.getApiKey());
            } else
            {
                marketingmessage = "";
            }
            if (!TextUtils.isEmpty(map) && !TextUtils.isEmpty(marketingmessage))
            {
                Localytics.Log.v(String.format("Saving in-app message with remoteURL = %s and localUrl = %s", new Object[] {
                    map, marketingmessage
                }));
                mFileDownloader.downloadFile(map, marketingmessage, true, mLocalyticsDao.getProxy());
            }
        }
        return i;
        JSONException jsonexception;
        jsonexception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    boolean _setInAppMessageAsDisplayed(int i)
    {
        Cursor cursor;
        Cursor cursor1;
        cursor1 = null;
        cursor = cursor1;
        Object obj = mProvider;
        cursor = cursor1;
        String s = String.format("%s = ?", new Object[] {
            "campaign_id"
        });
        cursor = cursor1;
        obj = ((BaseProvider) (obj)).query("frequency_capping_rules", new String[] {
            "ignore_global"
        }, s, new String[] {
            String.valueOf(i)
        }, null);
        cursor1 = ((Cursor) (obj));
        cursor = cursor1;
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_168;
        }
        cursor = cursor1;
        int j = cursor1.getInt(cursor1.getColumnIndex("ignore_global"));
        cursor = cursor1;
        mProvider.mDb.execSQL(String.format("INSERT INTO %s VALUES (?, datetime('%s'), ?);", new Object[] {
            "campaigns_displayed", mLocalyticsDao.getTimeStringForSQLite()
        }), new Integer[] {
            Integer.valueOf(i), Integer.valueOf(j)
        });
        if (cursor1 != null)
        {
            cursor1.close();
        }
        return true;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        break MISSING_BLOCK_LABEL_194;
        Exception exception;
        exception;
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
        return false;
    }

    boolean _setInAppMessageAsNotDisplayed(int i)
    {
        Cursor cursor;
        Cursor cursor1;
        String s;
        s = String.valueOf(i);
        cursor1 = null;
        cursor = cursor1;
        Object obj = mProvider;
        cursor = cursor1;
        String s1 = String.format("%s = ?", new Object[] {
            "campaign_id"
        });
        cursor = cursor1;
        String s2 = String.format("%s DESC", new Object[] {
            "date"
        });
        cursor = cursor1;
        obj = ((BaseProvider) (obj)).query("campaigns_displayed", new String[] {
            "date"
        }, s1, new String[] {
            s
        }, s2);
        cursor1 = ((Cursor) (obj));
        cursor = cursor1;
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_199;
        }
        cursor = cursor1;
        obj = cursor1.getString(cursor1.getColumnIndex("date"));
        cursor = cursor1;
        i = mProvider.remove("campaigns_displayed", String.format("%s = ? AND %s = ?", new Object[] {
            "campaign_id", "date"
        }), new String[] {
            s, obj
        });
        boolean flag;
        if (i > 0)
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
        break MISSING_BLOCK_LABEL_225;
        Exception exception;
        exception;
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
        return false;
    }

    void _showInAppTest()
    {
        if (mFragmentManager == null)
        {
            return;
        }
        if (mFragmentManager.findFragmentByTag("marketing_test_mode_button") != null || mFragmentManager.findFragmentByTag("marketing_test_mode_list") != null)
        {
            return;
        } else
        {
            final TestModeButton button = TestModeButton.newInstance();
            final TestModeListView listView = TestModeListView.newInstance();
            final Context appContext = mLocalyticsDao.getAppContext();
            final InAppMessagesAdapter adapter = new InAppMessagesAdapter(appContext, this);
            listView.setAdapter(adapter);
            TreeMap treemap = new TreeMap();
            treemap.put(Integer.valueOf(9), new _cls12());
            button.setCallbacks(treemap);
            button.show(mFragmentManager, "marketing_test_mode_button");
            mFragmentManager.executePendingTransactions();
            treemap = new TreeMap();
            treemap.put(Integer.valueOf(10), new _cls13());
            treemap.put(Integer.valueOf(12), new _cls14());
            treemap.put(Integer.valueOf(13), new _cls15());
            treemap.put(Integer.valueOf(14), new _cls16());
            treemap.put(Integer.valueOf(11), new _cls17());
            listView.setCallbacks(treemap);
            return;
        }
    }

    void _tryDisplayingInAppCampaign(final MarketingMessage inAppMessage, final Map jsCallbacks)
    {
        jsCallbacks = _getJavaScriptClientCallbacks(jsCallbacks);
        (new Handler(Looper.getMainLooper())).post(new _cls2());
    }

    boolean _validateAndStoreFrequencyCappingRule(Map map, Integer integer)
    {
        boolean flag2 = false;
        map = (Map)map.get("frequency_capping");
        if (map != null)
        {
            boolean flag;
            if (integer.intValue() == -1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (_validateFrequencyCappingRule(map, flag))
            {
                return _saveFrequencyCappingRule(map, integer);
            }
        }
        boolean flag1 = flag2;
        if (integer.intValue() != -1)
        {
            flag1 = _saveFrequencyCappingRule(new HashMap(DEFAULT_FREQUENCY_CAPPING_RULE), integer);
        }
        return flag1;
    }

    boolean _validateFrequencyCappingRule(Map map, boolean flag)
    {
label0:
        {
            String as[];
            if (flag)
            {
                as = GLOBAL_FREQUENCY_CAPPING_RULE_REQUIRED_KEYS;
            } else
            {
                as = INDIVIDUAL_FREQUENCY_CAPPING_RULE_REQUIRED_KEYS;
            }
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                if (!map.containsKey(as[i]))
                {
                    return false;
                }
            }

            Object obj = (List)map.get("display_frequencies");
            if (!_checkFrequencyCappingRuleArray(((List) (obj)), new String[] {
    "days", "count"
}))
            {
                return false;
            }
            if (!_additionalFCDisplayFrequencyRulesValidation(((List) (obj))))
            {
                return false;
            }
            map = (List)map.get("blackout_rules");
            if (map == null)
            {
                break label0;
            }
            if (map.size() <= 0)
            {
                return false;
            }
            map = map.iterator();
            do
            {
                if (!map.hasNext())
                {
                    break label0;
                }
                obj = (Map)map.next();
                if (!((Map) (obj)).containsKey("times") && !((Map) (obj)).containsKey("dates") && !((Map) (obj)).containsKey("weekdays"))
                {
                    return false;
                }
                List list = (List)((Map) (obj)).get("times");
                if (!_checkFrequencyCappingRuleArray(list, new String[] {
    "start", "end"
}))
                {
                    return false;
                }
                if (!_additionalFCDatesAndTimesRulesValidation(list, TIME_SDF))
                {
                    return false;
                }
                list = (List)((Map) (obj)).get("dates");
                if (!_checkFrequencyCappingRuleArray(list, new String[] {
    "start", "end"
}))
                {
                    return false;
                }
                if (!_additionalFCDatesAndTimesRulesValidation(list, DATE_SDF))
                {
                    return false;
                }
                obj = (List)((Map) (obj)).get("weekdays");
                if (obj != null && (((List) (obj)).size() <= 0 || ((List) (obj)).size() > 7))
                {
                    return false;
                }
            } while (_additionalFCWeekdaysRulesValidation(((List) (obj))));
            return false;
        }
        return true;
    }

    protected boolean _validateInAppMessage(MarketingMessage marketingmessage)
    {
        int i = JsonHelper.getSafeIntegerFromMap(marketingmessage, "campaign_id");
        String s = JsonHelper.getSafeStringFromMap(marketingmessage, "rule_name");
        List list = JsonHelper.getSafeListFromMap(marketingmessage, "display_events");
        int j = JsonHelper.getSafeIntegerFromMap(marketingmessage, "expiration");
        marketingmessage = JsonHelper.getSafeStringFromMap(marketingmessage, "location");
        long l = mLocalyticsDao.getCurrentTimeMillis() / 1000L;
        return i != 0 && !TextUtils.isEmpty(s) && list != null && !TextUtils.isEmpty(marketingmessage) && ((long)j > l || Constants.isTestModeEnabled());
    }

    void dismissCurrentInAppMessage()
    {
        if (mFragmentManager == null)
        {
            return;
        }
        try
        {
            android.support.v4.app.Fragment fragment = mFragmentManager.findFragmentByTag("marketing_dialog");
            if (fragment instanceof InAppDialogFragment)
            {
                ((InAppDialogFragment)fragment).dismissCampaign();
            }
            return;
        }
        catch (Exception exception)
        {
            LocalyticsManager.throwOrLogError(java/lang/RuntimeException, "Localytics library threw an uncaught exception", exception);
        }
    }

    SparseArray getDialogCallbacks()
    {
        SparseArray sparsearray = new SparseArray();
        sparsearray.put(1, new _cls3());
        sparsearray.put(2, new _cls4());
        sparsearray.put(16, new _cls5());
        sparsearray.put(17, new _cls6());
        return sparsearray;
    }

    List getInAppMessages()
    {
        return mMarketingHandler.getList(new _cls18());
    }

    void setFragmentManager(_cls1427 _pcls1427)
    {
        mFragmentManager = _pcls1427;
    }

    void setSessionStartInAppMessageShown(boolean flag)
    {
        mSessionStartInAppMessageShown = flag;
    }

    static 
    {
        TIME_SDF = new SimpleDateFormat("HH:mm");
        DATE_SDF = new SimpleDateFormat("yyyy-MM-dd");
        AUGMENTED_BLACKOUT_TIMES_RULE = new ArrayList();
        HashMap hashmap = new HashMap();
        hashmap.put("start", "00:00");
        hashmap.put("end", "23:59");
        AUGMENTED_BLACKOUT_TIMES_RULE.add(hashmap);
        hashmap = new HashMap();
        DEFAULT_FREQUENCY_CAPPING_RULE = hashmap;
        hashmap.put("max_display_count", Integer.valueOf(1));
        DEFAULT_FREQUENCY_CAPPING_RULE.put("ignore_global", Integer.valueOf(1));
        TIME_SDF.setLenient(false);
        DATE_SDF.setLenient(false);
    }




/*
    static boolean access$102(InAppManager inappmanager, boolean flag)
    {
        inappmanager.mCampaignDisplaying = flag;
        return flag;
    }

*/




/*
    static InAppMessagesAdapter access$402(InAppManager inappmanager, InAppMessagesAdapter inappmessagesadapter)
    {
        inappmanager.mTestCampaignsListAdapter = inappmessagesadapter;
        return inappmessagesadapter;
    }

*/





    private class _cls7 extends InAppCallable
    {

        final InAppManager this$0;

        Object call(Object aobj[])
        {
            String s;
            String s1;
            Object obj;
            long l;
            s = (String)aobj[0];
            s1 = (String)aobj[1];
            obj = (String)aobj[2];
            l = 0L;
            aobj = new HashMap();
            if (TextUtils.isEmpty(s))
            {
                LocalyticsManager.throwOrLogError(java/lang/IllegalArgumentException, "event cannot be null or empty");
            }
            try
            {
                if (!TextUtils.isEmpty(s1) && !InAppManager.JS_STRINGS_THAT_MEAN_NULL.contains(s1))
                {
                    java.util.Map.Entry entry1;
                    for (Iterator iterator1 = JsonHelper.toMap(new JSONObject(s1)).entrySet().iterator(); iterator1.hasNext(); ((Map) (aobj)).put(entry1.getKey(), String.valueOf(entry1.getValue())))
                    {
                        entry1 = (java.util.Map.Entry)iterator1.next();
                    }

                }
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                Localytics.Log.w("[JavaScriptClient]: Failed to parse the json object in tagEventNative");
                return null;
            }
            long l1 = Long.valueOf(((String) (obj))).longValue();
            l = l1;
              goto _L1
_L2:
            Exception exception;
            try
            {
                if (!TextUtils.isEmpty(((CharSequence) (obj))) && !InAppManager.JS_STRINGS_THAT_MEAN_NULL.contains(obj))
                {
                    java.util.Map.Entry entry;
                    for (obj = JsonHelper.toMap(new JSONObject(((String) (obj)))).entrySet().iterator(); ((Iterator) (obj)).hasNext(); ((Map) (aobj)).put(entry.getKey(), String.valueOf(entry.getValue())))
                    {
                        entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                    }

                }
            }
            catch (JSONException jsonexception) { }
_L1:
            if (s1 != null)
            {
                if (((Map) (aobj)).isEmpty())
                {
                    Localytics.Log.w("attributes is empty.  Did the caller make an error?");
                }
                if (((Map) (aobj)).size() > 50)
                {
                    Localytics.Log.w(String.format("attributes size is %d, exceeding the maximum size of %d.  Did the caller make an error?", new Object[] {
                        Integer.valueOf(((Map) (aobj)).size()), Integer.valueOf(50)
                    }));
                }
                Iterator iterator = ((Map) (aobj)).entrySet().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    Object obj1 = (java.util.Map.Entry)iterator.next();
                    String s2 = (String)((java.util.Map.Entry) (obj1)).getKey();
                    obj1 = String.valueOf(((java.util.Map.Entry) (obj1)).getValue());
                    if (TextUtils.isEmpty(s2))
                    {
                        LocalyticsManager.throwOrLogError(java/lang/IllegalArgumentException, "attributes cannot contain null or empty keys");
                    }
                    if (TextUtils.isEmpty(((CharSequence) (obj1))))
                    {
                        LocalyticsManager.throwOrLogError(java/lang/IllegalArgumentException, "attributes cannot contain null or empty values");
                    }
                } while (true);
            }
            mLocalyticsDao.tagEvent(s, ((Map) (aobj)), l);
            return null;
            exception;
              goto _L2
        }

        _cls7()
        {
            this$0 = InAppManager.this;
            super();
        }
    }


    private class _cls8 extends InAppCallable
    {

        final InAppManager this$0;
        final Map val$customerIDs;

        Object call(Object aobj[])
        {
            if (customerIDs.isEmpty())
            {
                return null;
            }
            try
            {
                aobj = new JSONObject();
                java.util.Map.Entry entry;
                for (Iterator iterator = customerIDs.entrySet().iterator(); iterator.hasNext(); ((JSONObject) (aobj)).put((String)entry.getKey(), entry.getValue()))
                {
                    entry = (java.util.Map.Entry)iterator.next();
                }

            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                Localytics.Log.w("[JavaScriptClient]: Failed to get identifiers");
                return null;
            }
            aobj = ((JSONObject) (aobj)).toString();
            return ((Object) (aobj));
        }

        _cls8()
        {
            this$0 = InAppManager.this;
            customerIDs = map;
            super();
        }
    }


    private class _cls9 extends InAppCallable
    {

        final InAppManager this$0;
        final JSONObject val$jsonCustomDimensions;

        Object call(Object aobj[])
        {
            return jsonCustomDimensions.toString();
        }

        _cls9()
        {
            this$0 = InAppManager.this;
            jsonCustomDimensions = jsonobject;
            super();
        }
    }


    private class _cls10 extends InAppCallable
    {

        final InAppManager this$0;
        final Map val$attributes;

        Object call(Object aobj[])
        {
            if (attributes == null)
            {
                return null;
            }
            if (attributes.size() == 0)
            {
                return null;
            }
            try
            {
                aobj = new JSONObject();
                java.util.Map.Entry entry;
                for (Iterator iterator = attributes.entrySet().iterator(); iterator.hasNext(); ((JSONObject) (aobj)).put((String)entry.getKey(), (String)entry.getValue()))
                {
                    entry = (java.util.Map.Entry)iterator.next();
                }

            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                Localytics.Log.w("[JavaScriptClient]: Failed to get attributes");
                return null;
            }
            aobj = ((JSONObject) (aobj)).toString();
            return ((Object) (aobj));
        }

        _cls10()
        {
            this$0 = InAppManager.this;
            attributes = map;
            super();
        }
    }


    private class _cls11 extends InAppCallable
    {

        final InAppManager this$0;

        Object call(Object aobj[])
        {
            int i = ((Integer)aobj[0]).intValue();
            aobj = (String)aobj[1];
            mLocalyticsDao.setCustomDimension(i, ((String) (aobj)));
            return null;
        }

        _cls11()
        {
            this$0 = InAppManager.this;
            super();
        }
    }


    private class _cls1 extends Thread
    {

        final InAppManager this$0;
        final InAppMessagesAdapter val$adapter;

        public void run()
        {
            class _cls1
                implements Runnable
            {

                final _cls1 this$1;

                public void run()
                {
                    adapter.updateDataSet();
                    adapter.notifyDataSetChanged();
                }

                _cls1()
                {
                    this$1 = _cls1.this;
                    super();
                }
            }

            (new Handler(Looper.getMainLooper())).post(new _cls1());
        }

        _cls1()
        {
            this$0 = InAppManager.this;
            adapter = inappmessagesadapter;
            super();
        }
    }


    private class _cls12 extends InAppCallable
    {

        final InAppManager this$0;
        final InAppMessagesAdapter val$adapter;
        final TestModeListView val$listView;

        Object call(Object aobj[])
        {
            adapter.updateDataSet();
            listView.show(mFragmentManager, "marketing_test_mode_list");
            mFragmentManager.executePendingTransactions();
            return null;
        }

        _cls12()
        {
            this$0 = InAppManager.this;
            adapter = inappmessagesadapter;
            listView = testmodelistview;
            super();
        }
    }


    private class _cls13 extends InAppCallable
    {

        final InAppManager this$0;
        final TestModeButton val$button;

        Object call(Object aobj[])
        {
            button.show(mFragmentManager, "marketing_test_mode_button");
            mFragmentManager.executePendingTransactions();
            return null;
        }

        _cls13()
        {
            this$0 = InAppManager.this;
            button = testmodebutton;
            super();
        }
    }


    private class _cls14 extends InAppCallable
    {

        final InAppManager this$0;
        final InAppMessagesAdapter val$adapter;

        Object call(Object aobj[])
        {
            mLocalyticsDao.tagEvent("Test Mode Update Data");
            mTestCampaignsListAdapter = adapter;
            mMarketingHandler.upload(mLocalyticsDao.getCustomerIdInMemory());
            return null;
        }

        _cls14()
        {
            this$0 = InAppManager.this;
            adapter = inappmessagesadapter;
            super();
        }
    }


    private class _cls15 extends InAppCallable
    {

        final InAppManager this$0;
        final Context val$appContext;

        Object call(Object aobj[])
        {
            class _cls1 extends AsyncTask
            {

                final _cls15 this$1;

                protected volatile Object doInBackground(Object aobj1[])
                {
                    return doInBackground((Void[])aobj1);
                }

                protected transient String doInBackground(Void avoid[])
                {
                    return mLocalyticsDao.getPushRegistrationId();
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((String)obj);
                }

                protected void onPostExecute(String s)
                {
                    if (!TextUtils.isEmpty(s))
                    {
                        if (DatapointHelper.getApiLevel() < 11)
                        {
                            ((ClipboardManager)appContext.getSystemService("clipboard")).setText(s);
                        } else
                        {
                            ((android.content.ClipboardManager)appContext.getSystemService("clipboard")).setText(s);
                        }
                        Toast.makeText(appContext, (new StringBuilder()).append(s).append(" has been copied to the clipboard.").toString(), 1).show();
                        return;
                    } else
                    {
                        Toast.makeText(appContext, "No push token found. Please check your integration.", 1).show();
                        return;
                    }
                }

                _cls1()
                {
                    this$1 = _cls15.this;
                    super();
                }
            }

            (new _cls1()).execute(new Void[0]);
            return null;
        }

        _cls15()
        {
            this$0 = InAppManager.this;
            appContext = context;
            super();
        }
    }


    private class _cls16 extends InAppCallable
    {

        final InAppManager this$0;
        final Context val$appContext;

        Object call(Object aobj[])
        {
            aobj = mLocalyticsDao.getInstallationId();
            if (!TextUtils.isEmpty(((CharSequence) (aobj))))
            {
                if (DatapointHelper.getApiLevel() < 11)
                {
                    ((ClipboardManager)appContext.getSystemService("clipboard")).setText(((CharSequence) (aobj)));
                } else
                {
                    ((android.content.ClipboardManager)appContext.getSystemService("clipboard")).setText(((CharSequence) (aobj)));
                }
                Toast.makeText(appContext, (new StringBuilder()).append(((String) (aobj))).append(" has been copied to the clipboard.").toString(), 1).show();
            } else
            {
                Toast.makeText(appContext, "No install id found. Please check your integration.", 1).show();
            }
            return null;
        }

        _cls16()
        {
            this$0 = InAppManager.this;
            appContext = context;
            super();
        }
    }


    private class _cls17 extends InAppCallable
    {

        final InAppManager this$0;
        final Context val$appContext;

        Object call(final Object marketingMessage[])
        {
            marketingMessage = (MarketingMessage)marketingMessage[0];
            class _cls1 extends AsyncTask
            {

                final _cls17 this$1;
                final MarketingMessage val$marketingMessage;

                protected volatile Object doInBackground(Object aobj[])
                {
                    return ((Object) (doInBackground((MarketingMessage[])aobj)));
                }

                protected transient Object[] doInBackground(MarketingMessage amarketingmessage[])
                {
                    if (_updateDisplayingCandidate(amarketingmessage[0]))
                    {
                        amarketingmessage = amarketingmessage[0];
                    } else
                    {
                        amarketingmessage = null;
                    }
                    return (new Object[] {
                        amarketingmessage, _getJavaScriptClientCallbacks(null)
                    });
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Object[])obj);
                }

                protected void onPostExecute(Object aobj[])
                {
                    MarketingMessage marketingmessage = (MarketingMessage)aobj[0];
                    aobj = (SparseArray)aobj[1];
                    if (marketingmessage == null)
                    {
                        Object obj;
                        try
                        {
                            Toast.makeText(appContext, "The downloaded campaign file is broken.", 0).show();
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object aobj[])
                        {
                            LocalyticsManager.throwOrLogError(java/lang/RuntimeException, "Localytics library threw an uncaught exception", ((Exception) (aobj)));
                        }
                        break MISSING_BLOCK_LABEL_185;
                    }
                    if (mFragmentManager == null)
                    {
                        break MISSING_BLOCK_LABEL_87;
                    }
                    obj = mFragmentManager.findFragmentByTag((new StringBuilder("marketing_dialog")).append(marketingmessage.get("campaign_id")).toString());
                    if (obj == null)
                    {
                        break MISSING_BLOCK_LABEL_88;
                    }
                    return;
                    obj = InAppDialogFragment.newInstance();
                    ((InAppDialogFragment) (obj)).setRetainInstance(false);
                    ((InAppDialogFragment) (obj)).setData(marketingmessage).setCallbacks(getDialogCallbacks()).setJavaScriptClient(new JavaScriptClient(((SparseArray) (aobj)))).show(mFragmentManager, (new StringBuilder("marketing_dialog")).append(marketingmessage.get("campaign_id")).toString());
                    mFragmentManager.executePendingTransactions();
                    return;
                }

                protected void onPreExecute()
                {
                    int i = ((Integer)marketingMessage.get("_id")).intValue();
                    boolean flag = _getRemoteFileURL(marketingMessage).endsWith(".zip");
                    if (!_doesCreativeExist(i, flag))
                    {
                        Toast.makeText(appContext, "Downloading the campaign...\nIt'll be shown in few seconds.", 0).show();
                    }
                }

                _cls1()
                {
                    this$1 = _cls17.this;
                    marketingMessage = marketingmessage;
                    super();
                }
            }

            (new _cls1()).execute(new MarketingMessage[] {
                marketingMessage
            });
            return null;
        }

        _cls17()
        {
            this$0 = InAppManager.this;
            appContext = context;
            super();
        }
    }


    private class _cls2
        implements Runnable
    {

        final InAppManager this$0;
        final MarketingMessage val$inAppMessage;
        final SparseArray val$jsCallbacks;

        public void run()
        {
            if (mFragmentManager == null)
            {
                return;
            }
            android.support.v4.app.Fragment fragment = mFragmentManager.findFragmentByTag("marketing_dialog");
            if (fragment != null)
            {
                return;
            }
            try
            {
                if (!mCampaignDisplaying)
                {
                    mCampaignDisplaying = true;
                    class _cls1 extends AsyncTask
                    {

                        final _cls2 this$1;
                        final int val$campaignId;

                        protected transient Boolean doInBackground(Void avoid[])
                        {
                            return Boolean.valueOf(mMarketingHandler.setInAppAsDisplayed(campaignId));
                        }

                        protected volatile Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected void onPostExecute(Boolean boolean1)
                        {
                            if (boolean1.booleanValue())
                            {
                                if (mFragmentManager != null)
                                {
                                    InAppDialogFragment.newInstance().setData(inAppMessage).setCallbacks(getDialogCallbacks()).setJavaScriptClient(new JavaScriptClient(jsCallbacks)).show(mFragmentManager, "marketing_dialog");
                                    if (!Constants.isTestModeEnabled())
                                    {
                                        ((MessagingListener)mMarketingHandler.listeners).localyticsWillDisplayInAppMessage();
                                    }
                                    mFragmentManager.executePendingTransactions();
                                } else
                                {
                                    mMarketingHandler.setInAppMessageAsNotDisplayed(campaignId);
                                }
                            }
                            mCampaignDisplaying = false;
                        }

                        protected volatile void onPostExecute(Object obj)
                        {
                            onPostExecute((Boolean)obj);
                        }

                _cls1()
                {
                    this$1 = _cls2.this;
                    campaignId = i;
                    super();
                }
                    }

                    (new _cls1()).execute(new Void[0]);
                }
                return;
            }
            catch (Exception exception)
            {
                LocalyticsManager.throwOrLogError(java/lang/RuntimeException, "Localytics library threw an uncaught exception", exception);
            }
            return;
        }

        _cls2()
        {
            this$0 = InAppManager.this;
            inAppMessage = marketingmessage;
            jsCallbacks = sparsearray;
            super();
        }
    }


    private class _cls3 extends InAppCallable
    {

        final InAppManager this$0;

        public Object call(Object aobj[])
        {
            ((MessagingListener)mMarketingHandler.listeners).localyticsDidDismissInAppMessage();
            return null;
        }

        _cls3()
        {
            this$0 = InAppManager.this;
            super();
        }
    }


    private class _cls4 extends InAppCallable
    {

        final InAppManager this$0;

        public Object call(Object aobj[])
        {
            String s = (String)aobj[0];
            aobj = (Map)aobj[1];
            mLocalyticsDao.tagEvent(s, ((Map) (aobj)));
            return null;
        }

        _cls4()
        {
            this$0 = InAppManager.this;
            super();
        }
    }


    private class _cls5 extends InAppCallable
    {

        final InAppManager this$0;

        public Object call(Object aobj[])
        {
            ((MessagingListener)mMarketingHandler.listeners).localyticsDidDisplayInAppMessage();
            return null;
        }

        _cls5()
        {
            this$0 = InAppManager.this;
            super();
        }
    }


    private class _cls6 extends InAppCallable
    {

        final InAppManager this$0;

        public Object call(Object aobj[])
        {
            ((MessagingListener)mMarketingHandler.listeners).localyticsWillDismissInAppMessage();
            return null;
        }

        _cls6()
        {
            this$0 = InAppManager.this;
            super();
        }
    }


    private class _cls18
        implements Callable
    {

        final InAppManager this$0;

        public volatile Object call()
        {
            return call();
        }

        public List call()
        {
            Cursor cursor;
            Object obj;
            ArrayList arraylist;
            arraylist = new ArrayList();
            cursor = null;
            obj = null;
            Cursor cursor1 = mProvider.query("marketing_rules", null, null, null, "campaign_id");
_L2:
            obj = cursor1;
            cursor = cursor1;
            if (!cursor1.moveToNext())
            {
                break; /* Loop/switch isn't completed */
            }
            obj = cursor1;
            cursor = cursor1;
            MarketingMessage marketingmessage = new MarketingMessage();
            obj = cursor1;
            cursor = cursor1;
            marketingmessage.put("_id", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("_id"))));
            obj = cursor1;
            cursor = cursor1;
            marketingmessage.put("campaign_id", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("campaign_id"))));
            obj = cursor1;
            cursor = cursor1;
            marketingmessage.put("expiration", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("expiration"))));
            obj = cursor1;
            cursor = cursor1;
            marketingmessage.put("display_seconds", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("display_seconds"))));
            obj = cursor1;
            cursor = cursor1;
            marketingmessage.put("display_session", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("display_session"))));
            obj = cursor1;
            cursor = cursor1;
            marketingmessage.put("version", cursor1.getString(cursor1.getColumnIndexOrThrow("version")));
            obj = cursor1;
            cursor = cursor1;
            marketingmessage.put("phone_location", cursor1.getString(cursor1.getColumnIndexOrThrow("phone_location")));
            obj = cursor1;
            cursor = cursor1;
            marketingmessage.put("phone_size_width", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("phone_size_width"))));
            obj = cursor1;
            cursor = cursor1;
            marketingmessage.put("phone_size_height", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("phone_size_height"))));
            obj = cursor1;
            cursor = cursor1;
            marketingmessage.put("tablet_location", cursor1.getString(cursor1.getColumnIndexOrThrow("tablet_location")));
            obj = cursor1;
            cursor = cursor1;
            marketingmessage.put("tablet_size_width", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("tablet_size_width"))));
            obj = cursor1;
            cursor = cursor1;
            marketingmessage.put("tablet_size_height", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("tablet_size_height"))));
            obj = cursor1;
            cursor = cursor1;
            marketingmessage.put("time_to_display", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("time_to_display"))));
            obj = cursor1;
            cursor = cursor1;
            marketingmessage.put("internet_required", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("internet_required"))));
            obj = cursor1;
            cursor = cursor1;
            marketingmessage.put("ab_test", cursor1.getString(cursor1.getColumnIndexOrThrow("ab_test")));
            obj = cursor1;
            cursor = cursor1;
            marketingmessage.put("rule_name_non_unique", cursor1.getString(cursor1.getColumnIndexOrThrow("rule_name_non_unique")));
            obj = cursor1;
            cursor = cursor1;
            marketingmessage.put("location", cursor1.getString(cursor1.getColumnIndexOrThrow("location")));
            obj = cursor1;
            cursor = cursor1;
            marketingmessage.put("devices", cursor1.getString(cursor1.getColumnIndexOrThrow("devices")));
            obj = cursor1;
            cursor = cursor1;
            marketingmessage.put("control_group", cursor1.getString(cursor1.getColumnIndexOrThrow("control_group")));
            obj = cursor1;
            cursor = cursor1;
            marketingmessage.put("schema_version", cursor1.getString(cursor1.getColumnIndexOrThrow("schema_version")));
            obj = cursor1;
            cursor = cursor1;
            arraylist.add(marketingmessage);
            if (true) goto _L2; else goto _L1
_L1:
            obj = arraylist;
            if (cursor1 != null)
            {
                cursor1.close();
                return arraylist;
            }
              goto _L3
_L5:
            obj = null;
            if (cursor != null)
            {
                cursor.close();
                return null;
            }
              goto _L3
            Exception exception;
            exception;
            if (obj != null)
            {
                ((Cursor) (obj)).close();
            }
            throw exception;
_L3:
            return ((List) (obj));
            Exception exception1;
            exception1;
            if (true) goto _L5; else goto _L4
_L4:
        }

        _cls18()
        {
            this$0 = InAppManager.this;
            super();
        }
    }

}
