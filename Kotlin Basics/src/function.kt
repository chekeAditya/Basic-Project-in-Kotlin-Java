fun main() {
    add(3, 2)
    println("Addition with Return type is  ${addWithReturnType(10, 20)}")
    println("You can return this ways also shortcut ${addWithReturnTypeEasy(22,34)}")
}

// this is the function
fun add(a: Int, b: Int) { //here we are telling the datatype of a and b and it's mandatory to write it
    val c = a + b
    println("Value of c is $c")
}

//if you want to return then write the Int after if
fun addWithReturnType(a: Int, b: Int): Int {
    return a + b
}
//you can return by this way also
fun addWithReturnTypeEasy(a: Int, b: Int) = a + b

//void = Unit byDefault it's a void