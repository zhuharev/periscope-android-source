// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.SharedPreferences;
import org.json.JSONObject;

// Referenced classes of package o:
//            up, ra, vl, vj, 
//            vh, uy, rl, vf, 
//            sc, ri, rz, vk, 
//            _cls03BB

public class vg
{

    final up Rk;
    final vk UP;
    final vj UQ;
    final uy UR;
    final vl US;
    final sc currentTimeProvider;
    final ri kit;

    public vg(ri ri1, vk vk, sc sc1, vj vj1, uy uy1, _cls03BB _pcls03bb)
    {
        kit = ri1;
        UP = vk;
        currentTimeProvider = sc1;
        UQ = vj1;
        UR = uy1;
        US = _pcls03bb;
        Rk = new up(kit);
    }

    boolean _mth0269(String s)
    {
        android.content.SharedPreferences.Editor editor = Rk.edit();
        editor.putString("existing_instance_identifier", s);
        return Rk._mth02CA(editor);
    }

    public vh _mth02CA(vf vf1)
    {
        Object obj;
        vh vh1;
        Object obj1;
        Object obj2;
        obj2 = null;
        obj1 = null;
        vh1 = obj1;
        obj = obj2;
        if (ra._mth04F5())
        {
            break MISSING_BLOCK_LABEL_40;
        }
        vh1 = obj1;
        obj = obj2;
        if (!FB88())
        {
            obj = obj2;
            JSONObject jsonobject;
            try
            {
                vh1 = _mth02CB(vf1);
            }
            // Misplaced declaration of an exception variable
            catch (vf vf1)
            {
                ra._mth0454()._mth02CB("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", vf1);
                return ((vh) (obj));
            }
        }
        obj = vh1;
        if (vh1 != null)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        obj = vh1;
        jsonobject = US._mth02CA(UP);
        obj = vh1;
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        obj = vh1;
        vf1 = UQ._mth02CA(currentTimeProvider, jsonobject);
        obj = vf1;
        UR._mth02CA(((vh) (vf1)).UX, jsonobject);
        obj = vf1;
        ra._mth0454()._mth02BE("Fabric", (new StringBuilder()).append("Loaded settings: ").append(jsonobject.toString()).toString());
        obj = vf1;
        _mth0269(FB34());
        obj = vf1;
        vf1 = ((vf) (obj));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        vf1 = _mth02CB(vf.UN);
        return vf1;
    }

    vh _mth02CB(vf vf1)
    {
        vf vf2;
        Object obj;
        Object obj1;
        Object obj2;
        obj1 = null;
        obj2 = null;
        obj = obj2;
        vf2 = obj1;
        if (vf.UM.equals(vf1)) goto _L2; else goto _L1
_L1:
        boolean flag;
        vf2 = obj1;
        JSONObject jsonobject;
        long l;
        try
        {
            jsonobject = UR._mth1F3A();
        }
        // Misplaced declaration of an exception variable
        catch (vf vf1)
        {
            ra._mth0454()._mth02CB("Fabric", "Failed to get cached settings", vf1);
            return vf2;
        }
        if (jsonobject == null) goto _L4; else goto _L3
_L3:
        vf2 = obj1;
        obj = UQ._mth02CA(currentTimeProvider, jsonobject);
        vf2 = obj1;
        ra._mth0454()._mth02BE("Fabric", (new StringBuilder()).append("Loaded cached settings: ").append(jsonobject.toString()).toString());
        vf2 = obj1;
        l = currentTimeProvider.getCurrentTimeMillis();
        vf2 = obj1;
        if (vf.UN.equals(vf1)) goto _L6; else goto _L5
_L5:
        vf2 = obj1;
        if (((vh) (obj)).UX < l)
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L7
_L6:
        vf1 = ((vf) (obj));
        vf2 = vf1;
        ra._mth0454()._mth02BE("Fabric", "Returning cached settings.");
        obj = vf1;
          goto _L2
_L8:
        vf2 = obj1;
        ra._mth0454()._mth02BE("Fabric", "Cached settings have expired.");
        return null;
_L4:
        vf2 = obj1;
        ra._mth0454()._mth02BE("Fabric", "No cached settings data found.");
        obj = obj2;
_L2:
        return ((vh) (obj));
_L7:
        if (flag) goto _L8; else goto _L6
    }

    public vh _mth5196()
    {
        return _mth02CA(vf.UL);
    }

    String FB34()
    {
        return rz._mth02CF(new String[] {
            rz._mth142A(kit.getContext())
        });
    }

    String FB4D()
    {
        return Rk._mth1E97().getString("existing_instance_identifier", "");
    }

    boolean FB88()
    {
        return !FB4D().equals(FB34());
    }
}
