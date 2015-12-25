// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


public final class aug extends Enum
{
    public static final class if extends Enum
    {

        public static final int bEU = 1;
        public static final int bEV = 2;
        public static final int bEW = 3;
        private static final int bEX[] = {
            1, 2, 3
        };

    }

    /* member class not found */
    class _cls02CA {}


    public static final aug bEA;
    public static final aug bEB;
    public static final aug bEC;
    public static final aug bED;
    public static final aug bEE;
    public static final aug bEF;
    public static final aug bEG;
    public static final aug bEH;
    private static aug bEI;
    private static aug bEJ;
    public static final aug bEK;
    public static final aug bEL;
    public static final aug bEM;
    private static aug bEN;
    public static final aug bEO;
    public static final aug bEP;
    private static final aug bEQ[] = values();
    private static final aug bET[];
    public static final aug bEy;
    public static final aug bEz;
    public final _cls02CA aUC;
    public final int bER;
    public final boolean bES;

    private aug(String s, int i, int j, _cls02CA _pcls02ca, boolean flag)
    {
        super(s, i);
        bER = j;
        bES = flag;
        aUC = _pcls02ca;
    }

    public static aug valueOf(String s)
    {
        return (aug)Enum.valueOf(o/aug, s);
    }

    public static aug[] values()
    {
        return (aug[])bET.clone();
    }

    public static aug _mth0142(int i)
    {
        if (i < 0 || i >= bEQ.length)
        {
            return bEy;
        } else
        {
            return bEQ[i];
        }
    }

    static 
    {
        bEy = new aug("Unknown", 0, if.bEU, _cls02CA.bEY, false);
        bEz = new aug("Chat", 1, if.bEU, _cls02CA.bFa, false);
        bEA = new aug("Heart", 2, if.bEU, _cls02CA.bEZ, false);
        bEB = new aug("Join", 3, if.bEU, _cls02CA.bFb, false);
        bEC = new aug("Location", 4, if.bEW, _cls02CA.bEY, false);
        bED = new aug("BroadcastEnded", 5, if.bEW, _cls02CA.bFa, false);
        bEE = new aug("InviteFollowers", 6, if.bEU, _cls02CA.bFa, false);
        bEF = new aug("BroadcastStartedLocally", 7, if.bEV, _cls02CA.bEY, false);
        bEG = new aug("BroadcasterUploadedReplay", 8, if.bEW, _cls02CA.bFa, false);
        bEH = new aug("Timestamp", 9, if.bEW, _cls02CA.bEY, false);
        bEI = new aug("LocalPromptToFollowBroadcaster", 10, if.bEV, _cls02CA.bEY, false);
        bEJ = new aug("LocalPromptToShareBroadcast", 11, if.bEV, _cls02CA.bEY, false);
        bEK = new aug("BroadcasterBlockedViewer", 12, if.bEW, _cls02CA.bEY, true);
        bEL = new aug("SharedOnTwitter", 13, if.bEU, _cls02CA.bFa, true);
        bEM = new aug("ViewerBlock", 14, if.bEU, _cls02CA.bEY, true);
        bEN = new aug("SharedOnFacebook", 15, if.bEU, _cls02CA.bFa, true);
        bEO = new aug("Screenshot", 16, if.bEU, _cls02CA.bFa, true);
        bEP = new aug("LocalPromptReplayScrubbing", 17, if.bEV, _cls02CA.bEY, false);
        bET = (new aug[] {
            bEy, bEz, bEA, bEB, bEC, bED, bEE, bEF, bEG, bEH, 
            bEI, bEJ, bEK, bEL, bEM, bEN, bEO, bEP
        });
    }
}
