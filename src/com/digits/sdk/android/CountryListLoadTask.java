// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import o.so;

// Referenced classes of package com.digits.sdk.android:
//            CountryInfo

class CountryListLoadTask extends so
{
    public static interface Listener
    {

        public abstract void onLoadComplete(List list);
    }


    private static final int MAX_COUNTRIES = 291;
    private final Listener listener;

    public CountryListLoadTask(Listener listener1)
    {
        listener = listener1;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient List doInBackground(Void avoid[])
    {
        avoid = new ArrayList(291);
        avoid.add(new CountryInfo((new Locale("", "AF")).getDisplayCountry(), 93));
        avoid.add(new CountryInfo((new Locale("", "AX")).getDisplayCountry(), 358));
        avoid.add(new CountryInfo((new Locale("", "AL")).getDisplayCountry(), 355));
        avoid.add(new CountryInfo((new Locale("", "DZ")).getDisplayCountry(), 213));
        avoid.add(new CountryInfo((new Locale("", "AS")).getDisplayCountry(), 1));
        avoid.add(new CountryInfo((new Locale("", "AD")).getDisplayCountry(), 376));
        avoid.add(new CountryInfo((new Locale("", "AO")).getDisplayCountry(), 244));
        avoid.add(new CountryInfo((new Locale("", "AI")).getDisplayCountry(), 1));
        avoid.add(new CountryInfo((new Locale("", "AG")).getDisplayCountry(), 1));
        avoid.add(new CountryInfo((new Locale("", "AR")).getDisplayCountry(), 54));
        avoid.add(new CountryInfo((new Locale("", "AM")).getDisplayCountry(), 374));
        avoid.add(new CountryInfo((new Locale("", "AW")).getDisplayCountry(), 297));
        avoid.add(new CountryInfo((new Locale("", "AC")).getDisplayCountry(), 247));
        avoid.add(new CountryInfo((new Locale("", "AU")).getDisplayCountry(), 61));
        avoid.add(new CountryInfo((new Locale("", "AT")).getDisplayCountry(), 43));
        avoid.add(new CountryInfo((new Locale("", "AZ")).getDisplayCountry(), 994));
        avoid.add(new CountryInfo((new Locale("", "BS")).getDisplayCountry(), 1));
        avoid.add(new CountryInfo((new Locale("", "BH")).getDisplayCountry(), 973));
        avoid.add(new CountryInfo((new Locale("", "BD")).getDisplayCountry(), 880));
        avoid.add(new CountryInfo((new Locale("", "BB")).getDisplayCountry(), 1));
        avoid.add(new CountryInfo((new Locale("", "BY")).getDisplayCountry(), 375));
        avoid.add(new CountryInfo((new Locale("", "BE")).getDisplayCountry(), 32));
        avoid.add(new CountryInfo((new Locale("", "BZ")).getDisplayCountry(), 501));
        avoid.add(new CountryInfo((new Locale("", "BJ")).getDisplayCountry(), 229));
        avoid.add(new CountryInfo((new Locale("", "BM")).getDisplayCountry(), 1));
        avoid.add(new CountryInfo((new Locale("", "BT")).getDisplayCountry(), 975));
        avoid.add(new CountryInfo((new Locale("", "BO")).getDisplayCountry(), 591));
        avoid.add(new CountryInfo((new Locale("", "BA")).getDisplayCountry(), 387));
        avoid.add(new CountryInfo((new Locale("", "BW")).getDisplayCountry(), 267));
        avoid.add(new CountryInfo((new Locale("", "BR")).getDisplayCountry(), 55));
        avoid.add(new CountryInfo((new Locale("", "IO")).getDisplayCountry(), 246));
        avoid.add(new CountryInfo((new Locale("", "VG")).getDisplayCountry(), 1));
        avoid.add(new CountryInfo((new Locale("", "BN")).getDisplayCountry(), 673));
        avoid.add(new CountryInfo((new Locale("", "BG")).getDisplayCountry(), 359));
        avoid.add(new CountryInfo((new Locale("", "BF")).getDisplayCountry(), 226));
        avoid.add(new CountryInfo((new Locale("", "BI")).getDisplayCountry(), 257));
        avoid.add(new CountryInfo((new Locale("", "KH")).getDisplayCountry(), 855));
        avoid.add(new CountryInfo((new Locale("", "CM")).getDisplayCountry(), 237));
        avoid.add(new CountryInfo((new Locale("", "CA")).getDisplayCountry(), 1));
        avoid.add(new CountryInfo((new Locale("", "CV")).getDisplayCountry(), 238));
        avoid.add(new CountryInfo((new Locale("", "BQ")).getDisplayCountry(), 599));
        avoid.add(new CountryInfo((new Locale("", "KY")).getDisplayCountry(), 1));
        avoid.add(new CountryInfo((new Locale("", "CF")).getDisplayCountry(), 236));
        avoid.add(new CountryInfo((new Locale("", "TD")).getDisplayCountry(), 235));
        avoid.add(new CountryInfo((new Locale("", "CL")).getDisplayCountry(), 56));
        avoid.add(new CountryInfo((new Locale("", "CN")).getDisplayCountry(), 86));
        avoid.add(new CountryInfo((new Locale("", "CX")).getDisplayCountry(), 61));
        avoid.add(new CountryInfo((new Locale("", "CC")).getDisplayCountry(), 61));
        avoid.add(new CountryInfo((new Locale("", "CO")).getDisplayCountry(), 57));
        avoid.add(new CountryInfo((new Locale("", "KM")).getDisplayCountry(), 269));
        avoid.add(new CountryInfo((new Locale("", "CD")).getDisplayCountry(), 243));
        avoid.add(new CountryInfo((new Locale("", "CG")).getDisplayCountry(), 242));
        avoid.add(new CountryInfo((new Locale("", "CK")).getDisplayCountry(), 682));
        avoid.add(new CountryInfo((new Locale("", "CR")).getDisplayCountry(), 506));
        avoid.add(new CountryInfo((new Locale("", "CI")).getDisplayCountry(), 225));
        avoid.add(new CountryInfo((new Locale("", "HR")).getDisplayCountry(), 385));
        avoid.add(new CountryInfo((new Locale("", "CU")).getDisplayCountry(), 53));
        avoid.add(new CountryInfo((new Locale("", "CW")).getDisplayCountry(), 599));
        avoid.add(new CountryInfo((new Locale("", "CY")).getDisplayCountry(), 357));
        avoid.add(new CountryInfo((new Locale("", "CZ")).getDisplayCountry(), 420));
        avoid.add(new CountryInfo((new Locale("", "DK")).getDisplayCountry(), 45));
        avoid.add(new CountryInfo((new Locale("", "DJ")).getDisplayCountry(), 253));
        avoid.add(new CountryInfo((new Locale("", "DM")).getDisplayCountry(), 1));
        avoid.add(new CountryInfo((new Locale("", "DO")).getDisplayCountry(), 1));
        avoid.add(new CountryInfo((new Locale("", "TL")).getDisplayCountry(), 670));
        avoid.add(new CountryInfo((new Locale("", "EC")).getDisplayCountry(), 593));
        avoid.add(new CountryInfo((new Locale("", "EG")).getDisplayCountry(), 20));
        avoid.add(new CountryInfo((new Locale("", "SV")).getDisplayCountry(), 503));
        avoid.add(new CountryInfo((new Locale("", "GQ")).getDisplayCountry(), 240));
        avoid.add(new CountryInfo((new Locale("", "ER")).getDisplayCountry(), 291));
        avoid.add(new CountryInfo((new Locale("", "EE")).getDisplayCountry(), 372));
        avoid.add(new CountryInfo((new Locale("", "ET")).getDisplayCountry(), 251));
        avoid.add(new CountryInfo((new Locale("", "FK")).getDisplayCountry(), 500));
        avoid.add(new CountryInfo((new Locale("", "FO")).getDisplayCountry(), 298));
        avoid.add(new CountryInfo((new Locale("", "FJ")).getDisplayCountry(), 679));
        avoid.add(new CountryInfo((new Locale("", "FI")).getDisplayCountry(), 358));
        avoid.add(new CountryInfo((new Locale("", "FR")).getDisplayCountry(), 33));
        avoid.add(new CountryInfo((new Locale("", "GF")).getDisplayCountry(), 594));
        avoid.add(new CountryInfo((new Locale("", "PF")).getDisplayCountry(), 689));
        avoid.add(new CountryInfo((new Locale("", "GA")).getDisplayCountry(), 241));
        avoid.add(new CountryInfo((new Locale("", "GM")).getDisplayCountry(), 220));
        avoid.add(new CountryInfo((new Locale("", "GE")).getDisplayCountry(), 995));
        avoid.add(new CountryInfo((new Locale("", "DE")).getDisplayCountry(), 49));
        avoid.add(new CountryInfo((new Locale("", "GH")).getDisplayCountry(), 233));
        avoid.add(new CountryInfo((new Locale("", "GI")).getDisplayCountry(), 350));
        avoid.add(new CountryInfo((new Locale("", "GR")).getDisplayCountry(), 30));
        avoid.add(new CountryInfo((new Locale("", "GL")).getDisplayCountry(), 299));
        avoid.add(new CountryInfo((new Locale("", "GD")).getDisplayCountry(), 1));
        avoid.add(new CountryInfo((new Locale("", "GP")).getDisplayCountry(), 590));
        avoid.add(new CountryInfo((new Locale("", "GU")).getDisplayCountry(), 1));
        avoid.add(new CountryInfo((new Locale("", "GT")).getDisplayCountry(), 502));
        avoid.add(new CountryInfo((new Locale("", "GG")).getDisplayCountry(), 44));
        avoid.add(new CountryInfo((new Locale("", "GN")).getDisplayCountry(), 224));
        avoid.add(new CountryInfo((new Locale("", "GW")).getDisplayCountry(), 245));
        avoid.add(new CountryInfo((new Locale("", "GY")).getDisplayCountry(), 592));
        avoid.add(new CountryInfo((new Locale("", "HT")).getDisplayCountry(), 509));
        avoid.add(new CountryInfo((new Locale("", "HM")).getDisplayCountry(), 672));
        avoid.add(new CountryInfo((new Locale("", "HN")).getDisplayCountry(), 504));
        avoid.add(new CountryInfo((new Locale("", "HK")).getDisplayCountry(), 852));
        avoid.add(new CountryInfo((new Locale("", "HU")).getDisplayCountry(), 36));
        avoid.add(new CountryInfo((new Locale("", "IS")).getDisplayCountry(), 354));
        avoid.add(new CountryInfo((new Locale("", "IN")).getDisplayCountry(), 91));
        avoid.add(new CountryInfo((new Locale("", "ID")).getDisplayCountry(), 62));
        avoid.add(new CountryInfo((new Locale("", "IR")).getDisplayCountry(), 98));
        avoid.add(new CountryInfo((new Locale("", "IQ")).getDisplayCountry(), 964));
        avoid.add(new CountryInfo((new Locale("", "IE")).getDisplayCountry(), 353));
        avoid.add(new CountryInfo((new Locale("", "IM")).getDisplayCountry(), 44));
        avoid.add(new CountryInfo((new Locale("", "IL")).getDisplayCountry(), 972));
        avoid.add(new CountryInfo((new Locale("", "IT")).getDisplayCountry(), 39));
        avoid.add(new CountryInfo((new Locale("", "JM")).getDisplayCountry(), 1));
        avoid.add(new CountryInfo((new Locale("", "JP")).getDisplayCountry(), 81));
        avoid.add(new CountryInfo((new Locale("", "JE")).getDisplayCountry(), 44));
        avoid.add(new CountryInfo((new Locale("", "JO")).getDisplayCountry(), 962));
        avoid.add(new CountryInfo((new Locale("", "KZ")).getDisplayCountry(), 7));
        avoid.add(new CountryInfo((new Locale("", "KE")).getDisplayCountry(), 254));
        avoid.add(new CountryInfo((new Locale("", "KI")).getDisplayCountry(), 686));
        avoid.add(new CountryInfo((new Locale("", "XK")).getDisplayCountry(), 381));
        avoid.add(new CountryInfo((new Locale("", "KW")).getDisplayCountry(), 965));
        avoid.add(new CountryInfo((new Locale("", "KG")).getDisplayCountry(), 996));
        avoid.add(new CountryInfo((new Locale("", "LA")).getDisplayCountry(), 856));
        avoid.add(new CountryInfo((new Locale("", "LV")).getDisplayCountry(), 371));
        avoid.add(new CountryInfo((new Locale("", "LB")).getDisplayCountry(), 961));
        avoid.add(new CountryInfo((new Locale("", "LS")).getDisplayCountry(), 266));
        avoid.add(new CountryInfo((new Locale("", "LR")).getDisplayCountry(), 231));
        avoid.add(new CountryInfo((new Locale("", "LY")).getDisplayCountry(), 218));
        avoid.add(new CountryInfo((new Locale("", "LI")).getDisplayCountry(), 423));
        avoid.add(new CountryInfo((new Locale("", "LT")).getDisplayCountry(), 370));
        avoid.add(new CountryInfo((new Locale("", "LU")).getDisplayCountry(), 352));
        avoid.add(new CountryInfo((new Locale("", "MO")).getDisplayCountry(), 853));
        avoid.add(new CountryInfo((new Locale("", "MK")).getDisplayCountry(), 389));
        avoid.add(new CountryInfo((new Locale("", "MG")).getDisplayCountry(), 261));
        avoid.add(new CountryInfo((new Locale("", "MW")).getDisplayCountry(), 265));
        avoid.add(new CountryInfo((new Locale("", "MY")).getDisplayCountry(), 60));
        avoid.add(new CountryInfo((new Locale("", "MV")).getDisplayCountry(), 960));
        avoid.add(new CountryInfo((new Locale("", "ML")).getDisplayCountry(), 223));
        avoid.add(new CountryInfo((new Locale("", "MT")).getDisplayCountry(), 356));
        avoid.add(new CountryInfo((new Locale("", "MH")).getDisplayCountry(), 692));
        avoid.add(new CountryInfo((new Locale("", "MQ")).getDisplayCountry(), 596));
        avoid.add(new CountryInfo((new Locale("", "MR")).getDisplayCountry(), 222));
        avoid.add(new CountryInfo((new Locale("", "MU")).getDisplayCountry(), 230));
        avoid.add(new CountryInfo((new Locale("", "YT")).getDisplayCountry(), 262));
        avoid.add(new CountryInfo((new Locale("", "MX")).getDisplayCountry(), 52));
        avoid.add(new CountryInfo((new Locale("", "FM")).getDisplayCountry(), 691));
        avoid.add(new CountryInfo((new Locale("", "MD")).getDisplayCountry(), 373));
        avoid.add(new CountryInfo((new Locale("", "MC")).getDisplayCountry(), 377));
        avoid.add(new CountryInfo((new Locale("", "MN")).getDisplayCountry(), 976));
        avoid.add(new CountryInfo((new Locale("", "ME")).getDisplayCountry(), 382));
        avoid.add(new CountryInfo((new Locale("", "MS")).getDisplayCountry(), 1));
        avoid.add(new CountryInfo((new Locale("", "MA")).getDisplayCountry(), 212));
        avoid.add(new CountryInfo((new Locale("", "MZ")).getDisplayCountry(), 258));
        avoid.add(new CountryInfo((new Locale("", "MM")).getDisplayCountry(), 95));
        avoid.add(new CountryInfo((new Locale("", "NA")).getDisplayCountry(), 264));
        avoid.add(new CountryInfo((new Locale("", "NR")).getDisplayCountry(), 674));
        avoid.add(new CountryInfo((new Locale("", "NP")).getDisplayCountry(), 977));
        avoid.add(new CountryInfo((new Locale("", "NL")).getDisplayCountry(), 31));
        avoid.add(new CountryInfo((new Locale("", "NC")).getDisplayCountry(), 687));
        avoid.add(new CountryInfo((new Locale("", "NZ")).getDisplayCountry(), 64));
        avoid.add(new CountryInfo((new Locale("", "NI")).getDisplayCountry(), 505));
        avoid.add(new CountryInfo((new Locale("", "NE")).getDisplayCountry(), 227));
        avoid.add(new CountryInfo((new Locale("", "NG")).getDisplayCountry(), 234));
        avoid.add(new CountryInfo((new Locale("", "NU")).getDisplayCountry(), 683));
        avoid.add(new CountryInfo((new Locale("", "NF")).getDisplayCountry(), 672));
        avoid.add(new CountryInfo((new Locale("", "KP")).getDisplayCountry(), 850));
        avoid.add(new CountryInfo((new Locale("", "MP")).getDisplayCountry(), 1));
        avoid.add(new CountryInfo((new Locale("", "NO")).getDisplayCountry(), 47));
        avoid.add(new CountryInfo((new Locale("", "OM")).getDisplayCountry(), 968));
        avoid.add(new CountryInfo((new Locale("", "PK")).getDisplayCountry(), 92));
        avoid.add(new CountryInfo((new Locale("", "PW")).getDisplayCountry(), 680));
        avoid.add(new CountryInfo((new Locale("", "PS")).getDisplayCountry(), 970));
        avoid.add(new CountryInfo((new Locale("", "PA")).getDisplayCountry(), 507));
        avoid.add(new CountryInfo((new Locale("", "PG")).getDisplayCountry(), 675));
        avoid.add(new CountryInfo((new Locale("", "PY")).getDisplayCountry(), 595));
        avoid.add(new CountryInfo((new Locale("", "PE")).getDisplayCountry(), 51));
        avoid.add(new CountryInfo((new Locale("", "PH")).getDisplayCountry(), 63));
        avoid.add(new CountryInfo((new Locale("", "PL")).getDisplayCountry(), 48));
        avoid.add(new CountryInfo((new Locale("", "PT")).getDisplayCountry(), 351));
        avoid.add(new CountryInfo((new Locale("", "PR")).getDisplayCountry(), 1));
        avoid.add(new CountryInfo((new Locale("", "QA")).getDisplayCountry(), 974));
        avoid.add(new CountryInfo((new Locale("", "RE")).getDisplayCountry(), 262));
        avoid.add(new CountryInfo((new Locale("", "RO")).getDisplayCountry(), 40));
        avoid.add(new CountryInfo((new Locale("", "RU")).getDisplayCountry(), 7));
        avoid.add(new CountryInfo((new Locale("", "RW")).getDisplayCountry(), 250));
        avoid.add(new CountryInfo((new Locale("", "BL")).getDisplayCountry(), 590));
        avoid.add(new CountryInfo((new Locale("", "SH")).getDisplayCountry(), 290));
        avoid.add(new CountryInfo((new Locale("", "KN")).getDisplayCountry(), 1));
        avoid.add(new CountryInfo((new Locale("", "LC")).getDisplayCountry(), 1));
        avoid.add(new CountryInfo((new Locale("", "MF")).getDisplayCountry(), 590));
        avoid.add(new CountryInfo((new Locale("", "PM")).getDisplayCountry(), 508));
        avoid.add(new CountryInfo((new Locale("", "VC")).getDisplayCountry(), 1));
        avoid.add(new CountryInfo((new Locale("", "WS")).getDisplayCountry(), 685));
        avoid.add(new CountryInfo((new Locale("", "SM")).getDisplayCountry(), 378));
        avoid.add(new CountryInfo((new Locale("", "ST")).getDisplayCountry(), 239));
        avoid.add(new CountryInfo((new Locale("", "SA")).getDisplayCountry(), 966));
        avoid.add(new CountryInfo((new Locale("", "SN")).getDisplayCountry(), 221));
        avoid.add(new CountryInfo((new Locale("", "RS")).getDisplayCountry(), 381));
        avoid.add(new CountryInfo((new Locale("", "SC")).getDisplayCountry(), 248));
        avoid.add(new CountryInfo((new Locale("", "SL")).getDisplayCountry(), 232));
        avoid.add(new CountryInfo((new Locale("", "SG")).getDisplayCountry(), 65));
        avoid.add(new CountryInfo((new Locale("", "SX")).getDisplayCountry(), 1));
        avoid.add(new CountryInfo((new Locale("", "SK")).getDisplayCountry(), 421));
        avoid.add(new CountryInfo((new Locale("", "SI")).getDisplayCountry(), 386));
        avoid.add(new CountryInfo((new Locale("", "SB")).getDisplayCountry(), 677));
        avoid.add(new CountryInfo((new Locale("", "SO")).getDisplayCountry(), 252));
        avoid.add(new CountryInfo((new Locale("", "ZA")).getDisplayCountry(), 27));
        avoid.add(new CountryInfo((new Locale("", "GS")).getDisplayCountry(), 500));
        avoid.add(new CountryInfo((new Locale("", "KR")).getDisplayCountry(), 82));
        avoid.add(new CountryInfo((new Locale("", "SS")).getDisplayCountry(), 211));
        avoid.add(new CountryInfo((new Locale("", "ES")).getDisplayCountry(), 34));
        avoid.add(new CountryInfo((new Locale("", "LK")).getDisplayCountry(), 94));
        avoid.add(new CountryInfo((new Locale("", "SD")).getDisplayCountry(), 249));
        avoid.add(new CountryInfo((new Locale("", "SR")).getDisplayCountry(), 597));
        avoid.add(new CountryInfo((new Locale("", "SJ")).getDisplayCountry(), 47));
        avoid.add(new CountryInfo((new Locale("", "SZ")).getDisplayCountry(), 268));
        avoid.add(new CountryInfo((new Locale("", "SE")).getDisplayCountry(), 46));
        avoid.add(new CountryInfo((new Locale("", "CH")).getDisplayCountry(), 41));
        avoid.add(new CountryInfo((new Locale("", "SY")).getDisplayCountry(), 963));
        avoid.add(new CountryInfo((new Locale("", "TW")).getDisplayCountry(), 886));
        avoid.add(new CountryInfo((new Locale("", "TJ")).getDisplayCountry(), 992));
        avoid.add(new CountryInfo((new Locale("", "TZ")).getDisplayCountry(), 255));
        avoid.add(new CountryInfo((new Locale("", "TH")).getDisplayCountry(), 66));
        avoid.add(new CountryInfo((new Locale("", "TG")).getDisplayCountry(), 228));
        avoid.add(new CountryInfo((new Locale("", "TK")).getDisplayCountry(), 690));
        avoid.add(new CountryInfo((new Locale("", "TO")).getDisplayCountry(), 676));
        avoid.add(new CountryInfo((new Locale("", "TT")).getDisplayCountry(), 1));
        avoid.add(new CountryInfo((new Locale("", "TN")).getDisplayCountry(), 216));
        avoid.add(new CountryInfo((new Locale("", "TR")).getDisplayCountry(), 90));
        avoid.add(new CountryInfo((new Locale("", "TM")).getDisplayCountry(), 993));
        avoid.add(new CountryInfo((new Locale("", "TC")).getDisplayCountry(), 1));
        avoid.add(new CountryInfo((new Locale("", "TV")).getDisplayCountry(), 688));
        avoid.add(new CountryInfo((new Locale("", "VI")).getDisplayCountry(), 1));
        avoid.add(new CountryInfo((new Locale("", "UG")).getDisplayCountry(), 256));
        avoid.add(new CountryInfo((new Locale("", "UA")).getDisplayCountry(), 380));
        avoid.add(new CountryInfo((new Locale("", "AE")).getDisplayCountry(), 971));
        avoid.add(new CountryInfo((new Locale("", "GB")).getDisplayCountry(), 44));
        avoid.add(new CountryInfo((new Locale("", "US")).getDisplayCountry(), 1));
        avoid.add(new CountryInfo((new Locale("", "UY")).getDisplayCountry(), 598));
        avoid.add(new CountryInfo((new Locale("", "UZ")).getDisplayCountry(), 998));
        avoid.add(new CountryInfo((new Locale("", "VU")).getDisplayCountry(), 678));
        avoid.add(new CountryInfo((new Locale("", "VA")).getDisplayCountry(), 379));
        avoid.add(new CountryInfo((new Locale("", "VE")).getDisplayCountry(), 58));
        avoid.add(new CountryInfo((new Locale("", "VN")).getDisplayCountry(), 84));
        avoid.add(new CountryInfo((new Locale("", "WF")).getDisplayCountry(), 681));
        avoid.add(new CountryInfo((new Locale("", "EH")).getDisplayCountry(), 212));
        avoid.add(new CountryInfo((new Locale("", "YE")).getDisplayCountry(), 967));
        avoid.add(new CountryInfo((new Locale("", "ZM")).getDisplayCountry(), 260));
        avoid.add(new CountryInfo((new Locale("", "ZW")).getDisplayCountry(), 263));
        Collections.sort(avoid);
        return avoid;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((List)obj);
    }

    protected void onPostExecute(List list)
    {
        if (listener != null)
        {
            listener.onLoadComplete(list);
        }
    }
}
