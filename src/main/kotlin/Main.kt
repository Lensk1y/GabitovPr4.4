import kotlin.math.pow
import kotlin.math.sqrt

class Point(val x: Double, val y: Double)

class Triangle(val A: Point, val B: Point, val C: Point) {
    fun getCircleCenterAndRadius(): Pair<Point, Double> {
        val D = 2 * (A.x * (B.y - C.y) + B.x * (C.y - A.y) + C.x * (A.y - B.y))
        val centerX = ((A.x.pow(2) + A.y.pow(2)) * (B.y - C.y) + (B.x.pow(2) + B.y.pow(2)) * (C.y - A.y) + (C.x.pow(2) + C.y.pow(2)) * (A.y - B.y)) / D
        val centerY = ((A.x.pow(2) + A.y.pow(2)) * (C.x - B.x) + (B.x.pow(2) + B.y.pow(2)) * (A.x - C.x) + (C.x.pow(2) + C.y.pow(2)) * (B.x - A.x)) / D
        val radius = sqrt((centerX - A.x).pow(2) + (centerY - A.y).pow(2))
        return Pair(Point(centerX, centerY), radius)
    }
}

fun main() {
    val A = Point(0.0, 0.0)
    val B = Point(4.0, 0.0)
    val C = Point(0.0, 3.0)

    val triangle = Triangle(A, B, C)
    val (center, radius) = triangle.getCircleCenterAndRadius()

    println("Центр окружности: (${center.x}, ${center.y}), Радиус: $radius")
}