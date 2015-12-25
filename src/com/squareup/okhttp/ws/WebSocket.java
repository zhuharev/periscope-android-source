// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.ws;

import o.vr;
import o.vu;

public interface WebSocket
{
    public static final class PayloadType extends Enum
    {

        private static final PayloadType $VALUES[];
        public static final PayloadType BINARY;
        public static final PayloadType TEXT;

        public static PayloadType valueOf(String s)
        {
            return (PayloadType)Enum.valueOf(com/squareup/okhttp/ws/WebSocket$PayloadType, s);
        }

        public static PayloadType[] values()
        {
            return (PayloadType[])$VALUES.clone();
        }

        static 
        {
            TEXT = new PayloadType("TEXT", 0);
            BINARY = new PayloadType("BINARY", 1);
            $VALUES = (new PayloadType[] {
                TEXT, BINARY
            });
        }

        private PayloadType(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract void close(int i, String s);

    public abstract vu newMessageSink(PayloadType payloadtype);

    public abstract void sendMessage(PayloadType payloadtype, vr vr);

    public abstract void sendPing(vr vr);
}
