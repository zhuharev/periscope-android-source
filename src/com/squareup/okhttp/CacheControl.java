// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.HeaderParser;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.squareup.okhttp:
//            Headers

public final class CacheControl
{
    public static final class Builder
    {

        int maxAgeSeconds;
        int maxStaleSeconds;
        int minFreshSeconds;
        boolean noCache;
        boolean noStore;
        boolean noTransform;
        boolean onlyIfCached;

        public final CacheControl build()
        {
            return new CacheControl(this, null);
        }

        public final Builder maxAge(int i, TimeUnit timeunit)
        {
            if (i < 0)
            {
                throw new IllegalArgumentException((new StringBuilder("maxAge < 0: ")).append(i).toString());
            }
            long l = timeunit.toSeconds(i);
            if (l > 0x7fffffffL)
            {
                i = 0x7fffffff;
            } else
            {
                i = (int)l;
            }
            maxAgeSeconds = i;
            return this;
        }

        public final Builder maxStale(int i, TimeUnit timeunit)
        {
            if (i < 0)
            {
                throw new IllegalArgumentException((new StringBuilder("maxStale < 0: ")).append(i).toString());
            }
            long l = timeunit.toSeconds(i);
            if (l > 0x7fffffffL)
            {
                i = 0x7fffffff;
            } else
            {
                i = (int)l;
            }
            maxStaleSeconds = i;
            return this;
        }

        public final Builder minFresh(int i, TimeUnit timeunit)
        {
            if (i < 0)
            {
                throw new IllegalArgumentException((new StringBuilder("minFresh < 0: ")).append(i).toString());
            }
            long l = timeunit.toSeconds(i);
            if (l > 0x7fffffffL)
            {
                i = 0x7fffffff;
            } else
            {
                i = (int)l;
            }
            minFreshSeconds = i;
            return this;
        }

        public final Builder noCache()
        {
            noCache = true;
            return this;
        }

        public final Builder noStore()
        {
            noStore = true;
            return this;
        }

        public final Builder noTransform()
        {
            noTransform = true;
            return this;
        }

        public final Builder onlyIfCached()
        {
            onlyIfCached = true;
            return this;
        }

        public Builder()
        {
            maxAgeSeconds = -1;
            maxStaleSeconds = -1;
            minFreshSeconds = -1;
        }
    }


    public static final CacheControl FORCE_CACHE;
    public static final CacheControl FORCE_NETWORK = (new Builder()).noCache().build();
    String headerValue;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;

    private CacheControl(Builder builder)
    {
        noCache = builder.noCache;
        noStore = builder.noStore;
        maxAgeSeconds = builder.maxAgeSeconds;
        sMaxAgeSeconds = -1;
        isPrivate = false;
        isPublic = false;
        mustRevalidate = false;
        maxStaleSeconds = builder.maxStaleSeconds;
        minFreshSeconds = builder.minFreshSeconds;
        onlyIfCached = builder.onlyIfCached;
        noTransform = builder.noTransform;
    }

    CacheControl(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    private CacheControl(boolean flag, boolean flag1, int i, int j, boolean flag2, boolean flag3, boolean flag4, 
            int k, int l, boolean flag5, boolean flag6, String s)
    {
        noCache = flag;
        noStore = flag1;
        maxAgeSeconds = i;
        sMaxAgeSeconds = j;
        isPrivate = flag2;
        isPublic = flag3;
        mustRevalidate = flag4;
        maxStaleSeconds = k;
        minFreshSeconds = l;
        onlyIfCached = flag5;
        noTransform = flag6;
        headerValue = s;
    }

    private String headerValue()
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (noCache)
        {
            stringbuilder.append("no-cache, ");
        }
        if (noStore)
        {
            stringbuilder.append("no-store, ");
        }
        if (maxAgeSeconds != -1)
        {
            stringbuilder.append("max-age=").append(maxAgeSeconds).append(", ");
        }
        if (sMaxAgeSeconds != -1)
        {
            stringbuilder.append("s-maxage=").append(sMaxAgeSeconds).append(", ");
        }
        if (isPrivate)
        {
            stringbuilder.append("private, ");
        }
        if (isPublic)
        {
            stringbuilder.append("public, ");
        }
        if (mustRevalidate)
        {
            stringbuilder.append("must-revalidate, ");
        }
        if (maxStaleSeconds != -1)
        {
            stringbuilder.append("max-stale=").append(maxStaleSeconds).append(", ");
        }
        if (minFreshSeconds != -1)
        {
            stringbuilder.append("min-fresh=").append(minFreshSeconds).append(", ");
        }
        if (onlyIfCached)
        {
            stringbuilder.append("only-if-cached, ");
        }
        if (noTransform)
        {
            stringbuilder.append("no-transform, ");
        }
        if (stringbuilder.length() == 0)
        {
            return "";
        } else
        {
            stringbuilder.delete(stringbuilder.length() - 2, stringbuilder.length());
            return stringbuilder.toString();
        }
    }

    public static CacheControl parse(Headers headers)
    {
        boolean flag8 = false;
        boolean flag7 = false;
        int i1 = -1;
        int l = -1;
        boolean flag6 = false;
        boolean flag5 = false;
        boolean flag4 = false;
        int k = -1;
        int j = -1;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag = true;
        String s = null;
        int j1 = 0;
        for (int k2 = headers.size(); j1 < k2;)
        {
            String s1;
            int i;
            int k1;
            int l1;
            int i2;
            boolean flag1;
            boolean flag9;
            boolean flag10;
            boolean flag11;
            boolean flag12;
            boolean flag13;
            boolean flag14;
            boolean flag15;
label0:
            {
                String s3 = headers.name(j1);
                String s2 = headers.value(j1);
                if (s3.equalsIgnoreCase("Cache-Control"))
                {
                    if (s != null)
                    {
                        flag = false;
                    } else
                    {
                        s = s2;
                    }
                } else
                {
                    flag9 = flag8;
                    flag10 = flag7;
                    i = i1;
                    k1 = l;
                    flag11 = flag6;
                    flag12 = flag5;
                    flag13 = flag4;
                    l1 = k;
                    i2 = j;
                    flag14 = flag2;
                    flag15 = flag3;
                    flag1 = flag;
                    s1 = s;
                    if (!s3.equalsIgnoreCase("Pragma"))
                    {
                        break label0;
                    }
                    flag = false;
                }
                int j2 = 0;
                do
                {
                    flag9 = flag8;
                    flag10 = flag7;
                    i = i1;
                    k1 = l;
                    flag11 = flag6;
                    flag12 = flag5;
                    flag13 = flag4;
                    l1 = k;
                    i2 = j;
                    flag14 = flag2;
                    flag15 = flag3;
                    flag1 = flag;
                    s1 = s;
                    if (j2 >= s2.length())
                    {
                        break;
                    }
                    i = HeaderParser.skipUntil(s2, j2, "=,;");
                    String s4 = s2.substring(j2, i).trim();
                    if (i == s2.length() || s2.charAt(i) == ',' || s2.charAt(i) == ';')
                    {
                        i++;
                        s1 = null;
                    } else
                    {
                        k1 = HeaderParser.skipWhitespace(s2, i + 1);
                        if (k1 < s2.length() && s2.charAt(k1) == '"')
                        {
                            i = k1 + 1;
                            k1 = HeaderParser.skipUntil(s2, i, "\"");
                            s1 = s2.substring(i, k1);
                            i = k1 + 1;
                        } else
                        {
                            i = HeaderParser.skipUntil(s2, k1, ",;");
                            s1 = s2.substring(k1, i).trim();
                        }
                    }
                    if ("no-cache".equalsIgnoreCase(s4))
                    {
                        flag8 = true;
                        j2 = i;
                    } else
                    if ("no-store".equalsIgnoreCase(s4))
                    {
                        flag7 = true;
                        j2 = i;
                    } else
                    if ("max-age".equalsIgnoreCase(s4))
                    {
                        i1 = HeaderParser.parseSeconds(s1, -1);
                        j2 = i;
                    } else
                    if ("s-maxage".equalsIgnoreCase(s4))
                    {
                        l = HeaderParser.parseSeconds(s1, -1);
                        j2 = i;
                    } else
                    if ("private".equalsIgnoreCase(s4))
                    {
                        flag6 = true;
                        j2 = i;
                    } else
                    if ("public".equalsIgnoreCase(s4))
                    {
                        flag5 = true;
                        j2 = i;
                    } else
                    if ("must-revalidate".equalsIgnoreCase(s4))
                    {
                        flag4 = true;
                        j2 = i;
                    } else
                    if ("max-stale".equalsIgnoreCase(s4))
                    {
                        k = HeaderParser.parseSeconds(s1, 0x7fffffff);
                        j2 = i;
                    } else
                    if ("min-fresh".equalsIgnoreCase(s4))
                    {
                        j = HeaderParser.parseSeconds(s1, -1);
                        j2 = i;
                    } else
                    if ("only-if-cached".equalsIgnoreCase(s4))
                    {
                        flag2 = true;
                        j2 = i;
                    } else
                    {
                        if ("no-transform".equalsIgnoreCase(s4))
                        {
                            flag3 = true;
                        }
                        j2 = i;
                    }
                } while (true);
            }
            j1++;
            flag8 = flag9;
            flag7 = flag10;
            i1 = i;
            l = k1;
            flag6 = flag11;
            flag5 = flag12;
            flag4 = flag13;
            k = l1;
            j = i2;
            flag2 = flag14;
            flag3 = flag15;
            flag = flag1;
            s = s1;
        }

        if (!flag)
        {
            s = null;
        }
        return new CacheControl(flag8, flag7, i1, l, flag6, flag5, flag4, k, j, flag2, flag3, s);
    }

    public final boolean isPrivate()
    {
        return isPrivate;
    }

    public final boolean isPublic()
    {
        return isPublic;
    }

    public final int maxAgeSeconds()
    {
        return maxAgeSeconds;
    }

    public final int maxStaleSeconds()
    {
        return maxStaleSeconds;
    }

    public final int minFreshSeconds()
    {
        return minFreshSeconds;
    }

    public final boolean mustRevalidate()
    {
        return mustRevalidate;
    }

    public final boolean noCache()
    {
        return noCache;
    }

    public final boolean noStore()
    {
        return noStore;
    }

    public final boolean noTransform()
    {
        return noTransform;
    }

    public final boolean onlyIfCached()
    {
        return onlyIfCached;
    }

    public final int sMaxAgeSeconds()
    {
        return sMaxAgeSeconds;
    }

    public final String toString()
    {
        String s = headerValue;
        if (s != null)
        {
            return s;
        } else
        {
            String s1 = headerValue();
            headerValue = s1;
            return s1;
        }
    }

    static 
    {
        FORCE_CACHE = (new Builder()).onlyIfCached().maxStale(0x7fffffff, TimeUnit.SECONDS).build();
    }
}
