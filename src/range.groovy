//范围 是list子类
def range = 1..10
println(range[0])
println(range.contains(3))
//获取起始值
println(range.from)
//获取最后的值
println(range.to)

range.each { print(it) }
println()
for (i in range) {
    print(i)
}
println()

def foo(Number number) {
    def result
    switch (number) {
        case 0..<10:
            result = "还行"
            break
        case 10..<20:
            result = "一般"
            break
        default:
            result = "default"
            break
    }
    //省略return
    result
}

println(foo(14))

