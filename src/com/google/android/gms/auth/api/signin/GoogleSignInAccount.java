// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import o.06BD;
import o.cw;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInAccount
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls06BD();
    public final int versionCode;
    public String wt;
    public String wu;
    public String wv;
    public String ww;
    public Uri wx;
    public String wy;
    public long wz;

    public GoogleSignInAccount(int i, String s, String s1, String s2, String s3, Uri uri, String s4, 
            long l)
    {
        versionCode = i;
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("Given String is empty or null");
        } else
        {
            wt = s;
            wu = s1;
            wv = s2;
            ww = s3;
            wx = uri;
            wy = s4;
            wz = l;
            return;
        }
    }

    private JSONObject _mth0213()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("id", wt);
            if (wu != null)
            {
                jsonobject.put("tokenId", wu);
            }
            if (wv != null)
            {
                jsonobject.put("email", wv);
            }
            if (ww != null)
            {
                jsonobject.put("displayName", ww);
            }
            if (wx != null)
            {
                jsonobject.put("photoUrl", wx.toString());
            }
            if (wy != null)
            {
                jsonobject.put("serverAuthCode", wy);
            }
            jsonobject.put("expirationTime", wz);
        }
        catch (JSONException jsonexception)
        {
            throw new RuntimeException(jsonexception);
        }
        return jsonobject;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof GoogleSignInAccount))
        {
            return false;
        } else
        {
            return ((GoogleSignInAccount)obj)._mth0213().toString().equals(_mth0213().toString());
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        _cls06BD._mth02CA(this, parcel, i);
    }

    static 
    {
        cw._mth027D();
    }
}
