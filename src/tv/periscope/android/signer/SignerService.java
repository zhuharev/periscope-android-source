// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.signer;

import retrofit.Callback;
import retrofit.mime.TypedFile;
import tv.periscope.android.api.PsMessage;
import tv.periscope.android.api.UploadTestResponse;

public interface SignerService
{

    public abstract void sign(PsMessage psmessage, Callback callback);

    public abstract UploadTestResponse uploadPadding(String s, TypedFile typedfile);
}
