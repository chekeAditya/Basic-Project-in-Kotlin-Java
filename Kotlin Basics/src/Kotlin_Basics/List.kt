fun main() {
    //in Kotlin their are 2 types of list
    val list = listOf<Int>(1, 2, 3, 4, 5)
    // here this list is immutable list : means you cannot change the properties of the list or the element
    println(list)

    val mutableList = mutableListOf<Int>(1,2,3,4,5)
    mutableList.add(10)
    mutableList.add(11)
    println(mutableList)
}
/*
listOf -> immutable -> cannot change
mutableListOf -> mutable list -> you can change it
 */