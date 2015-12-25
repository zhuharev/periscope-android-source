// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.drm;

import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.android.exoplayer.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer.util.Util;
import java.util.HashMap;
import java.util.UUID;

// Referenced classes of package com.google.android.exoplayer.drm:
//            DrmSessionManager, UnsupportedDrmException, DrmInitData, MediaDrmCallback, 
//            KeysExpiredException

public class StreamingDrmSessionManager
    implements DrmSessionManager
{
    public static interface EventListener
    {

        public abstract void onDrmKeysLoaded();

        public abstract void onDrmSessionManagerError(Exception exception);
    }

    class MediaDrmEventListener
        implements android.media.MediaDrm.OnEventListener
    {

        final StreamingDrmSessionManager this$0;

        public void onEvent(MediaDrm mediadrm, byte abyte0[], int i, int j, byte abyte1[])
        {
            mediaDrmHandler.sendEmptyMessage(i);
        }

        private MediaDrmEventListener()
        {
            this$0 = StreamingDrmSessionManager.this;
            super();
        }

        MediaDrmEventListener(_cls1 _pcls1)
        {
            this();
        }
    }

    class MediaDrmHandler extends Handler
    {

        final StreamingDrmSessionManager this$0;

        public void handleMessage(Message message)
        {
            if (openCount == 0 || state != 3 && state != 4)
            {
                return;
            }
            switch (message.what)
            {
            default:
                return;

            case 2: // '\002'
                postKeyRequest();
                return;

            case 3: // '\003'
                state = 3;
                onError(new KeysExpiredException());
                return;

            case 1: // '\001'
                state = 3;
                postProvisionRequest();
                return;
            }
        }

        public MediaDrmHandler(Looper looper)
        {
            this$0 = StreamingDrmSessionManager.this;
            super(looper);
        }
    }

    class PostRequestHandler extends Handler
    {

        final StreamingDrmSessionManager this$0;

        public void handleMessage(Message message)
        {
            message.what;
            JVM INSTR lookupswitch 2: default 120
        //                       0: 32
        //                       1: 62;
               goto _L1 _L2 _L3
_L2:
            Object obj;
            obj = callback.executeProvisionRequest(uuid, (android.media.MediaDrm.ProvisionRequest)message.obj);
            break; /* Loop/switch isn't completed */
_L3:
            try
            {
                obj = callback.executeKeyRequest(uuid, (android.media.MediaDrm.KeyRequest)message.obj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
            break; /* Loop/switch isn't completed */
_L1:
            throw new RuntimeException();
            postResponseHandler.obtainMessage(message.what, obj).sendToTarget();
            return;
        }

        public PostRequestHandler(Looper looper)
        {
            this$0 = StreamingDrmSessionManager.this;
            super(looper);
        }
    }

    class PostResponseHandler extends Handler
    {

        final StreamingDrmSessionManager this$0;

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                return;

            case 0: // '\0'
                onProvisionResponse(message.obj);
                return;

            case 1: // '\001'
                onKeyResponse(message.obj);
                break;
            }
        }

        public PostResponseHandler(Looper looper)
        {
            this$0 = StreamingDrmSessionManager.this;
            super(looper);
        }
    }


    private static final int MSG_KEYS = 1;
    private static final int MSG_PROVISION = 0;
    public static final String PLAYREADY_CUSTOM_DATA_KEY = "PRCustomData";
    public static final UUID PLAYREADY_UUID = new UUID(0x9a04f07998404286L, 0xab92e65be0885f95L);
    public static final UUID WIDEVINE_UUID = new UUID(0xedef8ba979d64aceL, 0xa3c827dcd51d21edL);
    final MediaDrmCallback callback;
    private final Handler eventHandler;
    private final EventListener eventListener;
    private Exception lastException;
    private MediaCrypto mediaCrypto;
    private final MediaDrm mediaDrm;
    final MediaDrmHandler mediaDrmHandler;
    private String mimeType;
    private int openCount;
    private final HashMap optionalKeyRequestParameters;
    private Handler postRequestHandler;
    final PostResponseHandler postResponseHandler;
    private boolean provisioningInProgress;
    private HandlerThread requestHandlerThread;
    private byte schemeData[];
    private byte sessionId[];
    private int state;
    final UUID uuid;

    public StreamingDrmSessionManager(UUID uuid1, Looper looper, MediaDrmCallback mediadrmcallback, HashMap hashmap, Handler handler, EventListener eventlistener)
    {
        uuid = uuid1;
        callback = mediadrmcallback;
        optionalKeyRequestParameters = hashmap;
        eventHandler = handler;
        eventListener = eventlistener;
        try
        {
            mediaDrm = new MediaDrm(uuid1);
        }
        // Misplaced declaration of an exception variable
        catch (UUID uuid1)
        {
            throw new UnsupportedDrmException(1, uuid1);
        }
        // Misplaced declaration of an exception variable
        catch (UUID uuid1)
        {
            throw new UnsupportedDrmException(2, uuid1);
        }
        mediaDrm.setOnEventListener(new MediaDrmEventListener(null));
        mediaDrmHandler = new MediaDrmHandler(looper);
        postResponseHandler = new PostResponseHandler(looper);
        state = 1;
    }

    public static StreamingDrmSessionManager newPlayReadyInstance(Looper looper, MediaDrmCallback mediadrmcallback, String s, Handler handler, EventListener eventlistener)
    {
        if (!TextUtils.isEmpty(s))
        {
            HashMap hashmap = new HashMap();
            hashmap.put("PRCustomData", s);
            s = hashmap;
        } else
        {
            s = null;
        }
        return new StreamingDrmSessionManager(PLAYREADY_UUID, looper, mediadrmcallback, s, handler, eventlistener);
    }

    public static StreamingDrmSessionManager newWidevineInstance(Looper looper, MediaDrmCallback mediadrmcallback, HashMap hashmap, Handler handler, EventListener eventlistener)
    {
        return new StreamingDrmSessionManager(WIDEVINE_UUID, looper, mediadrmcallback, hashmap, handler, eventlistener);
    }

    private void onError(final Exception e)
    {
        lastException = e;
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new _cls2());
        }
        if (state != 4)
        {
            state = 0;
        }
    }

    private void onKeyResponse(Object obj)
    {
        if (state != 3 && state != 4)
        {
            return;
        }
        if (obj instanceof Exception)
        {
            onKeysError((Exception)obj);
            return;
        }
        try
        {
            mediaDrm.provideKeyResponse(sessionId, (byte[])obj);
            state = 4;
            if (eventHandler != null && eventListener != null)
            {
                eventHandler.post(new _cls1());
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            onKeysError(((Exception) (obj)));
        }
    }

    private void onKeysError(Exception exception)
    {
        if (exception instanceof NotProvisionedException)
        {
            postProvisionRequest();
            return;
        } else
        {
            onError(exception);
            return;
        }
    }

    private void onProvisionResponse(Object obj)
    {
        provisioningInProgress = false;
        if (state != 2 && state != 3 && state != 4)
        {
            return;
        }
        if (obj instanceof Exception)
        {
            onError((Exception)obj);
            return;
        }
        mediaDrm.provideProvisionResponse((byte[])obj);
        if (state == 2)
        {
            openInternal(false);
            return;
        }
        try
        {
            postKeyRequest();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            onError(((Exception) (obj)));
        }
        return;
    }

    private void openInternal(boolean flag)
    {
        try
        {
            sessionId = mediaDrm.openSession();
            mediaCrypto = new MediaCrypto(uuid, sessionId);
            state = 3;
            postKeyRequest();
            return;
        }
        catch (NotProvisionedException notprovisionedexception)
        {
            if (flag)
            {
                postProvisionRequest();
                return;
            } else
            {
                onError(notprovisionedexception);
                return;
            }
        }
        catch (Exception exception)
        {
            onError(exception);
        }
    }

    private void postKeyRequest()
    {
        try
        {
            android.media.MediaDrm.KeyRequest keyrequest = mediaDrm.getKeyRequest(sessionId, schemeData, mimeType, 1, optionalKeyRequestParameters);
            postRequestHandler.obtainMessage(1, keyrequest).sendToTarget();
            return;
        }
        catch (NotProvisionedException notprovisionedexception)
        {
            onKeysError(notprovisionedexception);
        }
    }

    private void postProvisionRequest()
    {
        if (provisioningInProgress)
        {
            return;
        } else
        {
            provisioningInProgress = true;
            android.media.MediaDrm.ProvisionRequest provisionrequest = mediaDrm.getProvisionRequest();
            postRequestHandler.obtainMessage(0, provisionrequest).sendToTarget();
            return;
        }
    }

    public void close()
    {
        int i = openCount - 1;
        openCount = i;
        if (i != 0)
        {
            return;
        }
        state = 1;
        provisioningInProgress = false;
        mediaDrmHandler.removeCallbacksAndMessages(null);
        postResponseHandler.removeCallbacksAndMessages(null);
        postRequestHandler.removeCallbacksAndMessages(null);
        postRequestHandler = null;
        requestHandlerThread.quit();
        requestHandlerThread = null;
        schemeData = null;
        mediaCrypto = null;
        lastException = null;
        if (sessionId != null)
        {
            mediaDrm.closeSession(sessionId);
            sessionId = null;
        }
    }

    public final Exception getError()
    {
        if (state == 0)
        {
            return lastException;
        } else
        {
            return null;
        }
    }

    public final MediaCrypto getMediaCrypto()
    {
        if (state != 3 && state != 4)
        {
            throw new IllegalStateException();
        } else
        {
            return mediaCrypto;
        }
    }

    public final byte[] getPropertyByteArray(String s)
    {
        return mediaDrm.getPropertyByteArray(s);
    }

    public final String getPropertyString(String s)
    {
        return mediaDrm.getPropertyString(s);
    }

    public final int getState()
    {
        return state;
    }

    public void open(DrmInitData drminitdata)
    {
        int i = openCount + 1;
        openCount = i;
        if (i != 1)
        {
            return;
        }
        if (postRequestHandler == null)
        {
            requestHandlerThread = new HandlerThread("DrmRequestHandler");
            requestHandlerThread.start();
            postRequestHandler = new PostRequestHandler(requestHandlerThread.getLooper());
        }
        if (schemeData == null)
        {
            mimeType = drminitdata.mimeType;
            schemeData = drminitdata.get(uuid);
            if (schemeData == null)
            {
                onError(new IllegalStateException((new StringBuilder("Media does not support uuid: ")).append(uuid).toString()));
                return;
            }
            if (Util.SDK_INT < 21)
            {
                drminitdata = PsshAtomUtil.parseSchemeSpecificData(schemeData, WIDEVINE_UUID);
                if (drminitdata != null)
                {
                    schemeData = drminitdata;
                }
            }
        }
        state = 2;
        openInternal(true);
    }

    public boolean requiresSecureDecoderComponent(String s)
    {
        if (state != 3 && state != 4)
        {
            throw new IllegalStateException();
        } else
        {
            return mediaCrypto.requiresSecureDecoderComponent(s);
        }
    }

    public final void setPropertyByteArray(String s, byte abyte0[])
    {
        mediaDrm.setPropertyByteArray(s, abyte0);
    }

    public final void setPropertyString(String s, String s1)
    {
        mediaDrm.setPropertyString(s, s1);
    }






/*
    static int access$302(StreamingDrmSessionManager streamingdrmsessionmanager, int i)
    {
        streamingdrmsessionmanager.state = i;
        return i;
    }

*/






    private class _cls2
        implements Runnable
    {

        final StreamingDrmSessionManager this$0;
        final Exception val$e;

        public void run()
        {
            eventListener.onDrmSessionManagerError(e);
        }

        _cls2()
        {
            this$0 = StreamingDrmSessionManager.this;
            e = exception;
            super();
        }
    }


    private class _cls1
        implements Runnable
    {

        final StreamingDrmSessionManager this$0;

        public void run()
        {
            eventListener.onDrmKeysLoaded();
        }

        _cls1()
        {
            this$0 = StreamingDrmSessionManager.this;
            super();
        }
    }

}
