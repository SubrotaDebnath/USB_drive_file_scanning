package subrota.shuveo.usbdrivefilescanning

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.print.PrintHelper


class MainActivity : AppCompatActivity() {

    private val tag: String = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fromUsbButton = findViewById<Button>(R.id.usbBTN)




        fromUsbButton.setOnClickListener {
            Log.i(tag, "Usb button clicked")


            this.also { context ->
                PrintHelper(context).apply {
                    scaleMode = PrintHelper.SCALE_MODE_FIT
                }.also { printHelper ->
                    val bitmap = BitmapFactory.decodeResource(resources, R.drawable.man)
                    printHelper.printBitmap("droids.jpg - test print", bitmap)
                }
            }

        }
    }

}


