// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.api;


// Referenced classes of package tv.periscope.android.api:
//            ApiManager

static final class  extends Enum
{

    private static final Unmute $VALUES[];
    public static final Unmute Block;
    public static final Unmute Follow;
    public static final Unmute Mute;
    public static final Unmute Unblock;
    public static final Unmute Unfollow;
    public static final Unmute Unmute;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(tv/periscope/android/api/ApiManager$FollowActionType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Follow = new <init>("Follow", 0);
        Unfollow = new <init>("Unfollow", 1);
        Block = new <init>("Block", 2);
        Unblock = new <init>("Unblock", 3);
        Mute = new <init>("Mute", 4);
        Unmute = new <init>("Unmute", 5);
        $VALUES = (new .VALUES[] {
            Follow, Unfollow, Block, Unblock, Mute, Unmute
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
