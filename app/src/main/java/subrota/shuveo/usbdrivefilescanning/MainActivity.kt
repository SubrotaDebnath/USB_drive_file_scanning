package subrota.shuveo.usbdrivefilescanning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import me.jahnen.libaums.core.UsbMassStorageDevice

class MainActivity : AppCompatActivity() {

    private val tag: String = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val devices = UsbMassStorageDevice.getMassStorageDevices(this /* Context or Activity */)

        for (device in devices) {

            // before interacting with a device you need to call init()!
            device.init()

            // Only uses the first partition on the device
            val currentFs = device.partitions[0].fileSystem
            Log.i(tag, "Capacity: " + currentFs.capacity)
            Log.i(tag, "Occupied Space: " + currentFs.occupiedSpace)
            Log.i(tag, "Free Space: " + currentFs.freeSpace)
            Log.i(tag, "Chunk size: " + currentFs.chunkSize)
        }
    }
}