package mahmoud.nousir.imagehotspots

import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val frameLayout = findViewById<FrameLayout>(R.id.image_frame_layout)
        val imageBitmap =
            (ContextCompat.getDrawable(this, R.drawable.sample) as BitmapDrawable).bitmap
        frameLayout.drawHoles(
            imageBitmap,
            listOf(
                ShapeDimension.createShapeDimensionObject(
                    marginTop = convertPxToDp(70f, this),
                    marginLeft = convertPxToDp(70f, this),
                    width = convertPxToDp(180f, this),
                    height = convertPxToDp(200f, this)
                ),
                ShapeDimension.createShapeDimensionObject(
                    marginTop = convertPxToDp(700f, this),
                    marginLeft = convertPxToDp(60f, this),
                    width = convertPxToDp(190f, this),
                    height = convertPxToDp(200f, this)
                ),
                ShapeDimension.createShapeDimensionObject(
                    marginTop = convertPxToDp(370f, this),
                    marginLeft = convertPxToDp(400f, this),
                    width = convertPxToDp(200f, this),
                    height = convertPxToDp(200f, this)
                )
            )
        )
    }
}