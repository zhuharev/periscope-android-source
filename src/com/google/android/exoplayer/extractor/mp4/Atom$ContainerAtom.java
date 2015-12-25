// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.mp4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.extractor.mp4:
//            Atom

static final class endPosition extends Atom
{

    public final List containerChildren = new ArrayList();
    public final long endPosition;
    public final List leafChildren = new ArrayList();

    public final void add(endPosition endposition)
    {
        containerChildren.add(endposition);
    }

    public final void add(containerChildren containerchildren)
    {
        leafChildren.add(containerchildren);
    }

    public final leafChildren getContainerAtomOfType(int i)
    {
        int k = containerChildren.size();
        for (int j = 0; j < k; j++)
        {
            leafChildren leafchildren = (containerChildren)containerChildren.get(j);
            if (leafchildren.type == i)
            {
                return leafchildren;
            }
        }

        return null;
    }

    public final type getLeafAtomOfType(int i)
    {
        int k = leafChildren.size();
        for (int j = 0; j < k; j++)
        {
            type type = (leafChildren)leafChildren.get(j);
            if (type.leafChildren == i)
            {
                return type;
            }
        }

        return null;
    }

    public final String toString()
    {
        return (new StringBuilder()).append(getAtomTypeString(type)).append(" leaves: ").append(Arrays.toString(leafChildren.toArray(new leafChildren[0]))).append(" containers: ").append(Arrays.toString(containerChildren.toArray(new containerChildren[0]))).toString();
    }

    public (int i, long l)
    {
        super(i);
        endPosition = l;
    }
}
