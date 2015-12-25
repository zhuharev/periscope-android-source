// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.hardware.Camera;
import android.os.Build;
import java.util.Iterator;
import java.util.List;
import tv.periscope.android.util.Size;

// Referenced classes of package o:
//            FF6A

public final class aoe
{

    private static boolean buS;

    public aoe()
    {
    }

    public static Camera _mth02CA(int i, android.hardware.Camera.CameraInfo camerainfo)
    {
        int k = Camera.getNumberOfCameras();
        for (int j = 0; j < k; j++)
        {
            Camera.getCameraInfo(j, camerainfo);
            if (camerainfo.facing == i)
            {
                return Camera.open(j);
            }
        }

        Camera.getCameraInfo(0, camerainfo);
        return Camera.open(0);
    }

    public static Size _mth02CA(Size size, List list)
    {
        if (list == null)
        {
            return null;
        }
        Object obj = null;
        float f1 = -1F;
        Iterator iterator = list.iterator();
        list = obj;
        float f2;
        for (; iterator.hasNext(); f1 = f2)
        {
            Size size3 = Size._mth02CA((android.hardware.Camera.Size)iterator.next());
            Size size2 = size;
            boolean flag;
            if (size.bac * size._fld0575 <= 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            float f;
            if (flag)
            {
                f = 0.0F;
            } else
            {
                f = (float)size.bac / (float)size._fld0575;
            }
            if (size3.bac * size3._fld0575 <= 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                f2 = 0.0F;
            } else
            {
                f2 = (float)size3.bac / (float)size3._fld0575;
            }
            if (f < 1.0F)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            boolean flag2;
            if (f2 < 1.0F)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            Size size1 = size2;
            if (flag != flag2)
            {
                size2 = Size._mth05D5(size2._fld0575, size2.bac);
                size1 = size2;
                boolean flag1;
                if (size2.bac * size2._fld0575 <= 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag1)
                {
                    f = 0.0F;
                } else
                {
                    f = (float)size2.bac / (float)size2._fld0575;
                }
            }
            if (f < f2)
            {
                size2 = Size._mth02BE((float)size1._fld0575 * f2, size1._fld0575);
            } else
            {
                size2 = Size._mth02BE(size1.bac, (float)size1.bac / f2);
            }
            int i = size2.bac * size2._fld0575 - size3.bac * size3._fld0575;
            if (i > 0)
            {
                f = i;
            } else
            {
                f = (float)(-i) * 25F;
            }
            FF6A._mth02CB("RTMP", (new StringBuilder("Display: ")).append(size1).append(" Camera: ").append(size3).append(" AR size: ").append(size2).append(" Score: ").append(f).toString());
            if (f >= f1)
            {
                f2 = f1;
                if (f1 >= 0.0F)
                {
                    continue;
                }
            }
            list = size3;
            f2 = f;
        }

        return list;
    }

    public static boolean _mth02CA(Camera camera, android.hardware.Camera.Parameters parameters)
    {
        String s;
        Object obj;
        s = "";
        obj = parameters.getSupportedFocusModes();
        if (obj == null)
        {
            return false;
        }
        if (buS)
        {
            s = "auto";
        } else
        if (((List) (obj)).contains("continuous-video"))
        {
            s = "continuous-video";
        } else
        if (((List) (obj)).contains("infinity"))
        {
            s = "infinity";
        }
        obj = parameters.getFocusMode();
        if (s.equals("")) goto _L2; else goto _L1
_L1:
        parameters.setFocusMode(s);
        camera.setParameters(parameters);
        return true;
_L4:
        parameters.setFocusMode(((String) (obj)));
_L2:
        return false;
        camera;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static int[] _mth02CA(int i, List list)
    {
        if (list == null)
        {
            return null;
        }
        i = 0x7fffffff;
        int k = 0;
        Object obj = null;
        Iterator iterator = list.iterator();
        list = obj;
        while (iterator.hasNext()) 
        {
            Object obj1;
            int j;
            int l;
label0:
            {
                int ai[] = (int[])iterator.next();
                int j1 = ai[0];
                int i1 = ai[1];
                l = k;
                obj1 = list;
                j = i;
                if (i1 < 24000)
                {
                    break label0;
                }
                l = k;
                obj1 = list;
                j = i;
                if (j1 > 24000)
                {
                    break label0;
                }
                if (j1 >= i)
                {
                    l = k;
                    obj1 = list;
                    j = i;
                    if (j1 != i)
                    {
                        break label0;
                    }
                    l = k;
                    obj1 = list;
                    j = i;
                    if (i1 <= k)
                    {
                        break label0;
                    }
                }
                j = j1;
                l = i1;
                obj1 = ai;
            }
            k = l;
            list = ((List) (obj1));
            i = j;
        }
        return list;
    }

    static 
    {
        boolean flag;
        if (Build.MODEL.contains("GT-I9505") || Build.MODEL.contains("GT-I9506") || Build.MODEL.contains("GT-I9500") || Build.MODEL.contains("SGH-I337") || Build.MODEL.contains("SGH-M919") || Build.MODEL.contains("SCH-I545") || Build.MODEL.contains("SPH-L720") || Build.MODEL.contains("GT-I9508") || Build.MODEL.contains("SHV-E300") || Build.MODEL.contains("SCH-R970") || Build.MODEL.contains("SM-N900") || Build.MODEL.contains("LG-D801"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        buS = flag;
    }
}
