def stuMap = [name: "xiaoming", age: 18, sex: "男"]
println(stuMap)
println(stuMap['name'])
println(stuMap.age)
//添加元素
stuMap.apple="apple"
stuMap.conmap=[a:"a",b:"b"]
//移除元素
//stuMap.remove('name')
println(stuMap)
println(stuMap.getClass())//class java.util.LinkedHashMap
//遍历map
stuMap.each {
    stu->
        println("key:${stu.key} value:${stu.value}")
}
//带索引的 遍历
stuMap.eachWithIndex { Map.Entry<String, Serializable> stu, int i ->
    println("inedex:${i} key:${stu.key} value:${stu.value}")
}
//也可以直接这样搞
stuMap.each {
    key,value->
        println("key:${key} value:${value}")
}

//find findAll count groupBy分组 sort


