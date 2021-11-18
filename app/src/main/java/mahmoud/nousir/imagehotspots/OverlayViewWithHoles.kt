package mahmoud.nousir.imagehotspots

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.core.content.ContextCompat

//this class draw a linear layout which contains holes
//hole position is detected by shapeDimension object

class OverlayViewWithHoles : LinearLayout {
    constructor(context: Context, shapesDimensionList: List<ShapeDimension>) : this(context, null) {
        shapesDimension = shapesDimensionList
    }

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private var bitmap: Bitmap? = null
    private var alpha: Int = ALPHA_SEMI_TRANSPARENT
    private var centerX: Float? = null
    private var centerY: Float? = null
    private var forceReset = false
    private var shapesDimension: List<ShapeDimension>? = null


    override fun dispatchDraw(canvas: Canvas) {
        super.dispatchDraw(canvas)
        if (bitmap == null || forceReset) {
            createWindowFrame(100f, 100f)


        }
        canvas.drawBitmap(bitmap!!, 0F, 0F, null)

    }

    private fun createWindowFrame(x: Float, y: Float) {
        if (centerX == null) {
            centerX = x
        }
        if (centerY == null) {
            centerY = y
        }

        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ALPHA_8)
        val osCanvas = Canvas(bitmap!!)
        val outerRectangle = RectF(0F, 0F, width.toFloat(), height.toFloat())
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color = ContextCompat.getColor(context, R.color.overlyBackGround)
        paint.alpha = alpha
        osCanvas.drawRect(outerRectangle, paint)
        paint.color = Color.TRANSPARENT
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_OUT)
        drawShapes(osCanvas, paint)
        forceReset = false

    }

    private fun drawShapes(osCanvas: Canvas, paint: Paint) {
        shapesDimension?.forEach { shape ->
            val rect = RectF(shape.left, shape.top, shape.right, shape.bottom)
            osCanvas.drawRoundRect(rect, SHAPE_RADIUS, SHAPE_RADIUS, paint)
        }
    }

    override fun isInEditMode(): Boolean {
        return true
    }


    override fun onLayout(
        changed: Boolean, l: Int, t: Int, r: Int, b: Int
    ) {
        super.onLayout(changed, l, t, r, b)
        bitmap = null
    }
}

const val ALPHA_SEMI_TRANSPARENT = 130
const val SHAPE_RADIUS = 8f