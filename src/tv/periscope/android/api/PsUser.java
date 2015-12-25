// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.api;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// Referenced classes of package tv.periscope.android.api:
//            PsProfileImageUrl

public class PsUser
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    public String className;
    public String createdAt;
    public String description;
    public String displayName;
    public String id;
    public String initials;
    public boolean isBlocked;
    public boolean isEmployee;
    public boolean isFollowing;
    public boolean isMuted;
    public boolean isVerified;
    public int numBlocked;
    public int numFollowers;
    public int numFollowing;
    public int numHearts;
    private int numHeartsGiven;
    private int participantIndex;
    public ArrayList profileImageUrls;
    public transient String profileUrlLarge;
    public transient String profileUrlMedium;
    public transient String profileUrlSmall;
    public String updatedAt;
    public String username;

    public PsUser()
    {
    }

    public PsUser(Parcel parcel)
    {
        className = parcel.readString();
        id = parcel.readString();
        createdAt = parcel.readString();
        updatedAt = parcel.readString();
        username = parcel.readString();
        displayName = parcel.readString();
        initials = parcel.readString();
        description = parcel.readString();
        profileImageUrls = parcel.readArrayList(getClass().getClassLoader());
        numFollowers = parcel.readInt();
        numFollowing = parcel.readInt();
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isFollowing = flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isBlocked = flag;
        numHearts = parcel.readInt();
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isMuted = flag;
    }

    private void loadProfileUrls()
    {
        if (profileImageUrls != null && !profileImageUrls.isEmpty() && profileUrlSmall == null && profileUrlMedium == null && profileUrlLarge == null)
        {
            Object obj = new TreeMap();
            PsProfileImageUrl psprofileimageurl;
            for (Iterator iterator = profileImageUrls.iterator(); iterator.hasNext(); ((Map) (obj)).put(Integer.valueOf(psprofileimageurl.width * psprofileimageurl.height), psprofileimageurl.url))
            {
                psprofileimageurl = (PsProfileImageUrl)iterator.next();
            }

            obj = new ArrayList(((Map) (obj)).values());
            int i = ((List) (obj)).size();
            if (i > 0)
            {
                i = Math.max(0, i - 1);
                int j = Math.min(1, i);
                profileUrlSmall = (String)((List) (obj)).get(0);
                profileUrlMedium = (String)((List) (obj)).get(j);
                profileUrlLarge = (String)((List) (obj)).get(i);
            }
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public int getNumHearts()
    {
        if (numHearts == 0)
        {
            return 1;
        } else
        {
            return numHearts;
        }
    }

    public int getNumHeartsGiven()
    {
        return numHeartsGiven;
    }

    public int getParticipantIndex()
    {
        return participantIndex;
    }

    public String getProfileUrlLarge()
    {
        if (profileUrlLarge == null)
        {
            loadProfileUrls();
        }
        return profileUrlLarge;
    }

    public String getProfileUrlMedium()
    {
        if (profileUrlMedium == null)
        {
            loadProfileUrls();
        }
        return profileUrlMedium;
    }

    public String getProfileUrlSmall()
    {
        if (profileUrlSmall == null)
        {
            loadProfileUrls();
        }
        return profileUrlSmall;
    }

    public void setNumHeartsGiven(int i)
    {
        numHeartsGiven = i;
    }

    public void setParticipantIndex(int i)
    {
        participantIndex = i;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(className);
        parcel.writeString(id);
        parcel.writeString(createdAt);
        parcel.writeString(updatedAt);
        parcel.writeString(username);
        parcel.writeString(displayName);
        parcel.writeString(initials);
        parcel.writeString(description);
        parcel.writeList(profileImageUrls);
        parcel.writeInt(numFollowers);
        parcel.writeInt(numFollowing);
        if (isFollowing)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (isBlocked)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeInt(numHearts);
        if (isMuted)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final PsUser createFromParcel(Parcel parcel)
        {
            return new PsUser(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        public final PsUser[] newArray(int i)
        {
            return new PsUser[i];
        }

        _cls1()
        {
        }
    }

}
