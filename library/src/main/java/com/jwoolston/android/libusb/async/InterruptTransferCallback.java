package com.jwoolston.android.libusb.async;

import android.support.annotation.Nullable;

import java.nio.ByteBuffer;

/**
 * @author Jared Woolston (Jared.Woolston@gmail.com)
 */
public interface InterruptTransferCallback {

    void onInterruptTransferComplete(@Nullable ByteBuffer data, int result);
}
