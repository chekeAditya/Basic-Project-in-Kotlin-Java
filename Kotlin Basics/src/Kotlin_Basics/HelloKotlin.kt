fun main(args: Array<String>) { //if we won't write args then also it will be perfect

    println("Hello world") // output -> Hello world
    println("aditya")     // output -> Hello worldaditya


    var a = 4 //here by default it is taking as a int if you want to change the datatype then you can define it
    var b: Float = 4.5f //float
    println("a") //o.p -> a
    println(a) //o.p -> 4
    println("$a") //o.p -> 4 (this is String interpolation)
    println("Hello world " + 4)//here you can use this and also
    println("Hello world $a how are you ") //$ used to refer a variable
    a = 5
    println("value of a after init is $a")

    println("---------------------------")
    val c = 4
    println("when we use val it means it is a final is $c and we can't change it ")
}

