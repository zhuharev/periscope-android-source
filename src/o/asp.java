// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import tv.periscope.chatman.api.ChatMessage;
import tv.periscope.chatman.api.HistoryResponse;
import tv.periscope.chatman.api.WireMessage;

// Referenced classes of package o:
//            auh, ig, asv, aso, 
//            asz

public final class asp
    implements Callback
{

    private String bDk;
    private aso bDl;

    public asp(aso aso1, String s)
    {
        bDl = aso1;
        bDk = s;
        super();
    }

    public final void failure(RetrofitError retrofiterror)
    {
    }

    public final void success(Object obj, Response response)
    {
        Object obj1 = (HistoryResponse)obj;
        obj = Collections.emptyList();
        asw.if if1 = new asw.if();
        if1.bDx = ((Collection) (obj));
        obj = if1.FEA9("").FEA9(((HistoryResponse) (obj1)).cursor);
        if (response.getStatus() == 200)
        {
            response = new ArrayList();
            obj1 = ((HistoryResponse) (obj1)).messages.iterator();
            do
            {
                if (!((Iterator) (obj1)).hasNext())
                {
                    break;
                }
                WireMessage wiremessage = (WireMessage)((Iterator) (obj1)).next();
                if (wiremessage.kind == 1)
                {
                    ChatMessage chatmessage = (ChatMessage)auh.bFf._mth02CA(wiremessage.payload, tv/periscope/chatman/api/ChatMessage);
                    response.add(new asv(chatmessage.room, chatmessage.body, chatmessage.sender, chatmessage.timestamp, wiremessage.payload));
                }
            } while (true);
            ((asz.if) (obj))._mth02CC(response);
        }
        ((asz.if) (obj)).FE9B(bDk);
        obj = ((asz.if) (obj)).eO();
        response = aso._mth02CA(bDl);
        boolean flag;
        if (((asz) (obj)).eL().size() == 1000)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        response._mth02CA(((asz) (obj)), flag);
    }
}
