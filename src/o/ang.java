// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            aqt, arc, adc, asm

public final class ang extends android.support.v7.widget.RecyclerView._cls02CC
    implements android.view.View.OnClickListener
{

    private final asm beo;
    public final ImageView btM;
    public final ImageView btN;
    public final TextView btO;
    public final TextView btP;
    public final TextView btQ;
    public final arc btR;
    public final aqt btS;
    public final View btT;
    public PsUser user;

    public ang(View view, asm asm1)
    {
        super(view);
        btM = (ImageView)view.findViewById(0x7f0d0075);
        btN = (ImageView)view.findViewById(0x7f0d0198);
        btO = (TextView)view.findViewById(0x7f0d0077);
        btP = (TextView)view.findViewById(0x7f0d0199);
        btQ = (TextView)view.findViewById(0x7f0d00fd);
        btS = (aqt)view.findViewById(0x7f0d019b);
        btR = (arc)view.findViewById(0x7f0d019a);
        btT = view.findViewById(0x7f0d00b0);
        beo = asm1;
        view.setOnClickListener(this);
        btS.setOnClickListener(this);
    }

    public final void onClick(View view)
    {
        if (user != null)
        {
            switch (view.getId())
            {
            default:
                return;

            case 2131558805: 
                beo._mth1D65(new adc(user.id, null));
                return;

            case 2131558811: 
                break;
            }
            if (user.isFollowing)
            {
                beo.FBE6(user.id);
                return;
            }
            beo._mth4E36(user.id);
        }
    }
}
