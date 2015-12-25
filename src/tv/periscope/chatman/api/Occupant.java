// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.chatman.api;


public class Occupant
{

    public final int capabilities;
    public final String displayName;
    public final int participantIndex;
    public final String profileImageUrl;
    public final String userId;
    public final String username;

    public Occupant(String s, String s1, String s2, String s3, int i, int j)
    {
        userId = s;
        displayName = s1;
        username = s2;
        profileImageUrl = s3;
        participantIndex = i;
        capabilities = j;
    }
}
