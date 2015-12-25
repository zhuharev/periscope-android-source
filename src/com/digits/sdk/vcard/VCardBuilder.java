// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.vcard;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

// Referenced classes of package com.digits.sdk.vcard:
//            VCardConfig, VCardUtils, VCardPhoneNumberTranslationCallback

public class VCardBuilder
{

    public static final int DEFAULT_EMAIL_TYPE = 3;
    public static final int DEFAULT_PHONE_TYPE = 1;
    private static final String LOG_TAG = "vCard";
    private static final String SHIFT_JIS = "SHIFT_JIS";
    private static final String VCARD_DATA_PUBLIC = "PUBLIC";
    private static final String VCARD_DATA_SEPARATOR = ":";
    private static final String VCARD_DATA_VCARD = "VCARD";
    public static final String VCARD_END_OF_LINE = "\r\n";
    private static final String VCARD_ITEM_SEPARATOR = ";";
    private static final String VCARD_PARAM_ENCODING_QP = "ENCODING=QUOTED-PRINTABLE";
    private static final String VCARD_PARAM_EQUAL = "=";
    private static final String VCARD_PARAM_SEPARATOR = ";";
    private static final Set sAllowedAndroidPropertySet = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] {
        "vnd.android.cursor.item/nickname", "vnd.android.cursor.item/contact_event", "vnd.android.cursor.item/relation"
    })));
    private final boolean mAppendTypeParamName;
    private StringBuilder mBuilder;
    private final String mCharset;
    private boolean mEndAppended;
    private final boolean mIsDoCoMo;
    private final boolean mIsJapaneseMobilePhone;
    private final boolean mIsV30OrV40;
    private final boolean mNeedsToConvertPhoneticString;
    private final boolean mRefrainsQPToNameProperties;
    private final boolean mShouldAppendCharsetParam;
    private final boolean mShouldUseQuotedPrintable;
    private final boolean mUsesDefactProperty;
    private final String mVCardCharsetParameter;
    private final int mVCardType;

    public VCardBuilder(int i)
    {
        this(i, null);
    }

    public VCardBuilder(int i, String s)
    {
        mVCardType = i;
        if (VCardConfig.isVersion40(i))
        {
            Log.w("vCard", "Should not use vCard 4.0 when building vCard. It is not officially published yet.");
        }
        boolean flag;
        if (VCardConfig.isVersion30(i) || VCardConfig.isVersion40(i))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsV30OrV40 = flag;
        mShouldUseQuotedPrintable = VCardConfig.shouldUseQuotedPrintable(i);
        mIsDoCoMo = VCardConfig.isDoCoMo(i);
        mIsJapaneseMobilePhone = VCardConfig.needsToConvertPhoneticString(i);
        mUsesDefactProperty = VCardConfig.usesDefactProperty(i);
        mRefrainsQPToNameProperties = VCardConfig.shouldRefrainQPToNameProperties(i);
        mAppendTypeParamName = VCardConfig.appendTypeParamName(i);
        mNeedsToConvertPhoneticString = VCardConfig.needsToConvertPhoneticString(i);
        if (!VCardConfig.isVersion30(i) || !"UTF-8".equalsIgnoreCase(s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mShouldAppendCharsetParam = flag;
        if (VCardConfig.isDoCoMo(i))
        {
            if (!"SHIFT_JIS".equalsIgnoreCase(s))
            {
                if (TextUtils.isEmpty(s))
                {
                    mCharset = "SHIFT_JIS";
                } else
                {
                    mCharset = s;
                }
            } else
            {
                mCharset = s;
            }
            mVCardCharsetParameter = "CHARSET=SHIFT_JIS";
        } else
        if (TextUtils.isEmpty(s))
        {
            Log.i("vCard", "Use the charset \"UTF-8\" for export.");
            mCharset = "UTF-8";
            mVCardCharsetParameter = "CHARSET=UTF-8";
        } else
        {
            mCharset = s;
            mVCardCharsetParameter = (new StringBuilder("CHARSET=")).append(s).toString();
        }
        clear();
    }

    private VCardBuilder appendNamePropertiesV40(List list)
    {
        if (mIsDoCoMo || mNeedsToConvertPhoneticString)
        {
            Log.w("vCard", "Invalid flag is used in vCard 4.0 construction. Ignored.");
        }
        if (list == null || list.isEmpty())
        {
            appendLine("FN", "");
            return this;
        }
        ContentValues contentvalues = getPrimaryContentValueWithStructuredName(list);
        String s1 = contentvalues.getAsString("data3");
        String s2 = contentvalues.getAsString("data5");
        String s3 = contentvalues.getAsString("data2");
        String s4 = contentvalues.getAsString("data4");
        String s5 = contentvalues.getAsString("data6");
        String s = contentvalues.getAsString("data1");
        list = s1;
        if (TextUtils.isEmpty(s1))
        {
            list = s1;
            if (TextUtils.isEmpty(s3))
            {
                list = s1;
                if (TextUtils.isEmpty(s2))
                {
                    list = s1;
                    if (TextUtils.isEmpty(s4))
                    {
                        list = s1;
                        if (TextUtils.isEmpty(s5))
                        {
                            if (TextUtils.isEmpty(s))
                            {
                                appendLine("FN", "");
                                return this;
                            }
                            list = s;
                        }
                    }
                }
            }
        }
        String s10 = contentvalues.getAsString("data9");
        String s11 = contentvalues.getAsString("data8");
        String s12 = contentvalues.getAsString("data7");
        s1 = escapeCharacters(list);
        String s6 = escapeCharacters(s3);
        String s7 = escapeCharacters(s2);
        String s8 = escapeCharacters(s4);
        String s9 = escapeCharacters(s5);
        mBuilder.append("N");
        if (!TextUtils.isEmpty(s10) || !TextUtils.isEmpty(s11) || !TextUtils.isEmpty(s12))
        {
            mBuilder.append(";");
            s10 = (new StringBuilder()).append(escapeCharacters(s10)).append(';').append(escapeCharacters(s12)).append(';').append(escapeCharacters(s11)).toString();
            mBuilder.append("SORT-AS=").append(VCardUtils.toStringAsV40ParamValue(s10));
        }
        mBuilder.append(":");
        mBuilder.append(s1);
        mBuilder.append(";");
        mBuilder.append(s6);
        mBuilder.append(";");
        mBuilder.append(s7);
        mBuilder.append(";");
        mBuilder.append(s8);
        mBuilder.append(";");
        mBuilder.append(s9);
        mBuilder.append("\r\n");
        if (TextUtils.isEmpty(s))
        {
            Log.w("vCard", "DISPLAY_NAME is empty.");
            appendLine("FN", escapeCharacters(VCardUtils.constructNameFromElements(VCardConfig.getNameOrderType(mVCardType), list, s2, s3, s4, s5)));
        } else
        {
            list = escapeCharacters(s);
            mBuilder.append("FN");
            mBuilder.append(":");
            mBuilder.append(list);
            mBuilder.append("\r\n");
        }
        appendPhoneticNameFields(contentvalues);
        return this;
    }

    private void appendPhoneticNameFields(ContentValues contentvalues)
    {
        String s4 = contentvalues.getAsString("data9");
        String s = contentvalues.getAsString("data8");
        String s2 = contentvalues.getAsString("data7");
        if (mNeedsToConvertPhoneticString)
        {
            contentvalues = VCardUtils.toHalfWidthString(s4);
            s = VCardUtils.toHalfWidthString(s);
            s2 = VCardUtils.toHalfWidthString(s2);
        } else
        {
            contentvalues = s4;
        }
        if (TextUtils.isEmpty(contentvalues) && TextUtils.isEmpty(s) && TextUtils.isEmpty(s2))
        {
            if (mIsDoCoMo)
            {
                mBuilder.append("SOUND");
                mBuilder.append(";");
                mBuilder.append("X-IRMC-N");
                mBuilder.append(":");
                mBuilder.append(";");
                mBuilder.append(";");
                mBuilder.append(";");
                mBuilder.append(";");
                mBuilder.append("\r\n");
            }
            return;
        }
        if (!VCardConfig.isVersion40(mVCardType))
        {
            if (VCardConfig.isVersion30(mVCardType))
            {
                String s5 = VCardUtils.constructNameFromElements(mVCardType, contentvalues, s, s2);
                mBuilder.append("SORT-STRING");
                if (VCardConfig.isVersion30(mVCardType) && shouldAppendCharsetParam(new String[] {
    s5
}))
                {
                    mBuilder.append(";");
                    mBuilder.append(mVCardCharsetParameter);
                }
                mBuilder.append(":");
                mBuilder.append(escapeCharacters(s5));
                mBuilder.append("\r\n");
            } else
            if (mIsJapaneseMobilePhone)
            {
                mBuilder.append("SOUND");
                mBuilder.append(";");
                mBuilder.append("X-IRMC-N");
                boolean flag;
                if (!mRefrainsQPToNameProperties && (!VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[] {
    contentvalues
}) || !VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[] {
    s
}) || !VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[] {
    s2
})))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                String s6;
                String s8;
                String s9;
                if (flag)
                {
                    s8 = encodeQuotedPrintable(contentvalues);
                    s9 = encodeQuotedPrintable(s);
                    s6 = encodeQuotedPrintable(s2);
                } else
                {
                    s8 = escapeCharacters(contentvalues);
                    s9 = escapeCharacters(s);
                    s6 = escapeCharacters(s2);
                }
                if (shouldAppendCharsetParam(new String[] {
    s8, s9, s6
}))
                {
                    mBuilder.append(";");
                    mBuilder.append(mVCardCharsetParameter);
                }
                mBuilder.append(":");
                flag = true;
                if (!TextUtils.isEmpty(s8))
                {
                    mBuilder.append(s8);
                    flag = false;
                }
                boolean flag4 = flag;
                if (!TextUtils.isEmpty(s9))
                {
                    if (flag)
                    {
                        flag = false;
                    } else
                    {
                        mBuilder.append(' ');
                    }
                    mBuilder.append(s9);
                    flag4 = flag;
                }
                if (!TextUtils.isEmpty(s6))
                {
                    if (!flag4)
                    {
                        mBuilder.append(' ');
                    }
                    mBuilder.append(s6);
                }
                mBuilder.append(";");
                mBuilder.append(";");
                mBuilder.append(";");
                mBuilder.append(";");
                mBuilder.append("\r\n");
            }
        }
        if (mUsesDefactProperty)
        {
            if (!TextUtils.isEmpty(s2))
            {
                boolean flag1;
                if (mShouldUseQuotedPrintable && !VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[] {
    s2
}))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                String s7;
                if (flag1)
                {
                    s7 = encodeQuotedPrintable(s2);
                } else
                {
                    s7 = escapeCharacters(s2);
                }
                mBuilder.append("X-PHONETIC-FIRST-NAME");
                if (shouldAppendCharsetParam(new String[] {
    s2
}))
                {
                    mBuilder.append(";");
                    mBuilder.append(mVCardCharsetParameter);
                }
                if (flag1)
                {
                    mBuilder.append(";");
                    mBuilder.append("ENCODING=QUOTED-PRINTABLE");
                }
                mBuilder.append(":");
                mBuilder.append(s7);
                mBuilder.append("\r\n");
            }
            if (!TextUtils.isEmpty(s))
            {
                boolean flag2;
                if (mShouldUseQuotedPrintable && !VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[] {
    s
}))
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                String s3;
                if (flag2)
                {
                    s3 = encodeQuotedPrintable(s);
                } else
                {
                    s3 = escapeCharacters(s);
                }
                mBuilder.append("X-PHONETIC-MIDDLE-NAME");
                if (shouldAppendCharsetParam(new String[] {
    s
}))
                {
                    mBuilder.append(";");
                    mBuilder.append(mVCardCharsetParameter);
                }
                if (flag2)
                {
                    mBuilder.append(";");
                    mBuilder.append("ENCODING=QUOTED-PRINTABLE");
                }
                mBuilder.append(":");
                mBuilder.append(s3);
                mBuilder.append("\r\n");
            }
            if (!TextUtils.isEmpty(contentvalues))
            {
                boolean flag3;
                if (mShouldUseQuotedPrintable && !VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[] {
    contentvalues
}))
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
                String s1;
                if (flag3)
                {
                    s1 = encodeQuotedPrintable(contentvalues);
                } else
                {
                    s1 = escapeCharacters(contentvalues);
                }
                mBuilder.append("X-PHONETIC-LAST-NAME");
                if (shouldAppendCharsetParam(new String[] {
    contentvalues
}))
                {
                    mBuilder.append(";");
                    mBuilder.append(mVCardCharsetParameter);
                }
                if (flag3)
                {
                    mBuilder.append(";");
                    mBuilder.append("ENCODING=QUOTED-PRINTABLE");
                }
                mBuilder.append(":");
                mBuilder.append(s1);
                mBuilder.append("\r\n");
            }
        }
    }

    private void appendTypeParameter(String s)
    {
        appendTypeParameter(mBuilder, s);
    }

    private void appendTypeParameter(StringBuilder stringbuilder, String s)
    {
        if (VCardConfig.isVersion40(mVCardType) || (VCardConfig.isVersion30(mVCardType) || mAppendTypeParamName) && !mIsDoCoMo)
        {
            stringbuilder.append("TYPE=");
        }
        stringbuilder.append(s);
    }

    private void appendTypeParameters(List list)
    {
        boolean flag = true;
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            list = (String)iterator.next();
            if (VCardConfig.isVersion30(mVCardType) || VCardConfig.isVersion40(mVCardType))
            {
                if (VCardConfig.isVersion40(mVCardType))
                {
                    list = VCardUtils.toStringAsV40ParamValue(list);
                } else
                {
                    list = VCardUtils.toStringAsV30ParamValue(list);
                }
                if (!TextUtils.isEmpty(list))
                {
                    if (flag)
                    {
                        flag = false;
                    } else
                    {
                        mBuilder.append(";");
                    }
                    appendTypeParameter(list);
                }
            } else
            if (VCardUtils.isV21Word(list))
            {
                if (flag)
                {
                    flag = false;
                } else
                {
                    mBuilder.append(";");
                }
                appendTypeParameter(list);
            }
        } while (true);
    }

    private void appendUncommonPhoneType(StringBuilder stringbuilder, Integer integer)
    {
        if (mIsDoCoMo)
        {
            stringbuilder.append("VOICE");
            return;
        }
        stringbuilder = VCardUtils.getPhoneTypeString(integer);
        if (stringbuilder != null)
        {
            appendTypeParameter(stringbuilder);
            return;
        } else
        {
            Log.e("vCard", (new StringBuilder("Unknown or unsupported (by vCard) Phone type: ")).append(integer).toString());
            return;
        }
    }

    private void buildSinglePartNameField(String s, String s1)
    {
        boolean flag;
        if (!mRefrainsQPToNameProperties && !VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[] {
    s1
}))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        String s2;
        if (flag)
        {
            s2 = encodeQuotedPrintable(s1);
        } else
        {
            s2 = escapeCharacters(s1);
        }
        mBuilder.append(s);
        if (shouldAppendCharsetParam(new String[] {
    s1
}))
        {
            mBuilder.append(";");
            mBuilder.append(mVCardCharsetParameter);
        }
        if (flag)
        {
            mBuilder.append(";");
            mBuilder.append("ENCODING=QUOTED-PRINTABLE");
        }
        mBuilder.append(":");
        mBuilder.append(s2);
    }

    private boolean containsNonEmptyName(ContentValues contentvalues)
    {
        String s = contentvalues.getAsString("data3");
        String s1 = contentvalues.getAsString("data5");
        String s2 = contentvalues.getAsString("data2");
        String s3 = contentvalues.getAsString("data4");
        String s4 = contentvalues.getAsString("data6");
        String s5 = contentvalues.getAsString("data9");
        String s6 = contentvalues.getAsString("data8");
        String s7 = contentvalues.getAsString("data7");
        contentvalues = contentvalues.getAsString("data1");
        return !TextUtils.isEmpty(s) || !TextUtils.isEmpty(s1) || !TextUtils.isEmpty(s2) || !TextUtils.isEmpty(s3) || !TextUtils.isEmpty(s4) || !TextUtils.isEmpty(s5) || !TextUtils.isEmpty(s6) || !TextUtils.isEmpty(s7) || !TextUtils.isEmpty(contentvalues);
    }

    private String encodeQuotedPrintable(String s)
    {
        StringBuilder stringbuilder;
        int i;
        int j;
        if (TextUtils.isEmpty(s))
        {
            return "";
        }
        stringbuilder = new StringBuilder();
        j = 0;
        i = 0;
        byte abyte0[] = s.getBytes(mCharset);
        s = abyte0;
          goto _L1
_L3:
        Log.e("vCard", (new StringBuilder("Charset ")).append(mCharset).append(" cannot be used. Try default charset").toString());
        s = s.getBytes();
_L1:
        do
        {
            if (j >= s.length)
            {
                break;
            }
            stringbuilder.append(String.format("=%02X", new Object[] {
                Byte.valueOf(s[j])
            }));
            int k = j + 1;
            int l = i + 3;
            j = k;
            i = l;
            if (l >= 67)
            {
                stringbuilder.append("=\r\n");
                i = 0;
                j = k;
            }
        } while (true);
        return stringbuilder.toString();
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        if (true) goto _L3; else goto _L2
_L2:
    }

    private String escapeCharacters(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        int j = s.length();
        for (int i = 0; i < j; i++)
        {
            char c = s.charAt(i);
            switch (c)
            {
            case 59: // ';'
                stringbuilder.append('\\');
                stringbuilder.append(';');
                break;

            case 13: // '\r'
                if (i + 1 < j && s.charAt(i) == '\n')
                {
                    break;
                }
                // fall through

            case 10: // '\n'
                stringbuilder.append("\\n");
                break;

            case 92: // '\\'
                if (mIsV30OrV40)
                {
                    stringbuilder.append("\\\\");
                    break;
                }
                // fall through

            case 60: // '<'
            case 62: // '>'
                if (mIsDoCoMo)
                {
                    stringbuilder.append('\\');
                    stringbuilder.append(c);
                } else
                {
                    stringbuilder.append(c);
                }
                break;

            case 44: // ','
                if (mIsV30OrV40)
                {
                    stringbuilder.append("\\,");
                } else
                {
                    stringbuilder.append(c);
                }
                break;

            default:
                stringbuilder.append(c);
                break;
            }
        }

        return stringbuilder.toString();
    }

    private ContentValues getPrimaryContentValueWithStructuredName(List list)
    {
        Object obj = null;
        Object obj1 = null;
        Iterator iterator = list.iterator();
        list = ((List) (obj));
        do
        {
            obj = list;
            if (!iterator.hasNext())
            {
                break;
            }
            obj = (ContentValues)iterator.next();
            if (obj == null)
            {
                continue;
            }
            Object obj2 = ((ContentValues) (obj)).getAsInteger("is_super_primary");
            if (obj2 != null && ((Integer) (obj2)).intValue() > 0)
            {
                break;
            }
            obj2 = obj1;
            if (list == null)
            {
                obj2 = ((ContentValues) (obj)).getAsInteger("is_primary");
                if (obj2 != null && ((Integer) (obj2)).intValue() > 0 && containsNonEmptyName(((ContentValues) (obj))))
                {
                    list = ((List) (obj));
                    continue;
                }
                obj2 = obj1;
                if (obj1 == null)
                {
                    obj2 = obj1;
                    if (containsNonEmptyName(((ContentValues) (obj))))
                    {
                        obj2 = obj;
                    }
                }
            }
            obj1 = obj2;
        } while (true);
        list = ((List) (obj));
        if (obj == null)
        {
            if (obj1 != null)
            {
                return ((ContentValues) (obj1));
            }
            list = new ContentValues();
        }
        return list;
    }

    private transient boolean shouldAppendCharsetParam(String as[])
    {
        if (!mShouldAppendCharsetParam)
        {
            return false;
        }
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            if (!VCardUtils.containsOnlyPrintableAscii(new String[] {
    as[i]
}))
            {
                return true;
            }
        }

        return false;
    }

    private List splitPhoneNumbers(String s)
    {
        ArrayList arraylist = new ArrayList();
        StringBuilder stringbuilder = new StringBuilder();
        int j = s.length();
        for (int i = 0; i < j; i++)
        {
            char c = s.charAt(i);
            if (c == '\n' && stringbuilder.length() > 0)
            {
                arraylist.add(stringbuilder.toString());
                stringbuilder = new StringBuilder();
            } else
            {
                stringbuilder.append(c);
            }
        }

        if (stringbuilder.length() > 0)
        {
            arraylist.add(stringbuilder.toString());
        }
        return arraylist;
    }

    public void appendEmailLine(int i, String s, String s1, boolean flag)
    {
        switch (i)
        {
        case 0: // '\0'
            if (VCardUtils.isMobilePhoneLabel(s))
            {
                s = "CELL";
                break;
            }
            if (!TextUtils.isEmpty(s) && VCardUtils.containsOnlyAlphaDigitHyphen(new String[] {
    s
}))
            {
                s = (new StringBuilder("X-")).append(s).toString();
            } else
            {
                s = null;
            }
            break;

        case 1: // '\001'
            s = "HOME";
            break;

        case 2: // '\002'
            s = "WORK";
            break;

        case 3: // '\003'
            s = null;
            break;

        case 4: // '\004'
            s = "CELL";
            break;

        default:
            Log.e("vCard", (new StringBuilder("Unknown Email type: ")).append(i).toString());
            s = null;
            break;
        }
        ArrayList arraylist = new ArrayList();
        if (flag)
        {
            arraylist.add("PREF");
        }
        if (!TextUtils.isEmpty(s))
        {
            arraylist.add(s);
        }
        appendLineWithCharsetAndQPDetection("EMAIL", arraylist, s1);
    }

    public VCardBuilder appendEmails(List list)
    {
        boolean flag = false;
        int i = 0;
        if (list != null)
        {
            HashSet hashset = new HashSet();
            Iterator iterator = list.iterator();
            do
            {
                flag = i;
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj1 = (ContentValues)iterator.next();
                String s = ((ContentValues) (obj1)).getAsString("data1");
                list = s;
                if (s != null)
                {
                    list = s.trim();
                }
                if (!TextUtils.isEmpty(list))
                {
                    Object obj = ((ContentValues) (obj1)).getAsInteger("data2");
                    if (obj != null)
                    {
                        i = ((Integer) (obj)).intValue();
                    } else
                    {
                        i = 3;
                    }
                    obj = ((ContentValues) (obj1)).getAsString("data3");
                    obj1 = ((ContentValues) (obj1)).getAsInteger("is_primary");
                    boolean flag1;
                    if (obj1 != null)
                    {
                        if (((Integer) (obj1)).intValue() > 0)
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                    } else
                    {
                        flag1 = false;
                    }
                    flag = true;
                    if (!hashset.contains(list))
                    {
                        hashset.add(list);
                        appendEmailLine(i, ((String) (obj)), list, flag1);
                    }
                    i = ((flag) ? 1 : 0);
                }
            } while (true);
        }
        if (!flag && mIsDoCoMo)
        {
            appendEmailLine(1, "", "", false);
        }
        return this;
    }

    public void appendLine(String s, String s1)
    {
        appendLine(s, s1, false, false);
    }

    public void appendLine(String s, String s1, boolean flag, boolean flag1)
    {
        appendLine(s, null, s1, flag, flag1);
    }

    public void appendLine(String s, List list, String s1, boolean flag, boolean flag1)
    {
        mBuilder.append(s);
        if (list != null && list.size() > 0)
        {
            mBuilder.append(";");
            appendTypeParameters(list);
        }
        if (flag)
        {
            mBuilder.append(";");
            mBuilder.append(mVCardCharsetParameter);
        }
        if (flag1)
        {
            mBuilder.append(";");
            mBuilder.append("ENCODING=QUOTED-PRINTABLE");
            s = encodeQuotedPrintable(s1);
        } else
        {
            s = escapeCharacters(s1);
        }
        mBuilder.append(":");
        mBuilder.append(s);
        mBuilder.append("\r\n");
    }

    public void appendLineWithCharsetAndQPDetection(String s, List list, String s1)
    {
        boolean flag;
        if (!VCardUtils.containsOnlyPrintableAscii(new String[] {
    s1
}))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        boolean flag1;
        if (mShouldUseQuotedPrintable && !VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[] {
    s1
}))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        appendLine(s, list, s1, flag, flag1);
    }

    public VCardBuilder appendNameProperties(List list)
    {
        if (VCardConfig.isVersion40(mVCardType))
        {
            return appendNamePropertiesV40(list);
        }
        if (list == null || list.isEmpty())
        {
            if (VCardConfig.isVersion30(mVCardType))
            {
                appendLine("N", "");
                appendLine("FN", "");
                return this;
            }
            if (mIsDoCoMo)
            {
                appendLine("N", "");
            }
            return this;
        }
        ContentValues contentvalues = getPrimaryContentValueWithStructuredName(list);
        String s = contentvalues.getAsString("data3");
        String s1 = contentvalues.getAsString("data5");
        String s2 = contentvalues.getAsString("data2");
        String s3 = contentvalues.getAsString("data4");
        String s4 = contentvalues.getAsString("data6");
        list = contentvalues.getAsString("data1");
        if (!TextUtils.isEmpty(s) || !TextUtils.isEmpty(s2))
        {
            boolean flag2 = shouldAppendCharsetParam(new String[] {
                s, s2, s1, s3, s4
            });
            boolean flag;
            if (!mRefrainsQPToNameProperties && (!VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[] {
    s
}) || !VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[] {
    s2
}) || !VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[] {
    s1
}) || !VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[] {
    s3
}) || !VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[] {
    s4
})))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (TextUtils.isEmpty(list))
            {
                list = VCardUtils.constructNameFromElements(VCardConfig.getNameOrderType(mVCardType), s, s1, s2, s3, s4);
            }
            boolean flag3 = shouldAppendCharsetParam(new String[] {
                list
            });
            boolean flag1;
            if (!mRefrainsQPToNameProperties && !VCardUtils.containsOnlyNonCrLfPrintableAscii(new String[] {
    list
}))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag)
            {
                s = encodeQuotedPrintable(s);
                s2 = encodeQuotedPrintable(s2);
                s1 = encodeQuotedPrintable(s1);
                s3 = encodeQuotedPrintable(s3);
                s4 = encodeQuotedPrintable(s4);
            } else
            {
                s = escapeCharacters(s);
                s2 = escapeCharacters(s2);
                s1 = escapeCharacters(s1);
                s3 = escapeCharacters(s3);
                s4 = escapeCharacters(s4);
            }
            String s5;
            if (flag1)
            {
                s5 = encodeQuotedPrintable(list);
            } else
            {
                s5 = escapeCharacters(list);
            }
            mBuilder.append("N");
            if (mIsDoCoMo)
            {
                if (flag2)
                {
                    mBuilder.append(";");
                    mBuilder.append(mVCardCharsetParameter);
                }
                if (flag)
                {
                    mBuilder.append(";");
                    mBuilder.append("ENCODING=QUOTED-PRINTABLE");
                }
                mBuilder.append(":");
                mBuilder.append(list);
                mBuilder.append(";");
                mBuilder.append(";");
                mBuilder.append(";");
                mBuilder.append(";");
            } else
            {
                if (flag2)
                {
                    mBuilder.append(";");
                    mBuilder.append(mVCardCharsetParameter);
                }
                if (flag)
                {
                    mBuilder.append(";");
                    mBuilder.append("ENCODING=QUOTED-PRINTABLE");
                }
                mBuilder.append(":");
                mBuilder.append(s);
                mBuilder.append(";");
                mBuilder.append(s2);
                mBuilder.append(";");
                mBuilder.append(s1);
                mBuilder.append(";");
                mBuilder.append(s3);
                mBuilder.append(";");
                mBuilder.append(s4);
            }
            mBuilder.append("\r\n");
            mBuilder.append("FN");
            if (flag3)
            {
                mBuilder.append(";");
                mBuilder.append(mVCardCharsetParameter);
            }
            if (flag1)
            {
                mBuilder.append(";");
                mBuilder.append("ENCODING=QUOTED-PRINTABLE");
            }
            mBuilder.append(":");
            mBuilder.append(s5);
            mBuilder.append("\r\n");
        } else
        if (!TextUtils.isEmpty(list))
        {
            buildSinglePartNameField("N", list);
            mBuilder.append(";");
            mBuilder.append(";");
            mBuilder.append(";");
            mBuilder.append(";");
            mBuilder.append("\r\n");
            buildSinglePartNameField("FN", list);
            mBuilder.append("\r\n");
        } else
        if (VCardConfig.isVersion30(mVCardType))
        {
            appendLine("N", "");
            appendLine("FN", "");
        } else
        if (mIsDoCoMo)
        {
            appendLine("N", "");
        }
        appendPhoneticNameFields(contentvalues);
        return this;
    }

    public VCardBuilder appendPhones(List list, VCardPhoneNumberTranslationCallback vcardphonenumbertranslationcallback)
    {
        int j = 0;
        int i = 0;
        if (list != null)
        {
            HashSet hashset = new HashSet();
            Iterator iterator = list.iterator();
            do
            {
                j = i;
                if (!iterator.hasNext())
                {
                    break;
                }
                list = (ContentValues)iterator.next();
                Integer integer = list.getAsInteger("data2");
                String s = list.getAsString("data3");
                Object obj = list.getAsInteger("is_primary");
                boolean flag1;
                if (obj != null)
                {
                    if (((Integer) (obj)).intValue() > 0)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                } else
                {
                    flag1 = false;
                }
                obj = list.getAsString("data1");
                list = ((List) (obj));
                if (obj != null)
                {
                    list = ((String) (obj)).trim();
                }
                if (TextUtils.isEmpty(list))
                {
                    continue;
                }
                int k;
                if (integer != null)
                {
                    k = integer.intValue();
                } else
                {
                    k = 1;
                }
                if (vcardphonenumbertranslationcallback != null)
                {
                    list = vcardphonenumbertranslationcallback.onValueReceived(list, k, s, flag1);
                    j = i;
                    if (!hashset.contains(list))
                    {
                        hashset.add(list);
                        appendTelLine(Integer.valueOf(k), s, list, flag1);
                        continue;
                    }
                } else
                if (k == 6 || VCardConfig.refrainPhoneNumberFormatting(mVCardType))
                {
                    j = 1;
                    i = 1;
                    if (!hashset.contains(list))
                    {
                        hashset.add(list);
                        appendTelLine(Integer.valueOf(k), s, list, flag1);
                        continue;
                    }
                } else
                {
                    list = splitPhoneNumbers(list);
                    if (list.isEmpty())
                    {
                        continue;
                    }
                    boolean flag = true;
                    Iterator iterator1 = list.iterator();
                    do
                    {
                        j = ((flag) ? 1 : 0);
                        if (!iterator1.hasNext())
                        {
                            break;
                        }
                        String s1 = (String)iterator1.next();
                        if (!hashset.contains(s1))
                        {
                            Object obj1 = s1.replace(',', 'p').replace(';', 'w');
                            list = ((List) (obj1));
                            if (TextUtils.equals(((CharSequence) (obj1)), s1))
                            {
                                list = new StringBuilder();
                                j = s1.length();
                                for (i = 0; i < j; i++)
                                {
                                    char c = s1.charAt(i);
                                    if (Character.isDigit(c) || c == '+')
                                    {
                                        list.append(c);
                                    }
                                }

                                i = VCardUtils.getPhoneNumberFormat(mVCardType);
                                list = VCardUtils.PhoneNumberUtilsPort.formatNumber(list.toString(), i);
                            }
                            obj1 = list;
                            if (VCardConfig.isVersion40(mVCardType))
                            {
                                obj1 = list;
                                if (!TextUtils.isEmpty(list))
                                {
                                    obj1 = list;
                                    if (!list.startsWith("tel:"))
                                    {
                                        obj1 = (new StringBuilder("tel:")).append(list).toString();
                                    }
                                }
                            }
                            hashset.add(s1);
                            appendTelLine(Integer.valueOf(k), s, ((String) (obj1)), flag1);
                        }
                    } while (true);
                }
                i = j;
            } while (true);
        }
        if (j == 0 && mIsDoCoMo)
        {
            appendTelLine(Integer.valueOf(1), "", "", false);
        }
        return this;
    }

    public void appendTelLine(Integer integer, String s, String s1, boolean flag)
    {
        mBuilder.append("TEL");
        mBuilder.append(";");
        int i;
        if (integer == null)
        {
            i = 7;
        } else
        {
            i = integer.intValue();
        }
        integer = new ArrayList();
        boolean flag1 = flag;
        switch (i)
        {
        default:
            flag1 = flag;
            break;

        case 1: // '\001'
            integer.addAll(Arrays.asList(new String[] {
                "HOME"
            }));
            flag1 = flag;
            break;

        case 3: // '\003'
            integer.addAll(Arrays.asList(new String[] {
                "WORK"
            }));
            flag1 = flag;
            break;

        case 5: // '\005'
            integer.addAll(Arrays.asList(new String[] {
                "HOME", "FAX"
            }));
            flag1 = flag;
            break;

        case 4: // '\004'
            integer.addAll(Arrays.asList(new String[] {
                "WORK", "FAX"
            }));
            flag1 = flag;
            break;

        case 2: // '\002'
            integer.add("CELL");
            flag1 = flag;
            break;

        case 6: // '\006'
            if (mIsDoCoMo)
            {
                integer.add("VOICE");
                flag1 = flag;
            } else
            {
                integer.add("PAGER");
                flag1 = flag;
            }
            break;

        case 7: // '\007'
            integer.add("VOICE");
            flag1 = flag;
            break;

        case 9: // '\t'
            integer.add("CAR");
            flag1 = flag;
            break;

        case 10: // '\n'
            integer.add("WORK");
            flag1 = true;
            break;

        case 11: // '\013'
            integer.add("ISDN");
            flag1 = flag;
            break;

        case 12: // '\f'
            flag1 = true;
            break;

        case 13: // '\r'
            integer.add("FAX");
            flag1 = flag;
            break;

        case 15: // '\017'
            integer.add("TLX");
            flag1 = flag;
            break;

        case 17: // '\021'
            integer.addAll(Arrays.asList(new String[] {
                "WORK", "CELL"
            }));
            flag1 = flag;
            break;

        case 18: // '\022'
            integer.add("WORK");
            if (mIsDoCoMo)
            {
                integer.add("VOICE");
                flag1 = flag;
            } else
            {
                integer.add("PAGER");
                flag1 = flag;
            }
            break;

        case 20: // '\024'
            integer.add("MSG");
            flag1 = flag;
            break;

        case 0: // '\0'
            if (TextUtils.isEmpty(s))
            {
                integer.add("VOICE");
                flag1 = flag;
            } else
            if (VCardUtils.isMobilePhoneLabel(s))
            {
                integer.add("CELL");
                flag1 = flag;
            } else
            if (mIsV30OrV40)
            {
                integer.add(s);
                flag1 = flag;
            } else
            {
                String s2 = s.toUpperCase(Locale.getDefault());
                if (VCardUtils.isValidInV21ButUnknownToContactsPhoteType(s2))
                {
                    integer.add(s2);
                    flag1 = flag;
                } else
                {
                    flag1 = flag;
                    if (VCardUtils.containsOnlyAlphaDigitHyphen(new String[] {
    s
}))
                    {
                        integer.add((new StringBuilder("X-")).append(s).toString());
                        flag1 = flag;
                    }
                }
            }
            break;

        case 8: // '\b'
        case 14: // '\016'
        case 16: // '\020'
        case 19: // '\023'
            break;
        }
        if (flag1)
        {
            integer.add("PREF");
        }
        if (integer.isEmpty())
        {
            appendUncommonPhoneType(mBuilder, Integer.valueOf(i));
        } else
        {
            appendTypeParameters(integer);
        }
        mBuilder.append(":");
        mBuilder.append(s1);
        mBuilder.append("\r\n");
    }

    public void clear()
    {
        mBuilder = new StringBuilder();
        mEndAppended = false;
        appendLine("BEGIN", "VCARD");
        if (VCardConfig.isVersion40(mVCardType))
        {
            appendLine("VERSION", "4.0");
            return;
        }
        if (VCardConfig.isVersion30(mVCardType))
        {
            appendLine("VERSION", "3.0");
            return;
        }
        if (!VCardConfig.isVersion21(mVCardType))
        {
            Log.w("vCard", "Unknown vCard version detected.");
        }
        appendLine("VERSION", "2.1");
    }

    public String toString()
    {
        if (!mEndAppended)
        {
            if (mIsDoCoMo)
            {
                appendLine("X-CLASS", "PUBLIC");
                appendLine("X-REDUCTION", "");
                appendLine("X-NO", "");
                appendLine("X-DCM-HMN-MODE", "");
            }
            appendLine("END", "VCARD");
            mEndAppended = true;
        }
        return mBuilder.toString();
    }

}
