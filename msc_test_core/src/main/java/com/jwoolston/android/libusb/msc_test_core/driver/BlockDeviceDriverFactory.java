/*
 * (C) Copyright 2014 mjahnen <jahnen@in.tum.de>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package com.jwoolston.android.libusb.msc_test_core.driver;

import com.jwoolston.android.libusb.msc_test_core.driver.scsi.AsyncScsiBlockDevice;
import com.jwoolston.android.libusb.msc_test_core.driver.scsi.ScsiBlockDevice;
import com.jwoolston.android.libusb.msc_test_core.usb.UsbCommunication;

/**
 * A helper class to create different
 * {@link com.github.mjdev.libaums.driver.BlockDeviceDriver}s.
 * 
 * @author mjahnen
 * 
 */
public class BlockDeviceDriverFactory {
	/**
	 * This method creates a
	 * {@link com.github.mjdev.libaums.driver.BlockDeviceDriver} which is
	 * suitable for the underlying mass storage device.
	 * 
	 * @param usbCommunication
	 *            The underlying USB communication.
	 * @return A driver which can handle the USB mass storage device.
	 */
	public static BlockDeviceDriver createBlockDevice(UsbCommunication usbCommunication, boolean async) {
		// we currently only support scsi transparent command set
		if (async) {
			return new AsyncScsiBlockDevice(usbCommunication);
		} else {
			return new ScsiBlockDevice(usbCommunication);
		}
	}
}