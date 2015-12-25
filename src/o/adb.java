// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Switch;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import tv.periscope.android.api.ApiManager;
import tv.periscope.android.api.GetSettingsResponse;

// Referenced classes of package o:
//            ada, acl, aro, acm, 
//            arl, ari, act, ash, 
//            zu, xf

public class adb extends ada
    implements aro.if, arl.if, android.view.View.OnClickListener
{

    private static final int bdU[] = {
        0x7f0d0007, 0x7f0d0008, 0x7f0d0006
    };
    private static final int bdV[] = {
        0x7f060104, 0x7f060106, 0x7f060102
    };
    private static final int bdW[] = {
        0x7f0200ef, 0x7f020108, 0x7f020104
    };
    private arl bdX;
    private aro bdY;
    private aro bdZ;
    private aro bea;
    private aro beb;
    private aro bec;
    private ash bed;
    private ari bee;
    private LinkedHashSet bef;
    private acm mSettingsStore;

    public adb()
    {
        bef = new LinkedHashSet();
    }

    private void aR()
    {
        mSettingsStore._mth02CA(new acl(aS(), bdY.bBO.isChecked(), bdZ.bBO.isChecked(), bea.bBO.isChecked(), beb.bBO.isChecked(), bef, bec.bBO.isChecked()));
    }

    private acl.if aS()
    {
        switch (bdX.bBG)
        {
        case 2131558408: 
            return acl.if.bdn;

        case 2131558406: 
            return acl.if.bdo;
        }
        return acl.if.bdm;
    }

    private void _mth02CE(Collection collection)
    {
        bef.clear();
        bef.addAll(collection);
        ArrayList arraylist = new ArrayList(collection.size());
        for (collection = collection.iterator(); collection.hasNext(); arraylist.add(_cls141D.if._mth02CA(this, (String)collection.next()))) { }
        Collections.sort(arraylist);
        bee.setItems(arraylist);
    }

    public final void aQ()
    {
        aR();
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        switch (i)
        {
        case 20000: 
            if (j == -1)
            {
                _mth02CE(intent.getStringArrayListExtra("e_preferred_languages"));
                aR();
                return;
            }
            break;

        default:
            super.onActivityResult(i, j, intent);
            break;
        }
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        overridePendingTransition(0x7f04000a, 0x7f040010);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131558800: 
            view = new Intent(this, o/act);
            view.putStringArrayListExtra("e_preferred_languages", new ArrayList(bef));
            startActivityForResult(view, 20000);
            return;

        case 2131558656: 
            onBackPressed();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mSettingsStore = new acm(this);
        setContentView(0x7f03007f);
        getWindow().setBackgroundDrawable(null);
        bed = (ash)findViewById(0x7f0d009c);
        bed.findViewById(0x7f0d0100).setOnClickListener(this);
        bed.setTitle(0x7f060144);
        bdX = (arl)findViewById(0x7f0d018b);
        bdY = (aro)findViewById(0x7f0d018c);
        bdZ = (aro)findViewById(0x7f0d018d);
        bea = (aro)findViewById(0x7f0d018e);
        beb = (aro)findViewById(0x7f0d018f);
        bec = (aro)findViewById(0x7f0d0191);
        bee = (ari)findViewById(0x7f0d0190);
        bundle = mSettingsStore.aH();
        acl.if if1 = ((acl) (bundle)).bdf;
        static final class _cls1
        {

            static final int $SwitchMap$tv$periscope$android$event$ApiEvent$Type[];
            static final int bcI[];

            static 
            {
                $SwitchMap$tv$periscope$android$event$ApiEvent$Type = new int[zu.if.values().length];
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXZ.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXU.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                bcI = new int[acl.if.values().length];
                try
                {
                    bcI[acl.if.bdn.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    bcI[acl.if.bdo.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    bcI[acl.if.bdm.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
            }
        }

        int i;
        switch (_cls1.bcI[if1.ordinal()])
        {
        case 1: // '\001'
            i = 0x7f0d0008;
            break;

        case 2: // '\002'
            i = 0x7f0d0006;
            break;

        default:
            i = 0x7f0d0007;
            break;
        }
        bdX.setDialogLayout(0x7f030073, 0x7f0d015a, 0x104000a, 0x1040000);
        bdX.setSingleChoiceItems(bdU, bdV, bdW, i);
        bdY.setChecked(((acl) (bundle)).bdg);
        bdZ.setChecked(((acl) (bundle)).bdh);
        bea.setChecked(((acl) (bundle)).bdi);
        beb.setChecked(((acl) (bundle)).bdj);
        bec.setChecked(((acl) (bundle)).bdl);
        _mth02CE(((acl) (bundle)).bdk);
        ApiManager.get(this).getSettings();
        bdX.setOnCheckedChangeListener(this);
        bdY.setOnCheckedChangeListener(this);
        bdZ.setOnCheckedChangeListener(this);
        bea.setOnCheckedChangeListener(this);
        beb.setOnCheckedChangeListener(this);
        bec.setOnCheckedChangeListener(this);
        bee.setOnClickListener(this);
    }

    public void onEventMainThread(zu zu1)
    {
        switch (_cls1..SwitchMap.tv.periscope.android.event.ApiEvent.Type[zu1.aXk.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            boolean flag;
            if (zu1.aXl == null && zu1.mU == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                Toast.makeText(this, 0x7f0600c9, 0).show();
                return;
            }
            break;

        case 2: // '\002'
            boolean flag1;
            if (zu1.aXl == null && zu1.mU == null)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                zu1 = (GetSettingsResponse)zu1.data;
                bec.setChecked(((GetSettingsResponse) (zu1)).isAutoSaveEnabled);
                bea.setChecked(((GetSettingsResponse) (zu1)).isUserFollowEnabled);
                aR();
            }
            break;
        }
    }

    public final void _mth02CA(aro aro1, boolean flag)
    {
        switch (aro1.getId())
        {
        case 2131558796: 
            if (flag)
            {
                aro1 = xf.if.aRj;
            } else
            {
                aro1 = xf.if.aRk;
            }
            break;

        case 2131558797: 
            if (flag)
            {
                aro1 = xf.if.aRl;
            } else
            {
                aro1 = xf.if.aRm;
            }
            break;

        case 2131558798: 
            if (flag)
            {
                aro1 = xf.if.aRh;
            } else
            {
                aro1 = xf.if.aRi;
            }
            break;

        case 2131558799: 
            if (flag)
            {
                aro1 = xf.if.aRn;
            } else
            {
                aro1 = xf.if.aRo;
            }
            break;

        case 2131558801: 
            if (flag)
            {
                aro1 = xf.if.aRf;
            } else
            {
                aro1 = xf.if.aRg;
            }
            break;

        case 2131558800: 
        default:
            aro1 = null;
            break;
        }
        if (aro1 != null)
        {
            xf._mth02CA(aro1);
        }
        aR();
        ApiManager.get(this).setSettings(bea.bBO.isChecked(), bec.bBO.isChecked());
    }

}
