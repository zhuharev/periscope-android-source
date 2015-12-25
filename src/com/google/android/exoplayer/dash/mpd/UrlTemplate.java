// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash.mpd;

import java.util.Locale;

public final class UrlTemplate
{

    private static final String BANDWIDTH = "Bandwidth";
    private static final int BANDWIDTH_ID = 3;
    private static final String DEFAULT_FORMAT_TAG = "%01d";
    private static final String ESCAPED_DOLLAR = "$$";
    private static final String NUMBER = "Number";
    private static final int NUMBER_ID = 2;
    private static final String REPRESENTATION = "RepresentationID";
    private static final int REPRESENTATION_ID = 1;
    private static final String TIME = "Time";
    private static final int TIME_ID = 4;
    private final int identifierCount;
    private final String identifierFormatTags[];
    private final int identifiers[];
    private final String urlPieces[];

    private UrlTemplate(String as[], int ai[], String as1[], int i)
    {
        urlPieces = as;
        identifiers = ai;
        identifierFormatTags = as1;
        identifierCount = i;
    }

    public static UrlTemplate compile(String s)
    {
        String as[] = new String[5];
        int ai[] = new int[4];
        String as1[] = new String[4];
        return new UrlTemplate(as, ai, as1, parseTemplate(s, as, ai, as1));
    }

    private static int parseTemplate(String s, String as[], int ai[], String as1[])
    {
        as[0] = "";
        int i = 0;
        int j = 0;
        while (i < s.length()) 
        {
            int k = s.indexOf("$", i);
            if (k == -1)
            {
                as[j] = (new StringBuilder()).append(as[j]).append(s.substring(i)).toString();
                i = s.length();
            } else
            if (k != i)
            {
                as[j] = (new StringBuilder()).append(as[j]).append(s.substring(i, k)).toString();
                i = k;
            } else
            if (s.startsWith("$$", i))
            {
                as[j] = (new StringBuilder()).append(as[j]).append("$").toString();
                i += 2;
            } else
            {
                int l = s.indexOf("$", i + 1);
                String s3 = s.substring(i + 1, l);
                if (s3.equals("RepresentationID"))
                {
                    ai[j] = 1;
                } else
                {
                    i = s3.indexOf("%0");
                    String s2 = "%01d";
                    String s1 = s3;
                    if (i != -1)
                    {
                        s2 = s3.substring(i);
                        s1 = s2;
                        if (!s2.endsWith("d"))
                        {
                            s1 = (new StringBuilder()).append(s2).append("d").toString();
                        }
                        s3 = s3.substring(0, i);
                        s2 = s1;
                        s1 = s3;
                    }
                    if (s1.equals("Number"))
                    {
                        ai[j] = 2;
                    } else
                    if (s1.equals("Bandwidth"))
                    {
                        ai[j] = 3;
                    } else
                    if (s1.equals("Time"))
                    {
                        ai[j] = 4;
                    } else
                    {
                        throw new IllegalArgumentException((new StringBuilder("Invalid template: ")).append(s).toString());
                    }
                    as1[j] = s2;
                }
                j++;
                as[j] = "";
                i = l + 1;
            }
        }
        return j;
    }

    public final String buildUri(String s, int i, int j, long l)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int k = 0; k < identifierCount; k++)
        {
            stringbuilder.append(urlPieces[k]);
            if (identifiers[k] == 1)
            {
                stringbuilder.append(s);
                continue;
            }
            if (identifiers[k] == 2)
            {
                stringbuilder.append(String.format(Locale.US, identifierFormatTags[k], new Object[] {
                    Integer.valueOf(i)
                }));
                continue;
            }
            if (identifiers[k] == 3)
            {
                stringbuilder.append(String.format(Locale.US, identifierFormatTags[k], new Object[] {
                    Integer.valueOf(j)
                }));
                continue;
            }
            if (identifiers[k] == 4)
            {
                stringbuilder.append(String.format(Locale.US, identifierFormatTags[k], new Object[] {
                    Long.valueOf(l)
                }));
            }
        }

        stringbuilder.append(urlPieces[identifierCount]);
        return stringbuilder.toString();
    }
}
