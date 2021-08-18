fun main() {
//assigning the value of arr and printing it
    val arr = arrayOf(1, 2, 3, 4, 5, 10, "Aditya", "Karan")
    println("Element of the array are :- ")
    for (i in arr)
        print("$i ")


    println("print the index of the element of the array ")
    arr.forEachIndexed { index, value ->
        print("Index: $index Value: $value ")
    }
    println()

    //assigning the value through the size
    val a = IntArray(2)
    a[0] = 10
    a[1] = 20
    for (i in a)
        println(i)
}