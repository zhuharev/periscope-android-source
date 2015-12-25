// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.vcard;

import android.telephony.PhoneNumberUtils;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.digits.sdk.vcard:
//            VCardConfig, JapaneseUtils

public class VCardUtils
{
    public static class PhoneNumberUtilsPort
    {

        public static String formatNumber(String s, int i)
        {
            s = new SpannableStringBuilder(s);
            PhoneNumberUtils.formatNumber(s, i);
            return s.toString();
        }

        public PhoneNumberUtilsPort()
        {
        }
    }

    public static class TextUtilsPort
    {

        public static boolean isPrintableAscii(char c)
        {
            return ' ' <= c && c <= '~' || c == '\r' || c == '\n';
        }

        public static boolean isPrintableAsciiOnly(CharSequence charsequence)
        {
            int j = charsequence.length();
            for (int i = 0; i < j; i++)
            {
                if (!isPrintableAscii(charsequence.charAt(i)))
                {
                    return false;
                }
            }

            return true;
        }

        public TextUtilsPort()
        {
        }
    }


    private static final String LOG_TAG = "vCard";
    private static final int sEscapeIndicatorsV30[] = {
        58, 59, 44, 32
    };
    private static final int sEscapeIndicatorsV40[] = {
        59, 58
    };
    private static final SparseArray sKnownImPropNameMap_ItoS;
    private static final Map sKnownPhoneTypeMap_StoI;
    private static final SparseArray sKnownPhoneTypesMap_ItoS;
    private static final Set sMobilePhoneLabelSet = new HashSet(Arrays.asList(new String[] {
        "MOBILE", "\u643A\u5E2F\u96FB\u8A71", "\u643A\u5E2F", "\u30B1\u30A4\u30BF\u30A4", "\uFF79\uFF72\uFF80\uFF72"
    }));
    private static final Set sPhoneTypesUnknownToContactsSet;
    private static final Set sUnAcceptableAsciiInV21WordSet = new HashSet(Arrays.asList(new Character[] {
        Character.valueOf('['), Character.valueOf(']'), Character.valueOf('='), Character.valueOf(':'), Character.valueOf('.'), Character.valueOf(','), Character.valueOf(' ')
    }));

    private VCardUtils()
    {
    }

    public static String constructNameFromElements(int i, String s, String s1, String s2)
    {
        return constructNameFromElements(i, s, s1, s2, null, null);
    }

    public static String constructNameFromElements(int i, String s, String s1, String s2, String s3, String s4)
    {
        StringBuilder stringbuilder = new StringBuilder();
        s = sortNameElements(i, s, s1, s2);
        i = 1;
        if (!TextUtils.isEmpty(s3))
        {
            i = 0;
            stringbuilder.append(s3);
        }
        int l = s.length;
        for (int j = 0; j < l;)
        {
            s1 = s[j];
            int k = i;
            if (!TextUtils.isEmpty(s1))
            {
                if (i != 0)
                {
                    i = 0;
                } else
                {
                    stringbuilder.append(' ');
                }
                stringbuilder.append(s1);
                k = i;
            }
            j++;
            i = k;
        }

        if (!TextUtils.isEmpty(s4))
        {
            if (i == 0)
            {
                stringbuilder.append(' ');
            }
            stringbuilder.append(s4);
        }
        return stringbuilder.toString();
    }

    public static boolean containsOnlyAlphaDigitHyphen(Collection collection)
    {
        if (collection == null)
        {
            return true;
        }
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            String s = (String)collection.next();
            if (!TextUtils.isEmpty(s))
            {
                int j = s.length();
                int i = 0;
                while (i < j) 
                {
                    int k = s.codePointAt(i);
                    if ((97 > k || k >= 123) && (65 > k || k >= 91) && (48 > k || k >= 58) && k != 45)
                    {
                        return false;
                    }
                    i = s.offsetByCodePoints(i, 1);
                }
            }
        } while (true);
        return true;
    }

    public static transient boolean containsOnlyAlphaDigitHyphen(String as[])
    {
        if (as == null)
        {
            return true;
        } else
        {
            return containsOnlyAlphaDigitHyphen(((Collection) (Arrays.asList(as))));
        }
    }

    public static boolean containsOnlyNonCrLfPrintableAscii(Collection collection)
    {
        if (collection == null)
        {
            return true;
        }
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            String s = (String)collection.next();
            if (!TextUtils.isEmpty(s))
            {
                int j = s.length();
                int i = 0;
                while (i < j) 
                {
                    int k = s.codePointAt(i);
                    if (32 > k || k > 126)
                    {
                        return false;
                    }
                    i = s.offsetByCodePoints(i, 1);
                }
            }
        } while (true);
        return true;
    }

    public static transient boolean containsOnlyNonCrLfPrintableAscii(String as[])
    {
        if (as == null)
        {
            return true;
        } else
        {
            return containsOnlyNonCrLfPrintableAscii(((Collection) (Arrays.asList(as))));
        }
    }

    public static boolean containsOnlyPrintableAscii(Collection collection)
    {
        if (collection == null)
        {
            return true;
        }
        for (collection = collection.iterator(); collection.hasNext();)
        {
            String s = (String)collection.next();
            if (!TextUtils.isEmpty(s) && !TextUtilsPort.isPrintableAsciiOnly(s))
            {
                return false;
            }
        }

        return true;
    }

    public static transient boolean containsOnlyPrintableAscii(String as[])
    {
        if (as == null)
        {
            return true;
        } else
        {
            return containsOnlyPrintableAscii(((Collection) (Arrays.asList(as))));
        }
    }

    public static boolean containsOnlyWhiteSpaces(Collection collection)
    {
        if (collection == null)
        {
            return true;
        }
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            String s = (String)collection.next();
            if (!TextUtils.isEmpty(s))
            {
                int j = s.length();
                int i = 0;
                while (i < j) 
                {
                    if (!Character.isWhitespace(s.codePointAt(i)))
                    {
                        return false;
                    }
                    i = s.offsetByCodePoints(i, 1);
                }
            }
        } while (true);
        return true;
    }

    public static transient boolean containsOnlyWhiteSpaces(String as[])
    {
        if (as == null)
        {
            return true;
        } else
        {
            return containsOnlyWhiteSpaces(((Collection) (Arrays.asList(as))));
        }
    }

    public static int getPhoneNumberFormat(int i)
    {
        return !VCardConfig.isJapaneseDevice(i) ? 1 : 2;
    }

    public static String getPhoneTypeString(Integer integer)
    {
        return (String)sKnownPhoneTypesMap_ItoS.get(integer.intValue());
    }

    public static String getPropertyNameForIm(int i)
    {
        return (String)sKnownImPropNameMap_ItoS.get(i);
    }

    public static boolean isMobilePhoneLabel(String s)
    {
        return "_AUTO_CELL".equals(s) || sMobilePhoneLabelSet.contains(s);
    }

    public static boolean isV21Word(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return true;
        }
        int j = s.length();
        for (int i = 0; i < j; i = s.offsetByCodePoints(i, 1))
        {
            int k = s.codePointAt(i);
            if (32 > k || k > 126 || sUnAcceptableAsciiInV21WordSet.contains(Character.valueOf((char)k)))
            {
                return false;
            }
        }

        return true;
    }

    public static boolean isValidInV21ButUnknownToContactsPhoteType(String s)
    {
        return sPhoneTypesUnknownToContactsSet.contains(s);
    }

    public static String[] sortNameElements(int i, String s, String s1, String s2)
    {
        String as[] = new String[3];
        switch (VCardConfig.getNameOrderType(i))
        {
        case 8: // '\b'
            if (!containsOnlyPrintableAscii(new String[] {
    s
}) || !containsOnlyPrintableAscii(new String[] {
    s2
}))
            {
                as[0] = s;
                as[1] = s1;
                as[2] = s2;
                return as;
            }
            break;

        case 4: // '\004'
            as[0] = s1;
            as[1] = s2;
            as[2] = s;
            return as;
        }
        as[0] = s2;
        as[1] = s1;
        as[2] = s;
        return as;
    }

    public static String toHalfWidthString(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder();
        int j = s.length();
        for (int i = 0; i < j; i = s.offsetByCodePoints(i, 1))
        {
            char c = s.charAt(i);
            String s1 = JapaneseUtils.tryGetHalfWidthText(c);
            if (s1 != null)
            {
                stringbuilder.append(s1);
            } else
            {
                stringbuilder.append(c);
            }
        }

        return stringbuilder.toString();
    }

    private static String toStringAsParamValue(String s, int ai[])
    {
        String s1 = s;
        if (TextUtils.isEmpty(s))
        {
            s1 = "";
        }
        s = new StringBuilder();
        int k = s1.length();
        boolean flag = false;
        for (int i = 0; i < k;)
        {
            int l = s1.codePointAt(i);
            boolean flag1 = flag;
            if (l >= 32)
            {
                flag1 = flag;
                if (l != 34)
                {
                    s.appendCodePoint(l);
                    int i1 = ai.length;
                    int j = 0;
                    do
                    {
                        flag1 = flag;
                        if (j >= i1)
                        {
                            break;
                        }
                        if (l == ai[j])
                        {
                            flag1 = true;
                            break;
                        }
                        j++;
                    } while (true);
                }
            }
            i = s1.offsetByCodePoints(i, 1);
            flag = flag1;
        }

        s = s.toString();
        if (s.length() == 0 || containsOnlyWhiteSpaces(new String[] {
    s
}))
        {
            return "";
        }
        if (flag)
        {
            return (new StringBuilder("\"")).append(s).append('"').toString();
        } else
        {
            return s;
        }
    }

    public static String toStringAsV30ParamValue(String s)
    {
        return toStringAsParamValue(s, sEscapeIndicatorsV30);
    }

    public static String toStringAsV40ParamValue(String s)
    {
        return toStringAsParamValue(s, sEscapeIndicatorsV40);
    }

    static 
    {
        sKnownPhoneTypesMap_ItoS = new SparseArray();
        sKnownPhoneTypeMap_StoI = new HashMap();
        sKnownPhoneTypesMap_ItoS.put(9, "CAR");
        sKnownPhoneTypeMap_StoI.put("CAR", Integer.valueOf(9));
        sKnownPhoneTypesMap_ItoS.put(6, "PAGER");
        sKnownPhoneTypeMap_StoI.put("PAGER", Integer.valueOf(6));
        sKnownPhoneTypesMap_ItoS.put(11, "ISDN");
        sKnownPhoneTypeMap_StoI.put("ISDN", Integer.valueOf(11));
        sKnownPhoneTypeMap_StoI.put("HOME", Integer.valueOf(1));
        sKnownPhoneTypeMap_StoI.put("WORK", Integer.valueOf(3));
        sKnownPhoneTypeMap_StoI.put("CELL", Integer.valueOf(2));
        sKnownPhoneTypeMap_StoI.put("OTHER", Integer.valueOf(7));
        sKnownPhoneTypeMap_StoI.put("CALLBACK", Integer.valueOf(8));
        sKnownPhoneTypeMap_StoI.put("COMPANY-MAIN", Integer.valueOf(10));
        sKnownPhoneTypeMap_StoI.put("RADIO", Integer.valueOf(14));
        sKnownPhoneTypeMap_StoI.put("TTY-TDD", Integer.valueOf(16));
        sKnownPhoneTypeMap_StoI.put("ASSISTANT", Integer.valueOf(19));
        sKnownPhoneTypeMap_StoI.put("VOICE", Integer.valueOf(7));
        Object obj = new HashSet();
        sPhoneTypesUnknownToContactsSet = ((Set) (obj));
        ((Set) (obj)).add("MODEM");
        sPhoneTypesUnknownToContactsSet.add("MSG");
        sPhoneTypesUnknownToContactsSet.add("BBS");
        sPhoneTypesUnknownToContactsSet.add("VIDEO");
        obj = new SparseArray();
        sKnownImPropNameMap_ItoS = ((SparseArray) (obj));
        ((SparseArray) (obj)).put(0, "X-AIM");
        sKnownImPropNameMap_ItoS.put(1, "X-MSN");
        sKnownImPropNameMap_ItoS.put(2, "X-YAHOO");
        sKnownImPropNameMap_ItoS.put(3, "X-SKYPE-USERNAME");
        sKnownImPropNameMap_ItoS.put(5, "X-GOOGLE-TALK");
        sKnownImPropNameMap_ItoS.put(6, "X-ICQ");
        sKnownImPropNameMap_ItoS.put(7, "X-JABBER");
        sKnownImPropNameMap_ItoS.put(4, "X-QQ");
        sKnownImPropNameMap_ItoS.put(8, "X-NETMEETING");
    }
}
