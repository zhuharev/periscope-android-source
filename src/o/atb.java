// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.ArrayList;

// Referenced classes of package o:
//            atn, atw

final class atb extends atn
{
    static final class if extends atn.if
    {

        private Long bDD;
        private Boolean bDE;
        private Long bDF;
        private Long bDG;
        private Double bDH;
        private Double bDI;
        private Boolean bDJ;
        private Boolean bDK;
        atw bDz;
        private String featuredCategory;
        private String featuredCategoryColor;
        private String featuredReason;
        private ArrayList heartThemes;
        private String id;
        private String imageUrl;
        private String imageUrlSmall;
        private String profileImageUrl;
        private ArrayList shareUserDisplayNames;
        private ArrayList shareUserIds;
        private String title;
        private String twitterUsername;
        private String userDisplayName;
        private String userId;

        public final atb fn()
        {
            String s1 = "";
            if (id == null)
            {
                s1 = (new StringBuilder()).append("").append(" id").toString();
            }
            String s = s1;
            if (bDz == null)
            {
                s = (new StringBuilder()).append(s1).append(" location").toString();
            }
            s1 = s;
            if (bDD == null)
            {
                s1 = (new StringBuilder()).append(s).append(" createdAtMillis").toString();
            }
            s = s1;
            if (bDE == null)
            {
                s = (new StringBuilder()).append(s1).append(" featured").toString();
            }
            s1 = s;
            if (bDF == null)
            {
                s1 = (new StringBuilder()).append(s).append(" sortScore").toString();
            }
            s = s1;
            if (bDG == null)
            {
                s = (new StringBuilder()).append(s1).append(" startTimeMillis").toString();
            }
            s1 = s;
            if (bDH == null)
            {
                s1 = (new StringBuilder()).append(s).append(" ipLat").toString();
            }
            s = s1;
            if (bDI == null)
            {
                s = (new StringBuilder()).append(s1).append(" ipLong").toString();
            }
            s1 = s;
            if (userId == null)
            {
                s1 = (new StringBuilder()).append(s).append(" userId").toString();
            }
            s = s1;
            if (bDJ == null)
            {
                s = (new StringBuilder()).append(s1).append(" locked").toString();
            }
            s1 = s;
            if (userDisplayName == null)
            {
                s1 = (new StringBuilder()).append(s).append(" userDisplayName").toString();
            }
            s = s1;
            if (bDK == null)
            {
                s = (new StringBuilder()).append(s1).append(" hasLocation").toString();
            }
            if (!s.isEmpty())
            {
                throw new IllegalStateException((new StringBuilder("Missing required properties:")).append(s).toString());
            } else
            {
                return new atb(id, title, bDz, bDD.longValue(), bDE.booleanValue(), featuredCategory, featuredCategoryColor, featuredReason, bDF.longValue(), bDG.longValue(), bDH.doubleValue(), bDI.doubleValue(), userId, bDJ.booleanValue(), imageUrl, imageUrlSmall, userDisplayName, profileImageUrl, twitterUsername, bDK.booleanValue(), shareUserIds, shareUserDisplayNames, heartThemes, (byte)0);
            }
        }

        public final if _mth0208(String s)
        {
            featuredCategory = s;
            return this;
        }

        public final if _mth020B(String s)
        {
            featuredCategoryColor = s;
            return this;
        }

        public final if _mth0268(String s)
        {
            featuredReason = s;
            return this;
        }

        public final if _mth026A(String s)
        {
            userId = s;
            return this;
        }

        public final if _mth027E(String s)
        {
            imageUrl = s;
            return this;
        }

        public final if _mth027F(String s)
        {
            imageUrlSmall = s;
            return this;
        }

        public final if _mth029F(String s)
        {
            userDisplayName = s;
            return this;
        }

        public final if _mth02B0(String s)
        {
            profileImageUrl = s;
            return this;
        }

        public final if _mth02BF(ArrayList arraylist)
        {
            shareUserIds = arraylist;
            return this;
        }

        public final if _mth02C8(ArrayList arraylist)
        {
            shareUserDisplayNames = arraylist;
            return this;
        }

        public final if _mth02C9(ArrayList arraylist)
        {
            heartThemes = arraylist;
            return this;
        }

        public final if _mth02CA(atw atw)
        {
            bDz = atw;
            return this;
        }

        public final if _mth02CF(double d)
        {
            bDH = Double.valueOf(d);
            return this;
        }

        public final if _mth02E1(long l)
        {
            bDD = Long.valueOf(l);
            return this;
        }

        public final if _mth02EE(long l)
        {
            bDF = Long.valueOf(l);
            return this;
        }

        public final if _mth03AA(String s)
        {
            twitterUsername = s;
            return this;
        }

        public final if _mth03B9(boolean flag)
        {
            bDE = Boolean.valueOf(flag);
            return this;
        }

        public final if _mth06E5(long l)
        {
            bDG = Long.valueOf(l);
            return this;
        }

        public final if _mth09F2(boolean flag)
        {
            bDJ = Boolean.valueOf(flag);
            return this;
        }

        public final if _mth141D(double d)
        {
            bDI = Double.valueOf(d);
            return this;
        }

        public final if _mth1422(boolean flag)
        {
            bDK = Boolean.valueOf(flag);
            return this;
        }

        public final if FEE8(String s)
        {
            id = s;
            return this;
        }

        public final if FF68(String s)
        {
            title = s;
            return this;
        }

        if()
        {
        }
    }


    private final long bDA;
    private final long bDB;
    private final boolean bDC;
    private final atw bDz;
    private final boolean featured;
    private final String featuredCategory;
    private final String featuredCategoryColor;
    private final String featuredReason;
    private final boolean hasLocation;
    private final ArrayList heartThemes;
    private final String id;
    private final String imageUrl;
    private final String imageUrlSmall;
    private final double ipLat;
    private final double ipLong;
    private final String profileImageUrl;
    private final ArrayList shareUserDisplayNames;
    private final ArrayList shareUserIds;
    private final long sortScore;
    private final String title;
    private final String twitterUsername;
    private final String userDisplayName;
    private final String userId;

    private atb(String s, String s1, atw atw, long l, boolean flag, String s2, 
            String s3, String s4, long l1, long l2, double d, double d1, String s5, boolean flag1, String s6, String s7, 
            String s8, String s9, String s10, boolean flag2, ArrayList arraylist, ArrayList arraylist1, ArrayList arraylist2)
    {
        if (s == null)
        {
            throw new NullPointerException("Null id");
        }
        id = s;
        title = s1;
        if (atw == null)
        {
            throw new NullPointerException("Null location");
        }
        bDz = atw;
        bDA = l;
        featured = flag;
        featuredCategory = s2;
        featuredCategoryColor = s3;
        featuredReason = s4;
        sortScore = l1;
        bDB = l2;
        ipLat = d;
        ipLong = d1;
        if (s5 == null)
        {
            throw new NullPointerException("Null userId");
        }
        userId = s5;
        bDC = flag1;
        imageUrl = s6;
        imageUrlSmall = s7;
        if (s8 == null)
        {
            throw new NullPointerException("Null userDisplayName");
        } else
        {
            userDisplayName = s8;
            profileImageUrl = s9;
            twitterUsername = s10;
            hasLocation = flag2;
            shareUserIds = arraylist;
            shareUserDisplayNames = arraylist1;
            heartThemes = arraylist2;
            return;
        }
    }

    atb(String s, String s1, atw atw, long l, boolean flag, String s2, 
            String s3, String s4, long l1, long l2, double d, double d1, String s5, boolean flag1, String s6, String s7, 
            String s8, String s9, String s10, boolean flag2, ArrayList arraylist, ArrayList arraylist1, ArrayList arraylist2, 
            byte byte0)
    {
        this(s, s1, atw, l, flag, s2, s3, s4, l1, l2, d, d1, s5, flag1, s6, s7, s8, s9, s10, flag2, arraylist, arraylist1, arraylist2);
    }

    public final boolean bu()
    {
        return hasLocation;
    }

    public final String eS()
    {
        return title;
    }

    public final atw eT()
    {
        return bDz;
    }

    public final long eU()
    {
        return bDA;
    }

    public final boolean eV()
    {
        return featured;
    }

    public final String eW()
    {
        return featuredCategory;
    }

    public final String eX()
    {
        return featuredCategoryColor;
    }

    public final String eY()
    {
        return featuredReason;
    }

    public final long eZ()
    {
        return sortScore;
    }

    public final boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj instanceof atn)
        {
            obj = (atn)obj;
            return id.equals(((atn) (obj)).id()) && (title != null ? title.equals(((atn) (obj)).eS()) : ((atn) (obj)).eS() == null) && (bDz.equals(((atn) (obj)).eT()) && bDA == ((atn) (obj)).eU() && featured == ((atn) (obj)).eV()) && (featuredCategory != null ? featuredCategory.equals(((atn) (obj)).eW()) : ((atn) (obj)).eW() == null) && (featuredCategoryColor != null ? featuredCategoryColor.equals(((atn) (obj)).eX()) : ((atn) (obj)).eX() == null) && (featuredReason != null ? featuredReason.equals(((atn) (obj)).eY()) : ((atn) (obj)).eY() == null) && (sortScore == ((atn) (obj)).eZ() && bDB == ((atn) (obj)).fa() && Double.doubleToLongBits(ipLat) == Double.doubleToLongBits(((atn) (obj)).fb()) && Double.doubleToLongBits(ipLong) == Double.doubleToLongBits(((atn) (obj)).fc()) && userId.equals(((atn) (obj)).fd()) && bDC == ((atn) (obj)).fe()) && (imageUrl != null ? imageUrl.equals(((atn) (obj)).ff()) : ((atn) (obj)).ff() == null) && (imageUrlSmall != null ? imageUrlSmall.equals(((atn) (obj)).fg()) : ((atn) (obj)).fg() == null) && userDisplayName.equals(((atn) (obj)).fh()) && (profileImageUrl != null ? profileImageUrl.equals(((atn) (obj)).fi()) : ((atn) (obj)).fi() == null) && (twitterUsername != null ? twitterUsername.equals(((atn) (obj)).fj()) : ((atn) (obj)).fj() == null) && hasLocation == ((atn) (obj)).bu() && (shareUserIds != null ? shareUserIds.equals(((atn) (obj)).fk()) : ((atn) (obj)).fk() == null) && (shareUserDisplayNames != null ? shareUserDisplayNames.equals(((atn) (obj)).fl()) : ((atn) (obj)).fl() == null) && (heartThemes != null ? heartThemes.equals(((atn) (obj)).fm()) : ((atn) (obj)).fm() == null);
        } else
        {
            return false;
        }
    }

    public final long fa()
    {
        return bDB;
    }

    public final double fb()
    {
        return ipLat;
    }

    public final double fc()
    {
        return ipLong;
    }

    public final String fd()
    {
        return userId;
    }

    public final boolean fe()
    {
        return bDC;
    }

    public final String ff()
    {
        return imageUrl;
    }

    public final String fg()
    {
        return imageUrlSmall;
    }

    public final String fh()
    {
        return userDisplayName;
    }

    public final String fi()
    {
        return profileImageUrl;
    }

    public final String fj()
    {
        return twitterUsername;
    }

    public final ArrayList fk()
    {
        return shareUserIds;
    }

    public final ArrayList fl()
    {
        return shareUserDisplayNames;
    }

    public final ArrayList fm()
    {
        return heartThemes;
    }

    public final int hashCode()
    {
        int j = id.hashCode();
        int i;
        if (title == null)
        {
            i = 0;
        } else
        {
            i = title.hashCode();
        }
        int i1 = (int)((long)((((j ^ 0xf4243) * 0xf4243 ^ i) * 0xf4243 ^ bDz.hashCode()) * 0xf4243) ^ (bDA >>> 32 ^ bDA));
        if (featured)
        {
            i = 1231;
        } else
        {
            i = 1237;
        }
        if (featuredCategory == null)
        {
            j = 0;
        } else
        {
            j = featuredCategory.hashCode();
        }
        int k;
        if (featuredCategoryColor == null)
        {
            k = 0;
        } else
        {
            k = featuredCategoryColor.hashCode();
        }
        int l;
        if (featuredReason == null)
        {
            l = 0;
        } else
        {
            l = featuredReason.hashCode();
        }
        int i2 = (int)((long)((int)((long)((int)((long)((int)((long)(((((i1 * 0xf4243 ^ i) * 0xf4243 ^ j) * 0xf4243 ^ k) * 0xf4243 ^ l) * 0xf4243) ^ (sortScore >>> 32 ^ sortScore)) * 0xf4243) ^ (bDB >>> 32 ^ bDB)) * 0xf4243) ^ (Double.doubleToLongBits(ipLat) >>> 32 ^ Double.doubleToLongBits(ipLat))) * 0xf4243) ^ (Double.doubleToLongBits(ipLong) >>> 32 ^ Double.doubleToLongBits(ipLong)));
        int j2 = userId.hashCode();
        if (bDC)
        {
            i = 1231;
        } else
        {
            i = 1237;
        }
        if (imageUrl == null)
        {
            j = 0;
        } else
        {
            j = imageUrl.hashCode();
        }
        if (imageUrlSmall == null)
        {
            k = 0;
        } else
        {
            k = imageUrlSmall.hashCode();
        }
        int k2 = userDisplayName.hashCode();
        if (profileImageUrl == null)
        {
            l = 0;
        } else
        {
            l = profileImageUrl.hashCode();
        }
        if (twitterUsername == null)
        {
            i1 = 0;
        } else
        {
            i1 = twitterUsername.hashCode();
        }
        char c;
        if (hasLocation)
        {
            c = '\u04CF';
        } else
        {
            c = '\u04D5';
        }
        int j1;
        if (shareUserIds == null)
        {
            j1 = 0;
        } else
        {
            j1 = shareUserIds.hashCode();
        }
        int k1;
        if (shareUserDisplayNames == null)
        {
            k1 = 0;
        } else
        {
            k1 = shareUserDisplayNames.hashCode();
        }
        int l1;
        if (heartThemes == null)
        {
            l1 = 0;
        } else
        {
            l1 = heartThemes.hashCode();
        }
        return ((((((((((i2 * 0xf4243 ^ j2) * 0xf4243 ^ i) * 0xf4243 ^ j) * 0xf4243 ^ k) * 0xf4243 ^ k2) * 0xf4243 ^ l) * 0xf4243 ^ i1) * 0xf4243 ^ c) * 0xf4243 ^ j1) * 0xf4243 ^ k1) * 0xf4243 ^ l1;
    }

    public final String id()
    {
        return id;
    }

    public final String toString()
    {
        return (new StringBuilder("Broadcast{id=")).append(id).append(", title=").append(title).append(", location=").append(bDz).append(", createdAtMillis=").append(bDA).append(", featured=").append(featured).append(", featuredCategory=").append(featuredCategory).append(", featuredCategoryColor=").append(featuredCategoryColor).append(", featuredReason=").append(featuredReason).append(", sortScore=").append(sortScore).append(", startTimeMillis=").append(bDB).append(", ipLat=").append(ipLat).append(", ipLong=").append(ipLong).append(", userId=").append(userId).append(", locked=").append(bDC).append(", imageUrl=").append(imageUrl).append(", imageUrlSmall=").append(imageUrlSmall).append(", userDisplayName=").append(userDisplayName).append(", profileImageUrl=").append(profileImageUrl).append(", twitterUsername=").append(twitterUsername).append(", hasLocation=").append(hasLocation).append(", shareUserIds=").append(shareUserIds).append(", shareUserDisplayNames=").append(shareUserDisplayNames).append(", heartThemes=").append(heartThemes).append("}").toString();
    }
}
