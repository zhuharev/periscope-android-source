// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

final class JsonHelper
{

    JsonHelper()
    {
    }

    private static Object fromJson(Object obj)
    {
        if (obj == JSONObject.NULL)
        {
            return null;
        }
        if (obj instanceof JSONObject)
        {
            return toMap((JSONObject)obj);
        }
        if (obj instanceof JSONArray)
        {
            return toList((JSONArray)obj);
        } else
        {
            return obj;
        }
    }

    static Map getMap(JSONObject jsonobject, String s)
    {
        return toMap(jsonobject.getJSONObject(s));
    }

    static boolean getSafeBooleanFromMap(Map map, String s)
    {
        boolean flag = false;
        map = ((Map) (map.get(s)));
        if (map instanceof Boolean)
        {
            return ((Boolean)map).booleanValue();
        }
        if (map instanceof Integer)
        {
            if (((Integer)map).intValue() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return flag;
        }
        if (map instanceof String)
        {
            flag = ((String)map).equalsIgnoreCase("true");
        }
        return flag;
    }

    static int getSafeIntegerFromMap(Map map, String s)
    {
        int i = 0;
        map = ((Map) (map.get(s)));
        if (map == null)
        {
            return 0;
        }
        if (map instanceof Integer)
        {
            return ((Integer)map).intValue();
        }
        if (map instanceof String)
        {
            i = Integer.parseInt((String)map);
        }
        return i;
    }

    static List getSafeListFromMap(Map map, String s)
    {
        Object obj = null;
        s = ((String) (map.get(s)));
        if (s == null)
        {
            return null;
        }
        map = obj;
        if (s instanceof List)
        {
            map = (List)s;
        }
        return map;
    }

    static Map getSafeMapFromMap(Map map, String s)
    {
        Object obj = null;
        s = ((String) (map.get(s)));
        if (s == null)
        {
            return null;
        }
        map = obj;
        if (s instanceof Map)
        {
            map = (Map)s;
        }
        return map;
    }

    static String getSafeStringFromMap(Map map, String s)
    {
        Object obj = null;
        s = ((String) (map.get(s)));
        if (s == null)
        {
            return null;
        }
        if (s instanceof Integer)
        {
            return Integer.toString(((Integer)s).intValue());
        }
        map = obj;
        if (s instanceof String)
        {
            map = (String)s;
        }
        return map;
    }

    static String getSafeStringFromValue(Object obj)
    {
        String s = null;
        if (obj == null)
        {
            return null;
        }
        if (obj instanceof Integer)
        {
            return Integer.toString(((Integer)obj).intValue());
        }
        if (obj instanceof String)
        {
            s = (String)obj;
        }
        return s;
    }

    static boolean isEmptyObject(JSONObject jsonobject)
    {
        return jsonobject.names() == null;
    }

    static Object toJSON(Object obj)
    {
        if (obj instanceof Map)
        {
            JSONObject jsonobject = new JSONObject();
            obj = (Map)obj;
            Object obj1;
            for (Iterator iterator = ((Map) (obj)).keySet().iterator(); iterator.hasNext(); jsonobject.put(obj1.toString(), toJSON(((Map) (obj)).get(obj1))))
            {
                obj1 = iterator.next();
            }

            return jsonobject;
        }
        if (obj instanceof Iterable)
        {
            JSONArray jsonarray = new JSONArray();
            for (obj = ((Iterable)obj).iterator(); ((Iterator) (obj)).hasNext(); jsonarray.put(toJSON(((Iterator) (obj)).next()))) { }
            return jsonarray;
        } else
        {
            return obj;
        }
    }

    static List toList(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < jsonarray.length(); i++)
        {
            arraylist.add(fromJson(jsonarray.get(i)));
        }

        return arraylist;
    }

    static Map toMap(JSONObject jsonobject)
    {
        HashMap hashmap = new HashMap();
        String s;
        for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); hashmap.put(s, fromJson(jsonobject.get(s))))
        {
            s = (String)iterator.next();
        }

        return hashmap;
    }
}
