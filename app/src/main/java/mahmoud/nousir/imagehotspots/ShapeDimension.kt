package mahmoud.nousir.imagehotspots

data class ShapeDimension(
    val left: Float,
    val top: Float,
    val right: Float,
    val bottom: Float
) {
    companion object {
        fun createShapeDimensionObject(
            marginLeft: Float,
            marginTop: Float,
            width: Float,
            height: Float
        ): ShapeDimension {
            // RectF object needs four attributes in constructor as follow:
            // left -> which represent the margin from left side
            // top -> which represent the margin from top side
            // right -> which represent the width of view + the margin from left side
            // bottom -> which represent the height of view + the margin from top side
            //so, the following calculation is necessary
            val rectFRight = width + marginLeft
            val rectBottom = height + marginTop
            return ShapeDimension(
                left = marginLeft,
                top = marginTop,
                right = rectFRight,
                bottom = rectBottom
            )
        }
    }
}
