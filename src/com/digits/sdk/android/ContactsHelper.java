// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import com.digits.sdk.vcard.VCardBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ContactsHelper
{

    private static final int MAX_CONTACTS = 2500;
    private static final String allProjectionColumns[] = {
        "mimetype", "lookup", "data2", "data3", "is_primary", "data1", "data1", "data2", "data3", "is_primary", 
        "data1", "data2", "data3"
    };
    private static final String selectionArgs[] = {
        "vnd.android.cursor.item/phone_v2", "vnd.android.cursor.item/email_v2", "vnd.android.cursor.item/name"
    };
    private static final String selectionQuery = "mimetype=? OR mimetype=? OR mimetype=?";
    private final Context context;

    ContactsHelper(Context context1)
    {
        context = context1;
    }

    private List processContactsMap(Map map)
    {
        ArrayList arraylist = new ArrayList();
        HashMap hashmap = new HashMap();
        VCardBuilder vcardbuilder = new VCardBuilder(0xc0000001, "UTF-8");
        Iterator iterator = map.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (List)map.get((String)iterator.next());
            boolean flag = false;
            hashmap.clear();
            vcardbuilder.clear();
            ContentValues contentvalues;
            for (Iterator iterator1 = ((List) (obj)).iterator(); iterator1.hasNext(); ((List) (obj)).add(contentvalues))
            {
                contentvalues = (ContentValues)iterator1.next();
                String s = contentvalues.getAsString("mimetype");
                if ("vnd.android.cursor.item/phone_v2".equals(s) || "vnd.android.cursor.item/email_v2".equals(s))
                {
                    flag = true;
                }
                List list = (List)hashmap.get(s);
                obj = list;
                if (list == null)
                {
                    obj = new ArrayList();
                    hashmap.put(s, obj);
                }
            }

            if (flag)
            {
                vcardbuilder.appendNameProperties((List)hashmap.get("vnd.android.cursor.item/name")).appendPhones((List)hashmap.get("vnd.android.cursor.item/phone_v2"), null).appendEmails((List)hashmap.get("vnd.android.cursor.item/email_v2"));
                arraylist.add(vcardbuilder.toString());
            }
        } while (true);
        return arraylist;
    }

    public List createContactList(Cursor cursor)
    {
        if (cursor == null || cursor.getCount() == 0)
        {
            return Collections.emptyList();
        }
        int i = cursor.getColumnIndex("mimetype");
        int j = cursor.getColumnIndex("lookup");
        HashMap hashmap = new HashMap();
        do
        {
            if (!cursor.moveToNext())
            {
                break;
            }
            Object obj = cursor.getString(i);
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("mimetype", ((String) (obj)));
            byte byte0 = -1;
            switch (((String) (obj)).hashCode())
            {
            case 684173810: 
                if (((String) (obj)).equals("vnd.android.cursor.item/phone_v2"))
                {
                    byte0 = 0;
                }
                break;

            case -1569536764: 
                if (((String) (obj)).equals("vnd.android.cursor.item/email_v2"))
                {
                    byte0 = 1;
                }
                break;

            case -1079224304: 
                if (((String) (obj)).equals("vnd.android.cursor.item/name"))
                {
                    byte0 = 2;
                }
                break;
            }
            switch (byte0)
            {
            default:
                continue;

            case 0: // '\0'
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentvalues, "data2");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "data3");
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentvalues, "is_primary");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "data1");
                break;

            case 1: // '\001'
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "data1");
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentvalues, "data2");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "data3");
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentvalues, "is_primary");
                break;

            case 2: // '\002'
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "data1");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "data2");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "data3");
                break;
            }
            String s = cursor.getString(j);
            List list = (List)hashmap.get(s);
            obj = list;
            if (list == null)
            {
                obj = new ArrayList();
                hashmap.put(s, obj);
            }
            ((List) (obj)).add(contentvalues);
        } while (true);
        return processContactsMap(hashmap);
    }

    public Cursor getContactsCursor()
    {
        HashSet hashset = new HashSet(Arrays.asList(allProjectionColumns));
        String as[] = (String[])hashset.toArray(new String[hashset.size()]);
        Uri uri = android.provider.ContactsContract.Data.CONTENT_URI.buildUpon().appendQueryParameter("limit", Integer.toString(2500)).build();
        return context.getContentResolver().query(uri, as, "mimetype=? OR mimetype=? OR mimetype=?", selectionArgs, null);
    }

}
