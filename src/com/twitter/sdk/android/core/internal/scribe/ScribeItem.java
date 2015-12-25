// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal.scribe;

import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.User;

public class ScribeItem
{
    static class Builder
    {

        private String description;
        private Long id;
        private Integer itemType;

        ScribeItem build()
        {
            return new ScribeItem(itemType, id, description);
        }

        public Builder setDescription(String s)
        {
            description = s;
            return this;
        }

        public Builder setId(long l)
        {
            id = Long.valueOf(l);
            return this;
        }

        public Builder setItemType(int i)
        {
            itemType = Integer.valueOf(i);
            return this;
        }

        Builder()
        {
        }
    }


    public static final int TYPE_MESSAGE = 6;
    public static final int TYPE_TWEET = 0;
    public static final int TYPE_USER = 3;
    final String description;
    final Long id;
    final Integer itemType;

    private ScribeItem(Integer integer, Long long1, String s)
    {
        itemType = integer;
        id = long1;
        description = s;
    }


    public static ScribeItem fromMessage(String s)
    {
        return (new Builder()).setItemType(6).setDescription(s).build();
    }

    public static ScribeItem fromTweet(Tweet tweet)
    {
        return (new Builder()).setItemType(0).setId(tweet.id).build();
    }

    public static ScribeItem fromUser(User user)
    {
        return (new Builder()).setItemType(3).setId(user.id).build();
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (ScribeItem)obj;
        if (itemType == null ? ((ScribeItem) (obj)).itemType != null : !itemType.equals(((ScribeItem) (obj)).itemType))
        {
            return false;
        }
        if (id == null ? ((ScribeItem) (obj)).id != null : !id.equals(((ScribeItem) (obj)).id))
        {
            return false;
        }
        return description == null ? ((ScribeItem) (obj)).description == null : description.equals(((ScribeItem) (obj)).description);
    }

    public int hashCode()
    {
        int i;
        if (itemType != null)
        {
            i = itemType.hashCode();
        } else
        {
            i = 0;
        }
        int j;
        if (id != null)
        {
            j = id.hashCode();
        } else
        {
            j = 0;
        }
        int k;
        if (description != null)
        {
            k = description.hashCode();
        } else
        {
            k = 0;
        }
        return (i * 31 + j) * 31 + k;
    }
}
