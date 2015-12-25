// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import android.os.Message;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.localytics.android:
//            BaseHandler, BaseProvider, LocalyticsManager, LocalyticsDao, 
//            ProfileProvider, ProfileUploadHandler, BaseUploadThread

class ProfileHandler extends BaseHandler
{
    final class ProfileListenersSet extends BaseHandler.ListenersSet
    {

        final ProfileHandler this$0;

        private ProfileListenersSet()
        {
            this$0 = ProfileHandler.this;
            super(ProfileHandler.this);
        }

        ProfileListenersSet(_cls1 _pcls1)
        {
            this();
        }
    }

    static final class ProfileOperation extends Enum
    {

        private static final ProfileOperation $VALUES[];
        public static final ProfileOperation ASSIGN;
        public static final ProfileOperation DELETE;
        public static final ProfileOperation INCREMENT;
        public static final ProfileOperation SETADD;
        public static final ProfileOperation SETREMOVE;
        private final String operation;

        public static ProfileOperation valueOf(String s)
        {
            return (ProfileOperation)Enum.valueOf(com/localytics/android/ProfileHandler$ProfileOperation, s);
        }

        public static ProfileOperation[] values()
        {
            return (ProfileOperation[])$VALUES.clone();
        }

        public final String getOperationString()
        {
            return operation;
        }

        static 
        {
            ASSIGN = new ProfileOperation("ASSIGN", 0, "assign");
            DELETE = new ProfileOperation("DELETE", 1, "delete");
            SETADD = new ProfileOperation("SETADD", 2, "set-add");
            SETREMOVE = new ProfileOperation("SETREMOVE", 3, "set-remove");
            INCREMENT = new ProfileOperation("INCREMENT", 4, "increment");
            $VALUES = (new ProfileOperation[] {
                ASSIGN, DELETE, SETADD, SETREMOVE, INCREMENT
            });
        }

        private ProfileOperation(String s, int i, String s1)
        {
            super(s, i);
            operation = s1;
        }
    }


    static final String ATTRIBUTE_JSON_KEY_KEY = "attr";
    static final String ATTRIBUTE_JSON_OP_KEY = "op";
    static final String ATTRIBUTE_JSON_VALUE_KEY = "value";
    private static final int MESSAGE_SET_PROFILE_ATTRIBUTE = 301;

    ProfileHandler(LocalyticsDao localyticsdao, Looper looper)
    {
        super(localyticsdao, looper);
        siloName = "Profile";
        listeners = new ProfileListenersSet(null);
        queueMessage(obtainMessage(1));
    }

    private void _setAttribute(String s, String s1, String s2)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("scope", s1);
        contentvalues.put("change", s);
        contentvalues.put("customer_id", s2);
        mProvider.insert("changes", contentvalues);
    }

    private static boolean checkAttributeName(String s)
    {
        if (s == null)
        {
            LocalyticsManager.throwOrLogError(java/lang/IllegalArgumentException, "attribute name cannot be null");
            return false;
        }
        if (s.trim().length() == 0)
        {
            LocalyticsManager.throwOrLogError(java/lang/IllegalArgumentException, "attribute name cannot be empty");
            return false;
        } else
        {
            return true;
        }
    }

    private static Object convertDateToString(Object obj)
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd");
        if (obj instanceof Date)
        {
            return simpledateformat.format(obj);
        }
        if (obj instanceof Date[])
        {
            ArrayList arraylist = new ArrayList();
            obj = (Date[])obj;
            int j = obj.length;
            for (int i = 0; i < j; i++)
            {
                Date date = obj[i];
                if (date != null)
                {
                    arraylist.add(simpledateformat.format(date));
                } else
                {
                    arraylist.add(null);
                }
            }

            return ((Object) (arraylist.toArray()));
        } else
        {
            return null;
        }
    }

    private static Long[] convertToObjectArray(long al[])
    {
        Long along[] = new Long[al.length];
        int j = 0;
        int k = al.length;
        for (int i = 0; i < k; i++)
        {
            along[j] = Long.valueOf(al[i]);
            j++;
        }

        return along;
    }

    private void saveAttributeChange(ProfileOperation profileoperation, String s, Object obj, String s1)
    {
        if (!checkAttributeName(s))
        {
            break MISSING_BLOCK_LABEL_164;
        }
        JSONObject jsonobject;
        int j;
        jsonobject = new JSONObject();
        jsonobject.put("op", profileoperation.getOperationString());
        jsonobject.put("attr", s);
        if (!(obj instanceof Object[]))
        {
            break MISSING_BLOCK_LABEL_101;
        }
        profileoperation = new JSONArray();
        s = ((String) ((Object[])obj));
        j = s.length;
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        profileoperation.put(s[i]);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        try
        {
            jsonobject.put("value", profileoperation);
            break MISSING_BLOCK_LABEL_114;
        }
        // Misplaced declaration of an exception variable
        catch (ProfileOperation profileoperation)
        {
            Localytics.Log.w("Caught JSON exception", profileoperation);
        }
        break MISSING_BLOCK_LABEL_164;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        jsonobject.put("value", obj);
        queueMessage(obtainMessage(301, ((Object) (new Object[] {
            jsonobject.toString(), s1, mLocalyticsDao.getCustomerIdInMemory()
        }))));
        return;
    }

    protected void _deleteUploadedData(int i)
    {
        mProvider.remove("changes", (new StringBuilder("_id <= ")).append(i).toString(), null);
    }

    protected TreeMap _getDataToUpload()
    {
        Cursor cursor;
        TreeMap treemap;
        treemap = new TreeMap();
        cursor = null;
        Cursor cursor1 = mProvider.query("changes", null, null, null, "_id ASC");
        String s;
        String s1;
        s = null;
        s1 = null;
_L2:
        cursor = cursor1;
        if (!cursor1.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        cursor = cursor1;
        if ((double)treemap.size() >= 50D)
        {
            break; /* Loop/switch isn't completed */
        }
        cursor = cursor1;
        int i = cursor1.getInt(cursor1.getColumnIndexOrThrow("_id"));
        cursor = cursor1;
        String s5 = cursor1.getString(cursor1.getColumnIndexOrThrow("change"));
        cursor = cursor1;
        String s3 = cursor1.getString(cursor1.getColumnIndexOrThrow("customer_id"));
        cursor = cursor1;
        String s4 = cursor1.getString(cursor1.getColumnIndex("scope"));
        String s2;
        s2 = s;
        if (s == null)
        {
            s2 = s3;
            s1 = s4;
        }
        cursor = cursor1;
        if (!s2.equals(s3))
        {
            break; /* Loop/switch isn't completed */
        }
        cursor = cursor1;
        if (!s1.equals(s4))
        {
            break; /* Loop/switch isn't completed */
        }
        cursor = cursor1;
        treemap.put(Integer.valueOf(i), ((Object) (new Object[] {
            s3, s4, s5
        })));
        s = s2;
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
        Cursor cursor2 = mProvider.query("changes", new String[] {
            "_id"
        }, null, null, "_id ASC");
        Cursor cursor1;
        cursor1 = cursor2;
        cursor = cursor1;
        if (!cursor2.moveToLast())
        {
            break MISSING_BLOCK_LABEL_59;
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
        mProvider = new ProfileProvider(siloName.toLowerCase(), mLocalyticsDao);
        mProvider.vacuumIfNecessary();
    }

    protected void _onUploadCompleted(String s)
    {
        mProvider.vacuumIfNecessary();
    }

    void addProfileAttributesToSet(String s, long al[], String s1)
    {
        saveAttributeChange(ProfileOperation.SETADD, s, convertToObjectArray(al), s1);
    }

    void addProfileAttributesToSet(String s, String as[], String s1)
    {
        saveAttributeChange(ProfileOperation.SETADD, s, as, s1);
    }

    void addProfileAttributesToSet(String s, Date adate[], String s1)
    {
        saveAttributeChange(ProfileOperation.SETADD, s, convertDateToString(adate), s1);
    }

    void deleteProfileAttribute(String s, String s1)
    {
        saveAttributeChange(ProfileOperation.DELETE, s, null, s1);
    }

    protected BaseUploadThread getUploadThread(TreeMap treemap, String s)
    {
        return new ProfileUploadHandler(this, treemap, s, mLocalyticsDao);
    }

    protected void handleMessageExtended(final Message attribute)
    {
        switch (attribute.what)
        {
        case 301: 
            Localytics.Log.d("Profile handler received MESSAGE_SET_PROFILE_ATTRIBUTE");
            Object aobj[] = (Object[])attribute.obj;
            attribute = (String)aobj[0];
            final String database = (String)aobj[1];
            final String customerID = (String)aobj[2];
            mProvider.runBatchTransaction(new _cls1());
            return;
        }
        super.handleMessageExtended(attribute);
    }

    void incrementProfileAttribute(String s, long l, String s1)
    {
        saveAttributeChange(ProfileOperation.INCREMENT, s, Long.valueOf(l), s1);
    }

    void removeProfileAttributesFromSet(String s, long al[], String s1)
    {
        saveAttributeChange(ProfileOperation.SETREMOVE, s, convertToObjectArray(al), s1);
    }

    void removeProfileAttributesFromSet(String s, String as[], String s1)
    {
        saveAttributeChange(ProfileOperation.SETREMOVE, s, as, s1);
    }

    void removeProfileAttributesFromSet(String s, Date adate[], String s1)
    {
        saveAttributeChange(ProfileOperation.SETREMOVE, s, convertDateToString(adate), s1);
    }

    void setProfileAttribute(String s, long l, String s1)
    {
        saveAttributeChange(ProfileOperation.ASSIGN, s, Long.valueOf(l), s1);
    }

    void setProfileAttribute(String s, String s1, String s2)
    {
        saveAttributeChange(ProfileOperation.ASSIGN, s, s1, s2);
    }

    void setProfileAttribute(String s, Date date, String s1)
    {
        saveAttributeChange(ProfileOperation.ASSIGN, s, convertDateToString(date), s1);
    }

    void setProfileAttribute(String s, long al[], String s1)
    {
        saveAttributeChange(ProfileOperation.ASSIGN, s, convertToObjectArray(al), s1);
    }

    void setProfileAttribute(String s, String as[], String s1)
    {
        saveAttributeChange(ProfileOperation.ASSIGN, s, as, s1);
    }

    void setProfileAttribute(String s, Date adate[], String s1)
    {
        saveAttributeChange(ProfileOperation.ASSIGN, s, convertDateToString(adate), s1);
    }


    private class _cls1
        implements Runnable
    {

        final ProfileHandler this$0;
        final String val$attribute;
        final String val$customerID;
        final String val$database;

        public void run()
        {
            _setAttribute(attribute, database, customerID);
        }

        _cls1()
        {
            this$0 = ProfileHandler.this;
            attribute = s;
            database = s1;
            customerID = s2;
            super();
        }
    }

}
