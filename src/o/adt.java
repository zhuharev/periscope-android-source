// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public interface adt
{
    public static final class aux
        implements adt
    {

        final LatLng beN;

        public final int bc()
        {
            return _cls02BD.bfo;
        }

        public aux(double d, double d1)
        {
            beN = new LatLng(d, d1);
        }
    }

    public static final class if
        implements adt
    {

        final List bfb;

        public final int bc()
        {
            return _cls02BD.bfp;
        }

        public if(ArrayList arraylist)
        {
            bfb = arraylist;
        }
    }

    /* member class not found */
    class _cls02BB {}

    /* member class not found */
    class _cls02BC {}

    /* member class not found */
    class _cls02BD {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}

    /* member class not found */
    class _cls02CF {}

    /* member class not found */
    class _cls037A {}

    /* member class not found */
    class _cls141D {}

    /* member class not found */
    class if {}


    public abstract int bc();
}
