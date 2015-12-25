// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package o:
//            adk, adt, atq, aos, 
//            apm, adg

public abstract class adr extends android.support.v7.widget.RecyclerView._cls02CC
{
    public static final class aux extends adr
    {

        private final TextView beL;
        private final TextView beP;

        public final void _mth02CA(adt adt)
        {
            adt = (adt._cls141D)adt;
            Resources resources = beL.getResources();
            atq atq1 = ((adt._cls141D) (adt)).bfe;
            static final class _cls1
            {

                static final int beA[];

                static 
                {
                    beA = new int[adt._cls141D.if.bd().length];
                    int ai[];
                    ai = beA;
                    int i = adt._cls141D.if.bfh;
                    ai[0] = 1;
_L2:
                    ai = beA;
                    int j = adt._cls141D.if.bfi;
                    ai[1] = 2;
                    break MISSING_BLOCK_LABEL_39;
                    NoSuchFieldError nosuchfielderror;
                    nosuchfielderror;
                    if (true) goto _L2; else goto _L1
_L1:
                    nosuchfielderror;
                }
            }

            int j;
            switch (_cls1.beA[((adt._cls141D) (adt)).bff - 1])
            {
            default:
                return;

            case 1: // '\001'
                int i = Math.max(0, (atq1.fs() + atq1.fq()) - ((adt._cls141D) (adt)).bfg);
                beP.setText(aos._mth02CA(resources, i, true));
                beL.setText(aos._mth1D37(resources.getString(0x7f0600eb)));
                return;

            case 2: // '\002'
                j = Math.max(0, atq1.fr() - ((adt._cls141D) (adt)).bfg);
                break;
            }
            beP.setText(aos._mth02CA(resources, j, true));
            beL.setText(aos._mth1D37(resources.getString(0x7f0600eb)));
        }

        public aux(View view, adk adk)
        {
            super(view, adk);
            beL = (TextView)view.findViewById(0x7f0d006f);
            beP = (TextView)view.findViewById(0x7f0d006e);
        }
    }

    public static final class if extends adr
        implements android.view.View.OnClickListener
    {

        private final apm beB;
        private final View beC;
        private adg beD;
        private ArrayList beE;

        public static if _mth02CA(Context context, ViewGroup viewgroup, adk adk1)
        {
            return new if(LayoutInflater.from(context).inflate(0x7f03001e, viewgroup, false), adk1);
        }

        public final void onClick(View view)
        {
            switch (view.getId())
            {
            default:
                return;

            case 2131558504: 
                bej._mth1FBE(beE);
                return;

            case 2131558505: 
                break;
            }
            if (beD.execute())
            {
                beB.setLabel(beD._mth1D36(fy.getContext()).toUpperCase(), beD.aU());
            }
        }

        public final void _mth02CA(adt adt)
        {
            adt = new ArrayList(Collections.unmodifiableList(((adt.if)adt).bfb));
            beD = (adg)adt.remove(0);
            beE = adt;
            beB.setLabel(beD._mth1D36(fy.getContext()).toUpperCase(), beD.aU());
            if (beE.isEmpty())
            {
                beC.setVisibility(8);
                return;
            } else
            {
                beC.setVisibility(0);
                return;
            }
        }

        private if(View view, adk adk1)
        {
            super(view, adk1);
            beB = (apm)view.findViewById(0x7f0d0069);
            beB.setOnClickListener(this);
            beC = view.findViewById(0x7f0d0068);
            beC.setOnClickListener(this);
        }
    }

    /* member class not found */
    class _cls02BB {}

    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}

    /* member class not found */
    class _cls02CF {}

    /* member class not found */
    class _cls141D {}


    protected final adk bej;

    public adr(View view, adk adk)
    {
        super(view);
        bej = adk;
    }

    public abstract void _mth02CA(adt adt);
}
