// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import tv.periscope.android.api.PsProfileImageUrl;
import tv.periscope.android.api.PsProfileImageUrls;
import tv.periscope.android.api.PsUser;
import tv.periscope.android.api.SafeListAdapter;
import tv.periscope.chatman.api.Occupant;

// Referenced classes of package o:
//            zl, im, zs, zd, 
//            zi, zw, ig, atl, 
//            aty, ql, aui, zx, 
//            xd, yv, atd, is, 
//            xf

public final class zp
    implements zl
{
    public static final class if
    {

        public zs aWT;

        public if(zs zs1)
        {
            aWT = zs1;
        }
    }


    private static final ig aWH;
    public final SharedPreferences aQC;
    public final EnumMap aWI;
    private ArrayList aWJ;
    public final HashMap aWK;
    private EnumMap aWL;
    public final Map aWM;
    public final HashMap aWN;
    public final HashMap aWO;
    private final HashMap aWP;
    final List aWQ;
    final List aWR;
    public PsUser aWS;
    public final ql mEventBus;

    private zp(SharedPreferences sharedpreferences, ql ql1, HashMap hashmap, ArrayList arraylist, ArrayList arraylist1)
    {
        aWI = new EnumMap(o/zs);
        aWJ = new ArrayList();
        aWK = new HashMap();
        aWL = new EnumMap(o/zs);
        aWN = new HashMap();
        aWO = new HashMap();
        aWP = new HashMap();
        aQC = sharedpreferences;
        mEventBus = ql1;
        aWM = hashmap;
        aWQ = arraylist;
        aWR = arraylist1;
        sharedpreferences = aQC.getStringSet((String)yp.CON._mth02CA("o.yp").getField("aVL").get(null), null);
        if (sharedpreferences != null)
        {
            sharedpreferences = new zd("", zs.aXa, aWM, sharedpreferences);
        } else
        {
            sharedpreferences = new zd("", zs.aXa, aWM);
        }
        ql1 = new zi("", zs.aXb, aWM);
        hashmap = new zi("", zs.aXd, aWM);
        arraylist = new zi("", zs.aXc, aWM);
        arraylist1 = new zi("", zs.aXe, aWM);
        aWI.put(zs.aWX, new zd("", zs.aWX, aWM));
        aWI.put(zs.aWY, new zd("", zs.aWY, aWM));
        aWI.put(zs.aWZ, new zd("", zs.aWZ, aWM));
        aWI.put(zs.aXa, sharedpreferences);
        aWI.put(zs.aXf, new zd("", zs.aXf, aWM));
        aWI.put(zs.aXb, ql1);
        aWI.put(zs.aXd, hashmap);
        aWI.put(zs.aXc, arraylist);
        aWI.put(zs.aXe, arraylist1);
        aWJ.add(arraylist);
        aWJ.add(arraylist1);
        aWJ.add(ql1);
        aWJ.add(hashmap);
        aWL.put(zs.aWX, zw.aYC);
        aWL.put(zs.aWY, zw.aYD);
        aWL.put(zs.aXa, zw.aYP);
        aWL.put(zs.aXf, zw.aYG);
    }

    public zp(xd xd1, ql ql1)
    {
        this(PreferenceManager.getDefaultSharedPreferences(xd1), ql1, new HashMap(), new ArrayList(), new ArrayList());
    }

    private List F()
    {
        Object obj;
        obj = aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVM").get(null), null);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        obj = ((PsProfileImageUrls)aWH._mth02CA(((String) (obj)), tv/periscope/android/api/PsProfileImageUrls)).profileImageUrls;
        return ((List) (obj));
_L2:
        return Collections.emptyList();
        Exception exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private Set _mth02CA(String s, String s1, List list, boolean flag)
    {
        if (list != null && !list.isEmpty())
        {
            TreeSet treeset = new TreeSet();
            Iterator iterator = list.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                PsUser psuser = (PsUser)iterator.next();
                aWM.put(psuser.id, psuser);
                if (!psuser.id.equals(s1))
                {
                    list = psuser.id;
                    if (!((zd)aWI.get(zs.aXa))._mth14EA(list))
                    {
                        treeset.add(psuser.id);
                        list = psuser.id;
                        int i = psuser.getNumHeartsGiven();
                        int j = psuser.getParticipantIndex();
                        aty aty1 = (aty)aWP.get(new atl(s, list, flag));
                        list = aty1;
                        if (aty1 == null)
                        {
                            list = new aty(i, j, flag);
                        }
                        aWP.put(new atl(s, psuser.id, flag), list);
                    }
                }
            } while (true);
            return treeset;
        } else
        {
            return Collections.emptySet();
        }
    }

    private void _mth02CA(zs zs1, String s, List list, Map map)
    {
        Object obj1 = (Map)map.get(s);
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = new EnumMap(o/zs);
            map.put(s, obj);
        }
        obj1 = (zd)((Map) (obj)).get(zs1);
        map = ((Map) (obj1));
        if (obj1 == null)
        {
            map = new zd(s, zs1, aWM);
            ((Map) (obj)).put(zs1, map);
        }
        map._mth02BD(list);
    }

    public final String B()
    {
        return aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVC").get(null), null);
    }

    public final void C()
    {
        aWQ.clear();
        aWR.clear();
        Iterator iterator = aWJ.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            zi zi1 = (zi)(zd)iterator.next();
            if (zi1.getUserCount() > 0)
            {
                zi1._mth037A(aWQ);
                if (zi1.x() != zs.aXd)
                {
                    zi1._mth037A(aWR);
                }
            }
        } while (true);
        mEventBus._mth1429(zw.aYF);
    }

    public final void D()
    {
        aWQ.clear();
        aWR.clear();
        for (Iterator iterator = aWJ.iterator(); iterator.hasNext(); ((zd)iterator.next()).z()) { }
    }

    public final String E()
    {
        List list = F();
        if (list != null && !list.isEmpty())
        {
            return ((PsProfileImageUrl)list.get(list.size() - 1)).url;
        } else
        {
            return null;
        }
    }

    public final boolean G()
    {
        return aQC.getBoolean((String)yp.CON._mth02CA("o.yp").getField("aVN").get(null), false);
    }

    public final PsUser H()
    {
        if (aWS == null)
        {
            PsUser psuser = new PsUser();
            psuser.displayName = aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVD").get(null), null);
            psuser.description = aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVF").get(null), null);
            psuser.username = aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVB").get(null), null);
            psuser.id = aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVC").get(null), null);
            psuser.initials = aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVE").get(null), null);
            psuser.profileImageUrls = new ArrayList(F());
            psuser.numHearts = aQC.getInt((String)yp.CON._mth02CA("o.yp").getField("aVK").get(null), 1);
            aWS = psuser;
        } else
        {
            aWS.displayName = aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVD").get(null), null);
            aWS.description = aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVF").get(null), null);
            aWS.profileImageUrls = new ArrayList(F());
        }
        return aWS;
    }

    public final int _mth02CA(String s, zs zs1)
    {
        if (aui.isEmpty(s) || s.equals(H().id))
        {
            return ((zd)aWI.get(zs1)).getUserCount();
        }
        s = (Map)aWK.get(s);
        if (s == null || s.get(zs1) == null)
        {
            return 0;
        } else
        {
            return ((zd)s.get(zs1)).getUserCount();
        }
    }

    public final aty _mth02CA(String s, String s1, boolean flag)
    {
        return (aty)aWP.get(new atl(s, s1, flag));
    }

    public final PsUser _mth02CA(zs zs1, String s, int i)
    {
        if (aui.isEmpty(s) || s.equals(H().id))
        {
            return ((zd)aWI.get(zs1))._mth1D61(i);
        } else
        {
            return ((zd)((Map)aWK.get(s)).get(zs1))._mth1D61(i);
        }
    }

    public final void _mth02CA(String s, String s1, int i, boolean flag)
    {
        aty aty2 = (aty)aWP.get(new atl(s, s1, flag));
        aty aty1 = aty2;
        if (aty2 == null)
        {
            aty1 = new aty(0, i, flag);
        }
        aty1.numHeartsGiven = aty1.numHeartsGiven + 1;
        aWP.put(new atl(s, s1, flag), aty1);
        mEventBus._mth1429(new zx(s, s1, flag, aty1.numHeartsGiven));
    }

    public final void _mth02CA(String s, String s1, ArrayList arraylist, ArrayList arraylist1)
    {
        aWN.put(s1, _mth02CA(s1, s, ((List) (arraylist)), false));
        aWO.put(s1, _mth02CA(s1, s, ((List) (arraylist1)), true));
        mEventBus._mth1429(zw.aYJ);
    }

    public final void _mth02CA(String s, String s1, List list)
    {
        if (list == null)
        {
            return;
        }
        int j = list.size();
        int i = 0;
        ArrayList arraylist = new ArrayList(list.size());
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Occupant occupant = (Occupant)iterator.next();
            if (aWM.containsKey(occupant.userId))
            {
                arraylist.add(aWM.get(occupant.userId));
            } else
            {
                if (aui.isEmpty(occupant.displayName))
                {
                    i++;
                    continue;
                }
                list = new PsUser();
                list.displayName = occupant.displayName;
                String s2 = occupant.profileImageUrl;
                list.profileUrlLarge = s2;
                list.profileUrlMedium = s2;
                list.profileUrlSmall = s2;
                list.username = occupant.username;
                list.id = occupant.userId;
                arraylist.add(list);
            }
            list = occupant.userId;
            int k = occupant.participantIndex;
            aty aty1 = (aty)aWP.get(new atl(s1, list, false));
            list = aty1;
            if (aty1 == null)
            {
                list = new aty(0, k, false);
            }
            aWP.put(new atl(s1, occupant.userId, false), list);
        } while (true);
        list = xd._mth216D();
        j = Math.max(0, j - 1);
        ((yv) (list)).aWi.put(s1, new atd(i, 0, j));
        _mth02CA(s, s1, arraylist, ((ArrayList) (null)));
    }

    public final void _mth02CA(zs zs1, String s, List list)
    {
        if (aui.isEmpty(s) || s.equals(H().id))
        {
            ((zd)aWI.get(zs1))._mth02BD(list);
        } else
        {
            _mth02CA(zs1, s, list, ((Map) (aWK)));
        }
        zs1 = (zw)aWL.get(zs1);
        if (zs1 != null)
        {
            mEventBus._mth1429(zs1);
        }
    }

    public final void _mth02CA(PsUser psuser)
    {
        Object obj = new PsProfileImageUrls();
        obj.profileImageUrls = psuser.profileImageUrls;
        android.content.SharedPreferences.Editor editor = aQC.edit();
        editor.putString((String)yp.CON._mth02CA("o.yp").getField("aVC").get(null), psuser.id);
        editor.putString((String)yp.CON._mth02CA("o.yp").getField("aVB").get(null), psuser.username);
        editor.putString((String)yp.CON._mth02CA("o.yp").getField("aVF").get(null), psuser.description);
        editor.putString((String)yp.CON._mth02CA("o.yp").getField("aVD").get(null), psuser.displayName);
        editor.putString((String)yp.CON._mth02CA("o.yp").getField("aVE").get(null), psuser.initials);
        String s = (String)yp.CON._mth02CA("o.yp").getField("aVM").get(null);
        ig ig1 = aWH;
        if (obj == null)
        {
            obj = ig1._mth02CA(is.GB);
        } else
        {
            obj = ig1._mth02CA(obj, obj.getClass());
        }
        editor.putString(s, ((String) (obj)));
        editor.putInt((String)yp.CON._mth02CA("o.yp").getField("aVG").get(null), psuser.numFollowers);
        editor.putInt((String)yp.CON._mth02CA("o.yp").getField("aVH").get(null), psuser.numFollowing);
        editor.putInt((String)yp.CON._mth02CA("o.yp").getField("aVK").get(null), Math.max(psuser.numHearts, 1));
        editor.putBoolean((String)yp.CON._mth02CA("o.yp").getField("aVN").get(null), psuser.isEmployee);
        editor.putBoolean((String)yp.CON._mth02CA("o.yp").getField("aVO").get(null), psuser.isVerified);
        editor.apply();
        aWS = null;
        H();
        xf._mth02CA(this, xd._mth1FEB());
        mEventBus._mth1429(zw.aYB);
    }

    public final boolean _mth14EB(String s)
    {
        return ((zd)aWI.get(zs.aXa))._mth14EA(s);
    }

    public final zs _mth153E(String s)
    {
        if (((zd)aWI.get(zs.aXc))._mth14EA(s))
        {
            return zs.aXc;
        }
        if (((zd)aWI.get(zs.aXb))._mth14EA(s))
        {
            return zs.aXb;
        }
        if (((zd)aWI.get(zs.aXe))._mth14EA(s))
        {
            return zs.aXe;
        }
        if (((zd)aWI.get(zs.aXd))._mth14EA(s))
        {
            return zs.aXd;
        }
        if (((zd)aWI.get(zs.aXf))._mth14EA(s))
        {
            return zs.aXf;
        } else
        {
            return null;
        }
    }

    public final void _mth1D62(String s, String s1)
    {
        android.content.SharedPreferences.Editor editor = aQC.edit();
        editor.putString((String)yp.CON._mth02CA("o.yp").getField("aVQ").get(null), s);
        editor.putString((String)yp.CON._mth02CA("o.yp").getField("aVR").get(null), s1);
        editor.apply();
        mEventBus._mth1429(zw.aYK);
    }

    static 
    {
        im im1 = new im();
        SafeListAdapter safelistadapter = new SafeListAdapter();
        im1.Gv.add(safelistadapter);
        aWH = im1._mth0490();
    }
}
