// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.api;

import java.io.File;
import retrofit.mime.TypedFile;

// Referenced classes of package tv.periscope.android.api:
//            ApiRunnable

class this._cls0 extends TypedFile
{

    final ApiRunnable this$0;

    public String fileName()
    {
        return "image.jpeg";
    }

    (String s, File file)
    {
        this$0 = ApiRunnable.this;
        super(s, file);
    }
}
