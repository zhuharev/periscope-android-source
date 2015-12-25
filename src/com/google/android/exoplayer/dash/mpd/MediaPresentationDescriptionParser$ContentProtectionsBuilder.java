// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash.mpd;

import com.google.android.exoplayer.util.Assertions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.dash.mpd:
//            MediaPresentationDescriptionParser, ContentProtection

public static final class 
    implements Comparator
{

    private ArrayList adaptationSetProtections;
    private ArrayList currentRepresentationProtections;
    private ArrayList representationProtections;
    private boolean representationProtectionsSet;

    private void maybeAddContentProtection(List list, ContentProtection contentprotection)
    {
        if (!list.contains(contentprotection))
        {
            for (int i = 0; i < list.size(); i++)
            {
                boolean flag;
                if (!((ContentProtection)list.get(i)).schemeUriId.equals(contentprotection.schemeUriId))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                Assertions.checkState(flag);
            }

            list.add(contentprotection);
        }
    }

    public final void addAdaptationSetProtection(ContentProtection contentprotection)
    {
        if (adaptationSetProtections == null)
        {
            adaptationSetProtections = new ArrayList();
        }
        maybeAddContentProtection(adaptationSetProtections, contentprotection);
    }

    public final void addRepresentationProtection(ContentProtection contentprotection)
    {
        if (currentRepresentationProtections == null)
        {
            currentRepresentationProtections = new ArrayList();
        }
        maybeAddContentProtection(currentRepresentationProtections, contentprotection);
    }

    public final ArrayList build()
    {
        if (adaptationSetProtections == null)
        {
            return representationProtections;
        }
        if (representationProtections == null)
        {
            return adaptationSetProtections;
        }
        for (int i = 0; i < representationProtections.size(); i++)
        {
            maybeAddContentProtection(adaptationSetProtections, (ContentProtection)representationProtections.get(i));
        }

        return adaptationSetProtections;
    }

    public final int compare(ContentProtection contentprotection, ContentProtection contentprotection1)
    {
        return contentprotection.schemeUriId.compareTo(contentprotection1.schemeUriId);
    }

    public final volatile int compare(Object obj, Object obj1)
    {
        return compare((ContentProtection)obj, (ContentProtection)obj1);
    }

    public final void endRepresentation()
    {
        if (!representationProtectionsSet)
        {
            if (currentRepresentationProtections != null)
            {
                Collections.sort(currentRepresentationProtections, this);
            }
            representationProtections = currentRepresentationProtections;
            representationProtectionsSet = true;
        } else
        if (currentRepresentationProtections == null)
        {
            boolean flag;
            if (representationProtections == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Assertions.checkState(flag);
        } else
        {
            Collections.sort(currentRepresentationProtections, this);
            Assertions.checkState(currentRepresentationProtections.equals(representationProtections));
        }
        currentRepresentationProtections = null;
    }

    protected ()
    {
    }
}
