package mahmoud.nousir.imagehotspots

import android.graphics.Bitmap
import android.widget.FrameLayout

//draw layout above frame layout which contains holes
fun FrameLayout.drawHoles(
    resource: Bitmap,
    shapeDimensionList: List<ShapeDimension>
): OverlayViewWithHoles {
    val params = FrameLayout.LayoutParams(
        FrameLayout.LayoutParams.WRAP_CONTENT,
        FrameLayout.LayoutParams.WRAP_CONTENT
    )
    params.width = convertPxToDp(resource.width.toFloat(), context).toInt()
    params.height = convertPxToDp(resource.height.toFloat(), context).toInt()

    val shape = OverlayViewWithHoles(
        context,
        shapesDimensionList = shapeDimensionList
    )
    shape.layoutParams = params
    addView(shape)

    return shape
}
