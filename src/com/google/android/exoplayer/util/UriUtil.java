// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.util;

import android.net.Uri;
import android.text.TextUtils;

public final class UriUtil
{

    private static final int FRAGMENT = 3;
    private static final int INDEX_COUNT = 4;
    private static final int PATH = 1;
    private static final int QUERY = 2;
    private static final int SCHEME_COLON = 0;

    private UriUtil()
    {
    }

    private static int[] getUriIndices(String s)
    {
        int ai[];
        int i;
        int j;
label0:
        {
            ai = new int[4];
            if (TextUtils.isEmpty(s))
            {
                ai[0] = -1;
                return ai;
            }
            i = s.length();
            int k = s.indexOf('#');
            j = k;
            if (k == -1)
            {
                j = i;
            }
            i = s.indexOf('?');
            k = i;
            if (i != -1)
            {
                i = k;
                if (k <= j)
                {
                    break label0;
                }
            }
            i = j;
        }
        int l;
label1:
        {
            l = s.indexOf('/');
            int i1 = l;
            if (l != -1)
            {
                l = i1;
                if (i1 <= i)
                {
                    break label1;
                }
            }
            l = i;
        }
        int j1;
label2:
        {
            int k1 = s.indexOf(':');
            j1 = k1;
            if (k1 > l)
            {
                j1 = -1;
            }
            boolean flag;
            if (j1 + 2 < i && s.charAt(j1 + 1) == '/' && s.charAt(j1 + 2) == '/')
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                flag = s.indexOf('/', j1 + 3);
                int l1 = ((flag) ? 1 : 0);
                if (flag != -1)
                {
                    flag = l1;
                    if (l1 <= i)
                    {
                        break label2;
                    }
                }
                flag = i;
            } else
            {
                flag = j1 + 1;
            }
        }
        ai[0] = j1;
        ai[1] = ((flag) ? 1 : 0);
        ai[2] = i;
        ai[3] = j;
        return ai;
    }

    private static String removeDotSegments(StringBuilder stringbuilder, int i, int j)
    {
        if (i >= j)
        {
            return stringbuilder.toString();
        }
        int k = i;
        if (stringbuilder.charAt(i) == '/')
        {
            k = i + 1;
        }
        int i1 = k;
        i = k;
        int l = j;
        j = i1;
        do
        {
            if (i > l)
            {
                break;
            }
            int j1;
            if (i == l)
            {
                j1 = i;
            } else
            if (stringbuilder.charAt(i) == '/')
            {
                j1 = i + 1;
            } else
            {
                i++;
                continue;
            }
            if (i == j + 1 && stringbuilder.charAt(j) == '.')
            {
                stringbuilder.delete(j, j1);
                l -= j1 - j;
                i = j;
            } else
            if (i == j + 2 && stringbuilder.charAt(j) == '.' && stringbuilder.charAt(j + 1) == '.')
            {
                j = stringbuilder.lastIndexOf("/", j - 2) + 1;
                i = j;
                if (j > k)
                {
                    j = i;
                } else
                {
                    j = k;
                }
                stringbuilder.delete(j, j1);
                l -= j1 - j;
                j = i;
            } else
            {
                i++;
                j = i;
            }
        } while (true);
        return stringbuilder.toString();
    }

    public static String resolve(String s, String s1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (s == null)
        {
            s = "";
        }
        if (s1 == null)
        {
            s1 = "";
        }
        int ai[] = getUriIndices(s1);
        if (ai[0] != -1)
        {
            stringbuilder.append(s1);
            removeDotSegments(stringbuilder, ai[1], ai[2]);
            return stringbuilder.toString();
        }
        int ai1[] = getUriIndices(s);
        if (ai[3] == 0)
        {
            return stringbuilder.append(s, 0, ai1[3]).append(s1).toString();
        }
        if (ai[2] == 0)
        {
            return stringbuilder.append(s, 0, ai1[2]).append(s1).toString();
        }
        if (ai[1] != 0)
        {
            int i = ai1[0] + 1;
            stringbuilder.append(s, 0, i).append(s1);
            return removeDotSegments(stringbuilder, ai[1] + i, ai[2] + i);
        }
        if (ai[1] != ai[2] && s1.charAt(ai[1]) == '/')
        {
            stringbuilder.append(s, 0, ai1[1]).append(s1);
            return removeDotSegments(stringbuilder, ai1[1], ai1[1] + ai[2]);
        }
        if (ai1[0] + 2 < ai1[1] && ai1[1] == ai1[2])
        {
            stringbuilder.append(s, 0, ai1[1]).append('/').append(s1);
            return removeDotSegments(stringbuilder, ai1[1], ai1[1] + ai[2] + 1);
        }
        int j = s.lastIndexOf('/', ai1[2] - 1);
        if (j == -1)
        {
            j = ai1[1];
        } else
        {
            j++;
        }
        stringbuilder.append(s, 0, j).append(s1);
        return removeDotSegments(stringbuilder, ai1[1], ai[2] + j);
    }

    public static Uri resolveToUri(String s, String s1)
    {
        return Uri.parse(resolve(s, s1));
    }
}
