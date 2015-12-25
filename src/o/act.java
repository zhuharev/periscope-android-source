// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            ada, ash, zu, aui, 
//            abb, aqu

public class act extends ada
    implements android.view.View.OnClickListener
{
    final class if extends android.support.v7.widget.RecyclerView.if
    {

        final act bdA;
        String bdy[];
        final HashMap bdz;

        public final int getItemCount()
        {
            if (bdy != null)
            {
                return bdy.length;
            } else
            {
                return 0;
            }
        }

        public final void _mth02CA(android.support.v7.widget.RecyclerView._cls02CC _pcls02cc, int i)
        {
            _pcls02cc = (if)_pcls02cc;
            String s = bdy[i];
            String s1 = (String)bdz.get(s);
            ((if) (_pcls02cc)).bdB.setText(s);
            ((if) (_pcls02cc)).bdB.setChecked(act._mth02CA(bdA).contains(s1));
        }

        public final android.support.v7.widget.RecyclerView._cls02CC _mth02CB(ViewGroup viewgroup, int i)
        {
            return new if(this, LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030050, viewgroup, false));
        }

        private if()
        {
            bdA = act.this;
            super();
            bdz = new HashMap();
        }

        if(byte byte0)
        {
            this();
        }
    }

    public final class if.if extends android.support.v7.widget.RecyclerView._cls02CC
        implements android.view.View.OnClickListener
    {

        public aqu bdB;
        private if bdC;

        public final void onClick(View view)
        {
            if (act._mth02CA(bdC.bdA).size() == 1 && bdB.isChecked())
            {
                return;
            }
            bdB.toggle();
            view = (String)bdC.bdz.get(bdB.beL.getText().toString());
            if (bdB.isChecked())
            {
                act._mth02CA(bdC.bdA).add(view);
                return;
            } else
            {
                act._mth02CA(bdC.bdA).remove(view);
                return;
            }
        }

        public if.if(if if1, View view)
        {
            bdC = if1;
            super(view);
            bdB = (aqu)view;
            bdB.setOnClickListener(this);
        }
    }


    private final ArrayList bdw = new ArrayList();
    private if bdx;

    public act()
    {
    }

    static ArrayList _mth02CA(act act1)
    {
        return act1.bdw;
    }

    public void onBackPressed()
    {
        Intent intent = new Intent();
        intent.putStringArrayListExtra("e_preferred_languages", bdw);
        setResult(-1, intent);
        super.onBackPressed();
    }

    public void onClick(View view)
    {
        view = new Intent();
        view.putStringArrayListExtra("e_preferred_languages", bdw);
        setResult(-1, view);
        finish();
        overridePendingTransition(0x7f04000a, 0x7f040010);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030051);
        bundle = getIntent();
        bdw.addAll(bundle.getStringArrayListExtra("e_preferred_languages"));
        bundle = (ash)findViewById(0x7f0d009c);
        bundle.findViewById(0x7f0d0100).setOnClickListener(this);
        bundle.setTitle(0x7f06011f);
        bundle.setSubTitle(0x7f060120);
        bundle = (RecyclerView)findViewById(0x7f0d0067);
        bundle.setLayoutManager(new LinearLayoutManager(this));
        bdx = new if((byte)0);
        bundle.setAdapter(bdx);
        ApiManager.get(this).supportedLanguages();
    }

    public void onEventMainThread(zu zu1)
    {
        static final class _cls1
        {

            static final int $SwitchMap$tv$periscope$android$event$ApiEvent$Type[];

            static 
            {
                $SwitchMap$tv$periscope$android$event$ApiEvent$Type = new int[zu.if.values().length];
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXY.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (_cls1..SwitchMap.tv.periscope.android.event.ApiEvent.Type[zu1.aXk.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            break;
        }
        boolean flag;
        if (zu1.aXl == null && zu1.mU == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            zu1 = (String[])zu1.data;
            if (zu1 != null)
            {
                if if1 = bdx;
                ArrayList arraylist = new ArrayList();
                int j = zu1.length;
                for (int i = 0; i < j; i++)
                {
                    String s = zu1[i];
                    if ("other".equals(s))
                    {
                        continue;
                    }
                    String s2 = _cls141D.if._mth02CA(if1.bdA, s);
                    if (!aui.isEmpty(s2))
                    {
                        arraylist.add(s2);
                        if1.bdz.put(s2, s);
                    }
                }

                String s1 = _cls141D.if._mth02CA(if1.bdA, "other");
                if (!aui.isEmpty(s1))
                {
                    arraylist.add(s1);
                    if1.bdz.put(s1, "other");
                }
                if1.bdy = (String[])arraylist.toArray(new String[arraylist.size()]);
                ((android.support.v7.widget.RecyclerView.if) (bdx)).ey.notifyChanged();
                (new abb(this))._mth02BB(zu1);
            }
        }
    }
}
