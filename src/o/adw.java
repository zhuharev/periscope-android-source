// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.location.Location;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package o:
//            zg, _cls0993, yv, atn, 
//            zp, ato, afz, aga, 
//            afr, aff, afi, afy, 
//            afj, afe, atq, aos, 
//            adt, zx, adk, ada

public final class adw
    implements zg
{

    String bei;
    private final adk bej;
    private final boolean bfA;
    Location bfB;
    adt._cls02BB bfC;
    zg.if bfD;
    final ArrayList bfz = new ArrayList();
    final yv mBroadcastCacheManager;
    private final Context mContext;
    final zp mUserManager;

    public adw(ada ada, zp zp1, yv yv1, adk adk)
    {
        mContext = ada;
        mBroadcastCacheManager = yv1;
        bej = adk;
        mUserManager = zp1;
        boolean flag;
        if (_cls0993._mth1D4E(ada) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bfA = flag;
    }

    public final void A()
    {
        Object obj;
label0:
        {
            bfz.clear();
            obj = mBroadcastCacheManager;
            String s = bei;
            obj = (atn)((yv) (obj)).aWg.get(s);
            if (obj == null)
            {
                return;
            }
            if (bfC != null)
            {
                bfz.add(0, bfC);
            }
            if (((atn) (obj)).eV() && !TextUtils.isEmpty(((atn) (obj)).eY()))
            {
                adt._cls02CE _lcls02ce = new adt._cls02CE(((atn) (obj)).eY(), ((atn) (obj)).eW(), ((atn) (obj)).eX());
                bfz.add(new adt._cls02CB(_lcls02ce));
            }
            if (!bfA)
            {
                break label0;
            }
            if (((atn) (obj)).bu())
            {
                double d = ((atn) (obj)).fb();
                double d1 = ((atn) (obj)).fc();
                boolean flag;
                if (d != 0.0D || d1 != 0.0D)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    bfz.add(new adt.aux(((atn) (obj)).fb(), ((atn) (obj)).fc()));
                    break label0;
                }
            }
            if (_cls141D.if._mth02CA(bfB))
            {
                bfz.add(new adt.aux(bfB.getLatitude(), bfB.getLongitude()));
            }
        }
        bfz.add(new adt._cls02CA(this));
        if (((atn) (obj)).fd().equals(mUserManager.aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVC").get(null), null)))
        {
            ArrayList arraylist = new ArrayList();
            int i = ((atn) (obj)).bDW;
            boolean flag1;
            if (i == ato.bEf || i == ato.bEe)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                if (bfC != null)
                {
                    arraylist.add(new afz(bei, bej));
                }
                if (((atn) (obj)).bDX)
                {
                    if (!((atn) (obj)).fe())
                    {
                        arraylist.add(new aga(bei, bej));
                    }
                    arraylist.add(new afr(bei, bej));
                }
                arraylist.add(new aff(bei, bej));
            }
            arraylist.add(new afi(bei, bej));
            bfz.add(new adt.if(arraylist));
        } else
        {
            ArrayList arraylist1 = new ArrayList();
            if (!((atn) (obj)).fe())
            {
                boolean flag2;
                if (((atn) (obj)).bDW == ato.bEd)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                if (flag2 || ((atn) (obj)).bDX)
                {
                    arraylist1.add(new aga(bei, bej));
                }
            }
            arraylist1.add(new afi(bei, bej));
            arraylist1.add(new afy(bei, bej));
            if (mUserManager.aQC.getBoolean((String)yp.CON._mth02CA("o.yp").getField("aVN").get(null), false))
            {
                boolean flag3;
                if (((atn) (obj)).bDW == ato.bEd)
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
                if (flag3)
                {
                    arraylist1.add(new afj(bei, bej));
                    arraylist1.add(new afe(bei, bej));
                }
            }
            bfz.add(new adt.if(arraylist1));
        }
        Object obj1 = mUserManager;
        Object obj2 = bei;
        obj1 = (Set)((zp) (obj1)).aWO.get(obj2);
        obj2 = mUserManager;
        Object obj3 = bei;
        obj2 = (Set)((zp) (obj2)).aWN.get(obj3);
        Resources resources = mContext.getResources();
        if ((obj1 == null || ((Set) (obj1)).isEmpty()) && (obj2 == null || ((Set) (obj2)).isEmpty()))
        {
            bfz.add(new adt._cls02CF(resources.getString(0x7f0600ef)));
            return;
        }
        obj3 = ((atn) (obj)).id();
        obj3 = (atq)mBroadcastCacheManager.aWi.get(obj3);
        if (obj1 != null && !((Set) (obj1)).isEmpty())
        {
            int j;
            if (obj3 == null)
            {
                j = 0;
            } else
            {
                j = ((atq) (obj3)).fr();
            }
            bfz.add(new adt._cls02CF(resources.getQuantityString(0x7f070003, j, new Object[] {
                aos._mth02CA(resources, j, true)
            })));
            j = 0;
            obj = ((Set) (obj1)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                String s2 = (String)((Iterator) (obj)).next();
                bfz.add(new adt._cls037A(this, bei, s2, true));
                j++;
            } while (j < 15);
            if (((Set) (obj1)).size() > 15 && obj3 != null)
            {
                bfz.add(new adt._cls141D(((atq) (obj3)), adt._cls141D.if.bfi, 15));
            }
        } else
        {
            boolean flag4;
            if (((atn) (obj)).bDW == ato.bEd)
            {
                flag4 = true;
            } else
            {
                flag4 = false;
            }
            if (!flag4 && ((atn) (obj)).bDX)
            {
                bfz.add(new adt._cls02CF(resources.getString(0x7f0600ee)));
            }
        }
        if (obj2 != null && !((Set) (obj2)).isEmpty())
        {
            int k;
            if (obj3 == null)
            {
                k = 0;
            } else
            {
                k = ((atq) (obj3)).fs() + ((atq) (obj3)).fq();
            }
            bfz.add(new adt._cls02CF(resources.getQuantityString(0x7f070002, k, new Object[] {
                aos._mth02CA(resources, k, true)
            })));
            k = 0;
            Iterator iterator = ((Set) (obj2)).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s1 = (String)iterator.next();
                bfz.add(new adt._cls037A(this, bei, s1, false));
                k++;
            } while (k < 15);
            if (((Set) (obj2)).size() > 15 && obj3 != null)
            {
                bfz.add(new adt._cls141D(((atq) (obj3)), adt._cls141D.if.bfh, 15));
            }
        }
    }

    public final String id()
    {
        return "viewer_provider";
    }

    public final int v()
    {
        return bfz.size();
    }

    public final void _mth02CA(zx zx1)
    {
        int i = 0;
        for (Iterator iterator = bfz.iterator(); iterator.hasNext(); i++)
        {
            Object obj = (adt)iterator.next();
            if (!(obj instanceof adt._cls037A))
            {
                continue;
            }
            obj = (adt._cls037A)obj;
            if (zx1.userId.equals(((adt._cls037A) (obj)).userId) && zx1.aYS == ((adt._cls037A) (obj)).aYS)
            {
                bfD._mth2071(i, 1);
                return;
            }
        }

    }

    public final Object _mth1D4A(int i)
    {
        return (adt)bfz.get(i);
    }
}
