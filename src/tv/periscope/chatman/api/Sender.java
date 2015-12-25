// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.chatman.api;


public class Sender
{

    public final String displayName;
    public final Integer participantIndex;
    public final String profileImageUrl;
    public final String userId;
    public final String username;

    public Sender(String s, String s1, String s2, String s3, Integer integer)
    {
        userId = s;
        username = s1;
        displayName = s2;
        profileImageUrl = s3;
        participantIndex = integer;
    }
}
