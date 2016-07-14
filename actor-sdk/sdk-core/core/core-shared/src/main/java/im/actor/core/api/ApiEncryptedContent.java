package im.actor.core.api;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import im.actor.runtime.bser.*;
import im.actor.runtime.collections.*;
import static im.actor.runtime.bser.Utils.*;
import im.actor.core.network.parser.*;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import com.google.j2objc.annotations.ObjectiveCName;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public abstract class ApiEncryptedContent extends BserObject {
    public static ApiEncryptedContent fromBytes(byte[] src) throws IOException {
        BserValues values = new BserValues(BserParser.deserialize(new DataInput(src, 0, src.length)));
        int key = values.getInt(1);
        byte[] content = values.getBytes(2);
        switch(key) { 
            case 1: return Bser.parse(new ApiEncryptedMessageContent(), content);
            case 2: return Bser.parse(new ApiEncryptedEditContent(), content);
            case 3: return Bser.parse(new ApiEncryptedDeleteContent(), content);
            case 4: return Bser.parse(new ApiEncryptedReceived(), content);
            case 5: return Bser.parse(new ApiEncryptedRead(), content);
            case 6: return Bser.parse(new ApiEncryptedDeleteAll(), content);
            default: return new ApiEncryptedContentUnsupported(key, content);
        }
    }
    public abstract int getHeader();

    public byte[] buildContainer() throws IOException {
        DataOutput res = new DataOutput();
        BserWriter writer = new BserWriter(res);
        writer.writeInt(1, getHeader());
        writer.writeBytes(2, toByteArray());
        return res.toByteArray();
    }

}
