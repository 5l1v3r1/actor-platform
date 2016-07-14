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

public class ApiServiceTimerChanged extends ApiServiceEx {

    private int timerMs;

    public ApiServiceTimerChanged(int timerMs) {
        this.timerMs = timerMs;
    }

    public ApiServiceTimerChanged() {

    }

    public int getHeader() {
        return 23;
    }

    public int getTimerMs() {
        return this.timerMs;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.timerMs = values.getInt(1);
        if (values.hasRemaining()) {
            setUnmappedObjects(values.buildRemaining());
        }
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeInt(1, this.timerMs);
        if (this.getUnmappedObjects() != null) {
            SparseArray<Object> unmapped = this.getUnmappedObjects();
            for (int i = 0; i < unmapped.size(); i++) {
                int key = unmapped.keyAt(i);
                writer.writeUnmapped(key, unmapped.get(key));
            }
        }
    }

    @Override
    public String toString() {
        String res = "struct ServiceTimerChanged{";
        res += "timerMs=" + this.timerMs;
        res += "}";
        return res;
    }

}
