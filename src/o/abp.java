// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.ArrayList;
import java.util.List;
import tv.periscope.chatman.api.Occupant;

// Referenced classes of package o:
//            iq, it, kd, io, 
//            auh

public final class abp
{

    public final ArrayList bcx;
    public final int bcy;
    public final boolean bcz;

    abp(iq iq1)
    {
        iq1 = iq1._mth0673();
        if (((it) (iq1)).GC.containsKey("occupancy"))
        {
            bcy = ((iq)((it) (iq1)).GC.get("occupancy"))._mth05D4();
            bcz = true;
        } else
        {
            bcy = 0;
            bcz = false;
        }
        if (((it) (iq1)).GC.containsKey("uuids"))
        {
            iq1 = (iq)((it) (iq1)).GC.get("uuids");
            if (iq1 instanceof io)
            {
                iq1 = (io)iq1;
            } else
            {
                throw new IllegalStateException("This is not a JSON Array.");
            }
            bcx = new ArrayList(((io) (iq1)).GA.size());
            for (int i = 0; i < ((io) (iq1)).GA.size(); i++)
            {
                it it1 = ((iq)((io) (iq1)).GA.get(i))._mth0673();
                if (it1.GC.containsKey("state"))
                {
                    it1 = ((iq)it1.GC.get("state"))._mth0673();
                    bcx.add(new Occupant(auh._mth02CA(it1, "id"), auh._mth02CA(it1, "display_name"), auh._mth02CA(it1, "username"), auh._mth02CA(it1, "pub_nub_profile_image"), auh._mth02CB(it1, "participant_index"), 0));
                }
            }

            return;
        } else
        {
            bcx = null;
            return;
        }
    }
}
