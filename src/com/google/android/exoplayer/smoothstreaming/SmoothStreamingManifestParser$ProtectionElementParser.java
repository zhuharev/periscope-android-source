// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.smoothstreaming;

import android.util.Base64;
import com.google.android.exoplayer.extractor.mp4.PsshAtomUtil;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;

// Referenced classes of package com.google.android.exoplayer.smoothstreaming:
//            SmoothStreamingManifestParser

static class  extends 
{

    public static final String KEY_SYSTEM_ID = "SystemID";
    public static final String TAG = "Protection";
    public static final String TAG_PROTECTION_HEADER = "ProtectionHeader";
    private boolean inProtectionHeader;
    private byte initData[];
    private UUID uuid;

    public Object build()
    {
        return new (uuid, PsshAtomUtil.buildPsshAtom(uuid, initData));
    }

    public boolean handleChildInline(String s)
    {
        return "ProtectionHeader".equals(s);
    }

    public void parseEndTag(XmlPullParser xmlpullparser)
    {
        if ("ProtectionHeader".equals(xmlpullparser.getName()))
        {
            inProtectionHeader = false;
        }
    }

    public void parseStartTag(XmlPullParser xmlpullparser)
    {
        if ("ProtectionHeader".equals(xmlpullparser.getName()))
        {
            inProtectionHeader = true;
            uuid = UUID.fromString(xmlpullparser.getAttributeValue(null, "SystemID"));
        }
    }

    public void parseText(XmlPullParser xmlpullparser)
    {
        if (inProtectionHeader)
        {
            initData = Base64.decode(xmlpullparser.getText(), 0);
        }
    }

    public ( , String s)
    {
        super(, s, "Protection");
    }
}
