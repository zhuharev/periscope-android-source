// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

final class MarketingCondition
{
    static final class Opt extends Enum
    {

        private static final Opt $VALUES[];
        public static final Opt BETWEEN;
        public static final Opt EQUAL;
        public static final Opt GREATER_THAN;
        public static final Opt GREATER_THEN_OR_EQUAL;
        public static final Opt INVALID;
        public static final Opt IN_LIST;
        public static final Opt LESS_THAN;
        public static final Opt LESS_THAN_OR_EQUAL;
        public static final Opt NOT_EQUAL;

        public static Opt valueOf(String s)
        {
            return (Opt)Enum.valueOf(com/localytics/android/MarketingCondition$Opt, s);
        }

        public static Opt[] values()
        {
            return (Opt[])$VALUES.clone();
        }

        static 
        {
            INVALID = new Opt("INVALID", 0);
            EQUAL = new Opt("EQUAL", 1);
            NOT_EQUAL = new Opt("NOT_EQUAL", 2);
            GREATER_THAN = new Opt("GREATER_THAN", 3);
            GREATER_THEN_OR_EQUAL = new Opt("GREATER_THEN_OR_EQUAL", 4);
            LESS_THAN = new Opt("LESS_THAN", 5);
            LESS_THAN_OR_EQUAL = new Opt("LESS_THAN_OR_EQUAL", 6);
            BETWEEN = new Opt("BETWEEN", 7);
            IN_LIST = new Opt("IN_LIST", 8);
            $VALUES = (new Opt[] {
                INVALID, EQUAL, NOT_EQUAL, GREATER_THAN, GREATER_THEN_OR_EQUAL, LESS_THAN, LESS_THAN_OR_EQUAL, BETWEEN, IN_LIST
            });
        }

        private Opt(String s, int i)
        {
            super(s, i);
        }
    }


    private final String mName;
    private final Opt mOpt;
    private String mPkgName;
    private final Vector mValues;

    MarketingCondition(String s, String s1, Vector vector)
    {
        mName = s;
        mOpt = stringToOperator(s1);
        mValues = vector;
    }

    private boolean isSatisfiedByNumber(String s)
    {
        s = new BigDecimal(s);
        int j = s.compareTo(new BigDecimal((String)mValues.get(0)));
        int i;
        if (mValues.size() > 1)
        {
            i = s.compareTo(new BigDecimal((String)mValues.get(1)));
        } else
        {
            i = 0;
        }
        static class _cls1
        {

            static final int $SwitchMap$com$localytics$android$MarketingCondition$Opt[];

            static 
            {
                $SwitchMap$com$localytics$android$MarketingCondition$Opt = new int[Opt.values().length];
                try
                {
                    $SwitchMap$com$localytics$android$MarketingCondition$Opt[Opt.EQUAL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
                try
                {
                    $SwitchMap$com$localytics$android$MarketingCondition$Opt[Opt.NOT_EQUAL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$localytics$android$MarketingCondition$Opt[Opt.IN_LIST.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$localytics$android$MarketingCondition$Opt[Opt.GREATER_THAN.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$localytics$android$MarketingCondition$Opt[Opt.GREATER_THEN_OR_EQUAL.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$localytics$android$MarketingCondition$Opt[Opt.LESS_THAN.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$localytics$android$MarketingCondition$Opt[Opt.LESS_THAN_OR_EQUAL.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$localytics$android$MarketingCondition$Opt[Opt.BETWEEN.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$localytics$android$MarketingCondition$Opt[Opt.INVALID.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
            }
        }

        Iterator iterator;
        switch (_cls1..SwitchMap.com.localytics.android.MarketingCondition.Opt[mOpt.ordinal()])
        {
        default:
            return false;

        case 1: // '\001'
            boolean flag;
            if (j == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return flag;

        case 2: // '\002'
            boolean flag1;
            if (j != 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            return flag1;

        case 4: // '\004'
            boolean flag2;
            if (j > 0)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            return flag2;

        case 5: // '\005'
            boolean flag3;
            if (j >= 0)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            return flag3;

        case 6: // '\006'
            boolean flag4;
            if (j < 0)
            {
                flag4 = true;
            } else
            {
                flag4 = false;
            }
            return flag4;

        case 7: // '\007'
            boolean flag5;
            if (j <= 0)
            {
                flag5 = true;
            } else
            {
                flag5 = false;
            }
            return flag5;

        case 8: // '\b'
            boolean flag6;
            if (j >= 0 && i <= 0)
            {
                flag6 = true;
            } else
            {
                flag6 = false;
            }
            return flag6;

        case 3: // '\003'
            iterator = mValues.iterator();
            break;
        }
        while (iterator.hasNext()) 
        {
            if (s.compareTo(new BigDecimal((String)iterator.next())) == 0)
            {
                return true;
            }
        }
        return false;
    }

    private boolean isSatisfiedByString(String s)
    {
        switch (_cls1..SwitchMap.com.localytics.android.MarketingCondition.Opt[mOpt.ordinal()])
        {
        case 1: // '\001'
            return s.equals(mValues.get(0));

        case 2: // '\002'
            boolean flag;
            if (!s.equals(mValues.get(0)))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return flag;

        case 3: // '\003'
            for (Iterator iterator = mValues.iterator(); iterator.hasNext();)
            {
                if (s.equals((String)iterator.next()))
                {
                    return true;
                }
            }

            return false;
        }
        return isSatisfiedByNumber(s);
    }

    private String operatorToString(Opt opt)
    {
        switch (_cls1..SwitchMap.com.localytics.android.MarketingCondition.Opt[opt.ordinal()])
        {
        case 1: // '\001'
            return "is equal to";

        case 2: // '\002'
            return "not equal to";

        case 4: // '\004'
            return "is greater than";

        case 5: // '\005'
            return "is greater than or equal to";

        case 6: // '\006'
            return "is less than";

        case 7: // '\007'
            return "is less than or equal to";

        case 8: // '\b'
            return "is in between values";

        case 3: // '\003'
            return "is a member of the list";
        }
        return "INVALID OPERATOR";
    }

    private Opt stringToOperator(String s)
    {
        if (s.equals("eq"))
        {
            return Opt.EQUAL;
        }
        if (s.equals("neq"))
        {
            return Opt.NOT_EQUAL;
        }
        if (s.equals("gt"))
        {
            return Opt.GREATER_THAN;
        }
        if (s.equals("gte"))
        {
            return Opt.GREATER_THEN_OR_EQUAL;
        }
        if (s.equals("lt"))
        {
            return Opt.LESS_THAN;
        }
        if (s.equals("lte"))
        {
            return Opt.LESS_THAN_OR_EQUAL;
        }
        if (s.equals("btw"))
        {
            return Opt.BETWEEN;
        }
        if (s.equals("in"))
        {
            return Opt.IN_LIST;
        } else
        {
            return Opt.INVALID;
        }
    }

    final boolean isSatisfiedByAttributes(Map map)
    {
        if (map == null)
        {
            return false;
        }
        Object obj1 = map.get(mName);
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = map.get((new StringBuilder()).append(mPkgName).append(":").append(mName).toString());
        }
        if (obj == null)
        {
            Localytics.Log.w(String.format("Could not find the in-app condition %s in the attributes dictionary.", new Object[] {
                mName
            }));
            return false;
        }
        if (obj instanceof String)
        {
            return isSatisfiedByString((String)obj);
        }
        if (obj instanceof Number)
        {
            return isSatisfiedByNumber((String)obj);
        } else
        {
            Localytics.Log.w(String.format("Invalid value type %s in the attributes dictionary.", new Object[] {
                obj.getClass().getCanonicalName()
            }));
            return false;
        }
    }

    final void setPackageName(String s)
    {
        mPkgName = s;
    }
}
