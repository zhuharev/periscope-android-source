// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text.eia608;


// Referenced classes of package com.google.android.exoplayer.text.eia608:
//            ClosedCaption

final class ClosedCaptionCtrl extends ClosedCaption
{

    public static final byte BACKSPACE = 33;
    public static final byte CARRIAGE_RETURN = 45;
    public static final byte END_OF_CAPTION = 47;
    public static final byte ERASE_DISPLAYED_MEMORY = 44;
    public static final byte ERASE_NON_DISPLAYED_MEMORY = 46;
    public static final byte MID_ROW_CHAN_1 = 17;
    public static final byte MID_ROW_CHAN_2 = 25;
    public static final byte MISC_CHAN_1 = 20;
    public static final byte MISC_CHAN_2 = 28;
    public static final byte RESUME_CAPTION_LOADING = 32;
    public static final byte RESUME_DIRECT_CAPTIONING = 41;
    public static final byte ROLL_UP_CAPTIONS_2_ROWS = 37;
    public static final byte ROLL_UP_CAPTIONS_3_ROWS = 38;
    public static final byte ROLL_UP_CAPTIONS_4_ROWS = 39;
    public static final byte TAB_OFFSET_CHAN_1 = 23;
    public static final byte TAB_OFFSET_CHAN_2 = 31;
    public final byte cc1;
    public final byte cc2;

    protected ClosedCaptionCtrl(byte byte0, byte byte1)
    {
        super(0);
        cc1 = byte0;
        cc2 = byte1;
    }

    public final boolean isMidRowCode()
    {
        return (cc1 == 17 || cc1 == 25) && cc2 >= 32 && cc2 <= 47;
    }

    public final boolean isMiscCode()
    {
        return (cc1 == 20 || cc1 == 28) && cc2 >= 32 && cc2 <= 47;
    }

    public final boolean isPreambleAddressCode()
    {
        return cc1 >= 16 && cc1 <= 31 && cc2 >= 64 && cc2 <= 127;
    }

    public final boolean isTabOffsetCode()
    {
        return (cc1 == 23 || cc1 == 31) && cc2 >= 33 && cc2 <= 35;
    }
}
