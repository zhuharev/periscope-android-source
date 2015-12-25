// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MediaType
{

    private static final Pattern PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private final String charset;
    private final String mediaType;
    private final String subtype;
    private final String type;

    private MediaType(String s, String s1, String s2, String s3)
    {
        mediaType = s;
        type = s1;
        subtype = s2;
        charset = s3;
    }

    public static MediaType parse(String s)
    {
        Matcher matcher = TYPE_SUBTYPE.matcher(s);
        if (!matcher.lookingAt())
        {
            return null;
        }
        String s3 = matcher.group(1).toLowerCase(Locale.US);
        String s4 = matcher.group(2).toLowerCase(Locale.US);
        String s2 = null;
        Matcher matcher1 = PARAMETER.matcher(s);
        for (int i = matcher.end(); i < s.length();)
        {
            matcher1.region(i, s.length());
            if (!matcher1.lookingAt())
            {
                return null;
            }
            String s5 = matcher1.group(1);
            String s1 = s2;
            if (s5 != null)
            {
                s1 = s2;
                if (s5.equalsIgnoreCase("charset"))
                {
                    if (matcher1.group(2) != null)
                    {
                        s1 = matcher1.group(2);
                    } else
                    {
                        s1 = matcher1.group(3);
                    }
                    if (s2 != null && !s1.equalsIgnoreCase(s2))
                    {
                        throw new IllegalArgumentException((new StringBuilder("Multiple different charsets: ")).append(s).toString());
                    }
                }
            }
            i = matcher1.end();
            s2 = s1;
        }

        return new MediaType(s, s3, s4, s2);
    }

    public final Charset charset()
    {
        if (charset != null)
        {
            return Charset.forName(charset);
        } else
        {
            return null;
        }
    }

    public final Charset charset(Charset charset1)
    {
        if (charset != null)
        {
            return Charset.forName(charset);
        } else
        {
            return charset1;
        }
    }

    public final boolean equals(Object obj)
    {
        return (obj instanceof MediaType) && ((MediaType)obj).mediaType.equals(mediaType);
    }

    public final int hashCode()
    {
        return mediaType.hashCode();
    }

    public final String subtype()
    {
        return subtype;
    }

    public final String toString()
    {
        return mediaType;
    }

    public final String type()
    {
        return type;
    }

}
